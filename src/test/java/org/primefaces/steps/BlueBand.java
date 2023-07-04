package org.primefaces.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
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

    @Then("I should be on the DataTable selection page")
    public void i_should_be_on_the_data_table_selection_page() {
        String pageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Not on the DataTable selection page", pageTitle.contains("DataTable - Selection"));
    }

    @When("I scroll down until Checkbox selection")
    public void i_scroll_down_until_checkbox_selection() {

       BrowserUtil.scrollToElement(dataTableSelection.checkbox);
    }


    @Then("I select the checkbox against the row with the name {string}")
    public void i_select_the_checkbox_against_the_row_with_the_name(String string) {
        dataTableSelection.blueBandCheckboxButton.click();
    }
    @Then("the checkbox for {string} should be selected")
    public void the_checkbox_for_should_be_selected(boolean blueband) {

        BrowserUtil.selectCheckBox(dataTableSelection.checkbox,blueband );

        //Second way to select the checkbox
       // boolean isChecked = dataTableSelection.blueBandCheckboxButton.isSelected();
       // Assert.assertTrue("Checkbox for 'Blue Band' is not selected", isChecked);

    }
}
