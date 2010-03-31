package com.sap.mi.tools.metamodelbuilder.test;

import java.io.InputStream;
import java.util.HashMap;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISources;

import abbot.script.Condition;
import abbot.swt.eclipse.fixture.JavaProjectCreator;
import abbot.tester.swt.Robot;

import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTable;
import com.sap.ide.junit.ui.lift.LTableItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.projectselection.ProjectSelectionDialog;
import com.sap.mi.tools.mmbuilder.AddNatureHandler;
import com.sap.mi.tools.mmbuilder.internal.ConvertXMIHandler;
import com.sap.mi.tools.mmbuilder.internal.MetamodelBuildNature;
import com.sap.mi.tools.mmbuilder.internal.MetamodelBuilder;
import com.sap.mi.tools.mmbuilder.internal.RemoveNatureHandler;
import com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelDcType;

public class MetamodelBuilderTest extends ExtendedTestCase {

	private static final String PROJECT_NAME = "MetamodelBuilderTestWrapper"; //$NON-NLS-1$
	private static final String DC_NAME = MetamodelBuilderTest.class.getName();

	// Use a new DC for each test method to avoid problems with re-creating
	// deleted DCs (timing issues because of asynchronous deletion notification
	// inside DII)
	private static int mDCNameIndex = 0;
	private String mDcName = null;

	private IProject wrapperPluginProject;
	private IProject metaModelDCProject;
	private Display display;
	private LShell mShell;
	private LFactory mAbbotFactory;
	private IJavaProject javaProject;

