package fr.rizomm.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Builder;

/**
 * Created by Maximilien on 22/02/2015.
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
@Builder
public class Contact implements Parcelable {
    private String lastName;
    private String firstName;
    private String phone;
    private String mail;

    public Contact(Parcel in) {
        lastName = in.readString();
        firstName = in.readString();
        phone = in.readString();
        mail = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lastName);
        dest.writeString(firstName);
        dest.writeString(phone);
        dest.writeString(mail);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
