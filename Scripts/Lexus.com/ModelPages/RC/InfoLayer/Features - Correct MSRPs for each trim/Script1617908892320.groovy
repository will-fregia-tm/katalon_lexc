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

WebUI.click(findTestObject('ModelPages/Subnav/styles link'), FailureHandling.OPTIONAL)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('ModelPages/Styles/Compare Styles CTA'), FailureHandling.OPTIONAL)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Styles/Compare Styles CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

'these steps validate that the actual value contains an expected value'
actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 1 model price'), FailureHandling.STOP_ON_FAILURE)

modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 1 model name'), FailureHandling.STOP_ON_FAILURE)

int trimCode = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode)

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'continues testing if there is another model price'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 2 model price'), 3, FailureHandling.OPTIONAL)) {
    'these steps validate that the actual value contains an expected value'
    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 2 model price'), FailureHandling.STOP_ON_FAILURE)

    modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 2 model name'), FailureHandling.STOP_ON_FAILURE)

    int trimCode2 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode2)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'continues testing if there is another model price'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 3 model price'), 3, FailureHandling.OPTIONAL)) {
        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 3 model price'), FailureHandling.STOP_ON_FAILURE)

        modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 3 model name'), FailureHandling.STOP_ON_FAILURE)

        int trimCode3 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

        expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode3)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'continues testing if there is another model price'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 4 model price'), 3, FailureHandling.OPTIONAL)) {
            'these steps validate that the actual value contains an expected value'
            actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 4 model price'), FailureHandling.STOP_ON_FAILURE)

            modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 4 model name'), FailureHandling.STOP_ON_FAILURE)

            int trimCode4 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

            expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode4)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

            'continues testing if there is another model price'
            if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 5 model price'), 3, FailureHandling.OPTIONAL)) {
                'these steps validate that the actual value contains an expected value'
                actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 5 model price'), FailureHandling.STOP_ON_FAILURE)

                modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 5 model name'), FailureHandling.STOP_ON_FAILURE)

                int trimCode5 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode5)

                valueWithoutExpected = (actualValue - expectedValue)

                WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                'continues testing if there is another model price'
                if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 6 model price'), 3, FailureHandling.OPTIONAL)) {
                    'these steps validate that the actual value contains an expected value'
                    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 6 model price'), FailureHandling.STOP_ON_FAILURE)

                    modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 6 model name'), FailureHandling.STOP_ON_FAILURE)

                    int trimCode6 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode6)

                    valueWithoutExpected = (actualValue - expectedValue)

                    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                    'continues testing if there is another model price'
                    if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 7 model price'), 3, 
                        FailureHandling.OPTIONAL)) {
                        'these steps validate that the actual value contains an expected value'
                        actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 7 model price'), 
                            FailureHandling.STOP_ON_FAILURE)

                        modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 7 model name'), FailureHandling.STOP_ON_FAILURE)

                        int trimCode7 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                        expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode7)

                        valueWithoutExpected = (actualValue - expectedValue)

                        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                        'continues testing if there is another model price'
                        if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 8 model price'), 
                            3, FailureHandling.OPTIONAL)) {
                            'these steps validate that the actual value contains an expected value'
                            actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 8 model price'), 
                                FailureHandling.STOP_ON_FAILURE)

                            modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 8 model name'), 
                                FailureHandling.STOP_ON_FAILURE)

                            int trimCode8 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                            expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode8)

                            valueWithoutExpected = (actualValue - expectedValue)

                            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                            'continues testing if there is another model price'
                            if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 9 model price'), 
                                3, FailureHandling.OPTIONAL)) {
                                'these steps validate that the actual value contains an expected value'
                                actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 9 model price'), 
                                    FailureHandling.STOP_ON_FAILURE)

                                modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 9 model name'), 
                                    FailureHandling.STOP_ON_FAILURE)

                                int trimCode9 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                                expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode9)

                                valueWithoutExpected = (actualValue - expectedValue)

                                WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                                'continues testing if there is another model price'
                                if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 10 model price'), 
                                    3, FailureHandling.OPTIONAL)) {
                                    'these steps validate that the actual value contains an expected value'
                                    actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 10 model price'), 
                                        FailureHandling.STOP_ON_FAILURE)

                                    modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 10 model name'), 
                                        FailureHandling.STOP_ON_FAILURE)

                                    int trimCode10 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                                    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode10)

                                    valueWithoutExpected = (actualValue - expectedValue)

                                    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                                    'continues testing if there is another model price'
                                    if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 11 model price'), 
                                        3, FailureHandling.OPTIONAL)) {
                                        'these steps validate that the actual value contains an expected value'
                                        actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 11 model price'), 
                                            FailureHandling.STOP_ON_FAILURE)

                                        modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 11 model name'), 
                                            FailureHandling.STOP_ON_FAILURE)

                                        int trimCode11 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                                        expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode11)

                                        valueWithoutExpected = (actualValue - expectedValue)

                                        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                                        'continues testing if there is another model price'
                                        if (WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 12 model price'), 
                                            3, FailureHandling.OPTIONAL)) {
                                            'these steps validate that the actual value contains an expected value'
                                            actualValue = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 12 model price'), 
                                                FailureHandling.STOP_ON_FAILURE)

                                            modelName = WebUI.getText(findTestObject('ModelPages/InformationLayer/column 12 model name'), 
                                                FailureHandling.STOP_ON_FAILURE)

                                            int trimCode12 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                                            expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode12)

                                            valueWithoutExpected = (actualValue - expectedValue)

                                            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
                                        }
                                    }
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

