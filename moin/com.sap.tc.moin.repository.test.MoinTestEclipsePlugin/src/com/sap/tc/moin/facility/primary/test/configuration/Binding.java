package com.sap.tc.moin.facility.primary.test.configuration;

import java.lang.reflect.Method;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;


/**
 * Represents a binding defined in a facility component with a bind() method.
 */
class Binding {

    /**
     * The facility component which actually holds the binding (can be a subtype
     * of the declaring type).
     */
    private IpiFacilityComponent runtimeFacilityComponent;

    /**
     * Type which defines the binding (can be the supertype of the used runtime
     * facility component).
     */
    private Class<?> declaringType;

    /**
     * The bound type.
     */
    private Class<?> boundType;

    /**
     * The bind related method.
     */
    private Method bindMethod;

    /**
     * A type can be bound to a component more than once (even if this is a
     * special case).
     */
    private int multiplicity;

    /**
     * Constructor.
     */
    public Binding( IpiFacilityComponent runtimeFacilityComponent, Class<?> declaringType, Class<?> boundType, Method bindMethod, int multiplicity ) {

        this.runtimeFacilityComponent = runtimeFacilityComponent;
        this.declaringType = declaringType;
        this.boundType = boundType;
        this.bindMethod = bindMethod;
        this.multiplicity = multiplicity;
    }

    /**
     * @return the declaringType
     */
    protected Class<?> getDeclaringType( ) {

        return declaringType;
    }

    /**
     * @return the boundType
     */
    protected Class<?> getBoundType( ) {

        return boundType;
    }

    /**
     * @return the bindMethod
     */
    protected Method getBindMethod( ) {

        return bindMethod;
    }

    /**
     * @return the multiplicity
     */
    protected int getMultiplicity( ) {

        return multiplicity;
    }

    /**
     * @return runtimeFacilityComponent the runtimeFacilityComponent
     */
    public IpiFacilityComponent getRuntimeFacilityComponent( ) {

        return runtimeFacilityComponent;
    }

    /**
     * hashCode() based on boundType and declaringType.
     */
    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( boundType == null ) ? 0 : boundType.hashCode( ) );
        result = prime * result + ( ( declaringType == null ) ? 0 : declaringType.hashCode( ) );
        return result;
    }

    /**
     * equals() based on boundType and declaringType.
     */
    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final Binding other = (Binding) obj;
        if ( boundType == null ) {
            if ( other.boundType != null ) {
                return false;
            }
        } else if ( !boundType.equals( other.boundType ) ) {
            return false;
        }
        if ( declaringType == null ) {
            if ( other.declaringType != null ) {
                return false;
            }
        } else if ( !declaringType.equals( other.declaringType ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString( ) {

        StringBuilder stringBuilder = new StringBuilder( );
        stringBuilder.append( "runtimeFacilityComponent=" + this.runtimeFacilityComponent + "\n" );
        stringBuilder.append( "declaringType=" + this.declaringType + "\n" );
        stringBuilder.append( "boundType=" + this.boundType + "\n" );

        return stringBuilder.toString( );

    }
}