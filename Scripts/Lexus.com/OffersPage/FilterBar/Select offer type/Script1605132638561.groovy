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

cookieValue = findTestData('cookieValues').getValue(2, 1)

Cookie ck = new Cookie('ESTSAUTH', cookieValue)

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/privacy')

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers')

'This is a workaround in case LAM-2532 occurs.'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/expand CTA'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('OffersPage/ZipBar/change market CTA'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('OffersPage/ZipBar/zip entry field'), '08008')

    WebUI.click(findTestObject('OffersPage/ZipBar/search icon'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('OffersPage/SharedMarketOverlay/shared zip overlay'), 5, FailureHandling.OPTIONAL)

    WebUI.verifyElementPresent(findTestObject('OffersPage/SharedMarketOverlay/shared zip overlay'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('OffersPage/SharedMarketOverlay/X button'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/form input'), 5, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('OffersPage/ZipGate/form input'), '75218')

WebUI.click(findTestObject('OffersPage/ZipGate/submit button'))

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/FilterBar/filter bar'), FailureHandling.STOP_ON_FAILURE)

selectedColor = WebUI.getCSSValue(findTestObject('OffersPage/FilterBar/ALL button'), 'background-color', FailureHandling.STOP_ON_FAILURE)

defaultUnselected = WebUI.getCSSValue(findTestObject('OffersPage/FilterBar/finance button'), 'background-color', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyNotMatch(defaultUnselected, selectedColor, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/FilterBar/finance button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/FilterBar/lease button'), FailureHandling.STOP_ON_FAILURE)

selectedColor = WebUI.getCSSValue(findTestObject('OffersPage/FilterBar/lease button'), 'background-color', FailureHandling.STOP_ON_FAILURE)

firstUnselected = WebUI.getCSSValue(findTestObject('OffersPage/FilterBar/ALL button'), 'background-color', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyNotMatch(firstUnselected, selectedColor, false, FailureHandling.STOP_ON_FAILURE)

secondUnselected = WebUI.getCSSValue(findTestObject('OffersPage/FilterBar/finance button'), 'background-color', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyNotMatch(secondUnselected, selectedColor, false, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('OffersPage/FilterBar/unavailable model'), 3, FailureHandling.OPTIONAL)) {
    unavailableModelText = WebUI.getText(findTestObject('OffersPage/FilterBar/unavailable model'), FailureHandling.STOP_ON_FAILURE)

    unavailableModel = (unavailableModelText - ' (No offer available)')

    WebUI.verifyNotMatch(unavailableModelText, unavailableModel, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('OffersPage/FilterBar/unavailable model'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('OffersPage/FilterBar/apply button'), FailureHandling.STOP_ON_FAILURE)

    pageText = WebUI.getText(findTestObject('OffersPage/FilterBar/page content'), FailureHandling.STOP_ON_FAILURE)

    'Enable this to test whether the subsequent steps are working (they should fail).'
    not_run: unavailableModel = 'ES'

    pageTextWithoutModel = (pageText - unavailableModel)

    'Checks to see if the "unavailable model" is actually present anywhere on the offers page.'
    WebUI.verifyMatch(pageText, pageTextWithoutModel, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

