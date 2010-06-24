package de.hpi.sam.qcl;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;

import usecase.UsecasePackage;

/**
 * @author thea.schroeter
 *
 */
public class OclUtil {

	final static String regex="context([\\w\\W]*)? inv"; 

	/**
	 * Exutes a Ocl Constraint on a given Ressource
	 * @param completeConstraint a String like context Usecase inv: self.ID<10
	 * @param resource the Resource for the Diagram to execute on like my.usecase
	 * @return IQueryResult {@link IQueryResult}
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static IQueryResult executeQueryOn(String completeConstraint, Resource resource)
	throws IllegalAccessException, InvocationTargetException,
	NoSuchMethodException {
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(completeConstraint);
		String queryContext="";
		if(match.find()){
			queryContext=match.group(1);
		}
		queryContext=queryContext.trim();
		String queryInvariant=completeConstraint.substring(completeConstraint.indexOf("inv:")+4);
		queryInvariant=queryInvariant.trim();
		IQueryResult results= null;
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
	/**
	 * Resolve the EClass for a given name
	 * @param queryContext name of the Context EClass
	 * @return the EClass
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private static EClass getEClassForContext(String queryContext)
	throws IllegalAccessException, InvocationTargetException,
	NoSuchMethodException {
		EClass eclass=null;
		try {
			eclass=(EClass)UsecasePackage.eINSTANCE.getClass().getMethod("get"+queryContext).invoke(UsecasePackage.eINSTANCE);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return eclass;
	}
	/**
	 * Validates an Ocl Constraint by given constraint, context and ressource
	 * @param context context to execute on
	 * @param query a String like context Usecase inv: self.ID<10
	 * @param resource the Resource for the Diagram to execute on like my.usecase
	 * @return IQueryResult {@link IQueryResult}
	 * @throws ParserException
	 */
	public static IQueryResult validateOclQuery(EClass context, String query, Resource resource) throws ParserException{
		OCL ocl=OCL.newInstance();
		Condition condition=null;
		condition = new org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition<EClassifier, EClass, EObject>(
				ocl.getEnvironment(),
				query,
				context);
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
				new FROM(resource.getContents()), new WHERE((EObjectCondition) condition));

		return statement.execute();
	}
}
