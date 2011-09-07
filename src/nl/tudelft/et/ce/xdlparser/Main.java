package nl.tudelft.et.ce.xdlparser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import nl.tudelft.et.ce.xdlparser.model.Design;
import nl.tudelft.et.ce.xdlparser.model.EMeasureType;
import nl.tudelft.et.ce.xdlparser.parser.ParseException;
import nl.tudelft.et.ce.xdlparser.parser.TokenMgrError;
import nl.tudelft.et.ce.xdlparser.parser.XDLParser;

import jargs.gnu.CmdLineParser;

/**
 * 
 */


/**
 * @author roel
 *
 */
public class Main
{
    private boolean option_help = false;
    private boolean option_row = false;
    private boolean option_header = false;
    private boolean option_rownames = false;
    private boolean option_rownamehack = false;
    private String[] xdl_files;
    private String[] args;

    public static void main(String args[])
    {
        // instantiate app
        Main app = new Main(args);

        app.start();

        // normal exit
        System.exit(0);
    }

    public Main(String args[])
    {
        this.args = args;
    }

    public void start()
    {
        // parse options
        parseOptions();

        // print generate and print output
        if(option_header)
            printHeader();
        for(String file: xdl_files)
            parseXDLFile(file);
    }


    private void printHeader()
    {
        System.out.print("total.nets transport.nets logic.nets power.nets ground.nets clock.nets ");
        System.out.print("total.outpins transport.outpins logic.outpins power.outpins ground.outpins clock.outpins ");
        System.out.print("total.inpins transport.inpins logic.inpins power.inpins ground.inpins clock.inpins ");
        System.out.print("total.pips transport.pips logic.pips power.pips ground.pips clock.pips ");
        System.out.print("total.routethroughs transport.routethroughs logic.routethroughs power.routethroughs ground.routethroughs clock.routethroughs ");
        System.out.print("total.wires transport.wires logic.wires power.wires ground.wires clock.wires ");
        System.out.println("tiles instances");
    }

    private void parseOptions()
    {
        // generate CLI parser
        CmdLineParser parser = new CmdLineParser();

        // specify expected options
        CmdLineParser.Option showhelp = parser.addBooleanOption('h', "help");
        CmdLineParser.Option rowformat = parser.addBooleanOption('r', "row");
        CmdLineParser.Option showheader = parser.addBooleanOption('H', "header");
        CmdLineParser.Option showrownames = parser.addBooleanOption('n', "name");
        CmdLineParser.Option rownamehack = parser.addBooleanOption("name-hack");
                
        // parse CLI
        try {
            parser.parse(args);
        } catch(CmdLineParser.OptionException e) {
            System.err.println(e.getMessage());
            printHelp();
            System.exit(2);
        }

        // get option values
        option_help = (Boolean)parser.getOptionValue(showhelp, Boolean.FALSE);
        option_row = (Boolean)parser.getOptionValue(rowformat, Boolean.FALSE);
        option_header = (Boolean)parser.getOptionValue(showheader, Boolean.FALSE);
        option_rownames = (Boolean)parser.getOptionValue(showrownames, Boolean.FALSE);
        option_rownamehack = (Boolean)parser.getOptionValue(rownamehack, Boolean.FALSE);
 
        // if option_help is true print help and exit
        if(option_help)
        {
            printHelp();
            System.exit(0);
        }


        // check semantics
        // -> just ignore unused options

        xdl_files = parser.getRemainingArgs();

        if(xdl_files.length == 0)
        {
            System.err.println("Error: no files specified");
            printHelp();
            System.exit(1);
        }
    }

