package com.dp;

import java.sql.SQLException;

public interface Interpreter {
   public abstract String interpret() throws SQLException;
}
