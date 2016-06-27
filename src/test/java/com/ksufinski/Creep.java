package com.ksufinski;


import com.ksufinski.steps.UserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithDriver;
import net.thucydides.core.pages.Pages;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static com.ksufinski.PropertiesReader.readProperties;

@RunWith(SerenityRunner.class)
public class Creep {

    public Properties keyWords;
    {
        keyWords = readProperties("SignIn.properties");
    }

    @Managed(uniqueSession = true, driver = "chrome")
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://instagram.com/")
    public Pages pages;

    @Before
    public void myTest()  throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        webdriver.manage().window().maximize();
    }

    @Steps
    public UserSteps user;

    @WithDriver("chrome")
    @Test
    public void first() throws InterruptedException {
        user.loginFromHomePage(keyWords.getProperty("login"), keyWords.getProperty("password"));
        user.getTegPage(keyWords.getProperty("numberOfPhotos"));
        Thread.sleep(4000);

    }

}
