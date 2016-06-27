package com.ksufinski.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@DefaultUrl("https://instagram.com/accounts/login/")
public class Login extends PageObject {

    private static final Integer CATALOG_WAIT_FOR_TIMEOUT = 20000;
    public Login(WebDriver driver) {super(driver, CATALOG_WAIT_FOR_TIMEOUT);}


    @FindBy (name = "username")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElementFacade passwordInput;

    @FindBy (css = "button")
    private WebElementFacade submitLoginButton;

    public void setLogin(String emailInputText) {element(emailInput).type(emailInputText);}

    public void setPassword(String password){passwordInput.sendKeys(password);}

    public void clickLoginButton(){submitLoginButton.click();}








}
