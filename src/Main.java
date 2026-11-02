import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Garaj garaj = new Garaj();

        System.out.println("==================================================");
        System.out.println("🔥 SOKAK YARIŞI: MAHALLE GARAJI & MODİFİYE 🔥");
        System.out.println("==================================================");
        System.out.println("Gecenin karanlığı mahalleyi sararken, neon lambaların altında");
        System.out.println("egzoz kokulu o eski sanayi sokağındasın. Adını caddelere");
        System.out.println("kazımak ve mahallenin en büyük kralı olmak için ellerin direksiyonda...");
        System.out.println("--------------------------------------------------\n");

        // Giriş ve kullanıcı verileri alma
        System.out.print("Sürücü adın ne? : ");
        String ad = scan.nextLine();
        System.out.print("Soyadın     : ");
        String soyad = scan.nextLine();
        System.out.print("Sokaklardaki lakabın (Nickname) ne olacak? : ");
        String nickname = scan.nextLine();

        // İlk başlangıç arabası ve oyuncu nesnesi oluşturuluyor
        Araba ilkAraba = new Araba("Honda 1.6 iES", 120, 350000.0, 210, "Kırmızı");
        Oyuncu oyuncu = new Oyuncu(ad, soyad, nickname, 15000.0, ilkAraba);

        System.out.println("\n[SİSTEM]: Garajın tozlu köşesindeki 1998 model Honda'nın anahtarı cebine verildi.");
        System.out.println("Cüzdanında ilk yarışlar ve benzin için 15.000 TL nakit var. Mahalle seni bekliyor!\n");

        // --- 6 ADET RAKİP TANIMLAMASI ---
        Rakip[] rakipler = new Rakip[6];
        rakipler[0] = new Rakip("Celal Demir", "Tofaşçı Celal", "Murat 131 Şahin", 85, 160, "O egzoz borusu ne la öyle tencere kapağı gibi, mahallenin sesinden uyuyamıyoruz!", 1);
        rakipler[1] = new Rakip("Kaan Korkmaz", "Yanlayan Kaan", "BMW E30 3.20i", 150, 220, "Düzlükte tozumu yutarsın koçum, viraja gelince arkadan itişin keyfini izle!", 2);
        rakipler[2] = new Rakip("Selim VTEC", "VTEC Selim", "Honda Civic VTI", 175, 235, "VTEC açtığım sesi duyunca arabayı kenara çekip ağlayacaksın!", 3);
        rakipler[3] = new Rakip("Efe Aksoy", "Turbo Efe", "Mitsubishi Lancer 1.8", 210, 250, "Turbo basıncını bi açtım mı arkamdaki plakamı bile okuyamayacaksın.", 4);
        rakipler[4] = new Rakip("Murat Şahin", "Gececi Murat", "Mazda RX-7", 260, 275, "Gece yarışlarının efsanesiyiz oğlum, bu garajın suyunu biz içtik.", 5);
        rakipler[5] = new Rakip("Ahmet Karbon", "Karbon Ahmet", "Nissan GT-R R35", 350, 310, "Sen daha çıraksın çocuk. Caddelerin tek kralı var, o da benim!", 6);

        // --- OYUN DÖNGÜSÜ (MENÜ) ---
        boolean oyunDevamEdiyor = true;
        while(oyunDevamEdiyor){
            System.out.println("\n================ ANA MENÜ ================");
            System.out.println("1 - Profilimi ve Arabamı Göster");
            System.out.println("2 - Garaj & Galeri (Modifiye / Araba Satın Al)");
            System.out.println("3 - Rakipleri Listele & Piste Çık");
            System.out.println("0 - Oyundan Çık");
            System.out.print("Seçimin nedir patron? : ");

            int secim = scan.nextInt();
            switch (secim){
                case 1:
                    oyuncu.profilGoster();
                    break;
                case 2:
                    // Garaj ve Galeri Menüsü
                    boolean garajda = true;
                    while (garajda) {
                        System.out.println("\n--- SANAYİ GARAJI & GALERİ ---");
                        System.out.println("1 - Arabayı Tamir Et (1.500 TL)");
                        System.out.println("2 - NOS Kiti Tak (+30 HP, +20 Hız) [5.000 TL]");
                        System.out.println("3 - Body Kit Uygula (+15 Hız, +10 Dayanıklılık) [3.500 TL]");
                        System.out.println("4 - Araba Galerisi (Yeni Araba Al)");
                        System.out.println("0 - Ana Menüye Dön");
                        System.out.print("Garaj işlem seçimin: ");
                        int garajSecim = scan.nextInt();

                        if (garajSecim == 1) {
                            garaj.arabaTamirEt(oyuncu);
                        } else if (garajSecim == 2) {
                            garaj.nosSatınAl(oyuncu);
                        } else if (garajSecim == 3) {
                            garaj.bodyKitSatınAl(oyuncu);
                        } else if (garajSecim == 4) {
                            // Galeri Seçenekleri
                            System.out.println("\n--- GALERİ: YENİ ARAÇLAR ---");
                            System.out.println("1 - BMW E30 (HP: 150, Fiyat: 12.000 TL)");
                            System.out.println("2 - Honda Civic VTI (HP: 175, Fiyat: 25.000 TL)");
                            System.out.print("Hangi arabayı almak istiyorsun? (0 - İptal): ");
                            int arabaSecim = scan.nextInt();

                            if (arabaSecim == 1) {
                                if (oyuncu.bakiyeHarca(12000.0)) {
                                    Araba yeniArac = new Araba("BMW E30", 150, 450000.0, 220, "Siyah");
                                    oyuncu.setAraba(yeniArac);
                                    System.out.println("Tebrikler! Yeni BMW E30'un garaja çekildi!");
                                } else {
                                    System.out.println("Cüzdandaki para bu araca yetmiyor!");
                                }
                            } else if (arabaSecim == 2) {
                                if (oyuncu.bakiyeHarca(25000.0)) {
                                    Araba yeniArac = new Araba("Honda Civic VTI", 175, 600000.0, 235, "Beyaz");
                                    oyuncu.setAraba(yeniArac);
                                    System.out.println("Tebrikler! VTI caddelerin tozunu atmaya hazır!");
                                } else {
                                    System.out.println("Cüzdandaki para bu araca yetmiyor!");
                                }
                            }
                        } else if (garajSecim == 0) {
                            garajda = false;
                        } else {
                            System.out.println("Geçersiz işlem!");
                        }
                    }
                    break;
                case 3:
                    // Rakip Listesi ve Yarış Alanı
                    System.out.println("\n--- SOKAK YARIŞI PİSTİ: RAKİPLER ---");
                    for (int i = 0; i < rakipler.length; i++) {
                        System.out.println((i + 1) + ". Rakip: " + rakipler[i].getNickname() + " (" + rakipler[i].getArabaModeli() + ") - Seviye " + rakipler[i].getSeviye());
                    }
                    System.out.print("Hangi rakiple yarışmak istiyorsun? (1-6) (Çıkış için 0): ");
                    int rakipSecim = scan.nextInt();

                    if (rakipSecim >= 1 && rakipSecim <= 6) {
                        Rakip secilenRakip = rakipler[rakipSecim - 1];
                        secilenRakip.diyalogSoyle();
                        secilenRakip.bilgileriGoster();
                        
                        System.out.print("Gazı kökleyip piste çıkmaya hazır mısın? (1 - Evet, 0 - Vazgeç): ");
                        int basla = scan.nextInt();
                        if (basla == 1) {
                            yarisBaslat(oyuncu, secilenRakip);
                        }
                    } else if (rakipSecim == 0) {
                        System.out.println("Pitten çıkılıyor...");
                    } else {
                        System.out.println("Geçersiz rakip numarası!");
                    }
                    break;
                case 0:
                    System.out.println("Sokaklardan kaçıyorsun ha? Görüşmek üzere patron!");
                    oyunDevamEdiyor = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
        scan.close();
    }

    // --- ANİMASYONLU YARIŞ SİMÜLASYONU METODU ---
    public static void yarisBaslat(Oyuncu oyuncu, Rakip rakip) {
        System.out.println("\n==================================================");
        System.out.println("🏁 IŞIKLAR SÖNDÜ, YARIŞ BAŞLADI! 🏁");
        System.out.println("==================================================");
        System.out.println(oyuncu.getNickname() + " (" + oyuncu.getAraba().getModel() + ") vs " + rakip.getNickname() + " (" + rakip.getArabaModeli() + ")\n");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int bitisCizgisi = 30;
        int oyuncuPozisyonu = 0;
        int rakipPozisyonu = 0;

        while (oyuncuPozisyonu < bitisCizgisi && rakipPozisyonu < bitisCizgisi) {
            int oyuncuHizLAN = (int)(Math.random() * 3) + (oyuncu.getAraba().getHp() / 45);
            int rakipHizLAN = (int)(Math.random() * 3) + (rakip.getHp() / 45);

            oyuncuPozisyonu += oyuncuHizLAN;
            rakipPozisyonu += rakipHizLAN;

            if (oyuncuPozisyonu > bitisCizgisi) oyuncuPozisyonu = bitisCizgisi;
            if (rakipPozisyonu > bitisCizgisi) rakipPozisyonu = bitisCizgisi;

            System.out.println("\n--- PİSTTE ANLIK DURUM ---");
            
            System.out.print(oyuncu.getNickname() + " |");
            for (int i = 0; i < oyuncuPozisyonu; i++) System.out.print("-");
            System.out.println("🚗💨");

            System.out.print(rakip.getNickname() + " |");
            for (int i = 0; i < rakipPozisyonu; i++) System.out.print("-");
            System.out.println("🏎️💨");

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n================ YARIŞ SONUCU ================");
        if (oyuncuPozisyonu >= bitisCizgisi && oyuncuPozisyonu >= rakipPozisyonu) {
            System.out.println("🎉 HELAL OLSUN KOÇUM! Çizgiyi ilk sen geçtiğin için yarışı kazandın!");
            double odul = rakip.getSeviye() * 3000.0;
            oyuncu.bakiyeEkle(odul);
        } else {
            System.out.println("😢 Maalesef bu sefer rakip tozunu yutturdu! Sanayiye dönüp motoru açman lazım.");
        }
        System.out.println("===============================================\n");
    }
}