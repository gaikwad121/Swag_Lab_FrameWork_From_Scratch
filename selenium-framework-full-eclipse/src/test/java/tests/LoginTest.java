package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SwagLab_Home_Page;
import pages.loginPage;
import utils.AlertUtil;
import utils.CredentialsUtil;
import utils.ExcelReader;
import utils.TestDataGenerator;
import utils.TestListener;

@Listeners({TestListener.class})
public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        ExcelReader excel = new ExcelReader("testdata/TestData.xlsx");
        String encodedUser = excel.getCellData("Sheet1", 1, 0);
        String encodedPass = excel.getCellData("Sheet1", 1, 1);
        String encodeurl = excel.getCellData("Sheet1", 1, 2);

        String username = CredentialsUtil.decode(encodedUser);
        String password = CredentialsUtil.decode(encodedPass);
        String url = CredentialsUtil.decode(encodeurl);

        driver.get(url);
        test.get().log(Status.INFO, "Opening SauceDemo URL");

        loginPage loginPage = new loginPage(driver);
        loginPage.login(username, password);
        test.get().log(Status.INFO, "Logging in with provided credentials");

        Assert.assertTrue(loginPage.isOnInventoryPage(), "Login failed!");

       // System.out.println("Generated Email: " + TestDataGenerator.randomEmail());
    }

    @Test
    public void addCartClick() {
        SwagLab_Home_Page clk = new SwagLab_Home_Page(driver);
     
          /*  AlertUtil alertUtil = new AlertUtil(driver);

            alertUtil.acceptAlert();  // Accept alert if it exists

            clk.addToCartClk();
            test.get().log(Status.INFO, "Clicked Add to Cart button");

            alertUtil.acceptAlert();  

            Assert.assertTrue(true, "Dummy assertion to capture screenshot");
        */
    	//SwagLab_Home_Page clk = new SwagLab_Home_Page(driver);
    	//AlertUtil alertUtil = new AlertUtil(driver);

    	//By okButton = By.xpath("//div[@class='swal-modal']//button[text()='OK']");
    	//alertUtil.acceptHtmlModal(okButton);

    	//clk.addToCartClk();
    	//test.get().log(Status.INFO, "Clicked Add to Cart button");

    	//Assert.assertTrue(true);
       // clk.addToCartClk();
       // test.get().log(Status.INFO, "Clicked Add to Cart button");

      //  Assert.assertTrue(true, "Dummy assertion to capture screenshot");
    }
}
