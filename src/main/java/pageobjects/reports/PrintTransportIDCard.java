package pageobjects.reports;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.IOException;

public class PrintTransportIDCard extends GenericReports {
    @FindBy(xpath = "//*[contains(text(), 'Print TransportId Card')]")
    WebElement link;
    @FindBy(id = "Print TransportId Card")
    WebElement frame;

    public PrintTransportIDCard(WebDriver d) {
        page = this.getClass().getSimpleName();
        pack = gm.getPackage(this.getClass().getPackage().getName());
        file = gm.getFilePath(page, pack);
        PageFactory.initElements(d, this);
    }

    public void openPrintTransportIDCard() throws IOException {
        ehandler.moveToElement(new UIMap().getReportsMenu());
        ehandler.openFrame(new UIMap().getTransportReportSubMenu(), link, frame);
    }

    public void searchStudent() throws IOException, InterruptedException {
        ehandler.enterText(readFile.getElement("student"), "a");
        Thread.sleep(500);
        ehandler.pressDownArrow(readFile.getElement("student"));
        ehandler.pressEnter(readFile.getElement("student"));
        ehandler.pressEnter(readFile.getElement("student"));
    }
}