public class Person {
    private String name;
    private int age;

    // 重写hashCode方法
    public int hashCode(){
        int result = name.hashCode();
        result = 17 * result + age;
        return result;
    }

    // 重写equals方法
    public boolean equals(Object obj){
        if (this ==obj) return true;
        if (obj==null) return false;
        if (getClass()!=obj.getClass()) return false;
        Person one = (Person) obj;
        return one.name.equals(this.name) && one.age == this.age;
    }

}
