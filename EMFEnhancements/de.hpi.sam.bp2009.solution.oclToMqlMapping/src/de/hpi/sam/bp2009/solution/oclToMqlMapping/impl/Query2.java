package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.FromEntry;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.SelectAlias;
import org.eclipse.emf.query2.SelectAttrs;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.emf.query2.WhereComparisonAliases;
import org.eclipse.emf.query2.WhereComparisonAttrs;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereInt;
import org.eclipse.emf.query2.WhereNestedReference;
import org.eclipse.emf.query2.WhereRelationReference;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectBasedQueryContextScopeProviderImpl;

public class Query2 {

    /**
     * buildMqlQuery prepares for each Predefined type of the Iterator Expression a matching Query 2 after mapping all parts of
     * the Expression, the query 2 will be executed
     * 
     * @param contextObjects
     *            a Set<EObject> for setting the Query Context
     * @param ocType
     *            an Object for building the scope for Query 2
     * @param body
     *            is the OCLExpression, this must be the body of the IteratorExp for mapping all parts of the Expression to Query
     *            2
     * @param itExp
     *            is the IteratorExp, needed to defined the different mapping for each Predefined Type
     * @param mapEvalVisitor
     *            is the Mapping Evaluation Visitor, needed to instantiate a second Visitor to map the expression
     * @return result
     */
    public Object buildMqlQuery(Set<EObject> contextObjects, EClassifier ocType, OCLExpression<EClassifier> body,
            IteratorExp<EClassifier, EParameter> itExp, MappingEvaluationVisitor mapEvalVisitor) {

        switch (OCLStandardLibraryUtil.getOperationCode(itExp.getName())) {
        case PredefinedType.SELECT:
            return mappingForSelect(contextObjects, body, ocType);
        case PredefinedType.COLLECT:
            return mappingForCollect(contextObjects, body, ocType);
        case PredefinedType.EXISTS:
        case PredefinedType.FOR_ALL:
        case PredefinedType.ANY:
        case PredefinedType.REJECT:
        case PredefinedType.COLLECT_NESTED:
        case PredefinedType.ONE:
        case PredefinedType.SORTED_BY:
        case PredefinedType.IS_UNIQUE:
        case PredefinedType.CLOSURE:
        default:
            return null;
        }
    }

    private Collection<EObject> mappingForSelect(Set<EObject> contextObjects, OCLExpression<EClassifier> body, EClassifier ocType) {  
        if(body instanceof OperationCallExp){
            OCLExpression<EClassifier> bodySource = ((OperationCallExp)body).getSource();
            if(bodySource instanceof PropertyCallExp){
                OCLExpression<EClassifier> bodySourceSource = ((PropertyCallExp)bodySource).getSource();
                if (bodySourceSource instanceof PropertyCallExp){                    
                    EStructuralFeature prop = ((PropertyCallExp) bodySourceSource).getReferredProperty();
                    if (prop instanceof EReference) {
                        return selectOverBodyWithNavigation(contextObjects, body, ocType);
                    }
                }else{
                    OCLExpression<EClassifier> arg = ((OperationCallExp) body).getArgument().get(0);
                    if (arg instanceof PropertyCallExp){
                        OCLExpression<EClassifier> argSource = ((PropertyCallExp)arg).getSource();
                        if(argSource instanceof PropertyCallExp){
                            PropertyCallExp src = (PropertyCallExp) argSource;
                            EStructuralFeature prop = src.getReferredProperty();
                            if (prop instanceof EReference) {
                                return selectOverBodyWithComparisonAndNavigation(body, ocType, null);                         
                            }
                        }else{
                            return selectOverBodyWithComparisonWithoutNavigation(null, body, ocType);
                        }
                    }else{                
                        return selectOverBodyWithCondition(null, body, ocType);
                    }
                }
            }
        }

        return null;
    }

    private Map<?, Integer> mappingForCollect(Set<EObject> contextObjects, OCLExpression<EClassifier> body, EClassifier ocType) {
        if (body instanceof PropertyCallExp) {    
            EStructuralFeature prop = ((PropertyCallExp) body).getReferredProperty();
            if (prop instanceof EReference) {
                return collectOverReference(contextObjects, body, ocType);
            }
            if (prop instanceof EAttribute) {
                return collectOverAttribute(contextObjects, body, ocType);
            }
        } 
        // body is of type OperationCallExpression -> the expression can not be mapped
        return null;
    }

