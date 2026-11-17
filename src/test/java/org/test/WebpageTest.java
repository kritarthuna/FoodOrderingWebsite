
package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class WebpageTest {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        Thread.sleep(2000);

        String path = new File(
                "src/main/resources/index.html"
        ).getAbsolutePath();

        driver.get(new File(path).toURI().toString());
    }

    @Test
    public void titleTest() {

        String actualTitle = driver.getTitle();

        String expectedTitle = "Food Ordering Website";

        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }
}
