package Pages;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class practicePage {
    WebDriver driver;

    public practicePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchval")
    public WebElement searchbar;

    @FindBy(id = "buyButton")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"react_0HMLHOTUUJOFF\"]/div[2]/div/div[3]/a[2]/span[1]/span")
    public WebElement cartBtn;

    @FindBy(xpath = "//*[@id=\"react_0HMLHOTUUJOFF\"]/div[2]/div/div[3]/a[2]/span[1]/span")
    public WebElement removeBtn;

    public void verifyPracticeTest() throws IOException, InterruptedException {
        driver.get("https://www.webstaurantstore.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        searchbar.sendKeys("stainless work table", Keys.ENTER);

        //Verify the product title having Table word
        List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"details\"]/a[2]"));
        Iterator<WebElement> itr = products.iterator();
        while (itr.hasNext()){
            WebElement product = itr.next();
            String productName = product.getText();
            Assert.assertTrue(productName.contains("Table"));
            if (!itr.hasNext()){
                product.click();
            }
        }

        //Adding the last product into cart and empty the cart
        addToCartBtn.click();
        cartBtn.click();
        removeBtn.click();
    }
}

