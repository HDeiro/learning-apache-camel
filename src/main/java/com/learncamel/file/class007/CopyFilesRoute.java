package com.learncamel.file.class007;

import org.apache.camel.builder.RouteBuilder;

//Check test.java.com.learncamel.file.class007
public class CopyFilesRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:data/input?noop=true")
            .to("log:?level=INFO&showBody=true&showHeaders=true")
            .to("file:data/output");
    }
}
