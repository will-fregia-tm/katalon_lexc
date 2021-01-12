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

WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers', FailureHandling.STOP_ON_FAILURE)

'This is a workaround in case LAM-2532 occurs.'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/expand CTA'), 3, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('OffersPage/ZipBar/change market CTA'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('OffersPage/ZipBar/zip entry field'), '08008')

    WebUI.click(findTestObject('OffersPage/ZipBar/search icon'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('OffersPage/SharedMarketOverlay/shared zip overlay'), 5, FailureHandling.OPTIONAL)

    WebUI.verifyElementPresent(findTestObject('OffersPage/SharedMarketOverlay/shared zip overlay'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('OffersPage/SharedMarketOverlay/X button'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/form input'), 5, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('OffersPage/ZipGate/form input'), '75218')

WebUI.click(findTestObject('OffersPage/ZipGate/submit button'))

WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 5, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.STOP_ON_FAILURE)

'tests this offer row if it is present'
if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02'), 3, FailureHandling.OPTIONAL)) {
    WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 02 - Build'), 0, FailureHandling.STOP_ON_FAILURE)

    rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 02 - model name'), FailureHandling.STOP_ON_FAILURE)

    'removes HYBRID because model page title casing may differ'
    rowModel = (rowModel - ' HYBRID')

    'removes CONVERTIBLE because model page title casing may differ'
    rowModel = (rowModel - ' CONVERTIBLE')

    href = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 02 - Build'), 'href', FailureHandling.STOP_ON_FAILURE)

    WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 02 - Build'), FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('OffersPage/OfferRow/row 02 - Build'), FailureHandling.STOP_ON_FAILURE)

    WebUI.navigateToUrl(href, FailureHandling.STOP_ON_FAILURE)

    'checks the current model year tab, if there is one'
    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/BYL current model year'), 3, FailureHandling.OPTIONAL)) {
        fontFamily = WebUI.getCSSValue(findTestObject('OffersPage/OfferRow/BYL current model year'), 'font-family')

        'current year should be selected and bold'
        modifiedString = (fontFamily - 'bold')

        WebUI.verifyNotMatch(fontFamily, modifiedString, false, FailureHandling.STOP_ON_FAILURE)
    }
    
    fontFamily = WebUI.getCSSValue(findTestObject('OffersPage/OfferRow/BYL current model year'), 'font-family')

    'current year should be selected and bold'
    modifiedString = (fontFamily - 'bold')

    WebUI.verifyNotMatch(fontFamily, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

    displayedTrims = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL trim display'), FailureHandling.STOP_ON_FAILURE)

    'model shown on BYL page should match model from offers row'
    modifiedString = (displayedTrims - rowModel)

    WebUI.verifyNotMatch(displayedTrims, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

    zipcode = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL zipcode'), FailureHandling.STOP_ON_FAILURE)

    'ZIP code on BYL page should match ZIP from offers page'
    modifiedString = (zipcode - '75218')

    WebUI.verifyNotMatch(zipcode, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

    WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers', FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.OPTIONAL)

    'tests this offer row if it is present'
    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 03'), 3, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 02'), 0, FailureHandling.STOP_ON_FAILURE)

        rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 03 - model name'), FailureHandling.STOP_ON_FAILURE)

        'removes HYBRID because model page title casing may differ'
        rowModel = (rowModel - ' HYBRID')

        'removes CONVERTIBLE because model page title casing may differ'
        rowModel = (rowModel - ' CONVERTIBLE')

        href = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 03 - Build'), 'href', FailureHandling.STOP_ON_FAILURE)

        WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 03 - Build'), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('OffersPage/OfferRow/row 03 - Build'), FailureHandling.STOP_ON_FAILURE)

        WebUI.navigateToUrl(href, FailureHandling.STOP_ON_FAILURE)

        'checks the current model year tab, if there is one'
        if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/BYL current model year'), 3, FailureHandling.OPTIONAL)) {
            fontFamily = WebUI.getCSSValue(findTestObject('OffersPage/OfferRow/BYL current model year'), 'font-family')

            'current year should be selected and bold'
            modifiedString = (fontFamily - 'bold')

            WebUI.verifyNotMatch(fontFamily, modifiedString, false, FailureHandling.STOP_ON_FAILURE)
        }
        
        displayedTrims = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL trim display'), FailureHandling.STOP_ON_FAILURE)

        'model shown on BYL page should match model from offers row'
        modifiedString = (displayedTrims - rowModel)

        WebUI.verifyNotMatch(displayedTrims, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

        zipcode = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL zipcode'), FailureHandling.STOP_ON_FAILURE)

        'ZIP code on BYL page should match ZIP from offers page'
        modifiedString = (zipcode - '75218')

        WebUI.verifyNotMatch(zipcode, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

        WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers', FailureHandling.STOP_ON_FAILURE)

        WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.OPTIONAL)

        'tests this offer row if it is present'
        if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 04'), 3, FailureHandling.OPTIONAL)) {
            WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 03'), 0, FailureHandling.STOP_ON_FAILURE)

            rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 04 - model name'), FailureHandling.STOP_ON_FAILURE)

            'removes HYBRID because model page title casing may differ'
            rowModel = (rowModel - ' HYBRID')

            'removes CONVERTIBLE because model page title casing may differ'
            rowModel = (rowModel - ' CONVERTIBLE')

            href = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 04 - Build'), 'href', FailureHandling.STOP_ON_FAILURE)

            WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 04 - Build'), FailureHandling.STOP_ON_FAILURE)

            WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

            WebUI.click(findTestObject('OffersPage/OfferRow/row 04 - Build'), FailureHandling.STOP_ON_FAILURE)

            WebUI.navigateToUrl(href, FailureHandling.STOP_ON_FAILURE)

            'checks the current model year tab, if there is one'
            if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/BYL current model year'), 3, FailureHandling.OPTIONAL)) {
                fontFamily = WebUI.getCSSValue(findTestObject('OffersPage/OfferRow/BYL current model year'), 'font-family')

                'current year should be selected and bold'
                modifiedString = (fontFamily - 'bold')

                WebUI.verifyNotMatch(fontFamily, modifiedString, false, FailureHandling.STOP_ON_FAILURE)
            }
            
            displayedTrims = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL trim display'), FailureHandling.STOP_ON_FAILURE)

            'model shown on BYL page should match model from offers row'
            modifiedString = (displayedTrims - rowModel)

            WebUI.verifyNotMatch(displayedTrims, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

            zipcode = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL zipcode'), FailureHandling.STOP_ON_FAILURE)

            'ZIP code on BYL page should match ZIP from offers page'
            modifiedString = (zipcode - '75218')

            WebUI.verifyNotMatch(zipcode, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

            WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers', FailureHandling.STOP_ON_FAILURE)

            WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.OPTIONAL)

            'tests this offer row if it is present'
            if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 05'), 3, FailureHandling.OPTIONAL)) {
                WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 04'), 0, FailureHandling.STOP_ON_FAILURE)

                rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 05 - model name'), FailureHandling.STOP_ON_FAILURE)

                'removes HYBRID because model page title casing may differ'
                rowModel = (rowModel - ' HYBRID')

                'removes CONVERTIBLE because model page title casing may differ'
                rowModel = (rowModel - ' CONVERTIBLE')

                href = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 05 - Build'), 'href', FailureHandling.STOP_ON_FAILURE)

                WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 05 - Build'), FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                WebUI.click(findTestObject('OffersPage/OfferRow/row 05 - Build'), FailureHandling.STOP_ON_FAILURE)

                WebUI.navigateToUrl(href, FailureHandling.STOP_ON_FAILURE)

                'checks the current model year tab, if there is one'
                if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/BYL current model year'), 3, FailureHandling.OPTIONAL)) {
                    fontFamily = WebUI.getCSSValue(findTestObject('OffersPage/OfferRow/BYL current model year'), 'font-family')

                    'current year should be selected and bold'
                    modifiedString = (fontFamily - 'bold')

                    WebUI.verifyNotMatch(fontFamily, modifiedString, false, FailureHandling.STOP_ON_FAILURE)
                }
                
                displayedTrims = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL trim display'), FailureHandling.STOP_ON_FAILURE)

                'model shown on BYL page should match model from offers row'
                modifiedString = (displayedTrims - rowModel)

                WebUI.verifyNotMatch(displayedTrims, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

                zipcode = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL zipcode'), FailureHandling.STOP_ON_FAILURE)

                'ZIP code on BYL page should match ZIP from offers page'
                modifiedString = (zipcode - '75218')

                WebUI.verifyNotMatch(zipcode, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

                WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers', FailureHandling.STOP_ON_FAILURE)

                WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.OPTIONAL)

                'tests this offer row if it is present'
                if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/row 06'), 3, FailureHandling.OPTIONAL)) {
                    WebUI.scrollToElement(findTestObject('OffersPage/OfferRow/row 05'), 0, FailureHandling.STOP_ON_FAILURE)

                    rowModel = WebUI.getText(findTestObject('OffersPage/OfferRow/row 06 - model name'), FailureHandling.STOP_ON_FAILURE)

                    'removes HYBRID because model page title casing may differ'
                    rowModel = (rowModel - ' HYBRID')

                    'removes CONVERTIBLE because model page title casing may differ'
                    rowModel = (rowModel - ' CONVERTIBLE')

                    href = WebUI.getAttribute(findTestObject('OffersPage/OfferRow/row 06 - Build'), 'href', FailureHandling.STOP_ON_FAILURE)

                    WebUI.mouseOver(findTestObject('OffersPage/OfferRow/row 06 - Build'), FailureHandling.STOP_ON_FAILURE)

                    WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

                    WebUI.click(findTestObject('OffersPage/OfferRow/row 06 - Build'), FailureHandling.STOP_ON_FAILURE)

                    WebUI.navigateToUrl(href, FailureHandling.STOP_ON_FAILURE)

                    'checks the current model year tab, if there is one'
                    if (WebUI.verifyElementPresent(findTestObject('OffersPage/OfferRow/BYL current model year'), 3, FailureHandling.OPTIONAL)) {
                        fontFamily = WebUI.getCSSValue(findTestObject('OffersPage/OfferRow/BYL current model year'), 'font-family')

                        'current year should be selected and bold'
                        modifiedString = (fontFamily - 'bold')

                        WebUI.verifyNotMatch(fontFamily, modifiedString, false, FailureHandling.STOP_ON_FAILURE)
                    }
                    
                    displayedTrims = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL trim display'), FailureHandling.STOP_ON_FAILURE)

                    'model shown on BYL page should match model from offers row'
                    modifiedString = (displayedTrims - rowModel)

                    WebUI.verifyNotMatch(displayedTrims, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

                    zipcode = WebUI.getText(findTestObject('OffersPage/OfferRow/BYL zipcode'), FailureHandling.STOP_ON_FAILURE)

                    'ZIP code on BYL page should match ZIP from offers page'
                    modifiedString = (zipcode - '75218')

                    WebUI.verifyNotMatch(zipcode, modifiedString, false, FailureHandling.STOP_ON_FAILURE)

                    WebUI.navigateToUrl(GlobalVariable.SC_Domain + '/offers', FailureHandling.STOP_ON_FAILURE)

                    WebUI.waitForElementPresent(findTestObject('OffersPage/ZipGate/offers page with offers'), 0, FailureHandling.OPTIONAL)
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

