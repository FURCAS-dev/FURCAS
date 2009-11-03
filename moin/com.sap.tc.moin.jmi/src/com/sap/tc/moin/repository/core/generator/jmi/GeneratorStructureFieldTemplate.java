package com.sap.tc.moin.repository.core.generator.jmi;

import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorStructureFieldTemplate {

    public void generateTemplate( StringBuffer code, StructureField structureField, int generationKind ) {

        // important names
        String fieldName = Generator.convertFirstCharToUpper( Generator.getJMIIdentifier( structureField ) );
        String variableName = Generator.composeVariableName( fieldName );
        String accessorName = Generator.getAccessorNameForModelElement( structureField );
        String internalMutatorName = Generator.getInternalMutatorNameForTypedElement( structureField );
        String fieldType = Generator.getType( structureField.getType( ) );
        code.append( "// field: " + fieldName + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        addFieldDeclTemplate( code, variableName, fieldType, generationKind );
        addAccessorTemplate( code, variableName, fieldType, accessorName, generationKind );
        addInternalMutatorTemplate( code, variableName, fieldType, internalMutatorName, generationKind );
    }

    private void addAccessorTemplate( StringBuffer code, String variableName, String fieldType, String accessorName, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( "public " + fieldType + " " + accessorName + "() throws JmiException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "public " + fieldType + " " + accessorName + "() throws JmiException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  return " + variableName + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
        }
    }

    private void addFieldDeclTemplate( StringBuffer code, String variableName, String fieldType, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "private " + fieldType + " " + variableName + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
    }

    private void addInternalMutatorTemplate( StringBuffer code, String variableName, String attributeType, String internalMutatorName, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
                // internal mutator
                code.append( "public void " + internalMutatorName + "(" + attributeType + " newValue) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  " + variableName + " = newValue;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
        }
    }
}