package com.ibik.microservice.microservice.programs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class ProgramsController {
  
  // @GetMapping
  // public String helloWorld(){
  //   return "<h1>Hello World</h1>";
  // }

  @Autowired
  private ProgramsServices programsServices;

  @PostMapping
  public Students postPrograms(@RequestBody Students programs){
    return programsServices.save(programs);
  }

  @GetMapping
  public Iterable<Students> fetchPrograms(){
    return programsServices.findAll();
    
  }

  @GetMapping("/{id}")
  public Students fetchProgramsById(@PathVariable("id") int id){
    return programsServices.findOne(id);
  }

  @PutMapping
  public Students updatePrograms(@RequestBody Students programs){
    return programsServices.save(programs);
  }

  @DeleteMapping("/{id}")
  public void deleteProgramsById(@PathVariable("id") int id){
    programsServices.removeOne(id);
  }

}
