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

WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Hero/hero'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Hero/image'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Hero/model name - LC Convertible'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Hero/model year - 2021'), 0, FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/disclaimer'), 0, FailureHandling.STOP_ON_FAILURE)

pageWidth = WebUI.getPageWidth(FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/starting at MSRP'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/as shown MSRP'), 0, FailureHandling.OPTIONAL)
}

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/sub-header text'), 0, FailureHandling.OPTIONAL)) {
    }
    
    WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/starting at MSRP'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/as shown MSRP'), 0, FailureHandling.OPTIONAL)
}

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/CTA4'), 5, FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA3'), 5, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementClickable(findTestObject('ModelPages/Hero/CTA3'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Hero/CTA3'), FailureHandling.OPTIONAL)

    WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_LCC, FailureHandling.OPTIONAL)
}

if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA2'), 5, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementClickable(findTestObject('ModelPages/Hero/CTA2'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Hero/CTA2'), FailureHandling.OPTIONAL)

    WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_LCC, FailureHandling.OPTIONAL)
}

if (WebUI.verifyElementPresent(findTestObject('ModelPages/Hero/CTA1'), 5, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementClickable(findTestObject('ModelPages/Hero/CTA1'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Hero/CTA1'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForPageLoad(0, FailureHandling.OPTIONAL)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

