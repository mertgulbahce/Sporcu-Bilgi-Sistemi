package sporcubilgisistemi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SporcuBilgiFormu extends javax.swing.JFrame {

    private DoublyLinkedList sporcuBilgi;

    public SporcuBilgiFormu() throws IOException 
    {
        initComponents();
        setTitle("SPORCU BİLGİ SİSTEMİ");
        dosyaOku();
    }

    public DoublyLinkedList dosyaOku() throws IOException 
            /*sporcu dosyası içindeki kişiler okunup sporcuBilgi adlı doublylinkedlist'e atanır.*/
             
    {
        DoublyLinkedList sporcuBilgi = new DoublyLinkedList();
        Scanner File = null;
        try 
        {
            File dosya = new File("sporcu.txt");
            String satirArray[];
            BufferedReader okuyucu = new BufferedReader(new FileReader(dosya));
            String satir;
            while ((satir = okuyucu.readLine()) != null) 
            {
                satirArray = satir.split(", ");
                System.out.println(satir);
                Bilgi sporcu = new Bilgi();
                sporcu.setAdSoyad(satirArray[0]);
                String dogumTarihiArray[] = satirArray[1].split("/");
                ArrayList<String> kulupler = new ArrayList<String>();
                int tarihArray[] = new int[dogumTarihiArray.length];
                for (int i = 0; i < dogumTarihiArray.length; i++) {
                    tarihArray[i] = Integer.parseInt(dogumTarihiArray[i]);
                }
                sporcu.setDogumTarihi(tarihArray[0], tarihArray[1], tarihArray[2]);
                System.out.println(sporcu.dogumTarihi.toString());
                for (int x = 2;x<satirArray.length;x++){
                    kulupler.add(satirArray[x]);
                }
                sporcu.setKulupler(kulupler);
                sporcuBilgi.elemanEkle(sporcu);
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Dosya Bulunamadı.");
            System.exit(0);
        }

        return this.sporcuBilgi;
    }
    
    public void dosyayiGüncelle(DoublyLinkedList sporcuBilgi)
    {
        try
        {
            File dosya = new File("sporcu.txt");
            FileWriter dosyaYazici = new FileWriter(dosya,false);
            BufferedWriter yazdir = new BufferedWriter(dosyaYazici);
            Node dugum = sporcuBilgi.head;
            while(dugum!=null)
            {
                yazdir.write(dugum.getBilgi().toString());
                dugum = dugum.getSonraki();
                yazdir.newLine();
            }
            yazdir.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Dosya Bulunamadı.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabelSporcuEkleAdSoyad = new javax.swing.JLabel();
        jLabelSporcuEkleDogumTarihi = new javax.swing.JLabel();
        jTextFieldSporcuEkleAdSoyad = new javax.swing.JTextField();
        jTextFieldSporcuEkleDogumTarihi = new javax.swing.JTextField();
        jLabelSporcuEkleOynadigiKulupler = new javax.swing.JLabel();
        jTextFieldSporcuEkleOynadigiKulupler = new javax.swing.JTextField();
        jButtonSporcuyuEkle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelSporcuBulAdSoyad = new javax.swing.JLabel();
        jTextFieldSporcuBulAdSoyad = new javax.swing.JTextField();
        jButtonSporcuyuBul = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSporcuBul = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabelSporcuSilAdSoyad = new javax.swing.JLabel();
        jTextFieldSporcuSilAdSoyad = new javax.swing.JTextField();
        jButtonSporcuyuSil = new javax.swing.JButton();
        jButtonZA = new javax.swing.JButton();
        jButtonAZ = new javax.swing.JButton();
        jButtonCikis = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaSporcuBilgileriSirala = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sporcu Ekle", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setToolTipText("");

        jLabelSporcuEkleAdSoyad.setText("Ad-Soyad :");

        jLabelSporcuEkleDogumTarihi.setText("Doğum Tarihi :");

        jLabelSporcuEkleOynadigiKulupler.setText("Oynadığı Kulüpler :");

        jButtonSporcuyuEkle.setText("Sporcuyu Ekle");
        jButtonSporcuyuEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSporcuyuEkleActionPerformed(evt);
            }
        });

        jLabel1.setText("*Birden fazla kulüp girişi yapılacak ise kulüp adları arasına virgül koyunuz.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelSporcuEkleAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldSporcuEkleAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSporcuEkleDogumTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSporcuEkleOynadigiKulupler))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSporcuEkleOynadigiKulupler, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldSporcuEkleDogumTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(200, 200, 200))
                    .addComponent(jButtonSporcuyuEkle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonSporcuyuEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSporcuEkleAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSporcuEkleAdSoyad))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSporcuEkleDogumTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSporcuEkleDogumTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSporcuEkleOynadigiKulupler, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSporcuEkleOynadigiKulupler, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(215, 215, 215))
        );

        jLabelSporcuEkleDogumTarihi.getAccessibleContext().setAccessibleName("jLabelSporcuDogumTarihi");
        jTextFieldSporcuEkleAdSoyad.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sporcu Bul", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabelSporcuBulAdSoyad.setText("Ad-Soyad :");

        jButtonSporcuyuBul.setText("Sporcuyu Bul");
        jButtonSporcuyuBul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSporcuyuBulActionPerformed(evt);
            }
        });

        jTextAreaSporcuBul.setColumns(20);
        jTextAreaSporcuBul.setRows(5);
        jScrollPane1.setViewportView(jTextAreaSporcuBul);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelSporcuBulAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldSporcuBulAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSporcuyuBul, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSporcuBulAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSporcuBulAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSporcuyuBul, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sporcu Sil", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabelSporcuSilAdSoyad.setText("Ad-Soyad :");

        jButtonSporcuyuSil.setText("Sporcuyu Sil");
        jButtonSporcuyuSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSporcuyuSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelSporcuSilAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldSporcuSilAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSporcuyuSil, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSporcuSilAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSporcuSilAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSporcuyuSil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonZA.setText("Z'den A'ya Sırala");
        jButtonZA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZAActionPerformed(evt);
            }
        });

        jButtonAZ.setText("A'dan Z'ye Sırala");
        jButtonAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAZActionPerformed(evt);
            }
        });

        jButtonCikis.setText("Çıkış");
        jButtonCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCikisActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sporcu Bilgileri", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTextAreaSporcuBilgileriSirala.setColumns(20);
        jTextAreaSporcuBilgileriSirala.setRows(5);
        jScrollPane4.setViewportView(jTextAreaSporcuBilgileriSirala);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAZ, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonZA, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCikis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonZA, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAZ, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCikis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonZAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZAActionPerformed
        sporcuBilgi.sondanYazdir(jTextAreaSporcuBilgileriSirala);
        /*Oluşturulan doublylinkedlistin
        elemanlarını Z'den A'ya doğru metin alanına yazdırır. yazdırır.*/
    }//GEN-LAST:event_jButtonZAActionPerformed

    private void jButtonAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAZActionPerformed
        sporcuBilgi.bastanYazdir(jTextAreaSporcuBilgileriSirala);
        /*Oluşturulan doublylinkedlistin
        elemanlarını alfabetik sıraya göre metin alanına yazdırır.*/

    }//GEN-LAST:event_jButtonAZActionPerformed

    private void jButtonSporcuyuEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSporcuyuEkleActionPerformed
        
        String adSoyad = jTextFieldSporcuEkleAdSoyad.getText();
        String dogumTarihiGecici[];
        dogumTarihiGecici = jTextFieldSporcuEkleDogumTarihi.getText().split("/");
        int dogumTarihiGeciciInt[] = new int[3];
        dogumTarihiGeciciInt[0]= Integer.parseInt(dogumTarihiGecici[0]);
        dogumTarihiGeciciInt[1]= Integer.parseInt(dogumTarihiGecici[1]);
        dogumTarihiGeciciInt[2]= Integer.parseInt(dogumTarihiGecici[2]);
                
        Date dogumtarihi = new Date(dogumTarihiGeciciInt[0],dogumTarihiGeciciInt[1],dogumTarihiGeciciInt[2]);
        
        String kulupler = jTextFieldSporcuEkleOynadigiKulupler.getText();
        
        ArrayList<String> kuluplerArrayList = new ArrayList<>();
        String ayirici[] = kulupler.split(", ");
        for(int i = 0; i<ayirici.length;i++)
        {
            kuluplerArrayList.add(ayirici[i]);
        }
        
        Bilgi bilgi = new Bilgi(adSoyad,dogumtarihi,kuluplerArrayList);
        sporcuBilgi.elemanEkle(bilgi);
        JOptionPane.showMessageDialog(null,adSoyad+" Sporcu listeye eklendi.");
        jTextFieldSporcuEkleAdSoyad.setText("");
        jTextFieldSporcuEkleDogumTarihi.setText("");
        jTextFieldSporcuEkleOynadigiKulupler.setText("");
        
    }//GEN-LAST:event_jButtonSporcuyuEkleActionPerformed

    private void jButtonSporcuyuBulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSporcuyuBulActionPerformed
        String adSoyad = jTextFieldSporcuBulAdSoyad.getText(); /*girilen sporcunun adı ve
        soyadını alır.*/
        sporcuBilgi.elemanCagir(jTextAreaSporcuBul,adSoyad); /*girilen sporcunun ad ve
        soyadına göre sporcuyu bulur.*/
        jTextFieldSporcuBulAdSoyad.setText("");/*girilen sporcuların bilgilerini ekrana 
        yazdırıldıktan sonra metin alanı boşaltılır. */
    }//GEN-LAST:event_jButtonSporcuyuBulActionPerformed

    private void jButtonSporcuyuSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSporcuyuSilActionPerformed
        /*adı ve soyadı girilen sporcunun bilgileri ilgili listeden çıkarılır.*/
        String adSoyad = jTextFieldSporcuSilAdSoyad.getText();
        
        sporcuBilgi.elemanSil(adSoyad);
        JOptionPane.showMessageDialog(null,adSoyad+" "
                + "Sporcusunun bilgileri listeden çıkarıldı");
    }//GEN-LAST:event_jButtonSporcuyuSilActionPerformed

    private void jButtonCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCikisActionPerformed
        dosyayiGüncelle(sporcuBilgi);
        System.exit(0);
    }//GEN-LAST:event_jButtonCikisActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SporcuBilgiFormu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SporcuBilgiFormu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SporcuBilgiFormu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SporcuBilgiFormu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new SporcuBilgiFormu().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(SporcuBilgiFormu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAZ;
    private javax.swing.JButton jButtonCikis;
    private javax.swing.JButton jButtonSporcuyuBul;
    private javax.swing.JButton jButtonSporcuyuEkle;
    private javax.swing.JButton jButtonSporcuyuSil;
    private javax.swing.JButton jButtonZA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelSporcuBulAdSoyad;
    private javax.swing.JLabel jLabelSporcuEkleAdSoyad;
    private javax.swing.JLabel jLabelSporcuEkleDogumTarihi;
    private javax.swing.JLabel jLabelSporcuEkleOynadigiKulupler;
    private javax.swing.JLabel jLabelSporcuSilAdSoyad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaSporcuBilgileriSirala;
    private javax.swing.JTextArea jTextAreaSporcuBul;
    private javax.swing.JTextField jTextFieldSporcuBulAdSoyad;
    private javax.swing.JTextField jTextFieldSporcuEkleAdSoyad;
    private javax.swing.JTextField jTextFieldSporcuEkleDogumTarihi;
    private javax.swing.JTextField jTextFieldSporcuEkleOynadigiKulupler;
    private javax.swing.JTextField jTextFieldSporcuSilAdSoyad;
    // End of variables declaration//GEN-END:variables
}
