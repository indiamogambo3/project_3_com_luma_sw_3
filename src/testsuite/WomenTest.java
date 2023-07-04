package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {

        //Mouse Hover on Women Menu
        Thread.sleep(1000);
        WebElement womenMenu = driver.findElement(By.xpath("//span[(text() = 'Women')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).build().perform();
        //Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(tops).build().perform();
        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        //Select Sort By filter “Product Name”
        selectByValueFromDropDown(By.id("sorter"), "name");
        //Verify the products name display in alphabetical order
        List<WebElement> productsAToZ = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement e : productsAToZ){
            System.out.println(e.getText());
        }



    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {

        //Mouse Hover on Women Menu
        Thread.sleep(1000);
        WebElement womenMenu = driver.findElement(By.xpath("//span[(text() = 'Women')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).build().perform();
        //Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(tops).build().perform();
        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        //Select Sort By filter “Price”
        selectByValueFromDropDown(By.id("sorter"), "price");
        // Verify the products price display in Low to High
        List<WebElement> priceLowToHigh = driver.findElements(By.xpath("//span[@data-price-type= 'finalPrice']"));
        for (WebElement e : priceLowToHigh) {
            System.out.println(e.getText());
        }
    }


    @After
    public void tearDown() {

        closeBrowser();
    }


}
