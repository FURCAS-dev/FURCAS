package com.sap.tc.moin.repository.shared.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * Set using weak references to hold the objects. !!! Warning: this
 * implementation is still incomplete !!!! The referenced objects are held at
 * first in the singleRef. If a second object is added, the WeakHashMap is used
 * and the singleRef is removed.
 * 
 * @version $Revision: #1 $ <BR>
 * <p>
 * Created: 2001/02/16
 * </p>
 * <p>
 * Last modified on $Date: 2009/03/31 $ by $Author: c5097724 $ using $Change:
 * 161662 $
 * </p>
 * <p>
 * Copyright (c) SAP Portals Europe GmbH 2001
 */
public class WeakSet implements Set {

    private WeakReference singleRef;

    private WeakHashMap weakMap;

    private static byte[] DUMMY = new byte[0];

    /**
     * 
     */
    public synchronized int size( ) {

        if ( this.singleRef != null ) {
            if ( this.singleRef.get( ) == null ) {
                this.singleRef = null;
                return 0;
            } else {
                return 1;
            }
        } else if ( this.weakMap != null ) {
            return this.weakMap.size( );
        } else {
            return 0;
        }
    }

    /**
     * 
     */
    public synchronized boolean isEmpty( ) {

        if ( this.singleRef != null ) {
            if ( this.singleRef.get( ) == null ) {
                this.singleRef = null;
                return true;
            } else {
                return false;
            }
        } else if ( this.weakMap != null ) {
            return this.weakMap.isEmpty( );
        } else {
            return true;
        }
    }

    /**
     * 
     */
    public synchronized boolean contains( Object o ) {

        if ( this.singleRef != null ) {
            Object refOb = this.singleRef.get( );
            if ( refOb == null ) {
                this.singleRef = null;
                return false;
            } else {
                return o.equals( refOb );
            }
        } else if ( this.weakMap != null ) {
            return this.weakMap.keySet( ).contains( o );
        } else {
            return false;
        }
    }

    /**
     * Returns an iterator of a cloned set to avoid ConcurrentChangeExceptions
     */
    public synchronized Iterator iterator( ) {

        if ( this.weakMap != null ) {

            HashSet clonedSet = new HashSet( this.weakMap.keySet( ) );
            return clonedSet.iterator( );

        } else {
            ArrayList al = new ArrayList( 1 );
            if ( this.singleRef != null ) {
                Object refOb = this.singleRef.get( );
                if ( refOb == null ) {
                    this.singleRef = null;
                } else {
                    al.add( refOb );
                }
            }
            return al.iterator( );
        }
    }

    /**
     * 
     */
    public synchronized Object[] toArray( ) {

        if ( this.weakMap != null ) {
            return this.weakMap.keySet( ).toArray( );
        } else {
            if ( this.singleRef != null ) {
                Object refOb = this.singleRef.get( );
                if ( refOb == null ) {
                    this.singleRef = null;
                    return new Object[0];
                } else {
                    return new Object[] { refOb };
                }
            } else {
                return new Object[0];
            }
        }
    }

    /**
     * 
     */
    public synchronized Object[] toArray( Object[] a ) {

        if ( this.weakMap != null ) {
            return this.weakMap.keySet( ).toArray( a );
        } else {
            if ( this.singleRef != null ) {
                Object refOb = this.singleRef.get( );
                if ( refOb == null ) {
                    this.singleRef = null;
                } else {
                    a[0] = refOb;
                }
            }
            return a;
        }
    }

    /**
     * 
     */
    public synchronized boolean add( Object o ) {

        if ( this.singleRef != null ) {
            Object refOb = this.singleRef.get( );
            if ( refOb == null ) {
                this.singleRef = new WeakReference( o );
                return true;
            } else {
                this.singleRef = null;
                this.weakMap = new WeakHashMap( );
                this.weakMap.put( refOb, DUMMY );
                return ( this.weakMap.put( o, DUMMY ) == null );
            }
        } else if ( this.weakMap != null ) {
            // DUMMY is put into the table for being able to check if the key
            // already existed
            return ( this.weakMap.put( o, DUMMY ) == null );
        } else {
            this.singleRef = new WeakReference( o );
            return true;
        }
    }

    /**
     * 
     */
    public synchronized boolean remove( Object o ) {

        if ( this.singleRef != null ) {
            Object refOb = this.singleRef.get( );
            if ( refOb == null ) {
                this.singleRef = null;
                return false;
            } else {
                if ( o.equals( refOb ) ) {
                    this.singleRef = null;
                    return true;
                } else {
                    return false;
                }
            }
        } else if ( this.weakMap != null ) {
            return this.weakMap.keySet( ).remove( o );
        } else {
            return false;
        }
    }

    /**
     * 
     */
    public synchronized boolean containsAll( Collection c ) {

        if ( this.weakMap != null ) {
            return this.weakMap.keySet( ).containsAll( c );
        } else {
            int csize = c.size( );
            if ( csize > 1 ) {
                return false;
            } else if ( csize == 0 ) {
                return true;
            } else {
                Object refOb = null;
                if ( this.singleRef != null ) {
                    refOb = this.singleRef.get( );
                    if ( refOb == null ) {
                        this.singleRef = null;
                    }
                }

                if ( refOb != null ) {
                    Object[] c_a = c.toArray( new Object[1] );
                    return c_a[0].equals( refOb );
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * 
     */
    public synchronized boolean addAll( Collection c ) {

        throw new MoinUnsupportedOperationException( "WeakSet.addAll()" ); //$NON-NLS-1$
    }

    /**
     * 
     */
    public synchronized boolean retainAll( Collection c ) {

        return this.weakMap.keySet( ).retainAll( c );
    }

    /**
     * 
     */
    public synchronized boolean removeAll( Collection c ) {

        if ( this.singleRef != null ) {
            if ( this.singleRef.get( ) != null ) {
                this.singleRef = null;
                return true;
            } else {
                this.singleRef = null;
                return false;
            }
        } else if ( this.weakMap != null ) {
            return this.weakMap.keySet( ).removeAll( c );
        } else {
            return false;
        }
    }

    /**
     * 
     */
    public synchronized void clear( ) {

        if ( this.singleRef != null ) {
            this.singleRef = null;
        } else if ( this.weakMap != null ) {
            this.weakMap.clear( );
        }
    }

}
