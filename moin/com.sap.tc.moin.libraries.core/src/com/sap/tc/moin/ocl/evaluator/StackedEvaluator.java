package com.sap.tc.moin.ocl.evaluator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.BooleanLiteralExp;
import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionKind;
import org.omg.ocl.expressions.CollectionKindEnum;
import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.CollectionRange;
import org.omg.ocl.expressions.EnumLiteralExp;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.LetExp;
import org.omg.ocl.expressions.LiteralExp;
import org.omg.ocl.expressions.LoopExp;
import org.omg.ocl.expressions.ModelPropertyCallExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.PrimitiveLiteralExp;
import org.omg.ocl.expressions.RealLiteralExp;
import org.omg.ocl.expressions.StringLiteralExp;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpImpl;
import org.omg.ocl.expressions.__impl.AttributeCallExpInternal;
import org.omg.ocl.expressions.__impl.BooleanLiteralExpImpl;
import org.omg.ocl.expressions.__impl.CollectionItemInternal;
import org.omg.ocl.expressions.__impl.CollectionLiteralExpImpl;
import org.omg.ocl.expressions.__impl.CollectionRangeInternal;
import org.omg.ocl.expressions.__impl.EnumLiteralExpImpl;
import org.omg.ocl.expressions.__impl.EnumLiteralExpInternal;
import org.omg.ocl.expressions.__impl.IfExpImpl;
import org.omg.ocl.expressions.__impl.IntegerLiteralExpImpl;
import org.omg.ocl.expressions.__impl.IterateExpImpl;
import org.omg.ocl.expressions.__impl.LetExpImpl;
import org.omg.ocl.expressions.__impl.LoopExpInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.PropertyCallExpInternal;
import org.omg.ocl.expressions.__impl.RealLiteralExpImpl;
import org.omg.ocl.expressions.__impl.StringLiteralExpImpl;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpInternal;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;
import org.omg.ocl.expressions.__impl.VariableExpImpl;

import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclDouble;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclEnum;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFloat;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclInteger;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclLong;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclModelElement;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclString;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclStruct;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclTuple;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclType;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclVoid;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclCollectionImpl;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclInvalidImpl;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.AnyHandler;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.CollectHandler;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.ExistsHandler;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.ForAllHandler;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.IsUniqueHandler;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.IterateHandler;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.OneHandler;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.ResultHandler;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.SelectRejectHandler;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.iterators.SortedByHandler;
import com.sap.tc.moin.ocl.evaluator.util.Bag;
import com.sap.tc.moin.ocl.evaluator.util.HashBag;
import com.sap.tc.moin.ocl.evaluator.util.ListOrderedSet;
import com.sap.tc.moin.ocl.evaluator.util.OrderedSet;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.impl.OclSerializationException;
import com.sap.tc.moin.ocl.utils.impl.OclSerializer;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.WrapperManager;
import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefPackageImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode.NodeRoleTypes;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * While a visitor pattern would be the "natural" way to implement an evaluator,
 * it has one severe drawback: recursions are building up on the Java execution
 * stack. Recursions happen in OCL expressions mainly during processing of
 * iterator expressions and when calling operations in OCL expressions whose
 * bodies are again defined in OCL. Since the number of recursions is
 * potentially big, this can easily result in Java Stack Overflows.
 * <p>
 * In order to avoid such recursions in Java during evaluation, the following
 * strategy was implemented:
 * <p>
 * <ul>
 * <li>The expression that is to be evaluated is wrapped into a "context" object
 * and added to the top of the context stack</li>
 * <li>Evaluation happens in a Java loop that peeks the topmost context from
 * this stack and tries to evaluate the underlying expression</li>
 * <li>If additional evaluations have to be performed before the current
 * expression can be evaluated (for example a source expression or arguments
 * must be determined), these expressions are wrapped into their own context
 * objects. The context objects are added as children to the current context
 * object using the {@link OclDebuggerNode.NodeRoleTypes} enumeration to specify
 * the node type and pushed upon the stack; then the next loop is processed
 * which continues by processing the topmost sub-expression</li>
 * <li>Eventually, the evaluation returns to the original expression; the
 * required results from the child context objects and the original expression
 * is evaluated</li>
 * <li>After evaluation of the original expression, the result value is set in
 * the current context and the context stack is popped; then the next loop is
 * processed</li>
 * <li>Once the context stack is empty, evaluation is complete and the result
 * value from the last context is returned to the caller</li>
 * </ul>
 * Specific logic is used for iterators to ensure proper values for the iterator
 * variables.
 */

public class StackedEvaluator extends ExpressionEvaluator {

