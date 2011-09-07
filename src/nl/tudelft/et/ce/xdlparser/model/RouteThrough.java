package nl.tudelft.et.ce.xdlparser.model;

public class RouteThrough extends Node 
{
	private Instance instance;
	private Pin leftPin;
	private EPipDirection direction;
	private Pin rightPin;
	
	
	// constructor
	public RouteThrough(Instance pInstance, Pin pLeftPin, Pin pRightPin, 
				EPipDirection pDirection)
	{
		this.instance = pInstance;
		this.leftPin = pLeftPin;
		this.rightPin = pRightPin;
		this.direction = pDirection;
	}
	
	// getters
	public Instance getInstance()
	{
		return this.instance;
	}
	
	public Pin getLeftPin()
	{
		return this.leftPin;		
	}
	
	public Pin getRightPin()
	{
		return this.rightPin;
	}
	
	public EPipDirection getDirection()
	{
		return this.direction;
	}
}
