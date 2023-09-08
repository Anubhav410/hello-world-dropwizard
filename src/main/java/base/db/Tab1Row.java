package base.db;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.List;

public class Tab1Row {
    @ColumnName("id")
    public int id;
    @ColumnName("name")
    public String name;

    @ColumnName("age")
    public int age1;
}