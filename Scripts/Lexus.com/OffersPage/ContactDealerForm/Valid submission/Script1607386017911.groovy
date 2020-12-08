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

WebUI.waitForElementVisible(findTestObject('OffersPage/OfferRow/row 02 - Inventory'), 0)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0)

offerTitle = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - title'), FailureHandling.STOP_ON_FAILURE)

offerType = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - offer type'), FailureHandling.STOP_ON_FAILURE)

offerTerms = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - terms'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - contact dealer button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/OfferDetails/form CTA'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/OfferDetails/market dealer name'), 0, FailureHandling.STOP_ON_FAILURE)

detailsInventory = WebUI.getAttribute(findTestObject('OffersPage/OfferDetails/inventory CTA'), 'href', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferDetails/form CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ContactDealerForm/form heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('OffersPage/ContactDealerForm/input field - first name'), 'sendto', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('OffersPage/ContactDealerForm/input field - last name'), 'adf', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('OffersPage/ContactDealerForm/input field - email'), 'zach.smith@teamone-usa.com', FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('OffersPage/ContactDealerForm/submit button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/ContactDealerForm/submit button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ContactDealerForm/thank you headline'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/thank you headline'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/thank you subheadline'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/thank you subheadline'), 0, FailureHandling.STOP_ON_FAILURE)

offerCard = WebUI.getText(findTestObject('OffersPage/ContactDealerForm/offer card'), FailureHandling.STOP_ON_FAILURE)

'thank you offer card copy should match that of card in offer row'
modifiedString = (offerCard - offerTitle)

WebUI.verifyNotMatch(modifiedString, offerCard, false, FailureHandling.STOP_ON_FAILURE)

'thank you offer card copy should match that of card in offer row'
modifiedString = (offerCard - offerType)

WebUI.verifyNotMatch(modifiedString, offerCard, false, FailureHandling.STOP_ON_FAILURE)

'thank you offer card copy should match that of card in offer row'
modifiedString = (offerCard - offerTerms)

WebUI.verifyNotMatch(modifiedString, offerCard, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/thank you - dealer name'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/ContactDealerForm/thank you - dealer name'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ContactDealerForm/thank you headline'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/thank you - dealer distance'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/thank you - dealer address'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/thank you - dealer phone'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/thank you - inventory link'), 0, FailureHandling.STOP_ON_FAILURE)

cardInventory = WebUI.getAttribute(findTestObject('OffersPage/ContactDealerForm/thank you - inventory link'), 'href', FailureHandling.STOP_ON_FAILURE)

'thank you inventory CTA values should match details inventory CTA, which is validated in a separate test'
modifiedString = (cardInventory - detailsInventory)

WebUI.verifyNotMatch(modifiedString, cardInventory, false, FailureHandling.STOP_ON_FAILURE)

target = WebUI.getAttribute(findTestObject('OffersPage/ContactDealerForm/thank you - inventory link'), 'target', FailureHandling.STOP_ON_FAILURE)

'this link should open a new tab'
WebUI.verifyMatch(target, '_blank', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/ContactDealerForm/thank you - inventory link'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ContactDealerForm/thank you headline'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/thank you - back to offers CTA'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('OffersPage/ContactDealerForm/thank you - back to offers CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/ContactDealerForm/thank you - back to offers CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/OfferRow/row 02 - Inventory'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('OffersPage/ContactDealerForm/thank you headline'), 0, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

