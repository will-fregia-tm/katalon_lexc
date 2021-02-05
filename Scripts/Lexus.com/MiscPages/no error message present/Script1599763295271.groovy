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
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

totalPages = (findTestData(GlobalVariable.DS_version + 'URLsMiscPages').getRowNumbers() - 1)

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.OPTIONAL)

cookieValue = findTestData('cookieValues').getValue(2, 1)

Cookie ck = new Cookie('ESTSAUTH', cookieValue)

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/models/categories/sedans')

WebUI.delay(2)

for (def index : (0..totalPages)) {
    WebUI.navigateToUrl(findTestData(GlobalVariable.DS_version + 'URLsMiscPages').getValue(dataColumn, dataRow))

    if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/lexus logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.navigateToUrl(findTestData(GlobalVariable.DS_version + 'URLsMiscPages').getValue(dataColumn, dataRow))

        not_run: WebUI.verifyElementPresent(findTestObject('GlobalNav/lexus logo'), 0)
    }
    
    WebUI.verifyElementNotPresent(findTestObject('error'), 0)

    if (WebUI.verifyElementNotPresent(findTestObject('title'), 3, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(findTestObject('title - privacy'), 0)
    }
    
    WebUI.delay(2)

    dataRow = (dataRow + 1)
}

WebUI.waitForPageLoad(0)

WebUI.delay(6)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

