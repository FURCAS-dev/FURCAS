package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureFieldInternal;
import javax.swing.tree.TreeNode;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;

/**
 * The StructureField wrapper
 */
public class JmiGeneratorStructureFieldWrapper extends JmiGeneratorBaseWrapper {

    private final StructureFieldInternal wrappedStructureField;

    /**
     * @param structureField
     * @param parent
     * @param generator
     */
    public JmiGeneratorStructureFieldWrapper( CoreConnection connection, String metamodelName, StructureField structureField, TreeNode parent, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, structureField, parent, generator );
        this.wrappedStructureField = (StructureFieldInternal) structureField;
    }

    /**
     * @return the variable name used in the generated class
     */
    public String getVariableName( ) {

        return composeVariableName( getJMIIdentifier( ) );
    }

    @Override
    public List<String> getExtends( JmiGenerationKind genKind, boolean qualified ) {

        return null;
    }

    @Override
    public List<String> getImplements( JmiGenerationKind genKind, boolean qualified ) {

        return null;
    }

    @Override
    public String getJavaClassName( JmiGenerationKind genKind, boolean qualified ) {

        return this.getType( this.wrappedStructureField.getType( connection ) );
    }

    @Override
    public JmiGeneratorBaseTemplate getJavaTemplate( JmiGenerationKind genKind, String templateName ) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JmiGeneratorMofType getMofType( ) {

        return JmiGeneratorMofType.STRUCTUREFIELD;
    }

    @Override
    public List<String> getTemplateNames( JmiGenerationKind genKind ) {

        return null;
    }

    @Override
    protected void initChildren( ) {

        // no children
    }

}
