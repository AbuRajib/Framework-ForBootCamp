package HomePage;
import BaseApi.Base;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 5/26/2015.
 */
public class MenuList extends Base{
    @Test

    public void getMenuList() throws InterruptedException {
        List<String> list=getListOfTextByCss("#searchDropdownBox option");
        displayText(list);

        for(String item:list){
            typeAndEnterByCss("#twotabsearchtextbox",item);
            sleepFor(4);
        }

    }
}
