package testsuite;
/**
 * 1. verifyTheSortByProductNameFilter
 *      * Mouse Hover on Women Menu
 *      * Mouse Hover on Tops
 *      * Click on Jackets
 *      * Select Sort By filter “Product Name”
 *      * Verify the products name display in alphabetical order
 */

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class WomenTest extends Utility {
    // Declare baseUrl
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // Open Browser
    @Before
    public void setUP(){

        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {

        //Mouse Hover on Women Menu
        WebElement womenMenu = driver.findElement(By.xpath("//span[normalize-space()='Women']"));

        // Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        // Click on Jackets
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).moveToElement(tops).moveToElement(jackets).click().build().perform();

        //Select Sort By filter “Product Name”
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"));
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByIndex(1);

        //Verify the products name display in
        //alphabetical order
verifyTheListIsSortedInOrder(By.xpath("//strong[@class ='product name product-item-name']"));
    }
    @Test
    public void verifyTheSortedByPriceFilter(){
        // Mouse Hover on Women Menu
        WebElement womenMenu = driver.findElement(By.xpath("//span[normalize-space()='Women']"));

        // Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        // Click on Jackets
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).moveToElement(tops).moveToElement(jackets).click().build().perform();



        //Select Sort By filter “Price”
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"));
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByIndex(2);

        //Verify the products price display in Low to High

        verifyTheListIsSortedInOrder(By.xpath("//span[@class ='normal-price']//span[@class = 'price']"));
    }
    }


