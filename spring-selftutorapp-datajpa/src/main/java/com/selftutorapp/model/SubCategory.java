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
@Table(name="sub_category")
public class SubCategory {
    @Id
    @GeneratedValue(generator = "subcat_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "subcat_gen",sequenceName = "subcat_seq",initialValue = 10,allocationSize = 1)
    private Integer subCategoryId;
    @Column(length = 30)
    private String subCategoryName;
    @Column(length = 40)
    private String topic;

    public SubCategory(String subCategoryName, String topic) {
        this.subCategoryName = subCategoryName;
        this.topic = topic;
    }
}
