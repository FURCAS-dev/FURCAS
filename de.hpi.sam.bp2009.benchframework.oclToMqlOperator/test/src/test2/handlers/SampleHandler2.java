package test2.handlers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.internal.statements.QueryClause;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OCL.Helper;

import de.hpi.sam.qcl.OclUtil;

import usecase.Actor;
import usecase.Element;
import usecase.UsecaseDiagram;
import usecase.UsecasePackage;

public class SampleHandler2 extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String completeQuery= "context Usecase inv: self.ID<10"; 
		// create Resource My.usecase in Resourceset 
		ResourceSet resourceset=new ResourceSetImpl();
		Resource resource = resourceset.createResource(URI.createPlatformResourceURI("/test/My.usecase", true));
		try {
			resource.load(Collections.emptyMap());//load platform of My.usecase, exception in case of empty map
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try{
		IQueryResult results = OclUtil.executeQueryOn(completeQuery, resource);
		if(results==null)
			System.out.println("Results null");
		else
			System.out.println("oclEMFResult : "+results.size());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}


}
