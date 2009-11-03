package com.sap.mi.gfw.test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.gfw.GfwUtil;
import com.sap.mi.gfw.command.CommandContainer;
import com.sap.mi.gfw.command.DirectEditingFeatureCommandWithContext;
import com.sap.mi.gfw.command.ICommand;
import com.sap.mi.gfw.command.MoveShapeFeatureCommandWithContext;
import com.sap.mi.gfw.command.ResizeShapeFeatureCommandWithContext;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.datatypes.IInsets;
import com.sap.mi.gfw.datatypes.ILocation;
import com.sap.mi.gfw.datatypes.IRectangle;
import com.sap.mi.gfw.datatypes.impl.DimensionImpl;
import com.sap.mi.gfw.datatypes.impl.InsetsImpl;
import com.sap.mi.gfw.datatypes.impl.LocationImpl;
import com.sap.mi.gfw.datatypes.impl.RectangleImpl;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.GraphicsPlugin;
import com.sap.mi.gfw.eclipse.internal.ImagePool;
import com.sap.mi.gfw.eclipse.internal.command.AddModelObjectCommand;
import com.sap.mi.gfw.eclipse.internal.command.ContextEntryCommand;
import com.sap.mi.gfw.eclipse.internal.command.CreateModelObjectCommand;
import com.sap.mi.gfw.eclipse.internal.command.GFWCommand;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.editor.GfwMarqueeSelectionTool;
import com.sap.mi.gfw.eclipse.internal.parts.directedit.IDirectEditHolder;
import com.sap.mi.gfw.eclipse.internal.requests.ContextButtonDragRequest;
import com.sap.mi.gfw.eclipse.internal.requests.GfwDirectEditRequest;
import com.sap.mi.gfw.eclipse.internal.util.DataTypeTransformation;
import com.sap.mi.gfw.eclipse.internal.util.ui.UIUtil;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.context.IAreaContext;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.impl.AddBendpointContext;
import com.sap.mi.gfw.features.context.impl.AddConnectionContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.features.context.impl.AreaAnchorContext;
import com.sap.mi.gfw.features.context.impl.AreaContext;
import com.sap.mi.gfw.features.context.impl.CreateConnectionContext;
import com.sap.mi.gfw.features.context.impl.CreateContext;
import com.sap.mi.gfw.features.context.impl.CustomContext;
import com.sap.mi.gfw.features.context.impl.DirectEditingContext;
import com.sap.mi.gfw.features.context.impl.LayoutContext;
import com.sap.mi.gfw.features.context.impl.LocationContext;
import com.sap.mi.gfw.features.context.impl.MoveBendpointContext;
import com.sap.mi.gfw.features.context.impl.MoveConnectionDecoratorContext;
import com.sap.mi.gfw.features.context.impl.MoveContext;
import com.sap.mi.gfw.features.context.impl.MoveShapeContext;
import com.sap.mi.gfw.features.context.impl.PrintContext;
import com.sap.mi.gfw.features.context.impl.ReconnectionContext;
import com.sap.mi.gfw.features.context.impl.RemoveBendpointContext;
import com.sap.mi.gfw.features.context.impl.ResizeContext;
import com.sap.mi.gfw.features.context.impl.ResizeShapeContext;
import com.sap.mi.gfw.features.context.impl.SaveImageContext;
import com.sap.mi.gfw.features.context.impl.SplitConnectionContext;
import com.sap.mi.gfw.internal.ExternalPictogramLink;
import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.mapping.data.ImageDataMapping;
import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.links.DiagramLink;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.AbstractText;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.Font;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Image;
import com.sap.mi.gfw.mm.pictograms.LineStyle;
import com.sap.mi.gfw.mm.pictograms.LineStyleEnum;
import com.sap.mi.gfw.mm.pictograms.Orientation;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.PlatformGraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.mm.pictograms.RenderingStyle;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.mm.pictograms.Style;
import com.sap.mi.gfw.notification.AbstractNotificationService;
import com.sap.mi.gfw.notification.MoinNotificationService;
import com.sap.mi.gfw.platform.IPlatformImageConstants;
import com.sap.mi.gfw.platform.ga.RendererContext;
import com.sap.mi.gfw.samples.dt.IDiagramTypeConstants;
import com.sap.mi.gfw.tb.ContextButtonEntry;
import com.sap.mi.gfw.tb.ContextEntryHelper;
import com.sap.mi.gfw.tb.ContextMenuEntry;
import com.sap.mi.gfw.tb.DynamicContextMenuEntry;
import com.sap.mi.gfw.tb.IContextEntry;
import com.sap.mi.gfw.tb.ImageRenderingDecorator;
import com.sap.mi.gfw.util.LocationInfo;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;

public class GfwPackageTests extends AbstractGfwTests {
	private static final String DUMMY = "dummy";

	public GfwPackageTests() {
		super();
	}

	public void testPackageCocSapMiGfwEclipseInternalRequests() throws Exception {
		// test com.sap.mi.gfw.eclipse.internal.requests.GfwDirectEditRequest
		GfwDirectEditRequest myGfwDirectEditRequest = new GfwDirectEditRequest();

		IDirectEditHolder directEditHolderMock = createNiceMock(IDirectEditHolder.class);
		replay(directEditHolderMock);

		myGfwDirectEditRequest.setDirectEditingContext(directEditHolderMock);

		IDirectEditHolder directEditHolder = myGfwDirectEditRequest.getDirectEditHolder();
		assertEquals(directEditHolderMock, directEditHolder);

		// test
		// com.sap.mi.gfw.eclipse.internal.requests.ContextButtonDragRequest
		ContextButtonDragRequest myContextButtonDragRequest = new ContextButtonDragRequest();

		ContextButtonEntry contextButtonEntry = new ContextButtonEntry(createMock(IFeature.class), createMock(IContext.class));
		contextButtonEntry.addDragAndDropFeature(null);
		contextButtonEntry.getDragAndDropFeatures();
		contextButtonEntry.addContextButtonMenuEntry(contextButtonEntry);
		contextButtonEntry.getContextButtonMenuEntries();

		myContextButtonDragRequest.setContextButtonEntry(contextButtonEntry);

		ContextButtonEntry contextButtonEntry2 = myContextButtonDragRequest.getContextButtonEntry();
		assertEquals(contextButtonEntry, contextButtonEntry2);
	}

	public void testPackageComSapMiGfwCommand() throws Exception {
		// test com.sap.mi.gfw.command.CommandWrapper
		ICommand commandMock = createNiceMock(ICommand.class);
		replay(commandMock);

		Connection connectionMock = createNiceMock(Connection.class);
		replay(connectionMock);

		// #########################################################

		// test com.sap.mi.gfw.command.MoveShapeFeatureCommandWithContext
		IMoveShapeFeature moveShapeFeatureMock = createNiceMock(IMoveShapeFeature.class);
		replay(moveShapeFeatureMock);

		// IMoveShapeContext moveShapeContextMock =
		// createNiceMock(IMoveShapeContext.class);
		// expect(moveShapeContextMock.get)
		// replay(moveShapeContextMock);
		Shape shapeMock = createNiceMock(Shape.class);
		replay(shapeMock);

		MoveShapeContext moveShapeContext = new MoveShapeContext(shapeMock);
		moveShapeContext.setLocation(10, 10);
		moveShapeContext.getShape();
		moveShapeContext.getTargetConnection();
		moveShapeContext.getPictogramElement();
		moveShapeContext.getDeltaX();
		moveShapeContext.getDeltaY();
		moveShapeContext.getSourceContainer();
		moveShapeContext.getTargetConnection();
		moveShapeContext.getTargetContainer();
		moveShapeContext.getX();
		moveShapeContext.getY();

		MoveShapeFeatureCommandWithContext myMoveShapeFeatureCommandWithContext = new MoveShapeFeatureCommandWithContext(
				moveShapeFeatureMock, moveShapeContext);

		myMoveShapeFeatureCommandWithContext.canExecute();
		myMoveShapeFeatureCommandWithContext.execute();

		// #########################################################

		// testcom.sap.mi.gfw.command.CommandContainer
		IFeatureProvider featureProviderMock = createNiceMock(IFeatureProvider.class);
		replay(featureProviderMock);

		commandMock = createNiceMock(ICommand.class);
		replay(commandMock);

		CommandContainer myCommandContainer = new CommandContainer(featureProviderMock);

		myCommandContainer.add(myMoveShapeFeatureCommandWithContext);
		myCommandContainer.add(commandMock);

		myCommandContainer.getCommands();
		myCommandContainer.getDescription();
		myCommandContainer.getFeatureProvider();
		assertTrue(myCommandContainer.containsCommands());
		myCommandContainer.canExecute();
		myCommandContainer.undo();
		myCommandContainer.execute();
		myCommandContainer.undo();

		// #########################################################

		// testcom.sap.mi.gfw.command.ResizeShapeFeatureCommandWithContext
		IResizeShapeContext resizeShapeContextMock = createNiceMock(IResizeShapeContext.class);
		replay(resizeShapeContextMock);

		IFeature featureMock = createNiceMock(IResizeShapeFeature.class);
		replay(featureMock);

		ResizeShapeFeatureCommandWithContext myResizeShapeFeatureCommandWithContext = new ResizeShapeFeatureCommandWithContext(featureMock,
				resizeShapeContextMock);

		myResizeShapeFeatureCommandWithContext.canExecute();
		myResizeShapeFeatureCommandWithContext.execute();

		// #########################################################

		// testcom.sap.mi.gfw.command.DirectEditingFeatureCommandWithContext
		IDirectEditingContext directEditingContextMock = createNiceMock(IDirectEditingContext.class);
		replay(directEditingContextMock);

		IDirectEditingFeature directEditingFeatureMock = createNiceMock(IDirectEditingFeature.class);
		replay(directEditingFeatureMock);

		DirectEditingFeatureCommandWithContext myDirectEditingFeatureCommandWithContext = new DirectEditingFeatureCommandWithContext(
				directEditingFeatureMock, directEditingContextMock, new String("Value"));

		myDirectEditingFeatureCommandWithContext.execute();
	}

