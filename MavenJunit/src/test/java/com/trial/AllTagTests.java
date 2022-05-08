package com.trial;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.testcases.productapp"})
@IncludeTags({"creation","brand","all-product","check","by-brand"})
public class AllTagTests {

}
