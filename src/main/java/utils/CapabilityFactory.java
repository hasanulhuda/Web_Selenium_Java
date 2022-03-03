package utils;

import org.openqa.selenium.Capabilities;
import utils.Utility;

public class CapabilityFactory {

    public Capabilities capabilities;
    public Capabilities getCapabilities (String browser) {
        if (browser.equals("firefox"))
            capabilities = Utility.getFirefoxOptions();
        else
            capabilities = Utility.getChromeOptions();
        return capabilities;
    }
}
