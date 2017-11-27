package pageobjects.transactionreport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.File;
import java.io.IOException;

public class FeesConcession extends GenericReports {
    @FindBy(linkText = "Fees Concession")WebElement link;
    @FindBy(id = "Fees Concession")WebElement frame;

    public FeesConcession(WebDriver d) throws IOException {
        f1= new File("F:\\erpfee\\configuration\\transactionReport\\FeesConcession.properties");
        PageFactory.initElements(d, this);
        page= readFile.readProperty(f1, "page");
    }

    public void openFeesConcession() throws IOException {
        ehandler.openFrame(readFile.getElement(file, "transactionreportmenu"), link, frame);
    }

    public void getConcessionElements() throws IOException {
        element= readFile.getElement(f1, "concession");
        clear= readFile.getElement(f1, "concessionclear");
        values= readFile.getElement(f1, "concessionvalueslist");
        close= readFile.getElement(f1, "concessionclose");
        message= readFile.getElement(f1, "concessionmessage");
    }

    public void validateConcession() throws IOException {
        getConcessionElements();
        verify.verifyValidationOnMultiSelect(element, clear, close, message, readFile.readProperty(file, "concession"));
    }

    public void selectConcession() throws IOException {
        getConcessionElements();
        ehandler.selectValue(element, clear, values, close);
    }

    public void validateTillDate() throws IOException {
        verify.verifyValidationOnMultiSelect(readFile.getElement(f1, "tilldate"), clr, readFile.getElement(f1, "tilldatemessage"), readFile.readProperty(file, "tilldate"));
    }

    public void selectToDate(String mm, String yy, String dd) throws IOException, InterruptedException {
        ehandler.selectDate(readFile.getElement(f1, "tilldate"), mm, yy, dd);
    }

    public void clickPaidConcession() throws IOException {
        ehandler.click(readFile.getElement(f1, "paidconcession"));
    }

    public void clickEntryTime() throws IOException {
        ehandler.click(readFile.getElement(f1, "entrytime"));
    }

    public void clickAssigned() throws IOException {
        ehandler.click(readFile.getElement(f1, "assigned"));
    }
}