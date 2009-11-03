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

ECHO Make OCL lexer ...
%JAVACMD% -cp "%CLASSPATH%" JFlex.Main ocl.flex
ECHO

REM ECHO Make OCL parser ...
%JAVACMD% -jar CUP.jar -nonterms -package org.oslo.ocl20.syntax.parser -parser Yyparse < ocl.cup
REM ECHO


PAUSE
:EndOfScript