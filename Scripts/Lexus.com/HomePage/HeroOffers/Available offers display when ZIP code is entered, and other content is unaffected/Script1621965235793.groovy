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

WebUI.delay(4)

WebUI.waitForElementPresent(findTestObject('Homepage/HeroModule/hero module'), 10, FailureHandling.OPTIONAL)

'if the page renders slowly, it will be refreshed so the test can continue'
if (WebUI.verifyElementNotPresent(findTestObject('Homepage/HeroModule/hero module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()

    WebUI.delay(4)

    WebUI.waitForElementPresent(findTestObject('Homepage/HeroModule/hero module'), 10, FailureHandling.OPTIONAL)
}

WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/HeroModule/hero module'), 0, FailureHandling.STOP_ON_FAILURE)

'runs these tests on sales event version of page'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/zip code field'), 5, FailureHandling.OPTIONAL)) {
    heroBefore = WebUI.getText(findTestObject('Homepage/HeroModule/hero module'))

    QLBefore = WebUI.getText(findTestObject('Homepage/QuickLinks/Quick Links'))

    WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/HeroOffers/zip code field'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToPosition(0, 350)

    WebUI.click(findTestObject('Homepage/HeroOffers/zip code field'))

    WebUI.setText(findTestObject('Homepage/HeroOffers/zip code field'), '75218')

    WebUI.click(findTestObject('Homepage/HeroOffers/submit button'))

    WebUI.waitForElementPresent(findTestObject('Homepage/HeroOffers/offer cards row'), 10, FailureHandling.OPTIONAL)

    WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/HeroModule/hero module'), 0, FailureHandling.STOP_ON_FAILURE)

    heroAfter = WebUI.getText(findTestObject('Homepage/HeroModule/hero module'))

    QLAfter = WebUI.getText(findTestObject('Homepage/QuickLinks/Quick Links'))

    'available offers display when ZIP code is entered'
    WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/offer cards row'), 0, FailureHandling.STOP_ON_FAILURE)

    'other content is unaffected'
    WebUI.verifyMatch(heroBefore, heroAfter, false, FailureHandling.STOP_ON_FAILURE)

    'other content is unaffected'
    WebUI.verifyMatch(QLBefore, QLAfter, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

