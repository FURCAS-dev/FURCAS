This project contains several different test bundles.

These are unit tests, scenario tests, integration tests. 
(Though this classification might not be academically correct)

Unit tests supposedly test single classes or components 
in isolation, these should be runnable independently of 
Eclipse or Moin, and are based on ECore for modeling.
Unit tests are white box tests, they may and must assume
to know the inner implementation of classes in order to get 
high path coverage. Target is for 100% line coverage in the 
complex classes in 
com.sap.mi.textual.grammar.impl.tcs.t2m.grammar
and
com.sap.mi.textual.parsing (Project)

ScenarioTests try Parser Generation and then language parsing,
for several languages and samples. These tests integrate most
of the Core functionality of CoreMonet, but i.e. not MOIN or UI
aspects. Scenariotests are black box tests.

Finally integration tests validate integration with Eclipse 
and MOIN. Since integration tests require Eclipse and Moin,
they can only be run from Eclipse using the Run as...
"JUnit Plug-in Test" command.
For these, Parser generation for example DSLs has to be assumed
to have happened already. To prepare for these tests, DSL specific
Parsers have to be generated before running the tests.
To do this, you may run the scenarioTests as JUnit tests. 
These shall generate <DSLName>Parser.java and <DSLName>Lexer.java
within the ScenariotestTemp directory. Copy these Java files into 
the integrationTestSrc/generated package. 
Also, you'll need the MOIN Metamodel wrapper project for each DSL, else
these tests won't compile anyway, as they refer to the root packages of
the used metamodel as JMI class.
Then you may run the 
integration tests as Plug-in JUnit tests.  