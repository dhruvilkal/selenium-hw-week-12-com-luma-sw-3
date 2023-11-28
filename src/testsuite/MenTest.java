package testsuite;
/**
 * 1. userShouldAddProductSuccessFullyTo ShoppinCart()
 *      * Mouse Hover on Men Menu
 *      * Mouse Hover on Bottoms
 *      * Click on Pants
 *      * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
 *      * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
 *      * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
 *      * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
 *      * Click on ‘shopping cart’ Link into message
 *      * Verify the text ‘Shopping Cart.’
 *      * Verify the product name ‘Cronus Yoga Pant’
 *      * Verify the product size ‘32’
 *      * Verify the product colour ‘Black’
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    // Declare baseUrl
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // Open Browser
    @Before
    public void setUP(){

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){

         //Mouse Hover on Men Menu
         mouseHoverOnElement(By.xpath("//span[normalize-space()='Men']"));
           //Mouse Hover on Bottoms
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
           //Click on Pants
         mouseHoverOnElementAndClick(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
//Mouse Hover on product name‘Cronus Yoga Pant’ and click on size32.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));

        mouseHoverOnElementAndClick(By.xpath("(//div[@id='option-label-size-143-item-175'])[1]"));
        mouseHoverOnElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        mouseHoverOnElementAndClick(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));

        String actualMessage = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        Assert.assertEquals(expectedMessage, actualMessage);

        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        String expectedText = "Shopping Cart";
        Assert.assertEquals(expectedText, actualText);

        //Verify the product name ‘Cronus Yoga Pant’
        String actualMessage1 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        String expectedMessage1 = "Cronus Yoga Pant";
        Assert.assertEquals(expectedMessage1, actualMessage1);

        //Verify the product size ‘32’
        String actualMessage2 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        String expectedMessage2 = "32";
        Assert.assertEquals(expectedMessage2, actualMessage2);

        //Verify the product colour ‘Black’
        String actualMessage3 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        String expectedMessage3 = "Black";
        Assert.assertEquals(expectedMessage2, actualMessage2);


    }

}
