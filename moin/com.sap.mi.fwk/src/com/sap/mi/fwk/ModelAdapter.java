package com.sap.mi.fwk;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;

import com.sap.mi.fwk.internal.MiFwkPlugin;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;

/**
 * Implements several policies to convert model entities of one type to another.
 * Most of them are convenience utilities e.g. to avoid casts or to concentrate
 * functionality spread over different MOIN APIs.
 * <p>
 * Also see the UI counterpart of this class
 * <code>com.sap.mi.fwk.ui.ModelAdapterUI</code>.
 * 
 * @author d031150
 */
public class ModelAdapter {

	private static final ModelAdapter sInstance = new ModelAdapter();

	/**
	 * @return the adapter instance
	 */
	public static ModelAdapter getInstance() {
		return sInstance;
	}

	/**
	 * Returns the connection of the given model object
	 * 
	 * @param object
	 *            the object to get the connection for. Must not be
	 *            <code>null</code>.
	 * @return the connection
	 * 
	 * @see Partitionable#get___Connection()
	 */
	public Connection getConnection(RefBaseObject object) {
		MiFwkPlugin.assertObjectNotNull(object);
		Connection connection = getPartitionable(object).get___Connection();
		return connection;
	}

	/**
	 * Returns the project of the given object's connection, which usually is a
	 * kind of "tool context".
	 * 
	 * Note that the <b>object may be hosted in a different project</b> than the
	 * returned one (in case of an object referenced in a public part). Use
	 * {@link #getProject(RefBaseObject)} if interested in the object's actual
	 * location. The latter may be <code>null</code> for archives.
	 * 
	 * @param object
	 *            the object to get the project for
	 * @return the project or <code>null</code> if the object's connection was
	 *         not created with a project scope (see
	 *         {@link ConnectionManager#createConnection(IProject)}).
	 * 
	 * @see #getProject(RefBaseObject)
	 */
	public IProject getProjectUsingConnection(RefBaseObject object) {
		Connection connection = getConnection(object);
		IProject project = getProject(connection);
		return project;
	}

	/**
	 * Returns the project of the given connection, which usually is a kind of
	 * "tool context".
	 * 
	 * @param connection
	 *            the connection to get the project for
	 * @return the project or <code>null</code> if the object's connection was
	 *         not created with a project scope (see
	 *         {@link ConnectionManager#createConnection(IProject)}).
	 * 
	 * @see #getProjectUsingConnection(RefBaseObject)
	 */
	public IProject getProject(Connection connection) {
		IProject project = ConnectionManager.getInstance().getProject(connection);
		return project;
	}

	/**
	 * Returns the project of the given object.
	 * 
	 * Note that this project
	 * <ul>
	 * <li>is <code>null</code> for objects in
	 * <ul>
	 * <li>archives,</li>
	 * <li>{@link PRI#isMetaModelPartition() metamodel} partitions,</li>
	 * </ul>
	 * <li>for objects in referenced projects is different from the "home
	 * project" of the tool (i.e. the project of the connection the object was
	 * resolved with). See {@link #getProjectUsingConnection(RefBaseObject)}.</li>
	 * <li>for {@link PRI#isNullPartition() null} and
	 * {@link PRI#isVolatilePartition() volatile} partitions is the "home
	 * project" of the tool. This is to avoid the loss of context for those
	 * volatile objects, however, in this respect calling this method is not
	 * equivalent to calling {@link #getPri(RefBaseObject)},
	 * {@link PRI#getCri()}, and {@link #getProject(CRI)}.</li> </li>
	 * </ul>
	 * 
	 * @param object
	 *            the object to get the project for
	 * @return the project or <code>null</code> under the mentioned
	 *         circumstances
	 * 
	 * @see #getContainer(RefBaseObject)
	 * @see #getProjectUsingConnection(RefBaseObject)
	 */
	public IProject getProject(RefBaseObject object) {
		IProject project = getProject(getContainer(object));
		return project;
	}

