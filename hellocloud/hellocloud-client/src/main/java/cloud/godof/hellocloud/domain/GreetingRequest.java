package cloud.godof.hellocloud.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class GreetingRequest implements Serializable {

	private static final long serialVersionUID = -7918922173101965473L;
	
	@NotNull
	private String name;
	
	public GreetingRequest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
