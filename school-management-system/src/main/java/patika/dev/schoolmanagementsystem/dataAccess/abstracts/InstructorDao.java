package patika.dev.schoolmanagementsystem.dataAccess.abstracts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import patika.dev.schoolmanagementsystem.entities.abstracts.Instructor;

import java.util.List;


@Repository
public interface InstructorDao extends CrudRepository<Instructor,Integer> {
    List<Instructor> findByFullName(String instructorName);
    List<Instructor> findFirst3BySalaryLessThan(double salary);
    List<Instructor> findFirst3BySalaryGreaterThan(double salary);
    void deleteByFullName(String name);

}
