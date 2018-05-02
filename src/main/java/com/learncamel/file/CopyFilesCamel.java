package com.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamel {

    public static void main(String[] args) {
        //Gets apache camel context
        CamelContext context = new DefaultCamelContext();

        try {
            //Add a new route configuration through a Route Builder
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    /*
                        This "noop=true" query parameter is used to maintain the files at the source.
                        Without this, the files should be moved to /input/.camel/[files] after they
                        get copied to /output/[files]
                     */

                    from("file:data/input?noop=true")
                            .to("file:data/output");
                }
            });

            //Start context and it's routes
            context.start();

            Thread.sleep(3000);

            //Stop context and it's routes
            context.stop();
        } catch(Exception e) {
            System.out.println("Exception is: " + e);
            e.printStackTrace();
        }
    }
}
