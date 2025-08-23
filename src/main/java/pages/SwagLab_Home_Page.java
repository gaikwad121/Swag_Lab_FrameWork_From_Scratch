package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.LocatorReader;

public class SwagLab_Home_Page {
private WebDriver driver; 
private LocatorReader locators;
private String addcart;
public SwagLab_Home_Page(WebDriver driver) {
        this.driver = driver;
        this.locators = new LocatorReader("locators/loginPage.txt");
    }


private By addToCart() {
    return By.xpath(locators.get("addcart"));
}

public  void addToCartClk() {
driver.findElement(addToCart()).click();
}  }