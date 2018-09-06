
package android.databinding;
import com.wizag.taxi.rider.BR;
class DataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public DataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.wizag.taxi.rider.R.layout.activity_edit_profile:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_edit_profile_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.ActivityEditProfileBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_edit_profile is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.fragment_travel_review:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/fragment_travel_review_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.FragmentTravelReviewBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for fragment_travel_review is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.item_service:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/item_service_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.ItemServiceBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for item_service is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.fragment_travel_driver:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/fragment_travel_driver_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.FragmentTravelDriverBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for fragment_travel_driver is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.item_address:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/item_address_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.ItemAddressBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for item_address is invalid. Received: " + tag);
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
                case com.wizag.taxi.common.R.layout.activity_login:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_login_0".equals(tag)) {
                            return new com.wizag.taxi.common.databinding.ActivityLoginBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.fragment_review:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/fragment_review_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.FragmentReviewBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for fragment_review is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.fragment_edit_address:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/fragment_edit_address_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.FragmentEditAddressBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for fragment_edit_address is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.activity_addresses:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_addresses_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.ActivityAddressesBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_addresses is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.activity_main:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_main_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.ActivityMainBinding(bindingComponent, view);
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
                case com.wizag.taxi.rider.R.layout.fragment_travel_stats:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/fragment_travel_stats_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.FragmentTravelStatsBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for fragment_travel_stats is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.card_driver_accepted:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/card_driver_accepted_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.CardDriverAcceptedBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for card_driver_accepted is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.dialog_request_service:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/dialog_request_service_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.DialogRequestServiceBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for dialog_request_service is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.activity_travel:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_travel_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.ActivityTravelBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_travel is invalid. Received: " + tag);
                }
                case com.wizag.taxi.rider.R.layout.activity_splash:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_splash_0".equals(tag)) {
                            return new com.wizag.taxi.rider.databinding.ActivitySplashBinding(bindingComponent, view);
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
            case -1158109584: {
                if(tag.equals("layout/activity_edit_profile_0")) {
                    return com.wizag.taxi.rider.R.layout.activity_edit_profile;
                }
                break;
            }
            case 1191337956: {
                if(tag.equals("layout/fragment_travel_review_0")) {
                    return com.wizag.taxi.rider.R.layout.fragment_travel_review;
                }
                break;
            }
            case -635338625: {
                if(tag.equals("layout/item_service_0")) {
                    return com.wizag.taxi.rider.R.layout.item_service;
                }
                break;
            }
            case 854265012: {
                if(tag.equals("layout/fragment_travel_driver_0")) {
                    return com.wizag.taxi.rider.R.layout.fragment_travel_driver;
                }
                break;
            }
            case 433390078: {
                if(tag.equals("layout/item_address_0")) {
                    return com.wizag.taxi.rider.R.layout.item_address;
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
            case -237232145: {
                if(tag.equals("layout/activity_login_0")) {
                    return com.wizag.taxi.common.R.layout.activity_login;
                }
                break;
            }
            case 1496399475: {
                if(tag.equals("layout/fragment_review_0")) {
                    return com.wizag.taxi.rider.R.layout.fragment_review;
                }
                break;
            }
            case 672979098: {
                if(tag.equals("layout/fragment_edit_address_0")) {
                    return com.wizag.taxi.rider.R.layout.fragment_edit_address;
                }
                break;
            }
            case -1259933848: {
                if(tag.equals("layout/activity_addresses_0")) {
                    return com.wizag.taxi.rider.R.layout.activity_addresses;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return com.wizag.taxi.rider.R.layout.activity_main;
                }
                break;
            }
            case -972572342: {
                if(tag.equals("layout/dialog_write_complaint_0")) {
                    return com.wizag.taxi.common.R.layout.dialog_write_complaint;
                }
                break;
            }
            case -1988818347: {
                if(tag.equals("layout/fragment_travel_stats_0")) {
                    return com.wizag.taxi.rider.R.layout.fragment_travel_stats;
                }
                break;
            }
            case 1893722917: {
                if(tag.equals("layout/card_driver_accepted_0")) {
                    return com.wizag.taxi.rider.R.layout.card_driver_accepted;
                }
                break;
            }
            case 195334020: {
                if(tag.equals("layout/dialog_request_service_0")) {
                    return com.wizag.taxi.rider.R.layout.dialog_request_service;
                }
                break;
            }
            case 500839382: {
                if(tag.equals("layout/activity_travel_0")) {
                    return com.wizag.taxi.rider.R.layout.activity_travel;
                }
                break;
            }
            case 1573928931: {
                if(tag.equals("layout/activity_splash_0")) {
                    return com.wizag.taxi.rider.R.layout.activity_splash;
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
            ,"info"
            ,"item"
            ,"lastName"
            ,"media"
            ,"mobileNumber"
            ,"travel"
            ,"user"};
    }
}