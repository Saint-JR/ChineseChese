package Chess;

public class RChariot extends Chess{
    public RChariot(int n, int m)
    {
        x = n;
        y = m;
        SetEval();
    }

    public void MovAtk()
    {
        CLM();
        for (int i = x+1; i < 10; i++)						//向下检索
        {
            if (Map.RMap[i][y] == 0||Map.RMap[i][y]>=17)			//空位和第一个敌方是潜在移动点
            {
                Available_Pos.add(new Node(i,y));
                if (Map.RMap[i][y] >= 17)
                    break;
            }
            else break;
        }
        for (int i = x-1; i >= 0; i--)						//向上检索
        {
            if (Map.RMap[i][y] == 0 || Map.RMap[i][y] >= 17)		//空位和第一个敌方是潜在移动点
            {
                Available_Pos.add(new Node(i,y));
                if (Map.RMap[i][y] >= 17)
                    break;
            }
            else break;
        }
        for (int i = y+1; i < 9; i++)							//向右检索
        {
            if (Map.RMap[x][i] == 0 || Map.RMap[x][i] >= 17)		//空位和第一个敌方是潜在移动点
            {
                Available_Pos.add(new Node(x,i));
                if (Map.RMap[x][i] >= 17)
                    break;
            }
            else break;
        }
        for (int i = y-1; i >=0; i--)							//向左检索
        {
            if (Map.RMap[x][i] == 0 || Map.RMap[x][i] >= 17)		//空位和第一个敌方是潜在移动点
            {
                Available_Pos.add(new Node(x,i));
                if (Map.RMap[x][i] >= 17)
                    break;
            }
            else break;
        }
    }

    public void SetEval()
    {
        int[][] Eval2 =
                {
                        {206, 208, 207, 213, 214, 213, 207, 208, 206},
                        {206, 212, 209, 216, 233, 216, 209, 212, 206},
                        {206, 208, 207, 214, 216, 214, 207, 208, 206},
                        {206, 213, 213, 216, 216, 216, 213, 213, 206},
                        {208, 211, 211, 214, 215, 214, 211, 211, 208},
                        {208, 212, 212, 214, 215, 214, 212, 212, 208},
                        {204, 209, 204, 212, 214, 212, 204, 209, 204},
                        {198, 208, 204, 212, 212, 212, 204, 208, 198},
                        {200, 208, 206, 212, 200, 212, 206, 208, 200},
                        {194, 206, 204, 212, 200, 212, 204, 206, 194}
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
