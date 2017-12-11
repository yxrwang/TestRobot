package au.com.arvis;

import au.com.arvis.exception.InvalidPosition;
import au.com.arvis.model.Facing;
import au.com.arvis.model.Position;
import au.com.arvis.model.Robot;
import au.com.arvis.model.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestRobot {

    private Table table = new Table(5,5);

    private Robot robot;

    @Before
    public void setup(){

        robot = new Robot(table);
    }

    @Test
    public void testPlaceInASafePosition(){

        Position safePosition = new Position(1,0);

        try{

            robot.place(safePosition, Facing.EAST);

        }catch (InvalidPosition e){

        }

        Assert.assertEquals(1, robot.getCurrentPosition().getX(), 0);

        Assert.assertEquals(0, robot.getCurrentPosition().getY(), 0);

        Assert.assertEquals(Facing.EAST, robot.getCurrentFacing());
    }

    @Test(expected = InvalidPosition.class)
    public void testPlaceInAnInvalidPosition() throws Exception{

        Position invalidPosition = new Position(6,6);

        robot.place(invalidPosition, Facing.EAST);

        Assert.assertEquals(Facing.EAST, robot.getCurrentFacing());
    }

    @Test
    public void testRobotTurnRight() throws Exception{

        robot.place(new Position(1,1), Facing.EAST);

        Assert.assertEquals(Facing.EAST, robot.getCurrentFacing());

        robot.turnRight();

        Assert.assertEquals(Facing.SOUTH, robot.getCurrentFacing());

        robot.turnRight();

        Assert.assertEquals(Facing.WEST, robot.getCurrentFacing());

        robot.turnRight();

        Assert.assertEquals(Facing.NORTH, robot.getCurrentFacing());

        robot.turnRight();

        Assert.assertEquals(Facing.EAST, robot.getCurrentFacing());
    }

    @Test
    public void testRobotTurnLeft() throws Exception{

        robot.place(new Position(1, 1), Facing.EAST);

        Assert.assertEquals(Facing.EAST, robot.getCurrentFacing());

        robot.turnLeft();

        Assert.assertEquals(Facing.NORTH, robot.getCurrentFacing());

        robot.turnLeft();

        Assert.assertEquals(Facing.WEST, robot.getCurrentFacing());

        robot.turnLeft();

        Assert.assertEquals(Facing.SOUTH, robot.getCurrentFacing());

        robot.turnLeft();

        Assert.assertEquals(Facing.EAST, robot.getCurrentFacing());

    }
}
