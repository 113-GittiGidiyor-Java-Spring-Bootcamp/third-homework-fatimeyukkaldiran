package patika.dev.schoolmanagementsystem.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.dev.schoolmanagementsystem.business.abstracts.CourseService;
import patika.dev.schoolmanagementsystem.entities.concretes.Course;
import patika.dev.schoolmanagementsystem.entities.concretes.Student;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CourseService courseService;


    @GetMapping("/getall")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course){
        return  courseService.save(course);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id){
        return new ResponseEntity<>(courseService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course){
        return courseService.update(course);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourseById(@PathVariable int id) {
        courseService.deleteById(id);
        return "Deleted...";
    }
    @GetMapping("/getByCourseName/{name}")
    public List<Course> getCourseWithName(@PathVariable String name){
        return courseService.findByFullName(name);
    }
    @DeleteMapping("/deleteByName/{name}")
    public String deleteByCourseName(@PathVariable String name){
        courseService.deleteByFullName(name);
        return "Deleted...";
    }

}
