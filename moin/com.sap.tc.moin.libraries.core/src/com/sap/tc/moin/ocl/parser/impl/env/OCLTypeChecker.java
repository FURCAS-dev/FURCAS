package com.sap.tc.moin.ocl.parser.impl.env;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.types.BagType;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.OrderedSetType;
import org.omg.ocl.types.SequenceType;
import org.omg.ocl.types.SetType;
import org.omg.ocl.types.TupleType;
import org.omg.ocl.types.__impl.CollectionTypeInternal;
import org.omg.ocl.types.__impl.TupleTypeInternal;

import com.sap.tc.moin.ocl.parser.IOCLTypeChecker;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizableElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterImpl;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * Service which provides elementary type checking methods used by the OCL
 * parser
 */
public class OCLTypeChecker implements IOCLTypeChecker {

    /**
     * The helper used to instantiate JMI-classes
     */
    private final MoinJmiCreator jmiCreator;

    /**
     * The OCL Type Checker provides basic type-checking functionality for the
     * OCL parser.
     * 
     * @param theJmiCreator the {@link MoinJmiCreator}
     */
    public OCLTypeChecker( MoinJmiCreator theJmiCreator ) {

        this.jmiCreator = theJmiCreator;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLTypeChecker#createOclType(javax
     * .jmi.model.MultiplicityType,
     * com.sap.tc.moin.repository.mmi.model.Classifier)
     */
    public Classifier createOclType( MultiplicityType mt, Classifier type ) {

        if ( mt == null ) {
            return type;
        }

        /*
         * Got the return parameter, now let's see whether op returns a single
         * value or some sort of collection. For single value, upper
         * multiplicity should be 1.
         */
        if ( mt.getUpper( ) == 1 ) {
            return type;
        }

        if ( mt.isOrdered( ) ) {
            if ( mt.isUnique( ) ) {
                /*
                 * ordered && unique --> ordered set
                 */
                return this.jmiCreator.createOrderedSetType( type );
            }
            /*
             * ordered && !unique --> sequence
             */
            return this.jmiCreator.createSequenceType( type );

        }
        if ( mt.isUnique( ) ) {
            /*
             * !ordered & unique --> set
             */
            return this.jmiCreator.createSetType( type );
        }
        /*
         * !ordered && !unique --> bag
         */
        return this.jmiCreator.createBagType( type );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLTypeChecker#argumentsConform(
     * com.sap.tc.moin.repository.mmi.model.Operation, java.util.List)
     */
    public boolean argumentsConform( Operation op, List<Classifier> args ) {

        // go through all arguments in args
        // and compare it to the arguments
        boolean applicable = true;
        int argIndex = 0;
        CoreConnection conn = this.jmiCreator.getConnection( );
        JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) op ).getContents( conn );
        for ( int i = 0, n = contents.size( conn.getSession( ) ); i < n; i++ ) {
            RefObjectImpl contentObject = (RefObjectImpl) contents.get(conn.getSession(), i);
	    if (contentObject instanceof ParameterImpl) {
		ParameterImpl par = (ParameterImpl) contentObject;
		// only in and in/out paramteres are relevant
		if (par.getDirection() == DirectionKindEnum.IN_DIR || par.getDirection() == DirectionKindEnum.INOUT_DIR) {
		    // check whether the type of the argument conforms to
		    // the type of the parameter
		    if (args.size() <= argIndex) {
			// no more arguments left
			applicable = false;
			break;
		    }
		    if (!typesConform(args.get(argIndex), createOclType(par.getMultiplicity(), par.getType(conn)))) {
			// types do not conform
			// the signature does not match the operation
			applicable = false;
			break;
		    }
		    // go to the next argument
		    argIndex++;
		}
	    }
        }
        if ( argIndex != args.size( ) ) {
            // there are still arguments left which are not matched
            // by paramters
            applicable = false;
        }
        return applicable;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLTypeChecker#argumentsMatch(java
     * .util.List, java.util.List)
     */
    public boolean argumentsMatch( List<Classifier> definedArgs, List<Classifier> providedArgs ) {

        /*
         * if providedArgs is null, no arguments were specified, thus everything
         * matches
         */
        if ( providedArgs == null ) {
            return true;
        }
        /*
         * if operations wasn't defined with any arguments, we don't know
         */
        if ( definedArgs == null ) {
            return false;
        }

        int s1 = definedArgs.size( );
        int s2 = providedArgs.size( );

        if ( s1 != s2 ) {
            return false;
        }

        for ( int i = 0; i < s1; i++ ) {
            /*
             * -- WATCH OUT: ORDER OF ARGUMENTS IS CRUCIAL! IF YOU CHANGE -- IT,
             * TEST MAY FAIL! -- -- I actually ran into this problem when
             * l2.get(i) returns OclAny -- see code in {@link
             * Environment#typesConform}
             */
            if ( !typesConform( definedArgs.get( i ), providedArgs.get( i ) ) ) {
                return false;
            }
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLTypeChecker#commonSuperType(javax
     * .jmi.model.Classifier, com.sap.tc.moin.repository.mmi.model.Classifier)
     */
    public Classifier commonSuperType( Classifier type1, Classifier type2 ) {

        if ( type1 != null && type2 != null ) {
            // check the trivial cases first
            if ( type1.equals( type2 ) ) {
                return type1;
            }
            // check whether one type is the supertype of the other
            if ( typesConform( type1, type2 ) ) {
                return type2;
            }
            if ( typesConform( type2, type1 ) ) {
                return type1;
            }

            if ( type1 instanceof CollectionType && type2 instanceof CollectionType ) {
                Classifier elementType1 = ( (CollectionTypeInternal) type1 ).getElementType( this.jmiCreator.getConnection( ) );
                Classifier elementType2 = ( (CollectionTypeInternal) type2 ).getElementType( this.jmiCreator.getConnection( ) );

                if ( type1 instanceof SetType && type2 instanceof SetType ) {
                    return this.jmiCreator.createSetType( commonSuperType( elementType1, elementType2 ) );
                } else if ( type1 instanceof BagType && type2 instanceof BagType ) {
                    return this.jmiCreator.createBagType( commonSuperType( elementType1, elementType2 ) );
                } else if ( type1 instanceof SequenceType && type2 instanceof SequenceType ) {
                    return this.jmiCreator.createSequenceType( commonSuperType( elementType1, elementType2 ) );
                } else if ( type1 instanceof OrderedSetType && type2 instanceof OrderedSetType ) {
                    return this.jmiCreator.createOrderedSetType( commonSuperType( elementType1, elementType2 ) );
                }

                // TODO it is certainly type correct that a collection is has common supertype with a more specific
                // collection this is currenlty not supported (and thus limits the type system)

            }

            Map<Classifier, Integer> referenceList = new HashMap<Classifier, Integer>( );

            List<GeneralizableElementInternal> backlog = new ArrayList<GeneralizableElementInternal>( 10 );

            backlog.add( (GeneralizableElementInternal) type1 );

            // build list of all supertypes for type 1 O(n) with n - number of super types
            // if too many backlog reallocations will be found (array list), more aggressive
            // allocation strategy may be choosen.
            // Revisiting already known super types will be avoided.
            int largestFoundIndex = 0;
            for ( int i = 0; i < backlog.size( ); i++ ) {
                GeneralizableElementInternal element = backlog.get( i );

                referenceList.put( (Classifier) element, Integer.valueOf( largestFoundIndex++ ) );

                JmiList<GeneralizableElement> result = (JmiList<GeneralizableElement>) element.getSupertypes( this.jmiCreator.getConnection( ) );
                // avoid recursion
                for ( int sindex = 0; sindex < result.size( this.jmiCreator.getConnection( ).getSession( ) ); sindex++ ) {

                    Object o = result.get( this.jmiCreator.getConnection( ).getSession( ), sindex );

                    if ( !referenceList.containsKey( o ) ) {
                        backlog.add( (GeneralizableElementInternal) o );
                    }

                }

            }

            backlog.clear( );

            backlog.add( (GeneralizableElementInternal) type2 );

            Set<Classifier> foundElements = new HashSet<Classifier>( );

            // visit all super types of type2 and create a list of common super types with type1
            // This part is O(n) with n - number of type2's super types. Lookups are O(1), if reference list
            // is sparsely populated.
            // If this part performs poorly, a more aggressive allocation strategies for backlog and
            // reference list may be choosen.
            for ( int i = 0; i < backlog.size( ); i++ ) {
                GeneralizableElementInternal element = backlog.get( i );

                if ( referenceList.containsKey( element ) ) {
                    foundElements.add( (Classifier) element );
                }

                JmiList<GeneralizableElement> result = (JmiList<GeneralizableElement>) element.getSupertypes( this.jmiCreator.getConnection( ) );
                // avoid recursion
                for ( int sindex = 0; sindex < result.size( this.jmiCreator.getConnection( ).getSession( ) ); sindex++ ) {
                    Object o = result.get( this.jmiCreator.getConnection( ).getSession( ), sindex );
                    backlog.add( (GeneralizableElementInternal) o );
                }
            }

            Classifier ret = null;
            // No common super types => OclUndefined
            if ( foundElements.isEmpty( ) ) {
                ret = this.jmiCreator.getOclInvalidClass( );
            } else {
                // search for the most common super type.
                // this part is O(n) with n - number of found common super types.
                // If this part performs poorly: create a tree set for the found types with index as
                // comparison criterion.
                int index = largestFoundIndex + 1;
                for ( Classifier classifier : foundElements ) {
                    Integer currentIndex = referenceList.get( classifier );

                    if ( currentIndex.intValue( ) < index ) {
                        index = currentIndex.intValue( );
                        ret = classifier;
                    }
                }
            }

            return ret;
        }
        return this.jmiCreator.getOclInvalidClass( );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLTypeChecker#getReturnType(javax
     * .jmi.model.Operation)
     */
    public Classifier getReturnType( Operation operation ) {

        try {
            return this.jmiCreator.getReturnType( operation );
        } catch ( OclSemanticException e ) {
            return this.jmiCreator.getOclInvalidClass( );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLTypeChecker#typesConform(javax
     * .jmi.model.Classifier, com.sap.tc.moin.repository.mmi.model.Classifier)
     */
    public boolean typesConform( Classifier type1, Classifier type2 ) {

        CoreConnection connection = this.jmiCreator.getConnection( );
        SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );
        // deal with alias types
        Classifier actType1 = jmiHelper.getNonAliasType( connection.getSession( ), type1 );
        Classifier actType2 = jmiHelper.getNonAliasType( connection.getSession( ), type2 );

        // check the trivial cases first
        if ( actType1.equals( actType2 ) ) {
            return true;
        }
        // oclUndefined conforms to everything
        if ( this.jmiCreator.getOclVoidClass( ).equals( actType1 ) ) {
            return true;
        }

        // TODO oclInvalid conforms to everything??
        if ( this.jmiCreator.getOclInvalidClass( ).equals( actType1 ) ) {
            return true;
        }

        // some basic checks based on the name
        List<String> type2QName = MoinMetamodelCode.getQualifiedName( connection, actType2, (RefObjectImpl) actType2 );
        String type2Name = actType2.getName( );
        String packageName = null;
        if ( type2QName.size( ) >= 2 ) {
            packageName = type2QName.get( type2QName.size( ) - 2 );
        }

        // everything is conformant to Reflect::Element
        if ( OclConstants.T_ELEMENT.equals( type2Name ) && OclConstants.T_REFLECT.equals( packageName ) ) {
            return true;
        }

        // everything is conformant to Model::Classifier
        if ( OclConstants.T_CLASSIFIER.equals( type2Name ) && OclConstants.P_MODEL.equals( packageName ) ) {
            return true;
        }

        // any type conforms to OclAny except for Collections and Tuples.
        if ( !( actType1 instanceof CollectionType ) && !( actType1 instanceof TupleType ) ) {
            if ( OclConstants.T_OCLANYSTDLIB.equals( type2Name ) ) {
                return true;
            }
        }

        // check for some primitive types
        if ( actType1 instanceof PrimitiveType && actType2 instanceof PrimitiveType ) {

            // this checks for the names (the instances are different)
            if ( actType1.getName( ).equals( actType2.getName( ) ) ) {
                return true;
            }

            // check relation of numeral primitive types
            if ( actType2.equals( this.jmiCreator.getFloatClass( ) ) ) {
                if ( actType1.equals( this.jmiCreator.getIntClass( ) ) ) {
                    return true;
                }
            } else if ( actType2.equals( this.jmiCreator.getDoubleClass( ) ) ) {
                if ( actType1.equals( this.jmiCreator.getIntClass( ) ) || actType1.equals( this.jmiCreator.getLongClass( ) ) || actType1.equals( this.jmiCreator.getFloatClass( ) ) ) {
                    return true;
                }

            } else if ( actType2.equals( this.jmiCreator.getLongClass( ) ) ) {
                if ( actType1.equals( this.jmiCreator.getIntClass( ) ) ) {
                    return true;
                }
            }
        }

        /*
         * A concrete collection type conforms to its generic collection type.
         * Note that this introduces a type hole! (Is this checked during
         * evaluation?)
         */
        if ( actType1 instanceof CollectionType
             && ( ( (Classifier) actType1.refMetaObject( ) ).equals( actType2 ) || ( (JmiList<GeneralizableElement>) ( (MofClassImpl) actType1.refMetaObject( ) ).getSupertypes( this.jmiCreator.getConnection( ) ) ).contains( this.jmiCreator.getConnection( ), actType2 ) ) ) {
            return true;
        }

        /*
         * if you look at the following code, you're tempted to replace it by if
         * ((colType1.equals(colType2)) || (colType1 instanceof OrderedSetType
         * && colType2 instanceof SetType)) { but that would behave differently!
         * The reason is that we may have, e.g., two sets defined for tuples,
         * where the sets as such differ, but the element types are equal. And
         * that's what we really want to do here: We want to see whether the
         * types as such are compatible by checking whether they are instances
         * of similar things and then check whether their element types are
         * equal
         */
        if ( actType1 instanceof CollectionType && actType2 instanceof CollectionType ) {
            CollectionType colType1 = (CollectionType) actType1;
            CollectionType colType2 = (CollectionType) actType2;
            if ( ( colType1 instanceof BagType && actType2 instanceof BagType ) || ( colType1 instanceof SetType && colType2 instanceof SetType ) || ( colType1 instanceof SequenceType && colType2 instanceof SequenceType )
                 || ( colType1 instanceof OrderedSetType && colType2 instanceof OrderedSetType ) ) {
                // || (colType1 instanceof SetType && colType2 instanceof OrderedSetType)) {
                return typesConform( ( (CollectionTypeInternal) colType1 ).getElementType( this.jmiCreator.getConnection( ) ), ( (CollectionTypeInternal) colType2 ).getElementType( this.jmiCreator.getConnection( ) ) );
            }
        }

        // check tupletypes
        if ( actType1 instanceof TupleType && actType2 instanceof TupleType ) {
            return tupleConformance( (TupleType) actType1, (TupleType) actType2 );
        }

        // check supertypes
        List<GeneralizableElement> superTypes = MoinMetamodelCode.allSupertypes( this.jmiCreator.getConnection( ), actType1, (RefObjectImpl) actType1 );
        if ( superTypes != null && superTypes.contains( actType2 ) ) {
            return true;
        }

        return false;
    }

    /**
     * Checks to tuples for conformance. Tuples conform if they have the same
     * amount of elements. For each element in type1 there must be an element in
     * type2 with the same name. If the names match the type of the tuple
     * element of type1 must conform to the type of the tuple element of type2
     * 
     * @param type1
     * @param type2
     * @return true iff <tt>type1</tt> conforms to <tt>type2</tt>
     */
    protected boolean tupleConformance( TupleType type1, TupleType type2 ) {

        CoreConnection conn = this.jmiCreator.getConnection( );
        JmiList<ModelElement> contents1 = (JmiList<ModelElement>) ( (TupleTypeInternal) type1 ).getContents( conn );
        JmiList<ModelElement> contents2 = (JmiList<ModelElement>) ( (TupleTypeInternal) type2 ).getContents( conn );

        // tuples conform if they have the same amount of attributes
        // and the types of each attribute conform to each other
        Map<String, Attribute> type2AttrHash = new Hashtable<String, Attribute>( );

        if ( contents1.size( conn.getSession( ) ) != contents2.size( conn.getSession( ) ) ) {
            // if types have different amount of attributes
            // they cannot conform to each other
            return false;
        }
        // put the attributes of type2 in a hash so we can access them
        // conveniently
        // lookupElement() does not work porperly it returns null even though
        // there is an element with the supplied name
        for ( Iterator<ModelElement> i = contents2.iterator( conn ); i.hasNext( ); ) {
            ModelElement o = i.next( );
            if ( o instanceof Attribute ) {
                Attribute a = (Attribute) o;
                type2AttrHash.put( a.getName( ), a );
            }
        }
        // go through all attributes of type1
        for ( Iterator<ModelElement> i = contents1.iterator( conn ); i.hasNext( ); ) {
            ModelElement o = i.next( );
            if ( o instanceof Attribute ) {
                AttributeInternal a1 = (AttributeInternal) o;
                AttributeInternal a2 = (AttributeInternal) type2AttrHash.get( a1.getName( ) );
                if ( a2 == null ) {
                    // type2 does not have an attribute that corresponds to a1
                    return false;
                }
                // type of a1 has to conform to type of attribute a2
                if ( !this.typesConform( a1.getType( conn ), a2.getType( conn ) ) ) {
                    return false;
                }
            } else {
                return false;
            }
        }
        // the tuples do conform
        return true;
    }
}
