package patika.dev.schoolmanagementsystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.dev.schoolmanagementsystem.business.abstracts.InstructorService;
import patika.dev.schoolmanagementsystem.entities.concretes.Student;
import patika.dev.schoolmanagementsystem.entities.abstracts.Instructor;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorsController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorsController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Instructor>> getAllInstructor(){
        return new ResponseEntity<>(this.instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor){
        return  instructorService.save(instructor);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Instructor> getStudentById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInstructorById(@PathVariable int id) {
        instructorService.deleteById(id);
        return "Deleted...";
    }
    @GetMapping("/getByInstructorName/{name}")
    public List<Instructor> getCourseName(@PathVariable String name){
        return instructorService.getByInstructorName(name);
    }

    @GetMapping("/findFirst3BySalaryGreaterThan/{salary}")
    public List<Instructor> findFirst3BySalaryGreaterThan(@PathVariable double salary){
        return instructorService.findFirst3BySalaryGreaterThan(salary);
    }
    @GetMapping("/findFirst3BySalaryLessThan/{salary}")
    public List<Instructor> findFirst3BySalaryLessThan(@PathVariable double salary){
        return instructorService.findFirst3BySalaryLessThan(salary);
    }
    @DeleteMapping("/deleteByName/{name}")
    public String deleteByInstructorName(@PathVariable String name){
        instructorService.deleteByFullName(name);
        return "Deleted student...";
    }
}
