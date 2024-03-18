public class DbdMathCalculator {
    private final int[][] levelIntervals = {
            // {Level, Level, Required XP per Level, Required XPTotal, IS Reward per Level,
            // Total IS Reward}
            { 1, 2, 720, 720, 50, 50 },
            { 3, 3, 900, 1620, 65, 115 },
            { 4, 6, 1200, 5220, 85, 370 },
            { 7, 14, 2100, 22020, 150, 1570 },
            { 15, 24, 2700, 49020, 195, 3520 },
            { 25, 34, 3300, 82020, 235, 5870 },
            { 35, 49, 3750, 138270, 270, 9920 },
            { 50, 99, 4200, 348270, 300, 24920 }
    };

    public int calculateTotalIS(int level) {
        int totalIS = 0;
        for (int[] interval : levelIntervals) {
            int start = interval[0];
            int end = interval[1];
            int isValue = interval[5];
            if (level >= start && level <= end) {
                totalIS = isValue - ((end - level) * interval[4]);

                break;
            }
        }
        return totalIS;
    }

    public int calculateTotalXP(int level) {
        int totalXP = 0;
        for (int[] interval : levelIntervals) {
            int start = interval[0];
            int end = interval[1];
            int isValue = interval[3];
            if (level >= start && level <= end) {
                totalXP = isValue - ((end - level) * interval[2]);

                break;
            }
        }
        return totalXP;
    }

    public int[] calculateTimeForIsTarget(int totalIS, int isTarget, int level) {
        int XP = 0;
        int requiredMatches = 0;
        while (totalIS <= isTarget) {
            if (level == 100) {
                level = 1;
            }

            // Iterăm prin fiecare nivel din matricea levelIntervals
            for (int[] levelInterval : levelIntervals) {
                int startLevel = levelInterval[0];
                int endLevel = levelInterval[1];
                int requiredXP = levelInterval[2];
                int isReward = levelInterval[4];

                // Verificăm dacă nivelul curent este între intervalele din matrice
                if (level >= startLevel && level <= endLevel) {
                    // Calculăm câte meciuri sunt necesare pentru a obține XP-ul necesar pentru a
                    // atinge nivelul
                    requiredXP -= XP;
                    XP = 0;
                    if (requiredXP % 600 == 0) {
                        requiredMatches += requiredXP / 600; // Se primesc 600 XP pe meci
                        level++;
                    } else {
                        requiredMatches += requiredXP / 600 + 1;
                        XP += requiredXP % 600;
                        level++;
                    }

                    totalIS += isReward; // Adăugăm recompensa IS pentru nivelul curent
                    break; // Ne oprim după găsirea intervalului corespunzător nivelului
                }
            }
        }
        // Calculăm orele și minutele
        int hours = requiredMatches * 10 / 60;
        int minutes = requiredMatches * 10 % 60;
        // Returnăm orele și minutele ca un array de int
        return new int[] { hours, minutes, requiredMatches };
    }

}
