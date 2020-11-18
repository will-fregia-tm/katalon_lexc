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

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers?zip=30303&offerType=finance', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - offer type'), 0, FailureHandling.STOP_ON_FAILURE)

offerType = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - offer type'), FailureHandling.STOP_ON_FAILURE)

'only finance offers should be present at this link'
textWithoutOfferType = (offerType - 'FINANCE')

WebUI.verifyNotMatch(offerType, textWithoutOfferType, false, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers?zip=30303&offerType=lease', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - offer type'), 0, FailureHandling.STOP_ON_FAILURE)

offerType = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - offer type'), FailureHandling.STOP_ON_FAILURE)

'only lease offers should be present at this link'
textWithoutOfferType = (offerType - 'LEASE')

WebUI.verifyNotMatch(offerType, textWithoutOfferType, false, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers?zip=30303&offerType=all', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0)

WebUI.verifyElementVisible(findTestObject('OffersPage/ZipBar/zip bar - 30303'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - model name'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)

offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1'), FailureHandling.STOP_ON_FAILURE)

'model name in offer card content should match row model name'
textWithoutModel = (offerCardText - rowModel)

WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 03'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 03 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 03 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 03 - model name'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 03 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)

offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 03 - offer card 1'), FailureHandling.STOP_ON_FAILURE)

'model name in offer card content should match row model name'
textWithoutModel = (offerCardText - rowModel)

WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 04'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 04 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 04 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 04 - model name'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 04 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)

offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 04 - offer card 1'), FailureHandling.STOP_ON_FAILURE)

'model name in offer card content should match row model name'
textWithoutModel = (offerCardText - rowModel)

WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 05'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 05 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 05 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 05 - model name'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 05 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)

offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 05 - offer card 1'), FailureHandling.STOP_ON_FAILURE)

'model name in offer card content should match row model name'
textWithoutModel = (offerCardText - rowModel)

WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 06'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 06'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 06 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 06 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 06 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 07'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 07'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 07 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 07 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 07 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 08'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 08'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 08 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 08 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 08 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 09'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 09'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 09 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 09 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 09 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 10'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 10'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 10 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 10 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 10 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 11'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 11'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 11 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 11 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 11 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 12'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 12'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 12 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 12 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 12 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 13'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 13'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 13 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 13 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 13 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 14'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 14'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 14 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 14 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 14 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 15'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 15'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 15 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 15 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 15 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 16'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 16'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 16 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 16 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 16 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 17'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 17'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 17 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 17 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 17 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 18'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 18'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 18 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 18 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 18 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 19'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 19'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 19 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 19 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 19 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 20'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 20'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 20 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 20 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 20 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 21'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 21'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 21 - model jelly'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 21 - model name'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 21 - offer card 1'), 0, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

