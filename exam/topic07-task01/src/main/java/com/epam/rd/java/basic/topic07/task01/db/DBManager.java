package com.epam.rd.java.basic.topic07.task01.db;

import com.epam.rd.java.basic.topic07.task01.Constants;
import com.epam.rd.java.basic.topic07.task01.db.entity.Team;
import com.epam.rd.java.basic.topic07.task01.db.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBManager {
    private static DBManager instance;
    private final Connection connection;

    public DBManager() throws DBException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(Constants.SETTINGS_FILE)) {
            properties.load(fis);
            String url = properties.getProperty("connection.url");

            // Class.forName(JDBC-DRIVER-FQN)
            connection = DriverManager.getConnection(url);
        } catch (IOException e) {
            throw new DBException("Error loading properties file", e);
        } catch (SQLException e) {
            throw new DBException("Can not connect to DB", e);
        }

    }

    public static DBManager getInstance() throws DBException {
        if (instance == null) {
            instance = new DBManager();
        }

        return instance;
    }

    public List<User> findAllUsers() throws DBException {
        List<User> users = new ArrayList<>();
        String query = "SELECT id, login FROM users";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt(Fields.USER_ID);
                String login = resultSet.getString(Fields.USER_LOGIN);
                User user = new User(id, login);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DBException("Error while query on findAllUsers", e);
        }

        return users;
    }

    public boolean insertUser(User user) throws DBException {
        String query = "INSERT INTO users (login) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getLogin());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DBException("Error while query on insertUser", e);
        }
    }

    public User getUser(String login) throws DBException {
        String query = "SELECT id, login FROM users WHERE login = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt(Fields.USER_ID);
                    return new User(id, login);
                }
            }
        } catch (SQLException e) {
            throw new DBException("Error while query on getUser", e);
        }

        return null;
    }

    public Team getTeam(String name) throws DBException {
        String query = "SELECT id, name FROM teams WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt(Fields.TEAM_ID);
                    return new Team(id, name);
                }
            }
        } catch (SQLException e) {
            throw new DBException("Error while query on getUser", e);
        }
        return null;
    }

    public List<Team> findAllTeams() throws DBException {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT id, name FROM teams";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt(Fields.TEAM_ID);
                String name = resultSet.getString(Fields.TEAM_NAME);
                Team team = new Team(id, name);
                teams.add(team);
            }
        } catch (SQLException e) {
            throw new DBException("Error while query on getUser", e);
        }

        return teams;
    }

    public boolean insertTeam(Team team) throws DBException {
        String query = "INSERT INTO teams (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, team.getName());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DBException("Error while query on getUser", e);
        }
    }

}
