//37. Sudoku Solver
/* 
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.

tag: backtracking, vector 

Author: Dawei Li
*/


#include <vector>
using namespace std;

class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solveGrid( board, 0, 0 );
    }

private:

    bool solveGrid( vector<vector<char> >& board, int Row, int Col)
    {
        if( Row == 9 )
        {
            return true;
        }
        if( Col == 9 )
        {
            return solveGrid( board, Row + 1, 0 );
        }
        if( board[Row][Col] != '.' )
        {
            return solveGrid( board, Row, Col + 1 );
        }

        // loop over 1 - 9
        for( char charTmp = '1'; charTmp <= '9'; charTmp++ )
        {
            if( checkgrid( board, Row, Col, charTmp ) )
            {
                board[Row][Col] = charTmp;
                // if next grid is solved, return true;
                if( solveGrid( board, Row, Col + 1 ) )
                {
                    return true;
                }
                // reset the grid to be unsolved and take next loop;
                board[Row][Col] = '.';
            }
        }
        // tried all the number, doesn't work, return false here.
        return false;
    }


    bool checkgrid( vector<vector<char> >& board, int Row, int Col, char value )
    {
        int subgridRow = Row - Row%3;
        int subgridCol = Col - Col%3;
        for( int k = 0; k < 9; k++ )
        {
            // check over row
            if( board[Row][k] == value )
            {
                return false;
            }
            // check over column
            if( board[k][Col] == value )
            {
                return false;
            }
            // check over subgrid
            if( board[subgridRow+k/3][subgridCol+k%3] == value )
            {
                return false;
            }
        }
        return true;
    }

};


int main( int argc, char ** argv )
{
    string strboard[9] = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};

    vector<vector<char> > board;

    for( int i = 0; i < 9; i++ )
    {
        board.push_back( vector<char>( strboard[i].begin(), strboard[i].end() ) );
    }

    Solution Sln;
    Sln.solveSudoku(board);

    return 0;

}
