/*
    Team Name: tooBee || !tooBee
*/

package nottoobee.toobee.smarthive;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import java.util.HashMap;

/*
    N.B.: Instances of this class can be passed directly to Firebase's setValue() method,
    since they use the same field names as the database.

    e.g.
        ref.push().setValue(new Hive("Hive 1", "gps coords"));

    It is also possible to pull values from the database directly into a Hive object.
*/

public class Hive implements Parcelable{
    private String name;
    private String location;
    private long date_created;
    private HashMap<String, Data> data;
    private String key;

    public Hive() {
    }

    public Hive(Parcel in) {
        name = in.readString();
        location = in.readString();
        date_created = in.readLong();
        data = in.readParcelable(Data.class.getClassLoader());
    }

    public Hive(String name, String location) {
        this.name = name;
        this.location = location;
        this.date_created = new Date().getTime();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public long getDate_created() {
        return date_created;
    }

    public HashMap<String, Data> getData() {
        return data;
    }

    public void setData(HashMap<String, Data> data) { this.data = data; }

    public void setKey(String key) {
        this.key = (key);
    }

    public String getKey() {
        return key;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(location);
        dest.writeLong(date_created);
    }

    public static final Parcelable.Creator<Hive> CREATOR = new Parcelable.Creator<Hive>() {
        public Hive createFromParcel(Parcel in) {
            return new Hive(in);
        }

        public Hive[] newArray(int size) {
            return new Hive[size];
        }
    };
}