	public void testPackageComSapMiGfwDatatypesImpl() throws Exception {
		// test InsetImpl
		final int LEFT = 1;
		final int RIGHT = 2;
		final int TOP = 3;
		final int BOTTOM = 4;

		InsetsImpl myInsetsImpl = new InsetsImpl(LEFT, RIGHT, TOP, BOTTOM);

		assertEquals(BOTTOM, myInsetsImpl.getBottom());

		assertEquals(LEFT, myInsetsImpl.getLeft());

		assertEquals(RIGHT, myInsetsImpl.getRight());

		assertEquals(TOP, myInsetsImpl.getTop());

		// #########################################################

		// test DimensionImpl
		final int WIDTH = 30;
		final int HEIGHT = 20;
		final int WIDTH_DIFF = 10;
		final int HEIGHT_DIFF = 5;
		final int WIDTH_2 = WIDTH + WIDTH_DIFF;
		final int HEIGHT_2 = HEIGHT + HEIGHT_DIFF;

		DimensionImpl d1 = new DimensionImpl(WIDTH, HEIGHT);
		assertEquals(WIDTH, d1.getWidth());
		assertEquals(HEIGHT, d1.getHeight());

		d1.hashCode();

		DimensionImpl d2 = new DimensionImpl(d1);
		assertEquals(WIDTH, d2.getWidth());
		assertEquals(HEIGHT, d2.getHeight());

		d2.scale(2);
		assertEquals(2 * WIDTH, d2.getWidth());
		assertEquals(2 * HEIGHT, d2.getHeight());

		d2.setDimension(WIDTH, HEIGHT);
		assertEquals(WIDTH, d2.getWidth());
		assertEquals(HEIGHT, d2.getHeight());

		d2.expand(WIDTH_DIFF, HEIGHT_DIFF);
		assertEquals(WIDTH_2, d2.getWidth());
		assertEquals(HEIGHT_2, d2.getHeight());

		d2.setDimension(d1);
		assertEquals(WIDTH, d2.getWidth());
		assertEquals(HEIGHT, d2.getHeight());

		IDimension d3 = d1.getDimensionCopy();
		assertTrue(d1.equals(d1));
		assertTrue(d1.equals(d3));
		assertFalse(d1.equals(DUMMY));

		// #########################################################

		// test LocationImpl
		final int X = 15;
		final int Y = 25;
		final int DX = 5;
		final int DY = 10;
		final int X2 = X + DX;
		final int Y2 = Y + DY;

		LocationImpl l1 = new LocationImpl(X, Y);
		assertEquals(X, l1.getX());
		assertEquals(Y, l1.getY());

		l1.hashCode();
		l1.toString();

		LocationImpl l2 = new LocationImpl(l1);
		assertEquals(X, l2.getX());
		assertEquals(Y, l2.getY());

		l2.scale(2);
		assertEquals(2 * X, l2.getX());
		assertEquals(2 * Y, l2.getY());

		l2.setLocation(X, Y);
		assertEquals(X, l2.getX());
		assertEquals(Y, l2.getY());

		l2.translate(DX, DY);
		assertEquals(X2, l2.getX());
		assertEquals(Y2, l2.getY());

		l2.setLocation(l1);
		assertEquals(X, l2.getX());
		assertEquals(Y, l2.getY());

		ILocation l3 = l1.getLocationCopy();
		assertTrue(l1.equals(l1));
		assertTrue(l1.equals(l3));
		assertFalse(l1.equals(DUMMY));

		// #########################################################

		// test LocationImpl
		RectangleImpl r1 = new RectangleImpl(WIDTH, HEIGHT);
		// RectangleImpl r2 = new RectangleImpl(r1);

		r1.hashCode();
		r1.toString();

		r1.contains(l3);

		r1.expand(WIDTH_DIFF, HEIGHT_DIFF);
		r1.scale(2);
		r1.translate(DX, DY);

		IDimension d4 = r1.getDimensionCopy();
		ILocation l4 = r1.getLocationCopy();
		IRectangle r2 = r1.getRectangleCopy();

		r1.setDimension(d4);
		r1.setDimension(WIDTH, HEIGHT);

		r1.setLocation(l4);
		r1.setLocation(0, 0);

		r1.setRectangle(r2);

		assertTrue(r1.equals(r1));
		assertTrue(r1.equals(r2));
		assertFalse(r1.equals(DUMMY));
	}

