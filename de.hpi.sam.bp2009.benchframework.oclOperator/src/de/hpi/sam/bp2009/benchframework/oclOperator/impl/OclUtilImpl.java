/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCL.Query;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.ConstraintKind;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;

import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator;

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
	public boolean executeQueryOn(String completeConstraint, ResourceSet resource, QueryEvaluator evaluator) {
		
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(completeConstraint);
		String queryContext="";
		if(match.find()){
			queryContext=match.group(1);
		}
		queryContext=queryContext.trim();
		String queryInvariant=completeConstraint.substring(completeConstraint.indexOf("inv:")+4);
		queryInvariant=queryInvariant.trim();
		boolean results = false;
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
			results = validateOclQuery(context, queryInvariant, resource, evaluator);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	
		return results;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ParserException 
	 * @generated NOT
	 */
	public OCLExpression<?> getOCLExpression(String completeConstraint, ResourceSet resource) throws ParserException {
		
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(completeConstraint);
		String queryContext="";
		if(match.find()){
			queryContext=match.group(1);
		}
		queryContext=queryContext.trim();
		String queryInvariant=completeConstraint.substring(completeConstraint.indexOf("inv:")+4);
		queryInvariant=queryInvariant.trim();
		
		EClassifier cls = getEClassifierForName(resource, queryContext);
		
		EClass contextClass = castToEClass(cls);
		
		OCLExpression<EClassifier> query1 = null;

		    // create an OCL instance for Ecore
		    OCL ocl = OCLWithHiddenOpposites.newInstance();
		    
		    // create an OCL helper object
		    Helper helper = ocl.createOCLHelper();
		    
		    // set the OCL context classifier
		    helper.setContext(contextClass);
		    
		    query1 = helper.createQuery(queryInvariant);
		    
		    // record success
		return query1;
	}

	private EClassifier getEClassifierForName(ResourceSet resource,
			String queryContext) {
		assert(resource!=null);
		Registry registry = resource.getPackageRegistry();
		EClassifier cls=null;
		for(String key: registry.keySet()){
			EPackage current = registry.getEPackage(key);
			if(current.getEClassifier(queryContext)!=null){
				cls=current.getEClassifier(queryContext);
				break;
			}
		}
		return cls;
	}

	private EClass castToEClass(EClassifier cls)
			throws IllegalArgumentException {
		EClass contextClass= null;
		if(cls==null)
			throw new IllegalArgumentException("Context cannot be null");
		else if(cls instanceof EDataType)
			throw new IllegalArgumentException("Context cannot be a EDataType");
		else if(cls instanceof EClass)
			contextClass=(EClass)cls;
		else
			throw new IllegalArgumentException("Context is invalid");
		return contextClass;
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
	@SuppressWarnings("unchecked")
	public boolean validateOclQuery(EClass context, String queryString, ResourceSet resource, QueryEvaluator evaluator) throws ParserException{
		OCL ocl= OCLWithHiddenOpposites.newInstance();
		
		// build a valid extent map
		// TODO: build an appropriate scope using the scope provider
		Map<EClass, Set<? extends EObject>> extents = new HashMap<EClass, Set<? extends EObject>>();
		BasicEList<EObject> scope = new BasicEList<EObject>();
		for (Resource r : resource.getResources()){
			TreeIterator<EObject> it = r.getAllContents();
			while (it.hasNext()){
				EObject element = it.next();
				if (! extents.containsKey(element.eClass())){
					extents.put(element.eClass(), new HashSet<EObject>());
				}
				Set<EObject> content = (Set<EObject>) extents.get(element.eClass());
				content.add(element);
				extents.put(element.eClass(), content);
				scope.add(element); // add all EObjects to the scope
			}
		}
		
		Helper helper = ocl.createOCLHelper();
		Constraint constraint = helper.createConstraint(ConstraintKind.INVARIANT, queryString);
		helper.setContext(context);
		Query query = ocl.createQuery(constraint);
		evaluator.evaluateQuery(query, scope);
		return query.check(context);
	}
	

} //OclUtilImpl
