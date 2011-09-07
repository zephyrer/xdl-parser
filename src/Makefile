PROGRAM=xdlparser
MAINDIR=nl/tudelft/et/ce/xdlparser
MAINCLASSES=Main.class
MAINDEPS=$(shell echo $(MAINDIR)/$(MAINCLASSES))
MODELDIR=$(MAINDIR)/model
MODELCLASSES=RouteThrough.class,Tile.class,Node.class,Design.class,Net.class,Net$$1.class,Wire.class,PlacedInstance.class,EMeasureType.class,UnplacedInstance.class,Pip.class,EPipDirection.class,ENetType.class,Pin.class,ExternalNet.class,Instance.class,InternalNet.class
MODELDEPS=$(shell echo $(MODELDIR)/{$(MODELCLASSES)})
PARSERDIR=$(MAINDIR)/parser
PARSERCLASSES=XDLParser.class,XDLParserTokenManager.class,TokenMgrError.class,ParseException.class,Token.class,XDLParserConstants.class
PARSERDEPS=$(shell echo $(PARSERDIR)/{$(PARSERCLASSES)})
PARSERSRCS=$(PARSERDEPS:%.class=%.java)

MANIFEST=manifest.mf

JAVAC=javac
JFLAGS=
JAVACC=$(shell pwd)/../reqs/javacc-5.0/bin/javacc
JAR=jar
CJ=gcj
CJFLAGS= -g -Wall -Werror #-O2 -fwhole-program -minline-stringops-dynamically -fno-bounds-check -fno-store-check --disable-assertions

all: $(PROGRAM)

jar: $(PROGRAM).jar


$(PROGRAM): $(PROGRAM).jar
	@echo "Generating native executable"
	@$(CJ) --main=nl.tudelft.et.ce.xdlparser.Main $(CJFLAGS) $< -o $@


$(PROGRAM).jar: $(MANIFEST) $(PARSERDEPS) $(MODELDEPS) $(MAINDEPS)
	@echo "Generating jar file"
	@$(JAR) cfm $@ $(MANIFEST) $(MODELDIR)/*.class $(PARSERDIR)/*.class $(MAINDIR)/Main.class jargs

%.class: %.java
	@echo "Compiling $(shell basename $@)"
	@$(JAVAC) $(JFLAGS) $<


$(PARSERSRCS): $(PARSERDIR)/XDL.jj
	@echo "Generating parser classes"
	@cd $(PARSERDIR) && $(JAVACC) XDL.jj &> /dev/null && cd - > /dev/null

clean:
	@echo "Cleaning project"
	@-rm -rf $(MAINDIR)/*.class $(MODELDIR)/*.class $(PARSERDIR)/*.class $(PROGRAM) $(PROGRAM).jar $(PARSERDIR)/*.java
