/**
 * 
 */
package nl.tudelft.et.ce.xdlparser.model;

/**
 * @author roel
 *
 */
public abstract class Net
{
    private String name;
    private ENetType type;
    
    public Net(String pName, ENetType pType)
    {
        this.name = pName;
        this.type = pType;
    }

    // Name methods
    public String getName() {
        return name;
    }

    // type methods
    public ENetType getType() {
        return type;
    }
    
    public boolean isOfMeasureType(EMeasureType mtype)
    {
        boolean value = false;
        switch(mtype)
        {
            case TOTAL:
                value = true;
                break;
            case LOGIC:
                value = (this.type == ENetType.WIRE && !isClockNet() && !isTransportNet());
                break;
            case POWER:
                value = (this.type == ENetType.POWER && !isClockNet() );
                break;
            case GROUND:
                value = (this.type == ENetType.GROUND && !isClockNet() );
                break;
            case CLOCK:
                value = isClockNet();
                break;
            case TRANSPORT:
                value = isTransportNet();
                break;
            default:
                System.out.println("EMeasureType " + mtype + " not covered in Net::isOfMeasureType()");
                assert(false);
                break;
        }
        return value;
    }   

    public abstract boolean isClockNet();    
    public abstract boolean isTransportNet();    
    public abstract boolean isInternal();
    
    public abstract int getNumberOfTiles();
    public abstract int getNumberOfWires();
    public abstract int getNumberOfPips();
    public abstract int getNumberOfRouteThroughs();
    public abstract int getNumberOfOutpins();
    public abstract int getNumberOfInpins();
    
}
