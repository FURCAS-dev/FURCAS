package com.sap.mi.fwk.test.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

import abbot.script.Condition;
import abbot.tester.swt.Robot;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.dcfwk.MoinDcOptions;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.services.local.FileServices;
import com.sap.mi.fwk.services.local.ZipService;
import com.sap.mi.fwk.test.service.internal.InvocationHelper;
import com.sap.mi.fwk.test.service.internal.TestServicePlugin;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.cdam.ide.internal.IdeFacilityDispatcherInternal;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Provides standalone services useful for Moin-based JUnit tests like project
 * creation, metamodel import and DB resetting. Convencience test classes like
 * {@link ProjectBasedTest} just delegate to methods of this class.
 *
 * @author d031150
 */
public final class TestUtil {

	/**
	 * The container name ("id") of the MOF metamodel
	 *
	 * @value sap.com/tc/moin/mof_1.4
	 */
	public static final String CONTAINER_NAME_MOF = "sap.com/tc/moin/mof_1.4"; //$NON-NLS-1$

	/**
	 * The name of the Moin text verticalization metamodel DC
	 *
	 * @value tc/moin/model/textverticalization
	 */
	public static final String DC_NAME_MM_TEXTVERTICALIZATION = "tc/moin/model/textverticalization"; //$NON-NLS-1$

	/**
	 * The name of the compilation public part of the Moin text verticalization
	 * metamodel DC
	 *
	 * @value MM_Comp
	 */
	public static final String PP_NAME_COMPILTATION_MM_TEXTVERTICALIZATION = "MM_Comp"; //$NON-NLS-1$

	// TODO use constant: currently defined in MiLocations.MI_PROJECTS
	private static final TracerI sTracerProjects = TracingManager.getTracer("com.sap.moin.tooldevelopment.mie.projects"); //$NON-NLS-1$

	/**
	 * Constant defining the length of the string starting at <pos> and provided
	 * as detail information of
	 * {@link #assertEqualsLongString(String, String, String)}
	 */
	private static final int TAIL_LENGTH = 50;
	/**
	 * Constant defining the length of the string ending at <pos> and provided
	 * as detail information of
	 * {@link #assertEqualsLongString(String, String, String)}
	 */
	private static final int HEAD_LENGTH = 50;

	/**
	 * Creates a DC project, deleting an existing project,
	 *
	 * @param dcName
	 *            the name of the DC. Note that this differs from the
	 *            corresponding project name.
	 * @return The Eclipse project
	 * @throws CoreException
	 */
	public static IProject createLocalMoinDCProjectDeleting(String dcName) {
		IProject project = getLocalMoinDCProject(dcName);
		if (project != null) {
			// TODO [Projects] switch to deletePartitions==false as soon as Dii
			// deletes via Eclipse resources and not io.File
			deleteLocalMoinDCProject(project, true);
		}
		return createLocalMoinDCProject(dcName);
	}

	/**
	 * Creates a DC project, deleting an existing project,
	 *
	 * @param dcName
	 *            the name of the DC. Note that this differs from the
	 *            corresponding project name.
	 * @param is
	 *            An InputStream containing the future content; the moin-content
	 *            can be exported using the (create model data function;
	 *            alternatively, the following folder in the DC-project may be
	 *            zipped e.g.: If your project was webdynp, zip
	 *            New_configuration
	 *            .jdi\LocalDevelopment\DCs\sap.com\webdyn\_comp\src (click zip
	 *            on the src folder so that the zip is next to the src folder! )
	 * @return The Eclipse project
	 */
	public static IProject createLocalMoinDCProjectDeletingLoadingData(String dcName, InputStream is) {
		return createLocalMoinDCProjectDeletingLoadingData(dcName, MoinTestDcType.getDcType(), is);
	}

