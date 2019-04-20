import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.platform.runner.*;


@RunWith(JUnitPlatform.class)
@SelectClasses({CustomizationModuleTest.class, PremadeNameGeneratorTest.class})
public class AllTests {

}
