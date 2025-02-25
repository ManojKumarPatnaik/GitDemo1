package com.automation.newati.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class DosageTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage myReportPage;
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	
	String downloadFilepath = null;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage = new MyReportPage(driver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.user.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}


	
	@TestAnnotations(testID="NewATI-1235")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-1235:Verify the elements displayed on the card front")
	public void NewATI1235_VerifyElementsDisplayedOnTheCardFront() throws Exception {
		log(logger, "NewATI1235_VerifyElementsDisplayedOnTheCardFront Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 Start
//		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.name"));
		log(logger, "Clicking Module by Name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5 Start
//		tutorialPage.clickBeginTestButtonInPharmacologyCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.module.name"));
		log(logger, "Clicking Begin Test ");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying new ati logo");
//		boolean flag = tutorialPage.checkLogo(PropertiesRepository.getString("new-atitesting.loginpage.newati.image.loc"));
//		VerificationHandler.verifyTrue(flag, "Logo is not displayed");
		
		log(logger, "verifying close button");
//		boolean closeButtonStatus = tutorialPage.verifyCloseButton();
//		VerificationHandler.verifyTrue(closeButtonStatus, "close button is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying Question label text");
//		boolean questionLabelText=tutorialPage.verifyQuestionLableText();
//		VerificationHandler.verifyTrue(questionLabelText, "question label text is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking assessment for tutorial");
//		learnTabPage.takeTestPharmacologyAndNurseLogic(false, false, true, false);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "verifying IPP page");
//		myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
//		boolean result=myReportPage.verifyIPPpageObjects();
//		VerificationHandler.verifyTrue(result, "IPP page is not displayed");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "verifying close button");
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "click on cardback close button");
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		boolean result1 =tutorialPage.verifySubTabs();
//		VerificationHandler.verifyTrue(result1, "home page sub tabs are not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Clicking on Home Tab");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.clickTab(0);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		//verify recent activity
//		
//		log(logger, "Verifying pharmacology on test in Recent Activity");
//		homePage.verifyAndClickRecentActivity(
//				PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.pharmacologymadeeasy.3.0.loc"), "Flashcard",
//				"Pharmacology Made easy 3.0", "In Progress");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger,"verify Begin case is replaced with Continue Case");
//		String continueCase=textHandler.getText(PropertiesRepository.getString("new-atitesting.Learntab.tutorial.card.front.module.status"));
//		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "NewATI1235_VerifyElementsDisplayedOnTheCardFront End");
		
	}
	@TestAnnotations(testID="NewATI-1237")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-1237:Verify Dosage 2.0 Product with Single Instance.")
	public void NewATI1237_VerifyDosageProductSingleInstance() throws Exception {
		log(logger, "NewATI1237_VerifyDosageProductSingleInstance Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 Start
//		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.name"));
		log(logger, "Clicking Module by Name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5 Start
//		tutorialPage.clickBeginTestButtonInPharmacologyCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.module.name"));
		log(logger, "Clicking Begin Test ");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying new ati logo");
//		boolean flag = tutorialPage.checkLogo(PropertiesRepository.getString("new-atitesting.loginpage.newati.image.loc"));
//		VerificationHandler.verifyTrue(flag, "Logo is not displayed");
		
		log(logger, "verifying close button");
//		boolean closeButtonStatus = tutorialPage.verifyCloseButton();
//		VerificationHandler.verifyTrue(closeButtonStatus, "close button is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying Question label text");
//		boolean questionLabelText=tutorialPage.verifyQuestionLableText();
//		VerificationHandler.verifyTrue(questionLabelText, "question label text is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking assessment for tutorial");
//		learnTabPage.takeTestPharmacologyAndNurseLogic(false, false, true, false);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "verifying IPP page");
//		myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
//		boolean result=myReportPage.verifyIPPpageObjects();
//		VerificationHandler.verifyTrue(result, "IPP page is not displayed");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "verifying close button");
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "click on cardback close button");
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		boolean result1 =tutorialPage.verifySubTabs();
//		VerificationHandler.verifyTrue(result1, "home page sub tabs are not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Clicking on Home Tab");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.clickTab(0);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		//verify recent activity
//		
//		log(logger, "Verifying pharmacology on test in Recent Activity");
//		homePage.verifyAndClickRecentActivity(
//				PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.pharmacologymadeeasy.3.0.loc"), "Flashcard",
//				"Pharmacology Made easy 3.0", "In Progress");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger,"verify Begin case is replaced with Continue Case");
//		String continueCase=textHandler.getText(PropertiesRepository.getString("new-atitesting.Learntab.tutorial.card.front.module.status"));
//		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "NewATI1237_VerifyDosageProductSingleInstance End");
		
	}
}
