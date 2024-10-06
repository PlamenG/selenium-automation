package steps;

import org.picocontainer.annotations.Inject;
import setup.ChromeBrowserManager;

public class BaseSteps {
    @Inject
    private ChromeBrowserManager chromeBrowserManager;

    public ChromeBrowserManager getChromeBrowserManager(){
        return chromeBrowserManager;
    }
}
