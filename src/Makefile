all: Compiler C3aVM NasmVM SaVM

SaVM: SaVM.java saParser
	javac SaVM.java

NasmVM.jar : NasmVM
	jar cmf NasmVM.mf NasmVM.jar NasmVM.class nasm

C3aVM: C3aVM.java c3aParser
	javac C3aVM.java

NasmVM: NasmVM.java nasmParser
	javac NasmVM.java

Compiler.jar : Compiler
	jar cmf Compiler.mf Compiler.jar *.class sc sa ts nasm util c3a fg ig lParser

Compiler: Compiler.java lParser
	javac Compiler.java

# lParser: l.cfg
# 	java -jar ../sablecc/sablecc.jar l.cfg

saParser: sa.cfg
	java -jar ../sablecc/sablecc.jar sa.cfg

c3aParser: c3a.cfg
	java -jar ../sablecc/sablecc.jar c3a.cfg

nasmParser: nasm.cfg
	java -jar ../sablecc/sablecc.jar nasm.cfg

ualParser: ual.cfg
	java -jar ../sablecc/sablecc.jar ual.cfg

clean:
	-rm *.class
	-rm sc/*.class
	-rm sa/*.class
	-rm c3a/*.class
	-rm ts/*.class
	-rm nasm/*.class
	-rm fg/*.class
	-rm ig/*.class
	-rm util/intset/*.class
	-rm util/graph/*.class
	-rm util/*.class
	-rm -r saParser
	-rm -r c3aParser
	-rm -r nasmParser

