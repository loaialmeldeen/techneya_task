package com.Techneya_task.tests.drivers;

import com.Techneya_task.tests.utils.dataReader.PropertyReader;
import org.openqa.selenium.WebDriver;

public abstract class AbstractDriver {
    public abstract WebDriver createDriver();

    protected final String remoteHost = PropertyReader.getProperty("remoteHost");
    protected final String remotePort = PropertyReader.getProperty("remotePort");
}
