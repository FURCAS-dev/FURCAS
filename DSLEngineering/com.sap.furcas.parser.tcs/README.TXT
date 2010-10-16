This requires the antlr libraries to be present in this project 
and placed in lib. this means
stringtemplate.jar, antlr3.1.1.jar

For bootstrapping, TCS Syntax definition parsers can be build like this:

Bootstrap: create TCS.g grammar using the bootstrap.xml ant task in 
the test project, copy the contents of generated TCS.g grammar file 
into grammars/TCS.g here. (The com.sap.mi.textual.test project defines
classes to create a bootstrapped TCS.g grammar)

run the build.xml in this project. New Java files will be created in 
...grammar.parser, refresh the eclipse project.

No compile errors should occur.

Optionally organize imports in the files, as ANTLR adds unused imports.
Refresh the project in Eclipse.