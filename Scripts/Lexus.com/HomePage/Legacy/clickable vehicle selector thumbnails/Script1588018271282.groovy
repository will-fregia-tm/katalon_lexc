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

WebUI.waitForElementPresent(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Sedans - IS'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - IS'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - ES'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ES starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - ESh'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ESh starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - GS'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - GS F'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS F starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - LS'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LS starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - LSh'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LSh starting at price'), 
    2, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/SUVs - UX'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - UX'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UX starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - UXh'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UXh starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - NX'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NX starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - NXh'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NXh starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - RX'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RX starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - RXh'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RXh starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - GX'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - GX starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - LX'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - LX starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Coupes - RC'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - RC'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - RC F'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC F starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - LC'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LC starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - LCh'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LCh starting at price'), 
    0, FailureHandling.OPTIONAL)

if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelector/models/Coupes - LC C'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelector/models/Coupes - LC C'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LC C starting at price'), 
        0, FailureHandling.OPTIONAL)
}

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Hybrids - UXh'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - UXh'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - UXh starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - NXh'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - NXh starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - RXh'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - RXh starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - ESh'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - ESh starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - LSh'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LSh starting at price'), 
    2, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - LCh'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LCh starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Performance - RC F'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - RC F'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - RC F starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - GS F'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - GS F starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - LC'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LC starting at price'), 
    0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - LCh'))

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LCh starting at price'), 
    0, FailureHandling.OPTIONAL)

if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelector/models/Performance - LC C'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelector/models/Performance - LC C'))

    WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LC C starting at price'), 
        0, FailureHandling.OPTIONAL)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

