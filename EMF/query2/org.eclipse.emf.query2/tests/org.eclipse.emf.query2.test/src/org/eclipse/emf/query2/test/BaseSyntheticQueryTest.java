package org.eclipse.emf.query2.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query2.ColumnType;
import org.eclipse.emf.query2.FromEntry;
import org.eclipse.emf.query2.FromFixedSet;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.JoinWhereEntry;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.SelectAlias;
import org.eclipse.emf.query2.SelectAttrs;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.emf.query2.TypeScopeProvider;
import org.eclipse.emf.query2.WhereAnd;
import org.eclipse.emf.query2.WhereClause;
import org.eclipse.emf.query2.WhereComparisonAliases;
import org.eclipse.emf.query2.WhereComparisonAttrs;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereInt;
import org.eclipse.emf.query2.WhereNestedReference;
import org.eclipse.emf.query2.WhereNot;
import org.eclipse.emf.query2.WhereOr;
import org.eclipse.emf.query2.WhereRelationReference;
import org.eclipse.emf.query2.WhereString;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage;
import org.eclipse.emf.query2.test.setup.DefaultTestClientImpl;
import org.eclipse.emf.query2.test.setup.IndexSetupManager;
import org.eclipse.emf.query2.test.setup.TestClient;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
abstract public class BaseSyntheticQueryTest extends QueryTestCase {

	// private static final String GENERATED_MM_CONTAINER_NAME =
	// "sap.com/tc/moin/metamodel/generatedmetamodel";

	static protected TestClient myTestClient;

	static protected ModelDataInstantiator mdi;

	static public String partitionNameAppendix = ""; //$NON-NLS-1$

	// the following are test suite parameters with some defaults

	static protected int mmSize = 10;

	static protected int attrSize = 10;

	static protected int instSize = 10;

	static protected int partSize = 10;

	static protected URI[] partitionScope = null;

	static protected boolean partitionScopeInclusive = true;

	static protected boolean createDirtyData = true;

	static protected boolean createObjValAttrs = true;

	static private String LOG_MODE = System.getProperty("org.eclipse.emf.query2.test.tracelevel", null); //$NON-NLS-1$

	// we need this as state for the actual tests
	protected int dirtyPartitionsRatio;

	// default is true
	protected boolean withOptimization = true;

	private Index index;

	private static enum LogSeverity {
		INFO("INFO"), ERROR("ERROR"), DEBUG("DEBUG"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		String val;

		private LogSeverity(String v) {
			val = v;
		}

		public String getValue() {
			return val;
		}
	}

	private static boolean isTraced(LogSeverity sev) {
		return sev.getValue().equalsIgnoreCase(LOG_MODE);
	}

	private static void trace(LogSeverity sev, String s) {
		System.out.println("QUERY " + sev.getValue() + ": " + s); //$NON-NLS-1$ //$NON-NLS-2$
	}

	static public void beforeQueryTests(boolean withSave) throws Exception {

		if (isTraced(LogSeverity.INFO)) {
			trace(LogSeverity.INFO, "Query Test INITIALIZATION START"); //$NON-NLS-1$
		}

		init();

		mdi = new ModelDataInstantiator(myTestClient, withSave, mmSize, attrSize, instSize, partSize, createObjValAttrs);
		mdi.createData();

		// index all created partitions
		IndexSetupManager.index(getDefaultIndexStore(), myTestClient.getResourceSet().getResources().toArray(new Resource[0]));

		// test setup sanity check
		/*
		 * Note: setting the modification tracking to active may be done here
		 * instead of in the test client, but then the 'withSave' option must
		 * always be true (?)
		 */
		for (URI uri : mdi.getAllPartitions()) {
			assertTrue("Modification tracking must be enabled for query tests", myTestClient.getResource(uri).isTrackingModification()); //$NON-NLS-1$
		}

		// should happen after instantiate and save
		if (partitionScope == null && partitionScopeInclusive) {
			partitionScope = mdi.getAllPartitions().toArray(new URI[] {});
		}

		if (isTraced(LogSeverity.INFO)) {
			trace(LogSeverity.INFO, "Query Test INITIALIZATION END"); //$NON-NLS-1$
		}
	}

	private static void init() {

		myTestClient = new DefaultTestClientImpl();

	}

	static public void afterQueryTests(boolean deletePartitions) throws Exception {

		if (isTraced(LogSeverity.INFO)) {
			trace(LogSeverity.INFO, "Query Test CLEANUP START"); //$NON-NLS-1$
		}

		// remove from index
		if (deletePartitions && partitionScope != null) {
			IndexSetupManager.delete(getDefaultIndexStore(), partitionScope);
		}

		// if we have to delete the partitions
		if (mdi != null && deletePartitions) {
			mdi.removeData();
		}

		clear();

		if (mdi != null) {
			mdi.shutdown();
			mdi = null;
		}

		if (isTraced(LogSeverity.INFO)) {
			trace(LogSeverity.INFO, "Query Test CLEANUP END"); //$NON-NLS-1$
		}
	}

	static protected void clear() {

		if (myTestClient != null) {
			myTestClient.clear();
		}
		myTestClient = null;
	}

	static protected void resetTestEnvironment() {

		clear();
		init();
	}

	@Override
	@Before
	public void beforeTestMethod() throws Exception {
		if (isTraced(LogSeverity.INFO)) {
			int ratio = (this.dirtyPartitionsRatio == 0) ? 0 : (100 / this.dirtyPartitionsRatio);
			trace(LogSeverity.INFO, "Executing test with dirty partitions ratio on " + ratio + "%"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		init();

		this.index = getDefaultIndexStore();

		// for ( int i = 0; i < partitionScope.length; i++ ) {
		// partitionScope[i] = myConn.getSession( ).getMoin( ).createPri(
		// partitionScope[i].toString( ) );
		// }

	}

	@Override
	@After
	public void afterTestMethod() throws Exception {
		clear();
	}

	/*
	 * ================= Test Cases ===============
	 */

	/*-
	 * (select mm.name(STRING), mm.attrInt1(INTEGER) 
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm) as result
	 */
	protected boolean basic_get_attributes_ast() throws Exception {

		int ModelClassNr = 1;
		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass" + ModelClassNr)), false); //$NON-NLS-1$ //$NON-NLS-2$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name", "attrInt" + ModelClassNr }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

		Query query = new Query(selectEntries, fromEntries);
		ResultSet resultSet = this.executeQuery(query);

		return this.basic_get_attributes_check(resultSet);
	}

	protected boolean basic_get_attributes() throws Exception {

		String query = "select mm.name, mm.attrInt1 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm"; //$NON-NLS-1$ //$NON-NLS-2$
		ResultSet resultSet = this.executeQuery(query);

		return this.basic_get_attributes_check(resultSet);
	}

	protected boolean basic_get_attributes_with_removal() throws Exception {

		String query = "select mm.name, mm.attrInt1 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm"; //$NON-NLS-1$ //$NON-NLS-2$
		ResultSet resultSet = this.executeQuery(query);

		boolean successful = this.basic_get_attributes_check(resultSet);

		// remove element
		if (successful) {
			int origSize = resultSet.getSize();
			int newSize = resultSet.removeRow(origSize - 1);
			successful = (newSize == resultSet.getSize()) && (newSize == origSize - 1);
		}

		return successful;
	}

	protected boolean basic_get_attributes_with_comparison() throws Exception {

		String query = "select mm.name, mm.attrInt1 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm2 where mm = mm2"; //$NON-NLS-1$
		ResultSet resultSet = this.executeQuery(query);

		return this.basic_get_attributes_check(resultSet);
	}

	protected boolean basic_get_attributes_with_reflect_element() throws Exception {

		String partitions = ""; //$NON-NLS-1$
		if (partitionScope != null && partitionScope.length > 0) {
			partitions = "[" + partitionScope[0] + "]"; //$NON-NLS-1$ //$NON-NLS-2$
			for (int i = 1; i < partitionScope.length; i++) {
				partitions += ", [" + partitionScope[i] + "]"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		String query = "select mm.name, mm.attrInt1 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(EcorePackage.eINSTANCE.getEObject()) + "] as refEl in resources{" + partitions + "} where mm = refEl"; //$NON-NLS-1$ //$NON-NLS-2$
		ResultSet resultSet = this.executeQuery(query);

		return this.basic_get_attributes_check(resultSet);
	}

	private boolean basic_get_attributes_check(ResultSet resultSet) throws Exception {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, false), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, true), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
		}

		if (resultSet.isEmpty()) {
			return false;
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	protected boolean basic_get_attributes_limited() throws Exception {

		String query = "select mm.name, mm.attrInt1 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm"; //$NON-NLS-1$ //$NON-NLS-2$
		ResultSet resultSet = this.executeQuery(query, 1);

		return this.basic_get_attributes_limited_check(resultSet);
	}

	private boolean basic_get_attributes_limited_check(ResultSet resultSet) throws Exception {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>(1);
		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, false), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, true), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
		}

		if (resultSet.getSize() != 1) {
			return false;
		}

