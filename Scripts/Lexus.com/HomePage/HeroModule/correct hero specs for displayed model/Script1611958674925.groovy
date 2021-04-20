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

WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

'if the page renders slowly, it will be refreshed so the test can continue'
if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/hero module'), 0)

'runs test if starting at MSRP spec is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/spec - starting at msrp'), 3, FailureHandling.OPTIONAL)) {
    WebUI.delay(2)

    'goes to slide 1 if carousel is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/carousel slide 1 button'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/HeroModule/carousel slide 1 button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)
    }
    
    actualValue = WebUI.getText(findTestObject('Homepage/HeroModule/spec - starting at msrp'), FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 3)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    not_run: WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)

    'this should cover the rare situation in which specs are only present in slide 2'
    if (WebUI.verifyMatch(modifiedString, actualValue, false, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/HeroModule/carousel slide 2 button'), FailureHandling.OPTIONAL)

        WebUI.delay(2)

        actualValue = WebUI.getText(findTestObject('Homepage/HeroModule/spec - starting at msrp 2'), FailureHandling.STOP_ON_FAILURE)

        'this allows for null values in lower environments that do not have content updates'
        actualValue = (actualValue + ' ')

        'chooses column with data for test environment'
        column = GlobalVariable.dataColumn

        'gets homepage hero model value from HP test data'
        expectedValue = findTestData('HP').getValue(column, 3)

        'subtracts datasheet expected value from actual value displayed on page'
        modifiedString = (actualValue - expectedValue)

        'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
        WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
    }
}

'runs test if horsepower spec is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/spec - horsepower'), 3, FailureHandling.OPTIONAL)) {
    WebUI.delay(2)

    'goes to slide 1 if carousel is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/carousel slide 1 button'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/HeroModule/carousel slide 1 button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)
    }
    
    actualValue = WebUI.getText(findTestObject('Homepage/HeroModule/spec - horsepower'), FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 4)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
}

'runs test if drive mode spec is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/spec - drive modes'), 3, FailureHandling.OPTIONAL)) {
    WebUI.delay(2)

    'goes to slide 1 if carousel is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/carousel slide 1 button'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/HeroModule/carousel slide 1 button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)
    }
    
    actualValue = WebUI.getText(findTestObject('Homepage/HeroModule/spec - drive modes'), FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 7)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
}

'runs test if engine spec is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/spec - engine'), 3, FailureHandling.OPTIONAL)) {
    WebUI.delay(2)

    'goes to slide 1 if carousel is present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/carousel slide 1 button'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/HeroModule/carousel slide 1 button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)
    }
    
    actualValue = WebUI.getText(findTestObject('Homepage/HeroModule/spec - engine'), FailureHandling.STOP_ON_FAILURE)

    'this allows for null values in lower environments that do not have content updates'
    actualValue = (actualValue + ' ')

    'chooses column with data for test environment'
    column = GlobalVariable.dataColumn

    'gets homepage hero model value from HP test data'
    expectedValue = findTestData('HP').getValue(column, 8)

    'subtracts datasheet expected value from actual value displayed on page'
    modifiedString = (actualValue - expectedValue)

    'if the expected value is contained within the actual value, then the actual value without the expected value should not match the actual value'
    WebUI.verifyNotMatch(modifiedString, actualValue, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}
