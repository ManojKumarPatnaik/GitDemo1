package com.automation.newati.login;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class ForgetPasswordTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage=new HomePage(driver);
		tutorialPage=new TutorialPage(driver);
	}

	@Test(priority = 1, enabled = true, alwaysRun = true, groups = {"Regression"}, description = "NewATI-535:Verify user can unlock the account using security questions.")
	public void NEWATI535_LockUser() throws Exception {
		log(logger, "NEWATI535_LockUser Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "Enter value in user name and password for First Time");
		if(count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
			logger.info("Inside @BeforeMethod userId --> " + userId);
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		logger.info("Inside userId --> " + userId);
		loginPage.loginToApplication(userId, PropertiesRepository.getString("new-atitesting.lock.password"));
		
		Thread.sleep(5000);
		log(logger, "Clicking Go Button 2nd time");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.goBtnLoc"), true);
		Thread.sleep(5000);
		Thread.sleep(5000);
		log(logger, "Clicking Go Button 3rd time");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.goBtnLoc"), true);
		Thread.sleep(5000);
		
		log(logger, "Clicking Go Button 4th time");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.goBtnLoc"), true);
		Thread.sleep(5000);
		
		log(logger, "Clicking Go Button 5th time");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.goBtnLoc"), true);
		Thread.sleep(5000);
		
		log(logger, "Clicking Go Button 6th time");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.goBtnLoc"), true);
		Thread.sleep(5000);
		
		log(logger, "Verifying Account is locker error message");
		VerificationHandler
				.verifyTrue(
						loginPage
								.verifyMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.account.lock.error.message"),
										PropertiesRepository
												.getString("new-atitesting.account.lock.error.message.value")),
						"Unable to verify account lock error message");
		log(logger, "NEWATI535_LockUser End");
	}

	@TestAnnotations(testID="NewATI-621")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"},  description = "Verifying new flow of username/password resetting from www.atitesting.com")
	public void NewATI621_checkForgetUserNameAndPassword() throws Exception {
		log(logger, "NewATI621_checkForgetUserNameAndPassword Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"),PropertiesRepository.getString("new-atitesting.forgot.pwd.user.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for first security question");
		loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for second security question");
		loginPage.clickStudentSecurityQuestion(1,PropertiesRepository.getString("new-atitesting.account.second.security.question.input"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for third security question");
		loginPage.clickStudentSecurityQuestion(2,PropertiesRepository.getString("new-atitesting.account.third.security.question.input"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter password");
		//loginPage.resetWithNewPassword("new-atitesting.new.reset.password","new-atitesting.new.reset.password");
		String password = CommonUtils.getRandomPassword();
		loginPage.resetWithNewPassword(password,
				password);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.third.page.continue.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on sign on now button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.sign.on.now.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter value in user name and password for First Time");
		loginPage.enterUserIdAndPwd(PropertiesRepository.getString("new-atitesting.forgot.pwd.user.name"),password);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		

		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.logout.loc"),"Login is not Successful");

		log(logger, "NewATI621_checkForgetUserNameAndPassword End");
	}

	@TestAnnotations(testID="INST-622")
	@Test(priority = 3, alwaysRun = true, description = " NewATI-622:Verify the login flow by answering security question")
	public void NewATI622_checkForgetUserNameAndPassword2() throws Exception {
		log(logger, "NewATI622_checkForgetUserNameAndPassword2 Start");

		log(logger, "Loging to newati application");
		loginPage.enterURL("newati.stage.login.url");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"),PropertiesRepository.getString("new-atitesting.forgot.pwd.user.name"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for first security question");
		loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for second security question");
		loginPage.clickStudentSecurityQuestion(1,PropertiesRepository.getString("new-atitesting.account.second.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for third security question");
		loginPage.clickStudentSecurityQuestion(2,PropertiesRepository.getString("new-atitesting.account.third.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter password");
		String password = CommonUtils.getRandomPassword();
		loginPage.resetWithNewPassword(password,password);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.third.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Login to current ATI Faculty application for First Time");
		loginPage.loginToFacultyApplication(PropertiesRepository.getString("newati.newfaculty.stage.login.url"),PropertiesRepository.getString("new-atitesting.forgot.pwd.user.name"),password);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(loginPage.verifyErrorMessage(PropertiesRepository.getString("ATIFaculty.login.page.errorMsg.loc"), PropertiesRepository.getString("newati.newfaculty.stage.login.errorMsg")));
		
		log(logger, "NewATI622_checkForgetUserNameAndPassword2 End");
	}

	@Test(priority = 4, alwaysRun = true, description = " NewATI-623:Verify the login flow by answering security question from stage-www.atitesting.com")
	public void NewATI623_checkForgetUserNameAndPassword3() throws Exception {
		log(logger, "NewATI623_checkForgetUserNameAndPassword3 Start");

		log(logger, "Loging to current ati application");
		loginPage.enterURL("newati.newfaculty.stage.login.url");
		tutorialPage.waitForAwhile(10000);
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("ATIFaculty.atitesting.faculty.forgot.password.link");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on password button");
		loginPage.clickButtonATiFaculty(PropertiesRepository.getString("ATIFaculty.atitesting.faculty.username.password.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("ATIFaculty.atitesting.faculty.username.textbox"),PropertiesRepository.getString("new-atitesting.forgot.pwd.user.name"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");			
		log(logger, "click on continue button");
		loginPage.clickButtonATiFaculty(PropertiesRepository.getString("ATIFaculty.atitesting.faculty.secutiry.question.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input's for all the security question");
		loginPage.enterSecurityQuesAnswers(PropertiesRepository.getString("ATIFaculty.atitesting.secutiry.question.one"),PropertiesRepository.getString("new-atitesting.account.first.security.question.input"),PropertiesRepository.getString("new-atitesting.account.second.security.question.input"),PropertiesRepository.getString("new-atitesting.account.third.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButtonATiFacultyWithIndex(PropertiesRepository.getString("ATIFaculty.atitesting.secutiry.question.continue.button2"),1);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter password");
		String password = CommonUtils.getRandomPassword();
		loginPage.currentAtiFacultyResetPassword(password,password);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButtonATiFacultyWithIndex(PropertiesRepository.getString("ATIFaculty.atitesting.secutiry.question.continue.button2"), 1);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		log(logger, "click on sign on now button");
		loginPage.clickButtonATiFaculty(PropertiesRepository.getString("ATIFaculty.atitesting.sign.on.now.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Login to current ATI Faculty application for First Time");
		loginPage.loginToFacultyApplication(PropertiesRepository.getString("newati.newfaculty.stage.login.url"),PropertiesRepository.getString("new-atitesting.forgot.pwd.user.name"),password);
		tutorialPage.waitForAwhile(10000);
		VerificationHandler.verifyTrue(loginPage.verifyErrorMessage(PropertiesRepository.getString("ATIFaculty.login.page.errorMsg.loc"), PropertiesRepository.getString("newati.newfaculty.stage.login.errorMsg")));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI623_checkForgetUserNameAndPassword3 End");
	}

	@Test(priority = 5, alwaysRun = true, description = " NewATI-532:Verify New flow; Forgot username/password link:STU-4193,STU-4256.")
	public void NewATI532_checkForgetUserNameAndPassword4() throws Exception {
		log(logger, "NewATI-532_checkForgetUserNameAndPassword Start");

		log(logger, "Loging to newati application");
		loginPage.enterURL("newati.stage.login.url");
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"),PropertiesRepository.getString("new-atitesting.forgot.pwd.user.name"));
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for first security question");
		loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input"));
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for second security question");
		loginPage.clickStudentSecurityQuestion(1,PropertiesRepository.getString("new-atitesting.account.second.security.question.input"));

		log(logger, "enter input for third security question");
		loginPage.clickStudentSecurityQuestion(2,PropertiesRepository.getString("new-atitesting.account.third.security.question.input"));

		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter password");
		String password = CommonUtils.getRandomPassword();
		loginPage.resetWithNewPassword(password,password);

		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.third.page.continue.button"));
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Login to current ATI Faculty application for First Time");
		
		loginPage.loginToFacultyApplication(PropertiesRepository.getString("newati.newfaculty.stage.login.url"),PropertiesRepository.getString("new-atitesting.forgot.pwd.user.name"),password);
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(loginPage.verifyErrorMessage(PropertiesRepository.getString("ATIFaculty.login.page.errorMsg.loc"), PropertiesRepository.getString("newati.newfaculty.stage.login.errorMsg")));
		log(logger, "NewATI-532_checkForgetUserNameAndPassword End");
	}

	@Test(priority = 6, enabled = true, alwaysRun = true, description = "NewATI-562:Verification for removal of invalid message for Inactive users")
	public void NewATI562_InvalidMessageForInactiveUsers() throws Exception {
		log(logger, "NewATI562_InvalidMessageForInactiveUsers Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Enter value in user name and password");
		loginPage.enterUserIdAndPwd(PropertiesRepository.getString("new-atitesting.inactive2.user.name"),
				PropertiesRepository.getString("new-atitesting.inactive2.password"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Inactive account error message in popup");
		loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.inactive.error.message"),0,
						PropertiesRepository.getString("new-atitesting.account.inactive.error.mesage.in.popup"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for first security question");
		loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for second security question");
		loginPage.clickStudentSecurityQuestion(1,PropertiesRepository.getString("new-atitesting.account.second.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for third security question");
		loginPage
				.clickStudentSecurityQuestion(2,PropertiesRepository.getString("new-atitesting.account.third.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter password");
		String password = CommonUtils.getRandomPassword();
		loginPage.resetWithNewPassword(password,
				password);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.third.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		/*loginPage
		.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");*/
		
		log(logger, "Verifying Password Change success message");
		VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.username.email.password.change.success.message.loc"),
										PropertiesRepository
												.getString("new-atitesting.username.email.password.change.success.message.value")),
						"Unable to verify Passord Change Success Message");

		log(logger, "NewATI562_InvalidMessageForInactiveUsers End");
	}

	@Test(priority = 7, enabled = true, alwaysRun = true, description = "NewATI-563:Verify error message for invalid email added inforget username functionality for non account holder")
	public void NewATI563_VerifyErrorMessageForInvalidEmail() throws Exception {
		log(logger, "NewATI563_VerifyErrorMessageForInvalidEmail End");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on forget password link");
		loginPage
				.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on username button");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.username.password.button"), 0);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter Invalid Email id Format");
		loginPage.enterValue(PropertiesRepository
				.getString("new-atitesting.username.email.textbox"),
				PropertiesRepository
						.getString("new-atitesting.username.invalid.email.id"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Continue Button");
		loginPage
				.clickButton(PropertiesRepository
						.getString("new-atitesting.username.email.continue.button.loc"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Invalid Email Error Message");
		VerificationHandler
				.verifyTrue(
						loginPage
								.verifyContainsMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.username.email.error.message.loc"),
										PropertiesRepository
												.getString("new-atitesting.username.invalid.email.message")),
						"Unable to verify Email Error Message");

		log(logger, "NewATI563_VerifyErrorMessageForInvalidEmail End");
	}

	@Test(priority = 8, enabled = true, alwaysRun = true, description = "NewATI-564:Verify forget username functionality for non account user:STU-4679")
	public void NewATI564_VerifyErrorMessageForNonAccUser() throws Exception {
		log(logger, "NewATI564_VerifyErrorMessageForNonAccUser End");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "click on forget password link");
		loginPage
				.clickForgotPasswordLink("new-atitesting.forgot.password.link");

		log(logger, "click on username button");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.username.password.button"), 0);

		log(logger, "Enter Invalid Email id Format");
		loginPage
				.enterValue(
						PropertiesRepository
								.getString("new-atitesting.username.email.textbox"),
						PropertiesRepository
								.getString("new-atitesting.username.invalid.email.for.non.acc.user"));

		log(logger, "Clicking on Continue Button");
		loginPage
				.clickButton(
						PropertiesRepository
								.getString("new-atitesting.username.email.continue.button.loc"),
						false);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Toast Email Message");
		VerificationHandler
				.verifyTrue(
						loginPage
								.verifyContainsMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.toast.message"),
										PropertiesRepository
												.getString("new-atitesting.username.email.toast.message.value")),
						"Unable to verify Email Error Message");

		log(logger, "NewATI564_VerifyErrorMessageForNonAccUser End");
	}

	@TestAnnotations(testID="NewATI-536")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = "{Smoke}", description = "Verify user can unlock the account using Email Id.::LoginPage")
	public void NewATI536_VerifyUnLockAccUsingEmailId() throws Exception {
		log(logger, "NewATI536_VerifyUnLockAccUsingEmailId End");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "click on forget password link");
		loginPage
				.clickForgotPasswordLink("new-atitesting.forgot.password.link");

		log(logger, "click on username button");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.username.password.button"), 0);

		log(logger, "Enter Emaild Id");
		loginPage.enterValue(PropertiesRepository
				.getString("new-atitesting.username.textbox"),"murali.inbasekaran@happiestminds.com");

		
		/*log(logger, "Clicking on Email Radio Button");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.email.radio.button"));*/

		log(logger, "Clicking on Continue Button");
		loginPage
				.clickButton(
						PropertiesRepository
								.getString("new-atitesting.username.email.continue.button.loc"),
						false);

		log(logger, "Verifying Toast Email Message"); // Valid Email ID.
														// murali.inbasekaran@happiestminds.com
		VerificationHandler
				.verifyTrue(
						loginPage
								.verifyContainsMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.toast.message"),
										PropertiesRepository
												.getString("new-atitesting.username.email.toast.message.value")),
						"Unable to verify Email Error Message");

		log(logger, "NewATI536_VerifyUnLockAccUsingEmailId End");
	}

	@Test(priority = 10, enabled = true, alwaysRun = true, description = "NewATI-565:Verify reactivation of student account via security question flow")
	public void NewATI565_ReactivationStudAccViaSecurityQues() throws Exception {
		log(logger, "NewATI565_ReactivationStudAccViaSecurityQues End");
		
		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "Enter value in user name and password");
		loginPage.enterUserIdAndPwd(PropertiesRepository.getString("new-atitesting.inactive1.user.name1"),PropertiesRepository.getString("new-atitesting.inactive1.password1"));

		log(logger, "Verifying Inactive account error message in popup");
		loginPage
				.verifyMessageWithDefaultWinSwitch(
						PropertiesRepository
								.getString("new-atitesting.inactive.error.message"),0,
						PropertiesRepository
								.getString("new-atitesting.account.inactive.error.mesage.in.popup"));

		log(logger, "Clicking on Continue Button");
		  loginPage
		    .clickButton(
		      PropertiesRepository
		        .getString("new-atitesting.password.page.continue.button"), false);

		  log(logger, "enter input for first security question");
		  loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.fourth.security.question.input4"));

		  log(logger, "enter input for second security question");
		  loginPage.clickStudentSecurityQuestion(1,PropertiesRepository.getString("new-atitesting.account.fourth.security.question.input4"));

		  log(logger, "enter input for third security question");
		  loginPage.clickStudentSecurityQuestion(2,PropertiesRepository.getString("new-atitesting.account.fourth.security.question.input4"));
		  
		  log(logger, "click on continue button");
		  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
		  VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(
		          PropertiesRepository.getString("new-atitesting.username.email.error.message.loc"),
		          PropertiesRepository.getString("new-atitesting.security.question.1.correct.answer.error.message")),
		      "Unable to verify 1 correct password error Message");
		  
		  log(logger, "answer security questions second time");
		  
		  log(logger, "enter input for first security question");
		  loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input1"));

		  log(logger, "enter input for second security question");
		  loginPage
		    .clickStudentSecurityQuestion(
		      1,
		      PropertiesRepository
		        .getString("new-atitesting.account.second.security.question.input2"));

		  log(logger, "enter input for third security question");
		  loginPage
		    .clickStudentSecurityQuestion(
		      2,
		      PropertiesRepository
		        .getString("new-atitesting.account.third.security.question.input3"));
		  
		  log(logger, "click on continue button");
		  loginPage
		    .clickButton(PropertiesRepository
		      .getString("new-atitesting.password.second.page.continue.button"));

		  log(logger, "enter password");
		  String password = CommonUtils.getRandomPassword();
		  loginPage.resetWithNewPassword(password,password);
		  loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		  log(logger, "click on continue button");
		  loginPage
		    .clickButton(PropertiesRepository
		      .getString("new-atitesting.password.third.page.continue.button"));

		  log(logger, "Verifying Password Change success message");
		  VerificationHandler
		    .verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository
		            .getString("new-atitesting.username.email.password.change.success.message.loc"),
		          PropertiesRepository
		            .getString("new-atitesting.username.email.password.change.success.message.value")),
		      "Unable to verify Passord Change Success Message");
		
		log(logger, "NewATI565_ReactivationStudAccViaSecurityQues End");
	}
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 11, enabled = true, alwaysRun = true, description = "NewATI-44:Forgot Username Password Link verification")
	public void NewATI44_ForgotLinkVerification() throws Exception {

		log(logger, "NewATI44_ForgotLinkVerification Start");

		log(logger, "Navigate to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");

		log(logger, "Verify Forgot Username/Password modal is displayed");
		VerificationHandler.verifyTrue(
				homePage.VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.puse.banner.info.popup.forgot.loc", 0,
						"new-atitesting.homepage.forgot.pass.usename.poup.title"));

		log(logger, "click on username button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 0);

		log(logger, "Verify Forgot Username/Password modal is displayed");
		VerificationHandler.verifyTrue(
				homePage.VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.puse.banner.info.popup.forgot.loc", 0,
						"new-atitesting.homepage.forgot.pass.usename.poup.title"));

		log(logger, "Verify if 'Step 2: Enter your email address  modal is displayed.'");
		VerificationHandler.verifyTrue(loginPage.verifyEmailAddressLableInModel());

		log(logger, "NewATI44_ForgotLinkVerification End");
	}
	
}
