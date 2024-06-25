package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Utility class for scrolling the web page using JavaScriptExecutor.
 */
public class pageScrollingUtility {

    public WebDriver driver;
    public JavascriptExecutor scroll;
    /**
     * Constructor to initialize WebDriver and JavaScriptExecutor.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public pageScrollingUtility(WebDriver driver) {
        this.driver = driver;
        this.scroll = (JavascriptExecutor) driver;

    }

    /**
     * Scrolls the page vertically to a position of 600 pixels from the top.
     */
    public void setScroll600() {
        scroll.executeScript("window.scrollTo(0,600)");
    }
    /**
     * Scrolls the page vertically to the end.
     */
    public void setScrollToEnd() {
        scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    /**
     * Scrolls the page vertically to a position of 300 pixels from the top.
     */
    public void setScroll300() {
        scroll.executeScript("window.scrollTo(0,300)");
    }
    /**
     * Scrolls the page to the top.
     */
    public void scrollToTop() {
        scroll.executeScript("window.scrollTo(0, 0)");
    }
}
