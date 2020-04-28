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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/compare/series/IS')

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 300 RWD - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 300 RWD - starting at price'))

'IS 300 RWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 17)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 300 AWD - starting at price'))

'IS 300 AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 19)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 300 F Sport RWD - starting at price'))

'IS 300 F Sport RWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 18)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 300 F Sport AWD - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 300 F Sport AWD - starting at price'))

'IS 300 F Sport AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 20)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 350 RWD - starting at price'))

'IS 350 RWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 21)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 350 AWD - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 350 AWD - starting at price'))

'IS 350 AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 23)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 350 F Sport RWD - starting at price'))

'IS 350 F Sport RWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 22)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 350 F Sport AWD - starting at price'),
	0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/series pages - JATO IDs/IS/IS 350 F Sport AWD - starting at price'))

'IS 350 F Sport AWD'
expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 24)

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

