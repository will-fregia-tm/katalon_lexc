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

domain = GlobalVariable.domain

'this step is added to handle legacy staging authentication'
if (WebUI.verifyMatch(domain, 'staging', false, FailureHandling.OPTIONAL)) {
    WebUI.navigateToUrl(GlobalVariable.TS_Domain + GlobalVariable.legacyURL)
}

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers?zip=30303&offerType=all', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OffersPage/ZipBar/zip bar - 30303'), 0)

WebUI.click(findTestObject('OffersPage/FilterBar/filter bar'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/FilterBar/model-category - SUVs'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/FilterBar/model-category checkbox - All SUVs'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/FilterBar/apply button'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 01'), 0, FailureHandling.STOP_ON_FAILURE)

dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 1'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

'dropdown should default to ALL STYLES'
WebUI.verifyNotMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.STOP_ON_FAILURE)

offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

'model name in offer card content should match selected model-style, and includes fallback in case trim only has consolidated/military/college grad offers'
textWithoutModel = ((((offerCardText - dropdownText) - 'MILITARY REBATE') - 'COLLEGE') - 'SELECT')

WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

'tests this model-style if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 2'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

    dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 2'), FailureHandling.STOP_ON_FAILURE)

    WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 2'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 2'), FailureHandling.STOP_ON_FAILURE)

    'tests this model-style if it is present'
    if (WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.OPTIONAL)
    }
    
    offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

    'model name in offer card content should match selected model-style, and includes fallback in case trim only has consolidated/military/college grad offers'
    textWithoutModel = ((((offerCardText - dropdownText) - 'MILITARY REBATE') - 'COLLEGE') - 'SELECT')

    WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

    'tests this model-style if it is present'
    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 3'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

        dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 3'), FailureHandling.STOP_ON_FAILURE)

        WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 3'), FailureHandling.OPTIONAL)

        WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 3'), FailureHandling.STOP_ON_FAILURE)

        'tests this model-style if it is present'
        if (WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 3, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.OPTIONAL)
        }
        
        offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

        'model name in offer card content should match selected model-style, and includes fallback in case trim only has consolidated/military/college grad offers'
        textWithoutModel = ((((offerCardText - dropdownText) - 'MILITARY REBATE') - 'COLLEGE') - 'SELECT')

        WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

        'tests this model-style if it is present'
        if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 4'), 3, 
            FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

            dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 4'), 
                FailureHandling.STOP_ON_FAILURE)

            WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 4'), FailureHandling.OPTIONAL)

            WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 4'), FailureHandling.STOP_ON_FAILURE)

            'tests this model-style if it is present'
            if (WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 3, 
                FailureHandling.OPTIONAL)) {
                WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.OPTIONAL)
            }
            
            offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

            'model name in offer card content should match selected model-style, and includes fallback in case trim only has consolidated/military/college grad offers'
            textWithoutModel = ((((offerCardText - dropdownText) - 'MILITARY REBATE') - 'COLLEGE') - 'SELECT')

            WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

            'tests this model-style if it is present'
            if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 5'), 
                3, FailureHandling.OPTIONAL)) {
                WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 5'), 
                    FailureHandling.STOP_ON_FAILURE)

                WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 5'), FailureHandling.OPTIONAL)

                WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 5'), FailureHandling.STOP_ON_FAILURE)

                'tests this model-style if it is present'
                if (WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 
                    3, FailureHandling.OPTIONAL)) {
                    WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.OPTIONAL)
                }
                
                offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

                'model name in offer card content should match selected model-style, and includes fallback in case trim only has consolidated/military/college grad offers'
                textWithoutModel = ((((offerCardText - dropdownText) - 'MILITARY REBATE') - 'COLLEGE') - 'SELECT')

                WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

                'tests this model-style if it is present'
                if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 6'), 
                    3, FailureHandling.OPTIONAL)) {
                    WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                    dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 6'), 
                        FailureHandling.STOP_ON_FAILURE)

                    WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 6'), FailureHandling.OPTIONAL)

                    WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 6'), FailureHandling.STOP_ON_FAILURE)

                    'tests this model-style if it is present'
                    if (WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 
                        3, FailureHandling.OPTIONAL)) {
                        WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.OPTIONAL)
                    }
                    
                    offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 
                        FailureHandling.STOP_ON_FAILURE)

                    'model name in offer card content should match selected model-style, and includes fallback in case trim only has consolidated/military/college grad offers'
                    textWithoutModel = ((((offerCardText - dropdownText) - 'MILITARY REBATE') - 'COLLEGE') - 'SELECT')

                    WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

                    'tests this model-style if it is present'
                    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 7'), 
                        3, FailureHandling.OPTIONAL)) {
                        WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                        dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 7'), 
                            FailureHandling.STOP_ON_FAILURE)

                        WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 7'), 
                            FailureHandling.OPTIONAL)

                        WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 7'), FailureHandling.STOP_ON_FAILURE)

                        'tests this model-style if it is present'
                        if (WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 
                            3, FailureHandling.OPTIONAL)) {
                            WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.OPTIONAL)
                        }
                        
                        offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 
                            FailureHandling.STOP_ON_FAILURE)

                        'model name in offer card content should match selected model-style, and includes fallback in case trim only has consolidated/military/college grad offers'
                        textWithoutModel = ((((offerCardText - dropdownText) - 'MILITARY REBATE') - 'COLLEGE') - 'SELECT')

                        WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)

                        'tests this model-style if it is present'
                        if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 8'), 
                            3, FailureHandling.OPTIONAL)) {
                            WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                            dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 8'), 
                                FailureHandling.STOP_ON_FAILURE)

                            WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 8'), 
                                FailureHandling.OPTIONAL)

                            WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - dropdown button - model-style 8'), 
                                FailureHandling.STOP_ON_FAILURE)

                            'tests this model-style if it is present'
                            if (WebUI.verifyElementNotPresent(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 
                                3, FailureHandling.OPTIONAL)) {
                                WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - details button'), FailureHandling.OPTIONAL)
                            }
                            
                            offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - offer card 1 - details'), 
                                FailureHandling.STOP_ON_FAILURE)

                            'model name in offer card content should match selected model-style, and includes fallback in case trim only has consolidated/military/college grad offers'
                            textWithoutModel = ((((offerCardText - dropdownText) - 'MILITARY REBATE') - 'COLLEGE') - 'SELECT')

                            WebUI.verifyNotMatch(offerCardText, textWithoutModel, false, FailureHandling.STOP_ON_FAILURE)
                        }
                    }
                }
            }
        }
    }
}

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 03'), 3, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0, FailureHandling.STOP_ON_FAILURE)

    dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 03 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

    WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 03 - dropdown button'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('OffersPage/OfferRow/row 03 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 03 - dropdown button - model-style 1'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('OffersPage/OfferRow/row 03 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

    dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 03 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

    'dropdown should default to ALL STYLES'
    WebUI.verifyNotMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('OffersPage/OfferRow/row 03 - details button'), FailureHandling.STOP_ON_FAILURE)

    offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 03 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

    'tests this offer row if it is present'
    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 04'), 3, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 03'), 0, FailureHandling.STOP_ON_FAILURE)

        dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 04 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

        WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 04 - dropdown button'), FailureHandling.OPTIONAL)

        WebUI.click(findTestObject('OffersPage/OfferRow/row 04 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

        WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 04 - dropdown button - model-style 1'), FailureHandling.OPTIONAL)

        WebUI.click(findTestObject('OffersPage/OfferRow/row 04 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

        dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 04 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

        'dropdown should default to ALL STYLES'
        WebUI.verifyNotMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('OffersPage/OfferRow/row 04 - details button'), FailureHandling.STOP_ON_FAILURE)

        offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 04 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

        'tests this offer row if it is present'
        if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 05'), 3, FailureHandling.OPTIONAL)) {
            WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 04'), 0, FailureHandling.STOP_ON_FAILURE)

            dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 05 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

            WebUI.verifyMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

            WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 05 - dropdown button'), FailureHandling.OPTIONAL)

            WebUI.click(findTestObject('OffersPage/OfferRow/row 05 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

            WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 05 - dropdown button - model-style 1'), FailureHandling.OPTIONAL)

            WebUI.click(findTestObject('OffersPage/OfferRow/row 05 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

            dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 05 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

            'dropdown should default to ALL STYLES'
            WebUI.verifyNotMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('OffersPage/OfferRow/row 05 - details button'), FailureHandling.STOP_ON_FAILURE)

            offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 05 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

            'tests this offer row if it is present'
            if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 06'), 3, FailureHandling.OPTIONAL)) {
                WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 05'), 0, FailureHandling.STOP_ON_FAILURE)

                dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 06 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                WebUI.verifyMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

                WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 06 - dropdown button'), FailureHandling.OPTIONAL)

                WebUI.click(findTestObject('OffersPage/OfferRow/row 06 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 06 - dropdown button - model-style 1'), FailureHandling.OPTIONAL)

                WebUI.click(findTestObject('OffersPage/OfferRow/row 06 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

                dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 06 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                'dropdown should default to ALL STYLES'
                WebUI.verifyNotMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

                WebUI.click(findTestObject('OffersPage/OfferRow/row 06 - details button'), FailureHandling.STOP_ON_FAILURE)

                offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 06 - offer card 1 - details'), FailureHandling.STOP_ON_FAILURE)

                'tests this offer row if it is present'
                if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 07'), 3, FailureHandling.OPTIONAL)) {
                    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 06'), 0, FailureHandling.STOP_ON_FAILURE)

                    dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 07 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                    WebUI.verifyMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

                    WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 07 - dropdown button'), FailureHandling.OPTIONAL)

                    WebUI.click(findTestObject('OffersPage/OfferRow/row 07 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                    WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 07 - dropdown button - model-style 1'), FailureHandling.OPTIONAL)

                    WebUI.click(findTestObject('OffersPage/OfferRow/row 07 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

                    dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 07 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                    'dropdown should default to ALL STYLES'
                    WebUI.verifyNotMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

                    WebUI.click(findTestObject('OffersPage/OfferRow/row 07 - details button'), FailureHandling.STOP_ON_FAILURE)

                    offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 07 - offer card 1 - details'), 
                        FailureHandling.STOP_ON_FAILURE)

                    'tests this offer row if it is present'
                    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 08'), 3, FailureHandling.OPTIONAL)) {
                        WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 07'), 0, FailureHandling.STOP_ON_FAILURE)

                        dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 08 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                        WebUI.verifyMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

                        WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 08 - dropdown button'), FailureHandling.OPTIONAL)

                        WebUI.click(findTestObject('OffersPage/OfferRow/row 08 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                        WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 08 - dropdown button - model-style 1'), 
                            FailureHandling.OPTIONAL)

                        WebUI.click(findTestObject('OffersPage/OfferRow/row 08 - dropdown button - model-style 1'), FailureHandling.STOP_ON_FAILURE)

                        dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 08 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                        'dropdown should default to ALL STYLES'
                        WebUI.verifyNotMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

                        WebUI.click(findTestObject('OffersPage/OfferRow/row 08 - details button'), FailureHandling.STOP_ON_FAILURE)

                        offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 08 - offer card 1 - details'), 
                            FailureHandling.STOP_ON_FAILURE)

                        'tests this offer row if it is present'
                        if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 09'), 3, FailureHandling.OPTIONAL)) {
                            WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 08'), 0, FailureHandling.STOP_ON_FAILURE)

                            dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 09 - dropdown button'), 
                                FailureHandling.STOP_ON_FAILURE)

                            WebUI.verifyMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

                            WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 09 - dropdown button'), FailureHandling.OPTIONAL)

                            WebUI.click(findTestObject('OffersPage/OfferRow/row 09 - dropdown button'), FailureHandling.STOP_ON_FAILURE)

                            WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 09 - dropdown button - model-style 1'), 
                                FailureHandling.OPTIONAL)

                            WebUI.click(findTestObject('OffersPage/OfferRow/row 09 - dropdown button - model-style 1'), 
                                FailureHandling.STOP_ON_FAILURE)

                            dropdownText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 09 - dropdown button'), 
                                FailureHandling.STOP_ON_FAILURE)

                            'dropdown should default to ALL STYLES'
                            WebUI.verifyNotMatch(dropdownText, 'ALL STYLES', false, FailureHandling.STOP_ON_FAILURE)

                            WebUI.click(findTestObject('OffersPage/OfferRow/row 09 - details button'), FailureHandling.STOP_ON_FAILURE)

                            offerCardText = WebUI.getText(findTestObject('OffersPage/OfferRow/row 09 - offer card 1 - details'), 
                                FailureHandling.STOP_ON_FAILURE)
                        }
                    }
                }
            }
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

