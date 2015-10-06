/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Riad YOUSFI
 */
@WebListener
public class ApplicationServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        Context context = null;
        try {
            context = new InitialContext();
            if (context == null) {
                throw new Exception("No Context!!!");
            } else {
                Logger.getLogger(ApplicationServletListener.class.getName()).log(Level.INFO, "Init Context");
            }

            DataSource dataSource = (DataSource) context.lookup("jdbc/authentication_db_data_source");

            if (dataSource == null) {
                throw new Exception("No DataSource!!!");
            } else {
                Logger.getLogger(ApplicationServletListener.class.getName()).log(Level.INFO, "Init DataSource");
            }

            ServletContext servletContext = event.getServletContext();
            servletContext.setAttribute("dataSource", dataSource);

        } catch (Exception ex) {
            Logger.getLogger(ApplicationServletListener.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (context != null) {
                try {
                    context.close();
                    Logger.getLogger(ApplicationServletListener.class.getName()).log(Level.INFO, "Context close");
                } catch (NamingException ex) {
                    Logger.getLogger(ApplicationServletListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        Logger.getLogger(ApplicationServletListener.class.getName()).log(Level.INFO, "Context Destroyed");
    }
}