	/**
	 * Returns the project of the given container.
	 * 
	 * Note that this project
	 * <ul>
	 * <li>is <code>null</code> for archive and
	 * {@link CRI#isVolatileContainer() volatile} containers,</li>
	 * <li>may be different from the "home project" of the tool (which usually
	 * is the project of the connection the object was resolved with). See
	 * {@link #getProjectUsingConnection(RefBaseObject)}.</li>
	 * </ul>
	 * 
	 * @param container
	 *            the container id to get the project for
	 * @return the project or <code>null</code> under the mentioned
	 *         circumstances
	 * 
	 * @see #getProject(RefBaseObject)
	 * @see #getProjectUsingConnection(RefBaseObject)
	 * @see #getContainer(IProject)
	 */
	public IProject getProject(CRI container) {
		IProject project = MiFwkPlugin.getIdeCompoundDataAreaManager().getProject(container);
		// project is null for
		// - archives
		// - volatile/null/metamodel partitions
		return project;
	}

	/**
	 * Returns the container of the given object's connection, which usually is
	 * a kind of "tool context".
	 * 
	 * Note that the <b>object may be hosted in a different container</b> than
	 * the returned one (in case of an object referenced in a public part). Use
	 * {@link #getContainer(RefBaseObject)} if interested in the object's actual
	 * location.
	 * 
	 * @param object
	 *            the object whose container should be queried for
	 * @return the container or <code>null</code> under the mentioned
	 *         circumstances
	 * 
	 * @see #getContainer(RefBaseObject)
	 */
	public CRI getContainerUsingConnection(RefBaseObject object) {
		Connection connection = getConnection(object);
		CRI container = getContainer(connection);
		return container;
	}

	/**
	 * Returns the container of a given model object.
	 * 
	 * Note that this container
	 * <ul>
	 * <li>for objects in referenced projects or archives may be different from
	 * the container of the "home project" of the tool (which usually is the
	 * project of the connection the object was resolved with). See
	 * {@link #getContainerUsingConnection(RefBaseObject)},</li>
	 * <li>is the {@link #getContainer(Connection) connection's container} for
	 * objects in {@link PRI#isNullPartition() null} and
	 * {@link PRI#isVolatilePartition() volatile} partitions. This is to avoid
	 * the loss of context for those volatile objects, however, in this respect
	 * calling this method is not equivalent to calling
	 * {@link #getPri(RefBaseObject)} and {@link PRI#getCri()}.</li>
	 * <li>is one in the {@link DataAreaDescriptor#isMetamodelDataArea()
	 * metamodel data area} for objects in {@link PRI#isMetaModelPartition()
	 * metamodel partitions}.</li>
	 * </ul>
	 * 
	 * @param object
	 *            the object whose container should be queried for
	 * @return the container
	 * 
	 * @see #getContainerUsingConnection(RefBaseObject)
	 */
	public CRI getContainer(RefBaseObject object) {
		CRI container = getPri(object).getCri();
		// CRI.isVolatileContainer() applies for null and volatile partitions,
		// not for metamodel partitions, which is what we want.
		if (container.isVolatileContainer()) {
			Connection connection = getConnection(object);
			container = getContainer(connection);
		}
		return container;
	}

	/**
	 * Returns the container of a given project.
	 * 
	 * Note that the container is <code>null</code> for closed projects and
	 * projects that are not {@link ModelManager#isMoinProject(IProject) Moin
	 * relevant}.
	 * 
	 * @param project
	 *            the project whose container should be queried for
	 * @return the container or <code>null</code> under the mentioned
	 *         circumstances
	 * 
	 * @see #getContainer(RefBaseObject)
	 */
	public CRI getContainer(IProject project) {
		if (project != null && project.isOpen()) {
			CRI container = MiFwkPlugin.getIdeCompoundDataAreaManager().getContainer(project);
			return container;
		}
		return null;
	}

