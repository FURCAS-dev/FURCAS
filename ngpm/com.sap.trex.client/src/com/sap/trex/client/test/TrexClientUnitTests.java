package com.sap.trex.client.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.sap.trex.client.AdminService;
import com.sap.trex.client.AggregationType;
import com.sap.trex.client.AttributeDefinition;
import com.sap.trex.client.AttributeFlags;
import com.sap.trex.client.AttributeType;
import com.sap.trex.client.Connection;
import com.sap.trex.client.CreateHierarchyIndex_Request;
import com.sap.trex.client.CreateIndex_Request;
import com.sap.trex.client.DeleteIndex_Request;
import com.sap.trex.client.DocumentAction;
import com.sap.trex.client.GetVersion_Result;
import com.sap.trex.client.IndexAttribute;
import com.sap.trex.client.IndexColumnSpec;
import com.sap.trex.client.IndexDocument;
import com.sap.trex.client.IndexDocuments_Request;
import com.sap.trex.client.IndexDocuments_Result;
import com.sap.trex.client.IndexName;
import com.sap.trex.client.IndexService;
import com.sap.trex.client.IndexTableRow;
import com.sap.trex.client.IndexTable_Request;
import com.sap.trex.client.KeyFigure;
import com.sap.trex.client.ListIndex_Request;
import com.sap.trex.client.ListIndex_Result;
import com.sap.trex.client.OlapGuidedNavSearch_Request;
import com.sap.trex.client.OlapGuidedNavSearch_Result;
import com.sap.trex.client.OlapSearch_Request;
import com.sap.trex.client.OlapSearch_Result;
import com.sap.trex.client.PlaceHolder;
import com.sap.trex.client.PythonCall_Request;
import com.sap.trex.client.PythonCall_Result;
import com.sap.trex.client.QueryEntry;
import com.sap.trex.client.Request;
import com.sap.trex.client.RequestedAttribute;
import com.sap.trex.client.Result;
import com.sap.trex.client.ResultAttribute;
import com.sap.trex.client.ResultAttributeDefinition;
import com.sap.trex.client.ResultDocument;
import com.sap.trex.client.ResultTable;
import com.sap.trex.client.SearchDocuments_Request;
import com.sap.trex.client.SearchDocuments_Result;
import com.sap.trex.client.SearchTable_Request;
import com.sap.trex.client.SearchTable_Result;
import com.sap.trex.client.ShowIndexInfo_Request;
import com.sap.trex.client.ShowIndexInfo_Result;
import com.sap.trex.client.ShowIndex_Request;
import com.sap.trex.client.ShowIndex_Result;
import com.sap.trex.client.ShowJoinIndex_Request;
import com.sap.trex.client.ShowJoinIndex_Result;
import com.sap.trex.client.SortAttribute;
import com.sap.trex.client.TreeNode;
import com.sap.trex.client.ViewAttribute;
import com.sap.trex.client.ViewAttributeGroup;

public class TrexClientUnitTests  extends TestCase {

  private static String host;
  private static int    port;
  private static String URL = "";

  private static final String IMPORT_PATH_WINDOWS = "\\\\trextest\\trex_test\\barbara\\unittest";
  private static final String IMPORT_PATH_LINUX   = "/sapmnt/trextest/trex_test/barbara/unittest";

  private static final String docIndexId = "trexjunit:docidx";  
  private static final String tabIndexId = "trexjunit:tabidx"; 
  private static final String olapIndexId  = "br9_0bwvc_001_ps";  
  private static final String olapIndexId2 = "y1q_0bwvc_035_ps";  
  private static final String olapIndexId3 = "ms_adventureworks:cube";    
  private static final String hierarchyIndexId = "trexjunit:hieridx"; 

  private Properties properties = new Properties();

  String test_string       = "This is a first test string attribute.";
  String test_alphanum     = "0000001234";
  String test_fixedstring  = "200635332";
  String test_text         = "sap bobj java abap M\u00fcnchen \u30DB\u30FC\u30E0";
  String test_date         = "20080701121730";
  String test_time         = "121730";
  int    test_int          = 2000002;
  float  test_float        = 3.1415f;
  double test_double       = 6.2830;
  String test_fixed        = "456372";
  String test_decfloat     = "3.14159265";
  String test_unitdecfloat = "1.75 MTR";

  String test2_string       = "Next line";
  String test2_alphanum     = "00000abcd";
  String test2_fixedstring  = "200833449";
  String test2_text         = "E ist die Eulersche Zahl";
  String test2_date         = "20080707164133";
  String test2_time         = "16:41:33";
  int    test2_int          = 2000000;
  float  test2_float        = 2.718281828459045f;
  double test2_double       = 2.718281828459045;
  String test2_fixed        = "2.718281828459045";
  String test2_decfloat     = "2.718281828459045";
  String test2_unitdecfloat = "0.33 LTR";

  String check_string       = "This is a first test string attribute.";
  String check_alphanum     = "1234";
  String check_fixedstring  = "200635332";
  String check_text         = "sap bobj java abap M\u00fcnchen \u30DB\u30FC\u30E0";
  String check_date         = "2008-07-01 12:17:30";
  String check_time         = "12:17:30";
  int    check_int          = 2000002;
  float  check_float        = 3.1415f;
  double check_double       = 6.2830;
  String check_fixed        = "456372";
  String check_decfloat     = "3.14159265";
  String check_unitdecfloat = "1.75#LENGTH";

  String attr_string       = "attr_string";
  String attr_alphanum     = "attr_alphanum";
  String attr_fixedstring  = "attr_fixedstring";
  String attr_text         = "attr_text";
  String attr_textae       = "attr_textae";  
  String attr_date         = "attr_date";
  String attr_time         = "attr_time";
  String attr_int          = "attr_int";
  String attr_float        = "attr_float";
  String attr_double       = "attr_double";
  String attr_fixed        = "attr_fixed";
  String attr_decfloat     = "attr_decfloat";
  String attr_unitdecfloat = "attr_unitdecfloat";

  private static final String TREX_PROPERTIES_FILENAME = "trex.properties";


