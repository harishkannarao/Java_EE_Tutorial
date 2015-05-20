package firstcup.entity;

import org.junit.Test;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FixturesCountTest extends DbFixturesSupport{
    
    @Inject
    private DataSource dataSource;
    
    private static final String FIXTURES_COUNT_QUERY = "select count(*) as count from FirstcupUserTest";
    
    @Test
    public void shouldLoadDbFixtures_fromSql()throws Exception {
        int count = 0;
        try(Connection con = dataSource.getConnection();
            Statement statement = con.createStatement()){
            try(ResultSet rs = statement.executeQuery(FIXTURES_COUNT_QUERY)){
                while (rs.next()) {
                    count = rs.getInt("count");
                }
            }
        }
        assertEquals("fixtures data no loaded", 3, count);
    }
}
