package com.sap.tc.moin.repository.jmigenerator.template.impl;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorAttribute;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorReference;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorAssociationWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorAttributeWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorBaseWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorPackageWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorReferenceWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorStructuralFeatureWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorStructureFieldWrapper;

/**
 * Helper template
 */
public class JmiGeneratorFeatureImpl implements JmiGeneratorFeature {

    private String javaInterfaceName;

    private String javaImplementationName;

    private final String name;

    private final String jminame;

    private JmiGeneratorReference myReference;

    private JmiGeneratorAttribute myAttribute;

    private final Boolean isObjectTyped;

    private final Boolean isMultiple;

    private final Boolean isChangeable;

    private JmiGeneratorClassOperation myOperation;

    private final JmiGeneratorBaseWrapper myWrapper;

    private int index = 0;

    private String attributeOrAssociationMofId = null;

    private int toEndNumber;

    private String referenceMofId;

    /**
     * @param wrapper
     */
    public JmiGeneratorFeatureImpl( final JmiGeneratorAttributeWrapper wrapper ) {

        this.myWrapper = wrapper;
        this.attributeOrAssociationMofId = wrapper.getAttributeMofId( );
        this.toEndNumber = wrapper.getToEndNumber( );
        this.name = wrapper.getModelElementName( );
        String substituteName = wrapper.getSubstituteIdentifier( );
        if ( substituteName == null ) {
            substituteName = this.name;
        }
        this.jminame = wrapper.getJMIIdentifier( );
        this.isObjectTyped = wrapper.isObjectTyped( );
        this.isMultiple = wrapper.isMultiple( );
        this.isChangeable = wrapper.isChangeable( );

        this.myAttribute = new JmiGeneratorAttribute( ) {

            public Boolean isDerived( ) {

                return wrapper.isDerived( );
            }

            public String getVariableName( ) {

                return wrapper.getVariableName( );
            }
        };
    }

    /**
     * @param wrapper
     */
    public JmiGeneratorFeatureImpl( JmiGeneratorPackageWrapper wrapper ) {

        this( (JmiGeneratorBaseWrapper) wrapper );
    }

    /**
     * @param wrapper
     */
    public JmiGeneratorFeatureImpl( JmiGeneratorAssociationWrapper wrapper ) {

        this( (JmiGeneratorBaseWrapper) wrapper );
    }

    /**
     * @param wrapper
     */
    public JmiGeneratorFeatureImpl( JmiGeneratorClassWrapper wrapper ) {

        this( (JmiGeneratorBaseWrapper) wrapper );
    }

    /**
     * @param wrapper
     */
    public JmiGeneratorFeatureImpl( final JmiGeneratorReferenceWrapper wrapper ) {

        this.myWrapper = wrapper;
        this.attributeOrAssociationMofId = wrapper.getAssociationMofId( );
        this.toEndNumber = wrapper.getReferencedAssociationEndNumber( );
        this.referenceMofId = wrapper.getReferenceMofId( );
        this.name = wrapper.getModelElementName( );
        String substituteName = wrapper.getSubstituteIdentifier( );
        if ( substituteName == null ) {
            substituteName = this.name;
        }
        this.jminame = wrapper.getJMIIdentifier( );
        this.isObjectTyped = Boolean.FALSE;
        this.isMultiple = wrapper.isMultiple( );

        this.myReference = new JmiGeneratorReference( ) {

            public Boolean exposedAssocEndIsEnd0( ) {

                return wrapper.exposesEnd0( );
            }

            public Boolean bothEndsChangeable( ) {

                return wrapper.bothEndsChangeable( );
            }

            public Boolean isAssociationDerived( ) {

                return wrapper.associationIsDerived( );
            }
        };
        this.isChangeable = wrapper.isChangeable( );
    }

    /**
     * @param wrapper
     */
    public JmiGeneratorFeatureImpl( final JmiGeneratorStructureFieldWrapper wrapper ) {

        this.myWrapper = wrapper;
        // for some reason, structure fields are referenced by their name
        this.name = wrapper.getModelElementName( );

        this.myAttribute = new JmiGeneratorAttribute( ) {

            public Boolean isDerived( ) {

                return Boolean.FALSE;
            }

            public String getVariableName( ) {

                return wrapper.getVariableName( );
            }
        };

        String substituteName = wrapper.getSubstituteIdentifier( );
        if ( substituteName == null ) {
            substituteName = this.name;
        }
        this.jminame = wrapper.getJMIIdentifier( );
        this.isObjectTyped = Boolean.FALSE;
        this.isMultiple = Boolean.FALSE;
        this.isChangeable = Boolean.FALSE;
    }

