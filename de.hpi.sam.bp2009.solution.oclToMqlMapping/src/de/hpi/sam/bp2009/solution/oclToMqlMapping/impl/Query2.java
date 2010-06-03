package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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
            QueryContext queryContext = setQueryContext(allO);
            QueryProcessor queryProcessor = setQueryProcessor();
            ResultSet resultSet=null;
            String regex="([0-9A-Za-z]+)\\.([0-9A-Za-z]+)\\*\\*\\*([0-9A-Za-z]+)\\=([0-9A-Za-z]+)";
            String regex2="([0-9A-Za-z]+)\\.([0-9A-Za-z]+)\\=([0-9A-Za-z]+)\\.([0-9A-Za-z]+)\\*\\*\\*([0-9A-Za-z]+)";
            String regex3="([0-9A-Za-z]+)\\.([0-9A-Za-z]+)=([0-9A-Za-z]+)\\.([0-9A-Za-z]+)";
            String stars = "\\*\\*\\*";
            String alias = "([0-9A-Za-z]\\.)";
            String comp ="([0-9A-Za-z]{1}\\.)([0-9A-Za-z]+)([\\=\\<\\>]+)";
            Pattern pattern=Pattern.compile(regex);
            Pattern pattern2=Pattern.compile(regex2);
            Pattern pattern3=Pattern.compile(regex3);
            Pattern pattern_stars=Pattern.compile(stars);
            Pattern pattern_alias = Pattern.compile(alias);
            Pattern pattern_comp=Pattern.compile(comp);
            Matcher match=pattern.matcher(stringBody);
            Matcher match2=pattern_stars.matcher(stringBody);
            Matcher match3=pattern_alias.matcher(stringBody);
            Matcher match4=pattern2.matcher(stringBody);
            Matcher match5=pattern_comp.matcher(stringBody);
            Matcher match6=pattern3.matcher(stringBody);
            boolean test = match.find();
            boolean test2 = match2.find();
            boolean test3 =match3.find();
            boolean test4 =match4.find();
            boolean test5 =match5.find();
            boolean test6 =match6.find();
            if(test && test2 && test3){
                
                    String nav = stringBody.substring(match.start(1), stringBody.indexOf("***"));
                    String cond = stringBody.substring(stringBody.indexOf("***")+3);
                    String ali = stringBody.substring(match3.start(1), stringBody.indexOf("."));
                    if (body instanceof OperationCallExp<?, ?>){

                        Object prop = ((PropertyCallExp) ((PropertyCallExp) ((OperationCallExp<?, ?>) body).getSource()).getSource()).getReferredProperty();
                        if(prop instanceof EReference){
                            Object propType = ((EReference) prop).getEType();
                            EClassifier eclass2 = (EClassifier) propType;
                            URI uri2=EcoreUtil.getURI(eclass2);

                            try{
                                //if the body is a navigation
                                resultSet = queryProcessor.execute("select "+ali+" from  [" + uri1 + //$NON-NLS-1$
                                        "] as "+ali+" where "+nav+" in ( select p2 from [" + uri2+"] as p2 where p2." + cond+")", queryContext); //$NON-NLS-1$
                            }
                            catch (EvaluationHaltedException e) {
                                // evaluation stopped on demand, propagate further
                                throw e;
                            } catch (RuntimeException e) {
                                result=null;
                            }
                            finally{
                                result = buildResult(resultSet, queryContext, ali);
                                }

                        }}}
            else if(test3 &&!test2 &&!test6){
                
                String ali = stringBody.substring(match3.start(1), stringBody.indexOf("."));
                try{
                    //if the body is a comparison between an attribute and a value
                    resultSet = queryProcessor.execute("select "+ ali+" from  [" + uri1 + //$NON-NLS-1$
                            "] as "+ali+" where " + stringBody, queryContext); //$NON-NLS-1$
                }
                catch (EvaluationHaltedException e) {
                    // evaluation stopped on demand, propagate further
                    throw e;
                } catch (RuntimeException e) {
                    result=null;
                }
                finally{
                    result = buildResult(resultSet, queryContext, ali);
                    }
            }
            else if(test4 && test5 ){
                
                String ali = stringBody.substring(match4.start(1), stringBody.indexOf("."));
                String nav = stringBody.substring(match5.end(), stringBody.indexOf("***"));
                String cond = stringBody.substring(stringBody.indexOf("."),match5.end());
                String cond2=stringBody.substring(stringBody.indexOf("***")+3);
                
                if (body instanceof OperationCallExp<?, ?>){
                    List<OCLExpression> args = ((OperationCallExp) body).getArgument();
                    OCLExpression arg = args.get(0);
                    PropertyCallExp src = (PropertyCallExp) ((PropertyCallExp) arg).getSource();
                    Object prop = src.getReferredProperty();
                    if(prop instanceof EReference){
                        Object propType = ((EReference) prop).getEType();
                        EClassifier eclass2 = (EClassifier) propType;
                        URI uri2=EcoreUtil.getURI(eclass2);

                try{
                    //if the body is a comparison with navigation, wrong result
                    resultSet = queryProcessor.execute("select "+ ali+" from  [" + uri1 + //$NON-NLS-1$
                            "] as "+ali+" ,["+uri2+"] as p3 where " +nav+"=p3 where "+ali+ cond+ "p3."+ cond2, queryContext); //$NON-NLS-1$
                }
                catch (EvaluationHaltedException e) {
                    // evaluation stopped on demand, propagate further
                    throw e;
                } catch (RuntimeException e) {
                    result=null;
                }
                finally{
                    result = buildResult(resultSet, queryContext, ali);
                    }
            }}
               
                }
            else if(test6 && test3){
                String ali = stringBody.substring(match6.start(1), stringBody.indexOf("."));
                String cond= stringBody.replaceFirst(alias,"p.");
//                cond= cond.replaceFirst("e2", ali);
                
                try{
                   
                    //if the body is a comparison without navigation, wrong query
                    resultSet = queryProcessor.execute("select "+ ali+" from [" + uri1 + //$NON-NLS-1$
                            "] as p , ["+uri1+"] as "+ali+" where "+ali+"=p where "+cond, queryContext); //$NON-NLS-1$
                }
                catch (EvaluationHaltedException e) {
                    // evaluation stopped on demand, propagate further
                    throw e;
                } catch (RuntimeException e) {
                    result=null;
                }
                finally{
                    result = buildResult(resultSet, queryContext, ali);
                    }}
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
            QueryContext queryContext = setQueryContext(allO);
            ResultSet resultSet=null;
            QueryProcessor queryProcessor = setQueryProcessor();
