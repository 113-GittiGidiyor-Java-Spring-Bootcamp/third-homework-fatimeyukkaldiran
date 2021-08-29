package patika.dev.schoolmanagementsystem.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.schoolmanagementsystem.business.abstracts.CourseService;
import patika.dev.schoolmanagementsystem.dataAccess.abstracts.CourseDao;
import patika.dev.schoolmanagementsystem.entities.abstracts.Instructor;
import patika.dev.schoolmanagementsystem.entities.concretes.Course;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseManager implements CourseService {

    private final CourseDao courseDao;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) courseDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return courseDao.findById(id).get();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseDao.deleteById(id);
    }

    @Override
    @Transactional
    public Course update(Course course) {

        return courseDao.save(course);
    }

    @Override
    public List<Course> findByFullName(String courseName) {
        return courseDao.findByFullName(courseName);
    }

    @Override
    @Transactional
    public void deleteByFullName(String name) {
        courseDao.deleteByFullName(name);
    }
}
