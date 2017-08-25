package pageObjects.transactionReportPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.File;
import java.io.IOException;

public class YearlyCollectionReport extends GenericReports {
    @FindBy(linkText = "Yearly Collection Report")private WebElement link;
    @FindBy(id = "Yearly Collection Report")private WebElement frame;

    public YearlyCollectionReport(WebDriver d) throws IOException {
        f1= new File("F:\\erpfee\\configuration\\transactionReport\\YearlyCollectionReport.properties");
        PageFactory.initElements(d, this);
        page= readFile.readProperty(f1, "page");
    }

    public void openYearlyCollectionReport() throws IOException {
        ehandler.moveToElement(readFile.getElement(file, "transactionreportmenu"));
        ehandler.openFrame(readFile.getElement(file, "collectionsubmenu"), link, frame);
    }

    public void selectSession(String sess) throws IOException {
        ehandler.selectByVisibleText(readFile.getElement(f1, "session"), sess);
    }

    public void validateSession() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(f1, "sessionmessage"), readFile.getElement(f1, "sessionmsg"));
    }

    public void validateBankName() throws IOException {
        WebElement bname= readFile.getElement(f1, "bankname");
        clear= readFile.getElement(f1, "banknameclear");
        close= readFile.getElement(f1, "banknameclose");
        message= readFile.getElement(f1, "banknamemessage");
        verify.verifyValidationOnMultiSelect(bname, clear, close, message, readFile.readProperty(file, "bankname"));
    }
}