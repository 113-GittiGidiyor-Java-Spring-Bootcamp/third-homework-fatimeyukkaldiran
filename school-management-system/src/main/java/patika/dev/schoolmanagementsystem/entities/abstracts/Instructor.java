package patika.dev.schoolmanagementsystem.entities.abstracts;

import lombok.experimental.SuperBuilder;
import patika.dev.schoolmanagementsystem.entities.concretes.*;


import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;
import java.util.*;


@Data  //include --> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode , @ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructor.class, name = "PermanentInstructor"),
        @JsonSubTypes.Type(value = VisitingResearcher.class, name = "VisitingResearcher")
})
public abstract class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // it controls id that is unique on db
    private int id;
    private String name;
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;


    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();
}
