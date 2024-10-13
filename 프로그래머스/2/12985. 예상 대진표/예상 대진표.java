class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(Math.ceil(a/2.0)!=Math.ceil(b/2.0)){
            answer ++;
            a = (int)Math.ceil((double)a/2.0);
            b = (int)Math.ceil((double)b/2.0);
        }

        return answer+1;
    }
}