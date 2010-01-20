package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.Engine;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;
import de.hpi.sam.bp2009.benchframework.UserInterface;

public class WizardUserInterfaceImpl extends EObjectImpl implements UserInterface {
		/**
		 * The cached value of the '{@link #getEngine() <em>Engine</em>}' reference.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see #getEngine()
		 * @generated
		 * @ordered
		 */
		protected Engine engine;

		/**
		 * The cached value of the '{@link #getAvailableOperators() <em>Available Operators</em>}' reference list.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see #getAvailableOperators()
		 * @generated
		 * @ordered
		 */
		protected EList<Operator> availableOperators;

		/**
		 * The cached value of the '{@link #getResultProcessor() <em>Result Processor</em>}' reference.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see #getResultProcessor()
		 * @generated
		 * @ordered
		 */
		protected ResultProcessor resultProcessor;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected WizardUserInterfaceImpl() {
			super();
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
//		@Override
//		protected EClass eStaticClass() {
//			return BenchframeworkPackage.Literals.USER_INTERFACE;
//		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Engine getEngine() {
			if (engine != null && engine.eIsProxy()) {
				InternalEObject oldEngine = (InternalEObject)engine;
				engine = (Engine)eResolveProxy(oldEngine);
				if (engine != oldEngine) {
					if (eNotificationRequired())
						eNotify(new ENotificationImpl(this, Notification.RESOLVE, BenchframeworkPackage.USER_INTERFACE__ENGINE, oldEngine, engine));
				}
			}
			return engine;
		}

//		/**
//		 * <!-- begin-user-doc -->
//		 * <!-- end-user-doc -->
//		 * @generated
//		 */
//		public Engine basicGetEngine() {
//			return engine;
//		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void setEngine(Engine newEngine) {
			Engine oldEngine = engine;
			engine = newEngine;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.USER_INTERFACE__ENGINE, oldEngine, engine));
			this.availableOperators=engine.getRegisteredOperators();
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public EList<Operator> getAvailableOperators() {
			if (availableOperators == null) {
				availableOperators = new EObjectResolvingEList<Operator>(Operator.class, this, BenchframeworkPackage.USER_INTERFACE__AVAILABLE_OPERATORS);
			}
			return availableOperators;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ResultProcessor getResultProcessor() {
			if (resultProcessor != null && resultProcessor.eIsProxy()) {
				InternalEObject oldResultProcessor = (InternalEObject)resultProcessor;
				resultProcessor = (ResultProcessor)eResolveProxy(oldResultProcessor);
				if (resultProcessor != oldResultProcessor) {
					if (eNotificationRequired())
						eNotify(new ENotificationImpl(this, Notification.RESOLVE, BenchframeworkPackage.USER_INTERFACE__RESULT_PROCESSOR, oldResultProcessor, resultProcessor));
				}
			}
			return resultProcessor;
		}

//		/**
//		 * <!-- begin-user-doc -->
//		 * <!-- end-user-doc -->
//		 * @generated
//		 */
//		public ResultProcessor basicGetResultProcessor() {
//			return resultProcessor;
//		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void setResultProcessor(ResultProcessor newResultProcessor) {
			ResultProcessor oldResultProcessor = resultProcessor;
			resultProcessor = newResultProcessor;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.USER_INTERFACE__RESULT_PROCESSOR, oldResultProcessor, resultProcessor));
		}

//		/**
//		 * <!-- begin-user-doc -->
//		 * <!-- end-user-doc -->
//		 * @generated
//		 */
//		@Override
//		public Object eGet(int featureID, boolean resolve, boolean coreType) {
//			switch (featureID) {
//				case BenchframeworkPackage.USER_INTERFACE__ENGINE:
//					if (resolve) return getEngine();
//					return basicGetEngine();
//				case BenchframeworkPackage.USER_INTERFACE__AVAILABLE_OPERATORS:
//					return getAvailableOperators();
//				case BenchframeworkPackage.USER_INTERFACE__RESULT_PROCESSOR:
//					if (resolve) return getResultProcessor();
//					return basicGetResultProcessor();
//			}
//			return super.eGet(featureID, resolve, coreType);
//		}
//
//		/**
//		 * <!-- begin-user-doc -->
//		 * <!-- end-user-doc -->
//		 * @generated
//		 */
//		@SuppressWarnings("unchecked")
//		@Override
//		public void eSet(int featureID, Object newValue) {
//			switch (featureID) {
//				case BenchframeworkPackage.USER_INTERFACE__ENGINE:
//					setEngine((Engine)newValue);
//					return;
//				case BenchframeworkPackage.USER_INTERFACE__AVAILABLE_OPERATORS:
//					getAvailableOperators().clear();
//					getAvailableOperators().addAll((Collection<? extends Operator>)newValue);
//					return;
//				case BenchframeworkPackage.USER_INTERFACE__RESULT_PROCESSOR:
//					setResultProcessor((ResultProcessor)newValue);
//					return;
//			}
//			super.eSet(featureID, newValue);
//		}
//
//		/**
//		 * <!-- begin-user-doc -->
//		 * <!-- end-user-doc -->
//		 * @generated
//		 */
//		@Override
//		public void eUnset(int featureID) {
//			switch (featureID) {
//				case BenchframeworkPackage.USER_INTERFACE__ENGINE:
//					setEngine((Engine)null);
//					return;
//				case BenchframeworkPackage.USER_INTERFACE__AVAILABLE_OPERATORS:
//					getAvailableOperators().clear();
//					return;
//				case BenchframeworkPackage.USER_INTERFACE__RESULT_PROCESSOR:
//					setResultProcessor((ResultProcessor)null);
//					return;
//			}
//			super.eUnset(featureID);
//		}
//
//		/**
//		 * <!-- begin-user-doc -->
//		 * <!-- end-user-doc -->
//		 * @generated
//		 */
//		@Override
//		public boolean eIsSet(int featureID) {
//			switch (featureID) {
//				case BenchframeworkPackage.USER_INTERFACE__ENGINE:
//					return engine != null;
//				case BenchframeworkPackage.USER_INTERFACE__AVAILABLE_OPERATORS:
//					return availableOperators != null && !availableOperators.isEmpty();
//				case BenchframeworkPackage.USER_INTERFACE__RESULT_PROCESSOR:
//					return resultProcessor != null;
//			}
//			return super.eIsSet(featureID);
//		}

	}