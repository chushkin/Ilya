package pages;


import org.testng.Assert;

import components.common.AbstractBaseComponent;

/**
 * Created by eugene on 26.03.2016.
 */
public class BasePage extends AbstractBaseComponent implements PageInterface{

    private String url;
    
    public void setUrl(String url) {
        this.url = url;
    }

    public void open() {
        getDriver().get(getUrl());
    }

    protected String getUrl() {
        return url;
    }

    public void  assertCurrentPage() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains(getUrl()), "Wrong URL for page: " + this.getClass().getSimpleName());
    }

}
