package database;

import java.sql.SQLException;
import java.text.ParseException;

public interface ActionsBD {
    String insertRecord() throws ParseException, SQLException;
    void deleteRecord() throws SQLException;
}
