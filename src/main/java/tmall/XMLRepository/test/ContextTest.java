package tmall.XMLRepository.test;


import org.junit.Test;
import tmall.display.expression.util.Context;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ContextTest {

    @Test
    public void interpret() {
        Scanner scanner = new Scanner(System.in);
        Context context = new Context();
        try {
            Object[] enter_vc1234Pages = context.interpret("");
            for (Object o:enter_vc1234Pages
                 ) {
                System.out.println(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}