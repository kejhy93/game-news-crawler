package org.hejnaluk.gamenewscrawler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
class GameNewsCrawlerApplicationTests {

	@Value("${server.port}")
	int port;

	@Test
	void contextLoads() {
	}

}
