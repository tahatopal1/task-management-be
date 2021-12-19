package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Entry;
import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.repository.TaskRepository;
import com.project.taskmanagementbe.wsdto.EntryWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryServiceImpl implements EntryService, Converter<Entry, EntryWsDto> {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void addEntry(EntryWsDto entry, int taskID) {
        taskRepository.findById(taskID).ifPresent(task -> {
            task.getEntries().add(this.convertReverse(entry));
            taskRepository.save(task);
        });
    }

    @Override
    public List<EntryWsDto> getEntries(int taskID) {
        return taskRepository
                .findById(taskID)
                .map(Task::getEntries)
                .orElse(new ArrayList<>())
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }


    @Override
    public EntryWsDto convert(Entry source) {
        return new EntryWsDto(source.getId(), source.getComment());
    }

    public Entry convertReverse(EntryWsDto entryWsDto){
        return new Entry(entryWsDto.getId(), entryWsDto.getComment());
    }
}
