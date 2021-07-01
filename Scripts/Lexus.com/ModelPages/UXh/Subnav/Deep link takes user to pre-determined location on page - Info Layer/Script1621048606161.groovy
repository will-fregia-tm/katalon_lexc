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

WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
    GlobalVariable.deeplinkInfoLayerFeatures)

'these steps are added to handle author environment URLs'
if (WebUI.verifyMatch(GlobalVariable.author, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        GlobalVariable.deeplinkInfoLayerFeatures2)
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 10, FailureHandling.OPTIONAL)

WebUI.delay(4)

'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/hero module'), 5, FailureHandling.STOP_ON_FAILURE)

'these steps will run in environments that require valid content'
if (WebUI.verifyMatch(GlobalVariable.contentValidation, 'yes', false, FailureHandling.OPTIONAL)) {
    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/selected tab'), FailureHandling.STOP_ON_FAILURE)

    'Deeplink opens correct Info Layer tab'
    WebUI.verifyMatch(actualValue, 'FEATURES', false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/expanded accordion button'), FailureHandling.STOP_ON_FAILURE)

    expectedValue = 'DESIGN'

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Overlay/close overlay button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Hero/hero module'), 5, FailureHandling.STOP_ON_FAILURE)
}

WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
    GlobalVariable.deeplinkInfoLayerSpecs)

'these steps are added to handle author environment URLs'
if (WebUI.verifyMatch(GlobalVariable.author, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        GlobalVariable.deeplinkInfoLayerSpecs2)
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 10, FailureHandling.OPTIONAL)

WebUI.delay(4)

'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/hero module'), 5, FailureHandling.STOP_ON_FAILURE)

'these steps will run in environments that require valid content'
if (WebUI.verifyMatch(GlobalVariable.contentValidation, 'yes', false, FailureHandling.OPTIONAL)) {
    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/selected tab'), FailureHandling.STOP_ON_FAILURE)

    'Deeplink opens correct Info Layer tab'
    WebUI.verifyMatch(actualValue, 'SPECS', false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/expanded accordion button'), FailureHandling.STOP_ON_FAILURE)

    expectedValue = 'ENGINE'

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Overlay/close overlay button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Hero/hero module'), 5, FailureHandling.STOP_ON_FAILURE)
}

WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
    GlobalVariable.deeplinkInfoLayerPackages)

'these steps are added to handle author environment URLs'
if (WebUI.verifyMatch(GlobalVariable.author, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        GlobalVariable.deeplinkInfoLayerPackages2)
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 10, FailureHandling.OPTIONAL)

WebUI.delay(4)

'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/hero module'), 5, FailureHandling.STOP_ON_FAILURE)

'these steps will run in environments that require valid content'
if (WebUI.verifyMatch(GlobalVariable.contentValidation, 'yes', false, FailureHandling.OPTIONAL)) {
    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/selected tab'), FailureHandling.STOP_ON_FAILURE)

    'Deeplink opens correct Info Layer tab'
    WebUI.verifyMatch(actualValue, 'PACKAGES', false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/expanded accordion button'), FailureHandling.STOP_ON_FAILURE)

    expectedValue = 'PACKAGE'

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Overlay/close overlay button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Hero/hero module'), 5, FailureHandling.STOP_ON_FAILURE)
}

WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
    GlobalVariable.deeplinkInfoLayerOptions)

'these steps are added to handle author environment URLs'
if (WebUI.verifyMatch(GlobalVariable.author, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        GlobalVariable.deeplinkInfoLayerOptions2)
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 10, FailureHandling.OPTIONAL)

WebUI.delay(4)

'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/hero module'), 5, FailureHandling.STOP_ON_FAILURE)

'these steps will run in environments that require valid content'
if (WebUI.verifyMatch(GlobalVariable.contentValidation, 'yes', false, FailureHandling.OPTIONAL)) {
    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/selected tab'), FailureHandling.STOP_ON_FAILURE)

    'Deeplink opens correct Info Layer tab'
    WebUI.verifyMatch(actualValue, 'OPTIONS', false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Overlay/close overlay button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Hero/hero module'), 5, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

