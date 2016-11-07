package com.netcracker.devcourses.sd4.service.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Konstantin on 30.10.16.
 */
public class JettyRunner {
    private static final int PORT = 8080;

    private static final Logger LOGGER = LoggerFactory.getLogger(JettyRunner.class);

    public static void main(String[] args) throws Exception {
        new JettyRunner().startJetty(PORT);
    }

    private void startJetty(int port) throws Exception {
        LOGGER.debug("Starting server at port {}", port);
        Server server = new Server(port);
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar("/Users/Konstantin/IdeaProjects/NCDevCourses/app-restapi/target/app-restapi.war");
        server.setHandler(webapp);
        server.start();
        LOGGER.debug("Server started at port {}", port);
        server.join();
    }
}
