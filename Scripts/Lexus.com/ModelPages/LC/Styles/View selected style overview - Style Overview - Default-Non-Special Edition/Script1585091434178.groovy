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

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Overview_LC)

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyGreaterThan(pageWidth, '1204', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/base model-style specific jelly - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style name - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Styles/trim 2 link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style sub-name - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/horizontal bar - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('ModelPages/divider 1'), 0)

    WebUI.click(findTestObject('ModelPages/Styles/trim 1 link'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/background image - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style 1 starting at price - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style feature 1 - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style feature 2 - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style feature 3 - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Compare CTA - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/BYL CTA - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Specs link - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Packages link - desktop'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Accessories link - desktop'), 0, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyLessThan(pageWidth, '1204', FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles heading'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/base model-style specific jelly - mobile'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style name - mobile'), 0)

    not_run: WebUI.scrollToElement(findTestObject('ModelPages/Styles/change style dropdown'), 0)

    WebUI.click(findTestObject('ModelPages/Styles/change style dropdown'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Styles/change style dropdown option 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style sub-name - mobile'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/horizontal bar - mobile'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style 2 feature 1 - mobile'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style 2 feature 2 - mobile'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style 2 feature 3 - mobile'), 0)

    WebUI.click(findTestObject('ModelPages/Styles/option 2 dropdown'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('ModelPages/Styles/option 2 dropdown option 1'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/background image - mobile'), 0)

    if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style 1 starting at price - tablet'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style 1 feature 1 - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style 1 feature 2 - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style 1 feature 3 - mobile'), 0)

        WebUI.scrollToElement(findTestObject('ModelPages/Styles/Compare CTA - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Compare CTA - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/BYL CTA - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Specs link - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Packages link - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Accessories link - mobile'), 0)
    }
    
    if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/model-style 1 starting at price - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style 1 feature 1 - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style 1 feature 2 - mobile'), 0)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/key model-style 1 feature 3 - mobile'), 0)

        WebUI.scrollToElement(findTestObject('ModelPages/Styles/Compare CTA - mobile'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Compare CTA - mobile'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/BYL CTA - mobile'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Specs link - mobile'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Packages link - mobile'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Accessories link - mobile'), 0, FailureHandling.STOP_ON_FAILURE)
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

