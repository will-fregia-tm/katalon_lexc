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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.OPTIONAL)

'these steps are added to handle lower environment authentication'
if (WebUI.verifyMatch(GlobalVariable.lowerEnvironment, 'yes', false, FailureHandling.OPTIONAL)) {
    cookieValue = findTestData('cookieValues').getValue(2, 1)

    Cookie ck = new Cookie('ESTSAUTH', cookieValue)

    WebDriver driver = DriverFactory.getWebDriver()

    driver.manage().addCookie(ck)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

'if the page renders slowly, it will be refreshed so the test can continue'
if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/hero module'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Homepage/ContentTiles/tiles module 01'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 01'), 0, FailureHandling.OPTIONAL)

'continues tests if there are four tiles in this module'
if (WebUI.verifyElementPresent(findTestObject('Homepage/ContentTiles/tiles module 01 - tile4 image'), 3, FailureHandling.OPTIONAL)) {
    'this checks which slide is currently active'
    firstActive = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module - current slide'), 'data-index', 
        FailureHandling.STOP_ON_FAILURE)

    'should start at 0'
    WebUI.verifyMatch('0', firstActive, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/ContentTiles/tiles module 01 - next button'))

    WebUI.delay(2)

    WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/ContentTiles/tiles module 01 - tile4 image'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/ContentTiles/tiles module 01 - tile4 CTA'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('Homepage/ContentTiles/tiles module 01 - tile7 CTA'), 0, FailureHandling.STOP_ON_FAILURE)

    'this checks which slide is currently active'
    nextActive = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module - current slide'), 'data-index', 
        FailureHandling.STOP_ON_FAILURE)

    'if the carousel has progressed properly, this number should be 3 higher than the previous check'
    WebUI.verifyNotMatch(firstActive, nextActive, false, FailureHandling.STOP_ON_FAILURE)

    'should now be 3'
    WebUI.verifyMatch('3', nextActive, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/ContentTiles/tiles module 01 - previous button'))

    WebUI.delay(2)

    'this checks which slide is currently active'
    previousActive = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module - current slide'), 'data-index', 
        FailureHandling.STOP_ON_FAILURE)

    'if the carousel has progressed properly, this number should match original'
    WebUI.verifyMatch(firstActive, previousActive, false, FailureHandling.STOP_ON_FAILURE)

    'should go back to 0'
    WebUI.verifyMatch('0', previousActive, false, FailureHandling.STOP_ON_FAILURE)
}

'continues tests if there were not four tiles in this module'
if (WebUI.verifyElementNotPresent(findTestObject('Homepage/ContentTiles/tiles module 01 - tile4 image'), 3, FailureHandling.OPTIONAL)) {
    'runs more tests if there are additional grid modules present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/ContentTiles/tiles module 02'), 3, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 02'), 0, FailureHandling.STOP_ON_FAILURE)

        'this checks which slide is currently active'
        firstActive = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module - current slide'), 'data-index', 
            FailureHandling.STOP_ON_FAILURE)

        'should start at 0'
        WebUI.verifyMatch('0', firstActive, false, FailureHandling.STOP_ON_FAILURE)

        'continues tests if there are four tiles in this module'
        if (WebUI.verifyElementPresent(findTestObject('Homepage/ContentTiles/tiles module 02 - tile4 image'), 3, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('Homepage/ContentTiles/tiles module 02 - next button'))

            WebUI.delay(2)

            WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/ContentTiles/tiles module 02 - tile4 image'), 
                0, FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/ContentTiles/tiles module 02 - tile4 CTA'), 0, 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementNotPresent(findTestObject('Homepage/ContentTiles/tiles module 02 - tile7 CTA'), 0, FailureHandling.STOP_ON_FAILURE)

            'this checks which slide is currently active'
            nextActive = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module - current slide'), 'data-index', 
                FailureHandling.STOP_ON_FAILURE)

            'if the carousel has progressed properly, this number should be 3 higher than the previous check'
            WebUI.verifyNotMatch(firstActive, nextActive, false, FailureHandling.STOP_ON_FAILURE)

            'should now be 3'
            WebUI.verifyMatch('3', nextActive, false, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('Homepage/ContentTiles/tiles module 02 - previous button'))

            WebUI.delay(2)

            'this checks which slide is currently active'
            previousActive = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module - current slide'), 'data-index', 
                FailureHandling.STOP_ON_FAILURE)

            'if the carousel has progressed properly, this number should match original'
            WebUI.verifyMatch(firstActive, previousActive, false, FailureHandling.STOP_ON_FAILURE)

            'should go back to 0'
            WebUI.verifyMatch('0', previousActive, false, FailureHandling.STOP_ON_FAILURE)
        }
        
        'continues tests if there were not four tiles in this module'
        if (WebUI.verifyElementNotPresent(findTestObject('Homepage/ContentTiles/tiles module 02 - tile4 image'), 3, FailureHandling.OPTIONAL)) {
            'runs more tests if there are additional grid modules present'
            if (WebUI.verifyElementPresent(findTestObject('Homepage/ContentTiles/tiles module 03'), 3, FailureHandling.OPTIONAL)) {
                WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 03'), 0, FailureHandling.STOP_ON_FAILURE)

                'this checks which slide is currently active'
                firstActive = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module - current slide'), 'data-index', 
                    FailureHandling.STOP_ON_FAILURE)

                'should start at 0'
                WebUI.verifyMatch('0', firstActive, false, FailureHandling.STOP_ON_FAILURE)

                'continues tests if there are four tiles in this module'
                if (WebUI.verifyElementPresent(findTestObject('Homepage/ContentTiles/tiles module 03 - tile4 image'), 3, 
                    FailureHandling.OPTIONAL)) {
                    WebUI.click(findTestObject('Homepage/ContentTiles/tiles module 03 - next button'))

                    WebUI.delay(2)

                    WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/ContentTiles/tiles module 03 - tile4 image'), 
                        0, FailureHandling.STOP_ON_FAILURE)

                    WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/ContentTiles/tiles module 03 - tile4 CTA'), 
                        0, FailureHandling.STOP_ON_FAILURE)

                    WebUI.verifyElementNotPresent(findTestObject('Homepage/ContentTiles/tiles module 03 - tile7 CTA'), 0, 
                        FailureHandling.STOP_ON_FAILURE)

                    'this checks which slide is currently active'
                    nextActive = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module - current slide'), 
                        'data-index', FailureHandling.STOP_ON_FAILURE)

                    'if the carousel has progressed properly, this number should be 3 higher than the previous check'
                    WebUI.verifyNotMatch(firstActive, nextActive, false, FailureHandling.STOP_ON_FAILURE)

                    'should now be 3'
                    WebUI.verifyMatch('3', nextActive, false, FailureHandling.STOP_ON_FAILURE)

                    WebUI.click(findTestObject('Homepage/ContentTiles/tiles module 03 - previous button'))

                    WebUI.delay(2)

                    'this checks which slide is currently active'
                    previousActive = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module - current slide'), 
                        'data-index', FailureHandling.STOP_ON_FAILURE)

                    'if the carousel has progressed properly, this number should match original'
                    WebUI.verifyMatch(firstActive, previousActive, false, FailureHandling.STOP_ON_FAILURE)

                    'should go back to 0'
                    WebUI.verifyMatch('0', previousActive, false, FailureHandling.STOP_ON_FAILURE)
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

