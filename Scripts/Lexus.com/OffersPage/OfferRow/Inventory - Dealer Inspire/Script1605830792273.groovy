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

response = WS.sendRequest(findTestObject(('OffersPage/DeepLink/' + GlobalVariable.domain) + 'OffersEndpoint'), FailureHandling.OPTIONAL)

trimCode1 = WS.getElementPropertyValue(response, 'offers.Atlanta.trims[0].trimCode[0]', FailureHandling.OPTIONAL)

trimCode2 = WS.getElementPropertyValue(response, 'offers.Atlanta.trims[1].trimCode[0]', FailureHandling.OPTIONAL)

trimCode3 = WS.getElementPropertyValue(response, 'offers.Atlanta.trims[2].trimCode[0]', FailureHandling.OPTIONAL)

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.STOP_ON_FAILURE)

cookieValue = findTestData('cookieValues').getValue(2, 1)

Cookie ck = new Cookie('ESTSAUTH', cookieValue)

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/privacy', FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers?zip=33027', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/OfferRow/row - Inventory'), 0)

WebUI.click(findTestObject('OffersPage/OfferRow/row - Inventory'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/OfferRow/inventory select dealer heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('OffersPage/OfferRow/inventory select dealer heading'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/inventory CTA'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/inventory map'), 0, FailureHandling.OPTIONAL)

WebUI.mouseOver(findTestObject('OffersPage/OfferRow/inventory dealer name'), FailureHandling.STOP_ON_FAILURE)

target = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/inventory CTA'), 'target', FailureHandling.STOP_ON_FAILURE)

'this link should open a new tab'
WebUI.verifyMatch(target, '_blank', false, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/inventory dealer name'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/OfferRow/inventory CTA'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('OffersPage/OfferRow/inventory CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

href = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/inventory CTA'), 'href', FailureHandling.STOP_ON_FAILURE)

'dealer inventory link should include this specific make parameter'
modifiedString = (href - 'make')

WebUI.verifyNotMatch(modifiedString, href, false, FailureHandling.STOP_ON_FAILURE)

'dealer inventory link should include this specific model parameter'
modifiedString = (href - 'model')

WebUI.verifyNotMatch(modifiedString, href, false, FailureHandling.STOP_ON_FAILURE)

'dealer inventory link should include this specific search parameter'
modifiedString = (href - 'new-vehicles/#action=im_ajax_call&perform=get_results&page=1&')

WebUI.verifyNotMatch(modifiedString, href, false, FailureHandling.STOP_ON_FAILURE)

'dealer inventory link should include this specific trim code'
modifiedString = (href - trimCode1)

WebUI.verifyNotMatch(modifiedString, href, false, FailureHandling.STOP_ON_FAILURE)

'dealer inventory link should include this specific trim code'
modifiedString = (href - trimCode2)

WebUI.verifyNotMatch(modifiedString, href, false, FailureHandling.STOP_ON_FAILURE)

'dealer inventory link should include this specific trim code'
modifiedString = (href - trimCode3)

WebUI.verifyNotMatch(modifiedString, href, false, FailureHandling.STOP_ON_FAILURE)

target = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/inventory CTA'), 'target', FailureHandling.STOP_ON_FAILURE)

'this link should open a new tab'
WebUI.verifyMatch(target, '_blank', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/inventory CTA'), FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