	/**
	 * Creates a DC project, deleting an existing project,
	 *
	 * @param dcName
	 *            the name of the DC. Note that this differs from the
	 *            corresponding project name.
	 * @param dcType
	 *            the type of the DC
	 * @param is
	 *            An InputStream containing the future content; the moin-content
	 *            can be exported using the (create model data function;
	 *            alternatively, the following folder in the DC-project may be
	 *            zipped e.g.: If your project was webdynp, zip
	 *            New_configuration
	 *            .jdi\LocalDevelopment\DCs\sap.com\webdyn\_comp\src (click zip
	 *            on the src folder so that the zip is next to the src folder! )
	 * @return The Eclipse project
	 */
	public static IProject createLocalMoinDCProjectDeletingLoadingData(String dcName, IComponentType dcType, InputStream is) {
		IProject project = getLocalMoinDCProject(dcName);
		if (project != null) {
			// TODO [Projects] switch to deletePartitions==false as soon as Dii
			// deletes via Eclipse resources and not io.File
			deleteLocalMoinDCProject(project, true);
		}
		project = createLocalMoinDCProject(dcName, dcType);

		if (is != null) {
			loadData(is, project);
		}

		return project;
	}

	/**
	 * Fills the content of the given stream into the given project, syncs Moin
	 * with the changed content.
	 *
	 * @param is
	 *            An InputStream containing the future content; the moin-content
	 *            can be exported using the (create model data function;
	 *            alternatively, the following folder in the DC-project may be
	 *            zipped e.g.: If your project was webdynp, zip
	 *            New_configuration
	 *            .jdi\LocalDevelopment\DCs\sap.com\webdyn\_comp\src (click zip
	 *            on the src folder so that the zip is next to the src folder! )
	 * @param project
	 *            the project to fill
	 */
	public static void loadData(InputStream is, IProject project) {
		String zipFilename = FileServices.getTempDir() + "moin_sample_data.zip"; //$NON-NLS-1$
		FileServices.streamToFile(FileServices.getTempDir() + "moin_sample_data.zip", is); //$NON-NLS-1$

		// unzip into the project directory:
		String targetDirectory = project.getLocation().toOSString();
		try {
			ZipService.unzipDir(zipFilename, targetDirectory);
			IStatus result = InvocationHelper.callModelManager_refreshFromFileSystem(project, null);
			if (!result.isOK()) {
				ExtendedTestCase.fail(new CoreException(result));
			}
		} catch (IOException e) {
			ExtendedTestCase.fail("ZIP File not present at " + String.valueOf(zipFilename), e); //$NON-NLS-1$
		}
	}

	/**
	 * Returns an existing project with this DC name (presuming data is valid),
	 * creates and populates it with data if not existing
	 *
	 * @param dcName
	 *            the name of the test DC
	 * @param contentStream
	 *            the Stream (must be a zip of the dc/src) folder
	 * @return the project
	 */
	public static IProject getExistingLocalMoinDCProjectCreating(String dcName, InputStream contentStream) {
		return getExistingLocalMoinDCProjectCreating(dcName, MoinTestDcType.getDcType(), contentStream);
	}

	/**
	 * Returns an existing project with this DC name (presuming data is valid),
	 * creates and populates it with data if not existing
	 *
	 * @param dcName
	 *            the name of the test DC
	 * @param dcType
	 *            the type of the DC. this information is only used fro creating
	 *            a new DC, if a DC with the given name is found the type is
	 *            ignored
	 * @param contentStream
	 *            the Stream (must be a zip of the dc/src) folder
	 * @return the project
	 */
	public static IProject getExistingLocalMoinDCProjectCreating(String dcName, IComponentType dcType, InputStream contentStream) {
		// only if project does not exist yet, we create and fill it
		// (to avoid doing this for each and every test)
		IProject lProject = TestUtil.getLocalMoinDCProject(dcName);
		if (lProject == null || !lProject.exists()) {
			if (contentStream != null) {
				lProject = createLocalMoinDCProjectDeletingLoadingData(dcName, dcType, contentStream);
			} else {
				lProject = createLocalMoinDCProject(dcName, dcType);
			}
		} else if (!lProject.isOpen()) {
			try {
				lProject.open(null);
			} catch (CoreException e) {
				ExtendedTestCase.fail("Error opening project " + lProject, e); //$NON-NLS-1$
			}
		}
		return lProject;
	}

