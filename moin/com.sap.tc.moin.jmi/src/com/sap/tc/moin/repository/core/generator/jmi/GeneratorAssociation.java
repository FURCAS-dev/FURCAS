package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.Wrapper;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorAssociation {

    // e.g. Contains
    public static String getJavaInterfaceName( Association association ) {

        return Generator.getJMIIdentifier( association );
    }

    // e.g. javax.jmi.model.Contains
    public static String getJavaInterfaceNameQualified( Association association ) {

        return getJavaPackageNameQualifiedForInterface( association ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaInterfaceName( association );
    }

    // e.g. ContainsImpl
    public static String getJavaClassName( Association association ) {

        return Generator.getJMIIdentifier( association ) + Generator.EXTENSION_IMPLEMENTATION;
    }

    // e.g. javax.jmi.model.___impl.ContainsImpl
    public static String getJavaClassNameQualified( Association association ) {

        return getJavaPackageNameQualifiedForClass( association ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( association );
    }

    // e.g. javax.jmi.model
    public static String getJavaPackageNameQualifiedForInterface( Association association ) {

        return Generator.getJMIPackageIdentifierQualified( association );
    }

    // e.g. javax.jmi.model.___impl
    public static String getJavaPackageNameQualifiedForClass( Association association ) {

        return Generator.getJMIPackageIdentifierQualified( association ) + GeneratorConstants.PACKAGE_DELIMITER + Generator.PACKAGE_IMPLEMENTATION;
    }

    public JavaSource generateTemplate( Association association, boolean noJavaDocs, int generationKind ) {

        StringBuffer code = new StringBuffer( 1000 );
        JavaSource source = null;
        // important names
        String javaInterfaceName = getJavaInterfaceName( association );
        String javaInterfaceNameQualified = getJavaInterfaceNameQualified( association );
        String javaPackageNameForInterface = getJavaPackageNameQualifiedForInterface( association );
        String javaClassName = getJavaClassName( association );
        String javaClassNameQualified = getJavaClassNameQualified( association );
        String javaPackageNameForClass = getJavaPackageNameQualifiedForClass( association );
        // preamble
        Generator.generatePreamble( code );
        // package statement
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( "package " + javaPackageNameForInterface + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( Utilities.SystemLineSeparator );
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "package " + javaPackageNameForClass + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( Utilities.SystemLineSeparator );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        // includes
        Generator.generateDefaultIncludes( code, association, generationKind );
        // annotation template
        if ( !noJavaDocs ) {
            Generator.generateAnnotationTemplate( code, association );
        }
        // interface/class header
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // Java annotation template
                Generator.generateJavaAnnotationTemplateAssociation( code, association );
                code.append( "public interface " + javaInterfaceName ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "public final class " + javaClassName ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( " extends RefAssociation" ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( " extends " + Generator.JMI_IMPL_PACKAGE_REFLECT + ".RefAssociationImpl implements " + javaInterfaceNameQualified ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // constructor & variables
        if ( generationKind != Generator.GenerationKind.INTERFACE ) {
            Generator.generateTemplateRefAssociationDecl( code, association, javaClassName, generationKind );
        }
        List contents = Generator.getAllContent( association );
        if ( contents == null ) {
            return source;
        }
        // association ends
        AssociationEnd end0 = null;
        AssociationEnd end1 = null;
        Iterator iter = contents.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof AssociationEnd ) {
                if ( end0 == null ) {
                    end0 = (AssociationEnd) me;
                } else if ( end1 == null ) {
                    end1 = (AssociationEnd) me;
                }
            }
        }
        code.append( "// specific association methods" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // Metamodel Repository (AssociationsContainer) specific stuff
        String end0ClassName = Generator.getType( end0.getType( ) );
        String end1ClassName = Generator.getType( end1.getType( ) );
        String accessorNameEnd0 = Generator.getAccessorNameForModelElement( end0 );
        String accessorNameEnd1 = Generator.getAccessorNameForModelElement( end1 );
        String end0Name = "_" + Generator.getJMIIdentifier( end0 );
        String end1Name = "_" + Generator.getJMIIdentifier( end1 );
        String methodGetContainer = "get___AssociationsContainer()";

        int end0Number = Generator.getCoreConnection( ).getCoreJmiHelper( ).getAssociationEndNumber( Generator.getCoreConnection( ).getSession( ), ( (Wrapper<AssociationEnd>) end0 ).unwrap( ) );
        int end1Number = end0Number == 1 ? 0 : 1;
        // exists
        String existsName = "exists";
        String argumentList = end0ClassName + " " + end0Name + ", " + end1ClassName + " " + end1Name;
        code.append( "public boolean " + existsName + "(" + argumentList + ") throws JmiException" ); //$NON-NLS-1$
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                if ( association.isDerived( ) ) {
                    Tag bodyTag = Generator.getTag( association, GeneratorConstants.TAG_OPERATION_CODE_EXISTS_JAVA );
                    if ( bodyTag != null ) {
                        code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_EXISTS_JAVA + Utilities.SystemLineSeparator );
                        code.append( (String) bodyTag.getValues( ).get( 0 ) + Utilities.SystemLineSeparator );
                        code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_EXISTS_JAVA + Utilities.SystemLineSeparator );
                    } else {
                        code.append( "  boolean result = false;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        code.append( "  // missing an implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_EXISTS_JAVA + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        if ( end0.isNavigable( ) ) {
                            code.append( "  // calculate the existence based on the accessor for end " + end0.getName( ) + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            if ( end0.getMultiplicity( ).getUpper( ) == 1 ) {
                                code.append( "  if(" + accessorNameEnd0 + "(" + end1Name + ").equals(" + end0Name + ")) {" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "    result = true;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            } else {
                                code.append( "  for(Iterator iter = " + accessorNameEnd0 + "(" + end1Name + ").iterator(); iter.hasNext();) {" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "    if(iter.next().equals(" + end0Name + ")) {" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "      result = true;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "      break;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "    }" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            }
                            code.append( "  return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        } else if ( end1.isNavigable( ) ) {
                            code.append( "  // calculate the existence based on the accessor for end " + end1.getName( ) + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            if ( end1.getMultiplicity( ).getUpper( ) == 1 ) {
                                code.append( "  if(" + accessorNameEnd1 + "(" + end0Name + ").equals(" + end1Name + ")) {" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "    result = true;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            } else {
                                code.append( "  for(Iterator iter = " + accessorNameEnd1 + "(" + end0Name + ").iterator(); iter.hasNext();) {" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "    if(iter.next().equals(" + end1Name + ")) {" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "      result = true;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "      break;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "    }" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            }
                            code.append( "  return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        } else {
                            code.append( "  return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        }
                    }
                } else {
                    code.append( "  return refLinkExists((RefObject)" + end0Name + ", (RefObject)" + end1Name + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
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
        // getter for navigable end0
        if ( end0.isNavigable( ) ) {
            argumentList = end1ClassName + " " + end1Name;
            // end0 is single valued
            if ( end0.getMultiplicity( ).getUpper( ) == 1 ) {
                code.append( "public " + end0ClassName + " " + accessorNameEnd0 + "(" + argumentList + ") throws JmiException" ); //$NON-NLS-1$
                switch ( generationKind ) {
                    case Generator.GenerationKind.INTERFACE:
                        code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        break;
                    case Generator.GenerationKind.CLASS:
                        code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        if ( association.isDerived( ) ) {
                            Tag bodyTag = Generator.getTag( end0, GeneratorConstants.TAG_DERIVATION_CODE );
                            if ( bodyTag != null ) {
                                code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                                code.append( (String) bodyTag.getValues( ).get( 0 ) + Utilities.SystemLineSeparator );
                                code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                            } else {
                                code.append( "  // missing an implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "  return null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                            }
                        } else {
                            code.append( "  return (" + end0ClassName + ")___querySecondEndMult1(" + end1Name + ", " + end0ClassName + ".class, false);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
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
            // end0 is multi valued
            if ( end0.getMultiplicity( ).getUpper( ) < 0 || end0.getMultiplicity( ).getUpper( ) > 1 ) {
                String returnType = "";
                if ( end0.getMultiplicity( ).isOrdered( ) ) {
                    // ordered
                    returnType = "java.util.List";
                } else {
                    // not ordered
                    returnType = "java.util.Collection";
                }
                code.append( "public " + returnType + " " + accessorNameEnd0 + "(" + argumentList + ") throws JmiException" ); //$NON-NLS-1$
                switch ( generationKind ) {
                    case Generator.GenerationKind.INTERFACE:
                        code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        break;
                    case Generator.GenerationKind.CLASS:
                        code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        if ( association.isDerived( ) ) {
                            Tag bodyTag = Generator.getTag( end0, GeneratorConstants.TAG_DERIVATION_CODE );
                            if ( bodyTag != null ) {
                                code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                                code.append( (String) bodyTag.getValues( ).get( 0 ) + Utilities.SystemLineSeparator );
                                code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                            } else {
                                code.append( "  // missing an implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "  return null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                            }
                        } else {
                            code.append( "  return (" + returnType + ")___querySecondEndMultN(" + end1Name + ", " + end0ClassName + ".class, false);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
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
        }
        // getter for navigable end1
        if ( end1.isNavigable( ) ) {
            argumentList = end0ClassName + " " + end0Name;
            // end1 is single valued
            if ( end1.getMultiplicity( ).getUpper( ) == 1 ) {
                code.append( "public " + end1ClassName + " " + accessorNameEnd1 + "(" + argumentList + ") throws JmiException" ); //$NON-NLS-1$
                switch ( generationKind ) {
                    case Generator.GenerationKind.INTERFACE:
                        code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        break;
                    case Generator.GenerationKind.CLASS:
                        code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        if ( association.isDerived( ) ) {
                            Tag bodyTag = Generator.getTag( end1, GeneratorConstants.TAG_DERIVATION_CODE );
                            if ( bodyTag != null ) {
                                code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                                code.append( (String) bodyTag.getValues( ).get( 0 ) + Utilities.SystemLineSeparator );
                                code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                            } else {
                                code.append( "  // missing an implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "  return null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                            }
                        } else {
                            code.append( "  return (" + end1ClassName + ")___queryFirstEndMult1(" + end0Name + ", " + end1ClassName + ".class, false);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
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
            // end1 is multi valued
            if ( end1.getMultiplicity( ).getUpper( ) < 0 || end1.getMultiplicity( ).getUpper( ) > 1 ) {
                String returnType = "";
                if ( end1.getMultiplicity( ).isOrdered( ) ) {
                    // is ordered
                    returnType = "java.util.List";
                } else {
                    // not ordered
                    returnType = "java.util.Collection";
                }
                code.append( "public " + returnType + " " + accessorNameEnd1 + "(" + argumentList + ") throws JmiException" ); //$NON-NLS-1$
                switch ( generationKind ) {
                    case Generator.GenerationKind.INTERFACE:
                        code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        break;
                    case Generator.GenerationKind.CLASS:
                        code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        if ( association.isDerived( ) ) {
                            Tag bodyTag = Generator.getTag( end1, GeneratorConstants.TAG_DERIVATION_CODE );
                            if ( bodyTag != null ) {
                                code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                                code.append( (String) bodyTag.getValues( ).get( 0 ) + Utilities.SystemLineSeparator );
                                code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator );
                            } else {
                                code.append( "  // missing an implementation provided in tag " + GeneratorConstants.TAG_DERIVATION_CODE + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                                code.append( "  return null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                            }
                        } else {
                            code.append( "  return (" + returnType + ")___queryFirstEndMultN(" + end0Name + ", " + end1ClassName + ".class, false);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
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
        }
        // add: if end0 and end1 isChangeable
        if ( end0.isChangeable( ) && end1.isChangeable( ) ) {
            String addName = "add";
            argumentList = end0ClassName + " " + end0Name + ", " + end1ClassName + " " + end1Name;
            code.append( "public boolean " + addName + "(" + argumentList + ") throws JmiException" ); //$NON-NLS-1$
            switch ( generationKind ) {
                case Generator.GenerationKind.INTERFACE:
                    code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case Generator.GenerationKind.CLASS:
                    code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    if ( association.isDerived( ) ) {
                        code.append( "  return add___AssociationEnds((RefObject)" + end0Name + ", (RefObject)" + end1Name + ", null);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    } else {
                        code.append( "  return refAddLink((RefObject)" + end0Name + ", (RefObject)" + end1Name + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
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
        // remove: if end0 and end1 isChangeable
        if ( end0.isChangeable( ) && end1.isChangeable( ) ) {
            String removeName = "remove";
            argumentList = end0ClassName + " " + end0Name + ", " + end1ClassName + " " + end1Name;
            code.append( "public boolean " + removeName + "(" + argumentList + ") throws JmiException" ); //$NON-NLS-1$
            switch ( generationKind ) {
                case Generator.GenerationKind.INTERFACE:
                    code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case Generator.GenerationKind.CLASS:
                    code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    if ( association.isDerived( ) ) {
                        Tag bodyTag = Generator.getTag( association, GeneratorConstants.TAG_OPERATION_CODE_REMOVE_JAVA );
                        if ( bodyTag != null ) {
                            code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_REMOVE_JAVA + Utilities.SystemLineSeparator );
                            code.append( (String) bodyTag.getValues( ).get( 0 ) + Utilities.SystemLineSeparator );
                            code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_REMOVE_JAVA + Utilities.SystemLineSeparator );
                        } else {
                            code.append( "  // missing an implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_REMOVE_JAVA + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                            code.append( "  return false;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        }
                    } else {
                        code.append( "  return refRemoveLink((RefObject)" + end0Name + ", (RefObject)" + end1Name + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
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
        // RefAssociation
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // do nothing
                break;
            case Generator.GenerationKind.CLASS:
                Generator.generateTemplateRefAssociation( code, association, javaClassName, javaInterfaceNameQualified, generationKind );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        // end of interface/class
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // create a source code instance
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                source = new JavaSource( javaInterfaceNameQualified );
                break;
            case Generator.GenerationKind.CLASS:
                source = new JavaSource( javaClassNameQualified );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        source.setCode( code.toString( ) );
        return source;
    }
}