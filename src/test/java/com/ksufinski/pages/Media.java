package com.ksufinski.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

public class Media extends PageObject {




    @FindBy (css = ".coreSpriteHeartOpen")
    private WebElementFacade likeButton;

    //@FindBy(xpath = "//a[contains(@class,'rightArrow')]")
    @FindBy(css = "a.coreSpriteRightPaginationArrow")
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

    public void likeAndNextPhoto(String numberOfPhotos, String tag) throws InterruptedException {
        int nof = Integer.parseInt(numberOfPhotos);
        int likeCounter=0;
        int process = 0;
        int person = 0;
        boolean plusOne=false;
        LinkedHashSet <String> userNames = new LinkedHashSet <String>();


        for(int i=0; i < nof ;i++) {
            process++;
            System.out.print("\nProcess "+process
                    +"\t Likes "+likeCounter);
           /* if(followButton.getText().equals("FOLLOWING") ){
                System.out.print("\n"+process);
                rightArrow.sendKeys(Keys.RIGHT);
                continue;
            }*/

            if(!likeButton.getText().equals("Like")){
                rightArrow.sendKeys(Keys.RIGHT);
                Thread.sleep(2000);
            }
            rightArrow.sendKeys(Keys.RIGHT);
            likeButton.click();
            Thread.sleep(2000);

/*
            if(likeButton.getText().equals("Like")) {
                likeButton.click();
                likeCounter++;
                Thread.sleep(2000);
            }
*/

             /*if(followButton.getText().equals("FOLLOW")) {
                plusOne = false;
                followButton.click();
                followButton.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilClickable();
                if(followButton.getText().equals("FOLLOWING"))
                    plusOne = true;
            }
            if(plusOne==true){
                person++;
                System.out.print("\nGot " + person + " :" + userName.getText());
                userNames.add(userName.getText());}*/
          //likeButton.withTimeoutOf(3, TimeUnit.SECONDS).waitUntilClickable();
            //String a= likeButton.getText();
            //System.out.println(a);


        }
        System.out.print("\n# of likes :"+likeCounter+
                "\nOn tag :" +tag+
                "\nFor "+userNames.size()+" users :\n");
        for (String elem : userNames){
            System.out.print(elem+"\n");
        }


    }

}