	public void testPackageComSapMiGfw() throws Exception {
		String[] providerIds = GfwUtil.getExtensionManager().getDiagramTypeProviderExtensionIds(
				IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
		assertTrue("no dtp for sketch diagram type available", providerIds.length > 0);
		if (providerIds.length > 0) {
			IDiagramTypeProvider dtp = GfwUtil.createDiagramTypeProvider(null, providerIds[0]);
			assertNotNull("dtp couldn't be instantiated", dtp);
		}
	}

	@SuppressWarnings("deprecation")
	public void testPackageComSapMiGfwTb() throws Exception {

		// ContextButtonEntry and ContextEntryHelper
		ContextButtonEntry cbe = new ContextButtonEntry(null, null);
		ContextEntryHelper.markAsUpdateContextEntry(cbe);
		ContextEntryHelper.markAsCollapseContextEntry(cbe, true);
		ContextEntryHelper.markAsCollapseContextEntry(cbe, false);
		ContextEntryHelper.createCollapseContextButton(false, null, null);

		new ContextButtonEntry(null, null, 0);
		new ContextButtonEntry(null, null, 0, 0);

		// ImageRenderingDecorator
		final int X = 10;
		final int Y = 20;

		ImageRenderingDecorator rd = new ImageRenderingDecorator(IPlatformImageConstants.IMG_ECLIPSE_ERROR);
		rd.setX(X);
		rd.setY(Y);
		rd.setMessage(DUMMY);

		rd.getX();
		rd.getY();
		rd.getMessage();
		rd.getImageId();

		// DynamicContextMenuEntry
		DynamicContextMenuEntry cme = new DynamicContextMenuEntry(null, null);
		cme.setText(DUMMY);
		cme.setMinimumSubmenuEntries(5);
		cme.add(new ContextMenuEntry(null, null));
		assertFalse(cme.isSubmenu());
	}

	public void testPackageComSapMiGfwEclipse() throws Exception {
		String id = GraphicsPlugin.DIAGRAM_EDITOR_ID;
		assertNotNull(id);
		assertTrue(!("".equals(id)));

		GraphicsPlugin.getActivePage();
		assertNotNull(GraphicsPlugin.getDefault());
		assertNotNull(GraphicsPlugin.getID());
		assertNotNull(GraphicsPlugin.getInstallURL());
		// assertNotNull(GraphicsPlugin.getShell());
		assertNotNull(GraphicsPlugin.getWorkspace());
	}

	public void testPackageComSapMiGfwEclipseInternal() throws Exception {
		org.eclipse.swt.graphics.Image imageForId = ImagePool.getImageForId(IPlatformImageConstants.IMG_DIAGRAM);
		UIUtil.createImage(imageForId, SWT.IMAGE_GIF);
	}

	public void testPackageComSapMiGfwEclipseInternalCommand() throws Exception {
		// test com.sap.mi.gfw.eclipse.internal.command.AddModelObjectCommand
		IFeatureProvider featureProviderMock = createNiceMock(IFeatureProvider.class);
		replay(featureProviderMock);

		IDiagramTypeProvider diagramTypeProviderMock = createNiceMock(IDiagramTypeProvider.class);
		expect(diagramTypeProviderMock.getFeatureProvider()).andReturn(null).anyTimes();
		replay(diagramTypeProviderMock);

		IConfigurationProvider configurationProviderMock = createNiceMock(IConfigurationProvider.class);
		expect(configurationProviderMock.getDiagramTypeProvider()).andReturn(diagramTypeProviderMock).anyTimes();
		replay(configurationProviderMock);

		ContainerShape containerShapeMock = createNiceMock(ContainerShape.class);
		replay(containerShapeMock);

		IAdaptable adaptableMock = createNiceMock(IAdaptable.class);
		// RefObject aRefObject = new ContainerShapeImpl();
		// expect(adaptableMock.getAdapter(RefObject.class)).andReturn(aRefObject).anyTimes();
		expect(adaptableMock.getAdapter(RefObject.class)).andReturn(containerShapeMock).anyTimes();
		replay(adaptableMock);

		ISelection selection = new StructuredSelection(new Object[] { adaptableMock });

		Rectangle rectangle = new Rectangle();

		AddModelObjectCommand myAddModelObjectCommand = new AddModelObjectCommand(configurationProviderMock, containerShapeMock, selection,
				rectangle);

		assertFalse(myAddModelObjectCommand.canUndo());

		myAddModelObjectCommand.canExecute();

		reset(diagramTypeProviderMock);
		expect(diagramTypeProviderMock.getFeatureProvider()).andReturn(featureProviderMock).anyTimes();
		replay(diagramTypeProviderMock);

		myAddModelObjectCommand.canExecute();

		myAddModelObjectCommand.execute();

		// test com.sap.mi.gfw.eclipse.internal.command.ContextEntryCommand
		IContextEntry contextEntryMock = createNiceMock(IContextEntry.class);
		replay(contextEntryMock);

		ContextEntryCommand myContextEntryCommand = new ContextEntryCommand(contextEntryMock);

		myContextEntryCommand.execute();

		// test
		// com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider.GFWCommand
		GFWCommand myGFWCommand = new GFWCommand(configurationProviderMock, "Test");
		myGFWCommand.toString();
		myGFWCommand = new GFWCommand(configurationProviderMock);

		IContext contextMock = createNiceMock(IContext.class);
		replay(contextMock);
		myGFWCommand.setContext(contextMock);

		IContext context = myGFWCommand.getContext();
		assertEquals(contextMock, context);

		IFeature featureMock = createNiceMock(IFeature.class);
		replay(featureMock);
		myGFWCommand.setFeature(featureMock);

		IFeature feature = myGFWCommand.getFeature();
		assertEquals(featureMock, feature);

		// test com.sap.mi.gfw.eclipse.internal.command.CreateModelObjectCommand
		ICreateFeature createFeatureMock = createNiceMock(ICreateFeature.class);
		replay(createFeatureMock);

		ICreateContext createContextMock = createNiceMock(ICreateContext.class);
		replay(createContextMock);

		CreateModelObjectCommand myCreateModelObjectCommand = new CreateModelObjectCommand(configurationProviderMock, createFeatureMock,
				createContextMock, rectangle);

		myCreateModelObjectCommand.canExecute();

		myCreateModelObjectCommand.canUndo();

		myCreateModelObjectCommand.undo();

		// myCreateModelObjectCommand.execute();
	}

	public void testPackageComSapMiGfwEclipseInternalEditor() throws Exception {
		new GfwMarqueeSelectionTool();
	}

	public void testPackageComSapMiGfwEclipseInternalUtil() throws Exception {

		// TODO test DataTypeTransformation
		DataTypeTransformation myDataTypeTransformation = new DataTypeTransformation();
		assertNotNull(myDataTypeTransformation);

		com.sap.mi.gfw.mm.datatypes.Point pointMock = createNiceMock(com.sap.mi.gfw.mm.datatypes.Point.class);
		replay(pointMock);

		Point draw2dPoint = DataTypeTransformation.toDraw2dPoint(pointMock);
		assertNotNull(draw2dPoint);

		Bendpoint draw2dBendPoint = DataTypeTransformation.toDraw2dBendPoint(pointMock);
		assertNotNull(draw2dBendPoint);

		Vector<com.sap.mi.gfw.mm.datatypes.Point> points = new Vector<com.sap.mi.gfw.mm.datatypes.Point>();
		points.add(pointMock);
		points.add(pointMock);

		DataTypeTransformation.toDraw2dPointList(points);

		IInsets insetsMock = createNiceMock(IInsets.class);
		replay(insetsMock);

		DataTypeTransformation.toGfwInsets(DataTypeTransformation.toDraw2dInsets(insetsMock));
		DataTypeTransformation.toDraw2dInsets(null);
		DataTypeTransformation.toGfwInsets(null);

		Color colorMock = createNiceMock(Color.class);
		replay(colorMock);

		Vector<Color> colors = new Vector<Color>();
		colors.add(colorMock);

		Diagram diagramMock = createNiceMock(Diagram.class);
		expect(diagramMock.getColors()).andReturn(colors).anyTimes();
		replay(diagramMock);

		// DataTypeTransformation.toSwtColor((Color) null);
		// DataTypeTransformation.toPictogramsColor(DataTypeTransformation.toSwtColor(colorMock), diagramMock);
		//
		// DataTypeTransformation.toSwtColor((IColorConstant) null);
		// DataTypeTransformation.toSwtColor(IColorConstant.BLACK);

		assertTrue(DataTypeTransformation.toDraw2dLineStyle(LineStyleEnum.DASH) == Graphics.LINE_DASH);
		assertTrue(DataTypeTransformation.toDraw2dLineStyle(LineStyleEnum.DASHDOT) == Graphics.LINE_DASHDOT);
		assertTrue(DataTypeTransformation.toDraw2dLineStyle(LineStyleEnum.DASHDOTDOT) == Graphics.LINE_DASHDOTDOT);
		assertTrue(DataTypeTransformation.toDraw2dLineStyle(LineStyleEnum.DOT) == Graphics.LINE_DOT);
		assertTrue(DataTypeTransformation.toDraw2dLineStyle(LineStyleEnum.SOLID) == Graphics.LINE_SOLID);
		assertTrue(DataTypeTransformation.toDraw2dLineStyle(null) == Graphics.LINE_SOLID);

		Font fontMock = createNiceMock(Font.class);
		expect(fontMock.isItalic()).andReturn(true).anyTimes();
		expect(fontMock.isBold()).andReturn(true).anyTimes();
		expect(fontMock.getSize()).andReturn(10).anyTimes();
		expect(fontMock.getName()).andReturn("Arial").anyTimes();
		replay(fontMock);

		FontData fontData = DataTypeTransformation.toFontData(fontMock);
		assertNotNull(fontData);
		DataTypeTransformation.toFontData(null);
	}

	public void testPackageComSapMiGfwFeaturesContextImpl() throws Exception {
		// test com.sap.mi.gfw.features.context.impl.SplitConnectionContext
		com.sap.mi.gfw.mm.pictograms.Connection connectionMock = createNiceMock(com.sap.mi.gfw.mm.pictograms.Connection.class);
		replay(connectionMock);

		Shape shapeMock = createNiceMock(Shape.class);
		replay(shapeMock);

		SplitConnectionContext mySplitConnectionContext = new SplitConnectionContext(connectionMock, shapeMock);

		com.sap.mi.gfw.mm.pictograms.Connection con = mySplitConnectionContext.getConnection();
		assertNotNull(con);
		assertEquals(connectionMock, con);

		Shape shape = mySplitConnectionContext.getShape();
		assertNotNull(shape);
		assertEquals(shapeMock, shape);

		// test AreaAnchorContext
		Anchor anchorMock = createNiceMock(Anchor.class);
		replay(anchorMock);

		AreaAnchorContext myAreaAnchorContext = new AreaAnchorContext(anchorMock);

		Anchor anchor = myAreaAnchorContext.getAnchor();
		assertNotNull(anchor);
		assertEquals(anchorMock, anchor);

		AnchorContainer containerMock = createNiceMock(AnchorContainer.class);
		replay(containerMock);

		myAreaAnchorContext.setSourceContainer(containerMock);
		AnchorContainer sourceContainer = myAreaAnchorContext.getSourceContainer();
		assertNotNull(sourceContainer);
		assertEquals(containerMock, sourceContainer);

		myAreaAnchorContext.setTargetContainer(containerMock);
		AnchorContainer targetContainer = myAreaAnchorContext.getTargetContainer();
		assertNotNull(targetContainer);
		assertEquals(containerMock, targetContainer);

		// test CreateConnectionContext
		CreateConnectionContext myCreateConnectionContext = new CreateConnectionContext();

		myCreateConnectionContext.setSourceAnchor(anchorMock);
		anchor = myCreateConnectionContext.getSourceAnchor();
		assertNotNull(anchor);
		assertEquals(anchorMock, anchor);

		myCreateConnectionContext.setTargetAnchor(anchorMock);
		anchor = myCreateConnectionContext.getTargetAnchor();
		assertNotNull(anchor);
		assertEquals(anchorMock, anchor);

		PictogramElement peMock = createNiceMock(PictogramElement.class);
		replay(peMock);

		myCreateConnectionContext.setSourcePictogramElement(peMock);
		PictogramElement pictogramElement = myCreateConnectionContext.getSourcePictogramElement();
		assertNotNull(pictogramElement);
		assertEquals(peMock, pictogramElement);

		myCreateConnectionContext.setTargetPictogramElement(peMock);
		pictogramElement = myCreateConnectionContext.getTargetPictogramElement();
		assertNotNull(pictogramElement);
		assertEquals(peMock, pictogramElement);

		// test AddBendpointContext
		FreeFormConnection freeFormConnectionMock = createNiceMock(FreeFormConnection.class);
		replay(freeFormConnectionMock);

		AddBendpointContext myAddBendpointContext = new AddBendpointContext(freeFormConnectionMock, 0, 0, 0);

		myAddBendpointContext.getBendpoint();

		assertEquals(0, myAddBendpointContext.getBendpointIndex());

		FreeFormConnection freeFormConnection = myAddBendpointContext.getConnection();
		assertNotNull(freeFormConnection);
		assertEquals(freeFormConnectionMock, freeFormConnection);

		// test MoveConnectionDecoratorContext
		ConnectionDecorator connectionDecoratorMock = createNiceMock(ConnectionDecorator.class);
		replay(connectionDecoratorMock);

		MoveConnectionDecoratorContext myMoveConnectionDecoratorContext = new MoveConnectionDecoratorContext(connectionDecoratorMock, 0, 0,
				true);

		ConnectionDecorator connectionDecorator = myMoveConnectionDecoratorContext.getConnectionDecorator();
		assertNotNull(connectionDecorator);
		assertEquals(connectionDecoratorMock, connectionDecorator);

		assertTrue(myMoveConnectionDecoratorContext.isExecuteAllowed());

		// test ReconnectionContext
		ReconnectionContext myReconnectionContext = new ReconnectionContext(connectionMock, anchorMock, anchorMock);

		con = myReconnectionContext.getConnection();
		assertNotNull(con);
		assertEquals(connectionMock, con);

		anchor = myReconnectionContext.getNewAnchor();
		assertNotNull(anchor);
		assertEquals(anchorMock, anchor);

		anchor = myReconnectionContext.getOldAnchor();
		assertNotNull(anchor);
		assertEquals(anchorMock, anchor);

		myReconnectionContext.setTargetPictogramElement(peMock);

		pictogramElement = myReconnectionContext.getTargetPictogramElement();
		assertNotNull(pictogramElement);
		assertEquals(peMock, pictogramElement);

		// test RemoveBendpointContext
		com.sap.mi.gfw.mm.datatypes.Point pointMock = createNiceMock(com.sap.mi.gfw.mm.datatypes.Point.class);
		replay(pointMock);

		RemoveBendpointContext myRemoveBendpointContext = new RemoveBendpointContext(freeFormConnectionMock, pointMock);

		myRemoveBendpointContext.setBendpointIndex(0);

		assertEquals(0, myRemoveBendpointContext.getBendpointIndex());

		freeFormConnection = myRemoveBendpointContext.getConnection();
		assertNotNull(freeFormConnection);
		assertEquals(freeFormConnectionMock, freeFormConnection);

		com.sap.mi.gfw.mm.datatypes.Point bendpoint = myRemoveBendpointContext.getBendpoint();
		assertNotNull(bendpoint);
		assertEquals(pointMock, bendpoint);

		// test MoveContext
		MoveContext myMoveContext = new MoveContext();
		assertNotNull(myMoveContext);
		myMoveContext = new MoveContext(0, 0);
		assertNotNull(myMoveContext);

		// test MoveBendpointContext
		MoveBendpointContext myMoveBendpointContext = new MoveBendpointContext(pointMock);

		bendpoint = myMoveBendpointContext.getBendpoint();
		assertNotNull(bendpoint);
		assertEquals(pointMock, bendpoint);

		myMoveBendpointContext.setBendpointIndex(0);
		assertEquals(0, myMoveBendpointContext.getBendpointIndex());

		myMoveBendpointContext.setConnection(freeFormConnectionMock);
		freeFormConnection = myMoveBendpointContext.getConnection();
		assertNotNull(freeFormConnection);
		assertEquals(freeFormConnectionMock, freeFormConnection);

		// test SaveImageContext
		SaveImageContext mySaveImageContext = new SaveImageContext();

		PictogramElement[] pictogramElements1 = new PictogramElement[] { peMock };
		mySaveImageContext = new SaveImageContext(pictogramElements1);

		PictogramElement[] pictogramElements2 = mySaveImageContext.getPictogramElements();
		assertNotNull(pictogramElements2);
		assertEquals(pictogramElements1, pictogramElements2);

		// test LocationContext
		LocationContext myLocationContext = new LocationContext();

		myLocationContext = new LocationContext(10, 10);
		myLocationContext.setX(10);
		myLocationContext.setY(10);
		assertEquals(10, myLocationContext.getX());
		assertEquals(10, myLocationContext.getY());

		String s = myLocationContext.toString();
		assertNotNull(s);
		assertTrue(!("".equals(s)));

		// AreaContext
		AreaContext myAreaContext = new AreaContext();

		myAreaContext.setWidth(10);
		assertEquals(10, myAreaContext.getWidth());

		myAreaContext.setHeight(10);
		assertEquals(10, myAreaContext.getHeight());

		myAreaContext.setSize(20, 20);
		assertEquals(20, myAreaContext.getWidth());
		assertEquals(20, myAreaContext.getHeight());

		s = myAreaContext.toString();
		assertNotNull(s);
		assertTrue(!("".equals(s)));

		// test ResizeShapeContext
		ResizeShapeContext myResizeShapeContext = new ResizeShapeContext(shapeMock);

		shape = myResizeShapeContext.getShape();
		assertNotNull(shape);
		assertEquals(shapeMock, shape);

		pictogramElement = myResizeShapeContext.getPictogramElement();
		assertNotNull(pictogramElement);
		assertEquals(shapeMock, pictogramElement);

		// test ResizeContext
		ResizeContext myResizeContext = new ResizeContext();

		myResizeContext.setHeight(10);
		assertEquals(10, myResizeContext.getHeight());

		myResizeContext.setWidth(15);
		assertEquals(15, myResizeContext.getWidth());

		myResizeContext.setSize(20, 20);
		assertEquals(20, myResizeContext.getHeight());
		assertEquals(20, myResizeContext.getWidth());

		s = myResizeContext.toString();
		assertNotNull(s);
		assertTrue(!("".equals(s)));

		// test PrintContext
		PrintContext myPrintContext = new PrintContext();
		assertNotNull(myPrintContext);

		// test MoveShapeContext
		MoveShapeContext myMoveShapeContext = new MoveShapeContext(shapeMock);

		shape = myMoveShapeContext.getShape();
		assertNotNull(shape);
		assertEquals(shapeMock, shape);

		myMoveShapeContext.setDeltaX(10);
		assertEquals(10, myMoveShapeContext.getDeltaX());

		myMoveShapeContext.setDeltaY(15);
		assertEquals(15, myMoveShapeContext.getDeltaY());

		ContainerShape containerShapeMock = createNiceMock(ContainerShape.class);
		replay(containerShapeMock);

		myMoveShapeContext.setSourceContainer(containerShapeMock);
		ContainerShape containerShape = myMoveShapeContext.getSourceContainer();
		assertNotNull(containerShape);
		assertEquals(containerShapeMock, containerShape);

		myMoveShapeContext.setTargetContainer(containerShapeMock);
		containerShape = myMoveShapeContext.getTargetContainer();
		assertNotNull(containerShape);
		assertEquals(containerShapeMock, containerShape);

		myMoveShapeContext.setTargetConnection(connectionMock);
		con = myMoveShapeContext.getTargetConnection();
		assertNotNull(con);
		assertEquals(connectionMock, con);

		pictogramElement = myMoveShapeContext.getPictogramElement();
		assertNotNull(pictogramElement);
		assertEquals(shapeMock, pictogramElement);

		s = myMoveShapeContext.toString();
		assertNotNull(s);
		assertTrue(!("".equals(s)));

		// test LayoutContext
		LayoutContext myLayoutContext = new LayoutContext(peMock);
		assertNotNull(myLayoutContext);

		// test DirectEditingContext
		GraphicsAlgorithm graphicsAlgorithmMock = createNiceMock(GraphicsAlgorithm.class);
		replay(graphicsAlgorithmMock);

		DirectEditingContext myDirectEditingContext = new DirectEditingContext(peMock, graphicsAlgorithmMock);
		assertNotNull(myDirectEditingContext);

		// test AddConnectionContext
		AddConnectionContext myAddConnectionContext = new AddConnectionContext(anchorMock, anchorMock);

		anchor = myAddConnectionContext.getSourceAnchor();
		assertNotNull(anchor);
		assertEquals(anchorMock, anchor);

		anchor = myAddConnectionContext.getTargetAnchor();
		assertNotNull(anchor);
		assertEquals(anchorMock, anchor);

		// test CustomContext
		CustomContext myCustomContext = new CustomContext(pictogramElements1);

		pictogramElements2 = myCustomContext.getPictogramElements();
		assertNotNull(pictogramElements2);
		assertEquals(pictogramElements1, pictogramElements2);

		myCustomContext.setInnerPictogramElement(peMock);
		pictogramElement = myCustomContext.getInnerPictogramElement();
		assertNotNull(pictogramElement);
		assertEquals(peMock, pictogramElement);

		myCustomContext.setInnerGraphicsAlgorithm(graphicsAlgorithmMock);
		GraphicsAlgorithm graphicsAlgorithm = myCustomContext.getInnerGraphicsAlgorithm();
		assertNotNull(graphicsAlgorithm);
		assertEquals(graphicsAlgorithmMock, graphicsAlgorithm);

		// test AddContext
		IAreaContext areaContextMock = createNiceMock(IAreaContext.class);
		replay(areaContextMock);

		Object value = new Object();
		AddContext myAddContext = new AddContext(areaContextMock, value);

		myAddContext.setTargetConnection(connectionMock);
		con = myAddContext.getTargetConnection();
		assertNotNull(con);
		assertEquals(connectionMock, con);

		myAddContext.setTargetContainer(containerShapeMock);
		containerShape = myAddContext.getTargetContainer();
		assertNotNull(containerShape);
		assertEquals(containerShapeMock, containerShape);

		// test CreateContext
		CreateContext myCreateContext = new CreateContext();

		myCreateContext.setTargetConnection(connectionMock);
		con = myCreateContext.getTargetConnection();
		assertNotNull(con);
		assertEquals(connectionMock, con);

		myCreateContext.setTargetContainer(containerShapeMock);
		containerShape = myCreateContext.getTargetContainer();
		assertNotNull(containerShape);
		assertEquals(containerShapeMock, containerShape);
	}

	public void testPackageComSapMiGfwInternal() throws Exception {
		// test com.sap.mi.gfw.internal.ExternalPictogramLink

		// test constructor
		ExternalPictogramLink myExternalPictogramLink = new ExternalPictogramLink();

		try {
			List<com.sap.tc.moin.repository.mmi.reflect.RefObject> list = myExternalPictogramLink.getBusinessObjects();
			assertNotNull(list);
		} catch (UnsupportedOperationException e) {
			// do nothing
		}

		com.sap.mi.gfw.mm.datatypes.Point pointMock = createNiceMock(com.sap.mi.gfw.mm.datatypes.Point.class);
		replay(pointMock);
		myExternalPictogramLink.setLocation(pointMock);
		myExternalPictogramLink.getLocation();

		// test stub
		myExternalPictogramLink.refVerifyConstraints(true);
		// assertNotNull(constraints);
		myExternalPictogramLink.refVerifyConstraints(false);
		// assertNotNull(constraints2);
		myExternalPictogramLink.refOutermostPackage();
		// assertNotNull(refOutermostPackage);
		myExternalPictogramLink.refMofId();
		// assertNotNull(refMofId);
		myExternalPictogramLink.refMetaObject();
		// assertNotNull(refMetaObject);
		myExternalPictogramLink.refImmediatePackage();
		// assertNotNull(refImmediatePackage);
		myExternalPictogramLink.refSetValue(new String(), new Object());
		RefObject refObjectMock = createNiceMock(RefObject.class);
		replay(refObjectMock);
		myExternalPictogramLink.refSetValue(refObjectMock, new Object());
		myExternalPictogramLink.refInvokeOperation(new String(), new Vector<Object>());
		// assertNotNull(operation);
		myExternalPictogramLink.refInvokeOperation(refObjectMock, new Vector<Object>());
		// assertNotNull(operation2);
		myExternalPictogramLink.refGetValue(new String());
		// assertNotNull(value);
		myExternalPictogramLink.refGetValue(refObjectMock);
		// assertNotNull(value2);
		myExternalPictogramLink.refOutermostComposite();
		// assertNotNull(refOutermostComposite);
		boolean isInstanceOf = myExternalPictogramLink.refIsInstanceOf(refObjectMock, true);
		isInstanceOf = !(isInstanceOf);
		boolean isInstanceOf2 = myExternalPictogramLink.refIsInstanceOf(refObjectMock, false);
		isInstanceOf2 = !(isInstanceOf2);
		myExternalPictogramLink.refImmediateComposite();
		// assertNotNull(refImmediateComposite)
		myExternalPictogramLink.refDelete();
		myExternalPictogramLink.refClass();
		// assertNotNull(refClass);
		myExternalPictogramLink.setWidth(10);
		myExternalPictogramLink.getWidth();
		myExternalPictogramLink.setHeight(10);
		myExternalPictogramLink.getHeight();
		myExternalPictogramLink.getProperties();
		// assertNotNull(properties);
		// end of test stub

		assertNull(myExternalPictogramLink.getPictogramElement());

		PictogramElement pictogramElementMock = createNiceMock(PictogramElement.class);
		replay(pictogramElementMock);
		myExternalPictogramLink.setPictogramElement(pictogramElementMock);

		PictogramElement pictogramElement = myExternalPictogramLink.getPictogramElement();
		assertNotNull(pictogramElement);
		assertTrue(pictogramElement.equals(pictogramElementMock));

		DiagramLink diagramLinkMock = createNiceMock(DiagramLink.class);
		myExternalPictogramLink.setDiagramLink(diagramLinkMock);

		DiagramLink diagramLink = myExternalPictogramLink.getDiagramLink();
		assertNotNull(diagramLink);
		assertTrue(diagramLink.equals(diagramLinkMock));

		// ####################################################

		// test com.sap.mi.gfw.mm.datatypes.Color.GaUtilInternal
		GaUtilInternal myGaUtilInternal = new GaUtilInternal();
		assertNotNull(myGaUtilInternal);

		// test public static int getAngle(AbstractText at, boolean checkStyles)
		// and private static int getAngle(Style style)
		Style styleContainerMock = createNiceMock(Style.class);
		expect(styleContainerMock.getAngle()).andReturn(null);
		expect(styleContainerMock.getStyleContainer()).andReturn(null);
		replay(styleContainerMock);

		Style styleMock = createNiceMock(Style.class);
		expect(styleMock.getAngle()).andReturn(new Integer(-1));
		expect(styleMock.getAngle()).andReturn(new Integer(-1));

		expect(styleMock.getAngle()).andReturn(null);

		expect(styleMock.getStyleContainer()).andReturn(styleContainerMock);
		replay(styleMock);

		AbstractText abstractTextMock = createNiceMock(AbstractText.class);
		// run 1
		expect(abstractTextMock.getAngle()).andReturn(null);
		expect(abstractTextMock.getStyle()).andReturn(styleMock);
		// run 2
		expect(abstractTextMock.getAngle()).andReturn(null);
		expect(abstractTextMock.getStyle()).andReturn(styleMock);
		// run 3
		expect(abstractTextMock.getAngle()).andReturn(null);
		// run 4
		expect(abstractTextMock.getAngle()).andReturn(new Integer(0));
		expect(abstractTextMock.getAngle()).andReturn(new Integer(0));
		replay(abstractTextMock);

		GaUtilInternal.getAngle(abstractTextMock, true);
		GaUtilInternal.getAngle(abstractTextMock, true);
		GaUtilInternal.getAngle(abstractTextMock, false);
		GaUtilInternal.getAngle(abstractTextMock, false);

		// verify(styleMock);

		// test public static Color getBackgroundColor(GraphicsAlgorithm ga,
		// boolean checkStyles)
		// and private static Color getBackgroundColor(Style style)
		Color colorMock = createMock(Color.class);
		replay(colorMock);

		styleMock = createNiceMock(Style.class);
		expect(styleMock.getBackground()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.getBackground()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.getBackground()).andReturn(colorMock).times(2);
		replay(styleMock);

		GraphicsAlgorithm graphicsAlgorithmMock = createMock(GraphicsAlgorithm.class);
		// run 1
		expect(graphicsAlgorithmMock.getBackground()).andReturn(colorMock);
		expect(graphicsAlgorithmMock.getBackground()).andReturn(colorMock);
		// run 2
		expect(graphicsAlgorithmMock.getBackground()).andReturn(null);
		// run 3
		expect(graphicsAlgorithmMock.getBackground()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(graphicsAlgorithmMock.getBackground()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		replay(graphicsAlgorithmMock);

		GaUtilInternal.getBackgroundColor(graphicsAlgorithmMock, false);
		GaUtilInternal.getBackgroundColor(graphicsAlgorithmMock, false);
		GaUtilInternal.getBackgroundColor(graphicsAlgorithmMock, true);
		GaUtilInternal.getBackgroundColor(graphicsAlgorithmMock, true);

		// verify(styleMock);

		// test public static Font getFont(AbstractText at, boolean checkStyles)
		// and private static Font getFont(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.getFont()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.getFont()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.getFont()).andReturn(createMock(Font.class));
		expect(styleMock.getFont()).andReturn(createMock(Font.class));
		replay(styleMock);

		abstractTextMock = createNiceMock(AbstractText.class);
		// run 1
		expect(abstractTextMock.getFont()).andReturn(null);
		// run 2
		expect(abstractTextMock.getFont()).andReturn(createMock(Font.class));
		expect(abstractTextMock.getFont()).andReturn(null);
		// run 3
		expect(abstractTextMock.getFont()).andReturn(null);
		expect(abstractTextMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(abstractTextMock.getFont()).andReturn(null);
		expect(abstractTextMock.getStyle()).andReturn(styleMock);
		replay(abstractTextMock);

		GaUtilInternal.getFont(abstractTextMock, false);
		GaUtilInternal.getFont(abstractTextMock, true);
		GaUtilInternal.getFont(abstractTextMock, true);
		GaUtilInternal.getFont(abstractTextMock, true);

		// verify(styleMock);

		// test public static Color getForegroundColor(GraphicsAlgorithm ga,
		// boolean checkStyles)
		// and private static Color getForegroundColor(Style style)
		colorMock = createMock(Color.class);
		replay(colorMock);

		styleMock = createNiceMock(Style.class);
		expect(styleMock.getForeground()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.getForeground()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.getForeground()).andReturn(colorMock).times(2);
		replay(styleMock);

		graphicsAlgorithmMock = createMock(GraphicsAlgorithm.class);
		// run 1
		expect(graphicsAlgorithmMock.getForeground()).andReturn(colorMock).times(2);
		// run 2
		expect(graphicsAlgorithmMock.getForeground()).andReturn(null);
		// run 3
		expect(graphicsAlgorithmMock.getForeground()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(graphicsAlgorithmMock.getForeground()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		replay(graphicsAlgorithmMock);

		GaUtilInternal.getForegroundColor(graphicsAlgorithmMock, false);
		GaUtilInternal.getForegroundColor(graphicsAlgorithmMock, false);
		GaUtilInternal.getForegroundColor(graphicsAlgorithmMock, true);
		GaUtilInternal.getForegroundColor(graphicsAlgorithmMock, true);

		// verify(styleMock);

		// test public static Orientation getHorizontalAlignment(AbstractText
		// at, boolean checkStyles)
		// and private static Orientation getHorizontalAlignment(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.getHorizontalAlignment()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.getHorizontalAlignment()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.getHorizontalAlignment()).andReturn(createNiceMock(Orientation.class)).times(2);
		replay(styleMock);

		abstractTextMock = createMock(AbstractText.class);
		// run 1
		expect(abstractTextMock.getHorizontalAlignment()).andReturn(null);
		// run 2
		expect(abstractTextMock.getHorizontalAlignment()).andReturn(createMock(Orientation.class));
		expect(abstractTextMock.getHorizontalAlignment()).andReturn(null);
		// run 3
		expect(abstractTextMock.getHorizontalAlignment()).andReturn(null);
		expect(abstractTextMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(abstractTextMock.getHorizontalAlignment()).andReturn(null);
		expect(abstractTextMock.getStyle()).andReturn(styleMock);
		replay(abstractTextMock);

		GaUtilInternal.getHorizontalAlignment(abstractTextMock, false);
		GaUtilInternal.getHorizontalAlignment(abstractTextMock, false);
		GaUtilInternal.getHorizontalAlignment(abstractTextMock, true);
		GaUtilInternal.getHorizontalAlignment(abstractTextMock, true);

		// verify(styleMock);

		// test public static Orientation getVerticalAlignment(AbstractText at,
		// boolean checkStyles)
		// and private static Orientation getVerticalAlignment(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.getVerticalAlignment()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.getVerticalAlignment()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.getVerticalAlignment()).andReturn(createNiceMock(Orientation.class)).times(2);
		replay(styleMock);

		abstractTextMock = createMock(AbstractText.class);
		// run 1
		expect(abstractTextMock.getVerticalAlignment()).andReturn(null);
		// run 2
		expect(abstractTextMock.getVerticalAlignment()).andReturn(createMock(Orientation.class));
		expect(abstractTextMock.getVerticalAlignment()).andReturn(null);
		// run 3
		expect(abstractTextMock.getVerticalAlignment()).andReturn(null);
		expect(abstractTextMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(abstractTextMock.getVerticalAlignment()).andReturn(null);
		expect(abstractTextMock.getStyle()).andReturn(styleMock);
		replay(abstractTextMock);

		GaUtilInternal.getVerticalAlignment(abstractTextMock, false);
		GaUtilInternal.getVerticalAlignment(abstractTextMock, false);
		GaUtilInternal.getVerticalAlignment(abstractTextMock, true);
		GaUtilInternal.getVerticalAlignment(abstractTextMock, true);

		// verify(styleMock);

		// test public static LineStyle getLineStyle(GraphicsAlgorithm ga,
		// boolean checkStyles)
		// and private static LineStyle getLineStyle(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.getLineStyle()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.getLineStyle()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.getLineStyle()).andReturn(createNiceMock(LineStyle.class)).times(2);
		replay(styleMock);

		graphicsAlgorithmMock = createMock(GraphicsAlgorithm.class);
		// run 1
		expect(graphicsAlgorithmMock.getLineStyle()).andReturn(createMock(LineStyle.class)).times(2);
		// run 2
		expect(graphicsAlgorithmMock.getLineStyle()).andReturn(null);
		// run 3
		expect(graphicsAlgorithmMock.getLineStyle()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(graphicsAlgorithmMock.getLineStyle()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		replay(graphicsAlgorithmMock);

		GaUtilInternal.getLineStyle(graphicsAlgorithmMock, false);
		GaUtilInternal.getLineStyle(graphicsAlgorithmMock, false);
		GaUtilInternal.getLineStyle(graphicsAlgorithmMock, true);
		GaUtilInternal.getLineStyle(graphicsAlgorithmMock, true);

		// verify(styleMock);

		// test public static int getLineWidth(GraphicsAlgorithm ga, boolean
		// checkStyles) {
		// and private static int getLineWidth(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.getLineWidth()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.getLineWidth()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.getLineWidth()).andReturn(new Integer(5)).times(2);
		replay(styleMock);

		graphicsAlgorithmMock = createMock(GraphicsAlgorithm.class);
		// run 1
		expect(graphicsAlgorithmMock.getLineWidth()).andReturn(new Integer(6)).times(2);
		// run 2
		expect(graphicsAlgorithmMock.getLineWidth()).andReturn(null);
		// run 3
		expect(graphicsAlgorithmMock.getLineWidth()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(graphicsAlgorithmMock.getLineWidth()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		replay(graphicsAlgorithmMock);

		GaUtilInternal.getLineWidth(graphicsAlgorithmMock, false);
		GaUtilInternal.getLineWidth(graphicsAlgorithmMock, false);
		GaUtilInternal.getLineWidth(graphicsAlgorithmMock, true);
		GaUtilInternal.getLineWidth(graphicsAlgorithmMock, true);

		// verify(styleMock);

		// test public static RenderingStyle getRenderingStyle(GraphicsAlgorithm
		// ga, boolean checkStyles)
		// and private static RenderingStyle getRenderingStyle(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.getRenderingStyle()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.getRenderingStyle()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.getRenderingStyle()).andReturn(createMock(RenderingStyle.class)).times(2);
		replay(styleMock);

		graphicsAlgorithmMock = createMock(GraphicsAlgorithm.class);
		// run 1
		expect(graphicsAlgorithmMock.getRenderingStyle()).andReturn(createMock(RenderingStyle.class)).times(2);
		// run 2
		expect(graphicsAlgorithmMock.getRenderingStyle()).andReturn(null);
		// run 3
		expect(graphicsAlgorithmMock.getRenderingStyle()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(graphicsAlgorithmMock.getRenderingStyle()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		replay(graphicsAlgorithmMock);

		GaUtilInternal.getRenderingStyle(graphicsAlgorithmMock, false);
		GaUtilInternal.getRenderingStyle(graphicsAlgorithmMock, false);
		GaUtilInternal.getRenderingStyle(graphicsAlgorithmMock, true);
		GaUtilInternal.getRenderingStyle(graphicsAlgorithmMock, true);

		// verify(styleMock);

		// test public static double getTransparency(GraphicsAlgorithm ga,
		// boolean checkStyles)
		// and private static double getTransparency(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.getTransparency()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.getTransparency()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.getTransparency()).andReturn(new Double(1.0)).times(2);
		replay(styleMock);

		graphicsAlgorithmMock = createMock(GraphicsAlgorithm.class);
		// run 1
		expect(graphicsAlgorithmMock.getTransparency()).andReturn(new Double(0.0)).times(2);
		// run 2
		expect(graphicsAlgorithmMock.getTransparency()).andReturn(null);
		// run 3
		expect(graphicsAlgorithmMock.getTransparency()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(graphicsAlgorithmMock.getTransparency()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		replay(graphicsAlgorithmMock);

		GaUtilInternal.getTransparency(graphicsAlgorithmMock, false);
		GaUtilInternal.getTransparency(graphicsAlgorithmMock, false);
		GaUtilInternal.getTransparency(graphicsAlgorithmMock, true);
		GaUtilInternal.getTransparency(graphicsAlgorithmMock, true);

		// verify(styleMock);

		// test public static boolean isFilled(GraphicsAlgorithm ga, boolean
		// checkStyles)
		// and private static boolean isFilled(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.isFilled()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.isFilled()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.isFilled()).andReturn(new Boolean(true)).times(2);
		replay(styleMock);

		graphicsAlgorithmMock = createNiceMock(GraphicsAlgorithm.class);
		// run 1
		expect(graphicsAlgorithmMock.isFilled()).andReturn(new Boolean(false)).times(2);
		// run 2
		expect(graphicsAlgorithmMock.isFilled()).andReturn(null);
		// run 3
		expect(graphicsAlgorithmMock.isFilled()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(graphicsAlgorithmMock.isFilled()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		replay(graphicsAlgorithmMock);

		GaUtilInternal.isFilled(graphicsAlgorithmMock, false);
		GaUtilInternal.isFilled(graphicsAlgorithmMock, false);
		GaUtilInternal.isFilled(graphicsAlgorithmMock, true);
		GaUtilInternal.isFilled(graphicsAlgorithmMock, true);

		// verify(styleMock);

		// test public static boolean isLineVisible(GraphicsAlgorithm ga,
		// boolean checkStyles)
		// and private static boolean isLineVisible(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.isLineVisible()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.isLineVisible()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.isLineVisible()).andReturn(new Boolean(true)).times(2);
		replay(styleMock);

		graphicsAlgorithmMock = createMock(GraphicsAlgorithm.class);
		// run 1
		expect(graphicsAlgorithmMock.isLineVisible()).andReturn(new Boolean(false)).times(2);
		// run 2
		expect(graphicsAlgorithmMock.isLineVisible()).andReturn(null);
		// run 3
		expect(graphicsAlgorithmMock.isLineVisible()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(graphicsAlgorithmMock.isLineVisible()).andReturn(null);
		expect(graphicsAlgorithmMock.getStyle()).andReturn(styleMock);
		replay(graphicsAlgorithmMock);

		GaUtilInternal.isLineVisible(graphicsAlgorithmMock, false);
		GaUtilInternal.isLineVisible(graphicsAlgorithmMock, false);
		GaUtilInternal.isLineVisible(graphicsAlgorithmMock, true);
		GaUtilInternal.isLineVisible(graphicsAlgorithmMock, true);

		// verify(styleMock);

		// test public static boolean isProportional(Image image, boolean
		// checkStyles)
		// and private static boolean isProportional(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.isProportional()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.isProportional()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.isProportional()).andReturn(new Boolean(true)).times(2);
		replay(styleMock);

		Image imageMock = createMock(Image.class);
		// run 1
		expect(imageMock.isProportional()).andReturn(new Boolean(false)).times(2);
		// run 2
		expect(imageMock.isProportional()).andReturn(null);
		// run 3
		expect(imageMock.isProportional()).andReturn(null);
		expect(imageMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(imageMock.isProportional()).andReturn(null);
		expect(imageMock.getStyle()).andReturn(styleMock);
		replay(imageMock);

		GaUtilInternal.isProportional(imageMock, false);
		GaUtilInternal.isProportional(imageMock, false);
		GaUtilInternal.isProportional(imageMock, true);
		GaUtilInternal.isProportional(imageMock, true);

		// verify(styleMock);

		// test public static boolean isStretchH(Image image, boolean
		// checkStyles)
		// and private static boolean isStretchH(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.isStretchH()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.isStretchH()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.isStretchH()).andReturn(new Boolean(true)).times(2);
		replay(styleMock);

		imageMock = createMock(Image.class);
		// run 1
		expect(imageMock.isStretchH()).andReturn(new Boolean(false)).times(2);
		// run 2
		expect(imageMock.isStretchH()).andReturn(null);
		// run 3
		expect(imageMock.isStretchH()).andReturn(null);
		expect(imageMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(imageMock.isStretchH()).andReturn(null);
		expect(imageMock.getStyle()).andReturn(styleMock);
		replay(imageMock);

		GaUtilInternal.isStretchH(imageMock, false);
		GaUtilInternal.isStretchH(imageMock, false);
		GaUtilInternal.isStretchH(imageMock, true);
		GaUtilInternal.isStretchH(imageMock, true);

		// verify(styleMock);

		// test public static boolean isStretchV(Image image, boolean
		// checkStyles)
		// and private static boolean isStretchV(Style style)
		styleMock = createNiceMock(Style.class);
		expect(styleMock.isStretchV()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(styleMock);
		expect(styleMock.isStretchV()).andReturn(null);
		expect(styleMock.getStyleContainer()).andReturn(null);
		expect(styleMock.isStretchV()).andReturn(new Boolean(true)).times(2);
		replay(styleMock);

		imageMock = createMock(Image.class);
		// run 1
		expect(imageMock.isStretchV()).andReturn(new Boolean(false)).times(2);
		// run 2
		expect(imageMock.isStretchV()).andReturn(null);
		// run 3
		expect(imageMock.isStretchV()).andReturn(null);
		expect(imageMock.getStyle()).andReturn(styleMock);
		// run 4
		expect(imageMock.isStretchV()).andReturn(null);
		expect(imageMock.getStyle()).andReturn(styleMock);
		replay(imageMock);

		GaUtilInternal.isStretchV(imageMock, false);
		GaUtilInternal.isStretchV(imageMock, false);
		GaUtilInternal.isStretchV(imageMock, true);
		GaUtilInternal.isStretchV(imageMock, true);

		// verify(styleMock);
	}

	public void testPackageComSapMiGfwMappingData() throws Exception {
		// test com.sap.mi.gfw.mapping.data.ImageDataMapping
		class MyImageDataMapping extends ImageDataMapping {
			public MyImageDataMapping(IMappingProvider mappingProvider) {
				super(mappingProvider);
			}
		}

		IMappingProvider mappingProviderMock = createNiceMock(IMappingProvider.class);
		replay(mappingProviderMock);

		MyImageDataMapping myImageDataMapping = new MyImageDataMapping(mappingProviderMock);

		PictogramLink pictogramLinkMock = createNiceMock(PictogramLink.class);
		replay(pictogramLinkMock);

		myImageDataMapping.getImageId(pictogramLinkMock);

		myImageDataMapping.getUpdateWarning(pictogramLinkMock);
	}

	public void testPackageComSapMiGfwNotification() throws Exception {
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
		IConfigurationProvider configurationProvider = diagramEditor.getConfigurationProvider();
		IDiagramTypeProvider diagramTypeProvider = configurationProvider.getDiagramTypeProvider();

		// test final public void update(Object[] changedBOs)
		AbstractNotificationService simpleNotificationService = new AbstractNotificationService(diagramTypeProvider) {
		};
		simpleNotificationService.update(new Object[] { new Object(), null });

		// test com.sap.mi.gfw.notificationMoinNotificationService

		// test constructor
		MoinNotificationService myMoinNotificationService = new MoinNotificationService(diagramTypeProvider);

		// test public void notifyUpdate(EventChain eventChain)
		ChangeEvent changeEventMock = createNiceMock(ChangeEvent.class);
		replay(changeEventMock);

		Partitionable diag = diagramEditor.getDiagramTypeProvider().getDiagram();
		PRI diagramPri = diag.get___Partition().getPri();
		assertNotNull(diagramPri);
		MRI diagramMRI = diag.get___Mri();

		PRI priMock = createNiceMock(PRI.class);
		replay(priMock);

		MRI mriMock = createNiceMock(MRI.class);
		expect(mriMock.getPri()).andReturn(priMock).anyTimes();
		expect(mriMock.getDataAreaDescriptor()).andReturn(createMock(DataAreaDescriptor.class)).anyTimes();
		replay(mriMock);

		ElementChangeEvent elementChangeEventMock = createNiceMock(ElementChangeEvent.class);
		expect(elementChangeEventMock.getAffectedElementMri()).andReturn(mriMock).anyTimes();
		replay(elementChangeEventMock);

		LinkChangeEvent linkChangeEventMock = createNiceMock(LinkChangeEvent.class);
		expect(linkChangeEventMock.getFirstLinkEndMri()).andReturn(diagramMRI).anyTimes();
		expect(linkChangeEventMock.getSecondLinkEndMri()).andReturn(diagramMRI).anyTimes();
		replay(linkChangeEventMock);

		Vector<ChangeEvent> changeEvents = new Vector<ChangeEvent>();
		changeEvents.add(changeEventMock);
		changeEvents.add(elementChangeEventMock);
		changeEvents.add(linkChangeEventMock);

		EventChain eventChainMock = createNiceMock(EventChain.class);
		expect(eventChainMock.getEvents()).andReturn(changeEvents).anyTimes();
		replay(eventChainMock);

		myMoinNotificationService.notifyUpdate(eventChainMock);

		closeEditor(diagramEditor);
	}

	public void testPackageComSapMiGfwPlatformGa() throws Exception {

		// test com.sap.mi.gfw.platform.ga.RendererContext
		PlatformGraphicsAlgorithm platformGraphicsAlgorithmMock = createNiceMock(PlatformGraphicsAlgorithm.class);
		replay(platformGraphicsAlgorithmMock);

		IDiagramTypeProvider diagramTypeProviderMock = createNiceMock(IDiagramTypeProvider.class);
		IFeatureProvider featureProviderMock = createNiceMock(IFeatureProvider.class);
		replay(featureProviderMock);
		expect(diagramTypeProviderMock.getFeatureProvider()).andReturn(featureProviderMock);
		replay(diagramTypeProviderMock);

		// test constructor
		RendererContext myRendererContext = new RendererContext(platformGraphicsAlgorithmMock, diagramTypeProviderMock);

		// test getDiagramTypeProvider()
		IDiagramTypeProvider diagramTypeProvider = myRendererContext.getDiagramTypeProvider();
		assertNotNull(diagramTypeProvider);
		assertTrue(diagramTypeProvider.equals(diagramTypeProviderMock));

		// test getGraphicsAlgorithm()
		GraphicsAlgorithm graphicsAlgorithm = myRendererContext.getGraphicsAlgorithm();
		assertNotNull(graphicsAlgorithm);

		// test getMappingProvider()
		IMappingProvider mappingProvider = myRendererContext.getMappingProvider();
		assertNotNull(mappingProvider);

		// test getPlatformGraphicsAlgorithm()
		PlatformGraphicsAlgorithm platformGraphicsAlgorithm = myRendererContext.getPlatformGraphicsAlgorithm();
		assertNotNull(platformGraphicsAlgorithm);
		assertTrue(platformGraphicsAlgorithm.equals(platformGraphicsAlgorithmMock));
	}

	public void testPackageComSapMiGfwUtil() throws Exception {
		// test com.sap.mi.gfw.util.LocationInfo
		Shape shapeMock = createNiceMock(Shape.class);
		replay(shapeMock);

		GraphicsAlgorithm graphicsAlgorithmMock = createNiceMock(GraphicsAlgorithm.class);
		replay(graphicsAlgorithmMock);

		LocationInfo myLocationInfo = new LocationInfo(shapeMock, graphicsAlgorithmMock);

		assertTrue(shapeMock.equals(myLocationInfo.getShape()));

		assertTrue(graphicsAlgorithmMock.equals(myLocationInfo.getGraphicsAlgorithm()));

		// #########################################################

		// test com.sap.mi.gfw.util.PeUtilInternal
		graphicsAlgorithmMock = createNiceMock(GraphicsAlgorithm.class);
		expect(graphicsAlgorithmMock.getX()).andReturn(10).anyTimes();
		expect(graphicsAlgorithmMock.getY()).andReturn(10).anyTimes();
		replay(graphicsAlgorithmMock);

		PictogramElement pictogramElementMock = createNiceMock(PictogramElement.class);
		expect(pictogramElementMock.getGraphicsAlgorithm()).andReturn(graphicsAlgorithmMock).anyTimes();
		replay(pictogramElementMock);

		// test public static void
		// movePictogramElementsIntoPositiveRegion(Diagram diagram)
		shapeMock = createNiceMock(Shape.class);
		expect(shapeMock.getGraphicsAlgorithm()).andReturn(graphicsAlgorithmMock).anyTimes();
		replay(shapeMock);
		List<Shape> shapeList = new Vector<Shape>();
		shapeList.add(shapeMock);

		// com.sap.mi.gfw.mm.datatypes.Point pointMock =
		// createNiceMock(com.sap.mi.gfw.mm.datatypes.Point.class);
		// expect(pointMock.getX()).andReturn(20).anyTimes();
		// expect(pointMock.getY()).andReturn(20).anyTimes();
		// replay(pointMock);
		Vector<com.sap.mi.gfw.mm.datatypes.Point> points = new Vector<com.sap.mi.gfw.mm.datatypes.Point>();
		// points.add(pointMock);

		ConnectionDecorator connectionDecoratorMock1 = createNiceMock(ConnectionDecorator.class);
		expect(connectionDecoratorMock1.isLocationRelative()).andReturn(new Boolean(true)).anyTimes();
		expect(connectionDecoratorMock1.getGraphicsAlgorithm()).andReturn(graphicsAlgorithmMock).anyTimes();
		replay(connectionDecoratorMock1);

		ConnectionDecorator connectionDecoratorMock2 = createNiceMock(ConnectionDecorator.class);
		expect(connectionDecoratorMock2.isLocationRelative()).andReturn(new Boolean(false)).anyTimes();
		expect(connectionDecoratorMock2.getGraphicsAlgorithm()).andReturn(graphicsAlgorithmMock).anyTimes();
		replay(connectionDecoratorMock2);

		Vector<ConnectionDecorator> decorators = new Vector<ConnectionDecorator>();
		decorators.add(connectionDecoratorMock1);
		decorators.add(connectionDecoratorMock2);

		FreeFormConnection connectionMock = createNiceMock(FreeFormConnection.class);
		expect(connectionMock.getBendpoints()).andReturn(points).anyTimes();
		expect(connectionMock.getConnectionDecorators()).andReturn(decorators).anyTimes();
		expect(connectionMock.getGraphicsAlgorithm()).andReturn(graphicsAlgorithmMock).anyTimes();
		replay(connectionMock);

		Collection<com.sap.mi.gfw.mm.pictograms.Connection> connections = new Vector<com.sap.mi.gfw.mm.pictograms.Connection>();
		connections.add(connectionMock);

		Diagram diagramMock = createNiceMock(Diagram.class);
		expect(diagramMock.getChildren()).andReturn(shapeList).anyTimes();
		expect(diagramMock.getConnections()).andReturn(connections).anyTimes();
		replay(diagramMock);

		// test public static java.awt.Point
		// getTranslationVectorToOrigin(Diagram diagram)
		decorators = new Vector<ConnectionDecorator>();
		// decorators.add(connectionDecoratorMock1);
		decorators.add(connectionDecoratorMock2);

		connectionMock = createNiceMock(FreeFormConnection.class);
		expect(connectionMock.getBendpoints()).andReturn(points).anyTimes();
		expect(connectionMock.getConnectionDecorators()).andReturn(decorators).anyTimes();
		expect(connectionMock.getGraphicsAlgorithm()).andReturn(graphicsAlgorithmMock).anyTimes();
		replay(connectionMock);

		connections = new Vector<com.sap.mi.gfw.mm.pictograms.Connection>();
		connections.add(connectionMock);

		diagramMock = createNiceMock(Diagram.class);
		expect(diagramMock.getChildren()).andReturn(shapeList).anyTimes();
		expect(diagramMock.getConnections()).andReturn(connections).anyTimes();
		replay(diagramMock);

		// #########################################################

		// test com.sap.mi.gfw.util.PeUtil
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);
		final Diagram diagram = diagramEditor.getDiagramTypeProvider().getDiagram();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider diagramTypeProvider = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = diagramTypeProvider.getFeatureProvider();
				Diagram currentDiagram = diagramTypeProvider.getDiagram();

				addClassToDiagram(fp, currentDiagram, -100, -100, "Connection");
				addClassToDiagram(fp, currentDiagram, -700, -200, "ConnectionDecorator");

				final com.sap.mi.gfw.mm.pictograms.Connection connection = (com.sap.mi.gfw.mm.pictograms.Connection) currentDiagram
						.getConnections().toArray()[0];

				assertNotNull(PeUtil.getConnectionMidpoint(connection, 0.5));
				moveClassShape(fp, currentDiagram, 300, 300, "Connection");
			}

		});

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				PeUtil.setPropertyValue(diagram, "Test", "test");
				Property property = PeUtil.getProperty(diagram, "Test");
				assertTrue("test".equals(property.getValue()));
			}
		});

		pictogramElementMock = createNiceMock(PictogramElement.class);
		replay(pictogramElementMock);
		// PeUtil.setInsets(pictogramElementMock, 10, 10, 10, 10);

		waitForRefresh();

		closeEditor(diagramEditor);
	}
}
