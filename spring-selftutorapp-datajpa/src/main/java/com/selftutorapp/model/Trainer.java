package com.selftutorapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Trainer {
    @Id
    @GeneratedValue(generator = "trainer_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "trainer_gen",sequenceName = "trainer_seq",initialValue = 100,allocationSize = 1)
    private  Integer trainerId;
    @Column(length = 30)
    private String trainerName;
    private  double ratings;
    private int experience;
    private String techStack;
//    private LocalDate joiningDate;
    private Integer noOfStudent;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "trainer_id")
    private Set<Course> courses;

    public Trainer(String trainerName, double ratings, int experience, String techStack, Integer noOfStudent) {
        this.trainerName = trainerName;
        this.ratings = ratings;
        this.experience = experience;
        this.techStack = techStack;
        this.noOfStudent = noOfStudent;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerName='" + trainerName + '\'' +
                ", ratings=" + ratings +
                ", experience=" + experience +
                ", techStack='" + techStack + '\'' +
                ", noOfStudent=" + noOfStudent +
                '}';
    }
}
