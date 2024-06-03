package ua.tqs.airportManager.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_SeleniumTest {
    private WebDriver driver;

    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DisplayName("Test Example")
    @Test
    public void testExample() {
        driver.get("http://localhost:5173");

        // setWindowSize
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1173));

        // click id=email
        driver.findElement(By.id("email")).click();

        // click css=.register-form
        driver.findElement(By.cssSelector(".register-form")).click();

        // click css=div:nth-child(5) > p
        driver.findElement(By.cssSelector("div:nth-child(5) > p")).click();

        // click css=.buttonCreateAccount
        driver.findElement(By.cssSelector(".buttonCreateAccount")).click();

        // click id=firstName
        driver.findElement(By.id("firstName")).click();

        // type id=firstName
        driver.findElement(By.id("firstName")).sendKeys("Fabio");

        // click id=lastName
        driver.findElement(By.id("lastName")).click();

        // type id=lastName
        driver.findElement(By.id("lastName")).sendKeys("Teixeira");

        // click id=city
        driver.findElement(By.id("city")).click();

        // type id=city
        driver.findElement(By.id("city")).sendKeys("Porto");

        // click id=country
        driver.findElement(By.id("country")).click();

        // type id=country
        driver.findElement(By.id("country")).sendKeys("Portugal");

        // click id=email
        driver.findElement(By.id("email")).click();

        // type id=email
        driver.findElement(By.id("email")).sendKeys("Fabio@gmail.com");

        // click id=password
        driver.findElement(By.id("password")).click();

        // type id=password
        driver.findElement(By.id("password")).sendKeys("fabio");

        // click css=.btn
        driver.findElement(By.cssSelector(".btn")).click();

        // click id=email
        driver.findElement(By.id("email")).click();

        // type id=email
        driver.findElement(By.id("email")).sendKeys("Fabio@gmail.com");

        // click id=password
        driver.findElement(By.id("password")).click();

        // type id=password
        driver.findElement(By.id("password")).sendKeys("fabio");

        // click css=.btn
        driver.findElement(By.cssSelector(".btn")).click();

        // click name=from
        driver.findElement(By.name("from")).click();

        // type name=from
        driver.findElement(By.name("from")).sendKeys("Viena");

        // click name=to
        driver.findElement(By.name("to")).click();

        // type name=to
        driver.findElement(By.name("to")).sendKeys("Paris");

        // click name=departureDate
        driver.findElement(By.name("departureDate")).click();

        // type name=departureDate
        driver.findElement(By.name("departureDate")).sendKeys("2024-06-07");

        // click css=button
        driver.findElement(By.cssSelector("button")).click();

        // click css=.flight-card:nth-child(2)
        driver.findElement(By.cssSelector(".flight-card:nth-child(2)")).click();

        // click css=.flight-card:nth-child(2) .book-flight-btn
        driver.findElement(By.cssSelector(".flight-card:nth-child(2) .book-flight-btn")).click();

        // click id=firstName
        driver.findElement(By.id("firstName")).click();

        // type id=firstName
        driver.findElement(By.id("firstName")).sendKeys("Marta");

        // type id=lastName
        driver.findElement(By.id("lastName")).sendKeys("Inacio");

        // type id=email
        driver.findElement(By.id("email")).sendKeys("marta@gmail.com");

        // type id=phoneNumber
        driver.findElement(By.id("phoneNumber")).sendKeys("987654321");

        // type id=postalCode
        driver.findElement(By.id("postalCode")).sendKeys("3567098");

        // type id=streetAddress
        driver.findElement(By.id("streetAddress")).sendKeys("DETI");

        // type id=city
        driver.findElement(By.id("city")).sendKeys("Averio");

        // type id=country
        driver.findElement(By.id("country")).sendKeys("Portugal");

        // click id=sex
        driver.findElement(By.id("sex")).click();

        // type id=sex
        driver.findElement(By.id("sex")).sendKeys("Female");

        // click id=birthDate
        driver.findElement(By.id("birthDate")).click();

        // type id=birthDate
        driver.findElement(By.id("birthDate")).sendKeys("2000-12-20");

        // click id=passportNumber
        driver.findElement(By.id("passportNumber")).click();

        // type id=passportNumber
        driver.findElement(By.id("passportNumber")).sendKeys("889392");

        // click id=cardNumber
        driver.findElement(By.id("cardNumber")).click();

        // type id=cardNumber
        driver.findElement(By.id("cardNumber")).sendKeys("22223111");

        // click css=.form-group:nth-child(13)
        driver.findElement(By.cssSelector(".form-group:nth-child(13)")).click();

        // click id=cardPIN
        driver.findElement(By.id("cardPIN")).click();

        // type id=cardPIN
        driver.findElement(By.id("cardPIN")).sendKeys("12332211");

        // click css=.left-side
        driver.findElement(By.cssSelector(".left-side")).click();

        // click css=.btn
        driver.findElement(By.cssSelector(".btn")).click();

        // click css=.seat-row:nth-child(8) > .seat:nth-child(5)
        driver.findElement(By.cssSelector(".seat-row:nth-child(8) > .seat:nth-child(5)")).click();

        // click css=.btn:nth-child(1)
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();

        // click css=button:nth-child(1)
        driver.findElement(By.cssSelector("button:nth-child(1)")).click();

        // click linkText=Profile
        driver.findElement(By.linkText("Profile")).click();

        // assertText css=.infoFlightReserved:nth-child(2) > .subtitleFlightReserved:nth-child(3)
        WebElement element = driver.findElement(By.cssSelector(".infoFlightReserved:nth-child(2) > .subtitleFlightReserved:nth-child(3)"));
        assertEquals("120", element.getText());
    }
}
