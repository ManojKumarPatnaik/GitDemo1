package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.CheckboxHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.utils.SizzleSelector;

public class PaymentsPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	private LinkHandler linkHandler;
	private boolean flag = false;
	private DropDownHandler dropDownHandler;
	private BaseHandler baseHandler;
	private TextHandler textHandler;
	private NewATIBasePage newAtiBasePage;
	private CheckboxHandler checkBoxHandler;
	private String result;
	private TutorialPage tutorialPage;
	SizzleSelector sizzleSelector = new SizzleSelector(driver);
	private HomePage homePage;
	
	public PaymentsPage(WebDriver webDriver) {
		super(webDriver);
		buttonHandler = new ButtonHandler(driver);
		baseHandler = new BaseHandler(driver);
		linkHandler = new LinkHandler(driver);
		windowHandler = new WindowHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		textHandler = new TextHandler(driver);
		newAtiBasePage = new NewATIBasePage(driver);
		checkBoxHandler = new CheckboxHandler(driver);
		tutorialPage = new TutorialPage(driver);
		homePage=new HomePage(driver);
	}

	/**
	 * 
	 * @param loc
	 * @param code
	 * @param paymentClass
	 * @throws Exception
	 */
	public void enterPaymentCode(String loc, String code, String paymentClass) throws Exception {
		logger.info("Method : enterPaymentCode Start");
		try {
			List<WebElement> findElements = baseHandler.findElements(loc);
			if (CollectionUtils.isNotEmpty(findElements)) {
				findElements.get(0).sendKeys(code);
				findElements.get(1).sendKeys(paymentClass);
				clickButton(PropertiesRepository.getString("newati.payment.mypurchase.submit.loc"));
			}
		}catch (Exception e) {
    		logger.info("Unable to enterPaymentCode" );
			log(logger, "Unable to enterPaymentCode" );
    		throw new DriverException("Unable to enterPaymentCode" , e); 
    	}
		logger.info("Method: enterPaymentCode End ");
		

	}

	/**
	 * 
	 * @param loc
	 * @return
	 */
	public boolean isPaymentInfoDisplayed(String loc) throws Exception{
		logger.info("Method : isPaymentInfoDisplayed Start");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> findElements = baseHandler.findElements(loc);
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository.getString("newati.payment.mypurchase.institution.input"));
			if (CollectionUtils.isNotEmpty(findElements) && CollectionUtils.isNotEmpty(elements)
					&& findElements.get(0).isDisplayed() && findElements.get(1).isDisplayed()
					&& findElements.get(2).isDisplayed() && elements.get(0).isDisplayed()) {
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to isPaymentInfoDisplayed" );
			log(logger, "Unable to isPaymentInfoDisplayed" );
    		throw new DriverException("Unable to isPaymentInfoDisplayed" , e); 
    	}
		logger.info("Method: isPaymentInfoDisplayed End flag --> " + flag);
		return flag;
	}

	public boolean verifypurchasePageObjectPresence(String loc) throws Exception {
		logger.info("Method : verifypurchasePageObjectPresence Start");
		boolean flag = false;
		try {

			List<WebElement> findElements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(findElements) && findElements.get(0).isDisplayed()
					&& findElements.get(1).isDisplayed() && findElements.get(2).isDisplayed()
					&& findElements.get(3).isDisplayed() && findElements.get(4).isDisplayed()) {
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to verifypurchasePageObjectPresence" );
			log(logger, "Unable to verifypurchasePageObjectPresence" );
    		throw new DriverException("Unable to verifypurchasePageObjectPresence" , e); 
    	}
		logger.info("Method: verifypurchasePageObjectPresence End flag --> " + flag);
		return flag;
	}

	/**
	 * verify success message and description and price presence.
	 * 
	 * @return
	 */
	public boolean verifyingOrderSummaryPage() throws Exception {
		logger.info("Method : verifyingOrderSummaryPage Start");
		boolean flag = false;
		try {
			List<WebElement> findElements = baseHandler
					.findElements(PropertiesRepository.getString("newati.payment.mypurchase.success.msg"));
			List<WebElement> elements1 = baseHandler.findElements(
					PropertiesRepository.getString("newati.payment.mypurchase.order.summary.page.description"));
			if (CollectionUtils.isNotEmpty(findElements) && CollectionUtils.isNotEmpty(elements1) && elements1.size() == 2
					&& PropertiesRepository.getString("newati.payment.mypurchase.success.msg.input")
							.equalsIgnoreCase(findElements.get(0).getText())) {
				flag = true;

			}
		}catch (Exception e) {
    		logger.info("Unable to verifyingOrderSummaryPage" );
			log(logger, "Unable to verifyingOrderSummaryPage" );
    		throw new DriverException("Unable to verifyingOrderSummaryPage" , e); 
    	}
		logger.info("Method: verifyingOrderSummaryPage End flag --> " + flag);
		return flag;
	}

	public boolean verifyingOrderSummaryPageObjects() throws Exception {
		logger.info("Method : verifyingOrderSummaryPageObjects Start");
		boolean flag = false;
		try {
			WebElement element = baseHandler
					.findElement(PropertiesRepository.getString("newati.payment.mypurchase.class.code.loc"));
			WebElement element1 = baseHandler
					.findElement(PropertiesRepository.getString("newati.payment.mypurchase.institution.name.loc"));
			WebElement element2 = baseHandler
					.findElement(PropertiesRepository.getString("newati.payment.mypurchase.datetime.loc"));
			WebElement element3 = baseHandler
					.findElement(PropertiesRepository.getString("newati.payment.mypurchase.student.loc"));
			WebElement element4 = baseHandler
					.findElement(PropertiesRepository.getString("newati.payment.mypurchase.print.receipt.loc"));

			if (element.isDisplayed() && element1.isDisplayed() && element2.isDisplayed() && element3.isDisplayed()
					&& element4.isDisplayed()) {
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyingOrderSummaryPageObjects" );
			log(logger, "Unable to verifyingOrderSummaryPageObjects" );
    		throw new DriverException("Unable to verifyingOrderSummaryPageObjects" , e); 
    	}
		logger.info("Method: verifyingOrderSummaryPageObjects End flag --> " + flag);
		return flag;
	}

	public boolean verifyOrderDetails(String loc) throws Exception {
		logger.info("Method : verifyOrderDetails Start");
		boolean flag = false;
		try {
			ArrayList<Boolean> list = new ArrayList<Boolean>();
			List<WebElement> findElements = baseHandler.findElements(PropertiesRepository.getString(loc));
			String[] stringAsArray = PropertiesRepository.getStringAsArray("newati.payment.mypurchase.order.info");
			if (CollectionUtils.isNotEmpty(findElements)) {
				for (int i = 0; i < findElements.size(); i++) {
					if (findElements.get(i).getText().contains(stringAsArray[i])) {
						list.add(true);

					} else {
						list.add(false);
					}

				}
				flag = list.contains(false) ? false : true;

			}
		}catch (Exception e) {
    		logger.info("Unable to verifyOrderDetails" );
			log(logger, "Unable to verifyOrderDetails" );
    		throw new DriverException("Unable to verifyOrderDetails" , e); 
    	}
		logger.info("Method: verifyOrderDetails End flag --> " + flag);
		return flag;
	}

	/**
	 * 
	 * This Method is used to enter coupon code.
	 * 
	 * @param input
	 * @throws DriverException
	 */
	public void enterCouponCode(String input) throws DriverException {
		logger.info("Method: enterCouponCode method Starts");
		try {
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository.getString("newati.payment.mypurchase.coupon.code.loc"));
			if (CollectionUtils.isNotEmpty(elements)) {
				elements.get(0).sendKeys(PropertiesRepository.getString(input));
				tutorialPage.clickButtonFromList("newati.payment.mypurchase.apply.loc", 7);

			}
		} catch (Exception e) {
			throw new DriverException("User unable to enter coupon code", e);
		}
		logger.info("Method: enterCouponCode method ends");
	}

	public boolean verifyAddressInformationPage() throws Exception  {
		logger.info("Method : verifyAddressInformationPage Start");
		boolean flag = false;
		try {
			if (baseHandler.findElement(PropertiesRepository.getString("newati.payment.address.page.fname")).getText()
					.isEmpty()
					&& baseHandler.findElement(PropertiesRepository.getString("newati.payment.address.page.address"))
							.getText().isEmpty()
					&& baseHandler.findElement(PropertiesRepository.getString("newati.payment.address.page.city")).getText()
							.isEmpty()) {
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyAddressInformationPage" );
			log(logger, "Unable to verifyAddressInformationPage" );
    		throw new DriverException("Unable to verifyAddressInformationPage" , e); 
    	}
		logger.info("Method: verifyAddressInformationPage End flag --> " + flag);
		return flag;
	}

	public void enterCardDetails() throws Exception {
		logger.info("enterCardDetails start");
		try {
			
			windowHandler.switchToFrame("paymentFrame");
			windowHandler.switchToFrame("braintree-dropin-frame");
			tutorialPage.enterText("newati.payment.credit.card.no", "newati.payment.credit.card.details", 0);
			tutorialPage.enterText("newati.payment.credit.card.expiration", "newati.payment.credit.card.expiration.details",
					0);
			tutorialPage.enterText("newati.payment.credit.card.cvv", "newati.payment.credit.card.cvv.info", 0);
		} catch(Exception e) {
			throw new DriverException("Unable to enterCardDetails", e);
		}
		logger.info("enterCardDetails end");
	}
	
	
	public void enterMasterCardDetails() throws Exception {
		logger.info("enterMasterCardDetails start");
		try {
			windowHandler.switchToFrame("paymentFrame");
			windowHandler.switchToFrame("braintree-dropin-frame");
			tutorialPage.enterText("newati.payment.credit.card.no", "new-atitesting.MastercreditcardNoInput", 0);
			tutorialPage.enterText("newati.payment.credit.card.expiration", "new-atitesting.MastercreditcardExpInput",
					0);
			tutorialPage.enterText("newati.payment.credit.card.cvv", "newati.payment.credit.card.cvv.info", 0);
		} catch(Exception e) {
			throw new DriverException("Unable to enterCardDetails", e);
		}
		logger.info("enterMasterCardDetails end");
	}
	
	public void enterDiscoverCardDetails() throws Exception {
		logger.info("enterDiscoverCardDetails start");
		try {
			windowHandler.switchToFrame("paymentFrame");
			windowHandler.switchToFrame("braintree-dropin-frame");
			tutorialPage.enterText("newati.payment.credit.card.no", "new-atitesting.discovercreditcardNoInput", 0);
			tutorialPage.enterText("newati.payment.credit.card.expiration", "new-atitesting.discovercreditcardExpInput",
					0);
			tutorialPage.enterText("newati.payment.credit.card.cvv", "new-atitesting.discovercreditcardCVVUInput", 0);
		} catch(Exception e) {
			throw new DriverException("Unable to enterCardDetails", e);
		}
		logger.info("enterDiscoverCardDetails end");
	}
	
	
	public void enterAmericanCardDetails() throws Exception {
		logger.info("enterCardDetails start");
		try {
			windowHandler.switchToFrame("paymentFrame");
			windowHandler.switchToFrame("braintree-dropin-frame");
			tutorialPage.enterText("newati.payment.credit.card.no", "new-atitesting.AmxcreditcardNoInput", 0);
			tutorialPage.enterText("newati.payment.credit.card.expiration", "new-atitesting.AmxcreditcardExpInput",
					0);
			tutorialPage.enterText("newati.payment.credit.card.cvv", "new-atitesting.AmxcreditcardCVVUInput", 0);
		} catch(Exception e) {
			throw new DriverException("Unable to enterCardDetails", e);
		}
		logger.info("enterCardDetails end");
	}

	/**
	 * Entering Shipping Phone Number
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public void enterShippingPhoneNo() throws Exception {
		logger.info("Method: enterShippingPhoneNo Starts");
		try {
			// enter phone Number
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.shipping.phoneLoc")));
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.phoneLoc"),
					PropertiesRepository.getString("new-atitesting.payments.phoneInpt"));
			newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.shipping.phoneLoc"));
			Thread.sleep(10000);
			/*
			 * driver.findElement(By.cssSelector(PropertiesRepository
			 * .getString("new-atitesting.shipping.phoneLoc"))).sendKeys("0");
			 * newAtiBasePage.clickTab(PropertiesRepository.getString(
			 * "new-atitesting.shipping.phoneLoc"));
			 */
		} catch (DriverException e) {
			logger.info("Unable to enter Shipping Phone No");
			throw new DriverException("Unable to enter Shipping Phone No", e);
		}
		logger.info("Method: enterShippingPhoneNo End ");
	}

	/**
	 * Entering shipping Email ID.
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public void enterShippingEmailId() throws DriverException {
		logger.info("Method: enterShippingEmailId Starts");
		try {
			// enter email ID
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.shipping.emailLoc")));
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.emailLoc"),
					PropertiesRepository.getString("new-atitesting.shipping.emailTnput"));
			newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.shipping.emailLoc"));
		} catch (DriverException e) {
			logger.info("Unable to enter Shipping Email Id");
			throw new DriverException("Unable to enter Shipping Email Id", e);
		}
		logger.info("Method: enterShippingEmailId End ");
	}

	public String clickOnSubmitBtn() throws DriverException {
		logger.info("Method: clickOnSubmitBtn Starts");
		String value = "";
		try {
			Thread.sleep(5000);
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.paymentsSubmitbuttonLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			Thread.sleep(10000);
		} catch (Exception e) {
			throw new DriverException("Unable to click on Submit Button", e);
		}

		value = textHandler.getText(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc"));
		logger.info("Method: clickOnSubmitBtn Ends");
		return value;
	}

	public String clickOnContinueBtn(boolean bool) throws DriverException {
		logger.info("Method: clickOnContinueBtn Starts");
		String value = "";
		try {
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.ContinueLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			throw new DriverException("Unable to click on Continue Button", e);
		}
		value = textHandler.getText(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc"));
		if (bool) {
			String[] frameList = windowHandler.listFrames();
			for (String frameName : frameList) {
				System.out.println("Frame Names --> " + frameName);
			}
			windowHandler.switchToMainWindow();
			windowHandler.switchToFrame("paymentFrame");
			windowHandler.switchToFrame("braintree-dropin-frame");
			// setDriverWait(PropertiesRepository.getString("new-atitesting.creditcardNoLoc"));

		}

		logger.info("Method: clickOnContinueBtn Ends");
		return value;
	}

	public String verifyOrderSummaryPage(String loc) throws DriverException {

		logger.info("Method: verifyOrderSummaryPage Starts");
		String value = "";
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			//Thread.sleep(90000);
			value = textHandler.getText(loc);
		} catch (Exception e) {
			throw new DriverException("Unbale to fetch the order summary page header", e);
		}

		logger.info("Method: verifyOrderSummaryPage Ends value --> " + value);
		return value;

	}
	
	/**
	 * Verify Order Summary Page (Description, Assessment name ,Tax Amount,
	 * Total, Student Name, Name on Credit Card, Date and Time Paid,
	 * Institution)
	 * 
	 * @author syed.pashas
	 * @throws DriverException
	 */
	public boolean verifyOrderSummaryPageAllFields() throws DriverException {

		logger.info("Method: verifyOrderSummaryPage Starts");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			windowHandler.switchToLatestWindow();
			WebElement description = baseHandler.findElement("#PurchaseSummary .custom-table.order-detail-table>tbody>tr>th");
			WebElement assessmentName = baseHandler.findElement("#PurchaseSummary .custom-table.order-detail-table>tbody>tr td span[data-bind='text: PurchaseResultDescription']");
			WebElement price = baseHandler.findElement("#PurchaseSummary .custom-table.order-detail-table>tbody>tr td span[data-bind='currency: PurchaseResultPrice']");
			WebElement taxAmount = baseHandler.findElement("#PurchaseSummary .custom-table.order-detail-table>tbody>tr td span[data-bind='currency: TaxAmount']");
			WebElement total = baseHandler.findElement("#PurchaseSummary .custom-table.order-detail-table>tbody>tr td span[data-bind='currency: PurchaseResultTotal']");
			WebElement studentName = baseHandler.findElement("#PurchaseSummary .student-pay-details ul li span[data-bind='text: PurchaseResultFullName']");
			WebElement nameOnCC = baseHandler.findElement("#PurchaseSummary .student-pay-details ul li span[data-bind='text: BillingFullName']");
			WebElement dateAndTime = baseHandler.findElement("#PurchaseSummary .student-pay-details ul li span[data-bind='text: PurchaseResultPaymentDateTime']");
			WebElement institution = baseHandler.findElement("#PurchaseSummary .student-pay-details ul li span[data-bind='text: InstitutionName']");
			if(description.isDisplayed() && assessmentName.isDisplayed() && price.isDisplayed() && taxAmount.isDisplayed() && total.isDisplayed() && studentName.isDisplayed() && nameOnCC.isDisplayed() && dateAndTime.isDisplayed() && institution.isDisplayed()){
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unbale to fetch the order summary page header", e);
		}

		logger.info("Method: verifyOrderSummaryPage Ends");
		return flag;

	}
	

	public void enterShippingAddressDetails() throws Exception {
		logger.info("enterShippingAddressDetails start");
		try {
			tutorialPage.enterText("newati.payment.email", "newati.payment.email.info", 0);
			tutorialPage.enterText("newati.payment.phone.no", "newati.payment.phone.no.info", 0);
			WebElement element = baseHandler.findElement(PropertiesRepository.getString("newati.payment.phone.no"));
			element.sendKeys(Keys.TAB);
			element.sendKeys(Keys.TAB);
 		
		} catch(Exception e) {
 			throw new DriverException("Unable to enterShippingAddressDetails", e);
 		}
		logger.info("enterShippingAddressDetails end");
	}

	/**
	 * Method to close current window.
	 * 
	 * @throws Exception
	 */
	public void closeCurrentOnlinePaymentWindow(String mainWindowHandler) throws Exception {
		logger.info("Method: closeCurrentOnlinePaymentWindow Starts");
    	try {
    		for (String winHandle : driver.getWindowHandles()) {
    		    driver.switchTo().window(winHandle);
    		}
    		driver.close();
    		driver.switchTo().window(mainWindowHandler);
    	} catch (Exception e) {
    		logger.info("Unable to close Current Online Payment Window" );
    		log(logger, "Unable to close Current Online Payment Window" );
    		throw new DriverException("Unable to close Current Online Payment Window" , e); 
    	}
    	logger.info("Method: closeCurrentOnlinePaymentWindow End " );
	}
	
	/**
	 * Method is used to verify footer message in Order Details page. 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyOrderDetailsFooterMessage() throws Exception {
		logger.info("Method: verifyOrderDetailsFooterMessage Starts");
		result = null;
		flag = false;
		try {
			if (baseHandler
					.isDisplayed(baseHandler.findElement(PropertiesRepository
							.getString("new-atitesting.order.history.order.details.footer.message.loc")))) {
				List<WebElement> footerElement = baseHandler
						.findElements(PropertiesRepository
								.getString("new-atitesting.order.history.order.details.footer.message.loc"));
				if (CollectionUtils.isNotEmpty(footerElement)) {
					String firstMessage = footerElement.get(0).getText().trim();
					String secondMessage = footerElement.get(1).getText()
							.trim();

					if (StringUtils.isNotBlank(firstMessage)
							&& StringUtils.isNotBlank(secondMessage)) {
						if (PropertiesRepository
								.getString(
										"new-atitesting.order.history.order.details.footer.message.value.1")
								.equalsIgnoreCase(firstMessage)) {
							if (PropertiesRepository
									.getString(
											"new-atitesting.order.history.order.details.footer.message.value.2")
									.equalsIgnoreCase(secondMessage)) {
								flag = true;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Order Details Footer Message");
			throw new Exception("Unable to verify Order Details Footer Message", e);
		}
		logger.info("Method: verifyOrderDetailsFooterMessage --> " + flag);
		return flag;
	}
	
	/**
	 * Method to verify Payment Success Message. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPaymentSuccessMessage() throws Exception {
		logger.info("Method: verifyFacultyProductTabAssessment Starts");
		boolean flag = false;
    	try {
    		baseHandler.waitToBeDisplayed(PropertiesRepository
					.getString("new-atitesting.online.store.receipt.page.header.loc"));
    		String successMessage = getText(PropertiesRepository.getString("new-atitesting.online.store.receipt.page.header.loc"));
    		if(successMessage.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.online.store.receipt.page.header.message.value"))) {
    			flag = true;
    		}
    	} catch (DriverException e) {
    		logger.info("Unable to verify Faculty User Product Tab ");
    		throw new DriverException("Unable to verify Faculty User Product Tab " , e); 
    	}
    	logger.info("Method: verifyFacultyProductTabAssessment End flag --> " + flag);
    	return flag;
		
	}
	
	public void clickOnAddProductButton() throws DriverException {
		logger.info("Method : clickOnAddProductButton :::::::: Starts");
		try {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					PropertiesRepository.getString("new-atitesting.createaccount.addProductButtonLoc"))));
			// click on Add Product button
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.createaccount.addProductButtonLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		} catch (Exception e) {
			throw new DriverException("Unable to click on Add Product Button", e);
		}
		logger.info("Method : clickOnAddProductButton :::::::: Ends");
	}

	public void enterSelfPayProductID(String input) throws DriverException {
		logger.info("Method : enterSelfPayProductID :::::::: Starts");
		result = null;
		try {
			textHandler.writeText(
					PropertiesRepository.getString("new-atitesting.createaccount.addProductTextFieldLocnew"), input);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			newAtiBasePage
					.clickTab(PropertiesRepository.getString("new-atitesting.createaccount.addProductTextFieldLocnew"));
		} catch (Exception e) {
			throw new DriverException("Unable to Enter ProductID to Add Product Button", e);
		}
		logger.info("Method : enterSelfPayProductID :::::::: Ends " + result);
	}

	public void enterSelfPayProductPassword(String input) throws DriverException {
		logger.info("Method : enterSelfPayProductPassword :::::::: Starts");
		result = null;
		try {
			textHandler.writeText(
					PropertiesRepository.getString("new-atitesting.createaccount.productPasswordFieldLoc"), input);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			newAtiBasePage
					.clickTab(PropertiesRepository.getString("new-atitesting.createaccount.productPasswordFieldLoc"));
		} catch (Exception e) {
			throw new DriverException("Unable to Enter Product password to Add Product Button", e);
		}
		logger.info("Method : enterSelfPayProductPassword :::::::: Ends " + result);
	}

	public String clickOnAddProductContinueButton(boolean bool) throws DriverException {
		logger.info("Method : clickOnAddProductContinueButton :::::::: Starts");
		String result = null;
		try {
			// click on Add Product button
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.ContinueLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			homePage.scrollUpPage();
			if (bool) {
				result = textHandler.getText(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2"));
				
			}

		} catch (Exception e) {
			throw new DriverException("Unbale to click on Continue button", e);
		}
		logger.info("Method : clickOnAddProductContinueButton :::::::: End  " + result);
		return result;
	}
	
	public String clickOnAddProductContinueButtonNew(boolean bool) throws DriverException {
		logger.info("Method : clickOnAddProductContinueButton :::::::: Starts");
		String result = null;
		try {
			// click on Add Product button
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.ContinueLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if (bool) {
				result = textHandler
						.getText(PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc"));
			}

		} catch (Exception e) {
			throw new DriverException("Unbale to click on Continue button", e);
		}
		logger.info("Method : clickOnAddProductContinueButton :::::::: End  " + result);
		return result;
	}
	
	public String clickOnAddProductContinueButton1(boolean bool) throws DriverException {
		logger.info("Method : clickOnAddProductContinueButton :::::::: Starts");
		String result = null;
		try {
			// click on Add Product button
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.ContinueLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if (bool) {
				result = textHandler
						.getText(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc.newloc"));
			}

		} catch (Exception e) {
			throw new DriverException("Unbale to click on Continue button", e);
		}
		logger.info("Method : clickOnAddProductContinueButton :::::::: End  " + result);
		return result;
	}

	public boolean verifyInstitutionNameExists() throws Exception {
		logger.info("Method: verifyInstitutionNameExists Starts");
		try {
			flag = false;
			if (baseHandler.isDisplayed(baseHandler.findElement(".order-payment-step-2"))) {
				if (baseHandler.isDisplayed(baseHandler.findElement(
						PropertiesRepository.getString("new-atitesting.add.product.institution.name.value1")))) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Institution Name Exists ");
			throw new DriverException("Unable to verify Institution Name Exists ", e);
		}
		logger.info("Method: verifyInstitutionNameExists End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyInstitutionNameExists2() throws Exception {
		logger.info("Method: verifyInstitutionNameExists Starts");
		try {
			flag = false;
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if (baseHandler.isDisplayed(baseHandler.findElement("section[class='order-payment-section order-payment-step-2'] span[id='step2orderPaymentInst']"))) {
				flag = true;
			}			
		} catch (Exception e) {
			logger.info("Unable to verify Institution Name Exists ");
			throw new DriverException("Unable to verify Institution Name Exists ", e);
		}
		logger.info("Method: verifyInstitutionNameExists End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyInstitutionNamePurchaseDetails() throws Exception {
		logger.info("Method: verifyInstitutionNameExists Starts");
		try {
			flag = false;
			
				if (baseHandler.isDisplayed(baseHandler.findElement(
						PropertiesRepository.getString("new-atitesting.add.product.institution.name.value1")))) {
					flag = true;
				}
			
		} catch (Exception e) {
			logger.info("Unable to verify Institution Name Exists ");
			throw new DriverException("Unable to verify Institution Name Exists ", e);
		}
		logger.info("Method: verifyInstitutionNameExists End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyInstitutionNamePurchaseDetailsTEAS() throws Exception {
		logger.info("Method: verifyInstitutionNameExists Starts");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement("#step2orderPaymentInst"));
		try {
			flag = false;
			
				if (baseHandler.isDisplayed(baseHandler.findElement(
						PropertiesRepository.getString("new-atitesting.add.product.institution.name.value1")))) {
					flag = true;
				}
			
		} catch (Exception e) {
			logger.info("Unable to verify Institution Name Exists ");
			throw new DriverException("Unable to verify Institution Name Exists ", e);
		}
		logger.info("Method: verifyInstitutionNameExists End flag --> " + flag);
		return flag;
	}
	
	
	public boolean verifyDescriptionExists() throws Exception {
		logger.info("Method: verifyDescriptionExists Starts");
		boolean flag = false;
		try {
			if (baseHandler.isDisplayed(baseHandler.findElement("#OrderPaymentDialog"))) {
				List<WebElement> descriptionElement = baseHandler
						.findElements(PropertiesRepository.getString("new-atitesting.add.product.description.value"));
				if (CollectionUtils.isNotEmpty(descriptionElement) && descriptionElement.get(0).isDisplayed()) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Description Exists ");
			throw new DriverException("Unable to verify Description Exists ", e);
		}
		logger.info("Method: verifyDescriptionExists End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyDescriptionExists2() throws Exception {
		logger.info("Method: verifyDescriptionExists Starts");
		boolean flag = false;
		try {
				List<WebElement> descriptionElement = baseHandler.findElements("div[class='clear-both'] table[class='custom-table order-detail-table'] tbody tr th");
				driverWait.until(ExpectedConditions.visibilityOfAllElements(descriptionElement));
				if (CollectionUtils.isNotEmpty(descriptionElement) && descriptionElement.get(0).isDisplayed()) {
					flag = true;
				}
			}catch (Exception e) {
			logger.info("Unable to verify Description Exists ");
			throw new DriverException("Unable to verify Description Exists ", e);
		}
		logger.info("Method: verifyDescriptionExists End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyDescriptionDisplayed(String locator) throws Exception {
		logger.info("Method: verifyDescriptionDisplayed Starts");
		boolean flag = false;
		try {
				List<WebElement> descriptionElement = baseHandler.findElements(locator);
				driverWait.until(ExpectedConditions.visibilityOfAllElements(descriptionElement));
				if (CollectionUtils.isNotEmpty(descriptionElement) && descriptionElement.get(0).isDisplayed()) {
					flag = true;
				}
			}catch (Exception e) {
			logger.info("Unable to verify Description ");
			throw new DriverException("Unable to verify Description ", e);
		}
		logger.info("Method: verifyDescriptionDisplayed End flag --> " + flag);
		return flag;
	}
	
	
	public boolean verifyDescriptionExistsNew() throws Exception {
		logger.info("Method: verifyDescriptionExistsNew Starts");
		boolean flag = false;
		try {
				List<WebElement> descriptionElement = baseHandler.findElements(".custom-table.order-detail-table tbody[data-bind='foreach: OrderSummaryLineItems'] tr td");
				if (CollectionUtils.isNotEmpty(descriptionElement)) 
				{
					flag = true;
				}
			}catch (Exception e) {
			logger.info("Unable to verifyDescriptionExistsNew ");
			throw new DriverException("Unable to verifyDescriptionExistsNew ", e);
		}
		logger.info("Method: verifyDescriptionExistsNew End flag --> " + flag);
		return flag;
	}
	public boolean verifyDescriptionPurchaseDetails() throws Exception {
		logger.info("Method: verifyDescriptionExists Starts");
		try {
			flag = false;
			
				List<WebElement> descriptionElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.add.product.description.value1"));
				if (CollectionUtils.isNotEmpty(descriptionElement) && descriptionElement.size() > 0) {
					flag = true;
				
			}
		} catch (Exception e) {
			logger.info("Unable to verify Description Exists ");
			throw new DriverException("Unable to verify Description Exists ", e);
		}
		logger.info("Method: verifyDescriptionExists End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyInstitutionNameExistsNew() throws Exception {
		logger.info("Method: verifyInstitutionNameExistsNew Starts");
		boolean flag = false;
		try {
			List<WebElement> institutionElement = baseHandler.findElements("section[id='OrderPaymentDialog'] section[class='order-payment-section order-payment-step-2'] section[class='order-info-divs order-payment-section'] span");
			if (CollectionUtils.isNotEmpty(institutionElement)) {
					flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyInstitutionNameExistsNew ");
			throw new DriverException("Unable to verifyInstitutionNameExistsNew ", e);
		}
		logger.info("Method: verifyInstitutionNameExistsNew End flag --> " + flag);
		return flag;
	}


	public boolean checkShippingAddressCheckBox() throws Exception {
		logger.info("Method: checkShippingAddressCheckBox Starts");
		try {
			flag = false;
			if (baseHandler.isDisplayed(baseHandler.findElement("#ui-id-2"))) {
				flag = checkBoxHandler.isCheckboxSelected(
						PropertiesRepository.getString("new-atitesting.billing.address.checkbox.loc"));
			}
		} catch (Exception e) {
			logger.info("Unable to check Shipping Address CheckBox ");
			throw new DriverException("Unable to check Shipping Address CheckBox ", e);
		}
		logger.info("Method: checkShippingAddressCheckBox End flag --> " + flag);
		return flag;
	}
	
	public boolean checkShippingAddressCheckBox1() throws Exception {
		logger.info("Method: checkShippingAddressCheckBox Starts");
		try {
			flag = false;
			System.out.println("");
			if (baseHandler.isDisplayed(baseHandler.findElement(".tabbed-focus.checkbox-checked"))) {
				flag = checkBoxHandler.isCheckboxSelected(PropertiesRepository.getString("new-atitesting.shipping.address.checkbox.status"));
			}
		} catch (Exception e) {
			logger.info("Unable to check Shipping Address CheckBox ");
			throw new DriverException("Unable to check Shipping Address CheckBox ", e);
		}
		logger.info("Method: checkShippingAddressCheckBox End flag --> " + flag);
		return flag;
	}
	
	/*public boolean checkShippingAddressCheckBoxStatus() throws Exception {
		logger.info("Method: checkShippingAddressCheckBox Starts");
		try {
			flag = false;
			
				if (checkBoxHandler.isCheckboxSelected(
						PropertiesRepository.getString("new-atitesting.shipping.address.checkbox.status"))) {
					flag = true;	
				}
			
		} catch (Exception e) {
			logger.info("Unable to check Shipping Address CheckBox ");
			throw new DriverException("Unable to check Shipping Address CheckBox ", e);
		}
		logger.info("Method: checkShippingAddressCheckBox End flag --> " + flag);
		return flag;
	}
	*/
	public boolean checkShippingAddressCheckBoxNew() throws Exception {
		logger.info("Method: checkShippingAddressCheckBoxNew Starts");
		boolean flag = false;
		try {
			List<WebElement> institutionElement = baseHandler.findElements("section[class='order-payment-section order-payment-step-3 create-account-dialog'] .question-option input");
			if (CollectionUtils.isNotEmpty(institutionElement)) {
				WebElement shippingElement = institutionElement.get(0);
				if(shippingElement != null) {
					flag = checkBoxHandler.isCheckboxSelected("section[class='order-payment-section order-payment-step-3 create-account-dialog'] .question-option input");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to checkShippingAddressCheckBoxNew ");
			throw new DriverException("Unable to checkShippingAddressCheckBoxNew ", e);
		}
		logger.info("Method: checkShippingAddressCheckBoxNew End flag --> " + flag);
		return flag;
	}

	public boolean verifyOrderDetails(String locator, String orderno) throws Exception {
		logger.info("Method: verifyOrderDetails Starts");
		result = null;
		flag = false;
		try {
			if (baseHandler.isDisplayed(baseHandler.findElement(locator))) {
				result = textHandler.getText(locator);
				if (StringUtils.isNotBlank(result)) {
					if (orderno.equalsIgnoreCase(result)) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Order Details");
			throw new Exception("Unable to verify Order Details", e);
		}
		logger.info("Method: verifyOrderDetails --> " + flag);
		return flag;
	}

	public String getOrderNoDetails(String selector) throws Exception {
		logger.info("Method: getOrderNoDetails Starts");
		result = null;
		try {
			if (baseHandler.isDisplayed(baseHandler
					.findElement(PropertiesRepository.getString("new-atitesting.order.history.order.header.loc")))) {
				result = textHandler.getText(
						"#tabs-2 table[class='custom-table'] tbody:nth-child(2) tr:nth-child(1) td:nth-child(2)");
			}
		} catch (Exception e) {
			logger.info("Unable to get OrderNo Clicked");
			throw new Exception("Unable to get OrderNo Clicked", e);
		}
		logger.info("Method: getOrderNoDetails --> " + result);
		return result;
	}
	
	public String getOrderNo(String selector) throws Exception {
		logger.info("Method: getOrderNoDetails Starts");
		result = null;
		try {
			if (baseHandler.isDisplayed(baseHandler
					.findElement(PropertiesRepository.getString("new-atitesting.order.history.order.header.loc")))) {
				result = textHandler.getText(selector);
			}
		} catch (Exception e) {
			logger.info("Unable to get OrderNo Clicked");
			throw new Exception("Unable to get OrderNo Clicked", e);
		}
		logger.info("Method: getOrderNoDetails --> " + result);
		return result;
	}

	public boolean verifyOrderDetailsExists(String locator) throws Exception {
		logger.info("Method: verifyOrderDetailsExists Starts");
		result = null;
		flag = false;
		try {
			if (baseHandler.isDisplayed(baseHandler.findElement(locator))) {
				result = textHandler.getText(locator);
				if (StringUtils.isNotBlank(result)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Order Details Exists");
			throw new Exception("Unable to verify Order Details Exists", e);
		}
		logger.info("Method: verifyOrderDetailsExists --> " + flag);
		return flag;
	}

	public String getWindowHandler() throws Exception {
		return driver.getWindowHandle();
	}

	public String verifyOnlineStoreLink() throws DriverException {
		logger.info("Method : verifyOnlineStoreLink :::::::: START");
		try {
			// click on online store link
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.storeLinkLoc"));
			  tutorialPage.waitForAwhile(30000);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			// switch to particular window
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		} catch (Exception e) {
			throw new DriverException("Method: verifyOnlineStoreLink, Unable to locate element" + e);
		}
		result = textHandler.getText(PropertiesRepository.getString("new-atitesting.online.storeTextLoc"));
		logger.info("Method : verifyOnlineStoreLink :::::::: END  " + result);
		// fetching header
		return result;
	}

	public void clickPaymentTutorialOnline(String teasProductName) throws Exception {
		logger.info("Method: clickPaymentTutorialOnline Starts");
		try {
			List<WebElement> teasPracList = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.online.store.all.teas.product.tutorial.loc"));
			if (CollectionUtils.isNotEmpty(teasPracList)) {
				int size = teasPracList.size();
				for (int index = 0; index < size; index++) {
					if (teasProductName
							.equalsIgnoreCase(teasPracList.get(index)
									.findElement(By.cssSelector(PropertiesRepository
											.getString("new-atitesting.online.store.teas.product.teas.name.loc")))
							.getText())) {
						teasPracList.get(index)
								.findElement(By.cssSelector(PropertiesRepository
										.getString("new-atitesting.online.store.teas.product.teas.add.to.cart.loc")))
								.click();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Payment Tutorial Online");
			throw new DriverException("Unable to click Payment Tutorial Online", e);
		}
		logger.info("Method: clickPaymentTutorialOnline End ");
	}

	/**
	 * Method used to click check out button in Your Shopping Cart Page.
	 * 
	 * @throws Exception
	 */
	public void clickYourShoppingCartCheckOutButton() throws Exception {
		logger.info("Method: verifyFacultyProductTabAssessment Starts");
		try {
			baseHandler.waitToBeDisplayed(
					PropertiesRepository.getString("new-atitesting.online.store.your.shopping.cart.header.loc"));
			buttonHandler.clickButton(
					PropertiesRepository
							.getString("new-atitesting.online.store.your.shopping.cart.check.out.button.loc"),
					PropertiesRepository.getStringAsArray("new-atitesting.online.store.secure.checkout.header.loc"));
		} catch (DriverException e) {
			logger.info("Unable to verify Faculty User Product Tab ");
			throw new DriverException("Unable to verify Faculty User Product Tab ", e);
		}
		logger.info("Method: verifyFacultyProductTabAssessment End ");
	}
	
	/**
	 * Method is used to verify selected Institution while making TEAS Self Pay payments. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean checkSelectedInstitutions() throws Exception {
		logger.info("Method: checkSelectedInstitutions Starts");
    	try {
    		flag = false;
    		List<WebElement> institutionList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.select.institution.for.payment.selected.loc"));
    		if(CollectionUtils.isNotEmpty(institutionList) & institutionList.size() > 0) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to select Selected Institutions" );
    		throw new DriverException("Unable to select Selected Institutions" , e); 
    	}
    	logger.info("Method: checkSelectedInstitutions End flag --> " + flag );
    	return flag;
	}
	
	/**
	 * Method is used to click down arrow after selecting Institution while making TEAS Self Pay payments. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickDownArrow() throws Exception {
		logger.info("Method: clickDownArrow Starts");
    	try {
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.select.institution.for.payment.down.arrow.loc"));
    	} catch (Exception e) {
    		logger.info("Unable to click Down Arrow" );
    		throw new DriverException("Unable to click Down Arrow" , e); 
    	}
    	logger.info("Method: clickDownArrow End " );
	}
	

	/**
	 * Method used to click Proceed to Payment Details Button in Secure checkou
	 * page
	 * 
	 * @throws Exception
	 */
	public void clickProceedToPaymentDetailsButtonInSecureCheckOutPage() throws Exception {
		logger.info("Method: clickProceedToPaymentDetailsButtonInSecureCheckOutPage Starts");
		try {
			baseHandler.waitToBeDisplayed(
					PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.header.loc"));
			buttonHandler.clickButton(
					PropertiesRepository.getString(
							"new-atitesting.online.store.secure.checkout.proceed.to.payment.details.button.loc"),
					PropertiesRepository.getStringAsArray("new-atitesting.online.store.secure.checkout.header.loc"));
		} catch (DriverException e) {
			logger.info("Unable to click Proceed To Payment Details Button In Secure Check Out Page");
			throw new DriverException("Unable to click Proceed To Payment Details Button In Secure Check Out Page", e);
		}
		logger.info("Method: clickProceedToPaymentDetailsButtonInSecureCheckOutPage End ");
	}

	/**
	 * Method used to select Program Type if it is not selected by default.
	 * 
	 * @throws Exception
	 */
	public void selectProgramType() throws Exception {
		logger.info("Method: selectProgramType Starts");
		try {
			List<WebElement> programTypeList = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.program.type.loc"));
			if (CollectionUtils.isNotEmpty(programTypeList)) {
				Select programTypeSelect = dropDownHandler.getDropDown(
						PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.program.type.loc"));
				dropDownHandler.selectByVisibleText(programTypeSelect, "PN");
			} else {
				logger.info("Program Type DD is not available");
			}
		} catch (DriverException e) {
			logger.info("Unable to verify Faculty User Product Tab in selectProgramType");
			throw new DriverException("Unable to verify Faculty User Product Tab in selectProgramType", e);
		}
		logger.info("Method: selectProgramType End ");
	}

	/**
	 * Method is switch to BrainTree Frame
	 * 
	 */
	public void switchToBrainTree() {
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("paymentFrame");
		windowHandler.switchToFrame("braintree-dropin-frame");
	}

	public void switchToOnlinePaymentBrainTreeMain() {
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
	}
	public void switchToOnlinePaymentBrainTreeNext() {
		windowHandler.switchToFrame("braintree-dropin-frame");
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
	}
	
	public void switchToOnlinePaymentBrainTree() {
		logger.info("switchToOnlinePaymentBrainTree Start ");
		
		try {
			windowHandler.switchToMainWindow();
			windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
			windowHandler.switchToFrame("braintree-dropin-frame");
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.creditcardNoLoc"),"4111111111111111");
			//windowHandler.switchToFrame("braintree-dropin-frame");
			
			
		}catch (Exception e) {
			windowHandler.switchToMainWindow();
    		logger.info("Unable to " );
			log(logger, "Unable to " );
    		//throw new DriverException("Unable to " , e); 
    	}
		
		logger.info("switchToOnlinePaymentBrainTree End");
	}
	
	/**
	 * Method is switch to BrainTree Frame
	 * 
	 */
	public void switchToBrainTreeFrames() {
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame(PropertiesRepository.getString("new-atitesting.online.store.payment.frame.name"));
		windowHandler.switchToFrame("braintree-dropin-frame");
	}
	/**
	 * @author Sagar.Rao This method is used to enter the credit card exp date
	 * @param input
	 * @throws DriverException
	 */
	public void enterCreditCardCvv(String input) throws DriverException {
		logger.info("Method: enterCreditCvv Starts");
		try {
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.creditcardCVVLoc"), input);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			windowHandler.switchToMainWindow();
			windowHandler.switchToFrame("paymentFrame");
		} catch (Exception e) {
			throw new DriverException("Unable to enter credit card exp date", e);
		}
		logger.info("Method: enterCreditCvv Ends");
	}

	
	public void enterCreditCardCvvnumber(String input) throws DriverException {
		logger.info("Method: enterCreditCvv Starts");
		try {
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.creditcardCVVLoc"), input);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			
			WebElement element = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.creditcardCVVLoc"));
			element.sendKeys(Keys.TAB);
		
		} catch (Exception e) {
			throw new DriverException("Unable to enter credit card exp date", e);
		}
		logger.info("Method: enterCreditCvv Ends");
	}
	
	/**
	 * @author Sagar.Rao
	 * This method is used to enter the credit card exp date
	 * @param input
	 * @throws DriverException
	 */
	public void enterCreditCardCvvNumber(String input) throws DriverException{
		logger.info("Method: enterCreditCvv Starts");
		try{
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.creditcardCVVLoc"), input);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			
		}
		catch(Exception e){
			throw new DriverException("Unable to enter credit card exp date",e);
		}
		logger.info("Method: enterCreditCvv Ends");
	}
	/**
	 * @author Sagar.Rao This method is used to enter the credit card exp date
	 * @param input
	 * @throws DriverException
	 */
	public void enterCreditCardExpirationDate(String input) throws DriverException {
		logger.info("Method: enterCreditExpiration Starts");
		try {
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.creditcardExpLoc"), input);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
		} catch (Exception e) {
			throw new DriverException("Unable to enter credit card exp date", e);
		}
		logger.info("Method: enterCreditExpiration Ends");
	}

	/**
	 * @author Sagar.Rao This method is used to enter the credit card number
	 * @param input
	 * @throws DriverException
	 */
	public void enterCreditCardNo(String input) throws DriverException {
		logger.info("Method: enterCreditCardNo Starts");
		try {
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.creditcardNoLoc"), input);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
		} catch (Exception e) {
			throw new DriverException("Unable to enter credit card number", e);
		}
		logger.info("Method: enterCreditCardNo Ends");
	}

	/**
	 * Method is used to select Institution while making TEAS Self Pay payments.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void selectAvailableInstitutions() throws Exception {
		logger.info("Method: selectAvailableInstitutions Starts");
		try {
			List<WebElement> institutionList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.select.institution.for.payment.loc"));
			if (CollectionUtils.isNotEmpty(institutionList) & institutionList.size() > 0) {
				institutionList.get(0).click();
			}
		} catch (Exception e) {
			logger.info("Unable to select Available Institutions");
			throw new DriverException("Unable to select Available Institutions", e);
		}
		logger.info("Method: selectAvailableInstitutions End ");
	}

	/**
	 * @author Sagar.Rao This method is used to click on Submit button.
	 * @throws DriverException
	 */
	public void clickOnSubmitOrderBtn() throws DriverException {
		logger.info("Method: clickOnSubmitBtn Starts");
		try {
			
			log(logger, "switch to frames");
			
			windowHandler.switchToLatestWindow();
			windowHandler.switchToFrame("paymentFrame");
			log(logger, "click on submit button");
			tutorialPage.clickButton(".step-modal-nav input");
			Thread.sleep(5000);
			windowHandler.switchToLatestWindow();
			((JavascriptExecutor) driver).executeScript("scroll(0,-250);");
			windowHandler.switchToFrame("paymentFrame");
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			Thread.sleep(5000);
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			throw new DriverException("Unable to click on Submit Order Button", e);
		}
		logger.info("Method: clickOnSubmitBtn Ends");
	}
	
	/**
	 * @author Sagar.Rao This method is used to click on Submit button.
	 * @throws DriverException
	 */
	public void clickOnSubmitOrderBtnForTEASSelfPay() throws DriverException {
		logger.info("Method: clickOnSubmitOrderBtnForTEASSelfPay Starts");
		try {
			log(logger, "switch to frames");
			windowHandler.switchToLatestWindow();
			windowHandler.switchToFrame("paymentFrame");
			
			log(logger, "click on submit button");
			tutorialPage.clickButton(".step-modal-nav input");
			windowHandler.switchToLatestWindow();
			scrollUp();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			//Thread.sleep(50000);
		} catch (Exception e) {
			throw new DriverException("Unable to click on Submit Order Button", e);
		}

		logger.info("Method: clickOnSubmitOrderBtnForTEASSelfPay Ends");
	}
	
	/**
	 * Method used to scroll Up. 
	 * 
	 * @throws Exception
	 */
	public void scrollUp() throws Exception {
		logger.info("Method : scrollUp Start");
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,-250);");
		}catch (Exception e) {
    		logger.info("Unable to scrollUp" );
			log(logger, "Unable to scrollUp" );
    		throw new DriverException("Unable to scrollUp" , e); 
    	}
		logger.info("Method: End flag --> " + flag);
	}
	
	public void clickOnSubmitOrderBtnteas() throws DriverException {
		logger.info("Method: clickOnSubmitBtn Starts");
		System.out.println("");
		try {
			windowHandler.switchToFrame("braintree-dropin-frame");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.creditcardCVVLoc")));
			log(logger, "switch to frames");
			windowHandler.switchToLatestWindow();
			windowHandler.switchToFrame("paymentFrame");
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement("div[ data-bind='visible: IsTEASShareOrderDetailsVisible'] table[class='custom-table order-detail-table'] tbody>tr:nth-child(3) td span[data-bind='currency: Price']"));
			log(logger, "click on submit button");			
			tutorialPage.clickButton("input[value='Submit Order']");			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			windowHandler.switchToLatestWindow();
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
			Thread.sleep(50000);
		} catch (Exception e) {
			throw new DriverException("Unable to click on Submit Order Button", e);
		}

		logger.info("Method: clickOnSubmitBtn Ends");
	}
	
	public void clickOnSubmitOrderBtnteasWithRefresh() throws DriverException {
		logger.info("Method: clickOnSubmitOrderBtnteasWithRefresh Starts");
		System.out.println("");
		try {
			windowHandler.switchToFrame("braintree-dropin-frame");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.creditcardCVVLoc")));
			log(logger, "switch to frames");
			windowHandler.switchToLatestWindow();
			windowHandler.switchToFrame("paymentFrame");
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement("div[ data-bind='visible: IsTEASShareOrderDetailsVisible'] table[class='custom-table order-detail-table'] tbody>tr:nth-child(3) td span[data-bind='currency: Price']"));
			log(logger, "click on submit button");			
			tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.submit.button"),0);	
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			/*waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			windowHandler.switchToLatestWindow();
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");*/
			//Refresh page
			driver.navigate().refresh();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			Thread.sleep(4000);			
		} catch (Exception e) {
			throw new DriverException("Unable to click on Submit Order Button", e);
		}

		logger.info("Method: clickOnSubmitOrderBtnteasWithRefresh Ends");
	}

	public void closeOrderSummaryPage() throws DriverException {
		logger.info("Method closeOrderSummaryPage Starts");
		try {
			clickButtonWithSwitchToDefault(PropertiesRepository.getString("newati.payment.mypurchase.order.close.button"), 0);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			//Thread.sleep(4000);
		} catch (Exception e) {
			throw new DriverException("Unable to click on close button", e);
		}
		logger.info("Method closeOrderSummaryPage Ends");
	}

	/**
	 * @author Sagar.Rao This method is used to click on account link.
	 * @param accLoc
	 * @throws DriverException
	 */
	public String clickOnUserAccountLink() throws DriverException {
		logger.info("Method: clickOnUserAccountLink Starts");
		String value = "";
		try {
			linkHandler.selectLink(".secondary-nav li:nth-of-type(1) a");
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			value = textHandler.getText(PropertiesRepository.getString("new-atitesting.useracc.headerLoc"));
		} catch (Exception e) {
			throw new DriverException("Unable to click on User Account Link", e);
		}

		logger.info("Method: clickOnUserAccountLink Ends");
		return value;
	}

	public String verifyNoDataAvailable() throws DriverException {
		logger.info("Method verifyNoDataAvailable Starts");
		String value = "";
		try {
			value = textHandler.getText(PropertiesRepository.getString("new-atitesting.purchase.history.noDataLoc"));
		} catch (Exception e) {
			throw new DriverException("Unable to fetch text data", e);
		}
		logger.info("Method verifyNoDataAvailable Ends");
		return value;
	}

	/**
	 * @author Sagar.Rao This method is used to click on order link.
	 * @return
	 * @throws DriverException
	 */
	public String clickOnOrderLink() throws DriverException {
		logger.info("Method clickOnOrderLink Starts");
		String value = "";
		try {
			linkHandler.selectLink(PropertiesRepository.getString("new-atitesting.purchase.history.orderlinkLoc"),
					PropertiesRepository.getString("new-atitesting.purchase.history.orderDialogLoc"));

			value = textHandler
					.getText(PropertiesRepository.getString("new-atitesting.purchase.history.orderDetailsTxtLoc"));
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			throw new DriverException("Unable to click on Order Link", e);
		}

		logger.info("Method clickOnOrderLink Ends");
		return value;
	}

	public boolean clickOnCloseButton() throws DriverException {
		logger.info("Method clickOnCloseButton Starts");
		try {
			Thread.sleep(1500);
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.ordersummary.closeBtnLoc"));
		} catch (Exception e) {
			throw new DriverException("Unable to click on close button", e);
		}
		flag = baseHandler.isDisplayed(baseHandler
				.findElement(PropertiesRepository.getString("new-atitesting.purchase.history.orderDialogLoc")));

		logger.info("Method clickOnCloseButton Ends");
		return flag;

	}

	/**
	 * @author Sagar.Rao This Method is used to select
	 *         "My Purchase and Payments" tab
	 * @return
	 * @throws DriverException
	 */
	public boolean selectPaymentsTab() throws DriverException {
		logger.info("Method: selectPaymentsTab Starts");
		try {
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.paymentstabloc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			setDriverWait(PropertiesRepository.getString("new-atitesting.paymentTextFiledLoc"));
		} catch (Exception e) {
			throw new DriverException("Unable to find Payments Text Fields", e);
		}

		flag = baseHandler.isDisplayed(
				baseHandler.findElement(PropertiesRepository.getString("new-atitesting.paymentTextFiledLoc")));

		logger.info("Method: selectPaymentsTab Starts" + flag);
		return flag;
	}
	
	/**
	 * Method to click on Submit order button in Secure Checkout Page. 
	 * 
	 * @throws Exception
	 */
	public void clickSecureCheckOutSubmitOrder() throws Exception {
		logger.info("Method: clickSecureCheckOutSubmitOrder Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		windowHandler.switchToFrame(PropertiesRepository.getString("new-atitesting.online.store.payment.frame.name"));
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"), PropertiesRepository
					.getString("new-atitesting.online.store.receipt.page.header.loc"));
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		logger.info("Unable to click Secure Check Out Submit Order" );
    		throw new DriverException("Unable to click Secure Check Out Submit Order" , e); 
    	}
    	logger.info("Method: clickSecureCheckOutSubmitOrder End " );
	}

	/**
	 * Method to click on Check Agreement check box. 
	 * 
	 * @throws Exception
	 */
	public void checkAgreement() throws Exception {
		logger.info("Method: checkAgreement Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		windowHandler.switchToFrame(PropertiesRepository.getString("new-atitesting.online.store.payment.frame.name"));
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		logger.info("Unable to check Agreement" );
    		throw new DriverException("Unable to check Agreement" , e); 
    	}
    	logger.info("Method: checkAgreement End " );
	}

	public boolean verifyFradCardErrorMessage(String locator,String message) throws DriverException {
		logger.info("Method: verifyFradCardErrorMessage Start " );
		try
		{
			windowHandler.switchToFrame("paymentFrame");
			WebElement element = baseHandler.findElement(PropertiesRepository.getString(locator));
			if(element!=null)
			{
				if(element.getText().contains(PropertiesRepository.getString(message)))
				{
					return true;
				}
			}
			
	} catch (Exception e) {
		logger.info("Unable to verify Frad Card Error Message" );
		throw new DriverException("Unable to verify Frad Card Error Message" , e); 
	}
	logger.info("Method: checkAgreement End " );
	return false;
	
	}

	public void enterShippingAddress() throws DriverException {
		logger.info("Method: enterShippingAddress Starts");
		try {
			// enter 1st name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.firstNameLoc"),
					PropertiesRepository.getString("new-atitesting.billing.firstNameInpt"));
			
			newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.shipping.firstNameLoc"));
			
			// enter last name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.lastNameLoc"),
					PropertiesRepository.getString("new-atitesting.billing.lastNameInpt"));
			newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.shipping.lastNameLoc"));
			
			// enter address1
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.address1Loc"),
					PropertiesRepository.getString("new-atitesting.billing.address1Input"));
		
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.cityLoc"),
					PropertiesRepository.getString("new-atitesting.billing.cityInpt"));

			// enter zipcode
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.zipLoc"), PropertiesRepository
					.getString("new-atitesting.billing.zipCodeInpt"));

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

			// select country
			Select selCountry = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.shipping.countrydropdownLoc"));
			dropDownHandler.selectByVisibleText(selCountry,
					PropertiesRepository.getString("new-atitesting.billing.countryInpt"));

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

			// select state
			Select selState = dropDownHandler.getDropDown(PropertiesRepository
					.getString("new-atitesting.shipping.statedropdownLoc"));
			dropDownHandler.selectByVisibleText(selState,
					PropertiesRepository.getString("new-atitesting.billing.stateInpt"));

			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
			
			// enter email ID
			textHandler.writeText(PropertiesRepository
					.getString("new-atitesting.shipping.emailLoc"), PropertiesRepository
					.getString("new-atitesting.shipping.emailTnput"));
			
			newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.shipping.emailLoc"));
						
			// enter phone Number
			enterShippingPhoneNo();
			
		newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.shipping.phoneLoc"));
		} catch (Exception e) {
			throw new DriverException(
					"Method: enterShippingAddress :::::Unable to locate element" + e);
		}
		logger.info("Method: enterShippingAddress Ends");
	}
	
	
	
	public void enterBillingAddress() throws DriverException {
		logger.info("Method: enterBillingAddress Starts");
		try {

			// enter address1
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.address1Loc"),
					PropertiesRepository.getString("new-atitesting.billing.address1Input"));
		
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.cityLoc"),
					PropertiesRepository.getString("new-atitesting.billing.cityInpt"));

			// enter zipcode
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.zipLoc"), PropertiesRepository
					.getString("new-atitesting.billing.zipCodeInpt"));

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

			// select country
			Select selCountry = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.billing.countrydropdownLoc"));
			dropDownHandler.selectByVisibleText(selCountry,
					PropertiesRepository.getString("new-atitesting.billing.countryInpt"));

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

			// select state
			Select selState = dropDownHandler.getDropDown(PropertiesRepository
					.getString("new-atitesting.billing.statedropdownLoc"));
			dropDownHandler.selectByVisibleText(selState,
					PropertiesRepository.getString("new-atitesting.billing.stateInpt"));

			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
			
		} catch (Exception e) {
			throw new DriverException(
					"Method: enterBillingAddress :::::Unable to locate element" + e);
		}
		logger.info("Method: enterBillingAddress Ends");
	}
	public void enterShippingAddressForOnTime() throws DriverException {
		logger.info("Method: enterShippingAddressForOnTime Starts");
		try {
			// enter 1st name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.firstNameLoc"),
					PropertiesRepository.getString("new-atitesting.billing.firstNameInpt"));
			
			newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.billing.firstNameLoc"));
			
			// enter last name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.lastNameLoc"),
					PropertiesRepository.getString("new-atitesting.billing.lastNameInpt"));
			newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.billing.lastNameLoc"));
			
			// enter address1
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.address1Loc"),
					PropertiesRepository.getString("new-atitesting.billing.address1Input"));
		
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.cityLoc"),
					PropertiesRepository.getString("new-atitesting.billing.cityInpt"));

			// enter zipcode
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.zipLoc"), PropertiesRepository
					.getString("new-atitesting.billing.zipCodeInpt"));

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

			// select country
			Select selCountry = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.billing.countrydropdownLoc"));
			dropDownHandler.selectByVisibleText(selCountry,
					PropertiesRepository.getString("new-atitesting.billing.countryInpt"));

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

			// select state
			Select selState = dropDownHandler.getDropDown(PropertiesRepository
					.getString("new-atitesting.billing.statedropdownLoc"));
			dropDownHandler.selectByVisibleText(selState,
					PropertiesRepository.getString("new-atitesting.billing.stateInpt"));

			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
			
		} catch (Exception e) {
			throw new DriverException(
					"Method: enterShippingAddress :::::Unable to locate element" + e);
		}
		logger.info("Method: enterShippingAddress Ends");
	}
	
	public boolean verifyTaxAmount() throws DriverException {
		logger.info("Method: verifyTaxAmount Starts");
		boolean flag = false;
    	try {
    		waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
    		List<WebElement> taxAmountElement = baseHandler.findElements("section[class='order-payment-section order-payment-step-4'] tbody[data-bind='foreach: OrderSummaryLineItems'] tr");
    		if(CollectionUtils.isNotEmpty(taxAmountElement)) {
    			int size = taxAmountElement.size();
    			for(int index = 0; index < size ; index ++) {
    				List<WebElement> taxValueAmt = taxAmountElement.get(index).findElements(By.cssSelector("td"));
    				if(CollectionUtils.isNotEmpty(taxValueAmt)) {
    					if(taxValueAmt.get(0).getText().equalsIgnoreCase("Tax Amount")) {
    						String taxValue = taxValueAmt.get(1).getText();
    		    			if(taxValue.contains("$")) {
    		    				float actualValue = Float.valueOf(taxValue.replace("$", ""));
    		    				if(actualValue > 0.0) {
    		    					flag = true;
    		    					break;
    		    				}
    		    			}
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Tax Amount ");
    		throw new DriverException("Unable to verify Tax Amount " , e); 
    	}
    	logger.info("Method: verifyTaxAmount End flag --> " + flag);
    	return flag;
	}
	
	public void selectAssessmentToCheckOut(String assessmentName,String loc) throws DriverException {
		logger.info("Method: selectAssessmentToCheckOut start");
		try {
			driver.findElement(By.id("ctl00_ctl00_txtSearchBox")).sendKeys(assessmentName);
			buttonHandler.clickButton(PropertiesRepository.getString("newati.payment.search.button"));	
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if(CollectionUtils.isNotEmpty(elements))
			{
				for (int i=0;i<elements.size();i++) {
					if(elements.get(i).getText().equalsIgnoreCase(assessmentName.trim()))
					{
						List<WebElement> checkOutLoc = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.online.store.checkout.button.loc"));
						if(CollectionUtils.isNotEmpty(checkOutLoc))
						{
							checkOutLoc.get(i).click();
						}
						return;
					}
				}
				
			}
			
			
		} catch (Exception e) {
			logger.info("Unable to verify Tax Amount in selectAssessmentToCheckOut");
    		throw new DriverException("Unable to verify Tax Amount in selectAssessmentToCheckOut" , e); 
		}
		logger.info("Method: selectAssessmentToCheckOut end");
		
	}
	
	public void clickOnPracticeAssessmentOnLeftSide(String assessmentName,String loc) throws DriverException {
		logger.info("Method: clickOnPracticeAssessmentOnLeftSide start");
		try {
			
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if(CollectionUtils.isNotEmpty(elements))
			{
				for (WebElement webElement : elements) {
					if(webElement.getText().contains(assessmentName.trim()))
					{
						webElement.click();
						return;
					}
				}
				
			}
			
			
		} catch (Exception e) {
			logger.info("Unable to verify Tax Amount ");
    		throw new DriverException("Unable to verify Tax Amount " , e); 
		}
		logger.info("Method: clickOnPracticeAssessmentOnLeftSide end");
		
	}
	public boolean verifyIndSemesterGreater(String value) throws DriverException {
		logger.info("Method: verifyIndSemesterGreater Starts");
		boolean flag = false;
    	try {
    		waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
    		List<WebElement> mainTable = baseHandler.findElements("div [data-bind='visible: IsOrderDetailsVisible'] table[class='custom-table order-detail-table']");
    		if(CollectionUtils.isNotEmpty(mainTable)) {
    			List<WebElement> taxTable = mainTable.get(0).findElements(By.cssSelector("tbody tr"));
    			int size = taxTable.size();
    			for(int index = 0; index < size ; index ++) {
    				List<WebElement> taxValueAmt = taxTable.get(index).findElements(By.cssSelector("td"));
    				if(CollectionUtils.isNotEmpty(taxValueAmt)) {
    					if(taxValueAmt.get(0).getText().equalsIgnoreCase(value)) {
    						String taxValue = taxValueAmt.get(1).getText();
    		    			if(taxValue.contains("$")) {
    		    				float actualValue = Float.valueOf(taxValue.replace("$", ""));
    		    				if(actualValue > 0.0) {
    		    					flag = true;
    		    					break;
    		    				}
    		    			}
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyIndSemesterGreater");
    		throw new DriverException("Unable to verifyIndSemesterGreater" , e); 
    	}
    	logger.info("Method: verifyIndSemesterGreater End flag --> " + flag);
    	return flag;
	}
	
	public boolean verifyIndSemesterEqual(String value) throws DriverException {
		logger.info("Method: verifyIndSemesterEqual Starts");
		boolean flag = false;
    	try {
    		waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
    		List<WebElement> mainTable = baseHandler.findElements("div [data-bind='visible: IsOrderDetailsVisible'] table[class='custom-table order-detail-table']");
    		if(CollectionUtils.isNotEmpty(mainTable)) {
    			List<WebElement> taxTable = mainTable.get(0).findElements(By.cssSelector("tbody tr"));
    			int size = taxTable.size();
    			for(int index = 0; index < size ; index ++) {
    				List<WebElement> taxValueAmt = taxTable.get(index).findElements(By.cssSelector("td"));
    				if(CollectionUtils.isNotEmpty(taxValueAmt)) {
    					if(taxValueAmt.get(0).getText().equalsIgnoreCase(value)) {
    						String taxValue = taxValueAmt.get(1).getText();
    		    			if(taxValue.contains("$")) {
    		    				float actualValue = Float.valueOf(taxValue.replace("$", ""));
    		    				if(actualValue == 0.0) {
    		    					flag = true;
    		    					break;
    		    				}
    		    			}
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyIndSemesterEqual");
    		throw new DriverException("Unable to verifyIndSemesterEqual" , e); 
    	}
    	logger.info("Method: verifyIndSemesterEqual End flag --> " + flag);
    	return flag;
	}
	
	public boolean verifytaxvalue() throws DriverException{
		
		try {
	List<WebElement> taxvalue=baseHandler.findElements("div[data-bind='visible: IsOrderDetailsVisible'] table[class='custom-table order-detail-table'] tbody tr[style=''] td span");
	
	String val=taxvalue.get(0).getText();

		if(val.equals("$0.00")) {
			flag = true;	
	}
		} catch (Exception e) {
    		logger.info("Unable to verifytaxvalue");
    		throw new DriverException("Unable to verifytaxvalue" , e); 
    	}
    	logger.info("Method: verifytaxvalue End flag --> " + flag);
    	return flag;
}
	
	public boolean verifytaxvalueforteas() throws DriverException{
		
		try {
	List<WebElement> taxvalue=baseHandler.findElements("div[ data-bind='visible: IsTEASShareOrderDetailsVisible'] table[class='custom-table order-detail-table'] tbody>tr:nth-child(3) td span[data-bind='currency: Price']");
	
	String val=taxvalue.get(0).getText();

		if(val.equals("$0.00")) {
			flag = true;	
	}
		} catch (Exception e) {
    		logger.info("Unable to verifytaxvalue");
    		throw new DriverException("Unable to verifytaxvalue" , e); 
    	}
    	logger.info("Method: verifytaxvalue End flag --> " + flag);
    	return flag;
}
	
	public boolean verifytaxvaluegreaterthanzero() throws DriverException{
		logger.info("Method: verifytaxvaluegreaterthanzero Start ");
	    try {
	   List<WebElement> taxvalue=baseHandler.findElements("div[data-bind='visible: IsOrderDetailsVisible'] table[class='custom-table order-detail-table'] tbody tr[style=''] td span");
	    String val=taxvalue.get(0).getText();
	    double dVal =  Double.parseDouble(val.substring(1));
	    if(dVal > 0) {
	     flag = true;

	   }
	    } catch (Exception e) {
	        logger.info("Unable to verifytaxvalue");
	        throw new DriverException("Unable to verifytaxvalue" , e); 
	       }
	       logger.info("Method: verifytaxvaluegreaterthanzero End flag --> " + flag);
	       return flag;
	  }
	
	public void clearCreditCardfield() {
		baseHandler.findElement(PropertiesRepository.getString("new-atitesting.creditcardNoLoc")).clear();
	}
	
	/*
	 * Verify Credit Card, Expiry Date, CVV fields are displayed
	 * 
	 * @author syed.pasha
	 * 
	 * @throws Exception
	 */
	public boolean verifyCardFirlds() throws DriverException {
		logger.info("Method: verifyCardFirlds Starts ");
		boolean flag = false;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					baseHandler.findElement("#cvv"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if (baseHandler.findElement("#credit-card-number").isDisplayed()
					&& baseHandler.findElement("#expiration").isDisplayed()
					&& baseHandler.findElement("#cvv").isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Card Fields");
			throw new DriverException("Unable to verify Card Fields", e);
		}
		logger.info("Method: verifyCardFirlds End flag --> " + flag);
		return flag;
	}

	/*
	 * Verify Credit Card, Expiry Date, CVV fields are displayed
	 * 
	 * @author syed.pasha
	 * 
	 * @throws Exception
	 */
	public void enterAdd1CityZip(String address1, String city, String zip) throws Exception {
		logger.info("enterAdd1CityZip Start");
		// enter address1
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.address1Loc"),address1);
		// enter city
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.cityLoc"),city);
		// enter zipcode
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.billing.zipLoc"),zip);
		//enter email
		enterShippingEmailId();
		//enter phone
		enterShippingPhoneNo();
		log(logger, "Entering Phone number in Shipping address");
		//Click on continue button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.ContinueLoc")));
		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.ContinueLoc"));
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		logger.info("enterAdd1CityZip End");
	}
	
	/*
	 * Verify Credit Card, Expiry Date, CVV fields are displayed
	 * 
	 * @author syed.pasha
	 * 
	 * @throws Exception
	 */
	public void enterShippingInvalidAdd1CityZip(String address1, String city, String zip) throws Exception {
		
		logger.info("enterShippingInvalidAdd1CityZip Start");
		// enter 1st name
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.firstNameLoc"),PropertiesRepository.getString("new-atitesting.billing.firstNameInpt"));
		newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.shipping.firstNameLoc"));
		
		// enter last name
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.lastNameLoc"),PropertiesRepository.getString("new-atitesting.billing.lastNameInpt"));
		newAtiBasePage.clickTab(PropertiesRepository.getString("new-atitesting.shipping.lastNameLoc"));
		
		// enter address1
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.address1Loc"),address1);
		
		// enter city
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.cityLoc"),city);
		
		// enter zipcode
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.shipping.zipLoc"),zip);
		
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

		// select country
		Select selCountry = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.shipping.countrydropdownLoc"));
		dropDownHandler.selectByVisibleText(selCountry,PropertiesRepository.getString("new-atitesting.billing.countryInpt"));

		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

		// select state
		Select selState = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.shipping.statedropdownLoc"));
		dropDownHandler.selectByVisibleText(selState,PropertiesRepository.getString("new-atitesting.billing.stateInpt"));

		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));	

		//enter email
		enterShippingEmailId();
		log(logger, "Entering Phone number in Shipping address");
		
		//enter phone
		enterShippingPhoneNo();
		log(logger, "Entering Phone number in Shipping address");
		
		//Click on continue button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.ContinueLoc")));
		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.ContinueLoc"));
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		logger.info("enterShippingInvalidAdd1CityZip End");
	}
	
	/*
	 * Verify invalid error message is displayed
	 * 
	 * @author syed.pasha
	 * 
	 * @throws Exception
	 */
	public boolean verifyInvalidAddressErrorMsg() throws DriverException {
		logger.info("Method: verifyInvalidAddressErrorMsg Start ");
		boolean flag = false;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baseHandler.findElement("div[data-atiid='addressValidationErrorMessage']"));
			if (baseHandler.findElement("div[data-atiid='addressValidationErrorMessage']").isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Inalid error Error Message");
			throw new DriverException("Unable to verify Inalid error Error Message", e);
		}
		logger.info("Method: verifyInvalidAddressErrorMsg End ");
		return flag;
	}
	
	/*Click on Links fron left side
	 * 
	 * @author: Vaishali.katta
	 */
	public void clickLinkOnLeftSideOnlineStore(String locator) throws DriverException {
		logger.info("Method: clickLinkOnLeftSideOnlineStore start");
		try {	
			WebElement link = sizzleSelector.findElementBySizzleCss(driver, locator);
			driverWait.until(ExpectedConditions.visibilityOf(link));
			link.click();
		} catch (Exception e) {
			logger.info("Unable to click on Link ");
    		throw new DriverException("Unable to click on Link " , e); 
		}
		logger.info("Method: clickLinkOnLeftSideOnlineStore end");		
	}
	

	/*Click on Links fron left side
	 * @author: Vaishali.katta
	 */
	public void enterAndApplyCouponCodeOnlineStore() throws DriverException {
		logger.info("Method: enterAndApplyCouponCodeOnlineStore start");
		try {	
			baseHandler.findElement(PropertiesRepository.getString("new-atitesting.online.store.checkout.coupon.textfield")).sendKeys(
					PropertiesRepository.getString("newati.login.payment.coupon.code.input"));
			baseHandler.findElement(PropertiesRepository.getString("new-atitesting.online.store.checkout.applycode.button")).click();
			driverWait.until(ExpectedConditions.visibilityOf(baseHandler.findElement(
					PropertiesRepository.getString("new-atitesting.online.store.checkout.applycode.message.text"))));
		} catch (Exception e) {
			logger.info("Unable to enter and apply coupon code ");
    		throw new DriverException("Unable to enter and apply coupon code " , e); 
		}
		logger.info("Method: enterAndApplyCouponCodeOnlineStore end");		
	}
	
	/*Click on Links fron left side
	 * @author: Vaishali.katta
	 */
	public boolean verifyExpectedTotalAmountOnlineStoreCheckout(double eValue) throws DriverException {
		logger.info("Method: verifyExpectedTotalAmountOnlineStoreCheckout start");
		String aValue=null;
		try {	
			aValue=sizzleSelector.findElementBySizzleCss(driver, PropertiesRepository.getString("new-atitesting.online.store.checkout.total")).getText();
			if(aValue.contains("$")) {
				float actualValue = Float.valueOf(aValue.replace("$", ""));
				if(actualValue == eValue) {
					flag = true;				
				}
			}			
		} catch (Exception e) {
			logger.info("Expected value is not same as actual value");
    		throw new DriverException("Expected value is not same as actual value" , e); 
		}
		logger.info("Method: verifyExpectedTotalAmountOnlineStoreCheckout end");
		return flag;
	}

}
