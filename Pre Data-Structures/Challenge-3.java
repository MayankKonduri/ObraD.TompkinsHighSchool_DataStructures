public class Challenge {

    public static int fuelUsed(int[] stations, int tankCapacity) {
        
        int fuelUsedCount = 0;
        int currentTrash = 0;
        int lastStationIndex = 0;
        boolean journeyCompleted = false;
        int currentPosition = -1;

        
        for (int j = stations.length - 1; j >= 0; j--) {
            if (stations[j] != 0) {
                lastStationIndex = j;
                break;
            }
        }
        for (int i = 0; i <= lastStationIndex; i++) {
            if (journeyCompleted) {
                break;
            }  
            fuelUsedCount++;
            currentPosition++;  
            while (currentPosition == i && stations[i] > 0) {
                currentTrash++;
                stations[i]--;
                if (stations[lastStationIndex] == 0) {
                    fuelUsedCount += lastStationIndex + 1;
                    journeyCompleted = true;
                    break;
                }
                if (currentTrash == tankCapacity) {
                    currentTrash = 0;
                    fuelUsedCount += 2 * (i + 1);
                }
                if (stations[i] == 0) {
                    break;
                }
            }
        }
        currentPosition = -1;  
        return fuelUsedCount;
    }

    public static void main(String[] args) {
        
    }
}
