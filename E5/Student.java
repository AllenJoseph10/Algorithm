public class Student {
    String id;
    double average;
    private String[] modules;
    private int[] marks;
    private String name;

    public Student(String name){
        //complete the constructor
        getId(name);
    }

    public Student(String name, String[] modules, int[] marks){
        //complete the constructor
        this.modules = modules;
        this.marks = marks;

        getId(name);
        calculateAverage(marks);
    }

    public String getId (String name){
        //complete this method
        StringBuilder string1 = new StringBuilder();

        String[] splittingTheName = name.split(" ");
        for (String partOfTheName : splittingTheName) {
            string1.append(Character.toUpperCase(partOfTheName.toCharArray()[0]));
        }

        id = string1.toString() + name.length();
        return (id);
    }

    public double calculateAverage(int[] marks){
        //complete this method
        int sum = 0;

        for (int mark1 : marks) {
            sum = sum + mark1;
        }

        average = (Math.round((sum * 100.00 / marks.length)) / 100.00);
        return average;
    }

    public static double getAverage(Student[] students, String id) {
        //complete this method
        for (Student student1 : students) {
            if (student1.id.equals(id)) {
            return student1.average;
        }
    }
    return 0;
}

    public static int getMark(Student[] students, String id, String module) {
        //complete this method
        for (Student student1 : students) {
            if (student1.id.equals(id)) {
                if (student1.modules == null) {
                    return 0;
                }
                for (int i = 0; i < student1.modules.length; i++) {
                    if (student1.modules[i].equals(module)) {
                        return student1.marks[i];
                    }
                }
            }
        }
        return 0;
    }
}
