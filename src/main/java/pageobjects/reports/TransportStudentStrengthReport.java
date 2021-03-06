package pageobjects.reports;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.IOException;

public class TransportStudentStrengthReport extends GenericReports {
    @FindBy(linkText = "Transport Student Strength Report")
    private WebElement link;
    @FindBy(id = "Transport Student Strength Report")
    private WebElement frame;

    public TransportStudentStrengthReport(WebDriver d) {
        page = this.getClass().getSimpleName();
        pack = gm.getPackage(this.getClass().getPackage().getName());
        file = gm.getFilePath(page, pack);
        PageFactory.initElements(d, this);
    }

    public void openTransportStudentStrengthReport() throws IOException {
        ehandler.moveToElement(new UIMap().getReportsMenu());
        ehandler.openFrame(new UIMap().getStudentStrengthSubMenu(), link, frame);
    }

    public void selectRoute(int route) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("route"), route);
    }
}