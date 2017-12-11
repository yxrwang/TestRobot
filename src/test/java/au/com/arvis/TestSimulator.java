package au.com.arvis;

import au.com.arvis.business.CommandExecutor;
import au.com.arvis.business.CommandParser;
import au.com.arvis.business.Simulator;
import au.com.arvis.model.Command;
import au.com.arvis.model.Facing;
import au.com.arvis.model.Robot;
import au.com.arvis.model.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TestSimulator {

    private Simulator simulator;

    private Table table = new Table(5,5);

    private Robot robot;

    private CommandExecutor commandExecutor;

    @Before
    public void setup(){

        robot = new Robot(table);

        commandExecutor = new CommandExecutor(robot, new ArrayList<Command>());

        simulator = new ToyRobotSimulator.SimulatorBuilder().commandExecutor(commandExecutor).robot(robot).build();
    }

    @Test
    public void testSafeMovementCommand() throws Exception{

        List<Command> safeCommands = CommandParser.getCommands(getTestFile("test"));

        commandExecutor.setCommands(safeCommands);

        simulator.run();

        Assert.assertEquals(3, robot.getCurrentPosition().getX(), 0);

        Assert.assertEquals(3, robot.getCurrentPosition().getY(), 0);

        Assert.assertEquals(Facing.NORTH, robot.getCurrentFacing());

    }

    @Test
    public void testUnSafeMovementCommand() throws Exception{

        List<Command> unsafeCommands = CommandParser.getCommands(getTestFile("test2"));

        commandExecutor.setCommands(unsafeCommands);

        simulator.run();

        Assert.assertEquals(0, robot.getCurrentPosition().getX(),0);

        Assert.assertEquals(1, robot.getCurrentPosition().getY(), 0);

        Assert.assertEquals(Facing.NORTH, robot.getCurrentFacing());
    }

    private String getTestFile(String fileName) throws Exception{

        return getClass().getClassLoader().getResource(fileName).getFile();
    }
}
