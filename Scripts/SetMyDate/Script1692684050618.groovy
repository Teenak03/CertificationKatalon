import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://www.irctc.co.in/nget/train-search')
WebUI.verifyTextPresent('BOOK TICKET', false)
WebUI.click(findTestObject('Object Repository/SetDate/calendar'))
String date = CustomKeywords.'myPackage.dateset.setMyDate'()
String my_day = date.split("/")[0]
String my_month = date.split("/")[1]
String my_year = date.split("/")[2]
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
		    present_month= WebUI.getText(findTestObject('Object Repository/SetDate/month'))
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
    driver.quit()
WebUI.closeBrowser()

