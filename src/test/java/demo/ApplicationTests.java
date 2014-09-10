package demo;

import javax.inject.Inject;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = { AppCtxConfig.class })
public class ApplicationTests extends AbstractTestNGSpringContextTests {
	@Inject
	MyClass myClass;

	@Test
	public void contextLoads() {
		loginAs("user", "password");
		myClass.foo();
	}

	@Inject
	AuthenticationProvider authenticationProvider;

	protected void loginAs(String username, String password) {
		SecurityContextHolder.clearContext();
		Authentication auth = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username,
				password));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

}
