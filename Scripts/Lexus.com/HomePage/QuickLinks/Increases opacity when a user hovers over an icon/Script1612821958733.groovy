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

WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/hero module'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.STOP_ON_FAILURE)

noHover = WebUI.getCSSValue(findTestObject('Homepage/QuickLinks/BYL link - image'), 'opacity', FailureHandling.OPTIONAL)

WebUI.mouseOver(findTestObject('Homepage/QuickLinks/BYL link - image'), FailureHandling.OPTIONAL)

WebUI.delay(1)

yesHover = WebUI.getCSSValue(findTestObject('Homepage/QuickLinks/BYL link - image'), 'opacity', FailureHandling.OPTIONAL)

String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

println(browser)

'this is a workaround the firefox driver not being able to mouseOver'
if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyNotMatch(noHover, yesHover, false, FailureHandling.STOP_ON_FAILURE)
}

noHover = WebUI.getCSSValue(findTestObject('Homepage/QuickLinks/FAD link - image'), 'opacity', FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Homepage/QuickLinks/FAD link - image'), FailureHandling.OPTIONAL)

WebUI.delay(1)

yesHover = WebUI.getCSSValue(findTestObject('Homepage/QuickLinks/FAD link - image'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'this is a workaround the firefox driver not being able to mouseOver'
if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyNotMatch(noHover, yesHover, false, FailureHandling.STOP_ON_FAILURE)
}

noHover = WebUI.getCSSValue(findTestObject('Homepage/QuickLinks/Offers link - image'), 'opacity', FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Homepage/QuickLinks/Offers link - image'), FailureHandling.OPTIONAL)

WebUI.delay(1)

yesHover = WebUI.getCSSValue(findTestObject('Homepage/QuickLinks/Offers link - image'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'this is a workaround the firefox driver not being able to mouseOver'
if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyNotMatch(noHover, yesHover, false, FailureHandling.STOP_ON_FAILURE)
}

noHover = WebUI.getCSSValue(findTestObject('Homepage/QuickLinks/BYL link - image'), 'opacity', FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Homepage/QuickLinks/BYL link - image'), FailureHandling.OPTIONAL)

WebUI.delay(1)

yesHover = WebUI.getCSSValue(findTestObject('Homepage/QuickLinks/BYL link - image'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'this is a workaround the firefox driver not being able to mouseOver'
if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyNotMatch(noHover, yesHover, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

