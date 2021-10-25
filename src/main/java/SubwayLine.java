import com.google.gson.annotations.SerializedName;

import javax.print.DocFlavor;
import java.util.List;

public class SubwayLine {
    @SerializedName("A")
    public List<String> a;
    @SerializedName("B")
    public List<String> b;
    @SerializedName("C")
    public List<String> c;
    @SerializedName("D")
    public List<String> d;
    @SerializedName("E")
    public List<String> e;
    @SerializedName("F")
    public List<String> f;
    @SerializedName("G")
    public List<String> g;
    @SerializedName("J")
    public List<String> j;
    @SerializedName("L")
    public List<String> l;
    @SerializedName("M")
    public List<String> m;
    @SerializedName("N")
    public List<String> n;
    @SerializedName("Q")
    public List<String> q;
    @SerializedName("R")
    public List<String> r;
    @SerializedName("S")
    public List<String> s;
    @SerializedName("W")
    public List<String> w;
    @SerializedName("Z")
    public List<String> z;
    @SerializedName("7 Express")
    public List<String> _7Express;
    @SerializedName("6 Express")
    public List<String> _6Express;
    @SerializedName("1")
    public List<String> _1;
    @SerializedName("2")
    public List<String> _2;
    @SerializedName("3")
    public List<String> _3;
    @SerializedName("4")
    public List<String> _4;
    @SerializedName("5")
    public List<String> _5;
    @SerializedName("6")
    public List<String> _6;
    @SerializedName("7")
    public List<String> _7;

    public List<String> returnLinesForStation(String station){
        return station.equals("A") ? a :
                "B".equals(station) ? b :
                "C".equals(station) ? c :
                "D".equals(station) ? d :
                "E".equals(station) ? e :
                "F".equals(station) ? f :
                "G".equals(station) ? g :
                "J".equals(station) ? j :
                "L".equals(station) ? l :
                "M".equals(station) ? m :
                "N".equals(station) ? n :
                "Q".equals(station) ? q :
                "R".equals(station) ? r :
                "S".equals(station) ? s :
                "W".equals(station) ? w :
                "Z".equals(station) ? z :
                "7 Express".equals(station) ? _7Express :
                "6 Express".equals(station) ? _6Express :
                "1".equals(station) ? _1 :
                "2".equals(station) ? _2 :
                "3".equals(station) ? _3 :
                "4".equals(station) ? _4 :
                "5".equals(station) ? _5 :
                "6".equals(station) ? _6 :
                "7".equals(station) ? _7 : null; // What should be default?
    }
}

