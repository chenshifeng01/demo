package day01;

import java.nio.ByteBuffer;

public class HelloDirectMemoryOutOfmemory {

    private static final int ONE_MB = 1024 * 1024 * 1024;

    private static int count = 1;

    public static void main(String[] args) {

        try {

            while (true) {

                ByteBuffer buffer = ByteBuffer.allocateDirect(ONE_MB);

                count ++ ;



            }


        } catch (Exception e) {

            System.out.println("Exception:instance createed " + count);

            e.printStackTrace();

        } catch (Error e) {

            System.out.println("Error:instance create " + count);

            e.printStackTrace();

        }






    }


}
