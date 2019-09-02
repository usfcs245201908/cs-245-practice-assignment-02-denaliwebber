public class NQueens
{

	private int num;
	private int [][] board;

	NQueens(int n)
	{
		num=n;
		board= new int [num][num];
	}

	public boolean placeNQueens() throws Exception
	{
		if (num<1)
			throw new Exception();

		if(placeQ(0)){
			printToConsole();
			return true;
		}

		else
			return false;
	} //placeNQueens

	public boolean placeQ(int row)
	{
		if (row==num)
			return true;

		//iterate through row until there is a spot not being attacked
		for (int col=0; col<num; col++)
		{
			//can a queen go in this spot?
			if (!isAttacked(row, col))
			{
				board[row][col]=1;
				if(placeQ(row+1))
					return true;
				//backtrack
				board[row][col]=0;  //undo placement of that queen
			}
		}
		return false;
	}//placeQ

	public boolean isAttacked(int row, int col)
	{
		//is this space being attacked?
	
		//any queens in the column?
		for(int i=0; i<num; i++)
		{
			if (board[i][col]==1)
				return true;
		}

		//left, up, diagonal
		for (int i=row, j=col; i>=0 && j>=0; i--, j--)
		{
			if (board[i][j]==1)
				return true;
		}

		//left, down, diagonal
		for (int i=row, j=col; i>=0 && j<num; i--, j++)
		{
			if (board[i][j]==1)
				return true;
		}

		//right, up diagonal
		for (int i=row, j=col; i<num && j>=0; i++, j--)
		{
			if (board[i][j]==1)
				return true;
		}

		//right, down diagonal
		for (int i=row, j=col; i<num && j<num; i++, j++)
		{
			if (board[i][j]==1)
				return true;
		}

		//space isn't being attacked
		return false;
	}//isAttacked

	public void printToConsole()
	{
		for (int r=0; r<num; r++)
		{
			for (int c=0;c<num;c++)
			{
				if (board[r][c]==0)
					System.out.print("__  ");
				else
					System.out.print("Q   ");
			}
			System.out.println();
		}
	}


}