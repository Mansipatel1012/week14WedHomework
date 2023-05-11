package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends BaseTest {
    StartPage startPage;
    WorkTypePage workTypePage;
    SelectNationalityPage selectNationalityPage;
    ResultPage resultPage;
    ReasonForTravelPage reasonForTravelPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    DurationOfStayPage durationOfStayPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        startPage = new StartPage();
        workTypePage = new WorkTypePage();
        resultPage = new ResultPage();
        reasonForTravelPage = new ReasonForTravelPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        durationOfStayPage = new DurationOfStayPage();

    }

    @Test//(groups = {"sanity", "regression"})
    public void anAustralianCominToUKForTourism() throws InterruptedException {
        Thread.sleep(3000);
        // Click on start button
        startPage.clickStartNow();
        Thread.sleep(5000);
        //Select a Nationality 'Australia'
       // selectNationalityPage.selectNationality("Australia");
        //Click on Continue button
        selectNationalityPage.clickContinueButton();
        //Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");
        //Click on Continue button
        reasonForTravelPage.clickContinueButton();
        //verify result 'You will not need a visa to come to the UK'
        String actualMessage = resultPage.getResultMessage();
        String expectedMessage = "You will not need a visa to come to the UK";
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Test//(groups = {"sanity", "smoke", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() throws InterruptedException {
        Thread.sleep(3000);
        // Click on start button
        startPage.clickStartNow();
        Thread.sleep(2000);
        //Select a Nationality 'Chile'
        selectNationalityPage.selectNationality("chile");
        // Click on Continue button
        selectNationalityPage.clickContinueButton();
        // Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        //Click on Continue button
        selectNationalityPage.clickContinueButton();
        //Select intendent to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        //Click on Continue button
        selectNationalityPage.clickContinueButton();
        //Select have planning to work for 'Health and care professional'
        workTypePage.selectJobType("Health and care professional");
        //Click on Continue button
        selectNationalityPage.clickContinueButton();
        //verify result 'You need a visa to work in health and care'
        String actualMessage = resultPage.getResultMessage();
        String expectedMessage = "You need a visa to work in health and care";
        Assert.assertEquals(expectedMessage, actualMessage);

    }


    @Test//(groups = {"Smoke", "regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() throws InterruptedException {
        //Click on start button
        startPage.clickStartNow();
        Thread.sleep(3000);
        // Select a Nationality 'Colombia'
        selectNationalityPage.selectNationality("colombia");
        //Click on Continue button
        selectNationalityPage.clickContinueButton();
        //Select reason 'Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        //Click on Continue button
        selectNationalityPage.clickContinueButton();
        //Select state My partner of family member have uk immigration status 'yes'
        familyImmigrationStatusPage.selectImmigrationStatus("yes");
        //Click on Continue button
        //verify result 'You’ll need a visa to join your family or partner in the UK'
        String actualMessage = resultPage.getResultMessage();
        String expectedMessage = "You’ll need a visa to join your family or partner in the UK";
        Assert.assertEquals(expectedMessage, actualMessage);


    }
}
