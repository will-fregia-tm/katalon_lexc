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

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0)

offerJelly = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 02 - model jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

'checks image dislaimer if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - model jelly disclaimer'), 3, FailureHandling.OPTIONAL)) {
    jellyDisclaimer = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - model jelly disclaimer'), FailureHandling.STOP_ON_FAILURE)
}

offerTitle = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - title'), FailureHandling.STOP_ON_FAILURE)

offerType = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - offer type'), FailureHandling.STOP_ON_FAILURE)

offerTerms = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - terms'), FailureHandling.STOP_ON_FAILURE)

offerLegal = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - legal'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.STOP_ON_FAILURE)

WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details legal copy'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.STOP_ON_FAILURE)

'this verifies that subsequent detail variables are taken from the correct elements - which should not be present at this point'
WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferDetails/model-model year'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferDetails/model-jelly'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - contact dealer button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/OfferDetails/model-model year'), 0, FailureHandling.OPTIONAL)

detailJelly = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 02 - model jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(detailJelly, offerJelly, false, FailureHandling.STOP_ON_FAILURE)

'checks image dislaimer if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferDetails/jelly-disclaimer'), 3, FailureHandling.OPTIONAL)) {
    detailDisclaimer = WebUI.getText(findTestObject('OffersPage/OfferDetails/jelly-disclaimer'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(detailDisclaimer, jellyDisclaimer, false, FailureHandling.STOP_ON_FAILURE)
}

detailTitle = WebUI.getText(findTestObject('OffersPage/OfferDetails/model-model year'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(detailTitle, offerTitle, false, FailureHandling.STOP_ON_FAILURE)

detailType = WebUI.getText(findTestObject('OffersPage/OfferDetails/offer information - type'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(detailType, offerType, false, FailureHandling.STOP_ON_FAILURE)

detailTerms = WebUI.getText(findTestObject('OffersPage/OfferDetails/offer information - terms'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(detailTerms, offerTerms, false, FailureHandling.STOP_ON_FAILURE)

detailLegal = WebUI.getText(findTestObject('OffersPage/OfferDetails/offer legal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(detailLegal, offerLegal, false, FailureHandling.STOP_ON_FAILURE)

detailDisclaimer = WebUI.getText(findTestObject('OffersPage/OfferDetails/offer legal disclaimer'), FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

