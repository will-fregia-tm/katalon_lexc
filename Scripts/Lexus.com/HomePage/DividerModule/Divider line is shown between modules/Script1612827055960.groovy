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

WebUI.waitForElementPresent(findTestObject('Homepage/DividerModule/divider 01'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 01'), 0, FailureHandling.STOP_ON_FAILURE)

dividerSpacing = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 01'), 'display', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(dividerSpacing, 'block', false, FailureHandling.STOP_ON_FAILURE)

dividerHeight = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 01'), 'height', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(dividerHeight, '1px', false, FailureHandling.STOP_ON_FAILURE)

dividerColor = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 01'), 'background-color', FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(dividerColor, 'rgba(239, 239, 239, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(dividerColor, 'rgb(239, 239, 239)', false, FailureHandling.STOP_ON_FAILURE)
}

'tests further if there are additional dividers'
if (WebUI.verifyElementPresent(findTestObject('Homepage/DividerModule/divider 02'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 02'), 0, FailureHandling.STOP_ON_FAILURE)

    dividerHeight = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 02'), 'height', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(dividerHeight, '1px', false, FailureHandling.STOP_ON_FAILURE)

    dividerColor = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 02'), 'background-color', FailureHandling.STOP_ON_FAILURE)

    if (WebUI.verifyNotMatch(dividerColor, 'rgba(239, 239, 239, 1)', false, FailureHandling.OPTIONAL)) {
        WebUI.verifyMatch(dividerColor, 'rgb(239, 239, 239)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'tests further if there are additional dividers'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/DividerModule/divider 03'), 3, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 03'), 0, FailureHandling.STOP_ON_FAILURE)

        dividerHeight = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 03'), 'height', FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(dividerHeight, '1px', false, FailureHandling.STOP_ON_FAILURE)

        dividerColor = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 03'), 'background-color', FailureHandling.STOP_ON_FAILURE)

        if (WebUI.verifyNotMatch(dividerColor, 'rgba(239, 239, 239, 1)', false, FailureHandling.OPTIONAL)) {
            WebUI.verifyMatch(dividerColor, 'rgb(239, 239, 239)', false, FailureHandling.STOP_ON_FAILURE)
        }
        
        'tests further if there are additional dividers'
        if (WebUI.verifyElementPresent(findTestObject('Homepage/DividerModule/divider 04'), 3, FailureHandling.OPTIONAL)) {
            WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 04'), 0, FailureHandling.STOP_ON_FAILURE)

            dividerHeight = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 04'), 'height', FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyMatch(dividerHeight, '1px', false, FailureHandling.STOP_ON_FAILURE)

            dividerColor = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 04'), 'background-color', FailureHandling.STOP_ON_FAILURE)

            if (WebUI.verifyNotMatch(dividerColor, 'rgba(239, 239, 239, 1)', false, FailureHandling.OPTIONAL)) {
                WebUI.verifyMatch(dividerColor, 'rgb(239, 239, 239)', false, FailureHandling.STOP_ON_FAILURE)
            }
            
            'tests further if there are additional dividers'
            if (WebUI.verifyElementPresent(findTestObject('Homepage/DividerModule/divider 05'), 3, FailureHandling.OPTIONAL)) {
                WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 05'), 0, FailureHandling.STOP_ON_FAILURE)

                dividerHeight = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 05'), 'height', FailureHandling.STOP_ON_FAILURE)

                WebUI.verifyMatch(dividerHeight, '1px', false, FailureHandling.STOP_ON_FAILURE)

                dividerColor = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 05'), 'background-color', 
                    FailureHandling.STOP_ON_FAILURE)

                if (WebUI.verifyNotMatch(dividerColor, 'rgba(239, 239, 239, 1)', false, FailureHandling.OPTIONAL)) {
                    WebUI.verifyMatch(dividerColor, 'rgb(239, 239, 239)', false, FailureHandling.STOP_ON_FAILURE)
                }
                
                'tests further if there are additional dividers'
                if (WebUI.verifyElementPresent(findTestObject('Homepage/DividerModule/divider 06'), 3, FailureHandling.OPTIONAL)) {
                    WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 06'), 0, FailureHandling.STOP_ON_FAILURE)

                    dividerHeight = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 06'), 'height', FailureHandling.STOP_ON_FAILURE)

                    WebUI.verifyMatch(dividerHeight, '1px', false, FailureHandling.STOP_ON_FAILURE)

                    dividerColor = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 06'), 'background-color', 
                        FailureHandling.STOP_ON_FAILURE)

                    if (WebUI.verifyNotMatch(dividerColor, 'rgba(239, 239, 239, 1)', false, FailureHandling.OPTIONAL)) {
                        WebUI.verifyMatch(dividerColor, 'rgb(239, 239, 239)', false, FailureHandling.STOP_ON_FAILURE)
                    }
                    
                    'tests further if there are additional dividers'
                    if (WebUI.verifyElementPresent(findTestObject('Homepage/DividerModule/divider 07'), 3, FailureHandling.OPTIONAL)) {
                        WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 07'), 0, FailureHandling.STOP_ON_FAILURE)

                        dividerHeight = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 07'), 'height', 
                            FailureHandling.STOP_ON_FAILURE)

                        WebUI.verifyMatch(dividerHeight, '1px', false, FailureHandling.STOP_ON_FAILURE)

                        dividerColor = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 07'), 'background-color', 
                            FailureHandling.STOP_ON_FAILURE)

                        if (WebUI.verifyNotMatch(dividerColor, 'rgba(239, 239, 239, 1)', false, FailureHandling.OPTIONAL)) {
                            WebUI.verifyMatch(dividerColor, 'rgb(239, 239, 239)', false, FailureHandling.STOP_ON_FAILURE)
                        }
                        
                        'tests further if there are additional dividers'
                        if (WebUI.verifyElementPresent(findTestObject('Homepage/DividerModule/divider 08'), 3, FailureHandling.OPTIONAL)) {
                            WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 08'), 0, FailureHandling.STOP_ON_FAILURE)

                            dividerHeight = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 08'), 'height', 
                                FailureHandling.STOP_ON_FAILURE)

                            WebUI.verifyMatch(dividerHeight, '1px', false, FailureHandling.STOP_ON_FAILURE)

                            dividerColor = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 08'), 'background-color', 
                                FailureHandling.STOP_ON_FAILURE)

                            if (WebUI.verifyNotMatch(dividerColor, 'rgba(239, 239, 239, 1)', false, FailureHandling.OPTIONAL)) {
                                WebUI.verifyMatch(dividerColor, 'rgb(239, 239, 239)', false, FailureHandling.STOP_ON_FAILURE)
                            }
                            
                            'tests further if there are additional dividers'
                            if (WebUI.verifyElementPresent(findTestObject('Homepage/DividerModule/divider 09'), 3, FailureHandling.OPTIONAL)) {
                                WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 09'), 0, FailureHandling.STOP_ON_FAILURE)

                                dividerHeight = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 09'), 'height', 
                                    FailureHandling.STOP_ON_FAILURE)

                                WebUI.verifyMatch(dividerHeight, '1px', false, FailureHandling.STOP_ON_FAILURE)

                                dividerColor = WebUI.getCSSValue(findTestObject('Homepage/DividerModule/divider 09'), 'background-color', 
                                    FailureHandling.STOP_ON_FAILURE)

                                if (WebUI.verifyNotMatch(dividerColor, 'rgba(239, 239, 239, 1)', false, FailureHandling.OPTIONAL)) {
                                    WebUI.verifyMatch(dividerColor, 'rgb(239, 239, 239)', false, FailureHandling.STOP_ON_FAILURE)
                                }
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

