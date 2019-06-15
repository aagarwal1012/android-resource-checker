import org.checkerframework.checker.androidresource.qual.res.*;

class AndroidResourceTest {
    AndroidResourceTest() {
    }

    void Test() {
        @XmlRes int xml_res = R.xml.file_paths;
    }
}