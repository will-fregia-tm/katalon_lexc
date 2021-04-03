import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords


	modelSeries = 'RC'
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

