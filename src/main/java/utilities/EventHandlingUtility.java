package utilities;

import automationFramework.supportMethods.ReadFile;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import webdriver.DriverMethods;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static webdriver.AppDriver.driver;

public class EventHandlingUtility {
    private File file= new File("F:\\erpfee\\configuration\\UIMap.properties");
    private ReadFile readFile= new ReadFile();
    private DriverMethods dm= new DriverMethods();
    private String value="";

    public void openFrame(WebElement menu, WebElement link, WebElement frame){
      moveToElement(menu);
      //moveToElement(link);
      clickMenuItem(link);
      //System.out.println("Size: "+driver.findElements(By.tagName("iframe")).size());
      switchToFrame(frame);
    }

    public void moveToElement(WebElement menuItem){
      new Actions(driver).moveToElement(menuItem).build().perform();
    }

    private void clickMenuItem(WebElement link){
        new Actions(driver).moveToElement(link).click().perform();
    }

    private void switchToFrame(WebElement frame){
      driver.switchTo().frame(frame);
    }

    public void click(WebElement element){
      element.click();
    }

    public void clearValue(WebElement element){
        element.clear();
    }

    public void enterText(WebElement textfield, String text){
      textfield.sendKeys(text);
    }

    void pressEnter(WebElement textfield){
        textfield.sendKeys(Keys.ENTER);
    }

    public void enterText(WebElement textfield, int n) {
      for (int i=0; i<n; i++) {
          textfield.sendKeys("a");
          value= value+"a";
      }
    }

    public void verifyString(){
      Assert.assertTrue(driver.getPageSource().contains(value));
         System.out.println("Value Saved");
    }

//select first record in table
    void selectRecord(WebElement table, WebElement select){
     List<WebElement> cells=table.findElements(By.tagName("td"));
     if (cells.size()>1){
         for (WebElement cell:cells) {
             select.click();
             break;
         }
     }else
         System.out.println("No Record Found");
    }

//click particular cell of table
    private void selectValueFromTable(WebElement table, String value) throws IOException {
      List<WebElement> cells=readFile.getElements(file, "cell");
      for(WebElement cell: cells) {
          if (cell.getText().equals(value)){
            //System.out.println("cell value"+cell.getText());
            cell.click();
            break;
          }
      }
    }

    public void selectByVisibleText(WebElement element, String text) throws InterruptedException {
      new Select(element).selectByVisibleText(text);
      Thread.sleep(100);
    }

    public void selectByIndex(WebElement element, int index) throws InterruptedException {
      new Select(element).selectByIndex(index);
      Thread.sleep(100);
    }

    public void selectDate(WebElement date, String mm, String yy, String dd) throws IOException, InterruptedException {
      click(date);
      dm.waitUntil((readFile.getElement(file,"monthpicker")),20);
      readFile.getElement(file,"monthpicker");
      dm.waitUntil(readFile.getElement(file,"monthpicker"),200);
      selectByVisibleText(readFile.getElement(file,"monthpicker"), mm);
      dm.waitUntil(readFile.getElement(file,"yearpicker"),20);
      selectByVisibleText(readFile.getElement(file,"yearpicker"), yy);
      dm.waitUntil(readFile.getElement(file,"daypicker"),200);
      selectValueFromTable(readFile.getElement(file,"daypicker"), dd);
      Thread.sleep(500);
    }

//select 1st value in multiselect list
    public void selectValue(WebElement element, WebElement clear, WebElement values, WebElement close) throws IOException {
        click(element);
        click(clear);
        List<WebElement> options = readFile.getElements(file, values, "tablelist");
        if (options.isEmpty())
            System.out.println("No Value Present");
        else
            click(options.get(0));
        click(close);
    }

    void selectValue(WebElement element, WebElement clear, WebElement values, WebElement close, WebElement div) throws IOException, InterruptedException {
        click(element);
        click(clear);
        if (!div.getAttribute("style").contains("block")) {
            click(element);
        }
        List<WebElement> options = readFile.getElements(file, values, "tablelist");
        if (options.isEmpty())
            System.out.println("No Value Present");
        else
            click(options.get(0));
        click(close);
    }

    public void getList(List<WebElement>elements){
        HashMap<String, Integer> radioList= new HashMap<String, Integer>();
        for (WebElement emt: elements){
            String id= emt.getAttribute("id");

            System.out.println(emt.getText());
        }
    }

    public void clickRadioButton(List<WebElement>elements, String value){
        for (WebElement element: elements){
            if (element.getAttribute("value").equals(value))
                element.click();
        }
    }
}