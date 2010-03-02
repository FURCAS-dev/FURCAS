package com.sap.tc.moin.ocl.ia.instancescope.debug;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import y.io.GraphMLIOHandler;
import y.io.graphml.KeyScope;
import y.io.graphml.KeyType;

import com.sap.tc.moin.ocl.ia.instancescope.AbstractNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.BranchingNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.EmptyResultNavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.IndirectingStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStepSequence;
import com.sap.tc.moin.ocl.ia.instancescope.debug.extraction.BranchingNavigationStepGraphExtractor;
import com.sap.tc.moin.ocl.ia.instancescope.debug.extraction.EmptyResultNavigationStepGraphExtractor;
import com.sap.tc.moin.ocl.ia.instancescope.debug.extraction.GraphExtractor;
import com.sap.tc.moin.ocl.ia.instancescope.debug.extraction.GraphExtractorNotImplementedException;
import com.sap.tc.moin.ocl.ia.instancescope.debug.extraction.IndirectingStepGraphExtractor;
import com.sap.tc.moin.ocl.ia.instancescope.debug.extraction.NavigationStepGraphExtractor;
import com.sap.tc.moin.ocl.ia.instancescope.debug.extraction.NavigationStepSequenceGraphExtractor;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * This class provides the functionality to generate a GraphML file out of an NavigationStep object.
 * This GraphML file can be opened with the tool yEd to view the generated graph visualization. 
 * Within the debugger you can generate the GraphML file by calling the method printGraphFile(). 
 * 
 * @author Manuel Holzleitner (d049667)
 */
public class NavigationStepDebugHelperImpl {
    
    public static void printGraphFile(NavigationStep step, CoreConnection conn, String path){
	GraphContext graphContext = new GraphContext();
	graphContext.setNestingActive(false);

	GraphExtractor extractor = createGraphExtractorForNavigationStep(step);
		
	extractor.buildGraph(graphContext);
	
	//The count coloring can only be applied if the navigate() method was called on the first level navigation step
	if(extractor.hasBeenNavigated()){
	    GraphInformationApplicator informationApplicator = new GraphInformationApplicator(graphContext);
	    
	    informationApplicator.applyNavigationCountColoring(step);
        	
	    if(conn != null)
        	informationApplicator.applyOclInformation(conn);
	    
	    //TODO: Test and correct type labeling
	    //informationApplicator.applyAllEdgeLabels();
	}
	
	printGraph(graphContext, path);
    }
    
    public static void printGraphFile(NavigationStep step, String path){
	printGraphFile(step, null, path);
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

    private static void serializeGraphToOutputStream(GraphContext context, OutputStream outputStream) throws IOException {
	GraphMLIOHandler ioh = new GraphMLIOHandler();

	// Enable serialization of description text (e.g. OclExpression info) of
	// nodes
	ioh.getGraphMLHandler().addOutputDataProvider("description", context.getNodeDescription(), KeyScope.NODE, KeyType.STRING);

	ioh.write(context.getGraph2D(), outputStream);

    }

    private static void printGraph(GraphContext context, String path) {
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

	if (fileOutputStream != null) {

	    // Instantiate a GraphML I/O handler and write the graph to string.
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
}
