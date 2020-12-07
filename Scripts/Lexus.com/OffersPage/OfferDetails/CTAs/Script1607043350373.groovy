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

'default trim code, to be used unless a specific trim code is present'
trimCode1 = '='

'default trim code, to be used unless a specific trim code is present'
trimCode2 = '='

'default trim code, to be used unless a specific trim code is present'
trimCode3 = '='

WebUI.waitForElementVisible(findTestObject('OffersPage/OfferRow/row 02 - Inventory'), 0)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - Inventory'), FailureHandling.STOP_ON_FAILURE)

rowInventory = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/inventory CTA'), 'href', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferDetails/back to offers CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0)

rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - model name'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - contact dealer button'), 0)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - contact dealer button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/OfferDetails/market dealer name'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('OffersPage/OfferDetails/back to offers CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferDetails/back to offers CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - contact dealer button'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/OfferDetails/market dealer name'), 0)

WebUI.click(findTestObject('OffersPage/OfferDetails/market dealer name'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

WebUI.switchToWindowIndex(0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/OfferDetails/market dealer name'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/OfferDetails/form CTA'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferDetails/form CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ContactDealerForm/form heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/form heading'), 0, FailureHandling.STOP_ON_FAILURE)

detailsInventory = WebUI.getAttribute(findTestObject('OffersPage/OfferDetails/inventory CTA'), 'href', FailureHandling.STOP_ON_FAILURE)

'details inventory CTA values should match row inventory CTA, which is validated in a separate test'
modifiedString = (detailsInventory - rowInventory)

WebUI.verifyNotMatch(modifiedString, detailsInventory, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/zipcode'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/dealer details'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/ContactDealerForm/model information'), 0, FailureHandling.STOP_ON_FAILURE)

modelInformation = WebUI.getText(findTestObject('OffersPage/ContactDealerForm/model information'), FailureHandling.STOP_ON_FAILURE)

'model in form should match model row'
modifiedString = (modelInformation - rowModel)

WebUI.verifyNotMatch(modifiedString, modelInformation, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/ContactDealerForm/close overlay button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('OffersPage/OfferDetails/inventory CTA'), 0, FailureHandling.STOP_ON_FAILURE)

target = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/inventory CTA'), 'target', FailureHandling.STOP_ON_FAILURE)

'this link should open a new tab'
WebUI.verifyMatch(target, '_blank', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/inventory CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

