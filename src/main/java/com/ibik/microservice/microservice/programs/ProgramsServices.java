package com.ibik.microservice.microservice.programs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramsServices {
  
  @Autowired
  private ProgramsRepo programsRepo;

  public Students save(Students programs){
    return programsRepo.save(programs);
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
