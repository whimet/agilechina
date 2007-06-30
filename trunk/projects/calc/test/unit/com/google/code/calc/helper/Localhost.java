package com.google.code.calc.helper;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class Localhost {
    private static final int PORT = 9191;

    private final Server server;

    public static void main(String[] args) throws Exception {
        Localhost localhost = new Localhost();
        localhost.start();
    }

    public Localhost() {
        server = new Server(PORT);
        server.addHandler(new WebAppContext("webapp", "/"));
    }

    public void start() throws Exception {
        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }
}
