package firstcup.entity;

import firstcup.runner.WeldJUnit4Runner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(WeldJUnit4Runner.class)
public class FirstcupUserTest {
    @Inject
    private EntityManager em;
    private EntityTransaction tx;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

    @Before
    public void initTransaction() throws Exception {
        tx = em.getTransaction();
    }

    @Test
    public void shouldBeAbleToSaveAndLoad_FirstCupUserEntity() throws Exception{
        // given
        String bDay = "10/09/1985";
        Date date = sdf.parse("10/09/1985");
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

}
