package pageobjects.reports;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.IOException;

public class EwsClassWiseStrengthReport extends GenericReports {
    @FindBy(xpath = "//*[contains(text(), 'Ews ClassWise Strength Report')]")
    WebElement link;
    @FindBy(id = "Ews ClassWise Strength Report")
    WebElement frame;

    public EwsClassWiseStrengthReport(WebDriver d) {
        page = this.getClass().getSimpleName();
        pack = gm.getPackage(this.getClass().getPackage().getName());
        file = gm.getFilePath(page, pack);
        PageFactory.initElements(d, this);
    }

    public void openEwsClassWiseStrengthReport() throws IOException {
        ehandler.moveToElement(new UIMap().getReportsMenu());
        ehandler.openFrame(new UIMap().getStudentStrengthSubMenu(), link, frame);
    }
}