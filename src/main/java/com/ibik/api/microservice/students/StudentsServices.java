package com.ibik.api.microservice.students;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentsServices {
  
  @Autowired
  private StudentsRepo programsRepo;

  public Students save(Students students){
    return programsRepo.save(students);
  }

  public Students findOne(int id){
    return programsRepo.findById(id).get();
  }

  public Iterable<Students> findAll(){
    return programsRepo.findAll();
  }

  public void removeOne(int id){
    programsRepo.deleteById(id);
  }

}
