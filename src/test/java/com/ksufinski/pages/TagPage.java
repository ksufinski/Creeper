package com.ksufinski.pages;

import com.ksufinski.Creep;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


//@DefaultUrl("https://instagram.com/explore/tags/")
@DefaultUrl("https://www.instagram.com/rozanov_z/")
@NamedUrls(
        {
                @NamedUrl(name = "custom", url = "/{1}")

        }
)

public class TagPage extends PageObject {

    Creep creep;

    private static final Integer CATALOG_WAIT_FOR_TIMEOUT = 20000;
    public TagPage(WebDriver driver) {super(driver, CATALOG_WAIT_FOR_TIMEOUT);}



   // @FindBy(css = "div>a") //for tags
    @FindBy( css = "._ovg3g") //for peoplea
    private WebElement photoFromTag;



    public void clickOnPhotoFromTag(){

        setImplicitTimeout(5, TimeUnit.SECONDS);
        photoFromTag.click();
        resetImplicitTimeout();
    }








}
