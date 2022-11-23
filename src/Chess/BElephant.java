package Chess;

public class BElephant extends Chess{
    public BElephant(int n, int m)
    {
        x = n;
        y = m;
        SetEval();
    }

    public void MovAtk()
    {
        CLM();
        if (x - 2 >= 0 && y - 2 >= 0 && Map.RMap[x - 1][y - 1] == 0 && (Map.RMap[x - 2][y - 2] == 0 || Map.RMap[x - 2][y - 2] <= 16))			//左上移动
            Available_Pos.add(new Node(x-2,y-2));
        if (x - 2 >= 0 && y + 2 <= 8 && Map.RMap[x - 1][y + 1] == 0 && (Map.RMap[x - 2][y + 2] == 0 || Map.RMap[x - 2][y + 2] <= 16))			//右上移动
            Available_Pos.add(new Node(x-2,y+2));
        if (x + 2 <= 4 && y - 2 >= 0 && Map.RMap[x + 1][y - 1] == 0 && (Map.RMap[x + 2][y - 2] == 0 || Map.RMap[x + 2][y - 2] <= 16))			//左下移动
            Available_Pos.add(new Node(x+2,y-2));
        if (x + 2 <= 4 && y + 2 <= 8 && Map.RMap[x + 1][y + 1] == 0 && (Map.RMap[x + 2][y + 2] == 0 || Map.RMap[x + 2][y + 2] <= 16))			//右下移动
            //AMap[x + 2][y + 2] = Map.RMap[x][y];
            Available_Pos.add(new Node(x+2,y+2));
    }

    public void SetEval()
    {
        int[][] Eval2 =
                {
                        {0, 0,20, 0, 0, 0,20, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {18,0, 0, 0,23, 0, 0, 0,18},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0,20, 0, 0, 0,20, 0, 0},
                        {0, 0,20, 0, 0, 0,20, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {18,0, 0, 0,23, 0, 0, 0,18},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0,20, 0, 0, 0,20, 0, 0}
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
