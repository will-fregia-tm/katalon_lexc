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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_UXh)

WebUI.waitForPageLoad(0)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style tab 1'), 0)

    selectedState = WebUI.getAttribute(findTestObject('ModelPages/Styles/model-style tab 1'), 'aria-selected')

    WebUI.verifyMatch(selectedState, 'true', false)

    unselectedState = WebUI.getAttribute(findTestObject('ModelPages/Styles/model-style tab 2'), 'aria-selected')

    WebUI.verifyMatch(unselectedState, 'false', false)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/base model-style specific jelly - desktop'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style tab 1'), 0)

    selectedState = WebUI.getAttribute(findTestObject('ModelPages/Styles/model-style tab 1'), 'aria-selected')

    WebUI.verifyMatch(selectedState, 'true', false)

    WebUI.click(findTestObject('ModelPages/Styles/model-style tab 2'), FailureHandling.STOP_ON_FAILURE)

    selectedState = WebUI.getAttribute(findTestObject('ModelPages/Styles/model-style tab 2'), 'aria-selected')

    WebUI.verifyMatch(selectedState, 'true', false)

    unselectedState = WebUI.getAttribute(findTestObject('ModelPages/Styles/model-style tab 1'), 'aria-selected')

    WebUI.verifyMatch(unselectedState, 'false', false)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/non-base model-style specific jelly - desktop'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style tab 1'), 0)

    unselectedState = WebUI.getAttribute(findTestObject('ModelPages/Styles/model-style tab 1'), 'aria-selected')

    WebUI.verifyMatch(unselectedState, 'false', false)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

