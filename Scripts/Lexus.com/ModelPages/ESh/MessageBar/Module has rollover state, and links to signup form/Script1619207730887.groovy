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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

def modelSeries = GlobalVariable.currentTestCaseID //get current testcase name

String[] parts = modelSeries.split('/' //split it to using delimeter /
    )

String three = parts[(parts.length - 3)]

modelSeries = three

int seriesKey = findTestData('modelData' + modelSeries).getValue(1, 2).toInteger()

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.OPTIONAL)

'these steps are added to handle lower environment authentication'
if (WebUI.verifyMatch(GlobalVariable.lowerEnvironment, 'yes', false, FailureHandling.OPTIONAL)) {
    cookieValue = findTestData('cookieValues').getValue(2, 1)

    Cookie ck = new Cookie('ESTSAUTH', cookieValue)

    WebDriver driver = DriverFactory.getWebDriver()

    driver.manage().addCookie(ck)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

WebUI.navigateToUrl(GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey))

'these steps are added to handle author environment URLs'
not_run: if (WebUI.verifyMatch(GlobalVariable.author, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        GlobalVariable.authorQuery)
}

'this step is added to handle a slow or partial page load'
if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/hero module'), 6, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 6, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('ModelPages/Subnav/offers link'), FailureHandling.OPTIONAL)

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('ModelPages/AdditionalInfo/additional info module'), 0, FailureHandling.OPTIONAL)

WebUI.delay(1)

target = WebUI.getAttribute(findTestObject('ModelPages/MessageBar/signup link'), 'target', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(target, '_self', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ModelPages/MessageBar/signup link'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ModelPages/MessageBar/signup text'), 0, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('ModelPages/MessageBar/signup link'), FailureHandling.STOP_ON_FAILURE)

expectedValue = 'STAY INFORMED'

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'these steps validate that the actual value contains an expected value'
actualValue = WebUI.getText(findTestObject('ModelPages/MessageBar/signup text'), FailureHandling.CONTINUE_ON_FAILURE)

expectedValue = 'RECEIVE'

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

println(browser)

'checks hover state, with workaround for the firefox driver not being able to mouseOver'
if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
    barNoHover = WebUI.getCSSValue(findTestObject('ModelPages/MessageBar/signup link'), 'opacity', FailureHandling.STOP_ON_FAILURE)

    WebUI.mouseOver(findTestObject('ModelPages/MessageBar/signup link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    barYesHover = WebUI.getCSSValue(findTestObject('ModelPages/MessageBar/signup link'), 'opacity', FailureHandling.STOP_ON_FAILURE)

    'When a user hovers over anywhere in the module, then the system shall update the module to its hover over state'
    WebUI.verifyNotMatch(barNoHover, barYesHover, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('ModelPages/MessageBar/signup link'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0)

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/form overlay'), 0, FailureHandling.STOP_ON_FAILURE)

selectedModel = WebUI.getText(findTestObject('ModelPages/SignupForm/pre-selected model'))

'Clicking on sign-up link takes user to form with model preselected'
WebUI.verifyMatch(selectedModel, findTestData('modelData').getValue(1, seriesKey + 1380), false)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

