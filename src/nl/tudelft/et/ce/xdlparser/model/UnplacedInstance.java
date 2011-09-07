/*
 * UnplacedInstance.java
 * An FPGA element that has not been assigned to a physical site on the FPGA.
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
public class UnplacedInstance extends Instance
{
    private boolean bonded;


    public UnplacedInstance(String pName, String pSitedef, String pCfg, 
        boolean pBonded)
    {
        super(pName, pSitedef, pCfg);
        
        this.bonded = pBonded;
    }

    // checkers
    
    /* (non-Javadoc)
     * @see XDL.model.Instance#isPlaced()
     */
    @Override
    public boolean isPlaced()
    {
        return false;
    }
    
    /* (non-Javadoc)
     * @see XDL.model.Instance#isBonded()
     */
    @Override
    public boolean isBonded()
    {
        return bonded;
    }
    

}
