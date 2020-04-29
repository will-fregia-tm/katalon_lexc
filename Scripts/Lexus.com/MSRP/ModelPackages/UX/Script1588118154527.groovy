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

WebUI.openBrowser(GlobalVariable.TS_Domain + '/models/UX/packages')

WebUI.scrollToElement(findTestObject('MSRP/global objects/UX-UXh/UX 200 FWD - starting at price'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/global objects/UX-UXh/UX 200 FWD - starting at price'))

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/model pages/packages/UX-UXh/UX 200 - vehicle shown price'))

WebUI.scrollToElement(findTestObject('MSRP/global objects/UX-UXh/UX 200 Luxury FWD - starting at price'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/global objects/UX-UXh/UX 200 Luxury FWD - starting at price'))

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/model pages/packages/UX-UXh/UX 200 Luxury - vehicle shown price'))

WebUI.scrollToElement(findTestObject('MSRP/global objects/UX-UXh/UX 250h AWD - starting at price'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/global objects/UX-UXh/UX 250h AWD - starting at price'))

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/model pages/packages/UX-UXh/UX 250h - vehicle shown price'))

WebUI.scrollToElement(findTestObject('MSRP/global objects/UX-UXh/UX 250h Luxury AWD - starting at price'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/global objects/UX-UXh/UX 250h Luxury AWD - starting at price'))

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/model pages/packages/UX-UXh/UX 250h Luxury - vehicle shown price'))

WebUI.scrollToElement(findTestObject('MSRP/global objects/UX-UXh/UX 200 F Sport FWD - starting at price'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/global objects/UX-UXh/UX 200 F Sport FWD - starting at price'))

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/model pages/packages/UX-UXh/UX 200 F Sport - vehicle shown price'))

WebUI.scrollToElement(findTestObject('MSRP/global objects/UX-UXh/UX 250h F Sport AWD - starting at price'), 0)

WebUI.verifyElementVisible(findTestObject('MSRP/global objects/UX-UXh/UX 250h F Sport AWD - starting at price'))

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/model pages/packages/UX-UXh/UX 250h F Sport - vehicle shown price'))

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
	WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
	WebUI.executeJavaScript('sauce:job-result=failed', [])
}
