package com.selftutorapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category {
    @Id
    @GeneratedValue(generator = "cat_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "cat_gen", sequenceName = "cat_seq", initialValue = 10, allocationSize = 10)
    private Integer categoryId;
    @Column(length = 40)
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id") //This will  be added as F.K in subCategory
    Set<SubCategory> subCategories;

    public Category(String categoryName, Set<SubCategory> subCategories) {
        this.categoryName = categoryName;
        this.subCategories = subCategories;
    }

}
