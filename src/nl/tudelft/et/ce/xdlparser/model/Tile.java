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
