package base.db;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.FieldMapper;

import java.util.List;

public class DatabaseTest {

    public static void main(String[] args) {
        Database db = new Database();
        db.Get();
    }
}

class Database {
    Jdbi jdbi;

    Database() {
        jdbi = Jdbi.create("jdbc:mysql://localhost:3306/test_src", "root", "abcd1234");
    }

    public void Insert() {
        try (Handle handle = jdbi.open()) {
            handle.execute("insert into tab1 values('2');");
        }
    }

    public void Get() {
        try (Handle handle = jdbi.open()) {
            handle.registerRowMapper(FieldMapper.factory(Tab1Row.class));
            List<Tab1Row> res = handle.createQuery("select * from tab1").mapTo(Tab1Row.class).list();


            for (Tab1Row row : res) {
                System.out.printf("%s : %s : %s\n", row.age1, row.id, row.name);

//                for (Map.Entry<String, Object> item : row.entrySet()) {
//                    System.out.println("Key" + item.getKey());
//                    System.out.println("Value" + item.getValue());
//                }

            }
        }
    }
}

