package patika.dev.schoolmanagementsystem.utils;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import patika.dev.schoolmanagementsystem.dataAccess.abstracts.CourseDao;
import patika.dev.schoolmanagementsystem.dataAccess.abstracts.InstructorDao;
import patika.dev.schoolmanagementsystem.dataAccess.abstracts.StudentDao;
import patika.dev.schoolmanagementsystem.entities.concretes.Course;
import patika.dev.schoolmanagementsystem.entities.concretes.PermanentInstructor;
import patika.dev.schoolmanagementsystem.entities.concretes.Student;
import patika.dev.schoolmanagementsystem.entities.abstracts.Instructor;
import patika.dev.schoolmanagementsystem.entities.concretes.VisitingResearcher;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Consumer;

@Component
public class InitializerRunner implements CommandLineRunner {

  //  private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    StudentDao studentDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
     InstructorDao instructorDao;

    @Override
    public void run(String... args) throws Exception {
        studentDao.deleteAll();
        courseDao.deleteAll();
        instructorDao.deleteAll();


        Instructor instructor1 = PermanentInstructor.builder().name("Sezen Derin").address("Izmir/Bornova").fixedSalary(5000).phoneNumber("5423156478").build();
        Instructor instructor2 = PermanentInstructor.builder().name("Engin Ece").address("Istanbul/Levent").phoneNumber("5312465897").fixedSalary(6000.250).build();
        Instructor instructor3 = VisitingResearcher.builder().name("Senem Uslu").address("Istanbul/Sisli").phoneNumber("5321456987").hourlySalary(250.354).totalHours(3).build();
        Instructor instructor4 = VisitingResearcher.builder().name("Caner Kara").address("Istanbul/Besiktas").phoneNumber("536587941").hourlySalary(320.312).totalHours(4).build();

        Student student1 = Student.builder().name("Ela Yüce").address("Ankara/Dikmen").birthDate(LocalDate.of(1987, Month.FEBRUARY,10)).gender("Female").build();
        Student student2 = Student.builder().name("Efe Han").address("Istanbul/Karakoy").birthDate(LocalDate.of(1994, Month.SEPTEMBER,12)).gender("Male").build();
        Student student3 = Student.builder().name("Eda Gersu").address("Mugla/Datca").birthDate(LocalDate.of(1998, Month.OCTOBER,8)).gender("Female").build();

        Course course1 = Course.builder().courseName("Math").courseCode("MTH-210").creditScore(8).build();
        Course course2 = Course.builder().courseName("Biology").courseCode("BLG-230").creditScore(6).build();
        Course course3 = Course.builder().courseName("Physics").courseCode("PYC-312").creditScore(7).build();


        course1.setInstructor(instructor1);
        course2.setInstructor(instructor3);
        course3.setInstructor(instructor2);

        List<Course> courseList1 = new ArrayList<>();
        List<Course> courseList2 = new ArrayList<>();
        List<Course> courseList3 = new ArrayList<>();

        courseList1.addAll(Arrays.asList(course1,course2));
        courseList2.addAll(Arrays.asList(course2,course3));
        courseList3.addAll(Arrays.asList(course2));

        student1.setCourseList(courseList1);
        student2.setCourseList(courseList2);
        student3.setCourseList(courseList3);


        instructor1.setCourseList(courseList1);
        instructor2.setCourseList(courseList2);
        instructor3.setCourseList(courseList3);


        //save to db
        instructorDao.save(instructor1);
        instructorDao.save(instructor2);
        instructorDao.save(instructor3);
        instructorDao.save(instructor4);

        courseDao.save(course1);
        courseDao.save(course2);
        courseDao.save(course3);

        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);






/*
studentDao.findAll().forEach(new Consumer<Student>() {
    @Override
    public void accept(Student student) {
        logger.info("{}",student);
    }
});*/ //insteod of this used lambda expression bottom
       // studentDao.findAll().forEach(std -> logger.info("{}",std));
    }
}
