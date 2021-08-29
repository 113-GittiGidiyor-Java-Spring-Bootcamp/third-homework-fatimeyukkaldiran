package patika.dev.schoolmanagementsystem.entities.concretes;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // it controls id that is unique on db
    private int id;
    private String name;
    private String address;
    private LocalDate birthDate;
    private String gender;

   @ManyToMany
   private List<Course> courseList = new ArrayList<>();


}

