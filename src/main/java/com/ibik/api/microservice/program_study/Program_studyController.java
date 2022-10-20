package com.ibik.api.microservice.program_study;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibik.api.microservice.dto.ResponseData;

import java.util.List;

@RestController
@RequestMapping("/api/program_study")
public class Program_studyController {
  
  // @GetMapping
  // public String helloWorld(){
  //   return "<h1>Hello World</h1>";
  // }

  @Autowired
  private Program_studyServices program_studyServices;

  @PostMapping
  // public Program_study postPrograms(@Valid @RequestBody Program_study program_study, Errors errors){
    public ResponseEntity<ResponseData<Program_study>> postPrograms(@Valid @RequestBody Program_study students, Errors errors){
    ResponseData<Program_study> responseData = new ResponseData<>();

    if(errors.hasErrors()){
      for(ObjectError error : errors.getAllErrors()){
        responseData.getMessage().add(error.getDefaultMessage());
        // System.out.println(error.getDefaultMessage());
      }

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      // throw new RuntimeException("Validation Error");
    }
    
    List<Program_study> value = new ArrayList<>();
    value.add(program_studyServices.save(students));
    responseData.setData(value);
    return ResponseEntity.ok(responseData);

    // return program_studyServices.save(program_study);
  }

  @GetMapping
  public Iterable<Program_study> fetchPrograms(){
    return program_studyServices.findAll();
    
  }

  @GetMapping("/{id}")
  public Program_study fetchProgramsById(@PathVariable("id") int id){
    return program_studyServices.findOne(id);
  }

  @PutMapping
  public Program_study updatePrograms(@RequestBody Program_study program_study){
    return program_studyServices.save(program_study);
  }

  @DeleteMapping("/{id}")
  public void deleteProgramsById(@PathVariable("id") int id){
    program_studyServices.removeOne(id);
  }

}
