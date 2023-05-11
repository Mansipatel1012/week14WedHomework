package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {
    public SelectNationalityPage() {
        PageFactory.initElements(driver, this);

    }

    @CacheLookup
    @FindBy(css = "#response")
    WebElement nationalityDropDownList;
    //By nationalityDropDownList = By.xpath("//select[@id='response']/option");
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;


    public void selectNationality(String nationality) {
        //clickOnElement(nationalityDropDownList);
        selectByVisibleTextFromDropDown(nationalityDropDownList,nationality);
        // selectByValueFromDropDown(nationalityDropDownList,nationality);
        Reporter.log("Select nationality" + nationalityDropDownList.toString() + "<br>");
        CustomListeners.test.log(Status.PASS, "select nationality" + nationality);

    }

    public void clickContinueButton() {
        Reporter.log("click on continue button" + continueButton.toString() + "<br>");
        CustomListeners.test.log(Status.PASS, "click on continue button" + continueButton);
        clickOnElement(continueButton);

    }
}