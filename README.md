# ys09-webapp
An example of a gradle-based webapp, demonstrating the use of gradle for developing a mixed java/grovy web application that can be deployed to tomcat.

## File structure

```
src
  main
    groovy                           the groovy code goes here
      gr
        uoa
          di
            ys09
              Configuartion.groovy  a singleton class to hold the configuration of the web app
              Listener.groovy       code that loads the configuration files when the web app starts
     java                           the java code goes here
      gr
        uoa
          di
            ys09
              Numbers.java          a helper class that processes numbers
              TestServlet           a simple servlet example
    webapp                          the directory of the web app 
      index.jsp                     a jsp example
      test.groovy                   the same example in a groovlet
      conf                          contains the configuration files of the web app
      static                        contains the static files of the web app (images, css, etc)
        logo.png
      WEB-INF                       contains the web app deployment descriptor file (web.xml) 
        web.xml
```

## Gradle commands

