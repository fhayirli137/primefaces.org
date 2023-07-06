package org.primefaces.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.primefaces.pages.DataTableSelection;
import org.primefaces.utility.BrowserUtil;
import org.primefaces.utility.ConfigurationReader;
import org.primefaces.utility.Driver;

import static org.junit.Assert.assertTrue;

public class BlueBand {

DataTableSelection dataTableSelection = new DataTableSelection();


    @Given("I navigate to the url")
    public void i_navigate_to_the_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("primefaces.url"));
        BrowserUtil.waitFor(2);
    }


    @When("I scroll down until Checkbox selection")
    public void i_scroll_down_until_checkbox_selection() {

    BrowserUtil.scrollDown(250);
    }


    @And("I select the checkbox against the row with the name {string} in {string} section")
    public void iSelectTheCheckboxAgainstTheRowWithTheNameInSection(String checkbox, String blueBand) {

        dataTableSelection.clickCheckbox(checkbox, blueBand);

    }


    @And("the checkbox for Blue Band should be selected")
    public void theCheckboxForBlueBandShouldBeSelected() {

        // Verify if the checkbox is selected using assertion
        Assert.assertTrue("checkbox is not selected",dataTableSelection.checkbox.isSelected());


    }

}

