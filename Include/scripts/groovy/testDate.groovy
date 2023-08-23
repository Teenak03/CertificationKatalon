import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.google.api.client.util.Data
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
import io.netty.handler.codec.DateFormatter

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

import java.time.LocalDate
//import java.text.SimpleDateFormat
//import java.util.Calendar
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class testDates {

	@Given("go to website")
	def go_to_website() {

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://www.irctc.co.in/nget/train-search')

		//		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		//
		//        LocalDateTime today = LocalDateTime.now()
		//        println "today= " + today.format(dateformat);
		//
		//        LocalDateTime tomorrow = currentDateTime.plusDays(1)
		//        println "tomorrow   = " + tomorrow.format(dateformat)
		//
		//		LocalDateTime yesterday = currentDateTime.minusDays(1)
		//		println "yesterday :" + yesterday.format(dateformat)
		//
		//		LocalDateTime twoMonth = currentDateTime.plusMonths(2)
		//		println "After two months :" + twoMonth.format(dateformat)
	}

	@When("click on date")
	def click_calendar() {
		String date1 = CustomKeywords.'myPackage.dateset.setMyDate'()
		WebUI.click(findTestObject('Object Repository/SetDate/calendar'))
		WebUI.delay(3)
		String my_day = date1.split("/")[0]
		String my_month = date1.split("/")[1]
		String my_year = date1.split("/")[2]
		String present_month= WebUI.getText(findTestObject('Object Repository/SetDate/month'))
		String present_year = WebUI.getText(findTestObject('Object Repository/SetDate/year'))

		while ((!present_year.equals(my_year)) || (!present_month.equals(my_month)))
		{
			if((present_year <= my_year ) || (present_month.compareTo(my_month) < 0))
			{
				WebUI.click(findTestObject('Object Repository/SetDate/next_date'))
			}
			else
			{
				WebUI.click(findTestObject('Object Repository/SetDate/back_date'))
			}
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

	@Then("set the required date and close")
	def set_the_date() {
		WebUI.closeBrowser()
	}
}