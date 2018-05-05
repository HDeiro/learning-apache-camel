package com.learncamel.direct.class008;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SampleDirectRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder() {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {
        super.template.sendBody("direct:directInput", "This is my direct content =)");

        Thread.sleep(5000);

        File file = new File("data/direct/output");
        assertTrue(file.isDirectory());

        Exchange exchange = super.consumer.receive("file:data/direct/output");
        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}
