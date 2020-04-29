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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/models/RX/specifications')

WebUI.verifyElementClickable(findTestObject('MSRP/global objects/RX-RXh/RX 350 AWD - starting at price'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('MSRP/global objects/RX-RXh/RX 350 F Sport AWD - starting at price'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('MSRP/global objects/RX-RXh/RX 350 F Sport FWD - starting at price'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('MSRP/global objects/RX-RXh/RX 350 FWD - starting at price'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('MSRP/global objects/RX-RXh/RX 350L AWD - starting at price'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('MSRP/global objects/RX-RXh/RX 350L FWD - starting at price'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('MSRP/global objects/RX-RXh/RX 450h AWD - starting at price'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('MSRP/global objects/RX-RXh/RX 450h F Sport AWD - starting at price'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('MSRP/global objects/RX-RXh/RX 450hL AWD - starting at price'), FailureHandling.CONTINUE_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
	WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
	WebUI.executeJavaScript('sauce:job-result=failed', [])
}

