package FaceBookHomePage; /**
 * Created by HP on 5/18/2015.
 */
import BaseApi.Base;
import Utility.DataReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignIn extends Base {
    public DataReader dr=new DataReader();
    String path="FaceBook\\src\\data\\file1.xls";
    @Test
    public void signIn() throws IOException, InterruptedException {
        String[][] value=dr.fileReader(path);

        String emailLocator=value[1][0];
        String email=value[1][1];

        String PasswordLocator=value[2][0];
        String pass=value[2][1];

        typeByCss(emailLocator,email);
        sleepFor(2);
        typeByCss(PasswordLocator,pass);
        sleepFor(2);
        driver.findElement(By.cssSelector("#u_0_n")).click();
        sleepFor(4);

        typeByXpath(".//*[@id='u_0_c']", "Eshita");
        sleepFor(2);
        clickByXpath(".//*[@id='blueBarNAXAnchor']/div[1]/div/div/div[2]/form/button");
        sleepFor(1);
        clickByCss("#userNavigationLabel");
        sleepFor(1);
        clickByCss("#logout_form");
        sleepFor(2);

    }
}
