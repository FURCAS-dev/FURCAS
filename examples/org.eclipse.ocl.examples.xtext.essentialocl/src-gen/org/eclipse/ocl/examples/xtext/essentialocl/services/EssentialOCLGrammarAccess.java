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
 * $Id: EssentialOCLGrammarAccess.java,v 1.1 2010/04/13 06:32:27 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.essentialocl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class EssentialOCLGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final RuleCall cOclExpressionCSParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//Model returns OclExpressionCS:
		//  OclExpressionCS;  
		////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
		public ParserRule getRule() { return rule; }

		//OclExpressionCS
		public RuleCall getOclExpressionCSParserRuleCall() { return cOclExpressionCSParserRuleCall; }
	}

	public class REAL_LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "REAL_LITERAL");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Keyword cFullStopKeyword_1_0_0 = (Keyword)cGroup_1_0.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_0_1 = (RuleCall)cGroup_1_0.eContents().get(1);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cGroup_1_1.eContents().get(0);
		private final Keyword cFullStopKeyword_1_1_0_0 = (Keyword)cGroup_1_1_0.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_1_0_1 = (RuleCall)cGroup_1_1_0.eContents().get(1);
		private final Alternatives cAlternatives_1_1_1 = (Alternatives)cGroup_1_1.eContents().get(1);
		private final Keyword cEKeyword_1_1_1_0 = (Keyword)cAlternatives_1_1_1.eContents().get(0);
		private final Keyword cEKeyword_1_1_1_1 = (Keyword)cAlternatives_1_1_1.eContents().get(1);
		private final Alternatives cAlternatives_1_1_2 = (Alternatives)cGroup_1_1.eContents().get(2);
		private final Keyword cPlusSignKeyword_1_1_2_0 = (Keyword)cAlternatives_1_1_2.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1_1_2_1 = (Keyword)cAlternatives_1_1_2.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1_1_3 = (RuleCall)cGroup_1_1.eContents().get(3);
		
		//REAL_LITERAL returns ecore::EBigDecimal:
		//  INT ("." INT|("." INT)? ("e"|"E") ("+"|"-")? INT); 
		//
		//    				 // Not terminal to allow parser backtracking to sort out "5..7"
		public ParserRule getRule() { return rule; }

		//INT ("." INT|("." INT)? ("e"|"E") ("+"|"-")? INT) 				 // Not terminal to allow parser backtracking to sort out "5..7"
		public Group getGroup() { return cGroup; }

		//INT 				 // Not terminal to allow parser backtracking to sort out "5..7"
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }

		//"." INT|("." INT)? ("e"|"E") ("+"|"-")? INT
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//"." INT
		public Group getGroup_1_0() { return cGroup_1_0; }

		//"."
		public Keyword getFullStopKeyword_1_0_0() { return cFullStopKeyword_1_0_0; }

		//INT
		public RuleCall getINTTerminalRuleCall_1_0_1() { return cINTTerminalRuleCall_1_0_1; }

		//("." INT)? ("e"|"E") ("+"|"-")? INT
		public Group getGroup_1_1() { return cGroup_1_1; }

		//("." INT)?
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }

		//"."
		public Keyword getFullStopKeyword_1_1_0_0() { return cFullStopKeyword_1_1_0_0; }

		//INT
		public RuleCall getINTTerminalRuleCall_1_1_0_1() { return cINTTerminalRuleCall_1_1_0_1; }

		//"e"|"E"
		public Alternatives getAlternatives_1_1_1() { return cAlternatives_1_1_1; }

		//"e"
		public Keyword getEKeyword_1_1_1_0() { return cEKeyword_1_1_1_0; }

		//"E"
		public Keyword getEKeyword_1_1_1_1() { return cEKeyword_1_1_1_1; }

		//("+"|"-")?
		public Alternatives getAlternatives_1_1_2() { return cAlternatives_1_1_2; }

		//"+"
		public Keyword getPlusSignKeyword_1_1_2_0() { return cPlusSignKeyword_1_1_2_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_1_1_2_1() { return cHyphenMinusKeyword_1_1_2_1; }

		//INT
		public RuleCall getINTTerminalRuleCall_1_1_3() { return cINTTerminalRuleCall_1_1_3; }
	}

	public class INTEGER_LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "INTEGER_LITERAL");
		private final RuleCall cINTTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//INTEGER_LITERAL returns ecore::EBigInteger:
		//  INT;
		public ParserRule getRule() { return rule; }

		//INT
		public RuleCall getINTTerminalRuleCall() { return cINTTerminalRuleCall; }
	}

	public class TupleKeywordCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "tupleKeywordCS");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final Keyword cValueTupleKeyword_0 = (Keyword)cValueAssignment.eContents().get(0);
		
		//tupleKeywordCS returns SimpleNameCS:
		//  value="Tuple"; 
		//	
		////---------------------------------------------------------------------
		////  Names
		////---------------------------------------------------------------------
		/// *  Temporary backward compatibility support for 7.4.8 conceptual usage 
		//    conceptualOperationName returns SimpleNameCS:
		//    	value='and'
		//    	| value='implies'
		//    	| value='not'
		//    	| value='or'
		//    	| value='xor'
		//    	| value='<'
		//    	| value='<='
		//    	| value='>='
		//    	| value='>'
		//    	| value='='
		//    	| value='<>'
		//    	| value='+'
		//    	| value='-'
		//    	| value='*'
		//    	| value='/';
		//    conceptualOperationNameCS returns SimpleNameCS:
		//    	conceptualOperationName; * /
		//    
		/// *    reservedKeyword returns SimpleNameCS: 
		//    	value='and'
		//    	| value='else'
		//    	| value='endif'
		//    	| value='if'
		//    	| value='implies'
		//    	| value='in'
		//    	| value='let'
		//    	| value='not'
		//    	| value='or'
		//    	| value='then'
		//    	| value='xor'; * /
		//
		//        
		//    	
		//    
		////    reservedKeywordCS returns SimpleNameCS:
		////    	reservedKeyword;
		public ParserRule getRule() { return rule; }

		//value="Tuple"
		public Assignment getValueAssignment() { return cValueAssignment; }

		//"Tuple"
		public Keyword getValueTupleKeyword_0() { return cValueTupleKeyword_0; }
	}

	public class RestrictedKeywordCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "restrictedKeywordCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCollectionTypeIdentifierCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPrimitiveTypeCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cTupleKeywordCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//restrictedKeywordCS returns SimpleNameCS:
		//  CollectionTypeIdentifierCS|primitiveTypeCS|tupleKeywordCS; 
		//    
		////    reservedKeywordCS returns SimpleNameCS:
		////    	reservedKeyword;
		//    
		//         
		//    	
		////  restrictedKeywordCS -> BooleanLiteralExpCS
		////  restrictedKeywordCS -> InvalidLiteralExpCS
		////  restrictedKeywordCS -> NullLiteralExpCS
		////-  restrictedKeywordCS -> selfKeywordCS
		public ParserRule getRule() { return rule; }

		//CollectionTypeIdentifierCS|primitiveTypeCS|tupleKeywordCS 
		//    
		////    reservedKeywordCS returns SimpleNameCS:
		////    	reservedKeyword;
		//    
		//         
		//    	
		////  restrictedKeywordCS -> BooleanLiteralExpCS
		////  restrictedKeywordCS -> InvalidLiteralExpCS
		////  restrictedKeywordCS -> NullLiteralExpCS
		////-  restrictedKeywordCS -> selfKeywordCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//CollectionTypeIdentifierCS  
		//    	
		////  restrictedKeywordCS -> BooleanLiteralExpCS
		////  restrictedKeywordCS -> InvalidLiteralExpCS
		////  restrictedKeywordCS -> NullLiteralExpCS
		////-  restrictedKeywordCS -> selfKeywordCS
		public RuleCall getCollectionTypeIdentifierCSParserRuleCall_0() { return cCollectionTypeIdentifierCSParserRuleCall_0; }

		//primitiveTypeCS
		public RuleCall getPrimitiveTypeCSParserRuleCall_1() { return cPrimitiveTypeCSParserRuleCall_1; }

		//tupleKeywordCS
		public RuleCall getTupleKeywordCSParserRuleCall_2() { return cTupleKeywordCSParserRuleCall_2; }
	}

	public class SelfKeywordCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "selfKeywordCS");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final Keyword cValueSelfKeyword_0 = (Keyword)cValueAssignment.eContents().get(0);
		
		//selfKeywordCS returns SimpleNameCS:
		//  value="self";
		public ParserRule getRule() { return rule; }

		//value="self"
		public Assignment getValueAssignment() { return cValueAssignment; }

		//"self"
		public Keyword getValueSelfKeyword_0() { return cValueSelfKeyword_0; }
	}

	public class SimpleNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "simpleNameCS");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueIDTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//simpleNameCS returns SimpleNameCS:
		//  value=ID;
		public ParserRule getRule() { return rule; }

		//value=ID
		public Assignment getValueAssignment() { return cValueAssignment; }

		//ID
		public RuleCall getValueIDTerminalRuleCall_0() { return cValueIDTerminalRuleCall_0; }
	}

	public class UnreservedSimpleNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "unreservedSimpleNameCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSimpleNameCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRestrictedKeywordCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//unreservedSimpleNameCS returns SimpleNameCS:
		//  simpleNameCS|restrictedKeywordCS;
		public ParserRule getRule() { return rule; }

		//simpleNameCS|restrictedKeywordCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//simpleNameCS
		public RuleCall getSimpleNameCSParserRuleCall_0() { return cSimpleNameCSParserRuleCall_0; }

		//restrictedKeywordCS
		public RuleCall getRestrictedKeywordCSParserRuleCall_1() { return cRestrictedKeywordCSParserRuleCall_1; }
	}

	public class PathNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "pathNameCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSimpleNamesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cSimpleNamesSimpleNameCSParserRuleCall_0_0 = (RuleCall)cSimpleNamesAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cSimpleNamesAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cSimpleNamesUnreservedSimpleNameCSParserRuleCall_1_1_0 = (RuleCall)cSimpleNamesAssignment_1_1.eContents().get(0);
		
		//pathNameCS returns PathNameCS:
		//  simpleNames+=simpleNameCS ("::" simpleNames+=unreservedSimpleNameCS)*; 
		//
		//        
		//    	    
		//
		//        
		////---------------------------------------------------------------------
		////  Types
		////---------------------------------------------------------------------
		public ParserRule getRule() { return rule; }

		//simpleNames+=simpleNameCS ("::" simpleNames+=unreservedSimpleNameCS)*
		public Group getGroup() { return cGroup; }

		//simpleNames+=simpleNameCS
		public Assignment getSimpleNamesAssignment_0() { return cSimpleNamesAssignment_0; }

		//simpleNameCS
		public RuleCall getSimpleNamesSimpleNameCSParserRuleCall_0_0() { return cSimpleNamesSimpleNameCSParserRuleCall_0_0; }

		//("::" simpleNames+=unreservedSimpleNameCS)*
		public Group getGroup_1() { return cGroup_1; }

		//"::"
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }

		//simpleNames+=unreservedSimpleNameCS
		public Assignment getSimpleNamesAssignment_1_1() { return cSimpleNamesAssignment_1_1; }

		//unreservedSimpleNameCS
		public RuleCall getSimpleNamesUnreservedSimpleNameCSParserRuleCall_1_1_0() { return cSimpleNamesUnreservedSimpleNameCSParserRuleCall_1_1_0; }
	}

	public class PrimitiveTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "primitiveTypeCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final Keyword cValueBooleanKeyword_0_0 = (Keyword)cValueAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cValueIntegerKeyword_1_0 = (Keyword)cValueAssignment_1.eContents().get(0);
		private final Assignment cValueAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final Keyword cValueRealKeyword_2_0 = (Keyword)cValueAssignment_2.eContents().get(0);
		private final Assignment cValueAssignment_3 = (Assignment)cAlternatives.eContents().get(3);
		private final Keyword cValueStringKeyword_3_0 = (Keyword)cValueAssignment_3.eContents().get(0);
		private final Assignment cValueAssignment_4 = (Assignment)cAlternatives.eContents().get(4);
		private final Keyword cValueUnlimitedNaturalKeyword_4_0 = (Keyword)cValueAssignment_4.eContents().get(0);
		private final Assignment cValueAssignment_5 = (Assignment)cAlternatives.eContents().get(5);
		private final Keyword cValueOclAnyKeyword_5_0 = (Keyword)cValueAssignment_5.eContents().get(0);
		private final Assignment cValueAssignment_6 = (Assignment)cAlternatives.eContents().get(6);
		private final Keyword cValueOclInvalidKeyword_6_0 = (Keyword)cValueAssignment_6.eContents().get(0);
		private final Assignment cValueAssignment_7 = (Assignment)cAlternatives.eContents().get(7);
		private final Keyword cValueOclVoidKeyword_7_0 = (Keyword)cValueAssignment_7.eContents().get(0);
		
		//primitiveTypeCS returns SimpleNameCS:
		//  value="Boolean"|value="Integer"|value="Real"|value="String"|value=
		//  "UnlimitedNatural"|value="OclAny"|value="OclInvalid"|value="OclVoid"; 
		//
		//        
		////---------------------------------------------------------------------
		////  Types
		////---------------------------------------------------------------------
		public ParserRule getRule() { return rule; }

		//value="Boolean"|value="Integer"|value="Real"|value="String"|value=
		//"UnlimitedNatural"|value="OclAny"|value="OclInvalid"|value="OclVoid" 
		//
		//        
		////---------------------------------------------------------------------
		////  Types
		////---------------------------------------------------------------------
		public Alternatives getAlternatives() { return cAlternatives; }

		//value="Boolean"
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//"Boolean"
		public Keyword getValueBooleanKeyword_0_0() { return cValueBooleanKeyword_0_0; }

		//value="Integer"
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//"Integer"
		public Keyword getValueIntegerKeyword_1_0() { return cValueIntegerKeyword_1_0; }

		//value="Real"
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//"Real"
		public Keyword getValueRealKeyword_2_0() { return cValueRealKeyword_2_0; }

		//value="String"
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }

		//"String"
		public Keyword getValueStringKeyword_3_0() { return cValueStringKeyword_3_0; }

		//value="UnlimitedNatural"
		public Assignment getValueAssignment_4() { return cValueAssignment_4; }

		//"UnlimitedNatural"
		public Keyword getValueUnlimitedNaturalKeyword_4_0() { return cValueUnlimitedNaturalKeyword_4_0; }

		//value="OclAny"
		public Assignment getValueAssignment_5() { return cValueAssignment_5; }

		//"OclAny"
		public Keyword getValueOclAnyKeyword_5_0() { return cValueOclAnyKeyword_5_0; }

		//value="OclInvalid"
		public Assignment getValueAssignment_6() { return cValueAssignment_6; }

		//"OclInvalid"
		public Keyword getValueOclInvalidKeyword_6_0() { return cValueOclInvalidKeyword_6_0; }

		//value="OclVoid"
		public Assignment getValueAssignment_7() { return cValueAssignment_7; }

		//"OclVoid"
		public Keyword getValueOclVoidKeyword_7_0() { return cValueOclVoidKeyword_7_0; }
	}

	public class CollectionTypeIdentifierCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CollectionTypeIdentifierCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final Keyword cValueSetKeyword_0_0 = (Keyword)cValueAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cValueBagKeyword_1_0 = (Keyword)cValueAssignment_1.eContents().get(0);
		private final Assignment cValueAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final Keyword cValueSequenceKeyword_2_0 = (Keyword)cValueAssignment_2.eContents().get(0);
		private final Assignment cValueAssignment_3 = (Assignment)cAlternatives.eContents().get(3);
		private final Keyword cValueCollectionKeyword_3_0 = (Keyword)cValueAssignment_3.eContents().get(0);
		private final Assignment cValueAssignment_4 = (Assignment)cAlternatives.eContents().get(4);
		private final Keyword cValueOrderedSetKeyword_4_0 = (Keyword)cValueAssignment_4.eContents().get(0);
		
		//CollectionTypeIdentifierCS returns SimpleNameCS:
		//  value="Set"|value="Bag"|value="Sequence"|value="Collection"|value="OrderedSet";
		public ParserRule getRule() { return rule; }

		//value="Set"|value="Bag"|value="Sequence"|value="Collection"|value="OrderedSet"
		public Alternatives getAlternatives() { return cAlternatives; }

		//value="Set"
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//"Set"
		public Keyword getValueSetKeyword_0_0() { return cValueSetKeyword_0_0; }

		//value="Bag"
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//"Bag"
		public Keyword getValueBagKeyword_1_0() { return cValueBagKeyword_1_0; }

		//value="Sequence"
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//"Sequence"
		public Keyword getValueSequenceKeyword_2_0() { return cValueSequenceKeyword_2_0; }

		//value="Collection"
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }

		//"Collection"
		public Keyword getValueCollectionKeyword_3_0() { return cValueCollectionKeyword_3_0; }

		//value="OrderedSet"
		public Assignment getValueAssignment_4() { return cValueAssignment_4; }

		//"OrderedSet"
		public Keyword getValueOrderedSetKeyword_4_0() { return cValueOrderedSetKeyword_4_0; }
	}

	public class TypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "typeCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPrimitiveTypeCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPathNameCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cCollectionTypeCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cTupleTypeCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//typeCS returns TypeCS:
		//  primitiveTypeCS|pathNameCS|collectionTypeCS|tupleTypeCS;
		public ParserRule getRule() { return rule; }

		//primitiveTypeCS|pathNameCS|collectionTypeCS|tupleTypeCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//primitiveTypeCS
		public RuleCall getPrimitiveTypeCSParserRuleCall_0() { return cPrimitiveTypeCSParserRuleCall_0; }

		//pathNameCS
		public RuleCall getPathNameCSParserRuleCall_1() { return cPathNameCSParserRuleCall_1; }

		//collectionTypeCS
		public RuleCall getCollectionTypeCSParserRuleCall_2() { return cCollectionTypeCSParserRuleCall_2; }

		//tupleTypeCS
		public RuleCall getTupleTypeCSParserRuleCall_3() { return cTupleTypeCSParserRuleCall_3; }
	}

	public class CollectionTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "collectionTypeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cValueCollectionTypeIdentifierCSParserRuleCall_0_0 = (RuleCall)cValueAssignment_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeCSAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeCSTypeCSParserRuleCall_2_0 = (RuleCall)cTypeCSAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//collectionTypeCS returns CollectionTypeCS:
		//  value=CollectionTypeIdentifierCS "(" typeCS=typeCS ")";
		public ParserRule getRule() { return rule; }

		//value=CollectionTypeIdentifierCS "(" typeCS=typeCS ")"
		public Group getGroup() { return cGroup; }

		//value=CollectionTypeIdentifierCS
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//CollectionTypeIdentifierCS
		public RuleCall getValueCollectionTypeIdentifierCSParserRuleCall_0_0() { return cValueCollectionTypeIdentifierCSParserRuleCall_0_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//typeCS=typeCS
		public Assignment getTypeCSAssignment_2() { return cTypeCSAssignment_2; }

		//typeCS
		public RuleCall getTypeCSTypeCSParserRuleCall_2_0() { return cTypeCSTypeCSParserRuleCall_2_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class TupleTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "tupleTypeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cValueTupleKeyword_0_0 = (Keyword)cValueAssignment_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cPartAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cPartTuplePartCSParserRuleCall_2_0_0 = (RuleCall)cPartAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cPartAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cPartTuplePartCSParserRuleCall_2_1_1_0 = (RuleCall)cPartAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//tupleTypeCS returns TupleTypeCS:
		//  value="Tuple" "(" (part+=tuplePartCS ("," part+=tuplePartCS)*)? ")";
		public ParserRule getRule() { return rule; }

		//value="Tuple" "(" (part+=tuplePartCS ("," part+=tuplePartCS)*)? ")"
		public Group getGroup() { return cGroup; }

		//value="Tuple"
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//"Tuple"
		public Keyword getValueTupleKeyword_0_0() { return cValueTupleKeyword_0_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(part+=tuplePartCS ("," part+=tuplePartCS)*)?
		public Group getGroup_2() { return cGroup_2; }

		//part+=tuplePartCS
		public Assignment getPartAssignment_2_0() { return cPartAssignment_2_0; }

		//tuplePartCS
		public RuleCall getPartTuplePartCSParserRuleCall_2_0_0() { return cPartTuplePartCSParserRuleCall_2_0_0; }

		//("," part+=tuplePartCS)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//part+=tuplePartCS
		public Assignment getPartAssignment_2_1_1() { return cPartAssignment_2_1_1; }

		//tuplePartCS
		public RuleCall getPartTuplePartCSParserRuleCall_2_1_1_0() { return cPartTuplePartCSParserRuleCall_2_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class TuplePartCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "tuplePartCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameSimpleNameCSParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeTypeCSParserRuleCall_2_0 = (RuleCall)cTypeAssignment_2.eContents().get(0);
		
		//tuplePartCS returns VariableCS:
		//  name=simpleNameCS ":" type=typeCS; 
		//        
		//    
		//	    
		//
		//
		////---------------------------------------------------------------------
		////  Literals
		////---------------------------------------------------------------------
		//// EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
		////  LiteralExpCS -> EnumLiteralExpCS
		public ParserRule getRule() { return rule; }

		//name=simpleNameCS ":" type=typeCS
		public Group getGroup() { return cGroup; }

		//name=simpleNameCS
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//simpleNameCS
		public RuleCall getNameSimpleNameCSParserRuleCall_0_0() { return cNameSimpleNameCSParserRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//type=typeCS
		public Assignment getTypeAssignment_2() { return cTypeAssignment_2; }

		//typeCS
		public RuleCall getTypeTypeCSParserRuleCall_2_0() { return cTypeTypeCSParserRuleCall_2_0; }
	}

	public class LiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LiteralExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCollectionLiteralExpCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTupleLiteralExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cPrimitiveLiteralExpCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cTypeLiteralExpCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//LiteralExpCS:
		//  CollectionLiteralExpCS|TupleLiteralExpCS|PrimitiveLiteralExpCS|TypeLiteralExpCS; 
		//
		////---------------------------------------------------------------------
		////  Literals
		////---------------------------------------------------------------------
		//// EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
		////  LiteralExpCS -> EnumLiteralExpCS
		public ParserRule getRule() { return rule; }

		//CollectionLiteralExpCS|TupleLiteralExpCS|PrimitiveLiteralExpCS|TypeLiteralExpCS 
		//
		////---------------------------------------------------------------------
		////  Literals
		////---------------------------------------------------------------------
		//// EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
		////  LiteralExpCS -> EnumLiteralExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//CollectionLiteralExpCS
		public RuleCall getCollectionLiteralExpCSParserRuleCall_0() { return cCollectionLiteralExpCSParserRuleCall_0; }

		//TupleLiteralExpCS
		public RuleCall getTupleLiteralExpCSParserRuleCall_1() { return cTupleLiteralExpCSParserRuleCall_1; }

		//PrimitiveLiteralExpCS
		public RuleCall getPrimitiveLiteralExpCSParserRuleCall_2() { return cPrimitiveLiteralExpCSParserRuleCall_2; }

		//TypeLiteralExpCS
		public RuleCall getTypeLiteralExpCSParserRuleCall_3() { return cTypeLiteralExpCSParserRuleCall_3; }
	}

	public class CollectionLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CollectionLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cCollectionTypeIdentifierCSParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cCollectionTypeCSParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cCollectionLiteralPartsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_0_0 = (RuleCall)cCollectionLiteralPartsAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cCollectionLiteralPartsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0 = (RuleCall)cCollectionLiteralPartsAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//CollectionLiteralExpCS:
		//  (CollectionTypeIdentifierCS|collectionTypeCS) "{" (collectionLiteralParts+=
		//  CollectionLiteralPartCS ("," collectionLiteralParts+=CollectionLiteralPartCS)*)?
		//  "}";
		public ParserRule getRule() { return rule; }

		//(CollectionTypeIdentifierCS|collectionTypeCS) "{" (collectionLiteralParts+=
		//CollectionLiteralPartCS ("," collectionLiteralParts+=CollectionLiteralPartCS)*)?
		//"}"
		public Group getGroup() { return cGroup; }

		//CollectionTypeIdentifierCS|collectionTypeCS
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//CollectionTypeIdentifierCS
		public RuleCall getCollectionTypeIdentifierCSParserRuleCall_0_0() { return cCollectionTypeIdentifierCSParserRuleCall_0_0; }

		//collectionTypeCS
		public RuleCall getCollectionTypeCSParserRuleCall_0_1() { return cCollectionTypeCSParserRuleCall_0_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//(collectionLiteralParts+=CollectionLiteralPartCS ("," collectionLiteralParts+=
		//CollectionLiteralPartCS)*)?
		public Group getGroup_2() { return cGroup_2; }

		//collectionLiteralParts+=CollectionLiteralPartCS
		public Assignment getCollectionLiteralPartsAssignment_2_0() { return cCollectionLiteralPartsAssignment_2_0; }

		//CollectionLiteralPartCS
		public RuleCall getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_0_0() { return cCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_0_0; }

		//("," collectionLiteralParts+=CollectionLiteralPartCS)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//collectionLiteralParts+=CollectionLiteralPartCS
		public Assignment getCollectionLiteralPartsAssignment_2_1_1() { return cCollectionLiteralPartsAssignment_2_1_1; }

		//CollectionLiteralPartCS
		public RuleCall getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0() { return cCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class CollectionLiteralPartCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CollectionLiteralPartCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpressionCSAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpressionCSOclExpressionCSParserRuleCall_0_0 = (RuleCall)cExpressionCSAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cLastExpressionCSAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cLastExpressionCSOclExpressionCSParserRuleCall_1_1_0 = (RuleCall)cLastExpressionCSAssignment_1_1.eContents().get(0);
		
		//CollectionLiteralPartCS:
		//  expressionCS=OclExpressionCS (".." lastExpressionCS=OclExpressionCS)?;
		public ParserRule getRule() { return rule; }

		//expressionCS=OclExpressionCS (".." lastExpressionCS=OclExpressionCS)?
		public Group getGroup() { return cGroup; }

		//expressionCS=OclExpressionCS
		public Assignment getExpressionCSAssignment_0() { return cExpressionCSAssignment_0; }

		//OclExpressionCS
		public RuleCall getExpressionCSOclExpressionCSParserRuleCall_0_0() { return cExpressionCSOclExpressionCSParserRuleCall_0_0; }

		//(".." lastExpressionCS=OclExpressionCS)?
		public Group getGroup_1() { return cGroup_1; }

		//".."
		public Keyword getFullStopFullStopKeyword_1_0() { return cFullStopFullStopKeyword_1_0; }

		//lastExpressionCS=OclExpressionCS
		public Assignment getLastExpressionCSAssignment_1_1() { return cLastExpressionCSAssignment_1_1; }

		//OclExpressionCS
		public RuleCall getLastExpressionCSOclExpressionCSParserRuleCall_1_1_0() { return cLastExpressionCSOclExpressionCSParserRuleCall_1_1_0; }
	}

	public class PrimitiveLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PrimitiveLiteralExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIntegerLiteralExpCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRealLiteralExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cStringLiteralExpCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cBooleanLiteralExpCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cUnlimitedNaturalLiteralExpCSParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cInvalidLiteralExpCSParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cNullLiteralExpCSParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		
		//PrimitiveLiteralExpCS:
		//  IntegerLiteralExpCS|RealLiteralExpCS|StringLiteralExpCS|BooleanLiteralExpCS|
		//  UnlimitedNaturalLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS;
		public ParserRule getRule() { return rule; }

		//IntegerLiteralExpCS|RealLiteralExpCS|StringLiteralExpCS|BooleanLiteralExpCS|
		//UnlimitedNaturalLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//IntegerLiteralExpCS
		public RuleCall getIntegerLiteralExpCSParserRuleCall_0() { return cIntegerLiteralExpCSParserRuleCall_0; }

		//RealLiteralExpCS
		public RuleCall getRealLiteralExpCSParserRuleCall_1() { return cRealLiteralExpCSParserRuleCall_1; }

		//StringLiteralExpCS
		public RuleCall getStringLiteralExpCSParserRuleCall_2() { return cStringLiteralExpCSParserRuleCall_2; }

		//BooleanLiteralExpCS
		public RuleCall getBooleanLiteralExpCSParserRuleCall_3() { return cBooleanLiteralExpCSParserRuleCall_3; }

		//UnlimitedNaturalLiteralExpCS
		public RuleCall getUnlimitedNaturalLiteralExpCSParserRuleCall_4() { return cUnlimitedNaturalLiteralExpCSParserRuleCall_4; }

		//InvalidLiteralExpCS
		public RuleCall getInvalidLiteralExpCSParserRuleCall_5() { return cInvalidLiteralExpCSParserRuleCall_5; }

		//NullLiteralExpCS
		public RuleCall getNullLiteralExpCSParserRuleCall_6() { return cNullLiteralExpCSParserRuleCall_6; }
	}

	public class TupleLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TupleLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTupleKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cPartAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cPartTupleLiteralPartCSParserRuleCall_2_0 = (RuleCall)cPartAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cCommaKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cPartAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cPartTupleLiteralPartCSParserRuleCall_3_1_0 = (RuleCall)cPartAssignment_3_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//TupleLiteralExpCS:
		//  "Tuple" "{" part+=TupleLiteralPartCS ("," part+=TupleLiteralPartCS)* "}";
		public ParserRule getRule() { return rule; }

		//"Tuple" "{" part+=TupleLiteralPartCS ("," part+=TupleLiteralPartCS)* "}"
		public Group getGroup() { return cGroup; }

		//"Tuple"
		public Keyword getTupleKeyword_0() { return cTupleKeyword_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//part+=TupleLiteralPartCS
		public Assignment getPartAssignment_2() { return cPartAssignment_2; }

		//TupleLiteralPartCS
		public RuleCall getPartTupleLiteralPartCSParserRuleCall_2_0() { return cPartTupleLiteralPartCSParserRuleCall_2_0; }

		//("," part+=TupleLiteralPartCS)*
		public Group getGroup_3() { return cGroup_3; }

		//","
		public Keyword getCommaKeyword_3_0() { return cCommaKeyword_3_0; }

		//part+=TupleLiteralPartCS
		public Assignment getPartAssignment_3_1() { return cPartAssignment_3_1; }

		//TupleLiteralPartCS
		public RuleCall getPartTupleLiteralPartCSParserRuleCall_3_1_0() { return cPartTupleLiteralPartCSParserRuleCall_3_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class TupleLiteralPartCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TupleLiteralPartCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameSimpleNameCSParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTypeTypeCSParserRuleCall_1_1_0 = (RuleCall)cTypeAssignment_1_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cInitExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cInitExpressionOclExpressionCSParserRuleCall_3_0 = (RuleCall)cInitExpressionAssignment_3.eContents().get(0);
		
		//TupleLiteralPartCS returns VariableCS:
		//  name=simpleNameCS (":" type=typeCS)? "=" initExpression=OclExpressionCS;
		public ParserRule getRule() { return rule; }

		//name=simpleNameCS (":" type=typeCS)? "=" initExpression=OclExpressionCS
		public Group getGroup() { return cGroup; }

		//name=simpleNameCS
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//simpleNameCS
		public RuleCall getNameSimpleNameCSParserRuleCall_0_0() { return cNameSimpleNameCSParserRuleCall_0_0; }

		//(":" type=typeCS)?
		public Group getGroup_1() { return cGroup_1; }

		//":"
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//type=typeCS
		public Assignment getTypeAssignment_1_1() { return cTypeAssignment_1_1; }

		//typeCS
		public RuleCall getTypeTypeCSParserRuleCall_1_1_0() { return cTypeTypeCSParserRuleCall_1_1_0; }

		//"="
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }

		//initExpression=OclExpressionCS
		public Assignment getInitExpressionAssignment_3() { return cInitExpressionAssignment_3; }

		//OclExpressionCS
		public RuleCall getInitExpressionOclExpressionCSParserRuleCall_3_0() { return cInitExpressionOclExpressionCSParserRuleCall_3_0; }
	}

	public class IntegerLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntegerLiteralExpCS");
		private final Assignment cIntegerSymbolAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cIntegerSymbolINTEGER_LITERALParserRuleCall_0 = (RuleCall)cIntegerSymbolAssignment.eContents().get(0);
		
		//IntegerLiteralExpCS:
		//  integerSymbol=INTEGER_LITERAL;
		public ParserRule getRule() { return rule; }

		//integerSymbol=INTEGER_LITERAL
		public Assignment getIntegerSymbolAssignment() { return cIntegerSymbolAssignment; }

		//INTEGER_LITERAL
		public RuleCall getIntegerSymbolINTEGER_LITERALParserRuleCall_0() { return cIntegerSymbolINTEGER_LITERALParserRuleCall_0; }
	}

	public class RealLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RealLiteralExpCS");
		private final Assignment cRealSymbolAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cRealSymbolREAL_LITERALParserRuleCall_0 = (RuleCall)cRealSymbolAssignment.eContents().get(0);
		
		//RealLiteralExpCS:
		//  realSymbol=REAL_LITERAL;
		public ParserRule getRule() { return rule; }

		//realSymbol=REAL_LITERAL
		public Assignment getRealSymbolAssignment() { return cRealSymbolAssignment; }

		//REAL_LITERAL
		public RuleCall getRealSymbolREAL_LITERALParserRuleCall_0() { return cRealSymbolREAL_LITERALParserRuleCall_0; }
	}

	public class StringLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StringLiteralExpCS");
		private final Assignment cStringSymbolAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cStringSymbolSTRING_LITERALTerminalRuleCall_0 = (RuleCall)cStringSymbolAssignment.eContents().get(0);
		
		//StringLiteralExpCS:
		//  stringSymbol+=STRING_LITERAL+;
		public ParserRule getRule() { return rule; }

		//stringSymbol+=STRING_LITERAL+
		public Assignment getStringSymbolAssignment() { return cStringSymbolAssignment; }

		//STRING_LITERAL
		public RuleCall getStringSymbolSTRING_LITERALTerminalRuleCall_0() { return cStringSymbolSTRING_LITERALTerminalRuleCall_0; }
	}

	public class BooleanLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BooleanLiteralExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final Keyword cValueTrueKeyword_0_0 = (Keyword)cValueAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cValueFalseKeyword_1_0 = (Keyword)cValueAssignment_1.eContents().get(0);
		
		//BooleanLiteralExpCS:
		//  value="true"|value="false";
		public ParserRule getRule() { return rule; }

		//value="true"|value="false"
		public Alternatives getAlternatives() { return cAlternatives; }

		//value="true"
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//"true"
		public Keyword getValueTrueKeyword_0_0() { return cValueTrueKeyword_0_0; }

		//value="false"
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//"false"
		public Keyword getValueFalseKeyword_1_0() { return cValueFalseKeyword_1_0; }
	}

	public class UnlimitedNaturalLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnlimitedNaturalLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUnlimitedNaturalLiteralExpCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAsteriskKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//UnlimitedNaturalLiteralExpCS:
		//  {UnlimitedNaturalLiteralExpCS} "*";
		public ParserRule getRule() { return rule; }

		//{UnlimitedNaturalLiteralExpCS} "*"
		public Group getGroup() { return cGroup; }

		//{UnlimitedNaturalLiteralExpCS}
		public Action getUnlimitedNaturalLiteralExpCSAction_0() { return cUnlimitedNaturalLiteralExpCSAction_0; }

		//"*"
		public Keyword getAsteriskKeyword_1() { return cAsteriskKeyword_1; }
	}

	public class InvalidLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InvalidLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cInvalidLiteralExpCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cInvalidKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//InvalidLiteralExpCS:
		//  {InvalidLiteralExpCS} "invalid";
		public ParserRule getRule() { return rule; }

		//{InvalidLiteralExpCS} "invalid"
		public Group getGroup() { return cGroup; }

		//{InvalidLiteralExpCS}
		public Action getInvalidLiteralExpCSAction_0() { return cInvalidLiteralExpCSAction_0; }

		//"invalid"
		public Keyword getInvalidKeyword_1() { return cInvalidKeyword_1; }
	}

	public class NullLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NullLiteralExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cNullLiteralExpCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNullKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//NullLiteralExpCS:
		//  {NullLiteralExpCS} "null";
		public ParserRule getRule() { return rule; }

		//{NullLiteralExpCS} "null"
		public Group getGroup() { return cGroup; }

		//{NullLiteralExpCS}
		public Action getNullLiteralExpCSAction_0() { return cNullLiteralExpCSAction_0; }

		//"null"
		public Keyword getNullKeyword_1() { return cNullKeyword_1; }
	}

	public class TypeLiteralExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TypeLiteralExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPathNameCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPrimitiveTypeCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cCollectionTypeCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cTupleTypeCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//TypeLiteralExpCS:
		//  pathNameCS|primitiveTypeCS|collectionTypeCS|tupleTypeCS; 
		//        
		//        
		//		
		//		 
		//		 
		//		 
		//
		////---------------------------------------------------------------------
		////  Expressions
		////---------------------------------------------------------------------
		//     // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
		//     //  that let is right associative, whereas infix operators are left associative.
		//     //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
		//     // is
		//     //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
		public ParserRule getRule() { return rule; }

		//pathNameCS|primitiveTypeCS|collectionTypeCS|tupleTypeCS 
		//        
		//        
		//		
		//		 
		//		 
		//		 
		//
		////---------------------------------------------------------------------
		////  Expressions
		////---------------------------------------------------------------------
		//     // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
		//     //  that let is right associative, whereas infix operators are left associative.
		//     //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
		//     // is
		//     //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
		public Alternatives getAlternatives() { return cAlternatives; }

		//pathNameCS
		public RuleCall getPathNameCSParserRuleCall_0() { return cPathNameCSParserRuleCall_0; }

		//primitiveTypeCS
		public RuleCall getPrimitiveTypeCSParserRuleCall_1() { return cPrimitiveTypeCSParserRuleCall_1; }

		//collectionTypeCS
		public RuleCall getCollectionTypeCSParserRuleCall_2() { return cCollectionTypeCSParserRuleCall_2; }

		//tupleTypeCS
		public RuleCall getTupleTypeCSParserRuleCall_3() { return cTupleTypeCSParserRuleCall_3; }
	}

	public class OclExpressionCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OclExpressionCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cImpliesCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLetExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//OclExpressionCS:
		//  impliesCS|LetExpCS; 
		//
		////---------------------------------------------------------------------
		////  Expressions
		////---------------------------------------------------------------------
		//     // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
		//     //  that let is right associative, whereas infix operators are left associative.
		//     //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
		//     // is
		//     //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
		public ParserRule getRule() { return rule; }

		//impliesCS|LetExpCS 
		//
		////---------------------------------------------------------------------
		////  Expressions
		////---------------------------------------------------------------------
		//     // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
		//     //  that let is right associative, whereas infix operators are left associative.
		//     //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
		//     // is
		//     //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
		public Alternatives getAlternatives() { return cAlternatives; }

		//impliesCS
		public RuleCall getImpliesCSParserRuleCall_0() { return cImpliesCSParserRuleCall_0; }

		//LetExpCS
		public RuleCall getLetExpCSParserRuleCall_1() { return cLetExpCSParserRuleCall_1; }
	}

	public class ImpliesCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "impliesCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXorCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionCSLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOpImpliesKeyword_1_1_0 = (Keyword)cOpAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final Alternatives cRightAlternatives_1_2_0 = (Alternatives)cRightAssignment_1_2.eContents().get(0);
		private final RuleCall cRightImpliesCSParserRuleCall_1_2_0_0 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(0);
		private final RuleCall cRightLetExpCSParserRuleCall_1_2_0_1 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(1);
		
		//impliesCS returns OclExpressionCS:
		//  xorCS ({BinaryExpressionCS.left=current} op="implies" right=( impliesCS | LetExpCS ))?;
		public ParserRule getRule() { return rule; }

		//xorCS ({BinaryExpressionCS.left=current} op="implies" right=( impliesCS | LetExpCS ))?
		public Group getGroup() { return cGroup; }

		//xorCS
		public RuleCall getXorCSParserRuleCall_0() { return cXorCSParserRuleCall_0; }

		//({BinaryExpressionCS.left=current} op="implies" right=( impliesCS | LetExpCS ))?
		public Group getGroup_1() { return cGroup_1; }

		//{BinaryExpressionCS.left=current}
		public Action getBinaryExpressionCSLeftAction_1_0() { return cBinaryExpressionCSLeftAction_1_0; }

		//op="implies"
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//"implies"
		public Keyword getOpImpliesKeyword_1_1_0() { return cOpImpliesKeyword_1_1_0; }

		//right=( impliesCS | LetExpCS )
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//impliesCS|LetExpCS
		public Alternatives getRightAlternatives_1_2_0() { return cRightAlternatives_1_2_0; }

		//impliesCS
		public RuleCall getRightImpliesCSParserRuleCall_1_2_0_0() { return cRightImpliesCSParserRuleCall_1_2_0_0; }

		//LetExpCS
		public RuleCall getRightLetExpCSParserRuleCall_1_2_0_1() { return cRightLetExpCSParserRuleCall_1_2_0_1; }
	}

	public class XorCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "xorCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cOrCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionCSLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOpXorKeyword_1_1_0 = (Keyword)cOpAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final Alternatives cRightAlternatives_1_2_0 = (Alternatives)cRightAssignment_1_2.eContents().get(0);
		private final RuleCall cRightXorCSParserRuleCall_1_2_0_0 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(0);
		private final RuleCall cRightLetExpCSParserRuleCall_1_2_0_1 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(1);
		
		//xorCS returns OclExpressionCS:
		//  orCS ({BinaryExpressionCS.left=current} op="xor" right=( xorCS | LetExpCS ))?;
		public ParserRule getRule() { return rule; }

		//orCS ({BinaryExpressionCS.left=current} op="xor" right=( xorCS | LetExpCS ))?
		public Group getGroup() { return cGroup; }

		//orCS
		public RuleCall getOrCSParserRuleCall_0() { return cOrCSParserRuleCall_0; }

		//({BinaryExpressionCS.left=current} op="xor" right=( xorCS | LetExpCS ))?
		public Group getGroup_1() { return cGroup_1; }

		//{BinaryExpressionCS.left=current}
		public Action getBinaryExpressionCSLeftAction_1_0() { return cBinaryExpressionCSLeftAction_1_0; }

		//op="xor"
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//"xor"
		public Keyword getOpXorKeyword_1_1_0() { return cOpXorKeyword_1_1_0; }

		//right=( xorCS | LetExpCS )
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//xorCS|LetExpCS
		public Alternatives getRightAlternatives_1_2_0() { return cRightAlternatives_1_2_0; }

		//xorCS
		public RuleCall getRightXorCSParserRuleCall_1_2_0_0() { return cRightXorCSParserRuleCall_1_2_0_0; }

		//LetExpCS
		public RuleCall getRightLetExpCSParserRuleCall_1_2_0_1() { return cRightLetExpCSParserRuleCall_1_2_0_1; }
	}

	public class OrCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "orCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAndCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionCSLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOpOrKeyword_1_1_0 = (Keyword)cOpAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final Alternatives cRightAlternatives_1_2_0 = (Alternatives)cRightAssignment_1_2.eContents().get(0);
		private final RuleCall cRightOrCSParserRuleCall_1_2_0_0 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(0);
		private final RuleCall cRightLetExpCSParserRuleCall_1_2_0_1 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(1);
		
		//orCS returns OclExpressionCS:
		//  andCS ({BinaryExpressionCS.left=current} op="or" right=( orCS | LetExpCS ))?;
		public ParserRule getRule() { return rule; }

		//andCS ({BinaryExpressionCS.left=current} op="or" right=( orCS | LetExpCS ))?
		public Group getGroup() { return cGroup; }

		//andCS
		public RuleCall getAndCSParserRuleCall_0() { return cAndCSParserRuleCall_0; }

		//({BinaryExpressionCS.left=current} op="or" right=( orCS | LetExpCS ))?
		public Group getGroup_1() { return cGroup_1; }

		//{BinaryExpressionCS.left=current}
		public Action getBinaryExpressionCSLeftAction_1_0() { return cBinaryExpressionCSLeftAction_1_0; }

		//op="or"
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//"or"
		public Keyword getOpOrKeyword_1_1_0() { return cOpOrKeyword_1_1_0; }

		//right=( orCS | LetExpCS )
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//orCS|LetExpCS
		public Alternatives getRightAlternatives_1_2_0() { return cRightAlternatives_1_2_0; }

		//orCS
		public RuleCall getRightOrCSParserRuleCall_1_2_0_0() { return cRightOrCSParserRuleCall_1_2_0_0; }

		//LetExpCS
		public RuleCall getRightLetExpCSParserRuleCall_1_2_0_1() { return cRightLetExpCSParserRuleCall_1_2_0_1; }
	}

	public class AndCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "andCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cEqualityCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionCSLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cOpAndKeyword_1_1_0 = (Keyword)cOpAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final Alternatives cRightAlternatives_1_2_0 = (Alternatives)cRightAssignment_1_2.eContents().get(0);
		private final RuleCall cRightAndCSParserRuleCall_1_2_0_0 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(0);
		private final RuleCall cRightLetExpCSParserRuleCall_1_2_0_1 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(1);
		
		//andCS returns OclExpressionCS:
		//  equalityCS ({BinaryExpressionCS.left=current} op="and" right=( andCS | LetExpCS ))?;
		public ParserRule getRule() { return rule; }

		//equalityCS ({BinaryExpressionCS.left=current} op="and" right=( andCS | LetExpCS ))?
		public Group getGroup() { return cGroup; }

		//equalityCS
		public RuleCall getEqualityCSParserRuleCall_0() { return cEqualityCSParserRuleCall_0; }

		//({BinaryExpressionCS.left=current} op="and" right=( andCS | LetExpCS ))?
		public Group getGroup_1() { return cGroup_1; }

		//{BinaryExpressionCS.left=current}
		public Action getBinaryExpressionCSLeftAction_1_0() { return cBinaryExpressionCSLeftAction_1_0; }

		//op="and"
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//"and"
		public Keyword getOpAndKeyword_1_1_0() { return cOpAndKeyword_1_1_0; }

		//right=( andCS | LetExpCS )
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//andCS|LetExpCS
		public Alternatives getRightAlternatives_1_2_0() { return cRightAlternatives_1_2_0; }

		//andCS
		public RuleCall getRightAndCSParserRuleCall_1_2_0_0() { return cRightAndCSParserRuleCall_1_2_0_0; }

		//LetExpCS
		public RuleCall getRightLetExpCSParserRuleCall_1_2_0_1() { return cRightLetExpCSParserRuleCall_1_2_0_1; }
	}

	public class EqualityCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "equalityCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cRelationalCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionCSLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOpAlternatives_1_1_0 = (Alternatives)cOpAssignment_1_1.eContents().get(0);
		private final Keyword cOpEqualsSignKeyword_1_1_0_0 = (Keyword)cOpAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOpLessThanSignGreaterThanSignKeyword_1_1_0_1 = (Keyword)cOpAlternatives_1_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final Alternatives cRightAlternatives_1_2_0 = (Alternatives)cRightAssignment_1_2.eContents().get(0);
		private final RuleCall cRightEqualityCSParserRuleCall_1_2_0_0 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(0);
		private final RuleCall cRightLetExpCSParserRuleCall_1_2_0_1 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(1);
		
		//equalityCS returns OclExpressionCS:
		//  relationalCS ({BinaryExpressionCS.left=current} op=( "=" | "<>" ) right=( equalityCS |
		//  LetExpCS ))?;
		public ParserRule getRule() { return rule; }

		//relationalCS ({BinaryExpressionCS.left=current} op=( "=" | "<>" ) right=( equalityCS |
		//LetExpCS ))?
		public Group getGroup() { return cGroup; }

		//relationalCS
		public RuleCall getRelationalCSParserRuleCall_0() { return cRelationalCSParserRuleCall_0; }

		//({BinaryExpressionCS.left=current} op=( "=" | "<>" ) right=( equalityCS | LetExpCS ))?
		public Group getGroup_1() { return cGroup_1; }

		//{BinaryExpressionCS.left=current}
		public Action getBinaryExpressionCSLeftAction_1_0() { return cBinaryExpressionCSLeftAction_1_0; }

		//op=( "=" | "<>" )
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//"="|"<>"
		public Alternatives getOpAlternatives_1_1_0() { return cOpAlternatives_1_1_0; }

		//"="
		public Keyword getOpEqualsSignKeyword_1_1_0_0() { return cOpEqualsSignKeyword_1_1_0_0; }

		//"<>"
		public Keyword getOpLessThanSignGreaterThanSignKeyword_1_1_0_1() { return cOpLessThanSignGreaterThanSignKeyword_1_1_0_1; }

		//right=( equalityCS | LetExpCS )
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//equalityCS|LetExpCS
		public Alternatives getRightAlternatives_1_2_0() { return cRightAlternatives_1_2_0; }

		//equalityCS
		public RuleCall getRightEqualityCSParserRuleCall_1_2_0_0() { return cRightEqualityCSParserRuleCall_1_2_0_0; }

		//LetExpCS
		public RuleCall getRightLetExpCSParserRuleCall_1_2_0_1() { return cRightLetExpCSParserRuleCall_1_2_0_1; }
	}

	public class RelationalCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "relationalCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAdditiveCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionCSLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOpAlternatives_1_1_0 = (Alternatives)cOpAssignment_1_1.eContents().get(0);
		private final Keyword cOpGreaterThanSignKeyword_1_1_0_0 = (Keyword)cOpAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOpLessThanSignKeyword_1_1_0_1 = (Keyword)cOpAlternatives_1_1_0.eContents().get(1);
		private final Keyword cOpGreaterThanSignEqualsSignKeyword_1_1_0_2 = (Keyword)cOpAlternatives_1_1_0.eContents().get(2);
		private final Keyword cOpLessThanSignEqualsSignKeyword_1_1_0_3 = (Keyword)cOpAlternatives_1_1_0.eContents().get(3);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final Alternatives cRightAlternatives_1_2_0 = (Alternatives)cRightAssignment_1_2.eContents().get(0);
		private final RuleCall cRightRelationalCSParserRuleCall_1_2_0_0 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(0);
		private final RuleCall cRightLetExpCSParserRuleCall_1_2_0_1 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(1);
		
		//relationalCS returns OclExpressionCS:
		//  additiveCS ({BinaryExpressionCS.left=current} op=( ">" | "<" | ">=" | "<=" ) right=(
		//  relationalCS | LetExpCS ))?;
		public ParserRule getRule() { return rule; }

		//additiveCS ({BinaryExpressionCS.left=current} op=( ">" | "<" | ">=" | "<=" ) right=(
		//relationalCS | LetExpCS ))?
		public Group getGroup() { return cGroup; }

		//additiveCS
		public RuleCall getAdditiveCSParserRuleCall_0() { return cAdditiveCSParserRuleCall_0; }

		//({BinaryExpressionCS.left=current} op=( ">" | "<" | ">=" | "<=" ) right=( relationalCS |
		//LetExpCS ))?
		public Group getGroup_1() { return cGroup_1; }

		//{BinaryExpressionCS.left=current}
		public Action getBinaryExpressionCSLeftAction_1_0() { return cBinaryExpressionCSLeftAction_1_0; }

		//op=( ">" | "<" | ">=" | "<=" )
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//">"|"<"|">="|"<="
		public Alternatives getOpAlternatives_1_1_0() { return cOpAlternatives_1_1_0; }

		//">"
		public Keyword getOpGreaterThanSignKeyword_1_1_0_0() { return cOpGreaterThanSignKeyword_1_1_0_0; }

		//"<"
		public Keyword getOpLessThanSignKeyword_1_1_0_1() { return cOpLessThanSignKeyword_1_1_0_1; }

		//">="
		public Keyword getOpGreaterThanSignEqualsSignKeyword_1_1_0_2() { return cOpGreaterThanSignEqualsSignKeyword_1_1_0_2; }

		//"<="
		public Keyword getOpLessThanSignEqualsSignKeyword_1_1_0_3() { return cOpLessThanSignEqualsSignKeyword_1_1_0_3; }

		//right=( relationalCS | LetExpCS )
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//relationalCS|LetExpCS
		public Alternatives getRightAlternatives_1_2_0() { return cRightAlternatives_1_2_0; }

		//relationalCS
		public RuleCall getRightRelationalCSParserRuleCall_1_2_0_0() { return cRightRelationalCSParserRuleCall_1_2_0_0; }

		//LetExpCS
		public RuleCall getRightLetExpCSParserRuleCall_1_2_0_1() { return cRightLetExpCSParserRuleCall_1_2_0_1; }
	}

	public class AdditiveCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "additiveCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cMultiplicativeCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionCSLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOpAlternatives_1_1_0 = (Alternatives)cOpAssignment_1_1.eContents().get(0);
		private final Keyword cOpPlusSignKeyword_1_1_0_0 = (Keyword)cOpAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOpHyphenMinusKeyword_1_1_0_1 = (Keyword)cOpAlternatives_1_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final Alternatives cRightAlternatives_1_2_0 = (Alternatives)cRightAssignment_1_2.eContents().get(0);
		private final RuleCall cRightAdditiveCSParserRuleCall_1_2_0_0 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(0);
		private final RuleCall cRightLetExpCSParserRuleCall_1_2_0_1 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(1);
		
		//additiveCS returns OclExpressionCS:
		//  multiplicativeCS ({BinaryExpressionCS.left=current} op=( "+" | "-" ) right=( additiveCS |
		//  LetExpCS ))?;
		public ParserRule getRule() { return rule; }

		//multiplicativeCS ({BinaryExpressionCS.left=current} op=( "+" | "-" ) right=( additiveCS |
		//LetExpCS ))?
		public Group getGroup() { return cGroup; }

		//multiplicativeCS
		public RuleCall getMultiplicativeCSParserRuleCall_0() { return cMultiplicativeCSParserRuleCall_0; }

		//({BinaryExpressionCS.left=current} op=( "+" | "-" ) right=( additiveCS | LetExpCS ))?
		public Group getGroup_1() { return cGroup_1; }

		//{BinaryExpressionCS.left=current}
		public Action getBinaryExpressionCSLeftAction_1_0() { return cBinaryExpressionCSLeftAction_1_0; }

		//op=( "+" | "-" )
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//"+"|"-"
		public Alternatives getOpAlternatives_1_1_0() { return cOpAlternatives_1_1_0; }

		//"+"
		public Keyword getOpPlusSignKeyword_1_1_0_0() { return cOpPlusSignKeyword_1_1_0_0; }

		//"-"
		public Keyword getOpHyphenMinusKeyword_1_1_0_1() { return cOpHyphenMinusKeyword_1_1_0_1; }

		//right=( additiveCS | LetExpCS )
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//additiveCS|LetExpCS
		public Alternatives getRightAlternatives_1_2_0() { return cRightAlternatives_1_2_0; }

		//additiveCS
		public RuleCall getRightAdditiveCSParserRuleCall_1_2_0_0() { return cRightAdditiveCSParserRuleCall_1_2_0_0; }

		//LetExpCS
		public RuleCall getRightLetExpCSParserRuleCall_1_2_0_1() { return cRightLetExpCSParserRuleCall_1_2_0_1; }
	}

	public class MultiplicativeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "multiplicativeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cUnaryCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionCSLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOpAlternatives_1_1_0 = (Alternatives)cOpAssignment_1_1.eContents().get(0);
		private final Keyword cOpAsteriskKeyword_1_1_0_0 = (Keyword)cOpAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOpSolidusKeyword_1_1_0_1 = (Keyword)cOpAlternatives_1_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final Alternatives cRightAlternatives_1_2_0 = (Alternatives)cRightAssignment_1_2.eContents().get(0);
		private final RuleCall cRightMultiplicativeCSParserRuleCall_1_2_0_0 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(0);
		private final RuleCall cRightLetExpCSParserRuleCall_1_2_0_1 = (RuleCall)cRightAlternatives_1_2_0.eContents().get(1);
		
		//multiplicativeCS returns OclExpressionCS:
		//  unaryCS ({BinaryExpressionCS.left=current} op=( "*" | "/" ) right=( multiplicativeCS |
		//  LetExpCS ))?;
		public ParserRule getRule() { return rule; }

		//unaryCS ({BinaryExpressionCS.left=current} op=( "*" | "/" ) right=( multiplicativeCS |
		//LetExpCS ))?
		public Group getGroup() { return cGroup; }

		//unaryCS
		public RuleCall getUnaryCSParserRuleCall_0() { return cUnaryCSParserRuleCall_0; }

		//({BinaryExpressionCS.left=current} op=( "*" | "/" ) right=( multiplicativeCS | LetExpCS ))
		//?
		public Group getGroup_1() { return cGroup_1; }

		//{BinaryExpressionCS.left=current}
		public Action getBinaryExpressionCSLeftAction_1_0() { return cBinaryExpressionCSLeftAction_1_0; }

		//op=( "*" | "/" )
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//"*"|"/"
		public Alternatives getOpAlternatives_1_1_0() { return cOpAlternatives_1_1_0; }

		//"*"
		public Keyword getOpAsteriskKeyword_1_1_0_0() { return cOpAsteriskKeyword_1_1_0_0; }

		//"/"
		public Keyword getOpSolidusKeyword_1_1_0_1() { return cOpSolidusKeyword_1_1_0_1; }

		//right=( multiplicativeCS | LetExpCS )
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//multiplicativeCS|LetExpCS
		public Alternatives getRightAlternatives_1_2_0() { return cRightAlternatives_1_2_0; }

		//multiplicativeCS
		public RuleCall getRightMultiplicativeCSParserRuleCall_1_2_0_0() { return cRightMultiplicativeCSParserRuleCall_1_2_0_0; }

		//LetExpCS
		public RuleCall getRightLetExpCSParserRuleCall_1_2_0_1() { return cRightLetExpCSParserRuleCall_1_2_0_1; }
	}

	public class UnaryCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "unaryCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCalledExpCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cUnaryExpressionCSAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOpAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Alternatives cOpAlternatives_1_1_0 = (Alternatives)cOpAssignment_1_1.eContents().get(0);
		private final Keyword cOpHyphenMinusKeyword_1_1_0_0 = (Keyword)cOpAlternatives_1_1_0.eContents().get(0);
		private final Keyword cOpNotKeyword_1_1_0_1 = (Keyword)cOpAlternatives_1_1_0.eContents().get(1);
		private final Assignment cSourceAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cSourceUnaryCSParserRuleCall_1_2_0 = (RuleCall)cSourceAssignment_1_2.eContents().get(0);
		
		//unaryCS returns OclExpressionCS:
		//  calledExpCS|{UnaryExpressionCS} op=( "-" | "not" ) source=unaryCS;
		public ParserRule getRule() { return rule; }

		//calledExpCS|{UnaryExpressionCS} op=( "-" | "not" ) source=unaryCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//calledExpCS
		public RuleCall getCalledExpCSParserRuleCall_0() { return cCalledExpCSParserRuleCall_0; }

		//{UnaryExpressionCS} op=( "-" | "not" ) source=unaryCS
		public Group getGroup_1() { return cGroup_1; }

		//{UnaryExpressionCS}
		public Action getUnaryExpressionCSAction_1_0() { return cUnaryExpressionCSAction_1_0; }

		//op=( "-" | "not" )
		public Assignment getOpAssignment_1_1() { return cOpAssignment_1_1; }

		//"-"|"not"
		public Alternatives getOpAlternatives_1_1_0() { return cOpAlternatives_1_1_0; }

		//"-"
		public Keyword getOpHyphenMinusKeyword_1_1_0_0() { return cOpHyphenMinusKeyword_1_1_0_0; }

		//"not"
		public Keyword getOpNotKeyword_1_1_0_1() { return cOpNotKeyword_1_1_0_1; }

		//source=unaryCS
		public Assignment getSourceAssignment_1_2() { return cSourceAssignment_1_2; }

		//unaryCS
		public RuleCall getSourceUnaryCSParserRuleCall_1_2_0() { return cSourceUnaryCSParserRuleCall_1_2_0; }
	}

	public class CalledExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "calledExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cImplicitCallExpCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cCallExpCSSourceAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cCallArgumentsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cCallArgumentsCallArgumentsCSParserRuleCall_1_1_0 = (RuleCall)cCallArgumentsAssignment_1_1.eContents().get(0);
		
		//calledExpCS returns OclExpressionCS:
		//  implicitCallExpCS ({CallExpCS.source=current} callArguments+=CallArgumentsCS+)?;
		public ParserRule getRule() { return rule; }

		//implicitCallExpCS ({CallExpCS.source=current} callArguments+=CallArgumentsCS+)?
		public Group getGroup() { return cGroup; }

		//implicitCallExpCS
		public RuleCall getImplicitCallExpCSParserRuleCall_0() { return cImplicitCallExpCSParserRuleCall_0; }

		//({CallExpCS.source=current} callArguments+=CallArgumentsCS+)?
		public Group getGroup_1() { return cGroup_1; }

		//{CallExpCS.source=current}
		public Action getCallExpCSSourceAction_1_0() { return cCallExpCSSourceAction_1_0; }

		//callArguments+=CallArgumentsCS+
		public Assignment getCallArgumentsAssignment_1_1() { return cCallArgumentsAssignment_1_1; }

		//CallArgumentsCS
		public RuleCall getCallArgumentsCallArgumentsCSParserRuleCall_1_1_0() { return cCallArgumentsCallArgumentsCSParserRuleCall_1_1_0; }
	}

	public class CallArgumentsCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CallArgumentsCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cArrowCallArgumentsCSAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cPathNameAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cPathNamePathNameCSParserRuleCall_0_2_0 = (RuleCall)cPathNameAssignment_0_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_3 = (Keyword)cGroup_0.eContents().get(3);
		private final Alternatives cAlternatives_0_4 = (Alternatives)cGroup_0.eContents().get(4);
		private final Group cGroup_0_4_0 = (Group)cAlternatives_0_4.eContents().get(0);
		private final Assignment cVariable1Assignment_0_4_0_0 = (Assignment)cGroup_0_4_0.eContents().get(0);
		private final RuleCall cVariable1IteratorVariableCSParserRuleCall_0_4_0_0_0 = (RuleCall)cVariable1Assignment_0_4_0_0.eContents().get(0);
		private final Alternatives cAlternatives_0_4_0_1 = (Alternatives)cGroup_0_4_0.eContents().get(1);
		private final Group cGroup_0_4_0_1_0 = (Group)cAlternatives_0_4_0_1.eContents().get(0);
		private final Keyword cCommaKeyword_0_4_0_1_0_0 = (Keyword)cGroup_0_4_0_1_0.eContents().get(0);
		private final Assignment cVariable2Assignment_0_4_0_1_0_1 = (Assignment)cGroup_0_4_0_1_0.eContents().get(1);
		private final RuleCall cVariable2IteratorVariableCSParserRuleCall_0_4_0_1_0_1_0 = (RuleCall)cVariable2Assignment_0_4_0_1_0_1.eContents().get(0);
		private final Group cGroup_0_4_0_1_1 = (Group)cAlternatives_0_4_0_1.eContents().get(1);
		private final Keyword cSemicolonKeyword_0_4_0_1_1_0 = (Keyword)cGroup_0_4_0_1_1.eContents().get(0);
		private final Assignment cVariable2Assignment_0_4_0_1_1_1 = (Assignment)cGroup_0_4_0_1_1.eContents().get(1);
		private final RuleCall cVariable2IteratorAccumulatorCSParserRuleCall_0_4_0_1_1_1_0 = (RuleCall)cVariable2Assignment_0_4_0_1_1_1.eContents().get(0);
		private final Keyword cVerticalLineKeyword_0_4_0_2 = (Keyword)cGroup_0_4_0.eContents().get(2);
		private final Assignment cBodyAssignment_0_4_0_3 = (Assignment)cGroup_0_4_0.eContents().get(3);
		private final RuleCall cBodyOclExpressionCSParserRuleCall_0_4_0_3_0 = (RuleCall)cBodyAssignment_0_4_0_3.eContents().get(0);
		private final Group cGroup_0_4_1 = (Group)cAlternatives_0_4.eContents().get(1);
		private final Assignment cArgumentsAssignment_0_4_1_0 = (Assignment)cGroup_0_4_1.eContents().get(0);
		private final RuleCall cArgumentsOclExpressionCSParserRuleCall_0_4_1_0_0 = (RuleCall)cArgumentsAssignment_0_4_1_0.eContents().get(0);
		private final Group cGroup_0_4_1_1 = (Group)cGroup_0_4_1.eContents().get(1);
		private final Keyword cCommaKeyword_0_4_1_1_0 = (Keyword)cGroup_0_4_1_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_0_4_1_1_1 = (Assignment)cGroup_0_4_1_1.eContents().get(1);
		private final RuleCall cArgumentsOclExpressionCSParserRuleCall_0_4_1_1_1_0 = (RuleCall)cArgumentsAssignment_0_4_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_5 = (Keyword)cGroup_0.eContents().get(5);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cDotIndexArgumentsCSAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cFullStopKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cPathNameAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cPathNamePathNameCSParserRuleCall_1_2_0 = (RuleCall)cPathNameAssignment_1_2.eContents().get(0);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Keyword cLeftSquareBracketKeyword_1_3_0 = (Keyword)cGroup_1_3.eContents().get(0);
		private final Assignment cIndexesAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final RuleCall cIndexesOclExpressionCSParserRuleCall_1_3_1_0 = (RuleCall)cIndexesAssignment_1_3_1.eContents().get(0);
		private final Group cGroup_1_3_2 = (Group)cGroup_1_3.eContents().get(2);
		private final Keyword cCommaKeyword_1_3_2_0 = (Keyword)cGroup_1_3_2.eContents().get(0);
		private final Assignment cIndexesAssignment_1_3_2_1 = (Assignment)cGroup_1_3_2.eContents().get(1);
		private final RuleCall cIndexesOclExpressionCSParserRuleCall_1_3_2_1_0 = (RuleCall)cIndexesAssignment_1_3_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_1_3_3 = (Keyword)cGroup_1_3.eContents().get(3);
		private final Assignment cIsPreAssignment_1_4 = (Assignment)cGroup_1.eContents().get(4);
		private final Keyword cIsPrePreKeyword_1_4_0 = (Keyword)cIsPreAssignment_1_4.eContents().get(0);
		private final Group cGroup_1_5 = (Group)cGroup_1.eContents().get(5);
		private final Keyword cLeftParenthesisKeyword_1_5_0 = (Keyword)cGroup_1_5.eContents().get(0);
		private final Group cGroup_1_5_1 = (Group)cGroup_1_5.eContents().get(1);
		private final Assignment cArgumentsAssignment_1_5_1_0 = (Assignment)cGroup_1_5_1.eContents().get(0);
		private final RuleCall cArgumentsOclExpressionCSParserRuleCall_1_5_1_0_0 = (RuleCall)cArgumentsAssignment_1_5_1_0.eContents().get(0);
		private final Group cGroup_1_5_1_1 = (Group)cGroup_1_5_1.eContents().get(1);
		private final Keyword cCommaKeyword_1_5_1_1_0 = (Keyword)cGroup_1_5_1_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_5_1_1_1 = (Assignment)cGroup_1_5_1_1.eContents().get(1);
		private final RuleCall cArgumentsOclExpressionCSParserRuleCall_1_5_1_1_1_0 = (RuleCall)cArgumentsAssignment_1_5_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_5_2 = (Keyword)cGroup_1_5.eContents().get(2);
		
		//CallArgumentsCS:
		//  {ArrowCallArgumentsCS} "->" pathName=pathNameCS "(" (variable1=iteratorVariableCS (
		//  "," variable2=iteratorVariableCS|";" variable2=iteratorAccumulatorCS)? "|" body=
		//  OclExpressionCS|(arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?)
		//  ")"|{DotIndexArgumentsCS} "." pathName=pathNameCS ("[" indexes+=OclExpressionCS (","
		//  indexes+=OclExpressionCS)* "]")? isPre?="@pre"? ("(" (arguments+=OclExpressionCS (","
		//  arguments+=OclExpressionCS)*)? ")")?;
		public ParserRule getRule() { return rule; }

		//{ArrowCallArgumentsCS} "->" pathName=pathNameCS "(" (variable1=iteratorVariableCS (
		//"," variable2=iteratorVariableCS|";" variable2=iteratorAccumulatorCS)? "|" body=
		//OclExpressionCS|(arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?)
		//")"|{DotIndexArgumentsCS} "." pathName=pathNameCS ("[" indexes+=OclExpressionCS (","
		//indexes+=OclExpressionCS)* "]")? isPre?="@pre"? ("(" (arguments+=OclExpressionCS (","
		//arguments+=OclExpressionCS)*)? ")")?
		public Alternatives getAlternatives() { return cAlternatives; }

		//{ArrowCallArgumentsCS} "->" pathName=pathNameCS "(" (variable1=iteratorVariableCS (
		//"," variable2=iteratorVariableCS|";" variable2=iteratorAccumulatorCS)? "|" body=
		//OclExpressionCS|(arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?)
		//")"
		public Group getGroup_0() { return cGroup_0; }

		//{ArrowCallArgumentsCS}
		public Action getArrowCallArgumentsCSAction_0_0() { return cArrowCallArgumentsCSAction_0_0; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_0_1() { return cHyphenMinusGreaterThanSignKeyword_0_1; }

		//pathName=pathNameCS
		public Assignment getPathNameAssignment_0_2() { return cPathNameAssignment_0_2; }

		//pathNameCS
		public RuleCall getPathNamePathNameCSParserRuleCall_0_2_0() { return cPathNamePathNameCSParserRuleCall_0_2_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_0_3() { return cLeftParenthesisKeyword_0_3; }

		//variable1=iteratorVariableCS ("," variable2=iteratorVariableCS|";" variable2=
		//iteratorAccumulatorCS)? "|" body=OclExpressionCS|(arguments+=OclExpressionCS (","
		//arguments+=OclExpressionCS)*)?
		public Alternatives getAlternatives_0_4() { return cAlternatives_0_4; }

		//variable1=iteratorVariableCS ("," variable2=iteratorVariableCS|";" variable2=
		//iteratorAccumulatorCS)? "|" body=OclExpressionCS
		public Group getGroup_0_4_0() { return cGroup_0_4_0; }

		//variable1=iteratorVariableCS
		public Assignment getVariable1Assignment_0_4_0_0() { return cVariable1Assignment_0_4_0_0; }

		//iteratorVariableCS
		public RuleCall getVariable1IteratorVariableCSParserRuleCall_0_4_0_0_0() { return cVariable1IteratorVariableCSParserRuleCall_0_4_0_0_0; }

		//("," variable2=iteratorVariableCS|";" variable2=iteratorAccumulatorCS)?
		public Alternatives getAlternatives_0_4_0_1() { return cAlternatives_0_4_0_1; }

		//"," variable2=iteratorVariableCS
		public Group getGroup_0_4_0_1_0() { return cGroup_0_4_0_1_0; }

		//","
		public Keyword getCommaKeyword_0_4_0_1_0_0() { return cCommaKeyword_0_4_0_1_0_0; }

		//variable2=iteratorVariableCS
		public Assignment getVariable2Assignment_0_4_0_1_0_1() { return cVariable2Assignment_0_4_0_1_0_1; }

		//iteratorVariableCS
		public RuleCall getVariable2IteratorVariableCSParserRuleCall_0_4_0_1_0_1_0() { return cVariable2IteratorVariableCSParserRuleCall_0_4_0_1_0_1_0; }

		//";" variable2=iteratorAccumulatorCS
		public Group getGroup_0_4_0_1_1() { return cGroup_0_4_0_1_1; }

		//";"
		public Keyword getSemicolonKeyword_0_4_0_1_1_0() { return cSemicolonKeyword_0_4_0_1_1_0; }

		//variable2=iteratorAccumulatorCS
		public Assignment getVariable2Assignment_0_4_0_1_1_1() { return cVariable2Assignment_0_4_0_1_1_1; }

		//iteratorAccumulatorCS
		public RuleCall getVariable2IteratorAccumulatorCSParserRuleCall_0_4_0_1_1_1_0() { return cVariable2IteratorAccumulatorCSParserRuleCall_0_4_0_1_1_1_0; }

		//"|"
		public Keyword getVerticalLineKeyword_0_4_0_2() { return cVerticalLineKeyword_0_4_0_2; }

		//body=OclExpressionCS
		public Assignment getBodyAssignment_0_4_0_3() { return cBodyAssignment_0_4_0_3; }

		//OclExpressionCS
		public RuleCall getBodyOclExpressionCSParserRuleCall_0_4_0_3_0() { return cBodyOclExpressionCSParserRuleCall_0_4_0_3_0; }

		//(arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?
		public Group getGroup_0_4_1() { return cGroup_0_4_1; }

		//arguments+=OclExpressionCS
		public Assignment getArgumentsAssignment_0_4_1_0() { return cArgumentsAssignment_0_4_1_0; }

		//OclExpressionCS
		public RuleCall getArgumentsOclExpressionCSParserRuleCall_0_4_1_0_0() { return cArgumentsOclExpressionCSParserRuleCall_0_4_1_0_0; }

		//("," arguments+=OclExpressionCS)*
		public Group getGroup_0_4_1_1() { return cGroup_0_4_1_1; }

		//","
		public Keyword getCommaKeyword_0_4_1_1_0() { return cCommaKeyword_0_4_1_1_0; }

		//arguments+=OclExpressionCS
		public Assignment getArgumentsAssignment_0_4_1_1_1() { return cArgumentsAssignment_0_4_1_1_1; }

		//OclExpressionCS
		public RuleCall getArgumentsOclExpressionCSParserRuleCall_0_4_1_1_1_0() { return cArgumentsOclExpressionCSParserRuleCall_0_4_1_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_0_5() { return cRightParenthesisKeyword_0_5; }

		//{DotIndexArgumentsCS} "." pathName=pathNameCS ("[" indexes+=OclExpressionCS (","
		//indexes+=OclExpressionCS)* "]")? isPre?="@pre"? ("(" (arguments+=OclExpressionCS (","
		//arguments+=OclExpressionCS)*)? ")")?
		public Group getGroup_1() { return cGroup_1; }

		//{DotIndexArgumentsCS}
		public Action getDotIndexArgumentsCSAction_1_0() { return cDotIndexArgumentsCSAction_1_0; }

		//"."
		public Keyword getFullStopKeyword_1_1() { return cFullStopKeyword_1_1; }

		//pathName=pathNameCS
		public Assignment getPathNameAssignment_1_2() { return cPathNameAssignment_1_2; }

		//pathNameCS
		public RuleCall getPathNamePathNameCSParserRuleCall_1_2_0() { return cPathNamePathNameCSParserRuleCall_1_2_0; }

		//("[" indexes+=OclExpressionCS ("," indexes+=OclExpressionCS)* "]")?
		public Group getGroup_1_3() { return cGroup_1_3; }

		//"["
		public Keyword getLeftSquareBracketKeyword_1_3_0() { return cLeftSquareBracketKeyword_1_3_0; }

		//indexes+=OclExpressionCS
		public Assignment getIndexesAssignment_1_3_1() { return cIndexesAssignment_1_3_1; }

		//OclExpressionCS
		public RuleCall getIndexesOclExpressionCSParserRuleCall_1_3_1_0() { return cIndexesOclExpressionCSParserRuleCall_1_3_1_0; }

		//("," indexes+=OclExpressionCS)*
		public Group getGroup_1_3_2() { return cGroup_1_3_2; }

		//","
		public Keyword getCommaKeyword_1_3_2_0() { return cCommaKeyword_1_3_2_0; }

		//indexes+=OclExpressionCS
		public Assignment getIndexesAssignment_1_3_2_1() { return cIndexesAssignment_1_3_2_1; }

		//OclExpressionCS
		public RuleCall getIndexesOclExpressionCSParserRuleCall_1_3_2_1_0() { return cIndexesOclExpressionCSParserRuleCall_1_3_2_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_1_3_3() { return cRightSquareBracketKeyword_1_3_3; }

		//isPre?="@pre"?
		public Assignment getIsPreAssignment_1_4() { return cIsPreAssignment_1_4; }

		//"@pre"
		public Keyword getIsPrePreKeyword_1_4_0() { return cIsPrePreKeyword_1_4_0; }

		//("(" (arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)? ")")?
		public Group getGroup_1_5() { return cGroup_1_5; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_5_0() { return cLeftParenthesisKeyword_1_5_0; }

		//(arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?
		public Group getGroup_1_5_1() { return cGroup_1_5_1; }

		//arguments+=OclExpressionCS
		public Assignment getArgumentsAssignment_1_5_1_0() { return cArgumentsAssignment_1_5_1_0; }

		//OclExpressionCS
		public RuleCall getArgumentsOclExpressionCSParserRuleCall_1_5_1_0_0() { return cArgumentsOclExpressionCSParserRuleCall_1_5_1_0_0; }

		//("," arguments+=OclExpressionCS)*
		public Group getGroup_1_5_1_1() { return cGroup_1_5_1_1; }

		//","
		public Keyword getCommaKeyword_1_5_1_1_0() { return cCommaKeyword_1_5_1_1_0; }

		//arguments+=OclExpressionCS
		public Assignment getArgumentsAssignment_1_5_1_1_1() { return cArgumentsAssignment_1_5_1_1_1; }

		//OclExpressionCS
		public RuleCall getArgumentsOclExpressionCSParserRuleCall_1_5_1_1_1_0() { return cArgumentsOclExpressionCSParserRuleCall_1_5_1_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_1_5_2() { return cRightParenthesisKeyword_1_5_2; }
	}

	public class IteratorVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "iteratorVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameSimpleNameCSParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTypeTypeCSParserRuleCall_1_1_0 = (RuleCall)cTypeAssignment_1_1.eContents().get(0);
		
		//iteratorVariableCS returns VariableCS:
		//  name=simpleNameCS (":" type=typeCS)?;
		public ParserRule getRule() { return rule; }

		//name=simpleNameCS (":" type=typeCS)?
		public Group getGroup() { return cGroup; }

		//name=simpleNameCS
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//simpleNameCS
		public RuleCall getNameSimpleNameCSParserRuleCall_0_0() { return cNameSimpleNameCSParserRuleCall_0_0; }

		//(":" type=typeCS)?
		public Group getGroup_1() { return cGroup_1; }

		//":"
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//type=typeCS
		public Assignment getTypeAssignment_1_1() { return cTypeAssignment_1_1; }

		//typeCS
		public RuleCall getTypeTypeCSParserRuleCall_1_1_0() { return cTypeTypeCSParserRuleCall_1_1_0; }
	}

	public class IteratorAccumulatorCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "iteratorAccumulatorCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameSimpleNameCSParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeTypeCSParserRuleCall_2_0 = (RuleCall)cTypeAssignment_2.eContents().get(0);
		private final Keyword cEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cInitExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cInitExpressionOclExpressionCSParserRuleCall_4_0 = (RuleCall)cInitExpressionAssignment_4.eContents().get(0);
		
		//iteratorAccumulatorCS returns VariableCS:
		//  name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS;
		public ParserRule getRule() { return rule; }

		//name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS
		public Group getGroup() { return cGroup; }

		//name=simpleNameCS
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//simpleNameCS
		public RuleCall getNameSimpleNameCSParserRuleCall_0_0() { return cNameSimpleNameCSParserRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//type=typeCS
		public Assignment getTypeAssignment_2() { return cTypeAssignment_2; }

		//typeCS
		public RuleCall getTypeTypeCSParserRuleCall_2_0() { return cTypeTypeCSParserRuleCall_2_0; }

		//"="
		public Keyword getEqualsSignKeyword_3() { return cEqualsSignKeyword_3; }

		//initExpression=OclExpressionCS
		public Assignment getInitExpressionAssignment_4() { return cInitExpressionAssignment_4; }

		//OclExpressionCS
		public RuleCall getInitExpressionOclExpressionCSParserRuleCall_4_0() { return cInitExpressionOclExpressionCSParserRuleCall_4_0; }
	}

	public class ImplicitCallExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "implicitCallExpCS");
		private final RuleCall cPreCallExpCSParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//implicitCallExpCS returns OclExpressionCS:
		//  preCallExpCS; 
		//
		//	    
		//		
		////    	(	(({ImplicitIndexExpCS.calls=current} '[' indexes+=OclExpressionCS (',' indexes+=OclExpressionCS)* ']')?)
		////    	|	(({ImplicitCallExpCS.calls=current} '(' (arguments+=OclExpressionCS (',' arguments+=OclExpressionCS)*)? ')')?)
		////    	)
		public ParserRule getRule() { return rule; }

		//preCallExpCS 
		//		
		////    	(	(({ImplicitIndexExpCS.calls=current} '[' indexes+=OclExpressionCS (',' indexes+=OclExpressionCS)* ']')?)
		////    	|	(({ImplicitCallExpCS.calls=current} '(' (arguments+=OclExpressionCS (',' arguments+=OclExpressionCS)*)? ')')?)
		////    	)
		public RuleCall getPreCallExpCSParserRuleCall() { return cPreCallExpCSParserRuleCall; }
	}

	public class PreCallExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "preCallExpCS");
		private final RuleCall cExtendedPrimaryExpCSParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//preCallExpCS returns OclExpressionCS:
		//  extendedPrimaryExpCS; 
		//	
		//	    
		//		
		////	|	source=primaryExpCS isPre?='@pre'
		public ParserRule getRule() { return rule; }

		//extendedPrimaryExpCS 
		//		
		////	|	source=primaryExpCS isPre?='@pre'
		public RuleCall getExtendedPrimaryExpCSParserRuleCall() { return cExtendedPrimaryExpCSParserRuleCall; }
	}

	public class SimpleNameExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SimpleNameExpCS");
		private final RuleCall cSimpleNameCSParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//SimpleNameExpCS returns OclExpressionCS:
		//  simpleNameCS; 
		//        
		//          // AssociationClassCallExpCS[B.1.1],
		//                         // PropertyCallExpCS[B],VariableExpCS[.1]
		public ParserRule getRule() { return rule; }

		//simpleNameCS   // AssociationClassCallExpCS[B.1.1],
		//                         // PropertyCallExpCS[B],VariableExpCS[.1]
		public RuleCall getSimpleNameCSParserRuleCall() { return cSimpleNameCSParserRuleCall; }
	}

	public class ExtendedPrimaryExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "extendedPrimaryExpCS");
		private final RuleCall cPrimaryExpCSParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//extendedPrimaryExpCS returns OclExpressionCS:
		//  primaryExpCS; 
		//
		//        
		//		
		////  |	OclMessageExpCS // OclExpressionCS[E] is added by CompleteOCL
		public ParserRule getRule() { return rule; }

		//primaryExpCS 
		//		
		////  |	OclMessageExpCS // OclExpressionCS[E] is added by CompleteOCL
		public RuleCall getPrimaryExpCSParserRuleCall() { return cPrimaryExpCSParserRuleCall; }
	}

	public class PrimaryExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "primaryExpCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSelfKeywordCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLiteralExpCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cIfExpCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final RuleCall cOclExpressionCSParserRuleCall_3_1 = (RuleCall)cGroup_3.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		//primaryExpCS returns OclExpressionCS:
		//  selfKeywordCS|LiteralExpCS|IfExpCS|"(" OclExpressionCS ")"; 
		//
		//        
		//			 // The only VariableExpCS not parsed as a TypeLiteralExpCS
		//     	      // OclExpressionCS[C]
		//     	           // OclExpressionCS[F]
		public ParserRule getRule() { return rule; }

		//selfKeywordCS|LiteralExpCS|IfExpCS|"(" OclExpressionCS ")" 
		//
		//        
		//			 // The only VariableExpCS not parsed as a TypeLiteralExpCS
		//     	      // OclExpressionCS[C]
		//     	           // OclExpressionCS[F]
		public Alternatives getAlternatives() { return cAlternatives; }

		//selfKeywordCS 
		//			 // The only VariableExpCS not parsed as a TypeLiteralExpCS
		public RuleCall getSelfKeywordCSParserRuleCall_0() { return cSelfKeywordCSParserRuleCall_0; }

		//LiteralExpCS 	      // OclExpressionCS[C]
		public RuleCall getLiteralExpCSParserRuleCall_1() { return cLiteralExpCSParserRuleCall_1; }

		//IfExpCS 	           // OclExpressionCS[F]
		public RuleCall getIfExpCSParserRuleCall_2() { return cIfExpCSParserRuleCall_2; }

		//"(" OclExpressionCS ")"
		public Group getGroup_3() { return cGroup_3; }

		//"("
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }

		//OclExpressionCS
		public RuleCall getOclExpressionCSParserRuleCall_3_1() { return cOclExpressionCSParserRuleCall_3_1; }

		//")"
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }
	}

	public class IfExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IfExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIfKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cConditionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cConditionOclExpressionCSParserRuleCall_1_0 = (RuleCall)cConditionAssignment_1.eContents().get(0);
		private final Keyword cThenKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cThenExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cThenExpressionOclExpressionCSParserRuleCall_3_0 = (RuleCall)cThenExpressionAssignment_3.eContents().get(0);
		private final Keyword cElseKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cElseExpressionAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cElseExpressionOclExpressionCSParserRuleCall_5_0 = (RuleCall)cElseExpressionAssignment_5.eContents().get(0);
		private final Keyword cEndifKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//IfExpCS:
		//  "if" condition=OclExpressionCS "then" thenExpression=OclExpressionCS "else"
		//  elseExpression=OclExpressionCS "endif";
		public ParserRule getRule() { return rule; }

		//"if" condition=OclExpressionCS "then" thenExpression=OclExpressionCS "else"
		//elseExpression=OclExpressionCS "endif"
		public Group getGroup() { return cGroup; }

		//"if"
		public Keyword getIfKeyword_0() { return cIfKeyword_0; }

		//condition=OclExpressionCS
		public Assignment getConditionAssignment_1() { return cConditionAssignment_1; }

		//OclExpressionCS
		public RuleCall getConditionOclExpressionCSParserRuleCall_1_0() { return cConditionOclExpressionCSParserRuleCall_1_0; }

		//"then"
		public Keyword getThenKeyword_2() { return cThenKeyword_2; }

		//thenExpression=OclExpressionCS
		public Assignment getThenExpressionAssignment_3() { return cThenExpressionAssignment_3; }

		//OclExpressionCS
		public RuleCall getThenExpressionOclExpressionCSParserRuleCall_3_0() { return cThenExpressionOclExpressionCSParserRuleCall_3_0; }

		//"else"
		public Keyword getElseKeyword_4() { return cElseKeyword_4; }

		//elseExpression=OclExpressionCS
		public Assignment getElseExpressionAssignment_5() { return cElseExpressionAssignment_5; }

		//OclExpressionCS
		public RuleCall getElseExpressionOclExpressionCSParserRuleCall_5_0() { return cElseExpressionOclExpressionCSParserRuleCall_5_0; }

		//"endif"
		public Keyword getEndifKeyword_6() { return cEndifKeyword_6; }
	}

	public class LetExpCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LetExpCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cVariableAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cVariableLetVariableCSParserRuleCall_1_0 = (RuleCall)cVariableAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cVariableAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cVariableLetVariableCSParserRuleCall_2_1_0 = (RuleCall)cVariableAssignment_2_1.eContents().get(0);
		private final Keyword cInKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cInAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cInOclExpressionCSParserRuleCall_4_0 = (RuleCall)cInAssignment_4.eContents().get(0);
		
		//LetExpCS:
		//  "let" variable+=LetVariableCS ("," variable+=LetVariableCS)* "in" in=OclExpressionCS;
		public ParserRule getRule() { return rule; }

		//"let" variable+=LetVariableCS ("," variable+=LetVariableCS)* "in" in=OclExpressionCS
		public Group getGroup() { return cGroup; }

		//"let"
		public Keyword getLetKeyword_0() { return cLetKeyword_0; }

		//variable+=LetVariableCS
		public Assignment getVariableAssignment_1() { return cVariableAssignment_1; }

		//LetVariableCS
		public RuleCall getVariableLetVariableCSParserRuleCall_1_0() { return cVariableLetVariableCSParserRuleCall_1_0; }

		//("," variable+=LetVariableCS)*
		public Group getGroup_2() { return cGroup_2; }

		//","
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }

		//variable+=LetVariableCS
		public Assignment getVariableAssignment_2_1() { return cVariableAssignment_2_1; }

		//LetVariableCS
		public RuleCall getVariableLetVariableCSParserRuleCall_2_1_0() { return cVariableLetVariableCSParserRuleCall_2_1_0; }

		//"in"
		public Keyword getInKeyword_3() { return cInKeyword_3; }

		//in=OclExpressionCS
		public Assignment getInAssignment_4() { return cInAssignment_4; }

		//OclExpressionCS
		public RuleCall getInOclExpressionCSParserRuleCall_4_0() { return cInOclExpressionCSParserRuleCall_4_0; }
	}

	public class LetVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LetVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameSimpleNameCSParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeTypeCSParserRuleCall_2_0 = (RuleCall)cTypeAssignment_2.eContents().get(0);
		private final Keyword cEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cInitExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cInitExpressionOclExpressionCSParserRuleCall_4_0 = (RuleCall)cInitExpressionAssignment_4.eContents().get(0);
		
		//LetVariableCS returns VariableCS:
		//  name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS;
		public ParserRule getRule() { return rule; }

		//name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS
		public Group getGroup() { return cGroup; }

		//name=simpleNameCS
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//simpleNameCS
		public RuleCall getNameSimpleNameCSParserRuleCall_0_0() { return cNameSimpleNameCSParserRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//type=typeCS
		public Assignment getTypeAssignment_2() { return cTypeAssignment_2; }

		//typeCS
		public RuleCall getTypeTypeCSParserRuleCall_2_0() { return cTypeTypeCSParserRuleCall_2_0; }

		//"="
		public Keyword getEqualsSignKeyword_3() { return cEqualsSignKeyword_3; }

		//initExpression=OclExpressionCS
		public Assignment getInitExpressionAssignment_4() { return cInitExpressionAssignment_4; }

		//OclExpressionCS
		public RuleCall getInitExpressionOclExpressionCSParserRuleCall_4_0() { return cInitExpressionOclExpressionCSParserRuleCall_4_0; }
	}
	
	
	private ModelElements pModel;
	private TerminalRule tSTRING_LITERAL;
	private TerminalRule tID;
	private TerminalRule tINT;
	private REAL_LITERALElements pREAL_LITERAL;
	private INTEGER_LITERALElements pINTEGER_LITERAL;
	private TerminalRule tML_COMMENT;
	private TerminalRule tSL_COMMENT;
	private TerminalRule tWS;
	private TerminalRule tANY_OTHER;
	private TupleKeywordCSElements pTupleKeywordCS;
	private RestrictedKeywordCSElements pRestrictedKeywordCS;
	private SelfKeywordCSElements pSelfKeywordCS;
	private SimpleNameCSElements pSimpleNameCS;
	private UnreservedSimpleNameCSElements pUnreservedSimpleNameCS;
	private PathNameCSElements pPathNameCS;
	private PrimitiveTypeCSElements pPrimitiveTypeCS;
	private CollectionTypeIdentifierCSElements pCollectionTypeIdentifierCS;
	private TypeCSElements pTypeCS;
	private CollectionTypeCSElements pCollectionTypeCS;
	private TupleTypeCSElements pTupleTypeCS;
	private TuplePartCSElements pTuplePartCS;
	private LiteralExpCSElements pLiteralExpCS;
	private CollectionLiteralExpCSElements pCollectionLiteralExpCS;
	private CollectionLiteralPartCSElements pCollectionLiteralPartCS;
	private PrimitiveLiteralExpCSElements pPrimitiveLiteralExpCS;
	private TupleLiteralExpCSElements pTupleLiteralExpCS;
	private TupleLiteralPartCSElements pTupleLiteralPartCS;
	private IntegerLiteralExpCSElements pIntegerLiteralExpCS;
	private RealLiteralExpCSElements pRealLiteralExpCS;
	private StringLiteralExpCSElements pStringLiteralExpCS;
	private BooleanLiteralExpCSElements pBooleanLiteralExpCS;
	private UnlimitedNaturalLiteralExpCSElements pUnlimitedNaturalLiteralExpCS;
	private InvalidLiteralExpCSElements pInvalidLiteralExpCS;
	private NullLiteralExpCSElements pNullLiteralExpCS;
	private TypeLiteralExpCSElements pTypeLiteralExpCS;
	private OclExpressionCSElements pOclExpressionCS;
	private ImpliesCSElements pImpliesCS;
	private XorCSElements pXorCS;
	private OrCSElements pOrCS;
	private AndCSElements pAndCS;
	private EqualityCSElements pEqualityCS;
	private RelationalCSElements pRelationalCS;
	private AdditiveCSElements pAdditiveCS;
	private MultiplicativeCSElements pMultiplicativeCS;
	private UnaryCSElements pUnaryCS;
	private CalledExpCSElements pCalledExpCS;
	private CallArgumentsCSElements pCallArgumentsCS;
	private IteratorVariableCSElements pIteratorVariableCS;
	private IteratorAccumulatorCSElements pIteratorAccumulatorCS;
	private ImplicitCallExpCSElements pImplicitCallExpCS;
	private PreCallExpCSElements pPreCallExpCS;
	private SimpleNameExpCSElements pSimpleNameExpCS;
	private ExtendedPrimaryExpCSElements pExtendedPrimaryExpCS;
	private PrimaryExpCSElements pPrimaryExpCS;
	private IfExpCSElements pIfExpCS;
	private LetExpCSElements pLetExpCS;
	private LetVariableCSElements pLetVariableCS;
	
	private final GrammarProvider grammarProvider;

	@Inject
	public EssentialOCLGrammarAccess(GrammarProvider grammarProvider) {
		this.grammarProvider = grammarProvider;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	
	//Model returns OclExpressionCS:
	//  OclExpressionCS;  
	////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
	public ModelElements getModelAccess() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	//terminal STRING_LITERAL:
	//  "\'" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRING_LITERALRule() {
		return (tSTRING_LITERAL != null) ? tSTRING_LITERAL : (tSTRING_LITERAL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "STRING_LITERAL"));
	} 

	//terminal ID:
	//  ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")* | "_" STRING_LITERAL;  
	//	
	//    		 
	//	  
	////| 	("_'" ( '\\' ('b'|'t'|'n'|'f'|'r'|'"'|"'"|'\\') | !('\\'|"'") )* "'")
	public TerminalRule getIDRule() {
		return (tID != null) ? tID : (tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	//terminal INT:
	//  "0".."9"+; 
	//
	//  											 // String to allow diverse re-use
	public TerminalRule getINTRule() {
		return (tINT != null) ? tINT : (tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "INT"));
	} 

	//REAL_LITERAL returns ecore::EBigDecimal:
	//  INT ("." INT|("." INT)? ("e"|"E") ("+"|"-")? INT); 
	//
	//    				 // Not terminal to allow parser backtracking to sort out "5..7"
	public REAL_LITERALElements getREAL_LITERALAccess() {
		return (pREAL_LITERAL != null) ? pREAL_LITERAL : (pREAL_LITERAL = new REAL_LITERALElements());
	}
	
	public ParserRule getREAL_LITERALRule() {
		return getREAL_LITERALAccess().getRule();
	}

	//INTEGER_LITERAL returns ecore::EBigInteger:
	//  INT;
	public INTEGER_LITERALElements getINTEGER_LITERALAccess() {
		return (pINTEGER_LITERAL != null) ? pINTEGER_LITERAL : (pINTEGER_LITERAL = new INTEGER_LITERALElements());
	}
	
	public ParserRule getINTEGER_LITERALRule() {
		return getINTEGER_LITERALAccess().getRule();
	}

	//terminal ML_COMMENT:
	//  "/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return (tML_COMMENT != null) ? tML_COMMENT : (tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ML_COMMENT"));
	} 

	//terminal SL_COMMENT:
	//  "--" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return (tSL_COMMENT != null) ? tSL_COMMENT : (tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT"));
	} 

	//terminal WS:
	//  (" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return (tWS != null) ? tWS : (tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	//terminal ANY_OTHER:
	//  .; 
	//
	//    
	//	
	////---------------------------------------------------------------------
	////  Names
	////---------------------------------------------------------------------
	/// *  Temporary backward compatibility support for 7.4.8 conceptual usage 
	//    conceptualOperationName returns SimpleNameCS:
	//    	value='and'
	//    	| value='implies'
	//    	| value='not'
	//    	| value='or'
	//    	| value='xor'
	//    	| value='<'
	//    	| value='<='
	//    	| value='>='
	//    	| value='>'
	//    	| value='='
	//    	| value='<>'
	//    	| value='+'
	//    	| value='-'
	//    	| value='*'
	//    	| value='/';
	//    conceptualOperationNameCS returns SimpleNameCS:
	//    	conceptualOperationName; * /
	//    
	/// *    reservedKeyword returns SimpleNameCS: 
	//    	value='and'
	//    	| value='else'
	//    	| value='endif'
	//    	| value='if'
	//    	| value='implies'
	//    	| value='in'
	//    	| value='let'
	//    	| value='not'
	//    	| value='or'
	//    	| value='then'
	//    	| value='xor'; * /
	public TerminalRule getANY_OTHERRule() {
		return (tANY_OTHER != null) ? tANY_OTHER : (tANY_OTHER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ANY_OTHER"));
	} 

	//tupleKeywordCS returns SimpleNameCS:
	//  value="Tuple"; 
	//	
	////---------------------------------------------------------------------
	////  Names
	////---------------------------------------------------------------------
	/// *  Temporary backward compatibility support for 7.4.8 conceptual usage 
	//    conceptualOperationName returns SimpleNameCS:
	//    	value='and'
	//    	| value='implies'
	//    	| value='not'
	//    	| value='or'
	//    	| value='xor'
	//    	| value='<'
	//    	| value='<='
	//    	| value='>='
	//    	| value='>'
	//    	| value='='
	//    	| value='<>'
	//    	| value='+'
	//    	| value='-'
	//    	| value='*'
	//    	| value='/';
	//    conceptualOperationNameCS returns SimpleNameCS:
	//    	conceptualOperationName; * /
	//    
	/// *    reservedKeyword returns SimpleNameCS: 
	//    	value='and'
	//    	| value='else'
	//    	| value='endif'
	//    	| value='if'
	//    	| value='implies'
	//    	| value='in'
	//    	| value='let'
	//    	| value='not'
	//    	| value='or'
	//    	| value='then'
	//    	| value='xor'; * /
	//
	//        
	//    	
	//    
	////    reservedKeywordCS returns SimpleNameCS:
	////    	reservedKeyword;
	public TupleKeywordCSElements getTupleKeywordCSAccess() {
		return (pTupleKeywordCS != null) ? pTupleKeywordCS : (pTupleKeywordCS = new TupleKeywordCSElements());
	}
	
	public ParserRule getTupleKeywordCSRule() {
		return getTupleKeywordCSAccess().getRule();
	}

	//restrictedKeywordCS returns SimpleNameCS:
	//  CollectionTypeIdentifierCS|primitiveTypeCS|tupleKeywordCS; 
	//    
	////    reservedKeywordCS returns SimpleNameCS:
	////    	reservedKeyword;
	//    
	//         
	//    	
	////  restrictedKeywordCS -> BooleanLiteralExpCS
	////  restrictedKeywordCS -> InvalidLiteralExpCS
	////  restrictedKeywordCS -> NullLiteralExpCS
	////-  restrictedKeywordCS -> selfKeywordCS
	public RestrictedKeywordCSElements getRestrictedKeywordCSAccess() {
		return (pRestrictedKeywordCS != null) ? pRestrictedKeywordCS : (pRestrictedKeywordCS = new RestrictedKeywordCSElements());
	}
	
	public ParserRule getRestrictedKeywordCSRule() {
		return getRestrictedKeywordCSAccess().getRule();
	}

	//selfKeywordCS returns SimpleNameCS:
	//  value="self";
	public SelfKeywordCSElements getSelfKeywordCSAccess() {
		return (pSelfKeywordCS != null) ? pSelfKeywordCS : (pSelfKeywordCS = new SelfKeywordCSElements());
	}
	
	public ParserRule getSelfKeywordCSRule() {
		return getSelfKeywordCSAccess().getRule();
	}

	//simpleNameCS returns SimpleNameCS:
	//  value=ID;
	public SimpleNameCSElements getSimpleNameCSAccess() {
		return (pSimpleNameCS != null) ? pSimpleNameCS : (pSimpleNameCS = new SimpleNameCSElements());
	}
	
	public ParserRule getSimpleNameCSRule() {
		return getSimpleNameCSAccess().getRule();
	}

	//unreservedSimpleNameCS returns SimpleNameCS:
	//  simpleNameCS|restrictedKeywordCS;
	public UnreservedSimpleNameCSElements getUnreservedSimpleNameCSAccess() {
		return (pUnreservedSimpleNameCS != null) ? pUnreservedSimpleNameCS : (pUnreservedSimpleNameCS = new UnreservedSimpleNameCSElements());
	}
	
	public ParserRule getUnreservedSimpleNameCSRule() {
		return getUnreservedSimpleNameCSAccess().getRule();
	}

	//pathNameCS returns PathNameCS:
	//  simpleNames+=simpleNameCS ("::" simpleNames+=unreservedSimpleNameCS)*; 
	//
	//        
	//    	    
	//
	//        
	////---------------------------------------------------------------------
	////  Types
	////---------------------------------------------------------------------
	public PathNameCSElements getPathNameCSAccess() {
		return (pPathNameCS != null) ? pPathNameCS : (pPathNameCS = new PathNameCSElements());
	}
	
	public ParserRule getPathNameCSRule() {
		return getPathNameCSAccess().getRule();
	}

	//primitiveTypeCS returns SimpleNameCS:
	//  value="Boolean"|value="Integer"|value="Real"|value="String"|value=
	//  "UnlimitedNatural"|value="OclAny"|value="OclInvalid"|value="OclVoid"; 
	//
	//        
	////---------------------------------------------------------------------
	////  Types
	////---------------------------------------------------------------------
	public PrimitiveTypeCSElements getPrimitiveTypeCSAccess() {
		return (pPrimitiveTypeCS != null) ? pPrimitiveTypeCS : (pPrimitiveTypeCS = new PrimitiveTypeCSElements());
	}
	
	public ParserRule getPrimitiveTypeCSRule() {
		return getPrimitiveTypeCSAccess().getRule();
	}

	//CollectionTypeIdentifierCS returns SimpleNameCS:
	//  value="Set"|value="Bag"|value="Sequence"|value="Collection"|value="OrderedSet";
	public CollectionTypeIdentifierCSElements getCollectionTypeIdentifierCSAccess() {
		return (pCollectionTypeIdentifierCS != null) ? pCollectionTypeIdentifierCS : (pCollectionTypeIdentifierCS = new CollectionTypeIdentifierCSElements());
	}
	
	public ParserRule getCollectionTypeIdentifierCSRule() {
		return getCollectionTypeIdentifierCSAccess().getRule();
	}

	//typeCS returns TypeCS:
	//  primitiveTypeCS|pathNameCS|collectionTypeCS|tupleTypeCS;
	public TypeCSElements getTypeCSAccess() {
		return (pTypeCS != null) ? pTypeCS : (pTypeCS = new TypeCSElements());
	}
	
	public ParserRule getTypeCSRule() {
		return getTypeCSAccess().getRule();
	}

	//collectionTypeCS returns CollectionTypeCS:
	//  value=CollectionTypeIdentifierCS "(" typeCS=typeCS ")";
	public CollectionTypeCSElements getCollectionTypeCSAccess() {
		return (pCollectionTypeCS != null) ? pCollectionTypeCS : (pCollectionTypeCS = new CollectionTypeCSElements());
	}
	
	public ParserRule getCollectionTypeCSRule() {
		return getCollectionTypeCSAccess().getRule();
	}

	//tupleTypeCS returns TupleTypeCS:
	//  value="Tuple" "(" (part+=tuplePartCS ("," part+=tuplePartCS)*)? ")";
	public TupleTypeCSElements getTupleTypeCSAccess() {
		return (pTupleTypeCS != null) ? pTupleTypeCS : (pTupleTypeCS = new TupleTypeCSElements());
	}
	
	public ParserRule getTupleTypeCSRule() {
		return getTupleTypeCSAccess().getRule();
	}

	//tuplePartCS returns VariableCS:
	//  name=simpleNameCS ":" type=typeCS; 
	//        
	//    
	//	    
	//
	//
	////---------------------------------------------------------------------
	////  Literals
	////---------------------------------------------------------------------
	//// EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
	////  LiteralExpCS -> EnumLiteralExpCS
	public TuplePartCSElements getTuplePartCSAccess() {
		return (pTuplePartCS != null) ? pTuplePartCS : (pTuplePartCS = new TuplePartCSElements());
	}
	
	public ParserRule getTuplePartCSRule() {
		return getTuplePartCSAccess().getRule();
	}

	//LiteralExpCS:
	//  CollectionLiteralExpCS|TupleLiteralExpCS|PrimitiveLiteralExpCS|TypeLiteralExpCS; 
	//
	////---------------------------------------------------------------------
	////  Literals
	////---------------------------------------------------------------------
	//// EnumLiteralExpCS is parsed as a PropertyCallExpCS[C]
	////  LiteralExpCS -> EnumLiteralExpCS
	public LiteralExpCSElements getLiteralExpCSAccess() {
		return (pLiteralExpCS != null) ? pLiteralExpCS : (pLiteralExpCS = new LiteralExpCSElements());
	}
	
	public ParserRule getLiteralExpCSRule() {
		return getLiteralExpCSAccess().getRule();
	}

	//CollectionLiteralExpCS:
	//  (CollectionTypeIdentifierCS|collectionTypeCS) "{" (collectionLiteralParts+=
	//  CollectionLiteralPartCS ("," collectionLiteralParts+=CollectionLiteralPartCS)*)?
	//  "}";
	public CollectionLiteralExpCSElements getCollectionLiteralExpCSAccess() {
		return (pCollectionLiteralExpCS != null) ? pCollectionLiteralExpCS : (pCollectionLiteralExpCS = new CollectionLiteralExpCSElements());
	}
	
	public ParserRule getCollectionLiteralExpCSRule() {
		return getCollectionLiteralExpCSAccess().getRule();
	}

	//CollectionLiteralPartCS:
	//  expressionCS=OclExpressionCS (".." lastExpressionCS=OclExpressionCS)?;
	public CollectionLiteralPartCSElements getCollectionLiteralPartCSAccess() {
		return (pCollectionLiteralPartCS != null) ? pCollectionLiteralPartCS : (pCollectionLiteralPartCS = new CollectionLiteralPartCSElements());
	}
	
	public ParserRule getCollectionLiteralPartCSRule() {
		return getCollectionLiteralPartCSAccess().getRule();
	}

	//PrimitiveLiteralExpCS:
	//  IntegerLiteralExpCS|RealLiteralExpCS|StringLiteralExpCS|BooleanLiteralExpCS|
	//  UnlimitedNaturalLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS;
	public PrimitiveLiteralExpCSElements getPrimitiveLiteralExpCSAccess() {
		return (pPrimitiveLiteralExpCS != null) ? pPrimitiveLiteralExpCS : (pPrimitiveLiteralExpCS = new PrimitiveLiteralExpCSElements());
	}
	
	public ParserRule getPrimitiveLiteralExpCSRule() {
		return getPrimitiveLiteralExpCSAccess().getRule();
	}

	//TupleLiteralExpCS:
	//  "Tuple" "{" part+=TupleLiteralPartCS ("," part+=TupleLiteralPartCS)* "}";
	public TupleLiteralExpCSElements getTupleLiteralExpCSAccess() {
		return (pTupleLiteralExpCS != null) ? pTupleLiteralExpCS : (pTupleLiteralExpCS = new TupleLiteralExpCSElements());
	}
	
	public ParserRule getTupleLiteralExpCSRule() {
		return getTupleLiteralExpCSAccess().getRule();
	}

	//TupleLiteralPartCS returns VariableCS:
	//  name=simpleNameCS (":" type=typeCS)? "=" initExpression=OclExpressionCS;
	public TupleLiteralPartCSElements getTupleLiteralPartCSAccess() {
		return (pTupleLiteralPartCS != null) ? pTupleLiteralPartCS : (pTupleLiteralPartCS = new TupleLiteralPartCSElements());
	}
	
	public ParserRule getTupleLiteralPartCSRule() {
		return getTupleLiteralPartCSAccess().getRule();
	}

	//IntegerLiteralExpCS:
	//  integerSymbol=INTEGER_LITERAL;
	public IntegerLiteralExpCSElements getIntegerLiteralExpCSAccess() {
		return (pIntegerLiteralExpCS != null) ? pIntegerLiteralExpCS : (pIntegerLiteralExpCS = new IntegerLiteralExpCSElements());
	}
	
	public ParserRule getIntegerLiteralExpCSRule() {
		return getIntegerLiteralExpCSAccess().getRule();
	}

	//RealLiteralExpCS:
	//  realSymbol=REAL_LITERAL;
	public RealLiteralExpCSElements getRealLiteralExpCSAccess() {
		return (pRealLiteralExpCS != null) ? pRealLiteralExpCS : (pRealLiteralExpCS = new RealLiteralExpCSElements());
	}
	
	public ParserRule getRealLiteralExpCSRule() {
		return getRealLiteralExpCSAccess().getRule();
	}

	//StringLiteralExpCS:
	//  stringSymbol+=STRING_LITERAL+;
	public StringLiteralExpCSElements getStringLiteralExpCSAccess() {
		return (pStringLiteralExpCS != null) ? pStringLiteralExpCS : (pStringLiteralExpCS = new StringLiteralExpCSElements());
	}
	
	public ParserRule getStringLiteralExpCSRule() {
		return getStringLiteralExpCSAccess().getRule();
	}

	//BooleanLiteralExpCS:
	//  value="true"|value="false";
	public BooleanLiteralExpCSElements getBooleanLiteralExpCSAccess() {
		return (pBooleanLiteralExpCS != null) ? pBooleanLiteralExpCS : (pBooleanLiteralExpCS = new BooleanLiteralExpCSElements());
	}
	
	public ParserRule getBooleanLiteralExpCSRule() {
		return getBooleanLiteralExpCSAccess().getRule();
	}

	//UnlimitedNaturalLiteralExpCS:
	//  {UnlimitedNaturalLiteralExpCS} "*";
	public UnlimitedNaturalLiteralExpCSElements getUnlimitedNaturalLiteralExpCSAccess() {
		return (pUnlimitedNaturalLiteralExpCS != null) ? pUnlimitedNaturalLiteralExpCS : (pUnlimitedNaturalLiteralExpCS = new UnlimitedNaturalLiteralExpCSElements());
	}
	
	public ParserRule getUnlimitedNaturalLiteralExpCSRule() {
		return getUnlimitedNaturalLiteralExpCSAccess().getRule();
	}

	//InvalidLiteralExpCS:
	//  {InvalidLiteralExpCS} "invalid";
	public InvalidLiteralExpCSElements getInvalidLiteralExpCSAccess() {
		return (pInvalidLiteralExpCS != null) ? pInvalidLiteralExpCS : (pInvalidLiteralExpCS = new InvalidLiteralExpCSElements());
	}
	
	public ParserRule getInvalidLiteralExpCSRule() {
		return getInvalidLiteralExpCSAccess().getRule();
	}

	//NullLiteralExpCS:
	//  {NullLiteralExpCS} "null";
	public NullLiteralExpCSElements getNullLiteralExpCSAccess() {
		return (pNullLiteralExpCS != null) ? pNullLiteralExpCS : (pNullLiteralExpCS = new NullLiteralExpCSElements());
	}
	
	public ParserRule getNullLiteralExpCSRule() {
		return getNullLiteralExpCSAccess().getRule();
	}

	//TypeLiteralExpCS:
	//  pathNameCS|primitiveTypeCS|collectionTypeCS|tupleTypeCS; 
	//        
	//        
	//		
	//		 
	//		 
	//		 
	//
	////---------------------------------------------------------------------
	////  Expressions
	////---------------------------------------------------------------------
	//     // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
	//     //  that let is right associative, whereas infix operators are left associative.
	//     //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
	//     // is
	//     //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
	public TypeLiteralExpCSElements getTypeLiteralExpCSAccess() {
		return (pTypeLiteralExpCS != null) ? pTypeLiteralExpCS : (pTypeLiteralExpCS = new TypeLiteralExpCSElements());
	}
	
	public ParserRule getTypeLiteralExpCSRule() {
		return getTypeLiteralExpCSAccess().getRule();
	}

	//OclExpressionCS:
	//  impliesCS|LetExpCS; 
	//
	////---------------------------------------------------------------------
	////  Expressions
	////---------------------------------------------------------------------
	//     // An OclExpressionCS comprising one or more LetExpCS is kept separate to ensure
	//     //  that let is right associative, whereas infix operators are left associative.
	//     //   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
	//     // is
	//     //   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
	public OclExpressionCSElements getOclExpressionCSAccess() {
		return (pOclExpressionCS != null) ? pOclExpressionCS : (pOclExpressionCS = new OclExpressionCSElements());
	}
	
	public ParserRule getOclExpressionCSRule() {
		return getOclExpressionCSAccess().getRule();
	}

	//impliesCS returns OclExpressionCS:
	//  xorCS ({BinaryExpressionCS.left=current} op="implies" right=( impliesCS | LetExpCS ))?;
	public ImpliesCSElements getImpliesCSAccess() {
		return (pImpliesCS != null) ? pImpliesCS : (pImpliesCS = new ImpliesCSElements());
	}
	
	public ParserRule getImpliesCSRule() {
		return getImpliesCSAccess().getRule();
	}

	//xorCS returns OclExpressionCS:
	//  orCS ({BinaryExpressionCS.left=current} op="xor" right=( xorCS | LetExpCS ))?;
	public XorCSElements getXorCSAccess() {
		return (pXorCS != null) ? pXorCS : (pXorCS = new XorCSElements());
	}
	
	public ParserRule getXorCSRule() {
		return getXorCSAccess().getRule();
	}

	//orCS returns OclExpressionCS:
	//  andCS ({BinaryExpressionCS.left=current} op="or" right=( orCS | LetExpCS ))?;
	public OrCSElements getOrCSAccess() {
		return (pOrCS != null) ? pOrCS : (pOrCS = new OrCSElements());
	}
	
	public ParserRule getOrCSRule() {
		return getOrCSAccess().getRule();
	}

	//andCS returns OclExpressionCS:
	//  equalityCS ({BinaryExpressionCS.left=current} op="and" right=( andCS | LetExpCS ))?;
	public AndCSElements getAndCSAccess() {
		return (pAndCS != null) ? pAndCS : (pAndCS = new AndCSElements());
	}
	
	public ParserRule getAndCSRule() {
		return getAndCSAccess().getRule();
	}

	//equalityCS returns OclExpressionCS:
	//  relationalCS ({BinaryExpressionCS.left=current} op=( "=" | "<>" ) right=( equalityCS |
	//  LetExpCS ))?;
	public EqualityCSElements getEqualityCSAccess() {
		return (pEqualityCS != null) ? pEqualityCS : (pEqualityCS = new EqualityCSElements());
	}
	
	public ParserRule getEqualityCSRule() {
		return getEqualityCSAccess().getRule();
	}

	//relationalCS returns OclExpressionCS:
	//  additiveCS ({BinaryExpressionCS.left=current} op=( ">" | "<" | ">=" | "<=" ) right=(
	//  relationalCS | LetExpCS ))?;
	public RelationalCSElements getRelationalCSAccess() {
		return (pRelationalCS != null) ? pRelationalCS : (pRelationalCS = new RelationalCSElements());
	}
	
	public ParserRule getRelationalCSRule() {
		return getRelationalCSAccess().getRule();
	}

	//additiveCS returns OclExpressionCS:
	//  multiplicativeCS ({BinaryExpressionCS.left=current} op=( "+" | "-" ) right=( additiveCS |
	//  LetExpCS ))?;
	public AdditiveCSElements getAdditiveCSAccess() {
		return (pAdditiveCS != null) ? pAdditiveCS : (pAdditiveCS = new AdditiveCSElements());
	}
	
	public ParserRule getAdditiveCSRule() {
		return getAdditiveCSAccess().getRule();
	}

	//multiplicativeCS returns OclExpressionCS:
	//  unaryCS ({BinaryExpressionCS.left=current} op=( "*" | "/" ) right=( multiplicativeCS |
	//  LetExpCS ))?;
	public MultiplicativeCSElements getMultiplicativeCSAccess() {
		return (pMultiplicativeCS != null) ? pMultiplicativeCS : (pMultiplicativeCS = new MultiplicativeCSElements());
	}
	
	public ParserRule getMultiplicativeCSRule() {
		return getMultiplicativeCSAccess().getRule();
	}

	//unaryCS returns OclExpressionCS:
	//  calledExpCS|{UnaryExpressionCS} op=( "-" | "not" ) source=unaryCS;
	public UnaryCSElements getUnaryCSAccess() {
		return (pUnaryCS != null) ? pUnaryCS : (pUnaryCS = new UnaryCSElements());
	}
	
	public ParserRule getUnaryCSRule() {
		return getUnaryCSAccess().getRule();
	}

	//calledExpCS returns OclExpressionCS:
	//  implicitCallExpCS ({CallExpCS.source=current} callArguments+=CallArgumentsCS+)?;
	public CalledExpCSElements getCalledExpCSAccess() {
		return (pCalledExpCS != null) ? pCalledExpCS : (pCalledExpCS = new CalledExpCSElements());
	}
	
	public ParserRule getCalledExpCSRule() {
		return getCalledExpCSAccess().getRule();
	}

	//CallArgumentsCS:
	//  {ArrowCallArgumentsCS} "->" pathName=pathNameCS "(" (variable1=iteratorVariableCS (
	//  "," variable2=iteratorVariableCS|";" variable2=iteratorAccumulatorCS)? "|" body=
	//  OclExpressionCS|(arguments+=OclExpressionCS ("," arguments+=OclExpressionCS)*)?)
	//  ")"|{DotIndexArgumentsCS} "." pathName=pathNameCS ("[" indexes+=OclExpressionCS (","
	//  indexes+=OclExpressionCS)* "]")? isPre?="@pre"? ("(" (arguments+=OclExpressionCS (","
	//  arguments+=OclExpressionCS)*)? ")")?;
	public CallArgumentsCSElements getCallArgumentsCSAccess() {
		return (pCallArgumentsCS != null) ? pCallArgumentsCS : (pCallArgumentsCS = new CallArgumentsCSElements());
	}
	
	public ParserRule getCallArgumentsCSRule() {
		return getCallArgumentsCSAccess().getRule();
	}

	//iteratorVariableCS returns VariableCS:
	//  name=simpleNameCS (":" type=typeCS)?;
	public IteratorVariableCSElements getIteratorVariableCSAccess() {
		return (pIteratorVariableCS != null) ? pIteratorVariableCS : (pIteratorVariableCS = new IteratorVariableCSElements());
	}
	
	public ParserRule getIteratorVariableCSRule() {
		return getIteratorVariableCSAccess().getRule();
	}

	//iteratorAccumulatorCS returns VariableCS:
	//  name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS;
	public IteratorAccumulatorCSElements getIteratorAccumulatorCSAccess() {
		return (pIteratorAccumulatorCS != null) ? pIteratorAccumulatorCS : (pIteratorAccumulatorCS = new IteratorAccumulatorCSElements());
	}
	
	public ParserRule getIteratorAccumulatorCSRule() {
		return getIteratorAccumulatorCSAccess().getRule();
	}

	//implicitCallExpCS returns OclExpressionCS:
	//  preCallExpCS; 
	//
	//	    
	//		
	////    	(	(({ImplicitIndexExpCS.calls=current} '[' indexes+=OclExpressionCS (',' indexes+=OclExpressionCS)* ']')?)
	////    	|	(({ImplicitCallExpCS.calls=current} '(' (arguments+=OclExpressionCS (',' arguments+=OclExpressionCS)*)? ')')?)
	////    	)
	public ImplicitCallExpCSElements getImplicitCallExpCSAccess() {
		return (pImplicitCallExpCS != null) ? pImplicitCallExpCS : (pImplicitCallExpCS = new ImplicitCallExpCSElements());
	}
	
	public ParserRule getImplicitCallExpCSRule() {
		return getImplicitCallExpCSAccess().getRule();
	}

	//preCallExpCS returns OclExpressionCS:
	//  extendedPrimaryExpCS; 
	//	
	//	    
	//		
	////	|	source=primaryExpCS isPre?='@pre'
	public PreCallExpCSElements getPreCallExpCSAccess() {
		return (pPreCallExpCS != null) ? pPreCallExpCS : (pPreCallExpCS = new PreCallExpCSElements());
	}
	
	public ParserRule getPreCallExpCSRule() {
		return getPreCallExpCSAccess().getRule();
	}

	//SimpleNameExpCS returns OclExpressionCS:
	//  simpleNameCS; 
	//        
	//          // AssociationClassCallExpCS[B.1.1],
	//                         // PropertyCallExpCS[B],VariableExpCS[.1]
	public SimpleNameExpCSElements getSimpleNameExpCSAccess() {
		return (pSimpleNameExpCS != null) ? pSimpleNameExpCS : (pSimpleNameExpCS = new SimpleNameExpCSElements());
	}
	
	public ParserRule getSimpleNameExpCSRule() {
		return getSimpleNameExpCSAccess().getRule();
	}

	//extendedPrimaryExpCS returns OclExpressionCS:
	//  primaryExpCS; 
	//
	//        
	//		
	////  |	OclMessageExpCS // OclExpressionCS[E] is added by CompleteOCL
	public ExtendedPrimaryExpCSElements getExtendedPrimaryExpCSAccess() {
		return (pExtendedPrimaryExpCS != null) ? pExtendedPrimaryExpCS : (pExtendedPrimaryExpCS = new ExtendedPrimaryExpCSElements());
	}
	
	public ParserRule getExtendedPrimaryExpCSRule() {
		return getExtendedPrimaryExpCSAccess().getRule();
	}

	//primaryExpCS returns OclExpressionCS:
	//  selfKeywordCS|LiteralExpCS|IfExpCS|"(" OclExpressionCS ")"; 
	//
	//        
	//			 // The only VariableExpCS not parsed as a TypeLiteralExpCS
	//     	      // OclExpressionCS[C]
	//     	           // OclExpressionCS[F]
	public PrimaryExpCSElements getPrimaryExpCSAccess() {
		return (pPrimaryExpCS != null) ? pPrimaryExpCS : (pPrimaryExpCS = new PrimaryExpCSElements());
	}
	
	public ParserRule getPrimaryExpCSRule() {
		return getPrimaryExpCSAccess().getRule();
	}

	//IfExpCS:
	//  "if" condition=OclExpressionCS "then" thenExpression=OclExpressionCS "else"
	//  elseExpression=OclExpressionCS "endif";
	public IfExpCSElements getIfExpCSAccess() {
		return (pIfExpCS != null) ? pIfExpCS : (pIfExpCS = new IfExpCSElements());
	}
	
	public ParserRule getIfExpCSRule() {
		return getIfExpCSAccess().getRule();
	}

	//LetExpCS:
	//  "let" variable+=LetVariableCS ("," variable+=LetVariableCS)* "in" in=OclExpressionCS;
	public LetExpCSElements getLetExpCSAccess() {
		return (pLetExpCS != null) ? pLetExpCS : (pLetExpCS = new LetExpCSElements());
	}
	
	public ParserRule getLetExpCSRule() {
		return getLetExpCSAccess().getRule();
	}

	//LetVariableCS returns VariableCS:
	//  name=simpleNameCS ":" type=typeCS "=" initExpression=OclExpressionCS;
	public LetVariableCSElements getLetVariableCSAccess() {
		return (pLetVariableCS != null) ? pLetVariableCS : (pLetVariableCS = new LetVariableCSElements());
	}
	
	public ParserRule getLetVariableCSRule() {
		return getLetVariableCSAccess().getRule();
	}
}
