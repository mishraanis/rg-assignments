public class Main2 {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);
        System.out.println("Name: " + person.getName());
        person.setAge(31);
        System.out.println("Age: " + person.getAge());
    }
}
