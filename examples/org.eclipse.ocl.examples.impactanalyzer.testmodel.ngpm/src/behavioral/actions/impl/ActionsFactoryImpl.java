/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActionsFactoryImpl.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.actions.impl;

import behavioral.actions.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionsFactoryImpl extends EFactoryImpl implements ActionsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ActionsFactory init() {
        try {
            ActionsFactory theActionsFactory = (ActionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/actions.ecore"); 
            if (theActionsFactory != null) {
                return theActionsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ActionsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionsFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ActionsPackage.ASSIGNMENT: return createAssignment();
            case ActionsPackage.BLOCK: return createBlock();
            case ActionsPackage.IF_ELSE: return createIfElse();
            case ActionsPackage.WHILE_LOOP: return createWhileLoop();
            case ActionsPackage.FOREACH: return createForeach();
            case ActionsPackage.RETURN: return createReturn();
            case ActionsPackage.ADD_LINK: return createAddLink();
            case ActionsPackage.REMOVE_LINK: return createRemoveLink();
            case ActionsPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
            case ActionsPackage.SORT: return createSort();
            case ActionsPackage.QUERY_INVOCATION: return createQueryInvocation();
            case ActionsPackage.CONSTANT: return createConstant();
            case ActionsPackage.VARIABLE: return createVariable();
            case ActionsPackage.ITERATOR: return createIterator();
            case ActionsPackage.NAMED_VALUE_DECLARATION: return createNamedValueDeclaration();
            case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS: return createStatementWithNestedBlocks();
            case ActionsPackage.SINGLE_BLOCK_STATEMENT: return createSingleBlockStatement();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Assignment createAssignment() {
        AssignmentImpl assignment = new AssignmentImpl();
        return assignment;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Block createBlock() {
        BlockImpl block = new BlockImpl();
        return block;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IfElse createIfElse() {
        IfElseImpl ifElse = new IfElseImpl();
        return ifElse;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public WhileLoop createWhileLoop() {
        WhileLoopImpl whileLoop = new WhileLoopImpl();
        return whileLoop;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Foreach createForeach() {
        ForeachImpl foreach = new ForeachImpl();
        return foreach;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Return createReturn() {
        ReturnImpl return_ = new ReturnImpl();
        return return_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AddLink createAddLink() {
        AddLinkImpl addLink = new AddLinkImpl();
        return addLink;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RemoveLink createRemoveLink() {
        RemoveLinkImpl removeLink = new RemoveLinkImpl();
        return removeLink;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExpressionStatement createExpressionStatement() {
        ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
        return expressionStatement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Sort createSort() {
        SortImpl sort = new SortImpl();
        return sort;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QueryInvocation createQueryInvocation() {
        QueryInvocationImpl queryInvocation = new QueryInvocationImpl();
        return queryInvocation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Constant createConstant() {
        ConstantImpl constant = new ConstantImpl();
        return constant;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Variable createVariable() {
        VariableImpl variable = new VariableImpl();
        return variable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Iterator createIterator() {
        IteratorImpl iterator = new IteratorImpl();
        return iterator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NamedValueDeclaration createNamedValueDeclaration() {
        NamedValueDeclarationImpl namedValueDeclaration = new NamedValueDeclarationImpl();
        return namedValueDeclaration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatementWithNestedBlocks createStatementWithNestedBlocks() {
        StatementWithNestedBlocksImpl statementWithNestedBlocks = new StatementWithNestedBlocksImpl();
        return statementWithNestedBlocks;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SingleBlockStatement createSingleBlockStatement() {
        SingleBlockStatementImpl singleBlockStatement = new SingleBlockStatementImpl();
        return singleBlockStatement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionsPackage getActionsPackage() {
        return (ActionsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ActionsPackage getPackage() {
        return ActionsPackage.eINSTANCE;
    }

} //ActionsFactoryImpl
