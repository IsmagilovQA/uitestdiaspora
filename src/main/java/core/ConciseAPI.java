package core;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static core.Conditions.listSizeIsAtLeast;
import static core.Conditions.visible;


public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    protected WebElement $(By locator){
        return assertThat(visible(locator));
    }

    protected WebElement $(String cssSelector){
        return $(By.cssSelector(cssSelector));
    }

    protected List<WebElement> $$(By locator){
        return getWebDriver().findElements(locator);
    }

    protected List<WebElement> $$(String cssSelector){
        return $$(By.cssSelector(cssSelector));
    }

    protected WebElement $get(By listLocator, int index){
        return assertThat(listSizeIsAtLeast(listLocator, index + 1)).get(index);
    }

    protected void open(String url){
        getWebDriver().get(url);
    }

    protected <V> V waitUntil(Function<? super WebDriver, V> condition, int timeout){
        return (new WebDriverWait(getWebDriver(), timeout)).until(condition);
    }

    protected <V> V assertThat(Function<? super WebDriver, V> condition){
        return waitUntil(condition, Configuration.timeout);
    }

    protected void refresh(){
        $("body").sendKeys(Keys.F5);
    }

    public void executeJavaScript(String jsCode, Object... arguments) {
        if (getWebDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getWebDriver()).executeScript(jsCode, arguments);
        }
    }

    public File getScreenShotAsFile() {
        if (getWebDriver() instanceof TakesScreenshot) {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        }
        return null;
    }


 }
