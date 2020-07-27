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

WebUI.scrollToElement(findTestObject('ModelPages/Visualizer/visualizer'), 0)

WebUI.waitForElementVisible(findTestObject('ModelPages/Visualizer/interior swatches'), 0)

WebUI.click(findTestObject('ModelPages/Visualizer/interior swatches'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ModelPages/Visualizer/interior swatch 2'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ModelPages/Visualizer/interior angle 1'), 5, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('ModelPages/Visualizer/angle 1'), 5)

WebUI.verifyElementPresent(findTestObject('ModelPages/Visualizer/interior swatch 2 - highlighted'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/angle 2'), 0)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Visualizer/carousel arrow'), FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ModelPages/Visualizer/carousel button 2'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Visualizer/interior angle 2'), 5, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('ModelPages/Visualizer/angle 2'), 0)

WebUI.verifyElementPresent(findTestObject('ModelPages/Visualizer/interior swatch 2 - highlighted'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

