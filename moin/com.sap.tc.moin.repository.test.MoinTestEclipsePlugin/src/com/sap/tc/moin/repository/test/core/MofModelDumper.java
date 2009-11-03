/*
 * Created on 03.11.2005 TODO To change the template for this generated file go
 * to Window - Preferences - Java - Code Style - Code Templates
 */
package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;

/**
 * After analyzing the given Namespace content, you can dump the content with
 * the corresponding method dumpModel()
 * 
 * @author d045996
 */
public class MofModelDumper {

    public MofModelDumper( Namespace ns ) {

        rootNS = ns;
        metaTypes = clasifyContent( ns );
    }

    private Namespace rootNS = null;

    /*
     * Creates an String with the content of given Namespace Prefix Symbols: |
     * Frozen (ModelElement) & ClassifierScope (Feature) / Derived (Attribute,
     * Association) $ Changeable (StructuralFeature, AssociationEnd) < Root
     * (GeneralizableElement) > Leaf (GeneralizableElement) # Abstract
     * (GeneralizableElement) ! Singleton (Class) ? Query (Operation)
     * Association End Symbols: * Agregation < Navigable - Not Navigable
     */
    public String dumpModel( boolean includeMofIds, boolean includeConstrains ) {

        showMofId = includeMofIds;
        showConstrains = includeConstrains;
        StringBuffer res = new StringBuffer( "Content of '" + rootNS.getName( ) + "'\n" + "================================" );
        return res.append( serializeClassifiedContent( metaTypes, "" ) ).toString( );
    }

    private boolean showMofId = true;

    private boolean showConstrains = false;

    private boolean showPartition = false;

    private TreeMap metaTypes = null;

    private TreeMap clasifyContent( Namespace ns ) {

        TreeMap clasifiedContent = new TreeMap( );
        java.util.Iterator content = ns.getContents( ).iterator( );
        while ( content.hasNext( ) ) {
            com.sap.tc.moin.repository.mmi.model.ModelElement elem = (com.sap.tc.moin.repository.mmi.model.ModelElement) content.next( );
            classifyElement( clasifiedContent, elem );
        }
        return clasifiedContent;
    }

    // Classifies the model element using its class as key of the TreeMap
    private void classifyElement( TreeMap metaTypes, ModelElement elem ) {

        String elemType = elem.getClass( ).getName( );
        if ( !( metaTypes.containsKey( elemType ) ) ) {
            metaTypes.put( elemType, new ArrayList( ) );
        }
        ( (ArrayList) metaTypes.get( elemType ) ).add( elem );
    }

    // Serializing methods
    private StringBuffer serializeClassifiedContent( TreeMap metaTypes, String margin ) {

        StringBuffer str = new StringBuffer( );
        Iterator eit = null;

        String elemType = null;
        ModelElement elem = null;
        String partitionName;
        ModelPartition mp;

        Iterator it = metaTypes.keySet( ).iterator( );
        while ( it.hasNext( ) ) {
            elemType = (String) it.next( );
            str.append( "\n" + ( showMofId ? "                                    " : "" ) + ( showPartition ? "                                    " : "" ) + margin + "[" + elemType + "]" );
            eit = ( (ArrayList) metaTypes.get( elemType ) ).iterator( );
            while ( eit.hasNext( ) ) {
                partitionName = "";
                elem = (ModelElement) eit.next( );
                mp = ( (Partitionable) elem ).get___Partition( );
                if ( mp != null && mp.getPri( ) != null ) {
                    partitionName = mp.getPri( ).getPartitionName( );
                }
                str.append( "\n" + ( elem.isFrozen( ) ? "|" : "" ) + ( showMofId ? elem.refMofId( ) + "   " : "" ) + ( showPartition ? partitionName + "   " : "" ) + margin + serializeModelElement( elem, margin ) );
            }
        }
        return str;
    }

