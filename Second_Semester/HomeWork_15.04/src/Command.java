import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command
{
    public String[] aliases() default "no aliases";
    public String args() default "-";
    public String description() default "-";
    public String workingMethod() default "-";
    int id() default 0;
    public boolean inProgress() default true;
}