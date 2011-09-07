/**
 * 
 */
package nl.tudelft.et.ce.xdlparser.model;

/**
 * @author roel
 *
 */
public enum EMeasureType
{
    TOTAL,
    /* logic, transport, power, ground, and clock comprise mutual exclusive sets */
    LOGIC, POWER, GROUND, CLOCK, TRANSPORT
    /* these are other divisions of to measure */
}
