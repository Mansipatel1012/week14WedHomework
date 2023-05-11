package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage(){
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']/div/input")
    List <WebElement> reasonForVisitList;


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueBtn;

    public void selectReasonForVisit(String reason) {
        Reporter.log("Reason For Visit" + reasonForVisitList.toString() + "<br>");
        CustomListeners.test.log(Status.PASS, "Reason for visit" + reasonForVisitList);
        for (WebElement reasonList : reasonForVisitList) {
            if (reasonList.getText().equalsIgnoreCase(reason)) {
                clickOnElement(reasonList);
            }
        }
    }
    public void clickContinueButton() {
        Reporter.log("click on continue button" + continueBtn.toString() + "<br>");
        CustomListeners.test.log(Status.PASS, "click on continue button" + continueBtn);
        clickOnElement(continueBtn);

    }
}
