package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
@Repository
public class StudentRepository {
    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> techorMap;
    private HashMap<String, List<String>> studnetTeacherMapping;

    public void saveStudent(Student student) {
        studentMap.put(student.getName(),student);
    }

    public void saveTeacher(Teacher teacher) {
        techorMap.put(teacher.getName(), teacher);
    }

    public void makePair(String student, String teacher) {
        if(studentMap.containsKey(student) && techorMap.containsKey(teacher)){
            //for new studnet only

            List<String>currentStudent=new ArrayList<>();
            if(studnetTeacherMapping.containsKey(teacher)){
                currentStudent=studnetTeacherMapping.get(teacher);
            }
            currentStudent.add(student);
            studnetTeacherMapping.put(teacher,currentStudent);
        }
    }

    public Student getStudentName(String name) {
        return studentMap.get(name);
    }

    public Teacher getTeacherName(String name) {
        return techorMap.get(name);
    }

    public List<String> getlist(String teacher) {
        List<String> empty=new ArrayList<>();
        if(studnetTeacherMapping.containsKey(teacher)){
            empty=studnetTeacherMapping.get(teacher);
        }
        return empty;
    }

    public List<String> getAlllist() {
        List<String> studentList=new ArrayList<>();
        for(String student:studentMap.keySet()) studentList.add(student);
        return  studentList;

    }

    public void deleteTeacherName(String teacher) {
        if(studnetTeacherMapping.containsKey(teacher)){
            for(String s:studnetTeacherMapping.get(teacher)){
                studentMap.remove(s);
            }
            techorMap.remove(teacher);
            studnetTeacherMapping.remove(teacher);
        }
    }

    public void deleteAllteacher() {
        for(String s:studnetTeacherMapping.keySet()){
            deleteTeacherName(s);
        }
    }
    ///


}
