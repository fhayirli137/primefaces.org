package org.primefaces.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.primefaces.utility.BrowserUtil;
import org.primefaces.utility.Driver;

public class DataTableSelection {

public DataTableSelection(){
    PageFactory.initElements(Driver.getDriver(), this);
}

@FindBy(xpath = "//td[text()='Blue Band']/preceding-sibling::td/input[@type='checkbox']")
public WebElement checkbox;


public void clickCheckbox(String checkbox, String blueBand) {
String locator ="//h5[.='+checkbox+']/..//td[.='+blueBand+']/../td//div/div[2]";
    BrowserUtil.waitFor(2);
    Driver.getDriver().findElement(By.xpath(locator)).click();
}
}
