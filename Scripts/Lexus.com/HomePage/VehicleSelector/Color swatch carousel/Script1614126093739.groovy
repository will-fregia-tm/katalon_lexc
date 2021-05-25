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

WebUI.waitForElementPresent(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/QuickLinks/Quick Links'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 01'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/DividerModule/divider 02'), 0, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector heading'), 0, FailureHandling.OPTIONAL)

'if the vehicle selector renders slowly, page will be refreshed so the test can continue'
if (WebUI.verifyElementNotPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 3, FailureHandling.OPTIONAL)) {
    WebUI.refresh()

    WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 0, FailureHandling.OPTIONAL)

    'if the vehicle selector renders slowly, page will be refreshed so the test can continue'
    if (WebUI.verifyElementNotPresent(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector module'), 3, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('Homepage/VehicleSelectorAEM/vehicle selector heading'), 0, FailureHandling.OPTIONAL)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Sedans'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/ES'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

    swatch1size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch2size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 2'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch3size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 3'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch4size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 4'), 'width', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch2size, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch3size, false, FailureHandling.STOP_ON_FAILURE)

    'all color swatches should be the same size (regardless of # of swatches)'
    WebUI.verifyMatch(swatch1size, swatch4size, false, FailureHandling.STOP_ON_FAILURE)

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
    
    'color name renders under color swatch'
    colorName = WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), 0)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    'if there are more than eight swatches, then a carousel should be present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), 3, FailureHandling.OPTIONAL)) {
        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), FailureHandling.STOP_ON_FAILURE)

        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/SUVs'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RX'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    swatch1size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch2size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 2'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch3size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 3'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch4size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 4'), 'width', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch2size, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch3size, false, FailureHandling.STOP_ON_FAILURE)

    'all color swatches should be the same size (regardless of # of swatches)'
    WebUI.verifyMatch(swatch1size, swatch4size, false, FailureHandling.STOP_ON_FAILURE)

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
    
    'color name renders under color swatch'
    colorName = WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), 0)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    'if there are more than eight swatches, then a carousel should be present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), 3, FailureHandling.OPTIONAL)) {
        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), FailureHandling.STOP_ON_FAILURE)

        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Coupes'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    swatch1size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch2size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 2'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch3size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 3'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch4size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 4'), 'width', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch2size, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch3size, false, FailureHandling.STOP_ON_FAILURE)

    'all color swatches should be the same size (regardless of # of swatches)'
    WebUI.verifyMatch(swatch1size, swatch4size, false, FailureHandling.STOP_ON_FAILURE)

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
    
    'color name renders under color swatch'
    colorName = WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), 0)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    'if there are more than eight swatches, then a carousel should be present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), 3, FailureHandling.OPTIONAL)) {
        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), FailureHandling.STOP_ON_FAILURE)

        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Hybrids'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/RXh'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    swatch1size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch2size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 2'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch3size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 3'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch4size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 4'), 'width', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch2size, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch3size, false, FailureHandling.STOP_ON_FAILURE)

    'all color swatches should be the same size (regardless of # of swatches)'
    WebUI.verifyMatch(swatch1size, swatch4size, false, FailureHandling.STOP_ON_FAILURE)

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
    
    'color name renders under color swatch'
    colorName = WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), 0)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    'if there are more than eight swatches, then a carousel should be present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), 3, FailureHandling.OPTIONAL)) {
        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), FailureHandling.STOP_ON_FAILURE)

        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.click(findTestObject('HomePage/VehicleSelectorAEM/categories/Performance'), FailureHandling.STOP_ON_FAILURE)

'clicks this model if it is present'
if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/LC C'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    swatch1size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch2size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 2'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch3size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 3'), 'width', FailureHandling.STOP_ON_FAILURE)

    swatch4size = WebUI.getCSSValue(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 4'), 'width', FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch2size, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(swatch1size, swatch3size, false, FailureHandling.STOP_ON_FAILURE)

    'all color swatches should be the same size (regardless of # of swatches)'
    WebUI.verifyMatch(swatch1size, swatch4size, false, FailureHandling.STOP_ON_FAILURE)

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
    
    'color name renders under color swatch'
    colorName = WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/selected swatch name'), 0)

    'if color-swatch name has a disclaimer then the disclaimer icon will appear'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/swatch disclaimer'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisibleInViewport(findTestObject('Homepage/GlobalMisc/disclaimer copy'), 0, FailureHandling.STOP_ON_FAILURE)

        WebUI.getText(findTestObject('Homepage/GlobalMisc/disclaimer copy'), FailureHandling.STOP_ON_FAILURE)
    }
    
    'if there are more than eight swatches, then a carousel should be present'
    if (WebUI.verifyElementPresent(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), 3, FailureHandling.OPTIONAL)) {
        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/next button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 9'), FailureHandling.STOP_ON_FAILURE)

        'Tap/Clickable arrows should appear'
        WebUI.verifyElementVisible(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/previous button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('Homepage/VehicleSelectorAEM/models/swatch 1'), FailureHandling.STOP_ON_FAILURE)
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

