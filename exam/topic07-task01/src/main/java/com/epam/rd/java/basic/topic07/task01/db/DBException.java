package com.epam.rd.java.basic.topic07.task01.db;

import java.sql.SQLException;

public class DBException extends SQLException {
    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
