package com.sap.tc.moin.repository.shared.util.cmdline;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CommandLineParser {

    private List<String> args;

    private PrintStream out;

    private boolean success = true;

    private Object configObject;

    public CommandLineParser( String[] args, Object configObject, PrintStream out ) {

        this.args = Arrays.asList( args );
        this.configObject = configObject;
        this.out = out;
    }

    private int findParameter( String param ) {

        for ( int i = 0; i < args.size( ); ++i ) {
            if ( args.get( i ).equals( param ) ) {
                return i;
            }
        }
        return -1;
    }

    private void setFieldValue( Field field, Object value ) {

        try {
            field.set( configObject, value );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    private void processField( Field field, Option option ) {

        String name = option.name( );
        if ( name.equals( "" ) ) { //$NON-NLS-1$
            name = "-" + field.getName( ); //$NON-NLS-1$
        }
        int idx = findParameter( name );
        if ( idx == -1 ) {
            if ( option.mandatory( ) ) {
                if ( out != null ) {
                    out.println( CommandLineParserMessages.PARAMETER_IS_MISSING.format( name ) );
                    success = false;
                }
            }
        } else {
            if ( option.hasParameter( ) ) {
                String data = args.get( idx + 1 );
                if ( field.getType( ).isArray( ) || List.class.isAssignableFrom( field.getType( ) ) ) {
                    String[] res = data.split( option.separator( ) );
                    if ( field.getType( ).isArray( ) ) {
                        setFieldValue( field, res );
                    } else {
                        setFieldValue( field, Arrays.asList( res ) );
                    }
                } else {
                    setFieldValue( field, data );
                }
            } else {
                setFieldValue( field, Boolean.TRUE );
            }
        }
    }

    public boolean parse( ) {

        for ( Field field : configObject.getClass( ).getDeclaredFields( ) ) {
            Option option = field.getAnnotation( Option.class );
            if ( option != null ) {
                processField( field, option );
            }
        }
        return success;
    }
}
