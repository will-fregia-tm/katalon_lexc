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

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Compare)

if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.navigateToUrl(GlobalVariable.SC_Domain)

WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

WebUI.scrollToElement(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))

WebUI.setText(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), '75218')

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - search button'))

WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/hero offers - market name - 75218'), 0)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Sedans'))

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Sedans - IS'), 0)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - offers heading'), 0, FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/vehicle selector - offer title - IS'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/VehicleSelector/vehicle selector - offer title - IS'))

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/SUVs'))

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/SUVs - GX'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - GX'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - offers heading'), 0, FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/vehicle selector - offer title - GX'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/VehicleSelector/vehicle selector - offer title - GX'))

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

