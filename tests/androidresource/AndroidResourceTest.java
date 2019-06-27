import org.checkerframework.checker.androidresource.qual.res.*;
import src.R;

class AndroidResourceTest {
    AndroidResourceTest() {
    }

    void Test() {
        @XmlRes int xml_res = R.xml.file_paths;
        int a = 10;
        int b = 20;

        // :: warning: (binary.operation.not.allowed)
        int c = xml_res - b;

        // :: warning: (compound.assignment.not.allowed)
        xml_res += xml_res;
    }


}