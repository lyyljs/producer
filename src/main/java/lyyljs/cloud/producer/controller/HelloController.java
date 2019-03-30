package lyyljs.cloud.producer.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lyyljs.cloud.producer.config.ServerConfig;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private ServerConfig config;
	
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "Hello " + name + ", Welcome to Spring Cloud.";
    }
    
    @RequestMapping("/sleep")
    public String sleep(){
    	try {
    		//int time = 100;
    		int time = ThreadLocalRandom.current().nextInt(6000);
    		log.info("call in will sleep: {}", time);
			Thread.sleep(time);
			return "port:" + config.getPort() + " sleep " + time;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return "port:" + config.getPort() + " sleep failed";
    }
    
    @RequestMapping("/exception")
    public String exception() throws Exception{
    	int time = ThreadLocalRandom.current().nextInt(6000);
    	if (time >= 3000){
    		throw new Exception("port:" + config.getPort() + "timeout:" + time);
    	}
    	return "Success" + config.getPort() + ";" + time;
    }
}