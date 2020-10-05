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

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_IS)

WebUI.waitForPageLoad(0)

pageWidth = WebUI.getPageWidth()

WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

if (WebUI.verifyLessThan(pageWidth, '1204', FailureHandling.OPTIONAL)) {
    if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles heading'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Compare CTA - desktop'), 0)

        WebUI.click(findTestObject('ModelPages/Styles/Compare CTA - desktop'), FailureHandling.STOP_ON_FAILURE)

        WebUI.waitForElementPresent(findTestObject('ModelPages/InformationLayer/first category'), 0)

        WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/MSRP - first trim'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/InformationLayer/MSRP - first trim'), FailureHandling.STOP_ON_FAILURE)

        'IS 300'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 17)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/MSRP - second trim'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/InformationLayer/MSRP - second trim'), FailureHandling.STOP_ON_FAILURE)

        'IS 300 AWD'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 19)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles heading'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Compare CTA - mobile'), 0)

        WebUI.click(findTestObject('ModelPages/Styles/Compare CTA - mobile'), FailureHandling.STOP_ON_FAILURE)

        WebUI.waitForElementPresent(findTestObject('ModelPages/InformationLayer/first category'), 0)

        WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/MSRP mobile'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/InformationLayer/MSRP mobile'), FailureHandling.STOP_ON_FAILURE)

        'IS 300'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 17)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/InformationLayer/model selector dropdown'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('ModelPages/InformationLayer/model selector dropdown option 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/MSRP mobile'), FailureHandling.STOP_ON_FAILURE)

        textWithMSRP = WebUI.getText(findTestObject('ModelPages/InformationLayer/MSRP mobile'), FailureHandling.STOP_ON_FAILURE)

        'IS 300 AWD'
        expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 19)

        textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

        WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
    }
}

if (WebUI.verifyGreaterThan(pageWidth, '1204', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Compare CTA - desktop'), 0)

    WebUI.click(findTestObject('ModelPages/Styles/Compare CTA - desktop'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('ModelPages/InformationLayer/first category'), 0)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/MSRP - first trim'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/InformationLayer/MSRP - first trim'), FailureHandling.STOP_ON_FAILURE)

    'IS 300'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 17)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/MSRP - second trim'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/InformationLayer/MSRP - second trim'), FailureHandling.STOP_ON_FAILURE)

    'IS 300 AWD'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 19)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/MSRP - third trim'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/InformationLayer/MSRP - third trim'), FailureHandling.STOP_ON_FAILURE)

    'IS 350 F SPORT'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 21)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/MSRP - fourth trim'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/InformationLayer/MSRP - fourth trim'), FailureHandling.STOP_ON_FAILURE)

    'IS 350 F SPORT AWD'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 23)

    textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

    WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