		return this.verifyResultSetLimited(resultSet, intendedResultSet);
	}

	/*-
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm) as result
	 */
	protected boolean basic_get_mris_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), false); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

		SelectAlias selectMe = new SelectAlias("mm"); //$NON-NLS-1$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMe };

		Query query = new Query(selectEntries, fromEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.basic_get_mris_check(resultSet);
	}

	protected boolean basic_get_mris() throws Exception {

		String query = "select mm from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm"; //$NON-NLS-1$ //$NON-NLS-2$
		ResultSet resultSet = this.executeQuery(query);
		return this.basic_get_mris_check(resultSet);
	}

	private boolean basic_get_mris_check(ResultSet resultSet) {

		int intendedSize = instSize * 2;

		// we can only verify that the size of the result is correct (since MRIs
		// permanently change)
		return resultSet.getSize() == intendedSize;
	}

	/*-
	 * (select mm.name(STRING), mm.attrInt1(INTEGER)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm
	 *  where for mm((not(name like 'ModelClass*Obj*')) and
	 *               (name like 'TestS?b*'))) as result
	 */
	protected boolean like_and_not_like_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), false); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name", "attrInt1" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

		WhereString whereName = new WhereString("name", Operation.LIKE, "Model\\Class*Obj*\\"); //$NON-NLS-1$ //$NON-NLS-2$
		WhereNot whereNot = new WhereNot(whereName);
		WhereString whereName2 = new WhereString("name", Operation.LIKE, "ModelS?b*"); //$NON-NLS-1$ //$NON-NLS-2$
		WhereClause[] whereClauses = { whereNot, whereName2 };
		WhereAnd whereAnd = new WhereAnd(whereClauses);
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("mm", whereAnd); //$NON-NLS-1$
		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.like_and_not_like_check(resultSet);
	}

	protected boolean like_and_not_like() throws Exception {

		String query = "select mm.name, mm.attrInt1 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where for mm((name not like 'ModelClass*Obj*') and (name like 'ModelS?b*'))"; //$NON-NLS-1$
		ResultSet resultSet = this.executeQuery(query);

		return this.like_and_not_like_check(resultSet);
	}

	protected boolean like_and_not_like_2() throws Exception {

		String query = "select mm.name, mm.attrInt1 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where mm.name not like 'ModelClass*Obj*'  where mm.name like 'ModelS?b*'"; //$NON-NLS-1$
		ResultSet resultSet = this.executeQuery(query);

		return this.like_and_not_like_check(resultSet);
	}

	private boolean like_and_not_like_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, true), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	protected boolean where_not_like() throws Exception {

		String query = "select mm.name, mm.attrInt1 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where for mm(not(name like 'ModelClass*Obj*'))"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.where_not_check(resultSet, true);
	}

	protected boolean where_not_like_2() throws Exception {

		String query = "select mm.name, mm.attrInt1 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where mm.name not like 'ModelClass*Obj*'"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.where_not_check(resultSet, true);
	}

	protected boolean where_not_like_and_not_null_check() throws Exception {

		String query = "select mm.name, mm.attrInt1 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where mm.reference1x2 <> null " + "where mm.name not like 'ModelClass*Obj*'"; //$NON-NLS-1$ //$NON-NLS-2$

		ResultSet resultSet = this.executeQuery(query);

		return this.where_not_check(resultSet, false);
	}

	private boolean where_not_check(ResultSet resultSet, boolean expectSubtypes) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, false), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
			if (expectSubtypes)
				intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, true), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl0.name(STRING), cl1.name(STRING), cl2.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0} as cl0,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as cl1,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass2} as cl2
	 *  where cl0.reference0x1[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
	 *  where cl1.reference1x2[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
	 *  where for cl2(name(STRING) ='ModelClass2Inst0')) as result
	 */
	protected boolean double_assoc_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("cl0", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()), true); //$NON-NLS-1$
		FromType fromRelationShip2 = new FromType("cl1", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), true); //$NON-NLS-1$
		FromType fromRelationShip3 = new FromType("cl2", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()), true); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2, fromRelationShip3 };

		SelectAttrs selectName1 = new SelectAttrs("cl0", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAttrs selectName2 = new SelectAttrs("cl1", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAttrs selectName3 = new SelectAttrs("cl2", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1, selectName2, selectName3 };

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass2Inst0"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl2", whereName); //$NON-NLS-1$

		WhereRelationReference whereAssoc1 = new WhereRelationReference("cl0", "reference0x1", "cl1"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereRelationReference whereAssoc2 = new WhereRelationReference("cl1", "reference1x2", "cl2"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry, whereAssoc1, whereAssoc2 };

		Query query2a = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query2a);

		return this.double_assoc_check(resultSet);
	}

	protected boolean double_assoc() throws Exception {

		String query = "select cl0.name, cl1.name, cl2.name " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + " [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2 " + "where cl0.reference0x1 = cl1 " + "where cl1.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where for cl2(name = 'ModelClass2Inst0')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.double_assoc_check(resultSet);
	}

	protected boolean double_assoc_variant() throws Exception {

		String query = "select cl0.name, cl1.name, cl2.name " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + " ["  //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2_2 " + "where cl0.reference0x1 = cl1 " + "where cl1.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where cl2 = cl2_2 " + "where for cl2_2(name = 'ModelClass2Inst0')"; //$NON-NLS-1$ //$NON-NLS-2$

		ResultSet resultSet = this.executeQuery(query);

		return this.double_assoc_check(resultSet);
	}

	protected boolean double_assoc_2() throws Exception {

		String query = "select cl0.name, cl1.name, cl2.name " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + " [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2 " + "where cl0.reference0x1 = cl1 " + "where cl1.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where cl2.name = 'ModelClass2Inst0'"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.double_assoc_check(resultSet);
	}

	protected boolean double_assoc_3() throws Exception {

		String query = "select cl0.name, cl1.name, cl2.name " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + " [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2 " + "where cl0.reference0x1 = cl1 " + "where cl1.reference1x2 = cl2 "  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
				+ "where cl2.name = 'ModelClass2Inst0'"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.double_assoc_check(resultSet);
	}

	protected boolean double_assoc_with_comparison() throws Exception {

		String query = "select cl0.name, cl1.name, cl2.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) //$NON-NLS-1$
				+ "] as cl1extra, [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2 " + "where cl0.reference0x1 = cl1 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where cl1.reference1x2 = cl2 " + "where cl1 = cl1extra " + "where cl0.reference0x1 = cl1extra " + "where cl1extra.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ "where for cl2(name = 'ModelClass2Inst0')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.double_assoc_check(resultSet);
	}

	protected boolean double_paired_assocs() throws Exception {

		String query = "select cl0.name, cl1.name, cl2.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + "[" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2 " + "where cl0.reference0x1 = cl1 " + "where cl1.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where cl0.reference0x1 = cl1 " + "where cl1.reference1x2 = cl2 " + "where for cl2(name = 'ModelClass2Inst0')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		ResultSet resultSet = this.executeQuery(query);

		return this.double_assoc_check(resultSet);
	}

	private boolean double_assoc_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, 0, false), ModelDataInstantiator.calculateClassName(1, 0, false),
				ModelDataInstantiator.calculateClassName(2, 0, false) });

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl0.attrString9(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0} as cl0
	 *  where for cl0(attrString9(STRING) = null)) as result
	 */
	protected boolean string_null_comparison_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("cl0", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()), true); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

		SelectAttrs selectName1 = new SelectAttrs("cl0", new String[] { "attrString9" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

		WhereString whereName = new WhereString("attrString9", Operation.EQUAL, null); //$NON-NLS-1$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl0", whereName); //$NON-NLS-1$
		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

		Query query2a = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query2a);

		return this.string_null_comparison_check(resultSet);
	}

	protected boolean string_null_comparison() throws Exception {

		String query = "select cl0.attrString9 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where for cl0(attrString9 = null)"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.string_null_comparison_check(resultSet);
	}

	protected boolean string_null_comparison_2() throws Exception {

		String query = "select cl0.attrString9 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0 "  //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
				+ "where cl0.attrString9 = null"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.string_null_comparison_check(resultSet);
	}

	private boolean string_null_comparison_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		if (attrSize < 10) {
			for (int i = 0; i < instSize; i++) {
				intendedResultSet.add(new Object[] { null });

				if (createObjValAttrs) {
					for (int j = 0; j < mmSize; j++) {
						intendedResultSet.add(new Object[] { null });
					}
				}
			}
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl0.attrString9(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0} as cl0
	 *  where for cl0(attrString9(STRING) = null)) as result
	 */
	protected boolean string_not_null_comparison_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("cl0", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()), true); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

		SelectAttrs selectName1 = new SelectAttrs("cl0", new String[] { "attrString9" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

		WhereString whereName = new WhereString("attrString9", Operation.NOTEQUAL, null); //$NON-NLS-1$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl0", whereName); //$NON-NLS-1$
		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

		Query query2a = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query2a);

		return this.string_not_null_comparison_check(resultSet);
	}

	protected boolean string_not_null_comparison() throws Exception {

		String query = "select cl0.attrString9 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where for cl0(attrString9 <> null)"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.string_not_null_comparison_check(resultSet);
	}

	protected boolean string_not_null_comparison_2() throws Exception {

		String query = "select cl0.attrString9 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where cl0.attrString9 <> null"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.string_not_null_comparison_check(resultSet);
	}

	private boolean string_not_null_comparison_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select[PF] cl0.attrString5(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0,
	          sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass0} as cl0
	    where for cl0(attrString5(STRING) ='')) as result
	 */
	protected boolean empty_string_comparison_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("cl0", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()), true); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

		SelectAttrs selectName1 = new SelectAttrs("cl0", new String[] { "attrString5" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

		WhereString whereName = new WhereString("attrString5", Operation.EQUAL, ""); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl0", whereName); //$NON-NLS-1$
		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

		Query query2a = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query2a);

		return this.empty_string_comparison_check(resultSet);
	}

	protected boolean empty_string_comparison() throws Exception {

		String query = "select cl0.attrString5 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where for cl0(attrString5 = '')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.empty_string_comparison_check(resultSet);
	}

	protected boolean empty_string_comparison_2() throws Exception {

		String query = "select cl0.attrString5 " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where cl0.attrString5 = ''"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.empty_string_comparison_check(resultSet);
	}

	private boolean empty_string_comparison_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		if (attrSize > 4 && !(createDirtyData && (myTestClient.getOrCreateResourceStable(ModelDataInstantiator.getInstPartName(0)).isModified()))) {
			for (int i = 0; i < instSize; i++) {
				intendedResultSet.add(new Object[] { "" }); //$NON-NLS-1$
			}
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl1.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as cl1
	 *  where cl1.reference1x2[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] in 
	 *    (select cl2
	 *     from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass2} as cl2
	 *     where for cl2(name(STRING) ='ModelClass2Inst0')) as nested) as result
	 */
	protected boolean nested_query_with_reference_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("cl1", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), true); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

		SelectAttrs selectName1 = new SelectAttrs("cl1", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

		SelectAlias selectCl2 = new SelectAlias("cl2"); //$NON-NLS-1$
		SelectEntry[] nestedSelect = new SelectEntry[] { selectCl2 };

		FromType fromRelationShip2 = new FromType("cl2", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()), true); //$NON-NLS-1$
		FromEntry[] nestedFromEntries = new FromEntry[] { fromRelationShip2 };

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass2Inst0"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl2", whereName); //$NON-NLS-1$
		WhereEntry[] whereEntries1 = new WhereEntry[] { localWhereEntry };

		Query nestedQuery = new Query(nestedSelect, nestedFromEntries, whereEntries1);

		WhereNestedReference whereReference = new WhereNestedReference("cl1", "reference1x2", nestedQuery); //$NON-NLS-1$ //$NON-NLS-2$
		WhereEntry[] whereEntries2 = new WhereEntry[] { whereReference };

		Query query2 = new Query(selectEntries, fromEntries, whereEntries2);

		ResultSet resultSet = this.executeQuery(query2);

		return this.nested_query_with_reference_check(resultSet);
	}

	protected boolean nested_query_with_reference() throws Exception {

		String query = "select cl1.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as cl1 " //$NON-NLS-1$ //$NON-NLS-2$
				+ "where cl1.reference1x2 in " + "(select cl2 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] withoutsubtypes as cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ " where for cl2(name = 'ModelClass2Inst0'))"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.nested_query_with_reference_check(resultSet);
	}

	protected boolean nested_query_with_reference_variant() throws Exception {

		String query = "select cl1.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as cl1, " + "[" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1_1 " + "where cl1 = cl1_1 " + "where cl1.reference1x2 in " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "(select cl2 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] withoutsubtypes as cl2 " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where for cl2(name = 'ModelClass2Inst0'))"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.nested_query_with_reference_check(resultSet);
	}

	protected boolean nested_query_with_reference_2() throws Exception {

		String query = "select cl1.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as cl1 " //$NON-NLS-1$ //$NON-NLS-2$
				+ "where cl1.reference1x2 in " + "(select cl2 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] withoutsubtypes as cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ " where cl2.name = 'ModelClass2Inst0')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.nested_query_with_reference_check(resultSet);
	}

	private boolean nested_query_with_reference_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, 0, false) });

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	protected boolean nested_query_with_reference_in_other_direction() throws Exception {

		throw new UnsupportedOperationException();
		//
		// String query = "select cl2.name from [" + EcoreUtil.getURI(
		// GeneratedmetamodelPackage.eINSTANCE.getModelClass2( ) ) +
		// "] withoutsubtypes as cl2 " + "where cl2.assoc1x2EndA in " +
		// "(select cl1 from [" + EcoreUtil.getURI(
		// GeneratedmetamodelPackage.eINSTANCE.getModelClass1( ) )
		// + "] withoutsubtypes as cl1 where cl1.name = 'ModelClass1Inst0')";
		//
		// MQLResultSet resultSet = this.executeQuery( query );
		//
		// return this.nested_query_with_reference_in_other_direction_check(
		// resultSet );
	}

	// private boolean nested_query_with_reference_in_other_direction_check(
	// MQLResultSet resultSet ) {
	//
	// List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
	// intendedResultSet.add( new Object[] {
	// ModelDataInstantiator.calculateClassName( 2, 0, false ) } );
	//
	// return this.verifyResultSet( resultSet, intendedResultSet );
	// }

	protected boolean nested_query_with_reference_and_not() throws Exception {

		String query = "select cl1.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1 " //$NON-NLS-1$ //$NON-NLS-2$
				+ "where cl1.name not like 'ModelClass*Obj*'  where cl1.name like 'ModelS?b*' where cl1.reference1x2 not in " + "(select cl2 from [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2)"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.nested_query_with_reference_and_not_check(resultSet);
	}

	protected boolean nested_query_with_reference_and_not_2() throws Exception {

		String query = "select cl1.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1 " //$NON-NLS-1$ //$NON-NLS-2$
				+ "where cl1.name not like 'ModelClass*Obj*' where cl1.name like 'ModelS?b*' where cl1.reference1x2 = null"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.nested_query_with_reference_and_not_check(resultSet);
	}

	private boolean nested_query_with_reference_and_not_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();

		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, true) });
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl0.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass0} as cl0
	 *  where cl0.reference0x1[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] in 
	 *     (select cl1
	 *      from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as cl1
	 *      where for cl1(name(STRING) ='ModelClass1Inst0')) as nested) as result
	 */
	protected boolean nested_query_with_assoc_end_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("cl0", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()), false); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

		SelectAttrs selectName1 = new SelectAttrs("cl0", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

		SelectAlias selectCl2 = new SelectAlias("cl1"); //$NON-NLS-1$
		SelectEntry[] nestedSelect = new SelectEntry[] { selectCl2 };

		FromType fromRelationShip2 = new FromType("cl1", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), true); //$NON-NLS-1$
		FromEntry[] nestedFromEntries = new FromEntry[] { fromRelationShip2 };

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass1Inst0"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl1", whereName); //$NON-NLS-1$
		WhereEntry[] whereEntries1 = new WhereEntry[] { localWhereEntry };

		Query nestedQuery = new Query(nestedSelect, nestedFromEntries, whereEntries1);
		WhereNestedReference whereAssoc = new WhereNestedReference("cl0", "reference0x1", nestedQuery); //$NON-NLS-1$ //$NON-NLS-2$
		WhereEntry[] whereEntries2 = new WhereEntry[] { whereAssoc };

		Query query2 = new Query(selectEntries, fromEntries, whereEntries2);

		ResultSet resultSet = this.executeQuery(query2);

		return this.nested_query_with_assoc_end_check(resultSet);
	}

	protected boolean nested_query_with_assoc_end() throws Exception {

		String query = "select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0 " + "where cl0.reference0x1 in " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "(select cl1 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1 " + " where for cl1(name ='ModelClass1Inst0'))"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		ResultSet resultSet = this.executeQuery(query);

		return this.nested_query_with_assoc_end_check(resultSet);
	}

	protected boolean nested_query_with_assoc_end_2() throws Exception {

		String query = "select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0 " + "where cl0.reference0x1 in " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "(select cl1 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1 " + " where cl1.name = 'ModelClass1Inst0')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		ResultSet resultSet = this.executeQuery(query);

		return this.nested_query_with_assoc_end_check(resultSet);
	}

	private boolean nested_query_with_assoc_end_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, 0, false) });

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl0.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0} as cl0,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as cl1,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass2} as cl2,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass3} as cl3,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass4} as cl4,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass5} as cl5,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass6} as cl6,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass7} as cl7,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass8} as cl8,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass9} as cl9
	 *  where cl0.reference0x1[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
	 *  where cl1.reference1x2[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
	 *  where cl2.reference2x3[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x3 ] = cl3
	 *  where cl3.reference3x4[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x4 ] = cl4
	 *  where cl4.reference4x5[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc4x5 ] = cl5
	 *  where cl5.reference5x6[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc5x6 ] = cl6
	 *  where cl6.reference6x7[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc6x7 ] = cl7
	 *  where cl7.reference7x8[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc7x8 ] = cl8
	 *  where cl8.reference8x9[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc8x9 ] = cl9
	 *  where for cl9(name(STRING) ='ModelClass9Inst1')) as result
	 */
	protected boolean complex_assoc_linear_ast() throws Exception {

		FromEntry[] fromEntries = new FromEntry[mmSize];

		for (int i = 0; i < mmSize; i++) {
			fromEntries[i] = new FromType("cl" + i, EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass" + i)), true); //$NON-NLS-1$ //$NON-NLS-2$
		}

		SelectAttrs selectName1 = new SelectAttrs("cl0", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass" + (mmSize - 1) + "Inst1"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl" + (mmSize - 1), whereName); //$NON-NLS-1$

		WhereEntry[] whereEntries = new WhereEntry[mmSize];

		for (int i = 0; i < (mmSize - 1); i++) {
			whereEntries[i] = new WhereRelationReference("cl" + i, "reference" + i + "x" + (i + 1), "cl" + (i + 1)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		whereEntries[mmSize - 1] = localWhereEntry;

		Query query5 = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query5);

		return this.complex_assoc_linear_check(resultSet);
	}

	protected boolean complex_assoc_linear() throws Exception {

		String query = "select cl0.name " + "from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + "     [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + "     [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2, " + "     [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3()) + "] as cl3, " + "     [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass4()) + "] as cl4, " + "     [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass5()) + "] as cl5, " + "     [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass6()) + "] as cl6, " + "     [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass7()) + "] as cl7, " + "     [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass8()) + "] as cl8, " + "     [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass9()) + "] as cl9 " + "where cl0.reference0x1 = cl1 " + "where cl1.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "where cl2.reference2x3 = cl3 " + "where cl3.reference3x4 = cl4 " + "where cl4.reference4x5 = cl5 " + "where cl5.reference5x6 = cl6 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ "where cl6.reference6x7 = cl7 " + "where cl7.reference7x8 = cl8 " + "where cl8.reference8x9 = cl9 " + "where for cl9(name ='ModelClass9Inst1')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		ResultSet resultSet = this.executeQuery(query);

		return this.complex_assoc_linear_check(resultSet);
	}

	private boolean complex_assoc_linear_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, 1, false) });
		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl0.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0} as cl0,
	 {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as cl1,
	 {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass2} as cl2,
	 {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass3} as cl3,
	 {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass4} as cl4,
	 {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass5} as cl5,
	 {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass6} as cl6,
	 {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass7} as cl7,
	 {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass8} as cl8,
	 {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass9} as cl9
	 where cl0.reference0x1[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
	 where cl1.reference1x2[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
	 where cl2.reference2x3[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x3 ] = cl3
	 where cl3.reference3x4[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x4 ] = cl4
	 where cl5.reference5x6[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc5x6 ] = cl6
	 where cl6.reference6x7[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc6x7 ] = cl7
	 where cl7.reference7x8[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc7x8 ] = cl8
	 where cl8.reference8x9[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc8x9 ] = cl9
	 where cl0.reference0x5[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x5 ] = cl5
	 where cl1.reference1x6[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x6 ] = cl6
	 where cl2.reference2x7[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x7 ] = cl7
	 where cl3.reference3x8[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x8 ] = cl8
	 where cl4.reference4x9[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc4x9 ] = cl9
	 where for cl9(name like 'ModelClass9Inst2*')) as result
	 */
	protected boolean complex_assoc_grid_ast() throws Exception {

		FromEntry[] fromEntries = new FromEntry[mmSize];

		for (int i = 0; i < mmSize; i++) {

			fromEntries[i] = new FromType("cl" + i, EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass" + i)), true); //$NON-NLS-1$ //$NON-NLS-2$
		}

		SelectAttrs selectName1 = new SelectAttrs("cl0", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

		WhereString whereName = new WhereString("name", Operation.LIKE, "ModelClass" + (mmSize - 1) + "Inst2*"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl" + (mmSize - 1), whereName); //$NON-NLS-1$

		WhereEntry[] whereEntries = new WhereEntry[(mmSize / 2 - 1) + mmSize];

		for (int i = 0; i < (mmSize / 2 - 1); i++) {
			whereEntries[i] = new WhereRelationReference("cl" + i, "reference" + i + "x" + (i + 1), "cl" + (i + 1)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		for (int i = mmSize / 2; i < (mmSize - 1); i++) {
			whereEntries[i - 1] = new WhereRelationReference("cl" + i, "reference" + i + "x" + (i + 1), "cl" + (i + 1)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		for (int i = 0; i < (mmSize / 2); i++) {
			whereEntries[i + (mmSize - 1) - 1] = new WhereRelationReference("cl" + i, "reference" + i + "x" + (i + (mmSize / 2)), "cl" + (i + (mmSize / 2))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		whereEntries[(mmSize / 2 - 1) + (mmSize - 1)] = localWhereEntry;

		Query query6 = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query6);

		return this.complex_grid_assoc_check(resultSet);
	}

	protected boolean complex_assoc_grid() throws Exception {

		String query = "select cl0.name " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + "  [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3()) + "] as cl3, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass4()) + "] as cl4, " + " ["  //$NON-NLS-1$//$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass5()) + "] as cl5, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass6()) + "] as cl6, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass7()) + "] as cl7, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass8()) + "] as cl8, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass9()) + "] as cl9 " + " where cl0.reference0x1 = cl1 " + " where cl1.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ " where cl2.reference2x3 = cl3 " + " where cl3.reference3x4 = cl4 " + " where cl5.reference5x6 = cl6 " + " where cl6.reference6x7 = cl7 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ " where cl7.reference7x8 = cl8 " + " where cl8.reference8x9 = cl9 " + " where cl0.reference0x5 = cl5 " + " where cl1.reference1x6 = cl6 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ " where cl2.reference2x7 = cl7 " + " where cl3.reference3x8 = cl8 " + " where cl4.reference4x9 = cl9 " + " where for cl9(name like 'ModelClass9Inst2*')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		ResultSet resultSet = this.executeQuery(query);

		return this.complex_grid_assoc_check(resultSet);
	}

	protected boolean complex_assoc_grid_with_attr_comparisons() throws Exception {

		String query = "select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0,  [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3()) + "] as cl3, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass4()) + "] as cl4, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass5()) + "] as cl5, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass6()) + "] as cl6, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass7()) + "] as cl7, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass8()) + "] as cl8, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass9()) + "] as cl9 " + " where cl0.reference0x1 = cl1 where cl0.attrInt0 < cl1.attrInt0 " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where cl1.reference1x2 = cl2 where cl1.attrDouble0 < cl2.attrDouble0 " + " where cl2.reference2x3 = cl3 where cl2.attrInt0 < cl3.attrInt0 " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where cl3.reference3x4 = cl4 where cl3.attrDouble0 <= cl4.attrDouble0 " + " where cl5.reference5x6 = cl6 where cl5.attrInt0 <= cl6.attrInt0 " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where cl6.reference6x7 = cl7 where cl7.attrDouble0 > cl6.attrDouble0 " + " where cl7.reference7x8 = cl8 where cl8.attrInt0 > cl7.attrInt0 " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where cl8.reference8x9 = cl9 where cl9.attrDouble0 >= cl8.attrDouble0 " + " where cl0.reference0x5 = cl5 where cl5.attrInt0 >= cl0.attrInt0 " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where cl1.reference1x6 = cl6 where cl1.attrDouble0 <> cl6.attrDouble0 " + " where cl2.reference2x7 = cl7 where cl2.attrInt0 <> cl7.attrInt0 " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where cl3.reference3x8 = cl8 where cl3.attrDouble0 < cl8.attrDouble0 " + " where cl4.reference4x9 = cl9 where cl4.attrInt0 < cl9.attrInt0 " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where for cl9(name like 'ModelClass9Inst2*')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.complex_grid_assoc_check(resultSet);
	}

	protected boolean complex_assoc_grid_with_structureTypes() throws Exception {

		String query = "select cl0.name " + "  from [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0())
				+ "] as cl0, " //$NON-NLS-1$
				+ "  [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1())
				+ "] as cl1, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp())
				+ "] as st1, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2())
				+ "] as cl2, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp())
				+ "] as st2, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructInStructTp())
				+ "] as st22, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3())
				+ "] as cl3, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp())
				+ "] as st3, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass4())
				+ "] as cl4, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp())
				+ "] as st4, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass5())
				+ "] as cl5, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp())
				+ "] as st5, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructInStructTp())
				+ "] as st52, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass6())
				+ "] as cl6, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp())
				+ "] as st6, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass7())
				+ "] as cl7, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp())
				+ "] as st7, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass8())
				+ "] as cl8, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp())
				+ "] as st8, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructInStructTp())
				+ "] as st82, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass9())
				+ "] as cl9, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp())
				+ "] as st9 " //$NON-NLS-1$
				+ " where cl0.reference0x1 = cl1 " //$NON-NLS-1$
				+ " where cl1.reference1x2 = cl2 " //$NON-NLS-1$
				+ " where cl2.reference2x3 = cl3 " //$NON-NLS-1$
				+ " where cl3.reference3x4 = cl4 " //$NON-NLS-1$
				+ " where cl5.reference5x6 = cl6 " //$NON-NLS-1$
				+ " where cl6.reference6x7 = cl7 " //$NON-NLS-1$
				+ " where cl7.reference7x8 = cl8 " //$NON-NLS-1$
				+ " where cl8.reference8x9 = cl9 " //$NON-NLS-1$
				+ " where cl0.reference0x5 = cl5 " //$NON-NLS-1$
				+ " where cl1.reference1x6 = cl6 " //$NON-NLS-1$
				+ " where cl2.reference2x7 = cl7 " //$NON-NLS-1$
				+ " where cl3.reference3x8 = cl8 " //$NON-NLS-1$
				+ " where cl4.reference4x9 = cl9 " //$NON-NLS-1$
				+ " where cl9.name like 'ModelClass9Inst2*'" //$NON-NLS-1$
				+ " where cl1.attrStruct = st1 where cl2.attrStruct = st2 where cl3.attrStruct = st3 where cl4.attrStruct = st4 where cl5.attrStruct = st5 where cl6.attrStruct = st6 where cl7.attrStruct = st7 where cl8.attrStruct = st8 where cl9.attrStruct = st9" //$NON-NLS-1$
				+ " where for st1(Field2 like 'ModelClass1Inst?structValue' or Field2 like 'TestSubClass1Inst?structValue') " //$NON-NLS-1$
				+ " where for st2(Field2 like 'ModelClass2Inst?structValue' or Field2 like 'TestSubClass2Inst?structValue') " //$NON-NLS-1$
				+ " where for st3(Field2 like 'ModelClass3Inst?structValue' or Field2 like 'TestSubClass3Inst?structValue') " //$NON-NLS-1$
				+ " where for st4(Field2 like 'ModelClass4Inst?structValue' or Field2 like 'TestSubClass4Inst?structValue') " //$NON-NLS-1$
				+ " where for st5(Field2 like 'ModelClass5Inst?structValue' or Field2 like 'TestSubClass5Inst?structValue') " //$NON-NLS-1$
				+ " where for st6(Field2 like 'ModelClass6Inst?structValue' or Field2 like 'TestSubClass6Inst?structValue') " //$NON-NLS-1$
				+ " where for st7(Field2 like 'ModelClass7Inst?structValue' or Field2 like 'TestSubClass7Inst?structValue') " //$NON-NLS-1$
				+ " where for st8(Field2 like 'ModelClass8Inst?structValue' or Field2 like 'TestSubClass8Inst?structValue') " //$NON-NLS-1$
				+ " where for st9(Field2 like 'ModelClass9Inst?structValue' or Field2 like 'TestSubClass9Inst?structValue') " //$NON-NLS-1$
				+ " where st2.Field3 = st22 where st5.Field3 = st52 where st8.Field3 = st82"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.complex_grid_assoc_check(resultSet);
	}

	private boolean complex_grid_assoc_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, 2, false) });
		if (instSize > 20) {
			for (int i = 20; i < Math.min(instSize, 30); i++) {
				intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, i, false) });
			}
			if (instSize > 200) {
				for (int j = 200; j < Math.min(instSize, 300); j++) {
					intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, j, false) + j });
				}
			}
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	protected boolean complex_grid_assoc_with_string_comparisons() throws Exception {

		String query = "select cl0.name " + "  from [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0())
				+ "] as cl0, " //$NON-NLS-1$
				+ "  [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1())
				+ "] as cl1, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2())
				+ "] as cl2, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3())
				+ "] as cl3, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass4())
				+ "] as cl4, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass5())
				+ "] as cl5, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass6())
				+ "] as cl6, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass7())
				+ "] as cl7, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass8())
				+ "] as cl8, " //$NON-NLS-1$
				+ " [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass9())
				+ "] as cl9 " //$NON-NLS-1$
				+ " where cl0.reference0x1 = cl1 " //$NON-NLS-1$
				+ " where cl1.reference1x2 = cl2 " //$NON-NLS-1$
				+ " where cl2.reference2x3 = cl3 " //$NON-NLS-1$
				+ " where cl3.reference3x4 = cl4 " //$NON-NLS-1$
				+ " where cl5.reference5x6 = cl6 " //$NON-NLS-1$
				+ " where cl6.reference6x7 = cl7 " //$NON-NLS-1$
				+ " where cl7.reference7x8 = cl8 " //$NON-NLS-1$
				+ " where cl8.reference8x9 = cl9 " //$NON-NLS-1$
				+ " where cl0.reference0x5 = cl5 " //$NON-NLS-1$
				+ " where cl1.reference1x6 = cl6 " //$NON-NLS-1$
				+ " where cl2.reference2x7 = cl7 " //$NON-NLS-1$
				+ " where cl3.reference3x8 = cl8 " //$NON-NLS-1$
				+ " where cl4.reference4x9 = cl9 " //$NON-NLS-1$
				+ " where for cl9(name like 'ModelClass9Inst2*') " //$NON-NLS-1$
				+ " where cl8.name like 'ModelClass8Inst2*' where cl7.name like 'ModelClass7Inst2*' where cl6.name like 'ModelClass6Inst2*' where cl5.name like 'ModelClass5Inst2*' where cl4.name like 'ModelClass4Inst2*' " //$NON-NLS-1$
				+ " where cl3.name like 'ModelClass3Inst2*' where cl2.name like 'ModelClass2Inst2*' where cl1.name like 'ModelClass1Inst2*'"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.complex_grid_assoc_check(resultSet);
	}

	/*-
	 * (select cl0.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0} as cl0,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as cl1,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass2,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass2} as cl2
	 *        in E{PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFEAEC2A82CFC9E42A61455809B3F7DFF69,
	 *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFE651E90B462404D180F87CACB737499B8,
	 *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFEA3115CEAD9794BD70FF3D4DC0A43C632,
	 *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFF57F135EF447F413C274EC29C31525E1F,
	 *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFE6C31DC76157040B70FA89D899733A881,
	 *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFE9D663D97E5844E3225B793D39046DD39,
	 *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFFD7DABB0124ED4E6F14CBE21344F86227,
	 *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFF54EFA3ADD44B46493941C397670828FD,
	 *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFE1526C92E5B314BF7039E9BAE6B33627D,
	 *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFF302632358AA049C134F5BD274CD575CA},
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass3} as cl3,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass4} as cl4,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass5} as cl5,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass6} as cl6,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass7} as cl7,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass8} as cl8,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass9} as cl9
	 *  where cl0.reference0x1[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
	 *  where cl1.reference1x2[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
	 *  where cl2.reference2x3[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x3 ] = cl3
	 *  where cl3.reference3x4[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x4 ] = cl4
	 *  where cl5.reference5x6[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc5x6 ] = cl6
	 *  where cl6.reference6x7[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc6x7 ] = cl7
	 *  where cl7.reference7x8[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc7x8 ] = cl8
	 *  where cl8.reference8x9[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc8x9 ] = cl9
	 *  where cl0.reference0x5[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x5 ] = cl5
	 *  where cl1.reference1x6[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x6 ] = cl6
	 *  where cl2.reference2x7[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x7 ] = cl7
	 *  where cl3.reference3x8[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x8 ] = cl8
	 *  where cl4.reference4x9[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc4x9 ] = cl9
	 *  where for cl9(name like 'ModelClass9Inst2*')) as result
	 */
	protected boolean complex_grid_assoc_with_fixed_set_ast() throws Exception {

		// we first calculate a pre-query to obtain all MRIs of type ModelClass2
		int fixedIndex = 2;

		FromEntry intermediateFromEntry = new FromType("intermediateAlias", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass" + fixedIndex)), true); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAlias intermediateSelectEntry = new SelectAlias("intermediateAlias"); //$NON-NLS-1$

		WhereString whereObjectValued = new WhereString("name", Operation.LIKE, "ModelClass*Obj*"); //$NON-NLS-1$ //$NON-NLS-2$
		WhereNot whereNotObjectValued = new WhereNot(whereObjectValued);
		LocalWhereEntry whereNotObjectValuedEntry = new LocalWhereEntry("intermediateAlias", whereNotObjectValued); //$NON-NLS-1$

		Query intermediateQuery = new Query(new SelectEntry[] { intermediateSelectEntry }, new FromEntry[] { intermediateFromEntry },
				new WhereEntry[] { whereNotObjectValuedEntry });
		this.makeDirty();
		ResultSet intermediateResultSet = this.getMQLProcessor().execute(intermediateQuery, this.getQueryContext());

		if (isTraced(LogSeverity.DEBUG)) {
			trace(LogSeverity.DEBUG, "-----> Intermediate Result Set for fixed set test case: "); //$NON-NLS-1$
			String intermediateResultStr = intermediateResultSet.toString();
			trace(LogSeverity.DEBUG, intermediateResultStr);
		}

		resetTestEnvironment();

		URI[] intermediateElements = new URI[intermediateResultSet.getSize()];
		for (int i = 0; i < intermediateElements.length; i++) {
			intermediateElements[i] = intermediateResultSet.getUri(i, "intermediateAlias"); //$NON-NLS-1$
		}

		FromEntry[] fromEntries = new FromEntry[mmSize];

		for (int i = 0; i < mmSize; i++) {
			if (i != fixedIndex) {
				fromEntries[i] = new FromType("cl" + i, EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass" + i)), true); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				fromEntries[i] = new FromFixedSet("cl" + i, EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass" + i)), intermediateElements); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		SelectAttrs selectName1 = new SelectAttrs("cl0", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

		WhereString whereName = new WhereString("name", Operation.LIKE, "ModelClass" + (mmSize - 1) + "Inst2*"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl" + (mmSize - 1), whereName); //$NON-NLS-1$

		WhereEntry[] whereEntries = new WhereEntry[(mmSize / 2 - 1) + mmSize];

		for (int i = 0; i < (mmSize / 2 - 1); i++) {
			whereEntries[i] = new WhereRelationReference("cl" + i, "reference" + i + "x" + (i + 1), "cl" + (i + 1)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		for (int i = mmSize / 2; i < (mmSize - 1); i++) {
			whereEntries[i - 1] = new WhereRelationReference("cl" + i, "reference" + i + "x" + (i + 1), "cl" + (i + 1)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		for (int i = 0; i < (mmSize / 2); i++) {
			whereEntries[i + (mmSize - 1) - 1] = new WhereRelationReference("cl" + i, "reference" + i + "x" + (i + (mmSize / 2)), "cl" + (i + (mmSize / 2))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		whereEntries[(mmSize / 2 - 1) + (mmSize - 1)] = localWhereEntry;

		Query query7 = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query7);

		return this.complex_grid_assoc_with_fixed_set_check(resultSet);
	}

	protected boolean complex_grid_assoc_with_fixed_set() throws Exception {

		// we first calculate a pre-query to obtain all MRIs of type ModelClass2
		int fixedIndex = 2;
		FromEntry intermediateFromEntry = new FromType("intermediateAlias", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass" + fixedIndex)), true); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAlias intermediateSelectEntry = new SelectAlias("intermediateAlias"); //$NON-NLS-1$

		WhereString whereObjectValued = new WhereString("name", Operation.LIKE, "ModelClass*Obj*"); //$NON-NLS-1$ //$NON-NLS-2$
		WhereNot whereNotObjectValued = new WhereNot(whereObjectValued);
		LocalWhereEntry whereNotObjectValuedEntry = new LocalWhereEntry("intermediateAlias", whereNotObjectValued); //$NON-NLS-1$

		Query intermediateQuery = new Query(new SelectEntry[] { intermediateSelectEntry }, new FromEntry[] { intermediateFromEntry },
				new WhereEntry[] { whereNotObjectValuedEntry });
		this.makeDirty();

		ResultSet intermediateResultSet = this.getMQLProcessor().execute(intermediateQuery, this.getQueryContext());

		if (isTraced(LogSeverity.DEBUG)) {
			trace(LogSeverity.DEBUG, "-----> Intermediate Result Set for fixed set test case: "); //$NON-NLS-1$
			String intermediateResultStr = intermediateResultSet.toString();
			trace(LogSeverity.DEBUG, intermediateResultStr);
		}

		resetTestEnvironment();

		String elements = ""; //$NON-NLS-1$
		for (int i = 0; i < intermediateResultSet.getSize(); i++) {
			elements = elements + "[" + intermediateResultSet.getUri(i, "intermediateAlias") + "] ,"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		// remove last comma
		elements = elements.substring(0, elements.length() - 2);

		String query = "select cl0.name " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + "  [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2 in elements { " + elements + " }, " + " ["  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3()) + "] as cl3, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass4()) + "] as cl4, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass5()) + "] as cl5, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass6()) + "] as cl6, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass7()) + "] as cl7, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass8()) + "] as cl8, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass9()) + "] as cl9 " + " where cl0.reference0x1 = cl1 " + " where cl1.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ " where cl2.reference2x3 = cl3 " + " where cl3.reference3x4 = cl4 " + " where cl5.reference5x6 = cl6 " + " where cl6.reference6x7 = cl7 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ " where cl7.reference7x8 = cl8 " + " where cl8.reference8x9 = cl9 " + " where cl0.reference0x5 = cl5 " + " where cl1.reference1x6 = cl6 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ " where cl2.reference2x7 = cl7 " + " where cl3.reference3x8 = cl8 " + " where cl4.reference4x9 = cl9 " + " where for cl9(name like 'ModelClass9Inst2*')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		ResultSet resultSet = this.executeQuery(query);

		return this.complex_grid_assoc_with_fixed_set_check(resultSet);
	}

	private boolean complex_grid_assoc_with_fixed_set_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, 2, false) });
		if (instSize > 20) {
			for (int i = 20; i < Math.min(instSize, 30); i++) {
				intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, i, false) });
			}
			if (instSize > 200) {
				for (int j = 200; j < Math.min(instSize, 300); j++) {
					intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, j, false) + j });
				}
			}
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select mm.name(STRING), mm.attrStringMultiValued2(STRING)(multi)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm
	 *  where for mm(name(STRING) ='ModelClass1Inst0')) as result
	 */
	protected boolean select_multivalued_attributes_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass1")), false); //$NON-NLS-1$ //$NON-NLS-2$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name", "attrStringMultiValued2" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass1Inst0"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("mm", whereName); //$NON-NLS-1$
		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.select_multivalued_attributes_check(resultSet);
	}

	protected boolean select_multivalued_attributes() throws Exception {

		String query = "select mm.name, mm.attrStringMultiValued2 " + " from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ " where for mm(name ='ModelClass1Inst0')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.select_multivalued_attributes_check(resultSet);
	}

	private boolean select_multivalued_attributes_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		Object[] multivalues = new Object[10];
		for (int i = 0; i < 10; i++) {
			multivalues[i] = ModelDataInstantiator.calculateMultiValuedStringAttr(1, 0, 2, i, false);
		}

		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, 0, false), multivalues });

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select mm.name(STRING), mm.attrEnum(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm
	 *  where for mm(name(STRING) ='ModelClass1Inst0')) as result
	 */
	protected boolean select_enum_attribute_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass1")), false); //$NON-NLS-1$ //$NON-NLS-2$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name", "attrEnum" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass1Inst0"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("mm", whereName); //$NON-NLS-1$
		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.select_enum_attribute_check(resultSet);
	}

	protected boolean select_enum_attribute() throws Exception {

		String query = "select mm.name, mm.attrEnum " + " from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ " where for mm(name ='ModelClass1Inst0')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.select_enum_attribute_check(resultSet);
	}

	private boolean select_enum_attribute_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, 0, false), "Label1" }); //$NON-NLS-1$

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select mm.name(STRING), strTp.Field2(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#[" + EcoreUtil.getURI( GeneratedmetamodelPackage.eINSTANCE.getStructTp( ) ) + "]} as strTp
	 *  where mm.StructTp[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1::attrStruct ] = strTp
	 *  where for mm(name(STRING) ='ModelClass1Inst0')) as result
	 */
	protected boolean assoc_with_struct_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass1")), false); //$NON-NLS-1$ //$NON-NLS-2$
		FromType fromStruct = new FromType("strTp", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("StructTp")), false); //$NON-NLS-1$ //$NON-NLS-2$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip, fromStruct };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAttrs selectField = new SelectAttrs("strTp", new String[] { "Field2" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName, selectField };

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass1Inst0"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("mm", whereName); //$NON-NLS-1$

		WhereRelationReference whereAssoc = new WhereRelationReference("mm", "attrStruct", "strTp"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc, localWhereEntry };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_struct_check(resultSet);
	}

	protected boolean assoc_with_struct() throws Exception {

		String query = "select mm.name, strTp.Field2 " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm, " + "       [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp()) + "] as strTp " + "  where mm.attrStruct = strTp " //$NON-NLS-1$ //$NON-NLS-2$
				+ "  where for mm(name ='ModelClass1Inst0')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_struct_check(resultSet);
	}

	private boolean assoc_with_struct_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, 0, false), ModelDataInstantiator.calculateClassName(1, 0, false) + "structValue" }); //$NON-NLS-1$

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select mm.name(STRING), strTp.Field2(STRING), strInStrTp.Field2(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#[" + EcoreUtil.getURI( GeneratedmetamodelPackage.eINSTANCE.getStructTp( ) ) + "]} as strTp,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#[" + EcoreUtil.getURI( GeneratedmetamodelPackage.eINSTANCE.getStructInStructTp( ) ) + "]} as strInStrTp
	 *  where mm.StructTp[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1::attrStruct ] = strTp
	 *  where strTp.StructInStructTp[@ sap.com/tc/moin/metamodel/generatedmetamodel#[" + EcoreUtil.getURI( GeneratedmetamodelPackage.eINSTANCE.getStructTp( ) ) + "]::Field3 ] = strInStrTp
	 *  where for mm(name(STRING) ='ModelClass1Inst0')) as result
	 */
	protected boolean assoc_with_nested_struct_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), false); //$NON-NLS-1$
		FromType fromStruct = new FromType("strTp", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp()), false); //$NON-NLS-1$
		FromType fromStructInStruct = new FromType("strInStrTp", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructInStructTp()), false); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip, fromStruct, fromStructInStruct };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAttrs selectField = new SelectAttrs("strTp", new String[] { "Field2" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAttrs selectInField = new SelectAttrs("strInStrTp", new String[] { "Field2" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName, selectField, selectInField };

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass1Inst0"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("mm", whereName); //$NON-NLS-1$

		WhereRelationReference whereAssoc = new WhereRelationReference("mm", "attrStruct", "strTp"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereRelationReference whereAssoc2 = new WhereRelationReference("strTp", "Field3", "strInStrTp"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc, whereAssoc2, localWhereEntry };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_nested_struct_check(resultSet);
	}

	protected boolean assoc_with_nested_struct() throws Exception {

		String query = "select mm.name, strTp.Field2, strInStrTp.Field2 " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm, " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "       [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructTp()) + "] as strTp, " + "       [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getStructInStructTp()) + "] as strInStrTp " + "  where mm.attrStruct = strTp "  //$NON-NLS-1$//$NON-NLS-2$
				+ "  where strTp.Field3 = strInStrTp " + "  where for mm(name ='ModelClass1Inst0')"; //$NON-NLS-1$ //$NON-NLS-2$

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_nested_struct_check(resultSet);
	}

	private boolean assoc_with_nested_struct_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, 0, false), ModelDataInstantiator.calculateClassName(1, 0, false) + "structValue", //$NON-NLS-1$
				ModelDataInstantiator.calculateClassName(1, 0, false) + "structValueField3structValue" }); //$NON-NLS-1$

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select mm.name(STRING), obj.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass2,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass2} as obj
	 *  where mm.ModelClass2[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1::attrObjectValued2 ] = obj
	 *  where for mm(name like 'ModelClass1Inst0*')) as result
	 */
	protected boolean assoc_with_class_typed_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), false); //$NON-NLS-1$
		FromType fromObjType = new FromType("obj", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()), false); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip, fromObjType };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAttrs selectObjName = new SelectAttrs("obj", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName, selectObjName };

		WhereString whereName = new WhereString("name", Operation.LIKE, "ModelClass1Inst0*"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("mm", whereName); //$NON-NLS-1$

		WhereRelationReference whereAssoc = new WhereRelationReference("mm", "attrObjectValued0", "obj"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc, localWhereEntry };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_class_typed_check(resultSet);
	}

	protected boolean assoc_with_class_typed() throws Exception {

		String query = "select mm.name, obj.name " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as mm, " + "       [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as obj " + "  where mm.attrObjectValued0 = obj " //$NON-NLS-1$ //$NON-NLS-2$
				+ "  where for mm(name like 'ModelClass1Inst0*')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_class_typed_check(resultSet);
	}

	private boolean assoc_with_class_typed_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		if (createObjValAttrs) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, 0, false), ModelDataInstantiator.calculateObjectValuedAttrName(1, 0, 0, false) });
		}
		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl1.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0} as cl0,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as cl1
	 *  where cl0.reference0x1[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
	 *  where for cl0(attrString0(STRING) ='ModelClass0Inst1strValue0_DIRTY')) as result
	 */
	protected boolean assoc_with_dirty_partition_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("cl0", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()), true); //$NON-NLS-1$
		FromType fromRelationShip2 = new FromType("cl1", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), true); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2 };

		SelectAttrs selectName1 = new SelectAttrs("cl1", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

		WhereString whereName = new WhereString("attrString0", Operation.EQUAL, "ModelClass0Inst1strValue0_DIRTY"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl0", whereName); //$NON-NLS-1$

		WhereRelationReference whereAssoc = new WhereRelationReference("cl0", "reference0x1", "cl1"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc, localWhereEntry };

		Query query11 = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query11);

		return this.assoc_with_dirty_partition_check(resultSet);
	}

	protected boolean assoc_with_dirty_partition() throws Exception {

		String query = "select cl1.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0,   [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as cl1 " + "  where cl0.reference0x1 = cl1 " //$NON-NLS-1$ //$NON-NLS-2$
				+ "  where for cl0(attrString0 = 'ModelClass0Inst1strValue0_DIRTY')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_dirty_partition_check(resultSet);
	}

	private boolean assoc_with_dirty_partition_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		if (partSize > 1 && createDirtyData && (myTestClient.getOrCreateResourceStable(ModelDataInstantiator.getInstPartName(0)).isModified())) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, 1, false) });
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	// protected boolean assoc_with_dirty_partition_in_other_direction( ) throws
	// Exception {
	//
	// String query = "select cl0.name from [" + EcoreUtil.getURI(
	// GeneratedmetamodelPackage.eINSTANCE.getModelClass0( ) ) +
	// "] withoutsubtypes as cl0,   [" + EcoreUtil.getURI(
	// GeneratedmetamodelPackage.eINSTANCE.getModelClass1( ) ) +
	// "] withoutsubtypes as cl1 " + "  where cl0.reference0x1 = cl1 "
	// + "  where for cl1(attrString1 = 'ModelClass1Inst0strValue1_DIRTY')";
	//
	// MQLResultSet resultSet = this.executeQuery( query );
	//
	// return this.assoc_with_dirty_partition_in_other_direction_check(
	// resultSet );
	// }
	//
	// private boolean assoc_with_dirty_partition_in_other_direction_check(
	// MQLResultSet resultSet ) {
	//
	// List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
	// if ( partSize > 1 && createDirtyData && (
	// myTestClient.getOrCreateResourceStable(
	// ModelDataInstantiator.getInstPartName( 1 ) ).isModified( ) ) ) {
	// intendedResultSet.add( new Object[] {
	// ModelDataInstantiator.calculateClassName( 0, 0, false ) } );
	// }
	//
	// return this.verifyResultSet( resultSet, intendedResultSet );
	// }

	/*-
	 * (select cl0.name(STRING), cl1.name(STRING), cl2.name(STRING), cl3.name(STRING), cl4.name(STRING), cl5.name(STRING), cl6.name(STRING), cl7.name(STRING), cl8.name(STRING), cl9.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0} as cl0,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as cl1,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass2} as cl2,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass3} as cl3,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass4} as cl4,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass5} as cl5,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass6} as cl6,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass7} as cl7,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass8} as cl8,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass9} as cl9
	 *  where cl0.reference0x1[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
	 *  where cl1.reference1x2[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
	 *  where cl2.reference2x3[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x3 ] = cl3
	 *  where cl3.reference3x4[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x4 ] = cl4
	 *  where cl4.reference4x5[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc4x5 ] = cl5
	 *  where cl5.reference5x6[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc5x6 ] = cl6
	 *  where cl6.reference6x7[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc6x7 ] = cl7
	 *  where cl7.reference7x8[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc7x8 ] = cl8
	 *  where cl8.reference8x9[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc8x9 ] = cl9
	 *  where for cl9(name like 'ModelClass9Inst2*')) as result
	 */
	protected boolean complex_assoc_linear_with_many_selections_ast() throws Exception {

		FromEntry[] fromEntries = new FromEntry[mmSize];
		SelectEntry[] selectEntries = new SelectEntry[mmSize];

		for (int i = 0; i < mmSize; i++) {
			fromEntries[i] = new FromType("cl" + i, EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass" + i)), true); //$NON-NLS-1$ //$NON-NLS-2$
			selectEntries[i] = new SelectAttrs("cl" + i, new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		}

		WhereString whereName = new WhereString("name", Operation.LIKE, "ModelClass" + (mmSize - 1) + "Inst2*"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl" + (mmSize - 1), whereName); //$NON-NLS-1$

		WhereEntry[] whereEntries = new WhereEntry[mmSize];

		for (int i = 0; i < (mmSize - 1); i++) {
			whereEntries[i] = new WhereRelationReference("cl" + i, "reference" + i + "x" + (i + 1), "cl" + (i + 1)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}
		whereEntries[mmSize - 1] = localWhereEntry;

		Query query12 = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query12);

		return this.complex_assoc_linear_with_many_selections_check(resultSet);
	}

	protected boolean complex_assoc_linear_with_many_selections() throws Exception {

		String query = "select cl0.name, cl1.name, cl2.name, cl3.name, cl4.name, cl5.name, cl6.name, cl7.name, cl8.name, cl9.name " + "  from [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + "  [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3()) + "] as cl3, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass4()) + "] as cl4, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass5()) + "] as cl5, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass6()) + "] as cl6, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass7()) + "] as cl7, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass8()) + "] as cl8, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass9()) + "] as cl9 " + " where cl0.reference0x1 = cl1 " + " where cl1.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ " where cl2.reference2x3 = cl3 " + " where cl3.reference3x4 = cl4 " + " where cl4.reference4x5 = cl5 " + " where cl5.reference5x6 = cl6 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ " where cl6.reference6x7 = cl7 " + " where cl7.reference7x8 = cl8 " + " where cl8.reference8x9 = cl9 " + " where for cl9(name like 'ModelClass9Inst2*')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		ResultSet resultSet = this.executeQuery(query);

		return this.complex_assoc_linear_with_many_selections_check(resultSet);
	}

	protected boolean complex_assoc_linear_with_many_selections_limited() throws Exception {

		String query = "select cl0.name, cl1.name, cl2.name, cl3.name, cl4.name, cl5.name, cl6.name, cl7.name, cl8.name, cl9.name " + "  from [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + "  [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3()) + "] as cl3, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass4()) + "] as cl4, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass5()) + "] as cl5, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass6()) + "] as cl6, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass7()) + "] as cl7, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass8()) + "] as cl8, " + " [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass9()) + "] as cl9 " + " where cl0.reference0x1 = cl1 " + " where cl1.reference1x2 = cl2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ " where cl2.reference2x3 = cl3 " + " where cl3.reference3x4 = cl4 " + " where cl4.reference4x5 = cl5 " + " where cl5.reference5x6 = cl6 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ " where cl6.reference6x7 = cl7 " + " where cl7.reference7x8 = cl8 " + " where cl8.reference8x9 = cl9 " + " where for cl9(name like 'ModelClass9Inst2*')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		ResultSet resultSet = this.executeQuery(query, 3);

		return this.complex_assoc_linear_with_many_selections_check_limited(resultSet);
	}

	private boolean complex_assoc_linear_with_many_selections_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		Object[] intendedResultString = new Object[mmSize];
		for (int i = 0; i < mmSize; i++) {
			intendedResultString[i] = ModelDataInstantiator.calculateClassName(i, 2, false);
		}
		intendedResultSet.add(intendedResultString);

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	private boolean complex_assoc_linear_with_many_selections_check_limited(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		Object[] intendedResultString = new Object[mmSize];
		for (int i = 0; i < mmSize; i++) {
			intendedResultString[i] = ModelDataInstantiator.calculateClassName(i, 2, false);
		}
		intendedResultSet.add(intendedResultString);

		if (resultSet.getSize() > 3) {
			return false;
		}

		return this.verifyResultSetLimited(resultSet, intendedResultSet);
	}

	/*-
	 * Query dependent on dirty state...
	 */
	protected boolean partition_scope_in_query_ast() throws Exception {

		this.makeDirty();

		List<URI> partitionScopeList = new ArrayList<URI>();

		for (int i = 0; i < partSize; i++) {
			if (myTestClient.getOrCreateResourceStable(ModelDataInstantiator.getInstPartName(i)).isModified()) {
				partitionScopeList.add(myTestClient.getOrCreateResourceStable(ModelDataInstantiator.getInstPartName(i)).getURI());
			}
		}

		URI[] myPartitionScope = partitionScopeList.toArray(new URI[partitionScopeList.size()]);

		// numbers of those ModelClasses that are in a dirty partition
		List<Integer> dirtyClassesList = new ArrayList<Integer>();

		if (this.dirtyPartitionsRatio > 0) {
			for (int classNr = 0; classNr < mmSize; classNr++) {
				if (this.calculatePartitionDirtyFlag(ModelDataInstantiator.calculatePartitionForClassNr(classNr, partSize))) {
					dirtyClassesList.add(classNr);
				}
			}
		} else {
			for (int classNr = 0; classNr < mmSize; classNr++) {
				dirtyClassesList.add(classNr);
			}
		}

		List<FromEntry> fromEntriesList = new ArrayList<FromEntry>();
		List<SelectEntry> selectEntriesList = new ArrayList<SelectEntry>();

		for (Iterator<Integer> dirtyIterator = dirtyClassesList.iterator(); dirtyIterator.hasNext();) {
			int i = dirtyIterator.next();
			TypeScopeProvider queryScopeProvider = this.getMQLProcessor().getInclusivePartitionScopeProvider(myPartitionScope);
			fromEntriesList.add(new FromType("cl" + i, EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getEClassifier("ModelClass" + i)), true, queryScopeProvider)); //$NON-NLS-1$ //$NON-NLS-2$
			selectEntriesList.add(new SelectAttrs("cl" + i, new String[] { "name" })); //$NON-NLS-1$ //$NON-NLS-2$
		}

		FromEntry[] fromEntries = fromEntriesList.toArray(new FromEntry[fromEntriesList.size()]);
		SelectEntry[] selectEntries = selectEntriesList.toArray(new SelectEntry[selectEntriesList.size()]);

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass" + dirtyClassesList.get(0).toString() + "Inst0"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl" + dirtyClassesList.get(0).toString(), whereName); //$NON-NLS-1$

		WhereEntry[] whereEntries = new WhereEntry[dirtyClassesList.size()];

		for (int i = 0; i < dirtyClassesList.size() - 1; i++) {
			whereEntries[i] = new WhereRelationReference("cl" + dirtyClassesList.get(i).toString(), "reference" + dirtyClassesList.get(i).toString() + "x" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ dirtyClassesList.get(i + 1).toString(), "cl" + dirtyClassesList.get(i + 1).toString()); //$NON-NLS-1$
		}

		whereEntries[dirtyClassesList.size() - 1] = localWhereEntry;

		Query query13 = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query13);

		return this.partition_scope_in_query_check(resultSet, dirtyClassesList);
	}

	private boolean partition_scope_in_query_check(ResultSet resultSet, List<Integer> dirtyClassesList) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		List<Object> intendedResultString = new ArrayList<Object>();

		if (this.dirtyPartitionsRatio > 0) {
			for (Iterator<Integer> dirtyIterator = dirtyClassesList.iterator(); dirtyIterator.hasNext();) {
				intendedResultString.add(ModelDataInstantiator.calculateClassName(dirtyIterator.next(), 0, false));
			}
			intendedResultSet.add(intendedResultString.toArray());
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl0.name(STRING), cl0.attrInt2(INTEGER)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass0} as cl0,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as cl1
	 *  where cl0.reference0x1[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
	 *  where cl1.attrInt2(INTEGER) > cl0.attrInt2(INTEGER)
	 *  where for cl1(name(STRING) ='ModelClass1Inst1')) as result
	 */
	protected boolean assoc_with_two_comparisons_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("cl0", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()), false); //$NON-NLS-1$
		FromType fromRelationShip2 = new FromType("cl1", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), false); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2 };

		SelectAttrs select1 = new SelectAttrs("cl0", new String[] { "name", "attrInt2" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		SelectEntry[] selectEntries = new SelectEntry[] { select1 };

		WhereString whereName0 = new WhereString("name", Operation.EQUAL, "ModelClass1Inst1"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry whereEntry0 = new LocalWhereEntry("cl1", whereName0); //$NON-NLS-1$

		WhereEntry[] whereEntries = new WhereEntry[3];
		whereEntries[0] = new WhereRelationReference("cl0", "reference0x1", "cl1"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		whereEntries[1] = new WhereComparisonAttrs("cl1", "attrInt2", Operation.GREATER, "cl0", "attrInt2"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		whereEntries[2] = whereEntry0;

		Query query14 = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query14);

		return this.assoc_with_two_comparisons_check(resultSet);
	}

	protected boolean assoc_with_two_comparisons() throws Exception {

		String query = "select cl0.name, cl0.attrInt2 " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + "       [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1 " + "  where cl0.reference0x1 = cl1 " + "  where cl1.attrInt2 > cl0.attrInt2 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "  where for cl1(name ='ModelClass1Inst1')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_two_comparisons_check(resultSet);
	}

	protected boolean assoc_with_two_comparisons_variant() throws Exception {

		String query = "select cl0.name, cl0.attrInt2 " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + "       [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1, " + "       [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1_1 " + "  where cl0.reference0x1 = cl1 " + "  where cl1 = cl1_1 " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "  where cl1.attrInt2 > cl0.attrInt2 " + "  where cl1_1.name ='ModelClass1Inst1'"; //$NON-NLS-1$ //$NON-NLS-2$

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_two_comparisons_check(resultSet);
	}

	private boolean assoc_with_two_comparisons_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 1; i < 2; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, i, false), new Integer(ModelDataInstantiator.calculateIntAttr(0, i, 2)) });
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select mm.name(STRING), mm.attrInt1(INTEGER)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as mm
	 *  where for mm((attrInt1(INTEGER) >= 1001002) and
	 *               (attrInt1(INTEGER) < 1001010) and
	 *               (not(name like 'ModelClass*Obj*')))) as result
	 */
	protected boolean where_with_three_comparisons_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), true); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name", "attrInt1" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

		WhereString whereName = new WhereString("name", Operation.LIKE, "ModelClass*Obj*"); //$NON-NLS-1$ //$NON-NLS-2$
		WhereNot whereNot = new WhereNot(whereName);
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("mm", whereNot); //$NON-NLS-1$

		WhereInt whereInt1 = new WhereInt("attrInt1", Operation.GREATEREQUAL, ModelDataInstantiator.calculateIntAttr(1, 2, 1)); //$NON-NLS-1$
		WhereInt whereInt2 = new WhereInt("attrInt1", Operation.SMALLER, ModelDataInstantiator.calculateIntAttr(1, instSize, 1)); //$NON-NLS-1$
		WhereClause[] whereInts = new WhereClause[] { whereInt1, whereInt2 };
		WhereAnd whereAnd = new WhereAnd(whereInts);
		LocalWhereEntry andComparison = new LocalWhereEntry("mm", whereAnd); //$NON-NLS-1$

		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry, andComparison };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.where_with_three_comparisons_check(resultSet);
	}

	protected boolean where_with_three_comparisons() throws Exception {

		String query = "select mm.name, mm.attrInt1 " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as mm " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "  where for mm((attrInt1 >= 1001002) and " + "              (attrInt1 < 1001010) and " + "               (not(name like 'ModelClass*Obj*')))"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		ResultSet resultSet = this.executeQuery(query);

		return this.where_with_three_comparisons_check(resultSet);
	}

	protected boolean where_with_three_comparisons_limited() throws Exception {

		String query = "select mm.name, mm.attrInt1 " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as mm " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "  where for mm((attrInt1 >= 1001002) and " + "              (attrInt1 < 1001010) and " + "               (not(name like 'ModelClass*Obj*')))"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		ResultSet resultSet = this.executeQuery(query, 3);

		return this.where_with_three_comparisons_check_limited(resultSet);
	}

	protected boolean where_with_three_comparisons_2() throws Exception {

		String query = "select mm.name, mm.attrInt1 from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) //$NON-NLS-1$
				+ "] withoutsubtypes as mm where mm.attrInt1 >= 1001002 where mm.attrInt1 < 1001010 where " + " mm.name not like 'ModelClass*Obj*'"; //$NON-NLS-1$ //$NON-NLS-2$

		ResultSet resultSet = this.executeQuery(query);

		return this.where_with_three_comparisons_check(resultSet);
	}

	private boolean where_with_three_comparisons_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 2; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, false), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	private boolean where_with_three_comparisons_check_limited(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 2; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, false), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
		}

		if (resultSet.getSize() != 3) {
			return false;
		}

		return this.verifyResultSetLimited(resultSet, intendedResultSet);
	}

	/*-
	 * (select mm.name(STRING), mm.attrInt1(INTEGER)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as mm
	 *  where for mm((not(name like 'ModelClass*Obj*')) and
	 *               ((attrInt1(INTEGER) < 1001002) or
	 *               (attrInt1(INTEGER) > 1001002)))) as result
	 */
	protected boolean where_with_three_comparisons_and_or_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), true); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name", "attrInt1" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

		WhereString whereName = new WhereString("name", Operation.LIKE, "ModelClass*Obj*"); //$NON-NLS-1$ //$NON-NLS-2$
		WhereNot whereNot = new WhereNot(whereName);

		WhereInt whereInt1 = new WhereInt("attrInt1", Operation.SMALLER, ModelDataInstantiator.calculateIntAttr(1, 2, 1)); //$NON-NLS-1$
		WhereInt whereInt2 = new WhereInt("attrInt1", Operation.GREATER, ModelDataInstantiator.calculateIntAttr(1, 2, 1)); //$NON-NLS-1$
		WhereClause[] whereInts = new WhereClause[] { whereInt1, whereInt2 };
		WhereOr whereOr = new WhereOr(whereInts);

		WhereClause[] finalAnd = new WhereClause[] { whereNot, whereOr };

		WhereAnd whereAnd = new WhereAnd(finalAnd);

		LocalWhereEntry andComparison = new LocalWhereEntry("mm", whereAnd); //$NON-NLS-1$

		WhereEntry[] whereEntries = new WhereEntry[] { andComparison };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.where_with_three_comparisons_and_or_check(resultSet);
	}

	protected boolean where_with_three_comparisons_and_or() throws Exception {

		String query = "select mm.name, mm.attrInt1 " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as mm " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "  where for mm((not(name like 'ModelClass*Obj*')) and " + "               ((attrInt1 < 1001002) or " + "               (attrInt1 > 1001002)))"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		ResultSet resultSet = this.executeQuery(query);

		return this.where_with_three_comparisons_and_or_check(resultSet);
	}

	private boolean where_with_three_comparisons_and_or_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 0; i < instSize; i++) {
			if (i != 2) {
				intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, false), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
			}
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select mm.name(STRING), mm.attrInt1(INTEGER)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm) as result
	 */
	protected boolean execute_with_exclusive_scope_ast() throws Exception {

		FromType fromRelationShip = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), false); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name", "attrInt1" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

		Query query = new Query(selectEntries, fromEntries);

		URI[] oldPartitionScope = partitionScope;
		boolean oldPartitionScopeInclusive = partitionScopeInclusive;
		partitionScope = null;
		partitionScopeInclusive = false;
		ResultSet resultSet = this.executeQuery(query);
		partitionScope = oldPartitionScope;
		partitionScopeInclusive = oldPartitionScopeInclusive;

		return this.execute_with_exclusive_scope_check(resultSet);
	}

	private boolean execute_with_exclusive_scope_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, false), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, true), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	protected boolean reflect_element() throws Exception {

		String partitions = ""; //$NON-NLS-1$
		if (partitionScope != null && partitionScope.length > 0) {
			partitions = "[" + partitionScope[0] + "]"; //$NON-NLS-1$ //$NON-NLS-2$
			for (int i = 1; i < partitionScope.length; i++) {
				partitions += ", [" + partitionScope[i] + "]"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		String query = "select el from [" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEObject()) + "] as el in resources{" + partitions + "}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		ResultSet resultSet = this.executeQuery(query);
		return this.reflect_element_check(resultSet);
	}

	private boolean reflect_element_check(ResultSet resultSet) {

		// collect all partitions in the result set and verify
		Set<URI> partitionsInResultSet = new HashSet<URI>();
		for (int i = 0; i < resultSet.getSize(); i++) {
			partitionsInResultSet.add(resultSet.getUri(i, "el").trimFragment()); //$NON-NLS-1$
		}

		// check against the initial available
		for (int i = 0; i < partitionScope.length; i++) {
			if (!partitionsInResultSet.contains(partitionScope[i])) {
				return false;
			}
		}

		return partitionsInResultSet.size() == partitionScope.length;
	}

	/*-
	 * (select t1.name(STRING), t2.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as t1,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as t2
	 *  where t1.assoc1xRefElementEndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1xRefElement ] = t2) as result
	 */
	protected boolean assoc_to_subclass_of_reflect_element_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("t1", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), false); //$NON-NLS-1$
		FromType fromRelationShip2 = new FromType("t2", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), false); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2 };

		SelectAttrs selectMe1Name = new SelectAttrs("t1", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAttrs selectMe2Name = new SelectAttrs("t2", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMe1Name, selectMe2Name };

		WhereRelationReference whereAssoc1 = new WhereRelationReference("t1", "reference1xRefElement", "t2"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc1 };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_to_subclass_of_reflect_element_check(resultSet);
	}

	protected boolean assoc_to_subclass_of_reflect_element() throws Exception {

		String query = "select t1.name, t2.name " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as t1, " + "       [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as t2 " + "  where t1.reference1xRefElement = t2"; //$NON-NLS-1$ //$NON-NLS-2$

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_to_subclass_of_reflect_element_check(resultSet);
	}

	private boolean assoc_to_subclass_of_reflect_element_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, 0, false), ModelDataInstantiator.calculateClassName(1, i, false) });
		}
		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	protected boolean reflect_element_with_fixed_set() throws Exception {

		String preQuery = "select el from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as el where el.name = 'ModelClass1Inst0'"; //$NON-NLS-1$ //$NON-NLS-2$
		ResultSet preResultSet = this.executeQuery(preQuery);

		String query = "select el from [" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEObject()) + "] as el in elements {[" + preResultSet.getUri(0, "el") + "]}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		ResultSet resultSet = this.executeQuery(query);

		return this.reflect_element_with_fixed_set_check(resultSet, preResultSet.getUri(0, "el")); //$NON-NLS-1$
	}

	protected boolean reflect_element_compared_with_fixed_set() throws Exception {

		String preQuery = "select el from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as el where el.name = 'ModelClass1Inst0'"; //$NON-NLS-1$ //$NON-NLS-2$
		ResultSet preResultSet = this.executeQuery(preQuery);

		String query = "select el from [" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEObject()) + "] as el, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1 in elements {[" + preResultSet.getUri(0, "el") + "]}, [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] as cl2 where cl1.reference1x2 = cl2 where el = cl1 "; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.reflect_element_with_fixed_set_check(resultSet, preResultSet.getUri(0, "el")); //$NON-NLS-1$
	}

	protected boolean reflect_element_compared_with_fixed_set_2() throws Exception {

		String preQuery = "select el from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as el where el.name = 'ModelClass1Inst0'"; //$NON-NLS-1$ //$NON-NLS-2$
		ResultSet preResultSet = this.executeQuery(preQuery);

		String query = "select el, cl1 from [" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEObject()) + "] as el, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1 in elements {[" + preResultSet.getUri(0, "el") + "]} where el = cl1 "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		ResultSet resultSet = this.executeQuery(query);

		return this.reflect_element_with_fixed_set_check(resultSet, preResultSet.getUri(0, "el")) //$NON-NLS-1$
				&& this.reflect_element_with_fixed_set_check_2(resultSet, preResultSet.getUri(0, "el")); //$NON-NLS-1$

	}

	private boolean reflect_element_with_fixed_set_check(ResultSet resultSet, URI element) {

		return element.equals(resultSet.getUri(0, "el")); //$NON-NLS-1$
	}

	private boolean reflect_element_with_fixed_set_check_2(ResultSet resultSet, URI element) {

		return element.equals(resultSet.getUri(0, "cl1")); //$NON-NLS-1$
	}

	protected boolean incompatible_types_return_empty_result() throws Exception {

		String query = "select el from [" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEObject()) + "] as el, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1," + "[" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) //$NON-NLS-1$ //$NON-NLS-2$
				+ "] as cl2 where el = cl1 where el = cl2 where cl2 = cl2"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return resultSet.isEmpty();
	}

	protected boolean assoc_to_reflect_element() throws Exception {

		String query = "select t1.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as t1, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(EcorePackage.eINSTANCE.getEObject()) + "] as t2 where t1.reference1xRefElement = t2"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_to_reflect_element_check(resultSet);
	}

	private boolean assoc_to_reflect_element_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, 0, false) });
		}
		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select cl0.name(STRING), cl1.name(STRING)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass0,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass0} as cl0,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1,
	 *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as cl1
	 *  where cl0.reference0x1[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
	 *  where for cl0(name(STRING) ='ModelClass0Inst0')) as result
	 */
	protected boolean assoc_with_multiple_selection_ast() throws Exception {

		FromType fromRelationShip1 = new FromType("cl0", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()), false); //$NON-NLS-1$
		FromType fromRelationShip2 = new FromType("cl1", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), false); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2 };

		SelectAttrs selectName1 = new SelectAttrs("cl0", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$
		SelectAttrs selectName2 = new SelectAttrs("cl1", new String[] { "name" }); //$NON-NLS-1$ //$NON-NLS-2$

		SelectEntry[] selectEntries = new SelectEntry[] { selectName1, selectName2 };

		WhereString whereName = new WhereString("name", Operation.EQUAL, "ModelClass0Inst0"); //$NON-NLS-1$ //$NON-NLS-2$
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("cl0", whereName); //$NON-NLS-1$

		WhereRelationReference whereAssoc1 = new WhereRelationReference("cl0", "reference0x1", "cl1"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry, whereAssoc1 };

		Query query2a = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query2a);

		return this.assoc_with_multipled_selection_check(resultSet);
	}

	protected boolean assoc_with_multiple_selection() throws Exception {

		String query = "select cl0.name, cl1.name " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] as cl0, " + "       [" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] as cl1 " + "  where cl0.reference0x1 = cl1 " //$NON-NLS-1$ //$NON-NLS-2$
				+ "  where for cl0(name ='ModelClass0Inst0')"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.assoc_with_multipled_selection_check(resultSet);
	}

	private boolean assoc_with_multipled_selection_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, 0, false), ModelDataInstantiator.calculateClassName(1, 0, false) });
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, 0, false), ModelDataInstantiator.calculateClassName(1, 0, true) });
		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/*-
	 * (select mm.name(STRING), mm.attrInt1(INTEGER)
	 *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as mm,
	 *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::ModelClass1} as mm2
	 *  where mm.attrEnum(STRING) = mm2.attrEnum(STRING)
	 *  where mm = mm2
	 *  where for mm((not(name like 'ModelClass*Obj*')) and
	 *               (attrEnum(STRING) ='Label1'))) as result
	 */
	protected boolean enum_comparisons_ast() throws Exception {

		FromType fromT1 = new FromType("mm", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), true); //$NON-NLS-1$
		FromType fromT2 = new FromType("mm2", EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()), true); //$NON-NLS-1$
		FromEntry[] fromEntries = new FromEntry[] { fromT1, fromT2 };

		SelectAttrs selectMeName = new SelectAttrs("mm", new String[] { "name", "attrInt1" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

		WhereString whereName = new WhereString("name", Operation.LIKE, "ModelClass*Obj*"); //$NON-NLS-1$ //$NON-NLS-2$
		WhereNot whereNot = new WhereNot(whereName);
		WhereString whereEnum = new WhereString("attrEnum", Operation.EQUAL, "Label1"); //$NON-NLS-1$ //$NON-NLS-2$

		WhereClause[] whereClauses = { whereNot, whereEnum };
		WhereAnd whereAnd = new WhereAnd(whereClauses);
		LocalWhereEntry localWhereEntry = new LocalWhereEntry("mm", whereAnd); //$NON-NLS-1$

		JoinWhereEntry joinWhereEntry1 = new WhereComparisonAttrs("mm", "attrEnum", Operation.EQUAL, "mm2", "attrEnum"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		JoinWhereEntry joinWhereEntry2 = new WhereComparisonAliases("mm", "mm2"); //$NON-NLS-1$ //$NON-NLS-2$

		WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry, joinWhereEntry1, joinWhereEntry2 };

		Query query = new Query(selectEntries, fromEntries, whereEntries);

		ResultSet resultSet = this.executeQuery(query);

		return this.enum_comparisons_check(resultSet);
	}

	protected boolean enum_comparisons() throws Exception {

		String query = "select mm.name, mm.attrInt1 " + "  from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as mm, " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "       [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as mm2 " + "  where mm.attrEnum = mm2.attrEnum " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ "  where mm = mm2 " + "  where for mm((not(name like 'ModelClass*Obj*')) and " + "               (attrEnum ='Label1'))"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		ResultSet resultSet = this.executeQuery(query);

		return this.enum_comparisons_check(resultSet);
	}

	private boolean enum_comparisons_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(1, i, false), new Integer(ModelDataInstantiator.calculateIntAttr(1, i, 1)) });
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	protected boolean enforced_simple_scheduling() throws Exception {

		String query = " select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as cl1, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] withoutsubtypes as cl2 in resources{[" + this.partitionScope[2] + "]}, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3()) + "] withoutsubtypes as cl3 /* in resources{[" + this.partitionScope[3] //$NON-NLS-1$
				+ "]} */ where cl0.reference0x1 = cl1 where cl1.reference1x2 = cl2 where cl2.reference2x3 = cl3 "; //$NON-NLS-1$

		// FIXME this.makePartitionDirty( this.loadPartition( 3 ) );

		ResultSet resultSet = this.executeQuery(query);

		return this.enforced_simple_scheduling_check(resultSet);
	}

	protected boolean enforced_simple_scheduling_2() throws Exception {

		String query = " select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0 in resources{[" //$NON-NLS-1$ //$NON-NLS-2$
				+ this.partitionScope[0] + "]}, [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as cl1 in resources{[" //$NON-NLS-1$ //$NON-NLS-2$
				+ this.partitionScope[1] + "]} , [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] withoutsubtypes as cl2 in resources{[" //$NON-NLS-1$ //$NON-NLS-2$
				+ this.partitionScope[2] + "]} where cl0.reference0x1 = cl1 where cl1.reference1x2 = cl2"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.enforced_simple_scheduling_check(resultSet);
	}

	protected boolean enforced_simple_scheduling_3() throws Exception {

		String query = " select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as cl1 in resources{[" + this.partitionScope[1] + "]}, [" //$NON-NLS-1$ //$NON-NLS-2$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] withoutsubtypes as cl2, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3()) + "] withoutsubtypes as cl3 /* in resources{[" + this.partitionScope[3] //$NON-NLS-1$
				+ "]} */ where cl0.reference0x1 = cl1 where cl1.reference1x2 = cl2 where cl2.reference2x3 = cl3 "; //$NON-NLS-1$

		// FIXME this.makePartitionDirty( this.loadPartition( 1 ) );

		ResultSet resultSet = this.executeQuery(query);

		return this.enforced_simple_scheduling_check(resultSet);
	}

	private boolean enforced_simple_scheduling_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		for (int i = 0; i < instSize; i++) {
			intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, i, false) });
		}

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	protected boolean enforced_scheduling() throws Exception {

		String query = " select cl0.name from [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1())
				+ "] withoutsubtypes as cl1, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2())
				+ "] withoutsubtypes as cl2 in resources{[" //$NON-NLS-1$
				+ this.partitionScope[2]
				+ "]}, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0())
				+ "] withoutsubtypes as cl0, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3())
				+ "] withoutsubtypes as cl3 /* in resources{[" //$NON-NLS-1$
				+ this.partitionScope[3]
				+ "]} */ where cl0.reference0x1 = cl1 where cl1.reference1x2 = cl2 where cl2.name ='ModelClass2Inst0' where cl1.name = 'ModelClass1Inst0' where cl2.reference2x3 = cl3"; //$NON-NLS-1$

		// FIXME this.makePartitionDirty( this.loadPartition( 3 ) );

		ResultSet resultSet = this.executeQuery(query);

		return this.enforced_scheduling_check(resultSet);
	}

	protected boolean enforced_scheduling_2() throws Exception {

		String query = " select cl0.name from [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0()) + "] withoutsubtypes as cl0 in resources{[" //$NON-NLS-1$ //$NON-NLS-2$
				+ this.partitionScope[0] + "]}, [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1()) + "] withoutsubtypes as cl1 in resources{[" //$NON-NLS-1$ //$NON-NLS-2$
				+ this.partitionScope[1] + "]} , [" + EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2()) + "] withoutsubtypes as cl2 in resources{[" //$NON-NLS-1$ //$NON-NLS-2$
				+ this.partitionScope[2] + "]} where cl0.reference0x1 = cl1 where cl1.reference1x2 = cl2 where cl2.name ='ModelClass2Inst0' where cl1.name = 'ModelClass1Inst0'"; //$NON-NLS-1$

		ResultSet resultSet = this.executeQuery(query);

		return this.enforced_scheduling_check(resultSet);
	}

	protected boolean enforced_scheduling_3() throws Exception {

		String query = " select cl0.name from [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass0())
				+ "] withoutsubtypes as cl0, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass1())
				+ "] withoutsubtypes as cl1 in resources{[" //$NON-NLS-1$
				+ this.partitionScope[1]
				+ "]}, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass2())
				+ "] withoutsubtypes as cl2, [" //$NON-NLS-1$
				+ EcoreUtil.getURI(GeneratedmetamodelPackage.eINSTANCE.getModelClass3())
				+ "] withoutsubtypes as cl3 /* in resources{[" //$NON-NLS-1$
				+ this.partitionScope[3]
				+ "]} */ where cl0.reference0x1 = cl1 where cl1.reference1x2 = cl2 where cl2.reference2x3 = cl3 where cl2.name ='ModelClass2Inst0' where cl1.name = 'ModelClass1Inst0'"; //$NON-NLS-1$

		// FIXME this.makePartitionDirty( this.loadPartition( 1 ) );

		ResultSet resultSet = this.executeQuery(query);

		return this.enforced_scheduling_check(resultSet);
	}

	private boolean enforced_scheduling_check(ResultSet resultSet) {

		List<Object[]> intendedResultSet = new ArrayList<Object[]>();
		intendedResultSet.add(new Object[] { ModelDataInstantiator.calculateClassName(0, 0, false) });

		return this.verifyResultSet(resultSet, intendedResultSet);
	}

	/* Auxiliary methods */

	private ResultSet executeQuery(Query mqlQuery) throws Exception {

		this.makeDirty();

		ResultSet resultSet = null;

		QueryProcessor mql = this.getMQLProcessor();

		if (this.withOptimization) {
			mql.turnOnOptimizationDuringScheduling();
		} else {
			mql.turnOffOptimizationForElementsDuringScheduling();
		}

		long timeStamp = System.currentTimeMillis();
		// MQLPreparedQuery preparedQuery = mql.prepare(mqlQuery);
		// String preparedQueryString = preparedQuery.toString();
		// QueryScopeProvider queryScopeProvider =
		// mql.getQueryScopeProvider(partitionScopeInclusive, partitionScope);
		resultSet = mql.execute(mqlQuery, this.getQueryContext());

		if (isTraced(LogSeverity.INFO)) {
			trace(LogSeverity.INFO, "Query \n" + mqlQuery.toString() + "\nexecuted in " + String.valueOf(System.currentTimeMillis() - timeStamp) + " ms"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		return resultSet;
	}

	private ResultSet executeQuery(String mqlQuery, int threshold) throws Exception {

		this.makeDirty();

		ResultSet resultSet = null;

		QueryProcessor mql = this.getMQLProcessor();

		if (this.withOptimization) {
			mql.turnOnOptimizationDuringScheduling();
		} else {
			mql.turnOffOptimizationForElementsDuringScheduling();
		}

		long timeStamp = System.currentTimeMillis();
		// MQLPreparedQuery preparedQuery = mql.prepare(mqlQuery);
		// String preparedQueryString = preparedQuery.toString();
		// QueryScopeProvider queryScopeProvider =
		// mql.getQueryScopeProvider(partitionScopeInclusive, partitionScope);
		resultSet = mql.execute(mqlQuery, this.getQueryContext(), threshold);

		if (isTraced(LogSeverity.INFO)) {
			trace(LogSeverity.INFO, "Query \n" + mqlQuery + "\nexecuted in " + String.valueOf(System.currentTimeMillis() - timeStamp) + " ms"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		return resultSet;
	}

	private ResultSet executeQuery(String mqlQuery) throws Exception {

		return this.executeQuery(mqlQuery, -1);
	}

	private boolean calculatePartitionDirtyFlag(int partNr) {

		return (partNr % this.dirtyPartitionsRatio == 0);
	}

	private void makeDirty() throws Exception {

		if (this.dirtyPartitionsRatio > 0) {
			for (int j = 0; j < partSize; j++) {
				if (this.calculatePartitionDirtyFlag(j)) {
					Resource mp = this.loadPartition(j);
					this.makePartitionDirty(mp);

					if (createDirtyData) {
						TreeIterator<Object> el_iter = EcoreUtil.getAllProperContents(mp, true);
						for (; el_iter.hasNext();) {
							Object tmpObject = el_iter.next();

							if (tmpObject instanceof EObject && !((EObject) tmpObject).eIsProxy()) {
								for (int k = 0; k < attrSize; k++) {
									try {
										String tmpStr = (String) tmpObject.getClass().getMethod("getAttrString" + k, (Class[]) null).invoke(tmpObject, (Object[]) null); //$NON-NLS-1$
										tmpObject.getClass().getMethod("setAttrString" + k, new Class[] { String.class }).invoke(tmpObject, //$NON-NLS-1$
												(Object[]) (new String[] { tmpStr + "_DIRTY" })); //$NON-NLS-1$
									} catch (NoSuchMethodException nsme) {
										// ok
									}
								}
							}
						}
					}
				}
			}
		}

		if (isTraced(LogSeverity.INFO)) {
			trace(LogSeverity.INFO, "Applied dirty data settings."); //$NON-NLS-1$
		}

	}

	private void makePartitionDirty(Resource mp) {

		mp.setModified(true);
	}

	private Resource loadPartition(int j) {

		Resource mp = myTestClient.getOrCreateResourceStable(ModelDataInstantiator.getInstPartName(j));
		if (isTraced(LogSeverity.INFO)) {
			trace(LogSeverity.INFO, "Loading partition: " + mp.getURI()); //$NON-NLS-1$
		}

		return mp;
	}

	// protected ModelPartition[] loadPartitions( ) {
	//
	// ModelPartition[] partitions = new ModelPartition[partSize];
	// for ( int j = 0; j < partSize; j++ ) {
	// partitions[j] = this.loadPartition( j );
	// }
	// return partitions;
	// }

	/**
	 * Verfies the result set based on the String entries. The intended result
	 * set has to be a list of arrays, which represent the lines of the result
	 * set.
	 * 
	 * @param resultSet
	 * @param intendedResult
	 */
	private boolean verifyResultSet(ResultSet resultSet, List<Object[]> intendedResult) {

		boolean correctResultSet = true;
		int numberOfRows = resultSet.getSize();

		// construct the produced result set as basis for comparing
		List<Object[]> producedResultSet = new ArrayList<Object[]>(numberOfRows);

		// get reflective information
		ColumnType[] columnTypes = resultSet.getQueryColumnTypes();

		for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
			// add a line in the produced result set
			Object[] row = new Object[columnTypes.length];

			// iterate over the aliases
			for (int k = 0; k < columnTypes.length; k++) {
				if (columnTypes[k].attribute == null) {
					row[k] = resultSet.getUri(rowIndex, columnTypes[k].alias);
				} else {
					row[k] = resultSet.getAttribute(rowIndex, columnTypes[k].alias, columnTypes[k].attribute);
				}
			}
			producedResultSet.add(rowIndex, row);
		}

		// do the actual comparison
		int rsRow = 0;
		if (intendedResult.size() == producedResultSet.size()) {

			while (correctResultSet && rsRow < numberOfRows) {
				int psRow = 0;
				boolean correctResultSubSet = false;
				Object[] intendedRow = intendedResult.get(rsRow);
				while (!correctResultSubSet && psRow < numberOfRows) {
					correctResultSubSet = this.equalsArray(producedResultSet.get(psRow), intendedRow);
					psRow++;
				}
				correctResultSet = correctResultSubSet;
				rsRow++;
			}
		} else {
			correctResultSet = false;
		}

		if (!correctResultSet) {
			// header
			String header = "\n| "; //$NON-NLS-1$
			for (int i = 0; i < columnTypes.length; i++) {
				header = header + columnTypes[i].alias;
				if (columnTypes[i].attribute != null) {
					header = header + "." + columnTypes[i].attribute; //$NON-NLS-1$
				}
				header = header + " : " + columnTypes[i].typeName + " | "; //$NON-NLS-1$ //$NON-NLS-2$
			}

			// convert the 2D arrays to a legible format
			String producedResultSetString = header + "\n"; //$NON-NLS-1$
			String intendedResultSetString = header + "\n"; //$NON-NLS-1$
			for (Object[] producedResultSetRow : producedResultSet) {
				producedResultSetString = producedResultSetString + this.nestedArrayToString(producedResultSetRow, " | ") + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
			for (Object[] intendedResultSetRow : intendedResult) {
				intendedResultSetString = intendedResultSetString + this.nestedArrayToString(intendedResultSetRow, " | ") + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}

			StringBuilder sb = new StringBuilder();
			sb.append("Test FAILED\n"); //$NON-NLS-1$
			sb.append("-----> Result Sets \n"); //$NON-NLS-1$
			sb.append("Produced Result Set:" + producedResultSetString + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
			sb.append("Intended Result Set:" + intendedResultSetString + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
			sb.append("Result Sets <-----"); //$NON-NLS-1$
			System.err.println(sb.toString());
		}

		return correctResultSet;
	}

	/**
	 * Verfies the result set based on the String entries. The intended result
	 * set has to be a list of arrays, which represent the lines of the result
	 * set.
	 * 
	 * @param resultSet
	 * @param intendedResult
	 */
	private boolean verifyResultSetLimited(ResultSet resultSet, List<Object[]> intendedResult) {

		boolean correctResultSet = true;
		int numberOfRows = resultSet.getSize();

		// construct the produced result set as basis for comparing
		List<Object[]> producedResultSet = new ArrayList<Object[]>(numberOfRows);

		// get reflective information
		ColumnType[] columnTypes = resultSet.getQueryColumnTypes();

		for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
			// add a line in the produced result set
			Object[] row = new Object[columnTypes.length];

			// iterate over the aliases
			for (int k = 0; k < columnTypes.length; k++) {
				if (columnTypes[k].attribute == null) {
					row[k] = resultSet.getUri(rowIndex, columnTypes[k].alias);
				} else {
					row[k] = resultSet.getAttribute(rowIndex, columnTypes[k].alias, columnTypes[k].attribute);
				}
			}
			producedResultSet.add(rowIndex, row);
		}

		// do the actual comparison
		int rsRow = 0;
		if (intendedResult.size() >= producedResultSet.size()) {

			while (correctResultSet && rsRow < numberOfRows) {
				int psRow = 0;
				boolean correctResultSubSet = false;
				Object[] intendedRow = intendedResult.get(rsRow);
				while (!correctResultSubSet && psRow < numberOfRows) {
					correctResultSubSet = this.equalsArray(producedResultSet.get(psRow), intendedRow);
					psRow++;
				}
				correctResultSet = correctResultSubSet;
				rsRow++;
			}
		} else {
			correctResultSet = false;
		}

		if (!correctResultSet) {
			// header
			String header = "\n| "; //$NON-NLS-1$
			for (int i = 0; i < columnTypes.length; i++) {
				header = header + columnTypes[i].alias;
				if (columnTypes[i].attribute != null) {
					header = header + "." + columnTypes[i].attribute; //$NON-NLS-1$
				}
				header = header + " : " + columnTypes[i].typeName + " | "; //$NON-NLS-1$ //$NON-NLS-2$
			}

			// convert the 2D arrays to a legible format
			String producedResultSetString = header + "\n"; //$NON-NLS-1$
			String intendedResultSetString = header + "\n"; //$NON-NLS-1$
			for (Object[] producedResultSetRow : producedResultSet) {
				producedResultSetString = producedResultSetString + this.nestedArrayToString(producedResultSetRow, " | ") + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
			for (Object[] intendedResultSetRow : intendedResult) {
				intendedResultSetString = intendedResultSetString + this.nestedArrayToString(intendedResultSetRow, " | ") + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}

			StringBuilder sb = new StringBuilder();
			sb.append("Test FAILED\n"); //$NON-NLS-1$
			sb.append("-----> Result Sets \n"); //$NON-NLS-1$
			sb.append("Produced Result Set:" + producedResultSetString + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
			sb.append("Intended Result Set:" + intendedResultSetString + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
			sb.append("Result Sets <-----"); //$NON-NLS-1$
			System.err.println(sb.toString());
		}

		return correctResultSet;
	}

	private String nestedArrayToString(Object[] resultSetArray, String separator) {

		String res = separator;
		for (Object resSetEntry : resultSetArray) {
			if (resSetEntry == null) {
				res = res + " null" + separator; //$NON-NLS-1$
			} else if (resSetEntry instanceof Object[]) {
				res = res + "[" + this.nestedArrayToString((Object[]) resSetEntry, " ; ") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else {
				res = res + resSetEntry.toString() + separator;
			}
		}
		return res;
	}

	private boolean equalsArray(Object[] array1, Object[] array2) {

		if (array1.length == array2.length) {
			boolean res = true;
			int i = 0;
			while (res && i < array1.length) {
				if ((array1[i] == null && array2[i] != null) || (array2[i] == null && array1[i] != null)) {
					res = false;
				} else if (array1[i] instanceof Object[] && array2[i] instanceof Object[]) {
					res = this.equalsArray(((Object[]) array1[i]), ((Object[]) array2[i]));
				} else {
					res = (array1[i] == null && array2[i] == null) || array1[i].equals(array2[i]);
				}
				i++;
			}
			return res;
		}
		return false;

	}

	private QueryProcessor getMQLProcessor() {

		return QueryProcessorFactory.getDefault().createQueryProcessor(index);
	}

	private QueryContext getQueryContext() {

		QueryContext context = new QueryContext() {

			public URI[] getResourceScope() {
				return partitionScope;
			}

			public ResourceSet getResourceSet() {
				return myTestClient.getResourceSet();
			}

		};

		return context;
	}
}