	/**
	 * Returns the container of the given connection, which usually is a kind of
	 * "tool context".
	 * 
	 * Note that the container is <code>null</code> if the connection was not
	 * created with a project scope (see
	 * {@link ConnectionManager#createConnection(IProject)}).
	 * 
	 * @param connection
	 *            the connection whose container should be queried for
	 * @return the container or <code>null</code> under the mentioned
	 *         circumstances
	 * 
	 * @see #getContainerUsingConnection(RefBaseObject)
	 */
	public CRI getContainer(Connection connection) {
		IProject project = getProject(connection);
		if (project != null) {
			CRI container = getContainer(project);
			return container;
		}
		return null;
	}

	// /**
	// * Returns the container of a <em>metamodel</em> by its name
	// *
	// * @param metamodelContainerName
	// * the name of the container, e.g.
	// * <code>sap.com/tc/moin/webdynpro/webdynpro</code>
	// * @return the container
	// *
	// * @see #getContainer(RefBaseObject)
	// */
	// public CRI getContainerForMetamodel(String metamodelContainerName) {
	//		CRI container = MoinFactory.getMoinInstance().createCri(IdePrimaryFacility.FACILITY_ID, "MetaModelDataArea", //$NON-NLS-1$
	// metamodelContainerName);
	// return container;
	// }

	/**
	 * Returns the Eclipse file for the given object's partition.
	 * 
	 * Note that the file is <code>null</code> for objects in
	 * <ul>
	 * <li>archives,</li>
	 * <li>{@link PRI#isNullPartition() null}, {@link PRI#isVolatilePartition()
	 * volatile} and {@link PRI#isMetaModelPartition() metamodel} partitions,</li>
	 * <li>closed projects,</li>
	 * <li>not yet persisted partitions. In this respect this methods behaves
	 * asymmetric to the handle-only resource APIs like
	 * {@link IProject#getFile(String)}.</li>
	 * </ul>
	 * 
	 * @param object
	 *            the model object to get the file for
	 * @return the partition file or <code>null</code> under the mentioned
	 *         circumstances
	 * 
	 * @see #getFile(PRI)
	 */
	public IFile getFile(RefBaseObject object) {
		PRI pri = getPri(object);
		IFile file = getFile(pri);
		return file;
	}

	/**
	 * Returns the Eclipse file for the given partition.
	 * 
	 * Note that the file is <code>null</code> for objects in
	 * <ul>
	 * <li>archives,</li>
	 * <li>{@link PRI#isNullPartition() null}, {@link PRI#isVolatilePartition()
	 * volatile} and {@link PRI#isMetaModelPartition() metamodel} partitions,</li>
	 * <li>closed projects,</li>
	 * <li>not yet persisted partitions. In this respect this methods behaves
	 * asymmetric to the handle-only resource APIs like
	 * {@link IProject#getFile(String)}.</li>
	 * </ul>
	 * 
	 * @param pri
	 *            the partition id to get the file for
	 * @return the partition file or <code>null</code> under the mentioned
	 *         circumstances
	 * 
	 * @see #getFile(RefBaseObject)
	 */
	public IFile getFile(PRI pri) {
		IFile file = MiFwkPlugin.getIdeCompoundDataAreaManager().getFile(pri);
		return file;
	}

	/**
	 * Returns the object identifier of the given model object
	 * 
	 * @param object
	 *            the object to get the {@link MRI} for. Must not be
	 *            <code>null</code>.
	 * @return the identifier
	 * 
	 * @see Partitionable#get___Mri()
	 */
	public MRI getMri(RefBaseObject object) {
		MiFwkPlugin.assertObjectNotNull(object);
		MRI mri = getPartitionable(object).get___Mri();
		return mri;
	}

	/**
	 * Returns the partition identifier of the given model object
	 * 
	 * @param object
	 *            the object to get the {@link PRI} for. Must not be
	 *            <code>null</code>.
	 * @return the partition identifier
	 * 
	 * @see Partitionable#get___Mri()
	 */
	public PRI getPri(RefBaseObject object) {
		MRI mri = getMri(object);
		return mri.getPri();
	}

