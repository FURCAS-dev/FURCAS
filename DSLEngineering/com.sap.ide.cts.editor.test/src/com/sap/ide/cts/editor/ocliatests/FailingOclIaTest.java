package com.sap.ide.cts.editor.ocliatests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import behavioral.events.EventFilter;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.test.base.StandaloneConnectionBasedTest;
import com.sap.furcas.test.util.TcsTestHelper;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;

public class FailingOclIaTest extends StandaloneConnectionBasedTest {

    @Before
    public void initParsingHandlerAndSetupInstanceScopeAnalysis() {
	// create tcs Syntax
	ConcreteSyntax tcsSyntax = TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
	assertNotNull(tcsSyntax);
    }
    
    @Test
    public void testDelegatesTo() throws OclManagerException {
	final OclExpressionRegistration registration = MetamodelUtils.createOclExpression(connection,
		"testDelegatesTo",
		"self.delegatesTo()", SapClass.CLASS_DESCRIPTOR);
	SapClass a = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	a.setName("A");
	SapClass b = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	b.setName("B");
	AssociationEnd aeA = connection.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	aeA.setName("a");
	ClassTypeDefinition aCtd = MetamodelUtils.createClassTypeDefinitionExactlyOne(connection, a);
	aeA.setType(aCtd);
	AssociationEnd aeB = connection.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	aeB.setName("b");
	ClassTypeDefinition bCtd = MetamodelUtils.createClassTypeDefinitionExactlyOne(connection, b);
	Association assoc = connection.createElement(Association.CLASS_DESCRIPTOR);
	assoc.getEnds().add(aeA);
	assoc.getEnds().add(aeB);
	EventFilter eventFilter = registration.getEventFilter(/* notifyNewContextElement */ false);
	final boolean[] ok = new boolean[1];
	ChangeListener listener = new ChangeListener() {
	    @Override
	    public void notify(ChangeEvent event) {
		// FIXME currently it seems that when getAssociationEnds() correctly is triggered, the "look to right" doesn't find out that otherEnd()->select(delegation->notEmpty()) evaluates to an empty set; why???
		Set<URI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		// since no association end is delegating, ideally there would be no impact on delegatesTo on either end
		ok[0] = affectedElements.size() == 0;
	    }
	};
	connection.getEventRegistry().registerListener(listener, eventFilter);
	aeB.setType(bCtd);
	try {
	    assertTrue(ok[0]);
	} finally {
	    connection.getEventRegistry().deregister(listener);
	}
    }
    
}
