package au.com.arvis.business;

import au.com.arvis.exception.InvalidPosition;
import au.com.arvis.model.Command;
import au.com.arvis.model.PlaceOperationArgument;

import java.util.List;


public class CommandExecutor {

    private RobotOperation robot;

    private List<Command> commands;

    public CommandExecutor(RobotOperation robot, List<Command> commands){

        this.robot = robot;

        this.commands = commands;
    }

    public void execute(){

        if(robot == null){

            System.out.println("Warning: Robot is missing. Command execution stopped.");

            return;
        }

        if(commands != null && !commands.isEmpty()){

            for(Command command : commands){

                if(command != null && command.getOperation() != null){

                    switch (command.getOperation()){

                        case RIGHT:

                            robot.turnRight();

                            break;


                        case LEFT:

                            robot.turnLeft();

                            break;

                        case MOVE:

                            try{

                                robot.move();

                            }catch (InvalidPosition e){

                                System.out.println("The robot is going to fall off the table, ignore this move.");
                            }


                            break;

                        case PLACE:

                            try {

                                PlaceOperationArgument argument = (PlaceOperationArgument)command.getArgument();

                                if(argument != null){

                                    robot.place(argument.getPosition(), argument.getFacing());
                                }


                            }catch (InvalidPosition e){

                                System.out.println("The robot will fall off the table, ignore the position.");

                            }catch (ClassCastException e){

                                System.out.println("Invalid place operation argument, abort the operation.");
                            }

                            break;

                        case REPORT:

                            robot.report();

                            break;

                        default:

                            System.out.println("Warning: unknown operation detected.");

                            break;
                    }

                }else{

                    System.out.println("Warning: null command received, ignored");
                }


            }

        }else{

            System.out.print("No command has been given to the Robot.");
        }
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
