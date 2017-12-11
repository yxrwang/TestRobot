package au.com.arvis.model;


public class PlaceOperationArgument {

    private Position position;

    private Facing facing;

    public PlaceOperationArgument(Position position, Facing facing){

        this.position = position;

        this.facing = facing;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }
}
