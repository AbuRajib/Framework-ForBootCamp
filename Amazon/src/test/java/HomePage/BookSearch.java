package HomePage;
import BaseApi.Base;
import org.testng.annotations.Test;

/**
 * Created by HP on 6/1/2015.
 */
public class BookSearch extends Base {

    @Test
    public void search() throws InterruptedException {
        typeAndEnterByCss("#twotabsearchtextbox","Books");
        sleepFor(2);

        clickByXpath(".//*[@id='nav-subnav']/a[6]");
        sleepFor(2);

        clickByXpath(".//*[@id='centerSlots']/div[5]/div[1]/div[2]/div/a/img");
        sleepFor(2);

        clickByXpath(".//*[@id='ns_0D6XDD7FEC53FNRMDB16_897_ItemRow']/div[2]/div/div[4]/div/div/div/a/span");
        sleepFor(2);

        clickByXpath(".//*[@id='imgBlkFront']");
        sleepFor(1);

        clickByCss("#sitbReaderRightPageTurner");
        sleepFor(2);
    }
}
