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

opacity = WebUI.getCSSValue(findTestObject('FAD/ZipGate/error message'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'verifies that error message is not visible'
WebUI.verifyMatch(opacity, '0', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

opacity = WebUI.getCSSValue(findTestObject('FAD/ZipGate/error message'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'verifies that error message is visible'
border = WebUI.verifyMatch(opacity, '1', false, FailureHandling.STOP_ON_FAILURE)

border = WebUI.getCSSValue(findTestObject('FAD/ZipGate/form border'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(border, 'rgba(235, 0, 0, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(border, 'rgb(235, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ZipGate/search icon'), 0, FailureHandling.STOP_ON_FAILURE)

opacity = WebUI.getCSSValue(findTestObject('FAD/ZipGate/error message'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'verifies that error message is not visible'
WebUI.verifyMatch(opacity, '0', false, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('FAD/ZipGate/zip entry dialog box'), '1234', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

opacity = WebUI.getCSSValue(findTestObject('FAD/ZipGate/error message'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'verifies that error message is visible'
WebUI.verifyMatch(opacity, '1', false, FailureHandling.STOP_ON_FAILURE)

border = WebUI.getCSSValue(findTestObject('FAD/ZipGate/form border'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(border, 'rgba(235, 0, 0, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(border, 'rgb(235, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ZipGate/search icon'), 0, FailureHandling.STOP_ON_FAILURE)

opacity = WebUI.getCSSValue(findTestObject('FAD/ZipGate/error message'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'verifies that error message is not visible'
WebUI.verifyMatch(opacity, '0', false, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('FAD/ZipGate/zip entry dialog box'), 'asdfg', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

opacity = WebUI.getCSSValue(findTestObject('FAD/ZipGate/error message'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'verifies that error message is visible'
WebUI.verifyMatch(opacity, '1', false, FailureHandling.STOP_ON_FAILURE)

border = WebUI.getCSSValue(findTestObject('FAD/ZipGate/form border'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(border, 'rgba(235, 0, 0, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(border, 'rgb(235, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ZipGate/search icon'), 0, FailureHandling.STOP_ON_FAILURE)

opacity = WebUI.getCSSValue(findTestObject('FAD/ZipGate/error message'), 'opacity', FailureHandling.STOP_ON_FAILURE)

'verifies that error message is not visible'
WebUI.verifyMatch(opacity, '0', false, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('FAD/ZipGate/zip entry dialog box'), '123456', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

