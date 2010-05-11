package de.hpi.sam.bp2009.solution.ocltomqlmapping.AllInstancesQuery;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.petriNet.PetriNetPackage;

public class AllInstancesQuery{
	final static String regex="context:([\\w\\W]*)? body";
    

	public static Object executeQueryOn(String completeConstraint, Resource resource)
	throws IllegalAccessException, InvocationTargetException,
	NoSuchMethodException {
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(completeConstraint);
		String queryContext="";
		if(match.find()){
			queryContext=match.group(1);
		}
		queryContext=queryContext.trim();
		String queryInvariant=completeConstraint.substring(completeConstraint.indexOf("body:")+5);
		queryInvariant=queryInvariant.trim();
		Object results= null;
		EClass context=getEClassForContext(queryContext);
		if(context==null){
			throw new IllegalArgumentException("Context not found!");
		}		
		try {	
			results = validateOclQuery(context, queryInvariant, resource);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	private static EClass getEClassForContext(String queryContext)
	throws IllegalAccessException, InvocationTargetException,
	NoSuchMethodException {
		EClass eclass=null;
		try {
			eclass=(EClass)PetriNetPackage.eINSTANCE.getClass().getMethod("get"+queryContext).invoke(PetriNetPackage.eINSTANCE);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return eclass;
	}
	public static Object validateOclQuery(EClass context, String query, Resource resource) throws ParserException{
		OCL ocl=OCL.newInstance();
		Helper oclhelper=ocl.createOCLHelper();
		oclhelper.setContext(context);
		TreeIterator<EObject> it = resource.getAllContents();
		Map<EClass, Set<EObject>> map = new HashMap<EClass, Set<EObject>>();
		while(it.hasNext()){
		    EObject element = it.next();
		    
		    if(map.get(element.eClass())==null)
		        map.put(element.eClass(), new HashSet<EObject>());
		    map.get(element.eClass()).add(element);
		    		        
		}
		ocl.setExtentMap(map);
		Object statement = null;
                try {
                        OCLExpression oclexpression = oclhelper.createQuery(query);
                        statement = ocl.evaluate(PetriNetPackage.eINSTANCE.getPlace(), oclexpression);
                } catch (ParserException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
		
		return statement;
		
		
		
                
	}
}
