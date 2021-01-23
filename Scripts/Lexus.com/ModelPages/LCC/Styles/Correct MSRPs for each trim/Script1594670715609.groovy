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

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Overview_LCC)

WebUI.waitForPageLoad(0)

pageWidth = WebUI.getPageWidth()

WebUI.scrollToElement(findTestObject('ModelPages/Visualizer/visualizer'), 0)

if (WebUI.verifyGreaterThan(pageWidth, '1204', FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles heading'), 0)

    WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 3 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 3 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    'LC CONVERTIBLE'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 72)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Styles/trim 2 link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 2 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 2 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    'LC HYBRID'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Styles/trim 1 link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 1 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 1 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    'LC'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 3 link'), 0, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('ModelPages/Styles/trim 3 link'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 3 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 3 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

        'LC CONVERTIBLE'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 72)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

        if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 4 link'), 0, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('ModelPages/Styles/trim 4 link'), FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 4 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

            textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 4 starting at price - desktop'), 
                FailureHandling.STOP_ON_FAILURE)

            'LC INSPIRATION SERIES'
            expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 100)

            textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

            WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('ModelPages/Styles/trim 5 link'), FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 5 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

            textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 5 starting at price - desktop'), 
                FailureHandling.STOP_ON_FAILURE)

            'LC CONVERTIBLE INSPIRATION SERIES'
            expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 80)

            textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

            WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
        }
    }
    
    not_run: WebUI.click(findTestObject('ModelPages/Styles/trim 4 link'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 4 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

    not_run: textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 4 starting at price - desktop'), 
        FailureHandling.STOP_ON_FAILURE)

    'LC 500 CONVERTIBLE INSPIRATION SERIES'
    not_run: expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 80)

    not_run: textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    not_run: WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

    not_run: if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 3 link'), 0, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('ModelPages/Styles/trim 3 link'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 3 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 3 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

        'LC CONVERTIBLE'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 72)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    not_run: if (WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/trim 4 link'), 0, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('ModelPages/Styles/trim 4 link'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 4 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 4 starting at price - desktop'), FailureHandling.STOP_ON_FAILURE)

        'LC CONVERTIBLE INSPIRATION SERIES'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 80)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
    }
}

if (WebUI.verifyLessThan(pageWidth, '1204', FailureHandling.OPTIONAL)) {
    if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles heading'), 0)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 3 starting at price - tablet'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 3 starting at price - tablet'), FailureHandling.STOP_ON_FAILURE)

        'LC HYBRID'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Styles/change style dropdown'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Styles/change style dropdown option 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 1 starting at price - tablet'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 1 starting at price - tablet'), FailureHandling.STOP_ON_FAILURE)

        'LC'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles heading'), 0)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 3 starting at price - mobile'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 3 starting at price - mobile'), FailureHandling.STOP_ON_FAILURE)

        'LC HYBRID'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Styles/change style dropdown'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/Styles/change style dropdown option 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('ModelPages/Styles/model-style 1 starting at price - mobile'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/Styles/model-style 1 starting at price - mobile'), FailureHandling.STOP_ON_FAILURE)

        'LC'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)

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

