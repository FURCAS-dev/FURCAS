package com.sap.ide.moftool.editor.core.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.omg.ocl.OclPackage;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.IPartitionScopes;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.FromTypeMri;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;



public class MofService {

	private static final String MODEL_PACKAGE_NAME = "Model"; //$NON-NLS-1$
	private static final String OCL_PACKAGE_NAME = "OCL"; //$NON-NLS-1$
	private static final Logger sTracer = Logger.getLogger(MofService.class.getName());

	public static ModelPackage getModelPackage(Connection connection) {
		ModelPackage p = (ModelPackage) connection.getPackage(MOFToolEditorPlugin.CONTAINERNAME_Model, MODEL_PACKAGE_NAME);
		return p;
	}

	public static OclPackage getOclPackage(Connection connection) {
		OclPackage p = (OclPackage) connection.getPackage(MOFToolEditorPlugin.CONTAINERNAME_Model, OCL_PACKAGE_NAME);
		return p;
	}

	/**
	 * Helper method which creates and returns a MultiplicityType.
	 */
	public static MultiplicityType createMultiplicityType(ModelPackage modelPackage, int lower, int upper, boolean isOrdered,
			boolean isUnique) {
		if (modelPackage == null) {
			return null;
		}

		MultiplicityType.Descriptors d = MultiplicityType.DESCRIPTORS;
		StructureFieldContainer<MultiplicityType> container = new StructureFieldContainer<MultiplicityType>();
		container.put(d.LOWER(), lower).put(d.UPPER(), upper).put(d.IS_ORDERED(), isOrdered).put(d.IS_UNIQUE(), isUnique);
		MultiplicityType multiplicityType = modelPackage.createMultiplicityType(container);
		return multiplicityType;
	}

	public static RefObject getRefObject(Object obj) {
		if (obj instanceof RefObject)
			return (RefObject) obj;
		if (obj instanceof IStructuredSelection) {
			if (((IStructuredSelection) obj).isEmpty())
				return null;
			obj = ((IStructuredSelection) obj).getFirstElement();
			return getRefObject(obj);
		}
		if ((obj instanceof TreeItem) && !(obj instanceof IAdaptable)) {
			obj = ((TreeItem) obj).getData();
		}
		if ((obj instanceof TableItem) && !(obj instanceof IAdaptable)) {
			obj = ((TableItem) obj).getData();
		}
		if (obj instanceof RefObject) {
			return (RefObject) obj;
		}
		if (obj instanceof IAdaptable) {
			RefObject devobj = (RefObject) ((IAdaptable) obj).getAdapter(RefObject.class);
			return devobj;
		}

		return null;
	}

	public static RefBaseObject getRefBaseObject(Object obj) {
		RefObject refObject = getRefObject(obj);
		if (refObject != null) {
			return refObject;
		}
		if (obj instanceof IAdaptable) {
			RefBaseObject devobj = (RefBaseObject) ((IAdaptable) obj).getAdapter(RefBaseObject.class);
			return devobj;
		}

		return null;
	}

	public static Connection createConnectionWithBusyCursorWhile(final IProject project) {
		// try it the easy way ... but do not create one if it doesn't exist
		Connection connection = ConnectionManager.getInstance().getExistingDefaultConnection(project);
		if (connection != null) {
			return connection;
		}
		// connection creation as recommended by BI
		final Connection[] connections = new Connection[1]; // ConnectionManager.getInstance().getDefaultConnection(project);
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InterruptedException {
				connections[0] = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
			}
		};

		IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		try {
			ps.busyCursorWhile(operation);
		} catch (InterruptedException e) {
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return connections[0];
	}

	public static Connection getConnection(Object obj) {

		// get the RefObject
		RefBaseObject rbo = getRefBaseObject(obj);
		if (rbo != null) {
			return ModelAdapterUI.getInstance().getConnection(rbo);
		}

		return ModelAdapterUI.getInstance().adaptObject(obj, Connection.class);
	}

	public static Classifier getClassifierForString(Connection connection, String classifierName) {

		// Collection<?> c =
		// JMIReflection.MMBridge.refAllOfTypeInScope(getModelPackage
		// (connection).getClassifier(),null);
		Collection<Classifier> c = getAvailableClassifiers(connection);
		for (Object obj : c) {
			Classifier classifier = (Classifier) obj;
			if (classifier instanceof MofClass || classifier instanceof DataType) {
				if (classifierName.equals(classifier.getName())) {
					if ("PrimitiveTypes".equals(classifier.getQualifiedName().get(0))) //$NON-NLS-1$
						return classifier;
				}
			}
		}
		return null;
	}

