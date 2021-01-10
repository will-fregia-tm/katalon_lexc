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

'should be a dealership with multiple gallery images'
WebUI.setText(findTestObject('FAD/ZipGate/zip entry dialog box'), '98036', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ResultsModule/dealer details link'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer details link'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/DealerDetails/page title'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/gallery heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('FAD/DealerDetails/gallery heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/gallery pagination'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/open overlay'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/overlay next button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/overlay next button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/overlay previous button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/overlay previous button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/overlay previous button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/close overlay'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/previous slide'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/next slide'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/next slide'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/back to dealer results CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ZipGate/search icon'), 0, FailureHandling.STOP_ON_FAILURE)

'should be a dealership with one gallery image'
WebUI.setText(findTestObject('FAD/ZipGate/zip entry dialog box'), '34233', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ResultsModule/dealer details link'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer details link'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/DealerDetails/page title'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/gallery heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('FAD/DealerDetails/gallery heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('FAD/DealerDetails/gallery pagination'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/open overlay'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/close overlay'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/back to dealer results CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ZipGate/search icon'), 0, FailureHandling.STOP_ON_FAILURE)

'should be a dealership with no gallery images'
WebUI.setText(findTestObject('FAD/ZipGate/zip entry dialog box'), '08234', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ResultsModule/dealer details link'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer details link'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/DealerDetails/page title'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('FAD/DealerDetails/gallery heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('FAD/DealerDetails/services heading'), 0, FailureHandling.OPTIONAL)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

