package com.tests.santanderseleniumcalculadora;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private static WebDriver driver;
    private final CalculatorPage page = new CalculatorPage(driver);

    @BeforeAll
    static void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://igorsmasc.github.io/calculadora_atividade_selenium/");
    }

    @AfterEach
    void reloadPage() {
        driver.navigate().refresh();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void title() {
        assertEquals("Calculadora", driver.getTitle());
    }

    @Test
    void PageTitle() {
        assertEquals("Calculadora", page.title().getText());
    }

    @Test
    void PageDescription() {
        String expected = "Valide as operações básicas e utilize no mínimo 3 locators diferentes.";
        assertEquals(expected, page.description().getText());
    }

    @Test
    void addNumbersToDisplay() {
        page.seven().click();
        page.eight().click();
        page.nine().click();
        page.four().click();
        page.five().click();
        page.six().click();
        page.one().click();
        page.two().click();
        page.three().click();
        page.zero().click();

        assertEquals("7894561230", page.display().value());
    }

    @Test
    void justOneOperatorSameTime() {
        page.seven().click();
        page.add().click();
        page.multiply().click();
        page.eight().click();

        assertEquals("7*8", page.display().value());

        page.equals().click();

        assertEquals("56", page.display().value());
    }

    @Test
    void buttonsText() {
        assertEquals("1", page.one().getText());
        assertEquals("2", page.two().getText());
        assertEquals("3", page.three().getText());
        assertEquals("4", page.four().getText());
        assertEquals("5", page.five().getText());
        assertEquals("6", page.six().getText());
        assertEquals("7", page.seven().getText());
        assertEquals("8", page.eight().getText());
        assertEquals("9", page.nine().getText());
        assertEquals("0", page.zero().getText());
        assertEquals("+", page.add().getText());
        assertEquals("-", page.subtract().getText());
        assertEquals("*", page.multiply().getText());
        assertEquals("/", page.divide().getText());
        assertEquals("=", page.equals().getText());
        assertEquals("C", page.clear().getText());
    }

    @Test
    void addNumbers() {
        page.three().click();
        page.add().click();
        page.five().click();

        assertEquals("3+5", page.display().value());

        page.equals().click();

        assertEquals("8", page.display().value());
    }

    @Test
    void subtractNumbers() {
        page.five().click();
        page.subtract().click();
        page.three().click();

        assertEquals("5-3", page.display().value());

        page.equals().click();

        assertEquals("2", page.display().value());
    }

    @Test
    void multiplyNumbers() {
        page.five().click();
        page.multiply().click();
        page.three().click();

        assertEquals("5*3", page.display().value());

        page.equals().click();

        assertEquals("15", page.display().value());
    }

    @Test
    void divideNumbers() {
        page.five().click();
        page.divide().click();
        page.three().click();

        assertEquals("5/3", page.display().value());

        page.equals().click();

        assertEquals("1.6666666666666667", page.display().value());
    }

    @Test
    void divideByZero() {
        page.five().click();
        page.divide().click();
        page.zero().click();

        assertEquals("5/0", page.display().value());

        page.equals().click();

        assertEquals("Infinity", page.display().value());
    }

    @Test
    void clearDisplay() {
        page.five().click();
        page.divide().click();
        page.zero().click();

        assertEquals("5/0", page.display().value());

        page.clear().click();
        
        assertEquals("", page.display().value());
    }

    @Test
    void multipleOperations() {
        page.five().click();
        page.add().click();
        page.three().click();
        page.multiply().click();
        page.five().click();
        page.subtract().click();
        page.four().click();
        page.divide().click();
        page.two().click();

        assertEquals("5+3*5-4/2", page.display().value());

        page.equals().click();

        assertEquals("18", page.display().value());
    }

    @Test
    void notSecondNumber() {
        page.five().click();
        page.multiply().click();

        assertEquals("5*", page.display().value());

        page.equals().click();

        assertEquals("5*", page.display().value());
    }
}
