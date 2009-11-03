package com.sap.tc.moin.xm.generation.core.code.serializer.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.ChildElement;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.ComplexTypeMethod;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.SimpleElementOrAttribute;
import com.sap.tc.moin.xm.generation.core.code.util.HandlerAndComplexTypeMethodData;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;
import com.sap.tc.moin.xm.generation.core.code.util.XmParserSerializerTemplateImpl;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmAssociation;


public class ComplexTypeMethodImpl implements ComplexTypeMethod {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, ComplexTypeMethodImpl.class );

    private final String methodName;

    private final List<ChildElement> childs = new ArrayList<ChildElement>( 5 );

    private final List<SimpleElementOrAttribute> attributes = new ArrayList<SimpleElementOrAttribute>( 3 );


    private final String qNameOfParameter;

    private final String xmlEntityQName;

    private final boolean isSimpleContent;


    public ComplexTypeMethodImpl( final HandlerAndComplexTypeMethodData methodData ) {

        if ( methodData == null ) {
            throw new MoinNullPointerException( "methodData" ); //$NON-NLS-1$
        }
        this.methodName = methodData.getMethodName( );
        this.qNameOfParameter = methodData.getQualifiedJavaClassNameOfMoinClass( );
        this.xmlEntityQName = PSUtil.getXmlEntityQName( methodData );
        this.isSimpleContent = methodData.isSimpleContent( );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Template for complex type method {0} created", this.getMethodName( ) ); //$NON-NLS-1$
        }
    }

    /**
     * Returns the qualified java class name of the parameter of the method
     * which represents the type of the model element for which the XML element
     * is created.
     * 
     * @return qualified java class name, cannot be <code>null</code>
     */
    public String getQualifiedClassNameOfParameter( ) {

        return this.qNameOfParameter;
    }

    public void addSimpleXmlElement( final QualifiedName xmlElementQName, final String aQualifiedModelElementClassName, final String aAttributeName ) {

        this.childs.add( new SimpleElementOrAttributeImpl( xmlElementQName, aQualifiedModelElementClassName, aAttributeName ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Element declaration {0} with simple type definition added to complex type method {1}", new Object[] { xmlElementQName.getQName( ), this.getMethodName( ) } ); //$NON-NLS-1$
        }
    }

    public void addComplexXmlElement( final QualifiedName xmlElementQName, final XmAssociation moinAssoc, final String methodNameOfComplexTypeOfElement ) {

        final String associationClassQName = XmParserSerializerTemplateImpl.getQualifiedJmiClassName( moinAssoc.getNamespace( ), moinAssoc.getMofName( ) );
        this.childs.add( new AssociationImpl( associationClassQName, moinAssoc.getReferencedEndName( ), xmlElementQName, methodNameOfComplexTypeOfElement ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Element declaration {0} with complex type definition added to complex type method {1}", new Object[] { xmlElementQName.getQName( ), this.getMethodName( ) } ); //$NON-NLS-1$
        }
    }

    public void addSubstitutionGroupHead( final QualifiedName substitionGroupHeadQName, final XmAssociation moinAssoc, final String methodNameOfReferencedSubstitutionHead ) {

        final String associationClassQName = XmParserSerializerTemplateImpl.getQualifiedJmiClassName( moinAssoc.getNamespace( ), moinAssoc.getMofName( ) );
        this.childs.add( new AssociationImpl( associationClassQName, moinAssoc.getReferencedEndName( ), null, methodNameOfReferencedSubstitutionHead ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Substitution group head {0} added to complex type method {1}", new Object[] { substitionGroupHeadQName.getQName( ), this.getMethodName( ) } ); //$NON-NLS-1$
        }
    }


    public List<ChildElement> getChilds( ) {

        return this.childs;
    }


    public String getMethodName( ) {

        return this.methodName;
    }

    public void addXmlAttribute( final QualifiedName aQName, final String aQualifiedModelElementClassName, final String aAttributeName ) {

        this.attributes.add( new SimpleElementOrAttributeImpl( aQName, aQualifiedModelElementClassName, aAttributeName ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Attribute declaration {0} added to complex type method {1}", new Object[] { aQName.getQName( ), this.getMethodName( ) } ); //$NON-NLS-1$
        }
    }

    public List<SimpleElementOrAttribute> getXmlAttributes( ) {

        return this.attributes;
    }

    public String getXmlEntityQName( ) {

        return this.xmlEntityQName;
    }

    public boolean isSimpleContent( ) {

        return this.isSimpleContent;
    }

    @Override
    public String toString( ) {

        return this.getMethodName( );
    }


}
