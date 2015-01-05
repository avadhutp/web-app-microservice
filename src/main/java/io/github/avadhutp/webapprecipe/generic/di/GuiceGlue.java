package io.github.avadhutp.webapprecipe.generic.di;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Ties all the guice modules together.
 * 
 * @author aphatarpekar
 */
public class GuiceGlue extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new Module[] { new ControllerWiring() });
    }

}
