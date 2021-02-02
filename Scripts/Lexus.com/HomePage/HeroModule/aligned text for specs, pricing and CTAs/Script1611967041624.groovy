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

WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/hero module'), 0)

'runs test if starting at MSRP spec is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/spec - starting at msrp'), 3, FailureHandling.OPTIONAL)) {
    priceAlignment = WebUI.getCSSValue(findTestObject('Homepage/HeroModule/spec - starting at msrp'), 'text-align', FailureHandling.STOP_ON_FAILURE)

    'accounts for left alignment setting'
    modifiedString = (priceAlignment - 'left')

    'accounts for center alignment setting'
    modifiedString = (priceAlignment - 'center')

    'only center or left alignment values should pass - otherwise text will match and test will fail'
    WebUI.verifyNotMatch(modifiedString, priceAlignment, false, FailureHandling.STOP_ON_FAILURE)

    startingAtTextAlignment = WebUI.getCSSValue(findTestObject('Homepage/HeroModule/Starting At'), 'text-align', FailureHandling.STOP_ON_FAILURE)

    'verifies that price text alignment matches Starting At text alignment'
    WebUI.verifyMatch(priceAlignment, startingAtTextAlignment, false, FailureHandling.STOP_ON_FAILURE)

    'runs test if Vehicle Shown text is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/Vehicle Shown'), 3, FailureHandling.OPTIONAL)) {
        vehicleShownTextAlignment = WebUI.getText(findTestObject('Homepage/HeroModule/Vehicle Shown'), FailureHandling.STOP_ON_FAILURE)

        vehicleShownTextAlignment = WebUI.getCSSValue(findTestObject('Homepage/HeroModule/Vehicle Shown'), 'text-align', 
            FailureHandling.STOP_ON_FAILURE)

        'verifies that price text alignment matches Vehicle Shown text alignment'
        WebUI.verifyMatch(priceAlignment, vehicleShownTextAlignment, false, FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/slide 1 - first CTA'), 0, FailureHandling.STOP_ON_FAILURE)

CTAtext = WebUI.getCSSValue(findTestObject('Homepage/HeroModule/slide 1 - first CTA'), 'justify-content', FailureHandling.STOP_ON_FAILURE)

'accounts for center alignment setting'
modifiedString = (CTAtext - 'center')

'only center alignment values should pass - otherwise text will match and test will fail'
WebUI.verifyNotMatch(modifiedString, CTAtext, false, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

