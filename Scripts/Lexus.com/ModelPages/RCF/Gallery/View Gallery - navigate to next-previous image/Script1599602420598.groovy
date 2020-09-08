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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_RCF)

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('ModelPages/Gallery/gallery module'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/active secondary image 1'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/pagination 2'), 0)

not_run: WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Gallery/image description 1'), 0, FailureHandling.OPTIONAL)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Gallery/right image button - mobile'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/active secondary image 1'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/pagination 2'), 0)

    not_run: WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Gallery/image description 2'), 0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Gallery/left image button - mobile'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/active secondary image 1'), 0)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/pagination 2'), 0)
}

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Gallery/carousel tab - right'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/active secondary image 1'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/pagination 2'), 0)

    not_run: WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Gallery/image description 2'), 0, FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/Gallery/carousel tab - left'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/active secondary image 1'), 0)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/pagination 2'), 0)

    WebUI.click(findTestObject('ModelPages/Gallery/right image button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/active secondary image 1'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/pagination 2'), 0)

    WebUI.click(findTestObject('ModelPages/Gallery/left image button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/active secondary image 1'), 0)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/pagination 2'), 0)

    WebUI.click(findTestObject('ModelPages/Gallery/carousel tab - left'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/pagination 1'), 0)

    WebUI.click(findTestObject('ModelPages/Gallery/carousel tab - left'), FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

