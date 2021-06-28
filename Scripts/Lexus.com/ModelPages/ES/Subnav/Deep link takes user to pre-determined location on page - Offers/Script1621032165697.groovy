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
    GlobalVariable.deeplinkOffers)

'these steps are added to handle author environment URLs'
if (WebUI.verifyMatch(GlobalVariable.author, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        GlobalVariable.authorQuery) + GlobalVariable.deeplinkOffers)
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Offers/offers module'), 10, FailureHandling.OPTIONAL)

WebUI.delay(4)

'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Offers/offers module'), 5, FailureHandling.STOP_ON_FAILURE)

'these steps will run in environments that require valid content'
if (WebUI.verifyMatch(GlobalVariable.contentValidation, 'yes', false, FailureHandling.OPTIONAL)) {
    'Visiting via deeplink scrolls to predetermined location, with necessary elements preselected/shown/active.'
    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Offers/offers module'), 5, FailureHandling.STOP_ON_FAILURE)
}

WebUI.navigateToUrl('https://www.lexus.com/')

WebUI.waitForPageLoad(0)

WebUI.navigateToUrl(((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
    '?zip=75218') + GlobalVariable.deeplinkOffers)

'these steps are added to handle author environment URLs'
if (WebUI.verifyMatch(GlobalVariable.author, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl((((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        GlobalVariable.authorQuery) + '&zip=75218') + GlobalVariable.deeplinkOffers)
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Offers/offers module'), 10, FailureHandling.OPTIONAL)

WebUI.delay(4)

WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Offers/offers module'), 5, FailureHandling.STOP_ON_FAILURE)

displayedZIP = WebUI.getText(findTestObject('ModelPages/Offers/current market-zip'), FailureHandling.STOP_ON_FAILURE)

'ZIP parameter in deeplink should lead to preset ZIP code in offers module'
WebUI.verifyMatch(displayedZIP, '75218', false)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

