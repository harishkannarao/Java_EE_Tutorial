package firstcup.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FirstcupUserTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstcupPUTest");
    private EntityManager em;
    private EntityTransaction tx;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    @After
    public void closeEntityManager() throws Exception {
        if (em != null) em.close();
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
