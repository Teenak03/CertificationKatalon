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
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

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

class SetDate {
	@Given("user navigated to the website")
	def navigateToWebsite() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://www.irctc.co.in/nget/train-search')
	}

	@When("verify text and click date")
	def calendarClick() {
		WebUI.verifyTextPresent('BOOK TICKET', false)
	}

	@And("sets (.*) according to choice")
	def setDate(String date) {
		WebUI.click(findTestObject('Object Repository/SetDate/calendar'))
		WebUI.delay(3)
		String my_day = date.split("-")[0]
		String my_month = date.split("-")[1]
		String my_year = date.split("-")[2]
		String present_month= WebUI.getText(findTestObject('Object Repository/SetDate/month'))
		String present_year = WebUI.getText(findTestObject('Object Repository/SetDate/year'))

		while ((!present_year.equals(my_year)) || (!present_month.equals(my_month))) {
			WebUI.click(findTestObject('Object Repository/SetDate/next_date'))
			present_month = WebUI.getText(findTestObject('Object Repository/SetDate/month'))
			present_year = WebUI.getText(findTestObject('Object Repository/SetDate/year'))
		}

		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> e = driver.findElements(By.xpath('//a[@class="ui-state-default ng-tns-c58-10 ng-star-inserted"]'))
		for(WebElement e1:e) {
			if(e1.getText().equals(my_day)) {
				e1.click()
				break;
			}
		}
	}

	@Then("close the browser")
	def Closebrowser() {
		WebUI.closeBrowser()
	}
}