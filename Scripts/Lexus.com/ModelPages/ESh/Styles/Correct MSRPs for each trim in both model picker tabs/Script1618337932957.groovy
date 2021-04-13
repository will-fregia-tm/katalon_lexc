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

WebUI.click(findTestObject('ModelPages/Styles/model picker tab 1'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Styles/trim 3 link'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
    modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

    modelName = (modelName + modelName2)
}

'these steps validate that the actual value contains an expected value'
actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

int trimCode = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode)

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'continues testing if there is a secondary model price'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
    'these steps validate that the actual value contains an expected value'
    actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

    int trimCode2 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode2)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
}

'continues testing if there is another model trim link'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 4 link'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Styles/trim 4 link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
        modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

        modelName = (modelName + modelName2)
    }
    
    'these steps validate that the actual value contains an expected value'
    actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

    int trimCode3 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode3)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'continues testing if there is a secondary model price'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

        int trimCode4 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

        expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode4)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'continues testing if there is another model trim link'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 5 link'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('ModelPages/Styles/trim 5 link'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
            modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

            modelName = (modelName + modelName2)
        }
        
        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

        int trimCode5 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

        expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode5)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'continues testing if there is a secondary model price'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
            'these steps validate that the actual value contains an expected value'
            actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

            int trimCode6 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

            expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode6)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
        }
        
        'continues testing if there is another model trim link'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 6 link'), 3, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('ModelPages/Styles/trim 6 link'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

            modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
                modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

                modelName = (modelName + modelName2)
            }
            
            'these steps validate that the actual value contains an expected value'
            actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

            int trimCode7 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

            expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode7)

            valueWithoutExpected = (actualValue - expectedValue)

            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

            'continues testing if there is a secondary model price'
            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
                'these steps validate that the actual value contains an expected value'
                actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

                int trimCode8 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

                expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode8)

                valueWithoutExpected = (actualValue - expectedValue)

                WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
            }
            
            'continues testing if there is another model trim link'
            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 7 link'), 3, FailureHandling.OPTIONAL)) {
                WebUI.click(findTestObject('ModelPages/Styles/trim 7 link'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

                if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
                    modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

                    modelName = (modelName + modelName2)
                }
                
                'these steps validate that the actual value contains an expected value'
                actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

                int trimCode9 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode9)

                valueWithoutExpected = (actualValue - expectedValue)

                WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                'continues testing if there is a secondary model price'
                if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
                    'these steps validate that the actual value contains an expected value'
                    actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

                    int trimCode10 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

                    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode10)

                    valueWithoutExpected = (actualValue - expectedValue)

                    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
                }
                
                'continues testing if there is another model trim link'
                if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 8 link'), 3, FailureHandling.OPTIONAL)) {
                    WebUI.click(findTestObject('ModelPages/Styles/trim 8 link'), FailureHandling.STOP_ON_FAILURE)

                    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                    modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

                    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
                        modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

                        modelName = (modelName + modelName2)
                    }
                    
                    'these steps validate that the actual value contains an expected value'
                    actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

                    int trimCode11 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode11)

                    valueWithoutExpected = (actualValue - expectedValue)

                    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                    'continues testing if there is a secondary model price'
                    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
                        'these steps validate that the actual value contains an expected value'
                        actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

                        int trimCode12 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

                        expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode12)

                        valueWithoutExpected = (actualValue - expectedValue)

                        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
                    }
                    
                    'continues testing if there is another model trim link'
                    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 9 link'), 3, FailureHandling.OPTIONAL)) {
                        WebUI.click(findTestObject('ModelPages/Styles/trim 9 link'), FailureHandling.STOP_ON_FAILURE)

                        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                        modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

                        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
                            modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

                            modelName = (modelName + modelName2)
                        }
                        
                        'these steps validate that the actual value contains an expected value'
                        actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

                        int trimCode13 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                        expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode13)

                        valueWithoutExpected = (actualValue - expectedValue)

                        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                        'continues testing if there is a secondary model price'
                        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
                            'these steps validate that the actual value contains an expected value'
                            actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

                            int trimCode14 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

                            expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode14)

                            valueWithoutExpected = (actualValue - expectedValue)

                            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
                        }
                        
                        'continues testing if there is another model trim link'
                        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 10 link'), 3, FailureHandling.OPTIONAL)) {
                            WebUI.click(findTestObject('ModelPages/Styles/trim 10 link'), FailureHandling.STOP_ON_FAILURE)

                            WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                            modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

                            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
                                modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), 
                                    FailureHandling.STOP_ON_FAILURE))

                                modelName = (modelName + modelName2)
                            }
                            
                            'these steps validate that the actual value contains an expected value'
                            actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

                            int trimCode15 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                            expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode15)

                            valueWithoutExpected = (actualValue - expectedValue)

                            WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                            'continues testing if there is a secondary model price'
                            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
                                'these steps validate that the actual value contains an expected value'
                                actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

                                int trimCode16 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

                                expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode16)

                                valueWithoutExpected = (actualValue - expectedValue)

                                WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
                            }
                            
                            'continues testing if there is another model trim link'
                            if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 11 link'), 3, FailureHandling.OPTIONAL)) {
                                WebUI.click(findTestObject('ModelPages/Styles/trim 11 link'), FailureHandling.STOP_ON_FAILURE)

                                WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                                modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

                                if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, 
                                    FailureHandling.OPTIONAL)) {
                                    modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), 
                                        FailureHandling.STOP_ON_FAILURE))

                                    modelName = (modelName + modelName2)
                                }
                                
                                'these steps validate that the actual value contains an expected value'
                                actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

                                int trimCode17 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

                                expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode17)

                                valueWithoutExpected = (actualValue - expectedValue)

                                WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

                                'continues testing if there is a secondary model price'
                                if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
                                    'these steps validate that the actual value contains an expected value'
                                    actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

                                    int trimCode18 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

                                    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode18)

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

