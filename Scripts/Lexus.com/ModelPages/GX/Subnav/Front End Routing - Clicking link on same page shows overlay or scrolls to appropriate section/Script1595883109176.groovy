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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_GX)

WebUI.waitForPageLoad(0)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Subnav/mobile nav button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('ModelPages/Subnav/design link'), 0)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/design link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/design link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Design/design module'), 0, FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.click(findTestObject('ModelPages/Subnav/mobile nav button'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/styles link'), 0, FailureHandling.OPTIONAL)

    not_run: WebUI.click(findTestObject('ModelPages/Subnav/styles link'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Subnav/mobile nav button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/gallery link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/gallery link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Gallery/gallery module'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/mobile nav button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/technology link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/technology link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Design/technology module'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/mobile nav button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/performance link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/performance link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Design/performance module'), 0)

    not_run: WebUI.click(findTestObject('ModelPages/Subnav/mobile nav button'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/safety link'), 0, FailureHandling.OPTIONAL)

    not_run: WebUI.click(findTestObject('ModelPages/Subnav/safety link'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Subnav/mobile nav button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/offers link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/offers link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Offers/offers module'), 0)
}

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('ModelPages/Subnav/design link'), 0)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/design link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/design link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Design/design module'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/styles link'), 0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Subnav/styles link'), FailureHandling.OPTIONAL)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/gallery link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/gallery link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Gallery/gallery module'), 0)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/technology link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/technology link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Design/technology module'), 0)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/performance link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/performance link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Design/performance module'), 0)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/safety link'), 0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Subnav/safety link'), FailureHandling.OPTIONAL)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Subnav/offers link'), 0)

    WebUI.click(findTestObject('ModelPages/Subnav/offers link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Offers/offers module'), 0)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

