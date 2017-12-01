package widgets.dinesh.com.medicalapp.base.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ApplicationContext {
}
