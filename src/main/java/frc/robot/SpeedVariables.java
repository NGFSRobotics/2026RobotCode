package frc.robot;
// the stuff changes on runtime


public class SpeedVariables {
    public boolean intakeReverse = false;
    public boolean launch = false;   

    public void toggleIntake(boolean set) {
        intakeReverse = set;

    }
    public void toggleLaunch(boolean set) {
        launch = set;
    }
}
