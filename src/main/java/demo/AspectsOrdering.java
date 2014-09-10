package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;

@Aspect
@DeclarePrecedence("MyFirstAspect,*..AnnotationSecurityAspect*,MySecondAspect")
public class AspectsOrdering {

}