    private Collection<EObject> selectOverBodyWithNavigation(Set<EObject> contextObjects, OCLExpression<EClassifier> body, EClassifier ocType) {
        Collection<EObject> result = null;
        ResultSet resultSet = null;
        QueryContext queryContext = new ProjectBasedQueryContextScopeProviderImpl(contextObjects.toArray(new EObject[contextObjects.size()])).getForwardScopeAsQueryContext();
        QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        URI uri = EcoreUtil.getURI(ocType);        
        OCLExpression<EClassifier> bodySource = ((OperationCallExp) body).getSource();            
        OCLExpression<EClassifier> bodySourceSource = ((PropertyCallExp)bodySource).getSource();                                   
        EStructuralFeature prop = ((PropertyCallExp) bodySourceSource).getReferredProperty();                    
        String ali = ((PropertyCallExp) bodySourceSource).getSource().getName();
        try {
            // select over body with navigation
            // "select "+ali+" from  [" + uri1 + "] as "+ali+" where "+nav+" in ( select p2 from [" +
            // uri2+"] as p2 where p2." + cond+")"
            URI uri2 = EcoreUtil.getURI(((EReference) prop).getEType());
            String ali2 = ali.concat("_");
            Operation operation = mapStringToOperation(((OperationCallExp) body).getReferredOperation().getName());
            Integer value = new Integer(((OperationCallExp) body).getArgument().get(0).toString());
            SelectEntry nestedSelect = new SelectAlias(ali2);
            FromEntry nestedFrom = new FromType(ali2, uri2, /* withoutSubtypes */true);
            WhereInt whereLong = new WhereInt(((PropertyCallExp)bodySource).getReferredProperty().getName(), operation, value);
            LocalWhereEntry nestedWhere = new LocalWhereEntry(ali2, whereLong);
            Query nestedQuery = new Query(new SelectEntry[] { nestedSelect }, new FromEntry[] { nestedFrom },
                    new WhereEntry[] { nestedWhere });
            SelectEntry select = new SelectAlias(ali);
            FromEntry from = new FromType(ali, uri, /* withoutSubtypes */true);
            WhereNestedReference where = new WhereNestedReference(ali, prop.getName(), nestedQuery);
            Query query = new Query(new SelectEntry[] { select }, new FromEntry[] { from }, new WhereEntry[] { where });
            resultSet = queryProcessor.execute(query, queryContext);
        } catch (RuntimeException e) {
        } finally {
            result = buildResult(resultSet, queryContext, ali);
        }
        return result;
    }

    private Collection<EObject> selectOverBodyWithCondition(Set<EObject> contextObjects, OCLExpression<EClassifier> body, EClassifier ocType) {
        Collection<EObject> result = null;
        ResultSet resultSet = null;
        QueryContext queryContext = new ProjectBasedQueryContextScopeProviderImpl(contextObjects.toArray(new EObject[contextObjects.size()])).getForwardScopeAsQueryContext();
        QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        URI uri = EcoreUtil.getURI(ocType);        
        OCLExpression<EClassifier> bodySource = ((OperationCallExp) body).getSource();          
        String ali = ((PropertyCallExp) bodySource).getSource().getName();
        try {
            // select over body with condition
            // "select "+ ali+" from  [" + uri1 + "] as "+ali+" where " + stringBody
            String attrName = ((PropertyCallExp) bodySource).getReferredProperty().getName();
            Operation operation = mapStringToOperation(((OperationCallExp) body).getReferredOperation().getName());
            Integer value = new Integer(((OperationCallExp) body).getArgument().get(0).toString());
            SelectEntry select = new SelectAlias(ali);
            FromEntry from = new FromType(ali, uri, true);
            WhereInt whereLong = new WhereInt(attrName, operation, value);
            LocalWhereEntry where = new LocalWhereEntry(ali, whereLong);
            Query query = new Query(new SelectEntry[] { select }, new FromEntry[] { from }, new WhereEntry[] { where });
            resultSet = queryProcessor.execute(query, queryContext);
        } catch (RuntimeException e) {
        } finally {
            result = buildResult(resultSet, queryContext, ali);
        }
        return result;
    }

