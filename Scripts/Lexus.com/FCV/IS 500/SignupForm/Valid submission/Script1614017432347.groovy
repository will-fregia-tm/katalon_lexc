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
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.OPTIONAL)

cookieValue = findTestData('cookieValues').getValue(2, 1)

Cookie ck = new Cookie('ESTSAUTH', cookieValue)

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

domain = GlobalVariable.domain

'this step is added to handle legacy staging authentication'
if (WebUI.verifyMatch(domain, 'staging', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFSA')

if (WebUI.verifyElementNotPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FCV/Hero/Stay Informed button'), 5)

WebUI.verifyElementNotPresent(findTestObject('FCV/SignupForm/form overlay'), 0)

WebUI.mouseOver(findTestObject('FCV/Hero/Stay Informed button'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('FCV/Hero/Stay Informed button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FCV/SignupForm/form overlay'), 0)

WebUI.setText(findTestObject('FCV/SignupForm/input field - first name'), 'sendto', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('FCV/SignupForm/input field - last name'), 'adf', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('FCV/SignupForm/input field - email'), 'zach.smith@teamone-usa.com', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('FCV/SignupForm/input field - zip code'), '90064', FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('FCV/SignupForm/submit button'), FailureHandling.OPTIONAL)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FCV/SignupForm/submit button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('FCV/SignupForm/thank you headline'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('FCV/SignupForm/thank you headline'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('FCV/SignupForm/thank you subheadline'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('FCV/SignupForm/back to browsing CTA'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('FCV/SignupForm/back to browsing CTA'), FailureHandling.OPTIONAL)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FCV/SignupForm/back to browsing CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('FCV/SignupForm/form overlay'), 0, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

