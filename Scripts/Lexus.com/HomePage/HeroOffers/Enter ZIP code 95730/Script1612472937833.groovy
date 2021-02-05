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

'these steps will be run for the legacy version of the page'
if (WebUI.verifyMatch(GlobalVariable.legacy, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.SC_Domain)

    WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

    'if the page renders slowly, it will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.refresh()
    }
    
    WebUI.waitForElementVisible(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), 0)

    WebUI.scrollToPosition(0, 250)

    WebUI.verifyElementPresent(findTestObject('HomePage/HeroOffers/hero offers - see offers in your area'), 0)

    WebUI.scrollToElement(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), 0)

    WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))

    WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))

    WebUI.setText(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), '75218')

    WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - search button'))

    WebUI.waitForElementVisible(findTestObject('HomePage/HeroOffers/All Offers - offer info - dollar symbol'), 0)

    WebUI.scrollToElement(findTestObject('HomePage/HeroOffers/hero offers - change zip CTA'), 0)

    WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/hero offers - change zip CTA'))

    WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - change zip CTA'))

    WebUI.waitForElementVisible(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), 0)

    WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))
}

'these steps will be run for the non-legacy version of the page'
if (WebUI.verifyMatch(GlobalVariable.legacy, 'no', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.AEM_Domain)

    'if the page renders slowly, it will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
        WebUI.refresh()

        WebUI.delay(2)
    }
    
    WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/HeroModule/hero module'), 0, FailureHandling.STOP_ON_FAILURE)

    'runs these tests on sales event version of page'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/zip code field'), 5, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/HeroOffers/zip code field'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.scrollToPosition(0, 350)

        WebUI.click(findTestObject('Homepage/HeroOffers/zip code field'))

        WebUI.setText(findTestObject('Homepage/HeroOffers/zip code field'), '95730')

        WebUI.click(findTestObject('Homepage/HeroOffers/submit button'))

        WebUI.waitForElementPresent(findTestObject('Homepage/HeroOffers/no dealer message'), 5, FailureHandling.OPTIONAL)

        WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/no dealer message'), 5, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/expand CTA'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/HeroOffers/expand CTA'), FailureHandling.STOP_ON_FAILURE)

        WebUI.waitForElementPresent(findTestObject('Homepage/HeroOffers/ExpandSearch/expand zip overlay'), 5, FailureHandling.OPTIONAL)

        WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/ExpandSearch/expand zip overlay'), 5, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 1'), 5, FailureHandling.STOP_ON_FAILURE)
		
		noHover = WebUI.getCSSValue(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 1'), 'background-color', FailureHandling.STOP_ON_FAILURE)
		
		WebUI.mouseOver(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 1'), FailureHandling.OPTIONAL)
		
		hoverState = WebUI.getCSSValue(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 1'), 'background-color', FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyNotMatch(hoverState, noHover, false, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 2'), 5, FailureHandling.STOP_ON_FAILURE)
		
		noHover = WebUI.getCSSValue(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 2'), 'background-color', FailureHandling.STOP_ON_FAILURE)
		
		WebUI.mouseOver(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 2'), FailureHandling.OPTIONAL)
		
		hoverState = WebUI.getCSSValue(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 2'), 'background-color', FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyNotMatch(hoverState, noHover, false, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 3'), 5, FailureHandling.STOP_ON_FAILURE)
		
		noHover = WebUI.getCSSValue(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 3'), 'background-color', FailureHandling.STOP_ON_FAILURE)
		
		WebUI.mouseOver(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 3'), FailureHandling.OPTIONAL)
		
		hoverState = WebUI.getCSSValue(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 3'), 'background-color', FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyNotMatch(hoverState, noHover, false, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.scrollToElement(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 6'), 5, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyElementPresent(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 6'), 5, FailureHandling.STOP_ON_FAILURE)
		
		noHover = WebUI.getCSSValue(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 6'), 'background-color', FailureHandling.STOP_ON_FAILURE)
		
		WebUI.mouseOver(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 6'), FailureHandling.STOP_ON_FAILURE)
		
		hoverState = WebUI.getCSSValue(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 6'), 'background-color', FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyNotMatch(hoverState, noHover, false, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.scrollToElement(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 9'), 5, FailureHandling.STOP_ON_FAILURE)
		
		WebUI.mouseOver(findTestObject('Homepage/HeroOffers/ExpandSearch/displayed dealer 9'), FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
    }
    
    'runs these tests on non-sales event version of page'
    if (WebUI.verifyElementNotPresent(findTestObject('Homepage/HeroOffers/zip code field'), 5, FailureHandling.OPTIONAL)) {
        WebUI.verifyElementPresent(findTestObject('Homepage/HeroModule/hero module'), 0, FailureHandling.STOP_ON_FAILURE)
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