	/**
	 * Deletes a given project including its DC definition. Partitions are
	 * deleted first so that the Moin DB gets aligned. Note that this requires
	 * some extra time and is not necessary if the <code>create</code> methods
	 * are directly invoked after the deletion like
	 * {@link #createLocalMoinDCProjectDeletingLoadingData(String, InputStream)}
	 * does. In this case consider using
	 * {@link #deleteLocalMoinDCProject(IProject, boolean)}.
	 *
	 * @param project
	 *            the project to delete
	 * @see #deleteLocalMoinDCProject(IProject, boolean)
	 */
	public static void deleteLocalMoinDCProject(IProject project) {
		deleteLocalMoinDCProject(project, true);
	}

	/**
	 * Deletes a given project including its DC definition
	 *
	 * @param project
	 *            the project to delete
	 * @param deletePartitions
	 *            if <code>true</code>, the partitions are deleted first so that
	 *            the Moin DB gets aligned. Note that this requires some extra
	 *            time and is not necessary if the <code>create</code> methods
	 *            are directly invoked after the deletion like
	 *            {@link #createLocalMoinDCProjectDeletingLoadingData(String, InputStream)}
	 *            does.
	 * @see #deleteLocalMoinDCProject(IProject)
	 * @see #deleteLocalMoinDc(IDevelopmentComponent, boolean, boolean)
	 */
	public static void deleteLocalMoinDCProject(IProject project, boolean deletePartitions) {
		if (deletePartitions) {
			deletePartitions(project, false);
		}

		try {
			MoinProject.deleteLocalDc(project, null);
		} catch (CoreException e) {
			TestServicePlugin.logError(e, sTracerProjects);
		}
	}

	/**
	 * Deletes a given DC and optionally its project
	 *
	 * @param dc
	 *            the DC to delete
	 * @param deleteProject
	 *            if <code>true</code>, the project gets deleted as well
	 * @param deletePartitions
	 *            if <code>true</code>, the partitions are deleted first so that
	 *            the Moin DB gets aligned. Note that this requires some extra
	 *            time and is not necessary if the <code>create</code> methods
	 *            are directly invoked after the deletion like
	 *            {@link #createLocalMoinDCProjectDeletingLoadingData(String, InputStream)}
	 *            does.
	 * @see #deleteLocalMoinDCProject(IProject)
	 */
	public static void deleteLocalMoinDc(IDevelopmentComponent dc, boolean deleteProject, boolean deletePartitions) {
		IProject project = DiiResourceService.getProject(dc);
		if (deletePartitions) {
			deletePartitions(project, false);
		}

		try {
			MoinProject.deleteLocalDc(dc, deleteProject, null);
		} catch (CoreException e) {
			TestServicePlugin.logError(e, sTracerProjects);
		}
	}

	/**
	 * Deletes all partitions in a project. Fails if this was not successful.
	 *
	 * @param project
	 *            the project whose partitions are to be deleted
	 * @param fail
	 *            of <code>true</code> any deletion failure leads to a test
	 *            failure, otherwise the issue is logged
	 */
	private static void deletePartitions(IProject project, boolean fail) {
		if (project != null && project.isAccessible()) {
			IStatus result = InvocationHelper.callPartitionService_deletePartitions(project, null);
			if (!result.isOK()) {
				if (fail) {
					ExtendedTestCase.fail(new CoreException(result));
				} else {
					TestServicePlugin.logStatus(result, sTracerProjects);
				}
			}
		}
	}

	/**
	 * Creates a DC project with a test DC type and a test nature. If the DC
	 * project already exists, this is a nop.
	 *
	 * @param dcName
	 *            the name of the DC. Note that this differs from the
	 *            corresponding project name.
	 * @return The Eclipse project
	 */
	public static IProject createLocalMoinDCProject(String dcName) {
		return createLocalMoinDCProject(dcName, MoinTestDcType.getDcType());
	}

