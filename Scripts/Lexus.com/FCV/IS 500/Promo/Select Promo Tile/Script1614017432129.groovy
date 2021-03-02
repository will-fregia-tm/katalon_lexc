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

WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFSA')

if (WebUI.verifyElementNotPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5, FailureHandling.STOP_ON_FAILURE)

absoluteLink = WebUI.getAttribute(findTestObject('FCV/Promo/model card 1'), 'href', FailureHandling.STOP_ON_FAILURE)

'removes domain from URL in order to create a relative link'
relativeLink = (absoluteLink - GlobalVariable.AEM_Domain)

subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 1 subtag'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FCV/Promo/model card 1'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(subtagText, false, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFSA')

not_run: WebUI.back(FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.back(FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5, FailureHandling.STOP_ON_FAILURE)

subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 2 subtag'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FCV/Promo/model card 2'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(subtagText, false, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFSA')

not_run: WebUI.back(FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5)

subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 3 subtag'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FCV/Promo/model card 3'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0)

WebUI.verifyTextPresent(subtagText, false)

WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFSA')

not_run: WebUI.back()

WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5)

absoluteLink = WebUI.getAttribute(findTestObject('FCV/Promo/model card 4'), 'href', FailureHandling.STOP_ON_FAILURE)

'removes domain from URL in order to create a relative link'
relativeLink = (absoluteLink - GlobalVariable.AEM_Domain)

subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 4 subtag'), FailureHandling.STOP_ON_FAILURE)

'removes L from text to account for RXL content scenario'
subtagText = (subtagText - 'L')

WebUI.click(findTestObject('FCV/Promo/model card 4'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(subtagText, false, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFSA')

not_run: WebUI.back(FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.back(FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5, FailureHandling.STOP_ON_FAILURE)

absoluteLink = WebUI.getAttribute(findTestObject('FCV/Promo/model card 5'), 'href', FailureHandling.STOP_ON_FAILURE)

'removes domain from URL in order to create a relative link'
relativeLink = (absoluteLink - GlobalVariable.AEM_Domain)

subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 5 subtag'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FCV/Promo/model card 5 subtag'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://www.lexus.com' + relativeLink, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(subtagText, false, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

