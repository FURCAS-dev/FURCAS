package com.sap.mi.gfw.test;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.internal.presentations.PresentablePart;
import org.eclipse.ui.internal.presentations.defaultpresentation.DefaultTabItem;

import abbot.swt.Robot;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LCTabItem;
import com.sap.ide.junit.ui.lift.LCanvas;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.internal.command.CreateModelObjectCommand;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.editor.GFWFigureCanvas;
import com.sap.mi.gfw.eclipse.internal.policy.ShapeXYLayoutEditPolicy;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.samples.dt.IDiagramTypeConstants;

public class GfwIacTests extends AbstractGfwTests {

	public GfwIacTests() {
		super();
	}

	public void testSelectionTool() throws Exception {
		final int x = 100;
		final int y = 100;
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);
		final LFactory f = FactoryBuilder.newAbbotFactory();
		final Robot robot = new Robot(Display.getDefault());

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider diagramTypeProvider = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = diagramTypeProvider.getFeatureProvider();
				Diagram currentDiagram = diagramTypeProvider.getDiagram();

				addClassToDiagram(fp, currentDiagram, x, y, "Connection");
				addClassToDiagram(fp, currentDiagram, x, y + 300, "ConnectionDecorator");

			}

		});
		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				LShell shell = f.getShell(Display.getDefault());

				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();

					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);

					robot.setAutoDelay(1);

					robot.mouseMove(p.x - 10, p.y - 10);

					robot.mousePress(SWT.BUTTON1);

					robot.mouseMove(p.x + 500, p.y + 800);

					robot.mouseRelease(SWT.BUTTON1);

					robot.mouseMove(p.x + 50, p.y + 50);

					robot.mousePress(SWT.BUTTON1);

					robot.mouseMove(p.x + 200, p.y + 50);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}

		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				f.getShell(Display.getDefault());

				try {

					final Robot robot = new Robot(Display.getDefault());
					robot.setAutoDelay(1);

					try {
						robot.keyPress(SWT.ESC);
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						robot.keyRelease(SWT.ESC);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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

	public void testMarqueeTool() throws Exception {
		final int x = 100;
		final int y = 100;
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);
		final LFactory f = FactoryBuilder.newAbbotFactory();
		final Robot robot = new Robot(Display.getDefault());

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider diagramTypeProvider = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = diagramTypeProvider.getFeatureProvider();
				Diagram currentDiagram = diagramTypeProvider.getDiagram();

				addClassToDiagram(fp, currentDiagram, x, y, "Connection");
				addClassToDiagram(fp, currentDiagram, x, y + 300, "ConnectionDecorator");

				activateTool(diagramEditor.getEditDomain(), "Marquee");

			}

		});
		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				LShell shell = f.getShell(Display.getDefault());

				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();
					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);

					robot.setAutoDelay(1);

					robot.mouseMove(p.x - 10, p.y - 10);

					robot.mousePress(SWT.BUTTON1);

					robot.mouseMove(p.x + 500, p.y + 800);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}

			}

		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				LShell shell = f.getShell(Display.getDefault());

				try {

					activateTool(diagramEditor.getEditDomain(), "Select");

					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();

					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);

					robot.mouseMove(p.x + 50, p.y + 50);

					robot.mousePress(SWT.BUTTON1);

					robot.mouseMove(p.x + 200, p.y + 50);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}

		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				f.getShell(Display.getDefault());

				try {

					final Robot robot = new Robot(Display.getDefault());
					robot.setAutoDelay(1);

					try {
						robot.keyPress(SWT.ESC);
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						robot.keyRelease(SWT.ESC);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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

	public void testGFWFigureCanvas() throws Exception {
		final int x = 100;
		final int y = 100;
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);
		final LFactory f = FactoryBuilder.newAbbotFactory();
		final Robot robot = new Robot(Display.getDefault());
		robot.setAutoDelay(1);

		final org.eclipse.swt.graphics.Point absPositionOfClass = new org.eclipse.swt.graphics.Point(0, 0);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				// find diagram
				IDiagramTypeProvider diagramTypeProvider = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = diagramTypeProvider.getFeatureProvider();
				Diagram currentDiagram = diagramTypeProvider.getDiagram();

				// add a class to the diagram
				addClassToDiagram(fp, currentDiagram, x, y, "Connection");
				LShell shell = f.getShell(Display.getDefault());
				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();
					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);

					absPositionOfClass.x = p.x;
					absPositionOfClass.y = p.y;
				} catch (WidgetException e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		// move class-shape
		try {
			robot.mouseMove(absPositionOfClass.x + 50, absPositionOfClass.y + 50);
			robot.mousePress(SWT.BUTTON1);
			robot.mouseMove(0, 0);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
		} finally {
			robot.mouseRelease(SWT.BUTTON1);
		}

		waitForRefresh();
		Thread.sleep(500);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				LShell shell = f.getShell(Display.getDefault());

				try {
					// get instance of GFWFigureCanvas
					LCanvas liftCanvas = shell.canvas().withName(GFWFigureCanvas.class.toString()).andShows().resolve();
					Canvas canvas = liftCanvas.getWidget();
					if (!(canvas instanceof GFWFigureCanvas))
						return;
					GFWFigureCanvas gfwFigureCanvas = (GFWFigureCanvas) canvas;

					// do some scrolling
					Event e = new Event();
					e.doit = true;
					e.stateMask = 0;

					e.detail = SWT.ARROW_UP;
					gfwFigureCanvas.getHorizontalBar().notifyListeners(SWT.Selection, e);
					gfwFigureCanvas.getVerticalBar().notifyListeners(SWT.Selection, e);

					e.detail = SWT.ARROW_DOWN;
					gfwFigureCanvas.getHorizontalBar().notifyListeners(SWT.Selection, e);
					gfwFigureCanvas.getVerticalBar().notifyListeners(SWT.Selection, e);

					e.detail = SWT.PAGE_UP;
					gfwFigureCanvas.getHorizontalBar().notifyListeners(SWT.Selection, e);
					gfwFigureCanvas.getVerticalBar().notifyListeners(SWT.Selection, e);

					e.detail = SWT.PAGE_DOWN;
					gfwFigureCanvas.getHorizontalBar().notifyListeners(SWT.Selection, e);
					gfwFigureCanvas.getVerticalBar().notifyListeners(SWT.Selection, e);
				} catch (WidgetException e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(200);

		// ensure selection of class-shape
		// try {
		// robot.keyPress(SWT.ALT | 'a');
		// } catch (RuntimeException e1) {
		// e1.printStackTrace();
		// } finally {
		// robot.keyRelease(SWT.ALT | 'a');
		// }
		//
		// waitForRefresh();
		// Thread.sleep(500);

		// delete class-shape
		// robot.keyPress(SWT.DEL | SWT.SHIFT | SWT.KEYCODE_BIT);
		// robot.keyRelease(SWT.DEL | SWT.SHIFT | SWT.KEYCODE_BIT);
		Event event = new Event();
		event.type = SWT.KeyDown;
		event.keyCode = SWT.DEL;
		event.character = SWT.DEL;
		event.stateMask = 0; // SWT.SHIFT;
		Display.getDefault().post(event);

		try {
			robot.keyPress(SWT.CR);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			robot.keyRelease(SWT.CR);
		}

		waitForRefresh();
		Thread.sleep(500);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				LShell shell = f.getShell(Display.getDefault());

				try {
					// regain space
					LCanvas liftCanvas = shell.canvas().withName(GFWFigureCanvas.class.toString()).andShows().resolve();
					Canvas canvas = liftCanvas.getWidget();
					if (!(canvas instanceof GFWFigureCanvas))
						return;
					GFWFigureCanvas gfwFigureCanvas = (GFWFigureCanvas) canvas;

					gfwFigureCanvas.regainSpace();

				} catch (WidgetException e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(2000);

		// close diagram
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testMouseLocation() throws Exception {
		/*
		 * regression test for CSN 0120031469 0003790113 2008
		 */
		final int x = 100;
		final int y = 100;
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);
		final LFactory f = FactoryBuilder.newAbbotFactory();
		final Robot robot = new Robot(Display.getDefault());
		robot.setAutoDelay(1);

		final org.eclipse.swt.graphics.Point absPositionOfClass = new org.eclipse.swt.graphics.Point(0, 0);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				// find diagram
				IDiagramTypeProvider diagramTypeProvider = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = diagramTypeProvider.getFeatureProvider();
				Diagram currentDiagram = diagramTypeProvider.getDiagram();

				// add a class to the diagram
				addClassToDiagram(fp, currentDiagram, x, y, "Connection");
				LShell shell = f.getShell(Display.getDefault());
				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();
					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);

					absPositionOfClass.x = p.x;
					absPositionOfClass.y = p.y;
				} catch (WidgetException e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		// move class-shape to the origin (0,0)
		try {
			robot.mouseMove(absPositionOfClass.x + 50, absPositionOfClass.y + 50);
			robot.mousePress(SWT.BUTTON1);
			robot.mouseMove(0, 0);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
		} finally {
			robot.mouseRelease(SWT.BUTTON1);
		}

		waitForRefresh();
		Thread.sleep(2000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				LShell shell = f.getShell(Display.getDefault());

				try {
					// get instance of GFWFigureCanvas
					LCanvas liftCanvas = shell.canvas().withName(GFWFigureCanvas.class.toString()).andShows().resolve();
					Canvas canvas = liftCanvas.getWidget();
					if (!(canvas instanceof GFWFigureCanvas))
						return;
					GFWFigureCanvas gfwFigureCanvas = (GFWFigureCanvas) canvas;

					// scroll shape into visible region
					Event e = new Event();
					e.doit = true;
					e.stateMask = 0;

					e.detail = SWT.ARROW_UP;
					gfwFigureCanvas.getHorizontalBar().notifyListeners(SWT.Selection, e);
					gfwFigureCanvas.getVerticalBar().notifyListeners(SWT.Selection, e);

				} catch (WidgetException e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(2000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				LShell shell = f.getShell(Display.getDefault());

				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();

					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);

					final Robot robot = new Robot(Display.getDefault());
					robot.setAutoDelay(1);

					// values found by trail and error; mouse should be in the
					// middle of the shape
					robot.mouseMove(p.x + 35, p.y);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(2000);

		PictogramElement[] selectedPictogramElements = diagramEditor.getSelectedPictogramElements();
		for (PictogramElement pictogramElement : selectedPictogramElements) {
			if (pictogramElement instanceof ContainerShape) {
				GraphicsAlgorithm containerShapeGa = pictogramElement.getGraphicsAlgorithm();
				Rectangle rectangle = new Rectangle(containerShapeGa.getX(), containerShapeGa.getY(), containerShapeGa.getWidth(),
						containerShapeGa.getHeight());
				org.eclipse.draw2d.geometry.Point mouseLocation = diagramEditor
						.calculateRealMouseLocation(diagramEditor.getMouseLocation());
				boolean mouseIsInsideShape = rectangle.contains(mouseLocation);
				assertEquals(" Wrong mouse coordinates :  ", true, mouseIsInsideShape);
				break;
			}
		}

		waitForRefresh();
		Thread.sleep(500);

		// close diagram
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testContextButtons() throws Exception {
		final int x = 100;
		final int y = 100;
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);
		final LFactory f = FactoryBuilder.newAbbotFactory();
		// final Widget widget = AbbotUtil.findWidget(VIEW_REGEXP);
		// FactoryBuilder.newAbbotFactory().dumpWidgetHierarchy();
		// org.eclipse.swt.graphics.Point p2 =
		// Display.getDefault().getCursorLocation();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider diagramTypeProvider = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = diagramTypeProvider.getFeatureProvider();
				Diagram currentDiagram = diagramTypeProvider.getDiagram();

				addClassToDiagram(fp, currentDiagram, x, y, "Connection");
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				LShell shell = f.getShell(Display.getDefault());

				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();

					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);

					final Robot robot = new Robot(Display.getDefault());
					robot.setAutoDelay(1);

					robot.mouseMove(p.x + 50, p.y + 50);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				f.getShell(Display.getDefault());

				try {
					final Robot robot = new Robot(Display.getDefault());
					robot.setAutoDelay(1);

					try {
						robot.mousePress(SWT.BUTTON3);
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						robot.mouseRelease(SWT.BUTTON3);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				f.getShell(Display.getDefault());

				try {
					final Robot robot = new Robot(Display.getDefault());
					robot.setAutoDelay(1);

					try {
						robot.keyPress(SWT.ESC);
						robot.keyRelease(SWT.ESC);
						robot.keyPress(SWT.DEL);
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						robot.keyRelease(SWT.DEL);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				f.getShell(Display.getDefault());

				try {
					final Robot robot = new Robot(Display.getDefault());
					robot.setAutoDelay(1);

					try {
						robot.keyPress(SWT.CR);
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						robot.keyRelease(SWT.CR);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testDropOnConnection() throws Exception {
		final int xOfShape1 = 100;
		final int yOfShape1 = 100;

		final int xOfShape2 = 100;
		final int yOfShape2 = 400;

		final int xOfShape3 = 400;
		final int yOfShape3 = 100;

		final int xOfShape4 = 400;
		final int yOfShape4 = 400;

		final int width = 60;
		final int height = 60;

		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
		final LFactory f = FactoryBuilder.newAbbotFactory();

		final Robot robot = new Robot(Display.getDefault());
		robot.setAutoDelay(10);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = dtp.getFeatureProvider();

				CommandStack commandStack = diagramEditor.getEditDomain().getCommandStack();

				ICreateFeature[] createFeatures = fp.getCreateFeatures();
				for (ICreateFeature createFeature : createFeatures) {
					if (!("Rectangle".equals(createFeature.getName())))
						continue;

					Rectangle rectangle = new Rectangle(xOfShape1, yOfShape1, width, height);
					ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
					Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
							createContext, rectangle);
					commandStack.execute(createCommand);

					rectangle = new Rectangle(xOfShape2, yOfShape2, width, height);
					createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
					createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature, createContext,
							rectangle);
					commandStack.execute(createCommand);

					rectangle = new Rectangle(xOfShape3, yOfShape3, width, height);
					createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
					createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature, createContext,
							rectangle);
					commandStack.execute(createCommand);

					rectangle = new Rectangle(xOfShape4, yOfShape4, width, height);
					createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
					createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature, createContext,
							rectangle);
					commandStack.execute(createCommand);
				}
			}
		});

		waitForRefresh();

		final org.eclipse.swt.graphics.Point origin = new org.eclipse.swt.graphics.Point(0, 0);
		final org.eclipse.swt.graphics.Point midOfShape1Abs = new org.eclipse.swt.graphics.Point(0, 0);
		final org.eclipse.swt.graphics.Point midOfShape2Abs = new org.eclipse.swt.graphics.Point(0, 0);
		final org.eclipse.swt.graphics.Point midOfShape3Abs = new org.eclipse.swt.graphics.Point(0, 0);
		final org.eclipse.swt.graphics.Point midOfShape4Abs = new org.eclipse.swt.graphics.Point(0, 0);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				LShell shell = f.getShell(Display.getDefault());
				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();
					Object object = ((DefaultTabItem) diagramTab.getData()).getData();

					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(0, 0);
					origin.x = p.x;
					origin.y = p.y;

					// determine midpoints of each shape
					midOfShape1Abs.x = origin.x + xOfShape1 + width / 2;
					midOfShape1Abs.y = origin.y + yOfShape1 + height / 2;

					midOfShape2Abs.x = origin.x + xOfShape2 + width / 2;
					midOfShape2Abs.y = origin.y + yOfShape2 + height / 2;

					midOfShape3Abs.x = origin.x + xOfShape3 + width / 2;
					midOfShape3Abs.y = origin.y + yOfShape3 + height / 2;

					midOfShape4Abs.x = origin.x + xOfShape4 + width / 2;
					midOfShape4Abs.y = origin.y + yOfShape4 + height / 2;

					// p = ((PresentablePart)
					// object).getControl().toDisplay(xOfShape1, yOfShape1);
					// origin.x = p.x;
					// origin.y = p.y;

					// activate create-freeform-connection tool
					activateTool(diagramEditor.getEditDomain(), "free");

					// move to connection start point
					robot.mouseMove(midOfShape1Abs.x, midOfShape1Abs.y); // middle
					// shape
					// 1
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// move to connection end point
					robot.mousePress(SWT.BUTTON1);
					robot.mouseRelease(SWT.BUTTON1);
					robot.mouseMove(midOfShape2Abs.x, midOfShape2Abs.y); // middle
					// shape
					// 2
					robot.mousePress(SWT.BUTTON1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// activate create-freeform-connection tool
					activateTool(diagramEditor.getEditDomain(), "free");

					// move to connection start point
					robot.mouseMove(midOfShape1Abs.x, midOfShape1Abs.y); // middle
					// shape
					// 1

					// move to connection end point
					robot.mousePress(SWT.BUTTON1);
					robot.mouseRelease(SWT.BUTTON1);
					robot.mouseMove(midOfShape3Abs.x, midOfShape3Abs.y); // middle
					// shape
					// 2
					robot.mousePress(SWT.BUTTON1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					activateTool(diagramEditor.getEditDomain(), "Rectangle");

					// move to middle of connection
					robot.mouseMove((midOfShape1Abs.x + midOfShape3Abs.x) / 2, midOfShape1Abs.y); // middle
					// connection

					robot.mousePress(SWT.BUTTON1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// move to middle of shape
					robot.mouseMove(midOfShape4Abs.x, midOfShape4Abs.y);

					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove(midOfShape1Abs.x, (midOfShape1Abs.y + midOfShape2Abs.y) / 2);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					robot.mouseMove(midOfShape1Abs.x, midOfShape1Abs.y);

					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove((midOfShape1Abs.x + midOfShape3Abs.x) / 2, (midOfShape1Abs.y + midOfShape2Abs.y) / 2);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testDirectEditing() throws Exception {
		final int x = 100;
		final int y = 100;
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
		final LFactory f = FactoryBuilder.newAbbotFactory();

		final Robot robot = new Robot(Display.getDefault());
		robot.setAutoDelay(50);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = dtp.getFeatureProvider();

				CommandStack commandStack = diagramEditor.getEditDomain().getCommandStack();

				ICreateFeature[] createFeatures = fp.getCreateFeatures();
				for (ICreateFeature createFeature : createFeatures) {
					if (!("Rectangle".equals(createFeature.getName())))
						continue;

					Rectangle rectangle = new Rectangle(x, y, 100, 100);
					ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
					Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
							createContext, rectangle);
					commandStack.execute(createCommand);
				}
			}
		});

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					robot.mouseMove(0, 0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				LShell shell = f.getShell(Display.getDefault());

				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();

					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);

					robot.mouseMove(p.x + 51, p.y + 51);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					robot.mousePress(SWT.BUTTON1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					robot.mousePress(SWT.BUTTON1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		robot.keyPress('G');
		robot.keyRelease('G');
		robot.keyPress('F');
		robot.keyRelease('F');
		robot.keyPress('W');
		robot.keyRelease('W');
		robot.keyPress(' ');
		robot.keyRelease(' ');
		robot.keyPress('R');
		robot.keyRelease('R');
		robot.keyPress('u');
		robot.keyRelease('u');
		robot.keyPress('l');
		robot.keyRelease('l');
		robot.keyPress('z');
		robot.keyRelease('z');
		robot.keyPress('!');
		robot.keyRelease('!');

		robot.keyPress(SWT.CR);
		robot.keyRelease(SWT.CR);

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testDropIntoContainer() throws Exception {
		final int x = 100;
		final int y = 100;
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
		final LFactory f = FactoryBuilder.newAbbotFactory();

		final Robot robot = new Robot(Display.getDefault());
		robot.setAutoDelay(1);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = dtp.getFeatureProvider();

				CommandStack commandStack = diagramEditor.getEditDomain().getCommandStack();

				ICreateFeature[] createFeatures = fp.getCreateFeatures();
				for (ICreateFeature createFeature : createFeatures) {
					if ("Rectangle".equals(createFeature.getName())) {
						Rectangle rectangle = new Rectangle(x, y, 100, 100);
						ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
						Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
								createContext, rectangle);
						commandStack.execute(createCommand);
					} else if ("Rectangle Container".equals(createFeature.getName())) {
						Rectangle rectangle = new Rectangle(x + 300, y - 50, 200, 200);
						ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
						Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
								createContext, rectangle);
						commandStack.execute(createCommand);
					}
				}
			}

		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				LShell shell = f.getShell(Display.getDefault());
				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();

					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x + 50, y + 50);
					robot.mouseMove(p.x, p.y);
					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove(p.x + 350, p.y);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testConnectionReassign() throws Exception {
		final int xContainer1 = 100;
		final int yContainer1 = 100;
		final int xContainer2 = 300;
		final int yContainer2 = 100;
		final int xContainer3 = 100;
		final int yContainer3 = 300;
		final int containerSize = 100;
		final int rectangleSize = 60;
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
		final LFactory f = FactoryBuilder.newAbbotFactory();

		final Robot robot = new Robot(Display.getDefault());
		robot.setAutoDelay(50);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = dtp.getFeatureProvider();

				CommandStack commandStack = diagramEditor.getEditDomain().getCommandStack();

				ICreateFeature[] createFeatures = fp.getCreateFeatures();
				for (ICreateFeature createFeature : createFeatures) {
					if ("Rectangle".equals(createFeature.getName())) {
						Rectangle rectangle = new Rectangle(xContainer1 + containerSize, yContainer1 + containerSize, rectangleSize,
								rectangleSize);
						ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
						Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
								createContext, rectangle);
						commandStack.execute(createCommand);

						rectangle = new Rectangle(xContainer2 + containerSize, yContainer2 + containerSize, rectangleSize, rectangleSize);
						createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
						createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
								createContext, rectangle);
						commandStack.execute(createCommand);
					} else if ("Rectangle Container".equals(createFeature.getName())) {
						Rectangle rectangle = new Rectangle(xContainer1, yContainer1, containerSize, containerSize);
						ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
						Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
								createContext, rectangle);
						commandStack.execute(createCommand);

						rectangle = new Rectangle(xContainer2, yContainer2, containerSize, containerSize);
						createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
						createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
								createContext, rectangle);
						commandStack.execute(createCommand);

						rectangle = new Rectangle(xContainer3, yContainer3, containerSize, containerSize);
						createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
						createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
								createContext, rectangle);
						commandStack.execute(createCommand);
					}
				}
			}

		});

		waitForRefresh();
		Thread.sleep(1000);

		final Point origin = new Point(0, 0);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				LShell shell = f.getShell(Display.getDefault());
				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();

					Object object = ((DefaultTabItem) diagramTab.getData()).getData();

					Point p = ((PresentablePart) object).getControl().toDisplay(0, 0);
					origin.x = p.x;
					origin.y = p.y;

					p = ((PresentablePart) object).getControl().toDisplay(xContainer1 + containerSize + rectangleSize / 2,
							yContainer1 + containerSize + rectangleSize / 2);

					robot.mouseMove(p.x, p.y);
					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove(p.x - (containerSize + rectangleSize) / 2, p.y - (containerSize + rectangleSize) / 2);

					robot.mouseRelease(SWT.BUTTON1);

					p = ((PresentablePart) object).getControl().toDisplay(xContainer2 + containerSize + rectangleSize / 2,
							yContainer2 + containerSize + rectangleSize / 2);
					robot.mouseMove(p.x, p.y);
					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove(p.x - (containerSize + rectangleSize) / 2, p.y - (containerSize + rectangleSize) / 2);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				try {
					// activate create-freeform-connection tool
					activateTool(diagramEditor.getEditDomain(), "free");

					// move to connection start point
					robot.mouseMove(origin.x + 100 + containerSize / 2, origin.y + 100 + containerSize / 2); // middle
					// shape 1
					robot.mousePress(SWT.BUTTON1);
					robot.mouseRelease(SWT.BUTTON1);
					robot.mouseMove(origin.x + 300 + containerSize / 2, origin.y + 100 + containerSize / 2); // middle
					// shape 2
					robot.mousePress(SWT.BUTTON1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				try {
					// activate selection tool
					activateDefaultTool(diagramEditor.getEditDomain());

					// move to connection start point
					robot.mouseMove(origin.x + 300 + containerSize / 2 - rectangleSize / 2 - 5, origin.y + 100 + containerSize / 2); // middle
					// shape
					// 1
					robot.mousePress(SWT.BUTTON1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		robot.mouseMove(origin.x + 300 + containerSize / 2 - rectangleSize / 2 - 1, origin.y + 100 + containerSize / 2);

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove(origin.x + 300 + containerSize / 2 - rectangleSize / 2 - 10, origin.y + 100 + containerSize / 2);
					robot.mouseRelease(SWT.BUTTON1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		robot.mouseMove(origin.x + 100 + containerSize / 2, origin.y + 100 + containerSize / 2);
		robot.mousePress(SWT.BUTTON1);
		robot.mouseMove(origin.x + 100 + containerSize / 2, origin.y + 300 + containerSize / 2);
		robot.mouseRelease(SWT.BUTTON1);

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testCreateConnection() throws Exception {
		final int x = 100;
		final int y = 100;
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
		final LFactory f = FactoryBuilder.newAbbotFactory();

		final Robot robot = new Robot(Display.getDefault());
		robot.setAutoDelay(50);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
				IFeatureProvider fp = dtp.getFeatureProvider();

				CommandStack commandStack = diagramEditor.getEditDomain().getCommandStack();

				ICreateFeature[] createFeatures = fp.getCreateFeatures();
				for (ICreateFeature createFeature : createFeatures) {
					if ("Rectangle".equals(createFeature.getName())) {
						Rectangle rectangle = new Rectangle(x, y, 100, 100);
						ICreateContext createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
						Command createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
								createContext, rectangle);
						commandStack.execute(createCommand);
						rectangle = new Rectangle(x + 200, y, 100, 100);
						createContext = ShapeXYLayoutEditPolicy.createCreateContext(dtp.getDiagram(), rectangle);
						createCommand = new CreateModelObjectCommand(diagramEditor.getConfigurationProvider(), createFeature,
								createContext, rectangle);
						commandStack.execute(createCommand);
					}
				}
			}

		});

		waitForRefresh();
		Thread.sleep(500);

		final org.eclipse.swt.graphics.Point origin = new org.eclipse.swt.graphics.Point(0, 0);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {

				LShell shell = f.getShell(Display.getDefault());
				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();
					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);
					origin.x = p.x;
					origin.y = p.y;

					// activate create-freeform-connection tool
					activateTool(diagramEditor.getEditDomain(), "free");

					// move to connection start point
					robot.mouseMove(origin.x + 50, origin.y + 50); // middle
					// shape 1
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(500);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// move to connection end point
					robot.mousePress(SWT.BUTTON1);
					robot.mouseRelease(SWT.BUTTON1);
					robot.mouseMove(origin.x + 250, origin.y + 50); // middle
					// shape 2
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(500);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// create connection
					robot.mousePress(SWT.BUTTON1);
					robot.mouseRelease(SWT.BUTTON1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(500);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// activate selection tool
					activateDefaultTool(diagramEditor.getEditDomain());

					// move to line-center and select line
					robot.mouseMove(origin.x + 150, origin.y + 50); // middle
					// between
					// shapes
					robot.mousePress(SWT.BUTTON1);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(500);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// move mouse to create new bendpoint
					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove(origin.x + 150, origin.y); // just move
					// upwards
					// sw robot.mouseRelease(SWT.BUTTON1);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(500);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// move mouse to move existing bendpoint
					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove(origin.x + 150, origin.y + 100); // just
					// move
					// downwards

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(500);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// move mouse to move start point to remove bendpoint
					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove(origin.x + 150, origin.y + 50);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(500);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// move mouse to move start point to remove bendpoint
					robot.mousePress(SWT.BUTTON1);
					robot.mouseMove(origin.x + 150, origin.y + 95);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(500);

		// remove the connection via context menu
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					robot.mouseMove(origin.x + 140, origin.y + 90);
					robot.mousePress(SWT.BUTTON3);
					robot.mouseRelease(SWT.BUTTON3);
					robot.keyPress(SWT.ARROW_DOWN);
					robot.keyRelease(SWT.ARROW_DOWN);
					robot.keyPress(SWT.ARROW_DOWN);
					robot.keyRelease(SWT.ARROW_DOWN);
					robot.keyPress(SWT.ARROW_DOWN);
					robot.keyRelease(SWT.ARROW_DOWN);
					robot.keyPress(SWT.ARROW_DOWN);
					robot.keyRelease(SWT.ARROW_DOWN);
					robot.keyPress(SWT.CR);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.keyRelease(SWT.CR);
				}
			}
		});

		waitForRefresh();
		Thread.sleep(1000);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public void testSketchAll() throws Exception {
		final DiagramEditor diagramEditor = openDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_ID_SKETCH);
		final LFactory f = FactoryBuilder.newAbbotFactory();
		final Robot robot = new Robot(Display.getDefault());

		final EditDomain editDomain = diagramEditor.getEditDomain();
		PaletteRoot paletteRoot = editDomain.getPaletteViewer().getPaletteRoot();
		PaletteDrawer drawer = (PaletteDrawer) paletteRoot.getChildren().get(2);
		final List toolEntries = drawer.getChildren();
		System.out.println("GfwIacTests.testSketchAll()" + toolEntries);

		final int x = 10;
		final int y = 6 * toolEntries.size();
		int counter = 0;
		for (Object o : toolEntries) {
			if (o instanceof ToolEntry) {
				ToolEntry toolEntry = (ToolEntry) o;
				final Tool currentTool = toolEntry.createTool();

				Display.getDefault().syncExec(new RunnableWithCounter(editDomain, currentTool, x, y, robot, f, counter));

				waitForRefresh();

				counter++;
			}
		}

		waitForRefresh();
		Thread.sleep(1000);

		waitForRefresh();

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				diagramEditor.doSave(null);
				closeEditor(diagramEditor);
			}
		});
	}

	public class RunnableWithCounter implements Runnable {
		private final EditDomain editDomain;

		private final Tool currentTool;

		private final int x;

		private final int y;

		private final Robot robot;

		private final LFactory f;

		private final int counter;

		public RunnableWithCounter(EditDomain editDomain, Tool currentTool, int x, int y, Robot robot, LFactory f, int counter) {
			super();
			this.editDomain = editDomain;
			this.currentTool = currentTool;
			this.x = x;
			this.y = y;
			this.robot = robot;
			this.f = f;
			this.counter = counter;
		}

		public void run() {
			editDomain.setActiveTool(currentTool);
			spanMouseArea(f, robot, x + (counter * 5), y - (5 * counter), 0, 0, 10, 10);
		}
	}

	private void spanMouseArea(final LFactory f, final Robot robot, final int x, final int y, final int dx1, final int dy1, final int dx2,
			final int dy2) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				LShell shell = f.getShell(Display.getDefault());

				try {
					LCTabItem diagramTab = shell.cTabItem().withText(VIEW_REGEXP).andShows().resolve();

					Object object = ((DefaultTabItem) diagramTab.getData()).getData();
					org.eclipse.swt.graphics.Point p = ((PresentablePart) object).getControl().toDisplay(x, y);

					robot.mouseMove(p.x + dx1, p.y + dy1);

					robot.mousePress(SWT.BUTTON1);

					robot.mouseMove(p.x + dx2, p.y + dy2);

					System.out.println("GfwIacTests.run()");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					robot.mouseRelease(SWT.BUTTON1);
				}
			}
		});
	}

}
