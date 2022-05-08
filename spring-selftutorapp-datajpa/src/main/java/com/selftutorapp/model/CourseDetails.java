package com.selftutorapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDetails {
    @Id
    @GeneratedValue(generator = "coursedet_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "coursedet_gen",sequenceName = "coursedet_seq",initialValue = 1000,allocationSize = 5)
    private  Integer coursedetailsId;
    @Column(length = 20)
    private String language;
    private double ratings;
    private  double fees;
    @Column(length = 80)
    private String description;
    private  int durationInHour;
    private String level;

    public CourseDetails(String language, double ratings, double fees, String description, int durationInHour, String level) {
        this.language = language;
        this.ratings = ratings;
        this.fees = fees;
        this.description = description;
        this.durationInHour = durationInHour;
        this.level = level;
    }

    @Override
    public String toString() {
        return "CourseDetails{" +
                "language='" + language + '\'' +
                ", ratings=" + ratings +
                ", fees=" + fees +
                ", description='" + description + '\'' +
                ", durationInHour=" + durationInHour +
                ", level='" + level + '\'' +
                '}';
    }
}
