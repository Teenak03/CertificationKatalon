import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver;
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.configuration.RunConfiguration;
import org.openqa.selenium.chrome.ChromeOptions

class loginlogout {
	//	String chromeProfilePath = 'C:\\Users\\teena\\AppData\\Local\\Google\\Chrome\\User Data\\'
	//	String pathToChromeDriver = 'C:\\Users\\teena\\.katalon\\packages\\Katalon_Studio_Windows_64-8.6.5\\Katalon_Studio_Windows_64-8.6.5\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe'

	@Given("user to navigate on login page")
	public void loginpageAction() {

		//		System.setProperty("webdriver.chrome.driver", pathToChromeDriver)
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://ops.kansocloud.com/login')

		//		ChromeOptions options = new ChromeOptions()
		//		options.addArguments("user-data-dir=" + chromeProfilePath)
		//		options.addArguments("profile-directory= Profile 1")
		//
		//		WebDriver driver = new ChromeDriver(options)
		//		driver.get('https://ops.kansocloud.com/login')
		//		DriverFactory.changeWebDriver(driver)

		//		WebUI.openBrowser(pathToChromeDriver('C:\\Users\\teena\\.katalon\\packages\\Katalon_Studio_Windows_64-8.6.5\\Katalon_Studio_Windows_64-8.6.5\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe'), FailureHandling.STOP_ON_FAILURE)
		//		WebUI.navigateToUrl(pathToChromeDriver('https://ops.kansocloud.com/login'), FailureHandling.STOP_ON_FAILURE)

	}

	@When("text for sign in is verified")
	public void signInTextVerify() {
		WebUI.verifyTextPresent('Sign In To Your Account', false)
	}

	@And("user click on the button")
	public void clickLoginButton() {
		WebUI.click(findTestObject('Object Repository/KansoOpstest_objects/signIn_button'))
		WebUI.setText(findTestObject('Object Repository/KansoOpstest_objects/gmail_object'), 'teena.chauhan@kansocloud.com')
		WebUI.click(findTestObject('Object Repository/KansoOpstest_objects/next_click1'))
		WebUI.setEncryptedText(findTestObject('Object Repository/KansoOpstest_objects/pass_object'),'WWmjeSYBt6+f/OddB29rzg==')
		WebUI.click(findTestObject('Object Repository/KansoOpstest_objects/next_click'))
	}

	@Then("user navigated to access management")
	public void accessManagementPage() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/KansoOpstest_objects/access_text'), 30)
		WebUI.delay(3)
	}

	//	@Given("user on access management page")
	//	public void user_on_access_management_page() {
	//
	//		WebUI.verifyElementPresent(findTestObject('Object Repository/KansoOpstest_objects/access_text'), 30)
	//		WebUI.delay(3)
	//	}

	@When("user click on logout button")
	public void user_click_on_logout_button(){
		WebUI.click(findTestObject('Object Repository/KansoOpstest_objects/logout_button'))
		WebUI.delay(3)
		WebUI.waitForElementPresent(findTestObject('Object Repository/KansoOpstest_objects/logout_text_confirm'), 4)

	}
	@And("chooses the option yes")
	public void chooses_the_option_yes() {
		WebUI.verifyTextPresent('Are you sure you want to logout?', false)
		WebUI.click(findTestObject('Object Repository/KansoOpstest_objects/confirm_button'))
	}

	@Then("user navigated to login page again")
	public void  user_navigated_to_login_page_again(){
		WebUI.verifyTextPresent('Sign In To Your Account', false)
		WebUI.closeBrowser()
	}
}
