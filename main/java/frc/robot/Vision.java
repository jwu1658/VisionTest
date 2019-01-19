package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Vision extends Subsystem{

    
    NetworkTable table;
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta; 
    double x;
    double y;
    double area;
    
    public Vision(){
        table = NetworkTableInstance.getDefault().getTable("limelight");
        
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0);
        area = ta.getDouble(0.0);
        
        

    }

    public double getHorizontal(){
        return tx.getDouble(0.0);
    }

    

    public void turn(){

        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
        

    }

    @Override
    protected void initDefaultCommand() {

    }

}

