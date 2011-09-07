/**
 * 
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
