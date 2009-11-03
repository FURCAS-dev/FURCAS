@echo on

IF NOT .%JAVA_HOME%==. GOTO JdkFound
ECHO Could not find a JDK.
ECHO Either you have to install a JDK (preferrably 1.4) or you have to set JAVA_HOME to your JDK installation directory.
PAUSE
GOTO :EndOfScript

:JdkFound

set JAVACMD=%JAVA_HOME%\bin\java
ECHO Java command is '%JAVACMD%'.

set CLASSPATH=JFlex.jar;CUP.jar
ECHO Classpath is '%CLASSPATH%'.

ECHO Make QVT lexer ... (jflex-1.4.1)
%JAVACMD% -cp "%CLASSPATH%" JFlex.Main ocl.flex
ECHO

ECHO Make QVT parser ... (CUP 11a beta)
%JAVACMD% -jar CUP.jar -nonterms -package de.ikv.medini.qvt.syntax.parser -parser Yyparse < qvt.cup
ECHO


PAUSE
:EndOfScript