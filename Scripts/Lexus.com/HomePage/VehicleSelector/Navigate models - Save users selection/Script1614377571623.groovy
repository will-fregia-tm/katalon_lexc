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

WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

'if the page renders slowly, it will be refreshed so the test can continue'
if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 01'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector heading'), 0, FailureHandling.OPTIONAL)

'if the vehicle selector renders slowly, page will be refreshed so the test can continue'
if (WebUI.verifyElementNotPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()

    WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.OPTIONAL)

    'if the vehicle selector renders slowly, page will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 3, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector heading'), 0, FailureHandling.OPTIONAL)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    sedansJelly1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    sedansJelly2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    suvsJelly1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    suvsJelly2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    coupesJelly1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    coupesJelly2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    hybridsJelly1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    hybridsJelly2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    performanceJelly1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    performanceJelly2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), 3, FailureHandling.OPTIONAL)) {
    not_run: WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    returnJelly = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(returnJelly, sedansJelly2, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyNotMatch(returnJelly, sedansJelly1, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), 3, FailureHandling.OPTIONAL)) {
    not_run: WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    returnJelly = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(returnJelly, suvsJelly2, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyNotMatch(returnJelly, suvsJelly1, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
    not_run: WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    returnJelly = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(returnJelly, coupesJelly2, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyNotMatch(returnJelly, coupesJelly1, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
    not_run: WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    returnJelly = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(returnJelly, hybridsJelly2, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyNotMatch(returnJelly, hybridsJelly1, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    not_run: WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    returnJelly = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(returnJelly, performanceJelly2, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyNotMatch(returnJelly, performanceJelly1, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

