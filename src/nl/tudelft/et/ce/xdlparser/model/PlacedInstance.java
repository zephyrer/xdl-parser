/*
 * PlacedInstance.java
 * A PlacedInstance is an element on the FPGA that is actually placed on a
 * specific site.
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
public class PlacedInstance extends Instance
{
    private Tile tile;
    private String site;
    
    public PlacedInstance(String pName, String pSitedef, String pCfg,
        Tile pTile, String pSite)
    {
        super(pName, pSitedef, pCfg);
        
        this.tile = pTile;
        this.site = pSite;
    }

    // getters
    public Tile getTile()
    {
        return this.tile;
    }
    
    public String getSite()
    {
        return this.site;
    }
    
    // checkers
    
    /* (non-Javadoc)
     * @see XDL.model.Instance#isPlaced()
     */
    @Override
    public boolean isPlaced()
    {        
        return true;
    }
    
    /* (non-Javadoc)
     * @see XDL.model.Instance#isBonded()
     */
    @Override
    public boolean isBonded()
    {
        return true;
    }

}
