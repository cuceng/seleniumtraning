import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example {

    protected WebDriver driver;
    public static String webUrl = "https://ssilistre.github.io/seleniumtraning/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openToGoogle() throws InterruptedException {
        WebDriverWait bekleme = new WebDriverWait(driver, 20);
        driver.get(webUrl);
        //bekleme.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]")));
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("serhatsalma@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("ANKARA");
        Select ulkelistesi = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
        ulkelistesi.selectByIndex(1);
        Select sehirlistesi = new Select(driver.findElement(By.xpath("//*[@id=\"state\"]")));
        sehirlistesi.selectByIndex(1);
        driver.findElement(By.xpath("//*[@id=\"zip\"]")).sendKeys("06101");
        driver.findElement(By.xpath("//*[@for=\"same-address\"]")).click();
        driver.findElement(By.xpath("//*[@for=\"save-info\"]")).click();
        driver.findElement(By.xpath("//*[@for=\"debit\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"cc-name\"]")).sendKeys("MEHMET SERHAT SALMA");
        driver.findElement(By.xpath("//*[@id=\"cc-number\"]")).sendKeys("1111222233334444");
        driver.findElement(By.xpath("//*[@id=\"cc-expiration\"]")).sendKeys("11/22");
        driver.findElement(By.xpath("//*[@id=\"cc-cvv\"]")).sendKeys("123");
        driver.findElement(By.xpath("(//*[@type=\"submit\"])[2]")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("(//*[@type=\"submit\"])[2]")).click();
        driver.switchTo().alert().accept();
        String expectedmessage = "Your payment has been successful!";
        WebElement element = driver.findElement(By.xpath("//*[@role=\"alert\"]"));
        String webpagemessage= element.getAttribute("innerText");
        Assert.assertEquals(expectedmessage,webpagemessage);

        //String webpagemessage = "";
        //webpagemessage = driver.findElement(By.xpath("//*[@role=\"alert\"]").getText();


        //driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Serhat Salma");
        //driver.findElement(By.xpath("(//input[@name=\"btnK\"])[1]")).click();
        //Thread.sleep(5000);
        //Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

