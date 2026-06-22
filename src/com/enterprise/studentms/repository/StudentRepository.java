package com.enterprise.studentms.repository;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.enterprise.studentms.model.Student;


public class StudentRepository {


    private List<Student> students = new ArrayList<>();

    private final String FILE = "data/students.txt";


    public StudentRepository() {
        loadStudents();
    }


    public void addStudent(Student student) {

        students.add(student);

        saveStudents();
    }


    public List<Student> getAllStudents() {

        return students;
    }


    public Student findById(int id) {

        for(Student student : students){

            if(student.getId() == id){
                return student;
            }
        }

        return null;
    }


    public boolean deleteStudent(int id){

        Student student = findById(id);

        if(student != null){

            students.remove(student);

            saveStudents();

            return true;
        }

        return false;
    }

    public boolean updateStudentMarks(int id, double newMarks){

     Student student = findById(id);

      if(student != null){

        student.setMarks(newMarks);

        saveStudents();

        return true;
    }

    return false;
}



    private void saveStudents(){

        try{

            FileWriter writer = new FileWriter(FILE);


            for(Student student : students){

                writer.write(student.toFileString());
                writer.write("\n");

            }


            writer.close();


        }catch(IOException e){

            System.out.println("Error saving students");
        }

    }




    private void loadStudents(){

        File file = new File(FILE);


        if(!file.exists()){
            return;
        }


        try{


            BufferedReader reader =
                    new BufferedReader(new FileReader(file));


            String line;


            while((line = reader.readLine()) != null){


                String data[] = line.split(",");


                int id = Integer.parseInt(data[0]);

                String name = data[1];

                double marks = Double.parseDouble(data[2]);


                students.add(
                    new Student(id,name,marks)
                );

            }


            reader.close();



        }catch(IOException e){

            System.out.println("Error loading students");
        }

    }

}