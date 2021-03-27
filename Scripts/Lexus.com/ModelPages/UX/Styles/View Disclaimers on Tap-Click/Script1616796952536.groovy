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

WebUI.click(findTestObject('ModelPages/Subnav/styles link'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

'tests if asterisk disclaimer is present'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/asterisk disclaimer 1'), 3, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

    'When a user tap/clicks on a disclaimer "*" on the model page'
    WebUI.click(findTestObject('ModelPages/Styles/asterisk disclaimer 1'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    'display the appropriate disclaimer text in a disclaimer tooltip dialog box'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

    'these steps validate that the actual value contains an expected value'
    actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

    expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 480)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'When a user tap/clicks on the disclaimer tooltip close button (X)'
    WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    'Then the system shall hide the tooltip'
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

    'tests if asterisk disclaimer is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/asterisk disclaimer 2'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('ModelPages/Styles/asterisk disclaimer 2'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

        expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 510)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        'tests if asterisk disclaimer is present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/asterisk disclaimer 3'), 3, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('ModelPages/Styles/asterisk disclaimer 3'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

            'these steps validate that the actual value contains an expected value'
            actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

            expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 540)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)
        }
    }
}

'continues testing if there is another trim available'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 2 link'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Styles/trim 2 link'))

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    'tests if asterisk disclaimer is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/asterisk disclaimer 1'), 3, FailureHandling.OPTIONAL)) {
        'When a user tap/clicks on a disclaimer "*" on the model page'
        WebUI.click(findTestObject('ModelPages/Styles/asterisk disclaimer 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        'display the appropriate disclaimer text in a disclaimer tooltip dialog box'
        WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

        expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 480)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'When a user tap/clicks on the disclaimer tooltip close button (X)'
        WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        'Then the system shall hide the tooltip'
        WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        'tests if asterisk disclaimer is present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/asterisk disclaimer 2'), 3, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('ModelPages/Styles/asterisk disclaimer 2'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

            'these steps validate that the actual value contains an expected value'
            actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

            expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 510)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

            'tests if asterisk disclaimer is present'
            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/asterisk disclaimer 3'), 3, FailureHandling.OPTIONAL)) {
                WebUI.click(findTestObject('ModelPages/Styles/asterisk disclaimer 3'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(1)

                WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

                'these steps validate that the actual value contains an expected value'
                actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

                expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 540)

                valueWithoutExpected = (actualValue - expectedValue)

                WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)
            }
        }
    }
}

'continues testing if there is another trim available'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 3 link'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Styles/trim 3 link'))

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    'tests if asterisk disclaimer is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/asterisk disclaimer 1'), 3, FailureHandling.OPTIONAL)) {
        'When a user tap/clicks on a disclaimer "*" on the model page'
        WebUI.click(findTestObject('ModelPages/Styles/asterisk disclaimer 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        'display the appropriate disclaimer text in a disclaimer tooltip dialog box'
        WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

        expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 480)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'When a user tap/clicks on the disclaimer tooltip close button (X)'
        WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        'Then the system shall hide the tooltip'
        WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        'tests if asterisk disclaimer is present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/asterisk disclaimer 2'), 3, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('ModelPages/Styles/asterisk disclaimer 2'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

            'these steps validate that the actual value contains an expected value'
            actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

            expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 510)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

            'tests if asterisk disclaimer is present'
            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/asterisk disclaimer 3'), 3, FailureHandling.OPTIONAL)) {
                WebUI.click(findTestObject('ModelPages/Styles/asterisk disclaimer 3'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(1)

                WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

                'these steps validate that the actual value contains an expected value'
                actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

                expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 540)

                valueWithoutExpected = (actualValue - expectedValue)

                WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)
            }
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

