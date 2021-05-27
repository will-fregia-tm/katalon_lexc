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

'checks whether this is a hybrid'
hybridTrim = findTestData('modelData').getValue(2, seriesKey + 90)

'checks whether this is a gas trim with a hybrid counterpart'
hybridSeries = findTestData('modelData').getValue(2, seriesKey + 91)

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

'this step is added to handle a slow or partial page load'
if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/hero module'), 5, FailureHandling.OPTIONAL)) {
    WebUI.refresh()

    WebUI.delay(3)
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 3, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('ModelPages/Subnav/offers link'), FailureHandling.OPTIONAL)

WebUI.delay(3)

WebUI.setText(findTestObject('ModelPages/Offers/zip entry field'), '75218')

WebUI.delay(1)

WebUI.click(findTestObject('ModelPages/Offers/search button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/offers row'), 0)

displayedZIP = WebUI.getText(findTestObject('ModelPages/Offers/current market-zip'), FailureHandling.STOP_ON_FAILURE)

'Entering zip for a region with offers displays current market/zip'
WebUI.verifyMatch(displayedZIP, '75218', false)

'Entering zip for a region with offers displays ability to change market/zip'
WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/change CTA'), 0)

'runs this test if hybrid'
if (WebUI.verifyMatch(hybridTrim, 'hybrid', false, FailureHandling.OPTIONAL)) {
    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 1'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 1'), FailureHandling.STOP_ON_FAILURE)

    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 2'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 2'), FailureHandling.STOP_ON_FAILURE)
}

'runs this test if convertible'
if (WebUI.verifyMatch(hybridTrim, 'convertible', false, FailureHandling.OPTIONAL)) {
    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 1'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 1'), FailureHandling.STOP_ON_FAILURE)

    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 2'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 2'), FailureHandling.STOP_ON_FAILURE)

    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 3'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 3'), FailureHandling.STOP_ON_FAILURE)
}

'runs this test if hybrid trim is in this model series'
if (WebUI.verifyMatch(hybridSeries, 'hybrid', false, FailureHandling.OPTIONAL)) {
    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 1'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 1'), FailureHandling.STOP_ON_FAILURE)

    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 2'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 2'), FailureHandling.STOP_ON_FAILURE)
}

'runs this test if convertible trim is in this model series'
if (WebUI.verifyMatch(hybridSeries, 'convertible', false, FailureHandling.OPTIONAL)) {
    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 1'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 1'), FailureHandling.STOP_ON_FAILURE)

    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 2'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 2'), FailureHandling.STOP_ON_FAILURE)

    'Entering zip for a region with offers displays ability to toggle between gas/hybrid offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/trim tab 3'), 0)

    WebUI.getText(findTestObject('ModelPages/Offers/trim tab 3'), FailureHandling.STOP_ON_FAILURE)
}

'Entering zip for a region with offers displays ability to select a model Style '
WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/styles dropdown button'), 0)

'Entering zip for a region with offers displays up to 3 Offer Cards'
WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/offer card 1'), 0)

WebUI.getText(findTestObject('ModelPages/Offers/offer card 1'))

'Entering zip for a region with offers displays up to 3 Offer Cards'
WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/offer card 2'), 0)

WebUI.getText(findTestObject('ModelPages/Offers/offer card 2'))

'Entering zip for a region with offers displays up to 3 Offer Cards'
WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/offer card 3'), 0, FailureHandling.OPTIONAL)

WebUI.getText(findTestObject('ModelPages/Offers/offer card 3'), FailureHandling.OPTIONAL)

'continues testing if there are at least 4 Offer Cards'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/offer card 4'), 3, FailureHandling.OPTIONAL)) {
    'Entering zip for a region with offers displays offer card carousel for 4+ offers'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/next arrow'), 0)
}

'Entering zip for a region with offers displays View Inventory CTA\r\n'
WebUI.verifyElementPresent(findTestObject('ModelPages/Offers/view inventory CTA'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

