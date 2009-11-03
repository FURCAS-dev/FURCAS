These files are supposed to work with the com.sap.mi.textual.bootstrap.TCSBootStrap class in the src folder.
That class should create an ANTLR .g grammar file in this directory to be used in the 
com.sap.mi.textual.grammar.parser project for complete bootstrap.

Bootstrapping changes to the TCS syntax can first be tried out experimentally using the class
com.sap.mi.textual.test.scenarios.TCSMoinTest with the syntax definition in scenarioTestResource/TCS.tcs.
This should be done before replacing the parser in com.sap.mi.textual.grammar.parser.


The bootstrap.xml is currently not working.