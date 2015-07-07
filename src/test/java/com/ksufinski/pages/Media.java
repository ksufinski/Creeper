package com.ksufinski.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

public class Media extends PageObject {




    @FindBy(xpath = "//button[contains(@class,'likeButton')]")
    private WebElement likeButton;

    @FindBy(xpath = "//a[contains(@class,'rightArrow')]")
    private WebElement rightArrow;

    @FindBy(xpath = "//a[contains(@class,'ownerUserLink')]")
    private WebElement userName;

    @FindBy(xpath = "//button[contains(@class,'FollowButton')]")
    private WebElementFacade followButton;

    public void clickOnLikeButton(){
        likeButton.click();
    }
    public void clickOnFollowButton(){
        followButton.click();
    }
    public void clickOnRightArrow(){
        rightArrow.sendKeys(Keys.RIGHT);
    }

    public void likeAndNextPhoto(String numberOfPhotos, String tag){
        int nof = Integer.parseInt(numberOfPhotos);
        int likeCounter=0;
        int process = 0;
        int person = 0;
        boolean plusOne=false;
        LinkedHashSet <String> userNames = new LinkedHashSet <String>();


        for(int i=0; i < nof ;i++) {
            process++;
            if(/*userNames.contains(userName.getText())*/followButton.getText().equals("FOLLOWING") ){
                System.out.print("\n"+process);
                rightArrow.sendKeys(Keys.RIGHT);
                continue;
            }


            if(likeButton.getText().equals("Like")) {   // you have already liked
                likeButton.click();
                likeCounter++;
            }

            if(followButton.getText().equals("FOLLOW")) {
                plusOne = false;
                followButton.click();
                followButton.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilClickable();
                if(followButton.getText().equals("FOLLOWING"))
                    plusOne = true;
            }
            if(plusOne==true){
                person++;
                System.out.print("\nGot "+person+" :"+userName.getText());
                userNames.add(userName.getText());}

            rightArrow.sendKeys(Keys.RIGHT);

        }
        System.out.print("\n# of likes :"+likeCounter+
                "\nOn tag :" +tag+
                "\nFor "+userNames.size()+" users :\n");
        for (String elem : userNames){
            System.out.print(elem+"\n");
        }


    }

}
