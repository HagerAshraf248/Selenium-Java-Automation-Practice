import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicWaitTest {
    @Test
    public void Test2(){

        // Open Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to page that contains dynamic elements
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        // Global implicit wait: driver waits up to 10 seconds when searching for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create explicit wait object (used for specific conditions)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // (Example) wait until an element with id "dynamicElement" is present in DOM
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(By.id("dynamicElement"))
//        );

        // Wait until the "Add a box" button is present then click it
        WebElement addbox = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"adder\"]"))
        );
        addbox.click();

        // Wait until the red box appears in the DOM then verify it is displayed
        WebElement redBox = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"box0\"]"))
        );
        Assert.assertTrue(redBox.isDisplayed());

        // Wait for the "Reveal" button to be present, then click it
        WebElement newbutton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"reveal\"]"))
        );
        newbutton.click();

        // Wait until the hidden input field becomes visible, then type text into it
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"revealed\"]"))
        );
        field.sendKeys("Hager");
    }
}
