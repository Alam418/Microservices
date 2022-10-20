package com.ibik.api.microservice.programs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramsServices {
  
  @Autowired
  private ProgramsRepo programsRepo;

  public Programs save(Programs students){
    return programsRepo.save(students);
  }

  public Programs findOne(int id){
    return programsRepo.findById(id).get();
  }

  public Iterable<Programs> findAll(){
    return programsRepo.findAll();
  }

  public void removeOne(int id){
    programsRepo.deleteById(id);
  }

}
