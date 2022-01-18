import java.util.Random;
import java.util.Scanner;

public class Main {
    static int row = 4;
    static int colum = 4;

    static {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Satir : ");
        row = scanner.nextInt();
        System.out.print("Sutun : ");
        colum = scanner.nextInt();
    }

    static int[][] alan = new int[row][colum];

    public static void main(String[] args) {

        //yanana kadar oyunu devam ettirir.
        boolean devam=true;
        //toplam alandan mayınların sayısı çıkarılınca kalan sayıya kadar ilerlerse oyun kazanılır.
        int hesap=0;
        //mayınların toplam alandan çıkarılması yani boş yerler
        int toplam=row*colum/4;
        int satir,sutun;
        Scanner scanner=new Scanner(System.in);
        //alan 100 sayısı ile dolduruluyor;
        alanDoldur();

        //mayınlar rasstgele yerleştiriliyor
        mayinYerlestir((row * colum) / 4);
        while (devam){

            //mayın olmayan yerde etrafındaki mayın sayılarını yazdırdık. tekrar aynı yerlerin seçilmemesi için do while dongusu kullandım
            do{
                System.out.print("Satir index : ");
                satir=scanner.nextInt();
                System.out.print("Sutun index ");
                sutun=scanner.nextInt();
            }while (alan[satir][sutun]<100);



            devam=tercih(satir,sutun);
            print();

            //eger tüm boş alanlar seçilirse kazanılır.
            if(hesap==toplam){
                System.out.println("Kazandınız!");
                devam=false;
            }
        }


    }

    //alanı doldurmak
    static void alanDoldur() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                alan[i][j] = 100;
            }
        }
    }


    //alanı yazdırmak
    static void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (alan[i][j] == 100 || alan[i][j] == 101) {
                    System.out.print(" [X] ");
                } else {
                    System.out.print(" [" + alan[i][j] + "] ");
                }


            }
            System.out.println();
        }
    }

    //alana mayın yerleştirmek
    static void mayinYerlestir(int mayinSayisi) {

        Random r = new Random();
        for (int i = 0; i < mayinSayisi; i++) {
            int satir = r.nextInt(row);
            int sutun = r.nextInt(colum);
            if (alan[satir][sutun] == 101) {
                i--;
            } else {
                alan[satir][sutun] = 101;
            }

        }

    }

    //kişinin seçmek istediği yeri kontrol eden. boş olması durumda etrafındaki mayın saryisini  bulan fonksiyon
    static boolean tercih(int satir, int sutun) {

        if (alan[satir][sutun] != 101 || alan[satir][sutun]==100) {

            int sayi = 0;
            if (satir == 0) {
                if (sutun == 0) {
                    if (alan[satir][sutun + 1] == 101) {
                        sayi++;
                    }
                    if (alan[satir + 1][sutun] == 101) {
                        sayi++;
                    }
                    if (alan[satir + 1][sutun + 1] == 101) {
                        sayi++;
                    }
                }
                if (sutun == colum - 1) {
                    if (alan[satir][sutun - 1] == 101) {
                        sayi++;
                    }
                    if (alan[satir + 1][sutun] == 101) {
                        sayi++;
                    }
                    if (alan[satir + 1][sutun - 1] == 101) {
                        sayi++;
                    }
                }


            }
             if(satir==row-1){
                if (sutun == 0) {
                    if (alan[satir][sutun + 1] == 101) {
                        sayi++;
                    }
                    if (alan[satir - 1][sutun] == 101) {
                        sayi++;
                    }
                    if (alan[satir - 1][sutun + 1] == 101) {
                        sayi++;
                    }
                }
                if(sutun==colum-1){
                    if (alan[satir][sutun - 1] == 101) {
                        sayi++;
                    }
                    if (alan[satir - 1][sutun] == 101) {
                        sayi++;
                    }
                    if (alan[satir - 1][sutun - 1] == 101) {
                        sayi++;
                    }
                }
            }
             if((sutun==0) && (satir!=0) &&(satir!=row-1)){
                 if (alan[satir][sutun+1]==101){
                     sayi++;
                 }
                 if(alan[satir+1][sutun]==101){
                     sayi++;
                 }
                 if(alan[satir-1][sutun]==101){
                     sayi++;
                 }
                 if(alan[satir+1][sutun+1]==101){
                     sayi++;
                 }
                 if(alan[satir-1][sutun+1]==101){
                     sayi++;
                 }

             }
            if((sutun==colum-1) && (satir!=0) &&(satir!=row-1)){
                if (alan[satir][sutun-1]==101){
                    sayi++;
                }
                if(alan[satir+1][sutun]==101){
                    sayi++;
                }
                if(alan[satir-1][sutun]==101){
                    sayi++;
                }
                if(alan[satir+1][sutun-1]==101){
                    sayi++;
                }
                if(alan[satir-1][sutun-1]==101){
                    sayi++;
                }

            }
            if(satir==0 && sutun!=0 && sutun!=colum-1){
                if(alan[satir][sutun+1]==101){
                    sayi++;
                }
                if(alan[satir][sutun-1]==101){
                    sayi++;
                }
                if(alan[satir+1][sutun]==101){
                    sayi++;
                }
                if(alan[satir+1][sutun+1]==101){
                    sayi++;
                }
                if(alan[satir+1][sutun-1]==101){
                    sayi++;
                }
            }
            if(satir==row-1 && sutun!=0 && sutun!=colum-1){
                if(alan[satir][sutun+1]==101){
                    sayi++;
                }
                if(alan[satir][sutun-1]==101){
                    sayi++;
                }
                if(alan[satir-1][sutun]==101){
                    sayi++;
                }
                if(alan[satir-1][sutun+1]==101){
                    sayi++;
                }
                if(alan[satir-1][sutun-1]==101){
                    sayi++;
                }
            }
            if(satir!=0 && satir!=row-1 && sutun!=0 && sutun!=colum-1){
                if(alan[satir][sutun+1]==101){
                    sayi++;
                }
                if(alan[satir][sutun-1]==101){
                    sayi++;
                }
                if(alan[satir-1][sutun]==101){
                    sayi++;
                }
                if(alan[satir+1][sutun]==101){
                    sayi++;
                }
                if(alan[satir+1][sutun-1]==101){
                    sayi++;
                }
                if(alan[satir+1][sutun+1]==101){
                    sayi++;
                }

                if(alan[satir-1][sutun+1]==101){
                    sayi++;
                }
                if(alan[satir-1][sutun-1]==101){
                    sayi++;
                }
            }



            alan[satir][sutun] = sayi;



            return true;
        }
        System.out.println("Kaybettiniz!!");
        System.out.println("Sectiğiniz bölgede mayın vardi : "+alan[satir][sutun]);
        return false;
    }
}


