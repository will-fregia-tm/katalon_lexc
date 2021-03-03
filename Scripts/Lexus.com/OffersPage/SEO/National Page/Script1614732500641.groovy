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

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers/us')

WebUI.waitForElementPresent(findTestObject('OffersPage/SEO/breadcrumb - national'), 5, FailureHandling.OPTIONAL)

colorNational = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - national'), 'color', FailureHandling.STOP_ON_FAILURE)

colorState = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - state'), 'color', FailureHandling.STOP_ON_FAILURE)

colorCity = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - city'), 'color', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(colorState, colorCity, false, FailureHandling.STOP_ON_FAILURE)

'National breadcrumb (US) will be in active state but not clickable. State will be in inactive-state. City tab will be in inactive-state'
WebUI.verifyNotMatch(colorNational, colorCity, false, FailureHandling.STOP_ON_FAILURE)

textState = WebUI.getText(findTestObject('OffersPage/SEO/breadcrumb - state'), FailureHandling.STOP_ON_FAILURE)

'Render: STATE: {ALL} (indicating that all states have are available'
WebUI.verifyMatch(textState, 'STATE: ALL', false, FailureHandling.STOP_ON_FAILURE)

textState = WebUI.getText(findTestObject('OffersPage/SEO/state list'), FailureHandling.STOP_ON_FAILURE)

textState = WebUI.getText(findTestObject('OffersPage/SEO/state 01'), FailureHandling.STOP_ON_FAILURE)

'Will dynamically render a state list of the available states in alphabetical order.'
WebUI.verifyMatch(textState, 'ALASKA', false, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

