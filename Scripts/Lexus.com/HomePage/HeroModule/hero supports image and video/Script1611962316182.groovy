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

WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/image'), 0)

imageWidth = WebUI.getCSSValue(findTestObject('Homepage/HeroModule/image'), 'width', FailureHandling.STOP_ON_FAILURE)

'removes unit of measurement from variable'
imageWidth = (imageWidth - 'px')

pageWidth = WebUI.getPageWidth(FailureHandling.STOP_ON_FAILURE)

'converts number to string'
pageWidth = pageWidth.toString()

'verifies that image is full width'
WebUI.verifyMatch(imageWidth, pageWidth, false, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getAttribute(findTestObject('Homepage/HeroModule/image'), 'alt', FailureHandling.STOP_ON_FAILURE)

'this allows for null values in lower environments that do not have content updates'
actualValue = (actualValue + ' ')

'chooses column with data for test environment'
column = GlobalVariable.dataColumn

'gets homepage hero model value from MSRP test data'
expectedValue = findTestData('MSRP').getValue(column, 100)

'subtracts datasheet expected value from actual value displayed on page'
modifiedString = (actualValue - expectedValue)

'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'runs test if video is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/video'), 3, FailureHandling.OPTIONAL)) {
    videoWidth = WebUI.getCSSValue(findTestObject('Homepage/HeroModule/video'), 'width', FailureHandling.STOP_ON_FAILURE)

    'removes unit of measurement from variable'
    videoWidth = (videoWidth - 'px')

    'verifies that video is full width'
    WebUI.verifyMatch(videoWidth, pageWidth, false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getAttribute(findTestObject('Homepage/HeroModule/video'), 'alt', FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from MSRP test data'
    expectedValue = findTestData('MSRP').getValue(column, 100)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

