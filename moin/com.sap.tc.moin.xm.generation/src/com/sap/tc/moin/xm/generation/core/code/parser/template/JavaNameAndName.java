package com.sap.tc.moin.xm.generation.core.code.parser.template;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;


public class JavaNameAndName {



    private final String javaName;

    private final String name;

    public JavaNameAndName( final String aName ) {

        if ( aName == null ) {
            throw new MoinNullPointerException( "aName" ); //$NON-NLS-1$
        }
        this.javaName = PSUtil.replaceNonJavaCharacters( aName );
        this.name = aName;
    }

    /**
     * Returns the name whose characters which are non java identifier part
     * characters are replaced by '_'.
     * 
     * @return changed name
     */
    public String getJavaName( ) {

        return this.javaName;
    }


    /**
     * Returns the name.
     * 
     * @return name
     */
    public String getName( ) {

        return this.name;
    }

    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( name == null ) ? 0 : name.hashCode( ) );
        return result;
    }

    @Override
    public boolean equals( final Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final JavaNameAndName other = (JavaNameAndName) obj;
        if ( name == null ) {
            if ( other.name != null ) {
                return false;
            }
        } else if ( !name.equals( other.name ) ) {
            return false;
        }
        return true;
    }

}
