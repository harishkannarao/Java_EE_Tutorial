package firstcup.dao;


import firstcup.model.AgeDifferenceInfo;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSupportDao {
    @Inject
    private DataSource dataSource;
    
    private static final String AGE_DIFFERENCE_QUERY = "select sum(agedifference) sum_age_difference, count(agedifference)  count_age_difference from firstcupuser";
    private static final String DELETE_FIRSTCUP_STMT = "delete from FIRSTCUPUSER";

    public AgeDifferenceInfo getAgeDifferenceInfo() throws Exception{
        AgeDifferenceInfo result = new AgeDifferenceInfo();
        try(Connection con = dataSource.getConnection();
            Statement statement = con.createStatement()){
            try(ResultSet rs = statement.executeQuery(AGE_DIFFERENCE_QUERY)){
                while (rs.next()) {
                    result.setTotalAgeDifference(rs.getLong("sum_age_difference"));
                    result.setTotalCount(rs.getLong("count_age_difference"));
                }
            }
        }
        return result;
    }

    public void deleteFirstcupEntries() throws SQLException {
        try(Connection con = dataSource.getConnection();
            Statement statement = con.createStatement()){
            statement.executeUpdate(DELETE_FIRSTCUP_STMT);
        }
    }
}
