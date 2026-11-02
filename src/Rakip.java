public class Rakip {
    // 1. Özellikler (Private Fields)
    private String adSoyad;
    private String nickname;
    private String arabaModeli;
    private int hp;
    private int enYuksekHiz;
    private String diyalog;
    private int seviye; // 1'den 6'ya kadar olan zorluk sıralaması

    // 2. Kurucu Metod (Constructor)
    public Rakip(String adSoyad, String nickname, String arabaModeli, int hp, int enYuksekHiz, String diyalog, int seviye) {
        this.adSoyad = adSoyad;
        this.nickname = nickname;
        this.arabaModeli = arabaModeli;
        this.hp = hp;
        this.enYuksekHiz = enYuksekHiz;
        this.diyalog = diyalog;
        this.seviye = seviye;
    }

    // 3. Yarış Öncesi Laf Atma Metodu (Hikaye Atmosferi)
    public void diyalogSoyle() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("🔥 [RAKİP " + seviye + "] " + nickname + " (" + adSoyad + ") Sana Sesleniyor:");
        System.out.println("\"" + diyalog + "\"");
        System.out.println("--------------------------------------------------");
    }

    // 4. Rakip Künyesini Gösterme Metodu
    public void bilgileriGoster() {
        System.out.println("====================================");
        System.out.println("  SEVİYE " + seviye + " RAKİP: " + nickname);
        System.out.println("====================================");
        System.out.println("  Sürücü     : " + adSoyad);
        System.out.println("  Araç       : " + arabaModeli);
        System.out.println("  Motor Gücü : " + hp + " HP");
        System.out.println("  Maksimum Hız: " + enYuksekHiz + " km/s");
        System.out.println("====================================\n");
    }

    // 5. Getter Metodları (Bilgileri Dışarıya Okutma)
    public String getAdSoyad() {
        return adSoyad;
    }

    public String getNickname() {
        return nickname;
    }

    public String getArabaModeli() {
        return arabaModeli;
    }

    public int getHp() {
        return hp;
    }

    public int getEnYuksekHiz() {
        return enYuksekHiz;
    }

    public String getDiyalog() {
        return diyalog;
    }

    public int getSeviye() {
        return seviye;
    }
}