package au.com.arvis;

import au.com.arvis.business.CommandExecutor;
import au.com.arvis.business.Simulator;
import au.com.arvis.exception.InvalidPosition;
import au.com.arvis.model.*;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class ToyRobotSimulator implements Simulator{

    private Robot robot;

    private CommandExecutor commandExecutor;

    private ToyRobotSimulator(){

    }

    public static class SimulatorBuilder{

        private Robot robot;

        private CommandExecutor executor;

        public SimulatorBuilder robot(Robot robot){
            this.robot = robot;
            return this;
        }


        public SimulatorBuilder commandExecutor(CommandExecutor commandExecutor){

            this.executor = commandExecutor;
            return this;
        }

        public Simulator build(){

            ToyRobotSimulator simulator = new ToyRobotSimulator();

            simulator.setRobot(robot);

            simulator.setCommandExecutor(executor);

            return simulator;

        }
    }


    public void setRobot(Robot robot) {
        this.robot = robot;
    }


    public void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void run() {

        if(robot != null && commandExecutor != null){

            commandExecutor.execute();

        }else{

            System.out.println("Sorry, one of the simulator's components is broken. Simulation stopped");
        }
    }
}
