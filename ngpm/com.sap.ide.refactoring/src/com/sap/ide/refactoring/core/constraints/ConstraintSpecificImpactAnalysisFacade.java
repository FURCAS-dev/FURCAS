package com.sap.ide.refactoring.core.constraints;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.attaching.ClassifierInvariant;
import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.attaching.__impl.OclConstraintImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.ocl.ia.instancescope.AnnotatedRefObjectImpl;
import com.sap.tc.moin.ocl.ia.instancescope.InstanceScopeAnalysis;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.PathCache;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.OclMetaModelConstraintRegistrationWrapper;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.ocl.service.impl.MetaModelConstraintInfoImpl;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassWrapper;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

/**
 * Thin adapter that allows to register moin metamodel constraints in the impact analysis.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class ConstraintSpecificImpactAnalysisFacade {

    private final OclMetaModelConstraintRegistration constraintRegistration;
    private final OclConstraintImpl constraint;
    
    /**
     * Used for the instance scope impact analysis so as to not having to
     * re-analyze the same expressions over and over again.
     */
    private final PathCache instanceScopeAnalysisPathCache;
    private EventFilter eventFilter;
    private InstanceScopeAnalysis analyzer;
    private ClassScopeAnalyzer classScopeAnalyzer;
    
    public ConstraintSpecificImpactAnalysisFacade(OclMetaModelConstraintRegistration constraintRegistration, OclConstraintImpl constraint) {
	this.constraintRegistration = constraintRegistration;
	this.constraint = constraint;
	this.instanceScopeAnalysisPathCache = new PathCache();
    }
    
    public EventFilter getEventFilter(Connection connection, boolean notifyNewContextElement) {
	if (eventFilter == null) {
	    eventFilter = getClassScopeAnalyzer(connection, notifyNewContextElement).getEventFilter();
	}
	return eventFilter;
    }
    
    private ClassScopeAnalyzer getClassScopeAnalyzer(Connection connection, boolean notifyNewContextElement) {
	if (classScopeAnalyzer == null) {
	    classScopeAnalyzer = new ClassScopeAnalyzer(((ConnectionWrapper) connection).unwrap(), (OclExpressionInternal) constraint.getOclExpression(), notifyNewContextElement);
	}
	return classScopeAnalyzer;
    }

    public Set<MRI> getAffectedModelElements(Connection connection, ModelChangeEvent mce) {
	Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache = new HashMap<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>>();
	return	getImpactAnalyzer(connection).getAffectedElements(getContext(connection), mce, cache);
    }
    
    private InstanceScopeAnalysis getImpactAnalyzer(Connection connection) {
	if (analyzer == null) {
	    analyzer = new InstanceScopeAnalysis(constraintRegistration, constraint.getOclExpression(), ((ConnectionWrapper) connection).unwrap(),
		    instanceScopeAnalysisPathCache, getClassScopeAnalyzer(connection, /* notifyNewContextElement */false));
	}
	return analyzer;
    }

    private MofClassImpl getContext(Connection connection) {
	MetaModelConstraintInfoImpl infoImpl = (MetaModelConstraintInfoImpl) ((OclMetaModelConstraintRegistrationWrapper) constraintRegistration).unwrap();
	Collection<Classifier> classifiers = connection.getAssociation(ClassifierInvariant.ASSOCIATION_DESCRIPTOR).getInvariantOf((OclConstraint) ((ConnectionWrapper) connection).unwrap().getElement(infoImpl.getConstraintMRI()));
	assert classifiers.size() == 1; // TODO: We currently assume that there is always just one.
	return ((MofClassWrapper) classifiers.iterator().next()).unwrap();
    }
}
