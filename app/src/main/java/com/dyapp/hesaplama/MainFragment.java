package com.dyapp.hesaplama;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainFragment extends Fragment {
    private EditText et1, et2, et3, et4, et5, et6, et7, et8, et9, et10, et11, et12, et13, et14, et15, et16, et17, et18, et19, et20,
            et21, et22, et23, et24, et25, et26, et27, et28, et29, et30, et31, et32, et41, et42, et43, et44, et45, et46, et47, et48, et49, et50, etDiploma;
    private CheckBox cb;
    private Button btn, btn2;
    private InterstitialAd mInterstitialAd;
    public MainFragmentListener listener;
    public interface MainFragmentListener {
        void onInputASent(CharSequence input);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        btn = v.findViewById(R.id.btnHesapla);
        btn2 = v.findViewById(R.id.btnTemizle);
        et1 = v.findViewById(R.id.text1);
        et2 = v.findViewById(R.id.text2);
        et3 = v.findViewById(R.id.text3);
        et4 = v.findViewById(R.id.text4);
        et5 = v.findViewById(R.id.text5);
        et6 = v.findViewById(R.id.text6);
        et7 = v.findViewById(R.id.text7);
        et8 = v.findViewById(R.id.text8);
        et9 = v.findViewById(R.id.text9);
        et10 = v.findViewById(R.id.text10);
        et11 = v.findViewById(R.id.text11);
        et12 = v.findViewById(R.id.text12);
        et13 = v.findViewById(R.id.text13);
        et14 = v.findViewById(R.id.text14);
        et15 = v.findViewById(R.id.text15);
        et16 = v.findViewById(R.id.text16);
        et17 = v.findViewById(R.id.text17);
        et18 = v.findViewById(R.id.text18);
        et19 = v.findViewById(R.id.text19);
        et20 = v.findViewById(R.id.text20);
        et21 = v.findViewById(R.id.text21);
        et22 = v.findViewById(R.id.text22);
        et23 = v.findViewById(R.id.text23);
        et24 = v.findViewById(R.id.text24);
        et25 = v.findViewById(R.id.text25);
        et26 = v.findViewById(R.id.text26);
        et27 = v.findViewById(R.id.text27);
        et28 = v.findViewById(R.id.text28);
        et29 = v.findViewById(R.id.text29);
        et30 = v.findViewById(R.id.text30);
        et31 = v.findViewById(R.id.text31);
        et32 = v.findViewById(R.id.text32);
        etDiploma = v.findViewById(R.id.diplomaET);
        cb = (CheckBox) v.findViewById(R.id.checkBox);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int turkceDogru = Integer.parseInt(String.valueOf(et1.getText()));
                int turkceYanlis = Integer.parseInt(String.valueOf(et2.getText()));
                int sosyalDogru = Integer.parseInt(String.valueOf(et3.getText()));
                int sosyalYanlis = Integer.parseInt(String.valueOf(et4.getText()));
                int matDogru = Integer.parseInt(String.valueOf(et5.getText()));
                int matYanlis = Integer.parseInt(String.valueOf(et6.getText()));
                int fenDogru = Integer.parseInt(String.valueOf(et7.getText()));
                int fenYanlis = Integer.parseInt(String.valueOf(et8.getText()));
                double dipPuani = Integer.parseInt(String.valueOf(etDiploma.getText()));
                int matDogru1 = Integer.parseInt(String.valueOf(et9.getText()));
                int matYanlis1 = Integer.parseInt(String.valueOf(et10.getText()));
                int fizikDogru = Integer.parseInt(String.valueOf(et11.getText()));
                int fizikYanlis = Integer.parseInt(String.valueOf(et12.getText()));
                int kimyaDogru = Integer.parseInt(String.valueOf(et13.getText()));
                int kimyaYanlis = Integer.parseInt(String.valueOf(et14.getText()));
                int biyolojiDogru = Integer.parseInt(String.valueOf(et15.getText()));
                int biyolojiYanlis = Integer.parseInt(String.valueOf(et16.getText()));
                int edebDogru = Integer.parseInt(String.valueOf(et17.getText()));
                int edebYanlis = Integer.parseInt(String.valueOf(et18.getText()));
                int tarih1Dogru = Integer.parseInt(String.valueOf(et19.getText()));
                int tarih1Yanlis = Integer.parseInt(String.valueOf(et20.getText()));
                int cog1Dogru = Integer.parseInt(String.valueOf(et21.getText()));
                int cog1Yanlis = Integer.parseInt(String.valueOf(et22.getText()));
                int tar2Dogru = Integer.parseInt(String.valueOf(et23.getText()));
                int tar2Yanlis = Integer.parseInt(String.valueOf(et24.getText()));
                int cog2Dogru = Integer.parseInt(String.valueOf(et25.getText()));
                int cog2Yanlis = Integer.parseInt(String.valueOf(et26.getText()));
                int felsefeDogru = Integer.parseInt(String.valueOf(et27.getText()));
                int felsefeYanlis = Integer.parseInt(String.valueOf(et28.getText()));
                int dinDogru = Integer.parseInt(String.valueOf(et29.getText()));
                int dinYanlis = Integer.parseInt(String.valueOf(et30.getText()));
                int dilDogru = Integer.parseInt(String.valueOf(et31.getText()));
                int dilYanlis = Integer.parseInt(String.valueOf(et32.getText()));

                if (dipPuani > 100) {
                    Toast.makeText(getActivity(), "Diploma puanı 100'ü geçemez.", Toast.LENGTH_LONG).show();
                } else {

                    //TYT BAŞLANGIÇ
                    double turkceNet = (turkceYanlis / 1) * 0.25;
                    double turkceSonuc = turkceDogru - turkceNet;

                    double sosyalNet = (sosyalYanlis / 1) * 0.25;
                    double sosyalSonuc = sosyalDogru - sosyalNet;

                    double matNet = (matYanlis / 1) * 0.25;
                    double matSonuc = matDogru - matNet;

                    double fenNet = (fenYanlis / 1) * 0.25;
                    double fenSonuc = fenDogru - fenNet;
                    //TYT BİTİŞ

                    //AYT BAŞLANGIÇ
                    double matNet1 = (matYanlis1 / 1) * 0.25;
                    double matSonuc1 = matDogru1 - matNet1;

                    double fizikNet = (fizikYanlis / 1) * 0.25;
                    double fizikSonuc = fizikDogru - fizikNet;

                    double kimyaNet = (kimyaYanlis / 1) * 0.25;
                    double kimyaSonuc = kimyaDogru - kimyaNet;

                    double biyolojiNet = (biyolojiYanlis / 1) * 0.25;
                    double biyolojiSonuc = biyolojiDogru - biyolojiNet;

                    double edebNet = (edebYanlis / 1) * 0.25;
                    double edebSonuc = edebDogru - edebNet;

                    double tarih1Net = (tarih1Yanlis / 1) * 0.25;
                    double tarih1Sonuc = tarih1Dogru - tarih1Net;

                    double cog1Net = (cog1Yanlis / 1) * 0.25;
                    double cog1Sonuc = cog1Dogru - cog1Net;

                    double tarih2Net = (tar2Yanlis / 1) * 0.25;
                    double tarih2Sonuc = tar2Dogru - tarih2Net;

                    double cog2Net = (cog2Yanlis / 1) * 0.25;
                    double cog2Sonuc = cog2Dogru - cog2Net;

                    double felsefeNet = (felsefeYanlis / 1) * 0.25;
                    double felsefeSonuc = felsefeDogru - felsefeNet;

                    double dinNet = (dinYanlis / 1) * 0.25;
                    double dinSonuc = dinDogru - dinNet;

                    double dilNet = (dilYanlis / 1) * 0.25;
                    double dilSonuc = dilDogru - dilNet;
                    double dipSonuc = dipPuani * 0.6;
                    //AYT BİTİŞ
                    if (cb.isChecked()) {
                        double AYTsozelHamSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (edebSonuc * 3) + (tarih1Sonuc * 2.88) +
                                (cog1Sonuc * 3.33) + (tarih2Sonuc * 2.91) + (cog2Sonuc * 2.91) + (felsefeSonuc * 3) + (dinSonuc * 3.33) + 100;

                        double AYTsozelYerSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (edebSonuc * 3) + (tarih1Sonuc * 2.88) +
                                (cog1Sonuc * 3.33) + (tarih2Sonuc * 2.91) + (cog2Sonuc * 2.91) + (felsefeSonuc * 3) + (dinSonuc * 3.33) + (dipSonuc / 2) + 100;

                        double AYTesitHamSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (matSonuc1 * 3) + (edebSonuc * 3) +
                                (tarih1Sonuc * 2.88) + (cog1Sonuc *3.33) +  (felsefeSonuc * 3) + (dinSonuc * 3.33) + 100;

                        double AYTesitYerSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (matSonuc1 * 3) + (edebSonuc * 3) +
                                (tarih1Sonuc * 2.88) + (cog1Sonuc *3.33) +  (felsefeSonuc * 3) + (dinSonuc * 3.33) +(dipSonuc/2)+ 100;

                        double AYTsayisalHamSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (matSonuc1 * 3) + (fizikSonuc * 2.8) +
                                (kimyaSonuc * 3.07) + (biyolojiSonuc * 3.07) + 100;

                        double AYTsayisalYerSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (matSonuc1 * 3) + (fizikSonuc * 2.8) +
                                (kimyaSonuc * 3.07) + (biyolojiSonuc * 3.07) + (dipSonuc / 2) + 100;

                        double TYThamSonuc1 = (turkceSonuc * 3.3) + (matSonuc * 3.3) + (fenSonuc * 3.4) + (sosyalSonuc * 3.4) + 100;

                        double TYTyerSonuc1 = (turkceSonuc * 3.3) + (matSonuc * 3.3) + (fenSonuc * 3.4) + (sosyalSonuc * 3.4) + (dipSonuc / 2) + 100;

                        double DilHam=(turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36)+(dilSonuc*3)+100;

                        double DilYer=(turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36)+(dilSonuc*3) +(dipSonuc/2) +100;

                        Intent intent = new Intent(getContext(),SonucActivity.class);
                        intent.putExtra("veri1",String.valueOf(AYTsozelHamSonuc1));
                        intent.putExtra("veri2",String.valueOf(AYTsozelYerSonuc1));
                        intent.putExtra("veri3",String.valueOf(AYTesitHamSonuc1));
                        intent.putExtra("veri4",String.valueOf(AYTesitYerSonuc1));
                        intent.putExtra("veri5",String.valueOf(AYTsayisalHamSonuc1));
                        intent.putExtra("veri6",String.valueOf(AYTsayisalYerSonuc1));
                        intent.putExtra("veri7",String.valueOf(TYThamSonuc1));
                        intent.putExtra("veri8",String.valueOf(TYTyerSonuc1));
                        intent.putExtra("veri9",String.valueOf(DilHam));
                        intent.putExtra("veri10",String.valueOf(DilYer));
                        startActivity(intent);
                    } else
                    {
                        double AYTesitHamSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (matSonuc1 * 3) + (edebSonuc * 3) +
                                (tarih1Sonuc * 2.88) + (cog1Sonuc *3.33) +  (felsefeSonuc * 3) + (dinSonuc * 3.33) + 100;

                        double AYTesitYerSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (matSonuc1 * 3) + (edebSonuc * 3) +
                                (tarih1Sonuc * 2.88) + (cog1Sonuc *3.33) +  (felsefeSonuc * 3) + (dinSonuc * 3.33) +dipSonuc+ 100;

                        double AYTsozelHamSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (edebSonuc * 3) + (tarih1Sonuc * 2.88) +
                                (cog1Sonuc * 3.33) + (tarih2Sonuc * 2.91) + (cog2Sonuc * 2.91) + (felsefeSonuc * 3) + (dinSonuc * 3.33) + 100;

                        double AYTsozelYerSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (edebSonuc * 3) + (tarih1Sonuc * 2.88) +
                                (cog1Sonuc * 3.33) + (tarih2Sonuc * 2.91) + (cog2Sonuc * 2.91) +(felsefeSonuc * 3) + (dinSonuc * 3.33) +dipSonuc + 100;

                        double AYTsayisalHamSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (matSonuc1 * 3) + (fizikSonuc * 2.8) +
                                (kimyaSonuc * 3.07) + (biyolojiSonuc * 3.07) + 100;

                        double AYTsayisalYerSonuc1 = (turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36) + (matSonuc1 * 3) + (fizikSonuc * 2.8) +
                                (kimyaSonuc * 3.07) + (biyolojiSonuc * 3.07) + dipSonuc + 100;

                        double hamSonuc = (turkceSonuc * 3.3) + (matSonuc * 3.3) + (fenSonuc * 3.4) + (sosyalSonuc * 3.4) + 100;

                        double yerSonuc = (turkceSonuc * 3.3) + (matSonuc * 3.3) + (fenSonuc * 3.4) + (sosyalSonuc * 3.4) + dipSonuc + 100;

                        double DilHam=(turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36)+(dilSonuc*3)+100;

                        double DilYer=(turkceSonuc * 1.32) + (matSonuc * 1.32) + (fenSonuc * 1.36) + (sosyalSonuc * 1.36)+(dilSonuc*3) +dipSonuc +100;

                        Intent intent = new Intent(getContext(),SonucActivity.class);
                        intent.putExtra("veri1",String.valueOf(AYTsozelHamSonuc1));
                        intent.putExtra("veri2",String.valueOf(AYTsozelYerSonuc1));
                        intent.putExtra("veri3",String.valueOf(AYTesitHamSonuc1));
                        intent.putExtra("veri4",String.valueOf(AYTesitYerSonuc1));
                        intent.putExtra("veri5",String.valueOf(AYTsayisalHamSonuc1));
                        intent.putExtra("veri6",String.valueOf(AYTsayisalYerSonuc1));
                        intent.putExtra("veri7",String.valueOf(hamSonuc));
                        intent.putExtra("veri8",String.valueOf(yerSonuc));
                        intent.putExtra("veri9",String.valueOf(DilHam));
                        intent.putExtra("veri10",String.valueOf(DilYer));
                        startActivity(intent);

                    }

                }


            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int def = 0;
                etDiploma.setText(String.valueOf(def));
                et1.setText(String.valueOf(def));
                et2.setText(String.valueOf(def));
                et3.setText(String.valueOf(def));
                et4.setText(String.valueOf(def));
                et5.setText(String.valueOf(def));
                et6.setText(String.valueOf(def));
                et7.setText(String.valueOf(def));
                et8.setText(String.valueOf(def));
                et9.setText(String.valueOf(def));
                et10.setText(String.valueOf(def));
                et11.setText(String.valueOf(def));
                et12.setText(String.valueOf(def));
                et13.setText(String.valueOf(def));
                et14.setText(String.valueOf(def));
                et15.setText(String.valueOf(def));
                et16.setText(String.valueOf(def));
                et17.setText(String.valueOf(def));
                et18.setText(String.valueOf(def));
                et19.setText(String.valueOf(def));
                et20.setText(String.valueOf(def));
                et21.setText(String.valueOf(def));
                et22.setText(String.valueOf(def));
                et23.setText(String.valueOf(def));
                et24.setText(String.valueOf(def));
                et25.setText(String.valueOf(def));
                et26.setText(String.valueOf(def));
                et27.setText(String.valueOf(def));
                et28.setText(String.valueOf(def));
                et29.setText(String.valueOf(def));
                et30.setText(String.valueOf(def));
                et31.setText(String.valueOf(def));
                et32.setText(String.valueOf(def));

            }
        });
        return v;

    }


}
