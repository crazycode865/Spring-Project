package com.selftutorapp;

import com.selftutorapp.model.*;
import com.selftutorapp.service.ICategoryService;
import com.selftutorapp.service.ICourseService;
import com.selftutorapp.service.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSelftutorappDatajpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSelftutorappDatajpaApplication.class, args);
    }

    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    ITrainerService iTrainerService;
    @Autowired
    ICourseService iCourseService;

    @Override
    public void run(String... args) throws Exception {
//		Course course1 = new Course();
//		Category category1 = new Category();
//		String trainerName, double ratings, int experience, String techStack, Integer noOfStudent
		Trainer trainer1 = new Trainer("Priya",9.5,10, TechStack.FULLSTACK.name(),100);
		Trainer trainer2 = new Trainer("Baba",7.5,5, TechStack.FULLSTACK.name(),10);
		Trainer trainer3 = new Trainer("Dibya",9.5,10, TechStack.BACKEND.name(), 30);
		Trainer trainer4 = new Trainer("Awadhesh",8.5,5, TechStack.DATABASE.name(), 10);
		Trainer trainer5 = new Trainer("Abuthair",9.5,4, TechStack.FRONTEND.name(), 20);
		Trainer trainer6 = new Trainer("Shravani",6.5,9, TechStack.FRONTEND.name(), 50);
		Trainer trainer7 = new Trainer("Sandeep",10,6, TechStack.DATABASE.name(), 100);
//		iTrainerService.addTrainer(trainer1);
//		iTrainerService.addTrainer(trainer2);
//		iTrainerService.addTrainer(trainer3);
//		iTrainerService.addTrainer(trainer4);
//		iTrainerService.addTrainer(trainer5);
//		iTrainerService.addTrainer(trainer6);
//		iTrainerService.addTrainer(trainer7);
        SubCategory sub1 = new SubCategory("Web Development",Topic.HTML.name());
        SubCategory sub2 = new SubCategory("Development",Topic.JAVA.name());
        SubCategory sub3 = new SubCategory("Data Science",Topic.PYTHON.name());
        Set<SubCategory> subCategories1 = new HashSet<>(Arrays.asList(sub1,sub2,sub3));
        Category category1 = new Category("Development",subCategories1);
       // iCategoryService.addCategory(category1);

        SubCategory sub4 = new SubCategory("Digital Marketing",Topic.MARKETING.name());
        SubCategory sub5 = new SubCategory("SEO Marketing",Topic.SEO.name());
        SubCategory sub6 = new SubCategory("Branding",Topic.BRANDING.name());
        Set<SubCategory> subCategories2 = new HashSet<>(Arrays.asList(sub4,sub5,sub6));
        //Category category2 = new Category("Marketing",subCategories2);

        SubCategory sub7 = new SubCategory("Web Design",Topic.CSS.name());
        SubCategory sub8 = new SubCategory("Game Design",Topic.DJANGO.name());
        SubCategory sub9 = new SubCategory("User Experience Design",Topic.REACT.name());
        Set<SubCategory> subCategories3 = new HashSet<>(Arrays.asList(sub7,sub8,sub9));
        Category category3 = new Category("Design",subCategories3);
        //iCategoryService.addCategory(category3);
        SubCategory sub10 = new SubCategory("Food And Beverage",Topic.COOKING.name());
        SubCategory sub11 = new SubCategory("Gaming",Topic.ESPORTS.name());
        SubCategory sub12 = new SubCategory("Travel",Topic.ADVENTURE.name());
        Set<SubCategory> subCategories4 = new HashSet<>(Arrays.asList(sub10,sub11,sub12));
        Category category4 = new Category("Life Style",subCategories4);
//        iCategoryService.addCategory(category4);
        Features features1 = new Features("Assignments");
        Features features2 = new Features("sub-titles");
        Set<Features>featuresSet = new HashSet<>(Arrays.asList(features1,features2));
//        String language, double ratings, double fees, String description, int durationInHour, String level
        CourseDetails details1 = new CourseDetails("English",4.5,1000,"This the course details description",5,Level.ADVANCED.name());
        Course course = new Course("Java for Beginner",details1,featuresSet);
//        course.setTrainers(trainer1);
//        iCourseService.addCourse(course);
        Features features3 = new Features("Quizzes");
        Features features4 = new Features("Practice Problem");
        Set<Features>featuresSet1 = new HashSet<>(Arrays.asList(features3,features4));
        CourseDetails details2 = new CourseDetails("Hindi",8.5,140000,"Advanced Java Developer Course",48,Level.ADVANCED.name());
        Course course1 = new Course("Java for Advanced Developer",details2,featuresSet1);
//        course.setTrainers(trainer2);
//        iCourseService.addCourse(course1);

       // Features features3 = new Features("Quizzes");
       // Features features4 = new Features("Practice Problem");
        Set<Features>featuresSet2 = new HashSet<>(Arrays.asList(features3,features4));
        CourseDetails details3 = new CourseDetails("English",8.5,2500,"Tour And Travel Management Course",5,Level.BEGINNER.name());
        Course course2 = new Course("Travel and Tour Management",details3,featuresSet2);
        course.setTrainers(trainer3);
        iCourseService.addCourse(course2);
       // iCourseService.deleteCourse(7);
       // iCourseService.getByCategory("Development").forEach(System.out::println);
       // iCategoryService.deleteCategory(21);



    }
}