    private JmiGeneratorFeatureImpl( JmiGeneratorBaseWrapper wrapper ) {

        this.myWrapper = wrapper;
        this.name = wrapper.getModelElementName( );
        String substituteName = wrapper.getSubstituteIdentifier( );
        if ( substituteName == null ) {
            substituteName = this.name;
        }
        this.jminame = wrapper.getJMIIdentifier( );
        this.isObjectTyped = Boolean.FALSE;
        this.isMultiple = Boolean.FALSE;
        this.isChangeable = Boolean.FALSE;
    }

    public String getJavaInterfaceType( ) {

        if ( this.javaInterfaceName == null ) {
            this.javaInterfaceName = this.myWrapper.getJavaClassName( JmiGenerationKind.INTERFACE, true );
        }
        return this.javaInterfaceName;
    }

    public String getJavaImplementationType( ) {

        if ( this.javaImplementationName == null ) {
            this.javaImplementationName = this.myWrapper.getJavaClassName( JmiGenerationKind.CLASS, true );
        }
        return this.javaImplementationName;
    }

    public String getName( ) {

        return this.name;
    }

    public JmiGeneratorAttribute getAttribute( ) {

        return this.myAttribute;
    }

    public JmiGeneratorReference getReference( ) {

        return this.myReference;
    }

    /**
     * @param actIndex sets the index of this feature in the list of feature IDs
     */
    public void setIndex( int actIndex ) {

        this.index = actIndex;
    }

    /**
     * @param op
     */
    public void setOperation( JmiGeneratorClassOperation op ) {

        this.myOperation = op;
    }

    public String getAccessorNameInternal( ) {

        return this.myWrapper.getAccessorNameInternal( );
    }

    public String getMutatorNameInternal( ) {

        return this.myWrapper.getMutatorNameInternal( );
    }

    public String getAccessorName( ) {

        return this.myWrapper.getAccessorName( );
    }

    public String getMutatorName( ) {

        return this.myWrapper.getMutatorName( );
    }

    public String getJavaType( ) {

        String type = getJavaInterfaceType( );
        if ( type.equals( "boolean" ) ) { //$NON-NLS-1$
            return Boolean.class.getName( );
        }
        if ( type.equals( "int" ) ) { //$NON-NLS-1$
            return Integer.class.getName( );
        }
        if ( type.equals( "double" ) ) { //$NON-NLS-1$
            return Double.class.getName( );
        }
        if ( type.equals( "long" ) ) { //$NON-NLS-1$
            return Long.class.getName( );
        }
        if ( type.equals( "float" ) ) { //$NON-NLS-1$
            return Float.class.getName( );
        }
        return this.javaInterfaceName;
    }

    public String getJavaTypeParameter( ) {

        return ( (JmiGeneratorStructuralFeatureWrapper) this.myWrapper ).getJavaTypeParameter( );
    }

    public Boolean isObjectTyped( ) {

        return this.isObjectTyped;
    }

    public Boolean isMultiple( ) {

        return this.isMultiple;
    }

    public Integer getFeatureIndex( ) {

        return Integer.valueOf( this.index );
    }

    public JmiGeneratorClassOperation getOperation( ) {

        return this.myOperation;
    }

    @Override
    public String toString( ) {

        return this.name;
    }

    public Boolean isChangeable( ) {

        return this.isChangeable;
    }

    public String getJmiName( ) {

        return this.jminame;
    }

    public String getAttributeOrAssociationMofId( ) {

        return this.attributeOrAssociationMofId;
    }

    public int getToEndNumber( ) {

        return this.toEndNumber;
    }

    public String getReferenceMofId( ) {

        return this.referenceMofId;
    }

    public Boolean isSingleValuedNonObjectTyped( ) {

        if ( myWrapper instanceof JmiGeneratorAttributeWrapper ) {
            return ( (JmiGeneratorAttributeWrapper) myWrapper ).isSingleValuedNonObjectTyped( );
        } else if ( myWrapper instanceof JmiGeneratorStructureFieldWrapper ) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
