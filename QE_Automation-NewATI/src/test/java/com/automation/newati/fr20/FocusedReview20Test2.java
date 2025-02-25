package com.automation.newati.fr20;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LoginPage;
import com.jaca.TestAnnotations;

public class FocusedReview20Test2 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private ImproveTabPage improveTabPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		improveTabPage = new ImproveTabPage(driver);
	}

	@TestAnnotations(testID = "NewATI-753")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verification of fr2.0 Study Material button functionality available on Practice Assessment record")
	public void NewATI753_VerifyCustomAssessmentUnderImproveTab() throws Exception {
		log(logger, "NewATI857_VerifyCustomAssessmentUnderImproveTab Start");
		logger.info("NewATI857_VerifyCustomAssessmentUnderImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Study Material button");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyStudyMaterialButtonValue(
						PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
				"Unable to Clicking on Study Material button");

		log(logger, "Verifying Test tab");
		VerificationHandler.verifyTrue(improveTabPage.verifyMessage(
				PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.header.loc"),
				0, "Test Type:"), "Unable to Verifying Test tab name");
		VerificationHandler
				.verifyTrue(improveTabPage.verifyElement(
						PropertiesRepository.getString(
								"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.loc"),
						0), "Unable to Verifying Test tab select");

		log(logger, "Verifying Sory by ");
		VerificationHandler.verifyTrue(improveTabPage.verifyMessage(
				PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.header.loc"),
				1, "Sort by:"), "Unable to Verifying Sory by name");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyElement(PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.select.loc"), 1),
				"Unable to Verifying Sory by select");

		log(logger, "NewATI857_VerifyCustomAssessmentUnderImproveTab End");
		logger.info("NewATI857_VerifyCustomAssessmentUnderImproveTab End");
	}

	@TestAnnotations(testID = "NewATI-629")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify the functionality of sub-category sort dropdown")
	public void NewATI629_VerifySubCategorySortDDInImproveTab() throws Exception {
		log(logger, "NewATI629_VerifySubCategorySortDDInImproveTab Start");
		logger.info("NewATI629_VerifySubCategorySortDDInImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Study Material button");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyStudyMaterialButtonValue(
						PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
				"Unable to Clicking on Study Material button");

		log(logger, "Verifying Test tab");
		VerificationHandler.verifyTrue(improveTabPage.verifyMessage(
				PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.header.loc"),
				0, "Test Type:"), "Unable to Verifying Test tab name");
		VerificationHandler
				.verifyTrue(improveTabPage.verifyElement(
						PropertiesRepository.getString(
								"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.loc"),
						0), "Unable to Verifying Test tab select");

		log(logger, "Verifying Sory by ");
		VerificationHandler.verifyTrue(improveTabPage.verifyMessage(
				PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.header.loc"),
				1, "Sort by:"), "Unable to Verifying Sory by name");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyElement(PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.select.loc"), 1),
				"Unable to Verifying Sory by select");
		
		log(logger, "Verifying Sort By dd values");
		List<String> dropdownValue = new ArrayList<String>();
		dropdownValue.add(PropertiesRepository.getString("new-atitesting.improve.tab.sort.by.value1"));
		dropdownValue.add(PropertiesRepository.getString("new-atitesting.improve.tab.sort.by.value2"));
		dropdownValue.add(PropertiesRepository.getString("new-atitesting.improve.tab.sort.by.value3"));
		dropdownValue.add(PropertiesRepository.getString("new-atitesting.improve.tab.sort.by.value4"));
		
		VerificationHandler.verifyTrue(improveTabPage.verifyTestTypeAndSortByDDValue(PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value"), 1, dropdownValue),
				"Unable to verify all dd values in sort by");
		
		log(logger, "NewATI629_VerifySubCategorySortDDInImproveTab End");
		logger.info("NewATI629_VerifySubCategorySortDDInImproveTab End");
	}
	
	
	@TestAnnotations(testID = "NewATI-630")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify default display of sort by dropdown is Last Accessed within a content area")
	public void NewATI630_VerifySubCategorySortDDDefaultValueInImproveTab() throws Exception {
		log(logger, "NewATI630_VerifySubCategorySortDDDefaultValueInImproveTab Start");
		logger.info("NewATI630_VerifySubCategorySortDDDefaultValueInImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Study Material button");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyStudyMaterialButtonValue(
						PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
				"Unable to Clicking on Study Material button");

		log(logger, "Verifying Test tab");
		VerificationHandler.verifyTrue(improveTabPage.verifyMessage(
				PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.header.loc"),
				0, "Test Type:"), "Unable to Verifying Test tab name");
		VerificationHandler
				.verifyTrue(improveTabPage.verifyElement(
						PropertiesRepository.getString(
								"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.loc"),
						0), "Unable to Verifying Test tab select");

		log(logger, "Verifying Sory by ");
		VerificationHandler.verifyTrue(improveTabPage.verifyMessage(
				PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.header.loc"),
				1, "Sort by:"), "Unable to Verifying Sory by name");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyElement(PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.select.loc"), 1),
				"Unable to Verifying Sory by select");
		
		log(logger, "Verifying Sort By dd default values");
		VerificationHandler.verifyTrue(improveTabPage.verifyTestTypeAndSortByDDDefaultValue(PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value"), 1, PropertiesRepository.getString("new-atitesting.improve.tab.sort.by.value1")),
				"Unable to Verify Sort By dd default values");
		
		log(logger, "NewATI630_VerifySubCategorySortDDDefaultValueInImproveTab End");
		logger.info("NewATI630_VerifySubCategorySortDDDefaultValueInImproveTab End");
	}
	
	
	@TestAnnotations(testID = "NewATI-798")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify Time spent functionality for the Fr2.0 assessment under Myresult Page")
	public void NewATI798_VerifyTimeSpentInMyResultsTab() throws Exception {
		log(logger, "NewATI798_VerifyTimeSpentInMyResultsTab Start");
		logger.info("NewATI798_VerifyTimeSpentInMyResultsTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyResults Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Timespent value in My Results Tab");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyFR20TimeSpentInMyResultsTab(
						PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
				"Unable to Verify Timespent value in My Results Tab");

		log(logger, "NewATI798_VerifyTimeSpentInMyResultsTab End");
		logger.info("NewATI798_VerifyTimeSpentInMyResultsTab End");
	}
	
	@TestAnnotations(testID = "NewATI-765")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verification for non accessed assessment record under Improve tab")
	public void NewATI765_VerifyNonAccessedAssessmentInImproveTab() throws Exception {
		log(logger, "NewATI765_VerifyNonAccessedAssessmentInImproveTab Start");
		logger.info("NewATI765_VerifyNonAccessedAssessmentInImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Select Test");
		VerificationHandler.verifyTrue(
		improveTabPage.verifySelectTestForAssessment("RN Leadership 2013", "Select Test")
		, "Unable to Verify Select Test");
		
		log(logger, "Verifying Begin ");
		VerificationHandler.verifyTrue(
		improveTabPage.verifySelectTestForAssessment("RN Leadership Online Practice 2013 B", "Begin")
		,"Unable to Verify Begin");
		
		
		log(logger, "NewATI765_VerifyNonAccessedAssessmentInImproveTab End");
		logger.info("NewATI765_VerifyNonAccessedAssessmentInImproveTab End");
	}
	
	
	@TestAnnotations(testID = "NewATI-927")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "To verify the behavior of product launch when user have multiple instance under improve tab")
	public void NewATI927_VerifySelectTestInImproveTab() throws Exception {
		log(logger, "NewATI927_VerifySelectTestInImproveTab Start");
		logger.info("NewATI927_VerifySelectTestInImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Select Test and its select instance details");
		VerificationHandler.verifyTrue(
		improveTabPage.verifySelectTestForAssessmentAndItsDetails("RN Leadership 2013", "Select Test")
		, "Unable to Verify Select Test");
		
		log(logger, "NewATI927_VerifySelectTestInImproveTab End");
		logger.info("NewATI927_VerifySelectTestInImproveTab End");
	}
	
	@TestAnnotations(testID = "NewATI-769")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify proctor not available message for proctor assessment under improve tab.")
	public void NewATI769_VerifyProctorNotAvailableMsgInImproveTab() throws Exception {
		log(logger, "NewATI769_VerifyProctorNotAvailableMsgInImproveTab Start");
		logger.info("NewATI769_VerifyProctorNotAvailableMsgInImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Select Test and its select instance details");
		VerificationHandler.verifyTrue(
		improveTabPage.verifySelectTestForAssessmentAndItsDetails("RN Leadership 2013", "Select Test")
		, "Unable to Verify Select Test");
		
		log(logger, "NewATI769_VerifyProctorNotAvailableMsgInImproveTab End");
		logger.info("NewATI769_VerifyProctorNotAvailableMsgInImproveTab End");
	}
	
	
	@TestAnnotations(testID = "NewATI-791")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verification for Quiz functionality for completed FR2.0 assessments")
	public void NewATI791_VerifyQuizFunctionalityForFR20InImproveTab() throws Exception {
		log(logger, "NewATI791_VerifyQuizFunctionalityForFR20InImproveTab Start");
		logger.info("NewATI791_VerifyQuizFunctionalityForFR20InImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Study Material button");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyStudyMaterialButtonValue(
						PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
				"Unable to Clicking on Study Material button");

		log(logger, "Verifying Test tab");
		VerificationHandler.verifyTrue(improveTabPage.verifyMessage(
				PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.header.loc"),
				0, "Test Type:"), "Unable to Verifying Test tab name");
		VerificationHandler
				.verifyTrue(improveTabPage.verifyElement(
						PropertiesRepository.getString(
								"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.loc"),
						0), "Unable to Verifying Test tab select");

		log(logger, "Verifying Sory by ");
		VerificationHandler.verifyTrue(improveTabPage.verifyMessage(
				PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.label.header.loc"),
				1, "Sort by:"), "Unable to Verifying Sory by name");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyElement(PropertiesRepository.getString(
						"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.select.loc"), 1),
				"Unable to Verifying Sory by select");

		log(logger, "NewATI791_VerifyQuizFunctionalityForFR20InImproveTab End");
		logger.info("NewATI791_VerifyQuizFunctionalityForFR20InImproveTab End");
	}
}
