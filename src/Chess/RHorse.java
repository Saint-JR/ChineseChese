package Chess;

public class RHorse extends Chess{
    public RHorse(int n, int m)
    {
        x = n;
        y = m;
        SetEval();
    }

    public void MovAtk()
    {
        CLM();
        if (y - 2 >= 0 && x - 1 >= 0 && Map.RMap[x][y - 1] == 0 && (Map.RMap[x - 1][y - 2]==0|| Map.RMap[x - 1][y - 2] >= 17))			//左上检索
            Available_Pos.add(new Node(x-1,y-2));
        if (y - 2 >= 0 && x + 1 <= 9 && Map.RMap[x][y - 1] == 0 && (Map.RMap[x + 1][y - 2] == 0 || Map.RMap[x + 1][y - 2] >= 17))		//左下检索
            Available_Pos.add(new Node(x+1,y-2));
        if (y - 1 >= 0 && x + 2 <= 9 && Map.RMap[x + 1][y] == 0 && (Map.RMap[x +2][y -1] == 0 || Map.RMap[x + 2][y - 1] >= 17))		//下左检索
            Available_Pos.add(new Node(x+2,y-1));
        if (y + 1 <= 8 && x + 2 <= 9 && Map.RMap[x + 1][y] == 0 && (Map.RMap[x +2][y + 1] == 0 || Map.RMap[x + 2][y + 1] >= 17))		//下右检索
            Available_Pos.add(new Node(x+2,y+1));
        if (y + 2 <= 8 && x + 1 <= 9 && Map.RMap[x][y + 1] == 0 && (Map.RMap[x + 1][y + 2] == 0 || Map.RMap[x + 1][y + 2] >= 17))		//右下检索
            Available_Pos.add(new Node(x+1,y+2));
        if (y + 2 <= 8 && x - 1 >= 0 && Map.RMap[x][y + 1] == 0 && (Map.RMap[x - 1][y + 2] == 0 || Map.RMap[x - 1][y + 2] >= 17))		//右上检索
            Available_Pos.add(new Node(x-1,y+2));
        if (y + 1 <= 8 && x - 2 >= 0 && Map.RMap[x - 1][y] == 0 && (Map.RMap[x -2][y +1] == 0 || Map.RMap[x - 2][y + 1] >= 17))		//上右检索
            Available_Pos.add(new Node(x-2,y+1));
        if (y - 1 >= 0 && x - 2 >= 0 && Map.RMap[x - 1][y] == 0 && (Map.RMap[x - 2][y - 1] == 0 || Map.RMap[x - 2][y - 1] >= 17))		//上左检索
            Available_Pos.add(new Node(x-2,y-1));
    }

    public void SetEval()
    {
        int[][] Eval2 =
                {
                        {90, 90, 90, 96, 90, 96, 90, 90, 90} ,
                        {90, 96,105, 97, 94, 97,105, 96, 90},
                        {92, 98, 99,105, 99,105, 99, 98, 92},
                        {93,108,100,100,100,100,100,108, 93},
                        {90,100, 99,100,100,100, 99,100, 90},
                        {90, 98,100,100,100,100,100, 98, 90},
                        {92, 94, 98, 95, 98, 95, 98, 94, 92},
                        {93, 92, 94, 95, 92, 95, 94, 92, 93},
                        {85, 90, 92, 93, 78, 93, 92, 90, 85},
                        {88, 85, 90, 88, 90, 88, 90, 85, 88}
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
