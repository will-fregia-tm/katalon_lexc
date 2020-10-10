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

WebUI.openBrowser(GlobalVariable.TS_Domain + GlobalVariable.Header)

WebUI.navigateToUrl('https://stg-lcom.cdn.cepo-proxy.tms.aws.lexus.com/concept/LFSA')

Cookie ck = new Cookie('ESTSAUTH', '0.AQQAHS1kjAnXsEerEAgK8QeY-_fhvoluXopNnz3s1gElnacEACQ.AgABAAQAAAB2UyzwtQEKR7-rWbgdcBZIAQDs_wIA9P-Wpq_oN140SlaQhmSZdUtExwthC3QA5ZUhx1wblDmNb7TSMkJdVNslXCyuJ5xB9bmbl7RaZGwHff335IImgQFTygaeiY49nVYlaxJu1oghJNcGuXuTMSDerQ5TjaXzscAfoOY2_voPwSuTjy_ZUaYHlo_6Pc_Ny10pXDG0XKYbcdpAXlkKv5iG-YbfyWzaBxwsZGJMc4hCnbvNq770qfL5peM-UfqmxPc7l3RyU_RRCQnt5pJR0mq85t2vm_c9TSjo45BUgh76M3RGi8fe1lVqvxlgYzvH2_o6ddizfKvLoZr4u90huEYf4SlLQuKlobk8a8cBjAskEoIdWjNS3x_D1-c_uGlO_1p05adKubkPa64YFF3iDzFGKfrsMywG_jeECUB4sTT8gRZq1WKzklrtHnbzuSl5FVxt-8sYDEdOcEP824q37Svxnr06OUzosaglatgybf0m2PU7t0PMBB4zCx8j7IC7bPxd9z0FpPRJsCK7nOfJglPxclsOuFPoIARstoBhlYrRrdxSgcSdu_Bz55jh3O8D7JoTTMJuU-lQyCQugO6jvrc3_GhLJuGnAUrvoYI')

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

WebUI.navigateToUrl('https://stg-lcom.cdn.cepo-proxy.tms.aws.lexus.com/concept/LFSA')

not_run: WebUI.navigateToUrl(GlobalVariable.AEM_Domain_Unauthenticated + '/concept/LFSA')

if (WebUI.verifyElementNotPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('FCV/Hero/hero module'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FCV/Hero/Share link'), 5)

WebUI.verifyElementNotPresent(findTestObject('FCV/Hero/social media overlay'), 0)

WebUI.click(findTestObject('FCV/Hero/Share link'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('FCV/Hero/social media overlay'), 0)

WebUI.verifyElementPresent(findTestObject('FCV/Hero/Facebook button'), 0)

WebUI.verifyElementPresent(findTestObject('FCV/Hero/Twitter button'), 0)

WebUI.verifyElementPresent(findTestObject('FCV/Hero/Email button'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

