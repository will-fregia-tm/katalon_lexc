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

WebUI.waitForElementPresent(findTestObject('OffersPage/SEO/state - Florida'), 5, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('OffersPage/SEO/state - Florida'), 0)

WebUI.delay(1)

WebUI.click(findTestObject('OffersPage/SEO/state - Florida'))

WebUI.waitForElementPresent(findTestObject('OffersPage/SEO/city - Winter Park'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('OffersPage/SEO/city - Winter Park'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

'Dealers will render in a dealer card format leveraged from Offer-Details page'
WebUI.waitForElementVisible(findTestObject('OffersPage/SEO/dealer name'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('OffersPage/SEO/dealer name'), 0, FailureHandling.OPTIONAL)

'CTA 2 - Inventory - Will drive users to the Dealer Site Inventory page'
WebUI.verifyElementClickable(findTestObject('OffersPage/SEO/inventory CTA - eProcess'), FailureHandling.STOP_ON_FAILURE)

'CTA 2 - Inventory - Will drive users to the Dealer Site Inventory page'
href = WebUI.getAttribute(findTestObject('OffersPage/SEO/inventory CTA - eProcess'), 'href', FailureHandling.STOP_ON_FAILURE)

'dealer inventory link should include this specific search parameter'
modifiedString = (href - 'VehicleSearchResults/?')

WebUI.verifyNotMatch(modifiedString, href, false, FailureHandling.STOP_ON_FAILURE)

'CTA 2 - Inventory - Will drive users to the Dealer Site Inventory page'
WebUI.click(findTestObject('OffersPage/SEO/inventory CTA - eProcess'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

