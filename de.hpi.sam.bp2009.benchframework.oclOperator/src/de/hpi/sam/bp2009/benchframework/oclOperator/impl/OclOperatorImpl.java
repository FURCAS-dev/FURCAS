/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCL.Query;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;
import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerImpl;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperator;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorFactory;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclResult;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;
/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getTestRun <em>Test Run</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclOperatorImpl extends EObjectImpl implements OclOperator {

    private static final String NAME = "Ocl Operator";
    private static final String DESCRIPTION = "Evaluates a specific ocl expression";
    private HashMap<Notification, LinkedList<String>> affectedExprs = new HashMap<Notification, LinkedList<String>>();

    public static HashMap<String, List<Constraint>> stringToConstraints = new HashMap<String, List<Constraint>>();
    private ResourceSet res;
    /**
     * The cached value of the '{@link #getOption() <em>Option</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOption()
     * @generated
     * @ordered
     */
    protected OptionObject option;
    /**
     * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResult()
     * @generated
     * @ordered
     */
    protected ResultObject result;
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "";
    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;
    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public OclOperatorImpl() {
        super();
        setOption(OclOperatorFactory.eINSTANCE.createOclOptionObject());
        this.setName(NAME);
        this.setDescription(DESCRIPTION);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OclOperatorPackage.Literals.OCL_OPERATOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OptionObject getOption() {
        return option;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOption(OptionObject newOption, NotificationChain msgs) {
        OptionObject oldOption = option;
        option = newOption;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__OPTION, oldOption, newOption);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOption(OptionObject newOption) {
        if (newOption != option) {
            NotificationChain msgs = null;
            if (option != null)
                msgs = ((InternalEObject)option).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclOperatorPackage.OCL_OPERATOR__OPTION, null, msgs);
            if (newOption != null)
                msgs = ((InternalEObject)newOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclOperatorPackage.OCL_OPERATOR__OPTION, null, msgs);
            msgs = basicSetOption(newOption, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__OPTION, newOption, newOption));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResultObject getResult() {
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResult(ResultObject newResult, NotificationChain msgs) {
        ResultObject oldResult = result;
        result = newResult;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__RESULT, oldResult, newResult);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResult(ResultObject newResult) {
        if (newResult != result) {
            NotificationChain msgs = null;
            if (result != null)
                msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclOperatorPackage.OCL_OPERATOR__RESULT, null, msgs);
            if (newResult != null)
                msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclOperatorPackage.OCL_OPERATOR__RESULT, null, msgs);
            msgs = basicSetResult(newResult, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__RESULT, newResult, newResult));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TestRun getTestRun() {
        if (eContainerFeatureID() != OclOperatorPackage.OCL_OPERATOR__TEST_RUN) return null;
        return (TestRun)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTestRun, OclOperatorPackage.OCL_OPERATOR__TEST_RUN, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTestRun(TestRun newTestRun) {
        if (newTestRun != eInternalContainer() || (eContainerFeatureID() != OclOperatorPackage.OCL_OPERATOR__TEST_RUN && newTestRun != null)) {
            if (EcoreUtil.isAncestor(this, newTestRun))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTestRun != null)
                msgs = ((InternalEObject)newTestRun).eInverseAdd(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
            msgs = basicSetTestRun(newTestRun, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__TEST_RUN, newTestRun, newTestRun));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetTestRun((TestRun)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case OclOperatorPackage.OCL_OPERATOR__OPTION:
            return basicSetOption(null, msgs);
        case OclOperatorPackage.OCL_OPERATOR__RESULT:
            return basicSetResult(null, msgs);
        case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
            return basicSetTestRun(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
            return eInternalContainer().eInverseRemove(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case OclOperatorPackage.OCL_OPERATOR__OPTION:
            return getOption();
        case OclOperatorPackage.OCL_OPERATOR__RESULT:
            return getResult();
        case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
            return getTestRun();
        case OclOperatorPackage.OCL_OPERATOR__NAME:
            return getName();
        case OclOperatorPackage.OCL_OPERATOR__DESCRIPTION:
            return getDescription();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case OclOperatorPackage.OCL_OPERATOR__OPTION:
            setOption((OptionObject)newValue);
            return;
        case OclOperatorPackage.OCL_OPERATOR__RESULT:
            setResult((ResultObject)newValue);
            return;
        case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
            setTestRun((TestRun)newValue);
            return;
        case OclOperatorPackage.OCL_OPERATOR__NAME:
            setName((String)newValue);
            return;
        case OclOperatorPackage.OCL_OPERATOR__DESCRIPTION:
            setDescription((String)newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case OclOperatorPackage.OCL_OPERATOR__OPTION:
            setOption((OptionObject)null);
            return;
        case OclOperatorPackage.OCL_OPERATOR__RESULT:
            setResult((ResultObject)null);
            return;
        case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
            setTestRun((TestRun)null);
            return;
        case OclOperatorPackage.OCL_OPERATOR__NAME:
            setName(NAME_EDEFAULT);
            return;
        case OclOperatorPackage.OCL_OPERATOR__DESCRIPTION:
            setDescription(DESCRIPTION_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case OclOperatorPackage.OCL_OPERATOR__OPTION:
            return option != null;
        case OclOperatorPackage.OCL_OPERATOR__RESULT:
            return result != null;
        case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
            return getTestRun() != null;
        case OclOperatorPackage.OCL_OPERATOR__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case OclOperatorPackage.OCL_OPERATOR__DESCRIPTION:
            return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", description: ");
        result.append(description);
        result.append(')');
        return result.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     */

    public void execute() {
        setResult(OclOperatorFactory.eINSTANCE.createOclResult());
        if (option instanceof OclOptionObject){
            if(((OclOptionObject) option).isUseImpactAnalyzer()){
                registerQueriesIA(this.getTestRun().getModel(), (OclOptionObject) option);
            }
            else
                executeQueries(this.getTestRun().getModel(), (OclOptionObject) option);
            getResult().setStatus(Status.SUCCESSFUL);
            for (String query: ((OclOptionObject) option).getConstraints()){
                ((OclResultImpl)getResult()).addQuery(query);
            }
        }else{
            getResult().setStatus(Status.FAILED);
            getResult().setMessage("Invalid OptionObject");
        }


    }

    public void executeQueries(ResourceSet resource, OclOptionObject option) {
        OclUtil ocl = OclOperatorFactory.eINSTANCE.createOclUtil();
        QueryEvaluator queryEvaluator = getTestRun().getInstanceForClass(QueryEvaluator.class);
        for(String con: option.getConstraints()){
            boolean r = ocl.executeQueryOn(con, resource, queryEvaluator);
            if(getResult() instanceof OclResult)
                ((OclResult)getResult()).getQueriesToResults().put(con, r);
        }

    }

    private class ExpressionWithContext{
        public OCLExpression expr;
        public EClass classifier;

        public ExpressionWithContext(OCLExpression e, EClass c) {      
            classifier=c;
            expr = e;
        }
        public String toString(){
            return "context " + classifier.getName() + " : " + expr.toString();
        }
    }
    public HashMap<Notification, List<Long>> notiToAllInstances = new HashMap<Notification, List<Long>>();

    private void addConstraintToConstraintList(EAnnotation a, Map<String, ExpressionWithContext> allConstraints, EClassifier c){
        if (a == null)return;
        int index=0;
        for (Entry<String, String> detail : a.getDetails()) {
            String e = detail.getValue();
            if (e == null){
                break;
            }else{
                allConstraints.put(e, new ExpressionWithContext((OCLExpression) a.getContents().get(index),(EClass) c) );
            }
            index++;
        }
    }
    boolean gotParsed = false;
    protected long t1;
    protected long t2;

    public void registerQueriesIA(ResourceSet resourceSet, OclOptionObject option) {        
        assert(resourceSet!=null);
        this.res = resourceSet;
        this.affectedExprs = new HashMap<Notification, LinkedList<String>>();
        final Map<String, ExpressionWithContext> allConstraints= new HashMap<String, ExpressionWithContext>();
        EAnnotationOCLParser oclParser = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
        TreeIterator<EObject> ti = resourceSet.getResources().get(0).getAllContents();
        Set<EPackage> allPkg = new HashSet<EPackage>();
        while (ti.hasNext()){
            allPkg.add(ti.next().eClass().getEPackage());           
        }
        if (!gotParsed)
        for(EPackage pkg:allPkg){
            oclParser.traversalConvertOclAnnotations(pkg);
        }           
        gotParsed = true;
        for (EPackage p:allPkg){
            for(EClassifier c:p.getEClassifiers()){                
                EAnnotation a =c.getEAnnotation("http://de.hpi.sam.bp2009.OCL");                   
                addConstraintToConstraintList(a, allConstraints, c);                                                         
                if (c instanceof EClass) {
                    for (EOperation op : ((EClass) c).getEOperations()){
                        a = op.getEAnnotation("http://de.hpi.sam.bp2009.OCL");
                        addConstraintToConstraintList(a, allConstraints, c);
                    }
                    for (EAttribute at : ((EClass) c).getEAttributes()){
                        a = at.getEAnnotation("http://de.hpi.sam.bp2009.OCL");
                        addConstraintToConstraintList(a, allConstraints, c);                            
                    }
                }
            }
        }
        //TODO try to use manuell parsing form gui
        //        OCL ocl = OCL.newInstance();

        //        for(String con: option.getConstraints()){
        //            try {
        //                String uri = resource.getResources().get(0).getContents().get(0).eClass().getEPackage().getNsURI();
        //                EPackage basePackage = resource.getPackageRegistry().getEPackage(uri);
        //                String nsPrefix = basePackage.getNsPrefix();
        //                EPackage.Registry.INSTANCE.put(nsPrefix, basePackage);
        //                ArrayList<String> path = new ArrayList<String>();
        //                path.add(nsPrefix);
        //
        //                ocl = OCL.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));
        //
        //                OCLInput input = new OCLInput(con);
        //                List<Constraint> test = ocl.parse(input);
        //                OclOperatorImpl.stringToConstraints.put(con, test);
        //                for(Constraint c:test)
        //                    allConstraints.add(c);
        //            } catch (ParserException e) {
        //                throw new IllegalArgumentException("Invalid Query, parsing failed " + e.getMessage(), e);
        //            }
        //
        //        }
        /*
         * TODO refactor so that no direct dependencies between operators
         */
        //final ImpactAnalyzer ia = getTestRun().getInstanceForClass(de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer.class);
        //final EventManager em = getTestRun().getInstanceForClass(de.hpi.sam.bp2009.solution.eventManager.EventManager.class);
        final EventManager naiveEM = EventManagerFactory.eINSTANCE.getEventManagerFor(resourceSet);
        
       
        final QueryEvaluator qe = getTestRun().getInstanceForClass(de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator.class);        

        if(qe == null) {
            throw new IllegalArgumentException("Invalid Testrun, no Query Evaluator defined");
        } else {
            int expCount = 0;
            notiToAllInstances.clear();
            for (final Entry<String, ExpressionWithContext> entry: allConstraints.entrySet()){
                final OCLExpression exp = entry.getValue().expr;   
                final EClass context = entry.getValue().classifier;
                final ModifiedImpactAnalyzerImpl ia = new ModifiedImpactAnalyzerImpl(exp, context);
                ((OclResultImpl)getResult()).setExpToFilterTime(new HashMap<String, Long>());
                ((OclResultImpl)getResult()).addQuery(entry.getValue().toString());
                EventFilter filter = ia.createFilterForExpression(true);
                ((OclResultImpl)getResult()).getExpToFilterTime().put(exp.toString(),
                        ia.IAResult.getExpToFilterTime().get(exp.toString()));
                expCount++;

                naiveEM.subscribe(filter, new AdapterImpl() {
                    @Override
                    public void notifyChanged(Notification msg) {
                        // analyze reduction of context instances by usage of IA
                        EClass context = entry.getValue().classifier;
                        long beforeIA = System.nanoTime();
                        Collection<EObject> contextInstances = ia.getContextObjects(msg);
                        long afterIA = System.nanoTime();
                        EList<EObject> contextIns = new BasicEList<EObject>();
                        contextIns.addAll(contextInstances);
                        // calculate number of all instances for comparison with IA-Version
                        EList<EObject> allInstances = getAllInstances(context);                       
                        // execution time benchmarking
                        Query query = OCLWithHiddenOpposites.newInstance().createQuery(entry.getValue().expr);
                        //time consumption for Instance Scope and Class Scope evaluation
                        long before = System.nanoTime();
                        qe.evaluateQuery(query, contextIns);
                        long after = System.nanoTime();
                        
                        long beforeNaive = System.nanoTime();
                        qe.evaluateQuery(query, allInstances);
                        long afterNaive = System.nanoTime();
                        getResult().setMessage(getResult().getMessage() 
                                + "\n IA_Execute_Time: , " + (afterIA-beforeIA) + ", IA_Eval_Time: , "+ (after-before) + " , IA_Instances: , " + contextInstances.size() + ", C_Time: , " + (afterNaive - beforeNaive) + " , C_Instances: , " + allInstances.size());
                                                
                        //collect affected expressions for each model change
                        if (getAffectedExprs().containsKey(msg)){
                            getAffectedExprs().get(msg).add(entry.getValue().toString());
                        }
                        else {
                            LinkedList<String> expSet = new LinkedList<String>();
                            expSet.add(entry.getValue().toString());
                            getAffectedExprs().put(msg, expSet);
                          //evaluate all queries without IA to calculate time savings using IA
                            long timeResult = 0;
                            long instances = 0;
                            int count = 0;
                            for (ExpressionWithContext con: allConstraints.values()){
                                count++;
                                EList<EObject> all = getAllInstances(con.classifier);
                                long beforeWithoutIA = System.nanoTime();
                                qe.evaluateQuery(query, all);
                                long afterWithoutIA = System.nanoTime();
                                timeResult += (afterWithoutIA - beforeWithoutIA);
                                instances += all.size();
                                if (count % 20 == 0)
                                    System.out.print(count + " ");
                            }
                            List<Long> times = new LinkedList<Long>();
                            times.add(new Long(timeResult));
                            times.add(new Long(instances));
                            notiToAllInstances.put(msg, times);
                        }       
                        List<Long> times = notiToAllInstances.get(msg);
                        getResult().setMessage(getResult().getMessage() + 
                                ", without IA: , time: , " + times.get(0) + " , Instances: , " + times.get(1) + ", Expression: , " + entry.getValue().toString() + 
                                " , , , ,  event: , " + msg);
                        
                        super.notifyChanged(msg);
                    }});
                               
                
            }
            getResult().setMessage(getResult().getMessage() + "\n Totally registered OCL Expressions: " + expCount );
        }
    } 

    private EList<EObject> getAllInstances(EClass context) {
        EList<EObject> allInstances = new BasicEList<EObject>();
        allInstances = new BasicEList<EObject>();

        List<EClass> classes = new ArrayList<EClass>(DefaultOppositeEndFinder.getInstance().getAllSubclasses(context));
        classes.add(context);
        OCL ocl = OCLWithHiddenOpposites.newInstance(new Query2OppositeEndFinder(new ProjectDependencyQueryContextProvider()));
        Helper helper= ocl.createOCLHelper();          
        Resource r = res.getResources().get(0);
        EcoreHelper.getInstance().addResourceToDefaultIndex(r);       
        TreeIterator<EObject> it = r.getAllContents();  
        Map<EClass, Set<EObject>> map = new HashMap<EClass, Set<EObject>>();

        while(it.hasNext()){
            EObject element =it.next();

            if(map.get(element.eClass())==null)
                map.put(element.eClass(), new HashSet<EObject>());
            map.get(element.eClass()).add(element);

        }
        ocl.setExtentMap(map);

        for (EClass c : classes) {
            helper.setContext(c);
            try {
                OCLExpression query = helper.createQuery(c.getName() + ".allInstances()");
                Object objResult = ocl.evaluate(c, query);                
                if (objResult instanceof Collection<?>){
                    for (Object o : (Collection<?>)objResult){
                        if (o instanceof EObject){
                            allInstances.add((EObject) o);
                        }
                    }
                }
            } catch (ParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return allInstances;
    }

    public HashMap<Notification, LinkedList<String>> getAffectedExprs() {
        return affectedExprs;
    }

} //OclOperatorImpl
