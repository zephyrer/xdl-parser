package nl.tudelft.et.ce.xdlparser.model;

public class Pip extends Node 
{
	private Tile tile;
	private Wire leftWire;
	private EPipDirection direction;
	private Wire rightWire;
	
	
	// constructor
	public Pip(Tile pTile, Wire pLeftWire, Wire pRightWire, 
				EPipDirection pDirection)
	{
		this.tile = pTile;
		this.leftWire = pLeftWire;
		this.rightWire = pRightWire;
		this.direction = pDirection;
	}
	
	// getters
	public Tile getTile()
	{
		return this.tile;
	}
	
	public Wire getLeftWire()
	{
		return this.leftWire;		
	}
	
	public Wire getRightWire()
	{
		return this.rightWire;
	}
	
	public EPipDirection getDirection()
	{
		return this.direction;
	}
}
