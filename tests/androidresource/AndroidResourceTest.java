import org.checkerframework.checker.androidresource.qual.res.*;
import org.checkerframework.checker.androidresource.qual.Resource;
import src.R;

class AndroidResourceTest {
    AndroidResourceTest() {
    }

    void Test() {
        @XmlRes int xml_res = R.xml.file_paths;
        int a = 10;
        int b = 20;
        int c = xml_res - b; // CF gives warning "binary.operation.not.allowed"
        xml_res += xml_res;  // CF gives warning "compound.assignment.not.allowed"
//        xml_res = R.string.file_paths;    // Flagged by CF
    }
}