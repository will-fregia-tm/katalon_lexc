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
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.OPTIONAL)

'these steps are added to handle lower environment authentication'
if (WebUI.verifyMatch(GlobalVariable.lowerEnvironment, 'yes', false, FailureHandling.OPTIONAL)) {
    cookieValue = findTestData('cookieValues').getValue(2, 1)

    Cookie ck = new Cookie('ESTSAUTH', cookieValue)

    WebDriver driver = DriverFactory.getWebDriver()

    driver.manage().addCookie(ck)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

'these steps will be run for the legacy version of the page'
if (WebUI.verifyMatch(GlobalVariable.legacy, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.SC_Domain)

    WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

    'if the page renders slowly, it will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.refresh()
    }
    
    WebUI.waitForElementPresent(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

    WebUI.scrollToElement(findTestObject('HomePage/VehicleSelector/vehicle selector - heading'), 0)

    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('HomePage/VehicleSelector/categories/Performance'), FailureHandling.STOP_ON_FAILURE)
}

'these steps will be run for the non-legacy version of the page'
if (WebUI.verifyMatch(GlobalVariable.legacy, 'no', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

    'if the page renders slowly, it will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.refresh()
    }
    
    WebUI.delay(2)

    WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.OPTIONAL)

    WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

    selectedCategory = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/categories/selected category'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(selectedCategory, 'SEDANS', false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 11)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background image'), 'src', FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 16)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'checks background video if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 3, FailureHandling.OPTIONAL)) {
        actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 'src', 
            FailureHandling.STOP_ON_FAILURE)

        'this allows for null values in lower environments that do not have content updates'
        actualValue = (actualValue + ' ')

        'chooses column with data for test environment'
        column = GlobalVariable.dataColumn

        'gets homepage hero model value from HP test data'
        expectedValue = findTestData('HP').getValue(column, 21)

        'subtracts datasheet expected value from actual value displayed on page'
        modifiedString = (actualValue - expectedValue)

        'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
        WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

    selectedCategory = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/categories/selected category'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(selectedCategory, 'SUVS', false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 12)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background image'), 'src', FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 17)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'checks background video if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 3, FailureHandling.OPTIONAL)) {
        actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 'src', 
            FailureHandling.STOP_ON_FAILURE)

        'this allows for null values in lower environments that do not have content updates'
        actualValue = (actualValue + ' ')

        'chooses column with data for test environment'
        column = GlobalVariable.dataColumn

        'gets homepage hero model value from HP test data'
        expectedValue = findTestData('HP').getValue(column, 22)

        'subtracts datasheet expected value from actual value displayed on page'
        modifiedString = (actualValue - expectedValue)

        'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
        WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

    selectedCategory = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/categories/selected category'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(selectedCategory, 'COUPES', false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 13)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background image'), 'src', FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 18)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'checks background video if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 3, FailureHandling.OPTIONAL)) {
        actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 'src', 
            FailureHandling.STOP_ON_FAILURE)

        'this allows for null values in lower environments that do not have content updates'
        actualValue = (actualValue + ' ')

        'chooses column with data for test environment'
        column = GlobalVariable.dataColumn

        'gets homepage hero model value from HP test data'
        expectedValue = findTestData('HP').getValue(column, 23)

        'subtracts datasheet expected value from actual value displayed on page'
        modifiedString = (actualValue - expectedValue)

        'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
        WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

    selectedCategory = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/categories/selected category'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(selectedCategory, 'HYBRIDS', false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 14)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background image'), 'src', FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 19)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'checks background video if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 3, FailureHandling.OPTIONAL)) {
        actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 'src', 
            FailureHandling.STOP_ON_FAILURE)

        'this allows for null values in lower environments that do not have content updates'
        actualValue = (actualValue + ' ')

        'chooses column with data for test environment'
        column = GlobalVariable.dataColumn

        'gets homepage hero model value from HP test data'
        expectedValue = findTestData('HP').getValue(column, 24)

        'subtracts datasheet expected value from actual value displayed on page'
        modifiedString = (actualValue - expectedValue)

        'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
        WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

    selectedCategory = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/categories/selected category'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(selectedCategory, 'PERFORMANCE', false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected model'), FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 15)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background image'), 'src', FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 20)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'checks background video if it is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 3, FailureHandling.OPTIONAL)) {
        actualValue = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/categories/background video'), 'src', 
            FailureHandling.STOP_ON_FAILURE)

        'this allows for null values in lower environments that do not have content updates'
        actualValue = (actualValue + ' ')

        'chooses column with data for test environment'
        column = GlobalVariable.dataColumn

        'gets homepage hero model value from HP test data'
        expectedValue = findTestData('HP').getValue(column, 25)

        'subtracts datasheet expected value from actual value displayed on page'
        modifiedString = (actualValue - expectedValue)

        'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
        WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
    }
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

