import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.PendingException
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

//CustomKeywords.'myFileUpload.myfile'()
import internal.GlobalVariable

public class FileUpload {

	@Given("user is navigated to the website")
	def navigateTowebsite() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl("https://the-internet.herokuapp.com/upload")
		WebUI.verifyTextPresent(findTestObject('Object Repository/fileUpload/file_text'), false)
	}

	@When("user chooses (.*)")
	def chooseFileoption(String file) {
		WebUI.uploadFile(findTestObject('Object Repository/fileUpload/chooseFile'), file)
	}


	@And("click upload")
	def selection_of_file() {
		WebUI.click(findTestObject('Object Repository/fileUpload/button_submit'))
	}

	@Then("verify upload and exit browser")
	def upload_and_exit() {
		WebUI.verifyTextPresent('File Uploaded!', false)
		WebUI.closeBrowser()
	}
}
