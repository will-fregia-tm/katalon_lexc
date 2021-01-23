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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Overview_LCC)

WebUI.waitForPageLoad(0)

WebUI.waitForElementPresent(findTestObject('ModelPages/Overlay/special edition module'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('ModelPages/Overlay/special edition module'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Overlay/overlay CTA'), FailureHandling.OPTIONAL)

WebUI.delay(2)

if (WebUI.verifyElementPresent(findTestObject('ModelPages/Overlay/overlay MSRP'), 0, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementVisible(findTestObject('ModelPages/Overlay/overlay MSRP'), FailureHandling.STOP_ON_FAILURE)

    textWithMSRP = WebUI.getText(findTestObject('ModelPages/Overlay/overlay MSRP'), FailureHandling.STOP_ON_FAILURE)

    'LC CONVERTIBLE INSPIRATION SERIES'
    expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 80)

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

