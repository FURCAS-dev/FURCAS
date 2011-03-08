package com.sap.runlet.expressionpad.failing;

import java.util.Set;

import junit.framework.TestCase;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.runlet.abstractexpressionpad.Evaluator;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;

import data.classes.AElementsOfTypeClazz;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import dataaccess.expressions.MethodCallExpression;

public class RunletOclIaTests extends TestCase {
    private Connection connection;
    
    private Connection getConnection() {
        return connection;
    }

    protected void setUp() {
	connection = Evaluator.getResourceSet("ngpm.stdlib");
    }
    
    /**
     * self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()->select(s | s.name = '__TEXT___')
     */
    public void testAnalysisOfRecursiveOperationWithSelfAndSyntheticEvent() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils
		.createOclExpression(
			connection,
			"testAnalysisOfRecursiveOperationWithSelf",
			"self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.allSignatures()->select(s | s.name = '__TEXT___')", MethodCallExpression.CLASS_DESCRIPTOR);

	final SapClass numberClass = MetamodelUtils.findClass(getConnection(), "Number");
	String facilityId = numberClass.get___Mri().getLri().getDataAreaDescriptor().getFacilityId();
	final ClassTypeDefinition ctd = (ClassTypeDefinition) connection.getElement(connection.getSession().getMoin()
		.getFacilityById(facilityId).getRIFactory().createLri(
			numberClass.get___Mri().getLri().getDataAreaDescriptor().getDataAreaName(),
			"E016575C85CC9470B83811DEAFF1001CBF0234BB"));
	
	LinkRemoveEvent lre = new LinkRemoveEvent() {
	    @Override
	    public RefFeatured getAffectedMetaObject(Connection resolvingConnection) {
		return resolvingConnection.getAssociation(AElementsOfTypeClazz.ASSOCIATION_DESCRIPTOR).refMetaObject();
	    }

	    @Override
	    public MRI getAffectedMetaObjectMri() {
		return getAffectedMetaObject(getConnection()).get___Mri();
	    }

	    @Override
	    public RefObject getFirstLinkEnd(Connection resolvingConnection) {
		return ctd;
	    }

	    @Override
	    public MRI getFirstLinkEndMri() {
		return ctd.get___Mri();
	    }

	    @Override
	    public LRI getNonStoredLinkEndLri() {
		return getFirstLinkEndMri().getLri();
	    }

	    @Override
	    public int getPosition() {
		return -1;
	    }

	    @Override
	    public RefObject getSecondLinkEnd(Connection resolvingConnection) {
		return numberClass;
	    }

	    @Override
	    public MRI getSecondLinkEndMri() {
		return getSecondLinkEnd(getConnection()).get___Mri();
	    }

	    @Override
	    public MRI getStoredLinkEndMri() {
		return getSecondLinkEndMri();
	    }

	    @Override
	    public Connection getEventTriggerConnection() {
		return getConnection();
	    }

	    @Override
	    public void veto(String reason) {
		throw new RuntimeException("Veto: " + reason);
	    }
	};
	Set<MRI> affectedElements = registration.getAffectedModelElements(lre, getConnection());
	// no elements are expected to be affected; the ClassTypeDefinition marks the output
	// of the "t0" MethodSignature on the output multiplicity test class. The OCL expression,
	// however, only considers ObjectBasedExpression elements.
	
	// FIXME we're currently getting 191 results here; check if this was to be expected...
	assertEquals(0, affectedElements.size());
    }

    

}
