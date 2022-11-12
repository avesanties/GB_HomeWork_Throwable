package main.data;

import main.constants.GENDERS;

public class Human {
    private String lastName;

    private String surname;

    private String firstName;

    private String birthDay;

    private long phoneNumber;

    private GENDERS gender;

    protected Human(HumanBuilder hb){
        this.lastName = hb.getLastName();
        this.surname = hb.getSurname();
        this.firstName = hb.getFirstName();
        this.birthDay = hb.getBirthDay();
        this.phoneNumber = hb.getPhoneNumber();
        this.gender = hb.getGender();
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public GENDERS getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return this.getLastName()
                + " " + this.getFirstName()
                + " " + this.getSurname()
                + " " + this.getBirthDay()
                + " " + this.getPhoneNumber()
                + " " + this.getGender();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return phoneNumber == human.phoneNumber
                && lastName.equals(human.lastName)
                && surname.equals(human.surname)
                && firstName.equals(human.firstName)
                && birthDay.equals(human.birthDay)
                && gender == human.gender;
    }

    public static class HumanBuilder{
        private String lastName;

        private String surname;

        private String firstName;

        private String birthDay;

        private long phoneNumber;

        private GENDERS gender;

        public HumanBuilder(){
        }

        public String getLastName() {
            return lastName;
        }

        public HumanBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getSurname() {
            return surname;
        }

        public HumanBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public HumanBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getBirthDay() {
            return birthDay;
        }

        public HumanBuilder setBirthDay(String birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public long getPhoneNumber() {
            return phoneNumber;
        }

        public HumanBuilder setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public GENDERS getGender() {
            return gender;
        }

        public HumanBuilder setGender(GENDERS gender) {
            this.gender = gender;
            return this;
        }

        public Human build(){
            return new Human(this);
        }
    }
}
