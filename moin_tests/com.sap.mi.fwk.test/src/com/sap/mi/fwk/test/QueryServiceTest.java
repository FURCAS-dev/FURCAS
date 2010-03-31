package com.sap.mi.fwk.test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.mi.fwk.util.IExceptionHandler;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests {@link QueryService}
 * 
 * @author d031150
 */
public class QueryServiceTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/queryservice";

	private Connection mConnection;

	public QueryServiceTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected InputStream getProjectContentAsStream() {
		return QueryServiceTest.class.getResourceAsStream("QueryServiceTestData.zap");
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mConnection = createConnection();
	}

	@Override
	protected void tearDown() throws Exception {
		mConnection = null;

		super.tearDown();
	}

	public void testQueryInstances() {
		List<Component> components = QueryService.getInstance().queryInstances(getProject(), mConnection,
				CONTAINER_NAME_WEBDYNPRO, TYPE_NAME_COMPONENT);
		assertTrue("No Component found in " + components, components.size() == 1);

		RefBaseObject component = components.get(0);
		assertNotNull("Null entry in result list " + components, component);

		// The queryInstances implementation cannot technically quarantee that
		// all objects in the list are of the promised type
		// (due to Generics' type erasion at compile time).
		assertTrue("Expected type was " + Component.class.getName() + ", but is: " + component.getClass().getName(),
				component instanceof Component);
	}

	public void testQueryInstancesNullPartition() {
		List<Component> components = QueryService.getInstance().queryInstances(getProject(), mConnection,
				CONTAINER_NAME_WEBDYNPRO, TYPE_NAME_COMPONENT);
		components.get(0).get___Connection( ).createElementInPartition( Component.class, null ).setName( "ComponentInNullPartition" );

		components = QueryService.getInstance().queryInstances(getProject(), mConnection, CONTAINER_NAME_WEBDYNPRO,
				TYPE_NAME_COMPONENT);
		assertEquals("Null partition content not returned: " + components, 2, components.size());
	}

	public void testQueryInstancesDirtyState() {
		List<Component> components = QueryService.getInstance().queryInstances(getProject(), mConnection,
				CONTAINER_NAME_WEBDYNPRO, TYPE_NAME_COMPONENT);
		Component newComp = components.get(0).get___Connection( ).createElementInPartition( Component.class, null );
		newComp.setName("ComponentInNullPartition");
		ModelPartition partition = createPartition();
		partition.assignElement(newComp);

		components = QueryService.getInstance().queryInstances(getProject(), mConnection, CONTAINER_NAME_WEBDYNPRO,
				TYPE_NAME_COMPONENT);
		assertTrue("Dirty state content not returned: " + newComp, components.contains(newComp));
	}

	public void testQueryInstancesScopes() {
		IPartitionScopeProvider scopeProvider = PartitionService.getInstance().getPartitionScopeProvider(mConnection,
				PartitionScope.VISIBLE);
		List<Component> components = QueryService.getInstance().queryInstances(mConnection, scopeProvider,
				CONTAINER_NAME_WEBDYNPRO, TYPE_NAME_COMPONENT);
		ModelPartition partition = createPartition();
		Component newComp = partition.createElement( Component.class );
		newComp.setName( "ComponentInNullPartition" );

		components = QueryService.getInstance().queryInstances(getProject(), mConnection, CONTAINER_NAME_WEBDYNPRO,
				TYPE_NAME_COMPONENT);
		assertTrue("Dirty state content not returned: " + newComp, components.contains(newComp));
	}

	public void testQueryInstancesNoProject() {
		try {
			QueryService.getInstance().queryInstances(null, mConnection, CONTAINER_NAME_WEBDYNPRO, TYPE_NAME_COMPONENT);
		} catch (RuntimeException e) {
			fail("Project == null must be allowed", e);
		}
	}

	public void testQueryInstancesNoConnection() {
		try {
			QueryService.getInstance()
					.queryInstances(getProject(), null, CONTAINER_NAME_WEBDYNPRO, TYPE_NAME_COMPONENT);
			fail("Connection == null is not allowed");

		} catch (RuntimeException e) { // $JL-EXC$
		}

		try {
			mConnection.close();
			QueryService.getInstance().queryInstances(getProject(), mConnection, CONTAINER_NAME_WEBDYNPRO,
					TYPE_NAME_COMPONENT);
			fail("Closed connection is not allowed");
		} catch (RuntimeException e) { // $JL-EXC$
		}
	}

	public void testQueryInstancesNoQN() {
		try {
			QueryService.getInstance().queryInstances(getProject(), mConnection, CONTAINER_NAME_WEBDYNPRO,
					(String[]) null);
			fail("QualifiedName == null is not allowed");
		} catch (RuntimeException e) { // $JL-EXC$
		}

		// is not accepted by Moin, but QueryService logs and returns an
		// empty result set
		final Throwable[] e = new Throwable[1];
		List<Component> components = newQueryServiceWithExceptionHandler(new IExceptionHandler() {
			public void handleException(Throwable t) {
				e[0] = t;
			}

		}).queryInstances(getProject(), mConnection, CONTAINER_NAME_WEBDYNPRO, "");
		assertNotNull("Exception must have been logged", e[0]);
		assertNotNull("Result set must not be null", components);
		assertTrue("Result set must be empty", components.isEmpty());
	}

	public void testQueryInstancesNoMetamodel() {
		{
			// is not accepted by Moin, but QueryService logs and returns an
			// empty result set
			final Throwable[] e = new Throwable[1];
			List<Component> components = newQueryServiceWithExceptionHandler(new IExceptionHandler() {
				public void handleException(Throwable t) {
					e[0] = t;
				}

			}).queryInstances(getProject(), mConnection, "", TYPE_NAME_COMPONENT);
			assertNotNull("Exception must have been logged", e[0]);
			assertNotNull("Result set must not be null", components);
			assertTrue("Result set must be empty", components.isEmpty());
		}
		{
			List<Component> components = QueryService.getInstance().queryInstances(getProject(), mConnection, null,
					TYPE_NAME_COMPONENT);
			assertTrue("No Component found in " + components, components.size() == 1);
		}
	}

	public void testGetQueryScopeProvider() {
		IPartitionScopeProvider scopeProvider = PartitionService.getInstance().getPartitionScopeProvider(mConnection,
				PartitionScope.VISIBLE);
		QueryScopeProvider queryProvider = QueryService.getInstance().getQueryScopeProvider(scopeProvider);
		Set<PRI> actual = new HashSet<PRI>(Arrays.asList(queryProvider.getPartitionScope()));
		assertEquals("QueryScopeProvider must be backed by IPartitionScopeProvider", scopeProvider.getPartitions(),
				actual);

		try {
			queryProvider = QueryService.getInstance().getQueryScopeProvider(null);
			fail("Must fail with partitionScopeProvider==null: " + queryProvider);
		} catch (RuntimeException expected) {
		}
	}

	private ModelPartition createPartition() {
		PRI pri = getPri(getProject(), SOURCE_FOLDER_WEBDYNPRO.append("com/sap").append("partition2"));
		ModelPartition partition = mConnection.createPartition(pri);
		return partition;
	}

	/**
	 * Creates a new instance of {@link QueryService} (through non-public
	 * methods) instrumented with the given exception handler. In this way
	 * exceptions that would normally by logged can now be catched so that thy
	 * do not pollute the test log and lead to misconceptios about the test
	 * success.
	 */
	private QueryService newQueryServiceWithExceptionHandler(IExceptionHandler handler) {
		QueryService queryService = newNonPublicInstance(QueryService.class, null, null);
		runNonPublicMethod(queryService, "setExceptionHandler", new Class[] { IExceptionHandler.class },
				new Object[] { handler });
		return queryService;
	}

}