	/**
	 * Creates a DC project with a given DC type. If the DC project already
	 * exists, this is a nop.
	 *
	 * @param dcName
	 *            the name of the DC. Note that this differs from the
	 *            corresponding project name.
	 * @param dcType
	 *            the type of the DC
	 * @return The Eclipse project
	 */
	public static IProject createLocalMoinDCProject(String dcName, IComponentType dcType) {
		try {
			IProject project = MoinProject.createLocalDc(dcName, null, dcType, null);
			return project;
		} catch (CoreException e) {
			// this is fatal
			ExtendedTestCase.fail(e);
			return null;
		}
	}

	/**
	 * Returns the project for the given DC name
	 *
	 * @param dcName
	 *            the name of the DC. Note that this differs from the
	 *            corresponding project name.
	 * @return the Eclipse project or <code>null</code>
	 */
	public static IProject getLocalMoinDCProject(String dcName) {
		return getLocalMoinDCProject(dcName, null);
	}

	/**
	 * Returns the project for the given DC name
	 *
	 * @param dcName
	 *            the name of the DC. Note that this differs from the
	 *            corresponding project name.
	 * @param vendor
	 *            the dc vendor or <code>null</code>
	 * @return the Eclipse project or <code>null</code>
	 */
	public static IProject getLocalMoinDCProject(String dcName, String vendor) {
		try {
			IDevelopmentComponent dc = MoinProject.getLocalDC(dcName, vendor);
			if (dc != null) {
				IProject project = DiiResourceService.getProject(dc);
				return project;
			}
		} catch (CoreException e) {
			// this is fatal
			ExtendedTestCase.fail(e);
		}
		return null;
	}

	/**
	 * Creates a DC of the given DC type without a project in the workspace
	 *
	 * @param dcName
	 *            the name of the DC
	 * @param dcType
	 *            the type of the DC
	 * @return the created DC
	 * @see #createLocalMoinDCProject(String, IComponentType)
	 */
	public static IDevelopmentComponent createLocalMoinDC(String dcName, IComponentType dcType) {
		try {
			IDevelopmentComponent dc = MoinProject.createLocalDc(dcName, null, dcType, new MoinDcOptions() {
				@Override
				public boolean createProject(IDevelopmentComponent dc) throws CoreException {
					return false;
				}
			}, null);
			return dc;
		} catch (CoreException e) {
			// this is fatal
			ExtendedTestCase.fail(e);
			return null;
		}
	}

	/**
	 * Creates a dependency from the given DC project to the given public part.
	 * Fails if this was not successful.
	 *
	 * @param project
	 *            the project to create the dependency from. Must be a DC
	 *            project.
	 * @param dcName
	 *            the name of the DC to create the dependency to
	 * @param dcVendor
	 *            the vendor of the DC to create the dependency to. Defaults to
	 *            <code>sap.com</code> if <code>null</code>.
	 * @param ppName
	 *            the name of the public part to create the dependency to
	 * @param buildtime
	 *            specifies whether it is a public part usage at buildtime
	 * @param runtime
	 *            specifies whether it is a public part usage at runtime
	 * @param deploytime
	 *            specifies whether it is a public part usage at deploytime
	 */
	public static void addPublicPartDependency(IProject project, String dcName, String dcVendor, String ppName, boolean buildtime,
			boolean runtime, boolean deploytime) {
		try {
			MoinProject.addPublicPartDependency(project, dcName, dcVendor, ppName, buildtime, runtime, deploytime, null);
		} catch (CoreException e) {
			ExtendedTestCase.fail(e);
		}
	}

	/**
	 * Clears the Moin database. Fails if this was not successful.
	 *
	 * @deprecated no-op since DB is no longer necessary
	 */
	@Deprecated
	public static void clearDb() {
	}

