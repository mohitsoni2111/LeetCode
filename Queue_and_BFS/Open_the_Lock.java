// https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1375/

package Queue_and_BFS;

import java.util.*;

public class Open_the_Lock {

    private final Set<String> visited = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        if(target==null || target.length()==0)
            return -1;

        Collections.addAll(visited, deadends);

        Queue<String> queue = new LinkedList<>();
        int level = 0;
        queue.offer("0000");

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String currLock = queue.poll();
                if(visited.contains(currLock))
                    continue;
                if(target.equals(currLock))
                    return level;
                for(String nextlock : getNextLocks(currLock)){
                    if(!visited.contains(nextlock))
                        queue.offer(nextlock);
                }
                visited.add(currLock);
            }
            level++;
        }
        return -1;
    }

    private Set<String> getNextLocks(String currLock) {
        Set<String> newLocks = new HashSet<>();
        char[] lockChar = currLock.toCharArray();
        for(int i = 0; i < 4; i++){
            char c = lockChar[i];

            // Incrementing (Clockwise)
            lockChar[i] = c == '9' ? '0' : (char)(c+1);
            newLocks.add(new String(lockChar));
            // Decrementing (Anti - Clockwise)
            lockChar[i] = c == '0' ? '9' : (char)(c-1);
            newLocks.add(new String(lockChar));

            // Give back the calling character
            lockChar[i] = c;
        }
        return newLocks;
    }
}
