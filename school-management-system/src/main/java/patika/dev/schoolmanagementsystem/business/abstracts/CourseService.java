package patika.dev.schoolmanagementsystem.business.abstracts;

import patika.dev.schoolmanagementsystem.entities.concretes.Course;

import java.util.List;

public interface CourseService extends BaseService<Course> {
    List<Course> findByFullName(String courseName);
    void deleteByFullName(String name);

}
