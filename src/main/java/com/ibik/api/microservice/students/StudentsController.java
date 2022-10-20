package com.ibik.api.microservice.students;

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
@RequestMapping("/api/students")
public class StudentsController {

  // @GetMapping
  // public String helloWorld(){
  // return "<h1>Hello World</h1>";
  // }

  @Autowired
  private StudentsServices studentsServices;

  @PostMapping
  // public Students postPrograms(@Valid @RequestBody Students programs, Errors
  // errors){
  public ResponseEntity<ResponseData<Students>> postPrograms(@Valid @RequestBody Students students, Errors errors) {
    ResponseData<Students> responseData = new ResponseData<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessage().add(error.getDefaultMessage());
        // System.out.println(error.getDefaultMessage());
      }

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      // throw new RuntimeException("Validation Error");
    }

    List<Students> value = new ArrayList<>();
    value.add(studentsServices.save(students));
    responseData.setData(value);
    return ResponseEntity.ok(responseData);

    // return studentsServices.save(programs);
  }

  @GetMapping
  public Iterable<Students> fetchPrograms() {
    return studentsServices.findAll();
  }

  @GetMapping("/{id}")
  // public Students fetchProgramsById(@PathVariable("id") int id) {
  public ResponseEntity<ResponseData<Students>> postPrograms(@Valid @PathVariable("id") int id, Students students, Errors errors) {
    ResponseData<Students> responseData = new ResponseData<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessage().add(error.getDefaultMessage());
        // System.out.println(error.getDefaultMessage());
      }

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      // return ResponseEntity.status(HttpStatus.BAD_REQUEST).message("No Value present");
      // throw new RuntimeException("No Value Present");
    }

    List<Students> value = new ArrayList<>();
    value.add(studentsServices.findOne(id));
    responseData.setData(value);
    return ResponseEntity.ok(responseData);

    // return studentsServices.findOne(id);
  }

  @PutMapping
  public Students updatePrograms(@RequestBody Students programs) {
    return studentsServices.save(programs);
  }

  @DeleteMapping("/{id}")
  public void deleteProgramsById(@PathVariable("id") int id) {
    studentsServices.removeOne(id);
  }

}
