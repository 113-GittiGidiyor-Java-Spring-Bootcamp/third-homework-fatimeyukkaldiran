package patika.dev.schoolmanagementsystem.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import patika.dev.schoolmanagementsystem.business.abstracts.StudentService;
import patika.dev.schoolmanagementsystem.dataAccess.abstracts.StudentDao;
import patika.dev.schoolmanagementsystem.entities.concretes.Student;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentsController {
    //just manage http request here

     private StudentService studentService;


@GetMapping("/getall")
public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(this.studentService.findAll(), HttpStatus.OK);
}
@PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
      return  studentService.save(student);
}

@GetMapping("/get/{id}")
public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return new ResponseEntity<>(studentService.findById(id),HttpStatus.OK);
}
@PutMapping("/update")
public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id) {
        studentService.deleteById(id);
        return "Deleted...";
    }

@GetMapping("/getByStudentName/{name}")
public List<Student> getStudentName(@PathVariable String name){
    return studentService.findByStudentFullName(name);
}

@DeleteMapping("/deleteByName/{name}")
    public String deleteByStudentName(@PathVariable String name){
    studentService.deleteByFullName(name);
    return "Deleted student...";
}

@GetMapping("/getNumberOfStudent")
    public int getNumberOfStudents(){
    return studentService.getNumberOfStudents();
}
@GetMapping("/getNumberOfStudentByGender")
   public  List<?> getStudentCountWithGroupingGender(){
    return studentService.getStudentCountWithGroupingGender();
}
}
