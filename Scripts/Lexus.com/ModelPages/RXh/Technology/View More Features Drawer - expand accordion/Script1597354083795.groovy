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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_RXh)

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('ModelPages/Visualizer/visualizer'), 0)

WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

WebUI.scrollToElement(findTestObject('ModelPages/Gallery/gallery module'), 0)

WebUI.scrollToElement(findTestObject('ModelPages/Performance/performance module'), 0)

WebUI.scrollToElement(findTestObject('ModelPages/Technology/technology module'), 0)

WebUI.verifyElementVisible(findTestObject('ModelPages/Technology/base-small'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Technology/expanded feature'), 0)

WebUI.verifyElementPresent(findTestObject('ModelPages/Technology/more features header'), 0)

WebUI.verifyElementPresent(findTestObject('ModelPages/Technology/expand-collapse caret'), 0)

WebUI.click(findTestObject('ModelPages/Technology/more features CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ModelPages/Technology/expanded feature'), 0)

WebUI.verifyElementVisible(findTestObject('ModelPages/Technology/expanded feature'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('ModelPages/Technology/more features header'))

WebUI.verifyElementVisible(findTestObject('ModelPages/Technology/expand-collapse caret'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Technology/more features CTA'), FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}
