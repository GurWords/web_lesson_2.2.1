package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_user")
   private Car car;

   public User() {}

   public static class Builder{
      User user;
      public Builder(){
         user = new User();
      }
      public Builder withFirstName(String firstname){
         user.firstName = firstname;
         return this;
      }
      public Builder withLastName(String lastname){
         user.lastName = lastname;
         return this;
      }
      public Builder withEmail(String email){
         user.email = email;
         return this;
      }
      public Builder withCar(Car car){
         user.car = car;
         return this;
      }
      public User build(){
         return user;
      }
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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }
   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return Objects.equals(id, user.id) &&
              Objects.equals(firstName, user.firstName) &&
              Objects.equals(lastName, user.lastName) &&
              Objects.equals(email, user.email);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, firstName, lastName, email);
   }
}
