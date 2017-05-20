package gr.uoa.di.ys09

import javax.servlet.ServletContext
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.ServletException

class Listener implements ServletContextListener {

    @Override
    void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext ctx = servletContextEvent.getServletContext()

            Properties props = new Properties()

            Configuration.instance.contextPath = ctx.contextPath        	
            Configuration.instance.properties  = props 
            
            String pathToPropertiesInWebApp = ctx.getInitParameter("properties")
            if (pathToPropertiesInWebApp) {
        		String pathToPropertiesInFileSystem = ctx.getRealPath(pathToPropertiesInWebApp)

	            new File(pathToPropertiesInFileSystem).withInputStream { input ->
	            	props.load(input)
	            }
            }
        }
        catch(e) {
    		throw new ServletException(e.getMessage(), e)
        }
    }

    @Override
    void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

}