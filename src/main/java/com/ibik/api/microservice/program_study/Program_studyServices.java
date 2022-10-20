package com.ibik.api.microservice.program_study;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Program_studyServices {
  
  @Autowired
  private Program_studyRepo programsRepo;

  public Program_study save(Program_study students){
    return programsRepo.save(students);
  }

  public Program_study findOne(int id){
    return programsRepo.findById(id).get();
  }

  public Iterable<Program_study> findAll(){
    return programsRepo.findAll();
  }

  public void removeOne(int id){
    programsRepo.deleteById(id);
  }

}
