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

WebUI.setText(findTestObject('FAD/ZipGate/zip entry dialog box'), '98036', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ZipGate/search icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/ResultsModule/dealer details link'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/ResultsModule/dealer details link'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FAD/DealerDetails/contact heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('FAD/DealerDetails/key contacts heading'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/contact name'), 0, FailureHandling.STOP_ON_FAILURE)

contactName = WebUI.getText(findTestObject('FAD/DealerDetails/contact name'), FailureHandling.STOP_ON_FAILURE)

modifiedString = (contactName - ' ')

'verifies there\'s a space in the contact name'
WebUI.verifyNotMatch(modifiedString, contactName, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/contact title'), 0, FailureHandling.STOP_ON_FAILURE)

contactTitle = WebUI.getText(findTestObject('FAD/DealerDetails/contact title'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/contact email'), 0, FailureHandling.STOP_ON_FAILURE)

contactEmail = WebUI.getText(findTestObject('FAD/DealerDetails/contact email'), FailureHandling.STOP_ON_FAILURE)

modifiedString = (contactEmail - '@')

'verifies there\'s a @ in the contact email'
WebUI.verifyNotMatch(modifiedString, contactEmail, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/contact phone'), 0, FailureHandling.STOP_ON_FAILURE)

contactPhone = WebUI.getText(findTestObject('FAD/DealerDetails/contact phone'), FailureHandling.STOP_ON_FAILURE)

modifiedString = (contactPhone - ')')

'verifies there\'s a parenth in the contact phone number'
WebUI.verifyNotMatch(modifiedString, contactPhone, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FAD/DealerDetails/contact image'), 0, FailureHandling.STOP_ON_FAILURE)

imagePath = WebUI.getAttribute(findTestObject('FAD/DealerDetails/contact image'), 'src', FailureHandling.STOP_ON_FAILURE)

modifiedString = (imagePath - '.jpg')

'verifies there\'s a file for the contact image'
WebUI.verifyNotMatch(modifiedString, imagePath, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FAD/DealerDetails/contact phone'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('FAD/DealerDetails/contact email'), FailureHandling.OPTIONAL)

WebUI.delay(3)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

