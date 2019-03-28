package lyyljs.cloud.producer.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {

	private int port;
	
	@Override
	public void onApplicationEvent(WebServerInitializedEvent event) {
		port = event.getWebServer().getPort();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
