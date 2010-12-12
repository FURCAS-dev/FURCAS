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
package org.eclipse.ocl.examples.impactanalyzer.debug;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.ocl.examples.impactanalyzer.debug.extraction.BranchingNavigationStepGraphExtractor;
import org.eclipse.ocl.examples.impactanalyzer.debug.extraction.EmptyResultNavigationStepGraphExtractor;
import org.eclipse.ocl.examples.impactanalyzer.debug.extraction.GraphExtractor;
import org.eclipse.ocl.examples.impactanalyzer.debug.extraction.GraphExtractorNotImplementedException;
import org.eclipse.ocl.examples.impactanalyzer.debug.extraction.IndirectingStepGraphExtractor;
import org.eclipse.ocl.examples.impactanalyzer.debug.extraction.NavigationStepGraphExtractor;
import org.eclipse.ocl.examples.impactanalyzer.debug.extraction.NavigationStepSequenceGraphExtractor;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.AbstractNavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.BranchingNavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.EmptyResultNavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.IndirectingStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStep;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStepSequence;

import y.io.GraphMLIOHandler;
import y.io.graphml.KeyScope;
import y.io.graphml.KeyType;



/**
 * This class provides the functionality to generate a GraphML file out of an NavigationStep object.
 * This GraphML file can be opened with the tool yEd to view the generated graph visualization. 
 * Within the debugger you can generate the GraphML file by calling the method printGraphFile(). 
 * 
 * @author Manuel Holzleitner (d049667)
 */
public class NavigationStepDebugHelperImpl {
    
    public static void printGraphFile(NavigationStep step, String path){
	GraphContext graphContext = new GraphContext();
	graphContext.setNestingActive(false);

	GraphExtractor extractor = createGraphExtractorForNavigationStep(step);
		
	extractor.buildGraph(graphContext);
	
	//The count coloring can only be applied if the navigate() method was called on the first level navigation step
	if(extractor.hasBeenNavigated()){
	    GraphInformationApplicator informationApplicator = new GraphInformationApplicator(graphContext);
	    
	    informationApplicator.applyNavigationCountColoring(step);
	    informationApplicator.applyAllEdgeLabels();
	}
	
	printGraph(graphContext, path);
    }
    
    /**
     * Instantiates a @link{GraphExtractor} object according to the type of a NavigationStep
     * 
     * @param navigationStep @link{NavigationStep} for which a Extractor should be created
     * @return Instance of GraphExtractor according to @link{NavigationStep} type
     *  */
    public static GraphExtractor createGraphExtractorForNavigationStep(NavigationStep navigationStep){
	if(navigationStep instanceof BranchingNavigationStep){
	    return new BranchingNavigationStepGraphExtractor((BranchingNavigationStep) navigationStep);
	}else if(navigationStep instanceof NavigationStepSequence){
	    return new NavigationStepSequenceGraphExtractor((NavigationStepSequence) navigationStep);
	}else if(navigationStep instanceof IndirectingStep){
	    return new IndirectingStepGraphExtractor( (IndirectingStep) navigationStep);
	}else if(navigationStep instanceof AbstractNavigationStep){
	    return new NavigationStepGraphExtractor(navigationStep); 
	}else if(navigationStep instanceof EmptyResultNavigationStep){
	    return new EmptyResultNavigationStepGraphExtractor(navigationStep);	
	}else{
	    throw new GraphExtractorNotImplementedException(navigationStep.getClass().toString());
	}
    }
    
    public static void printToString(NavigationStep step, String path) {
	BufferedWriter writer = null;

	File f = new File(path);
	try {
	    f.createNewFile();
	} catch (IOException e) {
	    e.printStackTrace();
	}

	try {
	    writer = new BufferedWriter(new FileWriter(path));
	    writer.write(step.toString());
	    writer.flush();
	    writer.close();

	    System.out.println("ToString was printed to " + path);
	} catch (IOException ioEx) {
	    System.out.println("ToString is not printed because of an IOException");
	}
    }
    
    @SuppressWarnings("unused") //TODO: Provide a public getGraphAsString method
    private static String getGraphAsString(GraphContext context) {
	OutputStream stringOutputStream = new ByteArrayOutputStream();

	// Instantiate a GraphML I/O handler and write the graph to string.
	try {
	    serializeGraphToOutputStream(context, stringOutputStream);
	} catch (IOException ioEx) {
	    throw new RuntimeException("There should not be an IOExpcetion on writing to a string output stream");
	}

	return stringOutputStream.toString();
    }

    /**
     * Instantiate a GraphML I/O handler and write the graph to string
     */
    private static void serializeGraphToOutputStream(GraphContext context, OutputStream outputStream) throws IOException {
	GraphMLIOHandler ioh = new GraphMLIOHandler();

	// Enable serialization of description text (e.g. OclExpression info) of
	// nodes
	ioh.getGraphMLHandler().addOutputDataProvider("description", context.getNodeDescription(), KeyScope.NODE, KeyType.STRING);

	ioh.write(context.getGraph2D(), outputStream);
    }

    private static void printGraph(GraphContext context, String path) {
	OutputStream fileOutputStream = createFileOutputStream(path);

	if (fileOutputStream != null) {
	    try {

		serializeGraphToOutputStream(context, fileOutputStream);

		fileOutputStream.flush();
		fileOutputStream.close();

		System.out.println("Graph file was printed to " + path);
	    } catch (IOException ioEx) {
		System.out.println("Graph File is not printed because of an IOException");
	    }
	}
    }

    private static OutputStream createFileOutputStream(String path) {
	OutputStream fileOutputStream = null;
	
	try {
	    File f = new File(path);
	    try {
		f.getParentFile().mkdirs();
		f.createNewFile();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    fileOutputStream = new FileOutputStream(f);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	
	return fileOutputStream;
    }
}
