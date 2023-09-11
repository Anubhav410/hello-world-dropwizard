package base.db;

import org.jdbi.v3.sqlobject.config.RegisterFieldMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface TestDao {


    @SqlQuery("select * from tab1 where id=?")
    @RegisterFieldMapper(Tab1Row.class)
    List<Tab1Row> getRows(int id);
}
