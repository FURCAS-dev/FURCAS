package com.sap.mi.gfw.eclipse.internal.platform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;

import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ui.MarkerManagerUI;
import com.sap.mi.gfw.ILabelProvider;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.datatypes.impl.DimensionImpl;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.GraphicsPlugin;
import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditorDummy;
import com.sap.mi.gfw.eclipse.internal.util.DataTypeTransformation;
import com.sap.mi.gfw.eclipse.platform.PlatformUtil;
import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.pictograms.AbstractText;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.Font;
import com.sap.mi.gfw.platform.ColoredFont;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.mi.gfw.platform.IPlatformService;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class PlatformServiceImpl implements IPlatformService {

    protected static IPlatformService singleton;

    protected PlatformServiceImpl() {
        super();
    }

    public static IPlatformService getSingleton() {
        if (singleton == null) {
            singleton = new PlatformServiceImpl();
        }
        return singleton;
    }

    public String askString(String title, String message, String oldString) {
        String ret = null;
        Shell shell = GraphicsPlugin.getShell();
        InputDialog inputDialog = new InputDialog(shell, title, message,
                oldString, null);
        int retDialog = inputDialog.open();
        if (retDialog == Window.OK) {
            ret = inputDialog.getValue();
        }
        return ret;
    }

    public boolean askUser(String dialogTitle, String message) {
        boolean ret = false;
        Shell shell = GraphicsPlugin.getShell();
        ret = MessageDialog.openQuestion(shell, dialogTitle, message);
        return ret;
    }

    public Color editColor(Color color) {
        if (color != null && color.refImmediateComposite() instanceof Diagram) {
            Shell shell = GraphicsPlugin.getShell();
            ColorDialog colorDialog = new ColorDialog(shell);
            colorDialog.setText(Messages.PlatformServiceImpl_0_xfld);
            colorDialog.setRGB(new RGB(color.getRed(), color.getGreen(), color
                    .getBlue()));

            RGB retRgb = colorDialog.open();
            if (retRgb == null) {
                return null;
            }

            RefFeatured refImmediateComposite = color.refImmediateComposite();
            Diagram diagram = (Diagram) refImmediateComposite;
            Color newColor = GaUtil.manageColor(diagram, retRgb.red,
                    retRgb.green, retRgb.blue);
            return newColor;

        }

        return null;
    }

    public ColoredFont editFont(AbstractText text, ColoredFont coloredFont,
            Diagram diagram) {
        Font inputFont = coloredFont.getFont();
        Color inputColor = coloredFont.getColor();

        Shell shell = GraphicsPlugin.getShell();
        FontDialog fontDialog = new FontDialog(shell);
        FontData fontData = DataTypeTransformation.toFontData(inputFont);

        fontDialog.setFontList(new FontData[] { fontData });
        RGB rgb = new RGB(inputColor.getRed(), inputColor.getGreen(),
                inputColor.getBlue());
        fontDialog.setRGB(rgb);

        FontData retFontData = fontDialog.open();

        if (retFontData == null) {
            return null;
        }

        Font retFont = DataTypeTransformation.toPictogramsFont(text,
                retFontData);
        RGB retRgb = fontDialog.getRGB();
        Color retColor = DataTypeTransformation.toPictogramsColor(retRgb,
                diagram);

        ColoredFont ret = new ColoredFont(retFont, retColor);

        return ret;
    }

    public Object[] objectSelection(String title, String message,
            Object[] selectableElements, Object[] selectedElements,
            boolean singleSelection, ILabelProvider labelProvider) {
        final Object[] passedSelectableElements = new Object[selectableElements.length];
        System.arraycopy(selectableElements, 0, passedSelectableElements, 0,
                passedSelectableElements.length);
        // label provider
        org.eclipse.jface.viewers.ILabelProvider eclipseLabelProvider = new LabelProvider(); // no
        // icons
        if (labelProvider != null) {
            eclipseLabelProvider = new LabelProviderAdapter(labelProvider);
        }
        ListSelectionDialog osd = new ListSelectionDialog(GraphicsPlugin
                .getShell(), null, new IStructuredContentProvider() {

            @Override
            public void inputChanged(Viewer viewer, Object oldInput,
                    Object newInput) {
                // TODO Auto-generated method stub

            }

            @Override
            public void dispose() {
                // TODO Auto-generated method stub

            }

            @Override
            public Object[] getElements(Object inputElement) {
                return passedSelectableElements;
            }
        }, eclipseLabelProvider, message);
        // osd.setSingleSelection(singleSelection);
        // osd.setObjectSorter(new ViewerSorter());
        osd.setInitialSelections(selectedElements);
        osd.open();
        Object selectedObjects[] = osd.getResult();
        return selectedObjects;
    }

    private class LabelProviderAdapter extends LabelProvider {

        private ILabelProvider labelProviderDelegate;

        public LabelProviderAdapter(ILabelProvider labelProvider) {
            setLabelProviderDelegate(labelProvider);
        }

        @Override
        public Image getImage(Object element) {
            Image ret = super.getImage(element);
            // String imageIdFromDelegate =
            // getLabelProviderDelegate().getImageId(
            // element);
            // if (imageIdFromDelegate != null) {
            // Image imageFromPool = ImagePool
            // .getImageForId(imageIdFromDelegate);
            // if (imageFromPool != null) {
            // ret = imageFromPool;
            // }
            // }
            return ret;
        }

        private ILabelProvider getLabelProviderDelegate() {
            return labelProviderDelegate;
        }

        @Override
        public String getText(Object element) {
            String ret = super.getText(element);
            String textFromDelegate = getLabelProviderDelegate().getText(
                    element);
            if (textFromDelegate != null) {
                ret = textFromDelegate;
            }
            return ret;
        }

        private void setLabelProviderDelegate(
                ILabelProvider labelProviderDelegate) {
            this.labelProviderDelegate = labelProviderDelegate;
        }
    }

    public void openDiagram(Diagram diagram, String providerId) {
        PlatformUtil.openDiagramEditor(diagram, null, providerId);
    }

    public boolean doFixes(RefObject[] objects) {
        boolean ret = false;
        List<IMarker> markerList = new ArrayList<IMarker>();
        MarkerManagerUI mmUi = MarkerManagerUI.getInstance();
        for (RefObject bo : objects) {
            if (bo != null) {
                IMarker[] markersFound = MarkerManager.getInstance()
                        .findMarkers(bo, IMarker.PROBLEM, true,
                                IResource.DEPTH_INFINITE);
                for (IMarker marker : markersFound) {
                    markerList.add(marker);
                }
            }
        }

        IMarker[] toArray = markerList.toArray(new IMarker[] {});
        ret = mmUi.runQuickfix(toArray);
        return ret;
    }

    public boolean canDoFixes(RefObject[] objects) {
        List<IMarker> markerList = new ArrayList<IMarker>();
        MarkerManagerUI mmUi = MarkerManagerUI.getInstance();
        for (RefObject bo : objects) {
            if (bo != null) {
                IMarker[] markersFound = MarkerManager.getInstance()
                        .findMarkers(bo, IMarker.PROBLEM, true,
                                IResource.DEPTH_INFINITE);
                for (IMarker marker : markersFound) {
                    markerList.add(marker);
                }
            }
        }

        IMarker[] toArray = markerList.toArray(new IMarker[markerList.size()]);
        return mmUi.hasQuickfixes(toArray);
    }

    public void asyncExec(Runnable runnable) {
        Display.getCurrent().asyncExec(runnable);
    }

    public void syncExec(Runnable runnable) {
        Display.getCurrent().syncExec(runnable);
    }

    public IDiagramEditor createDiagramEditorDummy(
            IDiagramTypeProvider diagramTypeProvider) {
        DiagramEditorDummy diagramEditor = new DiagramEditorDummy(
                diagramTypeProvider);
        return diagramEditor;
    }

    public IDimension calculateTextSize(String text, Font font) {
        IDimension dimension = null;
        if (text == null || font == null || font.getName() == null) {
            return dimension;
        }

        org.eclipse.swt.graphics.Font swtFont = DataTypeTransformation
                .toSwtFont(font);
        if (swtFont != null) {
            Dimension se = TextUtilities.INSTANCE.getStringExtents(text,
                    swtFont);
            if (se != null) {
                dimension = new DimensionImpl(se.width, se.height);
            }
            if (!swtFont.isDisposed()) {
                swtFont.dispose();
            }
        }
        return dimension;
    }

}
