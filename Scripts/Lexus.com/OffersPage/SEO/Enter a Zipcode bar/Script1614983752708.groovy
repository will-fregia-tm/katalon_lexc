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

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('OffersPage/SEO/state - Texas'), 0)

WebUI.delay(1)

WebUI.click(findTestObject('OffersPage/SEO/state - Texas'))

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('OffersPage/SEO/city - Plano'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.OPTIONAL)

WebUI.delay(2)

WebUI.scrollToPosition(0, 0)

WebUI.delay(2)

WebUI.scrollToPosition(0, 0)

WebUI.delay(2)

WebUI.setText(findTestObject('OffersPage/ZipBar/zip entry field'), '75218', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('OffersPage/ZipGate/submit button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 20, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/cookied zip code - 75218'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 5, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/cookied zip code - 75218'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers/us')

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('OffersPage/SEO/state - Texas'), 0)

WebUI.delay(1)

WebUI.click(findTestObject('OffersPage/SEO/state - Texas'))

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.OPTIONAL)

WebUI.delay(2)

WebUI.scrollToPosition(0, 0)

WebUI.delay(2)

WebUI.scrollToPosition(0, 0)

WebUI.delay(2)

WebUI.setText(findTestObject('OffersPage/ZipBar/zip entry field'), '30303', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('OffersPage/ZipGate/submit button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 20, FailureHandling.OPTIONAL)

WebUI.delay(4)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/cookied zip code - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 5, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/cookied zip code - 30303'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers/us')

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipBar/zip entry field'), 5, FailureHandling.OPTIONAL)

WebUI.delay(2)

WebUI.scrollToPosition(0, 0)

WebUI.delay(2)

WebUI.scrollToPosition(0, 0)

WebUI.delay(2)

WebUI.setText(findTestObject('OffersPage/ZipBar/zip entry field'), '75218', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('OffersPage/ZipGate/submit button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 20, FailureHandling.OPTIONAL)

WebUI.delay(4)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/cookied zip code - 75218'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 20, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/cookied zip code - 75218'), 0, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

