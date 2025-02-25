package com.automation.newati.nclex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class NCLEXTest1 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private NclexPrepTabPage nclexPrepTabPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		nclexPrepTabPage = new NclexPrepTabPage(driver);
	}

	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1078")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify NCLEX Experience Recent Activity Functionality")
	public void NewATI1078_VerifyNCLEXRecentActivity() throws Exception {
		log(logger, "NewATI1078_VerifyNCLEXRecentActivity Start");
		logger.info("NewATI1078_VerifyNCLEXRecentActivity Start");

		// Step 1 & 2
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.username"),
				PropertiesRepository.getString("newati.nclex.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Verifying NCLEX Recent Activity Section 1");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyNCLEXRecentActivity(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"),
						PropertiesRepository.getString("new.atitestig.nclex.cardback.section1.header.value")),
				"Unable to Verify NCLEX Recent Activity Section 1");

		log(logger, "Verifying NCLEX Recent Activity Section 2");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyNCLEXRecentActivity(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"),
						PropertiesRepository.getString("new.atitestig.nclex.cardback.section2.header.value")),
				"Unable to Verify NCLEX Recent Activity Section 2");

		log(logger, "Verifying NCLEX Recent Activity Section 3");
//		VerificationHandler.verifyTrue(
//				nclexPrepTabPage.verifyNCLEXRecentActivityWithModuleTest(
//						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"),
//						PropertiesRepository.getString("new.atitestig.nclex.cardback.section3.header.value")),
//				"Unable to Verify NCLEX Recent Activity Section 3");

		logger.info("NewATI1078_VerifyNCLEXRecentActivity End");
		log(logger, "NewATI1078_VerifyNCLEXRecentActivity End");
	}

	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1090")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "verify Play Next Generation NCLEX Item Type Quizzes.")
	public void NewATI1090_VerifyNCLEXQuizAssessmentName() throws Exception {
		log(logger, "NewATI1090_VerifyNCLEXQuizAssessmentName Start");
		logger.info("NewATI1090_VerifyNCLEXQuizAssessmentName Start");
		// Step 1 & 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.username"),
				PropertiesRepository.getString("newati.nclex.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 1 & 2
		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));
		// Step 1 & 2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		// Step 1 & 2
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		// Step 3
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));
		// Step 3
		log(logger, "Clicking on NCLEX Cardback");
		tutorialPage
				.clickOnNCLEXModuleButton(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 4
		log(logger, "Verifying Card back header section");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyCardBackHeaderSection(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.with.module.count")),
				"Unable to Verify Card back header section");
		// Step 4 & 5
		logger.info("Section 1");
		log(logger, "Clicking on Card back of Quiz Section 1");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.clickQuizNameInCardBack(PropertiesRepository
						.getString("new.atitestig.nclex.recent.activity.module.test.module.name.value"), 0),
				"Unable to Click on Card back of Quiz Section 1");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	

		// Step 4 & 5
		log(logger, "Verifying Quiz Name");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyQuizName(PropertiesRepository.getString("new.atitesting.assessment.name.loc.quiz.new"), 0,
						PropertiesRepository
								.getString("new.atitestig.nclex.recent.activity.module.test.module.name.value")),
				"Unable to Verify Quiz Name");
		// Step 4 & 5
		log(logger, "Clicking on Close Button");
		VerificationHandler.verifyTrue(tutorialPage.clickAssessmentCloseButton(), "Unable to Click on Close Button");
		// Step 4 & 5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Card back header section");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyCardBackHeaderSection(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.with.module.count")),
				"Unable to Verify Card back header section");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 4 & 5
		logger.info("Section 2");
		log(logger, "Clicking on Card back of Quiz Section 2");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.clickQuizNameInCardBack(PropertiesRepository
						.getString("new.atitestig.nclex.recent.activity.module.test.module.name.2.value"), 1),
				"Unable to Click on Card back of Quiz Section 1");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 4 & 5
		log(logger, "Verifying Quiz Name");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyQuizName(PropertiesRepository.getString("new.atitesting.assessment.name.loc.quiz.new"), 0,
						PropertiesRepository
								.getString("new.atitestig.nclex.recent.activity.module.test.module.name.2.value")),
				"Unable to Verify Quiz Name");
		// Step 4 & 5
		log(logger, "Clicking on Close Button");
		VerificationHandler.verifyTrue(tutorialPage.clickAssessmentCloseButton(), "Unable to Click on Close Button");
		// Step 4 & 5
		log(logger, "Verifying Card back header section");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyCardBackHeaderSection(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.with.module.count")),
				"Unable to Verify Card back header section");

		log(logger, "NewATI1090_VerifyNCLEXQuizAssessmentName End");
		logger.info("NewATI1090_VerifyNCLEXQuizAssessmentName End");

	}

	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1085")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify The NCLEX® Experience RN Tutorials in NCLEX Prep TAB")
	public void NewATI1085_VerifyNCLEXAccessedNotAccessedFunctionality() throws Exception {
		log(logger, "NewATI1085_VerifyNCLEXAccessedNotAccessedFunctionality Start");
		logger.info("NewATI1085_VerifyNCLEXAccessedNotAccessedFunctionality Start");
		// Step 1 & 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.select.instance.login.username"),
				PropertiesRepository.getString("newati.nclex.select.instance.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 1 & 2
		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));
		// Step 1 & 2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		// Step 1 & 2
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		// Step 3
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		// Step 3
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));
		// Step 3
		log(logger, "Clicking on NCLEX Cardback");
		VerificationHandler.verifyTrue(tutorialPage.clickOnNCLEXModuleButtonSelectInstance(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")), "Unable to click on Select Instance");

		log(logger, "Verifying Card Front Multiple Version Module");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardFrontModulesButton(), "Unable to verify card front muultiple version module");

		log(logger, "NewATI1085_VerifyNCLEXAccessedNotAccessedFunctionality End");
		logger.info("NewATI1085_VerifyNCLEXAccessedNotAccessedFunctionality End");
	}

}
