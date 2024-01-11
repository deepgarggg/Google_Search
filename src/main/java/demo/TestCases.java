package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys("amazon");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//child::input[@value='Google Search']")).click();
        Thread.sleep(2000);
        List<WebElement>list=driver.findElements(By.xpath("//a[contains(text(),'Amazon')]"));
        for(WebElement ele : list){
            if(ele.getText().contains("in")){
                System.out.println("Amazon.in");
                break;
            }
        }
        System.out.println("end Test case: testCase01");
    }


}
