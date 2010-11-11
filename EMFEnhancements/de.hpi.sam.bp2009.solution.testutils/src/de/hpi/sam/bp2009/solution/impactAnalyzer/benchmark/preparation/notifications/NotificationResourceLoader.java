/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class NotificationResourceLoader {
    public static final String MODEL_FIXTURE_LOCATION = "fixtures/models/";
    public static final String EVENTTRACE_FIXTURE_LOCATION = "fixtures/eventtraces/";

    public static XMLResource loadModel(String path) {
        String resourcePath = NotificationResourceLoader.MODEL_FIXTURE_LOCATION + path;

        ResourceSetImpl resultRS;
        resultRS = new ResourceSetImpl();
        resultRS.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        // TODO register ECrossReferenceAdapter only after model shrinking process has finished and before OCL evaluation starts
        ECrossReferenceAdapter adapter = new ECrossReferenceAdapter();
        resultRS.eAdapters().add(adapter);

        InputStream fileStream = RealWorldReplayNotificationProducer.class.getResourceAsStream(resourcePath);
        XMLResource instanceResource = readResourceOutOfStream(fileStream, resultRS);

        return instanceResource;
    }

    public static List<String> getFilenamesOfEventFixtures() {
        return getFileListOfDirectory(EVENTTRACE_FIXTURE_LOCATION);
    }

    public static List<String> getFilenamesOfModelFixture() {
        return getFileListOfDirectory(MODEL_FIXTURE_LOCATION);
    }

    private static List<String> getFileListOfDirectory(String directory) {
        ArrayList<String> result = new ArrayList<String>();

        URL url = NotificationResourceLoader.class.getResource(directory);
        File folder;
        try {
            if (url.getPath().startsWith("file:")) {
                folder = new File(URLDecoder.decode(url.getPath(), "UTF-8"));
            } else {
                folder = new File(url.getPath());
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        if (folder.listFiles() != null) {
            for (File file : folder.listFiles()) {
                result.add(file.getName());
            }
        }

        return result;
    }

    public static List<RawNotification> loadTrace(String path) {
        String resourcePath = NotificationResourceLoader.EVENTTRACE_FIXTURE_LOCATION + path;

        ArrayList<RawNotification> informationList = new ArrayList<RawNotification>();

        InputStream traceInput = NotificationResourceLoader.class.getResourceAsStream(resourcePath);
        InputStreamReader ireader = new InputStreamReader(traceInput);
        BufferedReader reader = new BufferedReader(ireader);

        try {
            while (reader.ready()) {
                String newLine = reader.readLine();
                String[] splitOnOpenBracket = newLine.split("\\(");
                String[] splitOnComma = splitOnOpenBracket[1].split("\\)")[0].split(",");

                HashMap<String, String> hashMap = new HashMap<String, String>();

                for (String attributePair : splitOnComma) {
                    String[] attributePairSplitted = attributePair.split("=");

                    hashMap.put(attributePairSplitted[0], attributePairSplitted[1]);
                }

                informationList.add(new RawNotification(splitOnOpenBracket[0], hashMap));
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return informationList;
    }

    private static XMLResource readResourceOutOfStream(InputStream fileStream, ResourceSetImpl resultRS) {
        XMLResource instanceResource = null;
        try {
            instanceResource = (XMLResource) resultRS.createResource(URI
                    .createURI("http://de.hpi.sam.bp2009.solution.impactAnalyzer.benchmarks/test.xmi"));
            instanceResource.load(fileStream, null);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        if (instanceResource == null)
            throw new RuntimeException("Not able to create resource");
        return instanceResource;
    }

}
