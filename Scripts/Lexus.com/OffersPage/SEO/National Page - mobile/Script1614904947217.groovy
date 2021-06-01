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

WebUI.delay(5)

colorNational = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - national'), 'color', FailureHandling.STOP_ON_FAILURE)

colorState = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - state'), 'color', FailureHandling.STOP_ON_FAILURE)

colorCity = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - city'), 'color', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(colorState, colorCity, false, FailureHandling.STOP_ON_FAILURE)

'National breadcrumb (US) will be in active state but not clickable. State will be in inactive-state. City tab will be in inactive-state'
WebUI.verifyNotMatch(colorNational, colorCity, false, FailureHandling.STOP_ON_FAILURE)

textState = WebUI.getText(findTestObject('OffersPage/SEO/breadcrumb - state'), FailureHandling.STOP_ON_FAILURE)

textState = (textState - 'Arrow Icon')

'Render: STATE: {ALL} (indicating that all states have are available'
WebUI.verifyMatch(textState, 'STATE: ALL', false, FailureHandling.STOP_ON_FAILURE)

'Will display SEO text as a State List'
stateList = WebUI.getText(findTestObject('OffersPage/SEO/state list'), FailureHandling.STOP_ON_FAILURE)

textState = WebUI.getText(findTestObject('OffersPage/SEO/state 01'), FailureHandling.STOP_ON_FAILURE)

textState = (textState - 'Arrow Icon')

'Will dynamically render a state list of the available states in alphabetical order - which means Alabama should be first.'
WebUI.verifyMatch(textState, 'ALABAMA', false, FailureHandling.OPTIONAL)

'Will only show continental-US state with Dealers. (any state outside of the continental US or without dealers will be hidden. PR, HA, ND)'
WebUI.verifyElementNotPresent(findTestObject('OffersPage/SEO/state - Montana'), 0)

'Will only show continental-US state with Dealers. (any state outside of the continental US or without dealers will be hidden. PR, HA, ND)'
WebUI.verifyElementNotPresent(findTestObject('OffersPage/SEO/state - Wyoming'), 0)

'this is to verify whether checking for text is a valid test'
not_run: WebUI.verifyTextNotPresent('CALIFORNIA', false, FailureHandling.OPTIONAL)

'Will only show continental-US state with Dealers. (any state outside of the continental US or without dealers will be hidden. PR, HA, ND)'
WebUI.verifyTextNotPresent('HAWAII', false, FailureHandling.STOP_ON_FAILURE)

'Will only show continental-US state with Dealers. (any state outside of the continental US or without dealers will be hidden. PR, HA, ND)'
WebUI.verifyTextNotPresent('PUERTO RICO', false, FailureHandling.STOP_ON_FAILURE)

'Will only show continental-US state with Dealers. (any state outside of the continental US or without dealers will be hidden. PR, HA, ND)'
WebUI.verifyTextNotPresent('NORTH DAKOTA', false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/SEO/state - New York'), 0)

stateLink = WebUI.getAttribute(findTestObject('OffersPage/SEO/state - New York'), 'href')

stateLink = ((stateLink - GlobalVariable.SC_Domain) - 'https://aem-author.toyota.com')

'All states will be clickable and link to the state-page: https://www.lexus.com/offers/us/{state_name}#localized'
WebUI.verifyMatch(stateLink, '/offers/us/new-york#localized', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/SEO/state - Ohio'))

WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.OPTIONAL)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotVisibleInViewport(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/SEO/state page title'), 5, FailureHandling.STOP_ON_FAILURE)

'When a user selects a state it will anchor them to the SEO text section of the State Page'
WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/SEO/state page title'), 5, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

