package tmall.tmallSystem;

import tmall.model.entity.Buyer;

import java.util.Scanner;

public class TMallSystemTest {

    public static void main(String[] args) {

        /**
         * Buyer Register
         */
        System.out.println("======= Buyer Register =======");

        Scanner scanner = new Scanner(System.in);

        System.out.println("phone:");
        String phone = scanner.next();

        System.out.println("password:");
        String password = scanner.next();

        System.out.println("idNumber:");
        String idNumber = scanner.next();

        System.out.println("nickname:");
        String nickname = scanner.next();

        System.out.println("gender:");
        String gender = scanner.next();

        System.out.println("birthday:");
        String birthday = scanner.next();



    }

}







