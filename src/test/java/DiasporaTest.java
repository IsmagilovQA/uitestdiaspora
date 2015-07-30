import org.junit.Test;
import core.Configuration;
import org.openqa.selenium.Keys;
import testDatas.TestDiasporaData;

import static core.Conditions.visible;
import static core.LocatorHelpers.byText;


public class DiasporaTest extends AtDiasporaWithClearingDataBeforeEachTest{
    { Configuration.timeout = 15; }

    @Test
    public void CreateAccountTest(){

        $(byText("creating an account")).click();
        assertThat(visible($(".ball")));
        $("#user_email").sendKeys(TestDiasporaData.CONTACT_EMAIL);//+ Keys.ENTER
        $("#user_username").sendKeys(TestDiasporaData.USERNAMES[0]);
        $("#user_password").sendKeys(TestDiasporaData.PASSWORDS[0] );
        $("#user_password_confirmation").sendKeys(TestDiasporaData.PASSWORDS[0]);
        $("[value=\"Sign up\"]").click();

        assertThat(visible(byText("Well, hello there!")));
        $("#as-original-tags").sendKeys(TestDiasporaData.TAGS[0] + Keys.ENTER);
        $("#as-original-tags").sendKeys(TestDiasporaData.TAGS[1] + Keys.ENTER);
        $("#awesome_button").click();
        //$("#steps>:nth-child(2) a").click();
    }

}
