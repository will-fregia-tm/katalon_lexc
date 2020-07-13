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

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Compare CTA - desktop'), 0)

    WebUI.click(findTestObject('ModelPages/Styles/Compare CTA - desktop'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('ModelPages/InformationLayer/second category button'), 0)

    WebUI.scrollToElement(findTestObject('ModelPages/InformationLayer/second category button'), 0)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/InformationLayer/second category'), 0)

    iconClassCollapsed = WebUI.getAttribute(findTestObject('ModelPages/InformationLayer/second category accordion icon'), 
        'class', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/InformationLayer/second category button'), FailureHandling.STOP_ON_FAILURE)

    iconClassExpanded = WebUI.getAttribute(findTestObject('ModelPages/InformationLayer/second category accordion icon'), 
        'class', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyNotMatch(iconClassCollapsed, iconClassExpanded, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/second category'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/second category feature 1'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/second category feature 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/second category feature 1 availability icon 1'), 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisible(findTestObject('ModelPages/InformationLayer/second category feature 1 availability icon 2'), 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/InformationLayer/second category button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/InformationLayer/second category'), 0)

    iconClassCollapsed = WebUI.getAttribute(findTestObject('ModelPages/InformationLayer/second category accordion icon'), 
        'class', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyNotMatch(iconClassCollapsed, iconClassExpanded, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/InformationLayer/second category button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('ModelPages/InformationLayer/third category button'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/InformationLayer/third category button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/third category'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('ModelPages/InformationLayer/second category'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/second category'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('ModelPages/InformationLayer/first category'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/first category'), 0, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

