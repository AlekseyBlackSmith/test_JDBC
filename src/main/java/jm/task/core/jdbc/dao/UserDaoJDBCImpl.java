package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Util util;
    private Connection connection;

    public UserDaoJDBCImpl() {
        util = new Util();;
        connection = util.getConnection();
    }

    public void createUsersTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS Users " +
                "(id INT NOT NULL AUTO_INCREMENT, " +
                "name VARCHAR (45) NOT NULL, " +
                "last_name VARCHAR (45) NOT NULL, " +
                "age INT NOT NULL, " +
                "PRIMARY KEY (id));";

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTable);
//            System.out.println("Таблица создана");
        } catch (SQLException e) {
            System.out.println("Не удалось создать таблицу");
        }

    }


    public void dropUsersTable() {
        String dropTable = "DROP TABLE IF EXISTS Users;";

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropTable);
//            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить таблицу");
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUser = "INSERT INTO users (name, last_name, age) VALUES ('"+name+"', '"+lastName+"', '"+age+"');";

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(saveUser);
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);
        } catch (SQLException e) {
            System.out.printf("Не удалось добавить в базу User с именем – %s\n", name);
        }

    }

    public void removeUserById(long id) {
        String removeUser = "DELETE FROM users WHERE id = '"+id+"';";

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(removeUser);
//            System.out.println("Пользователь удален");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить пользователяиз БД");
        }

    }

    public List<User> getAllUsers() {
        String getAll = "SELECT * FROM users";
        List<User> result = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getAll);
            while (resultSet.next()) {
                User user = new User("User");
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));
                result.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось восстановить всех пользователей из БД");
        }

//        System.out.println("Все пользователи восстановлены из БД");
        return result;

    }

    public void cleanUsersTable() {
        String cleanTable = "DELETE FROM users WHERE id > 0";

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(cleanTable);
//            System.out.println("Таблица очищена");
        }catch (SQLException e) {
            System.out.println("Не удалось очистить таблицу");
        }

    }
}
