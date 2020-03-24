
package sporcubilgisistemi;

import javax.swing.JTextArea;

public class DoublyLinkedList 
{
    public static Node head;
    public static Node tail;
    public static int size;
    
    public  DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean bosMu()
    {
        return (head == null);
    }
    
    public int getSize()
    {
        return this.size;
    }
    
    public static void elemanEkle(Bilgi bilgi)/*Listeye yeni bir eleman eklemek
            için oluşturulmuş bir metot*/
    {
        Node yeniDugum = new Node(bilgi,null,null);/*listeye eklenecek 
        eleman için bir düğüm oluşturulur*/
        Node Dugum1,Dugum2; /*listeye yeni düğümü eklemek için kullanılacak
        yardımıcı düğümler*/
        boolean tercih = false; /*yeni düğümü eklemek için while döngüsüne
        girerse en son seçeneğe( if(!tercih) denkliğine) girmemesi için
        oluşturulmuş bir boolean değişkeni*/
        if(head==null)/*eğer liste boş ise*/
        {
            head=tail=yeniDugum;
        }
        else if(bilgi.getAdSoyad().toUpperCase().
                compareTo(head.getBilgi().getAdSoyad().toUpperCase())<=0)
        {
            yeniDugum.setSonraki(head);
            head.setOnceki(yeniDugum);
            head=yeniDugum;
        }
        else
        {
            Dugum1 = head;
            Dugum2 = head.getSonraki();
            while(Dugum2!=null)
            {
                if(bilgi.getAdSoyad().toUpperCase().
                   compareTo(Dugum1.getBilgi().getAdSoyad().toUpperCase())>=0
                   && bilgi.getAdSoyad().toUpperCase().
                   compareTo(Dugum2.getBilgi().getAdSoyad().toUpperCase())<=0)
                {
                    Dugum1.setSonraki(yeniDugum);
                    yeniDugum.setOnceki(Dugum1);
                    yeniDugum.setSonraki(Dugum2);
                    Dugum2.setOnceki(yeniDugum);
                    tercih = true;
                    break;
                    
                }
                else
                {
                    Dugum1 = Dugum2;
                    Dugum2 = Dugum2.getSonraki();
                }
            }
            if(!tercih)
            {
                Dugum1.setSonraki(yeniDugum);
                yeniDugum.setOnceki(Dugum1);
            }
        }
        size++;
    }
    
    public static void elemanSil(String adSoyad)
    {
        adSoyad = adSoyad.toUpperCase();
        Node basla = head;
        sonElemanBul();
        while(basla!=null)
        {
            if(adSoyad.equals(basla.getBilgi().getAdSoyad().toUpperCase()))
            {
                Node gecici = basla;
                if(basla==head)
                {
                    head=head.getSonraki();
                    head.setOnceki(null);
                    return;
                }
                else if(basla==tail)
                {
                    tail=tail.getOnceki();
                    tail.setSonraki(null);
                    return;
                }
                else
                {
                    gecici.getSonraki().setOnceki(gecici.getOnceki());
                    gecici.getOnceki().setSonraki(gecici.getSonraki());
                    return;
                }
                
            }
            size--;
            basla = basla.getSonraki();
            
        }
    }
    
    public static void sonElemanBul()/*Listenin sondaki elemanını bulmak için 
            oluşturulmuş bir metot*/
    {
        Node dugum = head;
        while(dugum.getSonraki()!=null)
        {
            dugum = dugum.getSonraki();
        }
        
        if(dugum.getSonraki()==null)
        {
            tail=dugum;
        }
    }
    
    public static void elemanCagir(JTextArea textarea,String adSoyad)/*girilen
            sporcunun ad ve soyadına göre bilgilerini bulur.*/
    {
        adSoyad = adSoyad.toUpperCase();/*büyük küçük harf ayrımını engellemek
        için yapıldı.*/
        Node dugum = head;
        while(dugum!=null)
        {
            if(adSoyad.equals(dugum.getBilgi().getAdSoyad().toUpperCase()))
            {
                textarea.setText(dugum.getBilgi().toString());
                return;
            }
            dugum = dugum.getSonraki();
        }
        if(dugum==null)
        {
            textarea.setText("Bu kişi listede ekli değil!");
        }
    }
    
    public static void bastanYazdir(JTextArea textarea) /*Oluşturulan ilgili
            listenin elemanlarını A'dan Z'ye doğru sıralar.*/
    {

        Node dugum = head;
        textarea.setText(dugum.getBilgi().toString());
        dugum = dugum.getSonraki();
        while(dugum!=null)
        {
            textarea.setText(textarea.getText()+"\n"
                    +dugum.getBilgi().toString());
            dugum = dugum.getSonraki();
        }  
        
    }
    
    public static void sondanYazdir(JTextArea textarea)  /*Oluşturulan ilgili
            listenin elemanlarını Z'den A'ya doğru sıralar.*/
    { 
        sonElemanBul();
        Node dugum = tail;
        textarea.setText(dugum.getBilgi().toString());
        dugum = dugum.getOnceki();
        while(dugum!=null)
        {
            textarea.setText(textarea.getText()+
                    "\n"+dugum.getBilgi().toString());
            dugum = dugum.getOnceki();
        }
    }
    
}
