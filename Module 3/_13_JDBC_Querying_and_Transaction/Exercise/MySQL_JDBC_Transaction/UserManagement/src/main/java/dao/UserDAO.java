package dao;

import model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "nguyenhuuhuy";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    public UserDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public User selectUser(int id) {
        System.out.println(SELECT_USER_BY_ID);
        User user = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        System.out.println(SELECT_ALL_USERS);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return userList;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());

            rowUpdated = (preparedStatement.executeUpdate() > 0);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        System.out.println(DELETE_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = (preparedStatement.executeUpdate() > 0);
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return rowDeleted;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{call insert_user(?, ?, ?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());

            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permissions) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementAssignment = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            int rowAffected = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            int userID = 0;
            if (resultSet.next())
                userID = resultSet.getInt(1);

            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permission(user_id,permission_id) " + "VALUES(?,?)";

                preparedStatementAssignment = connection.prepareStatement(sqlPivot);
                for (int permissionID : permissions) {
                    preparedStatementAssignment.setInt(1, userID);
                    preparedStatementAssignment.setInt(2, permissionID);
                    preparedStatementAssignment.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException exception) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(exception.getMessage());
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (preparedStatementAssignment != null)
                    preparedStatementAssignment.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException exception) {
                printSQLException(exception);
            }
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_UPDATE);) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            preparedStatementInsert.setString(1, "Quynh");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(10));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.executeUpdate();

            preparedStatementInsert.setString(1, "Ngan");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(20));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.executeUpdate();

            preparedStatementUpdate.setBigDecimal(2, new BigDecimal(999.99));
//            preparedStatementUpdate.setBigDecimal(1, new BigDecimal(999.99));
            preparedStatementUpdate.setString(2, "Quynh");
            preparedStatementUpdate.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void insertUpdateUseTransaction() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_UPDATE);) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            connection.setAutoCommit(false);
            preparedStatementInsert.setString(1, "Quynh");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(10));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.executeUpdate();

            preparedStatementInsert.setString(1, "Ngan");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(20));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.executeUpdate();

//            preparedStatementUpdate.setBigDecimal(2, new BigDecimal(999.99));
            preparedStatementUpdate.setBigDecimal(1, new BigDecimal(999.99));
            preparedStatementUpdate.setString(2, "Quynh");
            preparedStatementUpdate.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        }

    @Override
    public List<User> viewAllUsersStore() {
        String query = "{CALL view_all_users()}";
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return userList;
    }

    @Override
    public boolean updateUserStore(User user) {
        boolean rowUpdated = false;
        String query = "{CALL update_user_store_procedure(?, ?, ?, ?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());

            rowUpdated = (callableStatement.executeUpdate() > 0);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteUserStore(int id) {
        boolean rowDeleted = false;
        String query = "{CALL delete_user_store_procedure(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, id);

            rowDeleted = (callableStatement.executeUpdate() > 0);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException exception) {
        for (Throwable e : exception) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQL State: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = exception.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}

