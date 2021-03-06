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

WebUI.delay(1)

WebUI.click(findTestObject('OffersPage/SEO/state - Texas'))

WebUI.waitForElementPresent(findTestObject('OffersPage/SEO/state page title'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('OffersPage/SEO/city - Plano'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.OPTIONAL)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotVisibleInViewport(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.STOP_ON_FAILURE)

'Will display City page title'
WebUI.verifyElementPresent(findTestObject('OffersPage/SEO/city page title'), 5, FailureHandling.STOP_ON_FAILURE)

'If the user clicks on a city they will progress to the City page, anchoring them to the same SEO Text section of the page'
WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/SEO/city page title'), 5, FailureHandling.STOP_ON_FAILURE)

pageTitle = WebUI.getText(findTestObject('OffersPage/SEO/city page title'))

WebUI.verifyMatch(pageTitle, 'PLANO, TX', false, FailureHandling.STOP_ON_FAILURE)

'Will display City body copy'
WebUI.verifyElementPresent(findTestObject('OffersPage/SEO/city body copy'), 5, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('OffersPage/SEO/city body copy'))

'these steps validate that the actual value contains the expected value'
expectedValue = 'Lexus offers'

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'Will render Breadcrumbs:'
colorNational = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - national'), 'color', FailureHandling.STOP_ON_FAILURE)

'Will render Breadcrumbs:'
colorState = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - state'), 'color', FailureHandling.STOP_ON_FAILURE)

'Will render Breadcrumbs:'
colorCity = WebUI.getCSSValue(findTestObject('OffersPage/SEO/breadcrumb - city'), 'color', FailureHandling.STOP_ON_FAILURE)

'National, State and City will render in active-state'
WebUI.verifyMatch(colorState, colorNational, false, FailureHandling.STOP_ON_FAILURE)

'National, State and City will render in active-state'
WebUI.verifyMatch(colorNational, colorCity, false, FailureHandling.STOP_ON_FAILURE)

textState = WebUI.getText(findTestObject('OffersPage/SEO/breadcrumb - state'), FailureHandling.STOP_ON_FAILURE)

'State will display as STATE: {state_name}'
WebUI.verifyMatch(textState, 'STATE: TEXAS', false, FailureHandling.STOP_ON_FAILURE)

textState = WebUI.getText(findTestObject('OffersPage/SEO/breadcrumb - city'), FailureHandling.STOP_ON_FAILURE)

'City will display as CITY: {city_name}'
WebUI.verifyMatch(textState, 'CITY: PLANO', false, FailureHandling.STOP_ON_FAILURE)

'Will show all the available dealers for the LDA market of the city/metro that was selected.'
cityList = WebUI.getText(findTestObject('OffersPage/SEO/dealer list'), FailureHandling.STOP_ON_FAILURE)

'Dealers will render in a dealer card format leveraged from Offer-Details page'
WebUI.waitForElementVisible(findTestObject('OffersPage/SEO/dealer name'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/SEO/dealer name'), 0, FailureHandling.STOP_ON_FAILURE)

'Dealer Name - Will be clickable to drive users to dealer site homepage'
actualValue = WebUI.getText(findTestObject('OffersPage/SEO/dealer name'), FailureHandling.STOP_ON_FAILURE)

'these steps validate that the actual value contains an expected value'
expectedValue1 = 'Lexus'

'these steps validate that the actual value contains an expected value'
expectedValue2 = 'LEXUS'

valueWithoutExpected = ((actualValue - expectedValue1) - expectedValue2)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'Dealer Name - Will be clickable to drive users to dealer site homepage'
WebUI.click(findTestObject('OffersPage/SEO/dealer name'))

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers/us/texas/plano#localized')

WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

'Dealer Address'
actualValue = WebUI.getText(findTestObject('OffersPage/SEO/dealer address'), FailureHandling.STOP_ON_FAILURE)

'these steps validate that the actual value contains an expected value'
expectedValue = 'TX'

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'CTA 1 - View Offers: will drive users to the Market Offers page based on the market that the dealer belongs to (using the dealer zip code)'
WebUI.verifyElementClickable(findTestObject('OffersPage/SEO/view offers CTA'), FailureHandling.STOP_ON_FAILURE)

'CTA 1 - View Offers: will drive users to the Market Offers page based on the market that the dealer belongs to (using the dealer zip code)'
actualValue = WebUI.getAttribute(findTestObject('OffersPage/SEO/view offers CTA'), 'href', FailureHandling.STOP_ON_FAILURE)

'these steps validate that the actual value contains an expected value'
expectedValue = '/offers?zip=7'

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'CTA 1 - View Offers: will drive users to the Market Offers page based on the market that the dealer belongs to (using the dealer zip code)'
WebUI.click(findTestObject('OffersPage/SEO/view offers CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0)

WebUI.back()

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

'CTA 2 - Inventory - Will drive users to the Dealer Site Inventory page'
WebUI.verifyElementClickable(findTestObject('OffersPage/SEO/inventory CTA'), FailureHandling.STOP_ON_FAILURE)

'CTA 2 - Inventory - Will drive users to the Dealer Site Inventory page'
actualValue = WebUI.getAttribute(findTestObject('OffersPage/SEO/inventory CTA'), 'href', FailureHandling.STOP_ON_FAILURE)

'these steps validate that the actual value contains an expected value'
expectedValue = '.com'

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'CTA 2 - Inventory - Will drive users to the Dealer Site Inventory page'
WebUI.click(findTestObject('OffersPage/SEO/inventory CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

