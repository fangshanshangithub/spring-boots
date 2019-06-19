package com.boots.base.javabase.objects;

public class newObject {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("aaa");
        ojectInit(student);

        System.out.println(System.identityHashCode(student ) + " -- " +  student.getName());

    }

    private static void ojectInit(Student student) {
            Student student1 = new Student();
            student1.setName("bbbb");
            student = student1;
        System.out.println("## "+ System.identityHashCode(student) + " -- " +  student.getName());
    }


}

class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
