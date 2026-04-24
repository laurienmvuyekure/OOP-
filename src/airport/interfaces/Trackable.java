package airport.interfaces;

public interface Trackable {
    void trackStatus();

    void updateLocation(String location);

    String getCurrentLocation();
}