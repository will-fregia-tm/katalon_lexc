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
previousFeedData = findTestData(GlobalVariable.DS_version + 'Log').getValue(1, 2)

not_run: response = WS.sendRequest(findTestObject('LOD endpoint - ' + GlobalVariable.DS_version))

not_run: WS.verifyResponseStatusCode(response, 200)

not_run: WS.verifyElementPropertyValue(response, 'offers.Atlanta[0].offerType', 'lease')

not_run: currentFeedData = WS.getElementPropertyValue(response, 'offers.Atlanta[15].endDate')

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
        ExcelKeywords.setValueToCellByIndex(sheet01, 2, 0, textToWrite)
    }
    
    ExcelKeywords.saveWorkbook(excelFilePath, workbook01)

    WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain_Unauthenticated + '/compare')

    'reloads page if initial load fails'
    if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/lexus logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.refresh()
    }
    
    WebUI.verifyElementPresent(findTestObject('GlobalNav/lexus logo'), 0)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

