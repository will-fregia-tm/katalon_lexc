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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Compare)

if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.navigateToUrl(GlobalVariable.SC_Domain + GlobalVariable.HPdefault)

WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS starting at price'), 
    0)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS starting at price'))

WebUI.waitForElementClickable(findTestObject('HomePage/VehicleSelector/categories/SUVs'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('HomePage/VehicleSelector/models/SUVs - UX'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - UX'))

WebUI.waitForElementClickable(findTestObject('HomePage/VehicleSelector/vehicle selector - Explore CTA - UX'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/vehicle selector - Explore CTA - UX'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForPageLoad(20, FailureHandling.OPTIONAL)

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_UX)

pageWidth = WebUI.getPageWidth()

WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

WebUI.waitForElementPresent(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector module'), 0)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UX starting at price'), 
    0)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UX starting at price'))

WebUI.verifyElementNotVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS starting at price'))

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

