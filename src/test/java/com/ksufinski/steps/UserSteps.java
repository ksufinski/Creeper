package com.ksufinski.steps;

import com.ksufinski.pages.Login;
import com.ksufinski.pages.Media;
import com.ksufinski.pages.TagPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.Properties;

import static com.ksufinski.PropertiesReader.readProperties;

public class UserSteps extends ScenarioSteps {

    Login loginPage;
    TagPage tagPage;
    Media media;

    public Properties keyWords;
    {
        keyWords = readProperties("SignIn.properties");
    }

    public UserSteps(Pages pages)
    {
        super(pages);
    }

    @Step("Login")
    public void loginFromHomePage(String login, String password) {
        loginPage.open();
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }

    @Step("Go to teg page")
    public void getTegPage(String numberOfPhotos){
        tagPage.open("custom", new String[] {keyWords.getProperty("tag")});
        tagPage.clickOnPhotoFromTag();
        media.likeAndNextPhoto(numberOfPhotos, keyWords.getProperty("tag") );
       // media.clickOnLikeButton();
       // media.clickOnRightArrow();

    }
    @Step("Open UserAccount")
    public void openUserProfileWithPhoto(String userURL){}
}
