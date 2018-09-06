public class Container {
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int width = j - i;
            int areaHeight = Math.min(height[i], height[j]);
            area = Math.max(areaHeight * width, area);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return area;
    }
}
