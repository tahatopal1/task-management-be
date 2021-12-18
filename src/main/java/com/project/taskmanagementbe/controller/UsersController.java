package com.project.taskmanagementbe.controller;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.model.User;
import com.project.taskmanagementbe.service.UsersService;
import com.project.taskmanagementbe.wsdto.UserWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;

    @GetMapping("/users")
    public List<UserWsDto> findAll(){
        return usersService.findAll();
    }

    @PostMapping("/users/{id}")
    public void addTaskToUser(@PathVariable Integer id, @RequestBody Task task){
        usersService.addTaskToUser(id, task);
    }

    @GetMapping("/users/{id}")
    public UserWsDto find(@PathVariable Integer id){
        return usersService.find(id);
    }

    @GetMapping("/users/username")
    public UserWsDto findByUsername(@RequestParam("username") String username, @RequestParam("isAuth") boolean isAuth, HttpServletRequest request){
        UserWsDto userWsDto = usersService.findByUsername(username);
        if (userWsDto.getUsername() != null){
            if (isAuth){
                try {
                    UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(userWsDto.getUsername(), userWsDto.getPassword());
                    Authentication auth = daoAuthenticationProvider.authenticate(authReq);
                    SecurityContext sc = SecurityContextHolder.getContext();
                    sc.setAuthentication(auth);
                    HttpSession session = request.getSession(true);
                    session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return userWsDto;
    }

}
