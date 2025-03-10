import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    //C:\Users\yelen\Desktop\Algebra34\original.pdf

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Unesite putanju do originalne datoteke koju želite kopirati :");
            String origFile = sc.nextLine();
            System.out.println("Unesite naziv i putanju do destinacijske datoteke :");
            String destFile = sc.nextLine();

            File a = new File(origFile);
            File b = new File(destFile);

            if (!a.exists()) {
                System.out.println("Originalna datoteka ne postoji");
                return;
            }

            try {
                letsCopy(a, b);
            } catch (IOException e) {
                System.out.println("Greška u kopiranju : " + e);
                return;
            }


            System.out.println("Želite li izbrisat kopiju datoteke? (D/N)");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("D")) {
                if (b.delete()) {
                    System.out.println(b.getName()+"  datoteka uspješno obrisana");
                } else {
                    System.out.println("Brisanje kopije nije uspjelo");
                }
            }

        } catch (Exception e) {
            System.out.println("Pojavila se greška: " + e);
        }
    }


    public static void letsCopy(File a, File b) throws IOException {
        FileInputStream in = new FileInputStream(a);
        FileOutputStream out = new FileOutputStream(b);

        try{
            int n;
            while((n=in.read())!=-1){
                out.write(n);
            }
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println("Greška pri zatvaranju ulaznog toka: "+e);
            }
            try {
                out.close();
            } catch (IOException e) {
                System.out.println("Greška pri zatvaranju izlaznog toka: "+e);
            }
        }
    }

}
