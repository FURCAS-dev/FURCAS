package com.sap.tc.moin.repository.runtimehost.deployment;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * The pattern registry maps PRI patterns to serialization ids.<br>
 * The map has the following structure:<br>
 * reversed suffix -* prefix - serialization id<br>
 * The implementation currently uses the internal {@link FlexiblePrefixMapImpl}.
 * 
 * @author d026715
 */
public class PriPatternRegistry {

    private PrefixMap<PrefixMap<String>> suffixPrefixMap = new FlexiblePrefixMapImpl<PrefixMap<String>>( );

    /**
     * Puts a serialization id into the registry.
     * 
     * @param prefix prefix to register
     * @param suffix suffix to register
     * @param value serialization id
     * @return
     */
    public boolean put( String prefix, String suffix, String value ) {

        // reverse suffix
        String reverseSuffix = new StringBuilder( suffix ).reverse( ).toString( );

        // get the prefix map
        PrefixMap<String> prefixMap = this.suffixPrefixMap.get( reverseSuffix );
        if ( prefixMap == null ) {
            // simplified map if there is only one prefix - helpful if the prefix is ""
            prefixMap = new OneElementPrefixMap<String>( prefix, value );
            return this.suffixPrefixMap.put( reverseSuffix, prefixMap );
        } else if ( prefixMap instanceof OneElementPrefixMap ) {

            String existingValue = ( (OneElementPrefixMap<String>) prefixMap ).getValue( );
            String existingKey = ( (OneElementPrefixMap<String>) prefixMap ).getKey( );
            if ( !existingKey.equals( prefix ) ) {
                this.suffixPrefixMap.remove( reverseSuffix );
                prefixMap = new PrefixMapImpl<String>( );
                this.suffixPrefixMap.put( reverseSuffix, prefixMap );
                // put old and new - let map decide if possible or not
                prefixMap.put( existingKey, existingValue );
                return prefixMap.put( prefix, value );
            } else {
                return false;
            }

        } else {
            return prefixMap.put( prefix, value );
        }
    }

    /**
     * Finds the entry for the given partition name.
     * 
     * @param partitionName
     * @return
     */
    public String find( String partitionName ) {

        // reverse entry for suffix
        String reversePri = new StringBuilder( partitionName ).reverse( ).toString( );

        PrefixMap<String> found = this.suffixPrefixMap.find( reversePri );
        if ( found != null ) {
            return found.find( partitionName );
        } else {
            return null;
        }
    }

    /**
     * Gets the entry for a given prefix and suffix.
     * 
     * @param prefix
     * @param suffix
     * @return
     */
    public String get( String prefix, String suffix ) {

        // TODO (inspection) find cheaper way - suffix map?
        String reverseSuffix = new StringBuilder( suffix ).reverse( ).toString( );

        PrefixMap<String> found = this.suffixPrefixMap.get( reverseSuffix );
        if ( found != null ) {
            return found.get( prefix );
        } else {
            return null;
        }
    }

    /**
     * Removes an entry.
     * 
     * @param prefix
     * @param suffix
     */
    public void remove( String prefix, String suffix ) {

        String reverseSuffix = new StringBuilder( suffix ).reverse( ).toString( );

        PrefixMap<String> found = this.suffixPrefixMap.get( reverseSuffix );
        if ( found != null ) {
            if ( found instanceof OneElementPrefixMap ) {
                if ( ( (OneElementPrefixMap<String>) found ).getKey( ).equals( prefix ) ) {
                    this.suffixPrefixMap.remove( reverseSuffix );
                }
            } else {
                found.remove( prefix );
            }
        }
    }

    /**
     * Returns all registerd suffixes.
     * 
     * @return
     */
    public Set<String> getSuffixes( ) {

        Set<String> keySet = this.suffixPrefixMap.keySet( );
        Set<String> result = new HashSet<String>( keySet.size( ) );

        for ( String suffix : keySet ) {

            String correctSuffix = new StringBuilder( suffix ).reverse( ).toString( );
            result.add( correctSuffix );
        }

        return result;
    }

    /**
     * Returns pattern entries with their value.
     * 
     * @return
     */
    public Set<Entry<PriPattern, String>> getEntrySet( ) {

        Set<Entry<PriPattern, String>> result = new HashSet<Entry<PriPattern, String>>( );

        Set<String> suffixes = this.suffixPrefixMap.keySet( );

        for ( String suffix : suffixes ) {
            PrefixMap<String> prefixMap = this.suffixPrefixMap.get( suffix );
            Set<String> prefixes = prefixMap.keySet( );
            for ( String prefix : prefixes ) {
                String value = prefixMap.get( prefix );
                String correctSuffix = new StringBuilder( suffix ).reverse( ).toString( );
                result.add( new PriPatternEntry( new PriPattern( prefix, correctSuffix ), value ) );
            }
        }

        return result;
    }

    /**
     * Prefix map. Contains a map of prefixes and Objects. Allows to get the
     * element that is registered for the prefix of a given key. In contrast to
     * {@link PrefixMapImpl}, this map allows to put in prefixes that are
     * prefixes of other prefixes (moin/meta and moin). This map is used for the
     * suffix map, mapping the reversed suffixes to a prefix map. Suffixes can
     * be nested (e.g. test and testnew).
     * 
     * @author d026715
     * @param <T>
     */
    public static class FlexiblePrefixMapImpl<T> implements PrefixMap<T> {

        private TreeMap<String, T> treeMap = new TreeMap<String, T>( );

