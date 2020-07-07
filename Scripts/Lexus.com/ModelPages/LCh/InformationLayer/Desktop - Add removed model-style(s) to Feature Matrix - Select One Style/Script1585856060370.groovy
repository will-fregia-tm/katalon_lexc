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

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Overview_NXh)

WebUI.waitForPageLoad(0)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('ModelPages/Styles/styles module'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/Styles/Compare CTA - desktop'), 0)

    WebUI.click(findTestObject('ModelPages/Styles/Compare CTA - desktop'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('ModelPages/InformationLayer/trim heading - LC 500'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/trim heading - LC 500'), 0)

    WebUI.waitForElementPresent(findTestObject('ModelPages/InformationLayer/remove CTA - first column'), 0)

    WebUI.click(findTestObject('ModelPages/InformationLayer/remove CTA - first column'), FailureHandling.OPTIONAL)

    WebUI.waitForElementNotPresent(findTestObject('ModelPages/InformationLayer/trim heading - LC 500'), 0)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/InformationLayer/trim heading - LC 500'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/add feature option'), 0)

    WebUI.click(findTestObject('ModelPages/InformationLayer/add feature option'), FailureHandling.OPTIONAL)

    WebUI.waitForElementPresent(findTestObject('ModelPages/InformationLayer/add style CTA - first trim'), 0)

    WebUI.click(findTestObject('ModelPages/InformationLayer/add style CTA - first trim'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('ModelPages/InformationLayer/apply button'))

    WebUI.waitForElementPresent(findTestObject('ModelPages/InformationLayer/trim heading - LC 500'), 0)

    WebUI.verifyElementPresent(findTestObject('ModelPages/InformationLayer/trim heading - LC 500'), 0)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

