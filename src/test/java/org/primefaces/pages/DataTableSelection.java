package org.primefaces.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.primefaces.utility.Driver;

public class DataTableSelection {

public DataTableSelection(){
    PageFactory.initElements(Driver.getDriver(), this);
}

@FindBy(xpath = "//td[text()='Blue Band']/preceding-sibling::td/input[@type='checkbox']")
public WebElement checkbox;

@FindBy(xpath = "//div[@class=p-checkbox-box p-component p-clickable']")
    public WebElement blueBandCheckboxButton;


}
