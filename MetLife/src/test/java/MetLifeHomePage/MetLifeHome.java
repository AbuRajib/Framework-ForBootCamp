package MetLifeHomePage;

import Utility.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import BaseApi.Base;

import java.io.IOException;
import java.util.List;

/**
 * Created by HP on 5/19/2015.
 */
public class MetLifeHome extends Base{
    public DataReader dr=new DataReader();
    String path="MetLife\\src\\data\\file.xls";
    @Test

    public void homePage() throws InterruptedException,IOException {
        String[][] value=dr.fileReader(path);

        //Smoke Test of Menu
//        List<String> lists=getListOfTextByCss("#hdMenuDiv ul>li>a");
//        displayText(lists);
//
//        for(int i=1;i<lists.size();i++){
//            clickByText(lists.get(i));
//        }
//
//         List<String> list=getListOfTextByCss("#state1-mmquote option");
//        displayText(list);

        WebElement selectState = driver.findElement(By.id("state1-mmquote"));
        selectState.sendKeys("New York");
        sleepFor(1);

        WebElement selectMonth = driver.findElement(By.id("month-mmquote"));
        selectMonth.sendKeys("9");
        sleepFor(1);

        WebElement selectDay = driver.findElement(By.id("day-mmquote"));
        selectDay.sendKeys("8");
        sleepFor(1);

        WebElement selectYear = driver.findElement(By.id("year-mmquote"));
        selectYear.sendKeys("1986",Keys.ENTER);
        sleepFor(1);

        WebElement selectGender = driver.findElement(By.id("gender-mmquote"));
        selectGender.sendKeys("Male");
        sleepFor(1);

        Select selectCoverage1 = new Select(driver.findElement(By.id("coverage-mmquote")));
        selectCoverage1.selectByIndex(1);
        sleepFor(1);

        WebElement selectTeam = driver.findElement(By.id("term-mmquote"));
        selectTeam.sendKeys("20 Years");
        sleepFor(1);

        WebElement selectTobacco = driver.findElement(By.id("tobacco-mmquote"));
        selectTobacco.sendKeys("No",Keys.ENTER);
        sleepFor(1);

        WebElement selectHealth = driver.findElement(By.id("health-mmquote"));
        selectHealth.sendKeys("Very Good: I usually work out and eat right");
        sleepFor(1);

        clickByCss("#submitBtn #submitBtnImage");
        sleepFor(2);
        navigateBack();




    }
}
