package patika.dev.schoolmanagementsystem.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import patika.dev.schoolmanagementsystem.entities.abstracts.Instructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class VisitingResearcher extends Instructor {
    private double hourlySalary;

    private int totalHours;

    private double getTotalSalary(){
        return hourlySalary * totalHours;
    }
}
