package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Degrees;

import com.studica.frc.Navx;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavXSubsystem extends SubsystemBase {
    Navx navx = new Navx(0,100);

    

    public NavXSubsystem() {
        
    }
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Speed",  1);
        SmartDashboard.putNumber("Yaw Rotation", navx.getYaw().in(Degrees));
        
    }

    public Angle getRotation() {
        return navx.getYaw();
    }
    
}
