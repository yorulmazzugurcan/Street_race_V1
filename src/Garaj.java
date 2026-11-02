public class Garaj {
    
    // 1. Araba Tamir Etme İşlemi
    public void arabaTamirEt(Oyuncu oyuncu) {
        double tamirUcreti = 1500.0;
        System.out.println("\n--- SANAYİ & GARAJ: TAMİR BÖLÜMÜ ---");
        if (oyuncu.getAraba() == null) {
            System.out.println("Tamir icin garajinda bir aracin olmali.");
            return;
        }
        
        if (oyuncu.getAraba().getDayaniklilik() >= 100.0) {
            System.out.println("Araban zaten zımba gibi, tamire ihtiyacı yok!");
            return;
        }

        System.out.println("Tamir Bedeli: " + tamirUcreti + " TL");
        
        if (oyuncu.bakiyeHarca(tamirUcreti)) {
            oyuncu.getAraba().tamirEt();
            System.out.println("Tamir başarılı! Yol devam.");
        } else {
            System.out.println("Cüzdanda para yetersiz, yolda kalmaya devam edeceksin!");
        }
    }

    // 2. NOS Satın Alınması
    public void nosSatınAl(Oyuncu oyuncu) {
        double nosFiyati = 5000.0;
        System.out.println("\n--- GARAJ: MODİFİYE DÜKKANI (NOS) ---");
        if (oyuncu.getAraba() == null) {
            System.out.println("NOS takmak icin garajinda bir aracin olmali.");
            return;
        }

        if (oyuncu.getAraba().isNosVarmi()) {
            System.out.println("Zaten aracında NOS takılı!");
            return;
        }

        System.out.println("NOS Kiti Fiyatı: " + nosFiyati + " TL (+30 HP, +20 Hız)");

        if (oyuncu.bakiyeHarca(nosFiyati)) {
            oyuncu.getAraba().nosTak();
            System.out.println("Tebrikler! Roket gibi oldun.");
        } else {
            System.out.println("Para yetmediği için NOS alamadın.");
        }
    }

    // 3. YENİ: Body Kit (Gövde Kiti) Modifiyesi
    public void bodyKitSatınAl(Oyuncu oyuncu) {
        double bodyKitFiyati = 3500.0;
        System.out.println("\n--- GARAJ: KAPORTA & BODY KİT ---");
        if (oyuncu.getAraba() == null) {
            System.out.println("Body Kit uygulamak icin garajinda bir aracin olmali.");
            return;
        }

        if (oyuncu.getAraba().isBodyKitVarmi()) {
            System.out.println("Aracında zaten profesyonel Body Kit var, daha ne olsun!");
            return;
        }

        System.out.println("Widebody / Aerodinamik Kit Fiyatı: " + bodyKitFiyati + " TL (+15 Son Hız, +10 Dayanıklılık)");

        if (oyuncu.bakiyeHarca(bodyKitFiyati)) {
            oyuncu.getAraba().bodyKitUygula();
            System.out.println("Şekle geldin koçum! Arabanın kalıbı değişti.");
        } else {
            System.out.println("Bakiye yetersiz! Sanayide çırak kalmaya devam.");
        }
    }
}