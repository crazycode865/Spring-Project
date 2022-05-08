package com.trial;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectPackages({"com.student.testcases"})
//@SelectClasses({UserTest.class,CalculatorTest.class})
//@IncludePackages({"com.testcases.studentapp.trial"})
@ExcludePackages({"com.testcases.studentapp.trial"})
public class AllTests {

}
