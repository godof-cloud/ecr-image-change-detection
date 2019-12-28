package cloud.godof.hellocloud.domain;

import java.io.Serializable;

public class GreetingResponse implements Serializable {

	private static final long serialVersionUID = 9166876242373430286L;
	
	private String greeting;
	
	public GreetingResponse() {
	}
	
	public GreetingResponse(String greeting) {
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
