// https://leetcode.com/contest/weekly-contest-285/problems/count-collisions-on-a-road/
package weekly_285;

public class Q2_Count_Collisions_on_a_Road {
    public int countCollisions(String directions) {
        char[] chr = directions.toCharArray();
        int n = chr.length;
        int ans=0;
        for(int i=0; i<n; i++){
            if(chr[i]=='S'){
                for(int j = i-1; j>=0; j--){
                    if(chr[j]=='R') ans++;
                    else break;
                }

                for(int j = i+1; j<n; j++){
                    if(chr[j]=='L') ans++;
                    else break;
                }
            }
        }

        for(int i=0; i<n-1; i++){
            if(chr[i]=='R' && chr[i+1]=='L'){
                ans+=2;
                for(int j = i-1; j>=0; j--){
                    if(chr[j]=='R') ans++;
                    else break;
                }

                for(int j = i+2; j<n; j++){
                    if(chr[j]=='L') ans++;
                    else break;
                }
            }
        }
        return ans;
    }
}
