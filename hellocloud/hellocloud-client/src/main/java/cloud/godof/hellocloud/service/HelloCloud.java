package cloud.godof.hellocloud.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cloud.godof.hellocloud.domain.GreetingRequest;
import cloud.godof.hellocloud.domain.GreetingResponse;
import cloud.godof.hellocloud.domain.VersionResponse;

@CrossOrigin
@RequestMapping(value = "/api")
public interface HelloCloud {
	
	@RequestMapping(value = "/greeting", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public GreetingResponse greeting(GreetingRequest request);
	
	@RequestMapping(value = "/version", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public VersionResponse version();
	
}
