
package sporcubilgisistemi;

import java.util.ArrayList;

public class Bilgi {
    String adSoyad;
    Date dogumTarihi;
    ArrayList<String> kulupler;
    
    public Bilgi(){
        adSoyad = null;
        dogumTarihi = null;
        kulupler = null;
    }
    
    public Bilgi(String adSoyad,Date dogumTarihi,ArrayList<String> kulupler)
    {
        this.adSoyad = adSoyad;
        this.dogumTarihi = dogumTarihi;
        this.kulupler = kulupler;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(int day,int month,int year) {
        this.dogumTarihi = new Date(day,month,year);
    }


    public String getKulupler() {
        String cikti = "";
        cikti += kulupler.get(0);
        for(int i=1;i<kulupler.size();i++)
        {
            cikti+= ", "+kulupler.get(i);
        }
        return cikti;
    }

    public void setKulupler(ArrayList<String> kulupler) {
        this.kulupler = kulupler;
    }
    
    @Override
    public String toString()
    {
        return getAdSoyad() +", "+ getDogumTarihi() +", "+ getKulupler();
    }

}
