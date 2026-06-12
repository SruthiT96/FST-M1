package activities;

public class Activity3 {
public static String adjustDevice(String device, int value) {
	String status = switch (device) {
    // case Handle THERMOSTAT when value >= 40
    case String dev when dev.equals("THERMOSTAT") && value >= 40 ->"Temperature is high";
    // case Handle THERMOSTAT
    case "THERMOSTAT" -> "[Thermostat] Temperature is set to " + value;
    // case Handle LIGHT
    case "LIGHT" -> "[Light] Adjusting brightness to " + value + "%.";
    case null -> "Error: No device detected.";
    default -> "Unknown device type.";
};
return status;
}

public static void main(String[] args) {
	
	System.out.println(adjustDevice("THERMOSTAT", 50));
}
}
