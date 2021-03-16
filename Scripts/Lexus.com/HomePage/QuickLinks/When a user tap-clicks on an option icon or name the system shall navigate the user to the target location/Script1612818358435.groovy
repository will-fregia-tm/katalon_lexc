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

WebUI.click(findTestObject('Homepage/QuickLinks/BYL link'))

WebUI.waitForPageLoad(0)

WebUI.delay(3)

windowTitle = WebUI.getWindowTitle()

'these steps are added to handle environments in which BYL is not present'
if (WebUI.verifyNotMatch(windowTitle, 'Build Your Own Lexus | Lexus Configurator', false, FailureHandling.OPTIONAL)) {
    WebUI.back()

    href = WebUI.getAttribute(findTestObject('Homepage/QuickLinks/BYL link'), 'href')

    href = (href - 'https://dev-aem-lcom.origin.cepo-proxy.tms.aws.lexus.com')

    href = (href - 'https://stage-aem.author.toyota.com')

    WebUI.navigateToUrl('https://www.lexus.com' + href)

    WebUI.waitForPageLoad(0)

    windowTitle = WebUI.getWindowTitle()

    WebUI.verifyMatch(windowTitle, 'Build Your Own Lexus | Lexus Configurator', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.back()

WebUI.waitForElementPresent(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Homepage/QuickLinks/FAD link'))

WebUI.waitForPageLoad(0)

WebUI.delay(3)

windowTitle = WebUI.getWindowTitle()

'these steps are added to handle environments in which FAD is not present'
if (WebUI.verifyNotMatch(windowTitle, 'Lexus - Find a Dealer', false, FailureHandling.OPTIONAL)) {
    WebUI.back()

    href = WebUI.getAttribute(findTestObject('Homepage/QuickLinks/FAD link'), 'href')

    href = (href - 'https://dev-aem-lcom.origin.cepo-proxy.tms.aws.lexus.com')

    href = (href - 'https://stage-aem.author.toyota.com')

    WebUI.navigateToUrl('https://www.lexus.com' + href)

    WebUI.waitForPageLoad(0)

    windowTitle = WebUI.getWindowTitle()

    'this is covers slightly different window titles'
    if (WebUI.verifyNotMatch(windowTitle, 'Lexus - Find a Dealer', false, FailureHandling.OPTIONAL)) {
        'this is covers slightly different window titles'
        if (WebUI.verifyNotMatch(windowTitle, 'Find a Dealer', false, FailureHandling.OPTIONAL)) {
            WebUI.verifyMatch(windowTitle, 'Find A Dealer', false, FailureHandling.STOP_ON_FAILURE)
        }
    }
}

WebUI.back()

WebUI.waitForElementPresent(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Homepage/QuickLinks/Offers link'))

WebUI.waitForPageLoad(0)

WebUI.delay(3)

windowTitle = WebUI.getWindowTitle()

'these steps are added to handle environments in which Offers page is not present'
if (WebUI.verifyNotMatch(windowTitle, 'Lexus Offers | Experience Amazing', false, FailureHandling.OPTIONAL)) {
    WebUI.back()

    href = WebUI.getAttribute(findTestObject('Homepage/QuickLinks/Offers link'), 'href')

    href = (href - 'https://dev-aem-lcom.origin.cepo-proxy.tms.aws.lexus.com')

    href = (href - 'https://stage-aem.author.toyota.com')

    WebUI.navigateToUrl('https://www.lexus.com' + href)

    WebUI.waitForPageLoad(0)

    windowTitle = WebUI.getWindowTitle()

    'this is covers slightly different window titles'
    if (WebUI.verifyNotMatch(windowTitle, 'Lexus Offers | Experience Amazing', false, FailureHandling.OPTIONAL)) {
        WebUI.verifyMatch(windowTitle, 'Offers', false, FailureHandling.STOP_ON_FAILURE)
    }
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

