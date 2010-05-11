package de.hpi.sam.bp2009.solution.ocltomqlmapping.samplemenu.handlers;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.hpi.sam.bp2009.solution.ocltomqlmapping.AllInstancesQuery.AllInstancesQuery;

public class SampleHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String completeQuery= "context: PetriNet body: Place.allInstances()->select(p : Place| p.noTokens = 8)"; 
		// create Resource My.petriNet in Resourceset 
		ResourceSet resourceset=new ResourceSetImpl();
		Resource resource = resourceset.createResource(URI.createPlatformResourceURI("/test/My.petrinet", true));
		try {
			resource.load(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try{
		Object results = AllInstancesQuery.executeQueryOn(completeQuery, resource);
		if(results==null)
			System.out.println("Results null");
		else
			System.out.println("oclEMFResult : "+results);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}


}
