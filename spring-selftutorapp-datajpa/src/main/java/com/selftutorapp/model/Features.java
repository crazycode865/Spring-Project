package com.selftutorapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Features {
    @Id
    @GeneratedValue(generator = "features_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "features_gen",sequenceName = "features_seq",initialValue = 500,allocationSize = 1)
    private Integer featuresId;
    @Column(length = 40)
    private String featuresName;

    public Features(String featuresName) {
        this.featuresName = featuresName;
    }
}
