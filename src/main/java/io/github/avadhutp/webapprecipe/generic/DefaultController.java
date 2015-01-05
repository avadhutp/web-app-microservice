package io.github.avadhutp.webapprecipe.generic;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

/**
 * Sample default controller for all web-application requests.
 * 
 * @author aphatarpekar
 */
@Singleton
public class DefaultController extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultController.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(getIndexHtml());
    }

    /**
     * Get's the index.html file for the resources folder in the classpath.
     * 
     * @return
     */
    private String getIndexHtml() {
        try {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("index.html");
            StringWriter writer = new StringWriter();
            IOUtils.copy(is, writer);
            return writer.toString();
        } catch (Exception e) {
            LOGGER.error("Unable to load the index.html text.");
            return null;
        }
    }
}
