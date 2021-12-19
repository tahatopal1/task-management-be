package com.project.taskmanagementbe.controller;

import com.project.taskmanagementbe.service.EntryService;
import com.project.taskmanagementbe.wsdto.EntryWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @GetMapping("/entry")
    public List<EntryWsDto> getEntries(@RequestParam("taskID") Integer id){
        return entryService.getEntries(id);
    }

    @PostMapping("/entry")
    public void saveEntry(@RequestBody EntryWsDto entryWsDto, @RequestParam("taskID") Integer id){
        entryService.addEntry(entryWsDto, id);
    }

}
