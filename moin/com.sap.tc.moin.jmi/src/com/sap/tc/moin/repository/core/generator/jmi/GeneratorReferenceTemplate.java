package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorReferenceTemplate {

    public void generateTemplate( StringBuffer code, Reference reference, boolean noJavaDocs, int generationKind ) {

        // important names
        String referenceName = Generator.convertFirstCharToUpper( Generator.getJMIIdentifier( reference ) );
        String accessorName = "get" + referenceName;
        String mutatorName = "set" + referenceName;
        String internalMutatorName = Generator.getInternalMutatorNameForTypedElement( reference );
        String typeOfReference = Generator.getReferenceType( reference );
        addAttributeDeclTemplate( code, reference );
        addAccessorTemplate( code, reference, typeOfReference, accessorName, generationKind );
        addMutatorTemplate( code, reference, typeOfReference, mutatorName, generationKind );
        addInternalMutatorTemplate( code, reference, typeOfReference, internalMutatorName, generationKind );
    }

    private void addAccessorTemplate( StringBuffer code, Reference reference, String referenceType, String accessorName, int generationKind ) {

        AssociationEnd associationEnd = reference.getReferencedEnd( );
        Association association = (Association) associationEnd.getContainer( );
        // AssociationEnd must be navigable (see JMI 1.0 standard 4.8.6 NOTE)
        if ( associationEnd.isNavigable( ) ) {
            switch ( generationKind ) {
                case Generator.GenerationKind.INTERFACE:
                    if ( !reference.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                        return;
                    } else {
                        // JavaDoc
                        Generator.generateAnnotationTemplate( code, reference );
                        // accessor
                        code.append( Generator.mapVisibilityToJava( reference ) + " " + referenceType + " " + accessorName + "() throws JmiException;" + Utilities.SystemLineSeparator ); //$NON-NLS-12$
                        break;
                    }
                case Generator.GenerationKind.CLASS:
                    // JavaDoc
                    Generator.generateAnnotationTemplate( code, reference );
                    // accessor
                    code.append( Generator.mapVisibilityToJava( reference ) + " " + referenceType + " " + accessorName + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-12$
                    if ( association.isDerived( ) ) {
                        code.append( "  javax.jmi.model.AssociationEnd associationEnd = (javax.jmi.model.AssociationEnd)get___AttributeOrAssociationEndByName(\"" + reference.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "  javax.jmi.model.Association association = (javax.jmi.model.Association)associationEnd.getContainer();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code
                            .append( "  " + GeneratorAssociation.getJavaInterfaceNameQualified( association ) + " associationExtent = (" + GeneratorAssociation.getJavaInterfaceNameQualified( association ) + ")get___Workspace().getWorkspaceSet().getExtentManager().getExtent(((Partitionable)association).get___Mri());" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "  return associationExtent.get" + Generator.convertFirstCharToUpper( Generator.getJMIIdentifier( associationEnd ) ) + "(this);" + Utilities.SystemLineSeparator );
                    } else {
                        if ( associationEnd.getMultiplicity( ).getUpper( ) == 1 ) {
                            code.append( "  return (" + referenceType + ")___queryMult1(\"" + reference.getName( ) + "\", " + Generator.getJMIIdentifierQualified( reference.getType( ) ) + ".class, false);" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        } else {
                            code.append( "  return (" + referenceType + ")___queryMultN(\"" + reference.getName( ) + "\", " + Generator.getJMIIdentifierQualified( reference.getType( ) ) + ".class, false);" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        }
                    }
                    code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case Generator.GenerationKind.WRAPPER:
                    // TODO JMI WRAPPER
                    break;
                default:
                    throw new RuntimeException( );
            }
        }
    }

    private void addMutatorTemplate( StringBuffer code, Reference reference, String referenceType, String mutatorName, int generationKind ) {

        AssociationEnd associationEnd = reference.getReferencedEnd( );
        // AssociationEnd must be navigable (see JMI 1.0 standard 4.8.6 NOTE)
        if ( associationEnd.isNavigable( ) ) {
            if ( reference.isChangeable( ) && reference.getMultiplicity( ).getUpper( ) == 1 ) {
                String argumentList = referenceType + " newValue";
                switch ( generationKind ) {
                    case Generator.GenerationKind.INTERFACE:
                        if ( !reference.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                            return;
                        } else {
                            // JavaDoc
                            Generator.generateAnnotationTemplate( code, reference );
                            // mutator
                            code.append( Generator.mapVisibilityToJava( reference ) + " void " + mutatorName + "(" + argumentList + ") throws JmiException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                            break;
                        }
                    case Generator.GenerationKind.CLASS:
                        // JavaDoc
                        Generator.generateAnnotationTemplate( code, reference );
                        code.append( Generator.mapVisibilityToJava( reference ) + " void " + mutatorName + "(" + argumentList + ") throws JmiException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "  refSetValue(\"" + reference.getName( ) + "\", newValue);" + Utilities.SystemLineSeparator );
                        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        break;
                    case Generator.GenerationKind.WRAPPER:
                        // TODO implement the wrapper generation
                        break;
                    default:
                        throw new RuntimeException( );
                }
            }
        }
    }

    private void addInternalMutatorTemplate( StringBuffer code, Reference reference, String referenceType, String internalMutatorName, int generationKind ) {

        String argumentList = referenceType + " newValue";
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                return;
            case Generator.GenerationKind.CLASS:
                AssociationEnd associationEnd = reference.getReferencedEnd( );
                Association association = (Association) associationEnd.getContainer( );
                AssociationEnd associationEnd0 = null;
                AssociationEnd associationEnd1 = null;
                Iterator iter = association.getContents( ).iterator( );
                while ( iter.hasNext( ) ) {
                    ModelElement me = (ModelElement) iter.next( );
                    if ( me instanceof AssociationEnd ) {
                        if ( associationEnd0 == null ) {
                            associationEnd0 = (AssociationEnd) me;
                        } else if ( associationEnd1 == null ) {
                            associationEnd1 = (AssociationEnd) me;
                        }
                    }
                }
                // AssociationEnd must be navigable (see JMI 1.0 standard 4.8.6 NOTE)
                if ( associationEnd.isNavigable( ) ) {
                    if ( association.isDerived( ) && reference.isChangeable( ) && reference.getMultiplicity( ).getUpper( ) == 1 ) {
                        switch ( generationKind ) {
                            case Generator.GenerationKind.INTERFACE:
                                return;
                            case Generator.GenerationKind.CLASS:
                                code.append( "private void " + internalMutatorName + "(" + argumentList + ") throws JmiException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                if ( associationEnd0.isChangeable( ) && associationEnd1.isChangeable( ) ) {
                                    code.append( "  javax.jmi.model.AssociationEnd associationEnd = (javax.jmi.model.AssociationEnd)get___AttributeOrAssociationEndByName(\"" + reference.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                    code.append( "  javax.jmi.model.Reference reference = (javax.jmi.model.Reference)get___AttributeOrReferenceByName(\"" + reference.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                    code.append( "  javax.jmi.model.Association association = (javax.jmi.model.Association)associationEnd.getContainer();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                    code
                                        .append( "  " + GeneratorAssociation.getJavaInterfaceNameQualified( association ) + " associationExtent = (" + GeneratorAssociation.getJavaInterfaceNameQualified( association ) + ")get___Workspace().getWorkspaceSet().getExtentManager().getExtent(((Partitionable)association).get___Mri());" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                    if ( associationEnd.getName( ).equals( associationEnd0.getName( ) ) ) {
                                        code.append( "  ((com.sap.tc.moin.repository.core.jmi.extension.RefAssociationExtension)associationExtent).add___AssociationEnds(newValue, this, reference);" + Utilities.SystemLineSeparator );
                                    } else {
                                        code.append( "  ((com.sap.tc.moin.repository.core.jmi.extension.RefAssociationExtension)associationExtent).add___AssociationEnds(this, newValue, reference);" + Utilities.SystemLineSeparator );
                                    }
                                } else {
                                    code.append( "  // can not set reference, both association ends have to be changeable " + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                }
                                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                break;
                            case Generator.GenerationKind.WRAPPER:
                                // TODO implement the wrapper generation
                                break;
                            default:
                                throw new RuntimeException( );
                        }
                    }
                }
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                throw new RuntimeException( );
        }
    }

    private void addAttributeDeclTemplate( StringBuffer code, Reference reference ) {

        AssociationEnd associationEnd = reference.getReferencedEnd( );
        // AssociationEnd must be navigable (see JMI 1.0 standard 4.8.6 NOTE)
        if ( associationEnd.isNavigable( ) ) {
            if ( reference.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                code.append( "// reference: " + reference.getName( ) + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
        }
    }
}