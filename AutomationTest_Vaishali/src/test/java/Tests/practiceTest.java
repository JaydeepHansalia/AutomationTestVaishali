package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class practiceTest {
    Common common = new Common();
    WebDriver driver = common.setup();
    practicePage practicePage = new practicePage(driver);

    @Test
    public void practiceTestValidation() throws IOException, InterruptedException {
        practicePage.verifyPracticeTest();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
