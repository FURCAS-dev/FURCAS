/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.Engine;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;
import de.hpi.sam.bp2009.benchframework.TestRun;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Engine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl#getTestRuns <em>Test Runs</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl#getExeptionsDuringLastRun <em>Exeptions During Last Run</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EngineImpl extends EObjectImpl implements Engine {
	private static final String OPERATOR_EXTENSION_CLASS = "operatorClass";
	private static final String RESULT_EXTENSION_CLASS = "resultClass";
	private static final String OPERATORID	=	"de.hpi.sam.bp2009.benchframework.operatorExtensionPointID";
	private static final String RESULTPROCESSORID = "de.hpi.sam.bp2009.benchframework.resultExtensionPointID";

	/**
	 * The cached value of the '{@link #getTestRuns() <em>Test Runs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestRuns()
	 * @generated
	 * @ordered
	 */
	protected EList<TestRun> testRuns;

	/**
	 * The cached value of the '{@link #getExeptionsDuringLastRun() <em>Exeptions During Last Run</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExeptionsDuringLastRun()
	 * @generated
	 * @ordered
	 */
	protected EList<Exception> exeptionsDuringLastRun;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EngineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BenchframeworkPackage.Literals.ENGINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestRun> getTestRuns() {
		if (testRuns == null) {
			testRuns = new EObjectResolvingEList<TestRun>(TestRun.class, this, BenchframeworkPackage.ENGINE__TEST_RUNS);
		}
		return testRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Exception> getExeptionsDuringLastRun() {
		return exeptionsDuringLastRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExeptionsDuringLastRun(EList<Exception> newExeptionsDuringLastRun) {
		EList<Exception> oldExeptionsDuringLastRun = exeptionsDuringLastRun;
		exeptionsDuringLastRun = newExeptionsDuringLastRun;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.ENGINE__EXEPTIONS_DURING_LAST_RUN, oldExeptionsDuringLastRun, exeptionsDuringLastRun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void benchmark() {
		setExeptionsDuringLastRun(new BasicEList<Exception>());
		for(int i=0;i<getTestRuns().size();i++){
			TestRun run=getTestRuns().get(i);
			for(int c=0;c<run.getOperators().size();c++){
				Operator op=run.getOperators().get(c);
				try {
					op.execute();
				} catch (Exception e) {
					e.printStackTrace();
					getExeptionsDuringLastRun().add(e);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Operator> getRegisteredOperators() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElement = extensionRegistry.getConfigurationElementsFor(OPERATORID);
		EList<Operator> operators=new BasicEList<Operator>();
		
		for(IConfigurationElement element:configurationElement){
		
				Object obj=null;
				try {
					obj = element.createExecutableExtension(OPERATOR_EXTENSION_CLASS);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				if(obj instanceof Operator)
					operators.add((Operator) obj);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ResultProcessor> getRegisteredResultProcessors() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElement = extensionRegistry.getConfigurationElementsFor(RESULTPROCESSORID);
		BasicEList<ResultProcessor> resultProcessors=new BasicEList<ResultProcessor>();
		
		for(IConfigurationElement element:configurationElement){
		
				Object obj=null;
				try {
					obj = element.createExecutableExtension(RESULT_EXTENSION_CLASS);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				if(obj instanceof ResultProcessor)
					resultProcessors.add((ResultProcessor) obj);
		}
		return resultProcessors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BenchframeworkPackage.ENGINE__TEST_RUNS:
				return getTestRuns();
			case BenchframeworkPackage.ENGINE__EXEPTIONS_DURING_LAST_RUN:
				return getExeptionsDuringLastRun();
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
			case BenchframeworkPackage.ENGINE__TEST_RUNS:
				getTestRuns().clear();
				getTestRuns().addAll((Collection<? extends TestRun>)newValue);
				return;
			case BenchframeworkPackage.ENGINE__EXEPTIONS_DURING_LAST_RUN:
				setExeptionsDuringLastRun((EList<Exception>)newValue);
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
			case BenchframeworkPackage.ENGINE__TEST_RUNS:
				getTestRuns().clear();
				return;
			case BenchframeworkPackage.ENGINE__EXEPTIONS_DURING_LAST_RUN:
				setExeptionsDuringLastRun((EList<Exception>)null);
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
			case BenchframeworkPackage.ENGINE__TEST_RUNS:
				return testRuns != null && !testRuns.isEmpty();
			case BenchframeworkPackage.ENGINE__EXEPTIONS_DURING_LAST_RUN:
				return exeptionsDuringLastRun != null;
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
		result.append(" (exeptionsDuringLastRun: ");
		result.append(exeptionsDuringLastRun);
		result.append(')');
		return result.toString();
	}

} //EngineImpl
