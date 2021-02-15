package com.dyapp.hesaplama;

import android.os.Bundle;
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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class FragmentSecond extends Fragment  implements RewardedVideoAdListener {
    private AdView mAdView;
    private Button hesapla,temizle;
    private EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,obp;
    private CheckBox cb;
    private static final String APP_ID = "ca-app-pub-6261653662849942~3979389563";
    private static final String AD_UNIT_ID = "ca-app-pub-6261653662849942/3815738031";
    private RewardedVideoAd mRewardedVideoAd;
    public FragmentSecondListener listener;

    public interface FragmentSecondListener {
        void onInputASent(CharSequence input);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        MobileAds.initialize(getActivity(), APP_ID);
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getContext());
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest= new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        hesapla = view.findViewById(R.id.btnHesapla);
        temizle = view.findViewById(R.id.btnTemizle);
        et1 = view.findViewById(R.id.text1);
        et2 = view.findViewById(R.id.text2);
        et3 = view.findViewById(R.id.text3);
        et4 = view.findViewById(R.id.text4);
        et5 = view.findViewById(R.id.text5);
        et6 = view.findViewById(R.id.text6);
        et7 = view.findViewById(R.id.text7);
        et8 = view.findViewById(R.id.text8);
        et9 = view.findViewById(R.id.text9);
        et10 = view.findViewById(R.id.text10);
        obp= view.findViewById(R.id.onlisansET);
        cb = (CheckBox) view.findViewById(R.id.checkBox);
        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var = 0;
                et1.setText(String.valueOf(var));
                et2.setText(String.valueOf(var));
                et3.setText(String.valueOf(var));
                et4.setText(String.valueOf(var));
                et5.setText(String.valueOf(var));
                et6.setText(String.valueOf(var));
                et7.setText(String.valueOf(var));
                et8.setText(String.valueOf(var));
                et9.setText(String.valueOf(var));
                et10.setText(String.valueOf(var));
                obp.setText(String.valueOf(var));
            }

        });


        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }
                int matDogru = Integer.parseInt(String.valueOf(et1.getText()));
                int matYanlis = Integer.parseInt(String.valueOf(et2.getText()));
                int turkceDogru = Integer.parseInt(String.valueOf(et3.getText()));
                int turkceYanlis = Integer.parseInt(String.valueOf(et4.getText()));
                int obpPuan = Integer.parseInt(String.valueOf(obp.getText()));

                if(obpPuan>80 || obpPuan<40)
                {
                    Toast.makeText(getActivity(), "Ön lisans puanı 40-80 arasında olmalıdır.", Toast.LENGTH_LONG).show();
                }
                else {
                    double matNet = (matYanlis / 1) * 0.25;
                    double matSonuc = matDogru - matNet;

                    double turkceNet = (turkceYanlis / 1) * 0.25;
                    double turkceSonuc = turkceDogru - turkceNet;
                    double obpSonuc = obpPuan *0.6;
                    if(cb.isChecked())
                    {
                        double SayisalHam = (matSonuc*2.8) + (turkceSonuc*0.6) + 144.4;
                        et9.setText(String.valueOf(SayisalHam));
                        double SayisalYer = (matSonuc*2.8) + (turkceSonuc*0.6) + (obpSonuc/2) + 144.4;
                        et10.setText(String.valueOf(SayisalYer));

                        double SozelHam = (matSonuc*0.6) + (turkceSonuc*2.4) + 126.1;
                        et7.setText(String.valueOf(SozelHam));
                        double SozelYer = (matSonuc*0.6) + (turkceSonuc*2.4) + (obpSonuc/2) + 126.1;
                        et8.setText(String.valueOf(SozelYer));

                        double EsitHam = (matSonuc*1.6) + (turkceSonuc*1.5) + 135.4;
                        et5.setText(String.valueOf(EsitHam));
                        double EsitYer = (matSonuc*1.6) + (turkceSonuc*1.5) + (obpSonuc/2) + 135.4;
                        et6.setText(String.valueOf(EsitYer));
                    }
                    else {
                        double SayisalHam1 = (matSonuc*2.8) + (turkceSonuc*0.6) + 144.4;
                        et9.setText(String.valueOf(SayisalHam1));
                        double SayisalYer1 = (matSonuc*2.8) + (turkceSonuc*0.6) +obpSonuc + 144.4;
                        et10.setText(String.valueOf(SayisalYer1));

                        double SozelHam1 = (matSonuc*0.6) + (turkceSonuc*2.4) + 126.1;
                        et7.setText(String.valueOf(SozelHam1));
                        double SozelYer1 = (matSonuc*0.6) + (turkceSonuc*2.4) + obpSonuc + 126.1;
                        et8.setText(String.valueOf(SozelYer1));

                        double EsitHam1 = (matSonuc*1.6) + (turkceSonuc*1.5) + 135.4;
                        et5.setText(String.valueOf(EsitHam1));
                        double EsitYer1 = (matSonuc*1.6) + (turkceSonuc*1.5) + obpSonuc + 135.4;
                        et6.setText(String.valueOf(EsitYer1));
                    }
                }


            }

        });




        return view;
    }

    private void loadRewardedVideoAd() {
        if (!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        // Toast.makeText(getActivity(), "Yüklendi!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        //  Toast.makeText(getActivity(), "Açıldı", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        // Toast.makeText(getActivity(), "Başladı", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        // Toast.makeText(getActivity(), "Kapandı!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        // Toast.makeText(getActivity(), "IDN!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        //    Toast.makeText(getActivity(), "IDN!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        //  Toast.makeText(getActivity(), "Yüklenirken sorun oldu!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
        //  Toast.makeText(getActivity(), "Bitti!", Toast.LENGTH_SHORT).show();
    }

}
