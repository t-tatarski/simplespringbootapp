package pl.keep.javac.simplespringbootapp;

import java.math.BigDecimal;

public class Patient {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal price;

    public Patient(Long id, String firstName, String lastName, BigDecimal price) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
