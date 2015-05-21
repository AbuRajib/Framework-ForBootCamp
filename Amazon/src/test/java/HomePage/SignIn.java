package HomePage;

import Utility.DataReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import BaseApi.Base;

import java.io.IOException;

/**
 * Created by HP on 5/17/2015.
 */
public class SignIn extends Base{

    public DataReader data=new DataReader();
    String path="Amazon\\src\\data\\file1.xls";

    @Test

    public void signIn() throws InterruptedException, IOException {
        String[][] value=data.fileReader(path);
        clickByCss("#nav-tools #nav-link-yourAccount .nav-line-1");
        clickByCss("#nav-flyout-ya-signin .nav-action-button");
        sleepFor(4);

        String emailLocator=value[1][0];
        String emailValue=value[1][1];

        String PasswordLocator=value[2][0];
        String PasswordValue=value[2][1];

        typeByCss(emailLocator,emailValue);
        sleepFor(2);
        typeByCss(PasswordLocator,PasswordValue);
        sleepFor(2);
        driver.findElement(By.cssSelector("#signInSubmit-input")).click();
        sleepFor(4);

        typeAndEnterByCss("#twotabsearchtextbox","TV");
        sleepFor(4);
        clickByXpath(".//*[@id='result_1']/div/div[1]/div/div/div/div/a/div/div/span");
        sleepFor(2);

        clickByCss("#nav-link-yourAccount .nav-line-2");
        sleepFor(2);

        clickByXpath(".//*[@id='nav-item-signout']/span");
        sleepFor(2);
    }
}
