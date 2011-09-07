/*
 * Design.java
 * A class representing the design contained in the XDL file
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

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author roel
 *
 */
public class Design
{
    private String name;
    private String part;
    private String ncd_version;
    private String cfg;

    private Map<String, Instance> instances;
    private Collection<Net> nets;
	private Map<String,Tile> tiles;
    
    public Design(String pName, String pPart, String pNcdVersion, String pCfg)
    {
        this.name = pName;
        this.part = pPart;
        this.ncd_version = pNcdVersion;
        this.cfg = pCfg;
        
        this.instances = new HashMap<String,Instance>();
        this.nets = new LinkedList<Net>();
        this.tiles = new HashMap<String,Tile>();
    }

    // getters
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getPart()
    {
        return this.part;
    }
    
    public String getNcdVersion()
    {
        return this.ncd_version;
    }
    
    public String getCfg()
    {
        return this.cfg;
    }
    
    // methods for nets
    public void addNet(Net pNet)
    {
        this.nets.add(pNet);
    }
    
    public Iterable<Net> getNets()
    {
        return this.nets;
    }
    
    // methods for instances
    public void addInstance(Instance pInstance)
    {
        this.instances.put(pInstance.getName(),pInstance);
    }
    
    public Iterable<Instance> getInstances()
    {
        return this.instances.values();
    }
    
     
    public int getNumberOfNets()
    {
        return getNumberOfNets(EMeasureType.TOTAL);
    }
    
    public int getNumberOfNets(EMeasureType type)
    {
        if(type == EMeasureType.TOTAL)
            return this.nets.size();

        int count = 0;

        for(Net net: this.nets)
            if(net.isOfMeasureType(type))
                count++;
        
        return count;
    }
    
    public int getNumberOfRouteThroughs()
    {
        return getNumberOfRouteThroughs(EMeasureType.TOTAL);
    }
    
    public int getNumberOfRouteThroughs(EMeasureType type)
    {
        int count = 0;

        for(Net net: this.nets)
            if(net.isOfMeasureType(type))
                count += net.getNumberOfRouteThroughs();
        
        return count;
    }
    public int getNumberOfWires()
    {
        return getNumberOfWires(EMeasureType.TOTAL);
    }
    
    public int getNumberOfWires(EMeasureType type)
    {
        int count = 0;

        for(Net net: this.nets)
            if(net.isOfMeasureType(type))
                count += net.getNumberOfWires();
        
        return count;
    }

    public int getNumberOfPips()
    {
        return getNumberOfPips(EMeasureType.TOTAL);
    }
    
    public int getNumberOfPips(EMeasureType type)
    {
        int count = 0;

        for(Net net: this.nets)
            if(net.isOfMeasureType(type))
                count += net.getNumberOfPips();
        
        return count;
    }
    public int getNumberOfInpins()
    {
        return getNumberOfInpins(EMeasureType.TOTAL);
    }
    
    public int getNumberOfInpins(EMeasureType type)
    {
        int count = 0;

        for(Net net: this.nets)
            if(net.isOfMeasureType(type))
                count += net.getNumberOfInpins();
        
        return count;
    }
    
    public int getNumberOfOutpins()
    {
        return getNumberOfOutpins(EMeasureType.TOTAL);
    }
    
    public int getNumberOfOutpins(EMeasureType type)
    {
        int count = 0;

        for(Net net: this.nets)
            if(net.isInternal() && net.isOfMeasureType(type))
                count++;
        
        return count;
    }
    
    public int getNumberOfTiles()
    {      
        return tiles.size();
    }
    
    public int getNumberOfInstances()
    {
        return this.instances.size();
    }    

    public Instance getInstanceByName(String name)
    {
        return this.instances.get(name);
    }

	public Tile getTile(String pName)
	{
		Tile tile = tiles.get(pName);
		if(tile == null)
		{
			tile = new Tile(pName);
			tiles.put(pName, tile);
		}
		return tile;
	}
}
