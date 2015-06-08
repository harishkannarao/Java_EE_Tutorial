package firstcup.entity;

import firstcup.runner.WeldContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class FirstcupUserTest extends DbFixturesSupport{
    private EntityManager em;
    private EntityTransaction tx;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

    @BeforeClass
    public void setupClass() throws Exception {
        em = WeldContext.INSTANCE.getBean(EntityManager.class);
    }

    @BeforeMethod
    public void initTransaction() throws Exception {
        tx = em.getTransaction();
    }

    @Test
    public void shouldBeAbleToSaveAndLoad_FirstCupUserEntity() throws Exception{
        // given
        String bDay = "10/09/1985";
        Date date = sdf.parse(bDay);
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        FirstcupUser firstcupUser = new FirstcupUser(date, 3);
        
        // when
        tx.begin();
        em.persist(firstcupUser);
        tx.commit();
        
        // then
        Long generatedId = firstcupUser.getId();
        assertNotNull(generatedId);
        FirstcupUser persitedFirstcupUser = em.find(FirstcupUser.class, generatedId);
        assertEquals(cal, persitedFirstcupUser.getBirthday());
        assertEquals(3, persitedFirstcupUser.getAgeDifference());
    }
    
    @Test
    public void findAverageAgeDifferenceOfAllFirstcupUsers_shouldCalculateAverageAgeDifference() throws Exception {
        // given
        tx.begin();
        em.createQuery("DELETE FROM FirstcupUser").executeUpdate();

        // when
        FirstcupUser user1 = new FirstcupUser(sdf.parse("10/09/1985"), 3);
        FirstcupUser user2 = new FirstcupUser(sdf.parse("10/09/1988"), 6);
        em.persist(user1);
        em.persist(user2);
        tx.commit();
        
        // then
        Double actualAverage = (Double) em.createNamedQuery("findAverageAgeDifferenceOfAllFirstcupUsers").getSingleResult();
        assertEquals(4.5, actualAverage);
    }

}
