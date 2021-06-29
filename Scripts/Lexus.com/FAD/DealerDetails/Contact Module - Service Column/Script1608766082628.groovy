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

cookieValue = findTestData('cookieValues').getValue(2, 1)

Cookie ck = new Cookie('ESTSAUTH', cookieValue)

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

domain = GlobalVariable.domain

'this step is added to handle legacy staging authentication'
if (WebUI.verifyMatch(domain, 'staging', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

WebUI.navigateToUrl(GlobalVariable.AEM_Domain + '/dealers')

WebUI.waitForElementPresent(findTestObject('FAD/ZipGate/search icon'), 0)

WebUI.setText(findTestObject('FAD/ZipGate/zip entry dialog box'), '08234', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ResultsModule/dealer details link'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer details link'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/DealerDetails/contact heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/service title'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/service hours'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.getText(findTestObject('FAD/DealerDetails/service hours'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/schedule service link'), 0, FailureHandling.STOP_ON_FAILURE)

schedule = WebUI.getAttribute(findTestObject('FAD/DealerDetails/schedule service link'), 'href', FailureHandling.STOP_ON_FAILURE)

modifiedString = (schedule - '.com')

'verifies that a link to dealer\'s website is included in the schedule service URL'
WebUI.verifyNotMatch(modifiedString, schedule, false, FailureHandling.STOP_ON_FAILURE)

'runs these tests if the carousel is not present'
if (WebUI.verifyElementNotPresent(findTestObject('FAD/DealerDetails/carousel - contact module'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('FAD/DealerDetails/schedule service link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForPageLoad(0)

    WebUI.switchToWindowIndex(1, FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    windowTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

    modifiedString = (windowTitle - 'Schedule')

    'verifies that schedule service URL leads to a dealer service page'
    WebUI.verifyNotMatch(modifiedString, windowTitle, false, FailureHandling.STOP_ON_FAILURE)
}

'runs these tests if the carousel is present'
if (WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/carousel - contact module'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('FAD/DealerDetails/schedule service link - visible in carousel'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForPageLoad(0)

    WebUI.switchToWindowIndex(1, FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    windowTitle = WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)

    modifiedString = (windowTitle - 'Schedule')

    'verifies that schedule service URL leads to a dealer service page'
    WebUI.verifyNotMatch(modifiedString, windowTitle, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

