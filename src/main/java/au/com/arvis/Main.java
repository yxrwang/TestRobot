package au.com.arvis;

import au.com.arvis.business.CommandExecutor;
import au.com.arvis.business.CommandParser;
import au.com.arvis.business.Simulator;
import au.com.arvis.model.Command;
import au.com.arvis.model.Robot;
import au.com.arvis.model.Table;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("--------------------------------------------------");

        System.out.println("Welcome to Toy Robot simulation presented by ARVIS");

        System.out.println("---------------------------------------------------");

       if(args != null && args.length > 0){

               for(int i = 0; i < args.length; i ++){

                   try {
                       String testFile = args[i];

                       System.out.println("Starting simulation file: "+ testFile);

                       List<Command> commandList = CommandParser.getCommands(args[i]);

                       Table table = new Table(5,5);

                       Robot robot = new Robot(table);

                       CommandExecutor commandExecutor = new CommandExecutor(robot, commandList);

                       Simulator simulator = new ToyRobotSimulator.SimulatorBuilder().robot(robot).commandExecutor(commandExecutor).build();

                       simulator.run();

                   }catch (Exception e) {

                       System.out.println("Invalid command file: "+ e.getMessage());
                   }

               }


       }else{

           System.out.println("No command file has been specified.");

       }


    }


}
