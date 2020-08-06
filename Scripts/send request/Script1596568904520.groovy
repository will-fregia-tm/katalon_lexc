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

String excelFilePath = 'Data Files/log.xlsx'

String sheetName = 'Sheet1'

String textToWrite = currentFeedData

workbook01 = ExcelKeywords.getWorkbook(excelFilePath)

sheet01 = ExcelKeywords.getExcelSheet(workbook01, sheetName)

for (int rowIndex = 2; rowIndex < 5; rowIndex++) {
    ExcelKeywords.setValueToCellByIndex(sheet01, 1, 0, textToWrite)
}

ExcelKeywords.saveWorkbook(excelFilePath, workbook01)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

