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

'runs test if asterisk disclaimer is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/asterisk disclaimer 1'), 3, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementNotPresent(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/HeroModule/asterisk disclaimer 1'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'))

    'runs test if another asterisk disclaimer is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/asterisk disclaimer 2'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/GlobalMisc/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)

        WebUI.verifyElementNotPresent(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/HeroModule/asterisk disclaimer 2'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'))

        'runs test if another asterisk disclaimer is present'
        if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/asterisk disclaimer 3'), 3, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('Homepage/GlobalMisc/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(2)

            WebUI.verifyElementNotPresent(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('Homepage/HeroModule/asterisk disclaimer 3'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(2)

            WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

            WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'))
        }
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

