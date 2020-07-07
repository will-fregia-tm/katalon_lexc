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

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Overview_NXh)

WebUI.waitForPageLoad(0)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Compare CTA - desktop'), 0)

    WebUI.click(findTestObject('ModelPages/Styles/Compare CTA - desktop'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/legend'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/standard icon'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/standard label'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/package icon'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/package label'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/options icon'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/options label'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/InformationLayer/second category button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('ModelPages/InformationLayer/second category'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/legend'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/standard icon'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/standard label'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/package icon'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/package label'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/options icon'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/InformationLayer/options label'), 0, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