    static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL_EVALUATOR, StackedEvaluator.class );

    private final Map<Operation, Boolean> operationStdLibMap = new HashMap<Operation, Boolean>( );

    /**
     * Creates an instance
     */
    public StackedEvaluator( ) {

        // nothing
    }

    /**
     * If there are several iterators defined in some iterator expression, the
     * body expression must (potentially) be executed for any combination of
     * values in order to determine the result of the iterator expression.
     * <p>
     * For example, let's assume we have an expression with two iterators
     * <code>i, j</code>, like
     * <p>
     * <tt>
     * Bag {1, 3, 4}->&ltloop expression&gt(i, j | i + j = 7)
     * </tt>
     * <p>
     * The loop expression's body expression ("<code>i + j = 7</code>") must
     * potentially evaluated for all the following value combinations of i and
     * j:
     * <p>
     * <table border="1">
     * <tr>
     * <th colspan="3">Iterator values</th>
     * </tr>
     * <tr>
     * <th>Iteration</th>
     * <th>Value for i</th>
     * <th>Value for j</th>
     * </tr>
     * <tr>
     * <td>0</td>
     * <td rowspan="3">1</td>
     * <td>1</td>
     * </tr>
     * <tr>
     * <td>1</td>
     * <td>3</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>4</td>
     * </tr>
     * <tr>
     * <td>3</td>
     * <td rowspan="3">3</td>
     * <td>1</td>
     * </tr>
     * <tr>
     * <td>4</td>
     * <td>3</td>
     * </tr>
     * <tr>
     * <td>5</td>
     * <td>4</td>
     * </tr>
     * <tr>
     * <td>6</td>
     * <td rowspan="3">4</td>
     * <td>1</td>
     * </tr>
     * <tr>
     * <td>7</td>
     * <td>3</td>
     * </tr>
     * <tr>
     * <td>8</td>
     * <td>4</td>
     * </tr>
     * </table>
     * <p>
     * Depending on the specific loop expression, the evaluation can of course
     * be aborted once the value of the result is clear, for example the
     * "exists" iterator would stop after the first "<code>true</code>" value
     * returned by the body expression evaluation, whereas a "forAll" iterator
     * would stop after the first "false" result.
     * <p>
     * This class implements the logic for setting the values into the
     * evaluation context during each iteration.
     * <p>
     * Assuming the values are contained in <code>List&ltOclAny&gt values</code>
     * and the iterator names in <code>List&ltString&gt iteratorNames</code>,
     * the number of potential iterations is
     * <p>
     * <code>
     * int maxIteration = Math.pow(values.size(), iteratorNames.size())
     * </code>
     * <p>
     * For each iteration, the index in the <code>values</code> list for each is
     * determined in the {@link #getValueIndexes()} method and the corresponding
     * values are set in the evaluation context.
     */
    private static final class IndexIncreaser {

        private final MyContext myContext;

        private final List<String> varnames = new ArrayList<String>( );

        private final int numValues;

        private final int numVariables;

        private final int maxIndex;

        private int currentIndex = 0;

        private final List<OclAny> myValues = new ArrayList<OclAny>( );

        IndexIncreaser( MyContext currentContext, List<String> variableNames, Collection<OclAny> values ) {

            this.myContext = currentContext;
            this.myValues.addAll( values );
            this.varnames.addAll( variableNames );
            this.maxIndex = (int) Math.pow( values.size( ), variableNames.size( ) ) - 1;
            this.numValues = values.size( );
            this.numVariables = variableNames.size( );
        }

        boolean increment( EvaluationContext context ) {

            if ( canIncrement( ) ) {
                this.currentIndex++;
                int[] indexes = this.getValueIndexes( );
                for ( int i = 0; i < indexes.length; i++ ) {
                    String varname = this.varnames.get( i );
                    int valueIndex = indexes[i];
                    context.setVariable( varname, this.myValues.get( valueIndex ) );
                }
                // for more information, this could be called with toString() of the Iterator,
                // but performance is too bad
                this.myContext.initForIterator( OclConstants.DEBUGER_ITERATOR_TEXT );

                return true;
            }
            return false;
        }

        private boolean canIncrement( ) {

            return this.currentIndex < this.maxIndex;
        }


        private int[] getValueIndexes( ) {

            int[] result = new int[this.numVariables];

            for ( int varIndex = 0; varIndex < this.numVariables; varIndex++ ) {
                int divider = (int) Math.pow( this.numValues, varIndex );
                result[varIndex] = ( ( Math.max( 0, this.currentIndex / divider ) ) % this.numValues );

            }

            return result;
        }

        @Override
        public String toString( ) {

            StringBuilder result = new StringBuilder( );
            result.append( OclConstants.DEBUGER_ITERATION_TEXT );
            result.append( ": " ); //$NON-NLS-1$
            result.append( this.currentIndex );
            result.append( OclConstants.SPACE );

            int[] indexes = this.getValueIndexes( );
            for ( int i = 0; i < indexes.length; i++ ) {
                String varname = this.varnames.get( i );
                result.append( OclConstants.SPACE + varname );
                result.append( OclConstants.SPACE );
                int valueIndex = indexes[i];
                result.append( this.myValues.get( valueIndex ).getWrappedObject( ).toString( ) );
            }

            return result.toString( );
        }

    }


    private static final class MyContext implements OclDebuggerNode {

        /** used to create the children array */
        private final static int NUMTYPES = NodeRoleTypes.values( ).length;

        /** helper for returning an empty list of children */
        private final static List<MyContext> EMPTY_LIST = Collections.emptyList( );

        private final OclExpression myExpression;

        private final NodeRoleTypes myType;

        private OclAny myValue;

        /** the local evaluation context; null until a call to push is executed */
        private EvaluationContext evalContext = null;

        /**
         * we need to access this by role type, using the ordinal as index in
         * the array
         */
        final List<MyContext>[] children = new List[NUMTYPES];

        IndexIncreaser myIncreaser;

        private ResultHandler myHandler;

        // stuff for the OclDebuggerNode implementation

        private MyContext[] childArray = null;

        private OclSerializer mySerializer = null;

        private String mySerializedExpression = null;

        private String myName = null;

        private List<MyContext> myIterations = null;

        private final CoreConnection connection;

        // source is single values
        MyContext( CoreConnection actConnecdtion, OclExpression expression, NodeRoleTypes type, OclSerializer serializer ) {

            this.connection = actConnecdtion;
            this.myExpression = expression;
            this.myType = type;
            this.mySerializer = serializer;
        }

        OclExpression getExpression( ) {

            return this.myExpression;
        }

        void setValue( OclAny value ) {

            this.myValue = value;
        }

        void initForIterator( String name ) {

            if ( this.mySerializer != null ) {
                MyContext iteration = new MyContext( this.connection, this.myExpression, NodeRoleTypes.Listing, this.mySerializer );
                for ( int i = 0; i < this.children.length; i++ ) {
                    iteration.children[i] = this.children[i];
                }
                //iteration.children.putAll( this.children );
                iteration.setValue( this.myValue );
                iteration.myName = name;
                if ( this.myIterations == null ) {
                    this.myIterations = new ArrayList<MyContext>( );
                }
                this.myIterations.add( iteration );
            }
            // TODO optimize
            for ( int i = 0; i < this.children.length; i++ ) {
                this.children[i] = null;
            }
            //this.children.clear( );
            this.myValue = null;
        }

        List<MyContext> getIterations( ) {

            if ( this.myIterations == null ) {
                return Collections.emptyList( );
            }
            return this.myIterations;
        }

        OclAny getValue( ) {

            return this.myValue;
        }

        NodeRoleTypes getType( ) {

            return this.myType;
        }

        void addChild( MyContext child ) {

            int index = child.getType( ).ordinal( );
            List<MyContext> actChildren = this.children[index];
            if ( actChildren == null ) {
                actChildren = new ArrayList<MyContext>( 1 );
                this.children[index] = actChildren;
            }
            actChildren.add( child );
        }

        List<MyContext> getChildren( NodeRoleTypes type ) {

            List<MyContext> result = this.children[type.ordinal( )];
            if ( result == null ) {
                return EMPTY_LIST;
            }
            return result;
        }

        boolean childrenEvaluated( NodeRoleTypes type ) {

            List<MyContext> actChildren = this.children[type.ordinal( )];
            if ( actChildren == null ) {
                return false;
            }
            for ( MyContext context : actChildren ) {
                if ( context.getValue( ) == null ) {
                    return false;
                }
            }
            return true;
        }

        EvaluationContext pushEvaluationContext( OclAny self ) {

            if ( LOGGER.isLoggedOrTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, MoinOclEvaluatorMessages.PUSHINGEVALCONTEXT );
            }
            this.evalContext = EvaluationContext.CurrentContext.get( ).push( self );
            return this.evalContext;

        }

        void popEvaluationContext( ) {

            if ( this.evalContext != null ) {
                if ( LOGGER.isLoggedOrTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, MoinOclEvaluatorMessages.POPPINGEVACONTEXT );
                }
                this.evalContext.pop( );
            }
        }

        IndexIncreaser getIndexIncreaser( ) {

            return this.myIncreaser;
        }

        void setIndexIncreaser( IndexIncreaser increaser ) {

            this.myIncreaser = increaser;
        }

        ResultHandler getIteratorHandler( ) {

            return this.myHandler;
        }

        void setResultHandler( ResultHandler handler ) {

            this.myHandler = handler;
        }

        public OclDebuggerNode[] getChildren( ) {

            if ( this.childArray == null ) {
                int size = this.getIterations( ).size( );

                for ( List<MyContext> list : this.children ) {
                    if ( list != null ) {
                        size += list.size( );
                    }
                }
                this.childArray = new MyContext[size];
                int index = 0;
                for ( MyContext it : this.getIterations( ) ) {
                    this.childArray[index] = it;
                    index++;
                }
                for ( List<MyContext> list : this.children ) {
                    if ( list != null ) {
                        for ( MyContext child : list ) {
                            this.childArray[index] = child;
                            index++;
                        }
                    }
                }
            }
            return this.childArray;
        }

        public String getNodeName( ) {

            if ( this.myName == null ) {
                this.myName = getNameFromExpression( );
            }
            return this.myName;
        }

        private String getNameFromExpression( ) {

            if ( 1 == 2 ) {
                return null;
            } else if ( this.myExpression instanceof IfExp ) {
                return "if"; //$NON-NLS-1$
            } else if ( this.myExpression instanceof LetExp ) {
                return "let " + ( (LetExp) this.myExpression ).getVariable( ).getName( ) + " in"; //$NON-NLS-1$ //$NON-NLS-2$
            } else if ( this.myExpression instanceof LiteralExp ) {
                if ( this.myExpression instanceof PrimitiveLiteralExp ) {
                    if ( this.myExpression instanceof RealLiteralExp ) {
                        return Double.toString( ( (RealLiteralExp) this.myExpression ).getRealSymbol( ) );
                    } else if ( this.myExpression instanceof StringLiteralExp ) {
                        return ( (StringLiteralExpImpl) this.myExpression ).getStringSymbol( );
                    } else if ( this.myExpression instanceof BooleanLiteralExp ) {
                        return Boolean.toString( ( (BooleanLiteralExpImpl) this.myExpression ).isBooleanSymbol( ) );
                    } else if ( this.myExpression instanceof IntegerLiteralExp ) {
                        return Integer.toString( ( (IntegerLiteralExp) this.myExpression ).getIntegerSymbol( ) );
                    }
                } else if ( this.myExpression instanceof CollectionLiteralExp ) {
                    return ( (CollectionLiteralExp) this.myExpression ).getKind( ).toString( );
                } else if ( this.myExpression instanceof EnumLiteralExp ) {
                    return ( (EnumLiteralExpInternal) this.myExpression ).getLiteral( );
                } else if ( this.myExpression instanceof TupleLiteralExp ) {
                    Collection<VariableDeclaration> tupleParts = ( (TupleLiteralExpImpl) this.myExpression ).getTuplePart( );
                    StringBuilder sb = new StringBuilder( );
                    sb.append( "Tuple: " ); //$NON-NLS-1$
                    for ( Iterator<VariableDeclaration> parts = tupleParts.iterator( ); parts.hasNext( ); ) {
                        sb.append( parts.next( ).getVarName( ) );
                        if ( parts.hasNext( ) ) {
                            sb.append( ", " ); //$NON-NLS-1$
                        }
                    }
                    return sb.toString( );
                }

            } else if ( this.myExpression instanceof ModelPropertyCallExp ) {
                if ( this.myExpression instanceof AssociationEndCallExp ) {
                    return ( (AssociationEndCallExpImpl) this.myExpression ).getReferredAssociationEnd( ).getName( );
                } else if ( this.myExpression instanceof AttributeCallExp ) {
                    return ( (AttributeCallExp) this.myExpression ).getReferredAttribute( ).getName( );
                } else if ( this.myExpression instanceof OperationCallExp ) {
                    return ( (OperationCallExp) this.myExpression ).getReferredOperation( ).getName( ).concat( "( )" ); //$NON-NLS-1$

                }
            } else if ( this.myExpression instanceof TypeExp ) {
                return ( (TypeExpInternal) this.myExpression ).getType( this.connection ).getName( );
            } else if ( this.myExpression instanceof VariableDeclaration ) {
                return ( (VariableDeclaration) this.myExpression ).getVarName( );
            }
            return this.myExpression.getName( );
        }

        public NodeRoleTypes getNodeRole( ) {

            return this.myType;
        }

        public NodeValueTypes getNodeValueType( ) {

            OclAny value = this.myValue;
            if ( value == null ) {
                return NodeValueTypes.Unknown;
            }
            if ( value instanceof OclBoolean ) {
                return NodeValueTypes.Boolean;
            }
            if ( value instanceof OclCollection ) {
                return NodeValueTypes.Collection;
            }
            if ( value instanceof OclDouble ) {
                return NodeValueTypes.Double;
            }
            if ( value instanceof OclEnum ) {
                return NodeValueTypes.EnumerationType;
            }
            if ( value instanceof OclFloat ) {
                return NodeValueTypes.Float;
            }
            if ( value instanceof OclInteger ) {
                return NodeValueTypes.Integer;
            }
            if ( value instanceof OclLong ) {
                return NodeValueTypes.Long;
            }
            if ( value instanceof OclModelElement ) {
                return NodeValueTypes.ModelElement;
            }
            if ( value instanceof OclType ) {
                return NodeValueTypes.Type;
            }
            if ( value instanceof OclString ) {
                return NodeValueTypes.String;
            }
            if ( value instanceof OclVoid ) {
                return NodeValueTypes.Void;
            }
            return NodeValueTypes.Unknown;
        }

        public String getOclExpression( ) {

            if ( this.mySerializedExpression == null ) {
                if ( this.mySerializer != null ) {
                    try {
                        this.mySerializedExpression = this.mySerializer.serialize( this.myExpression, new RefPackage[0] );
                    } catch ( OclSerializationException e ) {
                        // this is for the debugger only, so as fall back we indicate this as simple String
                        this.mySerializedExpression = OclConstants.EXPR_SERIALIZATION_ERROR_TEXT;
                    }
                } else {
                    this.mySerializedExpression = OclConstants.EMPTY;
                }
            }
            return this.mySerializedExpression;

        }

        public Object getResultValue( ) throws InvalidValueException {

            OclAny value = this.myValue;
            if ( value == null ) {
                // value type unknown
                return null;
            }
            if ( value instanceof OclBoolean ) {
                // value type collection
                return ( (OclBoolean) value ).getWrappedBoolean( );
            }
            if ( value instanceof OclCollection ) {
                // value type collection                       
                return ( (OclCollection) value ).getUnwrappingCollection( true );
            }
            if ( value instanceof OclDouble ) {
                // value type double
                return ( (OclDouble) value ).getWrappedDouble( );
            }
            if ( value instanceof OclEnum ) {
                // value type enumeration type
                return null;
            }
            if ( value instanceof OclFloat ) {
                // value type float
                return ( (OclFloat) value ).getWrappedFloat( );
            }
            if ( value instanceof OclInteger ) {
                // value type integer
                return ( (OclInteger) value ).getWrappedInteger( );
            }
            if ( value instanceof OclLong ) {
                // value type long
                return ( (OclLong) value ).getWrappedLong( );
            }
            if ( value instanceof OclModelElement ) {
                // value type model element
                return ( (Partitionable) ( (OclModelElement) value ).getWrappedRefObject( ) ).get___Mri( );
            }
            if ( value instanceof OclType ) {
                // value type type            
                return ( (OclType) value ).getWrappedClassifier( ).getQualifiedName( );
            }
            if ( value instanceof OclString ) {
                // value type string            
                return ( (OclString) value ).getWrappedString( );
            }
            if ( value instanceof OclVoid ) {
                return null;
            }
            throw new InvalidValueException( OclServiceExceptions.INVALIDVALUEEXCEPTION );
        }

        @Override
        public String toString( ) {

            return this.myExpression.getName( ) + " - " + this.myType.name( ); //$NON-NLS-1$
        }


    }

    /**
     * A special Stack implementation used for evaluation.
     * <p>
     * Most importantly, the {@link ContextStack#pop(OclAny)} method requires a
     * value which is the result of the current evaluation.
     * <p>
     * This is protected against overflow by checking the size of the stack
     * during each push. If a certain limit is reached, a runtime exception will
     * be thrown.
     */
    private static final class ContextStack {

        private final static int OVERFLOW_SIZE = 100000;

        private final Stack<MyContext> myStack = new Stack<MyContext>( );

        ContextStack( ) {

            // nothing
        }

        MyContext push( MyContext currentContext ) {

            int size = this.myStack.size( );
            // we could do some sort of pattern checking using the MyContext.toString() method, 
            // but for now we just assume that OVERFLOW_SIZE is big enough to justify
            // a runtime exception

            if ( size >= OVERFLOW_SIZE ) {
                throw new MoinIllegalStateException( OclServiceExceptions.OCLEVALSTACKOVERFLOW, size );
            }
            return this.myStack.push( currentContext );
        }

        MyContext pop( OclAny value ) {

            MyContext popped = this.myStack.pop( );
            popped.setValue( value );
            return popped;
        }

        MyContext peek( ) {

            return this.myStack.peek( );
        }

        boolean isEmpty( ) {

            return this.myStack.isEmpty( );
        }
    }

    private final OclFactory oclFactory = OclFactory.instance( );

    @Override
    public OclAny evaluate( CoreConnection connection, OclExpression expression, EvaluationContext dummy ) {

        return this.evaluateInt( connection, expression, dummy, false ).getValue( );
    }

    /**
     * OclDebugger Node implementation
     * 
     * @param connection connection
     * @param expression expression
     * @param dummy not really required
     * @return the debugger root node
     */
    public OclDebuggerNode debug( CoreConnection connection, OclExpression expression, EvaluationContext dummy ) {

        return this.evaluateInt( connection, expression, dummy, true );
    }

    private MyContext evaluateInt( CoreConnection connection, OclExpression expression, @SuppressWarnings( "unused" ) EvaluationContext dummy, boolean debugMode ) {

        CoreSession session = connection.getSession( );
        ContextStack contextStack = new ContextStack( );

        OclSerializer serializer = null;
        if ( debugMode ) {
            serializer = OclSerializer.getInstance( connection );
        }

        contextStack.push( new MyContext( connection, expression, NodeRoleTypes.Root, serializer ) );
        boolean traceDebug = LOGGER.isLoggedOrTraced( MoinSeverity.DEBUG );

        EvaluationContext rootContext = EvaluationContext.CurrentContext.get( );

        MyContext currentContext = null;

        while ( !contextStack.isEmpty( ) ) {

            currentContext = contextStack.peek( );
            OclExpression currentExp = currentContext.getExpression( );
            if ( traceDebug ) {
                LOGGER.trace( MoinSeverity.DEBUG, MoinOclEvaluatorMessages.EVALUATIONOFEXPRESSION, currentExp.getClass( ).getName( ), currentContext.getType( ).name( ) );
            }

            /* IfExpression */
            if ( currentExp instanceof IfExp ) {

                IfExpImpl ifExpr = (IfExpImpl) currentExp;

                if ( !currentContext.childrenEvaluated( NodeRoleTypes.IfCondition ) ) {
                    OclExpression conditionExpr = ifExpr.getCondition( connection );
                    MyContext sourceCtx = new MyContext( connection, conditionExpr, NodeRoleTypes.IfCondition, serializer );
                    contextStack.push( sourceCtx );
                    currentContext.addChild( sourceCtx );
                    continue;
                }

                OclAny condition = currentContext.getChildren( NodeRoleTypes.IfCondition ).get( 0 ).getValue( );

                if ( OclInvalidImpl.OCL_INVALID.equals( condition ) || OclVoidImpl.OCL_UNDEFINED.equals( condition ) ) {
                    contextStack.pop( OclInvalidImpl.OCL_INVALID );
                    continue;
                }
                if ( !( condition instanceof OclBoolean ) ) {
                    throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_007 );
                }

                Boolean conditionValue = ( (OclBoolean) condition ).getWrappedBoolean( );

                if ( conditionValue.booleanValue( ) && !currentContext.childrenEvaluated( NodeRoleTypes.Then ) ) {
                    OclExpression valueExpr = ifExpr.getThenExpression( connection );
                    MyContext sourceCtx = new MyContext( connection, valueExpr, NodeRoleTypes.Then, serializer );
                    contextStack.push( sourceCtx );
                    currentContext.addChild( sourceCtx );
                    continue;

                }

                if ( !conditionValue.booleanValue( ) && !currentContext.childrenEvaluated( NodeRoleTypes.Else ) ) {
                    OclExpression valueExpr = ifExpr.getElseExpression( connection );
                    MyContext sourceCtx = new MyContext( connection, valueExpr, NodeRoleTypes.Else, serializer );
                    contextStack.push( sourceCtx );
                    currentContext.addChild( sourceCtx );
                    continue;
                }

                OclAny result;
                if ( conditionValue.booleanValue( ) ) {
                    result = currentContext.getChildren( NodeRoleTypes.Then ).get( 0 ).getValue( );
                } else {
                    result = currentContext.getChildren( NodeRoleTypes.Else ).get( 0 ).getValue( );
                }
                contextStack.pop( result );
                /* LetExpression */
            } else if ( currentExp instanceof LetExp ) {

                LetExpImpl letExpr = (LetExpImpl) currentExp;
                VariableDeclarationImpl varDecl = (VariableDeclarationImpl) letExpr.getVariable( connection );

                if ( !currentContext.childrenEvaluated( NodeRoleTypes.Initialization ) ) {
                    OclExpression initExp = varDecl.getInitExpression( connection );
                    MyContext sourceCtx = new MyContext( connection, initExp, NodeRoleTypes.Initialization, serializer );
                    contextStack.push( sourceCtx );
                    currentContext.addChild( sourceCtx );
                    continue;
                }

                OclAny varValue = currentContext.getChildren( NodeRoleTypes.Initialization ).get( 0 ).getValue( );

                rootContext.setVariable( varDecl.getVarName( ), varValue );

                if ( !currentContext.childrenEvaluated( NodeRoleTypes.InStatement ) ) {
                    OclExpression inExpr = letExpr.getIn( connection );
                    MyContext sourceCtx = new MyContext( connection, inExpr, NodeRoleTypes.InStatement, serializer );
                    contextStack.push( sourceCtx );
                    currentContext.addChild( sourceCtx );
                    continue;
                }

                OclAny result = currentContext.getChildren( NodeRoleTypes.InStatement ).get( 0 ).getValue( );

                contextStack.pop( result );
                /* Literal */
            } else if ( currentExp instanceof LiteralExp ) {

                if ( currentExp instanceof PrimitiveLiteralExp ) {
                    if ( currentExp instanceof BooleanLiteralExp ) {
                        BooleanLiteralExpImpl booleanLiteralExpr = (BooleanLiteralExpImpl) currentExp;
                        if ( booleanLiteralExpr.isBooleanSymbol( ) ) {
                            contextStack.pop( OclBoolean.TRUE );
                        } else {
                            contextStack.pop( OclBoolean.FALSE );
                        }
                    } else if ( currentExp instanceof IntegerLiteralExp ) {
                        IntegerLiteralExpImpl integerLiteralExpr = (IntegerLiteralExpImpl) currentExp;
                        Integer value = Integer.valueOf( integerLiteralExpr.getIntegerSymbol( ) );
                        contextStack.pop( this.oclFactory.create( value ) );
                    } else if ( currentExp instanceof RealLiteralExp ) {
                        RealLiteralExpImpl realLiteralExpr = (RealLiteralExpImpl) currentExp;
                        Double value = new Double( realLiteralExpr.getRealSymbol( ) );
                        contextStack.pop( this.oclFactory.create( value ) );
                    } else if ( currentExp instanceof StringLiteralExp ) {
                        StringLiteralExpImpl stringLiteralExpr = (StringLiteralExpImpl) currentExp;
                        String value = stringLiteralExpr.getStringSymbol( );
                        contextStack.pop( this.oclFactory.create( value ) );
                    }

                } else if ( currentExp instanceof CollectionLiteralExp ) {
                    OclAny result;
                    CollectionLiteralExpImpl expr = (CollectionLiteralExpImpl) currentExp;

                    JmiList<CollectionLiteralPart> parts = (JmiList<CollectionLiteralPart>) expr.getParts( connection );

                    if ( parts.size( session ) > 0 && !currentContext.childrenEvaluated( NodeRoleTypes.CollectionPart ) ) {
                        for ( int i = 0, n = parts.size( session ); i < n; i++ ) {
                            CollectionLiteralPart part = parts.get( session, i );
                            OclExpression partExpression;
                            if ( part instanceof CollectionItemInternal ) {
                                partExpression = ( (CollectionItemInternal) part ).getItem( connection );
                                MyContext partCtx = new MyContext( connection, partExpression, NodeRoleTypes.CollectionPart, serializer );
                                contextStack.push( partCtx );
                                currentContext.addChild( partCtx );

                            } else if ( part instanceof CollectionRangeInternal ) {
                                partExpression = ( (CollectionRangeInternal) part ).getFirst( connection );
                                MyContext firstCtx = new MyContext( connection, partExpression, NodeRoleTypes.CollectionPart, serializer );
                                contextStack.push( firstCtx );
                                currentContext.addChild( firstCtx );

                                partExpression = ( (CollectionRangeInternal) part ).getLast( connection );
                                MyContext lastCtx = new MyContext( connection, partExpression, NodeRoleTypes.CollectionPart, serializer );
                                contextStack.push( lastCtx );
                                currentContext.addChild( lastCtx );
                            }
                        }
                        continue;
                    }

                    List<MyContext> partValues = currentContext.getChildren( NodeRoleTypes.CollectionPart );
                    Collection<OclAny> values;
                    CollectionKind kind = ( expr ).getKind( );

                    if ( CollectionKindEnum.SET.equals( kind ) ) {
                        values = new HashSet<OclAny>( );
                    } else if ( CollectionKindEnum.ORDERED_SET.equals( kind ) ) {
                        values = new ListOrderedSet( );
                    } else if ( CollectionKindEnum.SEQUENCE.equals( kind ) ) {
                        values = new ArrayList<OclAny>( );
                    } else if ( CollectionKindEnum.BAG.equals( kind ) ) {
                        values = new HashBag( );
                    } else {
                        throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.UNKNOWNKIND, kind.toString( ) );
                    }

                    int valueIndex = 0;
                    for ( int i = 0, n = parts.size( session ); i < n; i++ ) {
                        OclAny firstValue = partValues.get( valueIndex ).getValue( );
                        valueIndex++;
                        if ( OclInvalidImpl.OCL_INVALID.equals( firstValue ) ) {
                            values = null;
                            break;
                        }
                        CollectionLiteralPart part = parts.get( session, i );
                        if ( part instanceof CollectionItem ) {
                            values.add( firstValue );
                        } else if ( part instanceof CollectionRange ) {
                            OclAny secondValue = partValues.get( valueIndex ).getValue( );
                            valueIndex++;
                            if ( OclInvalidImpl.OCL_INVALID.equals( secondValue ) ) {
                                values = null;
                                break;
                            }
                            if ( !( firstValue instanceof OclInteger ) ) {
                                throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.RANGENOTSUPPORTEDFORNONINT );
                            }
                            if ( !( secondValue instanceof OclInteger ) ) {
                                throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.RANGENOTSUPPORTEDFORNONINT );
                            }
                            int first = ( (OclInteger) firstValue ).getWrappedInteger( ).intValue( );
                            int last = ( (OclInteger) secondValue ).getWrappedInteger( ).intValue( );

                            // Collection range is inclusive according to the
                            // getRange() operation
                            // definition on page 119 of the UML 2.0 OCL spec
                            for ( int j = first; j <= last; j++ ) {
                                values.add( this.oclFactory.create( Integer.valueOf( j ) ) );
                            }
                        } else {
                            // Sanity check - should never happen as there are
                            // only two
                            // subclasses defined for CollectionLiteralPart
                            throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_006 );
                        }
                    }

                    if ( values == null ) {
                        result = OclInvalidImpl.OCL_INVALID;
                    } else {
                        if ( CollectionKindEnum.SET.equals( kind ) ) {
                            result = this.oclFactory.createSetFromOclAnyObjects( (Set<OclAny>) values );
                        } else if ( CollectionKindEnum.ORDERED_SET.equals( kind ) ) {
                            result = this.oclFactory.createOrderedSetFromOclAnyObjects( (OrderedSet) values );
                        } else if ( CollectionKindEnum.SEQUENCE.equals( kind ) ) {
                            result = this.oclFactory.createSequenceFromOclAnyObjects( (List<OclAny>) values );
                        } else if ( CollectionKindEnum.BAG.equals( kind ) ) {
                            result = this.oclFactory.createBagFromOclAnyObjects( (Bag) values );
                        } else {
                            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.UNKNOWNKIND, kind.toString( ) );
                        }
                    }
                    contextStack.pop( result );
                } else if ( currentExp instanceof EnumLiteralExp ) {

                    EnumLiteralExpImpl enumLiteralExpr = (EnumLiteralExpImpl) currentExp;

                    EnumerationTypeImpl referredEnum = (EnumerationTypeImpl) enumLiteralExpr.getReferredEnum( connection );
                    MofPackageImpl enumMofPkg = (MofPackageImpl) referredEnum.getContainer( connection );

                    RefPackageImpl enumRefPkg = (RefPackageImpl) connection.getCoreJmiHelper( ).getRefPackageForMofPackage( connection.getSession( ), enumMofPkg );

                    // Lookup the RefEnum instance for the literal value
                    String literal = enumLiteralExpr.getLiteral( );
                    RefEnum refEnum = enumRefPkg.refGetEnum( connection, referredEnum, literal );

                    contextStack.pop( this.oclFactory.create( refEnum ) );
                } else if ( currentExp instanceof TupleLiteralExp ) {
                    TupleLiteralExpImpl tupleLitExp = (TupleLiteralExpImpl) currentExp;
                    JmiList<VariableDeclaration> tupleLiteralParts = (JmiList<VariableDeclaration>) tupleLitExp.getTuplePart( connection );
                    if ( tupleLiteralParts.isEmpty( connection.getSession( ) ) ) {
                        throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_012 );
                    }

                    if ( !currentContext.childrenEvaluated( NodeRoleTypes.CollectionPart ) ) {
                        for ( Iterator<VariableDeclaration> it = tupleLiteralParts.iterator( connection ); it.hasNext( ); ) {
                            OclExpression partDecl = ( (VariableDeclarationInternal) it.next( ) ).getInitExpression( connection );
                            MyContext sourceCtx = new MyContext( connection, partDecl, NodeRoleTypes.CollectionPart, serializer );
                            contextStack.push( sourceCtx );
                            currentContext.addChild( sourceCtx );
                        }
                        continue;
                    }

                    List<MyContext> partValues = currentContext.getChildren( NodeRoleTypes.CollectionPart );

                    // Evaluate the value for each tuplePart and map it to its name
                    Map<String, OclAny> nameValuePairs = new LinkedHashMap<String, OclAny>( );
                    boolean isUndefined = false;
                    for ( int i = 0; i < tupleLiteralParts.size( session ); i++ ) {
                        String varname = tupleLiteralParts.get( session, i ).getVarName( );
                        OclAny value = partValues.get( i ).getValue( );
                        if ( OclInvalidImpl.OCL_INVALID.equals( value ) ) {
                            contextStack.pop( OclInvalidImpl.OCL_INVALID );
                            isUndefined = true;
                            break;
                        }
                        nameValuePairs.put( varname, value );
                    }

                    if ( !isUndefined ) {
                        contextStack.pop( this.oclFactory.createTuple( nameValuePairs ) );
                    }
                }
                /* Loop */
            } else if ( currentExp instanceof LoopExp ) {

                if ( !currentContext.childrenEvaluated( NodeRoleTypes.Source ) ) {
                    PropertyCallExpInternal propertyCallExpr = (PropertyCallExpInternal) currentExp;
                    OclExpression sourceExpr = ( propertyCallExpr ).getSource( connection );
                    MyContext sourceCtx = new MyContext( connection, sourceExpr, NodeRoleTypes.Source, serializer );
                    contextStack.push( sourceCtx );
                    currentContext.addChild( sourceCtx );
                    continue;
                }

                OclAny src = currentContext.getChildren( NodeRoleTypes.Source ).get( 0 ).getValue( );

                if ( OclInvalidImpl.OCL_INVALID.equals( src ) ) {
                    contextStack.pop( OclInvalidImpl.OCL_INVALID );
                    continue;
                }
                if ( OclVoidImpl.OCL_UNDEFINED.equals( src ) ) {
                    contextStack.pop( OclVoidImpl.OCL_UNDEFINED );
                    continue;
                }


                LoopExpInternal loopExp = (LoopExpInternal) currentExp;

                OclCollectionImpl collection = (OclCollectionImpl) src;
                JmiList<VariableDeclaration> iterators = (JmiList<VariableDeclaration>) loopExp.getIterators( connection );

                List<String> itNames = new ArrayList<String>( );
                if ( iterators.isEmpty( connection.getSession( ) ) ) {
                    itNames.add( OclConstants.EMPTY );
                } else {
                    for ( Iterator<VariableDeclaration> it = iterators.iterator( connection ); it.hasNext( ); ) {
                        itNames.add( it.next( ).getVarName( ) );
                    }
                }

                Collection<OclAny> wrappedCollection = collection.getWrappedCollection( );

                ResultHandler handler = null;

                if ( currentExp instanceof IterateExp ) {

                    VariableDeclarationImpl accumulatorDecl = (VariableDeclarationImpl) ( (IterateExpImpl) loopExp ).getResult( connection );
                    String accumulatorName = accumulatorDecl.getVarName( );

                    if ( !currentContext.childrenEvaluated( NodeRoleTypes.Accumulator ) ) {
                        OclExpression initExpr = accumulatorDecl.getInitExpression( connection );
                        MyContext sourceCtx = new MyContext( connection, initExpr, NodeRoleTypes.Accumulator, serializer );
                        contextStack.push( sourceCtx );
                        currentContext.addChild( sourceCtx );
                        continue;
                    }

                    OclAny accumulatorValue = currentContext.getChildren( NodeRoleTypes.Accumulator ).get( 0 ).getValue( );

                    if ( wrappedCollection.isEmpty( ) ) {
                        // do not evaluate the body, but return the value
                        OclAny result = new IterateHandler( accumulatorName, accumulatorValue ).getResult( connection, collection );
                        contextStack.pop( result );
                        continue;
                    }

                    rootContext.setVariable( accumulatorName, accumulatorValue );
                    handler = new IterateHandler( accumulatorName, accumulatorValue );


                } else if ( currentExp instanceof IteratorExp ) {


                    if ( wrappedCollection.isEmpty( ) ) {
                        // do not evaluate the body, but return the value
                        OclAny result = getResultHandler( loopExp.getName( ), itNames ).getResult( connection, collection );
                        contextStack.pop( result );
                        continue;
                    }

                    handler = getResultHandler( loopExp.getName( ), itNames );

                }

                if ( wrappedCollection.size( ) > 0 && !currentContext.childrenEvaluated( NodeRoleTypes.Body ) ) {

                    OclExpression body = loopExp.getBody( connection );
                    MyContext ctx = new MyContext( connection, body, NodeRoleTypes.Body, serializer );
                    ctx.setResultHandler( handler );
                    ctx.setIndexIncreaser( new IndexIncreaser( ctx, itNames, wrappedCollection ) );
                    currentContext.addChild( ctx );

                    OclAny firstValue = wrappedCollection.iterator( ).next( );
                    for ( String name : itNames ) {
                        rootContext.setVariable( name, firstValue );
                    }


                    contextStack.push( ctx );
                    continue;
                }


                MyContext bodyContext = currentContext.getChildren( NodeRoleTypes.Body ).iterator( ).next( );
                OclAny bodyResult = bodyContext.getValue( );

                if ( !bodyContext.getIteratorHandler( ).processElementAndResult( rootContext, bodyResult ) ) {
                    OclAny result = bodyContext.getIteratorHandler( ).getResult( connection, collection );
                    contextStack.pop( result );
                    continue;
                }

                IndexIncreaser increaser = bodyContext.getIndexIncreaser( );
                // TODO save the state of the completed increase for the debugger if needed
                boolean increased = increaser.increment( rootContext );

                if ( !increased ) {
                    OclAny result = bodyContext.getIteratorHandler( ).getResult( connection, collection );
                    contextStack.pop( result );
                    continue;
                }

                contextStack.push( bodyContext );
                continue;



                /* ModelProperty */
            } else if ( currentExp instanceof ModelPropertyCallExp ) {

                if ( !currentContext.childrenEvaluated( NodeRoleTypes.Source ) ) {
                    PropertyCallExpInternal propertyCallExpr = (PropertyCallExpInternal) currentExp;
                    OclExpression sourceExpr = ( propertyCallExpr ).getSource( connection );
                    MyContext sourceCtx = new MyContext( connection, sourceExpr, NodeRoleTypes.Source, serializer );
                    contextStack.push( sourceCtx );
                    currentContext.addChild( sourceCtx );
                    continue;
                }

                OclAny src = currentContext.getChildren( NodeRoleTypes.Source ).get( 0 ).getValue( );

                if ( currentExp instanceof AssociationEndCallExp ) {
                    if ( OclInvalidImpl.OCL_INVALID.equals( src ) ) {
                        contextStack.pop( OclInvalidImpl.OCL_INVALID );
                        continue;
                    }
                    if ( OclVoidImpl.OCL_UNDEFINED.equals( src ) ||
                	    (src instanceof OclCollection && ((OclCollection) src).getWrappedCollection().size() == 0)) {
                        contextStack.pop( OclVoidImpl.OCL_UNDEFINED );
                        continue;
                    }
                    // Sanity check - only model elements can have associations
                    if ( !( src instanceof OclModelElement ) ) {
                        throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_003 );
                    }

                    AssociationEndCallExp assocEndCallExp = (AssociationEndCallExp) currentExp;
                    RefObject srcRefObject = ( (OclModelElement) src ).getWrappedRefObject( );
                    AssociationEnd assocEnd = ( (AssociationEndCallExpImpl) assocEndCallExp ).getReferredAssociationEnd( connection );

                    OclAny result = extractAssociationEndValue( connection, srcRefObject, assocEnd );
                    contextStack.pop( result );

                } else if ( currentExp instanceof AttributeCallExp ) {
                    if ( OclInvalidImpl.OCL_INVALID.equals( src ) ) {
                        contextStack.pop( OclInvalidImpl.OCL_INVALID );
                        continue;
                    }
                    if ( OclVoidImpl.OCL_UNDEFINED.equals( src ) ) {
                        contextStack.pop( OclVoidImpl.OCL_UNDEFINED );
                        continue;
                    }
                    Attribute attribute = ( (AttributeCallExpInternal) currentExp ).getReferredAttribute( connection );

                    OclAny resultValue;

                    if ( src instanceof OclTuple ) {
                        OclTuple srcTuple = (OclTuple) src;
                        resultValue = srcTuple.getValue( attribute.getName( ) );
                    } else if ( src instanceof OclStruct ) {
                        OclStruct srcStruct = (OclStruct) src;
                        resultValue = srcStruct.getValue( attribute.getName( ) );
                    } else {
                        if ( !( src instanceof OclModelElement ) ) {
                            throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_002 );
                        }
                        RefObjectImpl srcRefObj = (RefObjectImpl) ( (OclModelElement) src ).getWrappedRefObject( );
                        Object attributeValue = srcRefObj.refGetValue( connection, attribute );

                        if ( attributeValue != null ) {
                            MultiplicityType multiplicity = attribute.getMultiplicity( );
                            int upperMultiplicity = multiplicity.getUpper( );
                            if ( upperMultiplicity > 1 || upperMultiplicity == -1 ) {
                                resultValue = this.oclFactory.createCollectionFromRawValues( (Collection<Object>) attributeValue, multiplicity.isOrdered( ), multiplicity.isUnique( ) );
                            } else {
                                resultValue = this.oclFactory.create( attributeValue );
                            }
                        } else {
                            resultValue = OclVoidImpl.OCL_UNDEFINED;
                        }
                    }
                    contextStack.pop( resultValue );

                } else if ( currentExp instanceof OperationCallExp ) {
                    // the oclIsInvalid() method should be executable on invalid
                    OperationCallExpImpl opCallExpr = (OperationCallExpImpl) currentExp;
                    OperationImpl operation = (OperationImpl) opCallExpr.getReferredOperation( connection );
                    String opName = operation.getName( );

                    JmiList<OclExpression> args = (JmiList<OclExpression>) opCallExpr.getArguments( connection );

                    if ( args.size( connection.getSession( ) ) > 0 && !currentContext.childrenEvaluated( NodeRoleTypes.Argument ) ) {
                        Iterator<OclExpression> argsIterator = args.iteratorReadOnly( connection.getSession( ) );
                        for ( ; argsIterator.hasNext( ); ) {
                            OclExpression arg = argsIterator.next( );
                            MyContext argctx = new MyContext( connection, arg, NodeRoleTypes.Argument, serializer );
                            contextStack.push( argctx );
                            currentContext.addChild( argctx );
                        }
                        continue;
                    }

                    List<MyContext> argctxs = currentContext.getChildren( NodeRoleTypes.Argument );

                    OclAny[] argValues = new OclAny[argctxs.size( )];
                    for ( int i = 0; i < argctxs.size( ); i++ ) {
                        argValues[i] = argctxs.get( i ).getValue( );
                    }

                    if ( isStdLibOperation( connection, operation ) ) {
                        OclAny result = src.callOperation( connection, opName, argValues );
                        contextStack.pop( result );
                        continue;
                    }

                    OclExpression bodyExp = lookupBodyExpression( connection, operation );

                    if ( bodyExp == null ) {
                        // we assume the operation has been generated into the JMI
                        OclAny result = evaluateJavaImplementedMethod( connection, operation, src, argValues );
                        contextStack.pop( result );
                        continue;
                    }

                    if ( !currentContext.childrenEvaluated( NodeRoleTypes.Body ) ) {
                        MyContext sourceCtx = new MyContext( connection, bodyExp, NodeRoleTypes.Body, serializer );
                        contextStack.push( sourceCtx );
                        currentContext.addChild( sourceCtx );

                        // Create a new EvaluationContext for the operation call,
                        // setting the variables from the list of arguments
                        rootContext = sourceCtx.pushEvaluationContext( src );

                        JmiList<ModelElement> operationContents = (JmiList<ModelElement>) ( operation ).getContents( connection );
                        int paramIndex = 0;
                        for ( int i = 0, n = operationContents.size( session ); i < n; i++ ) {
                            // TODO: Could this also be an Exception?
                            Parameter param = (Parameter) operationContents.get( session, i );
                            if ( DirectionKindEnum.RETURN_DIR.equals( param.getDirection( ) ) ) {
                                continue;
                            }
                            if ( DirectionKindEnum.IN_DIR.equals( param.getDirection( ) ) ) {
                                rootContext.setVariable( param.getName( ), argValues[paramIndex++] );
                            }
                        }
                        // TODO: Add support for IN_OUT and OUT args
                        continue;
                    }

                    MyContext result = currentContext.getChildren( NodeRoleTypes.Body ).get( 0 );

                    OclAny value = result.getValue( );
                    result.popEvaluationContext( );
                    contextStack.pop( value );

                    // Don't forget to pop the op-call context from the
                    // context stack
                    result.popEvaluationContext( );

                    rootContext = EvaluationContext.CurrentContext.get( );
                }
                /* Type */
            } else if ( currentExp instanceof TypeExp ) {
                TypeExp typeExpr = (TypeExp) currentExp;
                Classifier referredType = ( (TypeExpImpl) typeExpr ).getReferredType( connection );
                contextStack.pop( this.oclFactory.createType( referredType ) );
                /* Variable */
            } else if ( currentExp instanceof VariableExp ) {
                VariableExpImpl variableExpr = (VariableExpImpl) currentExp;
                String variableName = variableExpr.getReferredVariable( connection ).getVarName( );
                OclAny variableValue = rootContext.getVariable( variableName );
                if ( variableValue == null ) {
                    throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_008, variableName );
                }
                contextStack.pop( variableValue );
            } else {
                throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.EXPRTYPENOTSUPPORTED, currentExp.getClass( ).getName( ) );
            }
        }

        return currentContext;

    }

    private OclAny extractAssociationEndValue( CoreConnection connection, RefObject srcRefObject, AssociationEnd assocEnd ) {

        CoreSession session = connection.getSession( );
        Association assoc = (Association) ( (AssociationEndImpl) assocEnd ).getContainer( connection );

        // Get the proxy-object for the association (which contains the link
        // set) and query it for the value/s
        SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );
        RefAssociationImpl refAssoc = (RefAssociationImpl) jmiHelper.getRefAssociationForAssociation( connection.getSession( ), assoc );
        if ( refAssoc == null ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.EXTRACTREFASSOCFAILED, assoc.getName( ) );
        }
        JmiList<RefObject> associationValues;
        try {
            associationValues = refAssoc.refQuery( connection, MoinMetamodelCode.otherEnd( connection, (AssociationEndImpl) assocEnd ), srcRefObject );
            // If the association can have at most one value, return a single value
            MultiplicityType assocEndMultiplicity = assocEnd.getMultiplicity( );
            if ( assocEndMultiplicity.getUpper( ) == 1 ) {
                OclAny any = convertToSingleValue( session, associationValues );
                if ( any != null ) {
                    return any;
                }
                LOGGER.logAndTrace( MoinSeverity.ERROR, MoinOclEvaluatorMessages.ASSOCVALUEQUERYFAILED, MoinMetamodelCode.otherEnd( connection, (AssociationEndImpl) assocEnd ).getName( ), assoc.getName( ), srcRefObject.refMofId( ), srcRefObject.get___Mri( ).getPartitionName( ) );
                throw new EvaluatorException( MoinOclEvaluatorMessages.ASSOCVALUEQUERYFAILED, new String[] { MoinMetamodelCode.otherEnd( connection, (AssociationEndImpl) assocEnd ).getName( ), assoc.getName( ), srcRefObject.refMofId( ), srcRefObject.get___Mri( ).getPartitionName( ) } );
            }
            // Otherwise, the association can have multiple values - return a Set
            // (or OrderedSet if necessary)

            // Build a new collection, since OclFactory does not know about
            // CoreConnection.
            int size = associationValues.size( session );
            Collection<RefObject> refObjs = new ArrayList<RefObject>( size );

            for ( Iterator<RefObject> it = associationValues.iteratorReadOnly( session ); it.hasNext( ); ) {
                RefObject next = it.next( );
                if ( next == null ) {
                    LOGGER.logAndTrace( MoinSeverity.ERROR, MoinOclEvaluatorMessages.ASSOCVALUEQUERYFAILED, MoinMetamodelCode.otherEnd( connection, (AssociationEndImpl) assocEnd ).getName( ), assoc.getName( ), srcRefObject.refMofId( ), srcRefObject.get___Mri( ).getPartitionName( ) );
                    throw new EvaluatorException( MoinOclEvaluatorMessages.ASSOCVALUEQUERYFAILED, new String[] { MoinMetamodelCode.otherEnd( connection, (AssociationEndImpl) assocEnd ).getName( ), assoc.getName( ), srcRefObject.refMofId( ), srcRefObject.get___Mri( ).getPartitionName( ) } );
                }
                refObjs.add( next );
            }
            if ( assocEndMultiplicity.isOrdered( ) ) {
                return this.oclFactory.createOrderedSetFromRefObjects( refObjs );
            }
            return this.oclFactory.createSetFromRefObjects( refObjs );
        } catch (TypeMismatchException e) {
            // FIXME this exception currently may occur based on what I consider a bug in the impact analysis
            // Obviously, for OperationCallExp elements the derivation of the reverse path doesn't work properly.
            System.err.println("Caught exception "+e.getMessage()+
        	    ", probably because of bug in OCL Impact Analysis");
            return this.oclFactory.createOrderedSetFromRefObjects(new ArrayList<RefObject>());
        }

    }

    private OclAny convertToSingleValue( CoreSession session, JmiList<RefObject> associationValues ) {

        int size = associationValues.size( session );
        if ( size == 0 ) {
            return OclVoidImpl.OCL_UNDEFINED;
        }
        if ( size == 1 ) {
            RefObject next = associationValues.iteratorReadOnly( session ).next( );
            if ( next != null ) {
                return this.oclFactory.create( next );
            }
        }

        return null;
    }

    private boolean isStdLibOperation( CoreConnection connection, Operation operation ) {

        Boolean resultBool = this.operationStdLibMap.get( operation );
        if ( resultBool != null ) {
            return resultBool.booleanValue( );
        }
        // this is to cover a nasty hack to enable user-defined
        // operations
        Namespace container = ( (OperationImpl) operation ).getContainer( connection );
        if ( container == null ) {
            resultBool = Boolean.FALSE;
        } else {
            List<String> qName = MoinMetamodelCode.getQualifiedName( connection, container, (RefObjectImpl) container );
            if ( qName.size( ) == 3 && OclConstants.P_OCL.equals( qName.get( 0 ) ) && OclConstants.P_STDLIBRARY.equals( qName.get( 1 ) ) ) {
                resultBool = Boolean.TRUE;
            } else {
                resultBool = Boolean.FALSE;
            }
        }

        this.operationStdLibMap.put( operation, resultBool );
        return resultBool.booleanValue( );
    }

    /**
     * Find the corresponding body expression for the supplied operation.
     */
    private OclExpression lookupBodyExpression( CoreConnection connection, Operation operation ) {

        OclExpression bodyExp = ( (OperationBodyDefinitionImpl) connection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR ) ).getBody( connection, operation );
        return bodyExp;
    }

    /**
     * Evaluates the supplied operation by calling the refInvokeOperation method
     * on the supplied src RefObject with the supplied args.
     */
    private OclAny evaluateJavaImplementedMethod( CoreConnection connection, Operation operation, OclAny src, OclAny[] args ) {

        if ( OclInvalidImpl.OCL_INVALID.equals( src ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }

        if ( OclVoidImpl.OCL_UNDEFINED.equals( src ) ) {
            return OclVoidImpl.OCL_UNDEFINED;
        }
        CoreSession session = connection.getSession( );

        // Unwrap the arguments for the reflection call
        List<Object> objectArgs = new ArrayList<Object>( );
        for ( int i = 0; i < args.length; i++ ) {
            if ( args[i].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
                objectArgs.add( null );
            } else if ( args[i].equals( OclInvalidImpl.OCL_INVALID ) ) {
                return OclInvalidImpl.OCL_INVALID;
            } else {
                if ( args[i] instanceof OclCollection ) {
                    objectArgs.add( ( (OclCollection) args[i] ).getUnwrappingCollection( false ) );
                } else {
                    objectArgs.add( args[i].getWrappedObject( ) );
                }
            }
        }

        RefObject srcRefObj = null;
        if ( src instanceof OclModelElement ) {
            srcRefObj = ( (OclModelElement) src ).getWrappedRefObject( );
        } else if ( src instanceof OclCollection ) {
            // TODO: This is untested!
            Collection<OclAny> col = ( (OclCollection) src ).getWrappedCollection( );
            if ( col.size( ) == 1 ) {
                // If the source is a collection of size one, set the
                // sourceRefObj to that single value.
                OclAny obj = col.iterator( ).next( );
                if ( obj != null && obj instanceof OclModelElement ) {
                    srcRefObj = ( (OclModelElement) obj ).getWrappedRefObject( );
                }
            }
        }
        if ( srcRefObj == null ) {
            // Should not happen
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.COULDNOTGETSOURCEFORJAVAOP );
        }

        Object result;
        try {
            WrapperManager wm = connection.getSession( ).getWorkspaceSet( ).getWrapperManager( );
            RefObject wrapped = connection.getWrapperForJmiObject( srcRefObj );
            List<Object> wrappedArgs = new ArrayList<Object>( objectArgs.size( ) );
            for ( Object arg : objectArgs ) {
                wrappedArgs.add( wm.wrapObject( connection, arg ) );
            }
            result = wrapped.refInvokeOperation( operation.getName( ), wrappedArgs );
//            result = ( (RefObjectImpl) srcRefObj ).refInvokeOperation( connection, operation.getName( ), objectArgs );
        } catch ( RefException e ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        if ( result == null ) {
            return OclVoidImpl.OCL_UNDEFINED;
        }

        if ( !( result instanceof Collection ) ) {
            return this.oclFactory.create( result );
        }
        boolean isUnique = false;
        boolean isOrdered = false;
        JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (OperationImpl) operation ).getContents( connection );
        for ( int i = 0, n = contents.size( session ); i < n; i++ ) {
            Parameter param = (Parameter) contents.get( session, i );
            if ( DirectionKindEnum.RETURN_DIR.equals( param.getDirection( ) ) ) {
                isUnique = param.getMultiplicity( ).isUnique( );
                isOrdered = param.getMultiplicity( ).isOrdered( );
            }
        }
        return this.oclFactory.createCollectionFromRawValues( (Collection<Object>) result, isOrdered, isUnique );
    }

    private ResultHandler getResultHandler( String opName, List<String> iteratorNames ) {

        if ( iteratorNames.isEmpty( ) ) {
            throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_010 );
        }

        /*
         * This code could be refactored to use a look-up table & switch
         * statement if it is necessary for performance reasons.
         */

        if ( OclConstants.OP_EXISTS.equals( opName ) ) {
            return new ExistsHandler( );
        } else if ( OclConstants.OP_FORALL.equals( opName ) ) {
            return new ForAllHandler( );
        } else if ( OclConstants.OP_ISUNIQUE.equals( opName ) ) {
            checkSingleIteratorName( iteratorNames );
            return new IsUniqueHandler( );
        } else if ( OclConstants.OP_ANY.equals( opName ) ) {
            checkSingleIteratorName( iteratorNames );
            return new AnyHandler( iteratorNames.get( 0 ) );
        } else if ( OclConstants.OP_ONE.equals( opName ) ) {
            checkSingleIteratorName( iteratorNames );
            return new OneHandler( );
        } else if ( OclConstants.OP_COLLECT.equals( opName ) ) {
            checkSingleIteratorName( iteratorNames );
            return new CollectHandler( true );
        } else if ( OclConstants.OP_COLLECTNESTED.equals( opName ) ) {
            checkSingleIteratorName( iteratorNames );
            return new CollectHandler( false );
        } else if ( OclConstants.OP_SELECT.equals( opName ) ) {
            checkSingleIteratorName( iteratorNames );
            return new SelectRejectHandler( iteratorNames.get( 0 ), OclBoolean.TRUE );
        } else if ( OclConstants.OP_REJECT.equals( opName ) ) {
            checkSingleIteratorName( iteratorNames );
            return new SelectRejectHandler( iteratorNames.get( 0 ), OclBoolean.FALSE );
        } else if ( OclConstants.OP_SORTEDBY.equals( opName ) ) {
            checkSingleIteratorName( iteratorNames );
            return new SortedByHandler( iteratorNames.get( 0 ) );
        }
        throw new OperationNotFoundException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_017, new String[] { opName, getClass( ).getName( ) } );
    }

    /**
     * Convenience method for iterator operations that can only take one
     * iterator name. This method checks the length of the supplied array and
     * throws a SemanticErrorException if it is greater than one.
     */
    private void checkSingleIteratorName( List<String> iteratorNames ) {

        if ( iteratorNames.size( ) > 1 ) {
            throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_011 );
        }
    }

}
