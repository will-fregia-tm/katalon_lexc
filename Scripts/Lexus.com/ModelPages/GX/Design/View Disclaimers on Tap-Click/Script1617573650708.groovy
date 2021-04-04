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

'this step is added to handle a slow or partial page load'
if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 3, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('ModelPages/Subnav/design link'), FailureHandling.OPTIONAL)

WebUI.delay(3)

'tests if asterisk disclaimer is present'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Design/asterisk disclaimer 1'), 3, FailureHandling.OPTIONAL)) {
    WebUI.delay(1)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

    'When a user tap/clicks on a disclaimer "*" on the model page'
    WebUI.click(findTestObject('ModelPages/Design/asterisk disclaimer 1'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    'display the appropriate disclaimer text in a disclaimer tooltip dialog box'
    WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

    'these steps validate that the actual value contains an expected value'
    actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

    expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 570)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'When a user tap/clicks on the disclaimer tooltip close button (X)'
    WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    'Then the system shall hide the tooltip'
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)
}

'continues testing if there is another story link available'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Design/story link 2'), 3, FailureHandling.OPTIONAL)) {
    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Design/story link 2'))

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    'tests if asterisk disclaimer is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Design/asterisk disclaimer 1'), 3, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

        'When a user tap/clicks on a disclaimer "*" on the model page'
        WebUI.click(findTestObject('ModelPages/Design/asterisk disclaimer 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        'display the appropriate disclaimer text in a disclaimer tooltip dialog box'
        WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

        expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 600)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'When a user tap/clicks on the disclaimer tooltip close button (X)'
        WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        'Then the system shall hide the tooltip'
        WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)
    }
}

'continues testing if there is another story link available'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Design/story link 3'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Design/story link 3'))

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    'tests if asterisk disclaimer is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Design/asterisk disclaimer 1'), 3, FailureHandling.OPTIONAL)) {
        'When a user tap/clicks on a disclaimer "*" on the model page'
        WebUI.click(findTestObject('ModelPages/Design/asterisk disclaimer 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        'display the appropriate disclaimer text in a disclaimer tooltip dialog box'
        WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

        expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 630)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'When a user tap/clicks on the disclaimer tooltip close button (X)'
        WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        'Then the system shall hide the tooltip'
        WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)
    }
}

'continues testing if there is a More Features drawer'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Design/drawer/more features link'), 3, FailureHandling.OPTIONAL)) {
    not_run: WebUI.scrollToElement(findTestObject('ModelPages/Design/drawer/more features link'), 0)

    not_run: WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Design/drawer/more features link'))

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    'tests if asterisk disclaimer is present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Design/drawer/asterisk disclaimer 1'), 3, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

        'When a user tap/clicks on a disclaimer "*" on the model page'
        WebUI.click(findTestObject('ModelPages/Design/drawer/asterisk disclaimer 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1)

        'display the appropriate disclaimer text in a disclaimer tooltip dialog box'
        WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

        expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 660)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'When a user tap/clicks on the disclaimer tooltip close button (X)'
        WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        'Then the system shall hide the tooltip'
        WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        'tests if asterisk disclaimer is present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Design/drawer/asterisk disclaimer 2'), 3, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('ModelPages/Design/drawer/asterisk disclaimer 2'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1)

            WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

            'these steps validate that the actual value contains an expected value'
            actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

            expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 690)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('ModelPages/Disclaimers/disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

            'tests if asterisk disclaimer is present'
            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Design/drawer/asterisk disclaimer 3'), 3, FailureHandling.OPTIONAL)) {
                WebUI.click(findTestObject('ModelPages/Design/drawer/asterisk disclaimer 3'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(1)

                WebUI.verifyElementPresent(findTestObject('ModelPages/Disclaimers/disclaimer copy'), 0)

                'these steps validate that the actual value contains an expected value'
                actualValue = WebUI.getText(findTestObject('ModelPages/Disclaimers/disclaimer copy'))

                expectedValue = findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey + 720)

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