	public static Classifier getClassifier(Connection connection, String classifierName) {
		// Collection<?> c =
		// JMIReflection.MMBridge.refAllOfTypeInScope(getModelPackage
		// (connection).getClassifier(),null);
		Collection<Classifier> c = getAvailableClassifiers(connection);
		for (Object obj : c) {
			Classifier classifier = (Classifier) obj;
			if (classifier instanceof MofClass || classifier instanceof DataType) {
				if (classifierName.equals(classifier.getName())) {
					return classifier;
				}
			}
		}
		return null;
	}

	public static Classifier getClassifierByQualifiedName(Connection connection, String classifierQualifiedName) {
		String concatVal = null;
		// Collection<?> c =
		// JMIReflection.MMBridge.refAllOfTypeInScope(getModelPackage
		// (connection).getClassifier(),null);
		Collection<Classifier> c = getAvailableClassifiers(connection);
		for (Object object : c) {
			Classifier classifier = (Classifier) object;
			if (classifier instanceof MofClass || classifier instanceof DataType) {
				List<String> qualifiedName = classifier.getQualifiedName();
				concatVal = getQualifiedNameAsString(qualifiedName);
				if (classifierQualifiedName.equals(concatVal)) {
					return classifier;
				}
			}
		}
		return null;
	}

	public static MofPackage getPackageByQualifiedName(Connection connection, String packageQualifiedName) {
		String concatVal = null;
		Collection<MofPackage> c = getAvailablePackages(connection);
		for (Object object : c) {
			MofPackage pack = (MofPackage) object;
			List<String> qualifiedName = pack.getQualifiedName();
			concatVal = getQualifiedNameAsString(qualifiedName);
			if (packageQualifiedName.equals(concatVal)) {
				return pack;
			}

		}
		return null;
	}

	public static String getQualifiedNameAsString(List<String> qualifiedName) {
		String concatVal = null;
		Iterator<String> it = qualifiedName.iterator();
		Object obj = null;
		String val = null;
		boolean first = true;
		while (it.hasNext()) {
			obj = it.next();
			if (obj instanceof String) {
				val = (String) obj;
				if (first) {
					concatVal = val;
					first = false;
				} else {
					concatVal = concatVal + "." + val; //$NON-NLS-1$
				}
			}
		}
		return concatVal;
	}

	@SuppressWarnings("unchecked")
	public static Collection<MofPackage> getAvailablePackages(Connection connection) {
		IPartitionScopes scopes = PartitionService.getInstance().getPartitionScopes();
		Collection<MofPackage> c = (Collection<MofPackage>) refAllOfTypeInScope(getModelPackage(connection).getMofPackage(), scopes);
		// exclude OclGenerated packages
		Collection<MofPackage> c1 = new ArrayList<MofPackage>();
		Iterator<MofPackage> it = c.iterator();
		MofPackage pck = null;
		String[] sa = null;
		while (it.hasNext()) {
			pck = it.next();
			if (pck.getQualifiedName() != null) {
				sa = pck.getQualifiedName().toArray(new String[0]);
				if (sa[0].startsWith("OclGenerated")) { //$NON-NLS-1$
					continue;
				} else {
					c1.add(pck);
				}
			}
		}
		return c1;
	}

	public static Collection<ModelElement> getAvailablePackagesAndClassesFiltered(Connection connection, MofPackage excludePackage) {
		Collection<? extends ModelElement> classes = MofService.getAvailableClasses(connection);
		Collection<? extends ModelElement> packages = MofService.getAvailablePackages(connection);
		packages.remove(excludePackage);
		Collection<ModelElement> modelElements = new ArrayList<ModelElement>();
		modelElements.addAll(classes);
		modelElements.addAll(packages);
		return modelElements;
	}

	@SuppressWarnings("unchecked")
	public static Collection<MofClass> getAvailableClasses(Connection connection) {
		IPartitionScopes scopes = getScope();
		Collection<MofClass> c = (Collection<MofClass>) refAllOfTypeInScope(getModelPackage(connection).getMofClass(), scopes);
		// IPartitionScopeProvider partitionScopeProvider =
		// PartitionService.getInstance().getPartitionScopeProvider(connection,
		// PartitionScope.VISIBLE);
		// return QueryService.getInstance().queryInstances(connection,
		// partitionScopeProvider, MOFToolEditorPlugin.CONTAINERNAME_Model, new
		// String[]{"Model", "Class"});

		return c;
	}

