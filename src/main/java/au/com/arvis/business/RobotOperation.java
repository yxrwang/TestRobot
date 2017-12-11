package au.com.arvis.business;

import au.com.arvis.exception.InvalidPosition;
import au.com.arvis.model.Facing;
import au.com.arvis.model.Position;
import au.com.arvis.model.Table;


public interface RobotOperation {

    void turnLeft();

    void turnRight();

    void place(Position position, Facing facing) throws InvalidPosition;

    void move() throws InvalidPosition;

    void report();
}
