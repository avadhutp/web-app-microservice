package io.github.avadhutp.webapprecipe.generic;

import io.github.avadhutp.webapprecipe.generic.di.GuiceGlue;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.servlet.GuiceFilter;

/**
 * The actual engine that runs the microservice.
 * 
 * @author aphatarpekar
 */
public class StartUp {

    private static final int PORT = 8090;

    public static void main(String[] args) {
        try {
            Server server = new Server(PORT);

            ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
            servletContextHandler.setContextPath("/");

            servletContextHandler.addEventListener(new GuiceGlue());

            servletContextHandler.addServlet(DefaultServlet.class, "/");
            servletContextHandler.addFilter(new FilterHolder(GuiceFilter.class), "/*", EnumSet.of(DispatcherType.REQUEST));

            Handler[] handlers = new Handler[] { servletContextHandler };
            HandlerList handlerList = new HandlerList();
            handlerList.setHandlers(handlers);

            server.setHandler(handlerList);

            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
