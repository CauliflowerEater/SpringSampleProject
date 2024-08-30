package guru.springframework.spring5webapp.domain;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String city;
    private String state;
    private String streatName;
    private String streetNumber;
    @OneToMany
    private Set<Book> books=new HashSet<>();
    public Publisher() {
    }

    public Publisher(String name, String city, String state, String streatName, String streetNumber) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.streatName = streatName;
        this.streetNumber = streetNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreatName() {
        return streatName;
    }

    public void setStreatName(String streatName) {
        this.streatName = streatName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;
        return id == publisher.id && Objects.equals(name, publisher.name) && Objects.equals(city, publisher.city) && Objects.equals(state, publisher.state) && Objects.equals(streatName, publisher.streatName) && Objects.equals(streetNumber, publisher.streetNumber);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
