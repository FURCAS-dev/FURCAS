package com.sap.mi.fwk.ui.test.unit.databinding;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;

import com.sap.demo.mi.testmetamodel.databinding.ObjectWithAttributes;
import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.mi.fwk.ui.internal.databinding.observables.RefObjectObservableValue;
import com.sap.tc.moin.repository.Connection;

/**
 * Tests around MOIN {@link RefObjectObservableValue RefObjectObservableValues}.
 * 
 * @author d027044
 * 
 */
public class DatabindingTest extends ExtendedTestCase {

	private Connection connection = null;
	private MoinDataBindingContext dbc = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		connection = ConnectionManager.getInstance().createTransientConnection();
		new SetDefaultRealm();
		dbc = new MoinDataBindingContext();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		// Clean-up
		dbc.dispose();
		dbc = null;
		connection.revert();
		connection = null;
	}

	protected Connection getConnection() {
		return connection;
	}
	
	protected DataBindingContext getDbc() {
		return dbc;
	}

	protected ObjectWithAttributes createInstanceObjectWithAttributes() {
		return getConnection().createElement(ObjectWithAttributes.class);
	}

	private class SetDefaultRealm extends Realm {
		public SetDefaultRealm() {
			Realm.setDefault(this);
		}
		
		@Override
		public boolean isCurrent() {
			return true;
		}
		
		@Override
		public void asyncExec(Runnable runnable) {
			throw new IllegalStateException("Realm.asyncExec must not be called in test mode");//$NON-NLS-1$
		}
	};
}