package com.example.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.token.entity.WorkflowType;

public interface WorkflowTypeRepository  extends JpaRepository<WorkflowType, Integer>{

}
