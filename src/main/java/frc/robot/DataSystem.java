package frc.robot;

import java.util.HashMap;

import edu.wpi.first.networktables.DoubleArrayPublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StringPublisher;

public class DataSystem {
    
    public NetworkTableInstance instance;
    public NetworkTable infopannelTable;
    public NetworkTable consoleTable;

    public StringPublisher consolePublisher;

    public DoubleArrayPublisher leftLeader;
    public DoubleArrayPublisher leftFollower;
    public DoubleArrayPublisher rightLeader;
    public DoubleArrayPublisher rightFollower;

    public HashMap<String,StringPublisher> publishers = new HashMap<String,StringPublisher>();
    public DataSystem() {
        instance = NetworkTableInstance.getDefault();
        
        infopannelTable = instance.getTable("CitrusDuckzInfoPannel");
        consoleTable = instance.getTable("CitrusDuckzConsole2");

        consolePublisher = consoleTable.getStringTopic("log").publish();
        leftLeader = infopannelTable.getDoubleArrayTopic("leftLeader").publish();
        leftFollower = infopannelTable.getDoubleArrayTopic("leftFollower").publish();
        rightLeader = infopannelTable.getDoubleArrayTopic("rightLeader").publish();
        rightFollower = infopannelTable.getDoubleArrayTopic("rightFollower").publish();
        publishers.put("driveMode", infopannelTable.getStringTopic("driveMode").publish());
        Print("Robot Communication!");
    }
    public void Print(String text) {
        consolePublisher.set(text);
    }
    
    public void PublishSparkMaxes(double[][] data) {
        leftLeader.set(data[0]);
        leftFollower.set(data[1]);
        rightLeader.set(data[2]);
        rightFollower.set(data[3]);
    }

    public void SetValue(String key, String value) {
        publishers.get(key).set(value);
    }

}
