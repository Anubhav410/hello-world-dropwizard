package base.db;

import org.jdbi.v3.sqlobject.config.RegisterFieldMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;


interface DAODefinition {
    public Object getClassDef();
}

public interface BaseDAO<DAODefinition> {

    @SqlQuery("select * from table_name where id=?")
    @RegisterFieldMapper(base.db.DAODefinition.class)
    List<DAODefinition> getById(int id);

}
