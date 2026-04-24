package airport.models;

public class Passenger {
    private String id, name, passport, nationality, phone;

    public Passenger(String id, String name, String passport,
            String nationality, String phone) {
        this.id = id;
        this.name = name;
        this.passport = passport;
        this.nationality = nationality;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " (" + passport + ")";
    }

    public String getPhoneNumber() { return getPhoneNumber();
    }

    public String getFullName() { return getFullName();
    }
}