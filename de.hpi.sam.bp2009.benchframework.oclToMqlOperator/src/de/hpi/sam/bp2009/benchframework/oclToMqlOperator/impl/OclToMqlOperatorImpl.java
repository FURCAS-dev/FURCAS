/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperator;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorFactory;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl To Mql Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorImpl#getTestRun <em>Test Run</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclToMqlOperatorImpl extends EObjectImpl implements OclToMqlOperator {

    private static final String NAME = "OclToMql Operator";
    private static final String DESCRIPTION = "Evaluates a specific ocl expression and this mapping to Mql";

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
     * @generated
     */
    public OclToMqlOperatorImpl() {
        super();
        setOption(OclToMqlOperatorFactory.eINSTANCE.createOclToMqlOptionObject());
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
        return OclToMqlOperatorPackage.Literals.OCL_TO_MQL_OPERATOR;
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__OPTION, oldOption, newOption);
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
                msgs = ((InternalEObject)option).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__OPTION, null, msgs);
            if (newOption != null)
                msgs = ((InternalEObject)newOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__OPTION, null, msgs);
            msgs = basicSetOption(newOption, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__OPTION, newOption, newOption));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__RESULT, oldResult, newResult);
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
                msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__RESULT, null, msgs);
            if (newResult != null)
                msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__RESULT, null, msgs);
            msgs = basicSetResult(newResult, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__RESULT, newResult, newResult));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TestRun getTestRun() {
        if (eContainerFeatureID() != OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN) return null;
        return (TestRun)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTestRun, OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTestRun(TestRun newTestRun) {
        if (newTestRun != eInternalContainer() || (eContainerFeatureID() != OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN && newTestRun != null)) {
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
            eNotify(new ENotificationImpl(this, Notification.SET, OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN, newTestRun, newTestRun));
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
            eNotify(new ENotificationImpl(this, Notification.SET, OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__DESCRIPTION, oldDescription, description));
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN:
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
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__OPTION:
            return basicSetOption(null, msgs);
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__RESULT:
            return basicSetResult(null, msgs);
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN:
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
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN:
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
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__OPTION:
            return getOption();
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__RESULT:
            return getResult();
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN:
            return getTestRun();
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__NAME:
            return getName();
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__DESCRIPTION:
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
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__OPTION:
            setOption((OptionObject)newValue);
            return;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__RESULT:
            setResult((ResultObject)newValue);
            return;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN:
            setTestRun((TestRun)newValue);
            return;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__NAME:
            setName((String)newValue);
            return;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__DESCRIPTION:
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
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__OPTION:
            setOption((OptionObject)null);
            return;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__RESULT:
            setResult((ResultObject)null);
            return;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN:
            setTestRun((TestRun)null);
            return;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__NAME:
            setName(NAME_EDEFAULT);
            return;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__DESCRIPTION:
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
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__OPTION:
            return option != null;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__RESULT:
            return result != null;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__TEST_RUN:
            return getTestRun() != null;
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR__DESCRIPTION:
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
    }/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void executeQueries(ResourceSet resourceSet, OclToMqlOptionObject option) {
        OclToMqlUtil ocl = OclToMqlOperatorFactory.eINSTANCE.createOclToMqlUtil();
        //        QueryEvaluator queryEvaluator = getTestRun().getInstanceForClass(QueryEvaluator.class);
        FileWriter writer=null;

        if (option instanceof OclToMqlOptionObject){
            if(((OclToMqlOptionObject) option).isUseEvaluator()){
                File file = new File("ocl.csv");
                System.out.println(file.getAbsolutePath());

                try {
                    writer = new FileWriter(file);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                try {
                    writer.write("OCL-Bedingungen \t OCL (in s)");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                for(String con: option.getConstraints()){
                    long begin = System.nanoTime();
                    Object oclResult = ocl.evaluateOCL(con, resourceSet);
                    long end = System.nanoTime();
                    try {
                        writer.flush();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try {
                        writer.write("\n");
                        writer.write(con+"\t"+(end-begin));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Map<String,Object> map =new HashMap<String, Object>();
                    if(getResult() instanceof OclToMqlResult){
                        map.put(con, oclResult);
                        ((OclToMqlResult)getResult()).setQueriesToResults(map);

                    }
                }}
            else{
                File file = new File("mql.csv");
                System.out.println(file.getAbsolutePath());

                try {
                    writer = new FileWriter(file);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                try {
                    writer.write("OCL-Bedingungen \t OCL (in s)");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                for(String con: option.getConstraints()){
                    long begin = System.nanoTime();
                    Object mqlResult= ocl.evaluateMQL(con, resourceSet);
                    long end = System.nanoTime();
                    try {
                        writer.write("\n");
                        writer.write(con+"\t"+(end-begin));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Map<String,Object> map =new HashMap<String, Object>();
                    if(getResult() instanceof OclToMqlResult){
                        map.put(con, mqlResult);
                        ((OclToMqlResult)getResult()).setQueriesToResults(map);
                    }
                }
            }

        }
        try {
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void execute() {
        setResult(OclToMqlOperatorFactory.eINSTANCE.createOclToMqlResult());
        if (option instanceof OclToMqlOptionObject){
            executeQueries(this.getTestRun().getModel(),(OclToMqlOptionObject) option);

            getResult().setStatus(Status.SUCCESSFUL);
            for (String query: ((OclToMqlOptionObject) option).getConstraints()){
                ((OclToMqlResultImpl)getResult()).addQuery(query);
            }
        }else{
            getResult().setStatus(Status.FAILED);
            getResult().setMessage("Invalid OptionObject");
        }
    }
    //
    //    public void registerQueries(ResourceSet resourceSet, OclToMqlOptionObject option){
    //        assert(resourceSet!=null);
    //        new HashMap<Notification, Set<String>>();
    //
    //        //TODO try to use manuell parsing form gui
    //        //        OCL ocl = OCL.newInstance();
    //        //        MappingOCL mql =MappingOCL.newInstance();
    //
    //        String uri = resourceSet.getResources().get(0).getContents().get(0).eClass().getEPackage().getNsURI();
    //        EPackage basePackage = resourceSet.getPackageRegistry().getEPackage(uri);
    //        String nsPrefix = basePackage.getNsPrefix();
    //        EPackage.Registry.INSTANCE.put(nsPrefix, basePackage);
    //        ArrayList<String> path = new ArrayList<String>();
    //        path.add(nsPrefix);
    //
    //        //            ocl = OCL.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));
    //        //            mql = MappingOCL.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));
    //
    //    }
    //
    //
}


//OclToMqlOperatorImpl