    private void parseXDLFile(String filename)
    {
        XDLParser parser = null;
        
        // get buffered input stream from first argument
        try 
        {
            InputStream is;
            if(filename.equals("-"))
                is = System.in;
            else
            {
                File file = new File(filename);
                is = new FileInputStream(file.getAbsolutePath());
            }
            BufferedInputStream bs = new BufferedInputStream(is);
            parser = new XDLParser(bs);
        } 
        catch(FileNotFoundException ex) 
        {
            System.err.println("Error: " + ex.getMessage());
            System.exit(1);
        }

        try
        {        
            Design design = parser.getDesign();

            if(option_rownamehack)
                design.setName(getHackedFileName(filename));        
    
            if(option_row)
                printRowFormat(design);
            else
                printTableFormat(design);
        }
        catch(ParseException ex)
        {
            // TODO Auto-generated catch block
            System.err.println("Error in file " + filename + ": " + ex.getMessage());
        }
        catch(TokenMgrError ex)
        {
            // TODO Auto-generated catch block
            System.err.println("Error in file " + filename + ": " + ex.getMessage());
        }
    }

    private void printRowFormat(Design design)
    {
        if(option_rownames) 
            System.out.print(design.getName() + " ");

        System.out.println(
            design.getNumberOfNets(EMeasureType.TOTAL) + " " +
            design.getNumberOfNets(EMeasureType.TRANSPORT) + " " +
            design.getNumberOfNets(EMeasureType.LOGIC) + " " +
            design.getNumberOfNets(EMeasureType.POWER) + " " +              
            design.getNumberOfNets(EMeasureType.GROUND) + " " +              
            design.getNumberOfNets(EMeasureType.CLOCK)  + " " +
            
            design.getNumberOfOutpins(EMeasureType.TOTAL) + " " +            
            design.getNumberOfOutpins(EMeasureType.TRANSPORT) + " " +            
            design.getNumberOfOutpins(EMeasureType.LOGIC) + " " +
            design.getNumberOfOutpins(EMeasureType.POWER) + " " +
            design.getNumberOfOutpins(EMeasureType.GROUND) + " " +
            design.getNumberOfOutpins(EMeasureType.CLOCK) + " " +
            
            design.getNumberOfInpins(EMeasureType.TOTAL) + " " +            
            design.getNumberOfInpins(EMeasureType.TRANSPORT) + " " +            
            design.getNumberOfInpins(EMeasureType.LOGIC) + " " +
            design.getNumberOfInpins(EMeasureType.POWER) + " " +
            design.getNumberOfInpins(EMeasureType.GROUND) + " " +
            design.getNumberOfInpins(EMeasureType.CLOCK)  + " " +
            
            design.getNumberOfPips(EMeasureType.TOTAL) + " " +            
            design.getNumberOfPips(EMeasureType.TRANSPORT) + " " +            
            design.getNumberOfPips(EMeasureType.LOGIC) + " " +
            design.getNumberOfPips(EMeasureType.POWER) + " " +
            design.getNumberOfPips(EMeasureType.GROUND) + " " +
            design.getNumberOfPips(EMeasureType.CLOCK)  + " " +
            
            design.getNumberOfRouteThroughs(EMeasureType.TOTAL) + " " +            
            design.getNumberOfRouteThroughs(EMeasureType.TRANSPORT) + " " +            
            design.getNumberOfRouteThroughs(EMeasureType.LOGIC) + " " +
            design.getNumberOfRouteThroughs(EMeasureType.POWER) + " " +
            design.getNumberOfRouteThroughs(EMeasureType.GROUND) + " " +
            design.getNumberOfRouteThroughs(EMeasureType.CLOCK)  + " " +

            design.getNumberOfWires(EMeasureType.TOTAL) + " " +            
            design.getNumberOfWires(EMeasureType.TRANSPORT) + " " +            
            design.getNumberOfWires(EMeasureType.LOGIC) + " " +
            design.getNumberOfWires(EMeasureType.POWER) + " " +
            design.getNumberOfWires(EMeasureType.GROUND) + " " +
            design.getNumberOfWires(EMeasureType.CLOCK)  + " " +
            
            design.getNumberOfTiles() + " " +
            design.getNumberOfInstances());
    }

