/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl;

import de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl;

import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl To Mql Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlResultImpl#getQueriesToResults <em>Queries To Results</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclToMqlResultImpl extends ResultObjectImpl implements OclToMqlResult {
    /**
     * The cached value of the '{@link #getQueriesToResults() <em>Queries To Results</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueriesToResults()
     * @generated
     * @ordered
     */
    protected Map<String, Object> queriesToResults;
    private HashMap<String, Long> expToFilterTime = new HashMap<String, Long>();
    protected EList<String> queries = new BasicEList<String>();
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getQueries() {
        return queries;
}
    public void setQueries(EList<String> queries) {
        this.queries = queries;
}
    protected OclToMqlResultImpl() {
        super();
    }
    public void addQuery(String query){
        this.queries.add(query);
}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OclToMqlOperatorPackage.Literals.OCL_TO_MQL_RESULT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Map<String, Object> getQueriesToResults() {
        return queriesToResults;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQueriesToResults(Map<String, Object> newQueriesToResults) {
        Map<String, Object> oldQueriesToResults = queriesToResults;
        queriesToResults = newQueriesToResults;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclToMqlOperatorPackage.OCL_TO_MQL_RESULT__QUERIES_TO_RESULTS, oldQueriesToResults, queriesToResults));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case OclToMqlOperatorPackage.OCL_TO_MQL_RESULT__QUERIES_TO_RESULTS:
                return getQueriesToResults();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case OclToMqlOperatorPackage.OCL_TO_MQL_RESULT__QUERIES_TO_RESULTS:
                setQueriesToResults((Map<String, Object>)newValue);
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
            case OclToMqlOperatorPackage.OCL_TO_MQL_RESULT__QUERIES_TO_RESULTS:
                setQueriesToResults((Map<String, Object>)null);
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
            case OclToMqlOperatorPackage.OCL_TO_MQL_RESULT__QUERIES_TO_RESULTS:
                return queriesToResults != null;
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
        result.append(" (queriesToResults: ");
        result.append(queriesToResults);
        result.append(')');
        return result.toString();
    }
    @Override
    public Composite getComposite(Composite parent) {
           Composite composite = super.getComposite(parent);
            if(queriesToResults==null)
                    return composite;
            for(Entry<String, Object> entry:queriesToResults.entrySet()){
                    Label label1 = new Label(composite, SWT.CENTER);
                    label1.setText(entry.getKey() +" : "+entry.getValue());
            }
            return composite;
    }
    public String getCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
            if (queries == null) return sb.toString();
            sb.append("Total Number of OCL Expressions: ");
            sb.append(getQueries().size());
            sb.append(" , Time to generate Filter:");
            for (String query: getExpToFilterTime().keySet()){
                if (sb.toString() != "") sb.append(" ,\n ");
                sb.append(query);
                //add time for filter calculation
                Long time = getExpToFilterTime().get(query);
                sb.append(" , " + time.toString() + " ns ");

            }
            sb.append(getMessage());
            return sb.toString();
    }
    public void setExpToFilterTime(HashMap<String, Long> expToFilterTime) {
        this.expToFilterTime = expToFilterTime;
    }

    public HashMap<String, Long> getExpToFilterTime() {
        return expToFilterTime;
    }
} //OclToMqlResultImpl
