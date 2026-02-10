import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebFormTest {
    @Test
    public void Test1(){

        // Open Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the test web form page
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // Implicit wait: Selenium will wait up to 10 seconds when searching for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find text input field and type a name
        WebElement input = driver.findElement(By.xpath("//*[@id=\"my-text-id\"]"));
        input.sendKeys("Hager Ashraf");

        // Find password field and type password
        WebElement pass = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[2]/input"));
        pass.sendKeys("12345679#");

        // Find textarea and enter text
        WebElement Textarea = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[3]/textarea"));
        Textarea.sendKeys("Testttt");

        // Verify that the disabled button is displayed on the page
        WebElement Disablebutton = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[4]/input"));
        Assert.assertTrue(Disablebutton.isDisplayed());

        // Verify that the enabled button is clickable (enabled)
        WebElement Enablebutton = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[5]/input"));
        Assert.assertTrue(Enablebutton.isEnabled());

        // Locate the dropdown (select) element
        WebElement DropDownSelect = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select"));
        DropDownSelect.click();

        // Use Select class to choose option "Two" from dropdown
        Select select = new Select(DropDownSelect);
        select.selectByVisibleText("Two");

        // Locate datalist input field and type a value
        WebElement DropDownDataList = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[2]/input"));
        DropDownDataList.sendKeys("New York");

        // The below code was an attempt to select from datalist like a dropdown (not supported this way)
        // WebElement DataList = driver.findElement(By.id("my-options"));
        // DataList.click();
        // Select selectDL = new Select(DropDownDataList);
        // selectDL.selectByVisibleText("New York");

        // Locate first checkbox and select it
        WebElement CheckBox1 = driver.findElement(By.xpath("//*[@id=\"my-check-1\"]"));
        CheckBox1.click();

        // Locate second checkbox and select it
        WebElement CheckBox2 = driver.findElement(By.xpath("//*[@id=\"my-check-2\"]"));
        CheckBox2.click();

        // Locate radio button and select it
        WebElement radio = driver.findElement(By.xpath("//*[@id=\"my-radio-2\"]"));
        radio.click();
//Submit
        WebElement Submit = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        Submit.click();

//Form submitted
        WebElement sub=driver.findElement(By.xpath("/html/body/main/div/div[1]/div/h1"));
        Assert.assertEquals(sub.getText(),"Form submitted");
    }
}
