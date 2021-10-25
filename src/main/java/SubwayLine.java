import com.google.gson.annotations.SerializedName;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<String> returnOrderedList(List<String> connections){
        List<Integer> integerList = new ArrayList<>();
        for(String s : connections) integerList.add(Integer.valueOf(s));
        Collections.sort(integerList);
        List<String> sortedList = new ArrayList<>();
        for(Integer i : integerList) sortedList.add(i.toString());
        return sortedList;
    }

    public List<String> returnLinesForStation(String station){
        return station.equals("A") ? returnOrderedList(a) :
            "B".equals(station) ? returnOrderedList(b) :
            "C".equals(station) ? returnOrderedList(c) :
            "D".equals(station) ? returnOrderedList(d) :
            "E".equals(station) ? returnOrderedList(e) :
            "F".equals(station) ? returnOrderedList(f) :
            "G".equals(station) ? returnOrderedList(g) :
            "J".equals(station) ? returnOrderedList(j) :
            "L".equals(station) ? returnOrderedList(l) :
            "M".equals(station) ? returnOrderedList(m) :
            "N".equals(station) ? returnOrderedList(n) :
            "Q".equals(station) ? returnOrderedList(q) :
            "R".equals(station) ? returnOrderedList(r) :
            "S".equals(station) ? returnOrderedList(s) :
            "W".equals(station) ? returnOrderedList(w) :
            "Z".equals(station) ? returnOrderedList(z) :
            "7 Express".equals(station) ? returnOrderedList(_7Express) :
            "6 Express".equals(station) ? returnOrderedList(_6Express) :
            "1".equals(station) ? returnOrderedList(_1) :
            "2".equals(station) ? returnOrderedList(_2) :
            "3".equals(station) ? returnOrderedList(_3) :
            "4".equals(station) ? returnOrderedList(_4) :
            "5".equals(station) ? returnOrderedList(_5) :
            "6".equals(station) ? returnOrderedList(_6) :
            "7".equals(station) ? returnOrderedList(_7) : Collections.emptyList();
    }
}

