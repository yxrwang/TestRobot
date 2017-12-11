package au.com.arvis;

import au.com.arvis.business.CommandExecutor;
import au.com.arvis.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TestCommandExecutor {

    private Table table = new Table(5,5);

    private Robot robot;

    private CommandExecutor commandExecutor;

    @Before
    public void setup(){

        robot = new Robot(table);

        commandExecutor = new CommandExecutor(robot, null);
    }

    @Test
    public void testCorrectCommandExecution() throws Exception{

        commandExecutor.setCommands(getValidCommands());

        commandExecutor.execute();

        Assert.assertEquals(2, robot.getCurrentPosition().getX(),0);

        Assert.assertEquals(2, robot.getCurrentPosition().getY(), 0);

        Assert.assertEquals(Facing.EAST, robot.getCurrentFacing());

    }

    @Test
    public void testInvalidCommandsExecution() throws Exception{

        commandExecutor.setCommands(getInvalidCommands());

        commandExecutor.execute();

        Assert.assertEquals(0, robot.getCurrentPosition().getX(),0);

        Assert.assertEquals(1, robot.getCurrentPosition().getY(), 0);

        Assert.assertEquals(Facing.EAST, robot.getCurrentFacing());
    }

    private List<Command> getValidCommands(){

        List<Command> validCommands = new ArrayList<>();

        Command place = new Command(Operation.PLACE);

        place.setArgument(new PlaceOperationArgument(new Position(1, 1), Facing.EAST));

        validCommands.add(place);

        Command move = new Command(Operation.MOVE);

        validCommands.add(move);

        Command turnLeft = new Command(Operation.LEFT);

        validCommands.add(turnLeft);

        validCommands.add(move);

        Command turnRight = new Command(Operation.RIGHT);

        validCommands.add(turnRight);

        return validCommands;
    }



    private List<Command> getInvalidCommands(){

        List<Command> invalidCommands = new ArrayList<>();

        Command move = new Command(Operation.MOVE);

        Command turnRight = new Command(Operation.RIGHT);

        invalidCommands.add(null);

        invalidCommands.add(move);

        invalidCommands.add(turnRight);

        invalidCommands.add(null);

        invalidCommands.add(new Command(null));

        invalidCommands.add(new Command(Operation.PLACE));

        return invalidCommands;
    }

}