	@SuppressWarnings("unchecked")
	public static Collection<PrimitiveType> getAvailablePrimitives(Connection connection) {
		// List<RefObject> result = new ArrayList<RefObject>();
		// IPartitionScopeProvider partitionScopeProvider =
		// PartitionService.getInstance().getPartitionScopeProvider(connection,
		// PartitionScope.);
		// return QueryService.getInstance().queryInstances(connection,
		// partitionScopeProvider, MOFToolEditorPlugin.CONTAINERNAME_Model, new
		// String[]{"Model", "PrimitiveType"});
		// connection.getMQLProcessor().getInclusiveContainerScopeProvider(containerScope)
		// MQLResultSet resultSet =
		// connection.getMQLProcessor().execute("select primitiveType from Model::PrimitiveType as primitiveType");
		// RefObject[] refObjects = resultSet.getRefObjects("primitiveType");
		// result.addAll((Collection<? extends MofClass>)
		// Arrays.asList(refObjects));
		// return result;
		IPartitionScopes scopes = getScope();
		Collection<PrimitiveType> c = (Collection<PrimitiveType>) refAllOfTypeInScope(getModelPackage(connection).getPrimitiveType(),
				scopes);
		return c;
	}

	@SuppressWarnings("unchecked")
	public static Collection<ModelElement> getAvailableModelElements(Connection connection) {
		// List<RefObject> result = new ArrayList<RefObject>();
		// IPartitionScopeProvider partitionScopeProvider =
		// PartitionService.getInstance().getPartitionScopeProvider(connection,
		// PartitionScope.);
		// return QueryService.getInstance().queryInstances(connection,
		// partitionScopeProvider, MOFToolEditorPlugin.CONTAINERNAME_Model, new
		// String[]{"Model", "PrimitiveType"});
		// connection.getMQLProcessor().getInclusiveContainerScopeProvider(containerScope)
		// MQLResultSet resultSet =
		// connection.getMQLProcessor().execute("select primitiveType from Model::PrimitiveType as primitiveType");
		// RefObject[] refObjects = resultSet.getRefObjects("primitiveType");
		// result.addAll((Collection<? extends MofClass>)
		// Arrays.asList(refObjects));
		// return result;
		IPartitionScopes scopes = getScope();
		Collection<ModelElement> c = (Collection<ModelElement>) refAllOfTypeInScope(getModelPackage(connection).getModelElement(), scopes);
		return c;

	}

	@SuppressWarnings("unchecked")
	public static Collection<Classifier> getAvailableClassifiers(Connection connection) {
		// List<Classifier> result = new ArrayList<Classifier>();
		//		
		// MQLResultSet resultSet =
		// connection.getMQLProcessor().execute("select class from Model::Class as class");
		// RefObject[] refObjects = resultSet.getRefObjects("class");
		// result.addAll((Collection<? extends Classifier>)
		// Arrays.asList(refObjects));
		// resultSet =
		// connection.getMQLProcessor().execute("select st from Model::StructureType as st");
		// refObjects = resultSet.getRefObjects("st");
		// result.addAll((Collection<? extends Classifier>)
		// Arrays.asList(refObjects));
		// resultSet =
		// connection.getMQLProcessor().execute("select et from Model::EnumerationType as et");
		// refObjects = resultSet.getRefObjects("et");
		// result.addAll((Collection<? extends Classifier>)
		// Arrays.asList(refObjects));
		//		
		// return result;

		IPartitionScopes scopes = getScope();
		// </pg240108>
		Collection<Classifier> classesAndDataTypes = new ArrayList<Classifier>();
		// <pg240108> replaced parameter value null with scopes
		Collection<Classifier> c = (Collection<Classifier>) refAllOfTypeInScope(getModelPackage(connection).getClassifier(), scopes);
		for (Object obj : c) {
			Classifier classifier = (Classifier) obj;
			if (classifier instanceof MofClass || classifier instanceof DataType) {
				classesAndDataTypes.add(classifier);
			}
		}
		return classesAndDataTypes;
	}

	@SuppressWarnings("unchecked")
	public static Collection<DataType> getAvailableDatatypes(Connection connection) {
		IPartitionScopes scopes = getScope();
		Collection<DataType> dataTypes = (Collection<DataType>) refAllOfTypeInScope(getModelPackage(connection).getDataType(), scopes);
		return dataTypes;
	}

	@SuppressWarnings("unchecked")
	public static Collection<Constraint> getAvailableConstraints(Connection connection) {
		IPartitionScopes scopes = getScope();
		Collection<Constraint> c = (Collection<Constraint>) refAllOfTypeInScope(getModelPackage(connection).getConstraint(), scopes);
		return c;
	}

