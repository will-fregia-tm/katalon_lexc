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

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.STOP_ON_FAILURE)

cookieValue = findTestData('cookieValues').getValue(2, 1)

Cookie ck = new Cookie('ESTSAUTH', cookieValue)

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/privacy', FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers?zip=30303', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - details button'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

offerType = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - offer type'), FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 0, FailureHandling.STOP_ON_FAILURE)

offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

'model name in offer details should match selected model-style, and includes fallback in case trim only has consolidated/military/college grad offers'
textWithoutModel = ((((offerCardText - dropdownText) - 'MILITARY REBATE') - 'COLLEGE') - 'SELECT')

WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

'offer type in offer details should match offer card'
textWithoutOffer = (offerCardText - offerType)

WebUI.verifyNotMatch(offerCardText, textWithoutOffer, false, FailureHandling.STOP_ON_FAILURE)

legalCopy = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details legal copy'), FailureHandling.STOP_ON_FAILURE)

'legal copy should display copy, including year'
modifiedString = (legalCopy - '20')

WebUI.verifyNotMatch(modifiedString, legalCopy, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 0, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

