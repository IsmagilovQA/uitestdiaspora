package core;

import org.openqa.selenium.By;

public class LocatorHelpers {

    public static By byText(String text){
        //return By.xpath(String.format("//div[text()='%s']",text));
        return By.xpath(String.format(".//*/text()[normalize-space(.) = '%s']/parent::*",text));
    }

}
