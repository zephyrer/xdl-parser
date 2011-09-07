/*
 * Pin.java
 * A Pin is an end-point to a Net. It connects to a specific instance from the
 * instance section of the XDL file.
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

public class Pin extends Node 
{
//	private String inst_name;
    private Instance instance;
	private String inst_pin;
	
	// constructor
	public Pin(Instance pInstance, String pInstPin)
	{
		this.instance = pInstance;
		this.inst_pin = pInstPin;
	}
	
	public String getInstName()
	{
		return this.instance.getName();
	}
	
	public String getInstPin()
	{
		return this.inst_pin;
	}

    /**
     * @return
     */
    public boolean isClockPin()
    {
        // this is certainly a clock pin if it contains CLK in 
        // the signal name or pin        
        return (inst_pin.contains("CLK") || 
                getInstName().contains("CLK") ||
                inst_pin.contains("ODIV4") );
    }

    /**
     * @return
     */
    public boolean isAtIOB()
    {
        // this is at an IOB if the instance name is an IOB
        if(instance == null) return false;

        return instance.isIOB();
    }
}
