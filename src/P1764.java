import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class P1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> solution = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String equalString = br.readLine();
            if (hashSet.contains(equalString)) {
                solution.add(equalString);
            }
        }
        Collections.sort(solution);

        Iterator<String> stringIterator = solution.iterator();
        System.out.println(solution.size());
        while(stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }

    }
}
