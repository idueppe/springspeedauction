package de.crowdcode.speedauction.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
@PropertySource("classpath:database.properties")
public class DataSourceConfigTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Environment environment;

    @Test
    public void testDataSourceConnection() throws Exception {
        final String query = environment.getProperty("jdbcValidationQuery");
        assertThat(query, containsString("SELECT 1"));
        try (Connection con = dataSource.getConnection();
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {
            resultSet.next();
            assertThat(resultSet.getString(1), is("1"));
        }
    }
}