class Customer {
    private String name;
    private Vehicle customizedVehicle;
    private String age;
    private String email;
    private int customerId;
    // could be more values

    public Customer (String name, Vehicle customizedVehicle, String age, String email, int customerId) {
        this.name = name;
        this.customizedVehicle = customizedVehicle;
        this.age = age;
        this.email = email;
        this.customerId = customerId;
    }
}

public Customer getInformation() {
    return this;
}

public void changeInformation(Customer c) {
    this = c;
}

@Override
public void toString() {
    
}

// will need to add all the getter and setters