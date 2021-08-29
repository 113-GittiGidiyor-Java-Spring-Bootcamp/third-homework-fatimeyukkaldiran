package patika.dev.schoolmanagementsystem.business.abstracts;
import org.springframework.data.jpa.repository.Query;
import patika.dev.schoolmanagementsystem.dataAccess.abstracts.StudentGenderStatistics;
import  patika.dev.schoolmanagementsystem.entities.concretes.Student;

import java.util.List;

public interface StudentService extends BaseService<Student>{
    List<Student> findByStudentFullName(String studentName);
    void deleteByFullName(String name);
    int getNumberOfStudents();
    List<?> getStudentCountWithGroupingGender();

}
