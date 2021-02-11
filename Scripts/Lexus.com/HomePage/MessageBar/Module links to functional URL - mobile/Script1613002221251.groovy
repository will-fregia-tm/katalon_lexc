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

'these steps are added to handle lower environment authentication'
if (WebUI.verifyMatch(GlobalVariable.lowerEnvironment, 'yes', false, FailureHandling.OPTIONAL)) {
    cookieValue = findTestData('cookieValues').getValue(2, 1)

    Cookie ck = new Cookie('ESTSAUTH', cookieValue)

    WebDriver driver = DriverFactory.getWebDriver()

    driver.manage().addCookie(ck)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

'if the page renders slowly, it will be refreshed so the test can continue'
if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('Homepage/MessageBar/recall bar'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 01'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 02'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 03'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/MessageBar/recall bar'), 0, FailureHandling.STOP_ON_FAILURE)

target = WebUI.getAttribute(findTestObject('Homepage/MessageBar/recall bar'), 'target', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(target, '_self', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Homepage/MessageBar/recall CTA'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Homepage/MessageBar/recall text'), 0, FailureHandling.STOP_ON_FAILURE)

CTA = WebUI.getText(findTestObject('Homepage/MessageBar/recall CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(CTA, 'RECALL INFORMATION', false, FailureHandling.STOP_ON_FAILURE)

text = WebUI.getText(findTestObject('Homepage/MessageBar/recall text'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(text, 'YOUR SAFETY IS A TOP PRIORITY FOR LEXUS. VIEW INFORMATION ON SAFETY RECALLS AND FIND OUT IF YOUR LEXUS IS AFFECTED.', 
    false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Homepage/MessageBar/recall bar'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0)

windowTitle = WebUI.getWindowTitle()

modifiedString = (windowTitle - 'Recall')

'these steps are added to handle environments in which the linked page is not present'
if (WebUI.verifyMatch(windowTitle, modifiedString, false, FailureHandling.OPTIONAL)) {
    WebUI.back(FailureHandling.STOP_ON_FAILURE)

    href = WebUI.getAttribute(findTestObject('Homepage/MessageBar/recall bar'), 'href', FailureHandling.STOP_ON_FAILURE)

    not_run: href = ((href - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com')

    WebUI.navigateToUrl(href, FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    windowTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

    modifiedString = ((windowTitle - 'Lexus') - 'Recall')

    WebUI.verifyNotMatch(windowTitle, modifiedString, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

