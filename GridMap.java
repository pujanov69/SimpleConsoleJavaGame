public class GridMap extends Map {

    private int gridRows;
    private int gridColumns;
    private int[] obstacleMap = {  0, 0, 0, 0,
                                   0, 1, 0, 0,
                                   0, 0, 1, 0,   // number of rows and columns are equal to 4
                                   0, 1, 0, 0 };






    public GridMap(int gridRows, int gridColumns, int[] obstacleMap) {
        super();
        this.gridRows = gridRows;
        this.gridColumns = gridColumns;
        this.obstacleMap = obstacleMap;
    }






    @Override
    public void move() {


    } 



    }