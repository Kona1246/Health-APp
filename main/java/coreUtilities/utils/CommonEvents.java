package coreUtilities.utils;

import org.openqa.selenium.*;

public class CommonEvents {
    WebDriver d;
    public CommonEvents(WebDriver d){ this.d = d; }

    public void click(By l){ d.findElement(l).click(); }
    public void sendKeys(By l, CharSequence... v){ d.findElement(l).sendKeys(v); }
    public String getText(By l){ return d.findElement(l).getText(); }
    public String getAttr(By l,String a){ return d.findElement(l).getAttribute(a); }
    public boolean isDisplayed(By l){ 
        try{ return d.findElement(l).isDisplayed(); }catch(Exception e){ return false; }
    }

	public void navigateTo(String url) {
		d.get(url);
		
	}

	public String getTitle() {
		return d.getTitle();
	}

	public String getCurrentUrl() {
		return d.getCurrentUrl();
	}
}