/**
 * 
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
