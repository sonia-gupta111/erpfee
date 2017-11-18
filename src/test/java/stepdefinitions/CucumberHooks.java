package stepdefinitions;

import automationFramework.supportMethods.ReadFile;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import supportclasses.GenericBaseClass;
import utilities.GenericUtility;
import webdriver.DriverMethods;

import static webdriver.AppDriver.driver;
import java.io.File;
import java.io.IOException;

import static webdriver.AppDriver.getCurrentDriver;

public class CucumberHooks extends GenericBaseClass {
  private DriverMethods dm= new DriverMethods();
  private File file= new File("F:\\erpfee\\configuration\\GenericConfig.properties");
  private GenericUtility utility= new GenericUtility();

  @Before
  public void getScenario(Scenario sc) {
      scenario= sc.getSourceTagNames();
      System.out.println("Scenario is: "+scenario);
  }

  @Before
  public void launchBrowser() throws IOException {
      ReadFile readConfig= new ReadFile();
      System.setProperty(readConfig.readProperty(file,"driver"),readConfig.readProperty(file,"driverPath"));
      driver= getCurrentDriver();
      dm.maximizeWindow();
  }

  @After
  public void afterScenario(Scenario scenario) throws IOException {
      if (scenario.isFailed()){
        utility.takeScreenshot();
      }
  }

  @After
  public void closeBrowser()
  {
      dm.waitImplicitly(1000);
      //driver.quit();
      driver= null;
  }
}