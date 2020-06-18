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

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)

if (WebUI.verifyElementNotPresent(findTestObject('GlobalNav/header/header - Lexus logo'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.navigateToUrl(GlobalVariable.SC_Domain)

WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

WebUI.scrollToElement(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), 0)

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))

WebUI.sendKeys(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), '12345')

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - search button'))

WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/hero offers - change zip CTA'), 0)

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - change zip CTA'))

WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/hero offers - zip search value 12345'), 0)

WebUI.verifyElementPresent(findTestObject('HomePage/HeroOffers/hero offers - zip search value 12345'), 0)

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))

pageWidth = WebUI.getPageWidth(FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyGreaterThan(pageWidth, '960', FailureHandling.OPTIONAL)) {
    WebUI.sendKeys(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), '12345')

    WebUI.sendKeys(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), '6')

    WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - search button'))

    WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/hero offers - change zip CTA'), 0)

    WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - change zip CTA'))

    WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/hero offers - zip search value 12345'), 0, FailureHandling.OPTIONAL)

    WebUI.verifyElementPresent(findTestObject('HomePage/HeroOffers/hero offers - zip search value 12345'), 0)

    WebUI.verifyElementNotPresent(findTestObject('HomePage/HeroOffers/hero offers - zip search value 123456'), 0)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

