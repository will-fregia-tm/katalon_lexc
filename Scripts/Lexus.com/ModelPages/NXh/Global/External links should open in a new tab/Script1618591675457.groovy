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
if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/hero module'), 6, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 6, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/hero module'), 6, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Global/external link in same browser tab 1'), 6, FailureHandling.CONTINUE_ON_FAILURE)

'keeps checking for more external links that open in the same tab'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Global/external link in same browser tab 1'), 6, FailureHandling.OPTIONAL)) {
    WebUI.getAttribute(findTestObject('ModelPages/Global/external link in same browser tab 1'), 'href', FailureHandling.STOP_ON_FAILURE)

    'keeps checking for more external links that open in the same tab'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Global/external link in same browser tab 2'), 6, FailureHandling.OPTIONAL)) {
        WebUI.getAttribute(findTestObject('ModelPages/Global/external link in same browser tab 2'), 'href', FailureHandling.STOP_ON_FAILURE)

        'keeps checking for more external links that open in the same tab'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Global/external link in same browser tab 3'), 6, FailureHandling.OPTIONAL)) {
            WebUI.getAttribute(findTestObject('ModelPages/Global/external link in same browser tab 3'), 'href', FailureHandling.STOP_ON_FAILURE)

            'keeps checking for more external links that open in the same tab'
            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Global/external link in same browser tab 4'), 6, FailureHandling.OPTIONAL)) {
                WebUI.getAttribute(findTestObject('ModelPages/Global/external link in same browser tab 4'), 'href', FailureHandling.STOP_ON_FAILURE)

                'keeps checking for more external links that open in the same tab'
                if (WebUI.verifyElementPresent(findTestObject('ModelPages/Global/external link in same browser tab 5'), 
                    6, FailureHandling.OPTIONAL)) {
                    WebUI.getAttribute(findTestObject('ModelPages/Global/external link in same browser tab 5'), 'href', 
                        FailureHandling.STOP_ON_FAILURE)

                    'keeps checking for more external links that open in the same tab'
                    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Global/external link in same browser tab 6'), 
                        6, FailureHandling.OPTIONAL)) {
                        WebUI.getAttribute(findTestObject('ModelPages/Global/external link in same browser tab 6'), 'href', 
                            FailureHandling.STOP_ON_FAILURE)

                        'keeps checking for more external links that open in the same tab'
                        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Global/external link in same browser tab 7'), 
                            6, FailureHandling.OPTIONAL)) {
                            WebUI.getAttribute(findTestObject('ModelPages/Global/external link in same browser tab 7'), 
                                'href', FailureHandling.STOP_ON_FAILURE)

                            'keeps checking for more external links that open in the same tab'
                            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Global/external link in same browser tab 8'), 
                                6, FailureHandling.OPTIONAL)) {
                                WebUI.getAttribute(findTestObject('ModelPages/Global/external link in same browser tab 8'), 
                                    'href', FailureHandling.STOP_ON_FAILURE)
                            }
                        }
                    }
                }
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

