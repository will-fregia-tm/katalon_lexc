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


WebUI.openBrowser('', FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/compare/ES/competitor/71198362020', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 01'),
	0)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 01'), FailureHandling.OPTIONAL)

sedansModelSeries01text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 01 trims'),
	FailureHandling.OPTIONAL)

sedansModelSeries01textMissing = ''

if (WebUI.verifyMatch(sedansModelSeries01textMissing, sedansModelSeries01text, false, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 01'), FailureHandling.OPTIONAL)

	sedansModelSeries01text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 01 trims'),
		FailureHandling.OPTIONAL)
}

if (WebUI.verifyMatch(sedansModelSeries01textMissing, sedansModelSeries01text, false, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 01'), FailureHandling.OPTIONAL)

	sedansModelSeries01text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 01 trims'),
		FailureHandling.OPTIONAL)
}

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 02'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 02'), FailureHandling.OPTIONAL)

sedansModelSeries02text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 02 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 03'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 03'), FailureHandling.OPTIONAL)

sedansModelSeries03text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 03 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 04'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 04'), FailureHandling.OPTIONAL)

sedansModelSeries04text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 04 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 05'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 05'), FailureHandling.OPTIONAL)

sedansModelSeries05text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 05 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 06'), 0, FailureHandling.OPTIONAL)

sedansModelSeries06text = ''

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 06'), FailureHandling.OPTIONAL)

sedansModelSeries06text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 06 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 07'), 0, FailureHandling.OPTIONAL)

sedansModelSeries07text = ''

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - add vehicle CTA 07'), FailureHandling.OPTIONAL)

sedansModelSeries07text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans - model series 07 trims'),
	FailureHandling.OPTIONAL)

sedansTrimText = ((((((sedansModelSeries01text + sedansModelSeries02text) + sedansModelSeries03text) + sedansModelSeries04text) +
sedansModelSeries05text) + sedansModelSeries06text) + sedansModelSeries07text)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 01'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - add vehicle CTA 01'), FailureHandling.OPTIONAL)

SUVsModelSeries01text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 01 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 02'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - add vehicle CTA 02'), FailureHandling.OPTIONAL)

SUVsModelSeries02text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 02 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 03'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - add vehicle CTA 03'), FailureHandling.OPTIONAL)

SUVsModelSeries03text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 03 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 04'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - add vehicle CTA 04'), FailureHandling.OPTIONAL)

SUVsModelSeries04text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 04 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 05'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - add vehicle CTA 05'), FailureHandling.OPTIONAL)

SUVsModelSeries05text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 05 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 06'), 0, FailureHandling.OPTIONAL)

SUVsModelSeries06text = ''

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - add vehicle CTA 06'), FailureHandling.OPTIONAL)

SUVsModelSeries06text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 06 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 07'), 0, FailureHandling.OPTIONAL)

SUVsModelSeries07text = ''

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - add vehicle CTA 07'), FailureHandling.OPTIONAL)

SUVsModelSeries07text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 07 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 08'), 0, FailureHandling.OPTIONAL)

SUVsModelSeries08text = ''

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - add vehicle CTA 08'), FailureHandling.OPTIONAL)

SUVsModelSeries08text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs - model series 08 trims'),
	FailureHandling.OPTIONAL)

SUVsTrimText = (((((((SUVsModelSeries01text + SUVsModelSeries02text) + SUVsModelSeries03text) + SUVsModelSeries04text) +
SUVsModelSeries05text) + SUVsModelSeries06text) + SUVsModelSeries07text) + SUVsModelSeries08text)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - model series 01'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - add vehicle CTA 01'), FailureHandling.OPTIONAL)

coupesModelSeries01text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - model series 01 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - model series 02'), 0, FailureHandling.OPTIONAL)

coupesModelSeries02text = ''

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - add vehicle CTA 02'), FailureHandling.OPTIONAL)

coupesModelSeries02text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - model series 02 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - model series 03'), 0, FailureHandling.OPTIONAL)

coupesModelSeries03text = ''

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - add vehicle CTA 03'), FailureHandling.OPTIONAL)

coupesModelSeries03text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - model series 03 trims'),
	FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - model series 04'), 0, FailureHandling.OPTIONAL)

coupesModelSeries04text = ''

WebUI.click(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - add vehicle CTA 04'), FailureHandling.OPTIONAL)

coupesModelSeries04text = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes - model series 04 trims'),
	FailureHandling.OPTIONAL)

coupesTrimText = (((coupesModelSeries01text + coupesModelSeries02text) + coupesModelSeries03text) + coupesModelSeries04text)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/any sedan'), 0)

WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/any SUV'), 0)

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/sedans/sedans'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/IS'), 0, FailureHandling.OPTIONAL)) {
	'IS 300 RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 17)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'IS 300 AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 19)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'IS 350 RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 21)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'IS 350 AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 23)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'IS 300 F Sport RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 18)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'IS 300 F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 20)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'IS 350 F Sport RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 22)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'IS 350 F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 24)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/ES'), 0, FailureHandling.OPTIONAL)) {
	'ES 350'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 10)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'ES 350 F Sport'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 16)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'ES 350 Luxury'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 11)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'ES 350 Ultra Luxury'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 12)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'ES 300h'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 13)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'ES 300h Luxury'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 14)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'ES 300h Ultra Luxury'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 15)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/ES'), 0, FailureHandling.OPTIONAL)) {
	'ES 300h'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 13)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/GS'), 0, FailureHandling.OPTIONAL)) {
	'GS 350 AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 67)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'GS 350 RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 66)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'GS 350 F Sport RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 68)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'GS 350 F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 69)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/GS F'), 0, FailureHandling.OPTIONAL)) {
	'GS F'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 79)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/LS'), 0, FailureHandling.OPTIONAL)) {
	'LS 500 RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 45)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'LS 500 AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 46)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'LS 500 F Sport RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 47)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'LS 500 F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 48)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'LS 500h RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 49)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'LS 500h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 50)

	sedansTrimTextWithoutExpectedMSRP = (sedansTrimText - expectedMSRP)

	WebUI.verifyNotMatch(sedansTrimTextWithoutExpectedMSRP, sedansTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/LS'), 0, FailureHandling.OPTIONAL)) {
	'LS 500h RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 49)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/SUVs/SUVs'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/UX'), 0, FailureHandling.OPTIONAL)) {
	'UX 200 FWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 73)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'UX 200 F Sport FWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 77)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'UX 200 Luxury FWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 74)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'UX 250h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 75)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'UX 250h F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 78)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'UX 250h Luxury AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 76)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/UX'), 0, FailureHandling.OPTIONAL)) {
	'UX 250h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 75)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/NX'), 0, FailureHandling.OPTIONAL)) {
	'NX 300 FWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 35)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'NX 300 AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 36)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'NX 300 F Sport FWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 37)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'NX 300 F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 38)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'NX 300 Luxury FWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 39)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'NX 300 Luxury AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 40)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'NX 300h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'NX 300h Luxury AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 42)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/NX'), 0, FailureHandling.OPTIONAL)) {
	'NX 300h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/RX'), 0, FailureHandling.OPTIONAL)) {
	'RX 350 FWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 55)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RX 350 AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 56)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RX 350 F Sport FWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 59)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RX 350 F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 60)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RX 350L FWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 57)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RX 350L AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 58)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RX 450h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 61)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RX 450h F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 63)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RX 450hL AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 62)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/RX'), 0, FailureHandling.OPTIONAL)) {
	'RX 450h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 61)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/GX'), 0, FailureHandling.OPTIONAL)) {
	'GX 460'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 29)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'GX 460 Premium'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 30)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'GX 460 Luxury'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 31)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/LX'), 0, FailureHandling.OPTIONAL)) {
	'LX 570 Two-Row'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 32)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'LX 570 Three-Row'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 33)

	SUVsTrimTextWithoutExpectedMSRP = (SUVsTrimText - expectedMSRP)

	WebUI.verifyNotMatch(SUVsTrimTextWithoutExpectedMSRP, SUVsTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/coupes/coupes'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/RC'), 0, FailureHandling.OPTIONAL)) {
	'RC 300 RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 2)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RC 300 AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 4)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RC 300 F Sport RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 3)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RC 300 F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 5)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RC 350 RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 6)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RC 350 AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 8)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RC 350 F Sport RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 7)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RC 350 F Sport AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 9)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/RC F'), 0, FailureHandling.OPTIONAL)) {
	'RC F'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 53)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'RC F Track Edition'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 54)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/LC'), 0, FailureHandling.OPTIONAL)) {
	'LC'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)

	'LC Hybrid'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

	coupesTrimTextWithoutExpectedMSRP = (coupesTrimText - expectedMSRP)

	WebUI.verifyNotMatch(coupesTrimTextWithoutExpectedMSRP, coupesTrimText, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/LC'), 0, FailureHandling.OPTIONAL)) {
	'LC Hybrid'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/hybrids/hybrids'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/UX'), 0, FailureHandling.OPTIONAL)) {
	'UX 250h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 75)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/NX'), 0, FailureHandling.OPTIONAL)) {
	'NX 300h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 41)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/RX'), 0, FailureHandling.OPTIONAL)) {
	'RX 450h AWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 61)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/ES'), 0, FailureHandling.OPTIONAL)) {
	'ES 300h'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 13)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/LS'), 0, FailureHandling.OPTIONAL)) {
	'LS 500h RWD'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 49)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/LC'), 0, FailureHandling.OPTIONAL)) {
	'LC Hybrid'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

textWithMSRP = WebUI.getText(findTestObject('MSRP/section objects/compare/trim pages/performance/performance'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/RC F'), 0, FailureHandling.OPTIONAL)) {
	'RC F'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 53)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/GS F'), 0, FailureHandling.OPTIONAL)) {
	'GS F'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 79)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/LC'), 0, FailureHandling.OPTIONAL)) {
	'LC'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 70)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementPresent(findTestObject('MSRP/section objects/compare/trim pages/active models/LC'), 0, FailureHandling.OPTIONAL)) {
	'LC Hybrid'
	expectedMSRP = findTestData(GlobalVariable.DS_version + 'MSRPs').getValue(4, 71)

	textWithoutExpectedMSRP = (textWithMSRP - expectedMSRP)

	WebUI.verifyNotMatch(textWithoutExpectedMSRP, textWithMSRP, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
	WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
	WebUI.executeJavaScript('sauce:job-result=failed', [])
}
