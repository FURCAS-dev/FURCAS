/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst;

public interface MqlAstVisitor
{
    void visit(NodeToken n);
    void visit(IdentifierN n);
    void visit(Ident n);
    void visit(PathNameIdent n);
    void visit(MqlQuery n);
    void visit(SelectClause n);
    void visit(SelectEntryN n);
    void visit(SelectAlias n);
    void visit(SelectAttribute n);
    void visit(FromClause n);
    void visit(FromEntryN n);
    void visit(FromEntry n);
    void visit(TypeQName n);
    void visit(Withoutsubtypes n);
    void visit(TypeSetClause n);
    void visit(TypePathNameN n);
    void visit(ElementPathNameN n);
    void visit(FragmentAddress n);
    void visit(UriN n);
    void visit(Uri n);
    void visit(ScopeClause n);
    void visit(PartitionScope n);
    void visit(InElements n);
    void visit(WhereClauseN n);
    void visit(WhereClause n);
    void visit(LocalWhereEntry n);
    void visit(AndWhereCondition n);
    void visit(OrWhereCondition n);
    void visit(NotWhereCondition n);
    void visit(OperationCondition n);
    void visit(ParenthesizedLocalWhereCondition n);
    void visit(OpSmaller n);
    void visit(OpGreater n);
    void visit(OpSmallerEqual n);
    void visit(OpGreaterEqual n);
    void visit(OpEqual n);
    void visit(OpNotEqual n);
    void visit(OpLike n);
    void visit(NotLike n);
    void visit(IntegerLiteral n);
    void visit(RealLiteral n);
    void visit(StringLiteral n);
    void visit(TrueLiteral n);
    void visit(FalseLiteral n);
    void visit(NullLiteral n);
    void visit(JoinWhereEntry n);
    void visit(AliasComparisonClause n);
    void visit(NameBasedNavigation n);
    void visit(LinkPredicate n);
    void visit(AssocOrComparisonPredicate n);
    void visit(ComparisonSmallerPredicate n);
    void visit(ComparisonGreaterPredicate n);
    void visit(ComparisonSmallerEqualPredicate n);
    void visit(ComparisonGreaterEqualPredicate n);
    void visit(ComparisonNotEqualPredicate n);
    void visit(ComparisonLikePredicate n);
    void visit(ComparisonNotLikePredicate n);
    void visit(LiteralEqualsComparisonInPredicate n);
    void visit(IdentifierEqualsComparisonInPredicate n);
    void visit(LiteralComparisonInPredicate n);
    void visit(IdentifierComparisonInPredicate n);
    void visit(ComparisonPredicate n);
    void visit(Not n);
}

