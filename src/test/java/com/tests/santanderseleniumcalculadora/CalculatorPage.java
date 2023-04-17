package com.tests.santanderseleniumcalculadora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage  {
    private final WebDriver driver;

    protected record Input(WebElement element) {
        public String value() {
            return element.getAttribute("value");
        }
    }

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public Input display() {
        WebElement element = driver.findElement(By.xpath("//*[@id='display']"));
        return new Input(element);
    }

    public WebElement title() {
        return driver.findElement(By.tagName("h1"));
    }

    public WebElement description() {
        return driver.findElement(By.cssSelector("h4"));
    }

    public WebElement one() {
        return driver.findElement(By.id("one"));
    }

    public WebElement two() {
        return driver.findElement(By.id("two"));
    }

    public WebElement three() {
        return driver.findElement(By.id("three"));
    }

    public WebElement four() {
        return driver.findElement(By.id("four"));
    }

    public WebElement five() {
        return driver.findElement(By.id("five"));
    }

    public WebElement six() {
        return driver.findElement(By.id("six"));
    }

    public WebElement seven() {
        return driver.findElement(By.id("seven"));
    }

    public WebElement eight() {
        return driver.findElement(By.id("eight"));
    }

    public WebElement nine() {
        return driver.findElement(By.id("nine"));
    }

    public WebElement zero() {
        return driver.findElement(By.id("zero"));
    }

    public WebElement add() {
        return driver.findElement(By.id("add"));
    }

    public WebElement subtract() {
        return driver.findElement(By.id("subtract"));
    }

    public WebElement multiply() {
        return driver.findElement(By.id("multiply"));
    }

    public WebElement divide() {
        return driver.findElement(By.id("divide"));
    }

    public WebElement equals() {
        return driver.findElement(By.id("equals"));
    }

    public WebElement clear() {
        return driver.findElement(By.id("clear"));
    }
}
