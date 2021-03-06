package pageobjects.transactionreport;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.IOException;

public class FeeDefaulterListBoardingWise extends GenericReports {
    @FindBy(linkText = "Fee Defaulter List Boarding wise")WebElement link;
    @FindBy(id = "Fee Defaulter List Boarding wise")WebElement frame;

    public FeeDefaulterListBoardingWise(WebDriver d) {
        page = this.getClass().getSimpleName();
        pack = gm.getPackage(this.getClass().getPackage().getName());
        file = gm.getFilePath(page, pack);
        PageFactory.initElements(d, this);
    }

    public void openFeeDefaulterListBoardingWise() throws IOException {
        ehandler.moveToElement(new UIMap().getTransactionReportMenu());
        ehandler.openFrame(new UIMap().getDefaulterReportsSubMenu(), link, frame);
    }

    @Override
    public void selectClass(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("class1"), index);
    }

    public void clickWithFine() throws IOException {
        ehandler.click(readFile.getElement("withfine"));
    }

    @Override
    public void selectToDate(String mm, String yy, String dd) throws IOException, InterruptedException {
        ehandler.selectDate(readFile.getElement("tilldate"), mm, yy, dd);
    }

    public void selectRange(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("selectrange"), index);
    }

    public void clickHeaderWithClassGroup() throws IOException {
        ehandler.click(readFile.getElement("headerwithclassgroup"));
    }

    public void enterRangeValue(String value) throws IOException {
        ehandler.clearValue(readFile.getElement("rangevalue"));
        ehandler.enterText(readFile.getElement("rangevalue"), value);
    }

    public void clickButtonhead(String value) throws IOException {
        ehandler.clickRadioButton(readFile.getElements("radiobuttongrouphead"), value);
    }

    public void selectBoarding(int b) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("boarding"), b);
    }
}