	/**
	 * Checks whether all given metamodels are imported (deployed). Fails if at
	 * least one is not.
	 *
	 * @param metamodelContainerNames
	 *            the id of the metamodels, e.g.
	 *            <code>sap.com/tc/moin/webdynpro/webdynpro</code>
	 */
	public static void assertMetamodelsImported(String... containerNames) {
		boolean imported = InvocationHelper.callMetamodelManager_isMetamodelImported(containerNames);
		if (imported) {
			return;
		}
		if (containerNames.length == 1) {
			Assert.fail("Metamodel '" + containerNames[0] + "' not imported"); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			Assert.fail("At least one of metamodels '" + Arrays.toString(containerNames) + "' is not imported"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * Scans the given suite and calls
	 * {@link DisposableTest#disposeTests(TestSuite)} on all such test. Called
	 * at most on suite tearDown to delete test projects.
	 *
	 * @see DisposingTestSuite
	 */
	@SuppressWarnings("unchecked")
	public static void disposeTests(TestSuite suite) {
		StringBuilder errors = new StringBuilder();
		Enumeration<Test> tests = suite.tests();
		dispose(tests, errors);
		if (errors.length() > 0) {
			Assert.fail(errors.toString());
		}
	}

	/**
	 * Creates a new connection. <b>The caller is resposible for its
	 * closing.</b> Fails if creation fails.
	 * <p>
	 * See ConnectionManager#createConnection(IProject)
	 *
	 * @param project
	 *            the project context of the connection
	 * @param testName
	 *            the name of the current test or <code>null</code>
	 * @return the new connection
	 *
	 */
	public static Connection createConnection(IProject project, String testName) {
		Connection connection = InvocationHelper.callConnectionManager_createConnection(project);
		if (testName != null) {
			String label = testName + " - " + connection.getLabel(); //$NON-NLS-1$
			connection.setLabel(label);
		}
		return connection;
	}

	/**
	 * Opens a model editor the same like
	 * {@link ModelEditorManager#openEditor(RefBaseObject, String, Runnable)}
	 * does, but waits until it is completely up. This is useful for tests
	 * launching editors that initialize their UI in a deferred way.
	 *
	 * @param object
	 *            the object to open the editor for
	 * @param editorId
	 *            the editor id or <code>null</code> for the default editor
	 * @return the created editor
	 *
	 * @see #openModelEditor(RefBaseObject, String, boolean)
	 */
	public static IEditorPart openModelEditor(RefBaseObject object, String editorId) {
		return openModelEditor(object, editorId, true);
	}

	/**
	 * Opens a model editor the same like
	 * {@link ModelEditorManager#openEditor(RefBaseObject, String, Runnable)}
	 * does, and, if required, waits until it is completely up. This is useful
	 * for tests launching editors that initialize their UI in a deferred way.
	 *
	 * @param object
	 *            the object to open the editor for
	 * @param editorId
	 *            the editor id or <code>null</code> for the default editor
	 * @param wait
	 *            if <code>true</code>, waits until the editor is completely
	 *            initialized
	 * @return the created editor
	 *
	 * @see #openModelEditor(RefBaseObject, String)
	 */
	public static IEditorPart openModelEditor(RefBaseObject object, String editorId, boolean wait) {
		try {
			// we use a dummy follow up action to find out when the
			// editor has finally finished
			final boolean[] editorFinished = { false };
			Runnable followUp = new Runnable() {
				public void run() {
					editorFinished[0] = true;
				}
			};

			IEditorPart editor = InvocationHelper.callModelEditorManager_openEditor(object, editorId, followUp);
			if (editor != null && wait) {
				// Wait for the followUp to finish doing readAndDispatch() in
				// between so that the deferred editor init can be processed.
				// This also includes a timeout so that we don't wait forever.
				Robot.wait(new Condition() {
					public boolean test() {
						return editorFinished[0];
					}
				}, 20000, 100);
			}
			return editor;
		} catch (PartInitException e) {
			ExtendedTestCase.fail(e);
			return null;
		}
	}

	/**
	 * Waits for the given {@link IModelEditor model editor} to have initialized
	 * completely. This is useful for tests launching editors that initialize
	 * their UI in a deferred way. If possible, however, use
	 * {@link #openModelEditor(RefBaseObject, String)}.
	 *
	 * @param part
	 *            the editor part. If this doesn't adapt to {@link IModelEditor}
	 *            this method is a nop.
	 *
	 * @see #openModelEditor(RefBaseObject, String)
	 * @deprecated no know use-case
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	public static void waitForModelEditor(IEditorPart part) {
		Class iModelEditorClass = InvocationHelper.getIModelEditorClass();
		final Object object = InvocationHelper.callModelAdapter_adaptObject(part, iModelEditorClass);
		if (object != null) {
			Robot.wait(new Condition() {
				public boolean test() {
					try {
						Method method = object.getClass().getMethod("isInitialized"); //$NON-NLS-1$
						return (Boolean) method.invoke(object);
					} catch (NoSuchMethodException e) {
						TestServicePlugin.logError(e, sTracerProjects);
						return false;
					} catch (InvocationTargetException e) {
						TestServicePlugin.logError(e, sTracerProjects);
						return false;
					} catch (IllegalAccessException e) {
						TestServicePlugin.logError(e, sTracerProjects);
						return false;
					}
				}
			}, 10000, 100);
		}
	}

	/**
	 * Does anything one could think about to prepare for UI tests like making
	 * the workbench the active window, closing the welcome page etc.
	 *
	 * @deprecated use {@link PDEUtil#prepareWorkbench()}
	 */
	@Deprecated
	public static void prepareWorkbench() {
		PDEUtil.prepareWorkbench();
	}

	/**
	 * Prints an indented info message including name of the method.
	 *
	 * @param test
	 *            the current test
	 * @param message
	 *            the message to print
	 */
	public static void printInfo(TestCase test, String message) {
		String msg = "          >(info)   [" + test.getName() + "]: " + message; //$NON-NLS-1$ //$NON-NLS-2$
		System.out.println(msg); // $JL-SYS_OUT_ERR$
	}

	@SuppressWarnings("unchecked")
	private static void dispose(Enumeration<Test> tests, StringBuilder errors) {
		while (tests.hasMoreElements()) {
			Test test = tests.nextElement();
			if (test instanceof TestSuite) {
				TestSuite suite = (TestSuite) test;
				dispose(suite.tests(), errors);
			} else if (test instanceof DisposableTest) {
				DisposableTest disposingTest = (DisposableTest) test;
				try {
					disposingTest.dispose();
				} catch (Exception e) {
					String error = exceptionToString(e);
					errors.append("\nFailure during disposal of test ").append(test.getClass().getName()).append(": ") //$NON-NLS-1$ //$NON-NLS-2$
							.append(error);
				}
			}
		}
	}

	/**
	 * Converts the stack trace into a string
	 *
	 * @return the trace as string
	 */
	public static String exceptionToString(Throwable t) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		return stringWriter.toString();
	}

	/**
	 * Asserts that two Strings are equal. In case they are not equal an
	 * <code>IllegalStateException</code> is thrown. This exception contains
	 * detailed information about the position of the difference within the
	 * string <code>expected</code>. The position is marked with a <b><pos></b>
	 * tag.
	 *
	 * @param message
	 *            the message added to the exception in case the strings are not
	 *            equal.
	 * @param expected
	 *            the expected string value.
	 * @param actual
	 *            the actual string value.
	 * @exception IllegalStateException
	 *                in case the strings are not equal. Additional detail
	 *                information is provided.
	 */
	public static void assertEqualsLongString(String message, String expected, String actual) {
		org.eclipse.core.runtime.Assert.isLegal(expected != null, "The string value 'expected' must not be null"); //$NON-NLS-1$
		org.eclipse.core.runtime.Assert.isLegal(actual != null, "The string value 'actual' must not be null"); //$NON-NLS-1$
		org.eclipse.core.runtime.Assert.isLegal(message != null, "The string value 'message' must not be null"); //$NON-NLS-1$

		if (expected == actual || expected.equals(actual)) {
			return;
		}

		// strings are not equal
		int lx = Math.min(expected.length(), actual.length());
		int i = 0;
		int line = 1;
		int column = 1;
		while (i < lx && expected.charAt(i) == actual.charAt(i)) {
			if (expected.charAt(i) == '\n') {
				line++;
				column = 1;
			} else {
				column++;
			}
			i++;
		}
		int safestart = Math.max(i - HEAD_LENGTH, 0);
		while (safestart > 0 && !Character.isWhitespace(expected.charAt(safestart))) {
			safestart--;
		}

		String head = ""; //$NON-NLS-1$
		if (i > 0) {
			head = expected.substring(safestart, i);
		}
		String tailActual = getTail(actual, i, TAIL_LENGTH);
		String tailExpected = getTail(expected, i, TAIL_LENGTH);

		StringBuffer errorMsg = new StringBuffer(1024);
		errorMsg.append(message);
		errorMsg.append(" <... difference at <pos> (line: "); //$NON-NLS-1$
		errorMsg.append(line);
		errorMsg.append(", column: "); //$NON-NLS-1$
		errorMsg.append(column);
		errorMsg.append(" ), expected "); //$NON-NLS-1$
		errorMsg.append(head);
		errorMsg.append(" <pos> "); //$NON-NLS-1$
		errorMsg.append(tailExpected);
		errorMsg.append(" ...>, but was <... "); //$NON-NLS-1$
		errorMsg.append(head);
		errorMsg.append(" <pos> "); //$NON-NLS-1$
		errorMsg.append(tailActual);
		errorMsg.append(" ...>"); //$NON-NLS-1$

		throw new IllegalStateException(errorMsg.toString());
	}

	/**
	 * Returns the {@link ClientSpec} for the given connection and Eclipse
	 * {@link IProject}. The returned client spec may then e.g. be used as
	 * parameter for the method
	 * {@link #isDcInitialized(ClientSpec, String, String)} to check the MOIN
	 * initialization state of a project within that {@link ClientSpec}.
	 *
	 * @param connection
	 *            The MOIN {@link Connection} to use.
	 * @param eclipseProject
	 *            An Eclipse {@link IProject} of a DC project that belongs to
	 *            the desired {@link ClientSpec}
	 * @return The {@link ClientSpec}
	 */
	public static ClientSpec getClientSpec(Connection connection, IProject eclipseProject) {
		IdeCompoundDataAreaManager cdam = (IdeCompoundDataAreaManager) connection.getSession().getMoin().getCompoundDataAreaManager();
		return cdam.getClientSpec(eclipseProject);
	}

	/**
	 * Checks if the development component given by the name and vendor is
	 * already initialized by MOIN. The check needs the {@link ClientSpec} of
	 * the DC in order to perform the check.
	 *
	 * @param clientSpec
	 *            The {@link ClientSpec} to use for the check. Can be retrieved
	 *            via the method {@link #getClientSpec(Connection, IProject)}.
	 * @param dcVendor
	 *            The vendor name of the DC
	 * @param dcName
	 *            The name of the DC
	 * @return
	 */
	public static boolean isDcInitialized(ClientSpec clientSpec, String dcVendor, String dcName) {
		Facility pf = clientSpec.getDataArea().getFacility();
		ResourceIdentifierFactory riFactory = pf.getRIFactory();
		CRI cri = riFactory.createCri(clientSpec.getDataArea().getName(), dcVendor + "/" + dcName); //$NON-NLS-1$

		IdeFacilityDispatcherInternal dispatcher = (IdeFacilityDispatcherInternal) MoinFactory.getMoinInstance()
				.getCompoundDataAreaManager();
		ContainerInitializationState initState = dispatcher.getContainerInitializationState(clientSpec, cri);
		return ContainerInitializationState.INITIALIZED.equals(initState);
	}

	private static String getTail(String s, int i, int len) {
		if (s == null) {
			return ""; //$NON-NLS-1$
		}
		if (i >= s.length()) {
			return ""; //$NON-NLS-1$
		}
		int tailsafe = Math.min(s.length(), i + len);
		while (tailsafe < s.length() && !Character.isWhitespace(s.charAt(tailsafe))) {
			tailsafe++;
		}
		return s.substring(i, tailsafe);
	}

	private TestUtil() {
	}

}
