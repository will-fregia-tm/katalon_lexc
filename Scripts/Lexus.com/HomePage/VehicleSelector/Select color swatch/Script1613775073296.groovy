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

WebUI.waitForElementPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/IS'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    swatch1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name1 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    swatch2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name2 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch has been updated'
    WebUI.verifyNotMatch(swatch1, swatch2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch name has been updated'
    WebUI.verifyNotMatch(name1, name2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that model asset has been updated'
    WebUI.verifyNotMatch(asset1, asset2, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/UX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    swatch1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name1 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    swatch2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name2 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch has been updated'
    WebUI.verifyNotMatch(swatch1, swatch2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch name has been updated'
    WebUI.verifyNotMatch(name1, name2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that model asset has been updated'
    WebUI.verifyNotMatch(asset1, asset2, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RC F'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    swatch1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name1 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    swatch2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name2 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch has been updated'
    WebUI.verifyNotMatch(swatch1, swatch2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch name has been updated'
    WebUI.verifyNotMatch(name1, name2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that model asset has been updated'
    WebUI.verifyNotMatch(asset1, asset2, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/NXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    swatch1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name1 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    swatch2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name2 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch has been updated'
    WebUI.verifyNotMatch(swatch1, swatch2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch name has been updated'
    WebUI.verifyNotMatch(name1, name2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that model asset has been updated'
    WebUI.verifyNotMatch(asset1, asset2, false, FailureHandling.STOP_ON_FAILURE)
}

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LSh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    swatch1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name1 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    swatch2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name2 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch has been updated'
    WebUI.verifyNotMatch(swatch1, swatch2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch name has been updated'
    WebUI.verifyNotMatch(name1, name2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that model asset has been updated'
    WebUI.verifyNotMatch(asset1, asset2, false, FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    swatch1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name1 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset1 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    swatch2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'src', FailureHandling.STOP_ON_FAILURE)

    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 2'), 'border-top-color', FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has a visible border and is visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(164, 139, 91, 1)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has a visible border and is visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(164, 139, 91)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    swatchBorder = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/color 1 default'), 'border-top-color', 
        FailureHandling.STOP_ON_FAILURE)

    'verifies that this swatch has no visible border and is not visibly selected'
    if (WebUI.verifyNotMatch(swatchBorder, 'rgba(0, 0, 0, 0)', false, FailureHandling.OPTIONAL)) {
        'verifies that this swatch has no visible border and is not visibly selected'
        WebUI.verifyMatch(swatchBorder, 'rgb(0, 0, 0)', false, FailureHandling.STOP_ON_FAILURE)
    }
    
    name2 = WebUI.getText(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), FailureHandling.STOP_ON_FAILURE)

    asset2 = WebUI.getAttribute(findTestObject('Homepage/VehicleSelectorAEM/models/vehicle jelly'), 'src', FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch has been updated'
    WebUI.verifyNotMatch(swatch1, swatch2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that swatch name has been updated'
    WebUI.verifyNotMatch(name1, name2, false, FailureHandling.STOP_ON_FAILURE)

    'verifies that model asset has been updated'
    WebUI.verifyNotMatch(asset1, asset2, false, FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDownIfPassed
def passed() {
    WebUI.executeJavaScript('sauce:job-result=passed', [])
}

@com.kms.katalon.core.annotation.TearDownIfFailed
def failed() {
    WebUI.executeJavaScript('sauce:job-result=failed', [])
}

