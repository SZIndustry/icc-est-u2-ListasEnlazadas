package models;

public class Contact<T, U> {
    private T name;
    private U phone;

    public Contact(T name, U phone) {
        this.name = name;
        this.phone = phone;
    }

    public T getName() {
         return name; 
        }
    public U getPhone() {
         return phone; 
        }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone;
    }
}
