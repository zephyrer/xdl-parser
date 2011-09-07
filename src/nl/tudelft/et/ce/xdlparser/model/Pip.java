/*
 * Pip.java
 * A Pip is an intermediate point of a Net. It connects different wire segments
 * together.
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

public class Pip extends Node 
{
	private Tile tile;
	private Wire leftWire;
	private EPipDirection direction;
	private Wire rightWire;
	
	
	// constructor
	public Pip(Tile pTile, Wire pLeftWire, Wire pRightWire, 
				EPipDirection pDirection)
	{
		this.tile = pTile;
		this.leftWire = pLeftWire;
		this.rightWire = pRightWire;
		this.direction = pDirection;
	}
	
	// getters
	public Tile getTile()
	{
		return this.tile;
	}
	
	public Wire getLeftWire()
	{
		return this.leftWire;		
	}
	
	public Wire getRightWire()
	{
		return this.rightWire;
	}
	
	public EPipDirection getDirection()
	{
		return this.direction;
	}
}
