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

'Takes you to SSO login page.'
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

WebUI.navigateToUrl(GlobalVariable.AEM_Domain + '/accessibility')

'this step is added to handle a slow or partial page load'
if (WebUI.verifyElementNotPresent(findTestObject('Accessibility/Hero Image'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('Accessibility/Hero Image'), 4, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Accessibility/Copy Block'), 3)

WebUI.verifyElementPresent(findTestObject('Accessibility/Copy Paragraph'), 3)

paragraph = WebUI.getText(findTestObject('Accessibility/Copy Paragraph'), FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('Accessibility/Copy Paragraph'), FailureHandling.STOP_ON_FAILURE)

modifiedString = ((actualValue - 'Lexus') - 'accessibility')

'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(paragraph, 'Lexus is committed to accessibility, diversity and inclusion for all of its guests. We believe everyone should be able to visit Lexus.com, use our mobile apps, and access our services easily. We welcome feedback. If you notice any content, feature or functionality of the Site that you believe is not fully accessible to people with disabilities, please contact us and provide a description of the specific feature you feel is not fully accessible or a suggestion for improvement. We take your input seriously and will consider all feedback received as we evaluate ways to accommodate our customers and continuously improve our overall accessibility policies.', 
    false, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

