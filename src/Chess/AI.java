package Chess;

import static Chess.Map.*;

public class AI {
    static int Const_Depth=6;
    static int[][] Best_Map=new int[10][9];
    static int[][][] Way=new int[Const_Depth][10][9];

    static public int MaxDeepSearch(int Depth,int Alpha,int Beta)
    {
        int Val=-99999;
        int Cur_Val;
        int Cur_x;
        int Cur_y;
        int Brunch=0;
        int Counter =0;
        int Ori_Num;

        if(Depth==0)
            return EvalFun();

        for(int i=1;i<=16;i++)
        {
            if(AllChess[i].Exi==0)
                continue;
            AllChess[i].MovAtk();
            Cur_x=AllChess[i].x;
            Cur_y=AllChess[i].y;
            Counter=0;
            Brunch=0;
            for(int p=0;p<AllChess[i].Available_Pos.size();p++)
            {
                int j = AllChess[i].Available_Pos.get(p).Available_x;
                int k = AllChess[i].Available_Pos.get(p).Available_y;
                Ori_Num=RMap[j][k];
                Counter++;
                UpdSta(Depth,i,j,k,Cur_x,Cur_y);
                if(Checkmate()!=0)
                    Cur_Val=EvalFun();
                else Cur_Val=MinDeepSearch(Depth-1,Val,-99999);
                ResSta(Depth,i,j,k,Cur_x,Cur_y,Ori_Num);
                if(Cur_Val>Val)
                    Val=Cur_Val;
                if(Val>=Beta)
                {
                    Brunch=1;
                    break;
                }
            }
            if(Brunch==1)
                break;
            if(Counter==0)
                continue;
        }
        return Val;
    }

    static public int MinDeepSearch(int Depth,int Alpha,int Beta)
    {
        int Val=99999;
        int Record=99999;
        int Cur_Val;
        int Cur_x;
        int Cur_y;
        int Brunch=0;
        int Counter =0;
        int Ori_Num=0;

        if(Depth==0)
            return EvalFun();
        Val=99999;
        for(int i=17;i<=32;i++)
        {
            if(AllChess[i].Exi==0)
                continue;
            AllChess[i].MovAtk();
            Cur_x=AllChess[i].x;
            Cur_y=AllChess[i].y;
            Counter=0;
            Brunch=0;
            for(int p=0;p<AllChess[i].Available_Pos.size();p++)
            {
                int j=AllChess[i].Available_Pos.get(p).Available_x;
                int k=AllChess[i].Available_Pos.get(p).Available_y;
                Counter++;
                Ori_Num=RMap[j][k];
                UpdSta(Depth,i,j,k,Cur_x,Cur_y);
                if(Checkmate()!=0)
                    Cur_Val=EvalFun();
                else Cur_Val=MaxDeepSearch(Depth-1,99999,Val);
                if(Cur_Val<Val)
                    Val=Cur_Val;
                if(Val<=Alpha&&Depth!=Const_Depth)
                {
                    Brunch=1;
                    ResSta(Depth,i,j,k,Cur_x,Cur_y,Ori_Num);
                    break;
                }
                if(Const_Depth==Depth)
                {
                    if(Cur_Val<Record)
                    {
                        Record=Cur_Val;
                        for(int n=0;n<10;n++)
                            for(int m=0;m<9;m++)
                                Best_Map[n][m]=RMap[n][m];
                    }
                }
                ResSta(Depth,i,j,k,Cur_x,Cur_y,Ori_Num);
            }
            if(Brunch==1)
                break;
            if(Counter==0)
                continue;
        }
        return Val;
    }

    static void UpdSta(int Depth,int i,int j,int k,int Cur_x,int Cur_y)
    {
        if(Const_Depth-Depth==0)
        {
            for(int n=0;n<10;n++)
            {
                for(int m=0;m<9;m++)
                {
                    RMap[n][m]=Map[n][m];
                    for(int p=0;p<Const_Depth-1;p++)
                    {
                        Way[p][n][m]=Map[n][m];
                    }
                }
                /*else
                {
                    Way[Const_Depth-Depth][n][m]=Way[Const_Depth-1-Depth][n][m];
                    RMap[n][m]=Way[Const_Depth-1-Depth][n][m];
                }*/
            }
        }
        for(int n=Const_Depth-Depth;n<Const_Depth;n++)
        {
            Way[n][j][k]=i;
            Way[n][Cur_x][Cur_y]=0;
        }
        AllChess[i].x=j;
        AllChess[i].y=k;
        if(RMap[j][k]!=0)
            AllChess[RMap[j][k]].Exi=0;
        RMap[j][k]=i;
        RMap[Cur_x][Cur_y]=0;
    }

    static void ResSta(int Depth,int i,int j,int k,int Cur_x,int Cur_y,int Ori_Num)
    {
        if(Const_Depth-Depth==0)
        {
            for(int n=0;n<10;n++)
            {
                for(int m=0;m<9;m++)
                {

                    Way[Const_Depth-Depth][n][m]=0;
                    RMap[n][m]=Map[n][m];
                }
                /*else
                {
                    Way[Const_Depth-Depth][n][m]=0;
                    RMap[n][m]=Way[Const_Depth-1-Depth][n][m];
                }*/
            }
        }
        for(int n=Const_Depth-Depth;n<Const_Depth;n++)
        {
            Way[n][j][k]=Ori_Num;
            Way[n][Cur_x][Cur_y]=i;
        }
        if(Ori_Num!=0)
            AllChess[Ori_Num].Exi=1;
        RMap[j][k]=Ori_Num;
        RMap[Cur_x][Cur_y]=i;
        AllChess[i].x=Cur_x;
        AllChess[i].y=Cur_y;
        AllChess[i].MovAtk();
    }

    static int EvalFun()
    {
        int sum=0;
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(RMap[i][j]>=1&& RMap[i][j]<=16)
                    sum+=AllChess[RMap[i][j]].Eval[i][j];
                else if (RMap[i][j] >= 17 && RMap[i][j] <= 32)
                    sum -= AllChess[RMap[i][j]].Eval[i][j];
            }
        }
        return sum;
    }
}
