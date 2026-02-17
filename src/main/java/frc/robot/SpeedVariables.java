package frc.robot;
// the stuff changes on runtime


public class SpeedVariables {
    public boolean intakeReverse = false;
    public boolean launch = false;   

    public void toggleIntake() {
        intakeReverse = !intakeReverse;

    }
    public void toggleLaunch() {
        launch = !launch;
    }
}
