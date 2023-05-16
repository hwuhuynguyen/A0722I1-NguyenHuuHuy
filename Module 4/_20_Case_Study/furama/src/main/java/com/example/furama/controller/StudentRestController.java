package codegym.vn.springboot.controller;

import codegym.vn.springboot.entity.Student;
import codegym.vn.springboot.form.StudentForm;
import codegym.vn.springboot.service.ClassNameService;
import codegym.vn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/student")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassNameService classNameService;

    @GetMapping
    public ResponseEntity<Student> getStudentById(
            @RequestParam(name = "id") String id) {
        Student student = studentService.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
//        Student student = new Student();
//        student.setId(studentForm.getId());
//        student.setName(studentForm.getName());
//        student.setBirthdate(studentForm.getBirthdate());
//        student.setEmail(studentForm.getEmail());
//        student.setSex(studentForm.isSex());
//        student.setPhoneNumber(studentForm.getPhoneNumber());
//        student.setClassName(classNameService.findById(studentForm.getClassId()));
        studentService.create(student);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("searchNameOrEmail")
    public ResponseEntity<List<Student>> searchNameOrEmail(
            @RequestParam("name") String name,
            @RequestParam("email") String email) {
        List<Student> students = studentService.findAllByNameAndEmail(name, email);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
