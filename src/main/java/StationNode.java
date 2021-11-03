public class StationNode extends SubwayStation{

    private boolean visited;
    private int distance;

    public StationNode (){
        visited = false;
        distance = Integer.MAX_VALUE;
    }

    public boolean getVisited () {
        return this.visited;
    }

    public void setVisited (boolean visited) {
        this.visited = visited;
    }

    public int getDistance () {
        return this.distance;
    }

    public void setDistance (int distance) {
        this.distance = distance;
    }
}
