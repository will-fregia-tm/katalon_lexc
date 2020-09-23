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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_NX)

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('ModelPages/Technology/technology module'), 0)

WebUI.waitForElementVisible(findTestObject('ModelPages/Technology/more features CTA'), 0)

WebUI.click(findTestObject('ModelPages/Technology/more features CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Technology/feature 1'), 0)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    if (WebUI.verifyElementPresent(findTestObject('ModelPages/Technology/feature 6'), 0, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Technology/carousel next button'), 0)

        WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Technology/carousel previous button'), 0)

        WebUI.click(findTestObject('ModelPages/Technology/carousel next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Technology/feature 6'), 0)

        WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Technology/carousel previous button'), 0)

        WebUI.click(findTestObject('ModelPages/Technology/carousel previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Technology/feature 1'), 0)

        WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Technology/carousel next button'), 0)

        WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Technology/carousel previous button'), 0)
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

