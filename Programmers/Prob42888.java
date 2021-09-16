import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> name = new TreeMap<>();
        List<Map.Entry<String, String>> l = new ArrayList<>();
        for (String r : record) {
            String[] s = r.split(" ");
            if(s[0].equals("Enter")) {
            	l.add(Map.entry(s[1], "님이 들어왔습니다."));
                name.put(s[1], s[2]);
            }
            else if(s[0].equals("Leave"))            	
            	l.add(Map.entry(s[1], "님이 나갔습니다."));
            else
                name.put(s[1], s[2]);
        }
        return l.stream().map(r->name.get(r.getKey()) + r.getValue()).toArray(String[]::new);
    }
}

public class Prob42888 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(new Solution().solution(record)));
    }
}
