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

WebUI.click(findTestObject('ModelPages/Subnav/styles link'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

'continues test if there is a special edition trim present'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/special edition trim 1'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Styles/special edition trim 1'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Overlay/overlay'), 0)

    'continues test if there is a Learn More CTA present'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Learn More CTA'), 3, FailureHandling.OPTIONAL)) {
        WebUI.mouseOver(findTestObject('ModelPages/Styles/Learn More CTA'), FailureHandling.OPTIONAL)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Styles/Learn More CTA'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        'Learn More CTA for special edition trim should open appropriate special edition overlay.'
        WebUI.verifyElementVisible(findTestObject('ModelPages/Overlay/overlay'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Overlay/close overlay button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        'continues test if there is another special edition trim present'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/special edition trim 2'), 3, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('ModelPages/Styles/special edition trim 2'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementNotPresent(findTestObject('ModelPages/Overlay/overlay'), 0)

            'continues test if there is a Learn More CTA present'
            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Learn More CTA'), 3, FailureHandling.OPTIONAL)) {
                WebUI.mouseOver(findTestObject('ModelPages/Styles/Learn More CTA'), FailureHandling.OPTIONAL)

                WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                WebUI.click(findTestObject('ModelPages/Styles/Learn More CTA'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

                'Learn More CTA for special edition trim should open appropriate special edition overlay.'
                WebUI.verifyElementVisible(findTestObject('ModelPages/Overlay/overlay'), FailureHandling.STOP_ON_FAILURE)

                WebUI.click(findTestObject('ModelPages/Overlay/close overlay button'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

                'continues test if there is another special edition trim present'
                if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/special edition trim 3'), 3, FailureHandling.OPTIONAL)) {
                    WebUI.click(findTestObject('ModelPages/Styles/special edition trim 3'), FailureHandling.STOP_ON_FAILURE)

                    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Overlay/overlay'), 0)

                    'continues test if there is a Learn More CTA present'
                    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Learn More CTA'), 3, FailureHandling.OPTIONAL)) {
                        WebUI.mouseOver(findTestObject('ModelPages/Styles/Learn More CTA'), FailureHandling.OPTIONAL)

                        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                        WebUI.click(findTestObject('ModelPages/Styles/Learn More CTA'), FailureHandling.STOP_ON_FAILURE)

                        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

                        'Learn More CTA for special edition trim should open appropriate special edition overlay.'
                        WebUI.verifyElementVisible(findTestObject('ModelPages/Overlay/overlay'), FailureHandling.STOP_ON_FAILURE)

                        WebUI.click(findTestObject('ModelPages/Overlay/close overlay button'), FailureHandling.STOP_ON_FAILURE)

                        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
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

