package HomePage;
import BaseApi.Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 5/30/2015.
 */
public class Sell extends Base {

    @Test

    public void sellOnAmazon() throws InterruptedException {
        clickByXpath(".//*[@id='nav-xshop']/a[4]");
        sleepFor(2);

        List<String> st=getListOfTextByCss(".lp-product-bar ul>li>a");
            for(int i=1;i<st.size();i++){
                    clickByText(st.get(i));
                sleepFor(2);
            }
    }

}
