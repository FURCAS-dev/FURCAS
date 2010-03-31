package com.sap.mi.gfw.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.eclipse.core.runtime.IPath;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.gfw.GfwUtil;
import com.sap.mi.gfw.command.CommandExec;
import com.sap.mi.gfw.eclipse.GraphicsPlugin;
import com.sap.mi.gfw.eclipse.internal.GfwEclipseConstants;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.features.IAddFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.features.context.impl.AreaContext;
import com.sap.mi.gfw.features.context.impl.MoveShapeContext;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramsPackage;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.samples.dt.mof.MofService;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PackageUtil;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;

abstract class AbstractGfwTests extends ProjectBasedTest {
	class DiagramEditorHolder {
		DiagramEditor diagramEditor;

		public DiagramEditor getDiagramEditor() {
			return diagramEditor;
		}

		public void setDiagramEditor(DiagramEditor diagramEditor) {
			this.diagramEditor = diagramEditor;
		}
	}

	private LFactory abbotFactory;

	private Connection connection;

	private LShell lShell;

	protected static final String VIEW_REGEXP = "/^[\\*]?test_diagram_.+$/";

	public AbstractGfwTests() {
		super();
		setName(getClass().getName());
	}

	private String createDiagramName() {

		List<String> currentDiagramNames = new ArrayList<String>();
		Collection<Diagram> diagramCollection = MoinHelper.refAllOfClass(getPictogramsPackage().getDiagram());
		// Collection<Diagram> diagramCollection =
		// getPictogramsPackage().getDiagram().refAllOfClass();
		for (Diagram diagram : diagramCollection) {
			currentDiagramNames.add(diagram.getName());
		}

		int i = 0;
		String diagramName;

		do {
			diagramName = ITestConstants.TEST_DIAGRAM_PREFIX + i++;
		} while (currentDiagramNames.contains(diagramName));

		return diagramName;
	}

	protected void addClassToDiagram(IFeatureProvider fp, Diagram diagram, int x, int y, String className) {

		// create add context
		AreaContext areaContext = new AreaContext();
		areaContext.setLocation(x, y);
		AddContext addContext = new AddContext(areaContext, findMofClass(className));
		addContext.setTargetContainer(diagram);

		// get add class feature
		IAddFeature feature = fp.getAddFeature(addContext);
		assertNotNull("add class feature not available", feature);

		if (feature.canAdd(addContext)) {
			CommandExec.executeFeatureWithContext(feature, addContext);
		}
	}

	protected void addEnumToDiagram(IFeatureProvider fp, Diagram diagram, int x, int y, String enumName) {

		// create add context
		AreaContext areaContext = new AreaContext();
		areaContext.setLocation(x, y);
		AddContext addContext = new AddContext(areaContext, findEnumerationClass(enumName));
		addContext.setTargetContainer(diagram);

		// get add class feature
		IAddFeature addFeature = fp.getAddFeature(addContext);
		assertNotNull("add class feature not available", addFeature);

		if (addFeature.canAdd(addContext)) {
			addFeature.add(addContext);
		}
	}

