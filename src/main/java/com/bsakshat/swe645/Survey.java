package com.bsakshat.swe645;

import javax.persistence.*;

@Entity
@Table(name = "survey")
public class Survey {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "studentID", unique = true)
        private int id;

        @Column(name = "firstName", nullable = false)
        private String first;

        @Column(name = "lastName", nullable = false)
        private String last;

        @Column(name = "address", nullable = false)
        private String address;

        @Column(name = "city", nullable = false)
        private String city;

        @Column(name = "state", nullable = false)
        private String state;

        @Column(name = "zipCode", nullable = false)
        private String zipcode;

        @Column(name = "phone", nullable = false)
        private String phone;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "tdate", nullable = false)
        private String tdate;

        public int getId() {
            return id;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTdate() {
            return tdate;
        }

        public void setTdate(String tdate) {
            this.tdate = tdate;
        }
}

