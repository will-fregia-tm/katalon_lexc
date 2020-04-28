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

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/?personalization_id=inmarket_rx&audience=inmarket&campaign_vehicle_model=RX')

WebUI.waitForElementPresent(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Sedans'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/categories/Sedans'), 0)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Sedans - IS'), 0)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - IS'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 17)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - IS starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - ES'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ES starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ES starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ES vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 10)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ES starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - ESh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ESh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ESh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ESh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 13)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - ESh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - GS'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 67)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - GS F'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS F starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS F starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS F vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 79)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - GS F starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - LS'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LS starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LS starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LS vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 45)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LS starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Sedans - LSh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LSh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LSh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LSh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 49)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - sedans - LSh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/SUVs'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/categories/SUVs'), 0)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/SUVs - UX'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - UX'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UX starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UX starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UX vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 73)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UX starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - UXh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UXh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UXh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UXh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 75)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - UXh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - NX'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NX starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NX starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NX vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 35)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NX starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - NXh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NXh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NXh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NXh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - NXh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - RX'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RX starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RX starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RX vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 55)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RX starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - RXh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RXh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RXh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RXh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 61)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - RXh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - GX'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - GX starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - GX starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - GX vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 29)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - GX starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/SUVs - LX'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - LX starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - LX starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - LX vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 32)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - SUVs - LX starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Coupes'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/categories/Coupes'), 0)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Coupes - RC'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - RC'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 2)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - RC F'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC F starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC F starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC F vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 53)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - RC F starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - LC'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LC starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LC starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LC vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LC starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Coupes - LCh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LCh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LCh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LCh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - coupes - LCh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Hybrids'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/categories/Hybrids'), 0)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Hybrids - UXh'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - UXh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - UXh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - UXh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - UXh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 75)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - UXh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - NXh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - NXh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - NXh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - NXh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - NXh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - RXh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - RXh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - RXh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - RXh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 61)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - RXh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - ESh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - ESh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - ESh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - ESh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 13)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - ESh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - LSh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LSh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LSh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LSh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 49)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LSh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Hybrids - LCh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LCh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LCh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LCh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - hybrids - LCh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Performance'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/categories/Performance'), 0)

WebUI.waitForElementVisible(findTestObject('HomePage/VehicleSelector/models/Performance - RC F'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - RC F'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - RC F starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - RC F starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - RC F vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 53)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - RC F starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - GS F'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - GS F starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - GS F starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - GS F vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 79)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - GS F starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - LC'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LC starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LC starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LC vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LC starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelector/models/Performance - LCh'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LCh starting at price'),
	0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LCh starting at price'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LCh vehicle shown price'),
	FailureHandling.CONTINUE_ON_FAILURE)

expectedMSRP = (('$' + findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)) + '*')

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/homepage/vehicle selector/vehicle selector - performance - LCh starting at price'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(textWithMSRP, expectedMSRP, false, FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
	WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
	WebUI.executeJavaScript('sauce:job-result=failed', [])
}