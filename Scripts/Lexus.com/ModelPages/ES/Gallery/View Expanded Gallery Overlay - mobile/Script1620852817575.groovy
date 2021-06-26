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

WebUI.navigateToUrl(GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey))

'these steps are added to handle author environment URLs'
if (WebUI.verifyMatch(GlobalVariable.author, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        GlobalVariable.authorQuery)
}

'this step is added to handle a slow or partial page load'
if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 3, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('ModelPages/Subnav/mobile nav button'), FailureHandling.OPTIONAL)

WebUI.delay(2)

WebUI.click(findTestObject('ModelPages/Subnav/gallery link'), FailureHandling.OPTIONAL)

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/image 1'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/image 1 expanded'), 0)

WebUI.click(findTestObject('ModelPages/Gallery/image 1 link'))

WebUI.delay(2)

'display full size gallery overlay with "Image-A" in focus'
WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/image 1 expanded'), 0)

'provide the ability to close out of the overlay'
WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/exit button'), 0)

firstImage = WebUI.getAttribute(findTestObject('ModelPages/Gallery/active image'), 'src')

'provide carousel arrows in both directions to navigate to the next image'
WebUI.click(findTestObject('ModelPages/Gallery/carousel tab - right'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

secondImage = WebUI.getAttribute(findTestObject('ModelPages/Gallery/active image'), 'src')

'validates that image changes when navigating carousel\r\n'
WebUI.verifyNotMatch(firstImage, secondImage, false)

'provide carousel arrows in both directions to navigate to the previous image'
WebUI.click(findTestObject('ModelPages/Gallery/carousel tab - left'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

thirdImage = WebUI.getAttribute(findTestObject('ModelPages/Gallery/active image'), 'src')

'validates that image changes when navigating carousel\r\n'
WebUI.verifyMatch(firstImage, thirdImage, false)

for (def index : (0..14)) {
    'provide carousel arrows in both directions to navigate to the previous image'
    WebUI.click(findTestObject('ModelPages/Gallery/carousel tab - right'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)
}

'user is able to exit the expanded gallery and return to the default gallery.'
WebUI.click(findTestObject('ModelPages/Gallery/exit button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/image 1 expanded'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

