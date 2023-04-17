package com.tests.santanderseleniumcalculadora;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest extends Locators {

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
        assertEquals("Calculadora", $tagName("h1").getText());
    }

    @Test
    void PageDescription() {
        String expected = "Valide as operações básicas e utilize no mínimo 3 locators diferentes.";
        assertEquals(expected, $x("//*[@id='display']").getText());
    }

    @Test
    void addNumbersToDisplay() {
        $id("one").click();
        $id("two").click();
        $id("three").click();
        $id("four").click();
        $id("five").click();
        $id("six").click();
        $id("seven").click();
        $id("eight").click();
        $id("nine").click();
        $id("zero").click();

        assertEquals("1234567890", $tagName("input").getAttribute("value"));
    }

    @Test
    void justOneOperatorSameTime() {
        $id("one").click();

        $id("add").click();
        $id("sub").click();
        $id("mul").click();
        $id("div").click();

        assertEquals("1234567890", $tagName("input").getAttribute("value"));
    }
}
