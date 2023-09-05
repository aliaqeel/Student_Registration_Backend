package com.tel.StudentRegistration.Controller;

import com.tel.StudentRegistration.Entity.Student;
import com.tel.StudentRegistration.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    // to save the student details
    @PostMapping(value = "/save")
    private  String saveStudent(@RequestBody Student students) {

        studentServices.saveorUpdate(students);
        return students.get_id();
    }

    // get student information
    @GetMapping(value = "/getall")
    private Iterable<Student> getStudents() {
        return studentServices.listAll();
    }

    //update student records
    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable(name = "id") String _id) {
        student.set_id(_id);
        studentServices.saveorUpdate(student);
        return student;
    }

    //delete student records
    @DeleteMapping("/delete/{id}")
    private void deleteStudent(@PathVariable("id") String _id) {
        studentServices.deleteStudent(_id);
    }

    //search student record
    @RequestMapping("/search/{id}")
    private Student getStudents(@PathVariable(name = "id") String studentid) {
        return studentServices.getStudentByID(studentid);
    }

}