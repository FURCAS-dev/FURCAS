/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import company.CompanyPackage;

import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlUtil;
import de.hpi.sam.bp2009.solution.oclToMqlMapping.impl.MappingOCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl To Mql Util</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OclToMqlUtilImpl extends EObjectImpl implements OclToMqlUtil {

    final static String regex="context([\\w\\W]*)? body"; 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OclToMqlUtilImpl() {
        super();
    }
    protected MappingOCL mql;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OclToMqlOperatorPackage.Literals.OCL_TO_MQL_UTIL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    @SuppressWarnings({ "unchecked" })
    public Object evaluateMQL(String completeConstraint, ResourceSet resourceSet) {
        assert(resourceSet!=null);
        new HashMap<Notification, Set<String>>();
        mql =MappingOCL.newInstance();
        //TODO try to use manuell parsing form gui
        //        OCL ocl = OCL.newInstance();
        //        MappingOCL mql =MappingOCL.newInstance();

        String uri = resourceSet.getResources().get(0).getContents().get(0).eClass().getEPackage().getNsURI();
        EPackage basePackage = resourceSet.getPackageRegistry().getEPackage(uri);
        String nsPrefix = basePackage.getNsPrefix();
        EPackage.Registry.INSTANCE.put(nsPrefix, basePackage);
        ArrayList<String> path = new ArrayList<String>();
        path.add(nsPrefix);

        //            ocl = OCL.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));
        mql = MappingOCL.newInstance(mql.getEnvironment().getFactory().createPackageContext(mql.getEnvironment(), path));

        //TODO check if all is correctly
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(completeConstraint);
        String queryContext="";
        if(match.find()){
            queryContext=match.group(1);
        }
        queryContext=queryContext.trim();
        String queryBody=completeConstraint.substring(completeConstraint.indexOf("body:")+5);
        queryBody=queryBody.trim();
        
        Helper helper= mql.createOCLHelper();
        Object result =null;
        Resource resource=null;
        Map<EClass, Set<? extends EObject>> extents = new HashMap<EClass, Set<? extends EObject>>();
        BasicEList<EObject> scope = new BasicEList<EObject>();
        for (Resource r : resourceSet.getResources()) {
            TreeIterator<EObject> it = r.getAllContents();
            resource = r;
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
        EcoreHelper.getInstance().addResourceToDefaultIndex(resource);
        TreeIterator<EObject> it = resource.getAllContents();  
        Map<EClass, Set<EObject>> map = new HashMap<EClass, Set<EObject>>();
        while(it.hasNext()){
            EObject element =it.next();

            if(map.get(element.eClass())==null)
                map.put(element.eClass(), new HashSet<EObject>());
            map.get(element.eClass()).add(element);

        }
        mql.setExtentMap(map);
//        Registry registry = resourceSet.getPackageRegistry();
//        EPackage packageInstance=null;
//        for(String key: registry.keySet()){
//            EPackage current = registry.getEPackage(key);
//            if(current.getEClassifier(queryContext)!=null)
//                packageInstance=current;
//        }
//        if(packageInstance==null)
//            throw new IllegalArgumentException("Context not found!");
//
//        EClass context=getEClassForContext(queryContext, packageInstance);
//
//        if(context==null){
//            throw new IllegalArgumentException("Context not found!");
//        }


        //         build a valid extent map
        // TODO: build an appropriate scope using the scope provider
        EClass context = CompanyPackage.eINSTANCE.getEmployee();
        helper.setContext(context);

        try {
            OCLExpression oclexpression = helper.createQuery(queryBody);
            result= mql.evaluate(context, oclexpression);

        } catch (ParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->

     */
    @SuppressWarnings({ "unchecked" })
    public Object evaluateOCL(String completeConstraint, ResourceSet resourceSet) {
        assert(resourceSet!=null);
        new HashMap<Notification, Set<String>>();

        //TODO try to use manuell parsing form gui
        OCL ocl = OCLWithHiddenOpposites.newInstance();
        String uri = resourceSet.getResources().get(0).getContents().get(0).eClass().getEPackage().getNsURI();
        EPackage basePackage = resourceSet.getPackageRegistry().getEPackage(uri);
        String nsPrefix = basePackage.getNsPrefix();
        EPackage.Registry.INSTANCE.put(nsPrefix, basePackage);
        ArrayList<String> path = new ArrayList<String>();
        path.add(nsPrefix);
        ocl = OCLWithHiddenOpposites.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));
       
        //TODO check if all is correctly
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(completeConstraint);
        String queryContext="";
        if(match.find()){
            queryContext=match.group(1);
        }
        queryContext=queryContext.trim();
        String queryBody=completeConstraint.substring(completeConstraint.indexOf("body:")+5);

        queryBody=queryBody.trim();

        Helper helper= ocl.createOCLHelper();
        Object result =null;
        Resource resource=null;
        Map<EClass, Set<? extends EObject>> extents = new HashMap<EClass, Set<? extends EObject>>();
        BasicEList<EObject> scope = new BasicEList<EObject>();
        for (Resource r : resourceSet.getResources()) {
            TreeIterator<EObject> it = r.getAllContents();
            resource = r;
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

        EcoreHelper.getInstance().addResourceToDefaultIndex(resource);
        TreeIterator<EObject> it = resource.getAllContents();  
        Map<EClass, Set<EObject>> map = new HashMap<EClass, Set<EObject>>();
        while(it.hasNext()){
            EObject element =it.next();

            if(map.get(element.eClass())==null)
                map.put(element.eClass(), new HashSet<EObject>());
            map.get(element.eClass()).add(element);

        }
        ocl.setExtentMap(map);

        //        EPackage packageInstance= null;
        //        for(String key: registry.keySet()){
        //            EPackage current = registry.getEPackage(key);
        //            if(current.getEClassifier(queryContext)!=null)
        //                packageInstance=current;
        //        }

        //        if(packageInstance==null)
        //            throw new IllegalArgumentException("Context not found!");

        //        EClass context= getEClassForContext(queryContext, packageInstance);

        //        if(context==null){
        //            throw new IllegalArgumentException("Context not found!");
        //        }

        EClass context = CompanyPackage.eINSTANCE.getEmployee();
        helper.setContext(context);
        try {
            OCLExpression oclexpression = helper.createQuery(queryBody);
            result= ocl.evaluate(context, oclexpression);
        } catch (ParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->

     */
    public OCLExpression getOCLExpressionForOCL(String completeConstraint, ResourceSet resourceSet) {
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(completeConstraint);
        String queryContext="";
        if(match.find()){
            queryContext=match.group(1);
        }
        queryContext=queryContext.trim();
        String queryInvariant=completeConstraint.substring(completeConstraint.indexOf("body:")+5);
        queryInvariant=queryInvariant.trim();

        EClassifier cls = getEClassifierForName(resourceSet, queryContext);

        EClass contextClass = castToEClass(cls);

        OCLExpression query1 = null;

        // create an OCL instance for Ecore
        OCL ocl = OCLWithHiddenOpposites.newInstance();

        // create an OCL helper object
        Helper helper = ocl.createOCLHelper();

        // set the OCL context classifier
        helper.setContext(contextClass);

        try {
            query1 = helper.createQuery(queryInvariant);
        } catch (ParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // record success
        return query1;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public OCLExpression getOCLExpressionForMQL(String completeConstraint, ResourceSet resourceSet) {
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(completeConstraint);
        String queryContext="";
        if(match.find()){
            queryContext=match.group(1);
        }
        queryContext=queryContext.trim();
        String queryInvariant=completeConstraint.substring(completeConstraint.indexOf("body:")+5);
        queryInvariant=queryInvariant.trim();

        EClassifier cls = getEClassifierForName(resourceSet, queryContext);

        EClass contextClass = castToEClass(cls);

        OCLExpression query1 = null;

        // create an OCL instance for Ecore
        MappingOCL ocl = MappingOCL.newInstance();

        // create an OCL helper object
        Helper helper = ocl.createOCLHelper();

        // set the OCL context classifier
        helper.setContext(contextClass);

        try {
            query1 = helper.createQuery(queryInvariant);
        } catch (ParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
    @SuppressWarnings("unused")
    private static EClass getEClassForContext(String queryContext, EObject packageInstance){
        EClass eclass=null;
        try {
            eclass=(EClass)packageInstance.getClass().getMethod("get"+queryContext).invoke(packageInstance);
        } catch (Exception e) {
            //Nothing to do
        }
        return eclass;
    }
} //OclToMqlUtilImpl
