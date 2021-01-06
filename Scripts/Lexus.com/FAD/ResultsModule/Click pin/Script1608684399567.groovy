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
    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Privacy)
}

WebUI.navigateToUrl(GlobalVariable.AEM_Domain + '/dealers')

WebUI.waitForElementPresent(findTestObject('FAD/ZipGate/search icon'), 0)

WebUI.setText(findTestObject('FAD/ZipGate/zip entry dialog box'), '90210', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ResultsModule/dealer details link'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('FAD/ResultsModule/dealer pin 01'), FailureHandling.OPTIONAL)

unclickedColor = WebUI.getAttribute(findTestObject('FAD/ResultsModule/dealer pin svg'), 'color', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(unclickedColor, '#000000', false, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('FAD/ResultsModule/dealer details tooltip'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer pin 01'), FailureHandling.STOP_ON_FAILURE)

clickedColor = WebUI.getAttribute(findTestObject('FAD/ResultsModule/dealer pin svg'), 'color', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(clickedColor, '#a48b5b', false, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/ResultsModule/dealer details tooltip'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/ResultsModule/dealer details tooltip name'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.getText(findTestObject('FAD/ResultsModule/dealer details tooltip name'), FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('FAD/ResultsModule/dealer details tooltip address'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.getText(findTestObject('FAD/ResultsModule/dealer details tooltip address'), FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('FAD/ResultsModule/dealer details tooltip phone number'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/ResultsModule/dealer details tooltip close button'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer details tooltip close button'), FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('FAD/ResultsModule/dealer pin 02'), FailureHandling.OPTIONAL)

WebUI.verifyElementNotPresent(findTestObject('FAD/ResultsModule/dealer details tooltip'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer pin 02'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer pin 01'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ResultsModule/dealer details tooltip'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/ResultsModule/dealer details tooltip'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('FAD/ResultsModule/dealer details tooltip name'), FailureHandling.OPTIONAL)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer details tooltip name'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

