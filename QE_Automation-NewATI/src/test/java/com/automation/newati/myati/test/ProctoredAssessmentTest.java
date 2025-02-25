package com.automation.newati.myati.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.ProctorChromePage;
import com.automation.newati.pages.ProctorPage;
import com.automation.newati.pages.ProctorTestPage;
import com.automation.newati.pages.ProctoredAssessmentPage;
import com.automation.newati.util.UserCreationUtils;

public class ProctoredAssessmentTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private ProctoredAssessmentPage proctoredAssessmentPage;
	private WebDriver chromeDriver;
	private ProctorTestPage proctorTestPage;
	private ProctorChromePage proctorChromePage;
	private String browserType = null;
	private WebDriver proctorDriver;
	private HomePage homePage;
	private ProctorPage proctorPage;
	private CreateAccountPage createAccountPage;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	private static String userId = null;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		proctorTestPage = new ProctorTestPage(driver);
		proctorChromePage = new ProctorChromePage(driver);
		homePage = new HomePage(driver);
		proctorPage = new ProctorPage(driver);
		proctoredAssessmentPage = new ProctoredAssessmentPage(driver);
		createAccountPage = new CreateAccountPage(driver);
	}
	
	//@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-603:Verify student is able to take a ITEM TYPE REGRESSION proctored assessments")
	public void NewATI603_ItemTypeRegressionProctoredAssessment() throws Exception {
		log(logger, "NewATI603_ItemTypeRegressionProctoredAssessment End");

		loginPage.loginToApplication("TestUser_07042017_5", "Test123");
		//loginPage.loginToApplication("prodauto1", "Test123");

		// Faculty Portal Start 
		chromeDriver = openProctorChromeDriver(); 
		//Stage Faculty URL
		//chromeDriver.get("https://stage-www.atitesting.com/Home.aspx");
		chromeDriver.get("https://www.atitesting.com/Home.aspx");
		//proctoredAssessmentPage.loginToFacultyPortal(chromeDriver, "stage.atiuser3", "test");
		proctoredAssessmentPage.loginToFacultyPortal(chromeDriver, "riyaz.proctor", "test");
		proctoredAssessmentPage.checkPopupIsDisplayed(chromeDriver);

		log(logger, "Selected the product tab");
		proctoredAssessmentPage.selectTab(chromeDriver, "home.tabs.loc", 1);
		Thread.sleep(1000);
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selected the proctor Assesments form the drop down");
		proctoredAssessmentPage.selectActivity(chromeDriver, 0);
		Thread.sleep(1000);
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Entering Blank Proctor ID Value");
		proctoredAssessmentPage
				.enterProctorIDAndPwd(chromeDriver, 
						PropertiesRepository
								.getString("proctor.assessment.id.loc"),
						PropertiesRepository
								.getString("faculty.portal.itr.product.assessment.id.value"));

		log(logger, "Enteing Proctor Pwd Value");
		proctoredAssessmentPage
				.enterProctorIDAndPwd(chromeDriver, 
						PropertiesRepository
								.getString("proctor.assessment.pwd.loc"),
						PropertiesRepository
								.getString("faculty.portal.itr.product.assessment.pwd.value"));

		log(logger, "Clicking Proctor Submit Button");
		proctoredAssessmentPage.clickButtonWithLoadingImageDisappeared(chromeDriver, PropertiesRepository
				.getString("faculty.portal.product.select.activity.proctor.assessment.submit.button.loc"));
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		Thread.sleep(10000);
		
		log(logger, "Entering Electornic Signature");
		proctoredAssessmentPage
				.enterElectornicSignature(chromeDriver,
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctoredAssessmentPage
				.enterElectornicSignature(chromeDriver, 
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
						CommonUtils.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctoredAssessmentPage.clickProctorWelcomePageProceedButton(chromeDriver);
		// Faculty Portal End
		
		// Student Portal Start
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"));
		
		log(logger, "Entering Proctor Id"); // need to check locator
		proctoredAssessmentPage.enterValue(PropertiesRepository.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("faculty.portal.itr.product.assessment.id.value"));
		
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);
		// Student Portal End
		
		// Proctor Portal Start
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));
		// Proctor Portal End
		
		// Faculty Portal Start
		log(logger, "Clicking on Aprove Button");
		Thread.sleep(30000);
		proctoredAssessmentPage.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("new-atitesting.proctor.refresh.button"));
		Thread.sleep(30000); 
		Thread.sleep(30000);
		proctoredAssessmentPage.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("faculty.portal.proctor.approve.radio.button.loc"));
		
		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		Thread.sleep(30000);
		proctoredAssessmentPage.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("new-atitesting.proctor.refresh.button"));
		Thread.sleep(30000);
		// Faculty Portal End 
		
		// click on Resume Test Button. 
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"));
		// Assessment Page. 
		proctorTestPage.takeITRProctorAssessment();
		
		chromeDriver.close();
		chromeDriver.quit();
		log(logger, "NewATI603_ItemTypeRegressionProctoredAssessment Start");
	}

	//@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-104:Verify student is able to take a TEAS proctored assessments")
	public void NewATI104_TEASProctoredAssessment_OLD() throws Exception {
		log(logger, "NewATI104_TEASProctoredAssessment End");
		
		loginPage.loginToApplication("TestUser_06042017_6", "Test123");
		
		// Faculty Portal Start 
		chromeDriver = openProctorChromeDriver(); 
		chromeDriver.get("https://stage-www.atitesting.com/Home.aspx");
		proctoredAssessmentPage.loginToFacultyPortal(chromeDriver, "stage.atiuser3", "test");
		proctoredAssessmentPage.checkPopupIsDisplayed(chromeDriver);

		log(logger, "Selected the product tab");
		proctoredAssessmentPage.selectTab(chromeDriver, "home.tabs.loc", 1);
		Thread.sleep(1000);
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selected the proctor Assesments form the drop down");
		proctoredAssessmentPage.selectActivity(chromeDriver, 0);
		Thread.sleep(1000);
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Entering Blank Proctor ID Value");
		proctoredAssessmentPage
				.enterProctorIDAndPwd(chromeDriver, 
						PropertiesRepository
								.getString("proctor.assessment.id.loc"),
						PropertiesRepository
								.getString("faculty.portal.teas.product.assessment.id.value"));

		log(logger, "Enteing Proctor Pwd Value");
		proctoredAssessmentPage
				.enterProctorIDAndPwd(chromeDriver, 
						PropertiesRepository
								.getString("proctor.assessment.pwd.loc"),
						PropertiesRepository
								.getString("faculty.portal.teas.product.assessment.pwd.value"));

		log(logger, "Clicking Proctor Submit Button");
		proctoredAssessmentPage.clickButtonWithLoadingImageDisappeared(chromeDriver, PropertiesRepository
				.getString("faculty.portal.product.select.activity.proctor.assessment.submit.button.loc"));
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		Thread.sleep(10000);
		
		log(logger, "Entering Electornic Signature");
		proctoredAssessmentPage
				.enterElectornicSignature(chromeDriver,
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctoredAssessmentPage
				.enterElectornicSignature(chromeDriver, 
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
						CommonUtils.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctoredAssessmentPage.clickProctorWelcomePageProceedButton(chromeDriver);
		// Faculty Portal End
		
		// Student Portal Start
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"));
		
		log(logger, "Entering Proctor Id"); // need to check locator
		proctoredAssessmentPage.enterValue(PropertiesRepository.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("faculty.portal.teas.product.assessment.id.value"));
		
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);
		// Student Portal End
		
		// Proctor Portal Start
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));
		// Proctor Portal End
		
		// Faculty Portal Start
		log(logger, "Clicking on Aprove Button");
		Thread.sleep(30000);
		proctoredAssessmentPage.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("new-atitesting.proctor.refresh.button"));
		Thread.sleep(30000); 
		Thread.sleep(30000);
		proctoredAssessmentPage.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("faculty.portal.proctor.approve.radio.button.loc"));
		
		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		Thread.sleep(30000);
		proctoredAssessmentPage.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("new-atitesting.proctor.refresh.button"));
		Thread.sleep(30000);
		// Faculty Portal End 
		// click on Resume Test Button. 
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"));
		// Assessment Page.  
		// Section 1
		proctorTestPage.takeTEASProctorAssessment_1();
		// Section 2		
		proctorTestPage.takeTEASProctorAssessment_1();
		// Section 3
		proctorTestPage.takeTEASProctorAssessment_1();
		// Section 4
		proctorTestPage.takeTEASProctorAssessment_FinalSection();
		// Continue Section 
		proctorTestPage.clickContinueButton();
		// Last Section
		proctorTestPage.takeTEASProctorAssessment_last();
		log(logger, "NewATI104_TEASProctoredAssessment Start");
	}
	
	
	
	/**
	 * Proctor Assessment New Implementation
	 * @author Syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-104:Verify student is able to take a TEAS proctored assessments")
	public void NewATI104_TEASProctoredAssessmentTest_NEW() throws Exception {
		log(logger, "NewATI104_TEASProctoredAssessmentTest Start");
		// Getting value from Jenkins for environment - Start
		String environment = System.getProperty("env");
		logger.info("environment value ==> " + environment);
		
		if(StringUtils.isBlank(environment) || StringUtils.isEmpty(environment)) {
			environment = PropertiesRepository.getString("global.environment.name");
			logger.info("environment value from property file==> " + environment);
		}
		/*if (GlobalProperties.STAGE.equalsIgnoreCase(environment) || GlobalProperties.STG.equalsIgnoreCase(environment)) {
			envURL = "";
		} else if(GlobalProperties.PROD.equalsIgnoreCase(environment)){
			envURL = "";
		}*/		
		//Launch Application
		/*userId = userCreationUtils.getUserDetails();
		logger.info("Created User id --> " + userId);
		loginPage.loginToApplication(userId, "Test123");*/
		
		loginPage.enterURL("newati.login.url");
		//Generate Random User Name
		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append("test@gm.com");		
		//Create new user and login
		log(logger, "TestCase: Step 1 Start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName, sbEmail.toString()),
				PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		log(logger, "TestCase: Step 1 Ends");

		log(logger, "TestCase:  Step 2 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),
				PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		log(logger, "TestCase: Step 2 Ends");

		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),
				PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");

		log(logger, "TestCase: Step 4 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),
				PropertiesRepository.getString("new-atitesting.step5.header"),
				"Unable to complete Step 4 in Create Account");
		log(logger, "TestCase: Step 4 Ends");

		log(logger, "TestCase: Step 5 Starts");
		VerificationHandler.verifyTrue(
				createAccountPage.verifyStep5().trim()
						.contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
				"Unable to complete Step 5 in Create Account");
		log(logger, "TestCase: Step 5 Ends");

		log(logger, "TestCase: Step 6 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),
				PropertiesRepository.getString("new-atitesting.step7.header"),
				"Unable to complete Step 6 in Create Account");
		log(logger, "TestCase: Step 6 Ends");

		log(logger, "TestCase: Step 7 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(), "Unable to complete Step 7 in Create Account");
		log(logger, "TestCase: Step 7 Ends");
		
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		log(logger, "Welcome video dispalyed");	
		
		//Click on Begin Using ATI button
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#getStartedMainMenu a[class='button primary-button skip-orientation-link focus-element-flag']")));
		homePage.clickButton("#getStartedMainMenu a[class='button primary-button skip-orientation-link focus-element-flag']");
		
		//*******************************Proctor Assessment************************************	
		// Getting value from Jenkins
		logger.info("Proctor Assessment Starts");
		browserType = System.getProperty("browserName");
		logger.info("browserType value first ==> " + browserType);
		
		// If not getting value from properties file
		if(StringUtils.isEmpty(browserType)) {
			browserType = PropertiesRepository.getString("global.browser.name");
		} 
		
		logger.info("browserType value ==> " + browserType);
		if(browserType.equalsIgnoreCase(GlobalProperties.FIREFOX)) {
			proctorDriver = openProctorChromeDriver();
			logger.info("Opening Chrome Browser");
		} else if(browserType.equalsIgnoreCase(GlobalProperties.CHROME)) {
			proctorDriver = openProctorFirefoxDriver();
			logger.info("Opening Firefox Browser");
		}
		
		// Faculty Start
		log(logger, "Login to application");
		/*proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.teas.username"),
				PropertiesRepository.getString("id.login.proctor.teas.password"));*/
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.teas.username"),
				PropertiesRepository.getString("id.login.proctor.teas.password"));
		 //"prodstudent108","Test123");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository
				.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(20000);
		
		log(logger, "Verifying Assessment Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearchUpdated(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Enterin Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value.prod"),
				PropertiesRepository.getString("id.proctor.pwd.value.prod"));//Thread.sleep(10000);Thread.sleep(10000);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(20000);
		
		log(logger, "Entering Electornic Signature");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository
						.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
				proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);
		
		// Faculty Ends
		
		// Student Starts
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.add.product"));
		
		log(logger, "Verifying Add Product button is clicked or not.");
		VerificationHandler.verifyTrue(proctoredAssessmentPage.verifyAssessmentIDPopup(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"))
				,"Unable to click and add product id/ pwd");
		
		log(logger, "Entering Proctor Id"); // need to check locator
		proctoredAssessmentPage.enterTextValue(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"), PropertiesRepository
				.getString("id.proctor.id.value.prod"));
		
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);
				
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(10000);
		// Student Ends
		
		// Proctor Portal Start
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
		
		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWaitApprove(proctorDriver), "Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		//proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_TableComplete");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
		Thread.sleep(30000);
		
		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(proctorChromePage.checkStopTestCheckBox(proctorDriver), "Verifying Stop Test Check box");
		// Faculty End
		
		// Student Start
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(),"Unable to verify Question nos");
			
		// Assessment Page.
		log(logger, "Taking Proctor Assessment TEAS Section 1");
		proctorPage.takeTEASProctorAssessmentContinue();

		log(logger, "Taking Proctor Assessment TEAS Section 2");
		proctorPage.takeTEASProctorAssessmentContinue();
		
		log(logger, "Taking Proctor Assessment TEAS Section 3");
		proctorPage.takeTEASProctorAssessmentContinue();
		
		log(logger, "Taking Proctor Assessment TEAS Section 4");
		proctorPage.takeTEASProctorAssessmentFinalize();		
		
		// Getting environment. 
		if (GlobalProperties.STAGE.equalsIgnoreCase(environment) || GlobalProperties.STG.equalsIgnoreCase(environment)) {
			log(logger, "Taking TEAS Permission");
			proctorPage.takeTEASPermission();
		} else if(GlobalProperties.PROD.equalsIgnoreCase(environment)){
			log(logger, "Taking Proctor Assessment TEAS Survey");
			proctorPage.takeTEASProctorAssessmentSurvey();
		}
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(proctorPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
				
		log(logger, "Clicking on close button in IPP Page");
		proctorPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"),0);
		proctorPage.waitUntillLoadingImageIsDisappeared("ATIFaculti.common.page.spinner.loc");
				
		logger.info("Proctor Assessment End");
		// Student End		
		log(logger, "NewATI104_TEASProctoredAssessmentTest End");		
	}	
	
	

	/**
	 * Proctor Assessment New Implementation
	 * @author Syed.pasha
	 * @throws Exception
	 */
	//@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-104:Verify student is able to take a TEAS proctored assessments")
	public void NewATI104_TEASProctAssTest_NEW_WithTime() throws Exception {
		log(logger, "NewATI104_TEASProctAssTest_NEW_WithTime Start");
		long timeAtFirstQuestionLoadProc = 0;
		long timeAtFirstQuestionLoadAss = 0;
		
		// Getting value from Jenkins for environment - Start
		String environment = System.getProperty("env");
		logger.info("environment value ==> " + environment);
		
		if(StringUtils.isBlank(environment) || StringUtils.isEmpty(environment)) {
			environment = PropertiesRepository.getString("global.environment.name");
			logger.info("environment value from property file==> " + environment);
		}
		/*if (GlobalProperties.STAGE.equalsIgnoreCase(environment) || GlobalProperties.STG.equalsIgnoreCase(environment)) {
			envURL = "";
		} else if(GlobalProperties.PROD.equalsIgnoreCase(environment)){
			envURL = "";
		}*/		
		//Launch Application
		/*userId = userCreationUtils.getUserDetails();
		logger.info("Created User id --> " + userId);
		loginPage.loginToApplication(userId, "Test123");*/
		
		loginPage.enterURL("newati.login.url");
		//Generate Random User Name
		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append("test@gm.com");		
		//Create new user and login
		log(logger, "TestCase: Step 1 Start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName, sbEmail.toString()),
				PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		log(logger, "TestCase: Step 1 Ends");

		log(logger, "TestCase:  Step 2 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),
				PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		log(logger, "TestCase: Step 2 Ends");

		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),
				PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");

		log(logger, "TestCase: Step 4 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),
				PropertiesRepository.getString("new-atitesting.step5.header"),
				"Unable to complete Step 4 in Create Account");
		log(logger, "TestCase: Step 4 Ends");

		log(logger, "TestCase: Step 5 Starts");
		VerificationHandler.verifyTrue(
				createAccountPage.verifyStep5().trim()
						.contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
				"Unable to complete Step 5 in Create Account");
		log(logger, "TestCase: Step 5 Ends");

		log(logger, "TestCase: Step 6 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),
				PropertiesRepository.getString("new-atitesting.step7.header"),
				"Unable to complete Step 6 in Create Account");
		log(logger, "TestCase: Step 6 Ends");

		log(logger, "TestCase: Step 7 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(), "Unable to complete Step 7 in Create Account");
		log(logger, "TestCase: Step 7 Ends");
		
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		log(logger, "Welcome video dispalyed");	
		
		//Click on Begin Using ATI button
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#getStartedMainMenu a[class='button primary-button skip-orientation-link focus-element-flag']")));
		homePage.clickButton("#getStartedMainMenu a[class='button primary-button skip-orientation-link focus-element-flag']");
		
		//*******************************Proctor Assessment************************************	
		// Getting value from Jenkins
		logger.info("Proctor Assessment Starts");
		browserType = System.getProperty("browserName");
		logger.info("browserType value first ==> " + browserType);
		
		// If not getting value from properties file
		if(StringUtils.isEmpty(browserType)) {
			browserType = PropertiesRepository.getString("global.browser.name");
		} 
		
		logger.info("browserType value ==> " + browserType);
		if(browserType.equalsIgnoreCase(GlobalProperties.FIREFOX)) {
			proctorDriver = openProctorChromeDriver();
			logger.info("Opening Chrome Browser");
		} else if(browserType.equalsIgnoreCase(GlobalProperties.CHROME)) {
			proctorDriver = openProctorFirefoxDriver();
			logger.info("Opening Firefox Browser");
		}
		
		// Faculty Start
		log(logger, "Login to application");
		/*proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.teas.username"),
				PropertiesRepository.getString("id.login.proctor.teas.password"));*/
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.teas.username"),
				PropertiesRepository.getString("id.login.proctor.teas.password"));
		 //"prodstudent108","Test123");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository
				.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(20000);
		
		log(logger, "Verifying Assessment Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearchUpdated(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Enterin Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value.prod"),
				PropertiesRepository.getString("id.proctor.pwd.value.prod"));//Thread.sleep(10000);Thread.sleep(10000);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(20000);
		
		log(logger, "Entering Electornic Signature");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository
						.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
				proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);
		
		// Faculty Ends
		
		// Student Starts
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.add.product"));
		
		log(logger, "Verifying Add Product button is clicked or not.");
		VerificationHandler.verifyTrue(proctoredAssessmentPage.verifyAssessmentIDPopup(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"))
				,"Unable to click and add product id/ pwd");
		
		log(logger, "Entering Proctor Id"); // need to check locator
		proctoredAssessmentPage.enterTextValue(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"), PropertiesRepository
				.getString("id.proctor.id.value.prod"));
		
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);
				
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(10000);
		// Student Ends
		
		// Proctor Portal Start
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
		
		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWaitApprove(proctorDriver), "Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		//proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_TableComplete");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
		Thread.sleep(30000);
		
		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(proctorChromePage.checkStopTestCheckBox(proctorDriver), "Verifying Stop Test Check box");
		// Faculty End
		
		// Student Start
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		long timeBeforeLoadingFirstQuesProc = System.currentTimeMillis();
		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(),"Unable to verify Question nos");
		log(logger, "Verifying Calculator");
		
		if(proctorPage.verifyQuestionNos())
		{
			timeAtFirstQuestionLoadProc = System.currentTimeMillis();
			log(logger, "timeAtFirstQuestionLoadProc --> " +timeAtFirstQuestionLoadProc);
		}
		long timeTakenToLoadFirstQuestionProc = TimeUnit.MILLISECONDS.toSeconds(timeAtFirstQuestionLoadProc - timeBeforeLoadingFirstQuesProc);
		
			
		// Assessment Page.
		log(logger, "Taking Proctor Assessment TEAS Section 1");
		Double avgTimeTakenForLodingEachPageForSecList1 = proctorPage.takeTEASProctorAssessmentContinue();

		log(logger, "Taking Proctor Assessment TEAS Section 2");
		Double avgTimeTakenForLodingEachPageForSecList2 = proctorPage.takeTEASProctorAssessmentContinue();
		
		log(logger, "Taking Proctor Assessment TEAS Section 3");
		Double avgTimeTakenForLodingEachPageForSecList3 = proctorPage.takeTEASProctorAssessmentContinue();
		
		log(logger, "Taking Proctor Assessment TEAS Section 4");
		ArrayList<Double> avgTimeTakenForLodingAssForSecList = proctorPage.takeTEASProctAssFinalize_WithTime();		
		
		// Getting environment. 
		if (GlobalProperties.STAGE.equalsIgnoreCase(environment) || GlobalProperties.STG.equalsIgnoreCase(environment)) {
			log(logger, "Taking TEAS Permission");
			proctorPage.takeTEASPermission();
		} else if(GlobalProperties.PROD.equalsIgnoreCase(environment)){
			log(logger, "Taking Proctor Assessment TEAS Survey");
			proctorPage.takeTEASProctorAssessmentSurvey();
		}
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(proctorPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
		
		long ippLoadEnd = System.currentTimeMillis();
		logger.info("Time Taken to load IPP Page >>>>>>>>>>>> " + (TimeUnit.MILLISECONDS.toSeconds(ippLoadEnd- (new Double(avgTimeTakenForLodingAssForSecList.get(1))).longValue())  + " seconds")); 
				
		log(logger, "Clicking on close button in IPP Page");
		proctorPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"),0);
		proctorPage.waitUntillLoadingImageIsDisappeared("ATIFaculti.common.page.spinner.loc");
				
		logger.info("Proctor Assessment End");
		// Student End	
		
		Map<String, String> procAssTimeMap = new HashMap<String, String>();
		procAssTimeMap.put("Time taken to load first question for Proctored Test : " , Long.toString(timeTakenToLoadFirstQuestionProc) + " Seconds");
		procAssTimeMap.put("Average time taken to load each page in Proctored Test TEAS Section 1: " , Double.toString(avgTimeTakenForLodingEachPageForSecList1)+ " Milli Seconds");
		procAssTimeMap.put("Average time taken to load each page in Proctored Test TEAS Section 2: " , Double.toString(avgTimeTakenForLodingEachPageForSecList2)+ " Milli Seconds");
		procAssTimeMap.put("Average time taken to load each page in Proctored Test TEAS Section 3: " , Double.toString(avgTimeTakenForLodingEachPageForSecList3)+ " Milli Seconds");
		procAssTimeMap.put("Average time taken to load each page in Proctored Test TEAS Section 4: " , Double.toString(avgTimeTakenForLodingAssForSecList.get(0))+ " Milli Seconds");
		procAssTimeMap.put("Time Taken to load the Results page after completing test : " , (TimeUnit.MILLISECONDS.toSeconds(ippLoadEnd- (new Double(avgTimeTakenForLodingAssForSecList.get(1))).longValue()))  + " seconds");
		
		
		log (logger, "                                                              ");
		log(logger, "=========== TEST RESULT FOR TEAS PROCTORED ASSESSMENT =========");
		log (logger, "                                                              ");
		log(logger, "Proctored Test Completed Successfully");
		for (Map.Entry<String, String> entry : procAssTimeMap.entrySet()) {
			log(logger, entry.getKey() + entry.getValue());
		}
		log (logger, "                                                              ");
		
		
		log(logger, "NewATI104_TEASProctAssTest_NEW_WithTime End");		
	}	

	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.close();
			proctorDriver.quit();
		}
	}
	
}
