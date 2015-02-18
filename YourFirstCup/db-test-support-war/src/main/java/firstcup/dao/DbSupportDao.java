package firstcup.dao;


import firstcup.constants.JndiConstants;
import firstcup.model.AgeDifferenceInfo;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbSupportDao {
    @Resource(lookup = JndiConstants.FIRSTCUPDS)
    private DataSource dataSource;
    
    private static final String AGE_DIFFERENCE_QUERY = "select sum(agedifference) sum_age_difference, count(agedifference)  count_age_difference from firstcupuser";
    
    public AgeDifferenceInfo getAgeDifferenceInfo() throws Exception{
        
        AgeDifferenceInfo result = new AgeDifferenceInfo();
        
        try(
                Connection con = dataSource.getConnection();
                Statement statement = con.createStatement()
        ){
            ResultSet rs = statement.executeQuery(AGE_DIFFERENCE_QUERY);
            while (rs.next()) {
                result.setTotalAgeDifference(rs.getLong("sum_age_difference"));
                result.setTotalCount(rs.getLong("count_age_difference"));
            }
        }

        return result;
    }
}
