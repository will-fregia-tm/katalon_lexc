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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_UX)

WebUI.waitForPageLoad(0)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Styles/trim 2 link'), 0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Styles/trim 2 link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Styles/Compare CTA - desktop'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('ModelPages/InformationLayer/first category'), 0)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/first category'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/InformationLayer/second category'), 0)

    activeHighlight = WebUI.getCSSValue(findTestObject('ModelPages/InformationLayer/column 2'), 'background', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(activeHighlight, '5px solid rgb(182, 161, 113)', false, FailureHandling.OPTIONAL)

    not_run: WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/column 2 after element'), 0, FailureHandling.OPTIONAL)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

