import core.BaseTest;
import core.ExecHelpers;
import org.junit.Before;
import ru.yandex.qatools.allure.annotations.Step;

public class AtDiasporaWithClearingDataBeforeEachTest extends BaseTest {
    @Before
    @Step
    public void openEmptyDiasporaBeforeTest() {
        dropCreateSeedDiasporaDB();
        open("http://localhost:3000");
    }

    public static void dropCreateSeedDiasporaDB(){
        String output = ExecHelpers.executeSource("/bin/bash","-c", "source /home/julia/.scripts/cleardiaspora.sh");
        System.out.println(output);
        output = ExecHelpers.executeCommand("/home/julia/.scripts/cleardiaspora");
        System.out.println(output);
        output = ExecHelpers.executeCommand("/home/julia/.scripts/cleardiaspora1");
        System.out.println(output);
    }

}