	/**
	 * Returns the partition identifier for the given file
	 * 
	 * @param file
	 *            the file to get the partition for. Must not be
	 *            <code>null</code>.
	 * @param connection
	 *            connection to check the existence of the partition to return.
	 *            If <code>null</code>, a {@link PRI} may be returned that
	 *            denotes a non-existing partition.
	 * @return the partition identifier or <code>null</code> if no such
	 *         partition exists or the file path denotes an invalid partition
	 *         identifier
	 * 
	 * @see #getPri(RefBaseObject)
	 */
	public PRI getPri(IFile file, Connection connection) {
		MiFwkPlugin.assertObjectNotNull(file);

		IProject project = file.getProject();
		if (!ModelManager.getInstance().isMoinProject(project)) {
			return null;
		}

		IPath filePath = file.getProjectRelativePath();
		try {
			PRI pri = PartitionService.getInstance().getPRI(project, filePath);
			if (pri != null) {
				if (connection == null || connection.partitionExists(pri)) {
					return pri;
				}
			}
		} catch (InvalidResourceIdentifierException e) { // $JL-EXC$
			return null;
		}

		return null;
	}

	/**
	 * Returns the {@link JmiHelper JMI helper} utility for the given object's
	 * connection.
	 * 
	 * @param object
	 *            the object to get the helper for. Must not be
	 *            <code>null</code> and alive.
	 * @return the JMI helper
	 * 
	 * @see Connection#getJmiHelper()
	 */
	public JmiHelper getJmiHelper(RefBaseObject object) {
		Connection connection = getConnection(object);
		MiFwkPlugin.assertConnectionAlive(connection);
		return connection.getJmiHelper();
	}

	/**
	 * Resolves the given model object into the connection of the second model
	 * object.
	 * 
	 * @param <T>
	 * 
	 * @param object
	 *            the model object which should change the connection. Must not
	 *            be <code>null</code> nor dead.
	 * @param objectWithTargetConnection
	 *            the object whose connection the first one should be resolved
	 *            with. Must not be <code>null</code> nor dead.
	 * @return a model object in the target connection or <code>null</code> if
	 *         no such object is available there
	 * 
	 * @see #resolveInConnection(RefBaseObject, Connection)
	 * @see Connection#getElement(MRI)
	 */
	public <T extends RefBaseObject> T resolveInConnection(T object, RefBaseObject objectWithTargetConnection) {
		Connection connection = getConnection(objectWithTargetConnection);
		return resolveInConnection(object, connection);
	}

	/**
	 * Resolves the given model object into the given connection.
	 * 
	 * @param <T>
	 * 
	 * @param object
	 *            the model object which should change the connection. Must not
	 *            be <code>null</code> nor dead.
	 * @param targetConnection
	 *            the connection the object should be resolved with. Must not be
	 *            <code>null</code> nor dead.
	 * @return a model object in the target connection or <code>null</code> if
	 *         no such object is available there
	 * 
	 * @see #resolveInConnection(RefBaseObject, RefBaseObject)
	 * @see Connection#getElement(MRI)
	 */
	@SuppressWarnings("unchecked")
	public <T extends RefBaseObject> T resolveInConnection(T object, Connection targetConnection) {
		Connection ownConnection = getConnection(object);
		if (ownConnection.equals(targetConnection)) {
			return object;
		}

		MiFwkPlugin.assertConnectionAlive(targetConnection);
		MRI mri = getMri(object);
		T resolved = (T) targetConnection.getElement(mri); // unchecked cast
		return resolved;
	}

	/**
	 * Returns the object's JMI interface class, e.g.
	 * <code>Class&lt;MofClass&gt;</code> for all <code>MofClass</code>
	 * instances. Useful when displaying type names since any
	 * <code>refObject.getClass().getName()</code> call would return the name of
	 * the implementation class, which is usually not the intended UI type name.
	 * 
	 * @param <T>
	 * 
	 * @param object
	 *            the object to return the class for. Must not be
	 *            <code>null</code> and alive.
	 * @return the JMI interface class
	 * 
	 * @see Partitionable#get___JmiInterface()
	 */
	public <T extends RefBaseObject> Class<T> getJmiInterface(T object) {
		MiFwkPlugin.assertObjectAlive(object);
		Class<T> clazz = getPartitionable(object).get___JmiInterface();
		return clazz;
	}

