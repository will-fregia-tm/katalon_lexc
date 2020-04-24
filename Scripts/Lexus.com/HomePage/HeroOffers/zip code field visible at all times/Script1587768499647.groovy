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

WebUI.navigateToUrl(GlobalVariable.SC_Domain)

WebUI.navigateToUrl(GlobalVariable.SC_Domain_Unauthenticated)

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


@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

