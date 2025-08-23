package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    
    // 👇 यह declare करना जरूरी है
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void setUpReport() {
        extent = ExtentManager.getInstance();   // report init
    }

    @BeforeMethod
    public void setUpDriver(Method method) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // हर test के लिए नया extentTest object बनाओ
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);   // ✅ अब error नहीं आएगा
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
           // driver.quit();
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();   // report generate
    }
}
