package pageobjects.reports;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.IOException;

public class StudentRegisterDateWiseReport extends GenericReports {
    @FindBy(linkText = "Student Register Date Wise Report")private WebElement link;
    @FindBy(id="Student Register Date Wise Report")private WebElement frame;

    public StudentRegisterDateWiseReport(WebDriver d) {
        page = this.getClass().getSimpleName();
        pack = gm.getPackage(this.getClass().getPackage().getName());
        file = gm.getFilePath(page, pack);
        PageFactory.initElements(d, this);
    }

    public void openStudentRegisterDateWiseReport() throws IOException {
        ehandler.openFrame(new UIMap().getReportsMenu(), link, frame);
    }

    @Override
    public void selectFromDate(String mm, String yy, String dd) throws IOException, InterruptedException {
        ehandler.selectDate(readFile.getElement("fromdate"), mm, yy, dd);
    }

    @Override
    public void selectToDate(String mm, String yy, String dd) throws IOException, InterruptedException {
        ehandler.selectDate(readFile.getElement("todate"), mm, yy, dd);
    }
}
