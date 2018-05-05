package com.learncamel.file.class007;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CopyFileRoutesTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CopyFilesRoute();
    }

    @Test
    public void checkFileExistsInOutputDirectory() throws InterruptedException {
        Thread.sleep(5000); //Just to give time to Camel create the directory

        File file = new File("data/output");

        assertTrue(file.isDirectory());
        assertEquals(3, file.listFiles().length);
    }
}
