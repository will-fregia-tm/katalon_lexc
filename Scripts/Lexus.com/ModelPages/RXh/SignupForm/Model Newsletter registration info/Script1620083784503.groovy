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
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

def modelSeries = GlobalVariable.currentTestCaseID //get current testcase name

String[] parts = modelSeries.split('/' //split it to using delimeter /
    )

String three = parts[(parts.length - 3)]

modelSeries = three

int seriesKey = findTestData('modelData' + modelSeries).getValue(1, 2).toInteger()

WebUI.openBrowser(GlobalVariable.SSO_login, FailureHandling.OPTIONAL)

'these steps are added to handle lower environment authentication'
if (WebUI.verifyMatch(GlobalVariable.lowerEnvironment, 'yes', false, FailureHandling.OPTIONAL)) {
    cookieValue = findTestData('cookieValues').getValue(2, 1)

    Cookie ck = new Cookie('ESTSAUTH', cookieValue)

    WebDriver driver = DriverFactory.getWebDriver()

    driver.manage().addCookie(ck)

    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
    '?zip=90210')

'these steps are added to handle author environment URLs'
if (WebUI.verifyMatch(GlobalVariable.author, 'yes', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl((GlobalVariable.AEM_Domain + findTestData('modelData').getValue(GlobalVariable.dataColumn, seriesKey)) + 
        '&zip=90210')
}

'this step is added to handle a slow or partial page load'
if (WebUI.verifyElementNotPresent(findTestObject('ModelPages/Hero/hero module'), 6, FailureHandling.OPTIONAL)) {
    WebUI.refresh()
}

WebUI.waitForElementPresent(findTestObject('ModelPages/Hero/hero module'), 6, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('ModelPages/Subnav/offers link'), FailureHandling.OPTIONAL)

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('ModelPages/AdditionalInfo/additional info module'), 0, FailureHandling.OPTIONAL)

WebUI.delay(1)

