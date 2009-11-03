/**
 * 
 */
package com.sap.tc.moin.repository.runtimehost.deployment;

public class PriPattern {


    private static final String EMPTY_STRING = ""; //$NON-NLS-1$

    private String prefix;

    private String suffix;

    public PriPattern( String prefix, String suffix ) {

        this.prefix = prefix;
        this.suffix = suffix;
    }

    /**
     * @return the prefix
     */
    public String getPrefix( ) {

        if ( this.prefix == null ) {
            return EMPTY_STRING;
        }
        return prefix;
    }

    /**
     * @return the suffix
     */
    public String getSuffix( ) {

        if ( this.suffix == null ) {
            return EMPTY_STRING;
        }
        return suffix;
    }



    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( prefix == null ) ? 0 : prefix.hashCode( ) );
        result = prime * result + ( ( suffix == null ) ? 0 : suffix.hashCode( ) );
        return result;
    }

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
        PriPattern other = (PriPattern) obj;

        if ( prefix == null ) {
            if ( other.prefix != null ) {
                return false;
            }
        } else if ( !prefix.equals( other.prefix ) ) {
            return false;
        }
        if ( suffix == null ) {
            if ( other.suffix != null ) {
                return false;
            }
        } else if ( !suffix.equals( other.suffix ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString( ) {

        return this.getPrefix( ) + "*" + this.getSuffix( ); //$NON-NLS-1$
    }

}