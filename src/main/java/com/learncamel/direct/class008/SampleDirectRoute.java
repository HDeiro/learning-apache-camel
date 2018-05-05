package com.learncamel.direct.class008;

import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:directInput")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("file:data/direct/output?fileName=output.txt");
    }
}
