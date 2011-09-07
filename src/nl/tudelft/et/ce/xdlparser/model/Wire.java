/*
 * Wire.java
 * A Wire stands for the actual wire segments that comprise a net. they can be
 * connected through Pips and Pins.
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

public class Wire {

	private String name;
	
	public Wire(String pName)
	{
		this.name = pName;
	}
	
	public String getName()
	{
		return this.name;
	}
}
