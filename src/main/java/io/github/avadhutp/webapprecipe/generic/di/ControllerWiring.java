package io.github.avadhutp.webapprecipe.generic.di;

import io.github.avadhutp.webapprecipe.generic.controllers.SampleController;

import com.google.inject.Singleton;
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
        bind(SampleController.class).in(Singleton.class);

        serve("/default").with(SampleController.class);
    }
}
