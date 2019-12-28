package cloud.godof.hellocloud.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cloud.godof.hellocloud.domain.GreetingRequest;
import cloud.godof.hellocloud.domain.GreetingResponse;
import cloud.godof.hellocloud.domain.VersionResponse;
import cloud.godof.hellocloud.service.HelloCloud;

@RestController
public class HelloCloudController implements HelloCloud {

	private static final String GREET = "Hello";
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Override
	public GreetingResponse greeting(@Valid @RequestBody GreetingRequest request) {
		return new GreetingResponse(GREET.concat(StringUtils.SPACE).concat(request.getName()));
	}

	@Override
	public VersionResponse version() {
		return new VersionResponse(projectVersion);
	}	
	

	
}
