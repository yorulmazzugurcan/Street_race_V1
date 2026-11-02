public class Oyuncu {
    private String ad;
    private String soyad;
    private String nickname;
    private double bakiye;
    private Araba araba;

    // Constructor
    public Oyuncu(String ad, String soyad, String nickName, double bakiye, Araba araba) {
        this.ad = ad;
        this.soyad = soyad;
        this.nickname = nickName;
        setBakiye(bakiye);
        this.araba = araba;
    }

    //PROFİL GÖSTERME METODU
    public void profilGoster() {
        System.out.println("====================================");
        System.out.println("  OYUNCU PROFİLİ: " + this.nickname);
        System.out.println("====================================");
        System.out.println("  Ad Soyad   : " + ad + " " + soyad);
        System.out.println("  Bakiye     : " + bakiye + " TL");
        System.out.println("------------------------------------");
        if (araba != null) {
            System.out.println("  Garajdaki Araç: " + araba.getModel() + " (" + araba.getRenk() + ")");
            System.out.println("  Motor Gücü    : " + araba.getHp() + " HP");
        } else {
            System.out.println("  Garajdaki Araç: Henüz araba yok!");
        }
        System.out.println("====================================\n");
    }


    public boolean bakiyeEkle(double miktar) {
        if (!Double.isFinite(miktar) || miktar <= 0.0) {
            System.out.println("Eklenecek miktar pozitif ve gecerli olmalidir.");
            return false;
        }
        if (!Double.isFinite(bakiye + miktar)) {
            System.out.println("Bakiye bu miktar eklenerek guncellenemiyor.");
            return false;
        }
        bakiye += miktar;
        System.out.println(miktar + " TL kazanildi. Yeni bakiye: " + bakiye + " TL");
        return true;
    }

    public boolean bakiyeHarca(double miktar) {
        if (!Double.isFinite(miktar) || miktar <= 0.0) {
            System.out.println("Harcama miktari pozitif ve gecerli olmalidir.");
            return false;
        }
        if (bakiye < miktar) {
            System.out.println("Yetersiz Bakiye! Gereken: " + miktar + " TL, Mevcut: " + bakiye + " TL");
            return false;
        }
        bakiye -= miktar;
        System.out.println(miktar + " TL harcandi. Kalan bakiye: " + bakiye + " TL");
        return true;
    }
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        if (!Double.isFinite(bakiye) || bakiye < 0.0) {
            throw new IllegalArgumentException("Bakiye negatif veya gecerli olmayan bir deger olamaz.");
        }
        this.bakiye = bakiye;
    }

    public Araba getAraba() {
        return araba;
    }

    public void setAraba(Araba araba) {
        this.araba = araba;
    }

}