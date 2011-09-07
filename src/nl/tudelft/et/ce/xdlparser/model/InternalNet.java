/*
 * InternalNet.java
 * A subclass of a normal Net, an internal net is an actual net inside the
 * design and can be of different types. These nets can be routed and contain
 * actual resources.
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
import java.util.HashSet;
import java.util.LinkedList;


public class InternalNet extends Net {
	
	private Pin outpin;
	private Collection<Pin> inpins;
	private Collection<Pip> pips;
	private Collection<RouteThrough> routethroughs;
	
	// constructors	
	public InternalNet(String pName, Pin pOutpin, ENetType pType)
	{
	    super(pName,pType);
		this.outpin = pOutpin;
		
		inpins = new LinkedList<Pin>();
		pips = new LinkedList<Pip>();
		routethroughs = new LinkedList<RouteThrough>();
	}
	
	// outpin methods
	public Pin getOutpin() {
		return outpin;
	}
	
	// inpin methods
	public void addInpin(Pin pin) {
        isclocknetset = false;
		this.inpins.add(pin);
	}
	public Iterable<Pin> getInpins()
	{
		return this.inpins;
	}
	
	// pip methods
	public void addPip(Pip pip) {
        isclocknetset = false;
		this.pips.add(pip);
	}
	public Iterable<Pip> getPips()
	{
		return this.pips;
	}
	
	// routethroughs methods
	public void addRouteThrough(RouteThrough rt) {
        isclocknetset = false;
		this.routethroughs.add(rt);
	}
	public Iterable<RouteThrough> getRouteThroughs()
	{
		return this.routethroughs;
	}

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfTiles()
     */
    @Override
    public int getNumberOfTiles()
    {
        Collection<Tile> tiles = new HashSet<Tile>();
        for(Pip pip: getPips())
        {
            tiles.add(pip.getTile());
        }
        return tiles.size();
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfWires()
     */
    @Override
    public int getNumberOfWires()
    {
        Collection<Wire> wires = new HashSet<Wire>(this.pips.size()*2);
        for(Pip pip: getPips())
        {
            wires.add(pip.getLeftWire());
            wires.add(pip.getRightWire());
        }
        
        return wires.size();
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfInpins()
     */
    @Override
    public int getNumberOfInpins()
    {
        return inpins.size();
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfOutpins()
     */
    @Override
    public int getNumberOfOutpins()
    {
        // TODO Auto-generated method stub
        return 1;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfPips()
     */
    @Override
    public int getNumberOfPips()
    {
        // TODO Auto-generated method stub
        return this.pips.size();
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfPips()
     */
    @Override
    public int getNumberOfRouteThroughs()
    {
        // TODO Auto-generated method stub
        return this.routethroughs.size();
    }

    public boolean isInternal() 
    {
        return true;
    }

    private boolean isclocknetset = false;
    private boolean isclocknet = false;
    /* (non-Javadoc)
     * @see XDL.model.Net#isClockNet()
     */
    @Override
    public boolean isClockNet()
    {
        if(!isclocknetset)
        {        
            if(getName().contains("CLK")) {
                isclocknet = true;
            } else if(this.outpin.isClockPin()) {
                isclocknet = true;
//            } else {
//                for(Pin pin: this.inpins)
//                    if(pin.isClockPin()) 
//                        isclocknet = true;
            }
            isclocknetset = true;
        }
        return isclocknet;
    }

    private boolean istransportnetset = false;
    private boolean istransportnet = false;
    /* (non-Javadoc)
     * @see XDL.model.Net#isClockNet()
     */
    @Override
    public boolean isTransportNet()
    {
        if(!istransportnetset)
        {
            if(this.outpin.isAtIOB()) {
                istransportnet = true;
            } else {
                for(Pin pin: this.inpins)
                    if(pin.isAtIOB()) {
                        istransportnet = true;
                        break;
                    }
            }
            istransportnetset = true;
        }
        return istransportnet;
    }

    
}
