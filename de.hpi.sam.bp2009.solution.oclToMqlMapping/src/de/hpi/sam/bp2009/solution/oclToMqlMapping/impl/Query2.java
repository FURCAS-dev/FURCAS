package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;

import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

@SuppressWarnings("restriction")
public class Query2  {


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Object buildMqlQuery(Set<EObject> allO,  Object ocType, OCLExpression body, IteratorExp ie, MappingEvaluationVisitor<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> mapev){
        //TODO other query for each predefinded type
        Object result = null;
        MqlMapperToString<?, EClassifier, EOperation, EStructuralFeature, ?, ?, ?, ?, ?, Constraint, EClass, EObject> mmts ;
        mmts = new MqlMapperToString(mapev.getEnvironment(), mapev.getEvaluationEnvironment(), mapev.getExtentMap());
        EClassifier eclass1 = (EClassifier) ocType;
        URI uri1 = EcoreUtil.getURI(eclass1);
        String stringBody =null;
        stringBody = (String) mmts.visitExpression(body);
        if (mmts.wasErrorful()){
            return result;
        }
        int itExp = OCLStandardLibraryUtil.getOperationCode(ie.getName());
        switch (itExp){
        case 201:{
            //exists
        }
        case 202:{
            //forAll
        }
        case 209:{
            //            select
            ScopeProvider pro = new ProjectBasedScopeProviderImpl(allO.toArray(new EObject[allO.size()]));
            QueryContext queryContext = pro.getForwardScopeAsQueryContext();

            Index DEFAULT_INDEX = null;
            DEFAULT_INDEX = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);
            QueryProcessor queryProcessor = new QueryProcessorImpl(DEFAULT_INDEX);
            ResultSet resultSet=null;
            String regex="([0-9A-Za-z]+)\\.([0-9A-Za-z]+)\\*\\*\\*([0-9A-Za-z]+)\\=([0-9A-Za-z]+)";
            String stars = "\\*\\*\\*";
            Pattern pattern=Pattern.compile(regex);
            Pattern patt=Pattern.compile(stars);
            Matcher match=pattern.matcher(stringBody);
            Matcher match2=patt.matcher(stringBody);
            boolean test = match2.find();
            boolean test2 = match.find();
            if(test){
                if(test2){
                    String nav = stringBody.substring(stringBody.indexOf("("), stringBody.indexOf("***"));
                    String cond = stringBody.substring(stringBody.indexOf("***")+3);
                    if (body instanceof OperationCallExp<?, ?>){

                        Object prop = ((PropertyCallExp) ((PropertyCallExp) ((OperationCallExp<?, ?>) body).getSource()).getSource()).getReferredProperty();
                        if(prop instanceof EReference){
                            Object propType = ((EReference) prop).getEType();
                            EClassifier eclass2 = (EClassifier) propType;
                            URI uri2=EcoreUtil.getURI(eclass2);

                            try{
                                //if the body is a comparison between an attribute and a value
                                resultSet = queryProcessor.execute("select p1 from  [" + uri1 + //$NON-NLS-1$
                                        "] as p1 where "+nav+" in ( select p2 from [" + uri2+"]as p2 where p2." + cond+")", queryContext); //$NON-NLS-1$
                            }
                            catch (EvaluationHaltedException e) {
                                // evaluation stopped on demand, propagate further
                                throw e;
                            } catch (RuntimeException e) {
                                result=null;
                            }
                            finally{
                                if(!resultSet.isEmpty()){
                                    Collection<EObject> col= new HashSet<EObject>();
                                    for(int i=0; i<resultSet.getSize();i++){
                                        col.add(queryContext.getResourceSet().getEObject(resultSet.getUri(i,"p"), /* loadOnDemand */true)); //$NON-NLS-1$

                                    }
                                    result = col;
                                    System.out.println("successfull");
                                }
                                else {
                                    // TODO add handling of empty result set
                                    result= null;
                                }}

                        }}}}else{
                            try{
                                //if the body is a comparison between an attribute and a value
                                resultSet = queryProcessor.execute("select p from  [" + uri1 + //$NON-NLS-1$
                                        "] as p where " + stringBody, queryContext); //$NON-NLS-1$
                            }
                            catch (EvaluationHaltedException e) {
                                // evaluation stopped on demand, propagate further
                                throw e;
                            } catch (RuntimeException e) {
                                result=null;
                            }
                            finally{
                                if(!resultSet.isEmpty()){
                                    Collection<EObject> col= new HashSet<EObject>();
                                    for(int i=0; i<resultSet.getSize();i++){
                                        col.add(queryContext.getResourceSet().getEObject(resultSet.getUri(i,"p"), /* loadOnDemand */true)); //$NON-NLS-1$

                                    }
                                    result = col;
                                    System.out.println("successfull");
                                }
                                else {
                                    // TODO add handling of empty result set
                                    result= null;
                                }}
                        }
            return result;
        }





        case 205:{
            //any
        }
        case 210:{
            //reject
        }
        case 206:{
            //collect
            ScopeProvider pro = new ProjectBasedScopeProviderImpl(allO.toArray(new EObject[allO.size()]));
            QueryContext queryContext = pro.getForwardScopeAsQueryContext();
            ResultSet resultSet=null;
            Index DEFAULT_INDEX = null;
            DEFAULT_INDEX = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);
            QueryProcessor queryProcessor = new QueryProcessorImpl(DEFAULT_INDEX);
            if (body instanceof PropertyCallExp<?, ?>){

                Object prop = ((PropertyCallExp) body).getReferredProperty();
                if(prop instanceof EReference){
                    Object propType = ((EReference) prop).getEType();
                    EClassifier eclass2 = (EClassifier) propType;
                    URI uri2=EcoreUtil.getURI(eclass2);
                    //TODO check if correctly type-checking
                    try{
                        resultSet = queryProcessor.execute("select a2 from  [" +uri1+ //$NON-NLS-1$
                                "] as a1," +uri2+ " as a2 with (a1,a2) in assoc( " +stringBody+ ")", queryContext); //$NON-NLS-1$
                    }
                    catch (EvaluationHaltedException e) {
                        // evaluation stopped on demand, propagate further
                        throw e;
                    } catch (RuntimeException e) {
                        result=null;
                    }
                    finally{
                        if(!resultSet.isEmpty()){
                            Collection<EObject> col= new HashSet<EObject>();
                            for(int i=0; i<resultSet.getSize();i++){
                                col.add(queryContext.getResourceSet().getEObject(resultSet.getUri(i,"p"), /* loadOnDemand */true)); //$NON-NLS-1$

                            }
                            result = col;
                            System.out.println("successfull");
                        }
                        else {
                            // TODO add handling of empty result set
                            result= null;
                        }}

                }else if(prop instanceof EAttribute){

                    try{
                        //TODO change result
                        resultSet = queryProcessor.execute("select "+ stringBody+" from  [" + uri1 + //$NON-NLS-1$
                                "] as p", queryContext); //$NON-NLS-1$
                    }
                    catch (EvaluationHaltedException e) {
                        // evaluation stopped on demand, propagate further
                        throw e;
                    } catch (RuntimeException e) {
                        result=null;
                    }
                    finally{
                        if(!resultSet.isEmpty()){
                            Collection<EObject> col= new HashSet<EObject>();
                            for(int i=0; i<resultSet.getSize();i++){
                                col.add(queryContext.getResourceSet().getEObject(resultSet.getUri(i,"p"), /* loadOnDemand */true)); //$NON-NLS-1$

                            }
                            result = col;
                            System.out.println("successfull");
                        }
                        else {
                            // TODO add handling of empty result set
                            result= null;
                        }}
                }
                return result;
            }
            else{
                //if body is of type OperationCallExpression the expression can not be mapped
                return result;
            }

        }
        case 207:{
            //collectNested
        }case 204:{
            //one
        }
        case 211:{
            //sortedBy
        }
        case 203:{
            //isUnique
        }
        case 208:{
            //closure
        }
        default: return result;
        }


    }

}
