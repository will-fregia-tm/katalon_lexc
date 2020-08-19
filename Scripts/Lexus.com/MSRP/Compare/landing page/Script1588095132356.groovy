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

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/landing page/sedans - starting at prices'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/compare/landing page/sedans - starting at prices'))

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/landing page/sedans - starting at prices'))

'IS 300'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 17)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'ES 350'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 10)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'ES 300h'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 13)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'GS 350 AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 67)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'GS F'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 79)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LS 500 RWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 45)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LS 500h RWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 49)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/landing page/SUVs - starting at prices'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/compare/landing page/SUVs - starting at prices'))

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/landing page/SUVs - starting at prices'))

'UX 200 FWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 73)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'UX 250h AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 75)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'NX 300 FWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 35)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'NX 300h AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'RX 350 FWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 55)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'RX 450h AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 61)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'GX 460'
not_run: expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 29)

not_run: textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

not_run: WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LX 570 Two-Row'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 32)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/landing page/coupes - starting at prices'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/compare/landing page/coupes - starting at prices'))

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/landing page/coupes - starting at prices'))

'RC 300 RWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 2)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'RC F'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 53)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LC'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LC HYBRID'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LC CONVERTIBLE'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 72)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/landing page/hybrids - starting at prices'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/compare/landing page/hybrids - starting at prices'))

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/landing page/hybrids - starting at prices'))

'UX 250h AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 75)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'NX 300h AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'RX 450h AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 61)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'ES 300h'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 13)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LS 500h RWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 49)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LC HYBRID'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/landing page/performance - starting at prices'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/compare/landing page/performance - starting at prices'))

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/landing page/performance - starting at prices'))

'RC F'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 53)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'GS F'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 79)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LC'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LC HYBRID'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

'LC CONVERTIBLE'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 72)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

