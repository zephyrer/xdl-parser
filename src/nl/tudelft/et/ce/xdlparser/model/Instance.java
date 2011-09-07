/*
 * Instance.java
 * An instance is a physical element on the FPGA.
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
/**
 * 
 */
package nl.tudelft.et.ce.xdlparser.model;

/**
 * @author roel
 *
 */
public abstract class Instance
{
    private String name;
    private String sitedef;
    private String cfg;
    
    public Instance(String pName, String pSitedef, String pCfg)
    {
        this.name = pName;
        this.sitedef = pSitedef;
        this.cfg = pCfg;
    }
    
    // getters
    public String getName()
    {
        return this.name;
    }
    
    public String getSitedef()
    {
        return this.sitedef;
    }
    
    public String getCfg()
    {
        return this.cfg;
    }

    public boolean isIOB()
    {
        return sitedef.equals("IOB");
    }
    
    // checkers
    public abstract boolean isPlaced();
    public abstract boolean isBonded();
}
