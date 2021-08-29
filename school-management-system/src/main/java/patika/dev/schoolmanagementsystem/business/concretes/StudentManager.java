package patika.dev.schoolmanagementsystem.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.schoolmanagementsystem.business.abstracts.StudentService;
import patika.dev.schoolmanagementsystem.dataAccess.abstracts.StudentDao;
import patika.dev.schoolmanagementsystem.entities.concretes.Student;

import java.util.List;

@Service
@RequiredArgsConstructor // when we use this annotation , not require using constructor
public class StudentManager implements StudentService {

    private  final StudentDao studentDao;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) studentDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return studentDao.findById(id).get();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentDao.deleteById(id);
    }

    @Override
    @Transactional
    public Student update(Student student) {

        return studentDao.save(student);
    }

    @Override
    public List<Student> findByStudentFullName(String studentName) {
        return studentDao.findByFullName(studentName);
    }

    @Override
    @Transactional
    public void deleteByFullName(String name) {
        studentDao.deleteByFullName(name);
    }

    @Override
    public int getNumberOfStudents() {
        return studentDao.getNumberOfStudents();
    }

    @Override
    public List<?> getStudentCountWithGroupingGender() {
        return studentDao.getStudentCountWithGroupingGender();
    }
    //just business code



}
