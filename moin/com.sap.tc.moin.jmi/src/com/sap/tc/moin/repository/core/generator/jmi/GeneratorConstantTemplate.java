package com.sap.tc.moin.repository.core.generator.jmi;

import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorConstantTemplate {

    public void generateTemplate( StringBuffer code, Constant constant, boolean noJavaDocs, int generationKind ) {

        // annotation template
        Generator.generateAnnotationTemplate( code, constant );
        // in interface required only
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                String cType = Generator.getType( constant.getType( ) );
                String cName = Generator.correctConstant( Generator.getJMIIdentifier( constant ) );
                String cValue = constant.getValue( );
                code.append( "public final " + cType + " " + cName ); //$NON-NLS-1$
                if ( Generator.isJavaType( cType ) && cType.indexOf( "String" ) < 0 ) {
                    code.append( " = " + cValue + ";" ); //$NON-NLS-1$
                } else {
                    code.append( " = \"" + cValue + "\";" ); //$NON-NLS-1$
                }
                code.append( Utilities.SystemLineSeparator );
                break;
            case Generator.GenerationKind.CLASS:
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
    }
}