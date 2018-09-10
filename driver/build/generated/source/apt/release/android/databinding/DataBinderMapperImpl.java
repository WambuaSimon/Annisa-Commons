
package android.databinding;
import com.wizag.taxi.driver.BR;
class DataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public DataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.wizag.taxi.common.R.layout.activity_login:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_login_0".equals(tag)) {
                            return new com.wizag.taxi.common.databinding.ActivityLoginBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
                }
                case com.wizag.taxi.driver.R.layout.activity_statistics:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_statistics_0".equals(tag)) {
                            return new com.wizag.taxi.driver.databinding.ActivityStatisticsBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_statistics is invalid. Received: " + tag);
                }
                case com.wizag.taxi.driver.R.layout.activity_main:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_main_0".equals(tag)) {
                            return new com.wizag.taxi.driver.databinding.ActivityMainBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
                }
                case com.wizag.taxi.common.R.layout.dialog_write_complaint:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/dialog_write_complaint_0".equals(tag)) {
                            return new com.wizag.taxi.common.databinding.DialogWriteComplaintBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for dialog_write_complaint is invalid. Received: " + tag);
                }
                case com.wizag.taxi.driver.R.layout.activity_edit_profile:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_edit_profile_0".equals(tag)) {
                            return new com.wizag.taxi.driver.databinding.ActivityEditProfileBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_edit_profile is invalid. Received: " + tag);
                }
                case com.wizag.taxi.driver.R.layout.card_request:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/card_request_0".equals(tag)) {
                            return new com.wizag.taxi.driver.databinding.CardRequestBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for card_request is invalid. Received: " + tag);
                }
                case com.wizag.taxi.common.R.layout.activity_charge_account:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_charge_account_0".equals(tag)) {
                            return new com.wizag.taxi.common.databinding.ActivityChargeAccountBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_charge_account is invalid. Received: " + tag);
                }
                case com.wizag.taxi.common.R.layout.item_travel:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/item_travel_0".equals(tag)) {
                            return new com.wizag.taxi.common.databinding.ItemTravelBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for item_travel is invalid. Received: " + tag);
                }
                case com.wizag.taxi.driver.R.layout.activity_travel:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_travel_0".equals(tag)) {
                            return new com.wizag.taxi.driver.databinding.ActivityTravelBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_travel is invalid. Received: " + tag);
                }
                case com.wizag.taxi.driver.R.layout.fragment_request_card:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/fragment_request_card_0".equals(tag)) {
                            return new com.wizag.taxi.driver.databinding.FragmentRequestCardBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for fragment_request_card is invalid. Received: " + tag);
                }
                case com.wizag.taxi.driver.R.layout.activity_splash:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_splash_0".equals(tag)) {
                            return new com.wizag.taxi.driver.databinding.ActivitySplashBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
                }
        }
        return null;
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    @Override
    public int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -237232145: {
                if(tag.equals("layout/activity_login_0")) {
                    return com.wizag.taxi.common.R.layout.activity_login;
                }
                break;
            }
            case -1378399713: {
                if(tag.equals("layout/activity_statistics_0")) {
                    return com.wizag.taxi.driver.R.layout.activity_statistics;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return com.wizag.taxi.driver.R.layout.activity_main;
                }
                break;
            }
            case -972572342: {
                if(tag.equals("layout/dialog_write_complaint_0")) {
                    return com.wizag.taxi.common.R.layout.dialog_write_complaint;
                }
                break;
            }
            case -1158109584: {
                if(tag.equals("layout/activity_edit_profile_0")) {
                    return com.wizag.taxi.driver.R.layout.activity_edit_profile;
                }
                break;
            }
            case 941622678: {
                if(tag.equals("layout/card_request_0")) {
                    return com.wizag.taxi.driver.R.layout.card_request;
                }
                break;
            }
            case -1018865826: {
                if(tag.equals("layout/activity_charge_account_0")) {
                    return com.wizag.taxi.common.R.layout.activity_charge_account;
                }
                break;
            }
            case 857986514: {
                if(tag.equals("layout/item_travel_0")) {
                    return com.wizag.taxi.common.R.layout.item_travel;
                }
                break;
            }
            case 500839382: {
                if(tag.equals("layout/activity_travel_0")) {
                    return com.wizag.taxi.driver.R.layout.activity_travel;
                }
                break;
            }
            case -476096421: {
                if(tag.equals("layout/fragment_request_card_0")) {
                    return com.wizag.taxi.driver.R.layout.fragment_request_card;
                }
                break;
            }
            case 1573928931: {
                if(tag.equals("layout/activity_splash_0")) {
                    return com.wizag.taxi.driver.R.layout.activity_splash;
                }
                break;
            }
        }
        return 0;
    }
    @Override
    public String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"address"
            ,"carMedia"
            ,"converter"
            ,"driver"
            ,"email"
            ,"firstName"
            ,"gender"
            ,"item"
            ,"lastName"
            ,"media"
            ,"mobileNumber"
            ,"request"
            ,"user"};
    }
}