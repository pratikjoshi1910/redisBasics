package com.redis.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redis.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {}
