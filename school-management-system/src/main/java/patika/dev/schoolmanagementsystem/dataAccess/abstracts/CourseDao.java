package patika.dev.schoolmanagementsystem.dataAccess.abstracts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import patika.dev.schoolmanagementsystem.entities.concretes.Course;
import patika.dev.schoolmanagementsystem.entities.concretes.Student;

import java.util.List;


@Repository
public interface CourseDao extends CrudRepository<Course,Integer> {
    List<Course> findByFullName(String courseName);
    void deleteByFullName(String name);


}
