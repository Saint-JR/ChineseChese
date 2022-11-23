package Chess;

public class RGeneral extends Chess{
    public RGeneral(int n, int m)
    {
        x = n;
        y = m;
        SetEval();
    }

    public void MovAtk()
    {
        CLM();
        if (y - 1 >= 3 && (Map.RMap[x][y - 1] == 0 || Map.RMap[x][y - 1] >= 17))			//向左检索
            Available_Pos.add(new Node(x,y-1));
        if (y + 1 <= 5 && (Map.RMap[x][y + 1] == 0 || Map.RMap[x][y + 1] >= 17))			//向右检索
            Available_Pos.add(new Node(x,y+1));
        if (x - 1 >= 7 && (Map.RMap[x - 1][y] == 0 || Map.RMap[x-1][y ] >= 17))			//向上检索
            Available_Pos.add(new Node(x-1,y));
        if (x + 1 <= 9 && (Map.RMap[x + 1][y] == 0 || Map.RMap[x+1][y ] >= 17))			//向下检索
            Available_Pos.add(new Node(x+1,y));
        for (int i = x; i >= 0; i--)												//飞将检索
        {
            if (Map.RMap[i][y] != 0 && Map.RMap[i][y] != 17)
                break;
            else if (Map.RMap[i][y] == 17)
            {
                Available_Pos.add(new Node(i,y));
                break;
            }
        }
    }

    public void SetEval()
    {
        int i, k;
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
        for (i = 0; i < 10; i++)
        {
            for (k = 0; k < 9; k++)
            {
                Eval[i][k] = Eval2[i][k];
            }
        }
    }
}
