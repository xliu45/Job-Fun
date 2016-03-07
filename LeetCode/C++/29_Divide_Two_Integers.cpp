/*

* 29. Divide Two Integers

* Divide two integers without using multiplication, division and mod operator.

* If it is overflow, return MAX_INT.

* Tag : math, bit operation

* Author : Dawei Li

*/


#include <climits>
#include <stdlib.h>

class Solution {
public:
    int divide(int dividend, int divisor) {
        
        if( divisor == 0 || (dividend == INT_MIN && divisor==-1 ))
        {
            return INT_MAX;
        }
        int sign = ( (dividend < 0) ^ (divisor < 0) )? -1 : 1;
        
        long long lDivdend = labs( dividend );
        long long lDivisor = labs( divisor );
        
        long long res = lDivdend;
        int out = 0;
        while( res >= lDivisor )
        {
            long long tmp = lDivisor;
            long long Mul = 1;
            while( res >= (tmp << 1) )
            {
                tmp = tmp << 1;
                Mul = Mul << 1;
            }
            res = res - tmp;
            out = out + Mul;
        }
        return (sign == 1)? out : -out;
        
    }
};

int main( int argc, char** argv )
{
    Solution sln;
    sln.divide(-1,1);
}
