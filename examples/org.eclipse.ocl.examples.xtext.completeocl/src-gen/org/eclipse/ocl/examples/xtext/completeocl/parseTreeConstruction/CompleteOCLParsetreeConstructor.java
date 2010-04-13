/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteOCLParsetreeConstructor.java,v 1.1 2010/04/13 06:38:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess;

import com.google.inject.Inject;

public class CompleteOCLParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private CompleteOCLGrammarAccess grammarAccess;
	
	@Override	
	public CompleteOCLGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}

	@Override
	protected AbstractToken getRootToken(IInstanceDescription inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IInstanceDescription inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Model_Group(this, this, 0, inst);
			case 1: return new ImportCS_Group(this, this, 1, inst);
			case 2: return new PackageDeclarationCS_Group(this, this, 2, inst);
			case 3: return new ContextDeclCS_Alternatives(this, this, 3, inst);
			case 4: return new PropertyContextDeclCS_Group(this, this, 4, inst);
			case 5: return new InitCS_Group(this, this, 5, inst);
			case 6: return new DerCS_Group(this, this, 6, inst);
			case 7: return new ClassifierContextDeclCS_Group(this, this, 7, inst);
			case 8: return new InvCS_Group(this, this, 8, inst);
			case 9: return new DefCS_Group(this, this, 9, inst);
			case 10: return new OperationContextDeclCS_Group(this, this, 10, inst);
			case 11: return new ParameterCS_Group(this, this, 11, inst);
			case 12: return new PreCS_Group(this, this, 12, inst);
			case 13: return new PostCS_Group(this, this, 13, inst);
			case 14: return new BodyCS_Group(this, this, 14, inst);
			case 15: return new ConstraintCS_Alternatives(this, this, 15, inst);
			case 16: return new NamedConstraintCS_Alternatives(this, this, 16, inst);
			case 17: return new ExtendedPrimaryExpCS_Alternatives(this, this, 17, inst);
			case 18: return new OclMessageExpCS_Group(this, this, 18, inst);
			case 19: return new OclMessageArgCS_Alternatives(this, this, 19, inst);
			case 20: return new TupleKeywordCS_ValueAssignment(this, this, 20, inst);
			case 21: return new RestrictedKeywordCS_Alternatives(this, this, 21, inst);
			case 22: return new SelfKeywordCS_ValueAssignment(this, this, 22, inst);
			case 23: return new SimpleNameCS_ValueAssignment(this, this, 23, inst);
			case 24: return new UnreservedSimpleNameCS_Alternatives(this, this, 24, inst);
			case 25: return new PathNameCS_Group(this, this, 25, inst);
			case 26: return new PrimitiveTypeCS_Alternatives(this, this, 26, inst);
			case 27: return new CollectionTypeIdentifierCS_Alternatives(this, this, 27, inst);
			case 28: return new TypeCS_Alternatives(this, this, 28, inst);
			case 29: return new CollectionTypeCS_Group(this, this, 29, inst);
			case 30: return new TupleTypeCS_Group(this, this, 30, inst);
			case 31: return new TuplePartCS_Group(this, this, 31, inst);
			case 32: return new LiteralExpCS_Alternatives(this, this, 32, inst);
			case 33: return new CollectionLiteralExpCS_Group(this, this, 33, inst);
			case 34: return new CollectionLiteralPartCS_Group(this, this, 34, inst);
			case 35: return new PrimitiveLiteralExpCS_Alternatives(this, this, 35, inst);
			case 36: return new TupleLiteralExpCS_Group(this, this, 36, inst);
			case 37: return new TupleLiteralPartCS_Group(this, this, 37, inst);
			case 38: return new IntegerLiteralExpCS_IntegerSymbolAssignment(this, this, 38, inst);
			case 39: return new RealLiteralExpCS_RealSymbolAssignment(this, this, 39, inst);
			case 40: return new StringLiteralExpCS_StringSymbolAssignment(this, this, 40, inst);
			case 41: return new BooleanLiteralExpCS_Alternatives(this, this, 41, inst);
			case 42: return new UnlimitedNaturalLiteralExpCS_Group(this, this, 42, inst);
			case 43: return new InvalidLiteralExpCS_Group(this, this, 43, inst);
			case 44: return new NullLiteralExpCS_Group(this, this, 44, inst);
			case 45: return new TypeLiteralExpCS_Alternatives(this, this, 45, inst);
			case 46: return new OclExpressionCS_Alternatives(this, this, 46, inst);
			case 47: return new ImpliesCS_Group(this, this, 47, inst);
			case 48: return new XorCS_Group(this, this, 48, inst);
			case 49: return new OrCS_Group(this, this, 49, inst);
			case 50: return new AndCS_Group(this, this, 50, inst);
			case 51: return new EqualityCS_Group(this, this, 51, inst);
			case 52: return new RelationalCS_Group(this, this, 52, inst);
			case 53: return new AdditiveCS_Group(this, this, 53, inst);
			case 54: return new MultiplicativeCS_Group(this, this, 54, inst);
			case 55: return new UnaryCS_Alternatives(this, this, 55, inst);
			case 56: return new CalledExpCS_Group(this, this, 56, inst);
			case 57: return new CallArgumentsCS_Alternatives(this, this, 57, inst);
			case 58: return new IteratorVariableCS_Group(this, this, 58, inst);
			case 59: return new IteratorAccumulatorCS_Group(this, this, 59, inst);
			case 60: return new ImplicitCallExpCS_PreCallExpCSParserRuleCall(this, this, 60, inst);
			case 61: return new PreCallExpCS_ExtendedPrimaryExpCSParserRuleCall(this, this, 61, inst);
			case 62: return new SimpleNameExpCS_SimpleNameCSParserRuleCall(this, this, 62, inst);
			case 63: return new PrimaryExpCS_Alternatives(this, this, 63, inst);
			case 64: return new IfExpCS_Group(this, this, 64, inst);
			case 65: return new LetExpCS_Group(this, this, 65, inst);
			case 66: return new LetVariableCS_Group(this, this, 66, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule Model ****************
 *
 * Model returns DocumentCS:
 *   imports+=importCS* (packages+=packageDeclarationCS|contexts+=contextDeclCS)*; 
 * //generate completeOCL "http://www.eclipse.org/ocl/examples/xtext/completeocl/CompleteOCL"
 *
 **/

// imports+=importCS* (packages+=packageDeclarationCS|contexts+=contextDeclCS)*
protected class Model_Group extends GroupToken {
	
	public Model_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getModelAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Model_Alternatives_1(parent, this, 0, inst);
			case 1: return new Model_ImportsAssignment_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getModelRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// imports+=importCS*
protected class Model_ImportsAssignment_0 extends AssignmentToken  {
	
	public Model_ImportsAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getModelAccess().getImportsAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImportCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("imports",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("imports");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getImportCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getModelAccess().getImportsImportCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Model_ImportsAssignment_0(parent, next, actIndex, consumed);
			default: return parent.createParentFollower(next, actIndex , index - 1, consumed);
		}	
	}	
}

// (packages+=packageDeclarationCS|contexts+=contextDeclCS)*
protected class Model_Alternatives_1 extends AlternativesToken {

	public Model_Alternatives_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getModelAccess().getAlternatives_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new Model_PackagesAssignment_1_0(parent, this, 0, inst);
			case 1: return new Model_ContextsAssignment_1_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// packages+=packageDeclarationCS
protected class Model_PackagesAssignment_1_0 extends AssignmentToken  {
	
	public Model_PackagesAssignment_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getModelAccess().getPackagesAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PackageDeclarationCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("packages",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("packages");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPackageDeclarationCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getModelAccess().getPackagesPackageDeclarationCSParserRuleCall_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Model_Alternatives_1(parent, next, actIndex, consumed);
			case 1: return new Model_ImportsAssignment_0(parent, next, actIndex, consumed);
			default: return parent.createParentFollower(next, actIndex , index - 2, consumed);
		}	
	}	
}

// contexts+=contextDeclCS
protected class Model_ContextsAssignment_1_1 extends AssignmentToken  {
	
	public Model_ContextsAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getModelAccess().getContextsAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ContextDeclCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("contexts",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("contexts");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getContextDeclCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getModelAccess().getContextsContextDeclCSParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Model_Alternatives_1(parent, next, actIndex, consumed);
			case 1: return new Model_ImportsAssignment_0(parent, next, actIndex, consumed);
			default: return parent.createParentFollower(next, actIndex , index - 2, consumed);
		}	
	}	
}



/************ end Rule Model ****************/



/************ begin Rule importCS ****************
 *
 * importCS returns ImportCS:
 *   "import" importedNamespace=FQN;
 *
 **/

// "import" importedNamespace=FQN
protected class ImportCS_Group extends GroupToken {
	
	public ImportCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getImportCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImportCS_ImportedNamespaceAssignment_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getImportCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "import"
protected class ImportCS_ImportKeyword_0 extends KeywordToken  {
	
	public ImportCS_ImportKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getImportCSAccess().getImportKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// importedNamespace=FQN
protected class ImportCS_ImportedNamespaceAssignment_1 extends AssignmentToken  {
	
	public ImportCS_ImportedNamespaceAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getImportCSAccess().getImportedNamespaceAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImportCS_ImportKeyword_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("importedNamespace",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("importedNamespace");
		if(Boolean.TRUE.booleanValue()) { 
			type = AssignmentType.DRC;
			element = grammarAccess.getImportCSAccess().getImportedNamespaceFQNParserRuleCall_1_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule importCS ****************/


/************ begin Rule packageDeclarationCS ****************
 *
 * packageDeclarationCS returns PackageDeclarationCS:
 *   "package" name=pathNameCS contexts+=contextDeclCS* "endpackage";
 *
 **/

// "package" name=pathNameCS contexts+=contextDeclCS* "endpackage"
protected class PackageDeclarationCS_Group extends GroupToken {
	
	public PackageDeclarationCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPackageDeclarationCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PackageDeclarationCS_EndpackageKeyword_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getPackageDeclarationCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "package"
protected class PackageDeclarationCS_PackageKeyword_0 extends KeywordToken  {
	
	public PackageDeclarationCS_PackageKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPackageDeclarationCSAccess().getPackageKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// name=pathNameCS
protected class PackageDeclarationCS_NameAssignment_1 extends AssignmentToken  {
	
	public PackageDeclarationCS_NameAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPackageDeclarationCSAccess().getNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("name",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPathNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPackageDeclarationCSAccess().getNamePathNameCSParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PackageDeclarationCS_PackageKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// contexts+=contextDeclCS*
protected class PackageDeclarationCS_ContextsAssignment_2 extends AssignmentToken  {
	
	public PackageDeclarationCS_ContextsAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPackageDeclarationCSAccess().getContextsAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ContextDeclCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("contexts",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("contexts");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getContextDeclCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPackageDeclarationCSAccess().getContextsContextDeclCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PackageDeclarationCS_ContextsAssignment_2(parent, next, actIndex, consumed);
			case 1: return new PackageDeclarationCS_NameAssignment_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "endpackage"
protected class PackageDeclarationCS_EndpackageKeyword_3 extends KeywordToken  {
	
	public PackageDeclarationCS_EndpackageKeyword_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPackageDeclarationCSAccess().getEndpackageKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PackageDeclarationCS_ContextsAssignment_2(parent, this, 0, inst);
			case 1: return new PackageDeclarationCS_NameAssignment_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule packageDeclarationCS ****************/


/************ begin Rule contextDeclCS ****************
 *
 * contextDeclCS returns ContextDeclCS:
 *   propertyContextDeclCS|classifierContextDeclCS|operationContextDeclCS;
 *
 **/

// propertyContextDeclCS|classifierContextDeclCS|operationContextDeclCS
protected class ContextDeclCS_Alternatives extends AlternativesToken {

	public ContextDeclCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getContextDeclCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ContextDeclCS_PropertyContextDeclCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new ContextDeclCS_ClassifierContextDeclCSParserRuleCall_1(parent, this, 1, inst);
			case 2: return new ContextDeclCS_OperationContextDeclCSParserRuleCall_2(parent, this, 2, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getContextDeclCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// propertyContextDeclCS
protected class ContextDeclCS_PropertyContextDeclCSParserRuleCall_0 extends RuleCallToken {
	
	public ContextDeclCS_PropertyContextDeclCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getContextDeclCSAccess().getPropertyContextDeclCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PropertyContextDeclCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PropertyContextDeclCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPropertyContextDeclCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// classifierContextDeclCS
protected class ContextDeclCS_ClassifierContextDeclCSParserRuleCall_1 extends RuleCallToken {
	
	public ContextDeclCS_ClassifierContextDeclCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getContextDeclCSAccess().getClassifierContextDeclCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ClassifierContextDeclCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(ClassifierContextDeclCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getClassifierContextDeclCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// operationContextDeclCS
protected class ContextDeclCS_OperationContextDeclCSParserRuleCall_2 extends RuleCallToken {
	
	public ContextDeclCS_OperationContextDeclCSParserRuleCall_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getContextDeclCSAccess().getOperationContextDeclCSParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OperationContextDeclCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(OperationContextDeclCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getOperationContextDeclCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule contextDeclCS ****************/


/************ begin Rule propertyContextDeclCS ****************
 *
 * propertyContextDeclCS returns PropertyContextDeclCS:
 *   "context" contextName=pathNameCS ":" type=typeCS ((init=initCS der=derCS?)?|der=derCS
 *   init=initCS?);
 *
 **/

// "context" contextName=pathNameCS ":" type=typeCS ((init=initCS der=derCS?)?|der=derCS
// init=initCS?)
protected class PropertyContextDeclCS_Group extends GroupToken {
	
	public PropertyContextDeclCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PropertyContextDeclCS_Alternatives_4(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getPropertyContextDeclCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "context"
protected class PropertyContextDeclCS_ContextKeyword_0 extends KeywordToken  {
	
	public PropertyContextDeclCS_ContextKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getContextKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// contextName=pathNameCS
protected class PropertyContextDeclCS_ContextNameAssignment_1 extends AssignmentToken  {
	
	public PropertyContextDeclCS_ContextNameAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getContextNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("contextName",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("contextName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPathNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPropertyContextDeclCSAccess().getContextNamePathNameCSParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PropertyContextDeclCS_ContextKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ":"
protected class PropertyContextDeclCS_ColonKeyword_2 extends KeywordToken  {
	
	public PropertyContextDeclCS_ColonKeyword_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getColonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PropertyContextDeclCS_ContextNameAssignment_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS
protected class PropertyContextDeclCS_TypeAssignment_3 extends AssignmentToken  {
	
	public PropertyContextDeclCS_TypeAssignment_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getTypeAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPropertyContextDeclCSAccess().getTypeTypeCSParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PropertyContextDeclCS_ColonKeyword_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// (init=initCS der=derCS?)?|der=derCS init=initCS?
protected class PropertyContextDeclCS_Alternatives_4 extends AlternativesToken {

	public PropertyContextDeclCS_Alternatives_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getAlternatives_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PropertyContextDeclCS_Group_4_0(parent, this, 0, inst);
			case 1: return new PropertyContextDeclCS_Group_4_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// (init=initCS der=derCS?)?
protected class PropertyContextDeclCS_Group_4_0 extends GroupToken {
	
	public PropertyContextDeclCS_Group_4_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getGroup_4_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PropertyContextDeclCS_DerAssignment_4_0_1(parent, this, 0, inst);
			case 1: return new PropertyContextDeclCS_InitAssignment_4_0_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// init=initCS
protected class PropertyContextDeclCS_InitAssignment_4_0_0 extends AssignmentToken  {
	
	public PropertyContextDeclCS_InitAssignment_4_0_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getInitAssignment_4_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InitCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("init",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("init");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getInitCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPropertyContextDeclCSAccess().getInitInitCSParserRuleCall_4_0_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PropertyContextDeclCS_TypeAssignment_3(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// der=derCS?
protected class PropertyContextDeclCS_DerAssignment_4_0_1 extends AssignmentToken  {
	
	public PropertyContextDeclCS_DerAssignment_4_0_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getDerAssignment_4_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DerCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("der",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("der");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDerCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPropertyContextDeclCSAccess().getDerDerCSParserRuleCall_4_0_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PropertyContextDeclCS_InitAssignment_4_0_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// der=derCS init=initCS?
protected class PropertyContextDeclCS_Group_4_1 extends GroupToken {
	
	public PropertyContextDeclCS_Group_4_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getGroup_4_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PropertyContextDeclCS_InitAssignment_4_1_1(parent, this, 0, inst);
			case 1: return new PropertyContextDeclCS_DerAssignment_4_1_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// der=derCS
protected class PropertyContextDeclCS_DerAssignment_4_1_0 extends AssignmentToken  {
	
	public PropertyContextDeclCS_DerAssignment_4_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getDerAssignment_4_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DerCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("der",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("der");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDerCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPropertyContextDeclCSAccess().getDerDerCSParserRuleCall_4_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PropertyContextDeclCS_TypeAssignment_3(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// init=initCS?
protected class PropertyContextDeclCS_InitAssignment_4_1_1 extends AssignmentToken  {
	
	public PropertyContextDeclCS_InitAssignment_4_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyContextDeclCSAccess().getInitAssignment_4_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InitCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("init",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("init");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getInitCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPropertyContextDeclCSAccess().getInitInitCSParserRuleCall_4_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PropertyContextDeclCS_DerAssignment_4_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}




/************ end Rule propertyContextDeclCS ****************/


/************ begin Rule initCS ****************
 *
 * initCS returns InitCS:
 *   "init" ":" expression=OclExpressionCS;
 *
 **/

// "init" ":" expression=OclExpressionCS
protected class InitCS_Group extends GroupToken {
	
	public InitCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInitCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InitCS_ExpressionAssignment_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getInitCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "init"
protected class InitCS_InitKeyword_0 extends KeywordToken  {
	
	public InitCS_InitKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInitCSAccess().getInitKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// ":"
protected class InitCS_ColonKeyword_1 extends KeywordToken  {
	
	public InitCS_ColonKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInitCSAccess().getColonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InitCS_InitKeyword_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// expression=OclExpressionCS
protected class InitCS_ExpressionAssignment_2 extends AssignmentToken  {
	
	public InitCS_ExpressionAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInitCSAccess().getExpressionAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("expression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getInitCSAccess().getExpressionOclExpressionCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InitCS_ColonKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule initCS ****************/


/************ begin Rule derCS ****************
 *
 * derCS returns DerCS:
 *   "derive" ":" expression=OclExpressionCS;
 *
 **/

// "derive" ":" expression=OclExpressionCS
protected class DerCS_Group extends GroupToken {
	
	public DerCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDerCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DerCS_ExpressionAssignment_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getDerCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "derive"
protected class DerCS_DeriveKeyword_0 extends KeywordToken  {
	
	public DerCS_DeriveKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDerCSAccess().getDeriveKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// ":"
protected class DerCS_ColonKeyword_1 extends KeywordToken  {
	
	public DerCS_ColonKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDerCSAccess().getColonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DerCS_DeriveKeyword_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// expression=OclExpressionCS
protected class DerCS_ExpressionAssignment_2 extends AssignmentToken  {
	
	public DerCS_ExpressionAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDerCSAccess().getExpressionAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("expression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getDerCSAccess().getExpressionOclExpressionCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DerCS_ColonKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule derCS ****************/


/************ begin Rule classifierContextDeclCS ****************
 *
 * classifierContextDeclCS returns ClassifierContextDeclCS:
 *   "context" (selfName=simpleNameCS ":")? contextName=pathNameCS (invs+=invCS|defs+=
 *   defCS)*;
 *
 **/

// "context" (selfName=simpleNameCS ":")? contextName=pathNameCS (invs+=invCS|defs+=
// defCS)*
protected class ClassifierContextDeclCS_Group extends GroupToken {
	
	public ClassifierContextDeclCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassifierContextDeclCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ClassifierContextDeclCS_Alternatives_3(parent, this, 0, inst);
			case 1: return new ClassifierContextDeclCS_ContextNameAssignment_2(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getClassifierContextDeclCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "context"
protected class ClassifierContextDeclCS_ContextKeyword_0 extends KeywordToken  {
	
	public ClassifierContextDeclCS_ContextKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassifierContextDeclCSAccess().getContextKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// (selfName=simpleNameCS ":")?
protected class ClassifierContextDeclCS_Group_1 extends GroupToken {
	
	public ClassifierContextDeclCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassifierContextDeclCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ClassifierContextDeclCS_ColonKeyword_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// selfName=simpleNameCS
protected class ClassifierContextDeclCS_SelfNameAssignment_1_0 extends AssignmentToken  {
	
	public ClassifierContextDeclCS_SelfNameAssignment_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassifierContextDeclCSAccess().getSelfNameAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("selfName",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("selfName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getClassifierContextDeclCSAccess().getSelfNameSimpleNameCSParserRuleCall_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassifierContextDeclCS_ContextKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ":"
protected class ClassifierContextDeclCS_ColonKeyword_1_1 extends KeywordToken  {
	
	public ClassifierContextDeclCS_ColonKeyword_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassifierContextDeclCSAccess().getColonKeyword_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ClassifierContextDeclCS_SelfNameAssignment_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}


// contextName=pathNameCS
protected class ClassifierContextDeclCS_ContextNameAssignment_2 extends AssignmentToken  {
	
	public ClassifierContextDeclCS_ContextNameAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassifierContextDeclCSAccess().getContextNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("contextName",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("contextName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPathNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getClassifierContextDeclCSAccess().getContextNamePathNameCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassifierContextDeclCS_Group_1(parent, next, actIndex, consumed);
			case 1: return new ClassifierContextDeclCS_ContextKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// (invs+=invCS|defs+=defCS)*
protected class ClassifierContextDeclCS_Alternatives_3 extends AlternativesToken {

	public ClassifierContextDeclCS_Alternatives_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getClassifierContextDeclCSAccess().getAlternatives_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ClassifierContextDeclCS_InvsAssignment_3_0(parent, this, 0, inst);
			case 1: return new ClassifierContextDeclCS_DefsAssignment_3_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// invs+=invCS
protected class ClassifierContextDeclCS_InvsAssignment_3_0 extends AssignmentToken  {
	
	public ClassifierContextDeclCS_InvsAssignment_3_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassifierContextDeclCSAccess().getInvsAssignment_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InvCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("invs",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("invs");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getInvCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getClassifierContextDeclCSAccess().getInvsInvCSParserRuleCall_3_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassifierContextDeclCS_Alternatives_3(parent, next, actIndex, consumed);
			case 1: return new ClassifierContextDeclCS_ContextNameAssignment_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// defs+=defCS
protected class ClassifierContextDeclCS_DefsAssignment_3_1 extends AssignmentToken  {
	
	public ClassifierContextDeclCS_DefsAssignment_3_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassifierContextDeclCSAccess().getDefsAssignment_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("defs",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("defs");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDefCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getClassifierContextDeclCSAccess().getDefsDefCSParserRuleCall_3_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassifierContextDeclCS_Alternatives_3(parent, next, actIndex, consumed);
			case 1: return new ClassifierContextDeclCS_ContextNameAssignment_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule classifierContextDeclCS ****************/


/************ begin Rule invCS ****************
 *
 * invCS returns InvCS:
 *   "inv" constraintName=simpleNameCS? ":" expression=OclExpressionCS;
 *
 **/

// "inv" constraintName=simpleNameCS? ":" expression=OclExpressionCS
protected class InvCS_Group extends GroupToken {
	
	public InvCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInvCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InvCS_ExpressionAssignment_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getInvCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "inv"
protected class InvCS_InvKeyword_0 extends KeywordToken  {
	
	public InvCS_InvKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInvCSAccess().getInvKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// constraintName=simpleNameCS?
protected class InvCS_ConstraintNameAssignment_1 extends AssignmentToken  {
	
	public InvCS_ConstraintNameAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInvCSAccess().getConstraintNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("constraintName",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("constraintName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getInvCSAccess().getConstraintNameSimpleNameCSParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InvCS_InvKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ":"
protected class InvCS_ColonKeyword_2 extends KeywordToken  {
	
	public InvCS_ColonKeyword_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInvCSAccess().getColonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InvCS_ConstraintNameAssignment_1(parent, this, 0, inst);
			case 1: return new InvCS_InvKeyword_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// expression=OclExpressionCS
protected class InvCS_ExpressionAssignment_3 extends AssignmentToken  {
	
	public InvCS_ExpressionAssignment_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInvCSAccess().getExpressionAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("expression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getInvCSAccess().getExpressionOclExpressionCSParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InvCS_ColonKeyword_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule invCS ****************/


/************ begin Rule defCS ****************
 *
 * defCS returns DefCS:
 *   static?="static"? "def" constraintName=simpleNameCS? ":" constrainedName=
 *   simpleNameCS ("(" (parameters+=parameterCS ("," parameters+=parameterCS)*)? ")")? ":"
 *   type=typeCS? "=" expression=OclExpressionCS;
 *
 **/

// static?="static"? "def" constraintName=simpleNameCS? ":" constrainedName=
// simpleNameCS ("(" (parameters+=parameterCS ("," parameters+=parameterCS)*)? ")")? ":"
// type=typeCS? "=" expression=OclExpressionCS
protected class DefCS_Group extends GroupToken {
	
	public DefCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDefCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_ExpressionAssignment_9(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getDefCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// static?="static"?
protected class DefCS_StaticAssignment_0 extends AssignmentToken  {
	
	public DefCS_StaticAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDefCSAccess().getStaticAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("static",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("static");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getDefCSAccess().getStaticStaticKeyword_0_0();
			return obj;
		}
		return null;
	}

}

// "def"
protected class DefCS_DefKeyword_1 extends KeywordToken  {
	
	public DefCS_DefKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDefCSAccess().getDefKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_StaticAssignment_0(parent, this, 0, inst);
			default: return parent.createParentFollower(this, index, index - 1, inst);
		}	
	}	
		
}

// constraintName=simpleNameCS?
protected class DefCS_ConstraintNameAssignment_2 extends AssignmentToken  {
	
	public DefCS_ConstraintNameAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDefCSAccess().getConstraintNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("constraintName",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("constraintName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getDefCSAccess().getConstraintNameSimpleNameCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DefCS_DefKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ":"
protected class DefCS_ColonKeyword_3 extends KeywordToken  {
	
	public DefCS_ColonKeyword_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDefCSAccess().getColonKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_ConstraintNameAssignment_2(parent, this, 0, inst);
			case 1: return new DefCS_DefKeyword_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// constrainedName=simpleNameCS
protected class DefCS_ConstrainedNameAssignment_4 extends AssignmentToken  {
	
	public DefCS_ConstrainedNameAssignment_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDefCSAccess().getConstrainedNameAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("constrainedName",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("constrainedName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getDefCSAccess().getConstrainedNameSimpleNameCSParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DefCS_ColonKeyword_3(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("(" (parameters+=parameterCS ("," parameters+=parameterCS)*)? ")")?
protected class DefCS_Group_5 extends GroupToken {
	
	public DefCS_Group_5(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDefCSAccess().getGroup_5();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_RightParenthesisKeyword_5_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// "("
protected class DefCS_LeftParenthesisKeyword_5_0 extends KeywordToken  {
	
	public DefCS_LeftParenthesisKeyword_5_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDefCSAccess().getLeftParenthesisKeyword_5_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_ConstrainedNameAssignment_4(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// (parameters+=parameterCS ("," parameters+=parameterCS)*)?
protected class DefCS_Group_5_1 extends GroupToken {
	
	public DefCS_Group_5_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDefCSAccess().getGroup_5_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_Group_5_1_1(parent, this, 0, inst);
			case 1: return new DefCS_ParametersAssignment_5_1_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// parameters+=parameterCS
protected class DefCS_ParametersAssignment_5_1_0 extends AssignmentToken  {
	
	public DefCS_ParametersAssignment_5_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDefCSAccess().getParametersAssignment_5_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ParameterCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("parameters",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("parameters");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getParameterCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getDefCSAccess().getParametersParameterCSParserRuleCall_5_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DefCS_LeftParenthesisKeyword_5_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," parameters+=parameterCS)*
protected class DefCS_Group_5_1_1 extends GroupToken {
	
	public DefCS_Group_5_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDefCSAccess().getGroup_5_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_ParametersAssignment_5_1_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class DefCS_CommaKeyword_5_1_1_0 extends KeywordToken  {
	
	public DefCS_CommaKeyword_5_1_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDefCSAccess().getCommaKeyword_5_1_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_Group_5_1_1(parent, this, 0, inst);
			case 1: return new DefCS_ParametersAssignment_5_1_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// parameters+=parameterCS
protected class DefCS_ParametersAssignment_5_1_1_1 extends AssignmentToken  {
	
	public DefCS_ParametersAssignment_5_1_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDefCSAccess().getParametersAssignment_5_1_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ParameterCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("parameters",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("parameters");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getParameterCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getDefCSAccess().getParametersParameterCSParserRuleCall_5_1_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DefCS_CommaKeyword_5_1_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// ")"
protected class DefCS_RightParenthesisKeyword_5_2 extends KeywordToken  {
	
	public DefCS_RightParenthesisKeyword_5_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDefCSAccess().getRightParenthesisKeyword_5_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_Group_5_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}


// ":"
protected class DefCS_ColonKeyword_6 extends KeywordToken  {
	
	public DefCS_ColonKeyword_6(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDefCSAccess().getColonKeyword_6();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_Group_5(parent, this, 0, inst);
			case 1: return new DefCS_ConstrainedNameAssignment_4(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS?
protected class DefCS_TypeAssignment_7 extends AssignmentToken  {
	
	public DefCS_TypeAssignment_7(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDefCSAccess().getTypeAssignment_7();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getDefCSAccess().getTypeTypeCSParserRuleCall_7_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DefCS_ColonKeyword_6(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "="
protected class DefCS_EqualsSignKeyword_8 extends KeywordToken  {
	
	public DefCS_EqualsSignKeyword_8(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDefCSAccess().getEqualsSignKeyword_8();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_TypeAssignment_7(parent, this, 0, inst);
			case 1: return new DefCS_ColonKeyword_6(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// expression=OclExpressionCS
protected class DefCS_ExpressionAssignment_9 extends AssignmentToken  {
	
	public DefCS_ExpressionAssignment_9(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDefCSAccess().getExpressionAssignment_9();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("expression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getDefCSAccess().getExpressionOclExpressionCSParserRuleCall_9_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DefCS_EqualsSignKeyword_8(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule defCS ****************/


/************ begin Rule operationContextDeclCS ****************
 *
 * operationContextDeclCS returns OperationContextDeclCS:
 *   "context" contextName=pathNameCS "(" (parameters+=parameterCS ("," parameters+=
 *   parameterCS)*)? ")" ":" type=typeCS? (pres+=preCS|posts+=postCS|bodies+=bodyCS)*;
 *
 **/

// "context" contextName=pathNameCS "(" (parameters+=parameterCS ("," parameters+=
// parameterCS)*)? ")" ":" type=typeCS? (pres+=preCS|posts+=postCS|bodies+=bodyCS)*
protected class OperationContextDeclCS_Group extends GroupToken {
	
	public OperationContextDeclCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OperationContextDeclCS_Alternatives_7(parent, this, 0, inst);
			case 1: return new OperationContextDeclCS_TypeAssignment_6(parent, this, 1, inst);
			case 2: return new OperationContextDeclCS_ColonKeyword_5(parent, this, 2, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getOperationContextDeclCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "context"
protected class OperationContextDeclCS_ContextKeyword_0 extends KeywordToken  {
	
	public OperationContextDeclCS_ContextKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getContextKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// contextName=pathNameCS
protected class OperationContextDeclCS_ContextNameAssignment_1 extends AssignmentToken  {
	
	public OperationContextDeclCS_ContextNameAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getContextNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("contextName",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("contextName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPathNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOperationContextDeclCSAccess().getContextNamePathNameCSParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationContextDeclCS_ContextKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "("
protected class OperationContextDeclCS_LeftParenthesisKeyword_2 extends KeywordToken  {
	
	public OperationContextDeclCS_LeftParenthesisKeyword_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getLeftParenthesisKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OperationContextDeclCS_ContextNameAssignment_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// (parameters+=parameterCS ("," parameters+=parameterCS)*)?
protected class OperationContextDeclCS_Group_3 extends GroupToken {
	
	public OperationContextDeclCS_Group_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getGroup_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OperationContextDeclCS_Group_3_1(parent, this, 0, inst);
			case 1: return new OperationContextDeclCS_ParametersAssignment_3_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// parameters+=parameterCS
protected class OperationContextDeclCS_ParametersAssignment_3_0 extends AssignmentToken  {
	
	public OperationContextDeclCS_ParametersAssignment_3_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getParametersAssignment_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ParameterCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("parameters",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("parameters");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getParameterCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOperationContextDeclCSAccess().getParametersParameterCSParserRuleCall_3_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationContextDeclCS_LeftParenthesisKeyword_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," parameters+=parameterCS)*
protected class OperationContextDeclCS_Group_3_1 extends GroupToken {
	
	public OperationContextDeclCS_Group_3_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getGroup_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OperationContextDeclCS_ParametersAssignment_3_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class OperationContextDeclCS_CommaKeyword_3_1_0 extends KeywordToken  {
	
	public OperationContextDeclCS_CommaKeyword_3_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getCommaKeyword_3_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OperationContextDeclCS_Group_3_1(parent, this, 0, inst);
			case 1: return new OperationContextDeclCS_ParametersAssignment_3_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// parameters+=parameterCS
protected class OperationContextDeclCS_ParametersAssignment_3_1_1 extends AssignmentToken  {
	
	public OperationContextDeclCS_ParametersAssignment_3_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getParametersAssignment_3_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ParameterCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("parameters",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("parameters");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getParameterCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOperationContextDeclCSAccess().getParametersParameterCSParserRuleCall_3_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationContextDeclCS_CommaKeyword_3_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// ")"
protected class OperationContextDeclCS_RightParenthesisKeyword_4 extends KeywordToken  {
	
	public OperationContextDeclCS_RightParenthesisKeyword_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getRightParenthesisKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OperationContextDeclCS_Group_3(parent, this, 0, inst);
			case 1: return new OperationContextDeclCS_LeftParenthesisKeyword_2(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// ":"
protected class OperationContextDeclCS_ColonKeyword_5 extends KeywordToken  {
	
	public OperationContextDeclCS_ColonKeyword_5(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getColonKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OperationContextDeclCS_RightParenthesisKeyword_4(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS?
protected class OperationContextDeclCS_TypeAssignment_6 extends AssignmentToken  {
	
	public OperationContextDeclCS_TypeAssignment_6(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getTypeAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOperationContextDeclCSAccess().getTypeTypeCSParserRuleCall_6_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationContextDeclCS_ColonKeyword_5(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// (pres+=preCS|posts+=postCS|bodies+=bodyCS)*
protected class OperationContextDeclCS_Alternatives_7 extends AlternativesToken {

	public OperationContextDeclCS_Alternatives_7(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getAlternatives_7();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OperationContextDeclCS_PresAssignment_7_0(parent, this, 0, inst);
			case 1: return new OperationContextDeclCS_PostsAssignment_7_1(parent, this, 1, inst);
			case 2: return new OperationContextDeclCS_BodiesAssignment_7_2(parent, this, 2, inst);
			default: return null;
		}	
	}	
		
}

// pres+=preCS
protected class OperationContextDeclCS_PresAssignment_7_0 extends AssignmentToken  {
	
	public OperationContextDeclCS_PresAssignment_7_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getPresAssignment_7_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PreCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("pres",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("pres");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPreCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOperationContextDeclCSAccess().getPresPreCSParserRuleCall_7_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationContextDeclCS_Alternatives_7(parent, next, actIndex, consumed);
			case 1: return new OperationContextDeclCS_TypeAssignment_6(parent, next, actIndex, consumed);
			case 2: return new OperationContextDeclCS_ColonKeyword_5(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// posts+=postCS
protected class OperationContextDeclCS_PostsAssignment_7_1 extends AssignmentToken  {
	
	public OperationContextDeclCS_PostsAssignment_7_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getPostsAssignment_7_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PostCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("posts",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("posts");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPostCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOperationContextDeclCSAccess().getPostsPostCSParserRuleCall_7_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationContextDeclCS_Alternatives_7(parent, next, actIndex, consumed);
			case 1: return new OperationContextDeclCS_TypeAssignment_6(parent, next, actIndex, consumed);
			case 2: return new OperationContextDeclCS_ColonKeyword_5(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// bodies+=bodyCS
protected class OperationContextDeclCS_BodiesAssignment_7_2 extends AssignmentToken  {
	
	public OperationContextDeclCS_BodiesAssignment_7_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationContextDeclCSAccess().getBodiesAssignment_7_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new BodyCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("bodies",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("bodies");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBodyCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOperationContextDeclCSAccess().getBodiesBodyCSParserRuleCall_7_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationContextDeclCS_Alternatives_7(parent, next, actIndex, consumed);
			case 1: return new OperationContextDeclCS_TypeAssignment_6(parent, next, actIndex, consumed);
			case 2: return new OperationContextDeclCS_ColonKeyword_5(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule operationContextDeclCS ****************/


/************ begin Rule parameterCS ****************
 *
 * parameterCS returns essentialocl::VariableCS:
 *   name=simpleNameCS (":" type=typeCS)? ("=" initExpression=OclExpressionCS)?;
 *
 **/

// name=simpleNameCS (":" type=typeCS)? ("=" initExpression=OclExpressionCS)?
protected class ParameterCS_Group extends GroupToken {
	
	public ParameterCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getParameterCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ParameterCS_Group_2(parent, this, 0, inst);
			case 1: return new ParameterCS_Group_1(parent, this, 1, inst);
			case 2: return new ParameterCS_NameAssignment_0(parent, this, 2, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getParameterCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// name=simpleNameCS
protected class ParameterCS_NameAssignment_0 extends AssignmentToken  {
	
	public ParameterCS_NameAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getParameterCSAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("name",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getParameterCSAccess().getNameSimpleNameCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// (":" type=typeCS)?
protected class ParameterCS_Group_1 extends GroupToken {
	
	public ParameterCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getParameterCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ParameterCS_TypeAssignment_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ":"
protected class ParameterCS_ColonKeyword_1_0 extends KeywordToken  {
	
	public ParameterCS_ColonKeyword_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getParameterCSAccess().getColonKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ParameterCS_NameAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS
protected class ParameterCS_TypeAssignment_1_1 extends AssignmentToken  {
	
	public ParameterCS_TypeAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getParameterCSAccess().getTypeAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getParameterCSAccess().getTypeTypeCSParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ParameterCS_ColonKeyword_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// ("=" initExpression=OclExpressionCS)?
protected class ParameterCS_Group_2 extends GroupToken {
	
	public ParameterCS_Group_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getParameterCSAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ParameterCS_InitExpressionAssignment_2_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// "="
protected class ParameterCS_EqualsSignKeyword_2_0 extends KeywordToken  {
	
	public ParameterCS_EqualsSignKeyword_2_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getParameterCSAccess().getEqualsSignKeyword_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ParameterCS_Group_1(parent, this, 0, inst);
			case 1: return new ParameterCS_NameAssignment_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// initExpression=OclExpressionCS
protected class ParameterCS_InitExpressionAssignment_2_1 extends AssignmentToken  {
	
	public ParameterCS_InitExpressionAssignment_2_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getParameterCSAccess().getInitExpressionAssignment_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("initExpression",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("initExpression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getParameterCSAccess().getInitExpressionOclExpressionCSParserRuleCall_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ParameterCS_EqualsSignKeyword_2_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule parameterCS ****************/


/************ begin Rule preCS ****************
 *
 * preCS returns PreCS:
 *   "pre" constraintName=simpleNameCS? ":" expression=OclExpressionCS;
 *
 **/

// "pre" constraintName=simpleNameCS? ":" expression=OclExpressionCS
protected class PreCS_Group extends GroupToken {
	
	public PreCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPreCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PreCS_ExpressionAssignment_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getPreCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "pre"
protected class PreCS_PreKeyword_0 extends KeywordToken  {
	
	public PreCS_PreKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPreCSAccess().getPreKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// constraintName=simpleNameCS?
protected class PreCS_ConstraintNameAssignment_1 extends AssignmentToken  {
	
	public PreCS_ConstraintNameAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPreCSAccess().getConstraintNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("constraintName",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("constraintName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPreCSAccess().getConstraintNameSimpleNameCSParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PreCS_PreKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ":"
protected class PreCS_ColonKeyword_2 extends KeywordToken  {
	
	public PreCS_ColonKeyword_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPreCSAccess().getColonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PreCS_ConstraintNameAssignment_1(parent, this, 0, inst);
			case 1: return new PreCS_PreKeyword_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// expression=OclExpressionCS
protected class PreCS_ExpressionAssignment_3 extends AssignmentToken  {
	
	public PreCS_ExpressionAssignment_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPreCSAccess().getExpressionAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("expression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPreCSAccess().getExpressionOclExpressionCSParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PreCS_ColonKeyword_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule preCS ****************/


/************ begin Rule postCS ****************
 *
 * postCS returns PostCS:
 *   "post" constraintName=simpleNameCS? ":" expression=OclExpressionCS;
 *
 **/

// "post" constraintName=simpleNameCS? ":" expression=OclExpressionCS
protected class PostCS_Group extends GroupToken {
	
	public PostCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPostCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PostCS_ExpressionAssignment_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getPostCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "post"
protected class PostCS_PostKeyword_0 extends KeywordToken  {
	
	public PostCS_PostKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPostCSAccess().getPostKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// constraintName=simpleNameCS?
protected class PostCS_ConstraintNameAssignment_1 extends AssignmentToken  {
	
	public PostCS_ConstraintNameAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPostCSAccess().getConstraintNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("constraintName",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("constraintName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPostCSAccess().getConstraintNameSimpleNameCSParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PostCS_PostKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ":"
protected class PostCS_ColonKeyword_2 extends KeywordToken  {
	
	public PostCS_ColonKeyword_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPostCSAccess().getColonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PostCS_ConstraintNameAssignment_1(parent, this, 0, inst);
			case 1: return new PostCS_PostKeyword_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// expression=OclExpressionCS
protected class PostCS_ExpressionAssignment_3 extends AssignmentToken  {
	
	public PostCS_ExpressionAssignment_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPostCSAccess().getExpressionAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("expression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPostCSAccess().getExpressionOclExpressionCSParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PostCS_ColonKeyword_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule postCS ****************/


/************ begin Rule bodyCS ****************
 *
 * bodyCS returns BodyCS:
 *   "body" constraintName=simpleNameCS? ":" expression=OclExpressionCS;
 *
 **/

// "body" constraintName=simpleNameCS? ":" expression=OclExpressionCS
protected class BodyCS_Group extends GroupToken {
	
	public BodyCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getBodyCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new BodyCS_ExpressionAssignment_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getBodyCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "body"
protected class BodyCS_BodyKeyword_0 extends KeywordToken  {
	
	public BodyCS_BodyKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getBodyCSAccess().getBodyKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// constraintName=simpleNameCS?
protected class BodyCS_ConstraintNameAssignment_1 extends AssignmentToken  {
	
	public BodyCS_ConstraintNameAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getBodyCSAccess().getConstraintNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("constraintName",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("constraintName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getBodyCSAccess().getConstraintNameSimpleNameCSParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new BodyCS_BodyKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ":"
protected class BodyCS_ColonKeyword_2 extends KeywordToken  {
	
	public BodyCS_ColonKeyword_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getBodyCSAccess().getColonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new BodyCS_ConstraintNameAssignment_1(parent, this, 0, inst);
			case 1: return new BodyCS_BodyKeyword_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// expression=OclExpressionCS
protected class BodyCS_ExpressionAssignment_3 extends AssignmentToken  {
	
	public BodyCS_ExpressionAssignment_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getBodyCSAccess().getExpressionAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("expression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getBodyCSAccess().getExpressionOclExpressionCSParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new BodyCS_ColonKeyword_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule bodyCS ****************/


/************ begin Rule constraintCS ****************
 *
 * constraintCS returns ConstraintCS:
 *   initCS|derCS|namedConstraintCS;
 *
 **/

// initCS|derCS|namedConstraintCS
protected class ConstraintCS_Alternatives extends AlternativesToken {

	public ConstraintCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getConstraintCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ConstraintCS_InitCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new ConstraintCS_DerCSParserRuleCall_1(parent, this, 1, inst);
			case 2: return new ConstraintCS_NamedConstraintCSParserRuleCall_2(parent, this, 2, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getConstraintCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// initCS
protected class ConstraintCS_InitCSParserRuleCall_0 extends RuleCallToken {
	
	public ConstraintCS_InitCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getConstraintCSAccess().getInitCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InitCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(InitCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getInitCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// derCS
protected class ConstraintCS_DerCSParserRuleCall_1 extends RuleCallToken {
	
	public ConstraintCS_DerCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getConstraintCSAccess().getDerCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DerCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(DerCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getDerCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// namedConstraintCS
protected class ConstraintCS_NamedConstraintCSParserRuleCall_2 extends RuleCallToken {
	
	public ConstraintCS_NamedConstraintCSParserRuleCall_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getConstraintCSAccess().getNamedConstraintCSParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new NamedConstraintCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(NamedConstraintCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getNamedConstraintCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule constraintCS ****************/


/************ begin Rule namedConstraintCS ****************
 *
 * namedConstraintCS returns NamedConstraintCS:
 *   bodyCS|defCS|invCS|postCS|preCS;
 *
 **/

// bodyCS|defCS|invCS|postCS|preCS
protected class NamedConstraintCS_Alternatives extends AlternativesToken {

	public NamedConstraintCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getNamedConstraintCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new NamedConstraintCS_BodyCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new NamedConstraintCS_DefCSParserRuleCall_1(parent, this, 1, inst);
			case 2: return new NamedConstraintCS_InvCSParserRuleCall_2(parent, this, 2, inst);
			case 3: return new NamedConstraintCS_PostCSParserRuleCall_3(parent, this, 3, inst);
			case 4: return new NamedConstraintCS_PreCSParserRuleCall_4(parent, this, 4, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getNamedConstraintCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// bodyCS
protected class NamedConstraintCS_BodyCSParserRuleCall_0 extends RuleCallToken {
	
	public NamedConstraintCS_BodyCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNamedConstraintCSAccess().getBodyCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new BodyCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(BodyCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getBodyCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// defCS
protected class NamedConstraintCS_DefCSParserRuleCall_1 extends RuleCallToken {
	
	public NamedConstraintCS_DefCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNamedConstraintCSAccess().getDefCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new DefCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(DefCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getDefCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// invCS
protected class NamedConstraintCS_InvCSParserRuleCall_2 extends RuleCallToken {
	
	public NamedConstraintCS_InvCSParserRuleCall_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNamedConstraintCSAccess().getInvCSParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InvCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(InvCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getInvCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// postCS
protected class NamedConstraintCS_PostCSParserRuleCall_3 extends RuleCallToken {
	
	public NamedConstraintCS_PostCSParserRuleCall_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNamedConstraintCSAccess().getPostCSParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PostCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PostCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPostCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// preCS
protected class NamedConstraintCS_PreCSParserRuleCall_4 extends RuleCallToken {
	
	public NamedConstraintCS_PreCSParserRuleCall_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNamedConstraintCSAccess().getPreCSParserRuleCall_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PreCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PreCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPreCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule namedConstraintCS ****************/


/************ begin Rule extendedPrimaryExpCS ****************
 *
 * extendedPrimaryExpCS returns essentialocl::OclExpressionCS:
 *   primaryExpCS|OclMessageExpCS; 
 * 
 *     
 * 	
 * 	  	 // OclExpressionCS[E]
 *
 **/

// primaryExpCS|OclMessageExpCS 
// 
//     
// 	
// 	  	 // OclExpressionCS[E]
protected class ExtendedPrimaryExpCS_Alternatives extends AlternativesToken {

	public ExtendedPrimaryExpCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getExtendedPrimaryExpCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ExtendedPrimaryExpCS_PrimaryExpCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new ExtendedPrimaryExpCS_OclMessageExpCSParserRuleCall_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getExtendedPrimaryExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// primaryExpCS
protected class ExtendedPrimaryExpCS_PrimaryExpCSParserRuleCall_0 extends RuleCallToken {
	
	public ExtendedPrimaryExpCS_PrimaryExpCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getExtendedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimaryExpCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PrimaryExpCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPrimaryExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// OclMessageExpCS 	  	 // OclExpressionCS[E]
protected class ExtendedPrimaryExpCS_OclMessageExpCSParserRuleCall_1 extends RuleCallToken {
	
	public ExtendedPrimaryExpCS_OclMessageExpCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getExtendedPrimaryExpCSAccess().getOclMessageExpCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageExpCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(OclMessageExpCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getOclMessageExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule extendedPrimaryExpCS ****************/


/************ begin Rule OclMessageExpCS ****************
 *
 * OclMessageExpCS returns OclMessageCS:
 *   source=primaryExpCS op=( "^^" | "^" ) messageName=simpleNameCS "(" (arguments+=
 *   OclMessageArgCS ("," arguments+=OclMessageArgCS)*)? ")";
 *
 **/

// source=primaryExpCS op=( "^^" | "^" ) messageName=simpleNameCS "(" (arguments+=
// OclMessageArgCS ("," arguments+=OclMessageArgCS)*)? ")"
protected class OclMessageExpCS_Group extends GroupToken {
	
	public OclMessageExpCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageExpCS_RightParenthesisKeyword_5(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getOclMessageExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// source=primaryExpCS
protected class OclMessageExpCS_SourceAssignment_0 extends AssignmentToken  {
	
	public OclMessageExpCS_SourceAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getSourceAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimaryExpCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("source",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("source");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPrimaryExpCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOclMessageExpCSAccess().getSourcePrimaryExpCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// op=( "^^" | "^" )
protected class OclMessageExpCS_OpAssignment_1 extends AssignmentToken  {
	
	public OclMessageExpCS_OpAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getOpAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageExpCS_SourceAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if("^^".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getOclMessageExpCSAccess().getOpCircumflexAccentCircumflexAccentKeyword_1_0_0();
			return obj;
		}
		if("^".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getOclMessageExpCSAccess().getOpCircumflexAccentKeyword_1_0_1();
			return obj;
		}
		return null;
	}

}

// messageName=simpleNameCS
protected class OclMessageExpCS_MessageNameAssignment_2 extends AssignmentToken  {
	
	public OclMessageExpCS_MessageNameAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getMessageNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("messageName",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("messageName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOclMessageExpCSAccess().getMessageNameSimpleNameCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OclMessageExpCS_OpAssignment_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "("
protected class OclMessageExpCS_LeftParenthesisKeyword_3 extends KeywordToken  {
	
	public OclMessageExpCS_LeftParenthesisKeyword_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getLeftParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageExpCS_MessageNameAssignment_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// (arguments+=OclMessageArgCS ("," arguments+=OclMessageArgCS)*)?
protected class OclMessageExpCS_Group_4 extends GroupToken {
	
	public OclMessageExpCS_Group_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getGroup_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageExpCS_Group_4_1(parent, this, 0, inst);
			case 1: return new OclMessageExpCS_ArgumentsAssignment_4_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// arguments+=OclMessageArgCS
protected class OclMessageExpCS_ArgumentsAssignment_4_0 extends AssignmentToken  {
	
	public OclMessageExpCS_ArgumentsAssignment_4_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getArgumentsAssignment_4_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageArgCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("arguments",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("arguments");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclMessageArgCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOclMessageExpCSAccess().getArgumentsOclMessageArgCSParserRuleCall_4_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OclMessageExpCS_LeftParenthesisKeyword_3(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," arguments+=OclMessageArgCS)*
protected class OclMessageExpCS_Group_4_1 extends GroupToken {
	
	public OclMessageExpCS_Group_4_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getGroup_4_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageExpCS_ArgumentsAssignment_4_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class OclMessageExpCS_CommaKeyword_4_1_0 extends KeywordToken  {
	
	public OclMessageExpCS_CommaKeyword_4_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getCommaKeyword_4_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageExpCS_Group_4_1(parent, this, 0, inst);
			case 1: return new OclMessageExpCS_ArgumentsAssignment_4_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// arguments+=OclMessageArgCS
protected class OclMessageExpCS_ArgumentsAssignment_4_1_1 extends AssignmentToken  {
	
	public OclMessageExpCS_ArgumentsAssignment_4_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getArgumentsAssignment_4_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageArgCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("arguments",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("arguments");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclMessageArgCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOclMessageExpCSAccess().getArgumentsOclMessageArgCSParserRuleCall_4_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OclMessageExpCS_CommaKeyword_4_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// ")"
protected class OclMessageExpCS_RightParenthesisKeyword_5 extends KeywordToken  {
	
	public OclMessageExpCS_RightParenthesisKeyword_5(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOclMessageExpCSAccess().getRightParenthesisKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageExpCS_Group_4(parent, this, 0, inst);
			case 1: return new OclMessageExpCS_LeftParenthesisKeyword_3(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule OclMessageExpCS ****************/


/************ begin Rule OclMessageArgCS ****************
 *
 * OclMessageArgCS returns essentialocl::OclExpressionCS:
 *   {OclMessageArgCS} "?" (":" type=typeCS)?|OclExpressionCS;
 *
 **/

// {OclMessageArgCS} "?" (":" type=typeCS)?|OclExpressionCS
protected class OclMessageArgCS_Alternatives extends AlternativesToken {

	public OclMessageArgCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getOclMessageArgCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageArgCS_Group_0(parent, this, 0, inst);
			case 1: return new OclMessageArgCS_OclExpressionCSParserRuleCall_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getOclMessageArgCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// {OclMessageArgCS} "?" (":" type=typeCS)?
protected class OclMessageArgCS_Group_0 extends GroupToken {
	
	public OclMessageArgCS_Group_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOclMessageArgCSAccess().getGroup_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageArgCS_Group_0_2(parent, this, 0, inst);
			case 1: return new OclMessageArgCS_QuestionMarkKeyword_0_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// {OclMessageArgCS}
protected class OclMessageArgCS_OclMessageArgCSAction_0_0 extends ActionToken  {

	public OclMessageArgCS_OclMessageArgCSAction_0_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getOclMessageArgCSAccess().getOclMessageArgCSAction_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getOclMessageArgCSAccess().getOclMessageArgCSAction_0_0().getType().getClassifier())) return null;
		if(!current.isConsumed()) return null;
		return current;
	}
}

// "?"
protected class OclMessageArgCS_QuestionMarkKeyword_0_1 extends KeywordToken  {
	
	public OclMessageArgCS_QuestionMarkKeyword_0_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOclMessageArgCSAccess().getQuestionMarkKeyword_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageArgCS_OclMessageArgCSAction_0_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// (":" type=typeCS)?
protected class OclMessageArgCS_Group_0_2 extends GroupToken {
	
	public OclMessageArgCS_Group_0_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOclMessageArgCSAccess().getGroup_0_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageArgCS_TypeAssignment_0_2_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ":"
protected class OclMessageArgCS_ColonKeyword_0_2_0 extends KeywordToken  {
	
	public OclMessageArgCS_ColonKeyword_0_2_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOclMessageArgCSAccess().getColonKeyword_0_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclMessageArgCS_QuestionMarkKeyword_0_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS
protected class OclMessageArgCS_TypeAssignment_0_2_1 extends AssignmentToken  {
	
	public OclMessageArgCS_TypeAssignment_0_2_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOclMessageArgCSAccess().getTypeAssignment_0_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOclMessageArgCSAccess().getTypeTypeCSParserRuleCall_0_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OclMessageArgCS_ColonKeyword_0_2_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// OclExpressionCS
protected class OclMessageArgCS_OclExpressionCSParserRuleCall_1 extends RuleCallToken {
	
	public OclMessageArgCS_OclExpressionCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getOclMessageArgCSAccess().getOclExpressionCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(OclExpressionCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule OclMessageArgCS ****************/




/************ begin Rule tupleKeywordCS ****************
 *
 * tupleKeywordCS returns SimpleNameCS:
 *   value="Tuple"; 
 * 	
 * //---------------------------------------------------------------------
 * //  Names
 * //---------------------------------------------------------------------
 * / *  Temporary backward compatibility support for 7.4.8 conceptual usage 
 *     conceptualOperationName returns SimpleNameCS:
 *     	value='and'
 *     	| value='implies'
 *     	| value='not'
 *     	| value='or'
 *     	| value='xor'
 *     	| value='<'
 *     	| value='<='
 *     	| value='>='
 *     	| value='>'
 *     	| value='='
 *     	| value='<>'
 *     	| value='+'
 *     	| value='-'
 *     	| value='*'
 *     	| value='/';
 *     conceptualOperationNameCS returns SimpleNameCS:
 *     	conceptualOperationName; * /
 *     
 * / *    reservedKeyword returns SimpleNameCS: 
 *     	value='and'
 *     	| value='else'
 *     	| value='endif'
 *     	| value='if'
 *     	| value='implies'
 *     	| value='in'
 *     	| value='let'
 *     	| value='not'
 *     	| value='or'
 *     	| value='then'
 *     	| value='xor'; * /
 * 
 *         
 *     	
 *     
 * //    reservedKeywordCS returns SimpleNameCS:
 * //    	reservedKeyword;
 *
 **/

// value="Tuple"
protected class TupleKeywordCS_ValueAssignment extends AssignmentToken  {
	
	public TupleKeywordCS_ValueAssignment(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleKeywordCSAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTupleKeywordCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("Tuple".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getTupleKeywordCSAccess().getValueTupleKeyword_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule tupleKeywordCS ****************/


/************ begin Rule restrictedKeywordCS ****************
 *
 * restrictedKeywordCS returns SimpleNameCS:
 *   CollectionTypeIdentifierCS|primitiveTypeCS|tupleKeywordCS; 
 *     
 * //    reservedKeywordCS returns SimpleNameCS:
 * //    	reservedKeyword;
 *     
 *          
 *     	
 * //  restrictedKeywordCS -> BooleanLiteralExpCS
 * //  restrictedKeywordCS -> InvalidLiteralExpCS
 * //  restrictedKeywordCS -> NullLiteralExpCS
 * //-  restrictedKeywordCS -> selfKeywordCS
 *
 **/

// CollectionTypeIdentifierCS|primitiveTypeCS|tupleKeywordCS 
//     
// //    reservedKeywordCS returns SimpleNameCS:
// //    	reservedKeyword;
//     
//          
//     	
// //  restrictedKeywordCS -> BooleanLiteralExpCS
// //  restrictedKeywordCS -> InvalidLiteralExpCS
// //  restrictedKeywordCS -> NullLiteralExpCS
// //-  restrictedKeywordCS -> selfKeywordCS
protected class RestrictedKeywordCS_Alternatives extends AlternativesToken {

	public RestrictedKeywordCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getRestrictedKeywordCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new RestrictedKeywordCS_CollectionTypeIdentifierCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new RestrictedKeywordCS_PrimitiveTypeCSParserRuleCall_1(parent, this, 1, inst);
			case 2: return new RestrictedKeywordCS_TupleKeywordCSParserRuleCall_2(parent, this, 2, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getRestrictedKeywordCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// CollectionTypeIdentifierCS  
//     	
// //  restrictedKeywordCS -> BooleanLiteralExpCS
// //  restrictedKeywordCS -> InvalidLiteralExpCS
// //  restrictedKeywordCS -> NullLiteralExpCS
// //-  restrictedKeywordCS -> selfKeywordCS
protected class RestrictedKeywordCS_CollectionTypeIdentifierCSParserRuleCall_0 extends RuleCallToken {
	
	public RestrictedKeywordCS_CollectionTypeIdentifierCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getRestrictedKeywordCSAccess().getCollectionTypeIdentifierCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeIdentifierCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(CollectionTypeIdentifierCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getCollectionTypeIdentifierCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// primitiveTypeCS
protected class RestrictedKeywordCS_PrimitiveTypeCSParserRuleCall_1 extends RuleCallToken {
	
	public RestrictedKeywordCS_PrimitiveTypeCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getRestrictedKeywordCSAccess().getPrimitiveTypeCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimitiveTypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PrimitiveTypeCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// tupleKeywordCS
protected class RestrictedKeywordCS_TupleKeywordCSParserRuleCall_2 extends RuleCallToken {
	
	public RestrictedKeywordCS_TupleKeywordCSParserRuleCall_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getRestrictedKeywordCSAccess().getTupleKeywordCSParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleKeywordCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(TupleKeywordCS_ValueAssignment.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getTupleKeywordCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule restrictedKeywordCS ****************/


/************ begin Rule selfKeywordCS ****************
 *
 * selfKeywordCS returns SimpleNameCS:
 *   value="self";
 *
 **/

// value="self"
protected class SelfKeywordCS_ValueAssignment extends AssignmentToken  {
	
	public SelfKeywordCS_ValueAssignment(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSelfKeywordCSAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getSelfKeywordCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("self".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getSelfKeywordCSAccess().getValueSelfKeyword_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule selfKeywordCS ****************/


/************ begin Rule simpleNameCS ****************
 *
 * simpleNameCS returns SimpleNameCS:
 *   value=ID;
 *
 **/

// value=ID
protected class SimpleNameCS_ValueAssignment extends AssignmentToken  {
	
	public SimpleNameCS_ValueAssignment(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSimpleNameCSAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(Boolean.TRUE.booleanValue()) { 
			type = AssignmentType.LRC;
			element = grammarAccess.getSimpleNameCSAccess().getValueIDTerminalRuleCall_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule simpleNameCS ****************/


/************ begin Rule unreservedSimpleNameCS ****************
 *
 * unreservedSimpleNameCS returns SimpleNameCS:
 *   simpleNameCS|restrictedKeywordCS;
 *
 **/

// simpleNameCS|restrictedKeywordCS
protected class UnreservedSimpleNameCS_Alternatives extends AlternativesToken {

	public UnreservedSimpleNameCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getUnreservedSimpleNameCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnreservedSimpleNameCS_SimpleNameCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new UnreservedSimpleNameCS_RestrictedKeywordCSParserRuleCall_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getUnreservedSimpleNameCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// simpleNameCS
protected class UnreservedSimpleNameCS_SimpleNameCSParserRuleCall_0 extends RuleCallToken {
	
	public UnreservedSimpleNameCS_SimpleNameCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getUnreservedSimpleNameCSAccess().getSimpleNameCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(SimpleNameCS_ValueAssignment.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// restrictedKeywordCS
protected class UnreservedSimpleNameCS_RestrictedKeywordCSParserRuleCall_1 extends RuleCallToken {
	
	public UnreservedSimpleNameCS_RestrictedKeywordCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getUnreservedSimpleNameCSAccess().getRestrictedKeywordCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new RestrictedKeywordCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(RestrictedKeywordCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getRestrictedKeywordCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule unreservedSimpleNameCS ****************/


/************ begin Rule pathNameCS ****************
 *
 * pathNameCS returns PathNameCS:
 *   simpleNames+=simpleNameCS ("::" simpleNames+=unreservedSimpleNameCS)*; 
 * 
 *         
 *     	    
 * 
 *         
 * //---------------------------------------------------------------------
 * //  Types
 * //---------------------------------------------------------------------
 *
 **/

// simpleNames+=simpleNameCS ("::" simpleNames+=unreservedSimpleNameCS)*
protected class PathNameCS_Group extends GroupToken {
	
	public PathNameCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPathNameCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group_1(parent, this, 0, inst);
			case 1: return new PathNameCS_SimpleNamesAssignment_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getPathNameCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// simpleNames+=simpleNameCS
protected class PathNameCS_SimpleNamesAssignment_0 extends AssignmentToken  {
	
	public PathNameCS_SimpleNamesAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPathNameCSAccess().getSimpleNamesAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("simpleNames",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("simpleNames");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPathNameCSAccess().getSimpleNamesSimpleNameCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// ("::" simpleNames+=unreservedSimpleNameCS)*
protected class PathNameCS_Group_1 extends GroupToken {
	
	public PathNameCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPathNameCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_SimpleNamesAssignment_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// "::"
protected class PathNameCS_ColonColonKeyword_1_0 extends KeywordToken  {
	
	public PathNameCS_ColonColonKeyword_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group_1(parent, this, 0, inst);
			case 1: return new PathNameCS_SimpleNamesAssignment_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// simpleNames+=unreservedSimpleNameCS
protected class PathNameCS_SimpleNamesAssignment_1_1 extends AssignmentToken  {
	
	public PathNameCS_SimpleNamesAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPathNameCSAccess().getSimpleNamesAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnreservedSimpleNameCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("simpleNames",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("simpleNames");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getUnreservedSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getPathNameCSAccess().getSimpleNamesUnreservedSimpleNameCSParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PathNameCS_ColonColonKeyword_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule pathNameCS ****************/


/************ begin Rule primitiveTypeCS ****************
 *
 * primitiveTypeCS returns SimpleNameCS:
 *   value="Boolean"|value="Integer"|value="Real"|value="String"|value=
 *   "UnlimitedNatural"|value="OclAny"|value="OclInvalid"|value="OclVoid"; 
 * 
 *         
 * //---------------------------------------------------------------------
 * //  Types
 * //---------------------------------------------------------------------
 *
 **/

// value="Boolean"|value="Integer"|value="Real"|value="String"|value=
// "UnlimitedNatural"|value="OclAny"|value="OclInvalid"|value="OclVoid" 
// 
//         
// //---------------------------------------------------------------------
// //  Types
// //---------------------------------------------------------------------
protected class PrimitiveTypeCS_Alternatives extends AlternativesToken {

	public PrimitiveTypeCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getPrimitiveTypeCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimitiveTypeCS_ValueAssignment_0(parent, this, 0, inst);
			case 1: return new PrimitiveTypeCS_ValueAssignment_1(parent, this, 1, inst);
			case 2: return new PrimitiveTypeCS_ValueAssignment_2(parent, this, 2, inst);
			case 3: return new PrimitiveTypeCS_ValueAssignment_3(parent, this, 3, inst);
			case 4: return new PrimitiveTypeCS_ValueAssignment_4(parent, this, 4, inst);
			case 5: return new PrimitiveTypeCS_ValueAssignment_5(parent, this, 5, inst);
			case 6: return new PrimitiveTypeCS_ValueAssignment_6(parent, this, 6, inst);
			case 7: return new PrimitiveTypeCS_ValueAssignment_7(parent, this, 7, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// value="Boolean"
protected class PrimitiveTypeCS_ValueAssignment_0 extends AssignmentToken  {
	
	public PrimitiveTypeCS_ValueAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("Boolean".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getPrimitiveTypeCSAccess().getValueBooleanKeyword_0_0();
			return obj;
		}
		return null;
	}

}

// value="Integer"
protected class PrimitiveTypeCS_ValueAssignment_1 extends AssignmentToken  {
	
	public PrimitiveTypeCS_ValueAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("Integer".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getPrimitiveTypeCSAccess().getValueIntegerKeyword_1_0();
			return obj;
		}
		return null;
	}

}

// value="Real"
protected class PrimitiveTypeCS_ValueAssignment_2 extends AssignmentToken  {
	
	public PrimitiveTypeCS_ValueAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("Real".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getPrimitiveTypeCSAccess().getValueRealKeyword_2_0();
			return obj;
		}
		return null;
	}

}

// value="String"
protected class PrimitiveTypeCS_ValueAssignment_3 extends AssignmentToken  {
	
	public PrimitiveTypeCS_ValueAssignment_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("String".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getPrimitiveTypeCSAccess().getValueStringKeyword_3_0();
			return obj;
		}
		return null;
	}

}

// value="UnlimitedNatural"
protected class PrimitiveTypeCS_ValueAssignment_4 extends AssignmentToken  {
	
	public PrimitiveTypeCS_ValueAssignment_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("UnlimitedNatural".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getPrimitiveTypeCSAccess().getValueUnlimitedNaturalKeyword_4_0();
			return obj;
		}
		return null;
	}

}

// value="OclAny"
protected class PrimitiveTypeCS_ValueAssignment_5 extends AssignmentToken  {
	
	public PrimitiveTypeCS_ValueAssignment_5(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_5();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("OclAny".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getPrimitiveTypeCSAccess().getValueOclAnyKeyword_5_0();
			return obj;
		}
		return null;
	}

}

// value="OclInvalid"
protected class PrimitiveTypeCS_ValueAssignment_6 extends AssignmentToken  {
	
	public PrimitiveTypeCS_ValueAssignment_6(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("OclInvalid".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getPrimitiveTypeCSAccess().getValueOclInvalidKeyword_6_0();
			return obj;
		}
		return null;
	}

}

// value="OclVoid"
protected class PrimitiveTypeCS_ValueAssignment_7 extends AssignmentToken  {
	
	public PrimitiveTypeCS_ValueAssignment_7(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPrimitiveTypeCSAccess().getValueAssignment_7();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("OclVoid".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getPrimitiveTypeCSAccess().getValueOclVoidKeyword_7_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule primitiveTypeCS ****************/


/************ begin Rule CollectionTypeIdentifierCS ****************
 *
 * CollectionTypeIdentifierCS returns SimpleNameCS:
 *   value="Set"|value="Bag"|value="Sequence"|value="Collection"|value="OrderedSet";
 *
 **/

// value="Set"|value="Bag"|value="Sequence"|value="Collection"|value="OrderedSet"
protected class CollectionTypeIdentifierCS_Alternatives extends AlternativesToken {

	public CollectionTypeIdentifierCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getCollectionTypeIdentifierCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeIdentifierCS_ValueAssignment_0(parent, this, 0, inst);
			case 1: return new CollectionTypeIdentifierCS_ValueAssignment_1(parent, this, 1, inst);
			case 2: return new CollectionTypeIdentifierCS_ValueAssignment_2(parent, this, 2, inst);
			case 3: return new CollectionTypeIdentifierCS_ValueAssignment_3(parent, this, 3, inst);
			case 4: return new CollectionTypeIdentifierCS_ValueAssignment_4(parent, this, 4, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getCollectionTypeIdentifierCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// value="Set"
protected class CollectionTypeIdentifierCS_ValueAssignment_0 extends AssignmentToken  {
	
	public CollectionTypeIdentifierCS_ValueAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("Set".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getCollectionTypeIdentifierCSAccess().getValueSetKeyword_0_0();
			return obj;
		}
		return null;
	}

}

// value="Bag"
protected class CollectionTypeIdentifierCS_ValueAssignment_1 extends AssignmentToken  {
	
	public CollectionTypeIdentifierCS_ValueAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("Bag".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getCollectionTypeIdentifierCSAccess().getValueBagKeyword_1_0();
			return obj;
		}
		return null;
	}

}

// value="Sequence"
protected class CollectionTypeIdentifierCS_ValueAssignment_2 extends AssignmentToken  {
	
	public CollectionTypeIdentifierCS_ValueAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("Sequence".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getCollectionTypeIdentifierCSAccess().getValueSequenceKeyword_2_0();
			return obj;
		}
		return null;
	}

}

// value="Collection"
protected class CollectionTypeIdentifierCS_ValueAssignment_3 extends AssignmentToken  {
	
	public CollectionTypeIdentifierCS_ValueAssignment_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("Collection".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getCollectionTypeIdentifierCSAccess().getValueCollectionKeyword_3_0();
			return obj;
		}
		return null;
	}

}

// value="OrderedSet"
protected class CollectionTypeIdentifierCS_ValueAssignment_4 extends AssignmentToken  {
	
	public CollectionTypeIdentifierCS_ValueAssignment_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionTypeIdentifierCSAccess().getValueAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("OrderedSet".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getCollectionTypeIdentifierCSAccess().getValueOrderedSetKeyword_4_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule CollectionTypeIdentifierCS ****************/


/************ begin Rule typeCS ****************
 *
 * typeCS returns TypeCS:
 *   primitiveTypeCS|pathNameCS|collectionTypeCS|tupleTypeCS;
 *
 **/

// primitiveTypeCS|pathNameCS|collectionTypeCS|tupleTypeCS
protected class TypeCS_Alternatives extends AlternativesToken {

	public TypeCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getTypeCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_PrimitiveTypeCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new TypeCS_PathNameCSParserRuleCall_1(parent, this, 1, inst);
			case 2: return new TypeCS_CollectionTypeCSParserRuleCall_2(parent, this, 2, inst);
			case 3: return new TypeCS_TupleTypeCSParserRuleCall_3(parent, this, 3, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// primitiveTypeCS
protected class TypeCS_PrimitiveTypeCSParserRuleCall_0 extends RuleCallToken {
	
	public TypeCS_PrimitiveTypeCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTypeCSAccess().getPrimitiveTypeCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimitiveTypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PrimitiveTypeCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// pathNameCS
protected class TypeCS_PathNameCSParserRuleCall_1 extends RuleCallToken {
	
	public TypeCS_PathNameCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTypeCSAccess().getPathNameCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PathNameCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPathNameCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// collectionTypeCS
protected class TypeCS_CollectionTypeCSParserRuleCall_2 extends RuleCallToken {
	
	public TypeCS_CollectionTypeCSParserRuleCall_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTypeCSAccess().getCollectionTypeCSParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(CollectionTypeCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getCollectionTypeCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// tupleTypeCS
protected class TypeCS_TupleTypeCSParserRuleCall_3 extends RuleCallToken {
	
	public TypeCS_TupleTypeCSParserRuleCall_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTypeCSAccess().getTupleTypeCSParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleTypeCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(TupleTypeCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getTupleTypeCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule typeCS ****************/


/************ begin Rule collectionTypeCS ****************
 *
 * collectionTypeCS returns CollectionTypeCS:
 *   value=CollectionTypeIdentifierCS "(" typeCS=typeCS ")";
 *
 **/

// value=CollectionTypeIdentifierCS "(" typeCS=typeCS ")"
protected class CollectionTypeCS_Group extends GroupToken {
	
	public CollectionTypeCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCollectionTypeCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeCS_RightParenthesisKeyword_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getCollectionTypeCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// value=CollectionTypeIdentifierCS
protected class CollectionTypeCS_ValueAssignment_0 extends AssignmentToken  {
	
	public CollectionTypeCS_ValueAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionTypeCSAccess().getValueAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeIdentifierCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getCollectionTypeIdentifierCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCollectionTypeCSAccess().getValueCollectionTypeIdentifierCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// "("
protected class CollectionTypeCS_LeftParenthesisKeyword_1 extends KeywordToken  {
	
	public CollectionTypeCS_LeftParenthesisKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeCS_ValueAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// typeCS=typeCS
protected class CollectionTypeCS_TypeCSAssignment_2 extends AssignmentToken  {
	
	public CollectionTypeCS_TypeCSAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionTypeCSAccess().getTypeCSAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("typeCS",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("typeCS");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCollectionTypeCSAccess().getTypeCSTypeCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CollectionTypeCS_LeftParenthesisKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class CollectionTypeCS_RightParenthesisKeyword_3 extends KeywordToken  {
	
	public CollectionTypeCS_RightParenthesisKeyword_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeCS_TypeCSAssignment_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule collectionTypeCS ****************/


/************ begin Rule tupleTypeCS ****************
 *
 * tupleTypeCS returns TupleTypeCS:
 *   value="Tuple" "(" (part+=tuplePartCS ("," part+=tuplePartCS)*)? ")";
 *
 **/

// value="Tuple" "(" (part+=tuplePartCS ("," part+=tuplePartCS)*)? ")"
protected class TupleTypeCS_Group extends GroupToken {
	
	public TupleTypeCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleTypeCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleTypeCS_RightParenthesisKeyword_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTupleTypeCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// value="Tuple"
protected class TupleTypeCS_ValueAssignment_0 extends AssignmentToken  {
	
	public TupleTypeCS_ValueAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleTypeCSAccess().getValueAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("Tuple".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getTupleTypeCSAccess().getValueTupleKeyword_0_0();
			return obj;
		}
		return null;
	}

}

// "("
protected class TupleTypeCS_LeftParenthesisKeyword_1 extends KeywordToken  {
	
	public TupleTypeCS_LeftParenthesisKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleTypeCS_ValueAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// (part+=tuplePartCS ("," part+=tuplePartCS)*)?
protected class TupleTypeCS_Group_2 extends GroupToken {
	
	public TupleTypeCS_Group_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleTypeCSAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleTypeCS_Group_2_1(parent, this, 0, inst);
			case 1: return new TupleTypeCS_PartAssignment_2_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// part+=tuplePartCS
protected class TupleTypeCS_PartAssignment_2_0 extends AssignmentToken  {
	
	public TupleTypeCS_PartAssignment_2_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleTypeCSAccess().getPartAssignment_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TuplePartCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("part",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("part");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTuplePartCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTupleTypeCSAccess().getPartTuplePartCSParserRuleCall_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TupleTypeCS_LeftParenthesisKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," part+=tuplePartCS)*
protected class TupleTypeCS_Group_2_1 extends GroupToken {
	
	public TupleTypeCS_Group_2_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleTypeCSAccess().getGroup_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleTypeCS_PartAssignment_2_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class TupleTypeCS_CommaKeyword_2_1_0 extends KeywordToken  {
	
	public TupleTypeCS_CommaKeyword_2_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleTypeCSAccess().getCommaKeyword_2_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleTypeCS_Group_2_1(parent, this, 0, inst);
			case 1: return new TupleTypeCS_PartAssignment_2_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// part+=tuplePartCS
protected class TupleTypeCS_PartAssignment_2_1_1 extends AssignmentToken  {
	
	public TupleTypeCS_PartAssignment_2_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleTypeCSAccess().getPartAssignment_2_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TuplePartCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("part",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("part");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTuplePartCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTupleTypeCSAccess().getPartTuplePartCSParserRuleCall_2_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TupleTypeCS_CommaKeyword_2_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// ")"
protected class TupleTypeCS_RightParenthesisKeyword_3 extends KeywordToken  {
	
	public TupleTypeCS_RightParenthesisKeyword_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleTypeCS_Group_2(parent, this, 0, inst);
			case 1: return new TupleTypeCS_LeftParenthesisKeyword_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule tupleTypeCS ****************/


/************ begin Rule tuplePartCS ****************
 *
 * tuplePartCS returns VariableCS:
 *   name=simpleNameCS ":" type=typeCS; 
 *         
 *     
 * 	    
 * 
 * 
 * //---------------------------------------------------------------------
 * //  Literals
 * //---------------------------------------------------------------------
 * // EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
 * //  LiteralExpCS -> EnumLiteralExpCS
 *
 **/

// name=simpleNameCS ":" type=typeCS
protected class TuplePartCS_Group extends GroupToken {
	
	public TuplePartCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTuplePartCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TuplePartCS_TypeAssignment_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTuplePartCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// name=simpleNameCS
protected class TuplePartCS_NameAssignment_0 extends AssignmentToken  {
	
	public TuplePartCS_NameAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTuplePartCSAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("name",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTuplePartCSAccess().getNameSimpleNameCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// ":"
protected class TuplePartCS_ColonKeyword_1 extends KeywordToken  {
	
	public TuplePartCS_ColonKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTuplePartCSAccess().getColonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TuplePartCS_NameAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS
protected class TuplePartCS_TypeAssignment_2 extends AssignmentToken  {
	
	public TuplePartCS_TypeAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTuplePartCSAccess().getTypeAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTuplePartCSAccess().getTypeTypeCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TuplePartCS_ColonKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule tuplePartCS ****************/


/************ begin Rule LiteralExpCS ****************
 *
 * LiteralExpCS:
 *   CollectionLiteralExpCS|TupleLiteralExpCS|PrimitiveLiteralExpCS|TypeLiteralExpCS; 
 * 
 * //---------------------------------------------------------------------
 * //  Literals
 * //---------------------------------------------------------------------
 * // EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
 * //  LiteralExpCS -> EnumLiteralExpCS
 *
 **/

// CollectionLiteralExpCS|TupleLiteralExpCS|PrimitiveLiteralExpCS|TypeLiteralExpCS 
// 
// //---------------------------------------------------------------------
// //  Literals
// //---------------------------------------------------------------------
// // EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
// //  LiteralExpCS -> EnumLiteralExpCS
protected class LiteralExpCS_Alternatives extends AlternativesToken {

	public LiteralExpCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getLiteralExpCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LiteralExpCS_CollectionLiteralExpCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new LiteralExpCS_TupleLiteralExpCSParserRuleCall_1(parent, this, 1, inst);
			case 2: return new LiteralExpCS_PrimitiveLiteralExpCSParserRuleCall_2(parent, this, 2, inst);
			case 3: return new LiteralExpCS_TypeLiteralExpCSParserRuleCall_3(parent, this, 3, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// CollectionLiteralExpCS
protected class LiteralExpCS_CollectionLiteralExpCSParserRuleCall_0 extends RuleCallToken {
	
	public LiteralExpCS_CollectionLiteralExpCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getLiteralExpCSAccess().getCollectionLiteralExpCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralExpCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(CollectionLiteralExpCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getCollectionLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// TupleLiteralExpCS
protected class LiteralExpCS_TupleLiteralExpCSParserRuleCall_1 extends RuleCallToken {
	
	public LiteralExpCS_TupleLiteralExpCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getLiteralExpCSAccess().getTupleLiteralExpCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralExpCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(TupleLiteralExpCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getTupleLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// PrimitiveLiteralExpCS
protected class LiteralExpCS_PrimitiveLiteralExpCSParserRuleCall_2 extends RuleCallToken {
	
	public LiteralExpCS_PrimitiveLiteralExpCSParserRuleCall_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getLiteralExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimitiveLiteralExpCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PrimitiveLiteralExpCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPrimitiveLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// TypeLiteralExpCS
protected class LiteralExpCS_TypeLiteralExpCSParserRuleCall_3 extends RuleCallToken {
	
	public LiteralExpCS_TypeLiteralExpCSParserRuleCall_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getLiteralExpCSAccess().getTypeLiteralExpCSParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeLiteralExpCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(TypeLiteralExpCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getTypeLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule LiteralExpCS ****************/


/************ begin Rule CollectionLiteralExpCS ****************
 *
 * CollectionLiteralExpCS:
 *   (CollectionTypeIdentifierCS|collectionTypeCS) "{" (collectionLiteralParts+=
 *   CollectionLiteralPartCS ("," collectionLiteralParts+=CollectionLiteralPartCS)*)?
 *   "}";
 *
 **/

// (CollectionTypeIdentifierCS|collectionTypeCS) "{" (collectionLiteralParts+=
// CollectionLiteralPartCS ("," collectionLiteralParts+=CollectionLiteralPartCS)*)?
// "}"
protected class CollectionLiteralExpCS_Group extends GroupToken {
	
	public CollectionLiteralExpCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralExpCS_RightCurlyBracketKeyword_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getCollectionLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// CollectionTypeIdentifierCS|collectionTypeCS
protected class CollectionLiteralExpCS_Alternatives_0 extends AlternativesToken {

	public CollectionLiteralExpCS_Alternatives_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getAlternatives_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralExpCS_CollectionTypeIdentifierCSParserRuleCall_0_0(parent, this, 0, inst);
			case 1: return new CollectionLiteralExpCS_CollectionTypeCSParserRuleCall_0_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// CollectionTypeIdentifierCS
protected class CollectionLiteralExpCS_CollectionTypeIdentifierCSParserRuleCall_0_0 extends RuleCallToken {
	
	public CollectionLiteralExpCS_CollectionTypeIdentifierCSParserRuleCall_0_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getCollectionTypeIdentifierCSParserRuleCall_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeIdentifierCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(CollectionTypeIdentifierCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getCollectionTypeIdentifierCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// collectionTypeCS
protected class CollectionLiteralExpCS_CollectionTypeCSParserRuleCall_0_1 extends RuleCallToken {
	
	public CollectionLiteralExpCS_CollectionTypeCSParserRuleCall_0_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getCollectionTypeCSParserRuleCall_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(CollectionTypeCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getCollectionTypeCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


// "{"
protected class CollectionLiteralExpCS_LeftCurlyBracketKeyword_1 extends KeywordToken  {
	
	public CollectionLiteralExpCS_LeftCurlyBracketKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralExpCS_Alternatives_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// (collectionLiteralParts+=CollectionLiteralPartCS ("," collectionLiteralParts+=
// CollectionLiteralPartCS)*)?
protected class CollectionLiteralExpCS_Group_2 extends GroupToken {
	
	public CollectionLiteralExpCS_Group_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralExpCS_Group_2_1(parent, this, 0, inst);
			case 1: return new CollectionLiteralExpCS_CollectionLiteralPartsAssignment_2_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// collectionLiteralParts+=CollectionLiteralPartCS
protected class CollectionLiteralExpCS_CollectionLiteralPartsAssignment_2_0 extends AssignmentToken  {
	
	public CollectionLiteralExpCS_CollectionLiteralPartsAssignment_2_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsAssignment_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralPartCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("collectionLiteralParts",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("collectionLiteralParts");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getCollectionLiteralPartCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CollectionLiteralExpCS_LeftCurlyBracketKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," collectionLiteralParts+=CollectionLiteralPartCS)*
protected class CollectionLiteralExpCS_Group_2_1 extends GroupToken {
	
	public CollectionLiteralExpCS_Group_2_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralExpCS_CollectionLiteralPartsAssignment_2_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class CollectionLiteralExpCS_CommaKeyword_2_1_0 extends KeywordToken  {
	
	public CollectionLiteralExpCS_CommaKeyword_2_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralExpCS_Group_2_1(parent, this, 0, inst);
			case 1: return new CollectionLiteralExpCS_CollectionLiteralPartsAssignment_2_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// collectionLiteralParts+=CollectionLiteralPartCS
protected class CollectionLiteralExpCS_CollectionLiteralPartsAssignment_2_1_1 extends AssignmentToken  {
	
	public CollectionLiteralExpCS_CollectionLiteralPartsAssignment_2_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsAssignment_2_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralPartCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("collectionLiteralParts",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("collectionLiteralParts");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getCollectionLiteralPartCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CollectionLiteralExpCS_CommaKeyword_2_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// "}"
protected class CollectionLiteralExpCS_RightCurlyBracketKeyword_3 extends KeywordToken  {
	
	public CollectionLiteralExpCS_RightCurlyBracketKeyword_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralExpCS_Group_2(parent, this, 0, inst);
			case 1: return new CollectionLiteralExpCS_LeftCurlyBracketKeyword_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule CollectionLiteralExpCS ****************/


/************ begin Rule CollectionLiteralPartCS ****************
 *
 * CollectionLiteralPartCS:
 *   expressionCS=OclExpressionCS (".." lastExpressionCS=OclExpressionCS)?;
 *
 **/

// expressionCS=OclExpressionCS (".." lastExpressionCS=OclExpressionCS)?
protected class CollectionLiteralPartCS_Group extends GroupToken {
	
	public CollectionLiteralPartCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCollectionLiteralPartCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralPartCS_Group_1(parent, this, 0, inst);
			case 1: return new CollectionLiteralPartCS_ExpressionCSAssignment_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getCollectionLiteralPartCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// expressionCS=OclExpressionCS
protected class CollectionLiteralPartCS_ExpressionCSAssignment_0 extends AssignmentToken  {
	
	public CollectionLiteralPartCS_ExpressionCSAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("expressionCS",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("expressionCS");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSOclExpressionCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// (".." lastExpressionCS=OclExpressionCS)?
protected class CollectionLiteralPartCS_Group_1 extends GroupToken {
	
	public CollectionLiteralPartCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCollectionLiteralPartCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralPartCS_LastExpressionCSAssignment_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ".."
protected class CollectionLiteralPartCS_FullStopFullStopKeyword_1_0 extends KeywordToken  {
	
	public CollectionLiteralPartCS_FullStopFullStopKeyword_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionLiteralPartCS_ExpressionCSAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// lastExpressionCS=OclExpressionCS
protected class CollectionLiteralPartCS_LastExpressionCSAssignment_1_1 extends AssignmentToken  {
	
	public CollectionLiteralPartCS_LastExpressionCSAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("lastExpressionCS",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("lastExpressionCS");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSOclExpressionCSParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CollectionLiteralPartCS_FullStopFullStopKeyword_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule CollectionLiteralPartCS ****************/


/************ begin Rule PrimitiveLiteralExpCS ****************
 *
 * PrimitiveLiteralExpCS:
 *   IntegerLiteralExpCS|RealLiteralExpCS|StringLiteralExpCS|BooleanLiteralExpCS|
 *   UnlimitedNaturalLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS;
 *
 **/

// IntegerLiteralExpCS|RealLiteralExpCS|StringLiteralExpCS|BooleanLiteralExpCS|
// UnlimitedNaturalLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS
protected class PrimitiveLiteralExpCS_Alternatives extends AlternativesToken {

	public PrimitiveLiteralExpCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getPrimitiveLiteralExpCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimitiveLiteralExpCS_IntegerLiteralExpCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new PrimitiveLiteralExpCS_RealLiteralExpCSParserRuleCall_1(parent, this, 1, inst);
			case 2: return new PrimitiveLiteralExpCS_StringLiteralExpCSParserRuleCall_2(parent, this, 2, inst);
			case 3: return new PrimitiveLiteralExpCS_BooleanLiteralExpCSParserRuleCall_3(parent, this, 3, inst);
			case 4: return new PrimitiveLiteralExpCS_UnlimitedNaturalLiteralExpCSParserRuleCall_4(parent, this, 4, inst);
			case 5: return new PrimitiveLiteralExpCS_InvalidLiteralExpCSParserRuleCall_5(parent, this, 5, inst);
			case 6: return new PrimitiveLiteralExpCS_NullLiteralExpCSParserRuleCall_6(parent, this, 6, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getPrimitiveLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// IntegerLiteralExpCS
protected class PrimitiveLiteralExpCS_IntegerLiteralExpCSParserRuleCall_0 extends RuleCallToken {
	
	public PrimitiveLiteralExpCS_IntegerLiteralExpCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimitiveLiteralExpCSAccess().getIntegerLiteralExpCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IntegerLiteralExpCS_IntegerSymbolAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(IntegerLiteralExpCS_IntegerSymbolAssignment.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getIntegerLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// RealLiteralExpCS
protected class PrimitiveLiteralExpCS_RealLiteralExpCSParserRuleCall_1 extends RuleCallToken {
	
	public PrimitiveLiteralExpCS_RealLiteralExpCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimitiveLiteralExpCSAccess().getRealLiteralExpCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new RealLiteralExpCS_RealSymbolAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(RealLiteralExpCS_RealSymbolAssignment.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getRealLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// StringLiteralExpCS
protected class PrimitiveLiteralExpCS_StringLiteralExpCSParserRuleCall_2 extends RuleCallToken {
	
	public PrimitiveLiteralExpCS_StringLiteralExpCSParserRuleCall_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new StringLiteralExpCS_StringSymbolAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(StringLiteralExpCS_StringSymbolAssignment.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getStringLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// BooleanLiteralExpCS
protected class PrimitiveLiteralExpCS_BooleanLiteralExpCSParserRuleCall_3 extends RuleCallToken {
	
	public PrimitiveLiteralExpCS_BooleanLiteralExpCSParserRuleCall_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new BooleanLiteralExpCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(BooleanLiteralExpCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getBooleanLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// UnlimitedNaturalLiteralExpCS
protected class PrimitiveLiteralExpCS_UnlimitedNaturalLiteralExpCSParserRuleCall_4 extends RuleCallToken {
	
	public PrimitiveLiteralExpCS_UnlimitedNaturalLiteralExpCSParserRuleCall_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnlimitedNaturalLiteralExpCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(UnlimitedNaturalLiteralExpCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getUnlimitedNaturalLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// InvalidLiteralExpCS
protected class PrimitiveLiteralExpCS_InvalidLiteralExpCSParserRuleCall_5 extends RuleCallToken {
	
	public PrimitiveLiteralExpCS_InvalidLiteralExpCSParserRuleCall_5(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_5();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InvalidLiteralExpCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(InvalidLiteralExpCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getInvalidLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// NullLiteralExpCS
protected class PrimitiveLiteralExpCS_NullLiteralExpCSParserRuleCall_6 extends RuleCallToken {
	
	public PrimitiveLiteralExpCS_NullLiteralExpCSParserRuleCall_6(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_6();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new NullLiteralExpCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(NullLiteralExpCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getNullLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule PrimitiveLiteralExpCS ****************/


/************ begin Rule TupleLiteralExpCS ****************
 *
 * TupleLiteralExpCS:
 *   "Tuple" "{" part+=TupleLiteralPartCS ("," part+=TupleLiteralPartCS)* "}";
 *
 **/

// "Tuple" "{" part+=TupleLiteralPartCS ("," part+=TupleLiteralPartCS)* "}"
protected class TupleLiteralExpCS_Group extends GroupToken {
	
	public TupleLiteralExpCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleLiteralExpCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralExpCS_RightCurlyBracketKeyword_4(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTupleLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "Tuple"
protected class TupleLiteralExpCS_TupleKeyword_0 extends KeywordToken  {
	
	public TupleLiteralExpCS_TupleKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// "{"
protected class TupleLiteralExpCS_LeftCurlyBracketKeyword_1 extends KeywordToken  {
	
	public TupleLiteralExpCS_LeftCurlyBracketKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralExpCS_TupleKeyword_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// part+=TupleLiteralPartCS
protected class TupleLiteralExpCS_PartAssignment_2 extends AssignmentToken  {
	
	public TupleLiteralExpCS_PartAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleLiteralExpCSAccess().getPartAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralPartCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("part",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("part");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTupleLiteralPartCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTupleLiteralExpCSAccess().getPartTupleLiteralPartCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TupleLiteralExpCS_LeftCurlyBracketKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," part+=TupleLiteralPartCS)*
protected class TupleLiteralExpCS_Group_3 extends GroupToken {
	
	public TupleLiteralExpCS_Group_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleLiteralExpCSAccess().getGroup_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralExpCS_PartAssignment_3_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class TupleLiteralExpCS_CommaKeyword_3_0 extends KeywordToken  {
	
	public TupleLiteralExpCS_CommaKeyword_3_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralExpCS_Group_3(parent, this, 0, inst);
			case 1: return new TupleLiteralExpCS_PartAssignment_2(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// part+=TupleLiteralPartCS
protected class TupleLiteralExpCS_PartAssignment_3_1 extends AssignmentToken  {
	
	public TupleLiteralExpCS_PartAssignment_3_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleLiteralExpCSAccess().getPartAssignment_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralPartCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("part",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("part");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTupleLiteralPartCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTupleLiteralExpCSAccess().getPartTupleLiteralPartCSParserRuleCall_3_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TupleLiteralExpCS_CommaKeyword_3_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// "}"
protected class TupleLiteralExpCS_RightCurlyBracketKeyword_4 extends KeywordToken  {
	
	public TupleLiteralExpCS_RightCurlyBracketKeyword_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralExpCS_Group_3(parent, this, 0, inst);
			case 1: return new TupleLiteralExpCS_PartAssignment_2(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule TupleLiteralExpCS ****************/


/************ begin Rule TupleLiteralPartCS ****************
 *
 * TupleLiteralPartCS returns VariableCS:
 *   name=simpleNameCS (":" type=typeCS)? "=" initExpression=OclExpressionCS;
 *
 **/

// name=simpleNameCS (":" type=typeCS)? "=" initExpression=OclExpressionCS
protected class TupleLiteralPartCS_Group extends GroupToken {
	
	public TupleLiteralPartCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleLiteralPartCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralPartCS_InitExpressionAssignment_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTupleLiteralPartCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// name=simpleNameCS
protected class TupleLiteralPartCS_NameAssignment_0 extends AssignmentToken  {
	
	public TupleLiteralPartCS_NameAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleLiteralPartCSAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("name",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTupleLiteralPartCSAccess().getNameSimpleNameCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// (":" type=typeCS)?
protected class TupleLiteralPartCS_Group_1 extends GroupToken {
	
	public TupleLiteralPartCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleLiteralPartCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralPartCS_TypeAssignment_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ":"
protected class TupleLiteralPartCS_ColonKeyword_1_0 extends KeywordToken  {
	
	public TupleLiteralPartCS_ColonKeyword_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralPartCS_NameAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS
protected class TupleLiteralPartCS_TypeAssignment_1_1 extends AssignmentToken  {
	
	public TupleLiteralPartCS_TypeAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleLiteralPartCSAccess().getTypeAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTupleLiteralPartCSAccess().getTypeTypeCSParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TupleLiteralPartCS_ColonKeyword_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// "="
protected class TupleLiteralPartCS_EqualsSignKeyword_2 extends KeywordToken  {
	
	public TupleLiteralPartCS_EqualsSignKeyword_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleLiteralPartCS_Group_1(parent, this, 0, inst);
			case 1: return new TupleLiteralPartCS_NameAssignment_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// initExpression=OclExpressionCS
protected class TupleLiteralPartCS_InitExpressionAssignment_3 extends AssignmentToken  {
	
	public TupleLiteralPartCS_InitExpressionAssignment_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("initExpression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("initExpression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionOclExpressionCSParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TupleLiteralPartCS_EqualsSignKeyword_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule TupleLiteralPartCS ****************/


/************ begin Rule IntegerLiteralExpCS ****************
 *
 * IntegerLiteralExpCS:
 *   integerSymbol=INTEGER_LITERAL;
 *
 **/

// integerSymbol=INTEGER_LITERAL
protected class IntegerLiteralExpCS_IntegerSymbolAssignment extends AssignmentToken  {
	
	public IntegerLiteralExpCS_IntegerSymbolAssignment(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIntegerLiteralExpCSAccess().getIntegerSymbolAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getIntegerLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("integerSymbol",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("integerSymbol");
		if(Boolean.TRUE.booleanValue()) { 
			type = AssignmentType.DRC;
			element = grammarAccess.getIntegerLiteralExpCSAccess().getIntegerSymbolINTEGER_LITERALParserRuleCall_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule IntegerLiteralExpCS ****************/


/************ begin Rule RealLiteralExpCS ****************
 *
 * RealLiteralExpCS:
 *   realSymbol=REAL_LITERAL;
 *
 **/

// realSymbol=REAL_LITERAL
protected class RealLiteralExpCS_RealSymbolAssignment extends AssignmentToken  {
	
	public RealLiteralExpCS_RealSymbolAssignment(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRealLiteralExpCSAccess().getRealSymbolAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getRealLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("realSymbol",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("realSymbol");
		if(Boolean.TRUE.booleanValue()) { 
			type = AssignmentType.DRC;
			element = grammarAccess.getRealLiteralExpCSAccess().getRealSymbolREAL_LITERALParserRuleCall_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule RealLiteralExpCS ****************/


/************ begin Rule StringLiteralExpCS ****************
 *
 * StringLiteralExpCS:
 *   stringSymbol+=STRING_LITERAL+;
 *
 **/

// stringSymbol+=STRING_LITERAL+
protected class StringLiteralExpCS_StringSymbolAssignment extends AssignmentToken  {
	
	public StringLiteralExpCS_StringSymbolAssignment(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getStringLiteralExpCSAccess().getStringSymbolAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new StringLiteralExpCS_StringSymbolAssignment(parent, this, 0, inst);
			default: return parent.createParentFollower(this, index, index - 1, inst);
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getStringLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("stringSymbol",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("stringSymbol");
		if(Boolean.TRUE.booleanValue()) { 
			type = AssignmentType.LRC;
			element = grammarAccess.getStringLiteralExpCSAccess().getStringSymbolSTRING_LITERALTerminalRuleCall_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule StringLiteralExpCS ****************/


/************ begin Rule BooleanLiteralExpCS ****************
 *
 * BooleanLiteralExpCS:
 *   value="true"|value="false";
 *
 **/

// value="true"|value="false"
protected class BooleanLiteralExpCS_Alternatives extends AlternativesToken {

	public BooleanLiteralExpCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new BooleanLiteralExpCS_ValueAssignment_0(parent, this, 0, inst);
			case 1: return new BooleanLiteralExpCS_ValueAssignment_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getBooleanLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// value="true"
protected class BooleanLiteralExpCS_ValueAssignment_0 extends AssignmentToken  {
	
	public BooleanLiteralExpCS_ValueAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getBooleanLiteralExpCSAccess().getValueAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("true".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getBooleanLiteralExpCSAccess().getValueTrueKeyword_0_0();
			return obj;
		}
		return null;
	}

}

// value="false"
protected class BooleanLiteralExpCS_ValueAssignment_1 extends AssignmentToken  {
	
	public BooleanLiteralExpCS_ValueAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getBooleanLiteralExpCSAccess().getValueAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("value",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if("false".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getBooleanLiteralExpCSAccess().getValueFalseKeyword_1_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule BooleanLiteralExpCS ****************/


/************ begin Rule UnlimitedNaturalLiteralExpCS ****************
 *
 * UnlimitedNaturalLiteralExpCS:
 *   {UnlimitedNaturalLiteralExpCS} "*";
 *
 **/

// {UnlimitedNaturalLiteralExpCS} "*"
protected class UnlimitedNaturalLiteralExpCS_Group extends GroupToken {
	
	public UnlimitedNaturalLiteralExpCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnlimitedNaturalLiteralExpCS_AsteriskKeyword_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getUnlimitedNaturalLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// {UnlimitedNaturalLiteralExpCS}
protected class UnlimitedNaturalLiteralExpCS_UnlimitedNaturalLiteralExpCSAction_0 extends ActionToken  {

	public UnlimitedNaturalLiteralExpCS_UnlimitedNaturalLiteralExpCSAction_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0().getType().getClassifier())) return null;
		if(!current.isConsumed()) return null;
		return current;
	}
}

// "*"
protected class UnlimitedNaturalLiteralExpCS_AsteriskKeyword_1 extends KeywordToken  {
	
	public UnlimitedNaturalLiteralExpCS_AsteriskKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnlimitedNaturalLiteralExpCS_UnlimitedNaturalLiteralExpCSAction_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule UnlimitedNaturalLiteralExpCS ****************/


/************ begin Rule InvalidLiteralExpCS ****************
 *
 * InvalidLiteralExpCS:
 *   {InvalidLiteralExpCS} "invalid";
 *
 **/

// {InvalidLiteralExpCS} "invalid"
protected class InvalidLiteralExpCS_Group extends GroupToken {
	
	public InvalidLiteralExpCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInvalidLiteralExpCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InvalidLiteralExpCS_InvalidKeyword_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getInvalidLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// {InvalidLiteralExpCS}
protected class InvalidLiteralExpCS_InvalidLiteralExpCSAction_0 extends ActionToken  {

	public InvalidLiteralExpCS_InvalidLiteralExpCSAction_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0().getType().getClassifier())) return null;
		if(!current.isConsumed()) return null;
		return current;
	}
}

// "invalid"
protected class InvalidLiteralExpCS_InvalidKeyword_1 extends KeywordToken  {
	
	public InvalidLiteralExpCS_InvalidKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new InvalidLiteralExpCS_InvalidLiteralExpCSAction_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule InvalidLiteralExpCS ****************/


/************ begin Rule NullLiteralExpCS ****************
 *
 * NullLiteralExpCS:
 *   {NullLiteralExpCS} "null";
 *
 **/

// {NullLiteralExpCS} "null"
protected class NullLiteralExpCS_Group extends GroupToken {
	
	public NullLiteralExpCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getNullLiteralExpCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new NullLiteralExpCS_NullKeyword_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getNullLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// {NullLiteralExpCS}
protected class NullLiteralExpCS_NullLiteralExpCSAction_0 extends ActionToken  {

	public NullLiteralExpCS_NullLiteralExpCSAction_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0().getType().getClassifier())) return null;
		if(!current.isConsumed()) return null;
		return current;
	}
}

// "null"
protected class NullLiteralExpCS_NullKeyword_1 extends KeywordToken  {
	
	public NullLiteralExpCS_NullKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new NullLiteralExpCS_NullLiteralExpCSAction_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule NullLiteralExpCS ****************/


/************ begin Rule TypeLiteralExpCS ****************
 *
 * TypeLiteralExpCS:
 *   pathNameCS|primitiveTypeCS|collectionTypeCS|tupleTypeCS; 
 *         
 *         
 * 		
 * 		 
 * 		 
 * 		 
 * 
 * //---------------------------------------------------------------------
 * //  Expressions
 * //---------------------------------------------------------------------
 *      // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
 *      //  that let is right associative, whereas infix operators are left associative.
 *      //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
 *      // is
 *      //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
 *
 **/

// pathNameCS|primitiveTypeCS|collectionTypeCS|tupleTypeCS 
//         
//         
// 		
// 		 
// 		 
// 		 
// 
// //---------------------------------------------------------------------
// //  Expressions
// //---------------------------------------------------------------------
//      // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
//      //  that let is right associative, whereas infix operators are left associative.
//      //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
//      // is
//      //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
protected class TypeLiteralExpCS_Alternatives extends AlternativesToken {

	public TypeLiteralExpCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getTypeLiteralExpCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeLiteralExpCS_PathNameCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new TypeLiteralExpCS_PrimitiveTypeCSParserRuleCall_1(parent, this, 1, inst);
			case 2: return new TypeLiteralExpCS_CollectionTypeCSParserRuleCall_2(parent, this, 2, inst);
			case 3: return new TypeLiteralExpCS_TupleTypeCSParserRuleCall_3(parent, this, 3, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getTypeLiteralExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// pathNameCS
protected class TypeLiteralExpCS_PathNameCSParserRuleCall_0 extends RuleCallToken {
	
	public TypeLiteralExpCS_PathNameCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTypeLiteralExpCSAccess().getPathNameCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PathNameCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPathNameCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// primitiveTypeCS
protected class TypeLiteralExpCS_PrimitiveTypeCSParserRuleCall_1 extends RuleCallToken {
	
	public TypeLiteralExpCS_PrimitiveTypeCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTypeLiteralExpCSAccess().getPrimitiveTypeCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimitiveTypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PrimitiveTypeCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// collectionTypeCS
protected class TypeLiteralExpCS_CollectionTypeCSParserRuleCall_2 extends RuleCallToken {
	
	public TypeLiteralExpCS_CollectionTypeCSParserRuleCall_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTypeLiteralExpCSAccess().getCollectionTypeCSParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CollectionTypeCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(CollectionTypeCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getCollectionTypeCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// tupleTypeCS
protected class TypeLiteralExpCS_TupleTypeCSParserRuleCall_3 extends RuleCallToken {
	
	public TypeLiteralExpCS_TupleTypeCSParserRuleCall_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getTypeLiteralExpCSAccess().getTupleTypeCSParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TupleTypeCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(TupleTypeCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getTupleTypeCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule TypeLiteralExpCS ****************/


/************ begin Rule OclExpressionCS ****************
 *
 * OclExpressionCS:
 *   impliesCS|LetExpCS; 
 * 
 * //---------------------------------------------------------------------
 * //  Expressions
 * //---------------------------------------------------------------------
 *      // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
 *      //  that let is right associative, whereas infix operators are left associative.
 *      //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
 *      // is
 *      //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
 *
 **/

// impliesCS|LetExpCS 
// 
// //---------------------------------------------------------------------
// //  Expressions
// //---------------------------------------------------------------------
//      // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
//      //  that let is right associative, whereas infix operators are left associative.
//      //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
//      // is
//      //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
protected class OclExpressionCS_Alternatives extends AlternativesToken {

	public OclExpressionCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getOclExpressionCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_ImpliesCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new OclExpressionCS_LetExpCSParserRuleCall_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// impliesCS
protected class OclExpressionCS_ImpliesCSParserRuleCall_0 extends RuleCallToken {
	
	public OclExpressionCS_ImpliesCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getOclExpressionCSAccess().getImpliesCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImpliesCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(ImpliesCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getImpliesCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// LetExpCS
protected class OclExpressionCS_LetExpCSParserRuleCall_1 extends RuleCallToken {
	
	public OclExpressionCS_LetExpCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getOclExpressionCSAccess().getLetExpCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetExpCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(LetExpCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule OclExpressionCS ****************/


/************ begin Rule impliesCS ****************
 *
 * impliesCS returns OclExpressionCS:
 *   xorCS ({BinaryExpressionCS.left=current} op="implies" right=( impliesCS | LetExpCS ))?;
 *
 **/

// xorCS ({BinaryExpressionCS.left=current} op="implies" right=( impliesCS | LetExpCS ))?
protected class ImpliesCS_Group extends GroupToken {
	
	public ImpliesCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getImpliesCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImpliesCS_Group_1(parent, this, 0, inst);
			case 1: return new ImpliesCS_XorCSParserRuleCall_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getImpliesCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// xorCS
protected class ImpliesCS_XorCSParserRuleCall_0 extends RuleCallToken {
	
	public ImpliesCS_XorCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getImpliesCSAccess().getXorCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new XorCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(XorCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getXorCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// ({BinaryExpressionCS.left=current} op="implies" right=( impliesCS | LetExpCS ))?
protected class ImpliesCS_Group_1 extends GroupToken {
	
	public ImpliesCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getImpliesCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImpliesCS_RightAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {BinaryExpressionCS.left=current}
protected class ImpliesCS_BinaryExpressionCSLeftAction_1_0 extends ActionToken  {

	public ImpliesCS_BinaryExpressionCSLeftAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getImpliesCSAccess().getBinaryExpressionCSLeftAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImpliesCS_XorCSParserRuleCall_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getImpliesCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier())) return null;
		Object val = current.getConsumable("left", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("left")) return null;
		return getDescr((EObject) val);
	}
}

// op="implies"
protected class ImpliesCS_OpAssignment_1_1 extends AssignmentToken  {
	
	public ImpliesCS_OpAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getImpliesCSAccess().getOpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImpliesCS_BinaryExpressionCSLeftAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if("implies".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getImpliesCSAccess().getOpImpliesKeyword_1_1_0();
			return obj;
		}
		return null;
	}

}

// right=( impliesCS | LetExpCS )
protected class ImpliesCS_RightAssignment_1_2 extends AssignmentToken  {
	
	public ImpliesCS_RightAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getImpliesCSAccess().getRightAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImpliesCS_Group(this, this, 0, inst);
			case 1: return new LetExpCS_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("right",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("right");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getImpliesCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getImpliesCSAccess().getRightImpliesCSParserRuleCall_1_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getImpliesCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ImpliesCS_OpAssignment_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule impliesCS ****************/


/************ begin Rule xorCS ****************
 *
 * xorCS returns OclExpressionCS:
 *   orCS ({BinaryExpressionCS.left=current} op="xor" right=( xorCS | LetExpCS ))?;
 *
 **/

// orCS ({BinaryExpressionCS.left=current} op="xor" right=( xorCS | LetExpCS ))?
protected class XorCS_Group extends GroupToken {
	
	public XorCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getXorCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new XorCS_Group_1(parent, this, 0, inst);
			case 1: return new XorCS_OrCSParserRuleCall_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getXorCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// orCS
protected class XorCS_OrCSParserRuleCall_0 extends RuleCallToken {
	
	public XorCS_OrCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getXorCSAccess().getOrCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OrCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(OrCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getOrCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// ({BinaryExpressionCS.left=current} op="xor" right=( xorCS | LetExpCS ))?
protected class XorCS_Group_1 extends GroupToken {
	
	public XorCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getXorCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new XorCS_RightAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {BinaryExpressionCS.left=current}
protected class XorCS_BinaryExpressionCSLeftAction_1_0 extends ActionToken  {

	public XorCS_BinaryExpressionCSLeftAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getXorCSAccess().getBinaryExpressionCSLeftAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new XorCS_OrCSParserRuleCall_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getXorCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier())) return null;
		Object val = current.getConsumable("left", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("left")) return null;
		return getDescr((EObject) val);
	}
}

// op="xor"
protected class XorCS_OpAssignment_1_1 extends AssignmentToken  {
	
	public XorCS_OpAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getXorCSAccess().getOpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new XorCS_BinaryExpressionCSLeftAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if("xor".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getXorCSAccess().getOpXorKeyword_1_1_0();
			return obj;
		}
		return null;
	}

}

// right=( xorCS | LetExpCS )
protected class XorCS_RightAssignment_1_2 extends AssignmentToken  {
	
	public XorCS_RightAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getXorCSAccess().getRightAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new XorCS_Group(this, this, 0, inst);
			case 1: return new LetExpCS_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("right",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("right");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getXorCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getXorCSAccess().getRightXorCSParserRuleCall_1_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getXorCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new XorCS_OpAssignment_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule xorCS ****************/


/************ begin Rule orCS ****************
 *
 * orCS returns OclExpressionCS:
 *   andCS ({BinaryExpressionCS.left=current} op="or" right=( orCS | LetExpCS ))?;
 *
 **/

// andCS ({BinaryExpressionCS.left=current} op="or" right=( orCS | LetExpCS ))?
protected class OrCS_Group extends GroupToken {
	
	public OrCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOrCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OrCS_Group_1(parent, this, 0, inst);
			case 1: return new OrCS_AndCSParserRuleCall_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getOrCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// andCS
protected class OrCS_AndCSParserRuleCall_0 extends RuleCallToken {
	
	public OrCS_AndCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getOrCSAccess().getAndCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AndCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(AndCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getAndCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// ({BinaryExpressionCS.left=current} op="or" right=( orCS | LetExpCS ))?
protected class OrCS_Group_1 extends GroupToken {
	
	public OrCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOrCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OrCS_RightAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {BinaryExpressionCS.left=current}
protected class OrCS_BinaryExpressionCSLeftAction_1_0 extends ActionToken  {

	public OrCS_BinaryExpressionCSLeftAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getOrCSAccess().getBinaryExpressionCSLeftAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OrCS_AndCSParserRuleCall_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getOrCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier())) return null;
		Object val = current.getConsumable("left", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("left")) return null;
		return getDescr((EObject) val);
	}
}

// op="or"
protected class OrCS_OpAssignment_1_1 extends AssignmentToken  {
	
	public OrCS_OpAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOrCSAccess().getOpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OrCS_BinaryExpressionCSLeftAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if("or".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getOrCSAccess().getOpOrKeyword_1_1_0();
			return obj;
		}
		return null;
	}

}

// right=( orCS | LetExpCS )
protected class OrCS_RightAssignment_1_2 extends AssignmentToken  {
	
	public OrCS_RightAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOrCSAccess().getRightAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OrCS_Group(this, this, 0, inst);
			case 1: return new LetExpCS_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("right",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("right");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOrCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOrCSAccess().getRightOrCSParserRuleCall_1_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getOrCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OrCS_OpAssignment_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule orCS ****************/


/************ begin Rule andCS ****************
 *
 * andCS returns OclExpressionCS:
 *   equalityCS ({BinaryExpressionCS.left=current} op="and" right=( andCS | LetExpCS ))?;
 *
 **/

// equalityCS ({BinaryExpressionCS.left=current} op="and" right=( andCS | LetExpCS ))?
protected class AndCS_Group extends GroupToken {
	
	public AndCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAndCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AndCS_Group_1(parent, this, 0, inst);
			case 1: return new AndCS_EqualityCSParserRuleCall_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getAndCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// equalityCS
protected class AndCS_EqualityCSParserRuleCall_0 extends RuleCallToken {
	
	public AndCS_EqualityCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getAndCSAccess().getEqualityCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new EqualityCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(EqualityCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getEqualityCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// ({BinaryExpressionCS.left=current} op="and" right=( andCS | LetExpCS ))?
protected class AndCS_Group_1 extends GroupToken {
	
	public AndCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAndCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AndCS_RightAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {BinaryExpressionCS.left=current}
protected class AndCS_BinaryExpressionCSLeftAction_1_0 extends ActionToken  {

	public AndCS_BinaryExpressionCSLeftAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getAndCSAccess().getBinaryExpressionCSLeftAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AndCS_EqualityCSParserRuleCall_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getAndCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier())) return null;
		Object val = current.getConsumable("left", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("left")) return null;
		return getDescr((EObject) val);
	}
}

// op="and"
protected class AndCS_OpAssignment_1_1 extends AssignmentToken  {
	
	public AndCS_OpAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAndCSAccess().getOpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AndCS_BinaryExpressionCSLeftAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if("and".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getAndCSAccess().getOpAndKeyword_1_1_0();
			return obj;
		}
		return null;
	}

}

// right=( andCS | LetExpCS )
protected class AndCS_RightAssignment_1_2 extends AssignmentToken  {
	
	public AndCS_RightAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAndCSAccess().getRightAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AndCS_Group(this, this, 0, inst);
			case 1: return new LetExpCS_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("right",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("right");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAndCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getAndCSAccess().getRightAndCSParserRuleCall_1_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getAndCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AndCS_OpAssignment_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule andCS ****************/


/************ begin Rule equalityCS ****************
 *
 * equalityCS returns OclExpressionCS:
 *   relationalCS ({BinaryExpressionCS.left=current} op=( "=" | "<>" ) right=( equalityCS |
 *   LetExpCS ))?;
 *
 **/

// relationalCS ({BinaryExpressionCS.left=current} op=( "=" | "<>" ) right=( equalityCS |
// LetExpCS ))?
protected class EqualityCS_Group extends GroupToken {
	
	public EqualityCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getEqualityCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new EqualityCS_Group_1(parent, this, 0, inst);
			case 1: return new EqualityCS_RelationalCSParserRuleCall_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getEqualityCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// relationalCS
protected class EqualityCS_RelationalCSParserRuleCall_0 extends RuleCallToken {
	
	public EqualityCS_RelationalCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getEqualityCSAccess().getRelationalCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new RelationalCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(RelationalCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getRelationalCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// ({BinaryExpressionCS.left=current} op=( "=" | "<>" ) right=( equalityCS | LetExpCS ))?
protected class EqualityCS_Group_1 extends GroupToken {
	
	public EqualityCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getEqualityCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new EqualityCS_RightAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {BinaryExpressionCS.left=current}
protected class EqualityCS_BinaryExpressionCSLeftAction_1_0 extends ActionToken  {

	public EqualityCS_BinaryExpressionCSLeftAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getEqualityCSAccess().getBinaryExpressionCSLeftAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new EqualityCS_RelationalCSParserRuleCall_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getEqualityCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier())) return null;
		Object val = current.getConsumable("left", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("left")) return null;
		return getDescr((EObject) val);
	}
}

// op=( "=" | "<>" )
protected class EqualityCS_OpAssignment_1_1 extends AssignmentToken  {
	
	public EqualityCS_OpAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getEqualityCSAccess().getOpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new EqualityCS_BinaryExpressionCSLeftAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if("=".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getEqualityCSAccess().getOpEqualsSignKeyword_1_1_0_0();
			return obj;
		}
		if("<>".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getEqualityCSAccess().getOpLessThanSignGreaterThanSignKeyword_1_1_0_1();
			return obj;
		}
		return null;
	}

}

// right=( equalityCS | LetExpCS )
protected class EqualityCS_RightAssignment_1_2 extends AssignmentToken  {
	
	public EqualityCS_RightAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getEqualityCSAccess().getRightAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new EqualityCS_Group(this, this, 0, inst);
			case 1: return new LetExpCS_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("right",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("right");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getEqualityCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getEqualityCSAccess().getRightEqualityCSParserRuleCall_1_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getEqualityCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new EqualityCS_OpAssignment_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule equalityCS ****************/


/************ begin Rule relationalCS ****************
 *
 * relationalCS returns OclExpressionCS:
 *   additiveCS ({BinaryExpressionCS.left=current} op=( ">" | "<" | ">=" | "<=" ) right=(
 *   relationalCS | LetExpCS ))?;
 *
 **/

// additiveCS ({BinaryExpressionCS.left=current} op=( ">" | "<" | ">=" | "<=" ) right=(
// relationalCS | LetExpCS ))?
protected class RelationalCS_Group extends GroupToken {
	
	public RelationalCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getRelationalCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new RelationalCS_Group_1(parent, this, 0, inst);
			case 1: return new RelationalCS_AdditiveCSParserRuleCall_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getRelationalCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// additiveCS
protected class RelationalCS_AdditiveCSParserRuleCall_0 extends RuleCallToken {
	
	public RelationalCS_AdditiveCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getRelationalCSAccess().getAdditiveCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AdditiveCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(AdditiveCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getAdditiveCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// ({BinaryExpressionCS.left=current} op=( ">" | "<" | ">=" | "<=" ) right=( relationalCS |
// LetExpCS ))?
protected class RelationalCS_Group_1 extends GroupToken {
	
	public RelationalCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getRelationalCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new RelationalCS_RightAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {BinaryExpressionCS.left=current}
protected class RelationalCS_BinaryExpressionCSLeftAction_1_0 extends ActionToken  {

	public RelationalCS_BinaryExpressionCSLeftAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getRelationalCSAccess().getBinaryExpressionCSLeftAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new RelationalCS_AdditiveCSParserRuleCall_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getRelationalCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier())) return null;
		Object val = current.getConsumable("left", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("left")) return null;
		return getDescr((EObject) val);
	}
}

// op=( ">" | "<" | ">=" | "<=" )
protected class RelationalCS_OpAssignment_1_1 extends AssignmentToken  {
	
	public RelationalCS_OpAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRelationalCSAccess().getOpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new RelationalCS_BinaryExpressionCSLeftAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if(">".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getRelationalCSAccess().getOpGreaterThanSignKeyword_1_1_0_0();
			return obj;
		}
		if("<".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getRelationalCSAccess().getOpLessThanSignKeyword_1_1_0_1();
			return obj;
		}
		if(">=".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getRelationalCSAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_2();
			return obj;
		}
		if("<=".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getRelationalCSAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_3();
			return obj;
		}
		return null;
	}

}

// right=( relationalCS | LetExpCS )
protected class RelationalCS_RightAssignment_1_2 extends AssignmentToken  {
	
	public RelationalCS_RightAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRelationalCSAccess().getRightAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new RelationalCS_Group(this, this, 0, inst);
			case 1: return new LetExpCS_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("right",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("right");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getRelationalCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getRelationalCSAccess().getRightRelationalCSParserRuleCall_1_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getRelationalCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new RelationalCS_OpAssignment_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule relationalCS ****************/


/************ begin Rule additiveCS ****************
 *
 * additiveCS returns OclExpressionCS:
 *   multiplicativeCS ({BinaryExpressionCS.left=current} op=( "+" | "-" ) right=( additiveCS |
 *   LetExpCS ))?;
 *
 **/

// multiplicativeCS ({BinaryExpressionCS.left=current} op=( "+" | "-" ) right=( additiveCS |
// LetExpCS ))?
protected class AdditiveCS_Group extends GroupToken {
	
	public AdditiveCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAdditiveCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AdditiveCS_Group_1(parent, this, 0, inst);
			case 1: return new AdditiveCS_MultiplicativeCSParserRuleCall_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getAdditiveCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// multiplicativeCS
protected class AdditiveCS_MultiplicativeCSParserRuleCall_0 extends RuleCallToken {
	
	public AdditiveCS_MultiplicativeCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getAdditiveCSAccess().getMultiplicativeCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new MultiplicativeCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(MultiplicativeCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getMultiplicativeCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// ({BinaryExpressionCS.left=current} op=( "+" | "-" ) right=( additiveCS | LetExpCS ))?
protected class AdditiveCS_Group_1 extends GroupToken {
	
	public AdditiveCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAdditiveCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AdditiveCS_RightAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {BinaryExpressionCS.left=current}
protected class AdditiveCS_BinaryExpressionCSLeftAction_1_0 extends ActionToken  {

	public AdditiveCS_BinaryExpressionCSLeftAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getAdditiveCSAccess().getBinaryExpressionCSLeftAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AdditiveCS_MultiplicativeCSParserRuleCall_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getAdditiveCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier())) return null;
		Object val = current.getConsumable("left", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("left")) return null;
		return getDescr((EObject) val);
	}
}

// op=( "+" | "-" )
protected class AdditiveCS_OpAssignment_1_1 extends AssignmentToken  {
	
	public AdditiveCS_OpAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAdditiveCSAccess().getOpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AdditiveCS_BinaryExpressionCSLeftAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if("+".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getAdditiveCSAccess().getOpPlusSignKeyword_1_1_0_0();
			return obj;
		}
		if("-".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getAdditiveCSAccess().getOpHyphenMinusKeyword_1_1_0_1();
			return obj;
		}
		return null;
	}

}

// right=( additiveCS | LetExpCS )
protected class AdditiveCS_RightAssignment_1_2 extends AssignmentToken  {
	
	public AdditiveCS_RightAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAdditiveCSAccess().getRightAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new AdditiveCS_Group(this, this, 0, inst);
			case 1: return new LetExpCS_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("right",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("right");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAdditiveCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getAdditiveCSAccess().getRightAdditiveCSParserRuleCall_1_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getAdditiveCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AdditiveCS_OpAssignment_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule additiveCS ****************/


/************ begin Rule multiplicativeCS ****************
 *
 * multiplicativeCS returns OclExpressionCS:
 *   unaryCS ({BinaryExpressionCS.left=current} op=( "*" | "/" ) right=( multiplicativeCS |
 *   LetExpCS ))?;
 *
 **/

// unaryCS ({BinaryExpressionCS.left=current} op=( "*" | "/" ) right=( multiplicativeCS |
// LetExpCS ))?
protected class MultiplicativeCS_Group extends GroupToken {
	
	public MultiplicativeCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicativeCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new MultiplicativeCS_Group_1(parent, this, 0, inst);
			case 1: return new MultiplicativeCS_UnaryCSParserRuleCall_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getMultiplicativeCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// unaryCS
protected class MultiplicativeCS_UnaryCSParserRuleCall_0 extends RuleCallToken {
	
	public MultiplicativeCS_UnaryCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getMultiplicativeCSAccess().getUnaryCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnaryCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(UnaryCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getUnaryCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// ({BinaryExpressionCS.left=current} op=( "*" | "/" ) right=( multiplicativeCS | LetExpCS ))
// ?
protected class MultiplicativeCS_Group_1 extends GroupToken {
	
	public MultiplicativeCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicativeCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new MultiplicativeCS_RightAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {BinaryExpressionCS.left=current}
protected class MultiplicativeCS_BinaryExpressionCSLeftAction_1_0 extends ActionToken  {

	public MultiplicativeCS_BinaryExpressionCSLeftAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getMultiplicativeCSAccess().getBinaryExpressionCSLeftAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new MultiplicativeCS_UnaryCSParserRuleCall_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getMultiplicativeCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier())) return null;
		Object val = current.getConsumable("left", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("left")) return null;
		return getDescr((EObject) val);
	}
}

// op=( "*" | "/" )
protected class MultiplicativeCS_OpAssignment_1_1 extends AssignmentToken  {
	
	public MultiplicativeCS_OpAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicativeCSAccess().getOpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new MultiplicativeCS_BinaryExpressionCSLeftAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if("*".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getMultiplicativeCSAccess().getOpAsteriskKeyword_1_1_0_0();
			return obj;
		}
		if("/".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getMultiplicativeCSAccess().getOpSolidusKeyword_1_1_0_1();
			return obj;
		}
		return null;
	}

}

// right=( multiplicativeCS | LetExpCS )
protected class MultiplicativeCS_RightAssignment_1_2 extends AssignmentToken  {
	
	public MultiplicativeCS_RightAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicativeCSAccess().getRightAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new MultiplicativeCS_Group(this, this, 0, inst);
			case 1: return new LetExpCS_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("right",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("right");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getMultiplicativeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getMultiplicativeCSAccess().getRightMultiplicativeCSParserRuleCall_1_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getMultiplicativeCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new MultiplicativeCS_OpAssignment_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule multiplicativeCS ****************/


/************ begin Rule unaryCS ****************
 *
 * unaryCS returns OclExpressionCS:
 *   calledExpCS|{UnaryExpressionCS} op=( "-" | "not" ) source=unaryCS;
 *
 **/

// calledExpCS|{UnaryExpressionCS} op=( "-" | "not" ) source=unaryCS
protected class UnaryCS_Alternatives extends AlternativesToken {

	public UnaryCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getUnaryCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnaryCS_CalledExpCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new UnaryCS_Group_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getUnaryCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// calledExpCS
protected class UnaryCS_CalledExpCSParserRuleCall_0 extends RuleCallToken {
	
	public UnaryCS_CalledExpCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getUnaryCSAccess().getCalledExpCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CalledExpCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(CalledExpCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getCalledExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// {UnaryExpressionCS} op=( "-" | "not" ) source=unaryCS
protected class UnaryCS_Group_1 extends GroupToken {
	
	public UnaryCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getUnaryCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnaryCS_SourceAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {UnaryExpressionCS}
protected class UnaryCS_UnaryExpressionCSAction_1_0 extends ActionToken  {

	public UnaryCS_UnaryExpressionCSAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getUnaryCSAccess().getUnaryExpressionCSAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getUnaryCSAccess().getUnaryExpressionCSAction_1_0().getType().getClassifier())) return null;
		if(!current.isConsumed()) return null;
		return current;
	}
}

// op=( "-" | "not" )
protected class UnaryCS_OpAssignment_1_1 extends AssignmentToken  {
	
	public UnaryCS_OpAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUnaryCSAccess().getOpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnaryCS_UnaryExpressionCSAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("op",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("op");
		if("-".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getUnaryCSAccess().getOpHyphenMinusKeyword_1_1_0_0();
			return obj;
		}
		if("not".equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getUnaryCSAccess().getOpNotKeyword_1_1_0_1();
			return obj;
		}
		return null;
	}

}

// source=unaryCS
protected class UnaryCS_SourceAssignment_1_2 extends AssignmentToken  {
	
	public UnaryCS_SourceAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUnaryCSAccess().getSourceAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new UnaryCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("source",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("source");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getUnaryCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getUnaryCSAccess().getSourceUnaryCSParserRuleCall_1_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new UnaryCS_OpAssignment_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule unaryCS ****************/


/************ begin Rule calledExpCS ****************
 *
 * calledExpCS returns OclExpressionCS:
 *   implicitCallExpCS ({CallExpCS.source=current} callArguments+=CallArgumentsCS+)?;
 *
 **/

// implicitCallExpCS ({CallExpCS.source=current} callArguments+=CallArgumentsCS+)?
protected class CalledExpCS_Group extends GroupToken {
	
	public CalledExpCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCalledExpCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CalledExpCS_Group_1(parent, this, 0, inst);
			case 1: return new CalledExpCS_ImplicitCallExpCSParserRuleCall_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getCalledExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// implicitCallExpCS
protected class CalledExpCS_ImplicitCallExpCSParserRuleCall_0 extends RuleCallToken {
	
	public CalledExpCS_ImplicitCallExpCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getCalledExpCSAccess().getImplicitCallExpCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ImplicitCallExpCS_PreCallExpCSParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(ImplicitCallExpCS_PreCallExpCSParserRuleCall.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getImplicitCallExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// ({CallExpCS.source=current} callArguments+=CallArgumentsCS+)?
protected class CalledExpCS_Group_1 extends GroupToken {
	
	public CalledExpCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCalledExpCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CalledExpCS_CallArgumentsAssignment_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {CallExpCS.source=current}
protected class CalledExpCS_CallExpCSSourceAction_1_0 extends ActionToken  {

	public CalledExpCS_CallExpCSSourceAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getCalledExpCSAccess().getCallExpCSSourceAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CalledExpCS_ImplicitCallExpCSParserRuleCall_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getCalledExpCSAccess().getCallExpCSSourceAction_1_0().getType().getClassifier())) return null;
		Object val = current.getConsumable("source", false);
		if(val == null) return null;
		if(!current.isConsumedWithLastConsumtion("source")) return null;
		return getDescr((EObject) val);
	}
}

// callArguments+=CallArgumentsCS+
protected class CalledExpCS_CallArgumentsAssignment_1_1 extends AssignmentToken  {
	
	public CalledExpCS_CallArgumentsAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCalledExpCSAccess().getCallArgumentsAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("callArguments",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("callArguments");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getCallArgumentsCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCalledExpCSAccess().getCallArgumentsCallArgumentsCSParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CalledExpCS_CallArgumentsAssignment_1_1(parent, next, actIndex, consumed);
			case 1: return new CalledExpCS_CallExpCSSourceAction_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule calledExpCS ****************/


/************ begin Rule CallArgumentsCS ****************
 *
 * CallArgumentsCS:
 *   {ArrowCallArgumentsCS} "->" pathName=pathNameCS "(" (variable1=iteratorVariableCS (
 *   "," variable2=iteratorVariableCS|";" variable2=iteratorAccumulatorCS)? "|" body=
 *   OclExpressionCS|(arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?)
 *   ")"|{DotIndexArgumentsCS} "." pathName=pathNameCS ("[" indexes+=OclExpressionCS (","
 *   indexes+=OclExpressionCS)* "]")? isPre?="@pre"? ("(" (arguments+=OclExpressionCS (","
 *   arguments+=OclExpressionCS)*)? ")")?;
 *
 **/

// {ArrowCallArgumentsCS} "->" pathName=pathNameCS "(" (variable1=iteratorVariableCS (
// "," variable2=iteratorVariableCS|";" variable2=iteratorAccumulatorCS)? "|" body=
// OclExpressionCS|(arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?)
// ")"|{DotIndexArgumentsCS} "." pathName=pathNameCS ("[" indexes+=OclExpressionCS (","
// indexes+=OclExpressionCS)* "]")? isPre?="@pre"? ("(" (arguments+=OclExpressionCS (","
// arguments+=OclExpressionCS)*)? ")")?
protected class CallArgumentsCS_Alternatives extends AlternativesToken {

	public CallArgumentsCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_0(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_Group_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getCallArgumentsCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// {ArrowCallArgumentsCS} "->" pathName=pathNameCS "(" (variable1=iteratorVariableCS (
// "," variable2=iteratorVariableCS|";" variable2=iteratorAccumulatorCS)? "|" body=
// OclExpressionCS|(arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?)
// ")"
protected class CallArgumentsCS_Group_0 extends GroupToken {
	
	public CallArgumentsCS_Group_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_RightParenthesisKeyword_0_5(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// {ArrowCallArgumentsCS}
protected class CallArgumentsCS_ArrowCallArgumentsCSAction_0_0 extends ActionToken  {

	public CallArgumentsCS_ArrowCallArgumentsCSAction_0_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getArrowCallArgumentsCSAction_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getCallArgumentsCSAccess().getArrowCallArgumentsCSAction_0_0().getType().getClassifier())) return null;
		if(!current.isConsumed()) return null;
		return current;
	}
}

// "->"
protected class CallArgumentsCS_HyphenMinusGreaterThanSignKeyword_0_1 extends KeywordToken  {
	
	public CallArgumentsCS_HyphenMinusGreaterThanSignKeyword_0_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getHyphenMinusGreaterThanSignKeyword_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_ArrowCallArgumentsCSAction_0_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// pathName=pathNameCS
protected class CallArgumentsCS_PathNameAssignment_0_2 extends AssignmentToken  {
	
	public CallArgumentsCS_PathNameAssignment_0_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getPathNameAssignment_0_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("pathName",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("pathName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPathNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getPathNamePathNameCSParserRuleCall_0_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_HyphenMinusGreaterThanSignKeyword_0_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "("
protected class CallArgumentsCS_LeftParenthesisKeyword_0_3 extends KeywordToken  {
	
	public CallArgumentsCS_LeftParenthesisKeyword_0_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getLeftParenthesisKeyword_0_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_PathNameAssignment_0_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// variable1=iteratorVariableCS ("," variable2=iteratorVariableCS|";" variable2=
// iteratorAccumulatorCS)? "|" body=OclExpressionCS|(arguments+=OclExpressionCS (","
// arguments+=OclExpressionCS)*)?
protected class CallArgumentsCS_Alternatives_0_4 extends AlternativesToken {

	public CallArgumentsCS_Alternatives_0_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getAlternatives_0_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_0_4_0(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_Group_0_4_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// variable1=iteratorVariableCS ("," variable2=iteratorVariableCS|";" variable2=
// iteratorAccumulatorCS)? "|" body=OclExpressionCS
protected class CallArgumentsCS_Group_0_4_0 extends GroupToken {
	
	public CallArgumentsCS_Group_0_4_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_BodyAssignment_0_4_0_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// variable1=iteratorVariableCS
protected class CallArgumentsCS_Variable1Assignment_0_4_0_0 extends AssignmentToken  {
	
	public CallArgumentsCS_Variable1Assignment_0_4_0_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getVariable1Assignment_0_4_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IteratorVariableCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("variable1",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("variable1");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getIteratorVariableCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getVariable1IteratorVariableCSParserRuleCall_0_4_0_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_LeftParenthesisKeyword_0_3(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," variable2=iteratorVariableCS|";" variable2=iteratorAccumulatorCS)?
protected class CallArgumentsCS_Alternatives_0_4_0_1 extends AlternativesToken {

	public CallArgumentsCS_Alternatives_0_4_0_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getAlternatives_0_4_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_0_4_0_1_0(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_Group_0_4_0_1_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// "," variable2=iteratorVariableCS
protected class CallArgumentsCS_Group_0_4_0_1_0 extends GroupToken {
	
	public CallArgumentsCS_Group_0_4_0_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_0_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Variable2Assignment_0_4_0_1_0_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class CallArgumentsCS_CommaKeyword_0_4_0_1_0_0 extends KeywordToken  {
	
	public CallArgumentsCS_CommaKeyword_0_4_0_1_0_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getCommaKeyword_0_4_0_1_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Variable1Assignment_0_4_0_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// variable2=iteratorVariableCS
protected class CallArgumentsCS_Variable2Assignment_0_4_0_1_0_1 extends AssignmentToken  {
	
	public CallArgumentsCS_Variable2Assignment_0_4_0_1_0_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getVariable2Assignment_0_4_0_1_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IteratorVariableCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("variable2",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("variable2");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getIteratorVariableCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getVariable2IteratorVariableCSParserRuleCall_0_4_0_1_0_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_CommaKeyword_0_4_0_1_0_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// ";" variable2=iteratorAccumulatorCS
protected class CallArgumentsCS_Group_0_4_0_1_1 extends GroupToken {
	
	public CallArgumentsCS_Group_0_4_0_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_0_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Variable2Assignment_0_4_0_1_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ";"
protected class CallArgumentsCS_SemicolonKeyword_0_4_0_1_1_0 extends KeywordToken  {
	
	public CallArgumentsCS_SemicolonKeyword_0_4_0_1_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getSemicolonKeyword_0_4_0_1_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Variable1Assignment_0_4_0_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// variable2=iteratorAccumulatorCS
protected class CallArgumentsCS_Variable2Assignment_0_4_0_1_1_1 extends AssignmentToken  {
	
	public CallArgumentsCS_Variable2Assignment_0_4_0_1_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getVariable2Assignment_0_4_0_1_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IteratorAccumulatorCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("variable2",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("variable2");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getIteratorAccumulatorCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getVariable2IteratorAccumulatorCSParserRuleCall_0_4_0_1_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_SemicolonKeyword_0_4_0_1_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// "|"
protected class CallArgumentsCS_VerticalLineKeyword_0_4_0_2 extends KeywordToken  {
	
	public CallArgumentsCS_VerticalLineKeyword_0_4_0_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getVerticalLineKeyword_0_4_0_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Alternatives_0_4_0_1(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_Variable1Assignment_0_4_0_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// body=OclExpressionCS
protected class CallArgumentsCS_BodyAssignment_0_4_0_3 extends AssignmentToken  {
	
	public CallArgumentsCS_BodyAssignment_0_4_0_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getBodyAssignment_0_4_0_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("body",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("body");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getBodyOclExpressionCSParserRuleCall_0_4_0_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_VerticalLineKeyword_0_4_0_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// (arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?
protected class CallArgumentsCS_Group_0_4_1 extends GroupToken {
	
	public CallArgumentsCS_Group_0_4_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_0_4_1_1(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_ArgumentsAssignment_0_4_1_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// arguments+=OclExpressionCS
protected class CallArgumentsCS_ArgumentsAssignment_0_4_1_0 extends AssignmentToken  {
	
	public CallArgumentsCS_ArgumentsAssignment_0_4_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getArgumentsAssignment_0_4_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("arguments",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("arguments");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getArgumentsOclExpressionCSParserRuleCall_0_4_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_LeftParenthesisKeyword_0_3(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," arguments+=OclExpressionCS)*
protected class CallArgumentsCS_Group_0_4_1_1 extends GroupToken {
	
	public CallArgumentsCS_Group_0_4_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_0_4_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_ArgumentsAssignment_0_4_1_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class CallArgumentsCS_CommaKeyword_0_4_1_1_0 extends KeywordToken  {
	
	public CallArgumentsCS_CommaKeyword_0_4_1_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getCommaKeyword_0_4_1_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_0_4_1_1(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_ArgumentsAssignment_0_4_1_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// arguments+=OclExpressionCS
protected class CallArgumentsCS_ArgumentsAssignment_0_4_1_1_1 extends AssignmentToken  {
	
	public CallArgumentsCS_ArgumentsAssignment_0_4_1_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getArgumentsAssignment_0_4_1_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("arguments",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("arguments");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getArgumentsOclExpressionCSParserRuleCall_0_4_1_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_CommaKeyword_0_4_1_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}




// ")"
protected class CallArgumentsCS_RightParenthesisKeyword_0_5 extends KeywordToken  {
	
	public CallArgumentsCS_RightParenthesisKeyword_0_5(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getRightParenthesisKeyword_0_5();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Alternatives_0_4(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}


// {DotIndexArgumentsCS} "." pathName=pathNameCS ("[" indexes+=OclExpressionCS (","
// indexes+=OclExpressionCS)* "]")? isPre?="@pre"? ("(" (arguments+=OclExpressionCS (","
// arguments+=OclExpressionCS)*)? ")")?
protected class CallArgumentsCS_Group_1 extends GroupToken {
	
	public CallArgumentsCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_1_5(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_IsPreAssignment_1_4(parent, this, 1, inst);
			case 2: return new CallArgumentsCS_Group_1_3(parent, this, 2, inst);
			case 3: return new CallArgumentsCS_PathNameAssignment_1_2(parent, this, 3, inst);
			default: return null;
		}	
	}	
		
}

// {DotIndexArgumentsCS}
protected class CallArgumentsCS_DotIndexArgumentsCSAction_1_0 extends ActionToken  {

	public CallArgumentsCS_DotIndexArgumentsCSAction_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getDotIndexArgumentsCSAction_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
	
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(!current.isInstanceOf(grammarAccess.getCallArgumentsCSAccess().getDotIndexArgumentsCSAction_1_0().getType().getClassifier())) return null;
		if(!current.isConsumed()) return null;
		return current;
	}
}

// "."
protected class CallArgumentsCS_FullStopKeyword_1_1 extends KeywordToken  {
	
	public CallArgumentsCS_FullStopKeyword_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getFullStopKeyword_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_DotIndexArgumentsCSAction_1_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// pathName=pathNameCS
protected class CallArgumentsCS_PathNameAssignment_1_2 extends AssignmentToken  {
	
	public CallArgumentsCS_PathNameAssignment_1_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getPathNameAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PathNameCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("pathName",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("pathName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPathNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getPathNamePathNameCSParserRuleCall_1_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_FullStopKeyword_1_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("[" indexes+=OclExpressionCS ("," indexes+=OclExpressionCS)* "]")?
protected class CallArgumentsCS_Group_1_3 extends GroupToken {
	
	public CallArgumentsCS_Group_1_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_1_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_RightSquareBracketKeyword_1_3_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// "["
protected class CallArgumentsCS_LeftSquareBracketKeyword_1_3_0 extends KeywordToken  {
	
	public CallArgumentsCS_LeftSquareBracketKeyword_1_3_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getLeftSquareBracketKeyword_1_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_PathNameAssignment_1_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// indexes+=OclExpressionCS
protected class CallArgumentsCS_IndexesAssignment_1_3_1 extends AssignmentToken  {
	
	public CallArgumentsCS_IndexesAssignment_1_3_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getIndexesAssignment_1_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("indexes",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("indexes");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getIndexesOclExpressionCSParserRuleCall_1_3_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_LeftSquareBracketKeyword_1_3_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," indexes+=OclExpressionCS)*
protected class CallArgumentsCS_Group_1_3_2 extends GroupToken {
	
	public CallArgumentsCS_Group_1_3_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_1_3_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_IndexesAssignment_1_3_2_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class CallArgumentsCS_CommaKeyword_1_3_2_0 extends KeywordToken  {
	
	public CallArgumentsCS_CommaKeyword_1_3_2_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getCommaKeyword_1_3_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_1_3_2(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_IndexesAssignment_1_3_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// indexes+=OclExpressionCS
protected class CallArgumentsCS_IndexesAssignment_1_3_2_1 extends AssignmentToken  {
	
	public CallArgumentsCS_IndexesAssignment_1_3_2_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getIndexesAssignment_1_3_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("indexes",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("indexes");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getIndexesOclExpressionCSParserRuleCall_1_3_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_CommaKeyword_1_3_2_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// "]"
protected class CallArgumentsCS_RightSquareBracketKeyword_1_3_3 extends KeywordToken  {
	
	public CallArgumentsCS_RightSquareBracketKeyword_1_3_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getRightSquareBracketKeyword_1_3_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_1_3_2(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_IndexesAssignment_1_3_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}


// isPre?="@pre"?
protected class CallArgumentsCS_IsPreAssignment_1_4 extends AssignmentToken  {
	
	public CallArgumentsCS_IsPreAssignment_1_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getIsPreAssignment_1_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_1_3(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_PathNameAssignment_1_2(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("isPre",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("isPre");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KW;
			element = grammarAccess.getCallArgumentsCSAccess().getIsPrePreKeyword_1_4_0();
			return obj;
		}
		return null;
	}

}

// ("(" (arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)? ")")?
protected class CallArgumentsCS_Group_1_5 extends GroupToken {
	
	public CallArgumentsCS_Group_1_5(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_1_5();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_RightParenthesisKeyword_1_5_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// "("
protected class CallArgumentsCS_LeftParenthesisKeyword_1_5_0 extends KeywordToken  {
	
	public CallArgumentsCS_LeftParenthesisKeyword_1_5_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getLeftParenthesisKeyword_1_5_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_IsPreAssignment_1_4(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_Group_1_3(parent, this, 1, inst);
			case 2: return new CallArgumentsCS_PathNameAssignment_1_2(parent, this, 2, inst);
			default: return null;
		}	
	}	
		
}

// (arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?
protected class CallArgumentsCS_Group_1_5_1 extends GroupToken {
	
	public CallArgumentsCS_Group_1_5_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_1_5_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_1_5_1_1(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_ArgumentsAssignment_1_5_1_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// arguments+=OclExpressionCS
protected class CallArgumentsCS_ArgumentsAssignment_1_5_1_0 extends AssignmentToken  {
	
	public CallArgumentsCS_ArgumentsAssignment_1_5_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getArgumentsAssignment_1_5_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("arguments",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("arguments");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getArgumentsOclExpressionCSParserRuleCall_1_5_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_LeftParenthesisKeyword_1_5_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," arguments+=OclExpressionCS)*
protected class CallArgumentsCS_Group_1_5_1_1 extends GroupToken {
	
	public CallArgumentsCS_Group_1_5_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getGroup_1_5_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_ArgumentsAssignment_1_5_1_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class CallArgumentsCS_CommaKeyword_1_5_1_1_0 extends KeywordToken  {
	
	public CallArgumentsCS_CommaKeyword_1_5_1_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getCommaKeyword_1_5_1_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_1_5_1_1(parent, this, 0, inst);
			case 1: return new CallArgumentsCS_ArgumentsAssignment_1_5_1_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// arguments+=OclExpressionCS
protected class CallArgumentsCS_ArgumentsAssignment_1_5_1_1_1 extends AssignmentToken  {
	
	public CallArgumentsCS_ArgumentsAssignment_1_5_1_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getArgumentsAssignment_1_5_1_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("arguments",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("arguments");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getCallArgumentsCSAccess().getArgumentsOclExpressionCSParserRuleCall_1_5_1_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CallArgumentsCS_CommaKeyword_1_5_1_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// ")"
protected class CallArgumentsCS_RightParenthesisKeyword_1_5_2 extends KeywordToken  {
	
	public CallArgumentsCS_RightParenthesisKeyword_1_5_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCallArgumentsCSAccess().getRightParenthesisKeyword_1_5_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new CallArgumentsCS_Group_1_5_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}




/************ end Rule CallArgumentsCS ****************/


/************ begin Rule iteratorVariableCS ****************
 *
 * iteratorVariableCS returns VariableCS:
 *   name=simpleNameCS (":" type=typeCS)?;
 *
 **/

// name=simpleNameCS (":" type=typeCS)?
protected class IteratorVariableCS_Group extends GroupToken {
	
	public IteratorVariableCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getIteratorVariableCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IteratorVariableCS_Group_1(parent, this, 0, inst);
			case 1: return new IteratorVariableCS_NameAssignment_0(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getIteratorVariableCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// name=simpleNameCS
protected class IteratorVariableCS_NameAssignment_0 extends AssignmentToken  {
	
	public IteratorVariableCS_NameAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIteratorVariableCSAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("name",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getIteratorVariableCSAccess().getNameSimpleNameCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// (":" type=typeCS)?
protected class IteratorVariableCS_Group_1 extends GroupToken {
	
	public IteratorVariableCS_Group_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getIteratorVariableCSAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IteratorVariableCS_TypeAssignment_1_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ":"
protected class IteratorVariableCS_ColonKeyword_1_0 extends KeywordToken  {
	
	public IteratorVariableCS_ColonKeyword_1_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIteratorVariableCSAccess().getColonKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IteratorVariableCS_NameAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS
protected class IteratorVariableCS_TypeAssignment_1_1 extends AssignmentToken  {
	
	public IteratorVariableCS_TypeAssignment_1_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIteratorVariableCSAccess().getTypeAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getIteratorVariableCSAccess().getTypeTypeCSParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IteratorVariableCS_ColonKeyword_1_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule iteratorVariableCS ****************/


/************ begin Rule iteratorAccumulatorCS ****************
 *
 * iteratorAccumulatorCS returns VariableCS:
 *   name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS;
 *
 **/

// name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS
protected class IteratorAccumulatorCS_Group extends GroupToken {
	
	public IteratorAccumulatorCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getIteratorAccumulatorCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IteratorAccumulatorCS_InitExpressionAssignment_4(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getIteratorAccumulatorCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// name=simpleNameCS
protected class IteratorAccumulatorCS_NameAssignment_0 extends AssignmentToken  {
	
	public IteratorAccumulatorCS_NameAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIteratorAccumulatorCSAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("name",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getIteratorAccumulatorCSAccess().getNameSimpleNameCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// ":"
protected class IteratorAccumulatorCS_ColonKeyword_1 extends KeywordToken  {
	
	public IteratorAccumulatorCS_ColonKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIteratorAccumulatorCSAccess().getColonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IteratorAccumulatorCS_NameAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS
protected class IteratorAccumulatorCS_TypeAssignment_2 extends AssignmentToken  {
	
	public IteratorAccumulatorCS_TypeAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIteratorAccumulatorCSAccess().getTypeAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getIteratorAccumulatorCSAccess().getTypeTypeCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IteratorAccumulatorCS_ColonKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "="
protected class IteratorAccumulatorCS_EqualsSignKeyword_3 extends KeywordToken  {
	
	public IteratorAccumulatorCS_EqualsSignKeyword_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIteratorAccumulatorCSAccess().getEqualsSignKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IteratorAccumulatorCS_TypeAssignment_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// initExpression=OclExpressionCS
protected class IteratorAccumulatorCS_InitExpressionAssignment_4 extends AssignmentToken  {
	
	public IteratorAccumulatorCS_InitExpressionAssignment_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIteratorAccumulatorCSAccess().getInitExpressionAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("initExpression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("initExpression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getIteratorAccumulatorCSAccess().getInitExpressionOclExpressionCSParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IteratorAccumulatorCS_EqualsSignKeyword_3(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule iteratorAccumulatorCS ****************/


/************ begin Rule implicitCallExpCS ****************
 *
 * implicitCallExpCS returns OclExpressionCS:
 *   preCallExpCS; 
 * 
 * 	    
 * 		
 * //    	(	(({ImplicitIndexExpCS.calls=current} '[' indexes+=OclExpressionCS (',' indexes+=OclExpressionCS)* ']')?)
 * //    	|	(({ImplicitCallExpCS.calls=current} '(' (arguments+=OclExpressionCS (',' arguments+=OclExpressionCS)*)? ')')?)
 * //    	)
 *
 **/

// preCallExpCS 
// 		
// //    	(	(({ImplicitIndexExpCS.calls=current} '[' indexes+=OclExpressionCS (',' indexes+=OclExpressionCS)* ']')?)
// //    	|	(({ImplicitCallExpCS.calls=current} '(' (arguments+=OclExpressionCS (',' arguments+=OclExpressionCS)*)? ')')?)
// //    	)
protected class ImplicitCallExpCS_PreCallExpCSParserRuleCall extends RuleCallToken {
	
	public ImplicitCallExpCS_PreCallExpCSParserRuleCall(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getImplicitCallExpCSAccess().getPreCallExpCSParserRuleCall();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PreCallExpCS_ExtendedPrimaryExpCSParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getImplicitCallExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(PreCallExpCS_ExtendedPrimaryExpCSParserRuleCall.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getPreCallExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

/************ end Rule implicitCallExpCS ****************/


/************ begin Rule preCallExpCS ****************
 *
 * preCallExpCS returns OclExpressionCS:
 *   extendedPrimaryExpCS; 
 * 	
 * 	    
 * 		
 * //	|	source=primaryExpCS isPre?='@pre'
 *
 **/

// extendedPrimaryExpCS 
// 		
// //	|	source=primaryExpCS isPre?='@pre'
protected class PreCallExpCS_ExtendedPrimaryExpCSParserRuleCall extends RuleCallToken {
	
	public PreCallExpCS_ExtendedPrimaryExpCSParserRuleCall(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPreCallExpCSAccess().getExtendedPrimaryExpCSParserRuleCall();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new ExtendedPrimaryExpCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getPreCallExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(ExtendedPrimaryExpCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getExtendedPrimaryExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

/************ end Rule preCallExpCS ****************/


/************ begin Rule SimpleNameExpCS ****************
 *
 * SimpleNameExpCS returns OclExpressionCS:
 *   simpleNameCS; 
 *         
 *           // AssociationClassCallExpCS[B.1.1],
 *                          // PropertyCallExpCS[B],VariableExpCS[.1]
 *
 **/

// simpleNameCS   // AssociationClassCallExpCS[B.1.1],
//                          // PropertyCallExpCS[B],VariableExpCS[.1]
protected class SimpleNameExpCS_SimpleNameCSParserRuleCall extends RuleCallToken {
	
	public SimpleNameExpCS_SimpleNameCSParserRuleCall(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSimpleNameExpCSAccess().getSimpleNameCSParserRuleCall();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getSimpleNameExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(SimpleNameCS_ValueAssignment.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

/************ end Rule SimpleNameExpCS ****************/


/************ begin Rule primaryExpCS ****************
 *
 * primaryExpCS returns OclExpressionCS:
 *   selfKeywordCS|LiteralExpCS|IfExpCS|"(" OclExpressionCS ")"; 
 * 
 *         
 * 			 // The only VariableExpCS not parsed as a TypeLiteralExpCS
 *      	      // OclExpressionCS[C]
 *      	           // OclExpressionCS[F]
 *
 **/

// selfKeywordCS|LiteralExpCS|IfExpCS|"(" OclExpressionCS ")" 
// 
//         
// 			 // The only VariableExpCS not parsed as a TypeLiteralExpCS
//      	      // OclExpressionCS[C]
//      	           // OclExpressionCS[F]
protected class PrimaryExpCS_Alternatives extends AlternativesToken {

	public PrimaryExpCS_Alternatives(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getPrimaryExpCSAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimaryExpCS_SelfKeywordCSParserRuleCall_0(parent, this, 0, inst);
			case 1: return new PrimaryExpCS_LiteralExpCSParserRuleCall_1(parent, this, 1, inst);
			case 2: return new PrimaryExpCS_IfExpCSParserRuleCall_2(parent, this, 2, inst);
			case 3: return new PrimaryExpCS_Group_3(parent, this, 3, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getPrimaryExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// selfKeywordCS 
// 			 // The only VariableExpCS not parsed as a TypeLiteralExpCS
protected class PrimaryExpCS_SelfKeywordCSParserRuleCall_0 extends RuleCallToken {
	
	public PrimaryExpCS_SelfKeywordCSParserRuleCall_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimaryExpCSAccess().getSelfKeywordCSParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SelfKeywordCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(SelfKeywordCS_ValueAssignment.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getSelfKeywordCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// LiteralExpCS 	      // OclExpressionCS[C]
protected class PrimaryExpCS_LiteralExpCSParserRuleCall_1 extends RuleCallToken {
	
	public PrimaryExpCS_LiteralExpCSParserRuleCall_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LiteralExpCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(LiteralExpCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getLiteralExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// IfExpCS 	           // OclExpressionCS[F]
protected class PrimaryExpCS_IfExpCSParserRuleCall_2 extends RuleCallToken {
	
	public PrimaryExpCS_IfExpCSParserRuleCall_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IfExpCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(IfExpCS_Group.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getIfExpCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, inst);
		}	
	}	
}

// "(" OclExpressionCS ")"
protected class PrimaryExpCS_Group_3 extends GroupToken {
	
	public PrimaryExpCS_Group_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPrimaryExpCSAccess().getGroup_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimaryExpCS_RightParenthesisKeyword_3_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// "("
protected class PrimaryExpCS_LeftParenthesisKeyword_3_0 extends KeywordToken  {
	
	public PrimaryExpCS_LeftParenthesisKeyword_3_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPrimaryExpCSAccess().getLeftParenthesisKeyword_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// OclExpressionCS
protected class PrimaryExpCS_OclExpressionCSParserRuleCall_3_1 extends RuleCallToken {
	
	public PrimaryExpCS_OclExpressionCSParserRuleCall_3_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getPrimaryExpCSAccess().getOclExpressionCSParserRuleCall_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	protected IInstanceDescription tryConsumeVal() {
		if(checkForRecursion(OclExpressionCS_Alternatives.class, current)) return null;
		if(!current.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) return null;
		return current;
	}
	
    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimaryExpCS_LeftParenthesisKeyword_3_0(parent, next, actIndex, inst);
			default: return null;
		}	
	}	
}

// ")"
protected class PrimaryExpCS_RightParenthesisKeyword_3_2 extends KeywordToken  {
	
	public PrimaryExpCS_RightParenthesisKeyword_3_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPrimaryExpCSAccess().getRightParenthesisKeyword_3_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new PrimaryExpCS_OclExpressionCSParserRuleCall_3_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}



/************ end Rule primaryExpCS ****************/


/************ begin Rule IfExpCS ****************
 *
 * IfExpCS:
 *   "if" condition=OclExpressionCS "then" thenExpression=OclExpressionCS "else"
 *   elseExpression=OclExpressionCS "endif";
 *
 **/

// "if" condition=OclExpressionCS "then" thenExpression=OclExpressionCS "else"
// elseExpression=OclExpressionCS "endif"
protected class IfExpCS_Group extends GroupToken {
	
	public IfExpCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getIfExpCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IfExpCS_EndifKeyword_6(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getIfExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "if"
protected class IfExpCS_IfKeyword_0 extends KeywordToken  {
	
	public IfExpCS_IfKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIfExpCSAccess().getIfKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// condition=OclExpressionCS
protected class IfExpCS_ConditionAssignment_1 extends AssignmentToken  {
	
	public IfExpCS_ConditionAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIfExpCSAccess().getConditionAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("condition",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("condition");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getIfExpCSAccess().getConditionOclExpressionCSParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IfExpCS_IfKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "then"
protected class IfExpCS_ThenKeyword_2 extends KeywordToken  {
	
	public IfExpCS_ThenKeyword_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIfExpCSAccess().getThenKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IfExpCS_ConditionAssignment_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// thenExpression=OclExpressionCS
protected class IfExpCS_ThenExpressionAssignment_3 extends AssignmentToken  {
	
	public IfExpCS_ThenExpressionAssignment_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIfExpCSAccess().getThenExpressionAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("thenExpression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("thenExpression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getIfExpCSAccess().getThenExpressionOclExpressionCSParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IfExpCS_ThenKeyword_2(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "else"
protected class IfExpCS_ElseKeyword_4 extends KeywordToken  {
	
	public IfExpCS_ElseKeyword_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIfExpCSAccess().getElseKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IfExpCS_ThenExpressionAssignment_3(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// elseExpression=OclExpressionCS
protected class IfExpCS_ElseExpressionAssignment_5 extends AssignmentToken  {
	
	public IfExpCS_ElseExpressionAssignment_5(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIfExpCSAccess().getElseExpressionAssignment_5();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("elseExpression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("elseExpression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getIfExpCSAccess().getElseExpressionOclExpressionCSParserRuleCall_5_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IfExpCS_ElseKeyword_4(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "endif"
protected class IfExpCS_EndifKeyword_6 extends KeywordToken  {
	
	public IfExpCS_EndifKeyword_6(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIfExpCSAccess().getEndifKeyword_6();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new IfExpCS_ElseExpressionAssignment_5(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}


/************ end Rule IfExpCS ****************/


/************ begin Rule LetExpCS ****************
 *
 * LetExpCS:
 *   "let" variable+=LetVariableCS ("," variable+=LetVariableCS)* "in" in=OclExpressionCS;
 *
 **/

// "let" variable+=LetVariableCS ("," variable+=LetVariableCS)* "in" in=OclExpressionCS
protected class LetExpCS_Group extends GroupToken {
	
	public LetExpCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLetExpCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetExpCS_InAssignment_4(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getLetExpCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// "let"
protected class LetExpCS_LetKeyword_0 extends KeywordToken  {
	
	public LetExpCS_LetKeyword_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLetExpCSAccess().getLetKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			default: return parent.createParentFollower(this, index, index, inst);
		}	
	}	
		
}

// variable+=LetVariableCS
protected class LetExpCS_VariableAssignment_1 extends AssignmentToken  {
	
	public LetExpCS_VariableAssignment_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLetExpCSAccess().getVariableAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetVariableCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("variable",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("variable");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetVariableCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LetExpCS_LetKeyword_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," variable+=LetVariableCS)*
protected class LetExpCS_Group_2 extends GroupToken {
	
	public LetExpCS_Group_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLetExpCSAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetExpCS_VariableAssignment_2_1(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// ","
protected class LetExpCS_CommaKeyword_2_0 extends KeywordToken  {
	
	public LetExpCS_CommaKeyword_2_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetExpCS_Group_2(parent, this, 0, inst);
			case 1: return new LetExpCS_VariableAssignment_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// variable+=LetVariableCS
protected class LetExpCS_VariableAssignment_2_1 extends AssignmentToken  {
	
	public LetExpCS_VariableAssignment_2_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLetExpCSAccess().getVariableAssignment_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetVariableCS_Group(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("variable",false)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("variable");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLetVariableCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LetExpCS_CommaKeyword_2_0(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// "in"
protected class LetExpCS_InKeyword_3 extends KeywordToken  {
	
	public LetExpCS_InKeyword_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLetExpCSAccess().getInKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetExpCS_Group_2(parent, this, 0, inst);
			case 1: return new LetExpCS_VariableAssignment_1(parent, this, 1, inst);
			default: return null;
		}	
	}	
		
}

// in=OclExpressionCS
protected class LetExpCS_InAssignment_4 extends AssignmentToken  {
	
	public LetExpCS_InAssignment_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLetExpCSAccess().getInAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("in",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("in");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getLetExpCSAccess().getInOclExpressionCSParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LetExpCS_InKeyword_3(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule LetExpCS ****************/


/************ begin Rule LetVariableCS ****************
 *
 * LetVariableCS returns VariableCS:
 *   name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS;
 *
 **/

// name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS
protected class LetVariableCS_Group extends GroupToken {
	
	public LetVariableCS_Group(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLetVariableCSAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetVariableCS_InitExpressionAssignment_4(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override
	public IInstanceDescription tryConsume() {
		if(!current.isInstanceOf(grammarAccess.getLetVariableCSRule().getType().getClassifier())) return null;
		return tryConsumeVal();
	}
}

// name=simpleNameCS
protected class LetVariableCS_NameAssignment_0 extends AssignmentToken  {
	
	public LetVariableCS_NameAssignment_0(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLetVariableCSAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new SimpleNameCS_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("name",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleNameCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getLetVariableCSAccess().getNameSimpleNameCSParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			default: return parent.createParentFollower(next, actIndex , index, consumed);
		}	
	}	
}

// ":"
protected class LetVariableCS_ColonKeyword_1 extends KeywordToken  {
	
	public LetVariableCS_ColonKeyword_1(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLetVariableCSAccess().getColonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetVariableCS_NameAssignment_0(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// type=typeCS
protected class LetVariableCS_TypeAssignment_2 extends AssignmentToken  {
	
	public LetVariableCS_TypeAssignment_2(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLetVariableCSAccess().getTypeAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new TypeCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("type",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getLetVariableCSAccess().getTypeTypeCSParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LetVariableCS_ColonKeyword_1(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "="
protected class LetVariableCS_EqualsSignKeyword_3 extends KeywordToken  {
	
	public LetVariableCS_EqualsSignKeyword_3(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new LetVariableCS_TypeAssignment_2(parent, this, 0, inst);
			default: return null;
		}	
	}	
		
}

// initExpression=OclExpressionCS
protected class LetVariableCS_InitExpressionAssignment_4 extends AssignmentToken  {
	
	public LetVariableCS_InitExpressionAssignment_4(AbstractToken parent, AbstractToken next, int no, IInstanceDescription current) {
		super(parent, next, no, current);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLetVariableCSAccess().getInitExpressionAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IInstanceDescription inst) {
		switch(index) {
			case 0: return new OclExpressionCS_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}	
		
    @Override	
	protected IInstanceDescription tryConsumeVal() {
		if((value = current.getConsumable("initExpression",true)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("initExpression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOclExpressionCSRule().getType().getClassifier())) {
				type = AssignmentType.PRC;
				element = grammarAccess.getLetVariableCSAccess().getInitExpressionOclExpressionCSParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createParentFollower(AbstractToken next,	int actIndex, int index, IInstanceDescription inst) {
		if(value == inst.getDelegate() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LetVariableCS_EqualsSignKeyword_3(parent, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule LetVariableCS ****************/

}
