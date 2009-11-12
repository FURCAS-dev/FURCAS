package com.sap.ide.moftool.editor.graphics.serviceLayer.clazz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.ide.moftool.editor.core.service.ClassService;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.LinkUtil;

public class DiagramUtil {

    public static ContainerShape getExistingMofClassShapeFromDiagram(Diagram diagram, MofClass mofClass) {
        List<Shape> ch = diagram.getChildren();
        for (ListIterator<Shape> iter = ch.listIterator(); iter.hasNext();) {
            PictogramElement pe = (PictogramElement) iter.next();
            RefObject refObject = LinkUtil.getBusinessObjectForLinkedPictogramElement(pe);
            if (refObject instanceof MofClass) {
                MofClass existMofClass = (MofClass)refObject;
                if (existMofClass.equals(mofClass)) {
                    return (ContainerShape)pe;
                }
            }
        }
        return null;
    }

    public static boolean existAssocitionInDiagram(Diagram diagram, Association association) {
        Collection<Connection> ch = diagram.getConnections();
        for (Iterator<Connection> iter = ch.iterator(); iter.hasNext();) {
            Connection connection = iter.next();
            if (connection instanceof Connection){
                RefObject refObject = LinkUtil.getBusinessObjectForLinkedPictogramElement(connection);
                if (refObject instanceof Association) {
                    Association existAssociation = (Association)refObject;
                    if (association.equals(existAssociation)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean existsClassInDiagram(Diagram diagram, MofClass pclass) {
        List<Shape> ch = diagram.getChildren();      
        for (ListIterator<Shape> iter = ch.listIterator(); iter.hasNext();) {
            PictogramElement pe = (PictogramElement) iter.next();
            RefObject refObject = LinkUtil.getBusinessObjectForLinkedPictogramElement(pe);
            if (refObject instanceof MofClass) {
               MofClass mofClass  = (MofClass)refObject;
               if(mofClass.equals(pclass)){
                   return true;
               }
            }
        }
        return false;
    }

    public static boolean existAllAssociationOfMofClassInDiagram(Diagram diagram, MofClass mofClass) {
        List<Association> assocs = ClassService.getAllAssociations(mofClass);
        for(ListIterator<Association> iter = assocs.listIterator(); iter.hasNext();){
            if(!existAssocitionInDiagram(diagram, iter.next())){
                return false;
            }
        }
        
        return true;
    }

    public static List<ContainerShape> getAllClassContainerShapesFromDiagram(Diagram diagram) {
        List<Shape> ch = diagram.getChildren();
        List<ContainerShape> result = new ArrayList<ContainerShape>();
        for (ListIterator<Shape> iter = ch.listIterator(); iter.hasNext();) {
            Shape pe = iter.next();
            RefObject refObject = LinkUtil.getBusinessObjectForLinkedPictogramElement(pe);
            if (refObject instanceof MofClass) {
                result.add((ContainerShape) pe);
            }
        }
        return result;
    }

    public static PictogramElement getPictogramElementByName(String name, Diagram diagram) {
        List<Shape> ch = diagram.getChildren();      
        for (ListIterator<Shape> iter = ch.listIterator(); iter.hasNext();) {
            PictogramElement pe = (PictogramElement) iter.next();
            RefObject refObject = LinkUtil.getBusinessObjectForLinkedPictogramElement(pe);
            if (refObject instanceof MofClass) {
               MofClass mofClass  = (MofClass) refObject;
               if(mofClass.getName().equals(name)){
                   return pe;
               }
            }
        }
        return null;
    }
}