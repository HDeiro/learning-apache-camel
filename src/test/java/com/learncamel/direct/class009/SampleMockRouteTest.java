package com.learncamel.direct.class009;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleMockRouteTest extends CamelTestSupport {
    @Override
    public RouteBuilder createRouteBuilder() {
        return new SampleMockRoute();
    }

    @Test
    public void sampleMockRouteTest() throws InterruptedException {
        String input = "Hello =)";

        //A mock can be used as an expected Endpoint to assert if a sent value is correct
        MockEndpoint mock = super.getMockEndpoint("mock:output");
        //Here you set the expected body for the Endpoint
        mock.expectedBodiesReceived(input);
        //Here you send a direct body through direct value
        super.template.sendBody("direct:sampleInput", "Hello =)");
        //Here you assert if the mock Endpoints were satisfied
        assertMockEndpointsSatisfied();
    }
}
