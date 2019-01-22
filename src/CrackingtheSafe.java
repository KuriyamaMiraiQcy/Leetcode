public class CrackingtheSafe {
    public String crackSafe(int n, int k) {
        int size = (int) Math.pow(k, n);
        int mask = (int) Math.pow(10, n - 1);

        boolean[] seen = new boolean[mask * 10];
        char[] seq = new char[size + n - 1];

        for(int i=0; i<n; i++) seq[i] = '0';

        seen[0] = true;
        dfs(seq, n, 0,  seen, n, k, mask);

        return new String(seq);
    }

    private boolean dfs(char[] seq, int i, int cur,  boolean[] seen, int n, int k, int mask){
        if(i == seq.length)
            return true;

        int next = cur % mask * 10;

        for(int d = 0; d < k; d++){

            if(!seen[next + d]){
                seen[next + d] = true;
                seq[i] = (char)(d + '0');

                if(dfs(seq, i+1, next + d,  seen, n, k, mask))
                    return true;

                seen[next + d] = false;
            }
        }

        return false;
    }
}
