package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.TestCommand;
import frc.robot.commands.ToggleCompressor;
import frc.robot.commands.SetSpeed;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// Commands

/*
import frc.robot.commands.drive.Drive;
import frc.robot.commands.vision.LimelightCameraToggle;
import frc.robot.commands.vision.LimelightLightToggle;
import frc.robot.commands.vision.LimelightSnapshotToggle;
import frc.robot.commands.vision.LimelightStreamToggle;
*/

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    // The robot's subsystems
    public final Shooter m_shooter = Shooter.getInstance();

    public final Pneumatics m_pneumatics = Pneumatics.getInstance();
  
    // Controllers
    private Joystick m_mainStick = new Joystick(OIConstants.mainStickPort);
    private Joystick m_firstStick = new Joystick(OIConstants.firstStickPort);
    private Joystick m_secondStick = new Joystick(OIConstants.secondStickPort);



    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {

      // Configure the button bindings
      System.out.println("container init");
      configureButtonBindings();
  
      // Configure default commands

    }

      
  
    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    
    private void configureButtonBindings() {
      // new JoystickButton(m_mainStick, Button.kA.value)
      //   .whileTrue(

      //   );

      // new JoystickButton(m_mainStick, Button.kStart.value)
      //   .onTrue(

      //   );

      new JoystickButton(m_mainStick, 4)
        .onTrue(
          new TestCommand(m_pneumatics, 1)
        );

      new JoystickButton(m_mainStick, 2)
        .onTrue(
          new TestCommand(m_pneumatics, 0)
        );

      new JoystickButton(m_mainStick, 1)
        .onTrue(
          new TestCommand(m_pneumatics, -1)
        );

      new JoystickButton(m_mainStick, 3)
        .onTrue(
          new ToggleCompressor(m_pneumatics)
        );
      
      new JoystickButton(m_mainStick, 8)
        .onTrue(
          new SetSpeed(m_shooter)
        );
      /*ew JoystickButton(m_mainStick, Button.kX.value)
        .whenPressed(
          new ToggleGate(m_driveTrain)
        );*/

    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */

    
    public Command getAutonomousCommand() {
        return null;
    }
    
}