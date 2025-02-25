package com.automation.newati.student.engagement.New;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.faculty.pages.PulseLandingPage;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class LearnTabTutorialCardBackTest2 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private PulseLandingPage pulseLandingPage;
	private ApplyTabPage applyTabPage;
	private ButtonHandler btnHandler;

	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		learnTabPage = new LearnTabPage(driver);
		pulseLandingPage = new PulseLandingPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		btnHandler = new ButtonHandler(driver);
	}
	
	/**
	
	 * @author Sasmita
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-744")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-744:Verification for Speedometer on Module level for Sigma Theata TAU")
	public void NewATI744_VerifySpeedometerDisplayingAllModulesForSTT() throws Exception {

		logger.info("Method : NewATI744_VerifySpeedometerDisplayingAllModulesForSTT Start");
		loginPage.loginToApplication("sttstg_14",
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorials
		log(logger, "Filtering Tutorials");
		tutorialPage.waitUntillElementIsVisible("#tutorialTypeLabel");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage
		.clickModuleButtonByName(PropertiesRepository
				.getString("new-atitesting.learntab.tutorial.153.assessment.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify spedometer for all the module ");
		VerificationHandler.verifyTrue(learnTabPage.verifySpedometerForModuleLevel());

		logger.info("Method : NewATI744_VerifySpeedometerDisplayingAllModulesForSTT End");
	}
/**
	
	 * @author Sasmita
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-746")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-746:Verify if Overall Usage is displaying for existing users")
	public void NewATI746_VerifyOverallUsageForExistingUser() throws Exception {

		logger.info("Method : NewATI746_VerifyOverallUsageForExistingUser Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerDiaplayed(), "Pulse Banner is not Dispalyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner Speedometer is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerSpeedometerDiaplayed(),
				"Pulse Banner Speedometer is not Dispalyed");

		logger.info("Method : NewATI746_VerifyOverallUsageForExistingUser End");
	}
	
/**
	
	 * @author Sasmita
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-747")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-747:Verify if pop up is displaying by clicking on Recent score present on Simulation's usage table")
	public void NewATI747_VerifyUsageTablePopUpOnApplyTab() throws Exception {

		logger.info("Method : NewATI747_VerifyUsageTablePopUpOnApplyTab Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Apply Tab
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerDiaplayed(), "Pulse Banner is not Dispalyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner Speedometer is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerSpeedometerDiaplayed(),
				"Pulse Banner Speedometer is not Dispalyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on the Speedometer");
		btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.homepage.puse.banner.spedometer.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verfify if the Popup text is as expected");
		VerificationHandler.verifyTrue(
				homePage.VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.puse.banner.speedometer.text.loc",
						"new-atitesting.homepage.puse.banner.speedometer.text"));


		logger.info("Method : NewATI747_VerifyUsageTablePopUpOnApplyTab End");
	}
/**
	
	 * @author Sasmita
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-743")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-743:Verification for Speedometer on Module level for Skills Module")
	public void NewATI743_VerifySpeedometerDisplayingAllModulesForSkillsModule() throws Exception {

		logger.info("Method : NewATI743_VerifySpeedometerDisplayingAllModulesForSkillsModule Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorials
		log(logger, "Filtering Tutorials");
		tutorialPage.waitUntillElementIsVisible("#tutorialTypeLabel");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new.atitesting.module.name.sk2.0"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify spedometer for all the module ");
		VerificationHandler.verifyTrue(learnTabPage.verifySpedometerForModuleLevel());

		logger.info("Method : NewATI743_VerifySpeedometerDisplayingAllModulesForSkillsModule End");
	}
}
