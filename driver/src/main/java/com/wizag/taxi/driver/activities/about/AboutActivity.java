package com.wizag.taxi.driver.activities.about;

import android.os.Bundle;
import android.view.View;

import com.wizag.taxi.driver.BuildConfig;
import com.wizag.taxi.driver.R;
import com.wizag.taxi.common.components.BaseActivity;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.licenses.BSD3ClauseLicense;
import de.psdev.licensesdialog.licenses.MITLicense;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        registerEventBus = false;
        super.onCreate(savedInstanceState);
        Element versionElement = new Element().setTitle(getString(R.string.version_name, BuildConfig.VERSION_NAME));
        //Element licenseElement = new Element().setTitle(getString(R.string.legal_notices)).setIconDrawable(R.drawable.copyright).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Notices notices = new Notices();
//
//                new LicensesDialog.Builder(AboutActivity.this)
//                        .setNotices(notices)
//                        .setIncludeOwnLicense(true)
//                        .build()
//                        .show();
//            }
//        });
        AboutPage aboutPage = new AboutPage(AboutActivity.this)
                .isRTL(false)
                //.setImage(R.drawable.logo5)
                .addGroup(getString(R.string.about_contacts))
                .addItem(versionElement);

//        if(!getString(R.string.email).equals(""))
//            aboutPage.addEmail(getString(R.string.email));
//        if(!getString(R.string.website).equals(""))
//            aboutPage.addWebsite(getString(R.string.website));
//        if(!getString(R.string.twitter).equals(""))
//            aboutPage.addTwitter(getString(R.string.twitter));
//        if(!getString(R.string.instagram).equals(""))
//            aboutPage.addInstagram(getString(R.string.instagram));
//        if(!getString(R.string.facebook).equals(""))
//            aboutPage.addFacebook(getString(R.string.facebook));
//        if(!getString(R.string.playStore).equals(""))
//            aboutPage.addPlayStore(getString(R.string.playStore));
//        aboutPage.addItem(licenseElement);
        aboutPage.setDescription(getString(R.string.about_driver_description));
        View view = aboutPage.create();
        setContentView(view);
    }
}