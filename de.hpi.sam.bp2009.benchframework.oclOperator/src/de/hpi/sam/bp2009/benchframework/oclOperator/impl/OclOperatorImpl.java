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
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OCL.Query;

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
    private HashMap<Notification, Set<Constraint>> affectedExprs = new HashMap<Notification, Set<Constraint>>();

    public static HashMap<String, List<Constraint>> stringToConstraints = new HashMap<String, List<Constraint>>();
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
            for (String query: ((OclOptionObject) option).getConstraints()){
                ((OclResultImpl)getResult()).addQuery(query);
            }
            if(((OclOptionObject) option).isUseImpactAnalyzer())
                registerQueriesIA(this.getTestRun().getModel(), (OclOptionObject) option);
            else
                executeQueries(this.getTestRun().getModel(), (OclOptionObject) option);
            getResult().setStatus(Status.SUCCESSFUL);
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

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void registerQueriesIA(ResourceSet resource, OclOptionObject option) {
        assert(resource!=null);
        final EList<Constraint> allConstraints= new BasicEList<Constraint>();
        OCL ocl = OCL.newInstance();
        for(String con: option.getConstraints()){
            try {
                String uri = resource.getResources().get(0).getContents().get(0).eClass().getEPackage().getNsURI();
                EPackage basePackage = resource.getPackageRegistry().getEPackage(uri);
                String nsPrefix = basePackage.getNsPrefix();
                EPackage.Registry.INSTANCE.put(nsPrefix, basePackage);
                ArrayList<String> path = new ArrayList<String>();
                path.add(nsPrefix);

                ocl = OCL.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));

                OCLInput input = new OCLInput(con);
                List<Constraint> test = ocl.parse(input);
                OclOperatorImpl.stringToConstraints.put(con, test);
                for(Constraint c:test)
                    allConstraints.add(c);
            } catch (ParserException e) {
                throw new IllegalArgumentException("Invalid Query, parsing failed " + e.getMessage(), e);
            }

        }
        /*
         * TODO refactor so that no direct dependencies between operators
         */
        //final ImpactAnalyzer ia = getTestRun().getInstanceForClass(de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer.class);
        final ModifiedImpactAnalyzerImpl ia = new ModifiedImpactAnalyzerImpl();
        //final EventManager em = getTestRun().getInstanceForClass(de.hpi.sam.bp2009.solution.eventManager.EventManager.class);
        EventManager em = EventManagerFactory.eINSTANCE.getEventManagerFor(resource);
        final QueryEvaluator qe = getTestRun().getInstanceForClass(de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator.class);        
        
        if(ia== null)
            throw new IllegalArgumentException("Invalid Testrun, no Impact Analyzer defined");
        else 
        if(em == null)
            throw new IllegalArgumentException("Invalid Testrun, no Event Manager defined");
        else if(qe == null)
            throw new IllegalArgumentException("Invalid Testrun, no Query Evaluator defined");
        else{
            int expCount = 0;
            for (final Constraint item: allConstraints){
                final OCLExpression exp = (OCLExpression) item.getSpecification().getBodyExpression();
                EventFilter filter = ia.createFilterForExpression(exp, true);
                expCount++;
                em.subscribe(filter, new AdapterImpl() {
                    @Override
                    public void notifyChanged(Notification msg) {
                        //collect affected expressions for each model change
                        if (affectedExprs.containsKey(msg)){
                            affectedExprs.get(msg).add(item);
                        }
                        else {
                            HashSet<Constraint> expSet = new HashSet<Constraint>();
                            expSet.add(item);
                            affectedExprs.put(msg, expSet);
                        }
                        // analyze reduction of context instances by usage of IA
                        EClass context = ((EClass)(item.getSpecification().getContextVariable().getType()));
                        Collection<EObject> contextInstances = ia.getContextObjects(msg, exp, context);
                        // calculate number of all instances for comparison with IA-Version
                        EList<EObject> allInstances = getAllInstances(context);
                        getResult().setMessage(getResult().getMessage() + 
                                "\n Number of context Instances for Expression: , " + item.toString() + 
                                " , with IA : , " + contextInstances.size() + 
                                " ,  naive: , " + allInstances.size());
                        // execution time benchmarking
                        EList<EObject> scope = new BasicEList<EObject>();
                        for (EObject o: contextInstances){
                            scope.add(o);
                        }
                        Query query = OCL.newInstance().createQuery(item);
                        long before = System.nanoTime();
                        //evaluate query on instances calculated by IA
                        qe.evaluateQuery(query , scope);
                        long after = System.nanoTime();
                        //evaluate query on all instances of given context
                        long beforeNaive = System.nanoTime();
                        qe.evaluateQuery(query, allInstances);
                        long afterNaive = System.nanoTime();
                        getResult().setMessage(getResult().getMessage() 
                                + " , Execution Time: , with Instance Scope: , "
                                + (after - before) + "ns , naive: , " + (afterNaive - beforeNaive) + "ns" );
                        
                        //evaluate all queries without IA to calculate time savings using IA
                        long timeResult = 0;
                        for (Constraint con: allConstraints){
                            EList<EObject> all = getAllInstances((EClass)(con.getSpecification().getContextVariable().getType()));
                            long beforeWithoutIA = System.nanoTime();
                            qe.evaluateQuery(query, all);
                            long afterWithoutIA = System.nanoTime();
                            timeResult += (afterWithoutIA - beforeWithoutIA);
                        }
                        getResult().setMessage(getResult().getMessage()
                                + " , without IA: , " + timeResult + "ns");
                        
                        super.notifyChanged(msg);
                    }

                    private EList<EObject> getAllInstances(EClass context) {
                        //FIXME find all instances of meta class given by context 
                        // this probably doesn't work like intended
                        EList<EObject> allInstances = new BasicEList<EObject>();
                        allInstances.addAll(context.eContents());
                        allInstances.addAll(context.eCrossReferences());
                        return allInstances;
                    }
                });
            }
            ((OclResultImpl)getResult()).setExpToFilterTime(ia.IAResult.getExpToFilterTime());
            getResult().setMessage(getResult().getMessage() + "\n Totally registered OCL Expressions: " + expCount );
            
        }
    }

    public HashMap<Notification, Set<Constraint>> getAffectedExprs() {
        return affectedExprs;
    }

} //OclOperatorImpl
