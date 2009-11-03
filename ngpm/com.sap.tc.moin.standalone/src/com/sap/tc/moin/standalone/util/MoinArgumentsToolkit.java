package com.sap.tc.moin.standalone.util;

/**
 * Toolkit for commandline argument parsing.
 * 
 * @author D046220
 */
public class MoinArgumentsToolkit {

    public static String getArgumentValue( String name, String[] args ) {

        return getArgumentValue( name, args, "", false );
    }

    public static String getArgumentValue( String name, String[] args, String errorText ) {

        return getArgumentValue( name, args, errorText, true );
    }

    public static String getArgumentValue( String name, String[] args, String errorText, boolean failOnMiss ) {

        for ( int i = 0; i < args.length; i++ ) {
            if ( name.equals( args[i] ) ) {
                if ( i == args.length - 1 ) {
                    throw new IllegalStateException( errorText );
                }
                return args[i + 1];
            }

        }

        if ( failOnMiss ) {
            throw new IllegalStateException( "Argument: " + name + " not found." );
        }

        return null;
    }

}
