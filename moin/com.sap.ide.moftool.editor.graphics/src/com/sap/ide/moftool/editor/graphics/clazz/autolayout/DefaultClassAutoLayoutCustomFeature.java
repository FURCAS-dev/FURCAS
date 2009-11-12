package com.sap.ide.moftool.editor.graphics.clazz.autolayout;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import y.layout.LayoutOrientation;
import y.layout.orthogonal.DirectedOrthogonalLayouter;

import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.EnumTypeUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.StructureTypeUtil;
import com.sap.mi.gfw.autolayout.AutoLayoutEngine;
import com.sap.mi.gfw.autolayout.DefaultLayoutStructureProvider;
import com.sap.mi.gfw.autolayout.ILayoutStructureProvider;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.internal.autolayout.IGraphTransformation;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;

public class DefaultClassAutoLayoutCustomFeature extends AbstractCustomFeature {

    public DefaultClassAutoLayoutCustomFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public boolean isAvailable(IContext context) {
        if (context instanceof ICustomContext) {
            ICustomContext cc = (ICustomContext) context;
            PictogramElement[] pis = cc.getPictogramElements();
            if (pis.length > 0) {
                if (pis[0] instanceof Diagram) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean canExecute(ICustomContext context) {
        return true;
    }

    public void execute(ICustomContext context) {

        // calculate node size
        if (context instanceof ICustomContext) {
            ICustomContext cc = (ICustomContext) context;
            PictogramElement[] pis = cc.getPictogramElements();
            Diagram diag = null;
            List<Shape> children = null;
            int newWidth = 0;
            if (pis.length > 0) {
                if (pis[0] instanceof Diagram) {
                    diag = (Diagram) pis[0];
                    children = diag.getChildren();
                    Iterator<Shape> it = children.iterator();
                    while (it.hasNext()) {
                        Object childObj = it.next();
                        if (childObj instanceof ContainerShape) {
                            ContainerShape cs = (ContainerShape) childObj;
                            Object bo = getBusinessObjectForPictogramElement(cs);
                            if (bo instanceof MofClass) {
                                newWidth = ClassUtil.calculateASuitableWidth((MofClass) bo);
                            } else if (bo instanceof EnumerationType) {
                                newWidth = EnumTypeUtil.calculateASuitableWidth((EnumerationType) bo);
                            } else if (bo instanceof StructureType) {
                                newWidth = StructureTypeUtil.calculateASuitableWidth((StructureType) bo);
                            }
                            if (newWidth != 0) {
                                cs.getGraphicsAlgorithm().setWidth(newWidth);
                            }
                        }
                    }
                }
            }
        }

        // obsolete
// HierarchicGroupLayouter layOuter = DefaultLayouterFactory.getHierarchicalGroupLayouter();
// layOuter.setMinimalLayerDistance(120);
// layOuter.setMinimalNodeDistance(180);
// layOuter.setMaximalDuration(250);
// layOuter.setSelfLoopLayouterEnabled(false);
//
// ILayoutStructureProvider lsp = new ClassInheritanceLayoutStructureProvider(getDiagram());
// AutoLayoutEngine.autoLayout(layOuter, getFeatureProvider(), lsp);

        // define layout
        DirectedOrthogonalLayouter layOuter = new DirectedOrthogonalLayouter();
        layOuter.setLayoutOrientation(LayoutOrientation.BOTTOM_TO_TOP);
        layOuter.setGrid(40);
//		

        // define graph transformation and do layout
        ILayoutStructureProvider lsp = new DefaultLayoutStructureProvider(getDiagram());
        IGraphTransformation mofGraphTransformation = new MofGraphTransformation(getFeatureProvider(), lsp);
        AutoLayoutEngine.autoLayout(layOuter, mofGraphTransformation);

        // assign additional bend points to partition
        ModelPartition partition = ((Partitionable) getDiagram()).get___Partition();
        Connection connection = ((Partitionable) getDiagram()).get___Connection();
        ModelPartition nullPartition = connection.getNullPartition();
        Iterator<Partitionable> it = nullPartition.getElements().iterator();
// ((Partitionable)getDiagram()).assign___PartitionIncludingChildren(partition);
        while (it.hasNext()) {
            Partitionable element = (Partitionable) it.next();
            partition.assignElement(element);
        }

    }

    public String getName() {
        return Messages.DefaultClassAutoLayoutCustomFeature_0_xbut;
    }
}
