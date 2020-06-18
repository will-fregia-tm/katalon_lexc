import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Compare)

if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.navigateToUrl(GlobalVariable.SC_Domain)

WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

WebUI.scrollToElement(findTestObject('HomePage/ShoppingTools/shopping tools - heading'), 0)

WebUI.verifyElementVisibleInViewport(findTestObject('HomePage/ShoppingTools/shopping tools - heading'), 0)

WebUI.verifyElementVisibleInViewport(findTestObject('HomePage/ShoppingTools/BYL link image'), 0)

WebUI.verifyElementVisibleInViewport(findTestObject('HomePage/ShoppingTools/BYL link text'), 0)

WebUI.verifyElementVisibleInViewport(findTestObject('HomePage/ShoppingTools/FAD link image'), 0)

WebUI.verifyElementVisibleInViewport(findTestObject('HomePage/ShoppingTools/FAD link text'), 0)

WebUI.verifyElementVisibleInViewport(findTestObject('HomePage/ShoppingTools/Offers link image'), 0)

WebUI.verifyElementVisibleInViewport(findTestObject('HomePage/ShoppingTools/Offers link text'), 0)

WebUI.verifyElementVisibleInViewport(findTestObject('HomePage/ShoppingTools/Compare link image'), 0)

WebUI.verifyElementVisibleInViewport(findTestObject('HomePage/ShoppingTools/Compare link text'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