WebUI.click(findTestObject('ModelPages/Styles/model picker tab 2'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Styles/trim 12 link'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
    modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

    modelName = (modelName + modelName2)
}

'these steps validate that the actual value contains an expected value'
actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

int trimCode24 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode24)

valueWithoutExpected = (actualValue - expectedValue)

WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

'continues testing if there is a secondary model price'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
    'these steps validate that the actual value contains an expected value'
    actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

    int trimCode19 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode19)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
}

'continues testing if there is another model trim link'
if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 13 link'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Styles/trim 13 link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
        modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

        modelName = (modelName + modelName2)
    }
    
    'these steps validate that the actual value contains an expected value'
    actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

    int trimCode20 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

    expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode20)

    valueWithoutExpected = (actualValue - expectedValue)

    WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'continues testing if there is a secondary model price'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

        int trimCode21 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

        expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode21)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    'continues testing if there is another model trim link'
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 14 link'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('ModelPages/Styles/trim 14 link'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        modelName = WebUI.getText(findTestObject('ModelPages/Styles/trim model name 1'), FailureHandling.STOP_ON_FAILURE)

        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim model name 2'), 1, FailureHandling.OPTIONAL)) {
            modelName2 = (' ' + WebUI.getText(findTestObject('ModelPages/Styles/trim model name 2'), FailureHandling.STOP_ON_FAILURE))

            modelName = (modelName + modelName2)
        }
        
        'these steps validate that the actual value contains an expected value'
        actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 1'), FailureHandling.STOP_ON_FAILURE)

        int trimCode22 = findTestData('trimCode_' + modelName).getValue(1, 1).toInteger()

        expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode22)

        valueWithoutExpected = (actualValue - expectedValue)

        WebUI.verifyNotMatch(valueWithoutExpected, actualValue, false, FailureHandling.STOP_ON_FAILURE)

        'continues testing if there is a secondary model price'
        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim price 2'), 3, FailureHandling.OPTIONAL)) {
            'these steps validate that the actual value contains an expected value'
            actualValue = WebUI.getText(findTestObject('ModelPages/Styles/trim price 2'), FailureHandling.STOP_ON_FAILURE)

            int trimCode23 = findTestData(('trimCode_' + modelName) + '_AWD').getValue(1, 1).toInteger()

            expectedValue = findTestData('MSRP').getValue(GlobalVariable.dataColumn, trimCode23)

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

