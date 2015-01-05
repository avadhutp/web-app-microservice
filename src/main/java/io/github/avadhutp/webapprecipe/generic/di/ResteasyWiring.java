package io.github.avadhutp.webapprecipe.generic.di;

import io.github.avadhutp.webapprecipe.generic.controllers.SampleApi;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * Wiring for RestEASY stuff. It is important that this stuff go here, and not
 * in {@link ControllerWiring}, because this one extends
 * {@link JerseyServletModule} and not {@link ServletModule}.
 * 
 * @author aphatarpekar
 * 
 */
public class ResteasyWiring extends JerseyServletModule {

    @Override
    protected void configureServlets() {
        bind(SampleApi.class).in(Singleton.class);

        serve("/sample-api/*").with(GuiceContainer.class);
    }
}