	@SuppressWarnings("unchecked")
	public static Collection<MofException> getAvailableMofExceptions(Connection connection) {
		IPartitionScopes scopes = getScope();
		Collection<MofException> c = (Collection<MofException>) refAllOfTypeInScope(getModelPackage(connection).getMofException(), scopes);
		return c;
	}

	private static Set<PRI> priPrimitiveTypesAndReflect = null;

	public static synchronized Set<PRI> getPrimitiveType_And_Reflect_PRIs() {

		if (priPrimitiveTypesAndReflect == null) {
			Moin moinInstance = ModelManager.getInstance().getMoinInstance();
			HashSet<PRI> res = new HashSet<PRI>(4);
			res.add(moinInstance.createPri("PF", "MetaModelDataArea", "sap.com/tc/moin/mof_1.4", "moin/meta/PrimitiveTypes.moinmm")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			res.add(moinInstance.createPri("PF", "MetaModelDataArea", "sap.com/tc/moin/mof_1.4", "moin/meta/Reflect.moinmm")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			priPrimitiveTypesAndReflect = Collections.unmodifiableSet(res);
		}
		return priPrimitiveTypesAndReflect;
	}

	public static IPartitionScopes getScope() {
		// <pg240108> restrict scope to visible + primitive types
		IPartitionScopes scopes = PartitionService.getInstance().getPartitionScopes();
		scopes.setFixedVisiblePartitions(getPrimitiveType_And_Reflect_PRIs());
		// </pg240108>
		// <pg240108> replaced parameter value null with scopes
		return scopes;
	}

	/*
	 * 
	 * The following methods are copied from com.sap.mi.fwk.mmbridge.JMIReflection
	 */

	private static final String ALIAS_INSTANCE = "instance"; //$NON-NLS-1$

	public static String getName(RefObject dobj) {
		Attribute p = getAttribute((MofClass) dobj.refMetaObject(), "name"); //$NON-NLS-1$
		if (p != null) {
			Object o = dobj.refGetValue(p);
			if (o instanceof String)
				return (String) o;
		}
		return dobj.toString();
	}

	public static Attribute getAttribute(MofClass mofClass, String attributeName) {
		return ((Partitionable) mofClass).get___Connection().getJmiHelper().getAttributeByName(mofClass, attributeName, true);
	}

	public static MofClass getMofClass(RefBaseObject devObj) {
		return getMetaClass(devObj);
	}

	public static MofClass getMetaClass(RefBaseObject o) {
		Object mo = o.refMetaObject();
		if (mo instanceof MofClass)
			return (MofClass) mo;
		return null;
	}

	public static Object getAttributeValue(RefObject dobj, Attribute po) {
		return dobj.refGetValue(po);
	}

	public static List<? extends RefObject> refAllOfTypeInScope(RefClass rc, IPartitionScopes psp) {

		if (psp == null) {
			// Collection r = rc.refAllOfType();
			List<RefObject> r = refAllOfTypeViaQuery(rc);
			return r;
		}
		MofClass mc = rc.refMetaObject();
		List<String> qname = mc.getQualifiedName();
		String[] qualifiedNameOfType = mc.getQualifiedName().toArray(new String[qname.size()]);
		Connection connection = getConnection(rc);
		Set<PRI> priSet = psp.getVisiblePartitions(connection);

		String metamodelContainerName = ((Partitionable) mc).get___Mri().getPri().getContainerName();
		if (qualifiedNameOfType == null || qualifiedNameOfType.length == 0)
			throw new IllegalArgumentException("qualifiedNameOfType must not be empty: " //$NON-NLS-1$
					+ qualifiedNameOfType);

		FromType metaclassFT = new FromType(ALIAS_INSTANCE /* alias name */, qualifiedNameOfType, metamodelContainerName, false /*
																																 * false:
																																 * with
																																 * subtypes
																																 */);
		FromEntry[] fromEntries = new FromEntry[] { metaclassFT };

		SelectAlias selectAlias = new SelectAlias(ALIAS_INSTANCE);
		SelectEntry[] selectEntries = new SelectEntry[] { selectAlias };
		MQLQuery query = new MQLQuery(selectEntries, fromEntries);
		MQLProcessor processor = connection.getMQLProcessor();
		try {
			QueryScopeProvider scopeProvider = processor.getQueryScopeProvider(true, priSet, null);
			MQLResultSet resultSet = processor.execute(query, scopeProvider);
			List<RefObject> result = new ArrayList<RefObject>(resultSet.getSize());
			for (int i = 0; i < resultSet.getSize(); i++) {
				RefBaseObject object = connection.getElement(resultSet.getMri(i, ALIAS_INSTANCE));
				result.add((RefObject) object);
			}
			sortByMofId(result);
			return result;
		} catch (MQLExecutionException e) {
			sTracer.log(Level.SEVERE, "Query execution failed: " + e.getMessage(), e); //$NON-NLS-1$
			return Collections.emptyList();
		}
	}

	private static List<RefObject> refAllOfTypeViaQuery(RefClass rc) {
		MofClass mc = rc.refMetaObject();

		Collection<RefBaseObject> c2 = refAllOfTypeInMof(rc);
		List<String> qname = mc.getQualifiedName();
		String[] qualifiedNameOfType = mc.getQualifiedName().toArray(new String[qname.size()]);
		Connection connection = getConnection(rc);
		String metamodelContainerName = ((Partitionable) mc).get___Mri().getPri().getContainerName();
		if (qualifiedNameOfType == null || qualifiedNameOfType.length == 0)
			throw new IllegalArgumentException("qualifiedNameOfType must not be empty: " //$NON-NLS-1$
					+ qualifiedNameOfType);

		FromType metaclassFT = new FromType(ALIAS_INSTANCE /* alias name */, qualifiedNameOfType, metamodelContainerName, false /*
																																 * false:
																																 * with
																																 * subtypes
																																 */);
		FromEntry[] fromEntries = new FromEntry[] { metaclassFT };

		SelectAlias selectAlias = new SelectAlias(ALIAS_INSTANCE);
		SelectEntry[] selectEntries = new SelectEntry[] { selectAlias };
		MQLQuery query = new MQLQuery(selectEntries, fromEntries);
		MQLProcessor processor = connection.getMQLProcessor();
		try {
			MQLResultSet resultSet = processor.execute(query); // ,
			// true,priset,
			// null);
			List<RefObject> result = new ArrayList<RefObject>(resultSet.getSize());
			for (int i = 0; i < resultSet.getSize(); i++) {
				RefBaseObject object = connection.getElement(resultSet.getMri(i, ALIAS_INSTANCE));
				// no chance to check in advance at runtime if object is an
				// instance of T :(
				result.add((RefObject) object);
			}
			if (c2 != null && c2.size() > 0) {
				for (Object rc2 : c2) {
					result.add((RefObject) rc2);
				}
			}
			sortByMofId(result);
			return result;
		} catch (MQLExecutionException e) {
			sTracer.log(Level.SEVERE, "Query execution failed: " + e.getMessage(), e); //$NON-NLS-1$
			return Collections.emptyList();
		}
	}

	/**
	 * works only for MOF.
	 * 
	 * @param rc
	 * @return
	 */
	private static Collection<RefBaseObject> refAllOfTypeInMof(RefClass rc) {
		MRI mriOfMofClass = ((Partitionable) rc.refMetaObject()).get___Mri();
		Connection conn = getConnection(rc);
		MQLProcessor mql = conn.getMQLProcessor();
		MQLQuery query = new MQLQuery(new SelectEntry[] { new SelectAlias("thisClass") }, new FromEntry[] { new FromTypeMri( //$NON-NLS-1$
				"thisClass", mriOfMofClass, false) }); //$NON-NLS-1$
		QueryScopeProvider scopeProvider = mql
				.getQueryScopeProvider(true, null, new String[] { mriOfMofClass.getPri().getContainerName() });
		MQLResultSet resultSet = mql.execute(query, scopeProvider);
		List<RefBaseObject> resultObjs = new ArrayList<RefBaseObject>(resultSet.getSize());
		for (int i = 0; i < resultSet.getSize(); i++) {
			resultObjs.add(conn.getElement(resultSet.getMri(i, "thisClass"))); //$NON-NLS-1$
		}
		sortByMofId2(resultObjs);
		return resultObjs;
	}

	private static void sortByMofId(List<RefObject> result) {
		Collections.sort(result, new Comparator<RefObject>() {
			public int compare(RefObject o1, RefObject o2) {
				if (o1 == o2)
					return 0;
				if (o1 == null)
					return +1;
				if (o2 == null)
					return -1;
				return o1.refMofId().compareTo(o2.refMofId());
			}
		});
	}

	private static void sortByMofId2(List<RefBaseObject> result) {
		Collections.sort(result, new Comparator<RefBaseObject>() {
			public int compare(RefBaseObject o1, RefBaseObject o2) {
				if (o1 == o2)
					return 0;
				if (o1 == null)
					return +1;
				if (o2 == null)
					return -1;
				return o1.refMofId().compareTo(o2.refMofId());
			}
		});
	}

	private static Connection getConnection(RefClass rc) {
		return ((Partitionable) rc).get___Connection();
	}

}
