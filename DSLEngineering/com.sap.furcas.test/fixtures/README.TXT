This folder contains resources required for unit and scenario tests.
It contains Ecore metamodel in the metamodels directory which substitutes
for MOIN metamodels. This directory contains mainly coremonet-TCS files
defining syntaxes for metamodels contained in the metamodels folder, where 
one metamodel may have more than one TCS Syntax (Therefore not all names match).
This folder also contains several "...Target.g" ANTLR grammars, which show what
the original TCS would have done with the given TCS.

Tests cannot compare these target grammars and coreMonet grammars directly, 
because coreMonet may have different ordering, different naming, different 
grammarstyle (i.e. "(x)+" instead of "(x)(x)*") different strategies, and so on.

But it often helps to compare by looking at it.