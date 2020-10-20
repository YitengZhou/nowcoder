// 饿汉模式，空间换时间
public class Singleton{
    private final Singleton singleton = new Singleton();
    private Singleton(){

    }
    public Singleton getInstance(){
        return singleton;
    }
}

// 懒汉模式，懒加载，用到时才加载，时间换空间
public class Singleton {
    private Singleton singleton;

    private Singleton(){}

    public Singleton getInstance(){
        if (singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}

// 懒汉，线程安全
public class Singleton{
    private Singleton singleton;
    Singleton(){}
    // 本处加入synchronized
    public synchronized Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}

// 懒汉双重验证锁 volatile + synchronized代码块
//综合了懒汉式和饿汉式两者的优缺点整合而成
// 看上面代码实现中，特点是在synchronized关键字内外都加了一层 if 条件判断
// 这样既保证了线程安全，又比直接上锁提高了执行效率，还节省了内存空间。
public class Singleton{
    private volatile Singleton singleton;
    Singleton(){}
    public Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton==null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

// 静态内部类

// 枚举
public enum EnumSingleton{
    INSTANCE;
    private Singleton singleton;
    private EnumSingleton(){
        singleton = new Singleton();
    }
    public Singleton getInstance(){
        return singleton;
    }
}