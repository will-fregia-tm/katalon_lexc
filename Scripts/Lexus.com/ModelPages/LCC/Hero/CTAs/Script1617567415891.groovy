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

'checks whether sales event is active'
salesEvent = findTestData('modelData').getValue(GlobalVariable.dataColumn, 3)

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.OPTIONAL)

'these steps are added to handle lower environment authentication'
if (WebUI.verifyMatch(GlobalVariable.lowerEnvironment, 'yes', false, FailureHandling.OPTIONAL)) {
    cookieValue = findTestData('cookieValues').getValue(2, 1)

    Cookie ck = new Cookie('ESTSAUTH', cookieValue)

    WebDriver driver = DriverFactory.getWebDriver()

    driver.manage().addCookie(ck)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

String browser = DriverFactory.getWebDriver().getCapabilities().getBrowserName()

println(browser)

WebUI.navigateToUrl(GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey))

'this step is added to handle a slow or partial page load'
if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 3, FailureHandling.OPTIONAL)

'checks CTA hover states, with workaround for the firefox driver not being able to mouseOver'
if (WebUI.verifyNotMatch(browser, 'firefox', false, FailureHandling.OPTIONAL)) {
    'tests if CTA is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA1'), 3, FailureHandling.OPTIONAL)) {
        mouseOverNo = WebUI.getCSSValue(findTestObject('ModelPages/Hero/CTA1'), 'background-color')

        WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)

        mouseOverYes = WebUI.getCSSValue(findTestObject('ModelPages/Hero/CTA1'), 'background-color')

        'CTAs update on mouseover'
        WebUI.verifyNotMatch(mouseOverNo, mouseOverYes, false, FailureHandling.STOP_ON_FAILURE)

        'tests if CTA is present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA2'), 3, FailureHandling.OPTIONAL)) {
            mouseOverNo = WebUI.getCSSValue(findTestObject('ModelPages/Hero/CTA2'), 'background-color')

            WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA2'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(2)

            mouseOverYes = WebUI.getCSSValue(findTestObject('ModelPages/Hero/CTA2'), 'background-color')

            'CTAs update on mouseover'
            WebUI.verifyNotMatch(mouseOverNo, mouseOverYes, false, FailureHandling.STOP_ON_FAILURE)

            'tests if CTA is present'
            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA3'), 3, FailureHandling.OPTIONAL)) {
                mouseOverNo = WebUI.getCSSValue(findTestObject('ModelPages/Hero/CTA3'), 'background-color')

                WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA3'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(2)

                mouseOverYes = WebUI.getCSSValue(findTestObject('ModelPages/Hero/CTA3'), 'background-color')

                'CTAs update on mouseover'
                WebUI.verifyNotMatch(mouseOverNo, mouseOverYes, false, FailureHandling.STOP_ON_FAILURE)
            }
        }
    }
}

'runs this test if non-sales event content should be present'
if (WebUI.verifyMatch(salesEvent, 'n', false, FailureHandling.OPTIONAL)) {
    'outside of sales event - no offers or BYL CTAs are present in hero module on desktop'
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/CTA - offers'), 0, FailureHandling.STOP_ON_FAILURE)

    'outside of sales event - no offers or BYL CTAs are present in hero module on desktop'
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/CTA - BYL'), 0, FailureHandling.STOP_ON_FAILURE)
}

'runs this test if sales event content should be present'
if (WebUI.verifyMatch(salesEvent, 'y', false, FailureHandling.OPTIONAL)) {
    'during sales event, - only the offers CTA is present on desktop'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA - offers'), 0, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA - offers'), 'href')

    expectedValue = (findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey) + '#model_offers')

    valueWithoutExpected = (actualValue - expectedValue)

    'offers CTA should have correct link to model offers section'
    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA - offers'), 'target')

    expectedValue = '_self'

    valueWithoutExpected = (actualValue - expectedValue)

    'offers CTA link should remain in same browser tab'
    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'during sales event, - only the offers CTA is present on desktop'
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/CTA - BYL'), 0, FailureHandling.STOP_ON_FAILURE)
}

'tests URL if CTA is present'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA1'), 3, FailureHandling.OPTIONAL)) {
    WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA1'), FailureHandling.OPTIONAL)

    actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA1'), 'href')

    expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 360)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'takes the user to a page/section that corresponds to the URL in the CTA'
    WebUI.click(findTestObject('ModelPages/Hero/CTA1'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForPageLoad(0)

    WebUI.delay(2)

    WebUI.navigateToUrl(GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey))

    WebUI.waitForPageLoad(0)

    WebUI.delay(2)

    'tests if CTA is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA2'), 3, FailureHandling.OPTIONAL)) {
        WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA2'), FailureHandling.OPTIONAL)

        actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA2'), 'href')

        expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 390)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'takes the user to a page/section that corresponds to the URL in the CTA'
        WebUI.click(findTestObject('ModelPages/Hero/CTA2'), FailureHandling.STOP_ON_FAILURE)

        WebUI.waitForPageLoad(0)

        WebUI.delay(2)

        WebUI.back()

        WebUI.waitForPageLoad(0)

        WebUI.delay(2)

        'tests if CTA is present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA3'), 3, FailureHandling.OPTIONAL)) {
            WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA3'), FailureHandling.OPTIONAL)

            actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA3'), 'href')

            expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 420)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

            'takes the user to a page/section that corresponds to the URL in the CTA'
            WebUI.click(findTestObject('ModelPages/Hero/CTA3'), FailureHandling.STOP_ON_FAILURE)

            WebUI.waitForPageLoad(0)

            WebUI.delay(2)

            WebUI.back()

            WebUI.waitForPageLoad(0)

            WebUI.delay(2)
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

