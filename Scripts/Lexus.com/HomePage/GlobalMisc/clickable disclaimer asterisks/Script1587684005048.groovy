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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Compare)

if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.navigateToUrl(GlobalVariable.SC_Domain)

WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

WebUI.waitForElementPresent(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Sedans - IS'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - IS'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Homepage/GlobalMisc/disclaimer asterisk'), 0)

WebUI.click(findTestObject('Homepage/GlobalMisc/disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Homepage/GlobalMisc/disclaimer text'), 0)

WebUI.verifyElementVisible(findTestObject('Homepage/GlobalMisc/disclaimer text'), FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

