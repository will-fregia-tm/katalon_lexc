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

WebUI.openBrowser((GlobalVariable.TS_Domain + GlobalVariable.Overview_LCC) + '/design')

WebUI.waitForPageLoad(0)

WebUI.verifyElementVisibleInViewport(findTestObject('ModelPages/Design/design module'), 0)

WebUI.waitForElementVisible(findTestObject('ModelPages/Design/more features CTA'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ModelPages/Design/first story link - selected'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Design/second story link - selected'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('ModelPages/Design/first story headline'))

WebUI.verifyElementVisible(findTestObject('ModelPages/Design/first story body copy'))

WebUI.verifyElementPresent(findTestObject('ModelPages/Design/story image'), 0, FailureHandling.STOP_ON_FAILURE)

'if there is no image visible, then video should be present'
if (WebUI.verifyElementNotVisible(findTestObject('ModelPages/Design/story image'), FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('ModelPages/Design/story video'), 0)
}

WebUI.verifyElementVisible(findTestObject('ModelPages/Design/more features CTA'), FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

