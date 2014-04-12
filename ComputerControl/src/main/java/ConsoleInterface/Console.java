package ConsoleInterface;

import java.util.Scanner;

/**
 * Created by spier on 4/6/14.
 */
class Console {

    public String read() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public void write(String out) {
        System.out.println(out);
    }
}
