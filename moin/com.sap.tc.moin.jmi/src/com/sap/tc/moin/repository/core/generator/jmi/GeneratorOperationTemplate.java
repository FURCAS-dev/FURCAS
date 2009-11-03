package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorOperationTemplate {

    public void generateTemplate( StringBuffer code, Operation operation, boolean noJavaDocs, int generationKind ) {

        // annotation template
        Generator.generateAnnotationTemplate( code, operation );
        // check the operation for return types and paramters
        HashSet namesP = new HashSet( );
        HashSet namesE = new HashSet( );
        LinkedList parameters = new LinkedList( );
        LinkedList exceptions = new LinkedList( );
        Iterator iter = Generator.getAllContent( operation ).iterator( );
        Parameter pReturn = null;
        while ( iter.hasNext( ) ) {
            Object o = iter.next( );
            if ( o instanceof Parameter ) {
                Parameter p = (Parameter) o;
                if ( !( namesP.contains( p.getName( ) ) ) ) {
                    if ( p.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                        pReturn = p;
                    } else {
                        parameters.add( p );
                    }
                }
                namesP.add( p.getName( ) );
            } else if ( o instanceof MofException ) {
                MofException e = (MofException) o;
                if ( namesE.contains( e.getName( ) ) ) {
                    exceptions.add( o );
                }
                namesE.add( e.getName( ) );
            }
        }
        // exceptions
        exceptions.addAll( operation.getExceptions( ) );
        // default: no return parameter -> void
        String typeReturn = "void";
        if ( pReturn != null ) {
            typeReturn = getParameterType( pReturn );
        }
        // operation name
        String operationName = Generator.getOperationNameForOperation( operation );
        generateOperation( generationKind, code, operation, operationName, typeReturn, parameters, exceptions );
    }

    public static String getParameterType( Parameter p ) {

        String type = null;
        if ( Generator.isJavaType( p.getType( ).getName( ) ) ) {
            // MOF PrimitiveType
            if ( p.getDirection( ).equals( DirectionKindEnum.IN_DIR ) || p.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                if ( p.getMultiplicity( ).getLower( ) == 0 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = Generator.getJavaTypeClass( Generator.getType( p.getType( ) ) );
                } else if ( p.getMultiplicity( ).getLower( ) == 1 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = Generator.getType( p.getType( ) );
                } else {
                    if ( p.getMultiplicity( ).isOrdered( ) ) {
                        type = "java.util.List"; //$NON-NLS-1$
                    } else {
                        type = "java.util.Collection"; //$NON-NLS-1$
                    }
                }
            } else {
                if ( p.getMultiplicity( ).getLower( ) == 0 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = Generator.getJavaTypeClass( Generator.getType( p.getType( ) ) ) + "[]";
                } else if ( p.getMultiplicity( ).getLower( ) == 1 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = Generator.getType( p.getType( ) ) + "[]";
                } else {
                    if ( p.getMultiplicity( ).isOrdered( ) ) {
                        type = "java.util.List[]"; //$NON-NLS-1$
                    } else {
                        type = "java.util.Collection[]"; //$NON-NLS-1$
                    }
                }
            }
        } else {
            // NOT MOF PrimitiveType
            if ( p.getDirection( ).equals( DirectionKindEnum.IN_DIR ) || p.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                if ( p.getMultiplicity( ).getLower( ) == 0 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = Generator.getType( p.getType( ) );
                } else if ( p.getMultiplicity( ).getLower( ) == 1 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = Generator.getType( p.getType( ) );
                } else {
                    if ( p.getMultiplicity( ).isOrdered( ) ) {
                        type = "java.util.List"; //$NON-NLS-1$
                    } else {
                        type = "java.util.Collection"; //$NON-NLS-1$
                    }
                }
            } else {
                if ( p.getMultiplicity( ).getLower( ) == 0 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = Generator.getType( p.getType( ) ) + "[]";
                } else if ( p.getMultiplicity( ).getLower( ) == 1 && p.getMultiplicity( ).getUpper( ) == 1 ) {
                    type = Generator.getType( p.getType( ) ) + "[]";
                } else {
                    if ( p.getMultiplicity( ).isOrdered( ) ) {
                        type = "java.util.List[]"; //$NON-NLS-1$
                    } else {
                        type = "java.util.Collection[]"; //$NON-NLS-1$
                    }
                }
            }
        }
        return type;
    }

    private void generateOperation( int generationKind, StringBuffer code, Operation operation, String operationName, String typeReturn, List parameters, List exceptions ) {

        if ( generationKind == Generator.GenerationKind.INTERFACE && !( operation.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) ) {
            return;
        }
        code.append( "public " + typeReturn + " " + operationName + "(" ); //$NON-NLS-1$
        StringBuffer argumentList = new StringBuffer( );
        // parameters
        Iterator iter = parameters.iterator( );
        while ( iter.hasNext( ) ) {
            Parameter p = (Parameter) iter.next( );
            argumentList.append( getParameterType( p ) + " " + Generator.convertFirstCharToLower( Generator.getJMIIdentifier( p ) ) );
            if ( iter.hasNext( ) ) {
                argumentList.append( ", " ); //$NON-NLS-1$
            }
        }
        code.append( argumentList + ") throws " ); //$NON-NLS-1$
        // exceptions
        if ( exceptions.size( ) > 0 ) {
            iter = exceptions.iterator( );
            while ( iter.hasNext( ) ) {
                MofException e = (MofException) iter.next( );
                code.append( Generator.getJMIIdentifierQualified( e ) + ", " );
            }
        }
        code.append( "JmiException" ); //$NON-NLS-1$
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                // There may be a tag with the coding
                // fetching operation code tag for Java
                Tag tagJavaCoding = Generator.getTag( operation, GeneratorConstants.TAG_OPERATION_CODE_JAVA );
                // fetching operation code tag for Ocl
                Tag tagOclCoding = Generator.getTag( operation, GeneratorConstants.TAG_OPERATION_CODE_OCL );
                if ( tagOclCoding != null ) {
                    code.append( "  try {" + Utilities.SystemLineSeparator );
                    code.append( "    // begin of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_OCL + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    List list = tagOclCoding.getValues( );
                    if ( list == null ) {
                        // return default type
                        code.append( "    // implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_OCL + "is empty" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        if ( typeReturn.compareTo( "void" ) != 0 ) {
                            code.append( "    return " + Generator.getJavaReturnInitialValueByType( typeReturn ) + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        }
                    } else {
                        // currently no log of the OCL code because it is unclear whilch line separators can come
                        // here we assumed "\n" which is not platform independent
//            Iterator iterCode = list.iterator();
//            while(iterCode.hasNext()) {
//              Object o = iterCode.next();
//              code.append("    // " + o.toString().replace("\n", Utilities.SystemLineSeparator + "    // "));
//              if(iterCode.hasNext()) {
//                code.append(Utilities.SystemLineSeparator);
//              }
//            }
//            code.append(Utilities.SystemLineSeparator);
                        code.append( "    java.util.Map operationParameters = new java.util.HashMap();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        iter = parameters.iterator( );
                        while ( iter.hasNext( ) ) {
                            Parameter p = (Parameter) iter.next( );
                            code.append( "    operationParameters.put(\"" + p.getName( ) + "\", " + Generator.getJavaTypeAsObject( Generator.getParameterType( p ), Generator.convertFirstCharToLower( Generator.getJMIIdentifier( p ) ) ) + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        }
                        if ( typeReturn.compareTo( "void" ) != 0 ) {
                            code.append( "    " + typeReturn + " result = ((" + Generator.getJavaTypeClass( typeReturn ) + ")get___OclService().evaluateOclBodyExpression(\"" + operationName + "\", this, operationParameters))" ); //$NON-NLS-1$
                            String str = Generator.getJavaTypeGetValue( typeReturn );
                            if ( str != null ) {
                                code.append( "." + str ); //$NON-NLS-1$
                            }
                            code.append( ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                            code.append( "    return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        } else {
                            code.append( "    get___OclService().evaluateOclBodyExpression(\"" + operationName + "\", this, operationParameters);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        }
                    }
                    code.append( "    // end of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_OCL + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  catch(com.sap.tc.moin.repository.exception.MoinBaseException ex) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "    throw new javax.jmi.reflect.JmiException(ex);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  }" + Utilities.SystemLineSeparator );
                } else if ( tagJavaCoding != null ) {
                    code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_JAVA + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    List list = tagJavaCoding.getValues( );
                    if ( list == null ) {
                        // return
                        code.append( "  // implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_JAVA + "is empty" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        if ( typeReturn.compareTo( "void" ) != 0 ) {
                            code.append( "  return " + Generator.getJavaReturnInitialValueByType( typeReturn ) + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                        }
                    } else {
                        Iterator iterCode = list.iterator( );
                        while ( iterCode.hasNext( ) ) {
                            Object o = iterCode.next( );
                            code.append( o.toString( ) );
                            if ( iterCode.hasNext( ) ) {
                                code.append( Utilities.SystemLineSeparator );
                            }
                        }
                    }
                    code.append( Utilities.SystemLineSeparator );
                    code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_JAVA + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                } else {
                    // return default type
                    code.append( "  // missing an implementation provided in either tag " + GeneratorConstants.TAG_OPERATION_CODE_JAVA + " or " + GeneratorConstants.TAG_OPERATION_CODE_OCL + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    if ( typeReturn.compareTo( "void" ) != 0 ) {
                        code.append( "  return " + Generator.getJavaReturnInitialValueByType( typeReturn ) + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
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