    private Collection<EObject> selectOverBodyWithComparisonAndNavigation(OCLExpression<EClassifier> body, EClassifier ocType, Set<EObject> contextObjects) {
        Collection<EObject> result = null;
        ResultSet resultSet = null;
        QueryContext queryContext = new ProjectBasedQueryContextScopeProviderImpl(contextObjects.toArray(new EObject[contextObjects.size()])).getForwardScopeAsQueryContext();
        QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        URI uri = EcoreUtil.getURI(ocType);       
        OCLExpression<EClassifier> arg = ((OperationCallExp) body).getArgument().get(0);            
        OCLExpression<EClassifier> argSource = ((PropertyCallExp)arg).getSource();                            
        PropertyCallExp src = (PropertyCallExp) argSource;
        EStructuralFeature prop = src.getReferredProperty();                   
        String ali = src.getSource().toString();
        try {
            // select over body with a comparison with navigation
            // "select "+ ali+" from  [" + uri1 + "] as "+ali+" ,["+uri2+"] as p3 where " +nav+"=p3 where "+ali+ cond+ "p3."+ cond2
            EClassifier propType = ((EReference) prop).getEType();
            URI uri2 = EcoreUtil.getURI(propType);
            PropertyCallExp bodySource = ((PropertyCallExp) ((OperationCallExp) body).getSource());
            String ali2 = bodySource.getSource().toString();
            if (ali.equals(ali2)) {
                ali2 = ali2.concat("_");
            }
            String navName = prop.getName();
            Operation operation = mapStringToOperation(((OperationCallExp) body).getReferredOperation().getName());
            SelectEntry select = new SelectAlias(ali);
            FromEntry from1 = new FromType(ali, uri, /* withoutSubtypes */true);
            FromEntry from2 = new FromType(ali2, uri2, /* withoutSubtypes */true);
            WhereRelationReference where1 = new WhereRelationReference(ali, navName, ali2);
            WhereComparisonAttrs where2 = new WhereComparisonAttrs(ali, bodySource.getReferredProperty().getName(),
                    operation, ali2, ((PropertyCallExp) arg).getReferredProperty().getName());
            Query query = new Query(new SelectEntry[] { select }, new FromEntry[] { from1, from2 }, new WhereEntry[] {
                    where1, where2 });
            resultSet = queryProcessor.execute(query, queryContext);
        } catch (RuntimeException e) { }
        finally {
            result = buildResult(resultSet, queryContext, ali);
        }
        return result;
    }

    private Collection<EObject> selectOverBodyWithComparisonWithoutNavigation(Set<EObject> contextObjects, OCLExpression<EClassifier> body, EClassifier ocType) {
        Collection<EObject> result = null;
        ResultSet resultSet = null;
        QueryContext queryContext = new ProjectBasedQueryContextScopeProviderImpl(contextObjects.toArray(new EObject[contextObjects.size()])).getForwardScopeAsQueryContext();
        QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        URI uri = EcoreUtil.getURI(ocType);      
        OCLExpression<EClassifier> bodySource = ((OperationCallExp) body).getSource();         
        String ali = ((PropertyCallExp) bodySource).getSource().getName();
        try {
            // select over body with a comparison without navigation
            // "select "+ ali+" from [" + uri1 + "] as p , ["+uri1+"] as "+ali+" where "+ali+"=p where "+cond
            String ali2 = ali.concat("_");
            String leftAttrName = ((PropertyCallExp) bodySource).getReferredProperty().getName();
            String eOp = ((OperationCallExp) body).getReferredOperation().getName();
            Operation operation = mapStringToOperation(eOp);
            OCLExpression<EClassifier> rightProperty = ((OperationCallExp) body).getArgument().get(0);
            if (!(rightProperty instanceof PropertyCallExp)) {
                throw new RuntimeException();
            }
            String rightAlias = ((PropertyCallExp) rightProperty).getSource().getName();
            String rightAttrName = ((PropertyCallExp) rightProperty).getReferredProperty().getName();
            SelectEntry select = new SelectAlias(ali);
            FromEntry from1 = new FromType(ali2, uri, /* withoutSubtypes */true);
            FromEntry from2 = new FromType(ali, uri, /* withoutSubtypes */true);
            WhereComparisonAliases where1 = new WhereComparisonAliases(ali, ali2);
            WhereComparisonAttrs where2 = new WhereComparisonAttrs(ali2, leftAttrName, operation, rightAlias,
                    rightAttrName);
            Query query = new Query(new SelectEntry[] { select }, new FromEntry[] { from1, from2 }, new WhereEntry[] {
                    where1, where2 });
            resultSet = queryProcessor.execute(query, queryContext);
        } catch (RuntimeException e) {
        } finally {
            result = buildResult(resultSet, queryContext, ali);
        }
        return result;
    }

