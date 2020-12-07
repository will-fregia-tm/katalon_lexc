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

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - contact dealer button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/OfferDetails/form CTA'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/OfferDetails/market dealer name'), 0)

WebUI.click(findTestObject('OffersPage/OfferDetails/form CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ContactDealerForm/form heading'), 0)

WebUI.click(findTestObject('OffersPage/ContactDealerForm/submit button'), FailureHandling.STOP_ON_FAILURE)

backgroundColor = WebUI.getCSSValue(findTestObject('OffersPage/ContactDealerForm/input field - first name'), 'background-color', 
    FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(backgroundColor, 'rgba(254, 232, 232, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(backgroundColor, 'rgb(254, 232, 232)', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyElementPresent(findTestObject('OffersPage/ContactDealerForm/valid first name prompt'), 0, FailureHandling.STOP_ON_FAILURE)

backgroundColor = WebUI.getCSSValue(findTestObject('OffersPage/ContactDealerForm/input field - last name'), 'background-color', 
    FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(backgroundColor, 'rgba(254, 232, 232, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(backgroundColor, 'rgb(254, 232, 232)', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyElementPresent(findTestObject('OffersPage/ContactDealerForm/valid last name prompt'), 0, FailureHandling.STOP_ON_FAILURE)

backgroundColor = WebUI.getCSSValue(findTestObject('OffersPage/ContactDealerForm/input field - email'), 'background-color', 
    FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(backgroundColor, 'rgba(254, 232, 232, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(backgroundColor, 'rgb(254, 232, 232)', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyElementPresent(findTestObject('OffersPage/ContactDealerForm/valid email prompt'), 0, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

