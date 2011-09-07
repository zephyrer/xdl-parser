/*
 * EPipDirection.java
 * An enumeration of the different directions a PIP can have. buffered, or
 * unbuffered, uni- or bi-directional.
 *
 * Copyright (C) 2009, 2011
 * - R. J. Meeuws <r.j.meeuws@gmail.com>
 * - ...
 * 
 * Notice
 * -----------
 * The XDL Parser is free software.  See the files whose names start with
 * COPYING for copying permission.  The manuals, and some of the runtime
 * libraries, are under different terms; see the individual source files for
 * details.
 */
package nl.tudelft.et.ce.xdlparser.model;

public enum EPipDirection {
	BIDIR_UNBUF, BIDIR_ONEBUF, BIDIR_BUF, DIR_BUF
}
