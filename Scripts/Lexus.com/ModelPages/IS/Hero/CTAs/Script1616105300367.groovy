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

modelSeries = findTestData('modelData').getValue(1, 1)

int seriesKey = findTestData('modelData').getValue(1, 2).toInteger()

'checks whether this is a hybrid'
hybridValue = findTestData('modelData').getValue(2, seriesKey + 90)

WebUI.navigateToUrl(GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey))

'this step is added to handle a slow or partial page load'
if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 3, FailureHandling.OPTIONAL)

'tests URL if CTA is present'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA1'), 3, FailureHandling.OPTIONAL)) {
    WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA1'), FailureHandling.OPTIONAL)

    actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA1'), 'href')

    expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 360)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'tests if CTA is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA2'), 3, FailureHandling.OPTIONAL)) {
        WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA2'), FailureHandling.OPTIONAL)

        actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA2'), 'href')

        expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 390)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'tests if CTA is present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA3'), 3, FailureHandling.OPTIONAL)) {
            WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA3'), FailureHandling.OPTIONAL)

            actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA3'), 'href')

            expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 420)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
        }
    }
}

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

'checks non-sales event CTAs'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA1'), 3, FailureHandling.OPTIONAL)) {
    WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA1'), FailureHandling.OPTIONAL)

    actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA1'), 'href')

    expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 360)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'tests if CTA is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA2'), 3, FailureHandling.OPTIONAL)) {
        WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA2'), FailureHandling.OPTIONAL)

        actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA2'), 'href')

        expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 390)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'tests if CTA is present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA3'), 3, FailureHandling.OPTIONAL)) {
            WebUI.mouseOver(findTestObject('ModelPages/Hero/CTA3'), FailureHandling.OPTIONAL)

            actualValue = WebUI.getAttribute(findTestObject('ModelPages/Hero/CTA3'), 'href')

            expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 420)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
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

