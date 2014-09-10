package demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.prepost.PreAuthorize;

public class MyClass {
	static Log log = LogFactory.getLog(MyClass.class);

	public MyClass() {
	}

	@MyAnnotation
	@PreAuthorize("hasRole('ROLE_USER')")
	public void foo() {
		log.debug("In foo");
	}
}
