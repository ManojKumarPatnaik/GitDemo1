package com.automation.newati.regression.learntab;

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

public class VerifySTTTutorialTest extends BaseTest{
	
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);

		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
		
	@TestAnnotations(testID="NewATI-828")
		@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-828:Verification of Instance scenario for STT 2017 assessment")
		public void NewATI828_VerifySingleInstancesforSTT2017() throws Exception {
			logger.info("NewATI828_VerifyInstancesforSTT2017 Start");
			
			//Step-1
			loginPage.loginToApplication("stagesingleinstance","Test123");
			
			//Step-2 & Step-3
			log(logger, "Clicking MyATI Tab");
			homePage.clickTab(1);
			homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "Clicking on Learn Tab");
			homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "Selecting Tutorial from Learn Tab drop down");
			tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			//Step-4
			log(logger, "Clicking Module by Name");
			tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "Verify Modules count and header section in card back");
			VerificationHandler.verifyTrue(tutorialPage.verifyCardBackHeaderSection(PropertiesRepository.getString("newati.card.back.title.loc"),
					PropertiesRepository.getString("new-atitesting.learntab.tutorial.153.assessment.name")), "unable to verify card back header section");
			
			//Step-5
			log(logger, "Click on Begin Lesson for Module");
			tutorialPage.clickBeginLessonButtonInNurseLogicCardBack(PropertiesRepository.getString("new-atitesting.stt.tutorial.begin.lesson"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "click on close button");
			tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			logger.info("NewATI828_VerifySingleInstancesforSTT2017 Ends");
	}
			
			@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-1221:Verification of Instance scenario for STT 2017 assessment")
			public void NewATI1221_VerifyInstancesforSTT2017() throws Exception {
				logger.info("NewATI1221_VerifyInstancesforSTT2017 Start");
				
			//Step-1
			loginPage.loginToApplication("stagereg27mar","Test123");
				
			//Step-2 & Step-3
			log(logger, "Clicking MyATI Tab");
			homePage.clickTab(1);
			homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
				
			log(logger, "Clicking on Learn Tab");
			homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
			log(logger, "Selecting Tutorial from Learn Tab drop down");
			tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
			log(logger, "Clicking on STT modules list");
			
			tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
			VerificationHandler.verifyTrue(
					tutorialPage.clickSelectInstance("Part of CDN005930926-TUT338894 for class CCtestCDN"),
						"Unable to Click on STT modules list");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			log(logger, "Verifying Cardback header");
			VerificationHandler.verifyTrue(
					tutorialPage.verifyMessage(
							PropertiesRepository.getString("new-atitesting.tutorial.cardback.module.header.name.loc"), 0,
							PropertiesRepository.getString("new-atitesting.tutorial.cardback.module.header.name.value")),
					"Unable to Verify Cardback header");
			
			
			log(logger, "click on any instance module which is part of CDN");
			homePage.clickButton(PropertiesRepository.getString("new.atitesting.multiple.instance.stt.module"), 0);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
			log(logger,"click on begin lesson for Module");
			tutorialPage.clickBeginLessonButtonInSkillsModuleCardBack(PropertiesRepository.getString("new-atitesting.stt.tutorial.begin.lesson"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "click on close button");
			tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "click on any instance module");
			homePage.clickButton(PropertiesRepository.getString("new.atitesting.multiple.instance.stt.module"), 1);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "click on close button");
			tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			logger.info("NewATI1221_VerifyInstancesforSTT2017 Ends");
			
}
	
	
	@TestAnnotations(testID="NewATI-827")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-827:Verification of Multiple attempts scenario for STT 2017 pre and post assessment")
	public void NewATI827_VerifymultipleattemptsforSTT2017PreandPostAssesments() throws Exception {
		logger.info("NewATI827_VerifymultipleattemptsforSTT2017PreandPostAssesments Start");
		
		loginPage.loginToApplication("stagesingleinstance","Test123");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selecting Tutorial from Learn Tab drop down");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		tutorialPage.clickBeginTestButtonInPharmacologyCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.module.name"));
		log(logger, "Clicking Begin Test ");
		
		log(logger, "verify resultButton for STT Pre Assesment on card back");
		VerificationHandler.verifyTrue(loginPage.checkElementEnabled(PropertiesRepository.getString("new.atitesting.stt.pre.assessment.result.button")),"PreAssessment Results are Disbaled");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "verify resultsButton for STT Post Assesement on card back");
		VerificationHandler.verifyTrue(loginPage.checkElementEnabled(PropertiesRepository.getString("new.atitesting.stt.post.assessment.result.button")), "PostAssessment Results are Disabled");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"Click on Results Button for post Assesment");
		homePage.clickButton(PropertiesRepository.getString("new.atitesting.stt.post.assessment.result.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify for Multiple instances in Results page");
		VerificationHandler.verifyTrue(homePage.checkElementEnabled(".custom-table.tutorial-result-table>tbody>tr>td"));
		
		logger.info("NewATI827_VerifymultipleattemptsforSTT2017PreandPostAssesments Ends");
}
	
}

