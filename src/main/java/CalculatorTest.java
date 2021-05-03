import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CalculatorTest {
    private WebDriver driver;

    @BeforeTest
    public void openWebsite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver 5");
        driver = new ChromeDriver();
        driver.get("https://beregifiguru.ru/%D0%9A%D0%B0%D0%BB%D1%8C%D0%BA%D1%83%D0%BB%D1%8F%D1%82%D0%BE%D1%80%D1%8B/%D0%A0%D0%B0%D1%81%D1%87%D0%B5%D1%82-%D0%BD%D0%BE%D1%80%D0%BC%D0%B0%D0%BB%D1%8C%D0%BD%D0%BE%D0%B3%D0%BE-%D0%B2%D0%B5%D1%81%D0%B0");
        Thread.sleep(3000);
        //Here test open a tested website and wait 3 second
    }

    @Test
    public void positiveTestCalculation() {
        WebElement startButton = driver.findElement(By.xpath("//*[@id='calcFormId']/button"));
        startButton.click();
        //Find element start button and click to it
        WebElement checkboxMan = driver.findElement(By.xpath("//*[@id='radioSex']/label[2]"));
        checkboxMan.click();
        //Find and select gender male
        WebElement fieldWeight = driver.findElement(By.xpath("//*[@id='Weight']"));
        fieldWeight.sendKeys("" + 80);
        //Find field "Weight" and set value 80 kilos
        WebElement fieldHeight = driver.findElement(By.xpath("//*[@id='Height']"));
        fieldHeight.sendKeys("" + 182);
        //Find field "Height" and set value 182 sm
        WebElement fieldYears = driver.findElement(By.xpath("//*[@id='Age']"));
        fieldYears.sendKeys("" + 30);
        //Find field "Age" and set value 30 years
        WebElement buttonCalk = driver.findElement(By.xpath("//*/tbody/tr[6]/th/button"));
        buttonCalk.click();
        //Find and click to the button "Calculate"
        double expectedResult = 77.48;
        //Assign a value to the variable "expectedResult"
        WebElement result = driver.findElement(By.xpath("//div[@class='resvalue']"));
        String actualResultString = result.getText();
        double actualResultDouble = Double.parseDouble(actualResultString);
        //Find element with actual result, get value, convert the text value to a double value
        Assert.assertEquals(expectedResult, actualResultDouble);
        //Compare the expected value with the received value
    }

    @AfterTest
    public void AfterTest() {
        driver.quit();
        //Close browser
    }

}