    private Map<EObject, Integer> collectOverReference(Set<EObject> contextObjects, OCLExpression<EClassifier> body, EClassifier ocType) {
        Map<EObject, Integer> result = null;
        ResultSet resultSet = null;
        QueryContext queryContext = new ProjectBasedQueryContextScopeProviderImpl(contextObjects.toArray(new EObject[contextObjects.size()])).getForwardScopeAsQueryContext();
        QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        URI uri = EcoreUtil.getURI(ocType);
        // collect over an association
        // "select "+ali2+" from  [" + uri1 + "] as "+ali+" , [" +uri2+ "] as " + ali2 + " where "+ stringBody
        // +" in (select p2 from ["+uri2+"] as p2
        URI uri2 = EcoreUtil.getURI(((EReference) ((PropertyCallExp) body).getReferredProperty()).getEType());
        String ali = ((PropertyCallExp) body).getSource().getName();
        String ali2 = ali.concat("_");
        try {
            String ali3 = ali2.concat("_");
            SelectEntry nestedSelect = new SelectAlias(ali3);
            FromEntry nestedFrom = new FromType(ali3, uri2, /* withoutSubtypes */true);
            Query nestedQuery = new Query(new SelectEntry[] { nestedSelect }, new FromEntry[] { nestedFrom });
            SelectEntry select = new SelectAlias(ali2);
            FromEntry from1 = new FromType(ali, uri, /* withoutSubtypes */true);
            FromEntry from2 = new FromType(ali2, uri2, /* withoutSubtypes */true);
            WhereNestedReference where = new WhereNestedReference(ali, ((PropertyCallExp) body).getReferredProperty().getName(),
                    nestedQuery);
            Query query = new Query(new SelectEntry[] { select }, new FromEntry[] { from1, from2 }, new WhereEntry[] { where });
            resultSet = queryProcessor.execute(query, queryContext);

        } catch (RuntimeException e) { }
        finally {
            result = new HashMap<EObject, Integer>();
            if (!resultSet.isEmpty()) {                
                int count = 1;
                for (int i = 0; i < resultSet.getSize(); i++) {
                    EObject value = queryContext.getResourceSet().getEObject(resultSet.getUri(i, ali2), /* loadOnDemand */true); //$NON-NLS-1$
                    if (result.containsValue(value)) {
                        count++;
                        result.put(value, count);
                    } else {
                        count = 1;
                        result.put(value, count);
                    }
                }
            }
        }
        return result;
    }

    private Map<Object, Integer> collectOverAttribute(Set<EObject> contextObjects, OCLExpression<EClassifier> body, EClassifier ocType) {
        Map<Object, Integer> result = null;
        ResultSet resultSet = null;
        QueryContext queryContext = new ProjectBasedQueryContextScopeProviderImpl(contextObjects.toArray(new EObject[contextObjects.size()])).getForwardScopeAsQueryContext();
        QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        URI uri = EcoreUtil.getURI(ocType);
        String ali = ((PropertyCallExp) body).getSource().getName();
        try {
            // collect over an attribute
            // "select "+ stringBody+" from  [" + uri1 + "] as "+ali
            SelectEntry select = new SelectAttrs(ali, new String[] { ((PropertyCallExp) body).getReferredProperty().getName() });
            FromEntry from = new FromType(ali, uri, /* withoutSubtypes */true);
            Query query = new Query(new SelectEntry[] { select }, new FromEntry[] { from });
            resultSet = queryProcessor.execute(query, queryContext);
        } catch (RuntimeException e) { }
        finally {
            Map<Object, Integer> col = new HashMap<Object, Integer>();
            if (!resultSet.isEmpty()) {
                int count = 1;
                for (int i = 0; i < resultSet.getSize(); i++) {
                    Object value = null;
                    Object[] attribute = resultSet.getAttributes(i, ali);
                    for (int j = 0; j < attribute.length; j++) {
                        value = attribute[j];
                    }
                    if (col.containsKey(value)) {
                        count++;
                        col.put(value, count);
                    } else {
                        count = 1;
                        col.put(value, count);
                    }
                }
            }
            result = col;
        }
        return result;
    }

    private Operation mapStringToOperation(String eOp) {
        Operation operation;
        if ("=".equals(eOp))
            operation = Operation.EQUAL;
        else if ("!=".equals(eOp) || "=!".equals(eOp) || "<>".equals(eOp))
            operation = Operation.NOTEQUAL;
        else if (">=".equals(eOp) || "=>".equals(eOp))
            operation = Operation.GREATEREQUAL;
        else if (">".equals(eOp))
            operation = Operation.GREATER;
        else if ("<=".equals(eOp) || "=<".equals(eOp))
            operation = Operation.SMALLEREQUAL;
        else if ("<".equals(eOp))
            operation = Operation.SMALLER;
        else if ("like".equalsIgnoreCase(eOp))
            operation = Operation.GREATEREQUAL;
        else
            throw new RuntimeException();
        return operation;
    }

    private Collection<EObject> buildResult(ResultSet resultSet, QueryContext queryContext, String ali) {
        Collection<EObject> result = new HashSet<EObject>();
        if (!resultSet.isEmpty()) {
            for (int i = 0; i < resultSet.getSize(); i++) {
                result.add(queryContext.getResourceSet().getEObject(resultSet.getUri(i, ali), /* loadOnDemand */true)); //$NON-NLS-1$
            }
        }
        return result;
    }

}
