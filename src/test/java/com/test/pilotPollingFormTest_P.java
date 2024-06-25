package com.test;

import com.baseclass.baseClass;
import com.pageobject.loginPage;
import com.pageobject.pilotPollingFormPage;
import com.pageobject.homePage;
import com.utilities.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Test class to execute pilot polling form related tests.
 */
public class pilotPollingFormTest_P extends baseClass {
    loginPage login;

    /**
     * Constructor to initialize BaseUtils.
     *
     * @throws FileNotFoundException If the properties file is not found.
     */
    public pilotPollingFormTest_P() throws FileNotFoundException {
    }
    /**
     * Test case to perform login.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    @Test(priority = 1, enabled = true)
    public void loginToSwapaApp() throws IOException {
        // Instantiate LoginPage
       this.login = new loginPage(driver);
        // Perform login
        login.ClickMainLogin();
        login.setUsername(properties.getDataFromPropertyFile("username"));
        login.setPassword(properties.getDataFromPropertyFile("password"));
        login.ClickLoginbutton();

    }
    /**
     * Test case to navigate to the pilot polling form.
     */
    @Test(priority = 2, enabled = true)
    public void navigateToPilotPoling() throws IOException {
        // Instantiate swapaHomePage
        homePage pilot = new homePage(driver);
        // Click on Resources
        pilot.clickResources();
        // Click on SRC Forms
        pilot.clickSRC_Forms();
        // Click on Pilot Polling Form
        pilot.clickPilotPollingForm();
    }
    /**
     * Test case to answer the questions in the pilot polling form.
     *
     * @throws InterruptedException If the thread is interrupted.
     * @throws IOException          If there is an error reading from the properties file.
     */
    @Test(priority = 3, enabled = true)
    public void fillPilotPollingForm() throws InterruptedException, IOException {
        // Instantiate PilotPollingFormPage and PageScrolling
        pilotPollingFormPage answer = new pilotPollingFormPage(driver);
        pageScrollingUtility scroll = new pageScrollingUtility(driver);
        // Answer questions and scroll as necessary
        answer.selectQuestion1();
        answer.selectQuestion2();

        scroll.setScroll300();
        answer.selectQuestion3();
        answer.selectQuestion4();

        scroll.setScroll300();
        answer.selectQuestion5();
        answer.selectQuestion6();

        scroll.setScroll300();
        answer.selectQuestion7();
        answer.selectQuestion8();

        scroll.setScroll300();
        answer.selectQuestion9();
        answer.selectQuestion10();

        scroll.setScroll300();
        answer.selectQuestion11();
        answer.SetSubmitButton();

    }

}
