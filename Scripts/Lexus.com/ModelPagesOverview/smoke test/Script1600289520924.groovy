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

'checks previous build version saved in log for this environment'
previousFeedData = findTestData(GlobalVariable.DS_version + 'Log').getValue(1, 16)

'checks current build version at test URL/endpoint for this environment'
currentFeedData = WS.sendRequest(findTestObject('legacy assets version - ' + GlobalVariable.DS_version)).getResponseText()

'checks to see if current build version matches previous build version for this environment'
WebUI.verifyMatch(currentFeedData, previousFeedData, false, FailureHandling.OPTIONAL)

'if current build version is different, overwrites previous version with new value and launches smoke test'
if (WebUI.verifyNotMatch(currentFeedData, previousFeedData, false, FailureHandling.OPTIONAL)) {
    String excelFilePath = ('Data Files/' + GlobalVariable.DS_version) + 'Log.xlsx'

    String sheetName = 'Sheet1'

    String textToWrite = currentFeedData

    workbook01 = ExcelKeywords.getWorkbook(excelFilePath)

    sheet01 = ExcelKeywords.getExcelSheet(workbook01, sheetName)

    for (int rowIndex = 2; rowIndex < 5; rowIndex++) {
        ExcelKeywords.setValueToCellByIndex(sheet01, 16, 0, textToWrite)
    }
    
    ExcelKeywords.saveWorkbook(excelFilePath, workbook01)

    'counts the total number of URLs to be tested'
    totalPages = (findTestData(GlobalVariable.DS_version + 'URLsModelPagesOverview').getRowNumbers() - 1)

    WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)

    for (def index : (0..totalPages)) {
        WebUI.navigateToUrl(findTestData(GlobalVariable.DS_version + 'URLsModelPagesOverview').getValue(dataColumn, dataRow))

        if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/lexus logo'), 3, FailureHandling.OPTIONAL)) {
            WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)

            WebUI.navigateToUrl(findTestData(GlobalVariable.DS_version + 'URLsModelPagesOverview').getValue(dataColumn, dataRow))

            WebUI.verifyElementPresent(findTestObject('GlobalNav/lexus logo'), 0)
        }
        
        WebUI.verifyElementNotPresent(findTestObject('error'), 0)

        dataRow = (dataRow + 1)
    }
    
    WebUI.waitForPageLoad(0)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

