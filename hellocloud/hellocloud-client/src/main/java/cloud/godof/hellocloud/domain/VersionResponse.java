package cloud.godof.hellocloud.domain;

import java.io.Serializable;

public class VersionResponse implements Serializable {

	private static final long serialVersionUID = -1863402850380960730L;
	
	private String version;
	
	public VersionResponse() {
	}

	public VersionResponse(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
