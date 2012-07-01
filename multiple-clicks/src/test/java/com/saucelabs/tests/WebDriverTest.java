package com.saucelabs.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertEquals;

public class WebDriverTest {

    private WebDriver driver;

    public @Rule
    TestName testName= new TestName();

    @Before
    public void setUp() throws Exception {
        this.driver = new FirefoxDriver();
//        DesiredCapabilities capabillities = DesiredCapabilities.internetExplorer();
//        capabillities.setCapability("version", "6");
//        capabillities.setCapability("platform", Platform.XP);
//        this.driver = new RemoteWebDriver(
//                new URL("http://rossco_9_9:44f0744c-1689-4418-af63-560303cbb37b@ondemand.saucelabs.com:80/wd/hub"),
//                capabillities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void amazon() throws Exception {
        driver.get("http://www.amazon.com/");
        assertEquals(
                "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",
                driver.getTitle());
        driver.findElement(By.linkText("Books")).click();
        driver.findElement(By.linkText("Kindle")).click();
        driver.findElement(By.linkText("Kindle eBooks")).click();
    }
}
