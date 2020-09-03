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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/compare/series/NX')

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 FWD - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 FWD - starting at price'))

'NX 300 FWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 35)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 AWD - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 AWD - starting at price'))

'NX 300 AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 36)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 F Sport FWD - starting at price '),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 F Sport FWD - starting at price '))

'NX 300 F Sport FWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 37)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 F Sport AWD - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 F Sport AWD - starting at price'))

'NX 300 F Sport AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 38)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 FWD Luxury - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 FWD Luxury - starting at price'))

'NX 300 FWD Luxury'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 39)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 AWD Luxury - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300 AWD Luxury - starting at price'))

'NX 300 AWD Luxury'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 40)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300h AWD - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300h AWD - starting at price'))

'NX 300h AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300h AWD Luxury - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/NX/NX 300h AWD Luxury - starting at price'))

'NX 300h AWD Luxury'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 42)

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


