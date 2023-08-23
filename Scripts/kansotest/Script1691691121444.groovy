import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions


String chromeProfileDir = 'C:\\Users\\teena\\AppData\\Local\\Google\\Chrome\\User Data\\'

String pathToChromeDriver = 'C:\\Users\\teena\\.katalon\\packages\\Katalon_Studio_Windows_64-8.6.5\\Katalon_Studio_Windows_64-8.6.5\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe'
System.setProperty("webdriver.chrome.driver", pathToChromeDriver)
ChromeOptions chromeProfile = new ChromeOptions()

chromeProfile.addArguments("user-data-dir=" + chromeProfileDir)
chromeProfile.addArguments("profile-directory=Profile 1")

WebDriver driver = new ChromeDriver(chromeProfile)
driver.get('https://uat.ops.kansocloud.com/')
DriverFactory.changeWebDriver(driver)
//WebUI.openBrowser('https://uat.ops.kansocloud.com/')
//WebUI.navigateToUrl('https://uat.ops.kansocloud.com/')
//WebUI.maximizeWindow()
WebUI.verifyTextPresent('Sign In To Your Account', false)
WebUI.click(findTestObject('Object Repository/KansoOpstest_objects/signIn_button'))
WebUI.verifyElementPresent(findTestObject('Object Repository/KansoOpstest_objects/access_text'), 0)
WebUI.delay(4)
WebUI.click(findTestObject('Object Repository/KansoOpstest_objects/logout_button'))
WebUI.delay(4)
WebUI.waitForElementPresent(findTestObject('Object Repository/KansoOpstest_objects/logout_text_confirm'), 4)
WebUI.verifyTextPresent('Are you sure you want to logout?', false)
WebUI.click(findTestObject('Object Repository/KansoOpstest_objects/confirm_button'))
WebUI.verifyTextPresent('Sign In To Your Account', false)
WebUI.closeBrowser()
driver.quit()
