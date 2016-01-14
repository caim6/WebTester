package caim.study.jee.services.impl;

import caim.study.jee.services.ConfigApplicationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service("configApplicationService")
public class ConfigApplicationServiceImpl implements ConfigApplicationService {

	@Value("${caim.jee.study.supportEmailAddress}")
	private String supportEmailAddress;
	
	@Value("${caim.jee.study.cssJsVersion}")
	private String cssJsVersion;
	
	@Override
	public String getSupportEmailAddress() {
		return supportEmailAddress;
	}

	public void setSupportEmailAddress(String supportEmailAddress) {
		this.supportEmailAddress = supportEmailAddress;
	}

	public void setCssJsVersion(String cssJsVersion) {
		this.cssJsVersion = cssJsVersion;
	}

	@Override
	public String getCssJsVersion() {
		return cssJsVersion;
	}

}
