package org.example.lab_06.models;

import java.util.Objects;

public class User implements Comparable<User> {
    private Integer individualTaxNumber;  // Індивідуальний податковий номер (числовий)
    private String fullName;           // Прізвище ім’я по-батькові (символьний)
    private int birthYear;

    public User(Integer individualTaxNumber, String fullName, int birthYear) {
        this.individualTaxNumber = individualTaxNumber;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    @Override
    public String
    toString() {
        return "User{" +
                "individualTaxNumber=" + individualTaxNumber +
                ", fullName='" + fullName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return birthYear == user.birthYear && Objects.equals(individualTaxNumber, user.individualTaxNumber) && Objects.equals(fullName, user.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(individualTaxNumber, fullName, birthYear);
    }

    public Integer getIndividualTaxNumber() {
        return individualTaxNumber;
    }

    public void setIndividualTaxNumber(Integer individualTaxNumber) {
        this.individualTaxNumber = individualTaxNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public int compareTo(User o) {
        return this.individualTaxNumber.compareTo(o.individualTaxNumber);
    }
}
