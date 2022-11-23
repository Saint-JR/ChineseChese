package Chess;

import java.util.ArrayList;
import java.util.List;

public class RCannon extends Chess{
    public RCannon(int n, int m)
    {
        x = n;
        y = m;
        SetEval();
    }

    public void MovAtk()
    {
        CLM();
        for (int i = x+1; i < 10; i++)										//向下检索
        {
            if (Map.RMap[i][y] == 0)										//空位处是潜在移动点
                //AMap[i][y] = Map.RMap[x][y];
                Available_Pos.add(new Node(i,y));
            else														//检索到第一个非空位目标
            {
                for (int k = i + 1; k < 10; k++)							//继续检索到第二个非空位目标，若是敌方则可以进攻
                {
                    if (Map.RMap[k][y] >= 17)								//敌方
                    {
                        //AMap[k][y] = Map.RMap[x][y];
                        Available_Pos.add(new Node(k,y));
                        break;
                    }
                    else if (Map.RMap[k][y] <= 16 && Map.RMap[k][y] != 0)			//友方
                        break;
                }
                break;
            }
        }
        for (int i = x-1; i >= 0; i--)										//向上检索
        {
            if (Map.RMap[i][y] == 0)											//空位处是潜在移动点
                //AMap[i][y] = Map.RMap[x][y];
                Available_Pos.add(new Node(i,y));
            else														//检索到第一个非空位目标
            {
                for (int k = i - 1; k >= 0; k--)							//继续检索到第一个非空位目标，若是敌方则可以进攻
                {
                    if (Map.RMap[k][y] >= 17)								//敌方
                    {
                        //AMap[k][y] = Map.RMap[x][y];
                        Available_Pos.add(new Node(k,y));
                        break;
                    }
                    else if (Map.RMap[k][y] <= 16 && Map.RMap[k][y] != 0)			//友方
                        break;
                }
                break;
            }
        }
        for (int i = y+1; i < 9; i++)											//向右检索
        {
            if (Map.RMap[x][i] == 0)											//空位处是潜在移动点
                //AMap[x][i] = Map.RMap[x][y];
                Available_Pos.add(new Node(x,i));
            else														//检索到第一个非空位目标
            {
                for (int k = i + 1; k < 9; k++)								//继续检索到第一个非空位目标，若是敌方则可以进攻
                {
                    if (Map.RMap[x][k] >= 17)								//敌方
                    {
                        //AMap[x][k] = Map.RMap[x][y];
                        Available_Pos.add(new Node(x,k));
                        break;
                    }
                    else if (Map.RMap[x][k] <= 16 && Map.RMap[x][k] != 0)			//友方
                        break;
                }
                break;
            }
        }
        for (int i = y-1; i >= 0; i--)										//向左检索
        {
            if (Map.RMap[x][i] == 0)											//空位处是潜在移动点
                //AMap[x][i] = Map.RMap[x][y];
                Available_Pos.add(new Node(x,i));
            else														//检索到第一个非空位目标
            {
                for (int k = i - 1; k >= 0; k--)							//继续检索到第一个非空位目标，若是敌方则可以进攻
                {
                    if (Map.RMap[x][k] >= 17)								//敌方
                    {
                        //AMap[x][k] = Map.RMap[x][y];
                        Available_Pos.add(new Node(x,k));
                        break;
                    }
                    else if (Map.RMap[x][k] <= 16 && Map.RMap[x][k] != 0)			//友方
                        break;
                }
                break;
            }
        }
    }

    public void SetEval()
    {
        int[][] Eval2 =
                {
                        {100, 100,  96, 91,  90, 91,  96, 100, 100},
                        {98,  98,  96, 92,  89, 92,  96,  98,  98},
                        {97,  97,  96, 91,  92, 91,  96,  97,  97},
                        {96,  99,  99, 98, 104, 98,  99,  99,  96},
                        {96,  96,  96, 96, 106, 96,  96,  96,  96},
                        {95,  96,  99, 96, 105, 96,  99,  96,  95},
                        {96,  96,  96, 96,  96, 96,  96,  96,  96},
                        {97,  96, 101, 99, 105, 99, 101,  96,  97},
                        {96,  97,  98, 98,  98, 98,  98,  97,  96},
                        {96,  96,  97, 99,  99, 99,  97,  96,  96}
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
