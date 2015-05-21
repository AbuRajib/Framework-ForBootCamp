package CnnHomePage;
import BaseApi.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by HP on 5/18/2015.
 */
public class CnnHome extends Base {
    String heading="Gang warning issued";
    @Test
    public void cnnHomePage() throws InterruptedException {
//        List<WebElement> elements= getWebElements(".sections ul>li>a");
//        mouseOver(elements);

//        String st=getTextByXpath(".//*[@id='homepage1-zone-1']/div[2]/div/div[1]/ul/article[1]/div[1]/a/h2/strong");
//        System.out.println(st);
//        Assert.assertEquals(st,heading);

        clickByXpath(".//*[@id='nav-header']/nav/div/div[4]/ul/li[1]/div/ul/li[10]/a");
        sleepFor(2);
        clickByXpath(".//*[@id='more']/a");
        sleepFor(2);
        clickByXpath(".//*[@id='more']/div/div/div[5]/ul/li[1]/a");
        sleepFor(2);
    }
}
