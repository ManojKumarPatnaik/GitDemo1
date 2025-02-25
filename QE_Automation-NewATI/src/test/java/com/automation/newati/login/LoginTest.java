package com.automation.newati.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.ProctorChromePage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class LoginTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TextHandler textHandler;
	private ProctorChromePage proctorChromePage;
	private WindowHandler windowhandler;
	private TutorialPage tutorialPage;
	private BaseHandler baseHandler;
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		textHandler = new TextHandler(driver);
		proctorChromePage = new ProctorChromePage(driver);
		windowhandler= new WindowHandler(driver);
		tutorialPage = new TutorialPage(driver);
		baseHandler = new BaseHandler(driver);
	}
	
	@TestAnnotations(testID="NewATI-538")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups="{Smoke}", description="Validate that an existing user is able to login to the application::LoginPage")
	public void NewATI538_ValidateLoginWithExistingUser() throws Exception {
		log(logger, "NewATI538_ValidateLoginWithExistingUser Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Learn Tab");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.learn.type.section")), "Unable to verify Learn Tab ");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Test Tab");
		myATITabMainPage.clickButton(PropertiesRepository.getString("new-atitesting.test.tab.new.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Test Tab");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.test.view.section")), "Unable to verify Test Tab ");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Improve Tab");
		myATITabMainPage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.popup.close.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Improve Tab");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.improve.type.section.new")), "Unable to verify Improve Tab ");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Apply Tab");
		myATITabMainPage.clickButton(PropertiesRepository.getString("new-atitesting.apply.tab"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Apply Tab");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.apply.type.section")), "Unable to verify Apply Tab ");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on MyResults Tab");
		homePage.clickTab(2);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.my.results.heading")), "Unable to verify My Results Tab ");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Help Tab");
		homePage.clickTab(3);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.my.help.heading")), "Unable to verify My Help Tab ");
		
		log(logger, "NewATI538_ValidateLoginWithExistingUser End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description="NewATI-64:Verify the functionality of 'Technical Requirements' link")	
	public void NewATI64_VerifyTechReqLink() throws Exception {
		log(logger, "NewATI64_VerifyTechReqLink Start");
		
		loginPage.enterURL("newati.login.url");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Technical Requirement link");
		homePage.clickButton(".tech-requirements-area a");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler
		.verifyEquals(homePage.getText("#ui-id-4"), "Technical Requirements", "Unable to verify Technical Requirement window");
		log(logger, "NewATI64_VerifyTechReqLink End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description="NewATI-71:Verify the functionality of 'ATI Product Solutions' footer link.")	
	public void NewATI71_VerifyATIProdSolLink() throws Exception {
		log(logger, "NewATI71_VerifyATIProdSolLink Start");
		
		loginPage.enterURL("newati.login.url");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Technical Requirement link");
		homePage.clickButton("#prodsolutions");
		
		VerificationHandler
		.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.homepage.linkpage.linksText"), PropertiesRepository.getString("new-atitesting.bottom.link.product.solutions")), "Unable to verify ATI Product Solution window");
		log(logger, "NewATI71_VerifyATIProdSolLink End");
	}
	
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description="NewATI-628:Verify Student Specific Verbiage as 'Student Sign On on' login Page")	
	public void NewATI628_VerifyStudentSignOn() throws Exception {
		log(logger, "NewATI628_VerifyStudentSignOn Start");
		
		loginPage.enterURL("newati.login.url");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler
		.verifyTrue(loginPage.verifyMessage(PropertiesRepository.getString("new-atitesting.loginpage.student.sign.on.loc"), PropertiesRepository.getString("new-atitesting.login.page.student.sign.on.value")), "Unable to verify Student Sign On Message");
		log(logger, "NewATI628_VerifyStudentSignOn End");
	}
	
	@TestAnnotations(testID="NewATI-775")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description="NewATI-775: Verify student login page to mirror new faculty login page::LoginPage")
	 public void NewATI775_VerifyFacultyCredentialLoginErrorMessage() throws Exception
	 {
	  log(logger, "NewATI775_VerifyFacultyCredentialLoginErrorMessage start");
	  log(logger, "Invalid login to application. ");
//	  loginPage.invalidLoginToApplication(PropertiesRepository.getString("newati.facultyportal.username"), PropertiesRepository.getString("newati.facultyportal.password"));
	  loginPage.invalidLoginToApplication("stgreg3301","Testing1");
	  homePage.waitUntillElementIsVisible(PropertiesRepository.getString("newati.login.error.message.loc"));
	  
	  log(logger, "Verifying Error message");
	  String errormessage=textHandler.getText(PropertiesRepository.getString("newati.login.error.message.loc"));
	  loginPage. waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  VerificationHandler.verifyEquals(errormessage, PropertiesRepository.getString("newati.error.message"));
	  homePage.clickButton(PropertiesRepository.getString("newati.login.error.message.loc"));
	  loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger, "NewATI775_VerifyFacultyCredentialLoginErrorMessage end");
	 }

	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 6, enabled = true, alwaysRun = true, description = "NewATI-785:Verify logout functionality for faculty student mimic.")
	public void NewATI785_verifyFacultyLogoutStudentMimic() throws Exception {

		log(logger, "NewATI785_verifyFacultyLogoutStudentMimic Start");

		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(driver, PropertiesRepository.getString("id.login.faculty.username.prod"),
				PropertiesRepository.getString("id.login.faculty.password.prod"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(10000);

		log(logger, "Clicking on arrow icon in the Left Navigation header");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		log(logger, "Clicking on Student View link");
		proctorChromePage.clickButton(PropertiesRepository.getString("id.home.page.left.navigator.student.view.link"),
				1);
		Thread.sleep(1000);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Student View Continue button");
		proctorChromePage.clickButton(PropertiesRepository.getString("modal.continue.btn"), 0);
		Thread.sleep(15000);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillElementInvisible(".modal-body>div>h3");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if 'Return to Faculty Account' link is displayed");
		VerificationHandler.verifyTrue(homePage.verifyLinkUsingIndex(PropertiesRepository.getString("new-atitesting.home.returnToFacultyAcc.link.loc"), 1));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on 'Return to Faculty Account' link");
		proctorChromePage.clickButton(PropertiesRepository.getString("new-atitesting.home.returnToFacultyAcc.link.loc"),
				1);

		// To handle loading issues
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Faculty Home Page is displayed");
		VerificationHandler.verifyTrue(loginPage.baseHandler.findElement(".mat-icon-button").isDisplayed());
		log(logger, "NewATI785_verifyFacultyLogoutStudentMimic end");

	}

	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 7, enabled = true, alwaysRun = true, description = "NewATI-787:Verify add product functionality for faculty student mimic.")
	public void NewATI787_verifyAddProductStudentMimic() throws Exception {

		log(logger, "NewATI787_verifyAddProductStudentMimic Start");

		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(driver, PropertiesRepository.getString("id.login.faculty.username.prod"),
				PropertiesRepository.getString("id.login.faculty.password.prod"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(10000);

		proctorChromePage.waitUntillElementIsVisible(
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on arrow icon in the Left Navigation header");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"), true);
		Thread.sleep(1000);
		log(logger, "Clicking on Student View link");
		proctorChromePage.clickButton(PropertiesRepository.getString("id.home.page.left.navigator.student.view.link"),
				1);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Student View Continue button");
		proctorChromePage.clickButton(PropertiesRepository.getString("modal.continue.btn"), 0);
		Thread.sleep(5000);
		proctorChromePage.waitUntillBufferInvisible(".modal-body>div>h3");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if 'Return to Faculty Account' link is displayed");
		VerificationHandler.verifyTrue(homePage.verifyLinkUsingIndex(
				PropertiesRepository.getString("new-atitesting.home.returnToFacultyAcc.link.loc"), 1));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Add Product button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.verifyAddProductPopup();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"),
				PropertiesRepository.getString("new-atitesting.add.product.productid.student.mimic"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,
				"Verifying 'This is a Faculty student account, Products have already been added to your account' error message.");
		VerificationHandler.verifyTrue(baseHandler
				.findElement(PropertiesRepository.getString("new.atitesting.add.product.error.msg.loc")).isDisplayed() && baseHandler
				.findElement(PropertiesRepository.getString("new.atitesting.add.product.error.msg.loc")).getText()
				.equals("This is a Faculty student account, Products have already been added to your account."));

		log(logger, "NewATI787_verifyAddProductStudentMimic end");

	}
	
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 8, enabled = true, alwaysRun = true, description = "NewATI-786:Verify account button functionality for faculty student mimic.")
	public void NewATI786_verifyActionBtnstudentMimic() throws Exception {

		log(logger, "NewATI786_verifyActionBtnstudentMimic Start");

		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(driver, PropertiesRepository.getString("id.login.faculty.username.prod"),
				PropertiesRepository.getString("id.login.faculty.password.prod"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(10000);
	
		proctorChromePage.waitUntillElementIsVisible(
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on arrow icon in the Left Navigation header");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"), true);

		log(logger, "Clicking on Student View link");
		proctorChromePage.clickButton(PropertiesRepository.getString("id.home.page.left.navigator.student.view.link"),
				1);
		Thread.sleep(1000);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Student View Continue button");
		proctorChromePage.clickButton(PropertiesRepository.getString("modal.continue.btn"), 0);
		Thread.sleep(5000);
		proctorChromePage.waitUntillBufferInvisible(".modal-body>div>h3");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if 'Return to Faculty Account' link is displayed on top right of student portal");
		VerificationHandler.verifyTrue(homePage.verifyLinkUsingIndex(
				PropertiesRepository.getString("new-atitesting.home.returnToFacultyAcc.link.loc"), 1));
		Thread.sleep(1000);
		log(logger, "Verifying if 'User Account' 'Online Store' ' Contact Us' links at the top will not be functional links");
		VerificationHandler.verifyTrue(homePage.verifyInactiveLinks());		
		
		log(logger, "NewATI786_verifyActionBtnstudentMimic end");

	}
	
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {"Regression"}, description="NewATI-784:Verify student user is able to login through emulator") 
	 public void NewATI784_VerifyLoginEmulator() throws Exception {
	  log(logger, "NewATI784_VerifyLoginEmulator Start");
	  
	  loginPage.enterURL("newati.stage.login.mu.url");
	  loginPage.loginIntoMU(PropertiesRepository.getString("new-atitesting.mu.username"), PropertiesRepository.getString("new-atitesting.mu.password"));
	  homePage.clickSystemAdmin("SYSTEM ADMINISTRATION");
	  homePage.clickMenuFromSystemAdmnstrtn("Management Utility");
	  tutorialPage.waitForAwhile(1000);
	  homePage.clickMenuFromMgmtUtility("Manage Users");
	  tutorialPage.waitForAwhile(1000);
	  log(logger, "Enter username for search");
	  homePage.enterTextInAttributeValue("new-atitesting.mu.search.username.loc",PropertiesRepository.getString("new-atitesting.mu.student.username"));
	  
	  log(logger, "click on go button");
	  homePage.clickGoButton();

	  log(logger, "click on row link Start");
	  homePage.clickOnRowLink("new-atitesting.mu.users.selected.row.loc",0);
	  tutorialPage.waitForAwhile(2000);
	 
	  log(logger, "click on Login As button");
	  homePage.click(PropertiesRepository.getString("new-atitesting.mu.users.loginas.button.loc"));
	  
	  windowhandler.switchToLatestWindow();
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  log(logger, "enter pwd");
	  textHandler.writeText(PropertiesRepository.getString("new-atitesting.emulator.student.pwd"),PropertiesRepository.getString("new-atitesting.mu.password"));

	  log(logger, "click on go button");
	  homePage.clickOnRowLink("new-atitesting.student.go.button",0);
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger, "verifying home page");
	  boolean result=loginPage.VerifyLoginsuccessfullasEmulator();
	  VerificationHandler.verifyTrue(result,"Unable to verify Student Sign On Message");
	  log(logger, "NewATI784_VerifyLoginEmulator End");
	 }
}