//
// ========================================================================
// Copyright (c) 1995-2022 Mort Bay Consulting Pty Ltd and others.
//
// This program and the accompanying materials are made available under the
// terms of the Eclipse Public License v. 2.0 which is available at
// https://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
// which is available at https://www.apache.org/licenses/LICENSE-2.0.
//
// SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
// ========================================================================
//

package org.eclipse.jetty.ee10.demos;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jetty.ee10.servlet.DefaultServlet;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceFactory;

/**
 * Example of serving content from a JAR file.
 * The JAR file in this example does not belong to any Classpath.
 */
public class JarServer
{
    public static Server createServer(int port, Resource base) throws Exception
    {
        Server server = new Server(port);

        ServletContextHandler context = new ServletContextHandler();
        context.setBaseResource(base.getPath());
        context.addServlet(new ServletHolder(new DefaultServlet()), "/");

        server.setHandler(new Handler.Collection(context, new DefaultHandler()));
        return server;
    }

    public static void main(String[] args) throws Exception
    {
        int port = ExampleUtil.getPort(args, "jetty.http.port", 8080);

        Path jarFile = Paths.get("src/main/other/content.jar");
        if (!Files.exists(jarFile))
            throw new FileNotFoundException(jarFile.toString());

        try (ResourceFactory.Closeable resourceFactory = ResourceFactory.closeable())
        {
            Server server = createServer(port, resourceFactory.newResource(jarFile));
            server.start();
            server.join();
        }
    }
}
