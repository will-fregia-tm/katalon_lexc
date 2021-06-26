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

WebUI.click(findTestObject('ModelPages/Subnav/styles link'), FailureHandling.OPTIONAL)

WebUI.delay(3)

WebUI.click(findTestObject('ModelPages/Styles/trim 2 link'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

selectedModelName = WebUI.getText(findTestObject('ModelPages/Styles/selected model-style'))

WebUI.mouseOver(findTestObject('ModelPages/Styles/Compare Styles CTA'), FailureHandling.OPTIONAL)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Styles/Compare Styles CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/selected tab'), FailureHandling.STOP_ON_FAILURE)

'Clicking on "Compare Styles" CTA opens IL features tab'
WebUI.verifyMatch(actualValue, 'FEATURES', false, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/expanded accordion button'), FailureHandling.STOP_ON_FAILURE)

expectedValue = 'DESIGN'

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

unselectedStyle = WebUI.getCSSValue(findTestObject('ModelPages/InformationLayer/column 1'), 'background-color')

unselectedStyle = WebUI.getCSSValue(findTestObject('ModelPages/InformationLayer/column 1'), 'background-color')

selectedStyle = WebUI.getCSSValue(findTestObject('ModelPages/InformationLayer/column 2'), 'background-color')

'Clicking on "Compare Styles" CTA opens IL features tab with selected model-style visibly highlighted.'
WebUI.verifyNotMatch(selectedStyle, unselectedStyle, false)

highlightedModelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 2 model name'))

WebUI.verifyMatch(selectedModelName, highlightedModelName, false, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('ModelPages/Overlay/close overlay button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Styles/trim 1 link'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

selectedModelName = WebUI.getText(findTestObject('ModelPages/Styles/selected model-style'))

WebUI.click(findTestObject('ModelPages/Styles/Specs CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/selected tab'), FailureHandling.STOP_ON_FAILURE)

'Clicking on "Specs" CTA opens IL specs tab'
WebUI.verifyMatch(actualValue, 'SPECS', false, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/expanded accordion button'), FailureHandling.STOP_ON_FAILURE)

expectedValue = 'ENGINE'

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

unselectedStyle = WebUI.getCSSValue(findTestObject('ModelPages/InformationLayer/column 2'), 'background-color')

selectedStyle = WebUI.getCSSValue(findTestObject('ModelPages/InformationLayer/column 1'), 'background-color')

'Clicking on "Specs" CTA opens IL specs tab with selected model-style visibly highlighted.'
WebUI.verifyNotMatch(selectedStyle, unselectedStyle, false)

highlightedModelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 1 model name'))

WebUI.verifyMatch(selectedModelName, highlightedModelName, false, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('ModelPages/Overlay/close overlay button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Styles/trim 2 link'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

selectedModelName = WebUI.getText(findTestObject('ModelPages/Styles/selected model-style'))

WebUI.click(findTestObject('ModelPages/Styles/Packages CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/selected tab'), FailureHandling.STOP_ON_FAILURE)

'Clicking on "Packages" CTA opens IL packages tab '
WebUI.verifyMatch(actualValue, 'PACKAGES', false, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/expanded accordion button'), FailureHandling.STOP_ON_FAILURE)

expectedValue = 'PACKAGE'

valueWithoutExpected = (actualValue - expectedValue)

'Clicking on "Packages" CTA opens overlay with relevant packages displayed.'
WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

