package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() throws InterruptedException {

        //Mouse Hover on Men Menu
        Thread.sleep(1000);
        WebElement menMenu = driver.findElement(By.id("ui-id-5"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menMenu).build().perform();
        //Mouse Hover on Bottoms
        Thread.sleep(1000);
        WebElement bottoms = driver.findElement(By.id("ui-id-18"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(bottoms).build().perform();
        //Click on Pants
        Thread.sleep(1000);
        clickOnElement(By.id("ui-id-23"));
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        Thread.sleep(1000);
        WebElement cronusYogaPantSize = driver.findElement(By.id("option-label-size-143-item-175"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(cronusYogaPantSize).click().build().perform();
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        Thread.sleep(1000);
        WebElement cronusYogaPantColor = driver.findElement(By.id("option-label-color-93-item-49"));
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(cronusYogaPantColor).click().build().perform();
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        Thread.sleep(1000);
        WebElement addToCart = driver.findElement(By.xpath("//li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        Actions actions4 = new Actions(driver);
        actions4.moveToElement(addToCart).click().build().perform();
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedAddedToCartText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualAddedToCartText = getTextFromElement(By.xpath("//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("Unable to verify text.", expectedAddedToCartText, actualAddedToCartText);
        // Click on ‘shopping cart’ Link into message
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[(text() = 'shopping cart')]"));
        //Verify the text ‘Shopping Cart.’
        String expectedText = "Shopping Cart";
        String actualText = getTextFromElement(By.xpath("//span[@class = 'base']"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
        //Verify the product name ‘Cronus Yoga Pant’
        String expectedName = "Cronus Yoga Pant";
        String actualName = getTextFromElement(By.xpath("//td[1]/div[1]/strong[1]/a[1]"));
        Assert.assertEquals("Unable to verify product name.", expectedName, actualName);
        // Verify the product size ‘32’
        String expectedSize = "32";
        String actualSize = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("Unable to verify product size.", expectedSize, actualSize);
        //Verify the product colour ‘Black’
        String expectedColour = "Black";
        String actualColour = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Unable to verify product colour.", expectedColour, actualColour);
    }


    @After
    public void tearDown() {

        closeBrowser();
    }

}