  protected void setUp() throws Exception
  {
    ClassLoader   cl = this.getClass().getClassLoader();
    String        rsrc = this.getClass().getName().replace('.', '/')+ ".class";         
    String        url = cl.getResource(rsrc).toString();
    String dir = new File(url.substring(5)).getParent();
    boolean found = new File(dir, "trex.properties").exists();
    if (found)
    {
      FileInputStream in = new FileInputStream(new File(dir, TREX_PROPERTIES_FILENAME));
      properties.load(in);
      URL = properties.getProperty("url");
      System.out.println("Connection URL: " + URL);

      String keyStore=properties.getProperty("keyStore");
      if(keyStore==null)  keyStore="c:\\work\\ssl\\java\\keystore.jks";
      System.setProperty("javax.net.ssl.keyStore", keyStore );

      String keyStorePassword=properties.getProperty("keyStorePassword");
      if(keyStorePassword==null) keyStorePassword="trextrex";
      System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword );      

      //System.setProperty("javax.net.debug", "all" );
    } else {
      System.out.println("Path to trex.properties: " + dir);
      System.err.println("Properties file not found");
      URL = "trex://10.20.159.114:31316";
      // throw new Exception ("Properies file not found.");
    }
  }

  @Test public void testcase_version() throws Exception {
    listIndexes(); 
  }

  @Test public void testcase_docs() throws Exception {
    deleteIndex(docIndexId);
    createIndex(docIndexId, false);
    indexDocuments();
    searchDocuments();
    showIndex();
  }

  @Test public void testcase_table() throws Exception {
    deleteIndex(tabIndexId);
    createIndex(tabIndexId, true);
    indexTable();
    searchTable();
  }  

  @Test public void testcase_hierarchy() throws Exception {
    deleteIndex(hierarchyIndexId);
    createHierarchyIndex();
  }

  @Test public void testcase_olap()  throws Exception{
    importIndexes();
    searchOlap();
    guidedNavigation();
  }

  @Test public void testcase_listIndexes()  throws Exception{
    //importIndexes();    
    listIndexes();
    //showJoinIndex();
    //showJoinIndex2();
    //showIndexInfo();
  }  

  @Test public void testcase_polestar()  throws Exception{
    searchTableWithScript();
    searchTableWithScript2();  
  }

  public void getVersion() throws Exception
  {

    System.out.println("GetVersion:");

    Connection aCon  = new Connection(URL);
    AdminService anAdminService = new AdminService(aCon);
    Request aReq = new Request();    
    GetVersion_Result aRes  = new GetVersion_Result();

    anAdminService.getVersion(aReq, aRes);


    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }	

    Assert.assertEquals(0, aRes.getError().getCode());

    for (int i=0;i<aRes.getVersionInfos().size();i++)
    {  
      System.out.println(">Version: " + aRes.getVersionInfos().get(i).getVersion());
      System.out.println(">BuildNr: " + aRes.getVersionInfos().get(i).getBuildNr());
      System.out.println(">ChangeList: " + aRes.getVersionInfos().get(i).getChangeList());
    } 
  } 

  public void deleteIndex(String indexId) throws Exception
  {
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    DeleteIndex_Request aReq = new DeleteIndex_Request();
    Result aRes = new Result();

    aReq.setIndexName(new IndexName(indexId,""));

    anIndexService.deleteIndex(aReq, aRes);

    if ( aRes.getError().getCode() > 0 ) {
      System.out.println("DeleteIndex:");
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }	
    //Assert.assertEquals(0, aRes.getError().getCode());
  }


  public void createIndex(String indexId, boolean withKeyAttributes) throws Exception
  {
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    CreateIndex_Request aReq = new CreateIndex_Request();

    aReq.setIndexName(new IndexName(indexId,""));
    aReq.setDescription("M\u00fcnchen");
    
    aReq.addAttribute(new AttributeDefinition(attr_string,AttributeType.ATTRIBUTETYPE_STRING));
    aReq.addAttribute(new AttributeDefinition(attr_alphanum,AttributeType.ATTRIBUTETYPE_ALPHANUM)); 
    aReq.addAttribute(new AttributeDefinition(attr_fixedstring,AttributeType.ATTRIBUTETYPE_FIXEDSTRING)); 
    aReq.addAttribute(new AttributeDefinition(attr_text,AttributeType.ATTRIBUTETYPE_TEXT));  
    aReq.addAttribute(new AttributeDefinition(attr_textae,AttributeType.ATTRIBUTETYPE_TEXTAE,AttributeFlags.ATTRIBUTEFLAGS_SINGLEVALUED));
    aReq.addAttribute(new AttributeDefinition(attr_date,AttributeType.ATTRIBUTETYPE_DATE)); 
    aReq.addAttribute(new AttributeDefinition(attr_time,AttributeType.ATTRIBUTETYPE_TIME)); 
    aReq.addAttribute(new AttributeDefinition(attr_int,AttributeType.ATTRIBUTETYPE_INT)); 
    aReq.addAttribute(new AttributeDefinition(attr_float,AttributeType.ATTRIBUTETYPE_FLOAT)); 
    aReq.addAttribute(new AttributeDefinition(attr_double,AttributeType.ATTRIBUTETYPE_DOUBLE)); 
    aReq.addAttribute(new AttributeDefinition(attr_fixed,AttributeType.ATTRIBUTETYPE_FIXED)); 
    aReq.addAttribute(new AttributeDefinition(attr_decfloat,AttributeType.ATTRIBUTETYPE_DECFLOAT)); 
    aReq.addAttribute(new AttributeDefinition(attr_unitdecfloat,AttributeType.ATTRIBUTETYPE_UNITDECFLOAT)); 

    if (withKeyAttributes == true) {
      aReq.addKeyAttribute(attr_int);
    }

    Result aRes = new Result();
    anIndexService.createIndex(aReq, aRes);

    if ( aRes.getError().getCode() > 0 ) {
      System.out.println("CreateIndex:");
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }    
    Assert.assertEquals(0, aRes.getError().getCode());
  }


  public void createHierarchyIndex() throws Exception
  {	
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    CreateHierarchyIndex_Request aReq = new CreateHierarchyIndex_Request();

    aReq.setIndexName(hierarchyIndexId);
    aReq.setPredSuccIndex("trexjunit:hieridx~predsucc");
    aReq.setIntervalIndex("trexjunit:hieridx~interval");
    aReq.setSidIndex("trexjunit:hieridx~sid");
    aReq.setSidAttribute("xxx");

    Result aRes = new Result();
    anIndexService.createHierarchyIndex(aReq, aRes);

    if ( aRes.getError().getCode() > 0 ) {
      System.out.println("CreateHierarchyIndex:");
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }    
    Assert.assertEquals(0, aRes.getError().getCode());
  }   

  public void indexDocuments() throws Exception
  {  
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    IndexDocuments_Request aReq = new IndexDocuments_Request(); 

    aReq.setIndexId(docIndexId);

    IndexDocument aDoc;

    aDoc = new IndexDocument();
    aDoc.setKey("key1");
    aDoc.setAction(DocumentAction.DOCUMENTACTION_INDEX);    
    aDoc.setLanguage("EN");  

    aDoc.addAttribute(new IndexAttribute(attr_string,test_string,AttributeType.ATTRIBUTETYPE_STRING));
    aDoc.addAttribute(new IndexAttribute(attr_string,test2_string,AttributeType.ATTRIBUTETYPE_STRING));
    aDoc.addAttribute(new IndexAttribute(attr_alphanum,test_alphanum,AttributeType.ATTRIBUTETYPE_ALPHANUM));
    aDoc.addAttribute(new IndexAttribute(attr_fixedstring,test_fixedstring,AttributeType.ATTRIBUTETYPE_FIXEDSTRING));
    aDoc.addAttribute(new IndexAttribute(attr_text,test_text,AttributeType.ATTRIBUTETYPE_TEXT));
    aDoc.addAttribute(new IndexAttribute(attr_textae,test_text,AttributeType.ATTRIBUTETYPE_TEXTAE));
    aDoc.addAttribute(new IndexAttribute(attr_date,test_date,AttributeType.ATTRIBUTETYPE_DATE));
    aDoc.addAttribute(new IndexAttribute(attr_time,test_time,AttributeType.ATTRIBUTETYPE_TIME));
    aDoc.addAttribute(new IndexAttribute(attr_int,String.valueOf(test_int),AttributeType.ATTRIBUTETYPE_INT));
    aDoc.addAttribute(new IndexAttribute(attr_float,String.valueOf(test_float),AttributeType.ATTRIBUTETYPE_FLOAT));
    aDoc.addAttribute(new IndexAttribute(attr_double,String.valueOf(test_double),AttributeType.ATTRIBUTETYPE_DOUBLE));
    aDoc.addAttribute(new IndexAttribute(attr_fixed,test_fixed,AttributeType.ATTRIBUTETYPE_FIXED));
    aDoc.addAttribute(new IndexAttribute(attr_decfloat,test_decfloat,AttributeType.ATTRIBUTETYPE_DECFLOAT));
    aDoc.addAttribute(new IndexAttribute(attr_unitdecfloat,test_unitdecfloat,AttributeType.ATTRIBUTETYPE_UNITDECFLOAT));

    aDoc.setContent("this is the new content!");
    aReq.addDocument(aDoc);  

    aDoc = new IndexDocument();
    aDoc.setKey("key2");
    aDoc.setAction(DocumentAction.DOCUMENTACTION_INDEX);    
    aDoc.setLanguage("EN");  

    aDoc.addAttribute(new IndexAttribute(attr_string,test2_string,AttributeType.ATTRIBUTETYPE_STRING));
    aDoc.addAttribute(new IndexAttribute(attr_time,test2_time,AttributeType.ATTRIBUTETYPE_TIME));
    aDoc.addAttribute(new IndexAttribute(attr_alphanum,test2_alphanum,AttributeType.ATTRIBUTETYPE_ALPHANUM));

    aDoc.setContent("content of the second doc");
    aReq.addDocument(aDoc);    

    aReq.setAutoOptimize(true);
    IndexDocuments_Result aRes = new IndexDocuments_Result();
    anIndexService.indexDocuments(aReq, aRes);

    if ( aRes.getError().getCode() > 0 ) {
      System.out.println("IndexDocuments:");
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }    
    Assert.assertEquals(0, aRes.getError().getCode());
  }


  public void searchDocuments() throws Exception
  {
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    SearchDocuments_Request aReq = new SearchDocuments_Request();
    SearchDocuments_Result aRes = new SearchDocuments_Result();

    aReq.addIndexName(new IndexName(docIndexId,"en"));

    QueryEntry aQE = new QueryEntry();
    aQE.setAttribute(attr_alphanum);
    //aQE.setValue1(check_alphanum);    
    aQE.addValue(check_alphanum);
    aQE.setOperator(com.sap.trex.client.Operator.OPERATOR_EQ);
    aQE.setRowType(com.sap.trex.client.RowType.ROWTYPE_ATTRIBUTE);
    aReq.addQueryEntry(aQE);

    aReq.setTo(10);

    aReq.addRequestedAttribute(new RequestedAttribute("*")); 

    anIndexService.searchDocuments(aReq, aRes);

    System.out.println("SearchDocuments:");
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code: "+ aRes.getError().getCode());
      System.out.println(">Error Mess: "+ aRes.getError().getMsg());
    }
    Assert.assertEquals(0, aRes.getError().getCode());

    if ( aRes.getNoOfAllHits() < 2 ) {
      System.out.println(">No of All Hits: " +  aRes.getNoOfAllHits());
      System.out.println(">IndexSize: " +  aRes.getIndexSize());
    }
    Assert.assertEquals(1, aRes.getNoOfAllHits());

    ArrayList <ResultDocument> docs = new ArrayList<ResultDocument> ();
    ArrayList <ResultAttribute> attrs = new ArrayList<ResultAttribute> (); 
    ArrayList <ResultAttributeDefinition> attrdefs = new ArrayList<ResultAttributeDefinition> ();    
    docs     = aRes.getDocuments();
    attrdefs = aRes.getAttributes();

    for (int i = 0;i < docs.size();i++)
    {
      System.out.println(">Key: " +  docs.get(i).getKey());
      attrs = docs.get(i).getAttributes();
      for (int j=0;j<attrs.size();j++) {
        ResultAttribute attr = attrs.get(j);
        int ref = attr.getRef();
        System.out.print(" >Attribute: " + attrdefs.get(ref).getName() + ", type: " + attrdefs.get(ref).getType());
        for (int k=0;k<attr.getValues().size();k++) {
          System.out.print(", value: " + attr.getValues().get(k));  

          if (attrdefs.get(ref).getName().equals(attr_alphanum)) {
            Assert.assertEquals(check_alphanum, attr.getValues().get(k));
          }
          if (attrdefs.get(ref).getName().equals(attr_fixed)) {
            Assert.assertEquals(check_fixed, attr.getValues().get(k));
          } 
          if (attrdefs.get(ref).getName().equals(attr_text)) {
            Assert.assertEquals(check_text, attr.getValues().get(k));
          }   
          if (attrdefs.get(ref).getName().equals(attr_textae)) {
            Assert.assertEquals(check_text, attr.getValues().get(k));
          }  

        }
        System.out.println();
      }
    }    
  }  

  public void indexTable() throws Exception
  { 	
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    IndexTable_Request aReq = new IndexTable_Request();
    Result  aRes = new Result();

    aReq.setIndexId(tabIndexId);
    aReq.setAutoCommit(true);

    aReq.addColumn(new IndexColumnSpec(attr_string,AttributeType.ATTRIBUTETYPE_STRING));
    aReq.addColumn(new IndexColumnSpec(attr_alphanum,AttributeType.ATTRIBUTETYPE_ALPHANUM));
    aReq.addColumn(new IndexColumnSpec(attr_fixedstring,AttributeType.ATTRIBUTETYPE_FIXEDSTRING));
    aReq.addColumn(new IndexColumnSpec(attr_text,AttributeType.ATTRIBUTETYPE_TEXT));
    aReq.addColumn(new IndexColumnSpec(attr_textae,AttributeType.ATTRIBUTETYPE_TEXTAE));
    aReq.addColumn(new IndexColumnSpec(attr_date,AttributeType.ATTRIBUTETYPE_DATE));
    aReq.addColumn(new IndexColumnSpec(attr_time,AttributeType.ATTRIBUTETYPE_TIME));
    aReq.addColumn(new IndexColumnSpec(attr_int,AttributeType.ATTRIBUTETYPE_INT));  
    aReq.addColumn(new IndexColumnSpec(attr_float,AttributeType.ATTRIBUTETYPE_FLOAT));  
    aReq.addColumn(new IndexColumnSpec(attr_double,AttributeType.ATTRIBUTETYPE_DOUBLE));  
    aReq.addColumn(new IndexColumnSpec(attr_fixed,AttributeType.ATTRIBUTETYPE_FIXED));  
    aReq.addColumn(new IndexColumnSpec(attr_decfloat,AttributeType.ATTRIBUTETYPE_DECFLOAT));
    aReq.addColumn(new IndexColumnSpec(attr_unitdecfloat,AttributeType.ATTRIBUTETYPE_UNITDECFLOAT));


    IndexTableRow aRow;
    aRow = new IndexTableRow();
    aRow.clear(); 
    aRow.setAction(DocumentAction.DOCUMENTACTION_INDEX);
    aRow.addString(test_string);
    aRow.addString(test_alphanum);
    aRow.addString(test_fixedstring); 
    aRow.addString(test_text); 
    aRow.addString(test_text);  
    aRow.addString(test_date); 
    aRow.addString(test_time);  
    aRow.addInt(test_int);                        
    aRow.addFloat(test_float);  
    aRow.addDouble(test_double);  
    aRow.addString(test_fixed);  
    aRow.addString(test_decfloat);
    aRow.addString(test_unitdecfloat);      
    aReq.addRow(aRow);

    aRow = new IndexTableRow();    
    aRow.clear(); 
    aRow.setAction(DocumentAction.DOCUMENTACTION_INDEX);
    aRow.addString(test2_string);
    aRow.addString(test2_alphanum);
    aRow.addString(test2_fixedstring); 
    aRow.addString(test2_text); 
    aRow.addString(test2_text);  
    aRow.addString(test2_date); 
    aRow.addString(test2_time);  
    aRow.addInt(test2_int);                         
    aRow.addFloat(test2_float);  
    aRow.addDouble(test2_double);  
    aRow.addString(test2_fixed);  
    aRow.addString(test2_decfloat);
    aRow.addString(test2_unitdecfloat);      
    aReq.addRow(aRow);

    anIndexService.indexTable(aReq, aRes);

    if ( aRes.getError().getCode() > 0 ) {
      System.out.println("IndexTable:");
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }    
    Assert.assertEquals(0, aRes.getError().getCode());    
  }


  public void searchTable() throws Exception
  {	
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    SearchTable_Request aReq = new SearchTable_Request();
    SearchTable_Result aRes = new SearchTable_Result();

    aReq.addIndexName(new IndexName(tabIndexId,"en"));

    aReq.addRequestedAttribute(new RequestedAttribute("*"));

    QueryEntry aQE = new QueryEntry();
    aQE.setAttribute(attr_int);
    //aQE.setValue1(String.valueOf(test_int));
    aQE.addValue(String.valueOf(test_int));
    aQE.setOperator(com.sap.trex.client.Operator.OPERATOR_EQ);
    aQE.setRowType(com.sap.trex.client.RowType.ROWTYPE_ATTRIBUTE);
    aReq.addQueryEntry(aQE);

    aReq.setTo(10);
    anIndexService.searchTable(aReq, aRes);

    System.out.println("SearchTable:");
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }

    Assert.assertEquals(0, aRes.getError().getCode());
    //Assert.assertEquals(1, aRes.getNoOfAllHits());
    Assert.assertEquals(2, aRes.getIndexSize());    

    ResultTable aResTable = new ResultTable ();
    aResTable = aRes.getTable();

    System.out.println(">No of columns:" + String.valueOf(aRes.getTable().countColumns()));
    System.out.println(">No of rows:" + String.valueOf(aRes.getTable().countRows()));

    for (int i=0;aResTable.nextRow();i++)
    {     
      System.out.println("Row " + String.valueOf(i));
      for (int j=0;aResTable.nextColumn();j++)
      {  
        //String type  = String.valueOf(aResTable.getType());     	  
        String value = String.valueOf(aResTable.getValue());    	  

        System.out.println("Attribute: " + aRes.getAttributes().get(j).getName() + ", Value: " + value);

        if (aRes.getAttributes().get(j).getName().equals(attr_string)) 
          Assert.assertEquals(String.valueOf(check_string),value);
        if (aRes.getAttributes().get(j).getName().equals(attr_alphanum)) 
          Assert.assertEquals(String.valueOf(check_alphanum),value);
        if (aRes.getAttributes().get(j).getName().equals(attr_fixedstring)) 
          Assert.assertEquals(String.valueOf(check_fixedstring),value);
        if (aRes.getAttributes().get(j).getName().equals(attr_text)) 
          Assert.assertEquals(String.valueOf(check_text),value);
        if (aRes.getAttributes().get(j).getName().equals(attr_date)) 
          Assert.assertEquals(String.valueOf(check_date),value);        
        if (aRes.getAttributes().get(j).getName().equals(attr_time)) 
          Assert.assertEquals(String.valueOf(check_time),value);
        if (aRes.getAttributes().get(j).getName().equals(attr_time)) 
          Assert.assertEquals(String.valueOf(check_time),value);
        if (aRes.getAttributes().get(j).getName().equals(attr_int)) 
          Assert.assertEquals(String.valueOf(check_int),value);        
        if (aRes.getAttributes().get(j).getName().equals(attr_float)) 
          Assert.assertEquals(String.valueOf(check_float),value); 
        if (aRes.getAttributes().get(j).getName().equals(attr_double)) 
          Assert.assertEquals(String.valueOf(check_double),value); 
        if (aRes.getAttributes().get(j).getName().equals(attr_fixed)) 
          Assert.assertEquals(String.valueOf(check_fixed),value); 
        if (aRes.getAttributes().get(j).getName().equals(attr_decfloat)) 
          Assert.assertEquals(String.valueOf(check_decfloat),value);
        if (aRes.getAttributes().get(j).getName().equals(attr_unitdecfloat)) 
          Assert.assertEquals(String.valueOf(check_unitdecfloat),value);         

      } 
    } 
  }


  public void listIndexes() throws Exception
  {
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    ListIndex_Request aReq = new ListIndex_Request();
    ListIndex_Result aRes  = new ListIndex_Result();
    aReq.setType(com.sap.trex.client.IndexType.INDEXTYPE_OLAP);
    anIndexService.listIndexes(aReq, aRes);

    System.out.println("ListIndexes:");
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }	

    Assert.assertEquals(0, aRes.getError().getCode());
    for (int i = 0; i < aRes.getIndexes().size();i++) {   
      System.out.println(">" + aRes.getIndexes().get(i).getName() + ", type: " + aRes.getIndexes().get(i).getType());
      if (i > 10) {
        System.out.println(">...");
        break;
      }
    }	
  }

  public void showIndex() throws Exception
  {
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    ShowIndex_Request aReq = new ShowIndex_Request();
    ShowIndex_Result  aRes = new ShowIndex_Result();

    aReq.setIndexName(new IndexName(docIndexId,""));

    anIndexService.showIndex(aReq, aRes);

    System.out.println("ShowIndex:");	
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }	

    Assert.assertEquals(0, aRes.getError().getCode());

    System.out.println(">DateCreated:" + aRes.getDateCreated());
    System.out.println(">DateModified:" +aRes.getDateModified());

    int counter = 0;
    ArrayList<AttributeDefinition> attrdefs = aRes.getAttributes();
    for (int i=0;i<attrdefs.size();i++) {   
      //System.out.println(" >Attribute: " + attrdefs.get(i).getName() + ", type: " + attrdefs.get(i).getType());
      if (attrdefs.get(i).getName().equals(attr_string)) {
        counter++;
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_STRING, attrdefs.get(i).getType());
      }
      if (attrdefs.get(i).getName().equals(attr_alphanum)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_ALPHANUM, attrdefs.get(i).getType());
      }
      if (attrdefs.get(i).getName().equals(attr_fixedstring)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_FIXEDSTRING, attrdefs.get(i).getType());
      }
      if (attrdefs.get(i).getName().equals(attr_text)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_TEXT, attrdefs.get(i).getType());
      }
      if (attrdefs.get(i).getName().equals(attr_textae)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_TEXTAE, attrdefs.get(i).getType());
      }
      if (attrdefs.get(i).getName().equals(attr_date)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_DATE, attrdefs.get(i).getType());
      }
      if (attrdefs.get(i).getName().equals(attr_time)) {
        counter++;
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_TIME, attrdefs.get(i).getType());
      }
      if (attrdefs.get(i).getName().equals(attr_int)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_INT, attrdefs.get(i).getType());
      }      
      if (attrdefs.get(i).getName().equals(attr_float)) {
        counter++;    	
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_FLOAT, attrdefs.get(i).getType());
      } 
      if (attrdefs.get(i).getName().equals(attr_double)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_DOUBLE, attrdefs.get(i).getType());
      }       
      if (attrdefs.get(i).getName().equals(attr_fixed)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_FIXED, attrdefs.get(i).getType());
      }
      if (attrdefs.get(i).getName().equals(attr_decfloat)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_DECFLOAT, attrdefs.get(i).getType());
      }   
      if (attrdefs.get(i).getName().equals(attr_unitdecfloat)) {
        counter++;    	  
        Assert.assertEquals(AttributeType.ATTRIBUTETYPE_UNITDECFLOAT, attrdefs.get(i).getType());
      }      
    }
    Assert.assertEquals(13,counter); 	
  }  

  public void showJoinIndex() throws Exception
  {
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    ShowJoinIndex_Request aReq = new ShowJoinIndex_Request();
    ShowJoinIndex_Result  aRes = new ShowJoinIndex_Result();

    aReq.setIndexName(new IndexName(olapIndexId2,""));

    anIndexService.showJoinIndex(aReq, aRes);

    System.out.println("ShowJoinIndex:");	
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }	

    Assert.assertEquals(0, aRes.getError().getCode());

    System.out.println(">DateCreated:" + aRes.getDateCreated());
    System.out.println(">DateModified:" +aRes.getDateModified());

    int found = 0;
    int counter = 0;
    ArrayList<KeyFigure> keyfigures = aRes.getKeyFigures();
    for (int  i=0;i<keyfigures.size();i++) {
      counter++;
      if (keyfigures.get(i).getName().equals("vc_count")) {
        Assert.assertEquals("Transaktionszähler", keyfigures.get(i).getDescription());
        found = 1;
      }
      //System.out.println(">KeyFigure: " + keyfigures.get(i).getName() + ", description: " + keyfigures.get(i).getDescription());
    }
    //should be 7 key figures
    Assert.assertEquals(7, counter);    
    Assert.assertEquals(1, found); 

    found = 0;
    counter = 0;
    ArrayList<ViewAttribute> vattrs = aRes.getViewAttributes();
    for (int  i=0;i<vattrs.size();i++) {
      counter++;
      if (vattrs.get(i).getName().equals("0currency_chavl")) {
        Assert.assertEquals("Währung(Key)", vattrs.get(i).getDescription());
        found = 1;
      }   
      //System.out.println(">ViewAttribute: " + vattrs.get(i).getName() + ", description: " + vattrs.get(i).getDescription());
    }
    //should be 59 view attributes
    Assert.assertEquals(59, counter);  
    Assert.assertEquals(1, found); 

    counter = 0;
    ArrayList<String> constraints = aRes.getConstraints();
    for (int  i=0;i<constraints.size();i++) {
      counter++;
      System.out.println(">Constraint: " + constraints.get(i));
    }
    //should be 2 constraints
    Assert.assertEquals(2, counter);      

  }

  public void showJoinIndex2() throws Exception
  {
    /* test of view attribute groups */

    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    ShowJoinIndex_Request aReq = new ShowJoinIndex_Request();
    ShowJoinIndex_Result  aRes = new ShowJoinIndex_Result();

    aReq.setIndexName(new IndexName(olapIndexId3,""));

    anIndexService.showJoinIndex(aReq, aRes);

    System.out.println("ShowJoinIndex:"); 
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    } 

    Assert.assertEquals(0, aRes.getError().getCode());

    System.out.println(">DateCreated:" + aRes.getDateCreated());
    System.out.println(">DateModified:" +aRes.getDateModified());

    int counter = 0;
    ArrayList<ViewAttributeGroup> viewAttributeGroups = aRes.getViewAttributeGroups();
    for (int  i=0;i<viewAttributeGroups.size();i++) {
      counter++;
      System.out.println(">ViewAttributeGroups: " + viewAttributeGroups.get(i).getName() + ", description: " + viewAttributeGroups.get(i).getDescription());
    }
    //should be 1 view attribute group
    Assert.assertEquals(1, counter);    

  }


  public void searchOlap() throws Exception
  {	
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    OlapSearch_Request aReq = new OlapSearch_Request();
    OlapSearch_Result aRes  = new OlapSearch_Result();

    aReq.addIndexName(new IndexName(olapIndexId,""));

    aReq.setTo(2);

    aReq.addKeyFigure(new KeyFigure("VC_TURN",AggregationType.AGGREGATIONTYPE_SUM));
    aReq.addKeyFigure(new KeyFigure("0ROWCOUNT",AggregationType.AGGREGATIONTYPE_COUNT));

    aReq.addRequestedAttribute(new RequestedAttribute("0vc_prod1__0vc_grou_text"));
    aReq.addRequestedAttribute(new RequestedAttribute("0vc_sell1__0vc_home_text"));
    aReq.addRequestedAttribute(new RequestedAttribute("0vc_sell1__0vc_home_chavl"));
    aReq.addRequestedAttribute(new RequestedAttribute("0vc_prod1__0vc_mat_text"));

    aReq.addSortAttribute(new SortAttribute("0vc_prod1__0vc_mat_text"));

    QueryEntry aQE = new QueryEntry();   
    aQE.setAttribute("0vc_prod1__0vc_grou_text");    
    aQE.addValue("Küche*");
    aQE.setOperator(com.sap.trex.client.Operator.OPERATOR_EQ);
    aQE.setRowType(com.sap.trex.client.RowType.ROWTYPE_ATTRIBUTE);
    aReq.addQueryEntry(aQE);
    
    aQE = new QueryEntry();   
    aQE.setAttribute("0vc_sell1__0vc_home_chavl");    
    aQE.addValue("CALW");
    aQE.setOperator(com.sap.trex.client.Operator.OPERATOR_EQ);
    aQE.setRowType(com.sap.trex.client.RowType.ROWTYPE_ATTRIBUTE);
    aReq.addQueryEntry(aQE);
    
    aQE = new QueryEntry();   
    aQE.addValue("AND");
    aQE.setOperator(com.sap.trex.client.Operator.OPERATOR_EQ);
    aQE.setRowType(com.sap.trex.client.RowType.ROWTYPE_OPERATORAND);
    aReq.addQueryEntry(aQE);    
    
    aReq.addPlaceHolder(new PlaceHolder("key1", "value1"));
    aReq.addPlaceHolder(new PlaceHolder("key2", "value2"));
    anIndexService.olapSearch(aReq, aRes);

    System.out.println("OlapSearch:");
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }	
    Assert.assertEquals(0, aRes.getError().getCode());   

    ResultTable aResTable = new ResultTable();
    aResTable = aRes.getTable();
    System.out.println(String.valueOf(aResTable.countColumns()) + " x " + String.valueOf(aResTable.countRows()) + " result table");

    //print attribute name
    System.out.print("specs: (");
    for (int i=0;i<aRes.getAttributes().size()-1;i++) {
      System.out.print(aRes.getAttributes().get(i).getName() + ", ");
    }
    System.out.println(aRes.getAttributes().get(aRes.getAttributes().size()-1).getName() + ")");

    String tmp1 = null;
    String tmp2 = null;
    String tmp3 = null;

    //print whole table
    for (int i=0;aResTable.nextRow(); i++)
    {      

      System.out.print("row " + String.valueOf(i) + ": (");
      if (aResTable.nextColumn()) {
        tmp1 = String.valueOf(aResTable.getValue());
        System.out.print("'"+tmp1+"'");
      }
      for (int j = 1; aResTable.nextColumn();j++) {
        if (j==1) {
          tmp3 = String.valueOf(aResTable.getValue());
          System.out.print(", '" + tmp3 + "'");     	  
        } else if (j==4) {
          tmp2 = String.valueOf(aResTable.getValue());
          System.out.print(", '" + tmp2 + "'");    	   
        } else {
          System.out.print(", '" + aResTable.getValue() + "'"); 
        }

      } 
      System.out.println(")");

      //check result
      if (i==0){
        Assert.assertEquals("Küche und Bad", tmp1);  
        Assert.assertEquals("42.07", tmp2);  
        Assert.assertEquals("Buche", tmp3);     	
      } else if (i==1) {
        Assert.assertEquals("Küche und Bad", tmp1);  
        Assert.assertEquals("35.14", tmp2); 
        Assert.assertEquals("Eisen", tmp3);     	
      } else if (i==2) {
        Assert.assertEquals("Küche und Bad", tmp1);  
        Assert.assertEquals("52.01", tmp2); 
        Assert.assertEquals("Spanplatte", tmp3);         
      } else {
        Assert.assertEquals(-1, i);//only 3 lines are expected
      }

    }    
  }


  public void guidedNavigation() throws Exception   {
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    OlapGuidedNavSearch_Request aReq = new OlapGuidedNavSearch_Request();
    OlapGuidedNavSearch_Result aRes  = new OlapGuidedNavSearch_Result();

    aReq.addIndexName(new IndexName(olapIndexId, ""));

    aReq.setTo(10);
    aReq.setGnavNumBestAttributes(4);

    aReq.addKeyFigure(new KeyFigure("VC_TURN",AggregationType.AGGREGATIONTYPE_SUM));
    aReq.addKeyFigure(new KeyFigure("0ROWCOUNT",AggregationType.AGGREGATIONTYPE_COUNT));

    aReq.addRequestedAttribute(new RequestedAttribute("0vc_prod1__0vc_grou_text"));
    aReq.addRequestedAttribute(new RequestedAttribute("0vc_sell1__0vc_home_text"));
    aReq.addRequestedAttribute(new RequestedAttribute("0vc_sell1__0vc_home_chavl"));
    aReq.addRequestedAttribute(new RequestedAttribute("0vc_prod1__0vc_mat_text"));
    aReq.addSortAttribute(new SortAttribute("vc_turn",com.sap.trex.client.SortOrder.SORTORDER_DESCENDING));
    
    QueryEntry aQE = new QueryEntry();
    aQE.setAttribute("0vc_prod1__0vc_mat_text");
    aQE.addValue("Zeder");     
    aReq.addQueryEntry(aQE);
    aReq.setGnavNumBestAttributes(10);
    anIndexService.olapGuidedNavSearch(aReq, aRes);

    System.out.println("OlapGuidedNavSearch:");
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }   

    Assert.assertEquals(0, aRes.getError().getCode());   

    ResultTable aResTable = new ResultTable();
    aResTable = aRes.getTable();

    System.out.println(String.valueOf(aResTable.countColumns()) + " x " + String.valueOf(aResTable.countRows()) + " result table");

    //print attribute name
    System.out.print("specs: (");
    for (int i=0;i<aRes.getAttributes().size()-1;i++) {
      System.out.print(aRes.getAttributes().get(i).getName() + ", ");
    }
    System.out.println(aRes.getAttributes().get(aRes.getAttributes().size()-1).getName() + ")");

    String tmp1 = null;
    String tmp2 = null;
    String tmp3 = null;

    //print whole table
    for (int i=0;aResTable.nextRow(); i++)
    {      

      System.out.print("row " + String.valueOf(i) + ": (");
      if (aResTable.nextColumn()) {
        tmp1 = String.valueOf(aResTable.getValue());
        System.out.print("'"+tmp1+"'");
      }
      for (int j = 1; aResTable.nextColumn();j++) {
        if (j==3) {  //values = 64
          tmp2 = String.valueOf(aResTable.getValue());
          System.out.print(", '" + tmp2 + "'"); 
        } else if (j==7) { //0vc_sell1__0vc_home_text = Weida
          tmp3 = String.valueOf(aResTable.getValue());
          System.out.print(", '" + tmp3 + "'");        	  
        } else {
          System.out.print(", '" + aResTable.getValue() + "'");
        }
      } 
      System.out.println(")");

/*      
      OlapGuidedNavSearch:
        16 x 10 result table
        specs: (attribute, discrimination, instances, values, 0vc_sell1__0vc_home_chavl, vc_turn_0, 0rowcount_0, 0vc_sell1__0vc_home_text, vc_turn_1, 0rowcount_1, 0vc_prod1__0vc_grou_text, vc_turn_2, 0rowcount_2, 0vc_prod1__0vc_mat_text, vc_turn_3, 0rowcount_3)
        row 0: ('0vc_sell1__0vc_home_chavl', '0.05560662', '306', '64', 'WEIDA', '820.14', '26', 'Weida', '820.14', '26', 'Garten', '2537.85', '96', 'Zeder', '8167.17', '306')
        row 1: ('0vc_sell1__0vc_home_text', '0.05560662', '306', '64', 'GAEPPINGEN', '293.72', '10', 'GAEPPINGEN', '293.72', '10', 'Küche und Bad', '2103.36', '80', 'null', 'null', 'null')
        row 2: ('0vc_prod1__0vc_grou_text', '0.828', '306', '4', 'BUCHEN', '274.10', '12', 'Buchen', '274.10', '12', 'Assessoirs', '1866.25', '76', 'null', 'null', 'null')
        row 3: ('0vc_prod1__0vc_mat_text', '0.0', '306', '1', 'MUENCHEN', '272.77', '8', 'Muenchen', '272.77', '8', 'Lebensmittel', '1659.71', '54', 'null', 'null', 'null')
        row 4: ('null', 'null', 'null', 'null', 'JENA', '268.96', '10', 'Jena', '268.96', '10', 'null', 'null', 'null', 'null', 'null', 'null')
        row 5: ('null', 'null', 'null', 'null', 'TITISEE', '220.19', '8', 'Titisee', '220.19', '8', 'null', 'null', 'null', 'null', 'null', 'null')
        row 6: ('null', 'null', 'null', 'null', 'LUDWIGSHAFEN', '208.33', '6', 'Ludwigshafen', '208.33', '6', 'null', 'null', 'null', 'null', 'null', 'null')
        row 7: ('null', 'null', 'null', 'null', 'FRIEDRICHSHAFEN', '205.46', '6', 'Friedrichshafen', '205.46', '6', 'null', 'null', 'null', 'null', 'null', 'null')
        row 8: ('null', 'null', 'null', 'null', 'INGOLSTADT', '202.75', '6', 'Ingolstadt', '202.75', '6', 'null', 'null', 'null', 'null', 'null', 'null')
        row 9: ('null', 'null', 'null', 'null', 'LUDWIGSBURG', '201.76', '6', 'Ludwigsburg', '201.76', '6', 'null', 'null', 'null', 'null', 'null', 'null')
*/
      if (i==0){
        Assert.assertEquals("0vc_sell1__0vc_home_chavl", tmp1);  
        Assert.assertEquals("64", tmp2);  
        Assert.assertEquals("Weida", tmp3);     	
      } else if (i==1) {
        Assert.assertEquals("0vc_sell1__0vc_home_text", tmp1);  
        Assert.assertEquals("64", tmp2); 
        Assert.assertEquals("GAEPPINGEN", tmp3);     	
      } else if (i==2){
        Assert.assertEquals("0vc_prod1__0vc_grou_text", tmp1); 
        Assert.assertEquals("4", tmp2);  
        Assert.assertEquals("Buchen", tmp3);          
      } else if (i==3){
        Assert.assertEquals("0vc_prod1__0vc_mat_text", tmp1); 
        Assert.assertEquals("1", tmp2); 
        Assert.assertEquals("Muenchen", tmp3);        	
      } else if (i==4){
        Assert.assertEquals("null", tmp1); 
        Assert.assertEquals("null", tmp2);         
        Assert.assertEquals("Jena", tmp3);              
      } 
 
    } 
  }  

  public void importIndexes() throws Exception {
    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    PythonCall_Request aReq; 
    PythonCall_Result aRes;
    int    oldErrorCode = 0;
    String oldErrorMsg  = null;

    aReq  = new PythonCall_Request();    
    aRes  = new PythonCall_Result();
    aReq.setObjectName("importManager.!");
    aReq.addParameter("--importPath="+IMPORT_PATH_WINDOWS);    	
    //aReq.addParameter("--force=1"); 
    aReq.addParameter("--indexId="+olapIndexId);    
    aReq.addParameter("--indexId="+olapIndexId2);  
    aReq.addParameter("--indexId="+olapIndexId3);  
    
    anIndexService.pythonCall(aReq, aRes);

    if ( aRes.getError().getCode() > 0 ) {
      oldErrorCode = aRes.getError().getCode();
      oldErrorMsg  = aRes.getError().getMsg();

      aReq = new PythonCall_Request();
      aRes = new PythonCall_Result();

      aReq.setObjectName("importManager.!");
      aReq.addParameter("--importPath="+IMPORT_PATH_LINUX);
      //aReq.addParameter("--force=1"); 
      aReq.addParameter("--indexId="+olapIndexId);   
      aReq.addParameter("--indexId="+olapIndexId2);  
      aReq.addParameter("--indexId="+olapIndexId3);       

      anIndexService.pythonCall(aReq, aRes);
    }    

    if ( aRes.getError().getCode() > 0 ) {
      System.out.println("importIndexes:");    	
      System.out.println(">Error Code 1:" + oldErrorCode);
      System.out.println(">Error Text 1:" + oldErrorMsg);
      System.out.println(">Error Code 2:" + aRes.getError().getCode());
      System.out.println(">Error Text 2:" + aRes.getError().getMsg());      
    }   

    Assert.assertEquals(0, aRes.getError().getCode());     
  }

  public  void showIndexInfo() throws Exception {
    String queryString = "IndexInfo+Index=*!+indexFlags=1";
    int    found = 0;

    Connection aCon  = new Connection(URL);    
    IndexService anIndexService = new IndexService(aCon);
    ShowIndexInfo_Request aReq = new ShowIndexInfo_Request();
    ShowIndexInfo_Result  aRes = new ShowIndexInfo_Result();
    aReq.setQuery(queryString);

    anIndexService.showIndexInfo(aReq, aRes);

    System.out.println("ShowIndexInfo:");
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }      
    Assert.assertEquals(0, aRes.getError().getCode());   

    for (TreeNode tn : aRes.getNodes()) {
      System.out.println(">Level, name, value: "+ tn.getLevel() + " " + tn.getName() + " " + tn.getValue());
      if (tn.getName().equals("Index") && tn.getValue().equals(olapIndexId2)) {
        found = 1;
      }
    }

    /* olap index must be contained in the list */
    Assert.assertEquals(1, found);     
  }  


  public void searchTableWithScript() throws Exception {

    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    SearchTable_Request aReq = new SearchTable_Request();
    SearchTable_Result aRes = new SearchTable_Result();

    String queryEntryString = "";
    String groupByString    = "";
    String keyFigureString  = "";
    String searchString     = "";
    String placeHolderString= "";
    String user             = "JANNINGD"; //-> read from central config, once working

    //olapIndexId2 = "y1q_0bwvc_035_ps"; 

    //queryEntryString = "0vc_prod1__0vc_mat_text" + ",EQ," + "Zeder" + "";
    queryEntryString = "0requid_sid,LE,2000000000";

    groupByString     = "0calyear_chavl" + "," + "0vc_prod1__0vc_mat_text";
    keyFigureString   = "vc_count,1" + ";" + "vc_turn,1";
    searchString      = "2008 Zeder";
    placeHolderString = "user," + user;

    aReq.setScriptName("ps_gnav_highlight.searchGN");
    
    aReq.addScriptParameter(olapIndexId2);
    aReq.addScriptParameter(queryEntryString);
    aReq.addScriptParameter(groupByString);
    aReq.addScriptParameter(keyFigureString);
    aReq.addScriptParameter(new Integer(10).toString());
    aReq.addScriptParameter("0");
    aReq.addScriptParameter(searchString);
    aReq.addScriptParameter("300");
    aReq.addScriptParameter("1"); 
    aReq.addScriptParameter(placeHolderString);    
    aReq.addScriptParameter("");   
    
    anIndexService.searchTable(aReq, aRes);

    System.out.println("SearchTableWithScript:");
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }      
    Assert.assertEquals(0, aRes.getError().getCode()); 
   
    ResultTable aResTable = new ResultTable();
    aResTable = aRes.getTable();
    System.out.println(String.valueOf(aResTable.countColumns()) + " x " + String.valueOf(aResTable.countRows()) + " result table");

    //print attribute name
    System.out.print("specs: (");
    for (int i=0;i<aRes.getAttributes().size()-1;i++) {
      System.out.print(aRes.getAttributes().get(i).getName() + ", ");
    }
    System.out.println(aRes.getAttributes().get(aRes.getAttributes().size()-1).getName() + ")");

    String tmp0 = null;
    String tmp4 = null;
    String tmp5 = null;

    //print whole table
    for (int i=0;aResTable.nextRow(); i++)
    {      
      System.out.print("row " + String.valueOf(i) + ": (");

      for (int j = 0; aResTable.nextColumn();j++) {
        if (j==0) {
          tmp0 = String.valueOf(aResTable.getValue());
          System.out.print("'"+tmp0+"'");          
        } else if (j==4) {
          tmp4 = String.valueOf(aResTable.getValue());
          System.out.print(", '" + tmp4 + "'");         
        } else if (j==5) {
          tmp5 = String.valueOf(aResTable.getValue());
          System.out.print(", '" + tmp5 + "'");        
        } else {
          System.out.print(", '" + aResTable.getValue() + "'"); 
        }

      } 
      System.out.println(")");
  
      //check result
      if (i==0){
        Assert.assertEquals("0calyear_chavl", tmp0);  
        Assert.assertEquals("2009", tmp4);  
        Assert.assertEquals("3674", tmp5);       
      } else if (i==1) {
        Assert.assertEquals("0vc_prod1__0vc_mat_text", tmp0);  
        Assert.assertEquals("2008", tmp4); 
        Assert.assertEquals("3806", tmp5);      
      } else if (i==2) {
        Assert.assertEquals("null", tmp0);  
        Assert.assertEquals("2010", tmp4); 
        Assert.assertEquals("3357", tmp5);        
      } else {
        Assert.assertEquals(-1, i);
      }    
    }
  }
  
  public void searchTableWithScript2() throws Exception {

    Connection aCon  = new Connection(URL);
    IndexService anIndexService = new IndexService(aCon);
    SearchTable_Request aReq = new SearchTable_Request();
    SearchTable_Result aRes = new SearchTable_Result();

    String queryEntryString = "";
    String groupByString    = "";
    String keyFigureString  = "";
    String searchString     = "";
    String placeHolderString= "";
    String user             = "JANNINGD"; //-> read from central config, once working

    //olapIndexId = "br9_0bwvc_001_ps"; 

    queryEntryString = "0calyear_chavl" + ",EQ," + "200*" + "";
    groupByString     = "0vc_prod1__0vc_grou_text";
    keyFigureString   = "vc_count,1" + ";" + "vc_turn,1";
    searchString      = "Küche";
    placeHolderString = "user," + user;

    aReq.setScriptName("ps_gnav_highlight.searchGN");
    
    aReq.addScriptParameter(olapIndexId);
    aReq.addScriptParameter(queryEntryString);
    aReq.addScriptParameter(groupByString);
    aReq.addScriptParameter(keyFigureString);
    aReq.addScriptParameter(new Integer(10).toString());
    aReq.addScriptParameter("0");
    aReq.addScriptParameter(searchString);
    aReq.addScriptParameter("300");
    aReq.addScriptParameter("1"); 
    aReq.addScriptParameter(placeHolderString);    
    aReq.addScriptParameter("");       
   
    anIndexService.searchTable(aReq, aRes);

    System.out.println("SearchTableWithScript:");
    if ( aRes.getError().getCode() > 0 ) {
      System.out.println(">Error Code:" + aRes.getError().getCode());
      System.out.println(">Error Text:" + aRes.getError().getMsg());
    }      
    Assert.assertEquals(0, aRes.getError().getCode()); 
   
    ResultTable aResTable = new ResultTable();
    aResTable = aRes.getTable();
    System.out.println(String.valueOf(aResTable.countColumns()) + " x " + String.valueOf(aResTable.countRows()) + " result table");

    //print attribute name
    System.out.print("specs: (");
    for (int i=0;i<aRes.getAttributes().size()-1;i++) {
      System.out.print(aRes.getAttributes().get(i).getName() + ", ");
    }
    System.out.println(aRes.getAttributes().get(aRes.getAttributes().size()-1).getName() + ")");

    String tmp4 = null;
    String tmp6 = null;

    //print whole table
    for (int i=0;aResTable.nextRow(); i++)
    {      
      System.out.print("row " + String.valueOf(i) + ": (");

      for (int j = 0; aResTable.nextColumn();j++) {
        if (j==4) {
          tmp4 = String.valueOf(aResTable.getValue());
          System.out.print(", '" + tmp4 + "'");         
        } else if (j==6) {
          tmp6 = String.valueOf(aResTable.getValue());
          System.out.print(", '" + tmp6 + "'");        
        } else {
          System.out.print(", '" + aResTable.getValue() + "'"); 
        }

      } 
      System.out.println(")");

      //check result
      if (i==0){
        Assert.assertEquals("Küche und Bad", tmp4);  
        Assert.assertEquals("25069.220", tmp6);       
      } else if (i==1) {
        Assert.assertEquals("Garten", tmp4);  
        Assert.assertEquals("28414.650", tmp6);      
      } else if (i==2) {
        Assert.assertEquals("Assessoirs", tmp4);  
        Assert.assertEquals("26153.440", tmp6);       
      } else if (i==3) {
        Assert.assertEquals("Möbel (innen)", tmp4);  
        Assert.assertEquals("14799.070", tmp6);  
      } else if (i==4) {
        Assert.assertEquals("Lebensmittel", tmp4);  
        Assert.assertEquals("14502.870", tmp6); 
      } else {
        Assert.assertEquals(-1, i);
      }    

    }
  } 
}


