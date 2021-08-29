package patika.dev.schoolmanagementsystem.entities.concretes;

import lombok.*;
import patika.dev.schoolmanagementsystem.entities.abstracts.Instructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String courseCode;
    private int creditScore;

    @ManyToOne()
    //@JoinColumn(nullable = false, name = "instructor_id")
    private Instructor instructor;

    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList = new ArrayList<>();


}