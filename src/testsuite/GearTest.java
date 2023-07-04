package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() throws InterruptedException {

        //Mouse Hover on Gear Menu
        Thread.sleep(1000);
        WebElement gearMenu = driver.findElement(By.xpath("//span[(text() = 'Gear')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gearMenu).build().perform();
        //Click on Bags
        Thread.sleep(3000);
        clickOnElement(By.xpath("//span[contains(text(),'Bags')]"));
        //Click on Product Name ‘Overnight Duffle’
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        //Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
        // Change Qty 3
        Thread.sleep(1000);
        driver.findElement(By.id("qty")).clear();
        sendTextToElement(By.id("qty"), "3");
        // Click on ‘Add to Cart’ Button.
        Thread.sleep(1000);
        clickOnElement(By.id("product-addtocart-button"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedTextInShoppingCart = "You added Overnight Duffle to your shopping cart.";
        String actualTextInShoppingCart = getTextFromElement(By.xpath("//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("Unable to verify text.", expectedTextInShoppingCart, actualTextInShoppingCart);
        // Click on ‘shopping cart’ Link into message
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        // Verify the product name ‘Overnight Duffle’
        String expectedName = "Overnight Duffle";
        String actualName = getTextFromElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]"));
        Assert.assertEquals("Unable to verify product name.", expectedName, actualName);
        // Verify the Qty is ‘3’
        String expectedQuantity = "3";
        String actualQuantity = driver.findElement(By.xpath("//div[@class = 'control qty']//input[@type= 'number']")).getAttribute("value");
        Assert.assertEquals("Unable to verify product quantity.", expectedQuantity, actualQuantity);
        //Verify the product price ‘$135.00’
        String expectedPrice = "$135.00";
        String actualPrice = getTextFromElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]/span[1]/span[1]"));
        Assert.assertEquals("Unable to verify product price.", expectedPrice, actualPrice);
        //Change Qty to ‘5’
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/label[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/label[1]/input[1]"), "5");
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//button[@class = 'action update']"));
        //Verify the product price ‘$225.00’
        Thread.sleep(2000);
        String expectedTotalPrice = "$225.00";
        String actualTotalPrice = getTextFromElement(By.xpath("//tbody/tr[1]/td[4]/span[1]/span[1]/span[1]"));
        Assert.assertEquals("Unable to verify total price.", expectedTotalPrice, actualTotalPrice);
    }


    @After
    public void tearDown() {

        closeBrowser();
    }


}
