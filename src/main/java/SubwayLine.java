import com.google.gson.annotations.SerializedName;

import java.util.*;

public class SubwayLine {
    private List<Integer> A, B, C, D, E, F, G, J, L, M, N, Q, R, S, W, Z;
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
        return line.equals("A") ? (A) :
        "B".equals(line) ? (B) :
        "C".equals(line) ? (C) :
        "D".equals(line) ? (D) :
        "E".equals(line) ? (E) :
        "F".equals(line) ? (F) :
        "G".equals(line) ? (G) :
        "J".equals(line) ? (J) :
        "L".equals(line) ? (L) :
        "M".equals(line) ? (M) :
        "N".equals(line) ? (N) :
        "Q".equals(line) ? (Q) :
        "R".equals(line) ? (R) :
        "S".equals(line) ? (S) :
        "W".equals(line) ? (W) :
        "Z".equals(line) ? (Z) :
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

