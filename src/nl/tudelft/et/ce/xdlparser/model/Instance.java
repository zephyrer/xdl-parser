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
