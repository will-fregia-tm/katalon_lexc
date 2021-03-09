import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

class BeforeTest {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseVariables()
		GlobalVariable.currentTestCaseID = testCaseContext.getTestCaseId()
		def modelSeries = GlobalVariable.currentTestCaseID //get current testcase name
		String[] parts = modelSeries.split("/"); //split it to using delimeter /
		String three = parts[parts.length-3];
		modelSeries = three
		String excelFilePath = '../testData.xlsx'
		String sheetName = 'modelData'
		String textToWrite = modelSeries
		def workbook01 = ''
		def sheet01 = ''
		workbook01 = ExcelKeywords.getWorkbook(excelFilePath)
		sheet01 = ExcelKeywords.getExcelSheet(workbook01, sheetName)
		
		for (int rowIndex = 2; rowIndex < 5; rowIndex++) {
        ExcelKeywords.setValueToCellByIndex(sheet01, 0, 0, textToWrite)}
		ExcelKeywords.saveWorkbook(excelFilePath, workbook01)
	}
}