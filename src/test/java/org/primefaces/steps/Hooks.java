package org.primefaces.steps;

import org.primefaces.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.primefaces.utility.Driver;

/*
In this class we will be able to create "pre" and "post" condition for all scenarios and even steps
 */
public class Hooks {

    @Before //import the @before coming from io.cucumber.java
    public void setUp() {
//Driver.getDriver().manage().window().fullscreen();
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIOS");
    }

   // @Before(value = "@login", order = 2)
   // public void login_scenario_before(){
   //     System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
   // }

    @After//import the @before coming from io.cucumber.java
    public void tearDownMethod(Scenario scenario) {//@After will be executed automatically after EVERY scenario in the project

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("---> @After: RUNNING AFTER EACH SCENARIOS");
        Driver.closeDriver();
    }
        //@BeforeStep
        public void setupStep () {
            System.out.println("--->@BeforeSTEP : Running before each step!");
        }
        // @AfterStep
        public void teardownStep () {
            System.out.println("--->@AfterSTEP : Running before each step!");
        }

    }
