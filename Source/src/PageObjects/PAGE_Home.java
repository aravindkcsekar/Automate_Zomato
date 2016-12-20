package PageObjects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PAGE_Home {
    /*
       Google Page -> Minnesota as Search -> Some results -> Click on first link -> Right Page

       Before- Open Browser
               Google Page
               Maximize
       Test
               Identify Search Bar
               Type Minnesota in Search bar
               Click on search button
               Results-Click on first link - Identifying first link
       After
               Close the browser

     */
    WebDriver driver=null;
    @Before
    public void start()
    {
        System.setProperty("webdriver.chrome.driver","C:/Users/asapu/Downloads/chromedriver_win32/chromedriver.exe");
        driver=new ChromeDriver();
        //driver.get("https://www.google.com/");
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void getPageName()throws Exception
    {
            driver.findElement(By.id("lst-ib")).sendKeys("Minnesota");
            driver.findElement(By.id("_fZl")).click();
            Thread.sleep(3000);
            driver.findElement(By.linkText("index / Minnesota.gov")).click();
            String currentUrl=driver.getCurrentUrl();

            if(currentUrl.equals("https://mn.gov/portal/"))
            {
                System.out.print("Navigated to the right page");
            }
            else
            {
                System.out.print("Wrong Page");
            }
    }
    @After
    public void tear()
    {
       driver.close();
       // System.exit(0);
    }
}

