package com.vishnu.memoryclean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishnuprasad on 07/08/15.
 */
public class Myclass implements Parcelable {

    int a = 8;
    String b = "hello";
    List<String> l = new ArrayList<String>();

public Myclass(int t, String y,List<String> l){
    this.a = t;
    this.b = y;
    this.l = l;

}


    public Myclass(Parcel in){
      this.a =in.readInt();
        this.b = in.readString();

        in.readStringList(l);

    }
    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(a);
        parcel.writeString(b);
        parcel.writeStringList(l);

    }
   public static final Parcelable.Creator<Myclass> CREATOR = new Parcelable.Creator<Myclass>() {
        @Override
        public Myclass createFromParcel(Parcel parcel) {
            return new Myclass(parcel);
        }

        @Override
        public Myclass[] newArray(int i) {
            return new Myclass[0];
        }
    };
}
