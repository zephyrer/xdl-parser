/*
 * ExternalNet.java
 * A subclass of a normal Net, an external Net is a connection to the outside
 * world and as such is not routed, and does not contain any wires.
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

/**
 * @author roel
 *
 */
public class ExternalNet extends Net
{
    private String cfg;
    
    public ExternalNet(String pName, ENetType pType, String pCfg)
    {
        super(pName,pType);
        this.cfg=pCfg;
    }
    
    // Cfg methods
    public String getCfg()
    {
        return this.cfg;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfTiles()
     */
    @Override
    public int getNumberOfTiles()
    {
        return 0;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfWires()
     */
    @Override
    public int getNumberOfWires()
    {
        return 0;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfInpins()
     */
    @Override
    public int getNumberOfInpins()
    {
        return 0;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfOutpins()
     */
    @Override
    public int getNumberOfOutpins()
    {
        return 0;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfOutpins()
     */
    @Override
    public int getNumberOfRouteThroughs()
    {
        return 0;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#getNumberOfPips()
     */
    @Override
    public int getNumberOfPips()
    {
        return 0;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#isInternal()
     */
    @Override
    public boolean isInternal()
    {
        return false;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#isClockNet()
     */
    @Override
    public boolean isClockNet()
    {
        return false;
    }

    /* (non-Javadoc)
     * @see XDL.model.Net#isClockNet()
     */
    @Override
    public boolean isTransportNet()
    {
        return false;
    }
}