    private void printTableFormat(Design design)
    {
            System.out.println("object\t total\t logic\t power\t ground\t clock");
            
            System.out.println("nets\t" + 
                design.getNumberOfNets(EMeasureType.TOTAL) + "\t" +
                design.getNumberOfNets(EMeasureType.TRANSPORT) + "\t" +
                design.getNumberOfNets(EMeasureType.LOGIC) + "\t" +
                design.getNumberOfNets(EMeasureType.POWER) + "\t" +              
                design.getNumberOfNets(EMeasureType.GROUND) + "\t" +              
                design.getNumberOfNets(EMeasureType.CLOCK) );
            
            System.out.println("outpins\t" + 
                design.getNumberOfOutpins(EMeasureType.TOTAL) + "\t" +            
                design.getNumberOfOutpins(EMeasureType.TRANSPORT) + "\t" +            
                design.getNumberOfOutpins(EMeasureType.LOGIC) + "\t" +
                design.getNumberOfOutpins(EMeasureType.POWER) + "\t" +
                design.getNumberOfOutpins(EMeasureType.GROUND) + "\t" +
                design.getNumberOfOutpins(EMeasureType.CLOCK) );
            
            System.out.println("inpins\t" + 
                design.getNumberOfInpins(EMeasureType.TOTAL) + "\t" +            
                design.getNumberOfInpins(EMeasureType.TRANSPORT) + "\t" +            
                design.getNumberOfInpins(EMeasureType.LOGIC) + "\t" +
                design.getNumberOfInpins(EMeasureType.POWER) + "\t" +
                design.getNumberOfInpins(EMeasureType.GROUND) + "\t" +
                design.getNumberOfInpins(EMeasureType.CLOCK) );
            
            System.out.println("pips\t" + 
                design.getNumberOfPips(EMeasureType.TOTAL) + "\t" +            
                design.getNumberOfPips(EMeasureType.TRANSPORT) + "\t" +            
                design.getNumberOfPips(EMeasureType.LOGIC) + "\t" +
                design.getNumberOfPips(EMeasureType.POWER) + "\t" +
                design.getNumberOfPips(EMeasureType.GROUND) + "\t" +
                design.getNumberOfPips(EMeasureType.CLOCK) );

            System.out.println("routethroughs\t" + 
                design.getNumberOfRouteThroughs(EMeasureType.TOTAL) + "\t" +            
                design.getNumberOfRouteThroughs(EMeasureType.TRANSPORT) + "\t" +            
                design.getNumberOfRouteThroughs(EMeasureType.LOGIC) + "\t" +
                design.getNumberOfRouteThroughs(EMeasureType.POWER) + "\t" +
                design.getNumberOfRouteThroughs(EMeasureType.GROUND) + "\t" +
                design.getNumberOfRouteThroughs(EMeasureType.CLOCK) );
            
            System.out.println("wires\t" + 
                design.getNumberOfWires(EMeasureType.TOTAL) + "\t" +            
                design.getNumberOfWires(EMeasureType.TRANSPORT) + "\t" +            
                design.getNumberOfWires(EMeasureType.LOGIC) + "\t" +
                design.getNumberOfWires(EMeasureType.POWER) + "\t" +
                design.getNumberOfWires(EMeasureType.GROUND) + "\t" +
                design.getNumberOfWires(EMeasureType.CLOCK) );
            
            System.out.println();
            
            System.out.println("# of tiles\t" + design.getNumberOfTiles() );
            System.out.println("# of insts\t" + design.getNumberOfInstances() );            
    }
    
    private static void printHelp()
    {
        System.out.println("Usage: ./xdlparser [-h | --help] [-H | --header] [-r | --row] <files>");
        System.out.println("    -r: print in row format (default is in table format).");
        System.out.println("    -H: print header info (only for row format).");
        System.out.println("    -h: print this help message.");
        System.out.println("    -n: print row names (XDL design names)");
        System.out.println("    --name-hack: hack names to be kernel names (only for quipu scripts).");
        System.out.println("    <files>: a list of files to parse in sequence.");
    }
            
    private static String getHackedFileName(String filename)
    {
        File file = new File(filename);
        file = file.getParentFile();
        file = file.getParentFile();
        return file.getName();
    }
}