	private static final String PLUGIN_NATURE_ID = "org.eclipse.pde.PluginNature";

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);
		display = Display.getDefault();
		mShell = mAbbotFactory.getShell(display);

		// create wrapper plugin
		wrapperPluginProject = ResourcesPlugin.getWorkspace().getRoot().getProject(PROJECT_NAME);
		if (wrapperPluginProject.exists()) {
			wrapperPluginProject.delete(true, null);
		}

		JavaProjectCreator jpc = new JavaProjectCreator();
		jpc.createNewJavaProject(PROJECT_NAME);
		addPluginNature(wrapperPluginProject);

		javaProject = JavaCore.create(wrapperPluginProject);
		javaProject.open(null);
		javaProject.setRawClasspath(new IClasspathEntry[0], null);

		// if( !wrapperPluginProject.isAccessible()) {
		// wrapperPluginProject.open(null);
		// }

		// Create new DC name (other name for each test method)
		mDcName = DC_NAME + mDCNameIndex;
		mDCNameIndex++;

		// create metamodel dc
		InputStream data = MetamodelBuilderTest.class.getResourceAsStream("mof_ui_used.zap");
		metaModelDCProject = TestUtil.createLocalMoinDCProjectDeletingLoadingData(mDcName, MoinMetaModelDcType
				.getDcType(), data);
	}

	public void testAddRemoveNature() {

		assertTrue("Wrapper plugin is not open", wrapperPluginProject.isAccessible());
		assertTrue("Metamodel DC project is not open", metaModelDCProject.isAccessible());

		try {
			assertTrue(wrapperPluginProject.hasNature(PLUGIN_NATURE_ID));
		} catch (CoreException e) {
			fail(e);
		}

		ISelection sel = new StructuredSelection(wrapperPluginProject);
		IEvaluationContext context = new EvaluationContext(null, sel);
		context.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME, sel);
		context.addVariable(ISources.ACTIVE_SHELL_NAME, mShell.getWidget());
		final ExecutionEvent event = new ExecutionEvent(null, new HashMap<Object, Object>(), this, context);

		final AbstractHandler addHandler = new AddNatureHandler();
		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				addHandler.execute(event);
				return null;
			}
		};

		try {
			mShell.asyncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		try {
			LShell dialogShell = waitForDialog(mShell, ProjectSelectionDialog.SHELL_PROJECT_SELECTION_DIALOG);
			LTable table = dialogShell.table().withName(ProjectSelectionDialog.SHELL_PROJECT_SELECTION_DIALOG_LIST);
			LTableItem markerItem = table.tableItem().withText("/.*" + mDcName + ".*/").resolve();
			mShell.clickOn(markerItem);

			if (!dialogShell.isDisposed()) {
				pressOk(dialogShell);
			}
		} catch (Exception e) {
			fail(e);
		}

		Robot.wait(new Condition() {
			public boolean test() {
				return MetamodelBuildNature.hasMetamodelBuilderNature(wrapperPluginProject);
			}
		}, 6000);
		assertTrue(MetamodelBuildNature.hasMetamodelBuilderNature(wrapperPluginProject));

		// assertTrue(MetamodelBuildNature.isMetaModelBuildProject(
		// wrapperPluginProject));

		final AbstractHandler convertHandler = new ConvertXMIHandler();
		display.syncExec(new Runnable() {
			public void run() {
				try {
					convertHandler.execute(event);
				} catch (ExecutionException e1) {

				}
			}
		});

		final AbstractHandler removeHandler = new RemoveNatureHandler();
		display.syncExec(new Runnable() {
			public void run() {
				try {
					removeHandler.execute(event);
					assertFalse(MetamodelBuildNature.hasMetamodelBuilderNature(wrapperPluginProject));
				} catch (ExecutionException e1) {
					fail(e1);
				}
			}
		});
	}

	public void testMetamodelBuilder() throws CoreException {
		AddNatureHandler handler = new AddNatureHandler();
		handler.addNature(wrapperPluginProject, metaModelDCProject, null);
		runNonPublicMethod(MetamodelBuilder.class, null, "getMetamodelProperties", new Class[] { IProject.class },
				new Object[] { wrapperPluginProject });
		runNonPublicMethod(MetamodelBuilder.class, null, "getMetamodelPartitionFiles", new Class[] { IProject.class },
				new Object[] { wrapperPluginProject });
		runNonPublicMethod(MetamodelBuilder.class, null, "getMetamodelPartitionIFiles", new Class[] { IProject.class },
				new Object[] { wrapperPluginProject });

		MetamodelBuilder mmb = new MetamodelBuilder();
		boolean[] flags = (boolean[]) runNonPublicMethod(MetamodelBuilder.class, mmb, "getAdditionalFlags",
				new Class[] { IProject.class }, new Object[] { wrapperPluginProject });
		assertEquals("ignoreChecks default must be true", true, flags[0]);
		assertEquals("generateMof default must be false", false, flags[1]);

		runNonPublicMethod(MetamodelBuilder.class, mmb, "getJaproDcBuildProperties", new Class[] { IProject.class },
				new Object[] { wrapperPluginProject });
	}

	@Override
	protected void tearDown() throws Exception {
		if (metaModelDCProject != null) {
			metaModelDCProject.delete(true, null);
		}
		if (wrapperPluginProject != null) {
			wrapperPluginProject.delete(true, null);
		}
		super.tearDown();
	}

	public void testClean() throws Exception {
		PDEUtil.setAutoBuilding(false);

		assertTrue("Wrapper plugin is not open", wrapperPluginProject.isAccessible());
		assertTrue("Metamodel DC project is not open", metaModelDCProject.isAccessible());

		MetamodelBuilder builder = new MetamodelBuilder();

		runNonPublicMethod(builder, "setProject", new Class[] { IProject.class }, new Object[] { wrapperPluginProject });
		runNonPublicMethod(builder, "clean", new Class[] { IProgressMonitor.class }, new Object[] { null });
	}

	public void testBuild() throws Exception {
		PDEUtil.setAutoBuilding(false);

		assertTrue("Wrapper plugin is not open", wrapperPluginProject.isAccessible());
		assertTrue("Metamodel DC project is not open", metaModelDCProject.isAccessible());

		MetamodelBuilder builder = new MetamodelBuilder();

		AddNatureHandler handler = new AddNatureHandler();
		handler.addNature(wrapperPluginProject, metaModelDCProject, null);

		runNonPublicMethod(builder, "setProject", new Class[] { IProject.class }, new Object[] { wrapperPluginProject });
		runNonPublicMethod(builder, "fullBuild", new Class[] { IProgressMonitor.class }, new Object[] { null });
		// PDEUtil.setAutoBuilding(buildState);
	}

	// public void testAugmentManifest() throws CoreException, IOException {
	// IFolder folder = wrapperPluginProject.getFolder("META-INF");
	// if (!folder.exists()) {
	// folder.create(true, true, null);
	// }
	//
	// IFile manifestFile = folder.getFile("MANIFEST.MF");
	// if (manifestFile.exists()) {
	// manifestFile.delete(true, null);
	// }
	// InputStream is = this.getClass().getResourceAsStream("MANIFEST.MF.test");
	// manifestFile.create(is, true, null);
	// is.close();
	//
	// IFolder srcFolder = wrapperPluginProject.getFolder("src");
	// if (!srcFolder.exists()) {
	// srcFolder.create(true, true, null);
	// }
	// IFolder comFolder = srcFolder.getFolder("com");
	// if (!comFolder.exists()) {
	// comFolder.create(true, true, null);
	// }
	//
	// IFolder excludeFolder = srcFolder.getFolder("exclude");
	// if (!excludeFolder.exists()) {
	// excludeFolder.create(true, true, null);
	// }
	//
	// ByteArrayInputStream bais = new
	// ByteArrayInputStream("something".getBytes());
	// comFolder.getFile("test.java").create(bais, true, null);
	//
	// final Set<IClasspathEntry> classpathEntriesSet = new
	// HashSet<IClasspathEntry>();
	// classpathEntriesSet.add(JavaCore.newSourceEntry(srcFolder.getFullPath(),
	// new IPath[] { new Path("exclude/") }));
	// classpathEntriesSet.add(JavaCore.newSourceEntry(excludeFolder.getFullPath()));
	// javaProject.setRawClasspath(classpathEntriesSet.toArray(new
	// IClasspathEntry[classpathEntriesSet.size()]), null);
	//
	// MetamodelBuilder mb = new MetamodelBuilder();
	// runNonPublicMethod(mb, "augmentManifest", new Class[] { IProject.class,
	// IProgressMonitor.class }, new Object[] {
	// wrapperPluginProject, null });
	//
	// InputStream manifestIs = new
	// FileInputStream(manifestFile.getRawLocation().toOSString());
	// Manifest manifest = new Manifest(manifestIs);
	// manifestIs.close();
	// String entryString =
	// manifest.getMainAttributes().getValue(Constants.EXPORT_PACKAGE);
	// assertEquals("Entry must be 'com'", "com", entryString);
	// }

	private void addPluginNature(IProject project) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 1, natures.length);
		newNatures[0] = PLUGIN_NATURE_ID;
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
	}

	private LShell waitForDialog(LShell parent, String name) throws WidgetException {
		LShell dialogShell = parent.waitForShowing(parent.childShell().withName(name));
		assertNotNull("No Dialog shell found", dialogShell);
		return dialogShell;
	}

	private void pressOk(LShell dialog) throws Exception {
		LButton button = dialog.button().ok();
		assertNotNull("No Ok button found", button);
		dialog.clickOn(button);
		dialog.waitForClosed();
	}
}