package pageobjects.transactionreport;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.IOException;

public class AnnualStuLedReport extends GenericReports {
    @FindBy(linkText = "Annual Stu Led Report")WebElement link;
    @FindBy(id = "Annual Stu Led Report")WebElement frame;

    public AnnualStuLedReport(WebDriver d) {
        page = this.getClass().getSimpleName();
        pack = gm.getPackage(this.getClass().getPackage().getName());
        file = gm.getFilePath(page, pack);
        PageFactory.initElements(d, this);
    }

    public void openAnnualStuLedReport() throws IOException {
        ehandler.openFrame(new UIMap().getTransactionReportMenu(), link, frame);
    }
}