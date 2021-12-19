package com.project.taskmanagementbe.repository;

import com.project.taskmanagementbe.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Integer> {
}
