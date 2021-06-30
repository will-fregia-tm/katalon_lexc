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

'checks whether this is a hybrid'
hybridValue = findTestData('modelData').getValue(2, seriesKey + 90)

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

WebUI.verifyElementVisible(findTestObject('ModelPages/Hero/asset - image'))

'these steps validate that the actual value contains an expected value'
actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/asset - image'), 'src', FailureHandling.STOP_ON_FAILURE)

expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 30)

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'tests this if video asset is present'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/asset - video - mp4'), 3, FailureHandling.OPTIONAL)) {
    'these steps validate that the actual value contains an expected value'
    actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/asset - video - mp4'), 'src', FailureHandling.STOP_ON_FAILURE)

    expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 60)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
}

'runs this test if hybrid'
if (WebUI.verifyMatch(hybridValue, 'hybrid', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementVisible(findTestObject('ModelPages/Hero/hybrid tag'))

    hybrid = WebUI.getText(findTestObject('ModelPages/Hero/hybrid tag'))

    WebUI.verifyMatch(hybrid, 'HYBRID', false)
}

'runs this test if convertible'
if (WebUI.verifyMatch(hybridValue, 'convertible', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementVisible(findTestObject('ModelPages/Hero/hybrid tag'))

    convertible = WebUI.getText(findTestObject('ModelPages/Hero/hybrid tag'))

    WebUI.verifyMatch(convertible, 'CONVERTIBLE', false)
}

WebUI.verifyElementVisible(findTestObject('ModelPages/Hero/model name'))

modelName = WebUI.getText(findTestObject('ModelPages/Hero/model name'))

'edits model names (e.g. ESh) to match series names (e.g. ES)'
modelSeries2 = ((modelSeries - ' C') - 'h')

'verifies correct model name text'
WebUI.verifyMatch(modelName, modelSeries2, false)

WebUI.verifyElementVisible(findTestObject('ModelPages/Hero/model year'))

actualValue = WebUI.getText(findTestObject('ModelPages/Hero/model year'))

expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 120)

valueWithoutExpected = (actualValue - expectedValue)

'verifies that correct model year appears'
WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('ModelPages/Hero/starting at MSRP'))

actualValue = WebUI.getText(findTestObject('ModelPages/Hero/starting at MSRP'))

expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 150)

valueWithoutExpected = (actualValue - expectedValue)

'verifies that correct price appears'
WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'runs this test if As Shown pricing is present'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/as shown MSRP'), 3, FailureHandling.OPTIONAL)) {
    actualValue = WebUI.getText(findTestObject('ModelPages/Hero/as shown MSRP'))

    expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 180)

    valueWithoutExpected = (actualValue - expectedValue)

    'verifies that correct price appears'
    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
}

actualValue = WebUI.getText(findTestObject('ModelPages/Hero/image disclaimer'))

expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 210)

'only checks further if disclaimer text is actually expected'
if (WebUI.verifyNotMatch(expectedValue, '', false, FailureHandling.OPTIONAL)) {
    valueWithoutExpected = (actualValue - expectedValue)

    'verifies that correct value appears'
    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.OPTIONAL)
}

actualValue = WebUI.getText(findTestObject('ModelPages/Hero/video disclaimer'), FailureHandling.OPTIONAL)

expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 240)

'only checks further if disclaimer text is actually expected'
if (WebUI.verifyNotMatch(expectedValue, '', false, FailureHandling.OPTIONAL)) {
    valueWithoutExpected = (actualValue - expectedValue)

    'verifies that correct value appears'
    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.OPTIONAL)
}

'tests if CTA is present'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA1'), 3, FailureHandling.OPTIONAL)) {
    WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA1'), FailureHandling.OPTIONAL)

    actualValue = WebUI.getText(findTestObject('ModelPages/Hero/CTA1'), FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA1'), 'href')

    'tests if CTA is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA2'), 3, FailureHandling.OPTIONAL)) {
        WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA2'), FailureHandling.OPTIONAL)

        actualValue = WebUI.getText(findTestObject('ModelPages/Hero/CTA2'), FailureHandling.STOP_ON_FAILURE)

        actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA2'), 'href')

        'tests if CTA is present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA3'), 3, FailureHandling.OPTIONAL)) {
            WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA3'), FailureHandling.OPTIONAL)

            actualValue = WebUI.getText(findTestObject('ModelPages/Hero/CTA3'), FailureHandling.STOP_ON_FAILURE)

            actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA3'), 'href')

            WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/CTA4'), 0)
        }
    }
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

