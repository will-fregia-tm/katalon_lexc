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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Overview_LC)

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('ModelPages/Gallery/gallery module'), 0)

not_run: WebUI.scrollToElement(findTestObject('ModelPages/Gallery/gallery heading'), 0)

WebUI.verifyElementVisible(findTestObject('ModelPages/Gallery/gallery heading'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/expanded gallery overlay'), 0)

WebUI.waitForElementVisible(findTestObject('ModelPages/Gallery/expand image button'), 0)

WebUI.click(findTestObject('ModelPages/Gallery/expand image button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ModelPages/Gallery/expanded gallery overlay'), 0)

WebUI.click(findTestObject('ModelPages/Gallery/exit button'))

if (WebUI.verifyElementVisible(findTestObject('ModelPages/Gallery/exit button'), FailureHandling.OPTIONAL)) {
    WebUI.focus(findTestObject('ModelPages/Gallery/exit button'))

    WebUI.sendKeys(findTestObject('ModelPages/Gallery/exit button'), Keys.chord(Keys.ENTER))
}

WebUI.verifyElementVisible(findTestObject('ModelPages/Gallery/gallery heading'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Gallery/expanded gallery overlay'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

