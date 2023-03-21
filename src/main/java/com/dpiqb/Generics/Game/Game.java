package com.dpiqb.Generics.Game;

public class Game {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mary", 15);
        Student student1 = new Student("Nik", 20);
        Student student2 = new Student("Ksen", 19);
        Employee employee1 = new Employee("Zaur", 32);
        Employee employee2 = new Employee("Mikh", 47);

        Team<Schoolar> schoolarTeam1 = new Team<>("Dragons");
        schoolarTeam1.addNewParticipant(schoolar1);
        schoolarTeam1.addNewParticipant(schoolar2);

        Team<Student> studentTeam = new Team<>("Go!");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("To Work!");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        Team<Schoolar> schoolarTeam2 = new Team<>("To smart 4 U");
        Schoolar schoolar3 = new Schoolar("John", 15);
        Schoolar schoolar4 = new Schoolar("Bill", 15);
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);

        schoolarTeam1.playWith(schoolarTeam2);
    }
}
