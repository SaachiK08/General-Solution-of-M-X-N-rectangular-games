class Nash {

    public float[][][] solvingMatrix(float a_strategy[][], float b_strategy[][]) {
        int i = 0, j = 0, count = 0;

        float equilibrium_startegies[][][] = new float[2][3][3];
        boolean[][] hasPlayedStrategy_A = new boolean[3][3];
        boolean[][] hasPlayedStrategy_B = new boolean[3][3];
        float[][] a_nash = new float[3][3];
        float[][] b_nash = new float[3][3];
        while (count <= 17) {
            if (count % 2 == 0) {
                float loss = (Math.abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][0]) < Math
                        .abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][1]))
                                ? a_strategy[i][j] + b_strategy[(i + 1) % 3][0]
                                : a_strategy[i][j] + b_strategy[(i + 1) % 3][1];

                if (hasPlayedStrategy_A[(i + 1) % 3][0] == true) {
                    loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][1];
                } else if (hasPlayedStrategy_A[(i + 1) % 3][1] == true) {
                    loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][0];
                }

                loss = (Math.abs(loss) < Math.abs(a_strategy[i][j]
                        + b_strategy[(i + 1) % 3][2])) ? loss
                                : a_strategy[i][j] + b_strategy[(i + 1) % 3][2];
                if ((hasPlayedStrategy_A[(i + 1) % 3][2] == true)
                        && (loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][2])) {
                    loss = (Math.abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][0]) < Math
                            .abs(a_strategy[i][0] + b_strategy[(i + 1) % 3][1]))
                                    ? a_strategy[i][j] + b_strategy[(i + 1) % 3][0]
                                    : a_strategy[i][j] + b_strategy[(i + 1) % 3][1];

                    if (hasPlayedStrategy_A[(i + 1) % 3][0] == true) {
                        loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][1];
                    } else if (hasPlayedStrategy_A[(i + 1) % 3][1] == true) {
                        loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][0];
                    }
                } else if ((hasPlayedStrategy_A[(i + 1) % 3][1] == true)
                        && (hasPlayedStrategy_A[(i + 1) % 3][0] == true)) {
                    loss = a_strategy[i][j] + b_strategy[(i + 1) % 3][2];
                }
                if (loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][0]) {
                    hasPlayedStrategy_A[(i + 1) % 3][0] = true;
                    b_nash[(i + 1) % 3][0] = b_nash[(i + 1) % 3][0] + 1;
                    j = 0;
                    if (count == 17) {
                        j = 0;
                    }
                }

                else if (loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][1]) {
                    hasPlayedStrategy_A[(i + 1) % 3][1] = true;
                    b_nash[(i + 1) % 3][1] = b_nash[(i + 1) % 3][1] + 1;
                    j = 1;
                    if (count == 17) {
                        j = 1;
                    }
                }

                else {
                    hasPlayedStrategy_A[(i + 1) % 3][2] = true;
                    b_nash[(i + 1) % 3][2] = b_nash[(i + 1) % 3][2] + 1;
                    j = 2;
                    if (count == 17) {
                        j = 2;
                    }
                }
                i = (i + 1) % 3;
                count++;
            } else {
                float loss = (Math.abs(b_strategy[i][j] + a_strategy[(i + 1) % 3][0]) < Math
                        .abs(b_strategy[i][0] + a_strategy[(i + 1) % 3][1]))
                                ? b_strategy[i][j] + a_strategy[(i + 1) % 3][0]
                                : b_strategy[i][j] + a_strategy[(i + 1) % 3][1];

                if (hasPlayedStrategy_B[(i + 1) % 3][0] == true) {
                    loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][1];
                } else if (hasPlayedStrategy_B[(i + 1) % 3][1] == true) {
                    loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][0];
                }

                loss = (Math.abs(loss) < Math.abs(b_strategy[i][j]
                        + a_strategy[(i + 1) % 3][2])) ? loss
                                : b_strategy[i][j] + a_strategy[(i + 1) % 3][2];
                if ((hasPlayedStrategy_B[(i + 1) % 3][2] == true)
                        && (loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][2])) {
                    loss = (Math.abs(b_strategy[i][j] + a_strategy[(i + 1) % 3][0]) < Math
                            .abs(b_strategy[i][0] + a_strategy[(i + 1) % 3][1]))
                                    ? b_strategy[i][j] + a_strategy[(i + 1) % 3][0]
                                    : b_strategy[i][j] + a_strategy[(i + 1) % 3][1];

                    if (hasPlayedStrategy_B[(i + 1) % 3][0] == true) {
                        loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][1];
                    } else if (hasPlayedStrategy_B[(i + 1) % 3][1] == true) {
                        loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][0];
                    }
                } else if ((hasPlayedStrategy_B[(i + 1) % 3][1] == true)
                        && (hasPlayedStrategy_B[(i + 1) % 3][0] == true)) {
                    loss = b_strategy[i][j] + a_strategy[(i + 1) % 3][2];
                }
                if (loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][0]) {
                    hasPlayedStrategy_B[(i + 1) % 3][0] = true;
                    a_nash[(i + 1) % 3][0] = a_nash[(i + 1) % 3][0] + 1;
                    j = 0;
                    if (count == 17) {
                        j = 0;
                    }
                } else if (loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][1]) {
                    hasPlayedStrategy_B[(i + 1) % 3][1] = true;
                    a_nash[(i + 1) % 3][1] = a_nash[(i + 1) % 3][1] + 1;
                    j = 1;
                    if (count == 17) {
                        j = 1;
                    }
                } else {
                    hasPlayedStrategy_B[(i + 1) % 3][2] = true;
                    a_nash[(i + 1) % 3][2] = a_nash[(i + 1) % 3][2] + 1;
                    j = 2;
                    if (count == 17) {
                        j = 2;
                    }
                }
                i = (i + 1) % 3;
                count++;
            }
        }
        count = 0;
        while (count <= 17) {
            if (count % 2 == 0) {
                float loss = (Math.abs(a_strategy[i][j] + b_strategy[(i + 1) % 3][0]) < Math
                        .abs(a_strategy[i][0] + b_strategy[(i + 1) % 3][1]))
                                ? a_strategy[i][j] + b_strategy[(i + 1) % 3][0]
                                : a_strategy[i][j] + b_strategy[(i + 1) % 3][1];

                loss = (Math.abs(loss) < Math.abs(a_strategy[i][j]
                        + b_strategy[(i + 1) % 3][2])) ? loss
                                : a_strategy[i][j] + b_strategy[(i + 1) % 3][2];

                if (loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][0]) {
                    if (Math.abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][0])) == Math
                            .abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][1]))) {
                        b_nash[(i + 1) % 3][0] = b_nash[(i + 1) % 3][0] + 1;
                        b_nash[(i + 1) % 3][1] = b_nash[(i + 1) % 3][1] + 1;
                    } else if (Math.abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][0])) == Math
                            .abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][2]))) {
                        b_nash[(i + 1) % 3][0] = b_nash[(i + 1) % 3][0] + 1;
                        b_nash[(i + 1) % 3][2] = b_nash[(i + 1) % 3][2] + 1;
                    } else {
                        b_nash[(i + 1) % 3][0] = b_nash[(i + 1) % 3][0] + 1;
                    }
                    j = 0;
                }

                else if (loss == a_strategy[i][j] + b_strategy[(i + 1) % 3][1]) {
                    if (Math.abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][1])) == Math
                            .abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][0]))) {
                        b_nash[(i + 1) % 3][1] = b_nash[(i + 1) % 3][1] + 1;
                        b_nash[(i + 1) % 3][0] = b_nash[(i + 1) % 3][0] + 1;
                    } else if (Math.abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][1])) == Math
                            .abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][2]))) {
                        b_nash[(i + 1) % 3][1] = b_nash[(i + 1) % 3][1] + 1;
                        b_nash[(i + 1) % 3][2] = b_nash[(i + 1) % 3][2] + 1;
                    } else {
                        b_nash[(i + 1) % 3][1] = b_nash[(i + 1) % 3][1] + 1;
                    }
                    j = 1;
                }

                else {
                    if (Math.abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][2])) == Math
                            .abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][0]))) {
                        b_nash[(i + 1) % 3][2] = b_nash[(i + 1) % 3][2] + 1;
                        b_nash[(i + 1) % 3][0] = b_nash[(i + 1) % 3][0] + 1;
                    } else if (Math.abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][2])) == Math
                            .abs((a_strategy[i][j] + b_strategy[(i + 1) % 3][1]))) {
                        b_nash[(i + 1) % 3][2] = b_nash[(i + 1) % 3][2] + 1;
                        b_nash[(i + 1) % 3][1] = b_nash[(i + 1) % 3][1] + 1;
                    } else {
                        b_nash[(i + 1) % 3][2] = b_nash[(i + 1) % 3][2] + 1;
                    }
                    j = 2;
                }
                i = (i + 1) % 3;
                count++;
            } else {
                float loss = (Math.abs(b_strategy[i][j] + a_strategy[(i + 1) % 3][0]) < Math
                        .abs(b_strategy[i][0] + a_strategy[(i + 1) % 3][1]))
                                ? b_strategy[i][j] + a_strategy[(i + 1) % 3][0]
                                : b_strategy[i][j] + a_strategy[(i + 1) % 3][1];

                loss = (Math.abs(loss) < Math.abs(b_strategy[i][j]
                        + a_strategy[(i + 1) % 3][2])) ? loss
                                : b_strategy[i][j] + a_strategy[(i + 1) % 3][2];

                if (loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][0]) {
                    if (Math.abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][0])) == Math
                            .abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][1]))) {
                        a_nash[(i + 1) % 3][0] = a_nash[(i + 1) % 3][0] + 1;
                        a_nash[(i + 1) % 3][1] = a_nash[(i + 1) % 3][1] + 1;
                    } else if (Math.abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][0])) == Math
                            .abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][2]))) {
                        a_nash[(i + 1) % 3][0] = a_nash[(i + 1) % 3][0] + 1;
                        a_nash[(i + 1) % 3][2] = a_nash[(i + 1) % 3][2] + 1;
                    } else {
                        a_nash[(i + 1) % 3][0] = a_nash[(i + 1) % 3][0] + 1;
                    }
                    j = 0;

                } else if (loss == b_strategy[i][j] + a_strategy[(i + 1) % 3][1]) {
                    if (Math.abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][1])) == Math
                            .abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][0]))) {
                        a_nash[(i + 1) % 3][1] = a_nash[(i + 1) % 3][1] + 1;
                        a_nash[(i + 1) % 3][0] = a_nash[(i + 1) % 3][0] + 1;
                    } else if (Math.abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][1])) == Math
                            .abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][2]))) {
                        a_nash[(i + 1) % 3][1] = a_nash[(i + 1) % 3][1] + 1;
                        a_nash[(i + 1) % 3][2] = a_nash[(i + 1) % 3][2] + 1;
                    } else {
                        a_nash[(i + 1) % 3][1] = a_nash[(i + 1) % 3][1] + 1;
                    }
                    j = 1;
                } else {
                    if (Math.abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][2])) == Math
                            .abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][0]))) {
                        a_nash[(i + 1) % 3][2] = a_nash[(i + 1) % 3][2] + 1;
                        a_nash[(i + 1) % 3][0] = a_nash[(i + 1) % 3][0] + 1;
                    } else if (Math.abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][2])) == Math
                            .abs((b_strategy[i][j] + a_strategy[(i + 1) % 3][1]))) {
                        a_nash[(i + 1) % 3][2] = a_nash[(i + 1) % 3][2] + 1;
                        a_nash[(i + 1) % 3][1] = a_nash[(i + 1) % 3][1] + 1;
                    } else {
                        a_nash[(i + 1) % 3][2] = a_nash[(i + 1) % 3][2] + 1;
                    }
                    j = 2;
                }
                i = (i + 1) % 3;
                count++;
            }
        }
        float[][] probabilityDistribution_A = new float[a_nash.length][a_nash[0].length];
        float[][] probabilityDistribution_B = new float[b_nash.length][b_nash[0].length];

        for (int rows = 0; rows < b_nash.length; rows++) {
            float rowSum = 0.0f;
            for (int cols = 0; cols < a_nash[0].length; cols++) {
                rowSum += a_nash[rows][cols];
            }
            for (int cols = 0; cols < a_nash[0].length; cols++) {
                probabilityDistribution_A[rows][cols] = a_nash[rows][cols] / rowSum;
            }
        }

        for (int rows = 0; rows < b_nash.length; rows++) {
            float rowSum = 0.0f;
            for (int cols = 0; cols < b_nash[0].length; cols++) {
                rowSum += b_nash[rows][cols];
            }
            for (int cols = 0; cols < b_nash[0].length; cols++) {
                probabilityDistribution_B[rows][cols] = b_nash[rows][cols] / rowSum;
            }
        }

        equilibrium_startegies[0] = probabilityDistribution_A;
        equilibrium_startegies[1] = probabilityDistribution_B;
        return equilibrium_startegies;
    }

}