package au.com.arvis.model;


public enum Facing {

    NORTH(0), EAST(90), SOUTH(180), WEST(270);

    Facing(int value){
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public static Facing getFacing(int value){

        if(value < 0){

            value = value + 360;
        }

        switch (value){

            case 0:
                return NORTH;

            case 90:
                return EAST;

            case 180:
                return SOUTH;

            case 270:
                return WEST;

            default:
                return NORTH;

        }
    }
}
