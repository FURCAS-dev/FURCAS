package com.sap.tc.moin.repository.core.generator.jmi;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorAttributeTemplate {

    public void generateTemplate( StringBuffer code, Attribute attribute, boolean noJavaDocs, int generationKind ) {

        if ( attribute == null || attribute.getType( ) == null || attribute.getType( ).getName( ) == null ) {
            return;
        }
        // important names
        String attributeName = Generator.convertFirstCharToUpper( Generator.getJMIIdentifier( attribute ) );
        String variableName = Generator.composeVariableName( attributeName );
        String accessorName = Generator.getAccessorNameForModelElement( attribute );
        String mutatorName = Generator.getMutatorNameForTypedElement( attribute );
        String internalMutatorName = Generator.getInternalMutatorNameForTypedElement( attribute );
        String attributeType = Generator.getAttributeType( attribute );
        addAttributeDeclTemplate( code, attribute, variableName, attributeType, generationKind );
        addAccessorTemplate( code, attribute, variableName, attributeType, accessorName, generationKind );
        addMutatorTemplate( code, attribute, variableName, attributeType, accessorName, mutatorName, internalMutatorName, generationKind );
        addInternalMutatorTemplate( code, attribute, variableName, attributeType, accessorName, internalMutatorName, generationKind );
    }

    private void addAccessorTemplate( StringBuffer code, Attribute attribute, String variableName, String attributeType, String accessorName, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                if ( !attribute.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                    return;
                } else {
                    // JavaDoc
                    Generator.generateAnnotationTemplate( code, attribute );
                    // accessor
                    code.append( Generator.mapVisibilityToJava( attribute ) + " " + attributeType + " " + accessorName + "() throws JmiException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                }
            case Generator.GenerationKind.CLASS:
                // JavaDoc
                Generator.generateAnnotationTemplate( code, attribute );
                // accessor
                code.append( Generator.mapVisibilityToJava( attribute ) + " " + attributeType + " " + accessorName + "() throws JmiException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                if ( attribute.isDerived( ) ) {
                    Tag bodyTag = Generator.getTag( attribute, GeneratorConstants.TAG_DERIVATION_CODE );
                    if ( bodyTag != null ) {
                        code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                        code.append( (String) bodyTag.getValues( ).get( 0 ) + Utilities.SystemLineSeparator );
                        code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                    } else {
                        code.append( "  " + attributeType + " result = " + Generator.getJavaReturnInitialValueByType( attributeType ) + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        code.append( "  // missing an implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        code.append( "  return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                    }
                } else {
                    if ( !( attribute.getType( ) instanceof MofClass ) ) {
                        // the type of the variable is one of PrimitiveType, StructureType, EnumerationType, CollectionType or AliasType
                        // it is managed as Java class attribute, so get it here
                        code.append( "  " + attributeType + " result = " + Generator.getJavaReturnInitialValueByType( attributeType ) + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                            code.append( "  result = " + variableName + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        } else {
                            code.append( "  if (" + variableName + " == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            code.append( "    javax.jmi.model.Attribute attribute = (javax.jmi.model.Attribute)get___AttributeOrReferenceByName(\"" + attribute.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            code.append( "    " + variableName + " = new MultiValuedAttributesList(attribute);" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            code.append( "  result = " + variableName + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
//              if(attribute.isChangeable()) {
//                code.append("    return result;" + Utilities.SystemLineSeparator); //$NON-NLS-2$
//              }
//              else {
//                if(attribute.getMultiplicity().isOrdered()) {
//                  code.append("    return java.util.Collections.unmodifiableList(result);" + Utilities.SystemLineSeparator); //$NON-NLS-2$
//                }
//                else {
//                  code.append("    return java.util.Collections.unmodifiableCollection(result);" + Utilities.SystemLineSeparator); //$NON-NLS-2$
//                }
//              }
                        }
                        code.append( "  return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                    } else {
                        // variable is managed as link, so query the link here
                        code.append( "  " + attributeType + " result = " + Generator.getJavaReturnInitialValueByType( attributeType ) + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                            code.append( "  result = (" + attributeType + ")___queryMult1(\"" + attribute.getName( ) + "\", " + Generator.getJMIIdentifierQualified( attribute.getType( ) ) + ".class, false);" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        } else {
                            code.append( "  result = (" + attributeType + ")___queryMultN(\"" + attribute.getName( ) + "\", " + Generator.getJMIIdentifierQualified( attribute.getType( ) ) + ".class, false);" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
//              if(attribute.isChangeable()) {
//                code.append("    return result;" + Utilities.SystemLineSeparator); //$NON-NLS-2$
//              }
//              else {
//                if(attribute.getMultiplicity().isOrdered()) {
//                  code.append("    return java.util.Collections.unmodifiableList(result);" + Utilities.SystemLineSeparator); //$NON-NLS-2$
//                }
//                else {
//                  code.append("    return java.util.Collections.unmodifiableCollection(result);" + Utilities.SystemLineSeparator); //$NON-NLS-2$
//                }
//              }
                        }
                        code.append( "  return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                    }
                }
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
    }

    private void addMutatorTemplate( StringBuffer code, Attribute attribute, String variableName, String attributeType, String accessorName, String mutatorName, String internalMutatorName, int generationKind ) {

        if ( attribute.isChangeable( ) ) {
            String argumentList = attributeType + " newValue";
            switch ( generationKind ) {
                case Generator.GenerationKind.INTERFACE:
                    if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                        if ( !attribute.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                            return;
                        } else {
                            // JavaDoc
                            Generator.generateAnnotationTemplate( code, attribute );
                            // mutator
                            code.append( Generator.mapVisibilityToJava( attribute ) + " void " + mutatorName + "(" + argumentList + ") throws JmiException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        }
                    }
                    break;
                case Generator.GenerationKind.CLASS:
                    if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                        // JavaDoc
                        Generator.generateAnnotationTemplate( code, attribute );
                        // mutator
                        code.append( Generator.mapVisibilityToJava( attribute ) + " void " + mutatorName + "(" + argumentList + ") throws JmiException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "  refSetValue(\"" + attribute.getName( ) + "\", " + Generator.getJavaTypeAsObject( attributeType, "newValue" ) + ");" + Utilities.SystemLineSeparator );
                        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                    break;
                case Generator.GenerationKind.WRAPPER:
                    // TODO implement the wrapper generation
                    break;
                default:
                    // TODO proper exception here
                    throw new RuntimeException( );
            }
        }
    }

    private void addInternalMutatorTemplate( StringBuffer code, Attribute attribute, String variableName, String attributeType, String accessorName, String internalMutatorName, int generationKind ) {

        String argumentList = attributeType + " newValue";
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                return;
            case Generator.GenerationKind.CLASS:
                if ( attribute.isDerived( ) ) {
                    if ( attribute.isChangeable( ) && attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                        code.append( "private void " + internalMutatorName + "(" + attributeType + " newValue) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        Tag bodyTag = Generator.getTag( attribute, GeneratorConstants.TAG_PRODUCTION_CODE );
                        if ( bodyTag != null ) {
                            code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_PRODUCTION_CODE + Utilities.SystemLineSeparator );
                            code.append( (String) bodyTag.getValues( ).get( 0 ) + Utilities.SystemLineSeparator );
                            code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_PRODUCTION_CODE + Utilities.SystemLineSeparator );
                        } else {
                            code.append( "  // missing an implementation provided in tag " + GeneratorConstants.TAG_PRODUCTION_CODE + Utilities.SystemLineSeparator );
                        }
                        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                } else {
                    // internal mutator, needs to be package protected because it is used in  the class proxy
                    code.append( "void " + internalMutatorName + "(" + attributeType + " newValue) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    // set the variable
                    if ( !( attribute.getType( ) instanceof MofClass ) ) {
                        // the type of the variable is one of PrimitiveType, StructureType, EnumerationType, CollectionType or AliasType
                        // it is managed as Java class attribute, so set it here
                        if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                            code.append( "  " + variableName + " = newValue;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        } else {
                            code.append( "  if (" + variableName + " == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            code.append( "    javax.jmi.model.Attribute attribute = (javax.jmi.model.Attribute)get___AttributeOrReferenceByName(\"" + attribute.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            code.append( "    " + variableName + " = new MultiValuedAttributesList(attribute);" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            code.append( "  ((MultiValuedAttributesList)" + variableName + ").___replace(newValue);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        }
                    } else {
                        // variable is managed as link, so load the link here
                        code.append( "  ___loadLinks(\"" + attribute.getName( ) + "\", newValue);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                    code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                }
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
    }

    private void addAttributeDeclTemplate( StringBuffer code, Attribute attribute, String variableName, String attributeType, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                if ( attribute.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                    code.append( "// attribute: " + attribute.getName( ) + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                }
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "// attribute: " + attribute.getName( ) + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                if ( !attribute.isDerived( ) ) {
                    if ( !( attribute.getType( ) instanceof MofClass ) ) {
                        // the type of the variable is one of PrimitiveType, StructureType, EnumerationType, CollectionType or AliasType
                        // it is managed as Java class attribute, so generate its declaration here
                        code.append( "private " + attributeType + " " + variableName ); //$NON-NLS-1$	              
                        if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                            if ( attribute.getMultiplicity( ).getLower( ) == 0 ) {
                                code.append( " = null" );
                            } else if ( attribute.getMultiplicity( ).getLower( ) == 1 ) {
                                if ( Generator.isJavaType( attributeType ) ) {
                                    code.append( " = " + Generator.getJavaReturnInitialValueByType( attributeType ) );
                                }
                            }
                        }
                        code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                }
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
    }
}