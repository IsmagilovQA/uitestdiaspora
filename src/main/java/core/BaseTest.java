package core;

import com.google.common.io.Files;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.AfterClass;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

public class BaseTest extends ConciseAPI {
    static WebDriver driver = new FirefoxDriver();

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @After
    public void postScreensAndClearDataAfterTest() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = getScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }
}

