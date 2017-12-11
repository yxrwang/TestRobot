package au.com.arvis;

import au.com.arvis.business.CommandParser;
import au.com.arvis.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class TestCommandParser {

    @Test
    public void testParseValidCommands() throws Exception{

        List<Command> validCommands = CommandParser.getCommands(getTestFile("test1"));

        Assert.assertEquals(3, validCommands.size(), 0);

        Assert.assertEquals(Operation.PLACE, validCommands.get(0).getOperation());

        Position placePosition = ((PlaceOperationArgument)validCommands.get(0).getArgument()).getPosition();

        Facing placeFacing = ((PlaceOperationArgument)validCommands.get(0).getArgument()).getFacing();

        Assert.assertEquals(0, placePosition.getX(), 0);

        Assert.assertEquals(0, placePosition.getY(), 0);

        Assert.assertEquals(Facing.NORTH, placeFacing);

        Assert.assertEquals(Operation.LEFT, validCommands.get(1).getOperation());

        Assert.assertEquals(Operation.REPORT, validCommands.get(2).getOperation());
    }

    @Test
    public void testParseInvalidCommands() throws Exception{

        List<Command> commandsWithInvalidOnesFiltered = CommandParser.getCommands(getTestFile("InvalidCommand"));

        Assert.assertEquals(4, commandsWithInvalidOnesFiltered.size(), 0);

        Assert.assertEquals(Operation.MOVE, commandsWithInvalidOnesFiltered.get(0).getOperation());

        Assert.assertEquals(Operation.LEFT, commandsWithInvalidOnesFiltered.get(1).getOperation());

        Assert.assertEquals(Operation.MOVE, commandsWithInvalidOnesFiltered.get(2).getOperation());

        Assert.assertEquals(Operation.REPORT, commandsWithInvalidOnesFiltered.get(3).getOperation());
    }

    private String getTestFile(String fileName) throws Exception{

        return getClass().getClassLoader().getResource(fileName).getFile();
    }
}
