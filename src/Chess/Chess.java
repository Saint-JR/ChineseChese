package Chess;

import java.util.ArrayList;
import java.util.List;

public abstract class Chess {
    class Node
    {
        int Available_x=0;
        int Available_y=0;

        Node(){};

        Node(int a,int b)
        {
            Available_x=a;
            Available_y=b;
        }
    }

    public abstract void MovAtk();             //按照棋子的移动规则和攻击规则选定可行的移动点位并标记在AMap上
    public abstract void SetEval();			   //设置价值地图

    public void CLM()				   //清空棋子的所有可能移动点位
    {
        /*for (int i = 0; i <= 9; i++)
        {
            for (int k = 0; k <= 8; k++)
            {
                AMap[i][k] = 0;
            }
        }*/
        Available_Pos=null;
        Available_Pos=new ArrayList<Node>();
    }

    public int x, y;						   //坐标点位
    public List<Node> Available_Pos=new ArrayList<Node>();
    public int[][] AMap = new int[10][9];	   //潜在可行点位地图
    public int[][] Eval = new int[10][9];	   //价值地图
    public int Exi=1;                          //存在性
}
