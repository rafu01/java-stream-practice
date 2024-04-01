public class Employee {
    String address;

    public Employee(String address, String name, int age) {
        this.address = address;
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
