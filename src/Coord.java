public class Coord {

    private int x, y;

    public Coord(int x, int y ){
        if (x<8 && y<8 && x>=0 && y>=0 ) {
            this.x = x;
            this.y = y;
        }else{
            throw new IllegalArgumentException("coordonnées de la case invalides");
        }
    }

    public boolean t;


}
