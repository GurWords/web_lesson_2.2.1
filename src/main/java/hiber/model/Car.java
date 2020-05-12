package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "series")
    int series;
    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {}

    public static class Builder{
        Car car;
        public Builder(){
            car = new Car();
        }
        public Builder withName(String name){
            car.name = name;
            return this;
        }
        public Builder withSeries(int series){
            car.series = series;
            return this;
        }
        public Car build(){
            return car;
        }
    }

    public int getId() {
        return id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                series == car.series &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, series);
    }
}
