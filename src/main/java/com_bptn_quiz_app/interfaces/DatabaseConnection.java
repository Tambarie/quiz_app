package com_bptn_quiz_app.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
        Connection getConnection() throws SQLException, ClassNotFoundException;
}


