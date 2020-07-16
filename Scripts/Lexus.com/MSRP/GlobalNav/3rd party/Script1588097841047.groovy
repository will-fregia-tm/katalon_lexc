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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Header)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 17)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/sedans - IS starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 10)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/sedans - ES - starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 13)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/sedans - ESh - starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 67)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/sedans - GS - starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 79)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/sedans - GS F - starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 45)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/sedans - LS starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 49)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/sedans - LSh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 73)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/SUVs - UX starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 75)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/SUVs - UXh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 35)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/SUVs - NX starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/SUVs - NXh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 55)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/SUVs - RX starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 61)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/SUVs - RXh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 29)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/SUVs - GX starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 32)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/SUVs - LX starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 2)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/coupes - RC starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 53)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/coupes - RC F starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/coupes - LC starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/coupes - LCh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/global nav/coupes - LC C starting at price'), 0, FailureHandling.OPTIONAL)) {
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 72)

    textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/coupes - LC C starting at price'), 
        'text', FailureHandling.STOP_ON_FAILURE)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 75)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/hybrids - UXh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/hybrids - NXh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 61)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/hybrids - RXh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 13)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/hybrids - ESh - starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 49)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/hybrids - LSh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/hybrids - LCh starting at price'), 'text', 
    FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 53)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/performance - RC F starting at price'), 
    'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 79)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/performance - GS F - starting at price'), 
    'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/performance - LC starting at price'), 
    'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/performance - LCh starting at price'), 
    'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/global nav/performance - LC C starting at price'), 0, FailureHandling.OPTIONAL)) {
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 72)

    textWithMSRP = WebUI.getAttribute(findTestObject('MSRP/section objects/global nav/performance - LC C starting at price'), 
        'text', FailureHandling.STOP_ON_FAILURE)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

