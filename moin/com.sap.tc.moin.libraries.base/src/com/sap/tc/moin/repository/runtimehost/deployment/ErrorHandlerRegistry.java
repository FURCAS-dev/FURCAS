package com.sap.tc.moin.repository.runtimehost.deployment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * Registry for error handlers.
 * <p>
 * Error handlers can be registred for a given version range. The version ranges
 * for the error handlers that are to be registered must not overlap. Therefore,
 * registering an error handler with a version range overlapping the range of an
 * already registered one will fail.
 * </p>
 * <p>
 * Structure: cri - interval - error handler instance reference
 * </p>
 * 
 * @author d026715
 */
public class ErrorHandlerRegistry<T> {

    Map<String, Map<VersionInterval, T>> registry = new HashMap<String, Map<VersionInterval, T>>( );

    /**
     * Puts an error handler into the registry. Returns <code>false</code> if
     * this fails (see above).
     * 
     * @param containerId
     * @param versionFrom
     * @param versionTo
     * @param errorHandler
     * @return
     */
    public boolean put( String containerId, String versionFrom, String versionTo, T errorHandler ) {

        VersionInterval versionRange = new VersionInterval( versionFrom, versionTo );
        Map<VersionInterval, T> mapForContainer = this.registry.get( containerId );
        if ( mapForContainer == null ) {
            mapForContainer = new TreeMap<VersionInterval, T>( );
            registry.put( containerId, mapForContainer );
        } else {
            if ( mapForContainer.containsKey( versionRange ) ) {
                return false;
            }
        }

        mapForContainer.put( versionRange, errorHandler );

        return true;
    }

    public boolean remove( String containerId, String versionFrom, String versionTo ) {

        VersionInterval versionRange = new VersionInterval( versionFrom, versionTo );
        Map<VersionInterval, T> mapForContainer = this.registry.get( containerId );
        if ( mapForContainer != null ) {
            boolean removed = ( mapForContainer.remove( versionRange ) != null );
            if ( mapForContainer.isEmpty( ) ) {
                this.registry.remove( containerId );
            }
            return removed;
        }
        return false;
    }

    /**
     * Gets an error handler for a given version.
     * 
     * @param containerId
     * @param version
     * @return
     */
    public T get( String containerId, String version ) {

        VersionInterval versionRange = new VersionInterval( version, version );
        Map<VersionInterval, T> mapForContainer = this.registry.get( containerId );
        if ( mapForContainer != null ) {
            return mapForContainer.get( versionRange );
        }

        return null;
    }

    public boolean contains( String containerId, String versionFrom, String versionTo ) {

        VersionInterval versionRange = new VersionInterval( versionFrom, versionTo );
        Map<VersionInterval, T> mapForContainer = this.registry.get( containerId );
        if ( mapForContainer != null ) {
            if ( mapForContainer.containsKey( versionRange ) ) {
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator( ) {

        return new Iterator<T>( ) {

            Iterator<Map<VersionInterval, T>> outerIterator = registry.values( ).iterator( );

            Iterator<T> innerIterator = null;

            public void remove( ) {

                throw new MoinUnsupportedOperationException( RuntimeHostDeploymentMessages.REMOVENOTSUPPORTEDBYERRORHANDLERREGISTRY );
            }

            public T next( ) {

                if ( this.initInnerIterator( ) ) {
                    if ( this.innerIterator.hasNext( ) ) {
                        return this.innerIterator.next( );
                    } else {
                        this.innerIterator = null;
                        return this.next( );
                    }
                } else {
                    throw new NoSuchElementException( );
                }

            }

            public boolean hasNext( ) {

                if ( this.initInnerIterator( ) ) {
                    if ( this.innerIterator.hasNext( ) ) {
                        return true;
                    } else {
                        this.innerIterator = null;
                        return this.hasNext( );
                    }
                } else {
                    return false;
                }
            }

            private boolean initInnerIterator( ) {

                if ( this.innerIterator == null ) {
                    if ( this.outerIterator.hasNext( ) ) {
                        this.innerIterator = this.outerIterator.next( ).values( ).iterator( );
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            }
        };
    }

    public static class VersionInterval implements Comparable<VersionInterval> {


        static VersionInterval NO_VERSION = new VersionInterval( null, null );

        String from;

        String to;

        public VersionInterval( String from, String to ) {

            this.from = from;
            this.to = to;
        }

        public String getFrom( ) {

            return from;
        }


        public String getTo( ) {

            return to;
        }

        /**
         * Interval compare. The intervals are only different if they are
         * outside of each other.
         */
        public int compareTo( VersionInterval o ) {

            // set null values to value of other interval
            String thisLower = this.getFrom( );
            String thisUpper = this.getTo( );
            String otherLower = o.getFrom( );
            String otherUpper = o.getTo( );

            // if one of the operands is null, return equal
            // if both have no upper limit, return equal
            if ( ( ( thisUpper == null ) && ( thisLower == null ) ) || ( ( otherUpper == null ) && ( otherLower == null ) ) || ( ( thisUpper == null ) && ( otherUpper == null ) ) ) {
                return 0;
            }

            if ( otherLower == null ) {
                otherLower = this.getFrom( );
            }
            if ( thisUpper == null ) {
                thisUpper = o.getTo( );
            }
            if ( thisLower == null ) {
                thisLower = o.getFrom( );
            }
            if ( otherUpper == null ) {
                otherUpper = this.getTo( );
            }

            if ( thisUpper.compareTo( otherLower ) <= 0 ) {
                if ( thisLower.compareTo( otherLower ) < 0 ) {
                    return -1;
                }
            } else if ( thisLower.compareTo( otherUpper ) >= 0 ) {
                if ( thisUpper.compareTo( otherUpper ) > 0 ) {
                    return 1;
                }

            }
            return 0;
        }

        @Override
        public int hashCode( ) {

            final int prime = 31;
            int result = 1;
            result = prime * result + ( ( from == null ) ? 0 : from.hashCode( ) );
            result = prime * result + ( ( to == null ) ? 0 : to.hashCode( ) );
            return result;
        }

        @Override
        public boolean equals( Object obj ) {

            if ( this == obj )
                return true;
            if ( obj == null )
                return false;
            if ( getClass( ) != obj.getClass( ) )
                return false;
            VersionInterval other = (VersionInterval) obj;
            if ( from == null ) {
                if ( other.from != null )
                    return false;
            } else if ( !from.equals( other.from ) )
                return false;
            if ( to == null ) {
                if ( other.to != null )
                    return false;
            } else if ( !to.equals( other.to ) )
                return false;
            return true;
        }



    }
}
