package CitiBankHomePage;

import BaseApi.Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 5/20/2015.
 */
public class HomePage extends Base {

    @Test
    public void citiHomePage() throws InterruptedException {
        List<String> list=getListOfTextByCss("#nav_main #nav_marketing li");
        displayText(list);
        for(int i=0;i<list.size();i++){
            clickByText(list.get(i));
        }
    }
}
