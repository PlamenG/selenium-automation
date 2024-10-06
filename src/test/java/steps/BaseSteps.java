package steps;

import org.picocontainer.annotations.Inject;
import pages.LuckyBanditSports;
import setup.ChromeBrowserManager;

public class BaseSteps {
    @Inject
    private ChromeBrowserManager chromeBrowserManager;

    public ChromeBrowserManager getChromeBrowserManager(){
        return chromeBrowserManager;
    }
}
