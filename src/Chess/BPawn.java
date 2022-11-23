package Chess;

public class BPawn extends Chess{
    public BPawn(int n, int m)
    {
        x = n;
        y = m;
        SetEval();
    }

    public void MovAtk()
    {
        CLM();
        if (x <= 4)																//在己方半场只能前进
        {
            if (Map.RMap[x + 1][y] == 0 || Map.RMap[x + 1][y] <= 16)						//是敌方或者空位可以前进
                //AMap[x + 1][y] = Map.RMap[x][y];
                Available_Pos.add(new Node(x+1,y));
        }
        else																	//在对方半场可以前进或者左右移动
        {
            if (x + 1 >= 0 && (Map.RMap[x + 1][y] == 0 || Map.RMap[x + 1][y] <= 16))		//前进
                Available_Pos.add(new Node(x+1,y));
            if (y - 1 >= 0 && (Map.RMap[x][y - 1] == 0 || Map.RMap[x][y - 1] <= 16))		//左移
                Available_Pos.add(new Node(x,y-1));
            if (y + 1 <= 8 && (Map.RMap[x][y + 1] == 0 || Map.RMap[x][y + 1] <= 16))		//右移
                Available_Pos.add(new Node(x,y+1));
        }
    }

    public void SetEval()
    {
        int[][]Eval2 =
                {
                        {0,  0,  0,  0,  0,  0,  0,  0,  0},
                        {0,  0,  0,  0,  0,  0,  0,  0,  0},
                        {0,  0,  0,  0,  0,  0,  0,  0,  0},
                        {7,  0,  7,  0, 15,  0,  7,  0,  7},
                        {7,  0, 13,  0, 16,  0, 13,  0,  7},
                        {14, 18, 20, 27, 29, 27, 20, 18, 14},
                        {19, 23, 27, 29, 30, 29, 27, 23, 19},
                        {19, 24, 32, 37, 37, 37, 32, 24, 19},
                        {19, 24, 34, 42, 44, 42, 34, 24, 19},
                        {9,  9,  9, 11, 13, 11,  9,  9,  9}
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
