package tests;

import java.io.File;
import java.util.List;
import org.checkerframework.checker.androidresource.AndroidResourceChecker;
import org.checkerframework.framework.test.CheckerFrameworkPerDirectoryTest;
import org.junit.runners.Parameterized.Parameters;

/** Test runner for tests of the AndroidResource-Checker. */
public class AndroidResourceTest extends CheckerFrameworkPerDirectoryTest {
  public AndroidResourceTest(List<File> testFiles) {
    super(
        testFiles,
        AndroidResourceChecker.class,
        "androidresource",
        "-Anomsgtext",
        "-Astubs=stubs/",
        "-nowarn");
  }

  @Parameters
  public static String[] getTestDirs() {
    return new String[] {"androidresource"};
  }
}
