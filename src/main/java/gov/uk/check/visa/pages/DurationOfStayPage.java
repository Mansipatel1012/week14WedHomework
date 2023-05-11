package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
    public DurationOfStayPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='response-1']")
    WebElement moreThanSixMonths;

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//div[1]")
    WebElement lessThanSixMonths;


    public void selectLengthOfStay(String moreOrLess) {
        Reporter.log("Length of stay" + moreThanSixMonths.toString() + "<br>");
        CustomListeners.test.log(Status.PASS, "Length of stay" + moreThanSixMonths);
        switch (moreOrLess) {
            case "more":
                clickOnElement(moreThanSixMonths);
                break;
            case "less":
                clickOnElement(lessThanSixMonths);
                break;
        }


    }
}

