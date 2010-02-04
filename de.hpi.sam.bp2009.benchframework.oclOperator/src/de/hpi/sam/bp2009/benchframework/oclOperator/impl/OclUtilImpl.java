/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;

import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Util</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OclUtilImpl extends EObjectImpl implements OclUtil {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	final static String regex="context([\\w\\W]*)? inv"; 
	
	public OclUtilImpl() {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclOperatorPackage.Literals.OCL_UTIL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IQueryResult executeQueryOn(String completeConstraint, ResourceSet resource) {
		
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
		Registry registry = resource.getPackageRegistry();
		EPackage packageInstance=null;
		for(String key: registry.keySet()){
			EPackage current = registry.getEPackage(key);
			if(current.getEClassifier(queryContext)!=null)
				packageInstance=current;
		}
		if(packageInstance==null)
			throw new IllegalArgumentException("Context not found!");
		
		EClass context=getEClassForContext(queryContext, packageInstance);
		
		if(context==null){
			throw new IllegalArgumentException("Context not found!");
		}
		
		try {
			results = validateOclQuery(context, queryInvariant, resource);
		} catch (ParserException e) {
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
	private static EClass getEClassForContext(String queryContext, EObject packageInstance){
		EClass eclass=null;
		try {
			eclass=(EClass)packageInstance.getClass().getMethod("get"+queryContext).invoke(packageInstance);
		} catch (Exception e) {
			//Nothing to do
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
	 * @throws ParserException
	 */
	public static IQueryResult validateOclQuery(EClass context, String query, ResourceSet resource) throws ParserException{
		OCL ocl= OCL.newInstance();
		Condition condition=null;
		condition = new org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition<EClassifier, EClass, EObject>(
					ocl.getEnvironment(),
					query,
					context);
		BasicEList<EObject> list= new BasicEList<EObject>();
		for(Resource r: resource.getResources())
			list.addAll(r.getContents());
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
				new FROM(list), new WHERE((EObjectCondition) condition));

		return statement.execute();
	}
	

} //OclUtilImpl
