package patika.dev.schoolmanagementsystem.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.schoolmanagementsystem.business.abstracts.InstructorService;
import patika.dev.schoolmanagementsystem.dataAccess.abstracts.InstructorDao;
import patika.dev.schoolmanagementsystem.entities.abstracts.Instructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorManager implements InstructorService {
    private final InstructorDao instructorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        return (List<Instructor>) instructorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return instructorDao.findById(id).get();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorDao.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorDao.deleteById(id);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {

        return instructorDao.save(instructor);
    }

    @Override
    public List<Instructor> getByInstructorName(String instructorName) {
        return instructorDao.findByFullName(instructorName);
    }

    @Override
    public List<Instructor> findFirst3BySalaryLessThan(double salary) {
        return instructorDao.findFirst3BySalaryLessThan(salary);
    }

    @Override
    public List<Instructor> findFirst3BySalaryGreaterThan(double salary) {
        return instructorDao.findFirst3BySalaryGreaterThan(salary);
    }

    @Override
    @Transactional
    public void deleteByFullName(String name) {
        instructorDao.deleteByFullName(name);
    }




}
