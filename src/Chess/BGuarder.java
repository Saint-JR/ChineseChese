package Chess;

public class BGuarder extends Chess{
    public BGuarder(int n, int m)
    {
        x = n;
        y = m;
        SetEval();
    }

    public void MovAtk()
    {
        CLM();
        if (x == 2 && y == 3)										//仕处于田字格左下角
        {
            if (Map.RMap[x - 1][y + 1] == 0 || Map.RMap[x - 1][y + 1] <= 16)
                //AMap[x - 1][y + 1] = Map.RMap[x][y];
                Available_Pos.add(new Node(x-1,y+1));
        }
        else if (x == 2 && y == 5)									//仕处于田字格右下角
        {
            if (Map.RMap[x - 1][y - 1] == 0 || Map.RMap[x - 1][y - 1] <= 16)
                Available_Pos.add(new Node(x-1,y-1));
        }
        else if (x == 0 && y == 3)									//仕处于田字格左上角
        {
            if (Map.RMap[x + 1][y + 1] == 0 || Map.RMap[x + 1][y + 1] <= 16)
                Available_Pos.add(new Node(x+1,y+1));
        }
        else if (x == 0 && y == 5)									//仕处于田字格右上角
        {
            if (Map.RMap[x + 1][y - 1] == 0 || Map.RMap[x + 1][y - 1] <= 16)
                Available_Pos.add(new Node(x+1,y-1));
        }
        else if (x == 1 && y == 4)									//仕处于田字格中心
        {
            if (Map.RMap[x - 1][y + 1] == 0 || Map.RMap[x - 1][y + 1] <= 16)
                Available_Pos.add(new Node(x-1,y+1));
            if (Map.RMap[x - 1][y - 1] == 0 || Map.RMap[x - 1][y - 1] <= 16)
                Available_Pos.add(new Node(x-1,y-1));
            if (Map.RMap[x + 1][y + 1] == 0 || Map.RMap[x + 1][y + 1] <= 16)
                Available_Pos.add(new Node(x+1,y+1));
            if (Map.RMap[x + 1][y - 1] == 0 || Map.RMap[x + 1][y - 1] <= 16)
                Available_Pos.add(new Node(x+1,y-1));
        }
    }

    public void SetEval()
    {
        int[][] Eval2 =
                {
                        {0, 0, 0,20, 0,20, 0, 0, 0} ,
                        {0, 0, 0, 0,23, 0, 0, 0, 0},
                        {0, 0, 0,20, 0,20, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0,20, 0,20, 0, 0, 0},
                        {0, 0, 0, 0,23, 0, 0, 0, 0},
                        {0, 0, 0,20, 0,20, 0, 0, 0}
                };
        for (int i = 0; i < 10; i++)
        {
            for (int k = 0; k < 9; k++)
            {
                Eval[i][k] = Eval2[i][k];
            }
        }
    }
}