	/**
	 * Returns the object as {@link Partitionable}, which provides Moin-specific
	 * extensions to the standard JMI classes.
	 * 
	 * @param object
	 *            the object to return the partitionable for
	 * @return the object as partitionable
	 */
	public Partitionable getPartitionable(RefBaseObject object) {
		return object;
	}

	/**
	 * Generically adapts the given object to the given target type using the
	 * Eclipse adapter mechanisms {@link IAdaptable} and {@link IAdapterManager}
	 * .
	 * 
	 * Returns
	 * <ul>
	 * <li>the given object if it is an instance of the given type,</li>
	 * <li>an appropriate adapter if the given object {@link IAdaptable adapts}
	 * to the given type,</li>
	 * <li><code>null</code> in all other cases.</li>
	 * </ul>
	 * 
	 * @param <T>
	 * 
	 * @param object
	 *            the object to adapt. May be <code>null</code>.
	 * @param targetType
	 *            the type to adapt to. Must not be <code>null</code>.
	 * @return the adapted type or <code>null</code> as specified
	 * 
	 * @see IAdaptable
	 * @see IAdapterManager
	 */
	// ATTENTION WITH API CHANGES!!! - Called via reflection from
	// com.sap.mi.fwk.test.service.internal.InvocationHelper
	@SuppressWarnings("unchecked")
	public <T> T adaptObject(Object object, Class<T> targetType) {
		if (targetType == null) {
			throw new IllegalArgumentException("Class must not be null"); //$NON-NLS-1$
		}

		if (object == null) {
			return null;
		} else if (targetType.isInstance(object)) {
			return (T) object; // runtime-checked cast
		}

		Object adapter;
		if (object instanceof IAdaptable) {
			adapter = ((IAdaptable) object).getAdapter(targetType);
		} else {
			adapter = Platform.getAdapterManager().getAdapter(object, targetType);
		}
		return adaptObject(adapter, targetType);
	}

	/*
	 * Dispatches to the respective <code>getProject(...)</code> methods
	 * depending on the type of the input object. Input is object-typed for use
	 * in ModelAdapterUI (see there). However, we do the dispatching here and
	 * not in UI class to ease test-covering: if dispatching would be done
	 * there, the tests in ModelAdapterTest would need to be duplicated in
	 * ModelAdapterUITest in order to get a proper coverage. Anyway, it is
	 * important that the dispatch methods must be kept in sync with the typed
	 * methods: if these are extended, dispatching must be adjusted as well.
	 */
	protected IProject dispatchGetProject(Object object) {
		// if object directly adapts to target type, take this
		IProject project = adaptObject(object, IProject.class);
		if (project != null) {
			return project;
		}
		// dispatch to all typed methods
		RefBaseObject refBaseObject = adaptObject(object, RefBaseObject.class);
		if (refBaseObject != null) {
			return getProject(refBaseObject);
		}
		CRI container = adaptObject(object, CRI.class);
		if (container != null) {
			return getProject(container);
		}
		Connection connection = adaptObject(object, Connection.class);
		if (connection != null) {
			return getProject(connection);
		}
		return null;
	}

	/*
	 * @see #dispatchGetProject(Object)
	 */
	protected IProject dispatchGetProjectUsingConnection(Object object) {
		// if object directly adapts to target type, take this
		IProject project = adaptObject(object, IProject.class);
		if (project != null) {
			return project;
		}

		// check for connection-holder (RefBaseObject) or connection itself
		RefBaseObject refBaseObject = adaptObject(object, RefBaseObject.class);
		if (refBaseObject != null) {
			return getProjectUsingConnection(refBaseObject);
		}
		Connection connection = adaptObject(object, Connection.class);
		if (connection != null) {
			return getProject(connection);
		}
		return null;
	}

	/*
	 * For instantiation by UI subclass
	 */
	protected ModelAdapter() {
	}

}
