package firstcup.entity;

import firstcup.runner.WeldContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FixturesCountTest extends DbFixturesSupport{
    private DataSource dataSource;
    
    private static final String FIXTURES_COUNT_QUERY = "select count(*) as count from FirstcupUserTest";

    @BeforeClass
    public void setupClass() throws Exception {
        dataSource = WeldContext.INSTANCE.getBean(DataSource.class);
    }
    
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
        Assert.assertEquals(3, count, "fixtures data no loaded");
    }
}
