package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository=new StudentRepository();
    public void addStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.saveTeacher(teacher);
    }

    public void addstudnetTeacherPair(String student, String teacher) {
        studentRepository.makePair(student,teacher);
    }

    public Student getStudnet(String name) {
        return studentRepository.getStudentName(name);
    }

    public Teacher getteacher(String name) {
        return studentRepository.getTeacherName(name);
    }

    public List<String> getAllStudentOfTeacher(String teacher) {
        return studentRepository.getlist(teacher);
    }

    public List<String> getAllStudent() {
        return studentRepository.getAlllist();
    }

    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherName(teacher);
    }

    public void deleteAllTeacher() {
        studentRepository.deleteAllteacher();
    }
}
