package com.matt.springmasterclass.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public Customer(UUID id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Customer(String name) {
        this(UUID.randomUUID(), name, "password");
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!Objects.equals(id, customer.id)) return false;
        if (!Objects.equals(name, customer.name)) return false;
        return Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
