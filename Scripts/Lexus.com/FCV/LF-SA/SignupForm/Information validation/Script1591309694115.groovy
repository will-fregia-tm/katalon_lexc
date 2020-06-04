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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)

WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFSA')

WebUI.waitForElementPresent(findTestObject('FCV/Hero/Stay Informed button'), 5)

WebUI.click(findTestObject('FCV/Hero/Stay Informed button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FCV/SignupForm/form overlay'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FCV/SignupForm/submit button'))

backgroundColor = WebUI.getCSSValue(findTestObject('FCV/SignupForm/input field - first name'), 'background-color')

WebUI.verifyMatch(backgroundColor, 'rgb(254, 232, 232)', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FCV/SignupForm/valid first name prompt'), 0)

backgroundColor = WebUI.getCSSValue(findTestObject('FCV/SignupForm/input field - last name'), 'background-color')

WebUI.verifyMatch(backgroundColor, 'rgb(254, 232, 232)', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FCV/SignupForm/valid last name prompt'), 0)

backgroundColor = WebUI.getCSSValue(findTestObject('FCV/SignupForm/input field - email'), 'background-color')

WebUI.verifyMatch(backgroundColor, 'rgb(254, 232, 232)', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FCV/SignupForm/valid email prompt'), 0)

backgroundColor = WebUI.getCSSValue(findTestObject('FCV/SignupForm/input field - zip code'), 'background-color')

WebUI.verifyMatch(backgroundColor, 'rgb(254, 232, 232)', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FCV/SignupForm/valid zip code prompt'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

