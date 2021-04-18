package com.SugarP1g.reflection;

import java.lang.reflect.Field;

public class GetField {

    public static void getField() throws NoSuchFieldException {
        Class stdClass = Student.class;

        // Field getField(name)：根据字段名获取某个public的field（包括父类）
        // 获取public字段"score":
        System.out.println("[+] getField: ");
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        System.out.println();

        // Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
        // 获取private字段"grade":
        System.out.println("[+] getDeclaredField: ");
        System.out.println(stdClass.getDeclaredField("grade"));
        System.out.println();

        // Field[] getFields()：获取所有public的field（包括父类）
        System.out.println("[+] getFields: ");
        Field[] fields = stdClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();

        // Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
        System.out.println("[+] getDeclaredFields: ");
        Field[] fields2 = stdClass.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }
        System.out.println();
    }

    public static void getFieldInfo() throws NoSuchFieldException {
        Class clzz = Student.class;
        Field score_f = clzz.getField("score");
        System.out.println("Field name: " + score_f.getName());
        System.out.println("Field type: " + score_f.getType());
    }

    public static void getFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Student stu = new Student(100, 10);
        // 先获取Class实例
        Class clzz = Student.class;
        // 再获取Field实例
        Field score_f = clzz.getField("score");
        // 用Field.get(Object)获取指定实例的指定字段的值
        System.out.println(score_f.get(stu));

        try {
            // 会得到一个IllegalAccessException，这是因为grade被定义为一个private字段
            Field grade_f = clzz.getDeclaredField("grade");
            System.out.println(grade_f.get(stu));
        } catch (IllegalAccessException e) {
            System.out.println("[!] Cannot access private field value, must setAccessible=true.");
        }

        try {
            Field grade_f = clzz.getDeclaredField("grade");
            // 调用Field.setAccessible(true)的意思是，别管这个字段是不是public，一律允许访问
            // setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，那么它会根据规则进行检查，有可能阻止setAccessible(true)。例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，这样可以保证JVM核心库的安全
            grade_f.setAccessible(true);
            System.out.println(grade_f.get(stu));
        } catch (IllegalAccessException e) {
            System.out.println("[!] Cannot access private field value, must setAccessible=true.");
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        getField();
        getFieldInfo();
        getFieldValue();
    }
}

class Student extends Person {
    public int score;
    private int grade;

    public Student(int score, int grade) {
        this.score = score;
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public int getGrade() {
        return grade;
    }
}

class Person {
    public String name;
}
