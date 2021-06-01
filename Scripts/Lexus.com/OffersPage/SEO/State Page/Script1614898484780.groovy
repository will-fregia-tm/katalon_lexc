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

WebUI.scrollToElement(findTestObject('OffersPage/SEO/state - Texas'), 0)

WebUI.click(findTestObject('OffersPage/SEO/state - Texas'))

WebUI.waitForElementPresent(findTestObject('OffersPage/SEO/state page title'), 5, FailureHandling.OPTIONAL)

'Will display State page title and body copy'
WebUI.verifyElementPresent(findTestObject('OffersPage/SEO/state page title'), 5, FailureHandling.STOP_ON_FAILURE)

pageTitle = WebUI.getText(findTestObject('OffersPage/SEO/state page title'))

WebUI.verifyMatch(pageTitle, 'TEXAS LEXUS OFFERS', false, FailureHandling.STOP_ON_FAILURE)

'Will display State page title and body copy'
WebUI.verifyElementPresent(findTestObject('OffersPage/SEO/state body copy'), 5, FailureHandling.STOP_ON_FAILURE)

bodyCopy = WebUI.getText(findTestObject('OffersPage/SEO/state body copy'))

WebUI.verifyMatch(bodyCopy, 'Narrow down your Lexus offer search by selecting a nearby City.', false, FailureHandling.STOP_ON_FAILURE)

colorNational = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - national'), 'color', FailureHandling.STOP_ON_FAILURE)

colorState = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - state'), 'color', FailureHandling.STOP_ON_FAILURE)

colorCity = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - city'), 'color', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(colorState, colorNational, false, FailureHandling.STOP_ON_FAILURE)

'Will render Breadcrumbs: National and State will render in active-state, City will be in inactive-state'
WebUI.verifyNotMatch(colorNational, colorCity, false, FailureHandling.STOP_ON_FAILURE)

textState = WebUI.getText(findTestObject('OffersPage/SEO/breadcrumb - state'), FailureHandling.STOP_ON_FAILURE)

textState = (textState - 'Arrow Icon')

'State will display as STATE: {state_name}'
WebUI.verifyMatch(textState, 'STATE: TEXAS', false, FailureHandling.STOP_ON_FAILURE)

textState = WebUI.getText(findTestObject('OffersPage/SEO/breadcrumb - city'), FailureHandling.STOP_ON_FAILURE)

textState = (textState - 'Arrow Icon')

'City will display as CITY: ALL'
WebUI.verifyMatch(textState, 'CITY: ALL', false, FailureHandling.STOP_ON_FAILURE)

'Will show all the available cities within the state that was selected or searched for in list format.'
cityList = WebUI.getText(findTestObject('OffersPage/SEO/city list'), FailureHandling.STOP_ON_FAILURE)

cityLink = WebUI.getAttribute(findTestObject('OffersPage/SEO/city - Ft Worth'), 'href', FailureHandling.STOP_ON_FAILURE)

cityLink = ((cityLink - GlobalVariable.SC_Domain) - 'https://aem-author.toyota.com')

WebUI.verifyMatch(cityLink, '/offers/us/texas/ft-worth#localized', false, FailureHandling.STOP_ON_FAILURE)

cityLink = WebUI.getAttribute(findTestObject('OffersPage/SEO/city - Plano'), 'href', FailureHandling.STOP_ON_FAILURE)

cityLink = ((cityLink - GlobalVariable.SC_Domain) - 'https://aem-author.toyota.com')

WebUI.verifyMatch(cityLink, '/offers/us/texas/plano#localized', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/SEO/city - Plano'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.OPTIONAL)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotVisibleInViewport(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/SEO/city page title'), 5, FailureHandling.STOP_ON_FAILURE)

'If the user clicks on a city they will progress to the City page, anchoring them to the same SEO Text section of the page'
WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/SEO/city page title'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/SEO/breadcrumb - state'))

WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

'If the user clicks on the National breadcrumb or hits back on the browser, then the system will direct them back to the National page and anchor them to the SEO text section (Breadcrumbs + State list)'
WebUI.click(findTestObject('OffersPage/SEO/breadcrumb - national'))

WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

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

WebUI.scrollToElement(findTestObject('OffersPage/SEO/state - Texas'), 0)

WebUI.click(findTestObject('OffersPage/SEO/state - Texas'))

WebUI.waitForElementPresent(findTestObject('OffersPage/SEO/state page title'), 5, FailureHandling.OPTIONAL)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

