package com.learncamel.direct.class009;

import org.apache.camel.builder.RouteBuilder;

public class SampleMockRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received message is ${body} and Headers are ${headers}")
                .to("mock:output");
    }
}
