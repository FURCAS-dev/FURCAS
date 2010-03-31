package com.sap.mi.fwk.ui.test;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementContainer;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests {@link com.sap.mi.fwk.ui.internal.ModelEditorLauncher}
 * 
 * @author d024127
 */
public class ModelEditorLauncherTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/modeleditor/launcher";

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/me/launcher");

	private Connection connection;

	private IFile partitionFile;

	private View view1;

	private View view2;

	private LFactory mAbbotFactory;

	private LShell mShell;

	private IWorkbenchPage page;

	public ModelEditorLauncherTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		PDEUtil.prepareWorkbench();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);
		mShell = mAbbotFactory.getShell(Display.getDefault());

		connection = createConnection();

		PRI pri = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition = connection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage(CONTAINER_NAME_WEBDYNPRO, PACKAGE_NAME_COMPONENT);
		Component component = (Component) compPackage.getComponent().refCreateInstance( );
		component.setName("testComponent");
		partition.assignElement((Partitionable) component);

		// Two Views
		RefClass viewClass = compPackage.getView().getView();
		view1 = (View) viewClass.refCreateInstance( );
		view1.setName("testView1");
		component.getViews().add(view1);

		ViewPackage viewPackage = (ViewPackage) view1.refClass().refImmediatePackage();
		UielementContainer container = (UielementContainer) viewPackage.getUielement().getTransparentContainer().refCreateInstance( );
		container.setName("RootElement");
		view1.setRootUielementContainer(container);

		view2 = (View) viewClass.refCreateInstance( );
		view2.setName("testView2");
		component.getViews().add(view2);

		container = (UielementContainer) viewPackage.getUielement().getTransparentContainer().refCreateInstance( );
		container.setName("RootElement");
		view2.setRootUielementContainer(container);

		ModelManager.getConnectionManager().save(connection);

		// retrieve file after connection.save() because file may not be there
		// before
		partitionFile = ModelAdapter.getInstance().getFile(pri);
		// clean all markers before next test
		if (partitionFile != null && partitionFile.exists())
			partitionFile.deleteMarkers(null, true, IResource.DEPTH_INFINITE);

	}

	@Override
	protected void tearDown() throws Exception {
		// final IWorkbenchPage page =
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		// final IWorkbenchPage page = this.ö
		final IEditorPart[] parts = findModelEditors(page);
		if (parts.length > 0) {
			mShell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					for (IEditorPart part : parts) {
						if (part != null) {
							page.closeEditor(part, false);
						}
					}
					return null;
				}
			});

			IEditorPart[] parts2 = findModelEditors(page);
			int count = 0;
			while (parts2.length != 0 && count < 10) {
				mAbbotFactory.delay(300);
				parts2 = findModelEditors(page);
				count++;
			}
		}

		connection = null;
		partitionFile = null;

		super.tearDown();
	}

	public void testStartEditor() throws Exception {
		final IMarker marker1 = ModelManager.getMarkerManager().createMarker(view1, IMarker.PROBLEM, IMarker.SEVERITY_ERROR, "message");
		final IMarker marker2 = ModelManager.getMarkerManager().createMarker(view2, IMarker.PROBLEM, IMarker.SEVERITY_ERROR, "message");
		IMarker probe = partitionFile.findMarker(marker1.getId());
		assertNotNull(probe);
		probe = partitionFile.findMarker(marker2.getId());
		assertNotNull(probe);

		LRunnable<IWorkbenchPage> op = new LRunnable<IWorkbenchPage>() {
			public IWorkbenchPage run() throws Exception {
				final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

				// Intentionally issue navigation twice. Only one editor must
				// open.
				IDE.openEditor(page, marker1);
				IDE.openEditor(page, marker1);

				// Intentionally issue navigation twice. Only one editor must
				// open.
				IDE.openEditor(page, marker2);
				IDE.openEditor(page, marker2);
				return page;
			}
		};

		LShell shell = mAbbotFactory.getShell(Display.getDefault());
		page = shell.syncExec(op);

		IEditorPart[] parts = findModelEditors(page);
		int count = 0;
		while (parts.length != 2 && count < 10) {
			mAbbotFactory.delay(300);
			parts = findModelEditors(page);
			count++;
		}

		assertEquals("Exactly two editors must be open for view1 and view2", 2, parts.length);
		assertFalse("Editors must be different for view1 and view2", parts[0].equals(parts[1]));
	}

	private IEditorPart[] findModelEditors(IWorkbenchPage page) {

		Set<IEditorPart> result = new HashSet<IEditorPart>();
		IEditorReference[] references = page.getEditorReferences();
		for (IEditorReference reference : references) {
			try {
				if (reference.getEditorInput() instanceof ModelEditorInput) {
					RefBaseObject obj = ((ModelEditorInput) reference.getEditorInput()).getRefObject();
					if (view1.equals(obj) || view2.equals(obj)) {
						result.add(reference.getEditor(false));
					}
				}
			} catch (PartInitException e) {
				fail(e);
			}
		}
		return result.toArray(new IEditorPart[result.size()]);
	}
}