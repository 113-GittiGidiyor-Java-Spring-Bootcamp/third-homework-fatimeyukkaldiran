package patika.dev.schoolmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import patika.dev.schoolmanagementsystem.entities.concretes.Student;

import java.util.List;


@Repository
public interface StudentDao extends CrudRepository<Student,Integer> {
    List<Student> findByFullName(String studentName);
    void deleteByFullName(String name);

    @Query("select count(s) from Student s ")
    int getNumberOfStudents();

    @Query(nativeQuery = true, value = "select gender As g, count(g) As count from Student s GROUP By gender")
    List<StudentGenderStatistics> getStudentCountWithGroupingGender();
}

