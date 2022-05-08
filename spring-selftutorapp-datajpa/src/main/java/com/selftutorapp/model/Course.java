package com.selftutorapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(generator = "course_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", initialValue = 1, allocationSize = 1)
    private Integer courseId;
    @Column(length = 40)
    private String courseName;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="course_category",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
    @ManyToOne
    @JoinColumn(name = "trainer_id") //this will be added as F.K on this table
    private Trainer trainers;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coursedetails_id") // this will be added as F.K on this table
    private CourseDetails courseDetails;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id") //this. course_id is added as F.K as in features table
    private  Set<Features> features;//one course can have many features like subtitles,assignments

    public Course(String courseName, CourseDetails courseDetails, Set<Features> features) {
        this.courseName = courseName;
        this.courseDetails = courseDetails;
        this.features = features;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseDetails=" + courseDetails +
                '}';
    }
}
