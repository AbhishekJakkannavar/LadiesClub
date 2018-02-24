package shareholder.infinity.com.ladiesclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    ImageButton channelbtn;
    ImageButton designbtn;
    ImageButton aboutbtn;
    ImageButton feedbackbtn;
    private AdView mAdView;
    private InterstitialAd interstitialAdOfDesign;
    private InterstitialAd interstitialAdOfFeedback;
    private InterstitialAd interstitialAdOfAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        channelbtn = findViewById(R.id.youtubebtn);
        designbtn = findViewById(R.id.designbtn);
        feedbackbtn = findViewById(R.id.feedbackButton);
        aboutbtn = findViewById(R.id.aboutappButton);
        channelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyChannelActivity.class);
                startActivity(intent);
            }
        });


//        designbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,DesignActivity.class);
//                startActivity(intent);
//            }
//        });


//
//        feedbackbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,FeedbackActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });


        //Advertisement Code for Banner in Mainactivity
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Advertisement Code for Interstitial Add of Design Activity
        interstitialAdOfDesign = new InterstitialAd(this);
        interstitialAdOfDesign.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAdOfDesign.loadAd(new AdRequest.Builder().addTestDevice("80D564A54369E0651401428DFD20F1E1").build());

        interstitialAdOfDesign.setAdListener(new AdListener()

                                             {
                                                 @Override
                                                 public void onAdClosed() {
                                                     super.onAdClosed();
                                                     startActivity(new Intent(MainActivity.this, JewelleryActivity.class));
                                                     interstitialAdOfDesign.loadAd(new AdRequest.Builder().build());
                                                 }
                                             }

        );


        //Advertisement Code for Interstitial Add of Feedback Activity
        interstitialAdOfFeedback = new InterstitialAd(this);
        interstitialAdOfFeedback.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAdOfFeedback.loadAd(new AdRequest.Builder().addTestDevice("80D564A54369E0651401428DFD20F1E1").build());

        interstitialAdOfFeedback.setAdListener(new AdListener()

                                               {
                                                   @Override
                                                   public void onAdClosed() {
                                                       super.onAdClosed();
                                                       startActivity(new Intent(MainActivity.this, FeedbackActivity.class));
                                                       interstitialAdOfFeedback.loadAd(new AdRequest.Builder().build());
                                                   }
                                               }

        );


        //Advertisement Code for Interstitial Add of About Activity
        interstitialAdOfAbout = new InterstitialAd(this);
        interstitialAdOfAbout.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAdOfAbout.loadAd(new AdRequest.Builder().addTestDevice("80D564A54369E0651401428DFD20F1E1").build());

        interstitialAdOfAbout.setAdListener(new AdListener()

                                            {
                                                @Override
                                                public void onAdClosed() {
                                                    super.onAdClosed();
                                                    startActivity(new Intent(MainActivity.this, AboutActivity.class));
                                                    interstitialAdOfAbout.loadAd(new AdRequest.Builder().build());
                                                }
                                            }

        );


    }

    //Onclick Funtion of Designbtn
    public void startDesignActivity(View view) {
        if (interstitialAdOfDesign.isLoaded()) {
            interstitialAdOfDesign.show();
        } else {
            startActivity(new Intent(this, JewelleryActivity.class));
        }

    }


    //Onclick Funtion of Feedbackbtn
    public void startFeedbackActivity(View view) {
        if (interstitialAdOfFeedback.isLoaded()) {
            interstitialAdOfFeedback.show();
        } else {
            startActivity(new Intent(this, FeedbackActivity.class));
        }

    }


    //Onclick Funtion of Aboutbtn
    public void startAboutActivity(View view) {
        if (interstitialAdOfAbout.isLoaded()) {
            interstitialAdOfAbout.show();
        } else {
            startActivity(new Intent(this, AboutActivity.class));
        }

    }














    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
