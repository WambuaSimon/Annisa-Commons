package com.wizag.taxi.common.activities.chargeAccount;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cooltechworks.creditcarddesign.CardEditActivity;
import com.cooltechworks.creditcarddesign.CreditCardUtils;
import com.wizag.taxi.common.R;
import com.wizag.taxi.common.components.BaseActivity;
import com.wizag.taxi.common.databinding.ActivityChargeAccountBinding;
import com.wizag.taxi.common.events.ChargeAccountEvent;
import com.wizag.taxi.common.events.ChargeAccountResultEvent;
import com.wizag.taxi.common.utils.AlerterHelper;
import com.wizag.taxi.common.utils.CommonUtils;
import com.wizag.taxi.common.utils.NumberThousandWatcher;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.NumberFormat;


public class ChargeAccountActivity extends BaseActivity{
    ActivityChargeAccountBinding binding;
    final int GET_NEW_CARD = 2;
    private enum PaymentMode {
        online,
        stripe
    }
    PaymentMode paymentMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_charge_account);
        initializeToolbar(getString(R.string.title_charge));
        binding.editText.setText(String.valueOf(Math.round(getIntent().getDoubleExtra("defaultAmount",0f))));
        binding.paymentOnline.setOnClickListener(view -> {
            binding.checkoutButton.setText(getString(R.string.checkout_filled,getString(R.string.checkout_online)));
            paymentMode = PaymentMode.online;
            binding.checkoutButton.setEnabled(true);
        });
        binding.paymentStripe.setOnClickListener(view -> {
            binding.checkoutButton.setText(getString(R.string.checkout_filled,getString(R.string.checkout_stripe)));
            paymentMode = PaymentMode.stripe;
            binding.checkoutButton.setEnabled(true);
        });
        if(!getResources().getBoolean(R.bool.payment_stripe_enabled))
            binding.paymentStripe.setVisibility(View.GONE);
        if(!getResources().getBoolean(R.bool.payment_web_enabled))
            binding.paymentOnline.setVisibility(View.GONE);
        if(getResources().getBoolean(R.bool.payment_web_enabled) && !getResources().getBoolean(R.bool.payment_stripe_enabled)) {
            binding.paymentOnline.callOnClick();
            binding.layoutMethods.setVisibility(View.GONE);
            binding.titleMethod.setVisibility(View.GONE);
        }
        if(!getResources().getBoolean(R.bool.payment_web_enabled) && getResources().getBoolean(R.bool.payment_stripe_enabled)) {
            binding.paymentStripe.callOnClick();
            binding.layoutMethods.setVisibility(View.GONE);
            binding.titleMethod.setVisibility(View.GONE);
        }
        binding.editText.addTextChangedListener(new NumberThousandWatcher(binding.editText));

        Double balance = CommonUtils.driver != null ? CommonUtils.driver.getBalance() : CommonUtils.rider.getBalance();
        binding.textCurrentBalance.setText(getString(R.string.unit_money,balance));
        binding.chargeAddFirst.setText(NumberFormat.getInstance().format(getResources().getInteger(R.integer.charge_first)));
        binding.chargeAddSecond.setText(NumberFormat.getInstance().format(getResources().getInteger(R.integer.charge_second)));
        binding.chargeAddThird.setText(NumberFormat.getInstance().format(getResources().getInteger(R.integer.charge_third)));
        binding.chargeAddFirst.setOnClickListener(view -> addCharge(binding.chargeAddFirst));
        binding.chargeAddSecond.setOnClickListener(view -> addCharge(binding.chargeAddSecond));
        binding.chargeAddThird.setOnClickListener(view -> addCharge(binding.chargeAddThird));
    }

    public void onCheckoutClicked(View view) {
        if(binding.editText.getText().toString().isEmpty()){
            AlerterHelper.showError(ChargeAccountActivity.this,getString(R.string.error_charge_field_empty));
            return;
        }
        int amount = (Integer.parseInt(binding.editText.getText().toString().replace(",","")));
        if(amount < getResources().getInteger(R.integer.minimum_charge_amount)){
            AlerterHelper.showError(ChargeAccountActivity.this,getString(R.string.error_charge_field_low,getResources().getInteger(R.integer.minimum_charge_amount)));
            return;
        }
        if(paymentMode == PaymentMode.stripe) {
            Intent intent = new Intent(ChargeAccountActivity.this, CardEditActivity.class);
            startActivityForResult(intent, GET_NEW_CARD);
        } else {
            //AlerterHelper.showError(ChargeAccountActivity.this,"No provider was provided. Provide one!");

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void AccountCharged(ChargeAccountResultEvent event){
        if(event.hasError())
            event.showAlert(ChargeAccountActivity.this);
        else {
            setResult(RESULT_OK);
            finish();
        }

    }
    void addCharge(Button button) {
        try {
            binding.editText.setText(String.valueOf(NumberFormat.getInstance().parse(button.getText().toString()).intValue()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GET_NEW_CARD && resultCode == RESULT_OK) {
            if(getString(R.string.stripe_publishable_key).equals("")){
                AlerterHelper.showError(ChargeAccountActivity.this,"Stripe API Key wasn't provided. Implement you own payment method or provide API Key.");
                return;
            }
            Card card = new Card(data.getStringExtra(CreditCardUtils.EXTRA_CARD_NUMBER),
                    Integer.valueOf(data.getStringExtra(CreditCardUtils.EXTRA_CARD_EXPIRY).split("/")[0]),
                    Integer.valueOf(data.getStringExtra(CreditCardUtils.EXTRA_CARD_EXPIRY).split("/")[1]),
                    data.getStringExtra(CreditCardUtils.EXTRA_CARD_CVV));
            Stripe stripe = new Stripe();
            stripe.createToken(card, getString(R.string.stripe_publishable_key), new TokenCallback() {
                public void onSuccess(Token token) {
                    Float amount = Float.parseFloat(binding.editText.getText().toString().replace(",",""));
                    eventBus.post(new ChargeAccountEvent("stripe", token.getId(),amount));
                }

                public void onError(Exception error) {
                    Log.d("Stripe", error.getLocalizedMessage());
                }
            });
        }
    }
}
