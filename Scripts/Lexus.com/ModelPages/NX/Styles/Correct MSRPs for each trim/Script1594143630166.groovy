import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Overview_NX)

WebUI.waitForPageLoad(0)

pageWidth = WebUI.getPageWidth()

WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

if (WebUI.verifyGreaterThan(pageWidth, '1204', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 1 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 1 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    'NX 300'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 35)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Styles/trim 2 link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 2 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 2 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    'NX 300 F SPORT'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 37)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyLessThan(pageWidth, '1204', FailureHandling.OPTIONAL)) {
    if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles heading'), 0)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 1 starting at price - tablet'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 1 starting at price - tablet'), FailureHandling.STOP_ON_FAILURE)

        'NX 300'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 35)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Styles/change style dropdown'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Styles/change style dropdown option 2'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 2 starting at price - tablet'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 2 starting at price - tablet'), FailureHandling.STOP_ON_FAILURE)

        'NX 300 F SPORT'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 37)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles heading'), 0)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 1 starting at price - mobile'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 1 starting at price - mobile'), FailureHandling.STOP_ON_FAILURE)

        'NX 300'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 35)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Styles/change style dropdown'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Styles/change style dropdown option 2'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 2 starting at price - mobile'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 2 starting at price - mobile'), FailureHandling.STOP_ON_FAILURE)

        'NX 300 F SPORT'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 37)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
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

