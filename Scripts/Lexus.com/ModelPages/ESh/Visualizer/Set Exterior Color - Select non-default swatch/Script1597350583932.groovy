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

WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.Overview_ESh)

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('ModelPages/Visualizer/visualizer'), 0)

pageWidth = WebUI.getPageWidth()

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.waitForElementVisible(findTestObject('ModelPages/Visualizer/image - ultra white - desktop'), 0)
}

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.waitForElementVisible(findTestObject('ModelPages/Visualizer/image - ultra white - mobile'), 0)
}

WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/swatch 1 - highlighted'))

WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/color name - first color'))

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/image - ultra white - desktop'))
}

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/image - first color - mobile'))
}

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/swatch 2 - highlighted'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/color name - second color'), 0)

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - second color - desktop'), 0)
}

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - second color - mobile'), 0)
}

WebUI.click(findTestObject('ModelPages/Visualizer/swatch 2'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.waitForElementVisible(findTestObject('ModelPages/Visualizer/image - second color - desktop'), 0)

    WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/image - second color - desktop'))

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - ultra white - desktop'), 0)
}

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.waitForElementVisible(findTestObject('ModelPages/Visualizer/image - second color - mobile'), 0)

    WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/image - second color - mobile'))

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - ultra white - mobile'), 0)
}

WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/swatch 2 - highlighted'))

WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/color name - second color'))

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/swatch 1 - highlighted'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/color name - first color'), 0)

WebUI.click(findTestObject('ModelPages/Visualizer/swatch 3'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('ModelPages/Visualizer/swatch 1'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/swatch 2 - highlighted'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/color name - second color'), 0)

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - second color - desktop'), 0)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - ultra white - desktop'), 0)
}

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - second color - mobile'), 0)

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - ultra white - mobile'), 0)
}

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/swatch 1 - highlighted'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/color name - first color'), 0)

WebUI.click(findTestObject('ModelPages/Visualizer/swatch 1'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('ModelPages/Visualizer/swatch 2'), 0)

WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/swatch 1 - highlighted'))

WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/color name - first color'))

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/image - ultra white - desktop'))

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - second color - desktop'), 0)
}

if (WebUI.verifyLessThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.verifyElementVisible(findTestObject('ModelPages/Visualizer/image - ultra white - mobile'))

    WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/image - second color - mobile'), 0)
}

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/swatch 2 - highlighted'), 0)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/Visualizer/color name - second color'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

