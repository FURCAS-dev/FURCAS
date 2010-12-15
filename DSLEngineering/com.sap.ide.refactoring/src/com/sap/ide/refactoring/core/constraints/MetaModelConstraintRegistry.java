package com.sap.ide.refactoring.core.constraints;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.omg.ocl.attaching.__impl.OclConstraintImpl;
import org.omg.ocl.attaching.__impl.OclConstraintWrapper;
import org.omg.ocl.expressions.OclExpression;

import com.sap.ide.refactoring.Activator;
import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.ocl.evaluator.ExpressionUndefinedException;
import com.sap.tc.moin.ocl.evaluator.OclConstraintEvaluator;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.OclMetaModelConstraintRegistrationWrapper;
import com.sap.tc.moin.repository.core.ocl.service.impl.MetaModelConstraintInfoImpl;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;

/**
 * A central manager for the registration, deregistration and evaluation of OCL
 * metamodel constraints.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class MetaModelConstraintRegistry {

    private final Connection connection;
    private final HashMap<OclMetaModelConstraintRegistration, IAConstrantInvalidationListener> listenerPerRegistration = new HashMap<OclMetaModelConstraintRegistration, IAConstrantInvalidationListener>();

    public MetaModelConstraintRegistry(Connection connection) {
	this.connection = connection;
    }
    
    public void registerAllMetaModelConstraintsForIncrementalEvaluation(IProgressMonitor pm) {
	OclRegistryService registry = connection.getOclRegistryService();
	try {
	    pm.beginTask("Preparing OCL MetaModel Constraints (IA Setup)", registry.getMetamodelConstraintRegistry().getAvailableMetamodelConstraints().size());
	    for (OclMetaModelConstraintRegistration registration : registry.getMetamodelConstraintRegistry().getAvailableMetamodelConstraints()) {
		IAConstrantInvalidationListener listener = new IAConstrantInvalidationListener(connection, createOrGetCachedAnalyzer(registration));

		EventFilter filter = listener.getEventFilter();
		connection.getSession().getEventRegistry().registerListener(listener, filter);
		listenerPerRegistration.put(registration, listener);
		
		pm.worked(1);
	    }
	} catch (OclConstraintManagerException e) {
	    throw new RuntimeException("Failed to setup OCL Constraint Impact Analyzers", e);
	} finally {
	    pm.done();
	}
    }
    
    private ConstraintSpecificImpactAnalysisFacade createOrGetCachedAnalyzer(OclMetaModelConstraintRegistration registration) {
	HashMap<List<String>, ConstraintSpecificImpactAnalysisFacade> cache = Activator.getDefault().getImpactAnalyzerConstraintCache();
	if (!cache.containsKey(registration.getQualifiedName())) {
	    cache.put(registration.getQualifiedName(), new ConstraintSpecificImpactAnalysisFacade(registration, unwrapConstraintOfConstraintRegistration(registration)));
	}
	return cache.get(registration.getQualifiedName());
    }
    
    private OclConstraintImpl unwrapConstraintOfConstraintRegistration(OclMetaModelConstraintRegistration constraintRegistration) {
	MetaModelConstraintInfoImpl infoImpl = ((MetaModelConstraintInfoImpl) ((OclMetaModelConstraintRegistrationWrapper) constraintRegistration).unwrap());
	return ((OclConstraintWrapper) connection.getElement(infoImpl.getConstraintMRI())).unwrap();
    }

    public void deregisterRegisteredMetaModelConstraintListeners(IProgressMonitor pm) {
	pm.beginTask("Deregistering OCL MetaModel Impact Analyzers", listenerPerRegistration.size());
	for (IAConstrantInvalidationListener listener : listenerPerRegistration.values()) {
	    connection.getSession().getEventRegistry().deregister(listener);
	}
	listenerPerRegistration.clear();
	pm.done();
    }
    
    /**
     * Returns all currently broken constraints.
     * @return 
     */
    public Collection<ConstraintViolation> evaluateConstraints(IProgressMonitor pm) {
	pm.beginTask("Evaluating Impacted OCL constraints", listenerPerRegistration.size());
	Collection<ConstraintViolation> violations = new LinkedList<ConstraintViolation>();
	OclConstraintEvaluator evaluator = new OclConstraintEvaluator();
	
	for (Entry<OclMetaModelConstraintRegistration, IAConstrantInvalidationListener> entry : listenerPerRegistration.entrySet()) {
	    IAConstrantInvalidationListener listener = entry.getValue();
	    OclMetaModelConstraintRegistration registration = entry.getKey();
	    
	    CoreConnection coreConn = ((ConnectionWrapper) connection).unwrap();
	    OclExpression expression = unwrapConstraintOfConstraintRegistration(registration).getOclExpression();
	    
	    for (MRI impactedElementMRI : listener.getElementsImpactedByEvents()) {
		RefObject elementToCheck = (RefObject) connection.getElement(impactedElementMRI);
		try {
		    boolean isValid = evaluator.evaluate(coreConn, expression, elementToCheck);
		    if (!isValid) {
			ConstraintViolation violation = new ConstraintViolation(elementToCheck, registration);
			violations.add(violation);
		    }
		} catch (ExpressionUndefinedException e) {
		    Activator.logError(e, "Failed to evaluate metamodel constraint");
		    ConstraintViolation violation = new ConstraintViolation(elementToCheck, registration);
		    violations.add(violation);;
		} catch (EvaluatorException e) {
		    Activator.logError(e, "Failed to evaluate metamodel constraint");
		    ConstraintViolation violation = new ConstraintViolation(elementToCheck, registration);
		    violations.add(violation);;
		} finally {
		    pm.worked(1);
		}
		
	    }
	}
	pm.done();
	return violations;
    }

}
