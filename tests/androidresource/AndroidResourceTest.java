import org.checkerframework.checker.androidresource.qual.res.*;
import org.checkerframework.checker.androidresource.qual.Resource;
import src.R;

class AndroidResourceTest {
    AndroidResourceTest() {
    }

    void Test() {
        @XmlRes int xml_res = R.xml.file_paths;
//        xml_res = R.string.file_paths;    // Flagged by CF
    }
}