package pageobjects.transactionReportPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.File;
import java.io.IOException;

public class ReceiptWiseDailyCollection extends GenericReports {
    @FindBy(linkText = "Receipt wise Daily Collection")WebElement link;
    @FindBy(id = "Receipt wise Daily Collection")WebElement frame;

    public ReceiptWiseDailyCollection(WebDriver d) throws IOException {
        f1= new File("F:\\erpfee\\configuration\\transactionReport\\ReceiptWiseDailyCollection.properties");
        PageFactory.initElements(d, this);
        page= readFile.readProperty(f1, "page");
    }

    public void openReceiptWiseDailyCollection() throws IOException {
        ehandler.moveToElement(readFile.getElement(file, "transactionreportmenu"));
        ehandler.openFrame(readFile.getElement(file, "collectionsubmenu"), link, frame);
    }

    private void getBankNameElements() throws IOException {
        element= readFile.getElement(f1, "bankname");
        clear= readFile.getElement(f1, "banknameclear");
        values= readFile.getElement(f1, "banknamevalueslist");
        close= readFile.getElement(f1, "banknameclose");
        message= readFile.getElement(f1, "banknamemessage");
    }

    public void validateBankName() throws IOException {
        getBankNameElements();
        verify.verifyValidationOnMultiSelect(element, clear, close, message, readFile.readProperty(file, "bankname"));
    }

    public void selectBankName() throws IOException {
        getBankNameElements();
        ehandler.selectValue(element, clear, values, close);
    }

    public void selectOrderBy(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement(f1, "orderby"), index);
    }

    public void clickAmalgamatedReport() throws IOException {
        ehandler.click(readFile.getElement(f1, "amalgamatedreport"));
    }
}