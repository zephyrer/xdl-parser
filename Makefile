PROGRAM=xdlparser
INSTALLDIR=/home/rmeeuws


all: reqs bin/$(PROGRAM)


install: bin/$(PROGRAM)
	@echo Installing $(PROGRAM)
	@cp bin/$(PROGRAM) $(INSTALLDIR)/bin/$(PROGRAM)

uninstall:
	@echo Uninstalling $(PROGRAM)
	@-rm $(INSTALLDIR)/bin/$(PROGRAM) 2> /dev/null

bin/$(PROGRAM): src/$(PROGRAM)
	@echo Copying $(PROGRAM)
	@cp src/$(PROGRAM) bin/$(PROGRAM)	

src/$(PROGRAM): force_look
	@make -C src

.PHONY: clean

clean:
	@make -C src clean
	@-rm -rf bin/xdlparser

force_look:
	@true
