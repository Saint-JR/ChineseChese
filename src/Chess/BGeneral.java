package Chess;

public class BGeneral extends Chess {
    public BGeneral(int n, int m)
    {
        x = n;
        y = m;
        SetEval();
    }

    public void MovAtk()
    {
        int i;
        CLM();
        if (y - 1 >= 3 && (Map.RMap[x][y - 1] == 0 || Map.RMap[x][y - 1] <= 16))			//向左检索
            //AMap[x][y - 1] = Map.RMap[x][y];
            Available_Pos.add(new Node(x,y-1));
        if (y + 1 <= 5 && (Map.RMap[x][y + 1] == 0 || Map.RMap[x][y + 1] <= 16))			//向右检索
            Available_Pos.add(new Node(x,y+1));
        if (x - 1 >= 0 && (Map.RMap[x - 1][y] == 0 || Map.RMap[x-1][y ] <= 16))			//向上检索
            Available_Pos.add(new Node(x-1,y));
        if (x + 1 <= 2 && (Map.RMap[x + 1][y] == 0 || Map.RMap[x+1][y ] <= 16))			//向下检索
            Available_Pos.add(new Node(x+1,y));
        for (i = x; i <= 9; i++)												//飞将检索
        {
            if (Map.RMap[i][y] != 0 && Map.RMap[i][y] != 1)
                break;
            else if (Map.RMap[i][y] == 1)
            {
                Available_Pos.add(new Node(i,y));
                break;
            }
        }
    }

    public void SetEval()
    {
        int[][] Eval2 =
                {
                        {0, 0, 0, 8888, 8888, 8888, 0, 0, 0} ,
                        {0, 0, 0, 8888, 8888, 8888, 0, 0, 0},
                        {0, 0, 0, 8888, 8888, 8888, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 8888, 8888, 8888, 0, 0, 0},
                        {0, 0, 0, 8888, 8888, 8888, 0, 0, 0},
                        {0, 0, 0, 8888, 8888, 8888, 0, 0, 0}
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