	protected void closeConnection() {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

	protected void closeEditor(final DiagramEditor diagramEditor) {

		if (diagramEditor == null) {
			return;
		}

		final IWorkbenchPage workbenchPage = diagramEditor.getEditorSite().getPage();

		if (Display.getCurrent() == null) {

			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					if (diagramEditor != null) {
						workbenchPage.closeEditor(diagramEditor, false);
					}
				}
			});
		} else {
			workbenchPage.closeEditor(diagramEditor, false);
		}
	}

	protected void closeAllEditors() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				page.closeAllEditors(false);
			}
		});
	}

	protected Diagram createDiagram(String diagramTypeId) {
		return createDiagram(diagramTypeId, "xmi");
	}

	protected Diagram createDiagram(String diagramTypeId, String partitionExtension) {
		Diagram ret = null;

		String diagramName = createDiagramName();

		// ret = PeUtil.createDiagram(getConnection(), diagramTypeId,
		// diagramName, 10, true);
		ret = PeUtil.createDiagram(getConnection(), diagramTypeId, diagramName, true);
		IPath partitionTailName = SOURCE_FOLDER.append("diagrams");
		if (diagramName != null) { // append to Tail;
			partitionTailName = partitionTailName.append(diagramName);
		}

		IPath path = getProject().getProjectRelativePath().append(partitionTailName).addFileExtension(partitionExtension);
		PartitionService.getInstance().createPartition(getConnection(), getProject(), path, ret);

		return ret;
	}

	protected EnumerationType findEnumerationClass(String enumName) {
		Collection<EnumerationType> classes = MoinHelper.refAllOfType(getModelPackage().getEnumerationType());
		// Collection<MofClass> classes =
		// getModelPackage().getMofClass().refAllOfType();
		for (EnumerationType class1 : classes) {
			List<String> names = class1.getQualifiedName();
			if (names.size() > 0 && "pictograms".equals(names.get(0)) && enumName.equals(class1.getName())) {
				return class1;
			}
		}
		return null;
	}

	// private IWorkbenchWindow getActiveOrFirstWorkbenchWindow() {
	// IWorkbenchWindow result =
	// PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	// if (result == null) {
	// IWorkbenchWindow[] windows =
	// PlatformUI.getWorkbench().getWorkbenchWindows();
	// if (windows != null && windows.length > 0) {
	// result = windows[0];
	// }
	// }
	// return result;
	// }

	protected MofClass findMofClass(String className) {
		Collection<MofClass> classes = MoinHelper.refAllOfType(getModelPackage().getMofClass());
		// Collection<MofClass> classes =
		// getModelPackage().getMofClass().refAllOfType();
		for (MofClass class1 : classes) {
			List<String> names = class1.getQualifiedName();
			if (names.size() > 0 && "pictograms".equals(names.get(0)) && className.equals(class1.getName())) {
				return class1;
			}
		}
		return null;
	}

	protected Shape findShapeForMofClass(Diagram diagram, String className) {
		Object[] allShapes = PeUtil.getAllContainedShapes(diagram).toArray();
		Shape shape = null;
		for (int i = 0; i < allShapes.length; i++) {
			shape = (Shape) allShapes[i];
			if (shape instanceof ContainerShape) {
				Object bo = LinkUtil.getBusinessObjectForLinkedPictogramElement(shape);
				if (bo instanceof MofClass) {
					String boName = ((MofClass) bo).getName();
					if (boName.equals(className)) {
						return shape;
					}
				}
			}
		}
		return null;
	}

	/**
	 * @return the abbotFactory
	 */
	protected final LFactory getAbbotFactory() {
		return abbotFactory;
	}

	protected Connection getConnection() {
		if (connection == null) {
			connection = createConnection();
		}

		return connection;
	}

	@Override
	protected String getDcName() {
		return ITestConstants.DC_NAME;
	}

	/**
	 * @return the lShell
	 */
	protected final LShell getLShell() {
		return lShell;
	}

	protected ModelPackage getModelPackage() {
		ModelPackage modelPackage = MofService.getModelPackage(getConnection());
		return modelPackage;
	}

	protected PictogramsPackage getPictogramsPackage() {
		return PackageUtil.getPictogramsPackage(getConnection());
	}

	protected void initConnection() {
		connection = createConnection();
	}

	protected void moveClassShape(IFeatureProvider fp, Diagram diagram, int x, int y, String className) {

		Shape shape = findShapeForMofClass(diagram, className);

		MoveShapeContext moveShapeContext = new MoveShapeContext(shape);

		moveShapeContext.setSourceContainer(shape.getContainer());
		moveShapeContext.setTargetContainer(shape.getContainer());
		moveShapeContext.setLocation(x, y);
		moveShapeContext.setDeltaX(x - shape.getGraphicsAlgorithm().getX());
		moveShapeContext.setDeltaY(y - shape.getGraphicsAlgorithm().getY());

		IMoveShapeFeature moveShapeFeature = fp.getMoveShapeFeature(moveShapeContext);
		assertNotNull("move shape feature not available", moveShapeFeature);

		if (moveShapeFeature.canMoveShape(moveShapeContext)) {
			CommandExec.executeFeatureWithContext(moveShapeFeature, moveShapeContext);
		}
	}

	protected DiagramEditor openDiagram(final String type) {
		final DiagramEditorHolder deh = new DiagramEditorHolder();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				/**/
				final Diagram newDiagram = createDiagram(type);
				assertTrue("create diagram does not work", newDiagram != null);

				assertConnectionSave(getConnection());

				// use TestUtil to open editor since this waits for late
				// initialization
				DiagramEditor diagramEditor = (DiagramEditor) TestUtil.openModelEditor(newDiagram, null);
				deh.setDiagramEditor(diagramEditor);
			}
		});
		return deh.getDiagramEditor();
	}

	@Override
	protected void setUp() throws Exception {
		T.racer().setInfoAlwaysTrue(true); // tracing enabled for testing

		PDEUtil.prepareWorkbench();
		super.setUp();

		abbotFactory = FactoryBuilder.newAbbotFactory();
		abbotFactory.setWaitTimeout(10000);
		initConnection();
		lShell = abbotFactory.getShell(Display.getDefault());

		GraphicsPlugin.getDefault();

		openGfwTestPerspective();
	}

	private void openGfwTestPerspective() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IWorkbench workbench = PlatformUI.getWorkbench();
				if (workbench != null) {
					IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
					if (activeWorkbenchWindow != null) {
						try {
							workbench.showPerspective("com.sap.mi.gfw.test.GfwTestPerspective", activeWorkbenchWindow);
						} catch (WorkbenchException e) {
							throw new RuntimeException("Can not open perspective " + e.getMessage(), e);
						}
					}
				}
			}
		});
	}

	@Override
	protected void tearDown() throws Exception {
		closeConnection();

		super.tearDown();
	}

	protected void waitForRefresh() {
		try {
			PDEUtil.safeJoinJobManager(5000, GfwEclipseConstants.UIJOB_FAMILY_REFRESH);
			System.out.println(".waitOnRefresh(): refresh done");
		} catch (InterruptedException ie) {
			System.out.println(".waitOnRefresh(): catching InterruptedException");
			// Either: the refresh job hasn't started or has already finished
			// or ran into the timeout: continue anyway
		}
	}

	@Override
	protected String[] getMetamodels() {
		return new String[] { GfwUtil.METAMODEL_ID };
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return false;
	}

	protected void activateDefaultTool(EditDomain editDomain) {
		editDomain.setActiveTool(editDomain.getDefaultTool());
	}

	protected void activateTool(EditDomain editDomain, String toolName) {
		PaletteRoot paletteRoot = editDomain.getPaletteViewer().getPaletteRoot();
		Tool tool = getTool(paletteRoot, toolName);
		if (tool == null) {
			throw new RuntimeException("Tool '" + toolName + "' does not exist");
		}
		editDomain.setActiveTool(tool);
	}

	protected Tool getTool(PaletteContainer paletteContainer, String toolName) {
		List children = paletteContainer.getChildren();
		if (children != null) {
			for (Object child : children) {
				if (child instanceof ToolEntry) {
					ToolEntry toolEntry = (ToolEntry) child;
					if (toolEntry.getLabel().equals(toolName)) {
						return toolEntry.createTool();
					}
				}
				if (child instanceof PaletteContainer) {
					Tool tool = getTool((PaletteContainer) child, toolName);
					if (tool != null) {
						return tool;
					}
				}
			}
		}
		return null;
	}
}
