/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.collectionexpressions;

import dataaccess.expressions.ExpressionWithArgument;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Expression With Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getCollectionExpressionWithArgument()
 * @model abstract="true"
 *        annotation="http://de.hpi.sam.bp2009.OCL ArgumentTypeMustConformToCollectionExpressionType='let snl : Integer = source.getType().getNestingLevel() in let anl : Integer = argument.getType().getNestingLevel() in\n    if snl = anl then\n      source.getType().conformsToIgnoringMultiplicity(argument.getType())\n    else\n      if snl = (anl + 1) then\n        source.getType().oclAsType(NestedTypeDefinition).type.conformsToIgnoringMultiplicity(argument.getType())\n      else\n        if (snl + 1) = anl then\n          source.getType().conformsToIgnoringMultiplicity(argument.getType().oclAsType(NestedTypeDefinition).type)\n        else\n          false\n        endif\n      endif\n    endif'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ArgumentTypeMustConformToCollectionExpressionType'"
 * @generated
 */
public interface CollectionExpressionWithArgument extends CollectionExpression, ExpressionWithArgument {
} // CollectionExpressionWithArgument
