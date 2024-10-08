package org.example.class_design;

public class Exceptions {

    public static void main(String[] args) {
//        System.out.println(testFinally());

        Student s1 = new Student("");
        Student s2 = new Student("");
        Student s3 = null;
        System.out.println(s2.equals(s2) && s3.equals(s2));
    }

    private static int testFinally() {
        try {
            System.out.println("try block");
            return test2();
        } catch (Exception e) {
            System.out.println("catch block");
            return 4;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }

    private static int test2() {
        System.out.println("test2");
        throw new RuntimeException();
    }
}