WebUI.click(findTestObject('ModelPages/MessageBar/signup link'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(0)

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/form overlay'), 0, FailureHandling.STOP_ON_FAILURE)

'these steps will run in environments that require valid content'
if (WebUI.verifyMatch(GlobalVariable.contentValidation, 'yes', false, FailureHandling.OPTIONAL)) {
    selectedModel = WebUI.getText(findTestObject('ModelPages/SignupForm/pre-selected model'))

    'model of current model page is preselected in models of interest dropwdown'
    WebUI.verifyMatch(selectedModel, findTestData('modelData').getValue(1, seriesKey + 1380), false)
}

'zipcode field autofills if user\'s location is known'
zipCode = WebUI.getAttribute(findTestObject('ModelPages/SignupForm/zip field'), 'value')

WebUI.verifyMatch(zipCode, '90210', false)

WebUI.setText(findTestObject('ModelPages/SignupForm/zip field'), 'abcde', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/valid zip prompt'), 0, FailureHandling.STOP_ON_FAILURE)

validZIPPrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid zip prompt'))

'zipcode field only accepts 5 digits - numbers only'
WebUI.verifyMatch(validZIPPrompt, 'Please enter a valid 5 digit ZIP Code.', false, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('ModelPages/SignupForm/zip field'), '1234', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/valid zip prompt'), 0, FailureHandling.STOP_ON_FAILURE)

validZIPPrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid zip prompt'))

'zipcode field only accepts 5 digits - numbers only'
WebUI.verifyMatch(validZIPPrompt, 'Please enter a valid 5 digit ZIP Code.', false, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('ModelPages/SignupForm/zip field'), ' ', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/valid zip prompt'), 0, FailureHandling.STOP_ON_FAILURE)

validZIPPrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid zip prompt'))

'zipcode is a required field'
WebUI.verifyMatch(validZIPPrompt, 'Please enter a valid 5 digit ZIP Code.', false, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('ModelPages/SignupForm/zip field'), '90066', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

validZIPPrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid zip prompt'))

WebUI.verifyNotMatch(validZIPPrompt, 'Please enter a valid 5 digit ZIP Code.', false)

WebUI.click(findTestObject('ModelPages/SignupForm/submit button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

border = WebUI.getCSSValue(findTestObject('ModelPages/SignupForm/input field - first name'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(border, 'rgba(251, 13, 27, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(border, 'rgb(251, 13, 27)', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/valid first name prompt'), 0, FailureHandling.STOP_ON_FAILURE)

firstNamePrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid first name prompt'))

'first name is a required field'
WebUI.verifyMatch(firstNamePrompt, 'Please enter a first name.', false)

WebUI.setText(findTestObject('ModelPages/SignupForm/input field - first name'), 'sendto', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

firstNamePrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid first name prompt'))

'first name is a required field'
WebUI.verifyNotMatch(firstNamePrompt, 'Please enter a first name.', false)

border = WebUI.getCSSValue(findTestObject('ModelPages/SignupForm/input field - last name'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(border, 'rgba(251, 13, 27, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(border, 'rgb(251, 13, 27)', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/valid last name prompt'), 0, FailureHandling.STOP_ON_FAILURE)

lastNamePrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid last name prompt'))

'last name is a required field'
WebUI.verifyMatch(lastNamePrompt, 'Please enter a last name.', false)

WebUI.setText(findTestObject('ModelPages/SignupForm/input field - last name'), 'adf', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

lastNamePrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid last name prompt'))

'last name is a required field'
WebUI.verifyNotMatch(lastNamePrompt, 'Please enter a last name.', false)

border = WebUI.getCSSValue(findTestObject('ModelPages/SignupForm/input field - email'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyNotMatch(border, 'rgba(251, 13, 27, 1)', false, FailureHandling.OPTIONAL)) {
    WebUI.verifyMatch(border, 'rgb(251, 13, 27)', false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/valid email prompt'), 0, FailureHandling.STOP_ON_FAILURE)

emailPrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid email prompt'))

'email is a required field'
WebUI.verifyMatch(emailPrompt, 'Please enter a valid email address.', false)

WebUI.setText(findTestObject('ModelPages/SignupForm/input field - email'), 'zach.smithteamone-usa.com', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/valid email prompt'), 0, FailureHandling.STOP_ON_FAILURE)

emailPrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid email prompt'))

'email field requires valid @ tag'
WebUI.verifyMatch(emailPrompt, 'Please enter a valid email address.', false)

WebUI.setText(findTestObject('ModelPages/SignupForm/input field - email'), 'zach.smith@teamone-usa.com', FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

emailPrompt = WebUI.getText(findTestObject('ModelPages/SignupForm/valid email prompt'))

'email is a required field'
WebUI.verifyNotMatch(emailPrompt, 'Please enter a valid email address.', false)

'purchase plan dropdown is present'
WebUI.click(findTestObject('ModelPages/SignupForm/purchase plan dropdown'))

WebUI.delay(1)

purchasePlan = WebUI.getText(findTestObject('ModelPages/SignupForm/dropdown option 1'))

'it\'s possible to select one of these options in purchase plan dropdown: 0-1 Months, 2-3 Months, 4-6 Months, 7-12 Months, 12+ Months'
WebUI.click(findTestObject('ModelPages/SignupForm/dropdown option 1'))

selectedOption = WebUI.getText(findTestObject('ModelPages/SignupForm/selected plan'))

WebUI.verifyMatch(purchasePlan, selectedOption, false)

WebUI.delay(1)

'models of interest dropdown is present'
WebUI.click(findTestObject('ModelPages/SignupForm/model of interest dropdown'))

WebUI.delay(1)

MOI1 = WebUI.getText(findTestObject('ModelPages/SignupForm/dropdown option 1'))

'user can select up to three models in models of interest dropdown'
WebUI.click(findTestObject('ModelPages/SignupForm/dropdown option 1'))

WebUI.delay(1)

MOI2 = WebUI.getText(findTestObject('ModelPages/SignupForm/dropwdown option 2'))

'user can select up to three models in models of interest dropdown'
WebUI.click(findTestObject('ModelPages/SignupForm/dropwdown option 2'))

WebUI.delay(1)

'these steps will run in environments that require valid content'
if (WebUI.verifyMatch(GlobalVariable.contentValidation, 'yes', false, FailureHandling.OPTIONAL)) {
    'user can select up to three models in models of interest dropdown'
    WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/selection limited message'), 0)

    WebUI.getText(findTestObject('ModelPages/SignupForm/selection limited message'))

    'user can select up to three models in models of interest dropdown'
    WebUI.click(findTestObject('ModelPages/SignupForm/model of interest - remove button 3'))

    WebUI.delay(1)
}

'user can select up to three models in models of interest dropdown'
WebUI.click(findTestObject('ModelPages/SignupForm/model of interest - remove button 2'))

WebUI.delay(1)

'user can select up to three models in models of interest dropdown'
WebUI.click(findTestObject('ModelPages/SignupForm/model of interest - remove button 1'), FailureHandling.OPTIONAL)

WebUI.delay(1)

'these steps will run in environments that require valid content'
if (WebUI.verifyMatch(GlobalVariable.contentValidation, 'yes', false, FailureHandling.OPTIONAL)) {
    'there\'s no way to remove all models of interest'
    selectedModel = WebUI.getText(findTestObject('ModelPages/SignupForm/pre-selected model'))
}

'models of interest dropdown is present'
WebUI.click(findTestObject('ModelPages/SignupForm/model of interest dropdown'))

WebUI.delay(1)

'dealer opt-in box can be checked'
WebUI.click(findTestObject('ModelPages/SignupForm/dealer opt-in box'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('ModelPages/SignupForm/preferred dealers heading'), 0)

'dealer opt-in box can be unchecked'
WebUI.click(findTestObject('ModelPages/SignupForm/dealer opt-in box'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementNotPresent(findTestObject('ModelPages/SignupForm/preferred dealers heading'), 0)

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