//            String regex="([0-9A-Za-z]+)\\.([0-9A-Za-z]+)";//regex collect (Attribute) body
            
            String alias = "([0-9A-Za-z]{1}\\.)";
//            Pattern pattern=Pattern.compile(regex);
            
            Pattern pattern3 = Pattern.compile(alias);
//            Matcher match=pattern.matcher(stringBody);
            Matcher match3=pattern3.matcher(stringBody);
//            boolean test1 = match.find();
//            boolean test2 = match2.find();
            boolean test3 = match3.find();
            if (body instanceof PropertyCallExp<?, ?>){

                Object prop = ((PropertyCallExp) body).getReferredProperty();
                if(prop instanceof EReference){
                    Object propType = ((EReference) prop).getEType();
                    EClassifier eclass2 = (EClassifier) propType;
                    URI uri2=EcoreUtil.getURI(eclass2);
                    String ali = stringBody.substring(match3.start(1), stringBody.indexOf("."));
                    //TODO delete "with" and "in assoc", compare with ebnf for right mql
                    try{
                        resultSet = queryProcessor.execute("select "+ali+" from  [" +uri1+ //$NON-NLS-1$
                                "] as "+ali+" , [" +uri2+ "] as a2 where " +stringBody+"=a2" , queryContext); //$NON-NLS-1$
                    }
                    catch (EvaluationHaltedException e) {
                        // evaluation stopped on demand, propagate further
                        throw e;
                    } catch (RuntimeException e) {
                        result=null;
                    }
                    finally{
                        result = buildResult(resultSet, queryContext, ali);
                        }

                }else if(prop instanceof EAttribute){
                    String ali = stringBody.substring(match3.start(1), stringBody.indexOf("."));
                    try{
                        //TODO change result
                        resultSet = queryProcessor.execute("select "+ stringBody+" from  [" + uri1 + //$NON-NLS-1$
                                "] as "+ali, queryContext); //$NON-NLS-1$
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
                                col.add((EObject) resultSet); //$NON-NLS-1$

                            }
                            result = col;
                            System.out.println("successfull");
                        }
                        else {
                            Collection<EObject> col= new HashSet<EObject>();
                            
                            result = col;
                        }
                    } 
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
    
    private static Object buildResult(ResultSet resultSet, QueryContext queryContext, String ali){
        Object result;
    if(!resultSet.isEmpty()){
        Collection<EObject> col= new HashSet<EObject>();
        for(int i=0; i<resultSet.getSize();i++){
            col.add(queryContext.getResourceSet().getEObject(resultSet.getUri(i, ali), /* loadOnDemand */true)); //$NON-NLS-1$

        }
        result = col;
        System.out.println("successfull");
    }
    else {
        Collection<EObject> col= new HashSet<EObject>();
        
        result = col;
    }
    return result;
    }
    
    private static QueryContext setQueryContext(Set<EObject> allO){
        ScopeProvider pro = new ProjectBasedScopeProviderImpl(allO.toArray(new EObject[allO.size()]));
        QueryContext queryContext = pro.getForwardScopeAsQueryContext();
    return queryContext;
    }
    private static QueryProcessor setQueryProcessor(){
        Index DEFAULT_INDEX = null;
        DEFAULT_INDEX = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);
        QueryProcessor queryProcessor = new QueryProcessorImpl(DEFAULT_INDEX);
    return queryProcessor;
    }
}
