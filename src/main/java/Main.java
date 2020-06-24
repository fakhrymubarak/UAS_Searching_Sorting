import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opt;
        String valToSearch;
        String[][] arr = {{"Segala-galanya Ambyar", "Mark Manson"},
                {"Another Sorry", "Fahrul Khakim"},
                {"Inestable", "Eko Ivano"},
                {"Cinta Itu Alasan Sekaligus Tujuan", "Kang Maman"},
                {"A Cup of Tea", "Gita Savitri"},
                {"Never Be Alone", "Chelsea Karina"},
                {"Crazy Stupid Revenge", "Sophia Hanna"},
                {"Bapakku Indonesia", "Kang Maman"},
                {"Sebuah Seni Bersikap Bodo Amat", "Mark Manson"}
        };

        String re = "y";
        while (re.equals("y")) {
            System.out.println("=====================================================\n" +
                    "Program Mencari dan Mengurutkan Data\n" +
                    "1. Lihat List Data Buku\n" +
                    "2. Cari Penulis\n" +
                    "3. Cari Buku\n" +
                    "4. Urutkan Berdasarkan Penulis\n" +
                    "5. Urutkan Berdasarkan Buku\n" +
                    "Silakan masukkan angka : (1/2/3/4/5)");
            opt = input.nextInt();
            input.nextLine();
            switch (opt) {
                case 1:
                    System.out.println("================= START DAFTAR BUKU =================");
                    printList(arr);
                    break;
                case 2:
                    System.out.println("Masukkan nama penulis : ");
                    valToSearch = input.nextLine();
                    searchOnListWriter(arr, valToSearch);
                    break;
                case 3:
                    System.out.println("Masukkan judul buku : ");
                    valToSearch = input.nextLine();
                    searchOnListBook(arr, valToSearch);
                    break;
                case 4:
                    System.out.println("============= URUT BERDASARKAN PENULIS =============");
                    sortListWriterAsc(arr);
                    break;
                case 5:
                    System.out.println("=============== URUT BERDASARKAN BUKU ===============");
                    sortListBookAsc(arr);
                    break;
            }
            System.out.println("Terima kasih sudah menggunakan program kami!\n" +
                    "=====================================================\n" +
                    "\nMau coba program lain?(y/n)");
            re = input.nextLine().toLowerCase();
        }
    }

    private static void searchOnListWriter(String[][] arr, String valToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1].toLowerCase().contains(valToSearch.toLowerCase())) {
                String pos = "Position [ " + i + " , " + 1 + " ]";
                System.out.println(pos);
                System.out.println("Penulis\t\t: " + arr[i][1] + "\nBuku\t\t: " + arr[i][0] + "\n");
            }
        }
    }

    private static void searchOnListBook(String[][] arr, String valToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0].toLowerCase().contains(valToSearch.toLowerCase())) {
                String pos = "Position [ " + i + " , " + 1 + " ]";
                System.out.println(pos);
                System.out.println("Buku\t: " + arr[i][0] + "\nPenulis\t: " + arr[i][1]);
            }
        }
    }

    private static void sortListWriterAsc(String[][] arr) {
        Arrays.sort(arr, new ColumnComparator(1));
        printList(arr);
    }

    private static void sortListBookAsc(String[][] arr) {
        Arrays.sort(arr, new ColumnComparator(0));
        printList(arr);
    }

    private static void printList(String[][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                System.out.print(arr[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("================== END DAFTAR BUKU ==================");
    }
}

class ColumnComparator implements Comparator {
    int columnToSort;

    ColumnComparator(int columnToSort) {
        this.columnToSort = columnToSort;
    }

    public int compare(Object o1, Object o2) {
        String[] row1 = (String[]) o1;
        String[] row2 = (String[]) o2;

        return row1[columnToSort].compareTo(row2[columnToSort]);
    }
}