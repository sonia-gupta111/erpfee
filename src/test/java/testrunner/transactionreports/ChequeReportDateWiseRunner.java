package testrunner.transactionreports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"featurefiles/transactionreports/ChequeReportDateWise"}
        ,glue= {"stepdefinitions"}
        ,monochrome=true
        ,plugin= {"pretty","html:target/cucumber_html_report",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml"}
        ,tags= {"@scenario4"}
)
public class ChequeReportDateWiseRunner {
}