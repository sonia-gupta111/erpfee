package pageobjects.reports;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericReports;

import java.io.IOException;

public class ClassWiseMarkList extends GenericReports {
    @FindBy(linkText = "Class Wise Mark List")private WebElement link;
    @FindBy(id="Class Wise Mark List")private WebElement frame;

    public ClassWiseMarkList(WebDriver d) {
        page = this.getClass().getSimpleName();
        pack = gm.getPackage(this.getClass().getPackage().getName());
        file = gm.getFilePath(page, pack);
        PageFactory.initElements(d, this);
    }

    public void openClassWiseMarkList() throws IOException {
        ehandler.openFrame(new UIMap().getReportsMenu(), link, frame);
    }

    public void selectOrderBy(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("orderby"), index);
    }
}
