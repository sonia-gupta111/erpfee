package pageobjects.transactionreport;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.IOException;

public class DailyFeeCollection extends GenericReports {
    @FindBy(linkText = "Daily Fee Collection")
    WebElement link;
    @FindBy(id = "Daily Fee Collection")
    WebElement frame;

    public DailyFeeCollection(WebDriver d) {
        page = this.getClass().getSimpleName();
        pack = gm.getPackage(this.getClass().getPackage().getName());
        file = gm.getFilePath(page, pack);
        PageFactory.initElements(d, this);
    }

    public void openDailyFeeCollection() throws IOException {
        ehandler.moveToElement(new UIMap().getTransactionReportMenu());
        ehandler.openFrame(new UIMap().getCollectionsSubMenu(), link, frame);
    }

    private void getFeeTypeElements() throws IOException {
        element = readFile.getElement("feetype");
        clear = readFile.getElement("feetypeclear");
        values = readFile.getElement("feetypevalueslist");
        close = readFile.getElement("feetypeclose");
        message = readFile.getElement("feetypemessage");
    }

    public void validateFeeType() throws IOException {
        getFeeTypeElements();
        verify.verifyValidationOnMultiSelect(readFile.readProperty(fileUI, "feetype"));
    }

    public void selectFeeType() throws IOException {
        getFeeTypeElements();
        ehandler.selectValue();
    }

    @Override
    public void clickSettlementDate() throws IOException {
        ehandler.click(readFile.getElement("settlementdate"));
    }

    @Override
    public void clickChequeClearanceDate() throws IOException {
        ehandler.click(readFile.getElement("chequeclearancedate"));
    }
}