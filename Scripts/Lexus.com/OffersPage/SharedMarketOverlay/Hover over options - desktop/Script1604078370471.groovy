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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/privacy')

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers')

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/form input'), 5, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('OffersPage/ZipGate/form input'), '08008')

WebUI.click(findTestObject('OffersPage/ZipGate/submit button'))

WebUI.waitForElementPresent(findTestObject('OffersPage/SharedMarketOverlay/shared zip overlay'), 5, FailureHandling.OPTIONAL)

noHover = WebUI.getCSSValue(findTestObject('OffersPage/SharedMarketOverlay/displayed market name - New York, New Jersey, Connecticut Dealers'), 'background-color', 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('OffersPage/SharedMarketOverlay/displayed market name - New York, New Jersey, Connecticut Dealers'))

hoverState = WebUI.getCSSValue(findTestObject('OffersPage/SharedMarketOverlay/displayed market name - New York, New Jersey, Connecticut Dealers'), 'background-color', 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyNotMatch('hoverState', 'noHover', false, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

noHover = WebUI.getCSSValue(findTestObject('OffersPage/SharedMarketOverlay/displayed market name - New Jersey, Delaware, Pennsylvania Dealers'), 'background-color', 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('OffersPage/SharedMarketOverlay/displayed market name - New Jersey, Delaware, Pennsylvania Dealers'))

hoverState = WebUI.getCSSValue(findTestObject('OffersPage/SharedMarketOverlay/displayed market name - New Jersey, Delaware, Pennsylvania Dealers'), 'background-color', 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyNotMatch('hoverState', 'noHover', false, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

