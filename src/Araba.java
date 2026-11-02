public class Araba {
	private String model;
	private int hp;               // Genel araba özellikleri
	private double fiyat;

	// Ekstra özellikler
	private boolean nosVarmi;     // NOS var mı?
	private int enYuksekHiz;      // Maksimum hız
	private double dayaniklilik;  // Arabanın dayanıklılığı
	private String renk;          // Arabanın rengi
    private boolean bodyKitVarmi;


//Kurucu metodlar

public Araba(String model, int hp, double fiyat, int enYuksekHiz, String renk) {
    this(model, hp, fiyat, enYuksekHiz, renk, false, false, 100.0);
}

public Araba(String model, int hp, double fiyat, int enYuksekHiz, String renk,
             boolean bodyKitVarmi, boolean nosVarmi, double dayaniklilik) {
    this.model = model;
    this.hp = hp;
    this.fiyat = fiyat;
    this.enYuksekHiz = enYuksekHiz;
    this.renk = renk;
    this.bodyKitVarmi = bodyKitVarmi;
    this.nosVarmi = nosVarmi;
    this.dayaniklilik = Math.max(0.0, Math.min(100.0, dayaniklilik));
}


public void bilgileriGoster() {
    System.out.println("====================================");
        System.out.println("  ARAC: " + model + " (" + renk + ")");
        System.out.println("====================================");
        System.out.println("  Beygir Gucu (HP) : " + hp);
        System.out.println("  Maksimum Hiz     : " + enYuksekHiz + " km/s");
        System.out.println("  NOS Durumu       : " + (nosVarmi ? "VAR" : "YOK"));
        System.out.println("  Kondisyon        : %" + dayaniklilik);
        System.out.println("  Piyasa Degeri    : " + fiyat + " TL");
        System.out.println("====================================\n");
}

// 4. Aksiyon metotları tanımlama :))

public void bodyKitUygula() {
    if (!bodyKitVarmi) {
        bodyKitVarmi = true;
        this.enYuksekHiz += 15;      // Aerodinamik iyileşir, son hız artar
        this.dayaniklilik = Math.min(100.0, this.dayaniklilik + 10.0); // Fiber gövde dayanıklılığı artırır
        System.out.println(model + " aracina agresif Body Kit uygulandi! (+15 Hiz, +10 Dayaniklilik)");
    }
    else {
        System.out.println("Bu araçta zaten Body Kit var!");
    }
}

public void nosTak(){
  
    if(!nosVarmi){
        nosVarmi = true;
        hp += 30;
        enYuksekHiz += 20;
        System.out.println(model + " aracina NOS takildi (+30 beygir ve +20 km/s hiz).");
    } else {
        System.out.println("Bu araçta nos takılı");
    }
}

public void hasarAl(double miktar){
        if (!Double.isFinite(miktar) || miktar <= 0.0) {
            System.out.println("Hasar miktari pozitif ve gecerli olmalidir.");
            return;
        }
        dayaniklilik = Math.max(0.0, dayaniklilik - miktar);
         System.out.println(model  + " " + miktar + " derece hasar aldi. Kalan dayaniklilik: %" + dayaniklilik);
    }

    public void tamirEt() {
        dayaniklilik = 100.0;
        System.out.println(model + " tamamen tamir edildi! Kondisyon: %100");
    }

    // 5. Getter ve Setter Metodları (Erişim Kapıları)
    public String getModel() {
        return model;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
 
    public boolean isBodyKitVarmi() {
    return bodyKitVarmi;
}

    public boolean isNosVarmi() {
        return nosVarmi;
    }

    public int getEnYuksekHiz() {
        return enYuksekHiz;
    }

    public void setEnYuksekHiz(int enYuksekHiz) {
        this.enYuksekHiz = enYuksekHiz;
    }

    public double getDayaniklilik() {
        return dayaniklilik;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }
}
