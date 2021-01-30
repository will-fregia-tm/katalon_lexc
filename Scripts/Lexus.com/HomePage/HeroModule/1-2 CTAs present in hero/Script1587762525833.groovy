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

'these steps will be run for the legacy version of the page'
if (WebUI.verifyMatch(GlobalVariable.legacy, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.SC_Domain)

    WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

    'if the page renders slowly, it will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.refresh()
    }
    
    WebUI.verifyElementPresent(findTestObject('HomePage/HeroModule/CTA1'), 0)

    WebUI.verifyElementNotPresent(findTestObject('HomePage/HeroModule/CTA3'), 0)
}

'these steps will be run for the non-legacy version of the page'
if (WebUI.verifyMatch(GlobalVariable.legacy, 'no', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

    'if the page renders slowly, it will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.refresh()
    }
    
    WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/first CTA'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.mouseOver(findTestObject('Homepage/HeroModule/first CTA'), FailureHandling.STOP_ON_FAILURE)

    WebUI.getText(findTestObject('Homepage/HeroModule/first CTA'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    'interacts with the second CTA if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/second CTA'), 3, FailureHandling.OPTIONAL)) {
        WebUI.mouseOver(findTestObject('Homepage/HeroModule/second CTA'), FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/HeroModule/second CTA'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.verifyElementNotPresent(findTestObject('Homepage/HeroModule/third CTA'), 0, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}
