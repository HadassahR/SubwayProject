import com.google.gson.annotations.SerializedName;

import java.util.*;

public class SubwayLine {
    @SerializedName("A")
    public List<Integer> a;
    @SerializedName("B")
    public List<Integer> b;
    @SerializedName("C")
    public List<Integer> c;
    @SerializedName("D")
    public List<Integer> d;
    @SerializedName("E")
    public List<Integer> e;
    @SerializedName("F")
    public List<Integer> f;
    @SerializedName("G")
    public List<Integer> g;
    @SerializedName("J")
    public List<Integer> j;
    @SerializedName("L")
    public List<Integer> l;
    @SerializedName("M")
    public List<Integer> m;
    @SerializedName("N")
    public List<Integer> n;
    @SerializedName("Q")
    public List<Integer> q;
    @SerializedName("R")
    public List<Integer> r;
    @SerializedName("S")
    public List<Integer> s;
    @SerializedName("W")
    public List<Integer> w;
    @SerializedName("Z")
    public List<Integer> z;
    @SerializedName("7 Express")
    public List<Integer> _7Express;
    @SerializedName("6 Express")
    public List<Integer> _6Express;
    @SerializedName("1")
    public List<Integer> _1;
    @SerializedName("2")
    public List<Integer> _2;
    @SerializedName("3")
    public List<Integer> _3;
    @SerializedName("4")
    public List<Integer> _4;
    @SerializedName("5")
    public List<Integer> _5;
    @SerializedName("6")
    public List<Integer> _6;
    @SerializedName("7")
    public List<Integer> _7;

    public List<Integer> getLine (String line) {
        return line.equals("A") ? (a) :
        "B".equals(line) ? (b) :
        "C".equals(line) ? (c) :
        "D".equals(line) ? (d) :
        "E".equals(line) ? (e) :
        "F".equals(line) ? (f) :
        "G".equals(line) ? (g) :
        "J".equals(line) ? (j) :
        "L".equals(line) ? (l) :
        "M".equals(line) ? (m) :
        "N".equals(line) ? (n) :
        "Q".equals(line) ? (q) :
        "R".equals(line) ? (r) :
        "S".equals(line) ? (s) :
        "W".equals(line) ? (w) :
        "Z".equals(line) ? (z) :
        "7 Express".equals(line) ? (_7Express) :
        "6 Express".equals(line) ? (_6Express) :
        "1".equals(line) ? (_1) :
        "2".equals(line) ? (_2) :
        "3".equals(line) ? (_3) :
        "4".equals(line) ? (_4) :
        "5".equals(line) ? (_5) :
        "6".equals(line) ? (_6) :
        "7".equals(line) ? (_7) : Collections.emptyList();
    }
}

