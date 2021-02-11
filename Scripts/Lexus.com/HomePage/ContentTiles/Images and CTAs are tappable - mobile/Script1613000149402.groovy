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

WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/hero module'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Homepage/ContentTiles/tiles module 01'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 01'), 0, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('Homepage/ContentTiles/tiles module 01 - tile image - mobile'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Homepage/ContentTiles/tiles module 01 - tile CTA - mobile'), 0, FailureHandling.STOP_ON_FAILURE)

hrefCTA = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module 01 - tile CTA - mobile'), 'href', FailureHandling.STOP_ON_FAILURE)

hrefImage = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module 01 - tile image link - mobile'), 'href', 
    FailureHandling.STOP_ON_FAILURE)

'CTA and image links should match'
WebUI.verifyMatch(hrefCTA, hrefImage, false, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Homepage/ContentTiles/tiles module 01 - tile CTA - mobile'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0, FailureHandling.STOP_ON_FAILURE)

windowTitle = WebUI.getWindowTitle()

modifiedString = (windowTitle - 'Lexus')

'these steps are added to handle environments in which the linked page is not present'
if (WebUI.verifyMatch(windowTitle, modifiedString, false, FailureHandling.OPTIONAL)) {
    WebUI.back()

    href = WebUI.getAttribute(findTestObject('Homepage/ContentTiles/tiles module 01 - tile CTA - mobile'), 'href')

    href = ((href - GlobalVariable.AEM_Domain) - 'https://stage-aem.author.toyota.com')

    WebUI.navigateToUrl('https://www.lexus.com' + href)

    WebUI.waitForPageLoad(0)

    WebUI.delay(2)

    windowTitle = WebUI.getWindowTitle()

    modifiedString = ((windowTitle - 'Lexus') - 'Offers')

    WebUI.verifyNotMatch(windowTitle, modifiedString, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.back()

WebUI.waitForElementPresent(findTestObject('Homepage/ContentTiles/tiles module 01'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 01'), 0, FailureHandling.STOP_ON_FAILURE)

'runs more tests if there are additional grid modules present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/ContentTiles/tiles module 02'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 02'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    'runs more tests if there are additional grid modules present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/ContentTiles/tiles module 03'), 3, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('Homepage/ContentTiles/tiles module 03'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2)
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

