package jna.basic;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
 
// http://en.wikipedia.org/wiki/Java_Native_Access
/** Simple example of native library declaration and usage. */
public class HelloWorld {
    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary(
            (Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);
        void printf(String format, Object... args);
    }
 
    public static void main(String[] args) {
        CLibrary.INSTANCE.printf("Chris Wong is handsome.\n");
        for (int i = 0; i < args.length; i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
        }
    }
}