    private StringBuffer serializeModelElement( ModelElement elem, String margin ) {

        StringBuffer ser = new StringBuffer( );

        // Prefixes
        if ( elem instanceof Feature ) {
            ser.append( ( ScopeKindEnum.CLASSIFIER_LEVEL.equals( ( (Feature) elem ).getScope( ) ) ? "&" : "" ) );
        }
        if ( elem instanceof Attribute ) {
            ser.append( ( ( (Attribute) elem ).isDerived( ) ? "/" : "" ) );
        }
        if ( elem instanceof StructuralFeature ) {
            ser.append( ( ( (StructuralFeature) elem ).isChangeable( ) ? "$" : "" ) );
        }
        if ( elem instanceof Association ) {
            ser.append( ( ( (Association) elem ).isDerived( ) ? "/" : "" ) );
        }
        if ( elem instanceof MofClass ) {
            ser.append( ( ( (MofClass) elem ).isSingleton( ) ? "!" : "" ) );
        }
        if ( elem instanceof Operation ) {
            ser.append( ( ( (Operation) elem ).isQuery( ) ? "?" : "" ) );
        }
        if ( elem instanceof GeneralizableElement ) {
            ser.append( ( ( (GeneralizableElement) elem ).isAbstract( ) ? "#" : "" ) );
            ser.append( ( ( (GeneralizableElement) elem ).isRoot( ) ? "<" : "" ) );
            ser.append( ( ( (GeneralizableElement) elem ).isLeaf( ) ? ">" : "" ) );
        }

        // NAME
        ser.append( "'" + elem.getName( ) + "'" );

        if ( elem instanceof GeneralizableElement ) {
            ser.append( serializeGeneralizations( (GeneralizableElement) elem ) );
        }

        // For cross checking the Contains association
        ser.append( "{in '" + elem.getContainer( ).getName( ) + "'}" );

        // First Types that are serialized recursivelly (content)
        if ( elem instanceof MofPackage ) {
            ser.append( serializeNamespaceContent( (MofPackage) elem, margin ) );

        } else if ( elem instanceof MofClass ) {
            ser.append( serializeNamespaceContent( (MofClass) elem, margin ) );

        } else if ( elem instanceof Import ) {
            ser.append( ( ( (Import) elem ).isClustered( ) ? " clusters '" : " imports '" ) + ( (Import) elem ).getImportedNamespace( ).getName( ) + "'" );
            Namespace importedNS = ( (Import) elem ).getImportedNamespace( );
            ser.append( serializeNamespaceContent( importedNS, margin ) );

            // Then Types that are serialized directly
        } else if ( elem instanceof Association ) {
            AssociationEnd oneEnd = (AssociationEnd) ( (Association) elem ).getContents( ).get( 0 );
            AssociationEnd otherEnd = (AssociationEnd) ( (Association) elem ).getContents( ).get( 1 );
            ser.append( ": " + serializeAssociationEnd( oneEnd, -1 ) + "-" + serializeAssociationEnd( otherEnd, 1 ) );

        } else if ( elem instanceof Attribute ) {
            ser.append( serializeMultiplicity( ( (Attribute) elem ).getMultiplicity( ) ) + ":'" + ( (Attribute) elem ).getType( ).getName( ) + "'" );

        } else if ( elem instanceof Constant ) {
            ser.append( ":'" + ( (Constant) elem ).getType( ).getName( ) + "'" + "=" + ( (Constant) elem ).getValue( ) );

        } else if ( elem instanceof Constraint ) {
            if ( showConstrains ) {
                ser.append( "='" + ( (Constraint) elem ).getExpression( ) + "'" );
            }

        } else if ( elem instanceof Reference ) {
            ser.append( serializeMultiplicity( ( (Reference) elem ).getMultiplicity( ) ) + "->'" + ( (Reference) elem ).getType( ).getName( ) + "'" );

        } else if ( elem instanceof Operation ) {
            ser.append( "(" + serializeParameters( ( (Operation) elem ).getContents( ) ) + ")" );

        } else if ( elem instanceof StructureField ) {
            ser.append( ":'" + ( (StructureField) elem ).getType( ).getName( ) + "'" );

        } else if ( elem instanceof StructureType ) {
            ser.append( serializeNamespaceContent( (StructureType) elem, margin ) );

        } else if ( elem instanceof EnumerationType ) {
            ser.append( ":" + ( (EnumerationType) elem ).getLabels( ) );

        } else if ( elem instanceof Tag ) {
            ser.append( ":" + ( (Tag) elem ).getTagId( ) + "-" + ( (Tag) elem ).getValues( ) );

        } else if ( elem instanceof MofException ) {
            ser.append( "(" + serializeParameters( ( (MofException) elem ).getContents( ) ) + ")" );
        }
        return ser;
    }

    private StringBuffer serializeNamespaceContent( Namespace ns, String margin ) {

        return serializeClassifiedContent( clasifyContent( ns ), margin + "    " );
    }

    private String serializeAssociationEnd( AssociationEnd end, int direction ) {

        String endType = "'" + end.getType( ).getName( ) + "'";
        if ( end.getAggregation( ).equals( AggregationKindEnum.COMPOSITE ) ) {
            if ( direction == -1 ) {
                return endType + ( end.isChangeable( ) ? "$" : "" ) + serializeMultiplicity( end.getMultiplicity( ) ) + "*";
            } else {
                return "*" + serializeMultiplicity( end.getMultiplicity( ) ) + ( end.isChangeable( ) ? "$" : "" ) + endType;
            }
        }
        if ( direction == -1 ) {
            return endType + ( end.isChangeable( ) ? "$" : "" ) + serializeMultiplicity( end.getMultiplicity( ) ) + "<";
        } else {
            return ">" + serializeMultiplicity( end.getMultiplicity( ) ) + ( end.isChangeable( ) ? "$" : "" ) + endType;
        }
    }

    private String serializeParameters( List parameters ) {

        String ret = "";
        Parameter par = null;
        Iterator it = parameters.iterator( );
        while ( it.hasNext( ) ) {
            par = (Parameter) it.next( );
            ret = ret + "[" + par.getDirection( ) + "]" + par.getName( ) + ":" + par.getType( ).getName( );
            if ( it.hasNext( ) ) {
                ret = ret + ",";
            }
        }
        return ret;
    }

    private String serializeGeneralizations( GeneralizableElement elem ) {

        String ret = "";
        GeneralizableElement supertype = null;
        Iterator it = elem.getSupertypes( ).iterator( );
        if ( it.hasNext( ) ) {
            ret = ret + ":";
            while ( it.hasNext( ) ) {
                supertype = (GeneralizableElement) it.next( );
                ret = ret + "'" + supertype.getName( ) + "'";
                if ( it.hasNext( ) ) {
                    ret = ret + ",";
                }
            }
            ret = ret + " ";
        }
        return ret;
    }

    private String serializeMultiplicity( MultiplicityType mult ) {

        String upper = "" + mult.getUpper( );
        if ( mult.getUpper( ) == -1 ) {
            upper = "*";
        }
        return "[" + mult.getLower( ) + ".." + upper + "]";

    }

}
