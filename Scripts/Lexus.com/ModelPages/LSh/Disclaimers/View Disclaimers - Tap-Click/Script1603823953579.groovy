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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_LSh)

WebUI.waitForPageLoad(0)

WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), 0)

WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

not_run: pageWidth = WebUI.getPageWidth()

not_run: if (WebUI.verifyGreaterThan(pageWidth, '1025', FailureHandling.OPTIONAL)) {
    WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

    WebUI.verifyElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), FailureHandling.STOP_ON_FAILURE)
}

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: if (WebUI.verifyGreaterThan(pageWidth, '1025', FailureHandling.OPTIONAL)) {
    not_run: WebUI.scrollToElement(findTestObject('ModelPages/Visualizer/visualizer'), 0)

    not_run: WebUI.click(findTestObject('ModelPages/Visualizer/interior swatches'))

    not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/visualizer disclaimer asterisk'), 0)

    not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/visualizer disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/visualizer disclaimer text'), 0)

    not_run: WebUI.verifyElementVisible(findTestObject('ModelPages/Disclaimers/visualizer disclaimer text'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/visualizer disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/visualizer disclaimer text'), 0)

    not_run: WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

    not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/styles disclaimer asterisk'), 0)

    not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/styles disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/styles disclaimer text'), 0)

    not_run: WebUI.verifyElementVisible(findTestObject('ModelPages/Disclaimers/styles disclaimer text'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/styles disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/styles disclaimer text'), 0)

    not_run: WebUI.scrollToElement(findTestObject('ModelPages/Design/design module'), 0)

    not_run: WebUI.click(findTestObject('ModelPages/Design/more features CTA'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/design disclaimer asterisk'), 0)

    not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/design disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/design disclaimer text'), 0)

    not_run: WebUI.verifyElementVisible(findTestObject('ModelPages/Disclaimers/design disclaimer text'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/design disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/design disclaimer text'), 0)
}

not_run: if (WebUI.verifyLessThan(pageWidth, '1025', FailureHandling.OPTIONAL)) {
    not_run: WebUI.scrollToElement(findTestObject('ModelPages/Visualizer/visualizer'), 0)

    not_run: WebUI.click(findTestObject('ModelPages/Visualizer/interior swatches'))

    not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/visualizer disclaimer asterisk'), 0)

    not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/visualizer disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)
}

not_run: WebUI.scrollToElement(findTestObject('ModelPages/Gallery/gallery module'), 0)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: WebUI.scrollToElement(findTestObject('ModelPages/Design/technology module'), 0)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: WebUI.scrollToElement(findTestObject('ModelPages/Design/performance module'), 0)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: WebUI.scrollToElement(findTestObject('ModelPages/Offers/offers module'), 0)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: WebUI.scrollToElement(findTestObject('ModelPages/Overlay/special edition module'), 0)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer asterisk'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementVisible(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

not_run: WebUI.click(findTestObject('ModelPages/Disclaimers/hero disclaimer close button'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementNotPresent(findTestObject('ModelPages/Disclaimers/hero disclaimer text'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

