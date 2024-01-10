package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: LeetCode");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/ ");
        if(driver.getCurrentUrl().contains("leetcode")){
            System.out.println("TestCase01 : PASSED");
        }
        else {
            System.out.println("TestCase01 : FAILED");
        }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02(){
        System.out.println("Start Test case: testCase02");
        try {
            driver.findElement(By.xpath("//span[text()='Sign in']")).click();
            Thread.sleep(5000);
            WebElement user =  driver.findElement(By.id("id_login"));
            user.click();
            user.sendKeys("Tahseen123");
            WebElement pswd =  driver.findElement(By.id("id_password"));
            pswd.click();
            pswd.sendKeys("Bismillah@123");
            driver.findElement(By.xpath("//button[@id='signin_btn']")).click();
            Thread.sleep(5000);
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[@href='/problemset/all/']")).click();
            Thread.sleep(5000);
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if(driver.getCurrentUrl().contains("problemset")){
                System.out.println("url contains problemset");
            }
            else {
                System.out.println("url does not contains problemset");
            }
            List<WebElement> questions = driver.findElements(By.xpath("//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));
            for (int i = 1; i<= 5; i++) {
                System.out.println(questions.get(i).getText());
            }
            System.out.println("TestCase02 : PASSED");

        }
        catch(Exception e) {
            System.out.println("Something somewhere went wrong");
        }

        System.out.println("end Test case: testCase02");
    }

    public  void testCase03(){
        System.out.println("Start Test case: testCase03");
        try {
            driver.findElement(By.xpath("//a[@href='/problems/two-sum']")).click();
            Thread.sleep(5000);
            driver.getCurrentUrl().contains("two-sum");
            System.out.println("TestCase03 : PASSED");

        }
        catch(Exception e) {
            System.out.println("Something somewhere went wrong");
        }

        System.out.println("end Test case: testCase03");
    }

    public  void testCase04(){
        System.out.println("Start Test case: testCase04");
        try {
            driver.findElement(By.xpath("//span[@id='navbar_user_avatar']")).click();
            driver.findElement(By.xpath("//div[text()='Sign Out']")).click();
            Thread.sleep(15000);
            driver.findElement(By.id("submissions_tab")).click();
            Thread.sleep(4000);
            WebElement result = driver.findElement(By.xpath("//a[@href='/accounts/login/?next=%2Fproblems%2Ftwo-sum%2Fsubmissions%2F']"));
            if(result.getText().equals("Register or Sign In")) {
                System.out.println("TestCase04 : PASSED");
            }

        }
        catch(Exception e) {
            System.out.println("Something somewhere went wrong");
        }

        System.out.println("end Test case: testCase04");
    }


}
