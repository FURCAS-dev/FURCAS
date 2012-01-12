# FURCAS

FURCAS is language workbench. You can think of it as an IDE that helps you to 
develop your own IDE, for you own language.

FURCAS is based on Eclipse and EMF.

## Why might I be interested in FURCAS?
* You want to build your own domain specific languages and basically get features
  like syntax highlighting, auto completion and simple but safe refactorings for
  free.
* You do already use EMF models in your application, but want to edit your models
  in a textual rather than a graphical syntax.

## So, how does it work?
FURCAS uses a template language to create textual representations of classes of a metamodel.
As this language maps grammar fragments to metamodel classes, it is called _mapping_.

From such a mapping, we derive incremental parsers and pretty printers so that when you
update either your model or your text, the other one will be updated accordingly.

Lets consider your metamodel has a metaclass named `Workflow`. A `Workflow` consists
of several ordered steps, each represented by a `Step` class.

You might have a particular workflow model that consists of three steps. Any you may want
to view and edit it in textual syntax like the following:

    workflow:
       Step1: Do this,
       Step2: Do that,
       Step3: Finish


Corresponding templates in FURCAS to render your workflow models in such a syntax might
look like:

    template Workflow
    :  "workflow" ":" steps{separator=","}
    ; 
    template Step
    :  name ":" description
    ;

That is it. You can feed this to FURCAS and then start to create new models, or modify your existing
ones using this syntax. 

FURCAS automatically looks up types and multiplicities in your metamodel.
You don't have to specify these again.

## Is it any good?
Not yet :-)

## Why not?
We used to have very high ambitions in the light of lacking manpower. If you want to have an impression
of our current status, please have a look [here](http://lists.furcas.org/pipermail/furcas-discussion/2011-July/000369.html).

We contributed a scalable event manager and the _OCL implact analysis_ to Eclipse. The impact
analysis tells you when your OCL expressions should be re-evaluted after model changes.
You can find both it in the _OCL Examples and Editors_ features since the Eclipse Indigo release.


## Links
* [Homepage & Links to Research Papers](http://furcas.org/)
* [Mailinglist](http://www.furcas.org/cgi-bin/mailman/listinfo/furcas-discussion)
* [Wiki & Language Specification](http://furcas.org/wiki)
