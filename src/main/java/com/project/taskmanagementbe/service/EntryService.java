package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Entry;
import com.project.taskmanagementbe.wsdto.EntryWsDto;

import java.util.List;

public interface EntryService {

    void addEntry(EntryWsDto entry, int taskID);

    List<EntryWsDto> getEntries(int taskID);

}
