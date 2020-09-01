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

totalPages = (findTestData(GlobalVariable.DS_version + 'URLsModelPagesOwners').getRowNumbers() - 1)

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)

for (def index : (0..totalPages)) {
    WebUI.navigateToUrl(findTestData(GlobalVariable.DS_version + 'URLsModelPagesOwners').getValue(dataColumn, dataRow))

    'verifies no redirect to Lexus Drivers'
    not_run: if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/drivers logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(findTestObject('GlobalNav/lexus logo'), 0)

        WebUI.verifyElementPresent(findTestObject('GlobalNav/model image'), 0)

        WebUI.verifyElementPresent(findTestObject('GlobalNav/footer'), 0)
    }
    
    WebUI.verifyElementNotPresent(findTestObject('error'), 0)

    dataRow = (dataRow + 1)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

