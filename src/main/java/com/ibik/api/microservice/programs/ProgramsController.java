package com.ibik.api.microservice.programs;

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
@RequestMapping("/api/programs")
public class ProgramsController {
  
  // @GetMapping
  // public String helloWorld(){
  //   return "<h1>Hello World</h1>";
  // }

  @Autowired
  private ProgramsServices programsServices;

  @PostMapping
  // public Programs postPrograms(@Valid @RequestBody Programs programs, Errors errors){
    public ResponseEntity<ResponseData<Programs>> postPrograms(@Valid @RequestBody Programs students, Errors errors){
    ResponseData<Programs> responseData = new ResponseData<>();

    if(errors.hasErrors()){
      for(ObjectError error : errors.getAllErrors()){
        responseData.getMessage().add(error.getDefaultMessage());
        // System.out.println(error.getDefaultMessage());
      }

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      // throw new RuntimeException("Validation Error");
    }
    
    List<Programs> value = new ArrayList<>();
    value.add(programsServices.save(students));
    responseData.setData(value);
    return ResponseEntity.ok(responseData);

    // return programsServices.save(programs);
  }

  @GetMapping
  public Iterable<Programs> fetchPrograms(){
    return programsServices.findAll();
    
  }

  @GetMapping("/{id}")
  public Programs fetchProgramsById(@PathVariable("id") int id){
    return programsServices.findOne(id);
  }

  @PutMapping
  public Programs updatePrograms(@RequestBody Programs programs){
    return programsServices.save(programs);
  }

  @DeleteMapping("/{id}")
  public void deleteProgramsById(@PathVariable("id") int id){
    programsServices.removeOne(id);
  }

}