        public T find( String string ) {

            T value = null;
            T foundValue = null;
            int l = 1;

            while ( foundValue == null ) {
                if ( string.length( ) > l ) {
                    String subString = string.substring( 0, l );
                    SortedMap<String, T> tailMap = treeMap.tailMap( subString );
                    if ( !tailMap.isEmpty( ) ) {
                        String firstKey = tailMap.firstKey( );
                        if ( string.startsWith( firstKey ) ) {
                            l = firstKey.length( );
                            value = treeMap.get( firstKey );
                        } else if ( value != null ) {
                            foundValue = value;
                        } else if ( firstKey.compareTo( string ) > 0 ) {
                            break;
                        }
                        l++;
                    } else {
                        foundValue = value;
                        break;
                    }
                } else {
                    foundValue = value;
                    break;
                }
            }
            // special treatment for the empty string
            if ( foundValue == null ) {
                return this.treeMap.get( "" ); //$NON-NLS-1$
            }

            return foundValue;
        }

        public T get( String prefix ) {

            return this.treeMap.get( prefix );
        }

        public boolean put( String prefix, T value ) {

            T existing = this.treeMap.get( prefix );
            if ( existing == null ) {
                this.treeMap.put( prefix, value );
                return true;
            } else {
                return false;
            }
        }

        public void remove( String prefix ) {

            this.treeMap.remove( prefix );
        }

        public Set<String> keySet( ) {

            return this.treeMap.keySet( );
        }

    }

    /**
     * Prefix map. Contains a map of prefixes and Objects. Allows to get the
     * element that is registered for the prefix of a given key.
     * 
     * @author d026715
     * @param <T>
     */
    public static class PrefixMapImpl<T> implements PrefixMap<T> {

        private TreeMap<String, T> treeMap = new TreeMap<String, T>( );

        public T find( String string ) {

            T foundValue = null;
            int l = 0;

            while ( foundValue == null ) {
                if ( string.length( ) > l ) {
                    String subString = string.substring( 0, l );
                    SortedMap<String, T> tailMap = treeMap.tailMap( subString );
                    if ( !tailMap.isEmpty( ) ) {
                        String firstKey = tailMap.firstKey( );
                        if ( firstKey.compareTo( string ) > 0 ) {
                            break;
                        } else if ( string.startsWith( firstKey ) ) {
                            foundValue = treeMap.get( firstKey );
                        }
                        l++;
                    } else {
                        break;
                    }
                } else {
                    // no string starts with another string that is longer than itself
                    return null;
                }
            }
            return foundValue;
        }

        public T get( String prefix ) {

            return this.treeMap.get( prefix );
        }

        public boolean put( String prefix, T value ) {

            if ( stricterExisting( prefix ) ) {
                return false;
            }
            T existing = this.find( prefix );
            if ( existing == null ) {
                this.treeMap.put( prefix, value );
                return true;
            } else {
                return false;
            }
        }

        public void remove( String prefix ) {

            this.treeMap.remove( prefix );
        }

        public Set<String> keySet( ) {

            return this.treeMap.keySet( );
        }

        private boolean stricterExisting( String prefix ) {

            SortedMap<String, T> tailMap = this.treeMap.tailMap( prefix );
            if ( !tailMap.isEmpty( ) ) {
                String firstKey = tailMap.firstKey( );
                return firstKey.startsWith( prefix );
            }
            return false;
        }

    }

    public static class OneElementPrefixMap<T> implements PrefixMap<T> {

        private String onePrefix;

        private T oneValue;


        public OneElementPrefixMap( String prefix, T value ) {

            this.onePrefix = prefix;
            this.oneValue = value;
        }

        public T find( String string ) {

            if ( ( string != null ) && ( string.startsWith( this.onePrefix ) ) ) {
                return oneValue;
            } else {
                return null;
            }
        }

        public T get( String prefix ) {

            if ( this.onePrefix.equals( prefix ) ) {
                return oneValue;
            } else {
                return null;
            }
        }

        public boolean put( String prefix, T value ) {

            return false;
        }

        public void remove( String prefix ) {

        }

        public String getKey( ) {

            return this.onePrefix;
        }

        public Set<String> keySet( ) {

            HashSet<String> result = new HashSet<String>( 1 );
            result.add( this.onePrefix );

            return result;
        }

        public T getValue( ) {

            return this.oneValue;
        }


    }

    private static class PriPatternEntry implements Map.Entry<PriPattern, String> {

        private PriPattern pattern;

        private String value;

        public PriPatternEntry( PriPattern pattern, String value ) {

            this.pattern = pattern;
            this.value = value;
        }

        public PriPattern getKey( ) {

            return this.pattern;
        }

        public String getValue( ) {

            return this.value;
        }

        public String setValue( String value ) {

            this.value = value;
            return value;
        }

    }

    /**
     * Prefix map. Designed to find map entries whose keys have the given prefix
     * as prefix.
     * 
     * @author D026715
     * @param <T>
     */
    public interface PrefixMap<T> {

        /**
         * Adds a prefix and a value.
         * 
         * @param prefix
         * @param value
         */
        boolean put( String prefix, T value );

        /**
         * Returns the element registered for the prefix of the given string.
         * 
         * @param string
         * @return
         */
        T find( String string );

        /**
         * Simple getter.
         * 
         * @param prefix
         * @return
         */
        T get( String prefix );

        void remove( String prefix );

        public Set<String> keySet( );

    }

}
