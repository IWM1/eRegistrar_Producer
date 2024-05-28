package edu.miu.cs425.eregistrar.model;


import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="studnets")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false)
    @NotBlank(message = "Student Number can't be be blank, null or empty")
    private String studentNumber;
    private String firstName;
    private String MiddleName;
    @Column(nullable = false)
    @NotBlank(message = "LastName can't can't be be blank, null or empty")
    private String LastName;
    private double cgpa;
    @Column(nullable = false)
   // @NotBlank(message = "EnrollmentDate can't can't be blank, null or empty")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
   // @Column(nullable = false)
    private boolean isInternational;
}
