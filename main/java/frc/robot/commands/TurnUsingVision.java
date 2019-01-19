/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Vision;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.command.Command;

public class TurnUsingVision extends Command {
  Vision limelight;
  DriveTrain drivetrain;

  public TurnUsingVision() {
      limelight = new Vision();
      drivetrain = new DriveTrain();
    
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //if(angle>0) then left goes back, right goes front
    //if(angle<0) ''opposite

    if(limelight.getHorizontal()>0){

      System.out.print("\n\n\n\n\turn left\n\n\n\n");

      drivetrain.setLeftRightMotorOutputs (-0.3, 0.3); // turns left
    }
    else if(limelight.getHorizontal()<0) {
      System.out.print("\n\n\n\n\turn right\n\n\n\n");

      drivetrain.setLeftRightMotorOutputs(0.3, -0.3); // turns right
    }
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return limelight.getHorizontal() == 0;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    while(isFinished()==true) return;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
