package ru.pork.db;

import org.hibernate.dialect.MySQL57InnoDBDialect;

public class MyOwnDialect extends MySQL57InnoDBDialect {
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci";
    }
}
