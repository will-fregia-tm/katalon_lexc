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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/models/NX-hybrid')

WebUI.scrollToElement(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 FWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 FWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 AWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 - vehicle shown price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/trims - NX 300 FWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300h AWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300h AWD - vehicle shown price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/trims - NX 300h AWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 F Sport FWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 F Sport AWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 F Sport  - vehicle shown price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/trims - NX 300 F Sport FWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 FWD Luxury - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 AWD Luxury - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300 Luxury - vehicle shown price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/trims - NX 300 FWD Luxury - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300h AWD Luxury - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/details - NX 300h AWD Luxury - vehicle shown price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/trims - NX 300h AWD Luxury - starting at price'),
	0)

WebUI.scrollToElement(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/compare table - NX 300 AWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/compare table - NX 300 AWD - starting at price'),
	0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/model pages/overview/NX-NXh/compare table - NX 300h AWD - starting at price'),
	0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
	WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
	WebUI.executeJavaScript('sauce:job-result=failed', [])
}