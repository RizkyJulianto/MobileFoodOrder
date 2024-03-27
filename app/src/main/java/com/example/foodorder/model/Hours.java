package com.example.foodorder.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class Hours {

    String Minggu;
    String Senin;
    String Selasa;
    String Rabu;
    String Kamis;
    String Jumat;
    String Sabtu;

    public String getMinggu() {
        return Minggu;
    }

    public void setMinggu(String minggu) {
        Minggu = minggu;
    }

    public String getSenin() {
        return Senin;
    }

    public void setSenin(String senin) {
        Senin = senin;
    }

    public String getSelasa() {
        return Selasa;
    }

    public void setSelasa(String selasa) {
        Selasa = selasa;
    }

    public String getRabu() {
        return Rabu;
    }

    public void setRabu(String rabu) {
        Rabu = rabu;
    }

    public String getKamis() {
        return Kamis;
    }

    public void setKamis(String kamis) {
        Kamis = kamis;
    }

    public String getJumat() {
        return Jumat;
    }

    public void setJumat(String jumat) {
        Jumat = jumat;
    }

    public String getSabtu() {
        return Sabtu;
    }

    public void setSabtu(String sabtu) {
        Sabtu = sabtu;
    }

    public String getTodaysHours(){
        Calendar calendar = Calendar.getInstance();
         Date date =  calendar.getTime();
         String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
         switch (day){
             case "Minggu":
                 return this.Minggu;
                 case "Senin":
                  return this.Senin;
                 case "Selasa":
                  return this.Selasa;
                 case "Rabu":
                  return this.Rabu;
                 case "Kamis":
                  return this.Kamis;
                 case "Jumat":
                  return this.Jumat;
                 case "Sabtu":
                  return this.Sabtu;
             default:
                 return this.Minggu;
         }
    }
}
