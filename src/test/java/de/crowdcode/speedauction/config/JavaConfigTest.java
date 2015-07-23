package de.crowdcode.speedauction.config;

import de.crowdcode.speedauction.service.SpeedAuctionService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class JavaConfigTest {

    @Test
    public void testJavaConfigByName() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaConfig.class);
        ctx.register(AuctionRepositoryInMemoryConfig.class);
        ctx.refresh();

        assertThat(ctx.getBean("speedAuctionService"), is(notNullValue()));
        ctx.close();
    }

    @Test
    public void testJavaConfigByType() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaConfig.class);
        ctx.register(AuctionRepositoryInMemoryConfig.class);
        ctx.refresh();

        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));

        assertThat(ctx.getBean(SpeedAuctionService.class), is(notNullValue()));
        ctx.close();
    }

    @Test
//    @Ignore
    public void testJavaConfigRepository() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaConfig.class);
        ctx.register(AuctionRepositoryInMemoryConfig.class);
        ctx.refresh();

        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));

        SpeedAuctionService speedAuctionService = ctx.getBean(SpeedAuctionService.class);
        assertThat(speedAuctionService.findAllRunningAuctions(), is(notNullValue()));

        ctx.close();
    }

}