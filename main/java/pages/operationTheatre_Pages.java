package pages;

import java.util.Map;
import org.openqa.selenium.*;

import coreUtilities.utils.CommonEvents;

public class operationTheatre_Pages {

    WebDriver d;
    CommonEvents ce;

    // very short locators
    By u = By.id("username_id");
    By p = By.id("password");
    By l = By.id("login");
    By reg = By.xpath("//p[contains(text(),'Registered Patient')]");
    By ot = By.xpath("//span[.='OperationTheatre']");
    By hosp = By.xpath("//span[contains(text(),'Hospital Number')]");
    By newot = By.xpath("//button[contains(text(),'New OT Booking')]");
    By book = By.xpath("//span[contains(text(),'Booking OT Schedule')]");
    By pat = By.id("srch_PatientList");
    By diag = By.id("Diagnosis");
    By surg = By.id("surgeryType");
    By remarks = By.id("remarks");
    By doc = By.id("id_input_currentRequestedByDoctor_selectReferral");
    By docbtn = By.xpath("//ul[@class='select-list']//li[1]");
    By ext = By.xpath("//label[@class='is-ref mt-checkbox mt-checkbox-outline']//span");
    By plus = By.xpath("//a[@class='btn blue btn-xs btn-ext']");
    By addext = By.xpath("//button[contains(text(),'Add')]");
    By err = By.xpath("//span[contains(text(),'Referrer Name is required')]");
    By rname = By.id("referrerName");
    By raddr = By.id("ExtRefferaddress");
    By rcont = By.id("contactNum");
    By remail = By.id("email");
    By inc = By.xpath("(//div[@class='icheck-inline']//span)[2]");
    By add = By.id("add");
    By msg1 = By.xpath("//p[@class='msg-status']");
    By msg2 = By.xpath("//p[@class='main-message']");

    public operationTheatre_Pages(WebDriver d){ 
        this.d = d; 
        this.ce = new CommonEvents(d);
    }

    // Test 1.1
    public boolean loginToHealthAppByGivenValidCredetial(Map<String,String> ed){
        ce.sendKeys(u, ed.get("username"));
        ce.sendKeys(p, ed.get("password"));
        ce.click(l);
        return ce.isDisplayed(reg);
    }
    // Test 1.2
    public String verifyTitleOfThePage() throws Exception {
        return ce.getTitle();
    }

    // Test 1.3
    public String verifyURLOfThePage() throws Exception {
        return ce.getCurrentUrl();
    }

    // Test 2
    public String goToOperationTheatreModuleVerifyTableHeaderName(){
        ce.click(ot);
        return ce.getText(hosp);
    }

 // Test 3
    public String verifyBookingOTScheduleFormByClickingOnNewOTBookingButton(){
        try { Thread.sleep(2000); } catch(Exception e){}
        ce.click(newot);
        try { Thread.sleep(2000); } catch(Exception e){}
        return ce.getText(book);
    }

    // Test 4
    public String verifyEnteredDataIsPresentInSelectPatientTextbox(Map<String,String> ed){
        ce.sendKeys(pat, ed.get("patientName"));
        ce.sendKeys(diag, ed.get("diagnosisValue"));
        ce.sendKeys(surg, ed.get("surgeryTypeValue"));
        return ce.getAttr(pat,"value");
    }

    // Test 5
    public String verifyPlaceholderNameOfTexboxIfTextboxIsEnabled(){
        return ce.getAttr(remarks,"placeholder");
    }

// // Test 6
//    public String verifyButtonIsPresentAfterSendValueToSurgenNameTextfield(Map<String,String> ed){
//        ce.sendKeys(doc, ed.get("surgenNameValue1"));
//        try { Thread.sleep(2000); } catch(Exception e){}
//        
//        // re-locate first visible suggestion dynamically
//        By firstSuggestion = By.xpath("//ul[contains(@class,'select-list')]//li[1]");
//        ce.click(firstSuggestion);
//        
//        return ce.getText(firstSuggestion);
//    }



    // Test 7
    public Boolean verifyPlusButtonIsPresentAfterClickOnExternalCheckbox(){
        ce.click(ext);
        return ce.isDisplayed(plus);
    }

    // Test 8
    public String verifyErrorMessageInAddExternalReferralForms(){
        ce.click(plus);
        ce.click(addext);
        return ce.getText(err);
    }

//    // Test 9 (fixed, short)
//    public String verifySuccessNotificationPopupMessage(Map<String,String> ed){
//        ce.click(plus);
//        ce.sendKeys(rname, ed.get("referrerName"));
//        ce.sendKeys(raddr, ed.get("ExtRefferaddress"));
//        ce.sendKeys(rcont, ed.get("contactNum"));
//        ce.sendKeys(remail, ed.get("email"));
//        ce.click(inc);
//        ce.click(add);
//        return ce.getText(msg1)+" "+ce.getText(msg2);
//    }
}