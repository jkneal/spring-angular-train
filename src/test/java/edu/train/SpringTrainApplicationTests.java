package edu.train;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.train.SpringTrainApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTrainApplication.class)
@WebAppConfiguration
public class SpringTrainApplicationTests {

	@Test
	public void contextLoads() {
	}

}
