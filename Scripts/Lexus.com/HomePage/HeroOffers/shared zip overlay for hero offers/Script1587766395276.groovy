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

WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), 0)

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))

WebUI.setText(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), '08008')

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - search button'))

WebUI.waitForElementVisible(findTestObject('HomePage/HeroOffers/All Offers - shared zip overlay title'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - shared zip overlay title'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - shared zip overlay showing market'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - shared zip overlay change CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/hero offers - map close button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/hero offers - market button - New York marketLDAtitle'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - market button - New York marketLDAtitle'))

WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/All Offers - market name - 08008'), 0)

WebUI.scrollToElement(findTestObject('HomePage/HeroOffers/All Offers - market name - 08008'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - market name - 08008'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - change zip CTA'))

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))

WebUI.setText(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), '53128')

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - search button'))

WebUI.waitForElementVisible(findTestObject('HomePage/HeroOffers/All Offers - shared zip overlay title'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - shared zip overlay title'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - shared zip overlay showing market'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - shared zip overlay change CTA'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/hero offers - map close button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/hero offers - market button - Rockford'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - market button - Rockford'))

WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/All Offers - market name - 53128'), 0)

WebUI.scrollToElement(findTestObject('HomePage/HeroOffers/All Offers - market name - 53128'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - market name - 53128'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/All Offers - offer info - dollar symbol'), 0)

WebUI.verifyElementPresent(findTestObject('HomePage/HeroOffers/All Offers - offer info - dollar symbol'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - offer details slider'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - change zip CTA'))

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'))

WebUI.setText(findTestObject('HomePage/HeroOffers/hero offers - zip entry field'), '53128')

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - search button'))

WebUI.waitForElementVisible(findTestObject('HomePage/HeroOffers/hero offers - map close button'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/hero offers - map close button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/HeroOffers/hero offers - map close button'))

WebUI.waitForElementPresent(findTestObject('HomePage/HeroOffers/All Offers - offer info - dollar symbol'), 0)

WebUI.verifyElementPresent(findTestObject('HomePage/HeroOffers/All Offers - offer info - dollar symbol'), 0)

WebUI.verifyElementVisible(findTestObject('HomePage/HeroOffers/All Offers - offer details slider'), FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

