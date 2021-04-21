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

WebUI.click(findTestObject('ModelPages/Visualizer/interior tab'))

WebUI.delay(2)

highlightBeforeUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/highlighted swatch'), 'src')

assetBeforeUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/visualizer asset'), 'src')

angleBeforeUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/current slide'), 'data-index')

nameBeforeUpdate = WebUI.getText(findTestObject('ModelPages/Visualizer/color name'))

'Selecting a different interior color'
WebUI.click(findTestObject('ModelPages/Visualizer/swatch 02'))

WebUI.delay(2)

highlightAfterUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/highlighted swatch'), 'src')

assetAfterUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/visualizer asset'), 'src')

angleAfterUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/current slide'), 'data-index')

nameAfterUpdate = WebUI.getText(findTestObject('ModelPages/Visualizer/color name'))

'updates the highlighting '
WebUI.verifyNotMatch(highlightBeforeUpdate, highlightAfterUpdate, false)

'updates the asset '
WebUI.verifyNotMatch(assetBeforeUpdate, assetAfterUpdate, false)

'keeps the same angle'
WebUI.verifyMatch(angleBeforeUpdate, angleAfterUpdate, false)

'updates the swatch name'
WebUI.verifyNotMatch(nameBeforeUpdate, nameAfterUpdate, false)

WebUI.click(findTestObject('ModelPages/Visualizer/swatch 03'))

WebUI.delay(2)

highlightBeforeUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/highlighted swatch'), 'src')

assetBeforeUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/visualizer asset'), 'src')

angleBeforeUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/current slide'), 'data-index')

nameBeforeUpdate = WebUI.getText(findTestObject('ModelPages/Visualizer/color name'))

'Selecting a different interior angle'
WebUI.click(findTestObject('ModelPages/Visualizer/angle button 2'))

WebUI.delay(2)

highlightAfterUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/highlighted swatch'), 'src')

assetAfterUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/visualizer asset'), 'src')

angleAfterUpdate = WebUI.getAttribute(findTestObject('ModelPages/Visualizer/current slide'), 'data-index')

nameAfterUpdate = WebUI.getText(findTestObject('ModelPages/Visualizer/color name'))

'keeps the highlighting '
WebUI.verifyMatch(highlightBeforeUpdate, highlightAfterUpdate, false)

'updates the asset '
WebUI.verifyNotMatch(assetBeforeUpdate, assetAfterUpdate, false)

'updates the angle'
WebUI.verifyNotMatch(angleBeforeUpdate, angleAfterUpdate, false)

'keeps the swatch name'
WebUI.verifyMatch(nameBeforeUpdate, nameAfterUpdate, false)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

