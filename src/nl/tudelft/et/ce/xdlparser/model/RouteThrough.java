/*
 * RouteThrough.java
 * A RouteThrough is a connection like a Pip, but is goes through a slice. it
 * basically refers to an Instance and two Pins.
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

public class RouteThrough extends Node 
{
	private Instance instance;
	private Pin leftPin;
	private EPipDirection direction;
	private Pin rightPin;
	
	
	// constructor
	public RouteThrough(Instance pInstance, Pin pLeftPin, Pin pRightPin, 
				EPipDirection pDirection)
	{
		this.instance = pInstance;
		this.leftPin = pLeftPin;
		this.rightPin = pRightPin;
		this.direction = pDirection;
	}
	
	// getters
	public Instance getInstance()
	{
		return this.instance;
	}
	
	public Pin getLeftPin()
	{
		return this.leftPin;		
	}
	
	public Pin getRightPin()
	{
		return this.rightPin;
	}
	
	public EPipDirection getDirection()
	{
		return this.direction;
	}
}
