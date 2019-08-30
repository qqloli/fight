package com.zj.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servlet context 开启");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
