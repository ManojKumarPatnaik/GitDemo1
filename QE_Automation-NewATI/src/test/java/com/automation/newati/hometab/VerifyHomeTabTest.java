package com.automation.newati.hometab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifyHomeTabTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.namewithrecentactivity58"), PropertiesRepository.getString("newati.login.passwordofuserwithrecent"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@TestAnnotations(testID="NewATI-494")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Page Footer- Update Copyright to 2017::Home Tab")
	public void NewATI494_VerifyPageFooter() throws Exception {
		log(logger, "NewATI494_VerifyPageFooter Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Footer");
		VerificationHandler.verifyTrue(homePage.verifyFooter(), "Unable to verify Footer message");
		log(logger, "NewATI494_VerifyPageFooter Start");
	}
	
	@TestAnnotations(testID="NewATI-7")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Home Tab UI Element verification::Home Tab")
	public void NewATI7_verifyHomeTabUIElements() throws Exception {
		
		log(logger, "NewATI7_verifyHomeTabUIElements Start");
		
		log(logger, "verify logo image");
		boolean isLogoDisplayed=homePage.verifyLogo("new-atitesting.logo.loc");
		VerificationHandler.verifyTrue(isLogoDisplayed, "Logo is not displayed");
		log(logger, "verify logo image");
		log(logger, "verify logo image");
		log(logger, "verify home tab upper links");
		boolean status=homePage.verifyHomeTabTopLinks();
		VerificationHandler.verifyTrue(status, "home tab upper links are not displayed");
		
		log(logger, "verify home tab links");
		boolean status0=homePage.verifyHomeTabLinks();
		VerificationHandler.verifyTrue(status0, "home tab names are not displayed");
		
		log(logger, "verify home tab bottom links");
		boolean status1=homePage.verifyHomeTabBottomLinks();
		VerificationHandler.verifyTrue(status1, "home tab bottom links are not displayed");
		
		log(logger, "NewATI7_verifyHomeTabUIElements End");
		
	}
	@TestAnnotations(testID="NewATI-107")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Verify the functionality of 'Privacy Policy' footer link.::LoginPage")
	public void NewATI107_verifyPrivacyPolicyLink() throws Exception {
		logger.info("NewATI107_verifyPrivacyPolicyLink Starts");
		
		log(logger, "verify home tab bottom links");
		boolean status1=homePage.verifyHomeTabBottomLinks();
		VerificationHandler.verifyTrue(status1, "Home tab bottom links are not displayed");
		
		log(logger,"click on privacy policy button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.privacyPolicyFooterLinkLoc"));
		log(logger,"privacy policy link is clicked ");
		
		log(logger, "Verifying if the privacy policy link is opened");
		VerificationHandler.verifyTrue(homePage.verifyPrivacyPolicyPage(), "Privacy policy page is not opened.");
		
		logger.info("NewATI107_verifyPrivacyPolicyLink Ends");
	}
	
	@TestAnnotations(testID="NewATI-11")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verifying the navigation's of all Tabs , SubTabs and Links::General")
	public void NewATI11_verifyNavigatinOfAllTabs() throws Exception {
		
		log(logger, "NewATI11_verifyNavigatinOfAllTabs Start");
		
		log(logger, "verify logo image");
		boolean isLogoDisplayed=homePage.verifyLogo("new-atitesting.logo.loc");
		VerificationHandler.verifyTrue(isLogoDisplayed, "Logo is not displayed");
		
		log(logger, "verify home tab upper links");
		boolean status=homePage.verifyHomeTabTopLinks();
		VerificationHandler.verifyTrue(status, "home tab upper links are not displayed");
		
		log(logger, "verify home tab links");
		boolean status0=homePage.verifyHomeTabLinks();
		VerificationHandler.verifyTrue(status0, "home tab names are not displayed");
		
		log(logger, "verify home tab bottom links");
		boolean status1=homePage.verifyHomeTabBottomLinks();
		VerificationHandler.verifyTrue(status1, "home tab bottom links are not displayed");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean resutlt=tutorialPage.isElementDisplayed("new-atitesting.refresh.proctors.loc");
		VerificationHandler.verifyTrue(resutlt);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.improve"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Click on focused review product");
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
//		
//		log(logger, "Select Tutorial from the dropdown");
//		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
//		
		log(logger, "Clicking Apply Tab");
		homePage.clickSubTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean resutlt1=tutorialPage.isElementDisplayed("new-atitesting.applytab.disable.product.checkbox");
		VerificationHandler.verifyTrue(resutlt1);

		log(logger,"click on MY Results tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"click on help tab");
		homePage.clickTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		
		log(logger, "NewATI11_verifyNavigatinOfAllTabs End");
		
	}
	
	@TestAnnotations(testID="NewATI-2")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Verify Online Store link for the users.")
	public void NewATI2_verifyOnlineStoreLinkForTheUsers() throws Exception {
		logger.info("NewATI2_verifyOnlineStoreLinkForTheUsers Starts");
		
		log(logger,"verifying links in the home tab");
		String window=driver.getWindowHandle();
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying  window size");
		VerificationHandler.verifyTrue(tutorialPage.verifyTabSize());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"close current window");
		tutorialPage.closeCurrentWindow(window);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying  window size");
		VerificationHandler.verifyTrue(tutorialPage.verifyTabSize());
		
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"close current window");
		tutorialPage.closeCurrentWindow(window);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on MY Results tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying  window size");
		VerificationHandler.verifyTrue(tutorialPage.verifyTabSize());
		
		log(logger,"close current window");
		tutorialPage.closeCurrentWindow(window);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"click on help tab");
		homePage.clickTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying  window size");
		VerificationHandler.verifyTrue(tutorialPage.verifyTabSize());
		
		log(logger,"close current window");
		tutorialPage.closeCurrentWindow(window);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying links in the home tab");
		tutorialPage.clickButtonFromList("new-atitesting.onlinestore.link", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying  window size");
		VerificationHandler.verifyTrue(tutorialPage.verifyTabSize());
		
		log(logger,"verifying  online store url");
		VerificationHandler.verifyTrue(tutorialPage.verifyOnlineStoreUrl());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean resutlt=tutorialPage.isElementDisplayed("new-atitesting.online.store.go.button");
		VerificationHandler.verifyTrue(resutlt);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean resutlt2=tutorialPage.isElementDisplayed("new-atitesting.online.store.search.button");
		VerificationHandler.verifyTrue(resutlt2);
		
		logger.info("NewATI2_verifyOnlineStoreLinkForTheUsers Ends");
	}
	
}
