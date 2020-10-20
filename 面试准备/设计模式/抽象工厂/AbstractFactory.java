public class AbstractFactory {
    public static void main(String[] args) {
        DatabaseUtils db = new OracleDatabase();
        Connection con = db.getConnect();
        con.connect();
        Command com = db.getCommand();
        com.command();
    }
}

interface Connection{
    public void connect();
}

interface Command{
    public void command();
}

// 抽象工厂由一系列的工厂方法组成
interface DatabaseUtils{
    Connection getConnect();
    Command getCommand();
}

class MysqlConnection implements Connection{

    @Override
    public void connect() {
        System.out.println("mysql connecting");
    }
}

class MysqlCommand implements Command{

    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

class MysqlDatabase implements DatabaseUtils{

    @Override
    public Connection getConnect() {
        return new MysqlConnection();
    }

    @Override
    public Command getCommand() {
        return new MysqlCommand();
    }
}

class OracleConnection implements Connection{

    @Override
    public void connect() {
        System.out.println("Oracle connecting");
    }
}

class OracleCommand implements Command{

    @Override
    public void command() {
        System.out.println("Oracle command");
    }
}

class OracleDatabase implements DatabaseUtils {

    @Override
    public Connection getConnect() {
        return new OracleConnection();
    }

    @Override
    public Command getCommand() {
        return new OracleCommand();
    }
}