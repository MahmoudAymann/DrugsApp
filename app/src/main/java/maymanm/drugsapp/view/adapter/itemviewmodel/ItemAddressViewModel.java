package maymanm.drugsapp.view.adapter.itemviewmodel;

import android.location.Address;

import androidx.databinding.Bindable;

import maymanm.drugsapp.base.BaseViewModel;

public class ItemAddressViewModel extends BaseViewModel {
    private Address address;
    public ItemAddressViewModel(Address address) {
        this.address = address;
    }

    @Bindable
    public String getAddress() {
        return getFullAddress(address);
    }

    private String getFullAddress(Address addressItem) {
        StringBuilder strBuilder = new StringBuilder();
        if (addressItem.getThoroughfare() != null) {
            strBuilder.append(addressItem.getThoroughfare()).append(", ");
        }
        if (addressItem.getLocality() != null) {
            strBuilder.append(addressItem.getLocality()).append(", ");
        }
        if (addressItem.getSubAdminArea() != null) {
            strBuilder.append(addressItem.getSubAdminArea()).append(", ");
        }
        if (addressItem.getAdminArea() != null) {
            strBuilder.append(addressItem.getAdminArea()).append(", ");
        }
        if (addressItem.getCountryName() != null) {
            strBuilder.append(addressItem.getCountryName());
        }
        return strBuilder.toString();
    }


    public void onItemClick(){
        setValue(null);
    }


}
