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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

previousFeedData = findTestData('log').getValue(1, 1)

not_run: response = WS.sendRequest(findTestObject('LOD staging'))

not_run: WS.verifyResponseStatusCode(response, 200)

not_run: WS.verifyElementPropertyValue(response, 'offers.Atlanta[0].offerType', 'lease')

not_run: currentFeedData = WS.getElementPropertyValue(response, 'offers.Atlanta[15].endDate')

currentFeedData = WS.sendRequest(findTestObject('assets version')).getResponseText()

WebUI.verifyMatch(currentFeedData, previousFeedData, false, FailureHandling.OPTIONAL)

if (WebUI.verifyNotMatch(currentFeedData, previousFeedData, false, FailureHandling.OPTIONAL)) {
    String excelFilePath = 'Data Files/log.xlsx'

    String sheetName = 'Sheet1'

    String textToWrite = currentFeedData

    workbook01 = ExcelKeywords.getWorkbook(excelFilePath)

    sheet01 = ExcelKeywords.getExcelSheet(workbook01, sheetName)

    for (int rowIndex = 2; rowIndex < 5; rowIndex++) {
        ExcelKeywords.setValueToCellByIndex(sheet01, 1, 0, textToWrite)
    }
    
    ExcelKeywords.saveWorkbook(excelFilePath, workbook01)
	
	WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)
	
	WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFSA')
	
	if (WebUI.verifyElementNotPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
		WebUI.refresh()
	}
	
	WebUI.waitForElementPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.waitForElementPresent(findTestObject('FCV/Hero/hero module'), 5, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/Hero/image asset'), 0, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/Hero/model name'), 0, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/Hero/model tag'), 0, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/Hero/disclaimer'), 0, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/Hero/headline'), 0, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/Hero/subhead - body copy'), 0, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/Hero/Stay Informed button'), 0, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/lf-1-limitless')
	
	if (WebUI.verifyElementNotPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
		WebUI.refresh()
	}
	
	WebUI.waitForElementPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/Hero/Stay Informed button'), 5)
	
	WebUI.verifyElementNotPresent(findTestObject('FCV/SignupForm/form overlay'), 0)
	
	WebUI.click(findTestObject('FCV/Hero/Stay Informed button'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/SignupForm/form overlay'), 0)
	
	WebUI.click(findTestObject('FCV/SignupForm/close button'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementNotPresent(findTestObject('FCV/SignupForm/form overlay'), 0)
	
	WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LF-30-Electrified')
	
	if (WebUI.verifyElementNotPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
		WebUI.refresh()
	}
	
	WebUI.waitForElementPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.waitForPageLoad(0)
	
	WebUI.scrollToElement(findTestObject('FCV/Gallery/gallery module'), 5)
	
	WebUI.verifyElementNotPresent(findTestObject('FCV/Gallery/visible slide 1'), 5)
	
	WebUI.click(findTestObject('FCV/Gallery/thumb 1'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyElementPresent(findTestObject('FCV/Gallery/visible slide 1'), 5)
	
	WebUI.click(findTestObject('FCV/Gallery/exit button'))
	
	WebUI.verifyElementNotPresent(findTestObject('FCV/Gallery/visible slide 1'), 5)
	
	WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFFC')
	
	if (WebUI.verifyElementNotPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
		WebUI.refresh()
	}
	
	WebUI.waitForElementPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5, FailureHandling.STOP_ON_FAILURE)
	
	subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 1 subtag'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('FCV/Promo/model card 1'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.waitForPageLoad(0)
	
	WebUI.verifyTextPresent(subtagText, false)
	
	WebUI.back()
	
	WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5)
	
	subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 2 subtag'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('FCV/Promo/model card 2'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.waitForPageLoad(0)
	
	WebUI.verifyTextPresent(subtagText, false)
	
	WebUI.back()
	
	WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5)
	
	subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 3 subtag'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('FCV/Promo/model card 3'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.waitForPageLoad(0)
	
	WebUI.verifyTextPresent(subtagText, false)
	
	WebUI.back()
	
	WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5)
	
	subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 4 subtag'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('FCV/Promo/model card 4'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.waitForPageLoad(0)
	
	WebUI.verifyTextPresent(subtagText, false)
	
	WebUI.back()
	
	WebUI.scrollToElement(findTestObject('FCV/Promo/promo module'), 5)
	
	subtagText = WebUI.getText(findTestObject('FCV/Promo/model card 5 subtag'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('FCV/Promo/model card 5 subtag'), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.waitForPageLoad(0)
	
	WebUI.verifyTextPresent(subtagText, false)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

