package com.ibik.api.microservice.courses;

import org.springframework.data.repository.CrudRepository;

public interface CoursesRepo extends CrudRepository<Courses, Integer>{
    
}