package HomePage;
import BaseApi.Base;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 6/2/2015.
 */
public class MyAccount extends Base {

    @Test

    public void myAccount() throws InterruptedException {
        clickByCss("#nav-your-amazon");
        sleepFor(2);

        typeByCss("#ap_email","rajue794@gmail.com");
        typeByCss("#ap_password","monowara");
        clickByCss("#signInSubmit-input");
        sleepFor(2);

        //clickByXpath(".//*[@id='nav-link-yourAccount']/span[2]/span");

        List<String> st=getListOfTextByCss("#nav-flyout-yourAccount .nav-template>a");
        displayText(st);
        for(int i=0;i<st.size();i++){
            clickByXpath(".//*[@id='nav-link-yourAccount']/span[2]/span");

            clickByText(st.get(i));
            sleepFor(1);
        }
    }
}
