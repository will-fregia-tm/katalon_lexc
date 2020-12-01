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

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.STOP_ON_FAILURE)

cookieValue = findTestData('cookieValues').getValue(2, 1)

Cookie ck = new Cookie('ESTSAUTH', cookieValue)

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

WebUI.navigateToUrl(GlobalVariable.TS_Domain + '/privacy', FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers?zip=30303', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0)

'tests featured offers row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/FeaturedOffers/featured offers heading'), 3, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('OffersPage/FeaturedOffers/row 01 - offer card 1 - star icon'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('OffersPage/FeaturedOffers/row 02 - offer card 1 - star icon'), 0, FailureHandling.STOP_ON_FAILURE)

    'tests this featured offer card if it is present'
    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 01 - offer card 2'), 3, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(findTestObject('OffersPage/FeaturedOffers/row 01 - offer card 2 - star icon'), 0, FailureHandling.STOP_ON_FAILURE)

        'tests this featured offer card if it is present'
        if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 01 - offer card 3'), 3, FailureHandling.OPTIONAL)) {
            WebUI.verifyElementPresent(findTestObject('OffersPage/FeaturedOffers/row 01 - offer card 3 - star icon'), 0, 
                FailureHandling.STOP_ON_FAILURE)
        }
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

