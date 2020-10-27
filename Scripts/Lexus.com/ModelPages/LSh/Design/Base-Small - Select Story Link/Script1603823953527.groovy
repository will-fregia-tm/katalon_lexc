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

WebUI.scrollToElement(findTestObject('ModelPages/Design/design module'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ModelPages/Design/first story link - selected'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ModelPages/Design/first story link - selected'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ModelPages/Design/second story link - unselected'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Design/second story link - selected'), 0)

WebUI.verifyElementPresent(findTestObject('ModelPages/Design/second story link'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Design/second story link'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ModelPages/Design/first story link - unselected'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ModelPages/Design/second story link'), 0)

WebUI.verifyElementPresent(findTestObject('ModelPages/Design/first story link - unselected'), 0)

WebUI.verifyElementVisible(findTestObject('ModelPages/Design/second story link - selected'))

WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Design/second story headline'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Design/second story body copy'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ModelPages/Design/story image'), 0, FailureHandling.STOP_ON_FAILURE)

'if there is no image visible, then video should be present'
if (WebUI.verifyElementNotVisible(findTestObject('ModelPages/Design/story image'), FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('ModelPages/Design/story video'), 0)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

