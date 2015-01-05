package io.github.avadhutp.webapprecipe.generic.di;

import io.github.avadhutp.webapprecipe.generic.DefaultController;

import com.google.inject.servlet.ServletModule;

/**
 * You can wire up your controllers (for the application) here.
 * 
 * @author aphatarpekar
 */
public class ControllerWiring extends ServletModule {

    /*
     * (non-Javadoc)
     * 
     * @see com.google.inject.servlet.ServletModule#configureServlets()
     */
    @Override
    protected void configureServlets() {
        serve("/").with(DefaultController.class);
    }

}
