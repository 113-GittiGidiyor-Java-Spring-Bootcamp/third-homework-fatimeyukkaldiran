package patika.dev.schoolmanagementsystem.business.abstracts;

import patika.dev.schoolmanagementsystem.entities.abstracts.Instructor;

import java.util.List;

public interface InstructorService extends BaseService<Instructor> {
    List<Instructor> getByInstructorName(String instructorName);
    List<Instructor> findFirst3BySalaryLessThan(double salary);
    List<Instructor> findFirst3BySalaryGreaterThan(double salary);
    void deleteByFullName(String name);
}
