/*
 * EMeasureType.java
 * An enumeration of the different resources we want to measure.
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
public enum EMeasureType
{
    TOTAL,
    /* logic, transport, power, ground, and clock comprise mutual exclusive sets */
    LOGIC, POWER, GROUND, CLOCK, TRANSPORT
    /* these are other divisions of to measure */
}
