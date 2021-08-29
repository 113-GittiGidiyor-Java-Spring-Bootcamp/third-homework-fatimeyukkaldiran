package patika.dev.schoolmanagementsystem.entities.concretes;
import lombok.*;
import lombok.experimental.SuperBuilder;
import patika.dev.schoolmanagementsystem.entities.abstracts.Instructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class PermanentInstructor extends Instructor {
    private double fixedSalary;

}
