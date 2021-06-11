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
    '#model_visualizer')

WebUI.delay(6)

WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
    '#model_visualizer')

WebUI.delay(6)

'this step is added to handle a slow or partial page load'
if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/visualizer module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        '#model_visualizer')

    WebUI.delay(8)
}

'allows user to select exterior'
selectionState = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/exterior tab'), 'aria-selected', FailureHandling.STOP_ON_FAILURE)

'Visualizer defaults to exterior'
WebUI.verifyMatch(selectionState, 'true', false)

actualValue = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/swatch 01'), 'src', FailureHandling.STOP_ON_FAILURE)

expectedValue = 'xterior'

valueWithoutExpected = (actualValue - expectedValue)

'displays relevant swatches (i.e. exterior)'
WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/visualizer asset'), 'alt', FailureHandling.STOP_ON_FAILURE)

expectedValue = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/swatch 01'), 'alt', FailureHandling.STOP_ON_FAILURE)

valueWithoutExpected = (actualValue - expectedValue)

'preselected color swatch matches visualizer asset'
WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

actualValue = WebUI.getText(findTestObject('ModelPages/Visualizer/color name'))

valueWithoutExpected = (actualValue - expectedValue)

'color name is displayed for selected swatch'
WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'allows user to select interior'
WebUI.verifyElementPresent(findTestObject('ModelPages/Visualizer/interior tab'), 0)

'allows user to select wheels'
WebUI.verifyElementPresent(findTestObject('ModelPages/Visualizer/wheels tab'), 0)

WebUI.click(findTestObject('ModelPages/Visualizer/interior tab'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

trim1asset = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/visualizer asset'), 'src', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Visualizer/model-style 2'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

trim2asset = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/visualizer asset'), 'src', FailureHandling.STOP_ON_FAILURE)

'updates to correct default asset'
WebUI.verifyNotMatch(trim1asset, trim2asset, false)

selectionState = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/exterior tab'), 'aria-selected', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(selectionState, 'false', false)

selectionState = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/interior tab'), 'aria-selected', FailureHandling.STOP_ON_FAILURE)

'Selecting a non-base model-style remains in same exterior/interior/wheels tab'
WebUI.verifyMatch(selectionState, 'true', false)

selectionState = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/model-style 1'), 'aria-selected', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(selectionState, 'false', false)

selectionState = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/model-style 2'), 'aria-selected', FailureHandling.STOP_ON_FAILURE)

'indicates selected model-style'
WebUI.verifyMatch(selectionState, 'true', false)

actualValue = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/swatch 01'), 'src', FailureHandling.STOP_ON_FAILURE)

expectedValue = 'xterior'

valueWithoutExpected = (actualValue - expectedValue)

'displays relevant swatches (i.e. not exterior)'
WebUI.verifyMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Visualizer/wheels tab'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

trim2swatch = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/swatch 01'), 'src', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Visualizer/model-style 1'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

trim1swatch = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/swatch 01'), 'src', FailureHandling.STOP_ON_FAILURE)

'updates swatches to those available for selected model-style'
not_run: WebUI.verifyNotMatch(trim1swatch, trim2swatch, false)

WebUI.delay(1)

selectionState = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/interior tab'), 'aria-selected', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(selectionState, 'false', false)

selectionState = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/wheels tab'), 'aria-selected', FailureHandling.STOP_ON_FAILURE)

'Selecting a non-base model-style remains in same exterior/interior/wheels tab'
WebUI.verifyMatch(selectionState, 'true', false)

selectionState = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/model-style 2'), 'aria-selected', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(selectionState, 'false', false)

selectionState = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/model-style 1'), 'aria-selected', FailureHandling.STOP_ON_FAILURE)

'indicates selected model-style'
WebUI.verifyMatch(selectionState, 'true', false)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

