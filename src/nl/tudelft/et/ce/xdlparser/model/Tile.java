/*
 * Tile.java
 * A Tile is a physical location that an Instance can be assigned to.
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

import java.util.HashMap;
import java.util.Map;

public class Tile {
	
	private String name;
	private Map<String,Wire> wires;
	
	
	// Constructor
	protected Tile(String pName)
	{
		// factory / singleton-like pattern, so no constuctor for public use
		this.name = pName;
		this.wires = new HashMap<String,Wire>();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void addWire(String pName)
	{
	    Wire wire = wires.get(pName);
	    if(wire == null)
	    {
	        wire = new Wire(pName);
	        wires.put(pName, new Wire(pName));
	    }
	}
	
	public Wire getWire(String pName)
	{
	    return wires.get(pName);
	}
}
