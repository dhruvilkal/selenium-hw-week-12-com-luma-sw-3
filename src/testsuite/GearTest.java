package testsuite;
/**
 * 1. userShouldAddProductSuccessFullyToShoppingCart()
 *      * Mouse Hover on Gear Menu
 *      * Click on Bags
 *      * Click on Product Name ‘Overnight Duffle’
 *      * Verify the text ‘Overnight Duffle’
 *      * Change Qty 3
 *      * Click on ‘Add to Cart’ Button.
 *      * Verify the text ‘You added Overnight Duffle to your shopping cart.’
 *      * Click on ‘shopping cart’ Link into message
 *      * Verify the product name ‘Cronus Yoga Pant’
 *      * Verify the Qty is ‘3’
 *      * Verify the product price ‘$135.00’
 *      * Change Qty to ‘5’
 *      * Click on ‘Update Shopping Cart’ button
 *      * Verify the product price ‘$225.00'
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class GearTest extends Utility {
    // Declare baseUrl
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // Open Browser
    @Before
    public void setUP() {

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        Thread.sleep(2000);
        //Mouse Hover on Gear Menu
        mouseHoverOnElement(By.xpath("//span[normalize-space()='Gear']"));
        Thread.sleep(2000);
        //Click on Bags
        mouseHoverOnElementAndClick(By.xpath("//span[normalize-space()='Bags']"));
        //Click on Product Name ‘Overnight Duffle’
        mouseHoverOnElementAndClick(By.xpath("//a[@class='product-item-link'][normalize-space()='Overnight Duffle']"));
        //Verify the text ‘Overnight Duffle’
        String actualMessage = getTextFromElement(By.xpath("//span[@class='base']"));
        String expectedMessage = "Overnight Duffle";
        Assert.assertEquals(expectedMessage, actualMessage);
        //Change Qty 3
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@id='qty']"), s);
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");

        //Click on ‘Add to Cart’ Button.
        mouseHoverOnElementAndClick(By.xpath("//span[normalize-space()='Add to Cart']"));
        //Verify the text
        String actualMessage1 = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String expectedMessage1 = "You added Overnight Duffle to your shopping cart.";
        Assert.assertEquals(expectedMessage1, actualMessage1);

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        String expectedText = "Shopping Cart";
        Assert.assertEquals(expectedText, actualText);

        //Verify the product name ‘Cronus Yoga Pant’
        String actualMessage3 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        String expectedMessage3 = "Cronus Yoga Pant";
        Assert.assertEquals(expectedMessage3, actualMessage3);
        //return driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();

        //Verify the Qty is ‘3’

//Verify the product name ‘Cronus Yoga Pant’
        String actualMessage4 = getTextFromElement(By.xpath("#cart-484598-qty"));
        String expectedMessage4 = "3";
        Assert.assertEquals(expectedMessage3, actualMessage3);

        //Verify the product price ‘$135.00’
        String actualMessage5 = getTextFromElement(By.xpath("//span[contains(text(),'$135.00')]"));
        String expectedMessage5 = "$135.00";
        Assert.assertEquals(expectedMessage5, actualMessage5);

        //Change Qty 5
        String d = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@id='cart-484598-qty']"), d);
        sendTextToElement(By.xpath("//input[@id='cart-484598-qty']"), "5");
        //Click on ‘Update Shopping Cart’ button
        mouseHoverOnElementAndClick(By.xpath("//span[normalize-space()='Update Shopping Cart']"));

//Verify the product price ‘$225.00’
        String actualMessage6 = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        String expectedMessage6 = "$225.00";
        Assert.assertEquals(expectedMessage6, actualMessage6);

    }


}
