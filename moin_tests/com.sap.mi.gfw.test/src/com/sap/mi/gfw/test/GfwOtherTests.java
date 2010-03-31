package com.sap.mi.gfw.test;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Ray;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import y.layout.Layouter;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.editor.ModelObjectElementFactory;
import com.sap.mi.gfw.GfwUtil;
import com.sap.mi.gfw.autolayout.AutoLayoutEngine;
import com.sap.mi.gfw.autolayout.DefaultLayoutStructureProvider;
import com.sap.mi.gfw.autolayout.DefaultLayouterFactory;
import com.sap.mi.gfw.command.CommandContainer;
import com.sap.mi.gfw.command.CommandExec;
import com.sap.mi.gfw.command.ICommand;
import com.sap.mi.gfw.dt.IDiagramType;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.internal.command.CreateModelObjectCommand;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditorFactory;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditorInput;
import com.sap.mi.gfw.eclipse.internal.figures.ColoredArea;
import com.sap.mi.gfw.eclipse.internal.figures.ColoredLocation;
import com.sap.mi.gfw.eclipse.internal.figures.GfwFigureUtil;
import com.sap.mi.gfw.eclipse.internal.figures.PredefinedColoredAreas;
import com.sap.mi.gfw.eclipse.internal.policy.ShapeXYLayoutEditPolicy;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.LineSeg;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.LineSeg.KeyPoint;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.LineSeg.Sign;
import com.sap.mi.gfw.eclipse.internal.util.gef.GEFUtil;
import com.sap.mi.gfw.eclipse.internal.util.ui.PopupMenu;
import com.sap.mi.gfw.eclipse.internal.util.ui.PopupMenu.CascadingMenu;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.CustomContext;
import com.sap.mi.gfw.features.context.impl.ReconnectionContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.custom.impl.AbstractDrillDownFeature;
import com.sap.mi.gfw.internal.util.LookManager;
import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.Font;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.MultiText;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.PictogramsPackage;
import com.sap.mi.gfw.mm.pictograms.Polyline;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.pattern.IFeatureProviderWithPatterns;
import com.sap.mi.gfw.pattern.IPattern;
import com.sap.mi.gfw.pattern.template.TemplatePattern;
import com.sap.mi.gfw.pattern.template.TemplatePatternFeatureProvider;
import com.sap.mi.gfw.platform.ColoredFont;
import com.sap.mi.gfw.platform.IGFWExtensionManager;
import com.sap.mi.gfw.samples.dt.IDiagramTypeConstants;
import com.sap.mi.gfw.samples.shared.autolayout.DefaultAutoLayoutPreferences;
import com.sap.mi.gfw.samples.shared.autolayout.DefaultAutoLayoutPreferencesHelper;
import com.sap.mi.gfw.samples.shared.autolayout.DefaultLayouterProvider;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.IColorConstant;
import com.sap.mi.gfw.util.IPredefinedRenderingStyle;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.LocationInfo;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;

/**
 * prerequisite for this test plugin:
 * <p>
 * - moin installation is available
 */
public class GfwOtherTests extends AbstractGfwTests {

	public GfwOtherTests() {
		super();
	}

	@Override
	protected void tearDown() throws Exception {
		closeAllEditors();
		super.tearDown();
	}

	public void testGfwExtensionManager() {
		IGFWExtensionManager em = GfwUtil.getExtensionManager();

		IDiagramType sketchDiagramType = null;

		// check whether the sketch diagram type is registered
		IDiagramType[] diagramTypes = em.getDiagramTypes();
		for (IDiagramType diagramType : diagramTypes) {
			if (IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH.equals(diagramType.getId())) {
				sketchDiagramType = diagramType;
				break;
			}
		}

		assertNotNull("sketch digram type is not available", sketchDiagramType);

		// checker whether a provider for the sketch diagram type is registered
		// - and if yes - instantiate a diagram
		// type provider
		if (sketchDiagramType != null) {
			String[] diagramTypeProviderExtensionIds = em.getDiagramTypeProviderExtensionIds(sketchDiagramType.getId());
			if (diagramTypeProviderExtensionIds != null && diagramTypeProviderExtensionIds.length > 0) {
				IDiagramTypeProvider dtp = em.createDiagramTypeProvider(diagramTypeProviderExtensionIds[0]);
				assertNotNull("sketch diagram type provider couldn't be instantiated", dtp);
			}
		}

	}

