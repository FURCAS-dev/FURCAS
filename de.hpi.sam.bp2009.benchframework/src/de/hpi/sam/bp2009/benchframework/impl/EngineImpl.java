/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import de.hpi.sam.bp2009.benchframework.BenchMarker;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.Engine;
import de.hpi.sam.bp2009.benchframework.Generator;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;
import de.hpi.sam.bp2009.benchframework.UserInterface;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Engine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl#getResults <em>Results</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl#getGenerators <em>Generators</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl#getBenchMarkers <em>Bench Markers</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl#getUserInterfaces <em>User Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EngineImpl extends EObjectImpl implements Engine {
	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<Operator> operators;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<ResultProcessor> results;

	/**
	 * The cached value of the '{@link #getGenerators() <em>Generators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerators()
	 * @generated
	 * @ordered
	 */
	protected EList<Generator> generators;

	/**
	 * The cached value of the '{@link #getBenchMarkers() <em>Bench Markers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBenchMarkers()
	 * @generated
	 * @ordered
	 */
	protected EList<BenchMarker> benchMarkers;

	/**
	 * The cached value of the '{@link #getUserInterfaces() <em>User Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<UserInterface> userInterfaces;

	private static final String GENERATORID	=	"de.hpi.sam.bp2009.benchframework.generatorExtensionPointID";
	private static final String OPERATORID	=	"de.hpi.sam.bp2009.benchframework.operatorExtensionPointID";
	private static final String RESULTID	=	"de.hpi.sam.bp2009.benchframework.resultExtensionPointID";
	private static final String BENCHMARKID	=	"de.hpi.sam.bp2009.benchframework.benchmarkExtensionPointID";
	private static final String USERINTERFACEID	=	"de.hpi.sam.bp2009.benchframework.userInterfaceExtensionPointID";


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
	public EList<Operator> getOperators() {
		if (operators == null) {
			operators = new EObjectResolvingEList<Operator>(Operator.class, this, BenchframeworkPackage.ENGINE__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResultProcessor> getResults() {
		if (results == null) {
			results = new EObjectResolvingEList<ResultProcessor>(ResultProcessor.class, this, BenchframeworkPackage.ENGINE__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Generator> getGenerators() {
		if (generators == null) {
			generators = new EObjectResolvingEList<Generator>(Generator.class, this, BenchframeworkPackage.ENGINE__GENERATORS);
		}
		return generators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BenchMarker> getBenchMarkers() {
		if (benchMarkers == null) {
			benchMarkers = new EObjectResolvingEList<BenchMarker>(BenchMarker.class, this, BenchframeworkPackage.ENGINE__BENCH_MARKERS);
		}
		return benchMarkers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UserInterface> getUserInterfaces() {
		if (userInterfaces == null) {
			userInterfaces = new EObjectResolvingEList<UserInterface>(UserInterface.class, this, BenchframeworkPackage.ENGINE__USER_INTERFACES);
		}
		return userInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param outputStream 
	 */
	public void benchmark(OutputStream outputStream) {
		//TODO add registered UserInterfaces?
		Map<Resource, OptionObject> resources= new HashMap<Resource, OptionObject>();
		ArrayList<ResultProcessor> resultProcessors=getRegisteredResults();
		ArrayList<BenchMarker> benchmarks=getRegisteredBenchMarks();
		for(Generator gen: getRegisteredGenerators()){
			OptionObject optObj=gen.getDefaultOption();
			resources.put(gen.execute(optObj),optObj);
		}

		for(BenchMarker marker :benchmarks){
			for(Operator op: getRegisteredOperators()){
				
				for(Resource resource: resources.keySet()){
					OptionObject optObj= op.getDefaultOption();

					//Run Test
					marker.start();
					op.execute(resource, optObj);
					marker.end();
					
					// Add test results
					for(ResultProcessor proc:resultProcessors)
						proc.addRun(resource, resources.get(resource), optObj, marker);
					
				}
			}
		}
		
		for(ResultProcessor proc: resultProcessors)
			proc.streamTo(outputStream);
	}

	private ArrayList<Generator> getRegisteredGenerators() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElement = extensionRegistry.getConfigurationElementsFor(GENERATORID);
		ArrayList<Generator> generators=new ArrayList<Generator>();
		
		for(IConfigurationElement element:configurationElement){
		
				Object obj=null;
				try {
					obj = element.createExecutableExtension("generatorClass");
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(obj instanceof Generator)
					generators.add((Generator) obj);
		}
		return generators;
	}
	private ArrayList<Operator> getRegisteredOperators() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElement = extensionRegistry.getConfigurationElementsFor(OPERATORID);
		ArrayList<Operator> operators=new ArrayList<Operator>();
		
		for(IConfigurationElement element:configurationElement){
		
				Object obj=null;
				try {
					obj = element.createExecutableExtension("operatorClass");
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(obj instanceof Operator)
					operators.add((Operator) obj);
		}
		return operators;
	}
	private ArrayList<ResultProcessor> getRegisteredResults() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElement = extensionRegistry.getConfigurationElementsFor(RESULTID);
		ArrayList<ResultProcessor> results=new ArrayList<ResultProcessor>();
		
		for(IConfigurationElement element:configurationElement){
		
				Object obj=null;
				try {
					obj = element.createExecutableExtension("resultClass");
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(obj instanceof ResultProcessor)
					results.add((ResultProcessor) obj);
		}
		return results;
	}
	private ArrayList<BenchMarker> getRegisteredBenchMarks() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElement = extensionRegistry.getConfigurationElementsFor(BENCHMARKID);
		ArrayList<BenchMarker> benchmarks=new ArrayList<BenchMarker>();
		
		for(IConfigurationElement element:configurationElement){
		
				Object obj=null;
				try {
					obj = element.createExecutableExtension("benchmarkClass");
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(obj instanceof BenchMarker)
					benchmarks.add((BenchMarker) obj);
		}
		return benchmarks;
	}
	
	private ArrayList<UserInterface> getRegisteredUserInterfaces() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElement = extensionRegistry.getConfigurationElementsFor(USERINTERFACEID);
		ArrayList<UserInterface> userinterfaces=new ArrayList<UserInterface>();
		
		for(IConfigurationElement element:configurationElement){
		
				Object obj=null;
				try {
					obj = element.createExecutableExtension("userInterfaceClass");
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(obj instanceof UserInterface)
					userinterfaces.add((UserInterface) obj);
		}
		return userinterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BenchframeworkPackage.ENGINE__OPERATORS:
				return getOperators();
			case BenchframeworkPackage.ENGINE__RESULTS:
				return getResults();
			case BenchframeworkPackage.ENGINE__GENERATORS:
				return getGenerators();
			case BenchframeworkPackage.ENGINE__BENCH_MARKERS:
				return getBenchMarkers();
			case BenchframeworkPackage.ENGINE__USER_INTERFACES:
				return getUserInterfaces();
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
			case BenchframeworkPackage.ENGINE__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends Operator>)newValue);
				return;
			case BenchframeworkPackage.ENGINE__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends ResultProcessor>)newValue);
				return;
			case BenchframeworkPackage.ENGINE__GENERATORS:
				getGenerators().clear();
				getGenerators().addAll((Collection<? extends Generator>)newValue);
				return;
			case BenchframeworkPackage.ENGINE__BENCH_MARKERS:
				getBenchMarkers().clear();
				getBenchMarkers().addAll((Collection<? extends BenchMarker>)newValue);
				return;
			case BenchframeworkPackage.ENGINE__USER_INTERFACES:
				getUserInterfaces().clear();
				getUserInterfaces().addAll((Collection<? extends UserInterface>)newValue);
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
			case BenchframeworkPackage.ENGINE__OPERATORS:
				getOperators().clear();
				return;
			case BenchframeworkPackage.ENGINE__RESULTS:
				getResults().clear();
				return;
			case BenchframeworkPackage.ENGINE__GENERATORS:
				getGenerators().clear();
				return;
			case BenchframeworkPackage.ENGINE__BENCH_MARKERS:
				getBenchMarkers().clear();
				return;
			case BenchframeworkPackage.ENGINE__USER_INTERFACES:
				getUserInterfaces().clear();
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
			case BenchframeworkPackage.ENGINE__OPERATORS:
				return operators != null && !operators.isEmpty();
			case BenchframeworkPackage.ENGINE__RESULTS:
				return results != null && !results.isEmpty();
			case BenchframeworkPackage.ENGINE__GENERATORS:
				return generators != null && !generators.isEmpty();
			case BenchframeworkPackage.ENGINE__BENCH_MARKERS:
				return benchMarkers != null && !benchMarkers.isEmpty();
			case BenchframeworkPackage.ENGINE__USER_INTERFACES:
				return userInterfaces != null && !userInterfaces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EngineImpl
