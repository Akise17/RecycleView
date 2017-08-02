package id.yuktanding.recycleview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Akise on 01/08/2017.
 */

/*  Step Ketiga RecyclerView: Buat Kumpulan data
*   3. Buat Class Item/Class ini*/
public class item implements Parcelable{
    private String nama;
    private String pesan_terakhir;
    private int idImage;

    public item(){

    }
// 4. Generate get dan set
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPesan_terakhir() {
        return pesan_terakhir;
    }

    public void setPesan_terakhir(String pesan_terakhir) {
        this.pesan_terakhir = pesan_terakhir;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
// 4. Generate get dan set

// 5. Generate constructor
    public item(String nama, String pesan_terakhir, int idImage) {
        this.nama = nama;
        this.pesan_terakhir = pesan_terakhir;
        this.idImage = idImage;
    }
// 5. Generate constructor

    /*Generate Parcelable*/
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.pesan_terakhir);
        dest.writeInt(this.idImage);
    }

    protected item(Parcel in) {
        this.nama = in.readString();
        this.pesan_terakhir = in.readString();
        this.idImage = in.readInt();
    }

    public static final Creator<item> CREATOR = new Creator<item>() {
        @Override
        public item createFromParcel(Parcel source) {
            return new item(source);
        }

        @Override
        public item[] newArray(int size) {
            return new item[size];
        }
    };
    /*Generate Parcelable*/
}
/*  Step Ketiga RecyclerView: Buat Kumpulan data
*   3. Buat Class Item/Class ini*/
