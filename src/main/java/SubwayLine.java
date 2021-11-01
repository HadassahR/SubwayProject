import com.google.gson.annotations.SerializedName;

import java.util.*;

public class SubwayLine {
    private List<Integer> a, b, c, d, e, f, g, j, l, m, n, q, r, s, w, z;
    @SerializedName("7 Express")
    private List<Integer> _7Express;
    @SerializedName("6 Express")
    private List<Integer> _6Express;
    @SerializedName("1")
    private List<Integer> _1;
    @SerializedName("2")
    private List<Integer> _2;
    @SerializedName("3")
    private List<Integer> _3;
    @SerializedName("4")
    private List<Integer> _4;
    @SerializedName("5")
    private List<Integer> _5;
    @SerializedName("6")
    private List<Integer> _6;
    @SerializedName("7")
    private List<Integer> _7;

    public List<Integer> getSpecificLine(String line) {
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

