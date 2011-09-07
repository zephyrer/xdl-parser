package nl.tudelft.et.ce.xdlparser.model;

public class Pin extends Node 
{
//	private String inst_name;
    private Instance instance;
	private String inst_pin;
	
	// constructor
	public Pin(Instance pInstance, String pInstPin)
	{
		this.instance = pInstance;
		this.inst_pin = pInstPin;
	}
	
	public String getInstName()
	{
		return this.instance.getName();
	}
	
	public String getInstPin()
	{
		return this.inst_pin;
	}

    /**
     * @return
     */
    public boolean isClockPin()
    {
        // this is certainly a clock pin if it contains CLK in 
        // the signal name or pin        
        return (inst_pin.contains("CLK") || 
                getInstName().contains("CLK") ||
                inst_pin.contains("ODIV4") );
    }

    /**
     * @return
     */
    public boolean isAtIOB()
    {
        // this is at an IOB if the instance name is an IOB
        if(instance == null) return false;

        return instance.isIOB();
    }
}
