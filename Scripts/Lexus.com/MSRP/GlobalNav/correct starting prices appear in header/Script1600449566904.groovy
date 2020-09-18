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

WebUI.navigateToUrl('https://www.toyota.com/')

WebUI.waitForElementPresent(findTestObject('GlobalNav/header/tcom/Select Vehicle dropdown'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('GlobalNav/header/tcom/Select Vehicle dropdown'))

WebUI.waitForElementVisible(findTestObject('GlobalNav/header/tcom/Model Category - Crossovers SUVs'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GlobalNav/header/tcom/Model Category - Crossovers SUVs'))

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 95)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVS - C-HR'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVS - C-HR'), 'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 96)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVS - RAV4'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVS - RAV4'), 'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 97)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - RAV4 Hybrid'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - RAV4 Hybrid'), 'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 98)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - RAV4 Prime'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - RAV4 Prime'), 'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 99)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Venza'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Venza'), 'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 100)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Highlander'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Highlander'), 'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 101)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Highlander Hybrid'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Highlander Hybrid'), 'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 102)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - 4Runner'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - 4Runner'), 'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 103)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Sequoia'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Sequoia'), 'text', FailureHandling.STOP_ON_FAILURE)

textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 104)

WebUI.mouseOver(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Land Cruiser'))

textWithMSRP = WebUI.getAttribute(findTestObject('GlobalNav/header/tcom/Crossovers SUVs - Land Cruiser'), 'text', FailureHandling.STOP_ON_FAILURE)

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

