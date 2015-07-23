package de.crowdcode.speedauction.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class, DataSourceConfig.class})
public class JpaConfigTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testJpaConfig() throws Exception {
        assertThat(entityManager, is(notNullValue()));
    }
}