	public void testInstallation() throws Exception {

		assertNotNull("connection not available", getConnection());

		PictogramsPackage pictogramsPackage = getPictogramsPackage();
		assertNotNull("pictograms package not available", pictogramsPackage);
		ModelPackage modelPackage = getModelPackage();
		assertNotNull("model package not available", modelPackage);

		IGFWExtensionManager extensionManager = GfwUtil.getExtensionManager();
		assertNotNull("extension manager not available", extensionManager);

		String[] diagramTypeProviders = extensionManager.getDiagramTypeProviderExtensionIds(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);
		assertTrue("diagram type provider not available", diagramTypeProviders.length > 0);

		IDiagramTypeProvider dtp = extensionManager.createDiagramTypeProvider(diagramTypeProviders[0]);
		assertNotNull("diagram type provider couldn't be created", dtp);

		dtp.init(null, null);
		IFeatureProvider fp = dtp.getFeatureProvider();
		assertNotNull("feature provider not available", fp);
	}

	public void testOnMofDiagram() throws Exception {
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				IDiagramTypeProvider diagramTypeProvider = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = diagramTypeProvider.getFeatureProvider();
				Diagram currentDiagram = diagramTypeProvider.getDiagram();

				addClassToDiagram(fp, currentDiagram, 100, 100, "Connection");

				addClassToDiagram(fp, currentDiagram, 700, 200, "ConnectionDecorator");
				// check new model data in repository
				assertEquals("unexpected number of diagram children", 2, currentDiagram.getChildren().size());
				assertEquals("unexpected number of connections", 1, currentDiagram.getConnections().size());
				com.sap.mi.gfw.mm.pictograms.Connection c = (com.sap.mi.gfw.mm.pictograms.Connection) currentDiagram.getConnections()
						.toArray()[0];
				assertEquals("unexpected number of connection decorators", 9, c.getConnectionDecorators().size());

				waitForRefresh();

				doLayout(diagramTypeProvider, "Connection");
				waitForRefresh();

				// change GAs for connection decorator
				Collection<ConnectionDecorator> decorators = c.getConnectionDecorators();
				for (ConnectionDecorator decorator : decorators) {
					// we know, that initially the GA was a Polygon
					if (decorator.getGraphicsAlgorithm() instanceof com.sap.mi.gfw.mm.pictograms.Polygon) {
						com.sap.mi.gfw.mm.pictograms.Ellipse ellipse = GaUtil.createEllipse(decorator);
						GaUtil.setLocationAndSizeOfGraphicsAlgorithm(ellipse, 10, 10, 20, 30);
						doLayout(diagramTypeProvider, "Connection");
						waitForRefresh();
						GaUtil.createPolyline(decorator, new int[] { 0, 0, 10, 10, 10, 0, 0, 0 });
						doLayout(diagramTypeProvider, "Connection");
						waitForRefresh();
					}
				}

				// change background color of GA
				Shape shape = findShapeForMofClass(currentDiagram, "Connection");
				GaUtil.setRenderingStyle(shape.getGraphicsAlgorithm(), IPredefinedRenderingStyle.BLUE_WHITE_GLOSS_ID);
				doLayout(diagramTypeProvider, "Connection");
				waitForRefresh();

				diagramEditor.selectPictogramElements(new PictogramElement[] { shape });

				moveClassShape(fp, currentDiagram, 10, 30, "Connection");
				removeClassShape(fp, currentDiagram, "ConnectionDecorator");

			}

		});

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testComSapMiGfwPlatform() throws Exception {
		// test com.sap.mi.gfw.platform.ColoredFont
		Font font = createNiceMock(Font.class);
		replay(font);
		Color color = createNiceMock(Color.class);
		replay(color);

		// test ColoredFont(Font font, Color color)
		ColoredFont coloredFont = new ColoredFont(font, color);

		// test getFont()
		Font font2 = coloredFont.getFont();
		assertNotNull(font2);
		assertTrue(font.equals(font2));
		assertTrue(font == font2);

		// test setFont
		coloredFont.setFont(null);
		assertNull(coloredFont.getFont());

		// test getColor()
		Color color2 = coloredFont.getColor();
		assertNotNull(color2);
		assertTrue(color.equals(color2));
		assertTrue(color == color2);

		// test setColor()
		coloredFont.setColor(null);
		assertNull(coloredFont.getColor());
	}

	public void testUndoRedo() throws Exception {
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				IDiagramTypeProvider diagramTypeProvider = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = diagramTypeProvider.getFeatureProvider();
				Diagram diagram = diagramTypeProvider.getDiagram();

				addClassToDiagram(fp, diagram, 500, 500, "Shape");
				addClassToDiagram(fp, diagram, 100, 100, "ContainerShape");
				removeClassShape(fp, diagram, "ContainerShape");
				moveClassShape(fp, diagram, 0, 0, "Shape");

				// get UnDoStack
				Connection connection = ((Partitionable) diagram).get___Connection();
				com.sap.tc.moin.repository.commands.CommandStack cmdStack = connection.getCommandStack();

				// process "undo" until UnDoStack is empty
				while (cmdStack.canUndo()) {
					cmdStack.undo();
				}
				assertEquals("Undo/Redo failed: Diagram not empty at end of UndoStack", 0, diagram.getChildren().size());

				// process "redo" until ReDoStack is empty
				while (cmdStack.canRedo()) {
					cmdStack.redo();
				}
				assertShapeCoordinates(diagramTypeProvider, "Shape", 0, 0);

			}

		});

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testAbstractDrillDownFeature() throws Exception {
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
		Object rootModelObject = diagramEditor.getGraphicalViewer().getContents().getModel();
		assertTrue(rootModelObject instanceof Diagram);
		Diagram diagram = (Diagram) rootModelObject;

		IDiagramTypeProvider diagramTypeProvider = diagramEditor.getConfigurationProvider().getDiagramTypeProvider();
		IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = dtp.getFeatureProvider();

				int x = 50;
				CommandStack commandStack = diagramEditor.getEditDomain().getCommandStack();
				ICreateFeature[] createFeatures = fp.getCreateFeatures();
				for (ICreateFeature createFeature : createFeatures) {
					Rectangle rectangle = new Rectangle(x, 50, 100, 100);
					ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
					Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
							createContext, rectangle);
					commandStack.execute(createCommand);
					x += 150;
				}
			}
		});

		// test constructor
		AbstractDrillDownFeature drillDownFeature = new MyAbstractDrillDownFeature(featureProvider);

		// test AbstractDrillDownFeature.getName()
		String name = drillDownFeature.getName();
		assertNotNull(name);
		assertTrue(!"".equals(name));

		// test AbstractDrillDownFeature.canExecute()
		List<Shape> shapes = diagram.getChildren();
		Shape shape = shapes.iterator().next();
		assertNotNull("Diagram does not contain any shapes!", shape);

		ICustomContext customContextMock = createNiceMock(ICustomContext.class);
		expect(customContextMock.getPictogramElements()).andReturn(new PictogramElement[] { diagram }).once();
		expect(customContextMock.getPictogramElements()).andReturn(new PictogramElement[] { shape }).anyTimes();
		replay(customContextMock);

		drillDownFeature.canExecute((IContext) customContextMock);
		drillDownFeature.canExecute(customContextMock);
		verify(customContextMock);

		// test AbstractDrillDownFeature.execute()
		drillDownFeature.execute((IContext) customContextMock);
		drillDownFeature.execute(customContextMock);

		closeEditor(diagramEditor);
	}

	private class MyAbstractDrillDownFeature extends AbstractDrillDownFeature {
		MyAbstractDrillDownFeature(IFeatureProvider fp) {
			super(fp);
		}
	}

	public void testOnTestDiagram() throws Exception {
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_JUNIT);

		final IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				IFeatureProvider fp = dtp.getFeatureProvider();
				addEnumToDiagram(fp, dtp.getDiagram(), 100, 100, "LineStyle");

				int x = 50;
				CommandStack commandStack = diagramEditor.getEditDomain().getCommandStack();
				ICreateFeature[] createFeatures = fp.getCreateFeatures();
				for (ICreateFeature createFeature : createFeatures) {
					Rectangle rectangle = new Rectangle(x, 50, 100, 100);
					ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
					Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
							createContext, rectangle);
					commandStack.execute(createCommand);
					x += 150;
				}

			}

		});

		waitForRefresh();

		IFeatureProvider featureProvider = dtp.getFeatureProvider();
		if (featureProvider instanceof IFeatureProviderWithPatterns) {
			IFeatureProviderWithPatterns fpWithPatterns = (IFeatureProviderWithPatterns) featureProvider;
			Diagram diagram = dtp.getDiagram();
			Collection<PictogramElement> pes = PeUtil.getAllContainedPictogramElements(diagram);
			for (PictogramElement pe : pes) {
				IPattern patternForPictogramElement = fpWithPatterns.getPatternForPictogramElement(pe);
				if (patternForPictogramElement instanceof TemplatePattern) {
					TemplatePattern templatePattern = (TemplatePattern) patternForPictogramElement;
					templatePattern.update(new UpdateContext(pe));
					templatePattern.getDefaultLocationInfoForDirectEditing((Shape) pe, new LocationInfo((Shape) pe, pe
							.getGraphicsAlgorithm()));
				}
			}
		}

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testThumbnailView() throws Exception {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IWorkbench workbench = PlatformUI.getWorkbench();
				if (workbench != null) {
					IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
					if (activeWorkbenchWindow != null) {
						IWorkbenchPage page = activeWorkbenchWindow.getActivePage();
						if (page != null) {
							try {
								page.showView("com.sap.mi.gfw.eclipse.internal.editor.thumbnailview");
							} catch (PartInitException e) {
							}
						}
					}
				}
			}
		});
	}

	public void testOnSketchDiagram() throws Exception {
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = dtp.getFeatureProvider();

				int x = 50;
				CommandStack commandStack = diagramEditor.getEditDomain().getCommandStack();
				ICreateFeature[] createFeatures = fp.getCreateFeatures();
				for (ICreateFeature createFeature : createFeatures) {
					Rectangle rectangle = new Rectangle(x, 50, 100, 100);
					ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
					Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
							createContext, rectangle);
					commandStack.execute(createCommand);
					x -= 150;
				}

				GraphicalViewer viewer = diagramEditor.getGraphicalViewer();

				GEFUtil.findEditPartAt(viewer, new Point(75, 75), true);

				EditPart rootEditPart = viewer.getRootEditPart();
				if (rootEditPart instanceof ScalableFreeformRootEditPart) {
					ZoomManager zoomManager = ((ScalableFreeformRootEditPart) rootEditPart).getZoomManager();
					zoomManager.setZoom(0.5);
					getAbbotFactory().delay(500);
					zoomManager.setZoom(2.0);
					getAbbotFactory().delay(500);
				}

				EditPart diagramEditPart = (EditPart) rootEditPart.getChildren().get(0);
				List<EditPart> children = diagramEditPart.getChildren();
				EditPart tmp = null;
				for (EditPart child : children) {
					Object modelElement = child.getModel();

					// test GEFUtil
					GEFUtil.getLayoutConstraint(child);
					GEFUtil.selectEditPart(viewer, modelElement);
					GEFUtil.selectEditPart(viewer, null);
					assertTrue((new Point(0, 0)).equals(GEFUtil.calculateTranslation(child, child)));
					if (tmp != null) {
						GEFUtil.calculateTranslation(child, tmp);
					}
					tmp = child;
					// end of test GEFUtil
				}

				GEFUtil.dumpEditPartTree(diagramEditPart);
			}
		});

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testCommandContainer() throws Exception {
		CommandContainer container = new CommandContainer(null);

		assertTrue(container.canExecute());
		container.getFeatureProvider(); // assertNotNull(container.getFeatureProvider());
		assertNotNull(container.getCommands());
		assertFalse(container.containsCommands());
		assertNotNull(container.getDescription());
		container.add(new ICommand() {
			public boolean canExecute() {
				return false;
			}

			public boolean canUndo() {
				return false;
			}

			public boolean execute() {
				return false;
			}

			public IFeatureProvider getFeatureProvider() {
				return null;
			}

			public boolean undo() {
				return false;
			}

			public String getDescription() {
				return new String("Test Description");
			}
		});

	}

	public void testDraw2d() throws Exception {
		Point origin = new Point(0, 0);
		Point term = new Point(7, 7);
		Point test = new Point(2, 3);

		LineSeg lineSeg = new LineSeg(origin, term);
		lineSeg.containsPoint(test, 0);
		lineSeg.distanceAlong(test);
		lineSeg.distanceToPoint(4, 5);
		lineSeg.equals(lineSeg);
		lineSeg.getEquation();
		lineSeg.getInfimum();

		Rectangle ellipseBounds = new Rectangle(origin, term);
		lineSeg.getLineIntersectionsWithEllipse(ellipseBounds);
		PointList pointList = new PointList();
		pointList.addPoint(origin);
		pointList.addPoint(term);
		lineSeg.getLineIntersectionsWithLineSegs(pointList);
		lineSeg.getLinesIntersections(lineSeg);
		lineSeg.getOrigin();
		lineSeg.getParallelLineSegThroughPoint(test);
		lineSeg.getSupremum();
		lineSeg.getTerminus();
		lineSeg.getTrigValues(new Ray(origin, test));
		lineSeg.intersect(lineSeg, 0);
		lineSeg.isHorizontal();
		lineSeg.isVertical();
		lineSeg.length();
		lineSeg.locatePoint(0.5D, 0, Sign.POSITIVE);
		lineSeg.performScale(2D);
		lineSeg.perpIntersect(3, 7);
		lineSeg.perpSlope();
		lineSeg.pointOn(-1L, KeyPoint.ORIGIN, new Point());
		lineSeg.positionRelativeTo(test);
		lineSeg.projection(5, 5);
		lineSeg.setOrigin(origin);
		lineSeg.setTerminus(term);
		lineSeg.slope();
		LineSeg.getLineEquation(0D, 0D, -3.5D, 7.5D);
		lineSeg.performTranslate(10, 10);

	}

	private void doLayout(IDiagramTypeProvider diagramTypeProvider, String className) {
		Layouter layouter = DefaultLayouterFactory.getHierarchicalGroupLayouter();
		Shape shape = findShapeForMofClass(diagramTypeProvider.getDiagram(), className);
		DefaultLayoutStructureProvider dlsp = new DefaultLayoutStructureProvider(shape.getContainer());
		dlsp.getChildren(shape.getGraphicsAlgorithm().getPictogramElement());
		dlsp.getOutgoingConnections(shape.getGraphicsAlgorithm().getPictogramElement());
		AutoLayoutEngine.autoLayout(layouter, diagramTypeProvider.getFeatureProvider(), dlsp);

		/**/
		layouter = new DefaultLayouterProvider().getLayouter();
		DefaultAutoLayoutPreferences defaultAutoLayoutPreferences = new DefaultAutoLayoutPreferences();
		defaultAutoLayoutPreferences.copyValuesInto(defaultAutoLayoutPreferences);
		defaultAutoLayoutPreferences.setDefaults();

		/**/
		DefaultAutoLayoutPreferencesHelper defaultAutoLayoutPreferencesHelper = new DefaultAutoLayoutPreferencesHelper();
		defaultAutoLayoutPreferencesHelper.savePreferences(defaultAutoLayoutPreferences);
		defaultAutoLayoutPreferencesHelper.loadPreferences(defaultAutoLayoutPreferences);

		// M2MLayouter.recalculateLayout(diagramTypeProvider.getDiagram());
	}

	private void removeClassShape(IFeatureProvider fp, Diagram diagram, String className) {

		Shape shape = findShapeForMofClass(diagram, className);

		RemoveContext removeContext = new RemoveContext(shape);

		// remove the shape
		IRemoveFeature removeFeature = fp.getRemoveFeature(removeContext);
		assertNotNull("remove feature not available", removeFeature);

		if (removeFeature.canRemove(removeContext)) {
			CommandExec.executeFeatureWithContext(removeFeature, removeContext);
		}
	}

	private void assertShapeCoordinates(IDiagramTypeProvider diagramTypeProvider, String className, int x, int y) {
		Shape shape = findShapeForMofClass(diagramTypeProvider.getDiagram(), className);
		assertEquals("Undo/Redo failed: wrong X coordinate for " + className, x, shape.getGraphicsAlgorithm().getX());
		assertEquals("Undo/Redo failed: wrong Y coordinate " + className, y, shape.getGraphicsAlgorithm().getY());
	}

	public void testGaUtil() throws Exception {
		Diagram diagram = createDiagram("test_gautil");
		ContainerShape cs1 = PeUtil.createContainerShape(diagram, true);
		Shape shape1 = PeUtil.createShape(cs1, true);
		MultiText multiText1 = GaUtil.createMultiText(shape1);
		MultiText multiText2 = GaUtil.createMultiText(shape1, "GaUtil");
		GaUtil.createText(shape1);
		GaUtil.createText(shape1, "GaUtil");
		GaUtil.ignoreAll(multiText1);
		GaUtil.findStyle(diagram, "s");
		GaUtil.createStyle(diagram, "s");
		GaUtil.findStyle(diagram, "s");
		GaUtil.createShiftedColor(IColorConstant.BLUE, 5);
		GaUtil.deleteFont(multiText2);
	}

	public void testUtils() throws Exception {
		Diagram diagram = createDiagram("test_peutil");
		ContainerShape cs1 = PeUtil.createContainerShape(diagram, true);
		ContainerShape cs2 = PeUtil.createContainerShape(diagram, true);
		Shape shape1 = PeUtil.createShape(cs1, true);
		Anchor anchor1 = PeUtil.createFixPointAnchor(cs1);
		Anchor anchor2 = PeUtil.createFixPointAnchor(cs2);
		FreeFormConnection freeFormConnection = PeUtil.createFreeFormConnection(diagram);
		ConnectionDecorator connectionDecorator = PeUtil.createConnectionDecorator(freeFormConnection, true, 0.5, true);

		RefObject[] ro = new RefObject[] { shape1, cs1 };
		PeUtil.getLinkedPictogramElements(ro, diagram);
		PeUtil.getElementsNotInDiagram(ro, diagram);
		PeUtil.getPictogramElementChildren(cs1);
		PeUtil.getPictogramElementParent(freeFormConnection);
		PeUtil.getPictogramElementParent(anchor1);
		PeUtil.getPictogramElementParent(connectionDecorator);
		PeUtil.getDiagramForPictogramElement(cs1);
		PeUtil.getDiagramForPictogramElement(diagram);
		PeUtil.getDiagramForPictogramElement(anchor2);
		PeUtil.getDiagramForPictogramElement(freeFormConnection);
		PeUtil.getDiagramForAnchor(anchor1);
		PeUtil.getDiagramForShape(cs1);
		PeUtil.getAllContainedPictogramElements(diagram);
		PeUtil.getChopboxAnchor(diagram);
		PeUtil.createFixPointAnchor(diagram);
		PeUtil.getConnectionMidpoint(freeFormConnection, 0.5);
		PeUtil.getActiveContainerPe(shape1);
		PeUtil.removeProperty(cs1, "mc");

		LinkUtil.assignToDiagram(diagram, cs1);
		LinkUtil.getDiagramLink(diagram, false);
		List<RefObject> list = new ArrayList<RefObject>();
		list.add(cs1);
		list.add(cs2);
		LinkUtil.getPictogramElements(diagram, list, false);
		LinkUtil.setIndependentProperty(shape1, "prop_val");
		LinkUtil.getIndependentProperty(shape1);
		LinkUtil.hasIndependentProperty(shape1, "prop_val");

		LookManager.getLook();
		LookManager.setDynamicLook(true);
		LookManager.setDynamicLook(false);

		GEFUtil.dumpPictogramModelTree(diagram);
		com.sap.mi.gfw.mm.pictograms.Rectangle rectangle = GaUtil.createRectangle(diagram);
		GaUtil.createDefaultText(rectangle);
		GEFUtil.dumpGATree(rectangle);
		Ellipse ellipse = new Ellipse();
		ellipse.add(new Ellipse());
		ellipse.add(new Polygon());
		GEFUtil.dumpFigureTree(ellipse);
	}

	public void testTemplatePattern() {
		Diagram diagram = createDiagram("test_peutil");
		ContainerShape cs1 = PeUtil.createContainerShape(diagram, true);

		TemplatePatternFeatureProvider templatePatternFeatureProvider = new TemplatePatternFeatureProvider(null);
		MofClass findMofClass = findMofClass("ContainerShape");
		templatePatternFeatureProvider.getPatternForDomainObject(findMofClass);
		templatePatternFeatureProvider.getPatternsForDomainObject(findMofClass);
		templatePatternFeatureProvider.getCustomFeatures(new CustomContext(new PictogramElement[] { cs1 }));
		templatePatternFeatureProvider.getReconnectionFeature(new ReconnectionContext(null, null, null));
		templatePatternFeatureProvider.getUpdateFeature(new UpdateContext(cs1));
	}

	public void testGfwFigureUtil() {
		Image image = new Image(Display.getCurrent(), 22, 22);
		GC gc = new GC(image);
		SWTGraphics graphics = new SWTGraphics(gc);
		double zoom = 1;
		Rectangle rectangle = new Rectangle(1, 2, 3, 4);
		ColoredLocation start = new ColoredLocation("D4E7F8", 0, ColoredLocation.LOCATION_TYPE_ABSOLUTE_START);
		ColoredLocation end = new ColoredLocation("FAFBFC", 0, ColoredLocation.LOCATION_TYPE_ABSOLUTE_END);
		ColoredArea coloredArea = new ColoredArea(start, end);
		GfwFigureUtil.paintColorFlow(rectangle, graphics, coloredArea, zoom, true);
		GfwFigureUtil.paintColorFlow(rectangle, graphics, coloredArea, zoom, false);

		Diagram diagram = createDiagram("test_peutil");
		ContainerShape cs1 = PeUtil.createContainerShape(diagram, true);
		int[] intArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		Polyline polyline = GaUtil.createPolyline(cs1, intArray);
		PointList pointList = GfwFigureUtil.getPointList(polyline);
		int[] resultIntArray = pointList.toIntArray();
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], resultIntArray[i]);
		}
	}

	public void testPopupMenu() {
		List content = new ArrayList();
		content.add("One");
		content.add("Two");
		ILabelProvider labelProvider = new LabelProvider();
		List subContent = new ArrayList();
		subContent.add("More1");
		subContent.add("More2");
		subContent.add("More3");
		PopupMenu subMenu = new PopupMenu(subContent, labelProvider);
		content.add(new CascadingMenu("More than two", subMenu));
		content.add("Three");
		final PopupMenu popupMenu = new PopupMenu(content, labelProvider);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				// Shell activeShell = Display.getCurrent().getActiveShell();
				// popupMenu.show(activeShell);
			}
		});

		assertNull(popupMenu.getResult());
	}

	public void testPredefinedColoredAreas() {
		String[] ids = PredefinedColoredAreas.ALL_IDS;
		for (String id : ids) {
			PredefinedColoredAreas.getColoredAreas(id, PredefinedColoredAreas.STYLE_ADAPTATION_DEFAULT);
			PredefinedColoredAreas.getColoredAreas(id, PredefinedColoredAreas.STYLE_ADAPTATION_PRIMARY_SELECTED);
			PredefinedColoredAreas.getColoredAreas(id, PredefinedColoredAreas.STYLE_ADAPTATION_SECONDARY_SELECTED);
		}
	}

	public void testCreateDiagramInputViaFactory() {
		{
			IMemento memento = createNiceMock(IMemento.class);
			replay(memento);
			IAdaptable element = new DiagramEditorFactory().createElement(memento);
			assertNull(element);
		}
		{
			IMemento memento = createNiceMock(IMemento.class);
			expect(memento.getString(ModelObjectElementFactory.KEY_MRI)).andStubReturn("myMRI");
			replay(memento);
			IAdaptable element = new DiagramEditorFactory().createElement(memento);
			assertNull(element);
		}
		{
			IMemento memento = createNiceMock(IMemento.class);
			expect(memento.getString(ModelObjectElementFactory.KEY_MRI)).andStubReturn("myMRI");
			expect(memento.getString(DiagramEditorInput.KEY_PROVIDER_ID)).andStubReturn("myProviderId");
			expect(memento.getString(ModelObjectElementFactory.KEY_PROJECTNAME)).andStubReturn("myProject");
			replay(memento);
			IAdaptable element = new DiagramEditorFactory().createElement(memento);
			assertNotNull(element);
			assertTrue(element instanceof DiagramEditorInput);
		}
	}

	public void testOpenDiagramFromFile() throws Exception {
		int editorCount = 0;
		closeAllEditors();

		IFile diagFile1 = createPersistentDiagram();
		IFile diagFile2 = createPersistentDiagram();

		// open editor on first diagram file
		editorCount = openDiagramEditorFromFile(diagFile1);
		assertEquals("One editor must have opened for " + diagFile1, 1, editorCount);

		// open same file again
		editorCount = openDiagramEditorFromFile(diagFile1);
		assertEquals("No new editor must have opened for " + diagFile1, 1, editorCount);

		{
			// This is mainly for test coverage: DiagramEditorFactory creates a
			// default connection if it's not there. Close it now so that this
			// path can be covered.
			Connection defaultConnection = ConnectionManager.getInstance().getExistingDefaultConnection(getProject());
			if (defaultConnection != null) {
				defaultConnection.close();
			}
		}

		// open editor on second file
		editorCount = openDiagramEditorFromFile(diagFile2);
		assertEquals("One editor must have opened for " + diagFile2, 2, editorCount);

		// open first file again
		editorCount = openDiagramEditorFromFile(diagFile1);
		assertEquals("No new editor must have opened for " + diagFile1, 2, editorCount);
	}

	public void testOpenDiagramFromObject() throws Exception {
		int editorCount = 0;
		closeAllEditors();

		Diagram[] diagram = new Diagram[1];
		createPersistentDiagram(diagram);
		Diagram diagram1 = diagram[0];
		createPersistentDiagram(diagram);
		Diagram diagram2 = diagram[0];

		// open editor on first diagram
		editorCount = openDiagramEditorFromObject(diagram1);
		assertEquals("One editor must have opened for " + diagram1, 1, editorCount);

		// open same diagram again
		editorCount = openDiagramEditorFromObject(diagram1);
		assertEquals("No new editor must have opened for " + diagram1, 1, editorCount);

		// open editor on second diagram
		editorCount = openDiagramEditorFromObject(diagram2);
		assertEquals("One editor must have opened for " + diagram2, 2, editorCount);

		// open first diagram again
		editorCount = openDiagramEditorFromObject(diagram1);
		assertEquals("No new editor must have opened for " + diagram1, 2, editorCount);
	}

	private IFile createPersistentDiagram() throws Exception {
		return createPersistentDiagram(null);
	}

	private IFile createPersistentDiagram(Diagram[] diagram) throws Exception {
		Diagram d = createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF, "diagram");
		assertNotNull(d);
		if (diagram != null) {
			diagram[0] = d;
		}
		d.get___Connection().save();
		IFile diagFile = ModelAdapter.getInstance().getFile(d);
		assertNotNull(diagFile);
		return diagFile;
	}

	private int openDiagramEditorFromFile(final IFile diagFile) {
		final int[] editorCount = new int[1];
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IEditorPart ed = IDE.openEditor(page, diagFile);
					assertTrue("Editor must be a diagram editor: " + ed, ed instanceof DiagramEditor);
				} catch (PartInitException e) {
					fail(e);
				}
				editorCount[0] = page.getEditorReferences().length;
			}
		});
		return editorCount[0];
	}

	private int openDiagramEditorFromObject(final Diagram diagram) {
		final int[] editorCount = new int[1];
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IEditorInput input = ModelEditorManager.getInstance().getEditorInput(diagram);
					IEditorPart ed = IDE.openEditor(page, input, "com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor");
					assertTrue("Editor must be a diagram editor: " + ed, ed instanceof DiagramEditor);
				} catch (PartInitException e) {
					fail(e);
				}
				editorCount[0] = page.getEditorReferences().length;
			}
		});
		return editorCount[0];
	}

}
